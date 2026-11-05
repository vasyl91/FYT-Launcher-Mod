package org.apache.poi.xssf.dev;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.internal.ZipHelper;
import org.apache.poi.util.DocumentHelper;
import org.apache.poi.util.IOUtils;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSSFDump {
    public static void main(String[] strArr) throws Exception {
        for (int i = 0; i < strArr.length; i++) {
            System.out.println("Dumping " + strArr[i]);
            ZipFile zipFileOpenZipFile = ZipHelper.openZipFile(strArr[i]);
            try {
                dump(zipFileOpenZipFile);
                zipFileOpenZipFile.close();
            } catch (Throwable th) {
                zipFileOpenZipFile.close();
                throw th;
            }
        }
    }

    private static void createDirIfMissing(File file) throws RuntimeException {
        if (!file.exists() && !file.mkdir()) {
            throw new RuntimeException("Unable to create directory: " + file);
        }
    }

    private static void recursivelyCreateDirIfMissing(File file) throws RuntimeException {
        if (!file.exists() && !file.mkdirs()) {
            throw new RuntimeException("Unable to recursively create directory: " + file);
        }
    }

    public static void dump(ZipFile zipFile) throws Exception {
        String name = zipFile.getName();
        File file = new File(name.substring(0, name.lastIndexOf(46)));
        createDirIfMissing(file);
        System.out.println("Dumping to directory " + file);
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            String name2 = zipEntryNextElement.getName();
            int iLastIndexOf = name2.lastIndexOf(47);
            if (iLastIndexOf != -1) {
                recursivelyCreateDirIfMissing(new File(file, name2.substring(0, iLastIndexOf)));
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, zipEntryNextElement.getName()));
            try {
                if (zipEntryNextElement.getName().endsWith(".xml") || zipEntryNextElement.getName().endsWith(".vml") || zipEntryNextElement.getName().endsWith(".rels")) {
                    try {
                        XmlObject xmlObject = XmlObject.Factory.parse(DocumentHelper.readDocument(zipFile.getInputStream(zipEntryNextElement)), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
                        XmlOptions xmlOptions = new XmlOptions();
                        xmlOptions.setSavePrettyPrint();
                        xmlObject.save(fileOutputStream, xmlOptions);
                    } catch (XmlException unused) {
                        System.err.println("Failed to parse " + zipEntryNextElement.getName() + ", dumping raw content");
                        IOUtils.copy(zipFile.getInputStream(zipEntryNextElement), fileOutputStream);
                    }
                } else {
                    IOUtils.copy(zipFile.getInputStream(zipEntryNextElement), fileOutputStream);
                }
                fileOutputStream.close();
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        }
    }
}
