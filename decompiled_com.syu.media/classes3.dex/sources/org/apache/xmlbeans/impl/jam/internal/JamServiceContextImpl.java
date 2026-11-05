package org.apache.xmlbeans.impl.jam.internal;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.jam.JamServiceParams;
import org.apache.xmlbeans.impl.jam.annotation.AnnotationProxy;
import org.apache.xmlbeans.impl.jam.annotation.DefaultAnnotationProxy;
import org.apache.xmlbeans.impl.jam.annotation.JavadocTagParser;
import org.apache.xmlbeans.impl.jam.annotation.WhitespaceDelimitedTagParser;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
import org.apache.xmlbeans.impl.jam.provider.CompositeJamClassBuilder;
import org.apache.xmlbeans.impl.jam.provider.JamClassBuilder;
import org.apache.xmlbeans.impl.jam.provider.JamLogger;
import org.apache.xmlbeans.impl.jam.provider.JamServiceContext;
import org.apache.xmlbeans.impl.jam.provider.ResourcePath;
import org.apache.xmlbeans.impl.jam.visitor.CompositeMVisitor;
import org.apache.xmlbeans.impl.jam.visitor.MVisitor;
import org.apache.xmlbeans.impl.jam.visitor.PropertyInitializer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class JamServiceContextImpl extends JamLoggerImpl implements JamServiceContext, JamServiceParams, ElementContext {
    private static final char INNER_CLASS_SEPARATOR = '$';
    private static final String PREFIX = "[JamServiceContextImpl] ";
    private boolean m14WarningsEnabled = false;
    private Properties mProperties = null;
    private Map mSourceRoot2Scanner = null;
    private Map mClassRoot2Scanner = null;
    private List mClasspath = null;
    private List mSourcepath = null;
    private List mToolClasspath = null;
    private List mIncludeClasses = null;
    private List mExcludeClasses = null;
    private boolean mUseSystemClasspath = true;
    private JavadocTagParser mTagParser = null;
    private MVisitor mCommentInitializer = null;
    private MVisitor mPropertyInitializer = new PropertyInitializer();
    private List mOtherInitializers = null;
    private List mUnstructuredSourceFiles = null;
    private List mClassLoaders = null;
    private List mBaseBuilders = null;
    private JamClassLoader mLoader = null;

    @Override // org.apache.xmlbeans.impl.jam.provider.JamServiceContext, org.apache.xmlbeans.impl.jam.internal.elements.ElementContext
    public JamLogger getLogger() {
        return this;
    }

    public void setClassLoader(JamClassLoader jamClassLoader) {
        this.mLoader = jamClassLoader;
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamServiceContext
    public JamClassBuilder getBaseBuilder() {
        List list = this.mBaseBuilders;
        if (list == null || list.size() == 0) {
            return null;
        }
        if (this.mBaseBuilders.size() == 1) {
            return (JamClassBuilder) this.mBaseBuilders.get(0);
        }
        JamClassBuilder[] jamClassBuilderArr = new JamClassBuilder[this.mBaseBuilders.size()];
        this.mBaseBuilders.toArray(jamClassBuilderArr);
        return new CompositeJamClassBuilder(jamClassBuilderArr);
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamServiceContext
    public JavadocTagParser getTagParser() {
        if (this.mTagParser == null) {
            WhitespaceDelimitedTagParser whitespaceDelimitedTagParser = new WhitespaceDelimitedTagParser();
            this.mTagParser = whitespaceDelimitedTagParser;
            whitespaceDelimitedTagParser.init(this);
        }
        return this.mTagParser;
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamServiceContext
    public String[] getAllClassnames() throws IOException {
        HashSet hashSet = new HashSet();
        List list = this.mIncludeClasses;
        if (list != null) {
            hashSet.addAll(list);
        }
        Iterator allDirectoryScanners = getAllDirectoryScanners();
        while (allDirectoryScanners.hasNext()) {
            String[] includedFiles = ((DirectoryScanner) allDirectoryScanners.next()).getIncludedFiles();
            for (int i = 0; i < includedFiles.length; i++) {
                if (includedFiles[i].indexOf(36) == -1) {
                    hashSet.add(filename2classname(includedFiles[i]));
                }
            }
        }
        List list2 = this.mExcludeClasses;
        if (list2 != null) {
            hashSet.removeAll(list2);
        }
        String[] strArr = new String[hashSet.size()];
        hashSet.toArray(strArr);
        return strArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamServiceContext
    public File[] getSourceFiles() throws IOException {
        HashSet hashSet = new HashSet();
        Map map = this.mSourceRoot2Scanner;
        if (map != null) {
            for (DirectoryScanner directoryScanner : map.values()) {
                if (isVerbose(this)) {
                    verbose("[JamServiceContextImpl]  checking scanner for dir" + directoryScanner.getRoot());
                }
                String[] includedFiles = directoryScanner.getIncludedFiles();
                for (int i = 0; i < includedFiles.length; i++) {
                    if (isVerbose(this)) {
                        verbose("[JamServiceContextImpl]  ...including a source file " + includedFiles[i]);
                    }
                    hashSet.add(new File(directoryScanner.getRoot(), includedFiles[i]));
                }
            }
        }
        if (this.mUnstructuredSourceFiles != null) {
            if (isVerbose(this)) {
                verbose("[JamServiceContextImpl] adding " + this.mUnstructuredSourceFiles.size() + " other source files");
            }
            hashSet.addAll(this.mUnstructuredSourceFiles);
        }
        File[] fileArr = new File[hashSet.size()];
        hashSet.toArray(fileArr);
        return fileArr;
    }

    public File[] getUnstructuredSourceFiles() {
        List list = this.mUnstructuredSourceFiles;
        if (list == null) {
            return null;
        }
        File[] fileArr = new File[list.size()];
        this.mUnstructuredSourceFiles.toArray(fileArr);
        return fileArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamServiceContext
    public ResourcePath getInputClasspath() {
        return createJPath(this.mClasspath);
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamServiceContext
    public ResourcePath getInputSourcepath() {
        return createJPath(this.mSourcepath);
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamServiceContext
    public ResourcePath getToolClasspath() {
        return createJPath(this.mToolClasspath);
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamServiceContext
    public String getProperty(String str) {
        Properties properties = this.mProperties;
        if (properties == null) {
            return null;
        }
        return properties.getProperty(str);
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamServiceContext
    public MVisitor getInitializer() {
        ArrayList arrayList = new ArrayList();
        MVisitor mVisitor = this.mCommentInitializer;
        if (mVisitor != null) {
            arrayList.add(mVisitor);
        }
        MVisitor mVisitor2 = this.mPropertyInitializer;
        if (mVisitor2 != null) {
            arrayList.add(mVisitor2);
        }
        List list = this.mOtherInitializers;
        if (list != null) {
            arrayList.addAll(list);
        }
        MVisitor[] mVisitorArr = new MVisitor[arrayList.size()];
        arrayList.toArray(mVisitorArr);
        return new CompositeMVisitor(mVisitorArr);
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void addClassBuilder(JamClassBuilder jamClassBuilder) {
        if (this.mBaseBuilders == null) {
            this.mBaseBuilders = new ArrayList();
        }
        this.mBaseBuilders.add(jamClassBuilder);
    }

    public void setCommentInitializer(MVisitor mVisitor) {
        this.mCommentInitializer = mVisitor;
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void setPropertyInitializer(MVisitor mVisitor) {
        this.mPropertyInitializer = mVisitor;
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void addInitializer(MVisitor mVisitor) {
        if (this.mOtherInitializers == null) {
            this.mOtherInitializers = new ArrayList();
        }
        this.mOtherInitializers.add(mVisitor);
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void setJavadocTagParser(JavadocTagParser javadocTagParser) {
        this.mTagParser = javadocTagParser;
        javadocTagParser.init(this);
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void includeSourceFile(File file) {
        if (file == null) {
            throw new IllegalArgumentException("null file");
        }
        File absoluteFile = file.getAbsoluteFile();
        if (isVerbose(this)) {
            verbose("[JamServiceContextImpl] adding source ");
        }
        if (!absoluteFile.exists()) {
            throw new IllegalArgumentException(absoluteFile + " does not exist");
        }
        if (absoluteFile.isDirectory()) {
            throw new IllegalArgumentException(absoluteFile + " cannot be included as a source file because it is a directory.");
        }
        if (this.mUnstructuredSourceFiles == null) {
            this.mUnstructuredSourceFiles = new ArrayList();
        }
        this.mUnstructuredSourceFiles.add(absoluteFile.getAbsoluteFile());
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void includeSourcePattern(File[] fileArr, String str) {
        if (fileArr == null) {
            throw new IllegalArgumentException("null sourcepath");
        }
        if (fileArr.length == 0) {
            throw new IllegalArgumentException("empty sourcepath");
        }
        if (str == null) {
            throw new IllegalArgumentException("null pattern");
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            throw new IllegalArgumentException("empty pattern");
        }
        for (int i = 0; i < fileArr.length; i++) {
            if (isVerbose(this)) {
                verbose("[JamServiceContextImpl] including '" + strTrim + "' under " + fileArr[i]);
            }
            addSourcepath(fileArr[i]);
            getSourceScanner(fileArr[i]).include(strTrim);
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void includeClassPattern(File[] fileArr, String str) {
        if (fileArr == null) {
            throw new IllegalArgumentException("null classpath");
        }
        if (fileArr.length == 0) {
            throw new IllegalArgumentException("empty classpath");
        }
        if (str == null) {
            throw new IllegalArgumentException("null pattern");
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            throw new IllegalArgumentException("empty pattern");
        }
        for (int i = 0; i < fileArr.length; i++) {
            if (isVerbose(this)) {
                verbose("[JamServiceContextImpl] including '" + strTrim + "' under " + fileArr[i]);
            }
            addClasspath(fileArr[i]);
            getClassScanner(fileArr[i]).include(strTrim);
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void excludeSourcePattern(File[] fileArr, String str) {
        if (fileArr == null) {
            throw new IllegalArgumentException("null sourcepath");
        }
        if (fileArr.length == 0) {
            throw new IllegalArgumentException("empty sourcepath");
        }
        if (str == null) {
            throw new IllegalArgumentException("null pattern");
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            throw new IllegalArgumentException("empty pattern");
        }
        for (int i = 0; i < fileArr.length; i++) {
            if (isVerbose(this)) {
                verbose("[JamServiceContextImpl] EXCLUDING '" + strTrim + "' under " + fileArr[i]);
            }
            addSourcepath(fileArr[i]);
            getSourceScanner(fileArr[i]).exclude(strTrim);
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void excludeClassPattern(File[] fileArr, String str) {
        if (fileArr == null) {
            throw new IllegalArgumentException("null classpath");
        }
        if (fileArr.length == 0) {
            throw new IllegalArgumentException("empty classpath");
        }
        if (str == null) {
            throw new IllegalArgumentException("null pattern");
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            throw new IllegalArgumentException("empty pattern");
        }
        for (int i = 0; i < fileArr.length; i++) {
            if (isVerbose(this)) {
                verbose("[JamServiceContextImpl] EXCLUDING '" + strTrim + "' under " + fileArr[i]);
            }
            addClasspath(fileArr[i]);
            getClassScanner(fileArr[i]).exclude(strTrim);
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void includeSourceFile(File[] fileArr, File file) {
        File pathRootForFile = getPathRootForFile(fileArr, file);
        includeSourcePattern(new File[]{pathRootForFile}, source2pattern(pathRootForFile, file));
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void excludeSourceFile(File[] fileArr, File file) {
        File pathRootForFile = getPathRootForFile(fileArr, file);
        excludeSourcePattern(new File[]{pathRootForFile}, source2pattern(pathRootForFile, file));
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void includeClassFile(File[] fileArr, File file) {
        File pathRootForFile = getPathRootForFile(fileArr, file);
        includeClassPattern(new File[]{pathRootForFile}, source2pattern(pathRootForFile, file));
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void excludeClassFile(File[] fileArr, File file) {
        File pathRootForFile = getPathRootForFile(fileArr, file);
        excludeClassPattern(new File[]{pathRootForFile}, source2pattern(pathRootForFile, file));
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void includeClass(String str) {
        if (this.mIncludeClasses == null) {
            this.mIncludeClasses = new ArrayList();
        }
        this.mIncludeClasses.add(str);
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void excludeClass(String str) {
        if (this.mExcludeClasses == null) {
            this.mExcludeClasses = new ArrayList();
        }
        this.mExcludeClasses.add(str);
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void addClasspath(File file) {
        List list = this.mClasspath;
        if (list == null) {
            this.mClasspath = new ArrayList();
        } else if (list.contains(file)) {
            return;
        }
        this.mClasspath.add(file);
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void setLoggerWriter(PrintWriter printWriter) {
        super.setOut(printWriter);
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void setJamLogger(JamLogger jamLogger) {
        throw new IllegalStateException("NYI");
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void addSourcepath(File file) {
        List list = this.mSourcepath;
        if (list == null) {
            this.mSourcepath = new ArrayList();
        } else if (list.contains(file)) {
            return;
        }
        this.mSourcepath.add(file);
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void addToolClasspath(File file) {
        List list = this.mToolClasspath;
        if (list == null) {
            this.mToolClasspath = new ArrayList();
        } else if (list.contains(file)) {
            return;
        }
        this.mToolClasspath.add(file);
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void setProperty(String str, String str2) {
        if (this.mProperties == null) {
            this.mProperties = new Properties();
        }
        this.mProperties.setProperty(str, str2);
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void set14WarningsEnabled(boolean z) {
        this.m14WarningsEnabled = z;
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void setParentClassLoader(JamClassLoader jamClassLoader) {
        throw new IllegalStateException("NYI");
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void setUseSystemClasspath(boolean z) {
        this.mUseSystemClasspath = z;
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceParams
    public void addClassLoader(ClassLoader classLoader) {
        if (this.mClassLoaders == null) {
            this.mClassLoaders = new ArrayList();
        }
        this.mClassLoaders.add(classLoader);
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamServiceContext
    public ClassLoader[] getReflectionClassLoaders() {
        List list = this.mClassLoaders;
        if (list == null) {
            return this.mUseSystemClasspath ? new ClassLoader[]{ClassLoader.getSystemClassLoader()} : new ClassLoader[0];
        }
        int size = list.size() + (this.mUseSystemClasspath ? 1 : 0);
        ClassLoader[] classLoaderArr = new ClassLoader[size];
        for (int i = 0; i < this.mClassLoaders.size(); i++) {
            classLoaderArr[i] = (ClassLoader) this.mClassLoaders.get(i);
        }
        if (this.mUseSystemClasspath) {
            classLoaderArr[size - 1] = ClassLoader.getSystemClassLoader();
        }
        return classLoaderArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamServiceContext
    public boolean is14WarningsEnabled() {
        return this.m14WarningsEnabled;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.ElementContext
    public JamClassLoader getClassLoader() {
        return this.mLoader;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.ElementContext
    public AnnotationProxy createAnnotationProxy(String str) {
        DefaultAnnotationProxy defaultAnnotationProxy = new DefaultAnnotationProxy();
        defaultAnnotationProxy.init(this);
        return defaultAnnotationProxy;
    }

    private File getPathRootForFile(File[] fileArr, File file) {
        if (fileArr == null) {
            throw new IllegalArgumentException("null sourcepath");
        }
        if (fileArr.length == 0) {
            throw new IllegalArgumentException("empty sourcepath");
        }
        if (file == null) {
            throw new IllegalArgumentException("null sourceFile");
        }
        File absoluteFile = file.getAbsoluteFile();
        if (isVerbose(this)) {
            verbose("[JamServiceContextImpl] Getting root for " + absoluteFile + "...");
        }
        for (int i = 0; i < fileArr.length; i++) {
            if (isVerbose(this)) {
                verbose("[JamServiceContextImpl] ...looking in " + fileArr[i]);
            }
            if (isContainingDir(fileArr[i].getAbsoluteFile(), absoluteFile)) {
                if (isVerbose(this)) {
                    verbose("[JamServiceContextImpl] ...found it!");
                }
                return fileArr[i].getAbsoluteFile();
            }
        }
        throw new IllegalArgumentException(absoluteFile + " is not in the given path.");
    }

    private boolean isContainingDir(File file, File file2) {
        if (isVerbose(this)) {
            verbose("[JamServiceContextImpl] ... ...isContainingDir " + file + "  " + file2);
        }
        if (file2 == null) {
            return false;
        }
        if (file.equals(file2)) {
            if (!isVerbose(this)) {
                return true;
            }
            verbose("[JamServiceContextImpl] ... ...yes!");
            return true;
        }
        return isContainingDir(file, file2.getParentFile());
    }

    private String source2pattern(File file, File file2) {
        if (isVerbose(this)) {
            verbose("[JamServiceContextImpl] source2pattern " + file + "  " + file2);
        }
        String absolutePath = file.getAbsolutePath();
        String absolutePath2 = file2.getAbsolutePath();
        if (isVerbose(this)) {
            verbose("[JamServiceContextImpl] source2pattern returning " + absolutePath2.substring(absolutePath.length() + 1));
        }
        return absolutePath2.substring(absolutePath.length() + 1);
    }

    private static String filename2classname(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            str = str.substring(0, iLastIndexOf);
        }
        return str.replace('/', NameUtil.PERIOD).replace('\\', NameUtil.PERIOD);
    }

    private Iterator getAllDirectoryScanners() {
        ArrayList arrayList = new ArrayList();
        Map map = this.mSourceRoot2Scanner;
        if (map != null) {
            arrayList.addAll(map.values());
        }
        Map map2 = this.mClassRoot2Scanner;
        if (map2 != null) {
            arrayList.addAll(map2.values());
        }
        return arrayList.iterator();
    }

    private static ResourcePath createJPath(Collection collection) {
        if (collection == null || collection.size() == 0) {
            return null;
        }
        File[] fileArr = new File[collection.size()];
        collection.toArray(fileArr);
        return ResourcePath.forFiles(fileArr);
    }

    private DirectoryScanner getSourceScanner(File file) {
        if (this.mSourceRoot2Scanner == null) {
            this.mSourceRoot2Scanner = new HashMap();
        }
        DirectoryScanner directoryScanner = (DirectoryScanner) this.mSourceRoot2Scanner.get(file);
        if (directoryScanner != null) {
            return directoryScanner;
        }
        Map map = this.mSourceRoot2Scanner;
        DirectoryScanner directoryScanner2 = new DirectoryScanner(file, this);
        map.put(file, directoryScanner2);
        return directoryScanner2;
    }

    private DirectoryScanner getClassScanner(File file) {
        if (this.mClassRoot2Scanner == null) {
            this.mClassRoot2Scanner = new HashMap();
        }
        DirectoryScanner directoryScanner = (DirectoryScanner) this.mClassRoot2Scanner.get(file);
        if (directoryScanner != null) {
            return directoryScanner;
        }
        Map map = this.mClassRoot2Scanner;
        DirectoryScanner directoryScanner2 = new DirectoryScanner(file, this);
        map.put(file, directoryScanner2);
        return directoryScanner2;
    }
}
