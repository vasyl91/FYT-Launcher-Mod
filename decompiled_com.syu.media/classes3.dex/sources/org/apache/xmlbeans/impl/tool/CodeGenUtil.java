package org.apache.xmlbeans.impl.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.SystemProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CodeGenUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static String DEFAULT_COMPILER = "javac";
    public static String DEFAULT_JAR = "jar";
    public static String DEFAULT_MEM_MAX = "256m";
    public static String DEFAULT_MEM_START = "8m";

    public static URI resolve(URI uri, URI uri2) {
        URI uriResolve = uri.resolve(uri2);
        if (!"file".equals(uriResolve.getScheme()) || uri2.equals(uriResolve) || !uri.getPath().startsWith("//") || uriResolve.getPath().startsWith("//")) {
            return uriResolve;
        }
        try {
            return new URI("file", null, "///".concat(uriResolve.getPath()), uriResolve.getQuery(), uriResolve.getFragment());
        } catch (URISyntaxException unused) {
            return uriResolve;
        }
    }

    static void addAllJavaFiles(List list, List list2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (!file.isDirectory()) {
                list2.add(quoteAndEscapeFilename(file.getAbsolutePath()));
            } else {
                addAllJavaFiles(Arrays.asList(file.listFiles(new FileFilter() { // from class: org.apache.xmlbeans.impl.tool.CodeGenUtil.1
                    @Override // java.io.FileFilter
                    public boolean accept(File file2) {
                        if ((file2.isFile() && file2.getName().endsWith(".java")) || file2.isDirectory()) {
                            return true;
                        }
                        return CodeGenUtil.$assertionsDisabled;
                    }
                })), list2);
            }
        }
    }

    private static String quoteAndEscapeFilename(String str) {
        return str.indexOf(" ") < 0 ? str : "\"" + str.replaceAll("\\\\", "\\\\\\\\") + "\"";
    }

    private static String quoteNoEscapeFilename(String str) {
        return (str.indexOf(" ") < 0 || File.separatorChar == '/') ? str : "\"" + str + "\"";
    }

    public static boolean externalCompile(List list, File file, File[] fileArr, boolean z) {
        return externalCompile(list, file, fileArr, z, DEFAULT_COMPILER, null, DEFAULT_MEM_START, DEFAULT_MEM_MAX, $assertionsDisabled, $assertionsDisabled);
    }

    public static boolean externalCompile(List list, File file, File[] fileArr, boolean z, String str, String str2, String str3, boolean z2, boolean z3) {
        return externalCompile(list, file, fileArr, z, str, null, str2, str3, z2, z3);
    }

    public static boolean externalCompile(List list, File file, File[] fileArr, boolean z, String str, String str2, String str3, String str4, boolean z2, boolean z3) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            str = DEFAULT_COMPILER;
        }
        arrayList.add(findJavaTool(str).getAbsolutePath());
        if (file == null) {
            file = new File(".");
        } else {
            arrayList.add("-d");
            arrayList.add(quoteAndEscapeFilename(file.getAbsolutePath()));
        }
        if (fileArr == null) {
            fileArr = systemClasspath();
        }
        if (fileArr.length > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(file.getAbsolutePath());
            for (File file2 : fileArr) {
                stringBuffer.append(File.pathSeparator);
                stringBuffer.append(file2.getAbsolutePath());
            }
            arrayList.add("-classpath");
            arrayList.add(quoteAndEscapeFilename(stringBuffer.toString()));
        }
        if (str2 == null) {
            str2 = "1.6";
        }
        arrayList.add("-source");
        arrayList.add(str2);
        arrayList.add("-target");
        arrayList.add(str2);
        arrayList.add(z ? "-g" : "-g:none");
        if (z3) {
            arrayList.add("-verbose");
        }
        addAllJavaFiles(list, arrayList);
        File fileCreateTempFile = null;
        try {
            fileCreateTempFile = File.createTempFile("javac", "");
            FileWriter fileWriter = new FileWriter(fileCreateTempFile);
            Iterator it = arrayList.iterator();
            it.next();
            while (it.hasNext()) {
                fileWriter.write((String) it.next());
                fileWriter.write(10);
            }
            fileWriter.close();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(arrayList.get(0));
            if (str3 != null && str3.length() != 0) {
                arrayList2.add("-J-Xms" + str3);
            }
            if (str4 != null && str4.length() != 0) {
                arrayList2.add("-J-Xmx" + str4);
            }
            arrayList2.add("@" + fileCreateTempFile.getAbsolutePath());
            arrayList = arrayList2;
        } catch (Exception unused) {
            System.err.println("Could not create command-line file for javac");
        }
        try {
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            if (z3) {
                System.out.print("compile command:");
                for (String str5 : strArr) {
                    System.out.print(" " + str5);
                }
                System.out.println();
            }
            Process processExec = Runtime.getRuntime().exec(strArr);
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            new ThreadedReader(processExec.getInputStream(), stringBuffer3);
            new ThreadedReader(processExec.getErrorStream(), stringBuffer2);
            processExec.waitFor();
            if (z3 || processExec.exitValue() != 0) {
                if (stringBuffer3.length() > 0) {
                    System.out.println(stringBuffer3.toString());
                    System.out.flush();
                }
                if (stringBuffer2.length() > 0) {
                    System.err.println(stringBuffer2.toString());
                    System.err.flush();
                }
                if (processExec.exitValue() != 0) {
                    return $assertionsDisabled;
                }
            }
            if (fileCreateTempFile == null) {
                return true;
            }
            fileCreateTempFile.delete();
            return true;
        } catch (Throwable th) {
            System.err.println(th.toString());
            System.err.println(th.getCause());
            th.printStackTrace(System.err);
            return $assertionsDisabled;
        }
    }

    public static File[] systemClasspath() {
        ArrayList arrayList = new ArrayList();
        for (String str : SystemProperties.getProperty("java.class.path").split(File.pathSeparator)) {
            arrayList.add(new File(str));
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    public static boolean externalJar(File file, File file2) {
        return externalJar(file, file2, DEFAULT_JAR, $assertionsDisabled, $assertionsDisabled);
    }

    public static boolean externalJar(File file, File file2, String str, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            str = DEFAULT_JAR;
        }
        arrayList.add(findJavaTool(str).getAbsolutePath());
        arrayList.add("cf");
        arrayList.add(quoteNoEscapeFilename(file2.getAbsolutePath()));
        arrayList.add("-C");
        arrayList.add(quoteNoEscapeFilename(file.getAbsolutePath()));
        arrayList.add(".");
        try {
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            if (z2) {
                System.out.print("jar command:");
                for (String str2 : strArr) {
                    System.out.print(" " + str2);
                }
                System.out.println();
            }
            Process processExec = Runtime.getRuntime().exec(strArr);
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            new ThreadedReader(processExec.getInputStream(), stringBuffer2);
            new ThreadedReader(processExec.getErrorStream(), stringBuffer);
            processExec.waitFor();
            if (!z2 && processExec.exitValue() == 0) {
                return true;
            }
            if (stringBuffer2.length() > 0) {
                System.out.println(stringBuffer2.toString());
                System.out.flush();
            }
            if (stringBuffer.length() > 0) {
                System.err.println(stringBuffer.toString());
                System.err.flush();
            }
            if (processExec.exitValue() != 0) {
                return $assertionsDisabled;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace(System.err);
            return $assertionsDisabled;
        }
    }

    private static File findJavaTool(String str) {
        File file = new File(str);
        if (file.isFile()) {
            return file;
        }
        File file2 = new File(str + ".exe");
        if (file2.isFile()) {
            return file2;
        }
        String property = SystemProperties.getProperty("java.home");
        String str2 = File.separator;
        File file3 = new File(property + str2 + ".." + str2 + "bin", str);
        if (file3.isFile()) {
            return file3;
        }
        File file4 = new File(file3.getPath() + ".exe");
        if (file4.isFile()) {
            return file4;
        }
        File file5 = new File(property + str2 + "bin", str);
        if (file5.isFile()) {
            return file5;
        }
        File file6 = new File(file5.getPath() + ".exe");
        return file6.isFile() ? file6 : file;
    }

    private static class ThreadedReader {
        public ThreadedReader(InputStream inputStream, final StringBuffer stringBuffer) {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            new Thread(new Runnable() { // from class: org.apache.xmlbeans.impl.tool.CodeGenUtil.ThreadedReader.1
                @Override // java.lang.Runnable
                public void run() {
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                return;
                            } else {
                                stringBuffer.append(line + "\n");
                            }
                        } catch (Exception unused) {
                            return;
                        }
                    }
                }
            }).start();
        }
    }
}
