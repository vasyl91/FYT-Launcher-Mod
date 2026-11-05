package org.apache.poi.dev;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.poi.openxml4j.opc.internal.ZipHelper;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.util.IOUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class OOXMLPrettyPrint {
    private final DocumentBuilder documentBuilder;
    private final DocumentBuilderFactory documentBuilderFactory;

    public OOXMLPrettyPrint() throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        this.documentBuilderFactory = documentBuilderFactoryNewInstance;
        ZipSecureFile.setMinInflateRatio(1.0E-5d);
        this.documentBuilder = documentBuilderFactoryNewInstance.newDocumentBuilder();
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length <= 1 || strArr.length % 2 != 0) {
            System.err.println("Use:");
            System.err.println("\tjava OOXMLPrettyPrint [<filename> <outfilename>] ...");
            System.exit(1);
        }
        for (int i = 0; i < strArr.length; i += 2) {
            File file = new File(strArr[i]);
            if (!file.exists()) {
                System.err.println("Error, file not found!");
                System.err.println("\t" + file);
                System.exit(2);
            }
            handleFile(file, new File(strArr[i + 1]));
        }
        System.out.println("Done.");
    }

    private static void handleFile(File file, File file2) throws TransformerException, ParserConfigurationException, IOException {
        System.out.println("Reading zip-file " + file + " and writing pretty-printed XML to " + file2);
        ZipFile zipFileOpenZipFile = ZipHelper.openZipFile(file);
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
            try {
                new OOXMLPrettyPrint().handle(zipFileOpenZipFile, zipOutputStream);
                zipOutputStream.close();
                zipFileOpenZipFile.close();
                System.out.println();
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            zipFileOpenZipFile.close();
            System.out.println();
            throw th2;
        }
    }

    private void handle(ZipFile zipFile, ZipOutputStream zipOutputStream) throws TransformerException, IOException {
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            String name = zipEntryNextElement.getName();
            zipOutputStream.putNextEntry(new ZipEntry(name));
            try {
                try {
                    if (name.endsWith(".xml") || name.endsWith(".rels")) {
                        Document document = this.documentBuilder.parse(new InputSource(zipFile.getInputStream(zipEntryNextElement)));
                        document.setXmlStandalone(true);
                        pretty(document, zipOutputStream, 2);
                    } else {
                        System.out.println("Not pretty-printing non-XML file " + name);
                        IOUtils.copy(zipFile.getInputStream(zipEntryNextElement), zipOutputStream);
                    }
                    zipOutputStream.closeEntry();
                    System.out.print(".");
                } catch (Exception e) {
                    throw new IOException("While handling entry " + name, e);
                }
            } catch (Throwable th) {
                zipOutputStream.closeEntry();
                throw th;
            }
        }
    }

    private static void pretty(Document document, OutputStream outputStream, int i) throws TransformerException {
        Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
        transformerNewTransformer.setOutputProperty("encoding", "UTF-8");
        if (i > 0) {
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", Integer.toString(i));
        }
        transformerNewTransformer.transform(new DOMSource(document), new StreamResult(outputStream));
    }
}
