package com.ck.pr.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.ck.pr.cdgen.DevHelper;
import com.ck.pr.cdgen.model.FileMetaInfo;


public class DevToolGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	private static final int textFileSize = 45;
	
	//회사
//	private static final String dbDriver=        "net.sf.log4jdbc.DriverSpy";
//	private static final String dbUrl=           "jdbc:log4jdbc:oracle:thin:@10.154.3.160:1526:SKRECP1";
//	private static final String dbUser=          "SHOPPINGUSER";
//	private static final String dbPass=          "goddnsehd1109";
//	private static final String dbType=          "oracle";
//	private static final String dbTableName=     "HI_RM252M";
//	private static final String workspacePath=   "C:/work/workspace";
//	private static final String controllerPath=  "/05_BO/src/main/java/ehimart/webapp/bo/test/controller/TestController.java";
//	private static final String servicePath=     "/02_Application/src/main/java/ehimart/app/domain/bo/test/service/TestService.java";
//	private static final String serviceImplPath= "/02_Application/src/main/java/ehimart/app/domain/bo/test/service/TestServiceImpl.java";
//	private static final String daoPath=         "/02_Application/src/main/java/ehimart/app/domain/bo/test/biz/TestBiz.java";
//	private static final String daoImplPath=     "/02_Application/src/main/java/ehimart/app/domain/bo/test/biz/TestBizImpl.java";
//	private static final String modelPath=       "/02_Application/src/main/java/ehimart/app/domain/bo/test/model/TestModel.java";
//	private static final String searchModelPath= "/02_Application/src/main/java/ehimart/app/domain/bo/test/model/SearchTestModel.java";
//	private static final String ormPath=         "/02_Application/src/main/resources/ehimart/app/domain/bo/test/mapper/testMapper.xml";
//	private static final String nameSpace=       "testMapper";
	//clt
	private static final String dbDriver=        "net.sf.log4jdbc.sql.jdbcapi.DriverSpy";
	private static final String dbUrl=           "jdbc:log4jdbc:mariadb://dudtlr2331.cafe24.com:3306/dudtlr2331?useUnicode=true&characterEncoding=UTF-8&characterSetClient=utf8mb4&characterSetConnection=utf8mb4&characterSetDatabase=utf8mb4&characterSetFilesystem=binary&characterSetResults=utf8mb4&characterSetServer=utf8mb4&characterSetSystem=utf8&collationConnection=utf8mb4_unicode_ci&collationDatabase=utf8mb4_unicode_ci&collationServer=utf8mb4_unicode_ci";
	private static final String dbUser=          "dudtlr2331";
	private static final String dbPass=          "victory123";
	private static final String dbType=          "maria";
	private static final String dbTableName=     "PROM_TBL";
	private static final String workspacePath=   "C:/git";
	private static final String controllerPath=  "/hangang_spring_mvc/src/main/java/com/clt/shp/test/TestController.java";
	private static final String servicePath=     "";
	private static final String serviceImplPath= "/hangang_spring_mvc/src/main/java/com/clt/shp/test/service/impl/TestServiceImpl.java";
	private static final String daoPath=         "";
	private static final String daoImplPath=     "/hangang_spring_mvc/src/main/java/com/clt/shp/test/dao/impl/TestDaoImpl.java";
	private static final String modelPath=       "/hangang_spring_mvc/src/main/java/com/clt/shp/test/TestVO.java";
	private static final String searchModelPath= "";
	private static final String ormPath=         "/hangang_spring_mvc/src/main/resources/sqlmap/maria/test-mapping.xml";
	private static final String nameSpace=       "testDao";
	
	public JPanel mainPanel = new JPanel();
	public JPanel topPanel = new JPanel();
	public JPanel midPanel = new JPanel();
	public JPanel btmPanel = new JPanel();
	
	public JPanel topLeftPanel = new JPanel();
	public JPanel topCntrPanel = new JPanel();
	public JPanel topRghtPanel = new JPanel();
	
	public JPanel midLeftPanel = new JPanel();
	public JPanel midCntrPanel = new JPanel();
	public JPanel midRghtPanel = new JPanel();
	
	public JPanel btmLeftPanel = new JPanel();
	public JPanel btmCntrPanel = new JPanel();
	public JPanel btmRghtPanel = new JPanel();
	
	public JPanel workspacePathPl = new JPanel();
	public JPanel dbDriverPl = new JPanel();
	public JPanel dbUrlPl = new JPanel();
	public JPanel dbUserPl = new JPanel();
	public JPanel dbPassPl = new JPanel();
	public JPanel dbTypePl = new JPanel();
	public JPanel dbTableNamePl = new JPanel();
	public JPanel nameSpacePl = new JPanel();
	public JPanel controllerPathPl = new JPanel();
	public JPanel servicePathPl = new JPanel();
	public JPanel serviceImplPathPl = new JPanel();
	public JPanel daoPathPl = new JPanel();
	public JPanel daoImplPathPl = new JPanel();
	public JPanel modelPathPl = new JPanel();
	public JPanel searchModelPathPl = new JPanel();
	public JPanel ormPathPl = new JPanel();
	
	public JLabel workspacePathLb = new JLabel("워크스페이스 경로 :");
	public JLabel dbDriverLb = new JLabel("DB Drvier :");
	public JLabel dbUrlLb = new JLabel("DB URL :");
	public JLabel dbUserLb = new JLabel("DB User :");
	public JLabel dbPassLb = new JLabel("DB Pass :");
	public JLabel dbTypeLb = new JLabel("DBMS 명 :");
	public JLabel dbTableNameLb = new JLabel("디비 테이블 이름 :");
	public JLabel nameSpaceLb = new JLabel("네임스페이스 :");
	public JLabel controllerPathLb = new JLabel("Controller 명 :");
	public JLabel servicePathLb = new JLabel("Service 명 :");
	public JLabel serviceImplPathLb = new JLabel("ServiceImpl 명 :");
	public JLabel daoPathLb = new JLabel("Dao 명 :");
	public JLabel daoImplPathLb = new JLabel("DaoImpl 명 :");
	public JLabel modelPathLb = new JLabel("모델 명 :");
	public JLabel searchModelPathLb = new JLabel("파라미터 모델 명 :");
	public JLabel ormPathLb = new JLabel("mybatis xml 명 :");
	
	public JTextField dbDriverTf = new JTextField(dbDriver, textFileSize);
	public JTextField dbUrlTf = new JTextField(dbUrl, textFileSize);
	public JTextField dbUserTf = new JTextField(dbUser, textFileSize);
	public JTextField dbPassTf = new JTextField(dbPass, textFileSize);
	public JTextField dbTypeTf = new JTextField(dbType, textFileSize);
	public JTextField dbTableNameTf = new JTextField(dbTableName, textFileSize);
	public JTextField workspacePathTf = new JTextField(workspacePath, textFileSize);
	public JTextField controllerPathTf = new JTextField(controllerPath, textFileSize);
	public JTextField servicePathTf = new JTextField(servicePath, textFileSize);
	public JTextField serviceImplPathTf = new JTextField(serviceImplPath, textFileSize);
	public JTextField daoPathTf = new JTextField(daoPath, textFileSize);
	public JTextField daoImplPathTf = new JTextField(daoImplPath, textFileSize);
	public JTextField modelPathTf = new JTextField(modelPath, textFileSize);
	public JTextField searchModelPathTf = new JTextField(searchModelPath, textFileSize);
	public JTextField ormPathTf = new JTextField(ormPath, textFileSize);
	public JTextField nameSpaceTf = new JTextField(nameSpace, textFileSize);
	
	public JTextArea printSource = new JTextArea("디비정보만 입력해도 프린트 할 수 있습니다.", 43, 50);
	
	//스크롤 
	public JScrollPane scrollPane = new JScrollPane(printSource);
	
	public JButton topBtnPrint = new JButton("쿼리출력");
	public JButton topBtnFile = new JButton("파일생성");
	public JButton topBtnHttp = new JButton("Http통신");
	
	public JButton excuteBtn = new JButton("파일 생성");
	public JButton printBtn = new JButton("소스 프린트");

	public DevToolGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("개발 도구");
