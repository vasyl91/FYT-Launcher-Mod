package org.apache.xmlbeans.impl.repackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Repackage {
    private List _fromPackages;
    private List _moveAlongFiles;
    private Map _movedDirs;
    private Pattern _packagePattern;
    private Repackager _repackager;
    private int _skippedFiles;
    private File _sourceBase;
    private File _targetBase;
    private List _toPackages;

    public static void main(String[] strArr) throws Exception {
        new Repackage(strArr).repackage();
    }

    private Repackage(String[] strArr) {
        int i;
        String str = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        boolean z = false;
        while (i2 < strArr.length) {
            if (strArr[i2].equals("-repackage") && (i = i2 + 1) < strArr.length) {
                str = strArr[i];
            } else if (strArr[i2].equals("-f") && (i = i2 + 1) < strArr.length) {
                str2 = strArr[i];
            } else {
                if (!strArr[i2].equals("-t") || (i = i2 + 1) >= strArr.length) {
                    z = true;
                } else {
                    str3 = strArr[i];
                }
                i2++;
            }
            i2 = i;
            i2++;
        }
        if (!z && str != null) {
            if (!((str2 == null) ^ (str3 == null))) {
                this._repackager = new Repackager(str);
                if (str2 == null || str3 == null) {
                    return;
                }
                this._sourceBase = new File(str2);
                this._targetBase = new File(str3);
                return;
            }
        }
        throw new RuntimeException("Usage: repackage -repackage [spec] [ -f [sourcedir] -t [targetdir] ]");
    }

    public void repackage() throws Exception {
        if (this._sourceBase == null || this._targetBase == null) {
            System.out.println(this._repackager.repackage(readInputStream(System.in)).toString());
            return;
        }
        this._fromPackages = this._repackager.getFromPackages();
        this._toPackages = this._repackager.getToPackages();
        this._packagePattern = Pattern.compile("^\\s*package\\s+((?:\\w|\\.)*)\\s*;", 8);
        this._moveAlongFiles = new ArrayList();
        this._movedDirs = new HashMap();
        this._targetBase.mkdirs();
        ArrayList arrayList = new ArrayList();
        fillFiles(arrayList, this._sourceBase);
        System.out.println("Repackaging " + arrayList.size() + " files ...");
        int length = this._sourceBase.getCanonicalPath().length();
        for (int i = 0; i < arrayList.size(); i++) {
            repackageFile(((File) arrayList.get(i)).getCanonicalPath().substring(length + 1));
        }
        finishMovingFiles();
        if (this._skippedFiles > 0) {
            System.out.println("Skipped " + this._skippedFiles + " unmodified files.");
        }
    }

    private boolean fileIsUnchanged(String str) {
        return new File(this._sourceBase, str).lastModified() < new File(this._targetBase, str).lastModified();
    }

    public void repackageFile(String str) throws IOException {
        if (str.endsWith(".java")) {
            repackageJavaFile(str);
            return;
        }
        if (str.endsWith(".xsdconfig") || str.endsWith(".xml") || str.endsWith(".g")) {
            repackageNonJavaFile(str);
        } else if (str.startsWith("bin" + File.separatorChar)) {
            repackageNonJavaFile(str);
        } else {
            moveAlongWithJavaFiles(str);
        }
    }

    public void moveAlongWithJavaFiles(String str) {
        this._moveAlongFiles.add(str);
    }

    public void finishMovingFiles() throws IOException {
        for (String str : this._moveAlongFiles) {
            String str2 = (String) this._movedDirs.get(Repackager.dirForPath(str));
            String string = str2 != null ? new File(str2, new File(str).getName()).toString() : str;
            if (str.endsWith(".html")) {
                repackageNonJavaFile(str, string);
            } else {
                justMoveNonJavaFile(str, string);
            }
        }
    }

    public void repackageNonJavaFile(String str) throws IOException {
        File file = new File(this._sourceBase, str);
        File file2 = new File(this._targetBase, str);
        if (file.lastModified() < file2.lastModified()) {
            this._skippedFiles++;
        } else {
            writeFile(file2, this._repackager.repackage(readFile(file)));
        }
    }

    public void repackageNonJavaFile(String str, String str2) throws IOException {
        File file = new File(this._sourceBase, str);
        File file2 = new File(this._targetBase, str2);
        if (file.lastModified() < file2.lastModified()) {
            this._skippedFiles++;
        } else {
            writeFile(file2, this._repackager.repackage(readFile(file)));
        }
    }

    public void justMoveNonJavaFile(String str, String str2) throws IOException {
        File file = new File(this._sourceBase, str);
        File file2 = new File(this._targetBase, str2);
        if (file.lastModified() < file2.lastModified()) {
            this._skippedFiles++;
        } else {
            copyFile(file, file2);
        }
    }

    public void repackageJavaFile(String str) throws IOException {
        List list;
        List list2;
        String str2 = str;
        File file = new File(this._sourceBase, str2);
        StringBuffer file2 = readFile(file);
        Matcher matcher = this._packagePattern.matcher(file2);
        int i = 1;
        if (matcher.find()) {
            String strGroup = matcher.group(1);
            int iStart = matcher.start(1);
            int iEnd = matcher.end(1);
            if (matcher.find()) {
                throw new RuntimeException("Two package specifications found: " + str2);
            }
            ArrayList arrayListSplitPath = Repackager.splitPath(str2, File.separatorChar);
            String strDirForPath = Repackager.dirForPath(str);
            while (true) {
                boolean z = false;
                for (int i2 = i; i2 < arrayListSplitPath.size(); i2++) {
                    int i3 = i2 - 1;
                    String str3 = (String) arrayListSplitPath.get(i3);
                    String str4 = (String) arrayListSplitPath.get(i2);
                    if (str3.indexOf(58) < str4.indexOf(58)) {
                        arrayListSplitPath.set(i3, str4);
                        arrayListSplitPath.set(i2, str3);
                        z = true;
                    }
                }
                if (!z) {
                    break;
                } else {
                    i = 1;
                }
            }
            ArrayList arrayListSplitPath2 = Repackager.splitPath(strGroup, NameUtil.PERIOD);
            int size = arrayListSplitPath.size() - 2;
            if (size < 0 || arrayListSplitPath.size() - 1 < arrayListSplitPath2.size()) {
                throw new RuntimeException("Package spec differs from file path: " + str2);
            }
            for (int size2 = arrayListSplitPath2.size() - 1; size2 >= 0; size2--) {
                if (!arrayListSplitPath2.get(size2).equals(arrayListSplitPath.get(size))) {
                    throw new RuntimeException("Package spec differs from file path: " + str2);
                }
                size--;
            }
            int i4 = 0;
            loop3: while (true) {
                if (i4 >= this._fromPackages.size()) {
                    list = null;
                    list2 = null;
                    break;
                }
                list = (List) this._fromPackages.get(i4);
                if (list.size() <= arrayListSplitPath2.size()) {
                    int i5 = 0;
                    while (true) {
                        if (i5 < list.size()) {
                            if (!list.get(i5).equals(arrayListSplitPath2.get(i5))) {
                                break;
                            } else {
                                i5++;
                            }
                        } else {
                            list2 = (List) this._toPackages.get(i4);
                            break loop3;
                        }
                    }
                }
                i4++;
            }
            if (list2 != null) {
                String str5 = "";
                String str6 = "";
                for (int i6 = 0; i6 < list2.size(); i6++) {
                    if (i6 > 0) {
                        str5 = str5 + ".";
                        str6 = str6 + File.separatorChar;
                    }
                    str5 = str5 + list2.get(i6);
                    str6 = str6 + list2.get(i6);
                }
                for (int size3 = (arrayListSplitPath.size() - arrayListSplitPath2.size()) - 2; size3 >= 0; size3--) {
                    str6 = ((String) arrayListSplitPath.get(size3)) + File.separatorChar + str6;
                }
                for (int size4 = list.size(); size4 < arrayListSplitPath2.size(); size4++) {
                    str6 = str6 + File.separatorChar + ((String) arrayListSplitPath2.get(size4));
                    str5 = str5 + NameUtil.PERIOD + ((String) arrayListSplitPath2.get(size4));
                }
                String str7 = str6 + File.separatorChar + ((String) arrayListSplitPath.get(arrayListSplitPath.size() - 1));
                file2.replace(iStart, iEnd, str5);
                String strDirForPath2 = Repackager.dirForPath(str7);
                if (!strDirForPath.equals(strDirForPath2)) {
                    this._movedDirs.put(strDirForPath, strDirForPath2);
                }
                str2 = str7;
            }
        }
        if (file.lastModified() < new File(this._targetBase, str2).lastModified()) {
            this._skippedFiles++;
        } else {
            writeFile(new File(this._targetBase, str2), this._repackager.repackage(file2));
        }
    }

    void writeFile(File file, StringBuffer stringBuffer) throws IOException {
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        StringReader stringReader = new StringReader(stringBuffer.toString());
        copy(stringReader, outputStreamWriter);
        stringReader.close();
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    StringBuffer readFile(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        StringWriter stringWriter = new StringWriter();
        copy(inputStreamReader, stringWriter);
        stringWriter.close();
        inputStreamReader.close();
        fileInputStream.close();
        return stringWriter.getBuffer();
    }

    StringBuffer readInputStream(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        StringWriter stringWriter = new StringWriter();
        copy(inputStreamReader, stringWriter);
        stringWriter.close();
        inputStreamReader.close();
        return stringWriter.getBuffer();
    }

    public static void copyFile(File file, File file2) throws IOException {
        file2.getParentFile().mkdirs();
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        copy(fileInputStream, fileOutputStream);
        fileOutputStream.close();
        fileInputStream.close();
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[16384];
        while (true) {
            int i = inputStream.read(bArr, 0, 16384);
            if (i < 0) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    public static void copy(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[16384];
        while (true) {
            int i = reader.read(cArr, 0, 16384);
            if (i < 0) {
                return;
            } else {
                writer.write(cArr, 0, i);
            }
        }
    }

    public void fillFiles(ArrayList arrayList, File file) throws IOException {
        if (!file.isDirectory()) {
            arrayList.add(file);
            return;
        }
        if (file.getName().equals("build") || file.getName().equals("CVS")) {
            return;
        }
        for (String str : file.list()) {
            fillFiles(arrayList, new File(file, str));
        }
    }

    public void recursiveDelete(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                for (String str : file.list()) {
                    recursiveDelete(new File(file, str));
                }
            }
            file.delete();
        }
    }
}
