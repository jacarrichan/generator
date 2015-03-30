package com.huateng.credit.console.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/${url}")
public  class ${name}Action extends BaseViewAction{

<#list methodList as method>
	@RequestMapping("/${method.url}")
	public void ${method.methodName}(ModelMap model, HttpServletRequest request){
	
	}

</#list>

}
