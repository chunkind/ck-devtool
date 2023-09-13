package com.ck.pr.cdgen.model;

public class FileMetaInfo {
	private String dbTableName; //테이블 명
	private String nameSpace;
	
	private String controllerPath; //컨트롤러 파일 위치
	private String servicePath; //서비스 파일 위치
	private String serviceImplPath; //서비스구현체 파일 위치
	private String daoPath; //dao 파일위치
	private String daoImplPath; //dao 구현체 파일 위치
	private String mapperPath; //mapper 파일 위치
	private String modelPath; //모델 파일 위치
	private String searchModelPath; //파라미터 모델 파일 위치
	private String ormPath; //orm 파일 위치
	
	private String controllerImportPath; //컨트롤러 파일 위치
	private String serviceImportPath; //서비스 파일 위치
	private String serviceImplImportPath; //서비스구현체 파일 위치
	private String daoImportPath; //dao 파일위치
	private String daoImplImportPath; //dao 구현체 파일 위치
	private String mapperImportPath; //mapper 파일 위치
	private String modelImportPath; //모델 파일 위치
	private String searchModelImportPath; //파라미터 모델 파일 위치
	private String ormImportPath; //orm 파일 위치
	
	private String controllerPack; // 컨트롤러 패키지명
	private String servicePack; // 서비스 패키지명
	private String serviceImplPack; //서비스임플 패키지명
	private String daoPack; //dao패키지명
	private String daoImplPack; //dao임플 패키지명
	private String mapperPack; //mapper 패키지명
	private String modelPack; //모델 패키지명
	private String searchModelPack; //파라미터 모델 패키지명
	private String ormPack; //orm 패키지명
	
	private String controllerClazzName; //컨트롤러 명
	private String serviceClazzName; //서비스명
	private String serviceImplClazzName; //서비스임플명
	private String daoClazzName; //dao명
	private String daoImplClazzName; //dao임플 명
	private String mapperClazzName; //맵퍼명
	private String searchModelClazzName; //파라미터 모델명
	private String modelClazzName; //모델명
	private String ormClazzName; //orm명
	
	private String controllerFileName; //컨트롤러 파일명
	private String serviceFileName; //서비스 파일명
	private String serviceImplFileName; //서비스임플 파일명
	private String daoFileName; //dao 파일명
	private String daoImplFileName; //dao임플 파일명
	private String mapperFileName; //맵퍼 파일명
	private String searchModelFileName; //파라미터 모델 파일명
	private String modelFileName; //모델 파일명
	private String ormFileName; //orm 파일명 
	
