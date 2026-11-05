package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import javax.xml.stream.Location;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlOptionsBean;
import org.apache.xmlbeans.impl.common.StaxHelper;
import org.apache.xmlbeans.impl.validator.ValidatingXMLStreamReader;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class StreamInstanceValidator {
    public static void printUsage() {
        System.out.println("Validates the specified instance against the specified schema.");
        System.out.println("A streaming validation useful for validating very large instance ");
        System.out.println("documents with less memory. Contrast with the validate tool.");
        System.out.println("Usage: svalidate [-dl] [-nopvr] [-noupa] [-license] schema.xsd instance.xml");
        System.out.println("Options:");
        System.out.println("    -dl - permit network downloads for imports and includes (default is off)");
        System.out.println("    -noupa - do not enforce the unique particle attribution rule");
        System.out.println("    -nopvr - do not enforce the particle valid (restriction) rule");
        System.out.println("    -license - prints license information");
    }

    public static void main(String[] strArr) {
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add("version");
        hashSet.add("dl");
        hashSet.add("noupr");
        hashSet.add("noupa");
        CommandLine commandLine = new CommandLine(strArr, hashSet, Collections.EMPTY_SET);
        if (commandLine.getOpt("h") == null && commandLine.getOpt("help") == null && commandLine.getOpt("usage") == null) {
            if (strArr.length >= 1) {
                String[] badOpts = commandLine.getBadOpts();
                if (badOpts.length > 0) {
                    for (String str : badOpts) {
                        System.out.println("Unrecognized option: " + str);
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
                if (commandLine.args().length == 0) {
                    printUsage();
                    return;
                }
                boolean z = commandLine.getOpt("dl") != null;
                boolean z2 = commandLine.getOpt("nopvr") != null;
                boolean z3 = commandLine.getOpt("noupa") != null;
                File[] fileArrFilesEndingWith = commandLine.filesEndingWith(".xsd");
                File[] fileArrFilesEndingWith2 = commandLine.filesEndingWith(".xml");
                File[] fileArrFilesEndingWith3 = commandLine.filesEndingWith(".jar");
                ArrayList arrayList = new ArrayList();
                XmlOptions loadLineNumbers = new XmlOptions().setLoadLineNumbers();
                for (int i = 0; i < fileArrFilesEndingWith.length; i++) {
                    try {
                        arrayList.add(XmlObject.Factory.parse(fileArrFilesEndingWith[i], loadLineNumbers.setLoadMessageDigest()));
                    } catch (Exception e) {
                        System.err.println(fileArrFilesEndingWith[i] + " not loadable: " + e);
                    }
                }
                XmlObject[] xmlObjectArr = (XmlObject[]) arrayList.toArray(new XmlObject[0]);
                ArrayList arrayList2 = new ArrayList();
                XmlOptions xmlOptions = new XmlOptions();
                xmlOptions.setErrorListener(arrayList2);
                if (z) {
                    xmlOptions.setCompileDownloadUrls();
                }
                if (z2) {
                    xmlOptions.setCompileNoPvrRule();
                }
                if (z3) {
                    xmlOptions.setCompileNoUpaRule();
                }
                SchemaTypeLoader schemaTypeLoaderTypeLoaderForResource = (fileArrFilesEndingWith3 == null || fileArrFilesEndingWith3.length <= 0) ? null : XmlBeans.typeLoaderForResource(XmlBeans.resourceLoaderForPath(fileArrFilesEndingWith3));
                if (xmlObjectArr != null) {
                    try {
                        if (xmlObjectArr.length > 0) {
                            schemaTypeLoaderTypeLoaderForResource = XmlBeans.compileXsd(xmlObjectArr, schemaTypeLoaderTypeLoaderForResource, xmlOptions);
                        }
                    } catch (Exception e2) {
                        if (arrayList2.isEmpty() || !(e2 instanceof XmlException)) {
                            e2.printStackTrace(System.err);
                        }
                        System.out.println("Schema invalid");
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            System.out.println(it.next());
                        }
                        return;
                    }
                }
                validateFiles(fileArrFilesEndingWith2, schemaTypeLoaderTypeLoaderForResource, loadLineNumbers);
                return;
            }
        }
        printUsage();
        System.exit(0);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public static void validateFiles(File[] fileArr, SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        ValidatingXMLStreamReader validatingXMLStreamReader = new ValidatingXMLStreamReader();
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            String path = file.getPath();
            arrayList.clear();
            long jCurrentTimeMillis = 0;
            try {
                try {
                    try {
                        XMLInputFactory xMLInputFactoryNewXMLInputFactory = StaxHelper.newXMLInputFactory(new XmlOptionsBean(xmlOptions));
                        FileInputStream fileInputStream = new FileInputStream(file);
                        XMLStreamReader xMLStreamReaderCreateXMLStreamReader = xMLInputFactoryNewXMLInputFactory.createXMLStreamReader(path, fileInputStream);
                        while (!xMLStreamReaderCreateXMLStreamReader.isStartElement()) {
                            xMLStreamReaderCreateXMLStreamReader.next();
                        }
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        try {
                            validatingXMLStreamReader.init(xMLStreamReaderCreateXMLStreamReader, true, null, schemaTypeLoader, xmlOptions, arrayList);
                            while (validatingXMLStreamReader.hasNext()) {
                                validatingXMLStreamReader.next();
                            }
                            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                            validatingXMLStreamReader.close();
                            fileInputStream.close();
                        } catch (XMLStreamException e) {
                            e = e;
                            jCurrentTimeMillis = jCurrentTimeMillis2;
                            Location location = e.getLocation();
                            arrayList.add(XmlError.forLocation(e.getMessage(), path, location.getLineNumber(), location.getColumnNumber(), location.getCharacterOffset()));
                        }
                    } catch (XMLStreamException e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    System.err.println("error for file: " + file + ": " + e);
                    e.printStackTrace(System.err);
                }
            } catch (Exception e4) {
                e = e4;
            } catch (XMLStreamException e5) {
                e = e5;
            }
            if (arrayList.isEmpty()) {
                System.out.println(file + " valid. (" + jCurrentTimeMillis + " ms)");
            } else {
                System.out.println(file + " NOT valid (" + jCurrentTimeMillis + " ms):");
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    System.out.println(stringFromError((XmlError) it.next(), path));
                }
            }
        }
    }

    private static String stringFromError(XmlError xmlError, String str) {
        return XmlError.severityAsString(xmlError.getSeverity()) + ": " + str + ":" + xmlError.getLine() + ":" + xmlError.getColumn() + " " + xmlError.getMessage() + " ";
    }
}
