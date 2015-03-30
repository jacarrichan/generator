package com.jacarrichan.generator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import com.jacarrichan.generator.api.MyBatisGenerator;
import com.jacarrichan.generator.config.Configuration;
import com.jacarrichan.generator.config.xml.ConfigurationParser;
import com.jacarrichan.generator.exception.InvalidConfigurationException;
import com.jacarrichan.generator.internal.DefaultShellCallback;

public class MyBatisGeneratorTest {

    @Test(expected=InvalidConfigurationException.class)
    public void testGenerateMyBatis3() throws Exception {
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(this.getClass().getClassLoader().getResourceAsStream("generatorConfigMyBatis3.xml"));
            
        DefaultShellCallback shellCallback = new DefaultShellCallback(true);
        try {
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
            myBatisGenerator.generate(null);
        } catch (InvalidConfigurationException e) {
        	e.printStackTrace();
        	throw e;
        }
    }
    @Test(expected=InvalidConfigurationException.class)
    public void testGenerateSystemMenu() throws Exception {
    	List<String> warnings = new ArrayList<String>();
    	ConfigurationParser cp = new ConfigurationParser(warnings);
    	Configuration config = cp.parseConfiguration(this.getClass().getClassLoader().getResourceAsStream("misGeneratorConfigSystemMenu.xml"));
    	
    	DefaultShellCallback shellCallback = new DefaultShellCallback(true);
    	try {
    		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
    		myBatisGenerator.generate(null);
    	} catch (InvalidConfigurationException e) {
    		e.printStackTrace();
    		throw e;
    	}
    }

}
