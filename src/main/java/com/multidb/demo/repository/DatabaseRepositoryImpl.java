package com.multidb.demo.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.multidb.demo.dto.DatabaseDto;

@Repository("databaseRepository")
public class DatabaseRepositoryImpl implements DatabaseRepository {

	private static final Logger logger = LoggerFactory.getLogger(DatabaseRepositoryImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createNewDatabase(DatabaseDto databaseDto) {
		try {
			String sql = "CREATE DATABASE " + databaseDto.getDbName();
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			logger.error("Database cannot be created!!", e);
		}
	}

	@Override
	public void createNewUser(DatabaseDto databaseDto) {
		try {
			String sql = "CREATE USER " + databaseDto.getUserName() + " WITH ENCRYPTED PASSWORD '"
					+ databaseDto.getPassword() + "'";
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			logger.error("User cannot be created!!", e);
		}
	}

	@Override
	public void grantDBPriviledgesToUser(DatabaseDto databaseDto) {
		try {
			String sql = "GRANT ALL PRIVILEGES ON DATABASE " + databaseDto.getDbName() + " TO "
					+ databaseDto.getUserName();
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			logger.error("Error in assigning priviledges!!", e);
		}
	}

	@Override
	public List<String> fetchDatabases() {
		String sql = " SELECT datname as DB_NAME " + 
					 " FROM pg_database a " + 
					 " WHERE a.datistemplate != true "+
					 " AND a.datname<> 'postgres' ";
		return jdbcTemplate.queryForList(sql, String.class);
	}

}
