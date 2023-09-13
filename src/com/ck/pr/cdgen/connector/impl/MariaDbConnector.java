package com.ck.pr.cdgen.connector.impl;

import com.ck.pr.cdgen.connector.Connector;

public class MariaDbConnector extends Connector{

	public MariaDbConnector(String driver, String url, String user, String pass, boolean enableEnter) {
		super(driver, url, user, pass, enableEnter);
	}

	@Override
	public String createTableDesc() {
		String sql = "";
		sql += " SELECT A.TABLE_SCHEMA AS tableOwner";
		sql +=	  ", A.TABLE_NAME AS tableName";
		sql +=	  ", A.COLUMN_TYPE AS columnType";
		sql +=	  ", A.COLUMN_NAME AS columnName";
		sql +=	  ", A.COLUMN_COMMENT AS columnComments";
		sql += " FROM information_schema.columns A";
		sql += " WHERE 1=1";
		sql += " AND A.TABLE_NAME = ?";
		sql += " ORDER BY ORDINAL_POSITION ASC";
		return sql;
	}

}
