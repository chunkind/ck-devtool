package com.ck.pr.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DevHelperUtil {
	private static boolean ENABLE_ENTER = true;
	
	public static void main(String[] args) {
		System.out.println(getPackageName("/ck_world/src/main/java/com/dev/ck/test/model/TestDto.java"));
	}
	
	public static String getPackageName(String filePath){
		if(null == filePath || "".equals(filePath))
			return "";
		String fileName = filePath.substring(filePath.lastIndexOf("/")+1);
		filePath = filePath.replaceAll(fileName, "");
		String path = filePath.replaceAll("/", ".").replace("\\", ".").trim();
		String[] paths = path.split("\\.");
		String[] rootPaht = {"src","main","java"};
		String packageName = "";
		
		int cnt=0;
		mainLoop : for(int i=0; i<paths.length; i++) {
			if(paths[i].equals(rootPaht[0])) {
				int j=0;
				for(; j<rootPaht.length; j++) {
					if(!paths[i+j].equals(rootPaht[j])) {
						continue mainLoop;
					}
				}
				cnt += i + rootPaht.length;
				break mainLoop;
			}
		}
		for(int i = cnt; i<paths.length; i++) {
			if(i == paths.length - 1) {
				packageName += paths[i];
			}else {
				packageName += paths[i] + ".";
			}
		}
		return packageName;
	}
	
	public static String getOrmPackName(String filePath){
		if(null == filePath || "".equals(filePath))
			return "";
		String fileName = filePath.substring(filePath.lastIndexOf("/")+1);
		filePath = filePath.replaceAll(fileName, "");
		String path = filePath.replaceAll("/", ".").replace("\\", ".").trim();
		String[] paths = path.split("\\.");
		String[] rootPaht = {"src","main","resources"};
		String packageName = "";
		
		int cnt=0;
		mainLoop : for(int i=0; i<paths.length; i++) {
			if(paths[i].equals(rootPaht[0])) {
				int j=0;
				for(; j<rootPaht.length; j++) {
					if(!paths[i+j].equals(rootPaht[j])) {
						continue mainLoop;
					}
				}
				cnt += i + rootPaht.length;
				break mainLoop;
			}
		}
		for(int i = cnt; i<paths.length; i++) {
			if(i == paths.length - 1) {
				packageName += paths[i];
			}else {
				packageName += paths[i] + ".";
			}
		}
		return packageName;
	}
	
	public static String toCamelCase(String target){
		StringBuilder result = new StringBuilder();
		boolean nextIsUpper = false;
		if (target != null && target.length() > 0) {
			if (target.length() > 1 && target.substring(1,2).equals("_")) {
				result.append(target.substring(0, 1).toUpperCase());
			}
			else {
				result.append(target.substring(0, 1).toLowerCase());
			}
			for (int i = 1; i < target.length(); i++) {
				String s = target.substring(i, i + 1);
				if (s.equals("_")) {
					nextIsUpper = true;
				}
				else {
					if (nextIsUpper) {
						result.append(s.toUpperCase());
						nextIsUpper = false;
					}
					else {
						result.append(s.toLowerCase());
					}
				}
			}
		}
		return result.toString();
	}
	
	public static String toPascalCase(String target){
		String camel = toCamelCase(target);
		return camel.substring(0, 1).toUpperCase() + camel.substring(1);
	}
	
	public static void createDirAndFile(String fullPath){
		File paramPath = new File(fullPath);
		String filePath = paramPath.getAbsolutePath();
		String dirPath = filePath.substring(0, filePath.lastIndexOf(File.separator));
		File targetDir = new File(dirPath);
		File targetFile = new File(filePath);
		
		try {
			//디랙토리 생성.
			if(!targetDir.exists()){
				targetDir.mkdirs();
			}
			
			//파일 생성.
			if(!targetFile.exists()){
				if(targetFile.createNewFile()){
					System.out.println(targetFile.getAbsolutePath() + " 파일 생성 완료 !");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void createFile(String filePath, String text){
		File file = new File("");
		String path = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator));
		String fullPath = path + filePath;
		
		DevHelperUtil.createDirAndFile(fullPath);
		
		File paramPath = new File(fullPath);
		filePath = paramPath.getAbsolutePath();
		String dirPath = filePath.substring(0, filePath.lastIndexOf(File.separator));
		File targetDir = new File(dirPath);
		File targetFile = new File(filePath);
		try {
			FileWriter fw = new FileWriter(targetFile);
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write(text);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static StringBuilder appendEnter(StringBuilder sb){
		if(ENABLE_ENTER){
			sb.append("\n");
		}else{
			sb.append(" ");
		}
		return sb;
	}
	
	public static String getFileName(String path){
		if(null == path || "".equals(path))
			return "";
		String fileOrgName = path.substring(path.lastIndexOf("/")+1);
		return fileOrgName;
	}
	
	public static String getClazzName(String path){
		String fileName = getFileName(path).split("\\.")[0];
		return fileName;
	}
	
	public static String getImportPath(String pack, String clazzName){
		if(null == pack || "".equals(pack))
			return "";
		if(null == clazzName || "".equals(clazzName))
			return "";
		return pack + "." + clazzName;
	}
	
	public static String lookupColumnName(ResultSetMetaData resultSetMetaData, int columnIndex) throws SQLException {
		String name = resultSetMetaData.getColumnLabel(columnIndex);
		if (name == null || name.length() < 1) {
			name = resultSetMetaData.getColumnName(columnIndex);
		}
		return name;
	}
}
