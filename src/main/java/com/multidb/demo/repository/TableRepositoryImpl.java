package com.multidb.demo.repository;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.multidb.demo.dto.ColumnInfo;
import com.multidb.demo.dto.DatabaseDto;
import com.multidb.demo.dto.TableDto;
import com.multidb.demo.registry.DatabaseInfoRegistry;
import com.multidb.demo.registry.DatasourceRegistry;

@Repository("tableRepository")
public class TableRepositoryImpl implements TableRepository {

	private static final Logger logger = LoggerFactory.getLogger(TableRepositoryImpl.class);

	JdbcTemplate initializeJdbcTemplate(DatabaseDto dbDto) {
		DataSource dataSource = DatasourceRegistry.getDataSource(dbDto);
		return new JdbcTemplate(dataSource);
	}

	@Override
	public void createTable(TableDto tableDto) {

		DatabaseDto dbDto = DatabaseInfoRegistry.getDatabaseInfo(tableDto.getDbName());
		JdbcTemplate jdbcTemplate = initializeJdbcTemplate(dbDto);

		try {
			String sql = prepareCreateTableQuery(tableDto);
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			logger.error("Table cannot be created !!", e);
		}
	}

	private String prepareCreateTableQuery(TableDto tableDto) {
		StringBuilder columnList = new StringBuilder();
		for (ColumnInfo column : tableDto.getColumns()) {
			columnList.append(column.getColumnName()).append(" ").append(column.getColumnType()).append(",");
		}
		String columns = columnList.toString().substring(0, columnList.lastIndexOf(","));

		String sql = "CREATE TABLE " + tableDto.getTableName() + " ( " + columns + " ) ";
		return sql;
	}

	@Override
	public void insertDummyRecords(TableDto tableDto) {
		DatabaseDto dbDto = DatabaseInfoRegistry.getDatabaseInfo(tableDto.getDbName());
		JdbcTemplate jdbcTemplate = initializeJdbcTemplate(dbDto);

		try {
 			String sql = prepareInsertTableQuery(tableDto);
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			logger.error("Table cannot be created !!", e);
		}
	}

	private String prepareInsertTableQuery(TableDto tableDto) {
		StringBuilder columnList = new StringBuilder();
		StringBuilder valueList = new StringBuilder();
		int index = 1;
		for (ColumnInfo column : tableDto.getColumns()) {
			columnList.append(column.getColumnName()).append(",");
			valueList.append("'").append("VAL_" + (index++)).append("'").append(",");
		}
		String columns = columnList.toString().substring(0, columnList.lastIndexOf(","));
		String values = valueList.toString().substring(0, valueList.lastIndexOf(","));

		String sql = "INSERT INTO " + tableDto.getTableName() + " ( " + columns + " ) " + " VALUES (" + values + ")";
		return sql;
	}

}
