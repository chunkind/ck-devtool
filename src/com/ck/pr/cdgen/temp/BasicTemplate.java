package com.ck.pr.cdgen.temp;

public class BasicTemplate {
	public static String getBasicXmlTemplate(){
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \n");
		sb.append("\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n");
		sb.append("<mapper namespace=\"{0}\">\n");
		sb.append("{1}");
		sb.append("</mapper>");
		return sb.toString();
	}
	public static String getBasicXmlContents(){
		StringBuilder sb = new StringBuilder();
		sb.append("\t<insert id=\"insert{0}One\">\n");
		sb.append("\t/* {2}.insert{0}One - */\n");
		sb.append("{3}"); // insert
		sb.append("\t</insert>\n\n");
		
		sb.append("\t<select id=\"select{0}One\" resultType=\"{1}\">\n");
		sb.append("\t/* {2}.select{0}One - */\n");
		sb.append("{4}"); // select
		sb.append("\t</select>\n\n");
		
		sb.append("\t<select id=\"select{0}Count\" resultType=\"Integer\">\n");
		sb.append("\t/* {2}.select{0}Count - */\n");
		sb.append("{5}"); // select
		sb.append("\t</select>\n\n");
		
		sb.append("\t<select id=\"select{0}List\" resultType=\"{1}\">\n");
		sb.append("\t/* {2}.select{0}List - */\n");
		sb.append("{4}"); // select
		sb.append("\t</select>\n\n");
		
		sb.append("\t<update id=\"update{0}One\">\n");
		sb.append("\t/* {2}.update{0}One - */\n");
		sb.append("{6}"); // update
		sb.append("\t</update>\n\n");
		
		sb.append("\t<delete id=\"delete{0}One\">\n");
		sb.append("\t/* {2}.delete{0}One - */\n");
		sb.append("{7}"); // delete
		sb.append("\t</delete>\n\n");
		return sb.toString();
	}
	
	public static String getBasicSearchModelTemplate(){
		StringBuilder sb = new StringBuilder();
		sb.append("package {0};\n\n");
		sb.append("import lombok.Builder;\n");
		sb.append("import lombok.Data;\n");
		sb.append("import lombok.EqualsAndHashCode;\n");
		sb.append("import lombok.NoArgsConstructor;\n");
		sb.append("import framework.core.mvc.model.PaginatedSearchParam;\n\n");
		sb.append("@Data\n");
		sb.append("@NoArgsConstructor\n");
		sb.append("@EqualsAndHashCode(callSuper = false)\n");
		sb.append("public class {1} extends PaginatedSearchParam");
		return sb.toString();
	}
	public static String getBasicModelTemplate(){
		StringBuilder sb = new StringBuilder();
		sb.append("package {0};\n\n");
		sb.append("import lombok.Builder;\n");
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
		sb.append("\t@Builder\n");
		sb.append("{1}\n");
		sb.append("&#125;\n");
		return sb.toString();
	}
	
	public static String getBasicMapperTemplate(){
		StringBuilder sb = new StringBuilder();
		sb.append("package {0};\n\n");
		sb.append("import java.util.List;\n");
		sb.append("import org.apache.ibatis.annotations.Mapper;\n");
		sb.append("import {1};\n");
		sb.append("import {2};\n\n");
		sb.append("@Mapper\n");
		sb.append("public interface {3}");
		return sb.toString();
	}
	public static String getBasicMapperContents(){
		StringBuilder sb = new StringBuilder();
		sb.append("&#123;\n");
		sb.append("\tint insert{0}One({1} {2});\n");
		sb.append("\tint update{0}One({1} {2});\n");
		sb.append("\tint delete{0}One({1} {2});\n");
		sb.append("\t{0} select{0}One({1} {2});\n");
		sb.append("\tint select{0}Count({1} {2});\n");
		sb.append("\tList<{0}> select{0}List({1} {2});\n");
		sb.append("&#125;\n");
		return sb.toString();
	}
	
	public static String getBasicDaoTemplate(){
		StringBuilder sb = new StringBuilder();
		sb.append("package {0};\n\n");
		sb.append("import java.util.List;\n");
		sb.append("import framework.core.mvc.model.PaginatedList;\n\n");
		sb.append("import {1};\n");
		sb.append("import {2};\n\n");
		sb.append("public interface {3}");
		return sb.toString();
	}
	public static String getBasicDaoContents(){
		StringBuilder sb = new StringBuilder();
		sb.append("&#123;\n");
		sb.append("\tint insert{0}One({1} {2});\n");
		sb.append("\tint update{0}One({1} {2});\n");
		sb.append("\tint delete{0}One({1} {2});\n");
		sb.append("\t{0} select{0}One({1} {2});\n");
		sb.append("\tint select{0}Count({1} {2});\n");
		sb.append("\tPaginatedList<{0}> select{0}List({1} {2});\n");
		sb.append("&#125;\n");
		return sb.toString();
	}
	
