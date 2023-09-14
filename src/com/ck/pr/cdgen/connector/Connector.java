package com.ck.pr.cdgen.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ck.pr.cdgen.model.TargetTableInfo;
import com.ck.pr.util.DevHelperUtil;

public abstract class Connector {
	protected String driver;
	protected String url;
	protected String user;
	protected String pass;
	protected String space;
	
	public Connector(String driver, String url, String user, String pass, boolean enableEnter){
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pass = pass;
		this.space = "\t";
	}
	
	public abstract String createTableDesc();
	
	public List<TargetTableInfo> getTableInfo(String tableName){
		List<TargetTableInfo> tableInfo = new ArrayList<TargetTableInfo>();
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = conn.prepareStatement(createTableDesc());
			ps.setString(1, tableName);
			
			ResultSet rs = ps.executeQuery();
			TargetTableInfo obj = null;
			
			String tableOwner = "";
			String tableNm = "";
			String columnType = "";
			String columnName = "";
			String columnComments = "";
			while(rs.next()){
				tableOwner = rs.getString("tableOwner");
				tableNm = rs.getString("tableName");
				columnType = rs.getString("columnType");
				columnName = rs.getString("columnName");
				columnComments = rs.getString("columnComments");
				
				if(null != columnComments && !"".equals(columnComments)){
					columnComments = columnComments.replaceAll("\n", "").trim();
				}
				
				obj = new TargetTableInfo();
				obj.setTableOwner(tableOwner);
				obj.setTableName(tableNm);
				obj.setColumnType(columnType);
				obj.setColumnName(columnName);
				obj.setColumnComments(columnComments);
				tableInfo.add(obj);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
//			if(tableInfo.size() == 0)
//				throw new RuntimeException("조회할 데이터가 없습니다.");
		}
		return tableInfo;
	}
	
	public String createSqlCreate(List<TargetTableInfo> list){
		StringBuilder sb = new StringBuilder();
		sb.append(space+"CREATE TABLE " + list.get(0).getTableOwner() +"." + list.get(0).getTableName());
		DevHelperUtil.appendEnter(sb);
		for(int i=0; i<list.size(); i++){   
			if(i==0){
				sb.append(space+"( " + list.get(i).getColumnName() + " " + list.get(i).getColumnType() + " /*" + list.get(i).getColumnComments() + "*/");
			}else{
				sb.append(space+", " + list.get(i).getColumnName() + " " + list.get(i).getColumnType() + " /*" + list.get(i).getColumnComments() + "*/");
			}
			DevHelperUtil.appendEnter(sb);
		}
		sb.append(space+");");
		DevHelperUtil.appendEnter(sb);
		return sb.toString();
	}
	
	public String createSqlInsert(List<TargetTableInfo> list){
		StringBuilder sb = new StringBuilder();
		sb.append(space+"INSERT INTO " + list.get(0).getTableOwner() + "." + list.get(0).getTableName());
		DevHelperUtil.appendEnter(sb);
		for(int i=0; i<list.size(); i++){
			if(i==0){
				sb.append(space+"( " + list.get(i).getColumnName() + " /*" + list.get(i).getColumnComments() + "*/");
			}else{
				sb.append(space+", " + list.get(i).getColumnName() + " /*" + list.get(i).getColumnComments() + "*/");
			}
			DevHelperUtil.appendEnter(sb);
		}
		sb.append(space+") VALUES");
		DevHelperUtil.appendEnter(sb);
		for(int i=0; i<list.size(); i++){
			if(i==0){
				sb.append(space+"( #{" + DevHelperUtil.toCamelCase(list.get(i).getColumnName()) + "} /*" + list.get(i).getColumnComments() + "*/");
			}else{
				sb.append(space+", #{" + DevHelperUtil.toCamelCase(list.get(i).getColumnName()) + "} /*" + list.get(i).getColumnComments() + "*/");
			}
			DevHelperUtil.appendEnter(sb);
		}
		sb.append(space+")");
		DevHelperUtil.appendEnter(sb);
		return sb.toString();
	}
	
