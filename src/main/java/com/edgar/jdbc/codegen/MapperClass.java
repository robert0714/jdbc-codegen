/**
 *
 * Copyright 2013
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * @author Kalyan Mulampaka
 */
package com.edgar.jdbc.codegen;

import com.edgar.jdbc.codegen.util.CodeGenUtil;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapperClass extends BaseClass {

    final static Logger logger = LoggerFactory.getLogger(MapperClass.class);
    private static String CLASS_SUFFIX = "Mapper";

    private boolean generateRepositoryAnnotations = false;

    public MapperClass() {
        this.classSuffix = CLASS_SUFFIX;
        super.setExtendsClassName("com.edgar.core.repository.BaseMapper");
        this.addImports();
    }

    @Override
    protected void addImports() {
        if (generateRepositoryAnnotations) {
            this.imports.add("org.springframework.stereotype.Repository");
        }
    }

    protected void printClassAnnotations() {
        if (generateRepositoryAnnotations) {
            sourceBuf.append("@Repository\n");
        }
    }

    protected void printClassDefn() {
        sourceBuf.append("public interface " + name + this.classSuffix);
    }

    @Override
    protected void printClassExtends() {
        super.printClassExtends();

        if (!Strings.isNullOrEmpty(extendsClassName)) {
            sourceBuf.append("<");
            sourceBuf.append(this.name + ", ");
            if (this.pkeys.size() == 0) {
                sourceBuf.append("String");
            } else if (pkeys.size() == 1) {
                sourceBuf.append(this.pkeys.values().iterator().next().getName());
            } else {
                sourceBuf.append("Map<String, Object>");
            }
            sourceBuf.append(">");

        }
    }

    protected void printMethods() {
        String id = "String";
        if (this.pkeys.size() == 0) {
            id = "String";
        } else if (pkeys.size() == 1) {
            id = this.pkeys.values().iterator().next().getName();
        } else {
            id = "Map<String, Object>";
        }

        sourceBuf.append("\t@Override\n\t" + this.name +" selectByPrimaryKey(" + id +" id);\n\n");
        sourceBuf.append("\t@Override\n\tint insert(" + this.name +" entity);\n\n");
        sourceBuf.append("\t@Override\n\t int updateByPrimaryKey(" + this.name +" entity);\n\n");
        sourceBuf.append("\t@Override\n\tint deleteByPrimaryKey(" + id +"  id);\n\n");
        sourceBuf.append("\t@Override\n\tint updateByPrimaryKeyWithLock(" + this.name +" entity);\n\n");
        sourceBuf.append("\t@Override\n\tint deleteByPrimaryKeyWithLock(Map<String, Object> params);\n\n");
        sourceBuf.append("\t@Override\n\tint count(Map<String, Object> params);\n\n");
        sourceBuf.append("\t@Override\n\tList<" + this.name +"> query(Map<String, Object> params);\n\n");
    }

    protected void printClassComments() {
        sourceBuf.append(generateClassComments());
    }

    public static StringBuffer generateClassComments() {
        StringBuffer strBuf = new StringBuffer("");
        strBuf.append("\n/**\n");
        strBuf.append(" * This class is generated by Jdbc code generator.\n");
        strBuf.append(" *\n");
//        strBuf.append(" * 因为Mybatis-Spring无法扫描到jar包里的BaseMapper，所以重写了所有的BaseMapper方法.\n");
//        strBuf.append(" *\n");
        strBuf.append(" * @author Jdbc Code Generator\n");
        strBuf.append(" */\n");
        return strBuf;
    }

    protected void preprocess() {
        if (this.pkeys.size() != 1) {
            if (this.pkeys.size() > 1) {
                this.imports.add("java.util.Map");
            }
        }
    }

    @Override
    public void generateSource() {
        this.preprocess();

        super.printPackage();
        super.printImports();
        this.printClassComments();

        this.printClassAnnotations();
        this.printClassDefn();
        this.printClassExtends();
        super.printClassImplements();

        super.printOpenBrace(0, 2);
        super.printLogger();
//        this.printCtor();

//        this.printMethods();

        super.printUserSourceCode();

        super.printCloseBrace(0, 2);
    }

    public boolean isGenerateRepositoryAnnotations() {
        return generateRepositoryAnnotations;
    }

    public void setGenerateRepositoryAnnotations(boolean generateRepositoryAnnotations) {
        this.generateRepositoryAnnotations = generateRepositoryAnnotations;
    }
}
