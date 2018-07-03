package com.multidb.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multidb.demo.dto.DatabaseDto;
import com.multidb.demo.registry.DatabaseInfoRegistry;
import com.multidb.demo.repository.DatabaseRepository;

@Service("databaseService")
public class DatabaseServiceImpl implements DatabaseService {

	private static final Logger logger = LoggerFactory.getLogger(DatabaseServiceImpl.class);

	@Autowired
	private DatabaseRepository databaseRepository;

	@Override
	public List<DatabaseDto> fetchAllDatabases() {
		logger.info("Fetching Database Names!!");
		List<String> list = databaseRepository.fetchDatabases();
		List<DatabaseDto> databaseList = new ArrayList<>();
		for (String name : list) {
			DatabaseDto temp = new DatabaseDto();
			temp.setDbName(name);
			databaseList.add(temp);
		}
		return databaseList;
	}

	@Override
	public void createDatabase(DatabaseDto databaseDto) {
		logger.info("Create new database : {}", databaseDto.getDbName());
		
		databaseRepository.createNewDatabase(databaseDto);
		databaseRepository.createNewUser(databaseDto);
		databaseRepository.grantDBPriviledgesToUser(databaseDto);
		
		//Store Database Info In Registry
		DatabaseInfoRegistry.addDatabaseInfo(databaseDto);
		
		logger.info("Database Successfully Created : {}", databaseDto.getDbName());
	}

}
