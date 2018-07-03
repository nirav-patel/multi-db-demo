package com.multidb.demo.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.multidb.demo.dto.DatabaseDto;

public class DatabaseInfoRegistry {

	private static final Map<String, DatabaseDto> databaseRegistry = new ConcurrentHashMap<>();
	
	public static void addDatabaseInfo(DatabaseDto dbDto){
		databaseRegistry.put(dbDto.getDbName(), dbDto);
	}
	
	public static DatabaseDto getDatabaseInfo(String dbName){
		return databaseRegistry.get(dbName);
	}
}
