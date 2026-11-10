package org.apache.xmlbeans.impl.jam;

import java.io.File;
import java.io.PrintWriter;
import org.apache.xmlbeans.impl.jam.annotation.JavadocTagParser;
import org.apache.xmlbeans.impl.jam.provider.JamClassBuilder;
import org.apache.xmlbeans.impl.jam.provider.JamLogger;
import org.apache.xmlbeans.impl.jam.visitor.MVisitor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface JamServiceParams {
    void addClassBuilder(JamClassBuilder jamClassBuilder);

    void addClassLoader(ClassLoader classLoader);

    void addClasspath(File file);

    void addInitializer(MVisitor mVisitor);

    void addSourcepath(File file);

    void addToolClasspath(File file);

    void excludeClass(String str);

    void excludeClassFile(File[] fileArr, File file);

    void excludeClassPattern(File[] fileArr, String str);

    void excludeSourceFile(File[] fileArr, File file);

    void excludeSourcePattern(File[] fileArr, String str);

    void includeClass(String str);

    void includeClassFile(File[] fileArr, File file);

    void includeClassPattern(File[] fileArr, String str);

    void includeSourceFile(File file);

    void includeSourceFile(File[] fileArr, File file);

    void includeSourcePattern(File[] fileArr, String str);

    void set14WarningsEnabled(boolean z);

    void setJamLogger(JamLogger jamLogger);

    void setJavadocTagParser(JavadocTagParser javadocTagParser);

    void setLoggerWriter(PrintWriter printWriter);

    void setParentClassLoader(JamClassLoader jamClassLoader);

    void setProperty(String str, String str2);

    void setPropertyInitializer(MVisitor mVisitor);

    void setShowWarnings(boolean z);

    void setUseSystemClasspath(boolean z);

    void setVerbose(Class cls);

    void setVerbose(boolean z);
}