	public static String getDaoImplTemplate() {
		StringBuilder sb = new StringBuilder();
		sb.append("package {0};\n\n");
		sb.append("import java.util.List;\n\n");
		sb.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		sb.append("import org.springframework.stereotype.Service;\n");
		sb.append("import org.springframework.stereotype.Component;\n");
		sb.append("import framework.core.mvc.dao.BaseDao;\n");
		sb.append("import framework.core.mvc.model.PaginatedList;\n");
		sb.append("import lombok.extern.slf4j.Slf4j;\n");
		sb.append("import {1};\n");
		sb.append("import {2};\n\n");
		sb.append("@Slf4j\n");
		sb.append("@Component(\"{3}\")\n");
		sb.append("public class {4} implements {5}");
		return sb.toString();
	}
	public static String getDaoImplContents() {
		StringBuilder sb = new StringBuilder();
		sb.append("&#123;\n");
		sb.append("\t@Autowired private BaseDao baseDao;\n\n");
		
		sb.append("\t@Override\n");
		sb.append("\tpublic int insert{0}One({1} {2})&#123;");
		sb.append("\n\t\treturn (int)baseDao.create(\"{3}.insert{0}One\", {2});\n\t&#125;\n\n");

		sb.append("\t@Override\n");
		sb.append("\tpublic int update{0}One({1} {2})&#123;");
		sb.append("\n\t\treturn (int)baseDao.update(\"{3}.update{0}One\", {2});\n\t&#125;\n\n");

		sb.append("\t@Override\n");
		sb.append("\tpublic int delete{0}One({1} {2})&#123;");
		sb.append("\n\t\treturn (int)baseDao.update(\"{3}.delete{0}One\", {2});\n\t&#125;\n\n");

		sb.append("\t@Override\n");
		sb.append("\tpublic {0} select{0}One({1} {2})&#123;");
		sb.append("\n\t\treturn ({0})baseDao.getObject(\"{3}.select{0}One\", {2});\n\t&#125;\n\n");
		
		sb.append("\t@Override\n");
		sb.append("\tpublic int select{0}Count({1} {2})&#123;");
		sb.append("\n\t\treturn (int)baseDao.getObject(\"{3}.select{0}Count\", {2});\n\t&#125;\n\n");
		
		sb.append("\t@Override\n");
		sb.append("\tpublic PaginatedList<{0}> select{0}List({1} {2})&#123;");
		sb.append("\n\t\treturn baseDao.getPaginatedList(\"{3}.select{0}List\", \"{3}.select{0}Count\", {2});\n\t&#125;\n\n");
		sb.append("&#125;\n");
		return sb.toString();
	}
	
	public static String getBasicServiceTemplate() {
		StringBuilder sb = new StringBuilder();
		sb.append("package {0};\n\n");
		sb.append("import java.util.List;\n");
		sb.append("import framework.core.mvc.model.PaginatedList;\n");
		sb.append("import {1};\n\n");
		sb.append("import {2};\n\n");
		sb.append("public interface {3}");
		return sb.toString();
	}
	public static String getBasicServiceContents() {
		StringBuilder sb = new StringBuilder();
		sb.append("&#123;\n");
		sb.append("\tint insert{0}One({1} {2});\n");
		sb.append("\tint update{0}One({1} {2});\n");
		sb.append("\tint delete{0}One({1} {2});\n");
		sb.append("\t{0} select{0}One({1} {2});\n");
		sb.append("\tint select{0}Count({1} {2});\n");
		sb.append("\tPaginatedList<{0}> select{0}List({1} {2});\n");
		sb.append("&#125;\n");
		return sb.toString();
	}
	
	public static String getBasicServiceImplTemplate() {
		StringBuilder sb = new StringBuilder();
		sb.append("package {0};\n\n");
		sb.append("import java.util.List;\n\n");
		sb.append("import framework.core.mvc.model.PaginatedList;\n");
		sb.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		sb.append("import org.springframework.stereotype.Service;\n");
		sb.append("import lombok.extern.slf4j.Slf4j;\n");
		sb.append("import {1};\n");
		sb.append("import {2};\n");
		sb.append("import {3};\n\n");
		sb.append("@Slf4j\n");
		sb.append("@Service\n");
		sb.append("public class {4} implements {5}");
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
		sb.append("import lombok.extern.slf4j.Slf4j;\n");
		sb.append("import ehimart.webapp.bo.common.BoController;\n\n");
		sb.append("import {1};\n");
		sb.append("import {2};\n");
		sb.append("import {3};\n\n");
		sb.append("@Slf4j\n");
		sb.append("@Controller\n");
		sb.append("public class {4} extends BoController");
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