//		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		
		//패널 배경색 설정(테스트용)
//		topLeftPanel.setBackground(Color.cyan);
//		topCntrPanel.setBackground(Color.darkGray);
//		topRghtPanel.setBackground(Color.lightGray);
//		midLeftPanel.setBackground(Color.red);
//		midCntrPanel.setBackground(Color.blue);
//		midRghtPanel.setBackground(Color.green);
//		btmLeftPanel.setBackground(Color.yellow);
//		btmCntrPanel.setBackground(Color.magenta);
//		btmRghtPanel.setBackground(Color.orange);
		
		//레이아웃 설정
//		topLeftPanel.setLayout(new BoxLayout(topLeftPanel, BoxLayout.Y_AXIS));
		topCntrPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//		topRghtPanel.setLayout(new BoxLayout(topRghtPanel, BoxLayout.Y_AXIS));
//		midLeftPanel.setLayout(new BoxLayout(midLeftPanel, BoxLayout.Y_AXIS));
		midCntrPanel.setLayout(new BoxLayout(midCntrPanel, BoxLayout.Y_AXIS));
//		midRghtPanel.setLayout(new BoxLayout(midRghtPanel, BoxLayout.Y_AXIS));
//		btmLeftPanel.setLayout(new BoxLayout(btmLeftPanel, BoxLayout.Y_AXIS));
//		btmCntrPanel.setLayout(new BoxLayout(btmCntrPanel, BoxLayout.Y_AXIS));
//		btmRghtPanel.setLayout(new BoxLayout(btmRghtPanel, BoxLayout.Y_AXIS));
		
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.X_AXIS));
		btmPanel.setLayout(new BoxLayout(btmPanel, BoxLayout.X_AXIS));
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		//패널 설정
//		topPanel.add(topLeftPanel);
		topPanel.add(topCntrPanel);
