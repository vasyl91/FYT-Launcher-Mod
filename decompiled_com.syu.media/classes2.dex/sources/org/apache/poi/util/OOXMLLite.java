package org.apache.poi.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class OOXMLLite {
    private File _destDest;
    private File _ooxmlJar;
    private File _testDir;

    OOXMLLite(String str, String str2, String str3) {
        this._destDest = new File(str);
        this._testDir = new File(str2);
        this._ooxmlJar = new File(str3);
    }

    public static void main(String[] strArr) throws ClassNotFoundException, IOException {
        String str = null;
        String str2 = null;
        int i = 0;
        String str3 = null;
        while (i < strArr.length) {
            if (strArr[i].equals("-dest")) {
                i++;
                str = strArr[i];
            } else if (strArr[i].equals("-test")) {
                i++;
                str3 = strArr[i];
            } else if (strArr[i].equals("-ooxml")) {
                i++;
                str2 = strArr[i];
            }
            i++;
        }
        new OOXMLLite(str, str3, str2).build();
    }

    void build() throws ClassNotFoundException, IOException {
        ArrayList arrayList = new ArrayList();
        String strJoin = StringUtil.join("|", "BaseTestXWorkbook", "BaseTestXSheet", "BaseTestXRow", "BaseTestXCell", "BaseTestXSSFPivotTable", "TestSXSSFWorkbook\\$\\d", "TestUnfixedBugs", "MemoryUsage", "TestDataProvider", "TestDataSamples", "All.+Tests", "ZipFileAssert", "AesZipFileZipEntrySource", "TempFileRecordingSXSSFWorkbookWithCustomZipEntrySource", "PkiTestUtils", "TestCellFormatPart\\$\\d", "TestSignatureInfo\\$\\d", "TestCertificateEncryption\\$CertData", "TestPOIXMLDocument\\$OPCParser", "TestPOIXMLDocument\\$TestFactory", "TestXSLFTextParagraph\\$DrawTextParagraphProxy", "TestXSSFExportToXML\\$\\d", "TestXSSFExportToXML\\$DummyEntityResolver", "TestFormulaEvaluatorOnXSSF\\$Result", "TestFormulaEvaluatorOnXSSF\\$SS", "TestMultiSheetFormulaEvaluatorOnXSSF\\$Result", "TestMultiSheetFormulaEvaluatorOnXSSF\\$SS", "TestXSSFBugs\\$\\d", "AddImageBench", "AddImageBench_jmhType_B\\d", "AddImageBench_benchCreatePicture_jmhTest", "TestEvilUnclosedBRFixingInputStream\\$EvilUnclosedBRFixingInputStream", "TempFileRecordingSXSSFWorkbookWithCustomZipEntrySource\\$TempFileRecordingSheetDataWriterWithDecorator", "TestXSSFBReader\\$1", "TestXSSFBReader\\$TestSheetHandler", "TestFormulaEvaluatorOnXSSF\\$1", "TestMultiSheetFormulaEvaluatorOnXSSF\\$1", "TestZipPackagePropertiesMarshaller\\$1", "SLCommonUtils", "TestPPTX2PNG\\$1");
        System.out.println("Collecting unit tests from " + this._testDir);
        File file = this._testDir;
        collectTests(file, file, arrayList, ".+.class$", ".+(" + strJoin + ").class");
        System.out.println("Found " + arrayList.size() + " classes");
        JUnitCore jUnitCore = new JUnitCore();
        jUnitCore.addListener(new TextListener(System.out));
        if (!jUnitCore.run((Class[]) arrayList.toArray(new Class[arrayList.size()])).wasSuccessful()) {
            throw new RuntimeException("Tests did not succeed, cannot build ooxml-lite jar");
        }
        System.out.println("Copying classes to " + this._destDest);
        for (Class<?> cls : getLoadedClasses(this._ooxmlJar.getName()).values()) {
            String str = cls.getName().replace('.', '/') + ".class";
            copyFile(cls.getResourceAsStream("/" + str), new File(this._destDest, str));
            if (cls.isInterface()) {
                for (Class<?> cls2 : cls.getDeclaredClasses()) {
                    String str2 = cls2.getName().replace('.', '/') + ".class";
                    copyFile(cls2.getResourceAsStream("/" + str2), new File(this._destDest, str2));
                }
            }
        }
        System.out.println("Copying .xsb resources");
        JarFile jarFile = new JarFile(this._ooxmlJar);
        Pattern patternCompile = Pattern.compile("schemaorg_apache_xmlbeans/(system|element)/.*\\.xsb");
        try {
            Enumeration<JarEntry> enumerationEntries = jarFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                if (patternCompile.matcher(jarEntryNextElement.getName()).matches()) {
                    copyFile(jarFile.getInputStream(jarEntryNextElement), new File(this._destDest, jarEntryNextElement.getName()));
                }
            }
            jarFile.close();
        } catch (Throwable th) {
            jarFile.close();
            throw th;
        }
    }

    private static boolean checkForTestAnnotation(Class<?> cls) {
        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                return true;
            }
        }
        if (cls.getSuperclass() != null) {
            for (Method method2 : cls.getSuperclass().getDeclaredMethods()) {
                if (method2.isAnnotationPresent(Test.class)) {
                    return true;
                }
            }
        }
        System.out.println("Class " + cls.getName() + " does not derive from TestCase and does not have a @Test annotation");
        return false;
    }

    private static void collectTests(File file, File file2, List<Class<?>> list, String str, String str2) throws ClassNotFoundException {
        if (file2.isDirectory()) {
            File[] fileArrListFiles = file2.listFiles();
            if (fileArrListFiles != null) {
                for (File file3 : fileArrListFiles) {
                    collectTests(file, file3, list, str, str2);
                }
                return;
            }
            return;
        }
        String strReplace = file2.getAbsolutePath().substring(file.getAbsolutePath().length() + 1).replace(File.separator, ".");
        if (strReplace.matches(str) && !strReplace.matches(str2)) {
            if (strReplace.indexOf(36) != -1) {
                System.out.println("Inner class " + strReplace + " not included");
                return;
            }
            String strReplace2 = strReplace.replace(".class", "");
            try {
                Class<?> cls = Class.forName(strReplace2);
                if (TestCase.class.isAssignableFrom(cls) || checkForTestAnnotation(cls)) {
                    list.add(cls);
                }
            } catch (Throwable unused) {
                System.out.println("Class " + strReplace2 + " is not in classpath");
            }
        }
    }

    private static Map<String, Class<?>> getLoadedClasses(String str) {
        CodeSource codeSource;
        URL location;
        try {
            Vector<Class> vector = (Vector) ((Field) AccessController.doPrivileged(new PrivilegedAction<Field>() { // from class: org.apache.poi.util.OOXMLLite.1
                @Override // java.security.PrivilegedAction
                public Field run() {
                    try {
                        Field declaredField = ClassLoader.class.getDeclaredField("classes");
                        declaredField.setAccessible(true);
                        return declaredField;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            })).get(ClassLoader.getSystemClassLoader());
            HashMap map = new HashMap();
            for (Class cls : vector) {
                ProtectionDomain protectionDomain = cls.getProtectionDomain();
                if (protectionDomain != null && (codeSource = protectionDomain.getCodeSource()) != null && (location = codeSource.getLocation()) != null && location.toString().contains(str)) {
                    map.put(cls.getName(), cls);
                }
            }
            return map;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static void copyFile(InputStream inputStream, File file) throws IOException {
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            throw new RuntimeException("Can't create destination directory: " + parentFile);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            IOUtils.copy(inputStream, fileOutputStream);
        } finally {
            fileOutputStream.close();
        }
    }
}
