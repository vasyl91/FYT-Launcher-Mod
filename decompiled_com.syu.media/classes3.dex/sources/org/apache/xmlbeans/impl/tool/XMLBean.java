package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.taskdefs.Jar;
import org.apache.tools.ant.taskdefs.Javac;
import org.apache.tools.ant.taskdefs.MatchingTask;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.Path;
import org.apache.tools.ant.types.Reference;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.impl.common.IOUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XMLBean extends MatchingTask {
    private static final String JAVA = ".java";
    private static final String WSDL = ".wsdl";
    private static final String XSD = ".xsd";
    private static final String XSDCONFIG = ".xsdconfig";
    private String catalog;
    private File classgendir;
    private Path classpath;
    private String compiler;
    private boolean debug;
    private String debugLevel;
    private File destfile;
    private boolean download;
    private String forkedExecutable;
    private String javasource;
    private Set mdefnamespaces;
    private String memoryInitialSize;
    private String memoryMaximumSize;
    private boolean noSrcRegen;
    private boolean noann;
    private boolean nopvr;
    private boolean noupa;
    private boolean novdoc;
    private boolean optimize;
    private boolean quiet;
    private File schema;
    private File srcgendir;
    private boolean srconly;
    private String typesystemname;
    private boolean verbose;
    private ArrayList schemas = new ArrayList();
    private boolean noext = false;
    private boolean failonerror = true;
    private boolean fork = true;
    private boolean includeAntRuntime = true;
    private boolean includeJavaRuntime = false;
    private boolean nowarn = false;
    private List extensions = new ArrayList();
    private HashMap _extRouter = new HashMap(5);
    private String source = null;

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.tools.ant.BuildException */
    /* JADX WARN: Code duplicated, block: B:96:0x030d A[Catch: all -> 0x0309, BuildException -> 0x035a, TRY_LEAVE, TryCatch #1 {BuildException -> 0x035a, blocks: (B:47:0x0155, B:49:0x0159, B:54:0x0164, B:56:0x0168, B:57:0x0170, B:59:0x0174, B:60:0x017c, B:62:0x0180, B:63:0x018c, B:64:0x01a1, B:66:0x01a4, B:67:0x01b0, B:69:0x0228, B:71:0x022c, B:73:0x024a, B:74:0x024d, B:76:0x0256, B:77:0x0259, B:79:0x0271, B:81:0x0280, B:83:0x02a3, B:84:0x02a6, B:86:0x02aa, B:87:0x02ad, B:89:0x02c2, B:90:0x02e6, B:92:0x02ea, B:80:0x027a, B:96:0x030d, B:53:0x0160), top: B:116:0x0155 }] */
    public void execute() throws BuildException {
        boolean zCompile;
        if (this.schemas.size() == 0 && this.schema == null && this.fileset.getDir(this.project) == null) {
            if (this.failonerror) {
                throw new BuildException("The 'schema' or 'dir' attribute or a nested fileset is required.");
            }
            log("The 'schema' or 'dir' attribute or a nested fileset is required.", 0);
            return;
        }
        this._extRouter.put(XSD, new HashSet());
        this._extRouter.put(WSDL, new HashSet());
        this._extRouter.put(JAVA, new HashSet());
        this._extRouter.put(XSDCONFIG, new HashSet());
        File parentFile = this.schema;
        if (parentFile != null) {
            if (parentFile.isDirectory()) {
                DirectoryScanner directoryScanner = getDirectoryScanner(this.schema);
                processPaths(directoryScanner.getIncludedFiles(), directoryScanner.getBasedir());
            } else {
                parentFile = this.schema.getParentFile();
                processPaths(new String[]{this.schema.getName()}, parentFile);
            }
        }
        if (this.fileset.getDir(this.project) != null) {
            this.schemas.add(this.fileset);
        }
        Iterator it = this.schemas.iterator();
        while (it.hasNext()) {
            DirectoryScanner directoryScanner2 = ((FileSet) it.next()).getDirectoryScanner(this.project);
            processPaths(directoryScanner2.getIncludedFiles(), directoryScanner2.getBasedir());
        }
        Set set = (Set) this._extRouter.get(XSD);
        Set set2 = (Set) this._extRouter.get(WSDL);
        if (set.size() + set2.size() == 0) {
            log("Could not find any xsd or wsdl files to process.", 1);
            return;
        }
        Set set3 = (Set) this._extRouter.get(JAVA);
        Set set4 = (Set) this._extRouter.get(XSDCONFIG);
        if (this.srcgendir == null && this.srconly) {
            this.srcgendir = this.classgendir;
        }
        if (this.destfile == null && this.classgendir == null && !this.srconly) {
            this.destfile = new File("xmltypes.jar");
        }
        if (this.verbose) {
            this.quiet = false;
        }
        File[] fileArr = (File[]) set.toArray(new File[set.size()]);
        File[] fileArr2 = (File[]) set2.toArray(new File[set2.size()]);
        File[] fileArr3 = (File[]) set3.toArray(new File[set3.size()]);
        File[] fileArr4 = (File[]) set4.toArray(new File[set4.size()]);
        ErrorLogger errorLogger = new ErrorLogger(this.verbose);
        try {
            try {
                File fileCreateTempDir = (this.srcgendir == null || this.classgendir == null) ? SchemaCodeGenerator.createTempDir() : null;
                if (this.srcgendir == null) {
                    this.srcgendir = IOUtil.createDir(fileCreateTempDir, "src");
                }
                if (this.classgendir == null) {
                    this.classgendir = IOUtil.createDir(fileCreateTempDir, "classes");
                }
                if (this.classpath == null) {
                    Path path = new Path(this.project);
                    this.classpath = path;
                    path.concatSystemClasspath();
                }
                this.classpath.createPathElement().setLocation(this.classgendir);
                String[] list = this.classpath.list();
                File[] fileArr5 = new File[list.length];
                for (int i = 0; i < list.length; i++) {
                    fileArr5[i] = new File(list[i]);
                }
                SchemaCompiler.Parameters parameters = new SchemaCompiler.Parameters();
                parameters.setBaseDir(parentFile);
                parameters.setXsdFiles(fileArr);
                parameters.setWsdlFiles(fileArr2);
                parameters.setJavaFiles(fileArr3);
                parameters.setConfigFiles(fileArr4);
                parameters.setClasspath(fileArr5);
                parameters.setName(this.typesystemname);
                parameters.setSrcDir(this.srcgendir);
                parameters.setClassesDir(this.classgendir);
                parameters.setNojavac(true);
                parameters.setDebug(this.debug);
                parameters.setVerbose(this.verbose);
                parameters.setQuiet(this.quiet);
                parameters.setDownload(this.download);
                parameters.setExtensions(this.extensions);
                parameters.setErrorListener(errorLogger);
                parameters.setCatalogFile(this.catalog);
                parameters.setIncrementalSrcGen(this.noSrcRegen);
                parameters.setMdefNamespaces(this.mdefnamespaces);
                parameters.setNoUpa(this.noupa);
                parameters.setNoPvr(this.nopvr);
                parameters.setNoAnn(this.noann);
                parameters.setNoVDoc(this.novdoc);
                parameters.setNoExt(this.noext);
                parameters.setJavaSource(this.javasource);
                zCompile = SchemaCompiler.compile(parameters);
                if (zCompile) {
                    try {
                        if (!this.srconly) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            Javac javac = new Javac();
                            javac.setProject(this.project);
                            javac.setTaskName(getTaskName());
                            javac.setClasspath(this.classpath);
                            String str = this.compiler;
                            if (str != null) {
                                javac.setCompiler(str);
                            }
                            javac.setDebug(this.debug);
                            String str2 = this.debugLevel;
                            if (str2 != null) {
                                javac.setDebugLevel(str2);
                            }
                            javac.setDestdir(this.classgendir);
                            javac.setExecutable(this.forkedExecutable);
                            javac.setFailonerror(this.failonerror);
                            javac.setFork(this.fork);
                            String str3 = this.javasource;
                            if (str3 != null) {
                                javac.setSource(str3);
                                javac.setTarget(this.javasource);
                            } else {
                                javac.setSource("1.4");
                                javac.setTarget("1.4");
                            }
                            javac.setIncludeantruntime(this.includeAntRuntime);
                            javac.setIncludejavaruntime(this.includeJavaRuntime);
                            javac.setNowarn(this.nowarn);
                            javac.setSrcdir(new Path(this.project, this.srcgendir.getAbsolutePath()));
                            String str4 = this.memoryInitialSize;
                            if (str4 != null) {
                                javac.setMemoryInitialSize(str4);
                            }
                            String str5 = this.memoryMaximumSize;
                            if (str5 != null) {
                                javac.setMemoryMaximumSize(str5);
                            }
                            javac.setOptimize(this.optimize);
                            javac.setVerbose(this.verbose);
                            javac.execute();
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            if (!this.quiet) {
                                log("Time to compile code: " + ((jCurrentTimeMillis2 - jCurrentTimeMillis) / 1000.0d) + " seconds");
                            }
                            if (this.destfile != null) {
                                Jar jar = new Jar();
                                jar.setProject(this.project);
                                jar.setTaskName(getTaskName());
                                jar.setBasedir(this.classgendir);
                                jar.setDestFile(this.destfile);
                                jar.execute();
                            }
                        }
                        if (fileCreateTempDir != null) {
                            SchemaCodeGenerator.tryHardToDelete(fileCreateTempDir);
                        }
                    } catch (Throwable th) {
                        th = th;
                        if ((th instanceof InterruptedException) || this.failonerror) {
                            throw new BuildException(th);
                        }
                        log("Exception while building schemas: " + th.getMessage(), 0);
                        StringWriter stringWriter = new StringWriter();
                        th.printStackTrace(new PrintWriter(stringWriter));
                        log(stringWriter.toString(), 3);
                    }
                } else if (fileCreateTempDir != null) {
                    SchemaCodeGenerator.tryHardToDelete(fileCreateTempDir);
                }
            } catch (Throwable th2) {
                th = th2;
                zCompile = false;
            }
            if (!zCompile && this.failonerror) {
                throw new BuildException();
            }
        } catch (BuildException e) {
            throw e;
        }
    }

    private void processPaths(String[] strArr, File file) {
        for (int i = 0; i < strArr.length; i++) {
            int iLastIndexOf = strArr[i].lastIndexOf(46);
            if (iLastIndexOf > -1) {
                String str = strArr[i];
                Set set = (Set) this._extRouter.get(str.substring(iLastIndexOf).toLowerCase());
                if (set != null) {
                    set.add(new File(file, str));
                }
            }
        }
    }

    public void addFileset(FileSet fileSet) {
        this.schemas.add(fileSet);
    }

    public File getSchema() {
        return this.schema;
    }

    public void setSchema(File file) {
        this.schema = file;
    }

    public void setClasspath(Path path) {
        Path path2 = this.classpath;
        if (path2 != null) {
            path2.append(path);
        } else {
            this.classpath = path;
        }
    }

    public Path createClasspath() {
        if (this.classpath == null) {
            this.classpath = new Path(this.project);
        }
        return this.classpath.createPath();
    }

    public void setClasspathRef(Reference reference) {
        if (this.classpath == null) {
            this.classpath = new Path(this.project);
        }
        this.classpath.createPath().setRefid(reference);
    }

    public Path getClasspath() {
        return this.classpath;
    }

    public File getDestfile() {
        return this.destfile;
    }

    public void setDestfile(File file) {
        this.destfile = file;
    }

    public File getSrcgendir() {
        return this.srcgendir;
    }

    public void setSrcgendir(File file) {
        this.srcgendir = file;
    }

    public File getClassgendir() {
        return this.classgendir;
    }

    public void setClassgendir(File file) {
        this.classgendir = file;
    }

    public void setCompiler(String str) {
        this.compiler = str;
    }

    public boolean isDownload() {
        return this.download;
    }

    public void setDownload(boolean z) {
        this.download = z;
    }

    public void setOptimize(boolean z) {
        this.optimize = z;
    }

    public boolean getOptimize() {
        return this.optimize;
    }

    public boolean isVerbose() {
        return this.verbose;
    }

    public void setVerbose(boolean z) {
        this.verbose = z;
    }

    public boolean isQuiet() {
        return this.quiet;
    }

    public void setQuiet(boolean z) {
        this.quiet = z;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public String getDebugLevel() {
        return this.debugLevel;
    }

    public void setDebugLevel(String str) {
        this.debugLevel = str;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setFork(boolean z) {
        this.fork = z;
    }

    public void setExecutable(String str) {
        this.forkedExecutable = str;
    }

    public String getExecutable() {
        return this.forkedExecutable;
    }

    public boolean isSrconly() {
        return this.srconly;
    }

    public void setSrconly(boolean z) {
        this.srconly = z;
    }

    public String getTypesystemname() {
        return this.typesystemname;
    }

    public Extension createExtension() {
        Extension extension = new Extension();
        this.extensions.add(extension);
        return extension;
    }

    public void setIgnoreDuplicatesInNamespaces(String str) {
        this.mdefnamespaces = new HashSet();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreTokens()) {
            this.mdefnamespaces.add(stringTokenizer.nextToken().trim());
        }
    }

    public String getIgnoreDuplicatesInNamespaces() {
        if (this.mdefnamespaces == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.mdefnamespaces.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
            if (it.hasNext()) {
                stringBuffer.append(",");
            }
        }
        return stringBuffer.toString();
    }

    public void setTypesystemname(String str) {
        this.typesystemname = str;
    }

    public boolean isFailonerror() {
        return this.failonerror;
    }

    public void setFailonerror(boolean z) {
        this.failonerror = z;
    }

    public boolean isIncludeAntRuntime() {
        return this.includeAntRuntime;
    }

    public void setIncludeAntRuntime(boolean z) {
        this.includeAntRuntime = z;
    }

    public boolean isIncludeJavaRuntime() {
        return this.includeJavaRuntime;
    }

    public void setIncludeJavaRuntime(boolean z) {
        this.includeJavaRuntime = z;
    }

    public boolean isNowarn() {
        return this.nowarn;
    }

    public void setNowarn(boolean z) {
        this.nowarn = z;
    }

    public boolean isNoSrcRegen() {
        return this.noSrcRegen;
    }

    public void setNoSrcRegen(boolean z) {
        this.noSrcRegen = z;
    }

    public String getMemoryInitialSize() {
        return this.memoryInitialSize;
    }

    public void setMemoryInitialSize(String str) {
        this.memoryInitialSize = str;
    }

    public String getMemoryMaximumSize() {
        return this.memoryMaximumSize;
    }

    public void setMemoryMaximumSize(String str) {
        this.memoryMaximumSize = str;
    }

    public void setNoUpa(boolean z) {
        this.noupa = z;
    }

    public boolean isNoUpa() {
        return this.noupa;
    }

    public void setNoPvr(boolean z) {
        this.nopvr = z;
    }

    public boolean isNoPvr() {
        return this.nopvr;
    }

    public void setNoAnnotations(boolean z) {
        this.noann = z;
    }

    public boolean isNoAnnotations() {
        return this.noann;
    }

    public void setNoValidateDoc(boolean z) {
        this.novdoc = z;
    }

    public boolean isNoValidateDoc() {
        return this.novdoc;
    }

    public void setNoExt(boolean z) {
        this.noext = z;
    }

    public boolean isNoExt() {
        return this.noext;
    }

    public void setJavaSource(String str) {
        this.javasource = str;
    }

    public String getJavaSource() {
        return this.javasource;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String getCatalog() {
        return this.catalog;
    }

    public void setCatalog(String str) {
        this.catalog = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static URI uriFromFile(File file) {
        if (file == null) {
            return null;
        }
        try {
            return file.getCanonicalFile().toURI();
        } catch (IOException unused) {
            return file.getAbsoluteFile().toURI();
        }
    }

    public class ErrorLogger extends AbstractCollection {
        private URI _baseURI;
        private boolean _noisy;

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }

        public ErrorLogger(boolean z) {
            this._noisy = z;
            this._baseURI = XMLBean.uriFromFile(XMLBean.this.project.getBaseDir());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(Object obj) {
            if (obj instanceof XmlError) {
                XmlError xmlError = (XmlError) obj;
                if (xmlError.getSeverity() == 0) {
                    XMLBean.this.log(xmlError.toString(this._baseURI), 0);
                } else if (xmlError.getSeverity() == 1) {
                    XMLBean.this.log(xmlError.toString(this._baseURI), 1);
                } else if (this._noisy) {
                    XMLBean.this.log(xmlError.toString(this._baseURI), 2);
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return Collections.EMPTY_LIST.iterator();
        }
    }
}
