package com.jacarrichan.generator.codegen.systemmenu;

import java.util.ArrayList;
import java.util.List;

import com.jacarrichan.generator.api.GeneratedJavaFile;
import com.jacarrichan.generator.api.GeneratedXmlFile;
import com.jacarrichan.generator.api.IntrospectedTable;
import com.jacarrichan.generator.api.ProgressCallback;
import com.jacarrichan.generator.codegen.AbstractJavaGenerator;

public class IntrospectedTableSystemMenuImpl extends IntrospectedTable {
	/** The java model generators. */
	protected List<AbstractJavaGenerator> javaModelGenerators;
	/** The client generators. */
	protected List<AbstractJavaGenerator> clientGenerators;

	public IntrospectedTableSystemMenuImpl() {
		super(TargetRuntime.SYSTEMMENU);
		javaModelGenerators = new ArrayList<AbstractJavaGenerator>();
		clientGenerators = new ArrayList<AbstractJavaGenerator>();
	}

	@Override
	public void calculateGenerators(List<String> warnings,
			ProgressCallback progressCallback) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<GeneratedJavaFile> getGeneratedJavaFiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GeneratedXmlFile> getGeneratedXmlFiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isJava5Targeted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getGenerationSteps() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean requiresXMLGenerator() {
		// TODO Auto-generated method stub
		return false;
	}

}
