package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class InstanceValidator {
    public static void printUsage() {
        System.out.println("Validates the specified instance against the specified schema.");
        System.out.println("Contrast with the svalidate tool, which validates using a stream.");
        System.out.println("Usage: validate [-dl] [-nopvr] [-noupa] [-license] schema.xsd instance.xml");
        System.out.println("Options:");
        System.out.println("    -dl - permit network downloads for imports and includes (default is off)");
        System.out.println("    -noupa - do not enforce the unique particle attribution rule");
        System.out.println("    -nopvr - do not enforce the particle valid (restriction) rule");
        System.out.println("    -strict - performs strict(er) validation");
        System.out.println("    -partial - allow partial schema type system");
        System.out.println("    -license - prints license information");
    }

    public static void main(String[] strArr) {
        System.exit(extraMain(strArr));
    }

    public static int extraMain(String[] strArr) {
        int i;
        XmlOptions xmlOptions;
        XmlOptions errorListener;
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add("version");
        hashSet.add("dl");
        hashSet.add("noupa");
        hashSet.add("nopvr");
        hashSet.add("strict");
        hashSet.add("partial");
        CommandLine commandLine = new CommandLine(strArr, hashSet, Collections.EMPTY_SET);
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null || strArr.length < 1) {
            printUsage();
            return 0;
        }
        String[] badOpts = commandLine.getBadOpts();
        if (badOpts.length > 0) {
            for (String str : badOpts) {
                System.out.println("Unrecognized option: " + str);
            }
            printUsage();
            return 0;
        }
        if (commandLine.getOpt("license") != null) {
            CommandLine.printLicense();
            return 0;
        }
        if (commandLine.getOpt("version") != null) {
            CommandLine.printVersion();
            return 0;
        }
        if (commandLine.args().length == 0) {
            return 0;
        }
        boolean z = commandLine.getOpt("dl") != null;
        boolean z2 = commandLine.getOpt("nopvr") != null;
        boolean z3 = commandLine.getOpt("noupa") != null;
        boolean z4 = commandLine.getOpt("strict") != null;
        boolean z5 = commandLine.getOpt("partial") != null;
        File[] fileArrFilesEndingWith = commandLine.filesEndingWith(".xsd");
        File[] fileArrFilesEndingWith2 = commandLine.filesEndingWith(".xml");
        File[] fileArrFilesEndingWith3 = commandLine.filesEndingWith(".jar");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < fileArrFilesEndingWith.length; i2++) {
            try {
                arrayList.add(XmlObject.Factory.parse(fileArrFilesEndingWith[i2], new XmlOptions().setLoadLineNumbers().setLoadMessageDigest()));
            } catch (Exception e) {
                System.err.println(fileArrFilesEndingWith[i2] + " not loadable: " + e);
            }
        }
        XmlObject[] xmlObjectArr = (XmlObject[]) arrayList.toArray(new XmlObject[0]);
        ArrayList arrayList2 = new ArrayList();
        XmlOptions xmlOptions2 = new XmlOptions();
        xmlOptions2.setErrorListener(arrayList2);
        if (z) {
            xmlOptions2.setCompileDownloadUrls();
        }
        if (z2) {
            xmlOptions2.setCompileNoPvrRule();
        }
        if (z3) {
            xmlOptions2.setCompileNoUpaRule();
        }
        if (z5) {
            xmlOptions2.put("COMPILE_PARTIAL_TYPESYSTEM");
        }
        SchemaTypeLoader schemaTypeLoaderTypeLoaderForResource = (fileArrFilesEndingWith3 == null || fileArrFilesEndingWith3.length <= 0) ? null : XmlBeans.typeLoaderForResource(XmlBeans.resourceLoaderForPath(fileArrFilesEndingWith3));
        if (xmlObjectArr != null) {
            try {
                if (xmlObjectArr.length > 0) {
                    schemaTypeLoaderTypeLoaderForResource = XmlBeans.compileXsd(xmlObjectArr, schemaTypeLoaderTypeLoaderForResource, xmlOptions2);
                }
            } catch (Exception e2) {
                if (arrayList2.isEmpty() || !(e2 instanceof XmlException)) {
                    e2.printStackTrace(System.err);
                }
                System.out.println("Schema invalid:".concat(z5 ? " couldn't recover from errors" : ""));
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
                return 10;
            }
        }
        if (!z5 || arrayList2.isEmpty()) {
            i = 0;
        } else {
            System.out.println("Schema invalid: partial schema type system recovered");
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                System.out.println(it2.next());
            }
            i = 11;
        }
        if (schemaTypeLoaderTypeLoaderForResource == null) {
            schemaTypeLoaderTypeLoaderForResource = XmlBeans.getContextTypeLoader();
        }
        int i3 = i;
        for (int i4 = 0; i4 < fileArrFilesEndingWith2.length; i4++) {
            try {
                XmlObject xmlObject = schemaTypeLoaderTypeLoaderForResource.parse(fileArrFilesEndingWith2[i4], (SchemaType) null, new XmlOptions().setLoadLineNumbers("LOAD_LINE_NUMBERS_END_ELEMENT"));
                ArrayList arrayList3 = new ArrayList();
                if (xmlObject.schemaType() == XmlObject.type) {
                    System.out.println(fileArrFilesEndingWith2[i4] + " NOT valid.  ");
                    System.out.println("  Document type not found.");
                } else {
                    if (z4) {
                        xmlOptions = new XmlOptions();
                        errorListener = xmlOptions.setErrorListener(arrayList3).setValidateStrict();
                    } else {
                        xmlOptions = new XmlOptions();
                        errorListener = xmlOptions.setErrorListener(arrayList3);
                    }
                    if (xmlObject.validate(errorListener)) {
                        System.out.println(fileArrFilesEndingWith2[i4] + " valid.");
                    } else {
                        System.out.println(fileArrFilesEndingWith2[i4] + " NOT valid.");
                        Iterator it3 = arrayList3.iterator();
                        while (it3.hasNext()) {
                            System.out.println(it3.next());
                        }
                        i3 = 1;
                    }
                }
            } catch (Exception e3) {
                System.err.println(fileArrFilesEndingWith2[i4] + " not loadable: " + e3);
                e3.printStackTrace(System.err);
            }
        }
        return i3;
    }
}
