package com.jacarrichan.generator;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class FreeMarkerTest {
	@Test
	public void testProcessTemplate() {
		try {
			Map root = new HashMap();
			root.put("user", "dddddddddd");
			root.put("controllerName", "SystemUser");
			/**
			 * 创建Configuration对象
			 */
			Configuration config = new Configuration();
			/**l
			 * 指定模板路径
			 */
			File file = new File(this.getClass().getResource("/").getPath()
					+ "/templates");
			/**
			 * 设置要解析的模板所在的目录，并加载模板文件
			 */
			config.setDirectoryForTemplateLoading(file);
			/**
			 * 设置包装器，并将对象包装为数据模型
			 */
			config.setObjectWrapper(new DefaultObjectWrapper());

			/**
			 * 获取模板,并设置编码方式，这个编码必须要与页面中的编码格式一致
			 */
			String templateName = "templates.java.ftl";
			Template template = config.getTemplate(templateName, "UTF-8");
			/**
			 * 合并数据模型与模板
			 */
			Writer out = new OutputStreamWriter(System.out);
			template.process(root, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
