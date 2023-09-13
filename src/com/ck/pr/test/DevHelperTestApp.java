package com.ck.pr.test;

import com.ck.pr.cdgen.DevHelper;
import com.ck.pr.cdgen.model.FileMetaInfo;

/**
 * @Auth: K. J. S.
 * @Date: 2023. 09. 12.
 * 코드 제너레이터
 */
public class DevHelperTestApp {
	//테스트 서버 DB 정보
	public static final String DRIVER = "net.sf.log4jdbc.DriverSpy";
	public static final String URL = "jdbc:log4jdbc:oracle:thin:@10.154.3.160:1526:SKRECP1";
	public static final String USER = "SHOPPINGUSER";
	public static final String PASSWORD = "goddnsehd1109";
	public static final String TYPE = "oracle";
	
	public static void main(String[] args) {
		
		//1. 실행후 콘솔에 출력
		printAllSql("OP_ORD_DTL_INFO"); //디비명 입력
		
		//2. 실행후 파일생성 이클립스 프로잭트 새로고침해야 파일이 제대로 보입니다.
		String dbTableName = "HI_RM252M"; //db 테이블 명
		String packageName = "bo/test"; //패키지명 /로 표기
		String nameSpace = "testMapper"; //xml namespace 명
		String controllerName = "TestController"; //컨트롤러 이름
		String serviceName = "TestService"; // 서비스, 서비스임플 이름
		String bizName = "TestBiz"; // 비즈, 비즈임플 이름
		String modelName = "TestModel"; // 모델 이름
		String searchModelName = "SearchTestModel"; // 파라미터모델 이름
		String xmlName = "testXml"; // xml 이름
		createAllFile(dbTableName, packageName, nameSpace, controllerName, serviceName, bizName, modelName, searchModelName, xmlName);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void printAllSql(String targetTableName){
		DevHelper dev = new DevHelper();
		dev.setConnectInfo(DRIVER, URL, USER, PASSWORD, TYPE);
		dev.printAllSql(targetTableName); //출력할 DB 테이블 명
	}
	
	public static void createAllFile(String dbTableName, String packageName, String nameSpace, String controllerName, 
			String serviceName, String bizName, String modelName, String searchModelName, String xmlName){
		
		String controllerPath = "/05_BO/src/main/java/ehimart/webapp/"+packageName+"/controller/"+controllerName+".java";
		String servicePath = "/02_Application/src/main/java/ehimart/app/domain/"+packageName+"/service/"+serviceName+".java";
		String serviceImplPath = "/02_Application/src/main/java/ehimart/app/domain/"+packageName+"/service/"+serviceName+"Impl.java";
		String bizPath = "/02_Application/src/main/java/ehimart/app/domain/"+packageName+"/biz/"+bizName+".java";
		String bizImplPath = "/02_Application/src/main/java/ehimart/app/domain/"+packageName+"/biz/"+bizName+"Impl.java";
		String modelPath = "/02_Application/src/main/java/ehimart/app/domain/"+packageName+"/model/"+modelName+".java";
		String searchModelPath = "/02_Application/src/main/java/ehimart/app/domain/"+packageName+"/model/"+searchModelName+".java";
		String ormPath  = "/02_Application/src/main/resources/ehimart/app/domain/"+packageName+"/mapper/"+xmlName+".xml";
		
		FileMetaInfo info = new FileMetaInfo();
		info.setDbTableName(dbTableName);
		info.setNameSpace(nameSpace);
		info.setControllerPath(controllerPath);
		info.setServicePath(servicePath);
		info.setServiceImplPath(serviceImplPath);
		info.setDaoPath(bizPath);
		info.setDaoImplPath(bizImplPath);
		info.setModelPath(modelPath);
		info.setSearchModelPath(searchModelPath);
		info.setOrmPath(ormPath);
		
		DevHelper dev = new DevHelper();
		dev.setConnectInfo(DRIVER, URL, USER, PASSWORD, TYPE);
		dev.createAllFile(info);
	}
}
