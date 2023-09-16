package com.ck.pr.cdgen.temp.impl;

import com.ck.pr.cdgen.temp.BasicTemplate;

public class CltTemplate extends BasicTemplate{

	public static String getBasicModelTemplate(){
		StringBuilder sb = new StringBuilder();
		sb.append("package {0};\n\n");
		sb.append("import lombok.Data;\n");
		sb.append("import lombok.NoArgsConstructor;\n\n");
		sb.append("@Data\n");
		sb.append("@NoArgsConstructor\n");
		sb.append("public class {1}");
		return sb.toString();
	}
	public static String getBasicModelContents(){
		StringBuilder sb = new StringBuilder();
		sb.append("&#123;\n");
		sb.append("{0}\n");
		sb.append("&#125;\n");
		return sb.toString();
	}
	
	public static String getDaoImplTemplate() {
		StringBuilder sb = new StringBuilder();
		sb.append("package {0};\n\n");
		sb.append("import java.util.List;\n\n");
		sb.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		sb.append("import org.mybatis.spring.SqlSessionTemplate;\n");
		sb.append("import org.springframework.stereotype.Repository;\n");
		sb.append("import {1};\n");
		sb.append("import {2};\n\n");
		sb.append("@Repository(\"{3}\")\n");
		sb.append("public class {4} ");
		return sb.toString();
	}
	public static String getDaoImplContents() {
		StringBuilder sb = new StringBuilder();
		sb.append("&#123;\n");
		sb.append("\t@Autowired private SqlSessionTemplate mybatis;\n\n");
		
		sb.append("\t@Override\n");
		sb.append("\tpublic int insert{0}One({1} {2})&#123;");
		sb.append("\n\t\treturn mybatis.insert(\"{3}.insert{0}One\", {2});\n\t&#125;\n\n");

		sb.append("\t@Override\n");
		sb.append("\tpublic int update{0}One({1} {2})&#123;");
		sb.append("\n\t\treturn mybatis.update(\"{3}.update{0}One\", {2});\n\t&#125;\n\n");

		sb.append("\t@Override\n");
		sb.append("\tpublic int delete{0}One({1} {2})&#123;");
		sb.append("\n\t\treturn mybatis.delete(\"{3}.delete{0}One\", {2});\n\t&#125;\n\n");

		sb.append("\t@Override\n");
		sb.append("\tpublic {0} select{0}One({1} {2})&#123;");
		sb.append("\n\t\treturn mybatis.selectOne(\"{3}.select{0}One\", {2});\n\t&#125;\n\n");
		
		sb.append("\t@Override\n");
		sb.append("\tpublic int select{0}Count({1} {2})&#123;");
		sb.append("\n\t\treturn mybatis.selectOne(\"{3}.select{0}Count\", {2});\n\t&#125;\n\n");
		
		sb.append("\t@Override\n");
		sb.append("\tpublic List<{0}> select{0}List({1} {2})&#123;");
		sb.append("\n\t\treturn mybatis.selectList(\"{3}.select{0}List\", {2});\n\t&#125;\n\n");
		sb.append("&#125;\n");
		return sb.toString();
	}
	
	public static String getBasicServiceImplTemplate() {
		StringBuilder sb = new StringBuilder();
		sb.append("package {0};\n\n");
		sb.append("import java.util.List;\n\n");
		sb.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		sb.append("import org.springframework.stereotype.Service;\n");
		sb.append("import {1};\n");
		sb.append("import {2};\n");
		sb.append("import {3};\n\n");
		sb.append("@Service\n");
		sb.append("public class {4}");
		return sb.toString();
	}
	public static String getBasicServiceImplContents() {
		StringBuilder sb = new StringBuilder();
		sb.append("&#123;\n");
		sb.append("\t@Autowired\n"); 
		sb.append("\tpublic {3} {4};\n\n"); 
		
		sb.append("\t@Override\n");
		sb.append("\tpublic int insert{0}One({1} {2})&#123;");
		sb.append("\n\t\treturn {4}.insert{0}One({2});\n\t&#125;\n\n");
		
		sb.append("\t@Override\n");
		sb.append("\tpublic int update{0}One({1} {2})&#123;");
		sb.append("\n\t\treturn {4}.update{0}One({2});\n\t&#125;\n\n");
		
		sb.append("\t@Override\n");
		sb.append("\tpublic int delete{0}One({1} {2})&#123;");
		sb.append("\n\t\treturn {4}.delete{0}One({2});\n\t&#125;\n\n");
		
		sb.append("\t@Override\n");
		sb.append("\tpublic {0} select{0}One({1} {2})&#123;");
		sb.append("\n\t\treturn {4}.select{0}One({2});\n\t&#125;\n\n");
		
		sb.append("\t@Override\n");
		sb.append("\tpublic int select{0}Count({1} {2})&#123;");
		sb.append("\n\t\treturn {4}.select{0}Count({2});\n\t&#125;\n\n");
		
		sb.append("\t@Override\n");
		sb.append("\tpublic PaginatedList<{0}> select{0}List({1} {2})&#123;");
		sb.append("\n\t\treturn {4}.select{0}List({2});\n\t&#125;\n\n");
		sb.append("&#125;\n");
		return sb.toString();
	}
	
	public static String getBasicControllerTemplate(){
		StringBuilder sb = new StringBuilder();
		sb.append("package {0};\n\n");
		sb.append("import java.util.List;\n\n");
		sb.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		sb.append("import org.springframework.stereotype.Controller;\n");
		sb.append("import org.springframework.web.bind.annotation.RestController;\n");
		sb.append("import org.springframework.web.bind.annotation.RequestMapping;\n");
		sb.append("import {1};\n");
		sb.append("import {2};\n");
		sb.append("import {3};\n\n");
		sb.append("@Controller\n");
		sb.append("public class {4} ");
		return sb.toString();
	}
	public static String getBasicControllerContents(){
		StringBuilder sb = new StringBuilder();
		sb.append("&#123;\n");
		sb.append("\t@Autowired\n");
		sb.append("\tpublic {4} {5};\n\n"); 
		
		sb.append("\t@RequestMapping(\"{3}\")\n");
		sb.append("\tpublic String regist{0}One({1} {2})&#123;");
		sb.append("\n\t\treturn \"{3}/"+"\";\n\t&#125;\n\n");
		
		sb.append("\t@RequestMapping(\"{3}\")\n");
		sb.append("\tpublic String edit{0}One({1} {2})&#123;");
		sb.append("\n\t\treturn \"{3}/"+"\";\n\t&#125;\n\n");
		
		sb.append("\t@RequestMapping(\"{3}\")\n");
		sb.append("\tpublic String remove{0}One({1} {2})&#123;");
		sb.append("\n\t\treturn \"{3}/"+"\";\n\t&#125;\n\n");
		
		sb.append("\t@RequestMapping(\"{3}\")\n");
		sb.append("\tpublic String show{0}One({1} {2})&#123;");
		sb.append("\n\t\treturn \"{3}/"+"\";\n\t&#125;\n\n");
		
		sb.append("\t@RequestMapping(\"{3}\")\n");
		sb.append("\tpublic String show{0}List({1} {2})&#123;");
		sb.append("\n\t\treturn \"{3}/"+"\";\n\t&#125;\n\n");
		sb.append("&#125;\n");
		return sb.toString();
	}
}
