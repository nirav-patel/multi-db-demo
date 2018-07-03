package com.multidb.demo.dto;

import java.util.Set;

public class TableDto {

	String dbName;
	String tableName;
	Set<ColumnInfo> columns;

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Set<ColumnInfo> getColumns() {
		return columns;
	}

	public void setColumns(Set<ColumnInfo> columns) {
		this.columns = columns;
	}

}
