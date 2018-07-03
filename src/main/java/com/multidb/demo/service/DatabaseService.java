package com.multidb.demo.service;

import java.util.List;

import com.multidb.demo.dto.DatabaseDto;

public interface DatabaseService {

	List<DatabaseDto> fetchAllDatabases();

	void createDatabase(DatabaseDto databaseDto);

}
