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
			 * ����Configuration����
			 */
			Configuration config = new Configuration();
			/**l
			 * ָ��ģ��·��
			 */
			File file = new File(this.getClass().getResource("/").getPath()
					+ "/templates");
			/**
			 * ����Ҫ������ģ�����ڵ�Ŀ¼��������ģ���ļ�
			 */
			config.setDirectoryForTemplateLoading(file);
			/**
			 * ���ð�װ�������������װΪ����ģ��
			 */
			config.setObjectWrapper(new DefaultObjectWrapper());

			/**
			 * ��ȡģ��,�����ñ��뷽ʽ������������Ҫ��ҳ���еı����ʽһ��
			 */
			String templateName = "templates.java.ftl";
			Template template = config.getTemplate(templateName, "UTF-8");
			/**
			 * �ϲ�����ģ����ģ��
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