	public String getDbTableName() {
		return dbTableName;
	}
	
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}
	
	public String getNameSpace() {
		return nameSpace;
	}
	
	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}
	
	public String getControllerPath() {
		return controllerPath;
	}
	
	public void setControllerPath(String controllerPath) {
		this.controllerPath = controllerPath;
	}
	
	public String getServicePath() {
		return servicePath;
	}
	
	public void setServicePath(String servicePath) {
		this.servicePath = servicePath;
	}
	
	public String getServiceImplPath() {
		return serviceImplPath;
	}
	
	public void setServiceImplPath(String serviceImplPath) {
		this.serviceImplPath = serviceImplPath;
	}
	
	public String getDaoPath() {
		return daoPath;
	}
	
	public void setDaoPath(String daoPath) {
		this.daoPath = daoPath;
	}
	
	public String getDaoImplPath() {
		return daoImplPath;
	}
	
	public void setDaoImplPath(String daoImplPath) {
		this.daoImplPath = daoImplPath;
	}
	
	public String getMapperPath() {
		return mapperPath;
	}
	
	public void setMapperPath(String mapperPath) {
		this.mapperPath = mapperPath;
	}
	
	public String getModelPath() {
		return modelPath;
	}
	
	public void setModelPath(String modelPath) {
		this.modelPath = modelPath;
	}
	
	public String getSearchModelPath() {
		return searchModelPath;
	}
	
	public void setSearchModelPath(String searchModelPath) {
		this.searchModelPath = searchModelPath;
	}
	
	public String getOrmPath() {
		return ormPath;
	}
	
	public void setOrmPath(String ormPath) {
		this.ormPath = ormPath;
	}
	
	public String getControllerImportPath() {
		return controllerImportPath;
	}
	
	public void setControllerImportPath(String controllerImportPath) {
		this.controllerImportPath = controllerImportPath;
	}
	
	public String getServiceImportPath() {
		return serviceImportPath;
	}
	
	public void setServiceImportPath(String serviceImportPath) {
		this.serviceImportPath = serviceImportPath;
	}
	
	public String getServiceImplImportPath() {
		return serviceImplImportPath;
	}
	
	public void setServiceImplImportPath(String serviceImplImportPath) {
		this.serviceImplImportPath = serviceImplImportPath;
	}
	
	public String getDaoImportPath() {
		return daoImportPath;
	}
	
	public void setDaoImportPath(String daoImportPath) {
		this.daoImportPath = daoImportPath;
	}
	
	public String getDaoImplImportPath() {
		return daoImplImportPath;
	}
	
	public void setDaoImplImportPath(String daoImplImportPath) {
		this.daoImplImportPath = daoImplImportPath;
	}
	
	public String getMapperImportPath() {
		return mapperImportPath;
	}
	
	public void setMapperImportPath(String mapperImportPath) {
		this.mapperImportPath = mapperImportPath;
	}
	
	public String getModelImportPath() {
		return modelImportPath;
	}
	
	public void setModelImportPath(String modelImportPath) {
		this.modelImportPath = modelImportPath;
	}
	
	public String getSearchModelImportPath() {
		return searchModelImportPath;
	}
	
	public void setSearchModelImportPath(String searchModelImportPath) {
		this.searchModelImportPath = searchModelImportPath;
	}
	
	public String getOrmImportPath() {
		return ormImportPath;
	}
	
	public void setOrmImportPath(String ormImportPath) {
		this.ormImportPath = ormImportPath;
	}
	
	public String getControllerPack() {
		return controllerPack;
	}
	
	public void setControllerPack(String controllerPack) {
		this.controllerPack = controllerPack;
	}
	
	public String getServicePack() {
		return servicePack;
	}
	
	public void setServicePack(String servicePack) {
		this.servicePack = servicePack;
	}
	
	public String getServiceImplPack() {
		return serviceImplPack;
	}
	
	public void setServiceImplPack(String serviceImplPack) {
		this.serviceImplPack = serviceImplPack;
	}
	
	public String getDaoPack() {
		return daoPack;
	}
	
	public void setDaoPack(String daoPack) {
		this.daoPack = daoPack;
	}
	
	public String getDaoImplPack() {
		return daoImplPack;
	}
	
	public void setDaoImplPack(String daoImplPack) {
		this.daoImplPack = daoImplPack;
	}
	
	public String getMapperPack() {
		return mapperPack;
	}
	
	public void setMapperPack(String mapperPack) {
		this.mapperPack = mapperPack;
	}
	
	public String getModelPack() {
		return modelPack;
	}
	
	public void setModelPack(String modelPack) {
		this.modelPack = modelPack;
	}
	
	public String getSearchModelPack() {
		return searchModelPack;
	}
	
	public void setSearchModelPack(String searchModelPack) {
		this.searchModelPack = searchModelPack;
	}
	
	public String getOrmPack() {
		return ormPack;
	}
	
	public void setOrmPack(String ormPack) {
		this.ormPack = ormPack;
	}
	
	public String getControllerClazzName() {
		return controllerClazzName;
	}
	
	public void setControllerClazzName(String controllerClazzName) {
		this.controllerClazzName = controllerClazzName;
	}
	
	public String getServiceClazzName() {
		return serviceClazzName;
	}
	
	public void setServiceClazzName(String serviceClazzName) {
		this.serviceClazzName = serviceClazzName;
	}
	
	public String getServiceImplClazzName() {
		return serviceImplClazzName;
	}
	
	public void setServiceImplClazzName(String serviceImplClazzName) {
		this.serviceImplClazzName = serviceImplClazzName;
	}
	
	public String getDaoClazzName() {
		return daoClazzName;
	}
	
	public void setDaoClazzName(String daoClazzName) {
		this.daoClazzName = daoClazzName;
	}
	
	public String getDaoImplClazzName() {
		return daoImplClazzName;
	}
	
	public void setDaoImplClazzName(String daoImplClazzName) {
		this.daoImplClazzName = daoImplClazzName;
	}
	
	public String getMapperClazzName() {
		return mapperClazzName;
	}
	
	public void setMapperClazzName(String mapperClazzName) {
		this.mapperClazzName = mapperClazzName;
	}
	
	public String getSearchModelClazzName() {
		return searchModelClazzName;
	}
	
	public void setSearchModelClazzName(String searchModelClazzName) {
		this.searchModelClazzName = searchModelClazzName;
	}
	
	public String getModelClazzName() {
		return modelClazzName;
	}
	
	public void setModelClazzName(String modelClazzName) {
		this.modelClazzName = modelClazzName;
	}
	
	public String getOrmClazzName() {
		return ormClazzName;
	}
	
	public void setOrmClazzName(String ormClazzName) {
		this.ormClazzName = ormClazzName;
	}
	
	public String getControllerFileName() {
		return controllerFileName;
	}
	
	public void setControllerFileName(String controllerFileName) {
		this.controllerFileName = controllerFileName;
	}
	
	public String getServiceFileName() {
		return serviceFileName;
	}
	
	public void setServiceFileName(String serviceFileName) {
		this.serviceFileName = serviceFileName;
	}
	
	public String getServiceImplFileName() {
		return serviceImplFileName;
	}
	
	public void setServiceImplFileName(String serviceImplFileName) {
		this.serviceImplFileName = serviceImplFileName;
	}
	
	public String getDaoFileName() {
		return daoFileName;
	}
	
	public void setDaoFileName(String daoFileName) {
		this.daoFileName = daoFileName;
	}
	
	public String getDaoImplFileName() {
		return daoImplFileName;
	}
	
	public void setDaoImplFileName(String daoImplFileName) {
		this.daoImplFileName = daoImplFileName;
	}
	
	public String getMapperFileName() {
		return mapperFileName;
	}
	
	public void setMapperFileName(String mapperFileName) {
		this.mapperFileName = mapperFileName;
	}
	
	public String getSearchModelFileName() {
		return searchModelFileName;
	}
	
	public void setSearchModelFileName(String searchModelFileName) {
		this.searchModelFileName = searchModelFileName;
	}
	
	public String getModelFileName() {
		return modelFileName;
	}
	
	public void setModelFileName(String modelFileName) {
		this.modelFileName = modelFileName;
	}
	
	public String getOrmFileName() {
		return ormFileName;
	}
	
	public void setOrmFileName(String ormFileName) {
		this.ormFileName = ormFileName;
	}

	@Override
	public String toString() {
		return "FileMetaInfo [dbTableName=" + dbTableName + ", nameSpace=" + nameSpace + ", controllerPath=" + controllerPath
				+ ", servicePath=" + servicePath + ", serviceImplPath=" + serviceImplPath + ", daoPath=" + daoPath + ", daoImplPath="
				+ daoImplPath + ", mapperPath=" + mapperPath + ", modelPath=" + modelPath + ", searchModelPath=" + searchModelPath
				+ ", ormPath=" + ormPath + ", controllerImportPath=" + controllerImportPath + ", serviceImportPath=" + serviceImportPath
				+ ", serviceImplImportPath=" + serviceImplImportPath + ", daoImportPath=" + daoImportPath + ", daoImplImportPath="
				+ daoImplImportPath + ", mapperImportPath=" + mapperImportPath + ", modelImportPath=" + modelImportPath
				+ ", searchModelImportPath=" + searchModelImportPath + ", ormImportPath=" + ormImportPath + ", controllerPack="
				+ controllerPack + ", servicePack=" + servicePack + ", serviceImplPack=" + serviceImplPack + ", daoPack=" + daoPack
				+ ", daoImplPack=" + daoImplPack + ", mapperPack=" + mapperPack + ", modelPack=" + modelPack + ", searchModelPack="
				+ searchModelPack + ", ormPack=" + ormPack + ", controllerClazzName=" + controllerClazzName + ", serviceClazzName="
				+ serviceClazzName + ", serviceImplClazzName=" + serviceImplClazzName + ", daoClazzName=" + daoClazzName
				+ ", daoImplClazzName=" + daoImplClazzName + ", mapperClazzName=" + mapperClazzName + ", searchModelClazzName="
				+ searchModelClazzName + ", modelClazzName=" + modelClazzName + ", ormClazzName=" + ormClazzName + ", controllerFileName="
				+ controllerFileName + ", serviceFileName=" + serviceFileName + ", serviceImplFileName=" + serviceImplFileName
				+ ", daoFileName=" + daoFileName + ", daoImplFileName=" + daoImplFileName + ", mapperFileName=" + mapperFileName
				+ ", searchModelFileName=" + searchModelFileName + ", modelFileName=" + modelFileName + ", ormFileName=" + ormFileName
				+ "]";
	}
}
