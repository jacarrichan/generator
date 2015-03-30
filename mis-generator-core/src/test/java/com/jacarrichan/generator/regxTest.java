package com.jacarrichan.generator;

import org.junit.Test;

public class regxTest {
	@Test
	public void testreg() {
		String url = "function(){adQueryBase(\"Ìõ¼þ²éÑ¯\",\"icon-search\",800,330,\"system-distionary/query.html\");}";
		url="system-area/index.html";
		url = url.substring(0, url.indexOf("."));
		if(null!=url){
			url=url.substring(url.lastIndexOf("\"")+1);
		}
		System.out.println(url);
	}
}
