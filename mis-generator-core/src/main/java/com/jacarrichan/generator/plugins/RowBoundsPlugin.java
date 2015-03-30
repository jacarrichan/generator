/*
 *  Copyright 2011 MyBatis
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.jacarrichan.generator.plugins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.jacarrichan.generator.api.FullyQualifiedTable;
import com.jacarrichan.generator.api.IntrospectedTable;
import com.jacarrichan.generator.api.IntrospectedTable.TargetRuntime;
import com.jacarrichan.generator.api.PluginAdapter;
import com.jacarrichan.generator.api.dom.java.FullyQualifiedJavaType;
import com.jacarrichan.generator.api.dom.java.Interface;
import com.jacarrichan.generator.api.dom.java.Method;
import com.jacarrichan.generator.api.dom.java.Parameter;
import com.jacarrichan.generator.api.dom.xml.Attribute;
import com.jacarrichan.generator.api.dom.xml.Document;
import com.jacarrichan.generator.api.dom.xml.XmlElement;

/**
 * This plugin will add selectByExample methods that include rowBounds
 * parameters to the generated mapper interface.  This plugin is only
 * valid for MyBatis3.
 * 
 * @author Jeff Butler
 */
public class RowBoundsPlugin extends PluginAdapter {
    
    private FullyQualifiedJavaType rowBounds;
    private Map<FullyQualifiedTable, List<XmlElement>> elementsToAdd;

    public RowBoundsPlugin() {
        rowBounds = new FullyQualifiedJavaType("org.apache.ibatis.session.RowBounds"); //$NON-NLS-1$
        elementsToAdd = new HashMap<FullyQualifiedTable, List<XmlElement>>();
    }
    
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method,
            Interface interfaze, IntrospectedTable introspectedTable) {
        if (introspectedTable.getTargetRuntime() == TargetRuntime.SYSTEMMENU) {
            copyAndAddMethod(method, interfaze);
        }
        return true;
    }

    @Override
    public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(
            Method method, Interface interfaze,
            IntrospectedTable introspectedTable) {
        if (introspectedTable.getTargetRuntime() == TargetRuntime.SYSTEMMENU) {
            copyAndAddMethod(method, interfaze);
        }
        return true;
    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(
            XmlElement element, IntrospectedTable introspectedTable) {
        if (introspectedTable.getTargetRuntime() == TargetRuntime.SYSTEMMENU) {
            copyAndSaveElement(element, introspectedTable.getFullyQualifiedTable());
        }
        return true;
    }

    @Override
    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(
            XmlElement element, IntrospectedTable introspectedTable) {
        if (introspectedTable.getTargetRuntime() == TargetRuntime.SYSTEMMENU) {
            copyAndSaveElement(element, introspectedTable.getFullyQualifiedTable());
        }
        return true;
    }

    /**
     * We'll override this method and add any new elements generated by
     * previous calls
     */
    @Override
    public boolean sqlMapDocumentGenerated(Document document,
            IntrospectedTable introspectedTable) {
        List<XmlElement> elements = elementsToAdd.get(introspectedTable.getFullyQualifiedTable());
        if (elements != null) {
            for (XmlElement element : elements) {
                document.getRootElement().addElement(element);
            }
        }

        return true;
    }
    
    /**
     * Use the method copy constructor to create a new method, then
     * add the rowBounds parameter.
     * 
     * @param fullyQualifiedTable
     * @param method
     */
    private void copyAndAddMethod(Method method, Interface interfaze) {
        Method newMethod = new Method(method);
        newMethod.setName(method.getName() + "WithRowbounds"); //$NON-NLS-1$
        newMethod.addParameter(new Parameter(rowBounds, "rowBounds")); //$NON-NLS-1$
        interfaze.addMethod(newMethod);
        interfaze.addImportedType(rowBounds);
    }

    /**
     * Use the method copy constructor to create a new element
     * 
     * @param fullyQualifiedTable
     * @param method
     */
    private void copyAndSaveElement(XmlElement element, FullyQualifiedTable fqt) {
        XmlElement newElement = new XmlElement(element);
            
        // remove old id attribute and add a new one with the new name
        for (Iterator<Attribute> iterator = newElement.getAttributes().iterator(); iterator.hasNext();) {
            Attribute attribute = iterator.next();
            if ("id".equals(attribute.getName())) { //$NON-NLS-1$
                iterator.remove();
                Attribute newAttribute = new Attribute("id", attribute.getValue() + "WithRowbounds"); //$NON-NLS-1$ //$NON-NLS-2$
                newElement.addAttribute(newAttribute);
                break;
            }
        }
            
        // save the new element locally.   We'll add it to the document
        // later
        List<XmlElement> elements = elementsToAdd.get(fqt);
        if (elements == null) {
            elements = new ArrayList<XmlElement>();
            elementsToAdd.put(fqt, elements);
        }
        elements.add(newElement);
    }
}
