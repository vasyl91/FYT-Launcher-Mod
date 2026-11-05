package org.apache.poi.dev;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.poi.util.XMLHelper;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class RecordGenerator {
    public static void main(String[] strArr) throws Exception {
        Class.forName("org.apache.poi.generator.FieldIterator");
        if (strArr.length != 4) {
            System.out.println("Usage:");
            System.out.println("  java org.apache.poi.hssf.util.RecordGenerator RECORD_DEFINTIONS RECORD_STYLES DEST_SRC_PATH TEST_SRC_PATH");
        } else {
            generateRecords(strArr[0], strArr[1], strArr[2], strArr[3]);
        }
    }

    private static void generateRecords(String str, String str2, String str3, String str4) throws Exception {
        int i;
        File[] fileArr;
        File[] fileArrListFiles = new File(str).listFiles();
        if (fileArrListFiles == null) {
            System.err.println(str + " is not a directory.");
            return;
        }
        int length = fileArrListFiles.length;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            File file = fileArrListFiles[i3];
            if (file.isFile() && (file.getName().endsWith("_record.xml") || file.getName().endsWith("_type.xml"))) {
                Element documentElement = XMLHelper.getDocumentBuilderFactory().newDocumentBuilder().parse(file).getDocumentElement();
                String nodeValue = documentElement.getElementsByTagName("extends").item(i2).getFirstChild().getNodeValue();
                String nodeValue2 = documentElement.getElementsByTagName("suffix").item(i2).getFirstChild().getNodeValue();
                String nodeValue3 = documentElement.getAttributes().getNamedItem("name").getNodeValue();
                String strReplace = documentElement.getAttributes().getNamedItem("package").getNodeValue().replace('.', '/');
                String str5 = str3 + "/" + strReplace;
                File file2 = new File(str5);
                if (!file2.mkdirs()) {
                    throw new IOException("Could not create directory " + file2);
                }
                System.out.println("Created destination directory: " + str5);
                String str6 = str5 + "/" + nodeValue3 + nodeValue2 + ".java";
                i = length;
                fileArr = fileArrListFiles;
                transform(file, new File(str6), new File(str2 + "/" + nodeValue.toLowerCase(Locale.ROOT) + ".xsl"));
                System.out.println("Generated " + nodeValue2 + ": " + str6);
                String str7 = str4 + "/" + strReplace;
                File file3 = new File(str7);
                if (!file3.mkdirs()) {
                    throw new IOException("Could not create directory " + file3);
                }
                System.out.println("Created destination directory: " + str7);
                String str8 = str7 + "/Test" + nodeValue3 + nodeValue2 + ".java";
                if (!new File(str8).exists()) {
                    transform(file, new File(str8), new File(str2 + "/" + nodeValue.toLowerCase(Locale.ROOT) + "_test.xsl"));
                    System.out.println("Generated test: " + str8);
                } else {
                    System.out.println("Skipped test generation: " + str8);
                }
            } else {
                i = length;
                fileArr = fileArrListFiles;
            }
            i3++;
            length = i;
            fileArrListFiles = fileArr;
            i2 = 0;
        }
    }

    private static void transform(File file, File file2, File file3) throws TransformerException, FileNotFoundException {
        try {
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer(new StreamSource(file3));
            Properties properties = new Properties();
            properties.setProperty("method", "text");
            transformerNewTransformer.setOutputProperties(properties);
            transformerNewTransformer.transform(new StreamSource(file), new StreamResult(file2));
        } catch (TransformerException e) {
            System.err.println("Error compiling XSL style sheet " + file3);
            throw e;
        }
    }
}
