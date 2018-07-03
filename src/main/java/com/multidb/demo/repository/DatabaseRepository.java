package com.multidb.demo.repository;

import java.util.List;

import com.multidb.demo.dto.DatabaseDto;

public interface DatabaseRepository{
	
	List<String> fetchDatabases();
	
	void createNewDatabase(DatabaseDto databaseDto);

	void createNewUser(DatabaseDto databaseDto);

	void grantDBPriviledgesToUser(DatabaseDto databaseDto);
}
