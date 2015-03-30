package com.jacarrichan.generator.api;

import com.jacarrichan.generator.internal.util.JavaBeansUtil;

public class ControllerMethod {
	protected String url;
	protected String methodName;

	public ControllerMethod(String url) {
		super();
		this.url = url;
		this.methodName = JavaBeansUtil.getCamelCaseString(url, false);
	}

	public ControllerMethod(String url, String methodName) {
		super();
		this.url = url;
		this.methodName = methodName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

}
