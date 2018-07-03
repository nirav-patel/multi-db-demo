package com.multidb.demo.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;

import com.multidb.demo.dto.DatabaseDto;

public class DatasourceRegistry {

	//Store DataBaseName and corresponding DataSource object in Map
	private static final Map<String, DataSource> datasourceRegistry = new ConcurrentHashMap<>();
	private static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/";
	
	public static void addDataSource(DatabaseDto dbDto){
		initializeDatasource(dbDto);
	}
	
	public static DataSource getDataSource(DatabaseDto dbDto){
		DataSource ds = datasourceRegistry.get(dbDto.getDbName());
		if (ds == null) {
			ds = initializeDatasource(dbDto);
		}
		return ds;
	}
	
	private static DataSource initializeDatasource(DatabaseDto dbDto) {
		DataSource ds = DataSourceBuilder.create()
						.driverClassName(DRIVER_CLASS_NAME)
						.url(URL+dbDto.getDbName())
						.username(dbDto.getUserName())
						.password(dbDto.getPassword())
						.build(); 
		
		datasourceRegistry.put(dbDto.getDbName(), ds);
		return ds;
	}
	
}
