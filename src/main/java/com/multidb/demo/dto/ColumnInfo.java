package com.multidb.demo.dto;

public class ColumnInfo {
	String columnName;
	String columnType;
	
	public ColumnInfo(String columnName, String columnType) {
		this.columnName = columnName;
		this.columnType = columnType;
	}

	public String getColumnName() {
		return columnName;
	}

	public String getColumnType() {
		return columnType;
	}

}
