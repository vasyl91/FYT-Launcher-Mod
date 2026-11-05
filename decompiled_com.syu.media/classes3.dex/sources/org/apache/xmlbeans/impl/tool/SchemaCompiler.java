package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.apache.xmlbeans.ResourceLoader;
import org.apache.xmlbeans.SchemaCodePrinter;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.apache.xmlbeans.impl.common.JarHelper;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.common.ResolverUtil;
import org.apache.xmlbeans.impl.common.XmlErrorWatcher;
import org.apache.xmlbeans.impl.config.BindingConfigImpl;
import org.apache.xmlbeans.impl.repackage.Repackager;
import org.apache.xmlbeans.impl.schema.PathResourceLoader;
import org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeSystemCompiler;
import org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl;
import org.apache.xmlbeans.impl.schema.StscState;
import org.apache.xmlbeans.impl.util.FilerImpl;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument;
import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.xml.sax.EntityResolver;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SchemaCompiler {
    private static final String COMPATIBILITY_CONFIG_URI = "http://www.bea.com/2002/09/xbean/config";
    private static final String CONFIG_URI = "http://xml.apache.org/xmlbeans/2004/02/xbean/config";
    private static final Map MAP_COMPATIBILITY_CONFIG_URIS;

    public static void printUsage() {
        System.out.println("Compiles a schema into XML Bean classes and metadata.");
        System.out.println("Usage: scomp [opts] [dirs]* [schema.xsd]* [service.wsdl]* [config.xsdconfig]*");
        System.out.println("Options include:");
        System.out.println("    -cp [a;b;c] - classpath");
        System.out.println("    -d [dir] - target binary directory for .class and .xsb files");
        System.out.println("    -src [dir] - target directory for generated .java files");
        System.out.println("    -srconly - do not compile .java files or jar the output.");
        System.out.println("    -out [xmltypes.jar] - the name of the output jar");
        System.out.println("    -dl - permit network downloads for imports and includes (default is off)");
        System.out.println("    -noupa - do not enforce the unique particle attribution rule");
        System.out.println("    -nopvr - do not enforce the particle valid (restriction) rule");
        System.out.println("    -noann - ignore annotations");
        System.out.println("    -novdoc - do not validate contents of <documentation>");
        System.out.println("    -noext - ignore all extension (Pre/Post and Interface) found in .xsdconfig files");
        System.out.println("    -compiler - path to external java compiler");
        System.out.println("    -javasource [version] - generate java source compatible for a Java version (1.4 or 1.5)");
        System.out.println("    -ms - initial memory for external java compiler (default '" + CodeGenUtil.DEFAULT_MEM_START + "')");
        System.out.println("    -mx - maximum memory for external java compiler (default '" + CodeGenUtil.DEFAULT_MEM_MAX + "')");
        System.out.println("    -debug - compile with debug symbols");
        System.out.println("    -quiet - print fewer informational messages");
        System.out.println("    -verbose - print more informational messages");
        System.out.println("    -version - prints version information");
        System.out.println("    -license - prints license information");
        System.out.println("    -allowmdef \"[ns] [ns] [ns]\" - ignores multiple defs in given namespaces (use ##local for no-namespace)");
        System.out.println("    -catalog [file] -  catalog file for org.apache.xml.resolver.tools.CatalogResolver. (Note: needs resolver.jar from http://xml.apache.org/commons/components/resolver/index.html)");
        System.out.println();
    }

    /* JADX WARN: Code duplicated, block: B:107:0x027e  */
    /* JADX WARN: Code duplicated, block: B:109:0x028a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0298  */
    /* JADX WARN: Code duplicated, block: B:114:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:115:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:118:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:119:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:134:0x030d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:138:0x0315  */
    /* JADX WARN: Code duplicated, block: B:139:0x031b  */
    /* JADX WARN: Code duplicated, block: B:141:0x031e  */
    /* JADX WARN: Code duplicated, block: B:143:0x0324  */
    /* JADX WARN: Code duplicated, block: B:146:0x0332  */
    /* JADX WARN: Code duplicated, block: B:149:0x0341 A[LOOP:2: B:147:0x033e->B:149:0x0341, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:151:0x0363  */
    /* JADX WARN: Code duplicated, block: B:154:0x037d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:158:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:161:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:162:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:165:0x0471  */
    /* JADX WARN: Code duplicated, block: B:167:0x0476  */
    /* JADX WARN: Code duplicated, block: B:182:0x02e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void main(String[] strArr) {
        SchemaCodePrinter schemaCodePrinter;
        Set set;
        String str;
        boolean z;
        boolean z2;
        String opt;
        File fileCreateDir;
        String opt2;
        File fileCreateDir2;
        File fileCreateTempDir;
        File file;
        String opt3;
        File file2;
        File[] fileArrSystemClasspath;
        File[] fileArrFilesEndingWith;
        File[] fileArrFilesEndingWith2;
        URL[] uRLs;
        File baseDir;
        URI uri;
        boolean zCompile;
        String[] strArrSplit;
        ArrayList arrayList;
        int i;
        Extension extension;
        StringTokenizer stringTokenizer;
        int iIndexOf;
        if (strArr.length == 0) {
            printUsage();
            System.exit(0);
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add("quiet");
        hashSet.add("verbose");
        hashSet.add("version");
        hashSet.add("dl");
        hashSet.add("noupa");
        hashSet.add("nopvr");
        hashSet.add("noann");
        hashSet.add("novdoc");
        hashSet.add("noext");
        hashSet.add("srconly");
        hashSet.add("debug");
        HashSet hashSet2 = new HashSet();
        hashSet2.add("out");
        hashSet2.add("name");
        hashSet2.add("src");
        hashSet2.add("d");
        hashSet2.add("cp");
        hashSet2.add("compiler");
        hashSet2.add("javasource");
        hashSet2.add("jar");
        hashSet2.add("ms");
        hashSet2.add("mx");
        hashSet2.add("repackage");
        hashSet2.add("schemaCodePrinter");
        hashSet2.add("extension");
        hashSet2.add("extensionParms");
        hashSet2.add("allowmdef");
        hashSet2.add("catalog");
        CommandLine commandLine = new CommandLine(strArr, hashSet, hashSet2);
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
            printUsage();
            System.exit(0);
            return;
        }
        String[] badOpts = commandLine.getBadOpts();
        if (badOpts.length > 0) {
            for (String str2 : badOpts) {
                System.out.println("Unrecognized option: " + str2);
            }
            printUsage();
            System.exit(0);
            return;
        }
        if (commandLine.getOpt("license") != null) {
            CommandLine.printLicense();
            System.exit(0);
            return;
        }
        if (commandLine.getOpt("version") != null) {
            CommandLine.printVersion();
            System.exit(0);
            return;
        }
        commandLine.args();
        boolean z3 = commandLine.getOpt("verbose") != null;
        boolean z4 = z3 ? false : commandLine.getOpt("quiet") != null;
        if (z3) {
            CommandLine.printVersion();
        }
        String opt4 = commandLine.getOpt("out");
        String opt5 = commandLine.getOpt("repackage");
        String opt6 = commandLine.getOpt("schemaCodePrinter");
        if (opt6 != null) {
            try {
                schemaCodePrinter = (SchemaCodePrinter) Class.forName(opt6).newInstance();
            } catch (Exception unused) {
                System.err.println("Failed to load SchemaCodePrinter class " + opt6 + "; proceeding with default printer");
                schemaCodePrinter = null;
            }
        } else {
            schemaCodePrinter = null;
        }
        String opt7 = commandLine.getOpt("name");
        boolean z5 = commandLine.getOpt("dl") != null;
        boolean z6 = commandLine.getOpt("noupa") != null;
        boolean z7 = commandLine.getOpt("nopvr") != null;
        boolean z8 = commandLine.getOpt("noann") != null;
        boolean z9 = commandLine.getOpt("novdoc") != null;
        boolean z10 = commandLine.getOpt("noext") != null;
        boolean z11 = commandLine.getOpt("srconly") != null;
        boolean z12 = commandLine.getOpt("debug") != null;
        String opt8 = commandLine.getOpt("allowmdef");
        Set hashSet3 = opt8 == null ? Collections.EMPTY_SET : new HashSet(Arrays.asList(XmlListImpl.split_list(opt8)));
        SchemaCodePrinter schemaCodePrinter2 = schemaCodePrinter;
        ArrayList arrayList2 = new ArrayList();
        if (commandLine.getOpt("extension") != null) {
            set = hashSet3;
            try {
                Extension extension2 = new Extension();
                str = opt5;
                try {
                    z2 = z10;
                    try {
                        z = z9;
                        try {
                            extension2.setClassName(Class.forName(commandLine.getOpt("extension"), false, Thread.currentThread().getContextClassLoader()));
                            arrayList2.add(extension2);
                        } catch (ClassNotFoundException unused2) {
                            System.err.println("Could not find extension class: " + commandLine.getOpt("extension") + "  Is it on your classpath?");
                            System.exit(1);
                        }
                    } catch (ClassNotFoundException unused3) {
                        z = z9;
                    }
                } catch (ClassNotFoundException unused4) {
                    z = z9;
                    z2 = z10;
                    System.err.println("Could not find extension class: " + commandLine.getOpt("extension") + "  Is it on your classpath?");
                    System.exit(1);
                    if (arrayList2.size() > 0) {
                        extension = (Extension) arrayList2.get(0);
                        for (stringTokenizer = new StringTokenizer(commandLine.getOpt("extensionParms"), ";"); stringTokenizer.hasMoreTokens(); stringTokenizer = stringTokenizer) {
                            String strNextToken = stringTokenizer.nextToken();
                            iIndexOf = strNextToken.indexOf(61);
                            if (iIndexOf < 0) {
                                System.err.println("extensionParms should be name=value;name=value");
                                System.exit(1);
                            }
                            String strSubstring = strNextToken.substring(0, iIndexOf);
                            String strSubstring2 = strNextToken.substring(iIndexOf + 1);
                            Extension.Param paramCreateParam = extension.createParam();
                            paramCreateParam.setName(strSubstring);
                            paramCreateParam.setValue(strSubstring2);
                        }
                    }
                    opt = commandLine.getOpt("d");
                    if (opt != null) {
                        fileCreateDir = new File(opt);
                    } else {
                        fileCreateDir = null;
                    }
                    opt2 = commandLine.getOpt(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x02c5: INVOKE (r0v42 'opt2' java.lang.String) = (r14v16 'commandLine' org.apache.xmlbeans.impl.tool.CommandLine), (r20v0 java.lang.String) VIRTUAL call: org.apache.xmlbeans.impl.tool.CommandLine.getOpt(java.lang.String):java.lang.String A[MD:(java.lang.String):java.lang.String (m)] (LINE:265) in method: org.apache.xmlbeans.impl.tool.SchemaCompiler.main(java.lang.String[]):void, file: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:383)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:331)
                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r20v0 java.lang.String
                        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                        */
                    /*
                        Method dump skipped, instruction units count: 1159
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.tool.SchemaCompiler.main(java.lang.String[]):void");
                }

                public static class Parameters {
                    private File baseDir;
                    private String catalogFile;
                    private File classesDir;
                    private File[] classpath;
                    private String compiler;
                    private File[] configFiles;
                    private boolean debug;
                    private boolean download;
                    private EntityResolver entityResolver;
                    private Collection errorListener;
                    private boolean incrementalSrcGen;
                    private File[] javaFiles;
                    private String javasource;
                    private String memoryInitialSize;
                    private String memoryMaximumSize;
                    private String name;
                    private boolean noAnn;
                    private boolean noExt;
                    private boolean noPvr;
                    private boolean noUpa;
                    private boolean noVDoc;
                    private boolean nojavac;
                    private File outputJar;
                    private boolean quiet;
                    private String repackage;
                    private SchemaCodePrinter schemaCodePrinter;
                    private File srcDir;
                    private URL[] urlFiles;
                    private boolean verbose;
                    private File[] wsdlFiles;
                    private File[] xsdFiles;
                    private List extensions = Collections.EMPTY_LIST;
                    private Set mdefNamespaces = Collections.EMPTY_SET;

                    public String getJar() {
                        return null;
                    }

                    public void setJar(String str) {
                    }

                    public File getBaseDir() {
                        return this.baseDir;
                    }

                    public void setBaseDir(File file) {
                        this.baseDir = file;
                    }

                    public File[] getXsdFiles() {
                        return this.xsdFiles;
                    }

                    public void setXsdFiles(File[] fileArr) {
                        this.xsdFiles = fileArr;
                    }

                    public File[] getWsdlFiles() {
                        return this.wsdlFiles;
                    }

                    public void setWsdlFiles(File[] fileArr) {
                        this.wsdlFiles = fileArr;
                    }

                    public File[] getJavaFiles() {
                        return this.javaFiles;
                    }

                    public void setJavaFiles(File[] fileArr) {
                        this.javaFiles = fileArr;
                    }

                    public File[] getConfigFiles() {
                        return this.configFiles;
                    }

                    public void setConfigFiles(File[] fileArr) {
                        this.configFiles = fileArr;
                    }

                    public URL[] getUrlFiles() {
                        return this.urlFiles;
                    }

                    public void setUrlFiles(URL[] urlArr) {
                        this.urlFiles = urlArr;
                    }

                    public File[] getClasspath() {
                        return this.classpath;
                    }

                    public void setClasspath(File[] fileArr) {
                        this.classpath = fileArr;
                    }

                    public File getOutputJar() {
                        return this.outputJar;
                    }

                    public void setOutputJar(File file) {
                        this.outputJar = file;
                    }

                    public String getName() {
                        return this.name;
                    }

                    public void setName(String str) {
                        this.name = str;
                    }

                    public File getSrcDir() {
                        return this.srcDir;
                    }

                    public void setSrcDir(File file) {
                        this.srcDir = file;
                    }

                    public File getClassesDir() {
                        return this.classesDir;
                    }

                    public void setClassesDir(File file) {
                        this.classesDir = file;
                    }

                    public boolean isNojavac() {
                        return this.nojavac;
                    }

                    public void setNojavac(boolean z) {
                        this.nojavac = z;
                    }

                    public boolean isQuiet() {
                        return this.quiet;
                    }

                    public void setQuiet(boolean z) {
                        this.quiet = z;
                    }

                    public boolean isVerbose() {
                        return this.verbose;
                    }

                    public void setVerbose(boolean z) {
                        this.verbose = z;
                    }

                    public boolean isDownload() {
                        return this.download;
                    }

                    public void setDownload(boolean z) {
                        this.download = z;
                    }

                    public boolean isNoUpa() {
                        return this.noUpa;
                    }

                    public void setNoUpa(boolean z) {
                        this.noUpa = z;
                    }

                    public boolean isNoPvr() {
                        return this.noPvr;
                    }

                    public void setNoPvr(boolean z) {
                        this.noPvr = z;
                    }

                    public boolean isNoAnn() {
                        return this.noAnn;
                    }

                    public void setNoAnn(boolean z) {
                        this.noAnn = z;
                    }

                    public boolean isNoVDoc() {
                        return this.noVDoc;
                    }

                    public void setNoVDoc(boolean z) {
                        this.noVDoc = z;
                    }

                    public boolean isNoExt() {
                        return this.noExt;
                    }

                    public void setNoExt(boolean z) {
                        this.noExt = z;
                    }

                    public boolean isIncrementalSrcGen() {
                        return this.incrementalSrcGen;
                    }

                    public void setIncrementalSrcGen(boolean z) {
                        this.incrementalSrcGen = z;
                    }

                    public boolean isDebug() {
                        return this.debug;
                    }

                    public void setDebug(boolean z) {
                        this.debug = z;
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

                    public String getCompiler() {
                        return this.compiler;
                    }

                    public void setCompiler(String str) {
                        this.compiler = str;
                    }

                    public String getJavaSource() {
                        return this.javasource;
                    }

                    public void setJavaSource(String str) {
                        this.javasource = str;
                    }

                    public Collection getErrorListener() {
                        return this.errorListener;
                    }

                    public void setErrorListener(Collection collection) {
                        this.errorListener = collection;
                    }

                    public String getRepackage() {
                        return this.repackage;
                    }

                    public void setRepackage(String str) {
                        this.repackage = str;
                    }

                    public List getExtensions() {
                        return this.extensions;
                    }

                    public void setExtensions(List list) {
                        this.extensions = list;
                    }

                    public Set getMdefNamespaces() {
                        return this.mdefNamespaces;
                    }

                    public void setMdefNamespaces(Set set) {
                        this.mdefNamespaces = set;
                    }

                    public String getCatalogFile() {
                        return this.catalogFile;
                    }

                    public void setCatalogFile(String str) {
                        this.catalogFile = str;
                    }

                    public SchemaCodePrinter getSchemaCodePrinter() {
                        return this.schemaCodePrinter;
                    }

                    public void setSchemaCodePrinter(SchemaCodePrinter schemaCodePrinter) {
                        this.schemaCodePrinter = schemaCodePrinter;
                    }

                    public EntityResolver getEntityResolver() {
                        return this.entityResolver;
                    }

                    public void setEntityResolver(EntityResolver entityResolver) {
                        this.entityResolver = entityResolver;
                    }
                }

                private static SchemaTypeSystem loadTypeSystem(String str, File[] fileArr, File[] fileArr2, URL[] urlArr, File[] fileArr3, File[] fileArr4, ResourceLoader resourceLoader, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Set set, File file, Map map, Collection collection, File file2, EntityResolver entityResolver, File[] fileArr5, String str2) {
                    String str3;
                    String str4 = "xsd config";
                    XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher(collection);
                    try {
                        StscState.start().setErrorListener(xmlErrorWatcher);
                        SchemaTypeLoader schemaTypeLoaderTypeLoaderForClassLoader = XmlBeans.typeLoaderForClassLoader(SchemaDocument.class.getClassLoader());
                        ArrayList arrayList = new ArrayList();
                        if (fileArr != null) {
                            int i = 0;
                            while (i < fileArr.length) {
                                try {
                                    XmlOptions xmlOptions = new XmlOptions();
                                    xmlOptions.setLoadLineNumbers();
                                    xmlOptions.setLoadMessageDigest();
                                    xmlOptions.setEntityResolver(entityResolver);
                                    str3 = str4;
                                    try {
                                        XmlObject xmlObject = schemaTypeLoaderTypeLoaderForClassLoader.parse(fileArr[i], (SchemaType) null, xmlOptions);
                                        if (xmlObject instanceof SchemaDocument) {
                                            addSchema(fileArr[i].toString(), (SchemaDocument) xmlObject, xmlErrorWatcher, z5, arrayList);
                                        } else {
                                            StscState.addError(xmlErrorWatcher, "invalid.document.type", new Object[]{fileArr[i], "schema"}, xmlObject);
                                        }
                                    } catch (XmlException e) {
                                        e = e;
                                        xmlErrorWatcher.add(e.getError());
                                    } catch (Exception e2) {
                                        e = e2;
                                        StscState.addError(xmlErrorWatcher, "cannot.load.file", new Object[]{"xsd", fileArr[i], e.getMessage()}, fileArr[i]);
                                    }
                                } catch (XmlException e3) {
                                    e = e3;
                                    str3 = str4;
                                } catch (Exception e4) {
                                    e = e4;
                                    str3 = str4;
                                }
                                i++;
                                str4 = str3;
                            }
                        }
                        String str5 = str4;
                        if (fileArr2 != null) {
                            for (int i2 = 0; i2 < fileArr2.length; i2++) {
                                try {
                                    XmlOptions xmlOptions2 = new XmlOptions();
                                    xmlOptions2.setLoadLineNumbers();
                                    xmlOptions2.setLoadSubstituteNamespaces(Collections.singletonMap("http://schemas.xmlsoap.org/wsdl/", "http://www.apache.org/internal/xmlbeans/wsdlsubst"));
                                    xmlOptions2.setEntityResolver(entityResolver);
                                    XmlObject xmlObject2 = schemaTypeLoaderTypeLoaderForClassLoader.parse(fileArr2[i2], (SchemaType) null, xmlOptions2);
                                    if (xmlObject2 instanceof DefinitionsDocument) {
                                        addWsdlSchemas(fileArr2[i2].toString(), (DefinitionsDocument) xmlObject2, xmlErrorWatcher, z5, arrayList);
                                    } else {
                                        StscState.addError(xmlErrorWatcher, "invalid.document.type", new Object[]{fileArr2[i2], "wsdl"}, xmlObject2);
                                    }
                                } catch (Exception e5) {
                                    StscState.addError(xmlErrorWatcher, "cannot.load.file", new Object[]{"wsdl", fileArr2[i2], e5.getMessage()}, fileArr2[i2]);
                                } catch (XmlException e6) {
                                    xmlErrorWatcher.add(e6.getError());
                                }
                            }
                        }
                        if (urlArr != null) {
                            for (int i3 = 0; i3 < urlArr.length; i3++) {
                                try {
                                    XmlOptions xmlOptions3 = new XmlOptions();
                                    xmlOptions3.setLoadLineNumbers();
                                    xmlOptions3.setLoadSubstituteNamespaces(Collections.singletonMap("http://schemas.xmlsoap.org/wsdl/", "http://www.apache.org/internal/xmlbeans/wsdlsubst"));
                                    xmlOptions3.setEntityResolver(entityResolver);
                                    XmlObject xmlObject3 = schemaTypeLoaderTypeLoaderForClassLoader.parse(urlArr[i3], (SchemaType) null, xmlOptions3);
                                    if (xmlObject3 instanceof DefinitionsDocument) {
                                        addWsdlSchemas(urlArr[i3].toString(), (DefinitionsDocument) xmlObject3, xmlErrorWatcher, z5, arrayList);
                                    } else if (xmlObject3 instanceof SchemaDocument) {
                                        addSchema(urlArr[i3].toString(), (SchemaDocument) xmlObject3, xmlErrorWatcher, z5, arrayList);
                                    } else {
                                        StscState.addError(xmlErrorWatcher, "invalid.document.type", new Object[]{urlArr[i3], "wsdl or schema"}, xmlObject3);
                                    }
                                } catch (XmlException e7) {
                                    xmlErrorWatcher.add(e7.getError());
                                } catch (Exception e8) {
                                    StscState.addError(xmlErrorWatcher, "cannot.load.file", new Object[]{"url", urlArr[i3], e8.getMessage()}, urlArr[i3]);
                                }
                            }
                        }
                        SchemaDocument.Schema[] schemaArr = (SchemaDocument.Schema[]) arrayList.toArray(new SchemaDocument.Schema[arrayList.size()]);
                        ArrayList arrayList2 = new ArrayList();
                        if (fileArr3 != null) {
                            if (z6) {
                                System.out.println("Pre/Post and Interface extensions will be ignored.");
                            }
                            for (int i4 = 0; i4 < fileArr3.length; i4++) {
                                try {
                                    try {
                                        XmlOptions xmlOptions4 = new XmlOptions();
                                        xmlOptions4.put("LOAD_LINE_NUMBERS");
                                        xmlOptions4.setEntityResolver(entityResolver);
                                        xmlOptions4.setLoadSubstituteNamespaces(MAP_COMPATIBILITY_CONFIG_URIS);
                                        XmlObject xmlObject4 = schemaTypeLoaderTypeLoaderForClassLoader.parse(fileArr3[i4], (SchemaType) null, xmlOptions4);
                                        if (!(xmlObject4 instanceof ConfigDocument)) {
                                            try {
                                                Object[] objArr = new Object[2];
                                                try {
                                                    objArr[0] = fileArr3[i4];
                                                    objArr[1] = str5;
                                                    StscState.addError(xmlErrorWatcher, "invalid.document.type", objArr, xmlObject4);
                                                } catch (XmlException e9) {
                                                    e = e9;
                                                    xmlErrorWatcher.add(e.getError());
                                                }
                                            } catch (XmlException e10) {
                                                e = e10;
                                                xmlErrorWatcher.add(e.getError());
                                            }
                                        } else {
                                            StscState.addInfo(xmlErrorWatcher, "Loading config file " + fileArr3[i4]);
                                            if (xmlObject4.validate(new XmlOptions().setErrorListener(xmlErrorWatcher))) {
                                                ConfigDocument.Config config = ((ConfigDocument) xmlObject4).getConfig();
                                                arrayList2.add(config);
                                                if (z6) {
                                                    try {
                                                        config.setExtensionArray(new Extensionconfig[0]);
                                                    } catch (XmlException e11) {
                                                        e = e11;
                                                        xmlErrorWatcher.add(e.getError());
                                                    }
                                                }
                                            }
                                        }
                                    } catch (XmlException e12) {
                                        e = e12;
                                    }
                                } catch (Exception e13) {
                                    StscState.addError(xmlErrorWatcher, "cannot.load.file", new Object[]{str5, fileArr3[i4], e13.getMessage()}, fileArr3[i4]);
                                }
                                xmlErrorWatcher.add(e.getError());
                            }
                        }
                        ConfigDocument.Config[] configArr = (ConfigDocument.Config[]) arrayList2.toArray(new ConfigDocument.Config[arrayList2.size()]);
                        SchemaTypeLoader schemaTypeLoaderBuild = SchemaTypeLoaderImpl.build(null, resourceLoader, null);
                        URI uri = file != null ? file.toURI() : null;
                        XmlOptions xmlOptions5 = new XmlOptions();
                        if (z) {
                            xmlOptions5.setCompileDownloadUrls();
                        }
                        if (z2) {
                            xmlOptions5.setCompileNoUpaRule();
                        }
                        if (z3) {
                            xmlOptions5.setCompileNoPvrRule();
                        }
                        if (z4) {
                            xmlOptions5.setCompileNoAnnotations();
                        }
                        if (set != null) {
                            xmlOptions5.setCompileMdefNamespaces(set);
                        }
                        xmlOptions5.setCompileNoValidation();
                        xmlOptions5.setEntityResolver(entityResolver);
                        if (str2 != null) {
                            xmlOptions5.setGenerateJavaVersion(str2);
                        }
                        SchemaTypeSystemCompiler.Parameters parameters = new SchemaTypeSystemCompiler.Parameters();
                        parameters.setName(str);
                        parameters.setSchemas(schemaArr);
                        parameters.setConfig(BindingConfigImpl.forConfigDocuments(configArr, fileArr4, fileArr5));
                        parameters.setLinkTo(schemaTypeLoaderBuild);
                        parameters.setOptions(xmlOptions5);
                        parameters.setErrorListener(xmlErrorWatcher);
                        parameters.setJavaize(true);
                        parameters.setBaseURI(uri);
                        parameters.setSourcesToCopyMap(map);
                        parameters.setSchemasDir(file2);
                        SchemaTypeSystem schemaTypeSystemCompile = SchemaTypeSystemCompiler.compile(parameters);
                        StscState.end();
                        return schemaTypeSystemCompile;
                    } catch (Throwable th) {
                        StscState.end();
                        throw th;
                    }
                }

                private static void addSchema(String str, SchemaDocument schemaDocument, XmlErrorWatcher xmlErrorWatcher, boolean z, List list) {
                    StscState.addInfo(xmlErrorWatcher, "Loading schema file " + str);
                    XmlOptions errorListener = new XmlOptions().setErrorListener(xmlErrorWatcher);
                    if (z) {
                        errorListener.setValidateTreatLaxAsSkip();
                    }
                    if (schemaDocument.validate(errorListener)) {
                        list.add(schemaDocument.getSchema());
                    }
                }

                private static void addWsdlSchemas(String str, DefinitionsDocument definitionsDocument, XmlErrorWatcher xmlErrorWatcher, boolean z, List list) {
                    if (wsdlContainsEncoded(definitionsDocument)) {
                        StscState.addWarning(xmlErrorWatcher, "The WSDL " + str + " uses SOAP encoding. SOAP encoding is not compatible with literal XML Schema.", 60, definitionsDocument);
                    }
                    StscState.addInfo(xmlErrorWatcher, "Loading wsdl file " + str);
                    XmlOptions errorListener = new XmlOptions().setErrorListener(xmlErrorWatcher);
                    if (z) {
                        errorListener.setValidateTreatLaxAsSkip();
                    }
                    int i = 0;
                    for (XmlObject xmlObject : definitionsDocument.getDefinitions().getTypesArray()) {
                        XmlObject[] xmlObjectArrSelectPath = xmlObject.selectPath("declare namespace xs=\"http://www.w3.org/2001/XMLSchema\" xs:schema");
                        if (xmlObjectArrSelectPath.length == 0) {
                            StscState.addWarning(xmlErrorWatcher, "The WSDL " + str + " did not have any schema documents in namespace 'http://www.w3.org/2001/XMLSchema'", 60, definitionsDocument);
                        } else {
                            for (int i2 = 0; i2 < xmlObjectArrSelectPath.length; i2++) {
                                XmlObject xmlObject2 = xmlObjectArrSelectPath[i2];
                                if ((xmlObject2 instanceof SchemaDocument.Schema) && xmlObject2.validate(errorListener)) {
                                    i++;
                                    list.add(xmlObjectArrSelectPath[i2]);
                                }
                            }
                        }
                    }
                    StscState.addInfo(xmlErrorWatcher, "Processing " + i + " schema(s) in " + str);
                }

                /* JADX WARN: Code duplicated, block: B:71:0x02ae A[PHI: r0
  0x02ae: PHI (r0v5 boolean) = (r0v4 boolean), (r0v4 boolean), (r0v7 boolean), (r0v7 boolean), (r0v8 boolean), (r0v8 boolean) binds: [B:23:0x019f, B:24:0x01a1, B:42:0x0211, B:43:0x0213, B:55:0x0266, B:57:0x026a] A[DONT_GENERATE, DONT_INLINE]] */
                public static boolean compile(Parameters parameters) {
                    File file;
                    File baseDir = parameters.getBaseDir();
                    File[] xsdFiles = parameters.getXsdFiles();
                    File[] wsdlFiles = parameters.getWsdlFiles();
                    URL[] urlFiles = parameters.getUrlFiles();
                    File[] javaFiles = parameters.getJavaFiles();
                    File[] configFiles = parameters.getConfigFiles();
                    File[] classpath = parameters.getClasspath();
                    File outputJar = parameters.getOutputJar();
                    String name = parameters.getName();
                    File srcDir = parameters.getSrcDir();
                    File classesDir = parameters.getClassesDir();
                    String compiler = parameters.getCompiler();
                    String javaSource = parameters.getJavaSource();
                    String memoryInitialSize = parameters.getMemoryInitialSize();
                    String memoryMaximumSize = parameters.getMemoryMaximumSize();
                    boolean zIsNojavac = parameters.isNojavac();
                    boolean zIsDebug = parameters.isDebug();
                    boolean zIsVerbose = parameters.isVerbose();
                    boolean zIsQuiet = parameters.isQuiet();
                    boolean zIsDownload = parameters.isDownload();
                    boolean zIsNoUpa = parameters.isNoUpa();
                    boolean zIsNoPvr = parameters.isNoPvr();
                    boolean zIsNoAnn = parameters.isNoAnn();
                    boolean zIsNoVDoc = parameters.isNoVDoc();
                    boolean zIsNoExt = parameters.isNoExt();
                    boolean zIsIncrementalSrcGen = parameters.isIncrementalSrcGen();
                    Collection errorListener = parameters.getErrorListener();
                    String repackage = parameters.getRepackage();
                    if (repackage != null) {
                        SchemaTypeLoaderImpl.METADATA_PACKAGE_LOAD = SchemaTypeSystemImpl.METADATA_PACKAGE_GEN;
                        String name2 = SchemaTypeSystem.class.getPackage().getName();
                        SchemaTypeSystemImpl.METADATA_PACKAGE_GEN = new Repackager(repackage).repackage(new StringBuffer(name2)).toString().replace(NameUtil.PERIOD, NameUtil.USCORE);
                        System.out.println("\n\n\n" + name2 + ".SchemaCompiler  Metadata LOAD:" + SchemaTypeLoaderImpl.METADATA_PACKAGE_LOAD + " GEN:" + SchemaTypeSystemImpl.METADATA_PACKAGE_GEN);
                    }
                    SchemaCodePrinter schemaCodePrinter = parameters.getSchemaCodePrinter();
                    List extensions = parameters.getExtensions();
                    Set mdefNamespaces = parameters.getMdefNamespaces();
                    EntityResolver entityResolverResolverForCatalog = parameters.getEntityResolver() == null ? ResolverUtil.resolverForCatalog(parameters.getCatalogFile()) : parameters.getEntityResolver();
                    if (srcDir == null || classesDir == null) {
                        throw new IllegalArgumentException("src and class gen directories may not be null.");
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (baseDir == null) {
                        baseDir = new File(SystemProperties.getProperty("user.dir"));
                    }
                    HashMap map = new HashMap();
                    PathResourceLoader pathResourceLoader = classpath != null ? new PathResourceLoader(classpath) : null;
                    File fileCreateDir = IOUtil.createDir(classesDir, "schema" + SchemaTypeSystemImpl.METADATA_PACKAGE_GEN + "/src");
                    XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher(errorListener);
                    SchemaTypeSystem schemaTypeSystemLoadTypeSystem = loadTypeSystem(name, xsdFiles, wsdlFiles, urlFiles, configFiles, javaFiles, pathResourceLoader, zIsDownload, zIsNoUpa, zIsNoPvr, zIsNoAnn, zIsNoVDoc, zIsNoExt, mdefNamespaces, baseDir, map, xmlErrorWatcher, fileCreateDir, entityResolverResolverForCatalog, classpath, javaSource);
                    boolean zGenerateTypes = !xmlErrorWatcher.hasError();
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (!zIsQuiet) {
                        System.out.println("Time to build schema type system: " + ((jCurrentTimeMillis2 - jCurrentTimeMillis) / 1000.0d) + " seconds");
                    }
                    if (!zGenerateTypes || schemaTypeSystemLoadTypeSystem == null) {
                        file = classesDir;
                    } else {
                        long jCurrentTimeMillis3 = System.currentTimeMillis();
                        FilerImpl filerImpl = new FilerImpl(classesDir, srcDir, repackage == null ? null : new Repackager(repackage), zIsVerbose, zIsIncrementalSrcGen);
                        XmlOptions xmlOptions = new XmlOptions();
                        if (schemaCodePrinter != null) {
                            xmlOptions.setSchemaCodePrinter(schemaCodePrinter);
                        }
                        if (javaSource != null) {
                            xmlOptions.setGenerateJavaVersion(javaSource);
                        }
                        schemaTypeSystemLoadTypeSystem.save(filerImpl);
                        zGenerateTypes &= SchemaTypeSystemCompiler.generateTypes(schemaTypeSystemLoadTypeSystem, filerImpl, xmlOptions);
                        if (zIsIncrementalSrcGen) {
                            SchemaCodeGenerator.deleteObsoleteFiles(srcDir, srcDir, new HashSet(filerImpl.getSourceFiles()));
                        }
                        if (zGenerateTypes) {
                            long jCurrentTimeMillis4 = System.currentTimeMillis();
                            if (!zIsQuiet) {
                                System.out.println("Time to generate code: " + ((jCurrentTimeMillis4 - jCurrentTimeMillis3) / 1000.0d) + " seconds");
                            }
                        }
                        if (!zGenerateTypes || zIsNojavac) {
                            file = classesDir;
                        } else {
                            long jCurrentTimeMillis5 = System.currentTimeMillis();
                            List sourceFiles = filerImpl.getSourceFiles();
                            if (javaFiles != null) {
                                sourceFiles.addAll(Arrays.asList(javaFiles));
                            }
                            if (!CodeGenUtil.externalCompile(sourceFiles, classesDir, classpath, zIsDebug, compiler, javaSource, memoryInitialSize, memoryMaximumSize, zIsQuiet, zIsVerbose)) {
                                zGenerateTypes = false;
                            }
                            long jCurrentTimeMillis6 = System.currentTimeMillis();
                            if (zGenerateTypes && !parameters.isQuiet()) {
                                System.out.println("Time to compile code: " + ((jCurrentTimeMillis6 - jCurrentTimeMillis5) / 1000.0d) + " seconds");
                            }
                            if (!zGenerateTypes || outputJar == null) {
                                file = classesDir;
                            } else {
                                try {
                                    file = classesDir;
                                    try {
                                        new JarHelper().jarDir(file, outputJar);
                                    } catch (IOException e) {
                                        e = e;
                                        System.err.println("IO Error " + e);
                                        zGenerateTypes = false;
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    file = classesDir;
                                }
                                if (zGenerateTypes && !parameters.isQuiet()) {
                                    System.out.println("Compiled types to: " + outputJar);
                                }
                            }
                        }
                    }
                    if (!zGenerateTypes && !zIsQuiet) {
                        System.out.println("BUILD FAILED");
                    } else {
                        runExtensions(extensions, schemaTypeSystemLoadTypeSystem, file);
                    }
                    if (pathResourceLoader != null) {
                        pathResourceLoader.close();
                    }
                    return zGenerateTypes;
                }

                private static void runExtensions(List list, SchemaTypeSystem schemaTypeSystem, File file) {
                    String absolutePath;
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    Iterator it = list.iterator();
                    try {
                        absolutePath = file.getCanonicalPath();
                    } catch (IOException unused) {
                        System.out.println("WARNING: Unable to get the path for schema jar file");
                        absolutePath = file.getAbsolutePath();
                    }
                    while (it.hasNext()) {
                        Extension extension = (Extension) it.next();
                        try {
                            SchemaCompilerExtension schemaCompilerExtension = (SchemaCompilerExtension) extension.getClassName().newInstance();
                            System.out.println("Running Extension: " + schemaCompilerExtension.getExtensionName());
                            HashMap map = new HashMap();
                            for (Extension.Param param : extension.getParams()) {
                                map.put(param.getName(), param.getValue());
                            }
                            map.put("classesDir", absolutePath);
                            schemaCompilerExtension.schemaCompilerExtension(schemaTypeSystem, map);
                        } catch (IllegalAccessException unused2) {
                            System.out.println("ILLEGAL ACCESS Exception when attempting to instantiate schema compiler extension: " + extension.getClassName().getName());
                            System.out.println("EXTENSION Class was not run");
                            return;
                        } catch (InstantiationException unused3) {
                            System.out.println("UNABLE to instantiate schema compiler extension:" + extension.getClassName().getName());
                            System.out.println("EXTENSION Class was not run");
                            return;
                        }
                    }
                }

                private static boolean wsdlContainsEncoded(XmlObject xmlObject) {
                    for (SimpleValue simpleValue : xmlObject.selectPath("declare namespace soap='http://schemas.xmlsoap.org/wsdl/soap/' .//soap:body/@use|.//soap:header/@use|.//soap:fault/@use")) {
                        if ("encoded".equals(simpleValue.getStringValue())) {
                            return true;
                        }
                    }
                    return false;
                }

                static {
                    HashMap map = new HashMap();
                    MAP_COMPATIBILITY_CONFIG_URIS = map;
                    map.put(COMPATIBILITY_CONFIG_URI, CONFIG_URI);
                }
            }
