package com.multidb.demo.repository;

import com.multidb.demo.dto.TableDto;

public interface TableRepository {

	void createTable(TableDto tableDto);

	void insertDummyRecords(TableDto tableDto);
}
