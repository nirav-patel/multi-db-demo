package com.multidb.demo.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multidb.demo.dto.ColumnInfo;
import com.multidb.demo.dto.TableDto;
import com.multidb.demo.repository.TableRepository;

@Transactional
@Service("tableService")
public class TableServiceImpl implements TableService {

	private static final Logger logger = LoggerFactory.getLogger(TableServiceImpl.class);
	@Autowired
	private TableRepository tableRepository;

	@Override
	public void createTable(TableDto tableDto) {
		logger.info("Creating new table : {}", tableDto.getTableName());
		
		initializeDummyColumns(tableDto);
		tableRepository.createTable(tableDto);
		tableRepository.insertDummyRecords(tableDto);
		
		logger.info("Table {} successfully created!!", tableDto.getTableName());
	}

	private void initializeDummyColumns(TableDto tableDto) {
		Set<ColumnInfo> columns = new LinkedHashSet<>();
		for (int i = 1; i <= 5; i++) {
			columns.add(new ColumnInfo("COL_" + i, "text"));
		}
		tableDto.setColumns(columns);
	}

}
