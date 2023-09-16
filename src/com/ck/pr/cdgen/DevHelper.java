package com.ck.pr.cdgen;

import java.text.MessageFormat;
import java.util.List;

import com.ck.pr.cdgen.connector.Connector;
import com.ck.pr.cdgen.connector.impl.MariaDbConnector;
import com.ck.pr.cdgen.connector.impl.OracleDbConnector;
import com.ck.pr.cdgen.model.FileMetaInfo;
import com.ck.pr.cdgen.model.TargetTableInfo;
import com.ck.pr.cdgen.temp.impl.CltTemplate;
import com.ck.pr.util.DevHelperUtil;

public class DevHelper {
	//테스트 서버 DB 정보
	public String driver = "";
	public String url = "";
	public String user = "";
	public String pass = "";
	public Connector odb = null;
	
	public void setConnectInfo(String driver, String url, String user, String pass, String type) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pass = pass;
		if(type.equals("oracle")) {
			this.odb = new OracleDbConnector(driver, url, user, pass, true);
		}else {
			this.odb = new MariaDbConnector(driver, url, user, pass, true);
		}
	}
	
	public String printAllSql(String tableName){
		String alias = "A";
		String className = DevHelperUtil.toPascalCase(tableName) + "Dto";
		
		List<TargetTableInfo> list = odb.getTableInfo(tableName);
		
		if(null == list || list.size() == 0){
			return "테이블이 존재하지 않거나 DB 정보를 확인해 주세요.";
		}
		
		String createSql = odb.createSqlCreate(list);
		String insertSql = odb.createSqlInsert(list);
		String selectSql = odb.createSqlSelect(list, alias);
		String updateSql = odb.createSqlUpdate(list);
		String deleteSql = odb.createSqlDelete(list);
		String vo = odb.createJavaFiled(list, className);
		
		String result = "";
		result += "==createSqlCreate============================================================\n";
		result += createSql.replaceAll("\t", "");
		result += "==createSqlInsert============================================================\n";
		result += insertSql.replaceAll("\t", "");
		result += "==createSqlSelect============================================================\n";
		result += selectSql.replaceAll("\t", "");
		result += "==createSqlUpdate============================================================\n";
		result += updateSql.replaceAll("\t", "");
		result += "==createSqlDelete============================================================\n";
		result += deleteSql.replaceAll("\t", "");
		result += "==createJavaFiled============================================================\n";
		result += vo.replaceAll("\t", "");
		result += "=========================================================================\n";
		System.out.println(result);
		return result;
	}

	public void createAllFile(FileMetaInfo info) {
		if(null == info)
			throw new RuntimeException("파라미터 누락 !");
		String controllerPack = DevHelperUtil.getPackageName(info.getControllerPath());
		String servicePack = DevHelperUtil.getPackageName(info.getServicePath());
		String serviceImplPack = DevHelperUtil.getPackageName(info.getServiceImplPath());
		String daoPack = DevHelperUtil.getPackageName(info.getDaoPath());
		String daoImplPack = DevHelperUtil.getPackageName(info.getDaoImplPath());
		String mapperPack = DevHelperUtil.getPackageName(info.getMapperPath());
		String modelPack = DevHelperUtil.getPackageName(info.getModelPath());
		String searchModelPack = DevHelperUtil.getPackageName(info.getSearchModelPath());
		String ormPack = DevHelperUtil.getOrmPackName(info.getOrmPath());
		
		info.setControllerPack(controllerPack);
		info.setServicePack(servicePack);
		info.setServiceImplPack(serviceImplPack);
		info.setDaoPack(daoPack);
		info.setDaoImplPack(daoImplPack);
		info.setMapperPack(mapperPack);
		info.setModelPack(modelPack);
		info.setSearchModelPack(searchModelPack);
		info.setOrmPack(ormPack);
		
		info.setControllerFileName(DevHelperUtil.getFileName(info.getControllerPath()));
		info.setServiceFileName(DevHelperUtil.getFileName(info.getServicePath()));
		info.setServiceImplFileName(DevHelperUtil.getFileName(info.getServiceImplPath()));
		info.setDaoFileName(DevHelperUtil.getFileName(info.getDaoPath()));
		info.setDaoImplFileName(DevHelperUtil.getFileName(info.getDaoImplPath()));
		info.setMapperFileName(DevHelperUtil.getFileName(info.getMapperPath()));
		info.setModelFileName(DevHelperUtil.getFileName(info.getModelPath()));
		info.setSearchModelFileName(DevHelperUtil.getFileName(info.getSearchModelPath()));
		info.setOrmFileName(DevHelperUtil.getFileName(info.getOrmPath()));
		
		info.setControllerClazzName(DevHelperUtil.getClazzName(info.getControllerPath()));
		info.setServiceClazzName(DevHelperUtil.getClazzName(info.getServicePath()));
		info.setServiceImplClazzName(DevHelperUtil.getClazzName(info.getServiceImplPath()));
		info.setDaoClazzName(DevHelperUtil.getClazzName(info.getDaoPath()));
		info.setDaoImplClazzName(DevHelperUtil.getClazzName(info.getDaoImplPath()));
		info.setMapperClazzName(DevHelperUtil.getClazzName(info.getMapperPath()));
		info.setModelClazzName(DevHelperUtil.getClazzName(info.getModelPath()));
		info.setSearchModelClazzName(DevHelperUtil.getClazzName(info.getSearchModelPath()));
		info.setOrmClazzName(DevHelperUtil.getClazzName(info.getOrmPath()));
		
		info.setControllerImportPath(DevHelperUtil.getImportPath(controllerPack, info.getControllerClazzName()));
		info.setServiceImportPath(DevHelperUtil.getImportPath(servicePack, info.getServiceClazzName()));
		info.setServiceImplImportPath(DevHelperUtil.getImportPath(serviceImplPack, info.getServiceImplClazzName()));
		info.setDaoImportPath(DevHelperUtil.getImportPath(daoPack, info.getDaoClazzName()));
		info.setDaoImplImportPath(DevHelperUtil.getImportPath(daoImplPack, info.getDaoImplClazzName()));
		info.setMapperImportPath(DevHelperUtil.getImportPath(mapperPack, info.getMapperClazzName()));
		info.setModelImportPath(DevHelperUtil.getImportPath(modelPack, info.getModelClazzName()));
		info.setSearchModelImportPath(DevHelperUtil.getImportPath(searchModelPack, info.getSearchModelClazzName()));
		info.setOrmImportPath(DevHelperUtil.getImportPath(ormPack, info.getOrmClazzName()));
		
		createOrmFile(info);
		createModelFile(info);
		createSearchModelFile(info);
		createDaoFile(info);
		createDaoImplFile(info);
		createServiceFile(info);
		createServiceImplFile(info);
		createControllerFile(info);
	}
	
	public void createOrmFile(FileMetaInfo info) {
		if(null == info.getOrmPath() || "".equals(info.getOrmPath()))
			return;
		String ormPath = info.getOrmPath();
		String dbTableName = info.getDbTableName();
		String nameSpace = info.getNameSpace();
		String alias = "A";
		String resultType = info.getModelImportPath();
		String modelClazzName = info.getModelClazzName();
		
		List<TargetTableInfo> list = odb.getTableInfo(dbTableName);
		String insertSql = odb.createSqlInsert(list);
		String selectSql = odb.createSqlSelect(list, alias);
		String selectCountSql = odb.createSqlSelectCount(list, alias);
		String updateSql = odb.createSqlUpdate(list);
		String deleteSql = odb.createSqlDelete(list);
		
		String xmlContents = MessageFormat.format(
				CltTemplate.getBasicXmlContents(),
			modelClazzName, //0
			resultType, //1
			nameSpace, //2
			insertSql, //3
			selectSql, //4
			selectCountSql, //5
			updateSql, //6
			deleteSql //7
		);
		String xmlTemplate = MessageFormat.format(
				CltTemplate.getBasicXmlTemplate(),
			nameSpace,
			xmlContents
		);
		
		DevHelperUtil.createFile(ormPath, xmlTemplate);
	}
	
	public void createModelFile(FileMetaInfo info) {
		if(null == info.getModelPath() || "".equals(info.getModelPath()))
			return;
		String modelPath = info.getModelPath();
		String dbTableName = info.getDbTableName();
		String modelClazzName = info.getModelClazzName();
		String modelPack = info.getModelPack();
		
		List<TargetTableInfo> list = odb.getTableInfo(dbTableName);
		
		String filed = odb.createJavaFiled(list, modelClazzName);
		String constructors = odb.createJavaConstructor(list, modelClazzName);
		
		String dtoTemplate = MessageFormat.format(
				CltTemplate.getBasicModelTemplate(),
			modelPack,
			modelClazzName
		);
		
		String dtoContents = MessageFormat.format(
				CltTemplate.getBasicModelContents(),
			filed,
			constructors
		);
		
		String text = dtoTemplate + dtoContents;
		text = text.replaceAll("&#123;", "{").replaceAll("&#125;", "}");
		DevHelperUtil.createFile(modelPath, text);
	}
	
	public void createSearchModelFile(FileMetaInfo info) {
		if(null == info.getSearchModelPath() || "".equals(info.getSearchModelPath()))
			return;
		String searchModelPath = info.getSearchModelPath();
		String dbTableName = info.getDbTableName();
		String searchModelClazzName = info.getSearchModelClazzName();
		String searchModelPack = info.getSearchModelPack();
		
		List<TargetTableInfo> list = odb.getTableInfo(dbTableName);
		
		String filed = odb.createJavaFiled(list, searchModelClazzName);
		String constructors = odb.createJavaConstructor(list, searchModelClazzName);
		
		String dtoTemplate = MessageFormat.format(
				CltTemplate.getBasicSearchModelTemplate(),
			searchModelPack,
			searchModelClazzName
		);
		
		String dtoContents = MessageFormat.format(
				CltTemplate.getBasicModelContents(),
			filed,
			constructors
		);
		
		String text = dtoTemplate + dtoContents;
		text = text.replaceAll("&#123;", "{").replaceAll("&#125;", "}");
		DevHelperUtil.createFile(searchModelPath, text);
	}
	
	public void createMapperFile(FileMetaInfo info) {
		if(null == info.getMapperPath() || "".equals(info.getMapperPath()))
			return;
		String mapperPath = info.getMapperPath();
		String mapperClazzName = info.getMapperClazzName();
		String modelClazzName = info.getModelClazzName();
		String searchModelClazzName = info.getSearchModelClazzName();
		String mapperPack = info.getMapperPack();
		String modelImportPath = info.getModelImportPath();
		String searchModelImportPath = info.getSearchModelImportPath();
		
		String mapperTemplate = MessageFormat.format(
				CltTemplate.getBasicMapperTemplate(),
			mapperPack,
			modelImportPath,
			searchModelImportPath,
			mapperClazzName
		);
		
		String mapperContents = MessageFormat.format(
				CltTemplate.getBasicMapperContents(),
			modelClazzName,
			searchModelClazzName,
			DevHelperUtil.toCamelCase(searchModelClazzName)
		);
		
		String text = mapperTemplate + mapperContents;
		text = text.replaceAll("&#123;", "{").replaceAll("&#125;", "}");
		DevHelperUtil.createFile(mapperPath, text);
	}
	
	public void createDaoFile(FileMetaInfo info) {
		if(null == info.getDaoPath() || "".equals(info.getDaoPath()))
			return;
		String daoPath = info.getDaoPath();
		String daoClazzName = info.getDaoClazzName();
		String packageName = info.getDaoPack();
		String modelClazzName = info.getModelClazzName();
		String searchModelClazzName = info.getSearchModelClazzName();
		String modelImportPath = info.getModelImportPath();
		String searchModelImportPath = info.getSearchModelImportPath();
		
		String daoTemplate = MessageFormat.format(
				CltTemplate.getBasicDaoTemplate(),
			packageName,
			modelImportPath,
			searchModelImportPath,
			daoClazzName
		);
		String daoContents = MessageFormat.format(
				CltTemplate.getBasicDaoContents(),
			modelClazzName,
			searchModelClazzName,
			DevHelperUtil.toCamelCase(searchModelClazzName)
		);
		
		String text = daoTemplate + daoContents;
		text = text.replaceAll("&#123;", "{").replaceAll("&#125;", "}");
		DevHelperUtil.createFile(daoPath, text);
	}
	
	public void createDaoImplFile(FileMetaInfo info) {
		if(null == info.getDaoPath() || "".equals(info.getDaoPath()))
			return;
		String daoImplPath = info.getDaoImplPath();
		
		String daoClazzName = info.getDaoClazzName();
		String daoImplClazzName = info.getDaoImplClazzName();
		String modelClazzName = info.getModelClazzName();
		String searchModelClazzName = info.getSearchModelClazzName();
		String nameSpace = info.getNameSpace();
		
		String daoImplPack = info.getDaoImplPack();
		
		String searchModelImportPath = info.getSearchModelImportPath();
		String modelImportPath = info.getModelImportPath();
		
		String daoImplTemplate = MessageFormat.format(
				CltTemplate.getDaoImplTemplate(),
			daoImplPack,
			searchModelImportPath,
			modelImportPath,
			DevHelperUtil.toCamelCase(daoClazzName),
			daoImplClazzName,
			daoClazzName
		);
		
		String daoImplContents = MessageFormat.format(
				CltTemplate.getDaoImplContents(),
			modelClazzName,
			searchModelClazzName,
			DevHelperUtil.toCamelCase(searchModelClazzName),
			nameSpace
		);
		
		String text = daoImplTemplate + daoImplContents;
		text = text.replaceAll("&#123;", "{").replaceAll("&#125;", "}");
		DevHelperUtil.createFile(daoImplPath, text);
	}
	
	public void createServiceFile(FileMetaInfo info) {
		if(null == info.getServicePath() || "".equals(info.getServicePath()))
			return;
		String servicePath = info.getServicePath();
		
		String servicePack = info.getServicePack();
		
		String serviceClazzName = info.getServiceClazzName();
		String searchModelClazzName = info.getSearchModelClazzName();
		String modelClazzName = info.getModelClazzName();
		
		String modelImportPath = info.getModelImportPath();
		String searchModelImportPath = info.getSearchModelImportPath();
		
		String serviceTemplate = MessageFormat.format(
				CltTemplate.getBasicServiceTemplate(),
			servicePack,
			modelImportPath,
			searchModelImportPath,
			serviceClazzName
		);
		String serviceContents = MessageFormat.format(
				CltTemplate.getBasicServiceContents(),
			modelClazzName,
			searchModelClazzName,
			DevHelperUtil.toCamelCase(searchModelClazzName)
		);
		
		String text = serviceTemplate + serviceContents;
		text = text.replaceAll("&#123;", "{").replaceAll("&#125;", "}");
		DevHelperUtil.createFile(servicePath, text);
	}
	
	public void createServiceImplFile(FileMetaInfo info) {
		if(null == info.getServiceImplPath() || "".equals(info.getServiceImplPath()))
			return;
		String serviceImplPath = info.getServiceImplPath();
		
		String serviceImplPack = info.getServiceImplPack();
		
		String modelImportPath = info.getModelImportPath();
		String serarchModelImportPath = info.getSearchModelImportPath();
		String daoImportPath = info.getDaoImportPath();
		
		String serviceImplClazzName = info.getServiceImplClazzName();
		String serviceClazzName = info.getServiceClazzName();
		String daoClazzName = info.getDaoClazzName();
		String modelClazzName = info.getModelClazzName();
		String searchModelClazzName = info.getSearchModelClazzName();
		
		String serviceImplTemplate = MessageFormat.format(
				CltTemplate.getBasicServiceImplTemplate(),
			serviceImplPack,
			modelImportPath,
			serarchModelImportPath,
			daoImportPath,
			serviceImplClazzName,
			serviceClazzName
		);
		String serviceImplContents = MessageFormat.format(
				CltTemplate.getBasicServiceImplContents(),
			modelClazzName,
			searchModelClazzName,
			DevHelperUtil.toCamelCase(searchModelClazzName),
			daoClazzName,
			DevHelperUtil.toCamelCase(daoClazzName)
		);
		
		String text = serviceImplTemplate + serviceImplContents;
		text = text.replaceAll("&#123;", "{").replaceAll("&#125;", "}");
		DevHelperUtil.createFile(serviceImplPath, text);
	}
	
	public void createControllerFile(FileMetaInfo info) {
		if(null == info.getControllerPath() || "".equals(info.getControllerPath()))
			return;
		String controllerPath = info.getControllerPath();
		
		String controllerPack = info.getControllerPack();
		
		String serviceImportPath = info.getServiceImportPath();
		String modelImportPath = info.getModelImportPath();
		String serarchModelImportPath = info.getSearchModelImportPath();
		
		String controllerClazzName = info.getControllerClazzName();
		String serviceClazzName = info.getServiceClazzName();
		String modelClazzName = info.getModelClazzName();
		String searchModelClazzName = info.getSearchModelClazzName();
		
		String[] packageNameList = controllerPack.split("\\.");
		int lastIdx = packageNameList.length - 1;
		
		String contollerTemplate = MessageFormat.format(
				CltTemplate.getBasicControllerTemplate(),
			controllerPack,
			serviceImportPath,
			modelImportPath,
			serarchModelImportPath,
			controllerClazzName
		);
		String contollerContents = MessageFormat.format(
				CltTemplate.getBasicControllerContents(),
			modelClazzName,
			searchModelClazzName,
			DevHelperUtil.toCamelCase(searchModelClazzName),
			"",
			serviceClazzName,
			DevHelperUtil.toCamelCase(serviceClazzName)
		);
		
		String text = contollerTemplate + contollerContents;
		text = text.replaceAll("&#123;", "{").replaceAll("&#125;", "}");
		DevHelperUtil.createFile(controllerPath, text);
	}
	
}
