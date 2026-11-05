package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.impl.common.DefaultClassLoaderResourceLoader;
import org.apache.xmlbeans.impl.common.IOUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CommandLine {
    private static final File[] EMPTY_FILEARRAY = new File[0];
    private static final URL[] EMPTY_URLARRAY = new URL[0];
    private String[] _args;
    private String[] _badopts;
    private File _baseDir;
    private List _files;
    private Map _options;
    private List _urls;

    public CommandLine(String[] strArr, Collection collection, Collection collection2) {
        if (collection == null || collection2 == null) {
            throw new IllegalArgumentException("collection required (use Collections.EMPTY_SET if no options)");
        }
        this._options = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (i < strArr.length) {
            if (strArr[i].indexOf(45) == 0) {
                String strSubstring = strArr[i].substring(1);
                String str = "";
                if (!collection.contains(strSubstring)) {
                    if (collection2.contains(strSubstring)) {
                        int i2 = i + 1;
                        if (i2 < strArr.length) {
                            str = strArr[i2];
                            i = i2;
                        }
                    } else {
                        arrayList.add(strArr[i]);
                        str = null;
                    }
                }
                this._options.put(strSubstring, str);
            } else {
                arrayList2.add(strArr[i]);
            }
            i++;
        }
        this._badopts = (String[]) arrayList.toArray(new String[arrayList.size()]);
        this._args = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
    }

    public static void printLicense() {
        try {
            IOUtil.copyCompletely(new DefaultClassLoaderResourceLoader().getResourceAsStream("LICENSE.txt"), System.out);
        } catch (Exception unused) {
            System.out.println("License available in this JAR in LICENSE.txt");
        }
    }

    public static void printVersion() {
        System.out.println(XmlBeans.getVendor() + ", " + XmlBeans.getTitle() + ".XmlBeans version " + XmlBeans.getVersion());
    }

    public String[] args() {
        String[] strArr = this._args;
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }

    public String[] getBadOpts() {
        return this._badopts;
    }

    public String getOpt(String str) {
        return (String) this._options.get(str);
    }

    private static List collectFiles(File[] fileArr) {
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            if (!file.isDirectory()) {
                arrayList.add(file);
            } else {
                arrayList.addAll(collectFiles(file.listFiles()));
            }
        }
        return arrayList;
    }

    private List getFileList() {
        if (this._files == null) {
            String[] strArrArgs = args();
            File[] fileArr = new File[strArrArgs.length];
            boolean z = false;
            for (int i = 0; i < strArrArgs.length; i++) {
                File file = new File(strArrArgs[i]);
                fileArr[i] = file;
                if (!z && this._baseDir == null) {
                    if (file.isDirectory()) {
                        this._baseDir = fileArr[i];
                    } else {
                        this._baseDir = fileArr[i].getParentFile();
                    }
                } else {
                    URI uri = file.toURI();
                    File file2 = this._baseDir;
                    if (file2 != null && file2.toURI().relativize(uri).equals(uri)) {
                        this._baseDir = null;
                        z = true;
                    }
                }
            }
            this._files = Collections.unmodifiableList(collectFiles(fileArr));
        }
        return this._files;
    }

    private List getUrlList() {
        if (this._urls == null) {
            String[] strArrArgs = args();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArrArgs.length; i++) {
                if (looksLikeURL(strArrArgs[i])) {
                    try {
                        arrayList.add(new URL(strArrArgs[i]));
                    } catch (MalformedURLException e) {
                        System.err.println("ignoring invalid url: " + strArrArgs[i] + ": " + e.getMessage());
                    }
                }
            }
            this._urls = Collections.unmodifiableList(arrayList);
        }
        return this._urls;
    }

    private static boolean looksLikeURL(String str) {
        return str.startsWith("http:") || str.startsWith("https:") || str.startsWith("ftp:") || str.startsWith("file:");
    }

    public URL[] getURLs() {
        return (URL[]) getUrlList().toArray(EMPTY_URLARRAY);
    }

    public File[] getFiles() {
        return (File[]) getFileList().toArray(EMPTY_FILEARRAY);
    }

    public File getBaseDir() {
        return this._baseDir;
    }

    public File[] filesEndingWith(String str) {
        ArrayList arrayList = new ArrayList();
        for (File file : getFileList()) {
            if (file.getName().endsWith(str) && !looksLikeURL(file.getPath())) {
                arrayList.add(file);
            }
        }
        return (File[]) arrayList.toArray(EMPTY_FILEARRAY);
    }
}
