package com.alibaba.fastjson.codegen;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public abstract class ClassGen {
    protected Class<?> clazz;
    private String indent;
    private int indentCount;
    protected Appendable out;
    protected Type type;

    public abstract void gen() throws IOException;

    public ClassGen(Class<?> clazz, Appendable out) {
        this(clazz, null, out);
    }

    public ClassGen(Class<?> clazz, Type type, Appendable out) {
        this.indent = "\t";
        this.indentCount = 0;
        this.clazz = clazz;
        this.type = type;
        this.out = out;
    }

    protected void println() throws IOException {
        this.out.append("\n");
        printIndent();
    }

    protected void println(String text) throws IOException {
        this.out.append(text);
        this.out.append("\n");
        printIndent();
    }

    protected void print(String text) throws IOException {
        this.out.append(text);
    }

    protected void printPackage() throws IOException {
        print("package ");
        print(this.clazz.getPackage().getName());
        println(";");
    }

    protected void beginClass(String className) throws IOException {
        print("public class ");
        print(className);
        print(" implements ObjectDeserializer {");
        incrementIndent();
        println();
    }

    protected void endClass() throws IOException {
        decrementIndent();
        println();
        print("}");
        println();
    }

    protected void genField(String name, Class<?> feildClass) throws IOException {
        if (feildClass == char[].class) {
            print("char[]");
        }
        print(" ");
        print(name);
        println(";");
    }

    protected void beginInit(String className) throws IOException {
        print("public ");
        print(className);
        println(" () {");
        incrementIndent();
    }

    protected void endInit() throws IOException {
        decrementIndent();
        print("}");
        println();
    }

    public void decrementIndent() {
        this.indentCount--;
    }

    public void incrementIndent() {
        this.indentCount++;
    }

    public void printIndent() throws IOException {
        for (int i = 0; i < this.indentCount; i++) {
            print(this.indent);
        }
    }

    protected void printClassName(Class<?> clazz) throws IOException {
        String name = clazz.getName();
        print(name.replace('$', '.'));
    }
}
