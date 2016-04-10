package com.edgar.jdbc.codegen.gen;

import com.edgar.jdbc.codegen.CodegenOptions;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edgar on 16-4-8.
 */
public abstract class BaseClass implements Codegen {
  private final static Logger LOGGER = LoggerFactory.getLogger(BaseClass.class);
  protected final StringBuffer sourceBuf = new StringBuffer();
  protected final List<String> imports = new ArrayList<String>();

  private static String COMMENT_START = "/* START 写在START和END中间的代码不会被替换*/";

  private static String COMMENT_END = "/* END 写在START和END中间的代码不会被替换*/";

  private static String IS_COMMENT_START = "/* START";

  private static String IS_COMMENT_END = "/* END";

  private String rootFolderPath;

  private String packageName;

  private String classSuffix = "";

  protected String name;

  private final StringBuffer userSourceBuf = new StringBuffer("");

  private final CodegenOptions options;

//  private String dbProductName;
//
//  private String dbProductVersion;


  public BaseClass(CodegenOptions options) {
    this.options = options;
  }

  @Override
  public void createFile() throws Exception {
    String fileName = this.getSourceFileName();
    File file = new File(fileName);
    if (file.exists()) {
      LOGGER.debug("File:{} exists, appending to existing file...", file.getPath());
      this.readUserSourceCode(file);
      //LOGGER.debug ("User Source code:{}", this.userSourceBuf);
      this.userSourceBuf.toString();
    }

    FileWriter writer = new FileWriter(file);
    this.printSource(options);
    writer.write(sourceBuf.toString());
    writer.close();
    LOGGER.info("Class File created:" + file.getPath());
  }

  protected String getSourceFileName() {
    String path = "";
    if (!Strings.isNullOrEmpty(packageName)) {
      path = CharMatcher.anyOf(".").replaceFrom(this.packageName, "/") + "/";
    }
    if (!Strings.isNullOrEmpty(this.rootFolderPath)) {
      path = this.rootFolderPath + "/" + path;
    }

    String fileName = path + name + classSuffix + ".java";
    return fileName;
  }

  protected void readUserSourceCode(File file) {
    try {
      LOGGER.debug("Reading file :{}", file.getName());
      String contents = Files.asByteSource(file).asCharSource(Charset.defaultCharset()).read();

      int startIndex = contents.indexOf(IS_COMMENT_START);
      int endIndex = contents.indexOf(IS_COMMENT_END);
      LOGGER.debug("Start index:{} End index:{}", startIndex, endIndex);
      if (startIndex != -1 && endIndex != -1) {
        userSourceBuf.append(contents.substring(startIndex, endIndex));
        userSourceBuf.append(COMMENT_END + "\n\n");
      }
      // save the imports
      List<String> lines = Files.readLines(file, Charset.defaultCharset());
      for (String line : lines) {
        if (line.startsWith("import")) {
          String[] tokens = Iterables.toArray(Splitter.on(" ").split(line), String.class);
          if (tokens.length > 2) {
            String iClass = tokens[1] + " " + tokens[2].substring(0, tokens[2].length() - 1);
            LOGGER.debug("iClass:{}", iClass);
            if (!this.imports.contains(iClass)) {
              this.imports.add(iClass);
            }
          } else {
            String iClass = tokens[1].substring(0, tokens[1].length() - 1);
            if (!this.imports.contains(iClass)) {
              this.imports.add(iClass);
            }
          }
        }
      }

    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    } finally {

    }

  }

  protected void printUserSourceCode() {
    String userSource = this.userSourceBuf.toString();
    if (Strings.isNullOrEmpty(userSource)) {
      this.sourceBuf.append(COMMENT_START + "\n\n" + COMMENT_END + "\n\n");
    } else {
      this.sourceBuf.append(userSource);
    }

  }

  public void printPackage() {
    sourceBuf.append("package " + packageName + ";\n\n");
  }

  public void printImports() {
    imports.forEach(importClass -> sourceBuf.append("import " + importClass + ";\n"));
  }

  public void printClassComments() {
    sourceBuf.append("\n/**\n");
    sourceBuf.append(" * This class is generated by Jdbc code generator.\n");
    sourceBuf.append(" *\n");
    sourceBuf.append(" * @author Jdbc Code Generator\n");
    sourceBuf.append(" */\n");
  }

  public void printClassDefn(String className) {
    sourceBuf.append("public class " + className);
  }

  public void printClassExtends(List<String> extendsClassNames) {
    if (!extendsClassNames.isEmpty()) {
      sourceBuf.append(" extends ");
      Iterable<String> interfaceClasses = Iterables.transform(extendsClassNames,
              input -> input.substring(
                      CharMatcher.anyOf(".")
                              .lastIndexIn
                                      (input) + 1));
      sourceBuf.append(Joiner.on(",").join(interfaceClasses));
    }
  }

  public void printClassImplements(List<String> interfaceNames) {
    if (!interfaceNames.isEmpty()) {
      sourceBuf.append(" implements ");
      Iterable<String> interfaceClasses = Iterables.transform(interfaceNames,
              input -> input.substring(
                      CharMatcher.anyOf(".")
                              .lastIndexIn
                                      (input) + 1));
      sourceBuf.append(Joiner.on(",").join(interfaceClasses));
    }
  }

  public void printBlank(int blankNum) {
    for (int i = 0; i < blankNum; i ++) {
      sourceBuf.append(" ");
    }
  }

  public void printOpenBrace(int indentLevel, int newLines) {
    for (int i = 0; i < indentLevel; i++) {
      sourceBuf.append("\t");
    }
    sourceBuf.append("{");
    if (newLines == 0)
      newLines = 1; // add atleast 1 new line
    for (int i = 0; i < newLines; i++) {
      sourceBuf.append("\n");
    }
  }

  public void printCloseBrace(int indentLevel, int newLines) {
    for (int i = 0; i < indentLevel; i++) {
      sourceBuf.append("\t");
    }
    sourceBuf.append("}");
    for (int i = 0; i < newLines; i++) {
      sourceBuf.append("\n");
    }
  }

  public StringBuffer getSourceBuf() {
    return sourceBuf;
  }

  public List<String> getImports() {
    return imports;
  }

  public static String getCommentStart() {
    return COMMENT_START;
  }

  public static void setCommentStart(String commentStart) {
    COMMENT_START = commentStart;
  }

  public static String getCommentEnd() {
    return COMMENT_END;
  }

  public static void setCommentEnd(String commentEnd) {
    COMMENT_END = commentEnd;
  }

  public static String getIsCommentStart() {
    return IS_COMMENT_START;
  }

  public static void setIsCommentStart(String isCommentStart) {
    IS_COMMENT_START = isCommentStart;
  }

  public static String getIsCommentEnd() {
    return IS_COMMENT_END;
  }

  public static void setIsCommentEnd(String isCommentEnd) {
    IS_COMMENT_END = isCommentEnd;
  }

  public String getRootFolderPath() {
    return rootFolderPath;
  }

  public void setRootFolderPath(String rootFolderPath) {
    this.rootFolderPath = rootFolderPath;
  }

  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public String getClassSuffix() {
    return classSuffix;
  }

  public void setClassSuffix(String classSuffix) {
    this.classSuffix = classSuffix;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public StringBuffer getUserSourceBuf() {
    return userSourceBuf;
  }


  public abstract void printSource(CodegenOptions options);
}