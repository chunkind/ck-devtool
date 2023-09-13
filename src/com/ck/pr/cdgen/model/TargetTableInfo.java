package com.ck.pr.cdgen.model;

public class TargetTableInfo{
	private String tableOwner;
	private String tableName;
	private String columnType;
	private String columnName;
	private String columnComments;
	
	public String getTableOwner() {
		return tableOwner;
	}
	
	public void setTableOwner(String tableOwner) {
		this.tableOwner = tableOwner;
	}
	
	public String getTableName() {
		return tableName;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String getColumnType() {
		return columnType;
	}
	
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	
	public String getColumnName() {
		return columnName;
	}
	
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	public String getColumnComments() {
		return columnComments;
	}
	
	public void setColumnComments(String columnComments) {
		this.columnComments = columnComments;
	}

	@Override
	public String toString() {
		return "TargetTableInfo [tableOwner=" + tableOwner + ", tableName=" + tableName + ", columnType=" + columnType + ", columnName="
				+ columnName + ", columnComments=" + columnComments + "]";
	}
}