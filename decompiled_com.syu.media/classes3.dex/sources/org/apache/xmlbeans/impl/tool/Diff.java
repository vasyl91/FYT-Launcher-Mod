package org.apache.xmlbeans.impl.tool;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Diff {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static void main(String[] strArr) {
        if (strArr.length != 2) {
            System.out.println("Usage: diff <jarname1> <jarname2> to compare two jars");
            System.out.println("  or   diff <dirname1> <dirname2> to compare two dirs");
            return;
        }
        File file = new File(strArr[0]);
        if (!file.exists()) {
            System.out.println("File \"" + strArr[0] + "\" not found.");
            return;
        }
        File file2 = new File(strArr[1]);
        if (!file2.exists()) {
            System.out.println("File \"" + strArr[1] + "\" not found.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (file.isDirectory()) {
            if (!file2.isDirectory()) {
                System.out.println("Both parameters have to be directories if the first parameter is a directory.");
                return;
            }
            dirsAsTypeSystems(file, file2, arrayList);
        } else if (file2.isDirectory()) {
            System.out.println("Both parameters have to be jar files if the first parameter is a jar file.");
            return;
        } else {
            try {
                jarsAsTypeSystems(new JarFile(file), new JarFile(file2), arrayList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (arrayList.size() < 1) {
            System.out.println("No differences encountered.");
            return;
        }
        System.out.println("Differences:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).toString());
        }
    }

    public static void jarsAsTypeSystems(JarFile jarFile, JarFile jarFile2, List list) {
        Enumeration<JarEntry> enumerationEntries = jarFile.entries();
        Enumeration<JarEntry> enumerationEntries2 = jarFile2.entries();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (enumerationEntries.hasMoreElements()) {
            JarEntry jarEntryNextElement = enumerationEntries.nextElement();
            String name = jarEntryNextElement.getName();
            if (name.startsWith("schema" + SchemaTypeSystemImpl.METADATA_PACKAGE_GEN + "/system/s") && name.endsWith(".xsb")) {
                arrayList.add(jarEntryNextElement);
            }
        }
        while (enumerationEntries2.hasMoreElements()) {
            JarEntry jarEntryNextElement2 = enumerationEntries2.nextElement();
            String name2 = jarEntryNextElement2.getName();
            if (name2.startsWith("schema" + SchemaTypeSystemImpl.METADATA_PACKAGE_GEN + "/system/s") && name2.endsWith(".xsb")) {
                arrayList2.add(jarEntryNextElement2);
            }
        }
        ZipEntry[] zipEntryArr = (ZipEntry[]) arrayList.toArray(new ZipEntry[arrayList.size()]);
        ZipEntry[] zipEntryArr2 = (ZipEntry[]) arrayList2.toArray(new ZipEntry[arrayList2.size()]);
        ZipEntryNameComparator zipEntryNameComparator = new ZipEntryNameComparator();
        Arrays.sort(zipEntryArr, zipEntryNameComparator);
        Arrays.sort(zipEntryArr2, zipEntryNameComparator);
        int i = 0;
        int i2 = 0;
        while (i < zipEntryArr.length && i2 < zipEntryArr2.length) {
            String name3 = zipEntryArr[i].getName();
            String name4 = zipEntryArr2[i2].getName();
            int iCompareTo = name3.compareTo(name4);
            if (iCompareTo == 0) {
                zipEntriesAsXsb(zipEntryArr[i], jarFile, zipEntryArr2[i2], jarFile2, list);
                i++;
            } else if (iCompareTo < 0) {
                list.add("Jar \"" + jarFile.getName() + "\" contains an extra file: \"" + name3 + "\"");
                i++;
            } else if (iCompareTo > 0) {
                list.add("Jar \"" + jarFile2.getName() + "\" contains an extra file: \"" + name4 + "\"");
            }
            i2++;
        }
        while (i < zipEntryArr.length) {
            list.add("Jar \"" + jarFile.getName() + "\" contains an extra file: \"" + zipEntryArr[i].getName() + "\"");
            i++;
        }
        while (i2 < zipEntryArr2.length) {
            list.add("Jar \"" + jarFile2.getName() + "\" contains an extra file: \"" + zipEntryArr2[i2].getName() + "\"");
            i2++;
        }
    }

    public static void dirsAsTypeSystems(File file, File file2, List list) {
        File file3 = new File(file, "schema" + SchemaTypeSystemImpl.METADATA_PACKAGE_GEN + "/system");
        File file4 = new File(file2, "schema" + SchemaTypeSystemImpl.METADATA_PACKAGE_GEN + "/system");
        int i = 0;
        if (file3.exists() && file4.exists()) {
            File[] fileArrListFiles = file3.listFiles();
            File[] fileArrListFiles2 = file4.listFiles();
            if (fileArrListFiles.length == 1 && fileArrListFiles2.length == 1) {
                file3 = fileArrListFiles[0];
                file4 = fileArrListFiles2[0];
            } else {
                if (fileArrListFiles.length == 0) {
                    file3 = null;
                }
                if (fileArrListFiles2.length == 0) {
                    file4 = null;
                }
                if (fileArrListFiles.length > 1) {
                    list.add("More than one typesystem found in dir \"" + file.getName() + "\"");
                    return;
                } else if (fileArrListFiles2.length > 1) {
                    list.add("More than one typesystem found in dir \"" + file2.getName() + "\"");
                    return;
                }
            }
        } else {
            if (!file3.exists()) {
                file3 = null;
            }
            if (!file4.exists()) {
                file4 = null;
            }
        }
        if (file3 == null && file4 == null) {
            return;
        }
        if (file3 == null || file4 == null) {
            if (file3 == null) {
                list.add("No typesystems found in dir \"" + file + "\"");
            }
            if (file4 == null) {
                list.add("No typesystems found in dir \"" + file2 + "\"");
                return;
            }
            return;
        }
        boolean zIsDiffIndex = isDiffIndex();
        XsbFilenameFilter xsbFilenameFilter = new XsbFilenameFilter();
        File[] fileArrListFiles3 = file3.listFiles(xsbFilenameFilter);
        File[] fileArrListFiles4 = file4.listFiles(xsbFilenameFilter);
        FileNameComparator fileNameComparator = new FileNameComparator();
        Arrays.sort(fileArrListFiles3, fileNameComparator);
        Arrays.sort(fileArrListFiles4, fileNameComparator);
        int i2 = 0;
        while (i < fileArrListFiles3.length && i2 < fileArrListFiles4.length) {
            String name = fileArrListFiles3[i].getName();
            String name2 = fileArrListFiles4[i2].getName();
            int iCompareTo = name.compareTo(name2);
            if (iCompareTo == 0) {
                if (zIsDiffIndex || !fileArrListFiles3[i].getName().equals("index.xsb")) {
                    filesAsXsb(fileArrListFiles3[i], fileArrListFiles4[i2], list);
                }
                i++;
            } else if (iCompareTo < 0) {
                list.add("Dir \"" + file3.getName() + "\" contains an extra file: \"" + name + "\"");
                i++;
            } else if (iCompareTo > 0) {
                list.add("Dir \"" + file4.getName() + "\" contains an extra file: \"" + name2 + "\"");
            }
            i2++;
        }
        while (i < fileArrListFiles3.length) {
            list.add("Dir \"" + file3.getName() + "\" contains an extra file: \"" + fileArrListFiles3[i].getName() + "\"");
            i++;
        }
        while (i2 < fileArrListFiles4.length) {
            list.add("Dir \"" + file4.getName() + "\" contains an extra file: \"" + fileArrListFiles4[i2].getName() + "\"");
            i2++;
        }
    }

    private static boolean isDiffIndex() {
        String property = SystemProperties.getProperty("xmlbeans.diff.diffIndex");
        if (property == null) {
            return true;
        }
        return ("0".equals(property) || "false".equalsIgnoreCase(property)) ? false : true;
    }

    public static void filesAsXsb(File file, File file2, List list) {
        try {
            streamsAsXsb(new FileInputStream(file), file.getName(), new FileInputStream(file2), file2.getName(), list);
        } catch (FileNotFoundException | IOException unused) {
        }
    }

    public static void zipEntriesAsXsb(ZipEntry zipEntry, JarFile jarFile, ZipEntry zipEntry2, JarFile jarFile2, List list) {
        try {
            streamsAsXsb(jarFile.getInputStream(zipEntry), zipEntry.getName(), jarFile2.getInputStream(zipEntry2), zipEntry2.getName(), list);
        } catch (IOException unused) {
        }
    }

    public static void streamsAsXsb(InputStream inputStream, String str, InputStream inputStream2, String str2, List list) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        XsbDumper.dump(inputStream, "", new PrintStream(byteArrayOutputStream));
        XsbDumper.dump(inputStream2, "", new PrintStream(byteArrayOutputStream2));
        inputStream.close();
        inputStream2.close();
        readersAsText(new StringReader(byteArrayOutputStream.toString()), str, new StringReader(byteArrayOutputStream2.toString()), str2, list);
    }

    public static void readersAsText(Reader reader, String str, Reader reader2, String str2, List list) throws IOException {
        org.apache.xmlbeans.impl.util.Diff.readersAsText(reader, str, reader2, str2, list);
    }

    private static class XsbFilenameFilter implements FilenameFilter {
        private XsbFilenameFilter() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".xsb");
        }
    }

    private static class ZipEntryNameComparator implements Comparator {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Override // java.util.Comparator
        public boolean equals(Object obj) {
            return this == obj;
        }

        private ZipEntryNameComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((ZipEntry) obj).getName().compareTo(((ZipEntry) obj2).getName());
        }
    }

    private static class FileNameComparator implements Comparator {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Override // java.util.Comparator
        public boolean equals(Object obj) {
            return this == obj;
        }

        private FileNameComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((File) obj).getName().compareTo(((File) obj2).getName());
        }
    }
}
