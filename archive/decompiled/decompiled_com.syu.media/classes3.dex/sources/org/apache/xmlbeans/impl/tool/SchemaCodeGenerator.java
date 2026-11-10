package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.repackage.Repackager;
import org.apache.xmlbeans.impl.util.FilerImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SchemaCodeGenerator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Set deleteFileQueue = new HashSet();
    private static int triesRemaining = 0;

    public static void saveTypeSystem(SchemaTypeSystem schemaTypeSystem, File file, File file2, Repackager repackager, XmlOptions xmlOptions) throws IOException {
        schemaTypeSystem.save(new FilerImpl(file, null, repackager, false, false));
    }

    static void deleteObsoleteFiles(File file, File file2, Set set) {
        if (!file.isDirectory() || !file2.isDirectory()) {
            throw new IllegalArgumentException();
        }
        String absolutePath = file2.getAbsolutePath();
        if (absolutePath.length() <= 5) {
            return;
        }
        if (!absolutePath.startsWith("/home/") || (absolutePath.indexOf("/", 6) < absolutePath.length() - 1 && absolutePath.indexOf("/", 6) >= 0)) {
            File[] fileArrListFiles = file2.listFiles();
            for (int i = 0; i < fileArrListFiles.length; i++) {
                if (fileArrListFiles[i].isDirectory()) {
                    deleteObsoleteFiles(file, fileArrListFiles[i], set);
                } else if (!set.contains(fileArrListFiles[i])) {
                    deleteXmlBeansFile(fileArrListFiles[i]);
                    deleteDirRecursively(file, fileArrListFiles[i].getParentFile());
                }
            }
        }
    }

    private static void deleteXmlBeansFile(File file) {
        if (file.getName().endsWith(".java")) {
            file.delete();
        }
    }

    private static void deleteDirRecursively(File file, File file2) {
        String[] list = file2.list();
        while (list != null && list.length == 0 && !file2.equals(file)) {
            file2.delete();
            file2 = file2.getParentFile();
            list = file2.list();
        }
    }

    protected static File createTempDir() throws IOException {
        String str;
        try {
            new File(SystemProperties.getProperty("java.io.tmpdir")).mkdirs();
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = null;
        File fileCreateTempFile = File.createTempFile("xbean", null);
        String absolutePath = fileCreateTempFile.getAbsolutePath();
        if (!absolutePath.endsWith(".tmp")) {
            throw new IOException("Error: createTempFile did not create a file ending with .tmp");
        }
        int i = 0;
        String strSubstring = absolutePath.substring(0, absolutePath.length() - 4);
        while (i < 100) {
            StringBuilder sbAppend = new StringBuilder().append(strSubstring).append(".d");
            if (i == 0) {
                str = "";
            } else {
                int i2 = i + 1;
                String string = Integer.toString(i);
                i = i2;
                str = string;
            }
            File file2 = new File(sbAppend.append(str).toString());
            if (!file2.exists()) {
                file2.mkdirs();
                file = file2;
                break;
            }
            i++;
            file = file2;
        }
        fileCreateTempFile.deleteOnExit();
        return file;
    }

    protected static void tryHardToDelete(File file) {
        tryToDelete(file);
        if (file.exists()) {
            tryToDeleteLater(file);
        }
    }

    private static void tryToDelete(File file) {
        String[] list;
        if (file.exists()) {
            if (file.isDirectory() && (list = file.list()) != null) {
                for (String str : list) {
                    tryToDelete(new File(file, str));
                }
            }
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean tryNowThatItsLater() {
        ArrayList<File> arrayList;
        boolean z;
        synchronized (deleteFileQueue) {
            arrayList = new ArrayList(deleteFileQueue);
            deleteFileQueue.clear();
        }
        ArrayList arrayList2 = new ArrayList();
        for (File file : arrayList) {
            tryToDelete(file);
            if (file.exists()) {
                arrayList2.add(file);
            }
        }
        synchronized (deleteFileQueue) {
            int i = triesRemaining;
            z = true;
            if (i > 0) {
                triesRemaining = i - 1;
            }
            if (triesRemaining <= 0 || arrayList2.size() == 0) {
                triesRemaining = 0;
            } else {
                deleteFileQueue.addAll(arrayList2);
            }
            if (triesRemaining > 0) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void giveUp() {
        synchronized (deleteFileQueue) {
            deleteFileQueue.clear();
            triesRemaining = 0;
        }
    }

    private static void tryToDeleteLater(File file) {
        synchronized (deleteFileQueue) {
            deleteFileQueue.add(file);
            if (triesRemaining == 0) {
                new Thread() { // from class: org.apache.xmlbeans.impl.tool.SchemaCodeGenerator.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        while (!SchemaCodeGenerator.tryNowThatItsLater()) {
                            try {
                                Thread.sleep(3000L);
                            } catch (InterruptedException unused) {
                                SchemaCodeGenerator.giveUp();
                                return;
                            }
                        }
                    }
                };
            }
            if (triesRemaining < 10) {
                triesRemaining = 10;
            }
        }
    }
}
