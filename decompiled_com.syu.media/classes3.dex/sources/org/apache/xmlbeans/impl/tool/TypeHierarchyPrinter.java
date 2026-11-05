package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class TypeHierarchyPrinter {
    public static void printUsage() {
        System.out.println("Prints the inheritance hierarchy of types defined in a schema.\n");
        System.out.println("Usage: xsdtree [-noanon] [-nopvr] [-noupa] [-partial] [-license] schemafile.xsd*");
        System.out.println("    -noanon - Don't include anonymous types in the tree.");
        System.out.println("    -noupa - do not enforce the unique particle attribution rule");
        System.out.println("    -nopvr - do not enforce the particle valid (restriction) rule");
        System.out.println("    -partial - Print only part of the hierarchy.");
        System.out.println("    -license - prints license information");
        System.out.println("    schemafile.xsd - File containing the schema for which to print a tree.");
        System.out.println();
    }

    public static void main(String[] strArr) throws Exception {
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add("version");
        hashSet.add("noanon");
        hashSet.add("noupr");
        hashSet.add("noupa");
        hashSet.add("partial");
        CommandLine commandLine = new CommandLine(strArr, hashSet, Collections.EMPTY_SET);
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
            printUsage();
            System.exit(0);
            return;
        }
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
        boolean z = commandLine.getOpt("noanon") != null;
        boolean z2 = commandLine.getOpt("nopvr") != null;
        boolean z3 = commandLine.getOpt("noupa") != null;
        boolean z4 = commandLine.getOpt("partial") != null;
        File[] fileArrFilesEndingWith = commandLine.filesEndingWith(".xsd");
        File[] fileArrFilesEndingWith2 = commandLine.filesEndingWith(".jar");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < fileArrFilesEndingWith.length; i++) {
            try {
                arrayList.add(SchemaDocument.Factory.parse(fileArrFilesEndingWith[i], new XmlOptions().setLoadLineNumbers()));
            } catch (Exception e) {
                System.err.println(fileArrFilesEndingWith[i] + " not loadable: " + e);
            }
        }
        XmlObject[] xmlObjectArr = (XmlObject[]) arrayList.toArray(new XmlObject[0]);
        ArrayList arrayList2 = new ArrayList();
        XmlOptions xmlOptions = new XmlOptions();
        xmlOptions.setErrorListener(arrayList2);
        xmlOptions.setCompileDownloadUrls();
        if (z2) {
            xmlOptions.setCompileNoPvrRule();
        }
        if (z3) {
            xmlOptions.setCompileNoUpaRule();
        }
        if (z4) {
            xmlOptions.put("COMPILE_PARTIAL_TYPESYSTEM");
        }
        try {
            SchemaTypeSystem schemaTypeSystemCompileXsd = XmlBeans.compileXsd(xmlObjectArr, (fileArrFilesEndingWith2 == null || fileArrFilesEndingWith2.length <= 0) ? null : XmlBeans.typeLoaderForResource(XmlBeans.resourceLoaderForPath(fileArrFilesEndingWith2)), xmlOptions);
            if (z4 && !arrayList2.isEmpty()) {
                System.out.println("Schema invalid: partial schema type system recovered");
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
            }
            HashMap map = new HashMap();
            map.put(XMLValidationSchema.SCHEMA_ID_DTD, Sax2Dom.XML_PREFIX);
            map.put(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "xs");
            System.out.println("xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"");
            HashMap map2 = new HashMap();
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(Arrays.asList(schemaTypeSystemCompileXsd.documentTypes()));
            arrayList3.addAll(Arrays.asList(schemaTypeSystemCompileXsd.attributeTypes()));
            arrayList3.addAll(Arrays.asList(schemaTypeSystemCompileXsd.globalTypes()));
            for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                SchemaType schemaType = (SchemaType) arrayList3.get(i2);
                if (!z) {
                    arrayList3.addAll(Arrays.asList(schemaType.getAnonymousTypes()));
                }
                if (!schemaType.isDocumentType() && !schemaType.isAttributeType() && schemaType != XmlObject.type) {
                    noteNamespace(map, schemaType);
                    Collection arrayList4 = (Collection) map2.get(schemaType.getBaseType());
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                        map2.put(schemaType.getBaseType(), arrayList4);
                        if (schemaType.getBaseType().isBuiltinType()) {
                            arrayList3.add(schemaType.getBaseType());
                        }
                    }
                    arrayList4.add(schemaType);
                }
            }
            ArrayList arrayList5 = new ArrayList();
            arrayList5.add(XmlObject.type);
            StringBuffer stringBuffer = new StringBuffer();
            while (!arrayList5.isEmpty()) {
                SchemaType schemaType2 = (SchemaType) arrayList5.remove(arrayList5.size() - 1);
                if (schemaType2 == null) {
                    stringBuffer.setLength(Math.max(0, stringBuffer.length() - 2));
                } else {
                    System.out.println(((Object) stringBuffer) + "+-" + QNameHelper.readable(schemaType2, map) + notes(schemaType2));
                    Collection collection = (Collection) map2.get(schemaType2);
                    if (collection != null && collection.size() > 0) {
                        stringBuffer.append((arrayList5.size() == 0 || arrayList5.get(arrayList5.size() - 1) == null) ? "  " : "| ");
                        arrayList5.add(null);
                        arrayList5.addAll(collection);
                    }
                }
            }
        } catch (XmlException e2) {
            System.out.println("Schema invalid:".concat(z4 ? " couldn't recover from errors" : ""));
            if (arrayList2.isEmpty()) {
                System.out.println(e2.getMessage());
                return;
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                System.out.println(it2.next());
            }
        }
    }

    private static String notes(SchemaType schemaType) {
        if (schemaType.isBuiltinType()) {
            return " (builtin)";
        }
        if (schemaType.isSimpleType()) {
            int simpleVariety = schemaType.getSimpleVariety();
            if (simpleVariety == 2) {
                return " (union)";
            }
            if (simpleVariety != 3) {
                return schemaType.getEnumerationValues() != null ? " (enumeration)" : "";
            }
            return " (list)";
        }
        int contentType = schemaType.getContentType();
        if (contentType != 2) {
            return contentType != 4 ? "" : " (mixed)";
        }
        return " (complex)";
    }

    private static void noteNamespace(Map map, SchemaType schemaType) {
        String strNamespace = QNameHelper.namespace(schemaType);
        if (strNamespace.equals("") || map.containsKey(strNamespace)) {
            return;
        }
        String strSuggestPrefix = QNameHelper.suggestPrefix(strNamespace);
        int i = 0;
        String str = strSuggestPrefix;
        while (map.containsValue(str)) {
            str = strSuggestPrefix + i;
            i++;
        }
        map.put(strNamespace, str);
        System.out.println(Sax2Dom.XMLNS_STRING + str + "=\"" + strNamespace + "\"");
    }
}
