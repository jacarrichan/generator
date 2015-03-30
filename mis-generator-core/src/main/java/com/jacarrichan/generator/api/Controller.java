package com.jacarrichan.generator.api;

import java.util.ArrayList;
import java.util.List;

import com.jacarrichan.generator.internal.util.JavaBeansUtil;

public class Controller {
	protected String name;
	protected String url;
	protected List<ControllerMethod> methodList;

	public Controller(String url) {
		super();
		this.url = url;
		this.name = JavaBeansUtil.getCamelCaseString(url, true);
		methodList=new ArrayList<ControllerMethod>();
	}

	public Controller(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<ControllerMethod> getMethodList() {
		return methodList;
	}

	public void setMethodList(List<ControllerMethod> methodList) {
		this.methodList = methodList;
	}

}