//		topPanel.add(topRghtPanel);
		
		midPanel.add(midLeftPanel);
		midPanel.add(midCntrPanel);
		midPanel.add(midRghtPanel);
		
		btmPanel.add(btmLeftPanel);
		btmPanel.add(btmCntrPanel);
		btmPanel.add(btmRghtPanel);
		
		mainPanel.add(topPanel);
		mainPanel.add(midPanel);
		mainPanel.add(btmPanel);
		
		//버튼 생성
		topCntrPanel.add(topBtnPrint);
		topCntrPanel.add(topBtnFile);
		topCntrPanel.add(topBtnHttp);
		
		addEventListener();
		
		setContentPane(mainPanel);
		setSize(1400, 800);
		setVisible(true);
	}
	
	public void httpScene() {
		clearScene();
		
		JPanel workspacePathPl = new JPanel();
	}
	
	public void printScene() {
		clearScene();
		//컴포넌트 에드
		dbDriverPl.add(dbDriverLb);dbDriverPl.add(dbDriverTf);
		dbUrlPl.add(dbUrlLb);dbUrlPl.add(dbUrlTf);
		dbUserPl.add(dbUserLb);dbUserPl.add(dbUserTf);
		dbPassPl.add(dbPassLb);dbPassPl.add(dbPassTf);
		dbTypePl.add(dbTypeLb);dbTypePl.add(dbTypeTf);
		dbTableNamePl.add(dbTableNameLb);dbTableNamePl.add(dbTableNameTf);
		
		//중단
		midCntrPanel.add(new Label("* DB Info"));
		midCntrPanel.add(dbDriverPl);
		midCntrPanel.add(dbUrlPl);
		midCntrPanel.add(dbUserPl);
		midCntrPanel.add(dbPassPl);
		midCntrPanel.add(dbTypePl);
		midCntrPanel.add(dbTableNamePl);
		
		midRghtPanel.add(scrollPane);
		
		//버튼 생성
		topCntrPanel.add(topBtnPrint);
		topCntrPanel.add(topBtnFile);
		topCntrPanel.add(topBtnHttp);
		btmCntrPanel.add(printBtn);
		
		//패널 설정
		topPanel.add(topCntrPanel);
		
		midPanel.add(midLeftPanel);
		midPanel.add(midCntrPanel);
		midPanel.add(midRghtPanel);
		
		btmPanel.add(btmLeftPanel);
		btmPanel.add(btmCntrPanel);
		btmPanel.add(btmRghtPanel);
		
		mainPanel.add(topPanel);
		mainPanel.add(midPanel);
		mainPanel.add(btmPanel);
		
		setContentPane(mainPanel);
	}
	
	public void fileScene() {
		clearScene();
		//컴포넌트 에드
		workspacePathPl.add(workspacePathLb);workspacePathPl.add(workspacePathTf);
		nameSpacePl.add(nameSpaceLb);nameSpacePl.add(nameSpaceTf);
		controllerPathPl.add(controllerPathLb);controllerPathPl.add(controllerPathTf);
		servicePathPl.add(servicePathLb);servicePathPl.add(servicePathTf);
		serviceImplPathPl.add(serviceImplPathLb);serviceImplPathPl.add(serviceImplPathTf);
		daoPathPl.add(daoPathLb);daoPathPl.add(daoPathTf);
		daoImplPathPl.add(daoImplPathLb);daoImplPathPl.add(daoImplPathTf);
		modelPathPl.add(modelPathLb);modelPathPl.add(modelPathTf);
		searchModelPathPl.add(searchModelPathLb);searchModelPathPl.add(searchModelPathTf);
		ormPathPl.add(ormPathLb);ormPathPl.add(ormPathTf);
		
		midCntrPanel.add(new Label("* File Info"));
		midCntrPanel.add(workspacePathPl);
		midCntrPanel.add(controllerPathPl);
		midCntrPanel.add(servicePathPl);
		midCntrPanel.add(serviceImplPathPl);
		midCntrPanel.add(daoPathPl);
		midCntrPanel.add(daoImplPathPl);
		midCntrPanel.add(modelPathPl);
		midCntrPanel.add(searchModelPathPl);
		midCntrPanel.add(ormPathPl);
		midCntrPanel.add(nameSpacePl);
		
		//버튼 생성
		topCntrPanel.add(topBtnPrint);
		topCntrPanel.add(topBtnFile);
		topCntrPanel.add(topBtnHttp);
		btmCntrPanel.add(excuteBtn);
		
		//패널 설정
		topPanel.add(topCntrPanel);
		
		midPanel.add(midLeftPanel);
		midPanel.add(midCntrPanel);
		midPanel.add(midRghtPanel);
		
		btmPanel.add(btmLeftPanel);
		btmPanel.add(btmCntrPanel);
		btmPanel.add(btmRghtPanel);
		
		mainPanel.add(topPanel);
		mainPanel.add(midPanel);
		mainPanel.add(btmPanel);
		
		setContentPane(mainPanel);
	}
	
	public void clearScene() {
		midLeftPanel.removeAll();
		midCntrPanel.removeAll();
		midRghtPanel.removeAll();
		
		btmLeftPanel.removeAll();
		btmCntrPanel.removeAll();
		btmRghtPanel.removeAll();
		
		topPanel.removeAll();
		midPanel.removeAll();
		btmPanel.removeAll();
		
		mainPanel.removeAll();
	}
	
	public void addEventListener() {
		ActionListener topBtnPrintAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printScene();
			}
		};
		
		ActionListener topBtnFileAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileScene();
			}
		};
		ActionListener topBtnHttpAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				httpScene();
			}
		};
		
		ActionListener makeFileAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "파일생성후 이클립스 프로잭트를 refresh를 해줘야 합니다.\n파일을 정말 생성 하시겠습니까?");
				if(result == JOptionPane.YES_OPTION){
					FileMetaInfo info = new FileMetaInfo();
					info.setDbTableName(dbTableNameTf.getText());
					info.setNameSpace(nameSpaceTf.getText());
					info.setControllerPath(controllerPathTf.getText());
					info.setServicePath(servicePathTf.getText());
					info.setServiceImplPath(serviceImplPathTf.getText());
					info.setDaoPath(daoPathTf.getText());
					info.setDaoImplPath(daoImplPathTf.getText());
					info.setModelPath(modelPathTf.getText());
					info.setSearchModelPath(searchModelPathTf.getText());
					info.setOrmPath(ormPathTf.getText());
					
					DevHelper dev = new DevHelper();
					dev.setConnectInfo(
						dbDriverTf.getText(),
						dbUrlTf.getText(),
						dbUserTf.getText(),
						dbPassTf.getText(),
						dbTypeTf.getText()
					);
					dev.createAllFile(info);
				}
			}
		};
		
		ActionListener printAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DevHelper dev = new DevHelper();
				dev.setConnectInfo(
					dbDriverTf.getText(),
					dbUrlTf.getText(),
					dbUserTf.getText(),
					dbPassTf.getText(),
					dbTypeTf.getText()
				);
				String result = dev.printAllSql(dbTableNameTf.getText());
				printSource.setText(result);
			}
		};
		
		topBtnPrint.removeActionListener(topBtnPrintAction);
		topBtnFile.removeActionListener(topBtnFileAction);
		topBtnHttp.removeActionListener(topBtnHttpAction);
		excuteBtn.removeActionListener(makeFileAction);
		printBtn.removeActionListener(printAction);
		
		topBtnPrint.addActionListener(topBtnPrintAction);
		topBtnFile.addActionListener(topBtnFileAction);
		topBtnHttp.addActionListener(topBtnHttpAction);
		excuteBtn.addActionListener(makeFileAction);
		printBtn.addActionListener(printAction);
	}
	
	public static void main(String[] args) {
		new DevToolGUI();
	}
}
