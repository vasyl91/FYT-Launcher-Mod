package org.apache.xmlbeans.impl.xsd2inst;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.tool.CommandLine;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SchemaInstanceGenerator {

    public static class Xsd2InstOptions {
        private boolean _downloads = false;
        private boolean _nopvr = false;
        private boolean _noupa = false;

        public boolean isNetworkDownloads() {
            return this._downloads;
        }

        public void setNetworkDownloads(boolean z) {
            this._downloads = z;
        }

        public boolean isNopvr() {
            return this._nopvr;
        }

        public void setNopvr(boolean z) {
            this._nopvr = z;
        }

        public boolean isNoupa() {
            return this._noupa;
        }

        public void setNoupa(boolean z) {
            this._noupa = z;
        }
    }

    public static void printUsage() {
        System.out.println("Generates a document based on the given Schema file");
        System.out.println("having the given element as root.");
        System.out.println("The tool makes reasonable attempts to create a valid document,");
        System.out.println("but this is not always possible since, for example, ");
        System.out.println("there are schemas for which no valid instance document ");
        System.out.println("can be produced.");
        System.out.println("Usage: xsd2inst [flags] schema.xsd -name element_name");
        System.out.println("Flags:");
        System.out.println("    -name    the name of the root element");
        System.out.println("    -dl      enable network downloads for imports and includes");
        System.out.println("    -nopvr   disable particle valid (restriction) rule");
        System.out.println("    -noupa   disable unique particle attribution rule");
        System.out.println("    -license prints license information");
        System.out.println("    -version prints version information");
    }

    public static void main(String[] strArr) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add("version");
        hashSet.add("dl");
        hashSet.add("noupa");
        hashSet.add("nopvr");
        hashSet.add("partial");
        hashSet2.add("name");
        CommandLine commandLine = new CommandLine(strArr, hashSet, hashSet2);
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
            printUsage();
            return;
        }
        String[] badOpts = commandLine.getBadOpts();
        int i = 0;
        if (badOpts.length > 0) {
            while (i < badOpts.length) {
                System.out.println("Unrecognized option: " + badOpts[i]);
                i++;
            }
            printUsage();
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
        boolean z = commandLine.getOpt("dl") != null;
        boolean z2 = commandLine.getOpt("nopvr") != null;
        boolean z3 = commandLine.getOpt("noupa") != null;
        File[] fileArrFilesEndingWith = commandLine.filesEndingWith(".xsd");
        String opt = commandLine.getOpt("name");
        if (opt == null) {
            System.out.println("Required option \"-name\" must be present");
            return;
        }
        ArrayList arrayList = new ArrayList();
        while (i < fileArrFilesEndingWith.length) {
            try {
                arrayList.add(XmlObject.Factory.parse(fileArrFilesEndingWith[i], new XmlOptions().setLoadLineNumbers().setLoadMessageDigest()));
            } catch (Exception e) {
                System.err.println("Can not load schema file: " + fileArrFilesEndingWith[i] + ": ");
                e.printStackTrace();
            }
            i++;
        }
        XmlObject[] xmlObjectArr = (XmlObject[]) arrayList.toArray(new XmlObject[arrayList.size()]);
        Xsd2InstOptions xsd2InstOptions = new Xsd2InstOptions();
        xsd2InstOptions.setNetworkDownloads(z);
        xsd2InstOptions.setNopvr(z2);
        xsd2InstOptions.setNoupa(z3);
        System.out.println(xsd2inst(xmlObjectArr, opt, xsd2InstOptions));
    }

    public static String xsd2inst(String[] strArr, String str, Xsd2InstOptions xsd2InstOptions) throws XmlException, IOException {
        Reader[] readerArr = new Reader[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            readerArr[i] = new StringReader(strArr[i]);
        }
        return xsd2inst(readerArr, str, xsd2InstOptions);
    }

    public static String xsd2inst(Reader[] readerArr, String str, Xsd2InstOptions xsd2InstOptions) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readerArr.length; i++) {
            try {
                arrayList.add(XmlObject.Factory.parse(readerArr[i], new XmlOptions().setLoadLineNumbers().setLoadMessageDigest()));
            } catch (Exception e) {
                System.err.println("Can not load schema reader: " + i + "  " + readerArr[i] + ": ");
                e.printStackTrace();
            }
        }
        return xsd2inst((XmlObject[]) arrayList.toArray(new XmlObject[arrayList.size()]), str, xsd2InstOptions);
    }

    public static String xsd2inst(XmlObject[] xmlObjectArr, String str, Xsd2InstOptions xsd2InstOptions) {
        SchemaTypeSystem schemaTypeSystemCompileXsd;
        SchemaType schemaType = null;
        if (xmlObjectArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            XmlOptions xmlOptions = new XmlOptions();
            if (xsd2InstOptions.isNetworkDownloads()) {
                xmlOptions.setCompileDownloadUrls();
            }
            if (xsd2InstOptions.isNopvr()) {
                xmlOptions.setCompileNoPvrRule();
            }
            if (xsd2InstOptions.isNoupa()) {
                xmlOptions.setCompileNoUpaRule();
            }
            try {
                schemaTypeSystemCompileXsd = XmlBeans.compileXsd(xmlObjectArr, XmlBeans.getBuiltinTypeSystem(), xmlOptions);
            } catch (Exception e) {
                if (arrayList.isEmpty() || !(e instanceof XmlException)) {
                    e.printStackTrace();
                }
                System.out.println("Schema compilation errors: ");
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
                schemaTypeSystemCompileXsd = null;
            }
        } else {
            schemaTypeSystemCompileXsd = null;
        }
        if (schemaTypeSystemCompileXsd == null) {
            throw new RuntimeException("No Schemas to process.");
        }
        SchemaType[] schemaTypeArrDocumentTypes = schemaTypeSystemCompileXsd.documentTypes();
        for (int i = 0; i < schemaTypeArrDocumentTypes.length; i++) {
            if (str.equals(schemaTypeArrDocumentTypes[i].getDocumentElementName().getLocalPart())) {
                schemaType = schemaTypeArrDocumentTypes[i];
                break;
            }
        }
        if (schemaType == null) {
            throw new RuntimeException("Could not find a global element with name \"" + str + "\"");
        }
        return SampleXmlUtil.createSampleForType(schemaType);
    }
}