	public String createSqlSelect(List<TargetTableInfo> list, String alias){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list.size(); i++){
			if(i==0){
				sb.append(space+"SELECT " + alias + "." + list.get(i).getColumnName() + " AS " + DevHelperUtil.toCamelCase(list.get(i).getColumnName()) + " /*" + list.get(i).getColumnComments() + "*/");
			}else{
				sb.append(space+"\t, " + alias + "." + list.get(i).getColumnName() + " AS " + DevHelperUtil.toCamelCase(list.get(i).getColumnName()) + " /*" + list.get(i).getColumnComments() + "*/");
			}
			DevHelperUtil.appendEnter(sb);
		}
		sb.append(space+"  FROM " + list.get(0).getTableOwner() + "." + list.get(0).getTableName() + " " + alias);
		DevHelperUtil.appendEnter(sb);
		return sb.toString();
	}
	
	public String createSqlSelectCount(List<TargetTableInfo> list, String alias){
		StringBuilder sb = new StringBuilder();
		sb.append(space+"SELECT COUNT(*) AS cnt");
		DevHelperUtil.appendEnter(sb);
		sb.append(space+"  FROM " + list.get(0).getTableOwner() + "." + list.get(0).getTableName() + " " + alias);
		DevHelperUtil.appendEnter(sb);
		return sb.toString();
	}
	
	public String createSqlUpdate(List<TargetTableInfo> list){
		StringBuilder sb = new StringBuilder();
		sb.append(space+"UPDATE " + list.get(0).getTableOwner() + "." + list.get(0).getTableName());
		DevHelperUtil.appendEnter(sb);
		for(int i=0; i<list.size(); i++){
			if(i==0){
				sb.append(space+" SET " + list.get(i).getColumnName() + " = #{" + DevHelperUtil.toCamelCase(list.get(i).getColumnName()) + "} " + " /*" + list.get(i).getColumnComments() + "*/");
			}else{
				sb.append(space+"   , " + list.get(i).getColumnName() + " = #{" + DevHelperUtil.toCamelCase(list.get(i).getColumnName()) + "} " + " /*" + list.get(i).getColumnComments() + "*/");
			}
			DevHelperUtil.appendEnter(sb);
		}
		sb.append(space+" WHERE 1=1");
		DevHelperUtil.appendEnter(sb);
		for(int i=0; i<list.size(); i++){
			sb.append(space+"   AND " + list.get(i).getColumnName() + " = #{" + DevHelperUtil.toCamelCase(list.get(i).getColumnName()) + "} " + " /*" + list.get(i).getColumnComments() + "*/");
			DevHelperUtil.appendEnter(sb);
		}
		return sb.toString();
	}
	
	public String createSqlDelete(List<TargetTableInfo> list){
		StringBuilder sb = new StringBuilder();
		sb.append(space+"DELETE FROM " + list.get(0).getTableOwner() + "." +list.get(0).getTableName());
		DevHelperUtil.appendEnter(sb);
		return sb.toString();
	}
	
	public String createJavaFiled(List<TargetTableInfo> list, String className){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getColumnType().toUpperCase().contains("NUMBER")){
				sb.append(space+"private int " + DevHelperUtil.toCamelCase(list.get(i).getColumnName()) +  "; /*" + list.get(i).getColumnComments() +"*/");
			}else{
				sb.append(space+"private String " + DevHelperUtil.toCamelCase(list.get(i).getColumnName()) + "; /*" + list.get(i).getColumnComments() +"*/");
			}
			DevHelperUtil.appendEnter(sb);
		}
		return sb.toString();
	}
	
	public String createJavaConstructor(List<TargetTableInfo> list, String className){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list.size(); i++){
			if(i==0) {
				sb.append("\tpublic " + className + "( ");
			}
			if(i < list.size()-1) {
				if(list.get(i).getColumnType().toUpperCase().contains("NUMBER")){
					sb.append("int " + DevHelperUtil.toCamelCase(list.get(i).getColumnName()) + ", ");
				}else{
					sb.append("String " + DevHelperUtil.toCamelCase(list.get(i).getColumnName() + ", "));
				}
			}else {
				if(list.get(i).getColumnType().toUpperCase().contains("NUMBER")){
					sb.append("int " + DevHelperUtil.toCamelCase(list.get(i).getColumnName()) + "){");
				}else{
					sb.append("String " + DevHelperUtil.toCamelCase(list.get(i).getColumnName() + "){"));
				}
			}
			
		}
		sb.append("\n\t\tsuper();\n");
		
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getColumnType().toUpperCase().contains("NUMBER")){
				sb.append("\t\tthis." + DevHelperUtil.toCamelCase(list.get(i).getColumnName()) + " = " + DevHelperUtil.toCamelCase(list.get(i).getColumnName()) + "; /*" + list.get(i).getColumnComments() +"*/");
			}else{
				sb.append("\t\tthis." + DevHelperUtil.toCamelCase(list.get(i).getColumnName()) + " = " + DevHelperUtil.toCamelCase(list.get(i).getColumnName()) + "; /*" + list.get(i).getColumnComments() +"*/");
			}
			DevHelperUtil.appendEnter(sb);
		}
		sb.append("\t}");
		return sb.toString();
	}
}
