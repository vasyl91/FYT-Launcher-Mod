package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class FactorImports {
    public static void printUsage() {
        System.out.println("Refactors a directory of XSD files to remove name conflicts.");
        System.out.println("Usage: sfactor [-import common.xsd] [-out outputdir] inputdir");
        System.out.println("    -import common.xsd - The XSD file to contain redundant ");
        System.out.println("                         definitions for importing.");
        System.out.println("    -out outputdir - The directory into which to place XSD ");
        System.out.println("                     files resulting from refactoring, ");
        System.out.println("                     plus a commonly imported common.xsd.");
        System.out.println("    inputdir - The directory containing the XSD files with");
        System.out.println("               redundant definitions.");
        System.out.println("    -license - Print license information.");
        System.out.println();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
    public static void main(String[] strArr) throws Exception {
        File file;
        Map map;
        File file2;
        HashSet hashSet;
        HashMap map2;
        HashSet hashSet2;
        int i;
        HashMap map3;
        HashSet hashSet3;
        String str = "warning: ";
        HashSet hashSet4 = new HashSet();
        hashSet4.add("h");
        hashSet4.add("help");
        hashSet4.add("usage");
        hashSet4.add("license");
        hashSet4.add("version");
        String str2 = "out";
        CommandLine commandLine = new CommandLine(strArr, hashSet4, Arrays.asList("import", "out"));
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null || strArr.length < 1) {
            printUsage();
            System.exit(0);
            return;
        }
        String[] badOpts = commandLine.getBadOpts();
        if (badOpts.length > 0) {
            for (String str3 : badOpts) {
                System.out.println("Unrecognized option: " + str3);
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
        String[] strArrArgs = commandLine.args();
        if (strArrArgs.length != 1) {
            System.exit(0);
            return;
        }
        String opt = commandLine.getOpt("import");
        if (opt == null) {
            opt = "common.xsd";
        }
        String opt2 = commandLine.getOpt("out");
        if (opt2 == null) {
            System.out.println("Using output directory 'out'");
        } else {
            str2 = opt2;
        }
        File file3 = new File(str2);
        File file4 = new File(strArrArgs[0]);
        File[] files = commandLine.getFiles();
        HashMap map4 = new HashMap();
        HashSet hashSet5 = new HashSet();
        HashSet hashSet6 = new HashSet();
        HashSet hashSet7 = new HashSet();
        HashSet hashSet8 = new HashSet();
        HashSet hashSet9 = new HashSet();
        HashSet hashSet10 = new HashSet();
        HashSet hashSet11 = new HashSet();
        HashSet hashSet12 = new HashSet();
        HashSet hashSet13 = new HashSet();
        File file5 = file4;
        HashSet hashSet14 = new HashSet();
        String str4 = opt;
        HashSet hashSet15 = new HashSet();
        int i2 = 0;
        while (i2 < files.length) {
            try {
                try {
                    SchemaDocument schemaDocument = SchemaDocument.Factory.parse(files[i2]);
                    HashSet hashSet16 = hashSet14;
                    try {
                        map4.put(schemaDocument, files[i2]);
                        if (schemaDocument.getSchema().sizeOfImportArray() > 0 || schemaDocument.getSchema().sizeOfIncludeArray() > 0) {
                            map3 = map4;
                            try {
                                System.out.println(str + files[i2] + " contains imports or includes that are being ignored.");
                            } catch (XmlException e) {
                                e = e;
                                str = str;
                                i = i2;
                                hashSet3 = hashSet16;
                                System.out.println(str + files[i] + " is not a schema file - " + e.getError().toString());
                                i2 = i + 1;
                                hashSet14 = hashSet3;
                                map4 = map3;
                                str = str;
                            }
                        } else {
                            map3 = map4;
                        }
                        try {
                            String targetNamespace = schemaDocument.getSchema().getTargetNamespace();
                            if (targetNamespace == null) {
                                targetNamespace = "";
                            }
                            i = i2;
                            for (TopLevelComplexType topLevelComplexType : schemaDocument.getSchema().getComplexTypeArray()) {
                                try {
                                    try {
                                        noteName(topLevelComplexType.getName(), targetNamespace, hashSet7, hashSet12, hashSet15);
                                    } catch (XmlException e2) {
                                        e = e2;
                                        hashSet3 = hashSet16;
                                        System.out.println(str + files[i] + " is not a schema file - " + e.getError().toString());
                                        i2 = i + 1;
                                        hashSet14 = hashSet3;
                                        map4 = map3;
                                        str = str;
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    System.err.println("Unable to load " + files[i] + " - " + e.getMessage());
                                    System.exit(1);
                                    return;
                                }
                            }
                            for (TopLevelSimpleType topLevelSimpleType : schemaDocument.getSchema().getSimpleTypeArray()) {
                                noteName(topLevelSimpleType.getName(), targetNamespace, hashSet7, hashSet12, hashSet15);
                            }
                            for (TopLevelElement topLevelElement : schemaDocument.getSchema().getElementArray()) {
                                noteName(topLevelElement.getName(), targetNamespace, hashSet5, hashSet10, hashSet15);
                            }
                            for (TopLevelAttribute topLevelAttribute : schemaDocument.getSchema().getAttributeArray()) {
                                noteName(topLevelAttribute.getName(), targetNamespace, hashSet6, hashSet11, hashSet15);
                            }
                            for (NamedGroup namedGroup : schemaDocument.getSchema().getGroupArray()) {
                                noteName(namedGroup.getName(), targetNamespace, hashSet8, hashSet13, hashSet15);
                            }
                            NamedAttributeGroup[] attributeGroupArray = schemaDocument.getSchema().getAttributeGroupArray();
                            int i3 = 0;
                            while (i3 < attributeGroupArray.length) {
                                hashSet3 = hashSet16;
                                try {
                                    noteName(attributeGroupArray[i3].getName(), targetNamespace, hashSet9, hashSet3, hashSet15);
                                    i3++;
                                    hashSet16 = hashSet3;
                                } catch (XmlException e4) {
                                    e = e4;
                                    System.out.println(str + files[i] + " is not a schema file - " + e.getError().toString());
                                    i2 = i + 1;
                                    hashSet14 = hashSet3;
                                    map4 = map3;
                                    str = str;
                                }
                            }
                            hashSet3 = hashSet16;
                        } catch (XmlException e5) {
                            e = e5;
                            i = i2;
                            hashSet3 = hashSet16;
                            System.out.println(str + files[i] + " is not a schema file - " + e.getError().toString());
                            i2 = i + 1;
                            hashSet14 = hashSet3;
                            map4 = map3;
                            str = str;
                        }
                    } catch (XmlException e6) {
                        e = e6;
                        str = str;
                        i = i2;
                        map3 = map4;
                    }
                } catch (IOException e7) {
                    e = e7;
                    i = i2;
                }
            } catch (XmlException e8) {
                e = e8;
                str = str;
                i = i2;
                map3 = map4;
                hashSet3 = hashSet14;
            }
            i2 = i + 1;
            hashSet14 = hashSet3;
            map4 = map3;
            str = str;
        }
        Map map5 = map4;
        HashSet hashSet17 = hashSet14;
        if (map5.size() == 0) {
            System.out.println("No schema files found.");
            System.exit(0);
            return;
        }
        if (hashSet12.size() + hashSet10.size() + hashSet11.size() + hashSet13.size() + hashSet17.size() == 0) {
            System.out.println("No duplicate names found.");
            System.exit(0);
            return;
        }
        HashMap map6 = new HashMap();
        HashMap map7 = new HashMap();
        int i4 = hashSet15.size() == 1 ? 0 : 1;
        for (Iterator it = hashSet15.iterator(); it.hasNext(); it = it) {
            String str5 = (String) it.next();
            SchemaDocument schemaDocument2 = SchemaDocument.Factory.parse("<xs:schema xmlns:xs='http://www.w3.org/2001/XMLSchema'/>");
            if (str5.length() > 0) {
                schemaDocument2.getSchema().setTargetNamespace(str5);
            }
            schemaDocument2.getSchema().setElementFormDefault(FormChoice.QUALIFIED);
            map6.put(str5, schemaDocument2);
            String str6 = str4;
            map7.put(schemaDocument2, commonFileFor(str6, str5, i4, file3));
            i4++;
            hashSet9 = hashSet9;
            str4 = str6;
        }
        HashSet hashSet18 = hashSet9;
        File file6 = file3;
        Iterator it2 = map5.keySet().iterator();
        while (it2.hasNext()) {
            SchemaDocument schemaDocument3 = (SchemaDocument) it2.next();
            String targetNamespace2 = schemaDocument3.getSchema().getTargetNamespace();
            if (targetNamespace2 == null) {
                targetNamespace2 = "";
            }
            SchemaDocument schemaDocument4 = (SchemaDocument) map6.get(targetNamespace2);
            HashMap map8 = map6;
            TopLevelComplexType[] complexTypeArray = schemaDocument3.getSchema().getComplexTypeArray();
            Iterator it3 = it2;
            int length = complexTypeArray.length - 1;
            boolean z = false;
            while (length >= 0) {
                HashMap map9 = map7;
                if (isDuplicate(complexTypeArray[length].getName(), targetNamespace2, hashSet12)) {
                    if (isFirstDuplicate(complexTypeArray[length].getName(), targetNamespace2, hashSet7, hashSet12)) {
                        schemaDocument4.getSchema().addNewComplexType().set(complexTypeArray[length]);
                    }
                    schemaDocument3.getSchema().removeComplexType(length);
                    z = true;
                } else {
                    file6 = file6;
                }
                length--;
                file6 = file6;
                map7 = map9;
            }
            HashMap map10 = map7;
            File file7 = file6;
            TopLevelSimpleType[] simpleTypeArray = schemaDocument3.getSchema().getSimpleTypeArray();
            for (int i5 = 0; i5 < simpleTypeArray.length; i5++) {
                if (isDuplicate(simpleTypeArray[i5].getName(), targetNamespace2, hashSet12)) {
                    if (isFirstDuplicate(simpleTypeArray[i5].getName(), targetNamespace2, hashSet7, hashSet12)) {
                        schemaDocument4.getSchema().addNewSimpleType().set(simpleTypeArray[i5]);
                    }
                    schemaDocument3.getSchema().removeSimpleType(i5);
                    z = true;
                }
            }
            TopLevelElement[] elementArray = schemaDocument3.getSchema().getElementArray();
            for (int i6 = 0; i6 < elementArray.length; i6++) {
                if (isDuplicate(elementArray[i6].getName(), targetNamespace2, hashSet10)) {
                    if (isFirstDuplicate(elementArray[i6].getName(), targetNamespace2, hashSet5, hashSet10)) {
                        schemaDocument4.getSchema().addNewElement().set(elementArray[i6]);
                    }
                    schemaDocument3.getSchema().removeElement(i6);
                    z = true;
                }
            }
            TopLevelAttribute[] attributeArray = schemaDocument3.getSchema().getAttributeArray();
            for (int i7 = 0; i7 < attributeArray.length; i7++) {
                if (isDuplicate(attributeArray[i7].getName(), targetNamespace2, hashSet11)) {
                    if (isFirstDuplicate(attributeArray[i7].getName(), targetNamespace2, hashSet6, hashSet11)) {
                        schemaDocument4.getSchema().addNewElement().set(attributeArray[i7]);
                    }
                    schemaDocument3.getSchema().removeElement(i7);
                    z = true;
                }
            }
            NamedGroup[] groupArray = schemaDocument3.getSchema().getGroupArray();
            for (int i8 = 0; i8 < groupArray.length; i8++) {
                if (isDuplicate(groupArray[i8].getName(), targetNamespace2, hashSet13)) {
                    if (isFirstDuplicate(groupArray[i8].getName(), targetNamespace2, hashSet8, hashSet13)) {
                        schemaDocument4.getSchema().addNewElement().set(groupArray[i8]);
                    }
                    schemaDocument3.getSchema().removeElement(i8);
                    z = true;
                }
            }
            NamedAttributeGroup[] attributeGroupArray2 = schemaDocument3.getSchema().getAttributeGroupArray();
            int i9 = 0;
            while (i9 < attributeGroupArray2.length) {
                if (isDuplicate(attributeGroupArray2[i9].getName(), targetNamespace2, hashSet17)) {
                    hashSet2 = hashSet18;
                    if (isFirstDuplicate(attributeGroupArray2[i9].getName(), targetNamespace2, hashSet2, hashSet17)) {
                        schemaDocument4.getSchema().addNewElement().set(attributeGroupArray2[i9]);
                    }
                    schemaDocument3.getSchema().removeElement(i9);
                    z = true;
                } else {
                    hashSet2 = hashSet18;
                    hashSet13 = hashSet13;
                }
                i9++;
                hashSet13 = hashSet13;
                hashSet18 = hashSet2;
            }
            HashSet hashSet19 = hashSet18;
            HashSet hashSet20 = hashSet13;
            if (z) {
                IncludeDocument.Include includeAddNewInclude = schemaDocument3.getSchema().addNewInclude();
                map = map5;
                File file8 = (File) map.get(schemaDocument3);
                file = file5;
                file2 = file7;
                File fileOutputFileFor = outputFileFor(file8, file, file2);
                hashSet = hashSet12;
                map2 = map10;
                File file9 = (File) map2.get(schemaDocument4);
                if (targetNamespace2 != null) {
                    includeAddNewInclude.setSchemaLocation(relativeURIFor(fileOutputFileFor, file9));
                }
            } else {
                file = file5;
                map = map5;
                file2 = file7;
                hashSet = hashSet12;
                map2 = map10;
            }
            map5 = map;
            map7 = map2;
            hashSet12 = hashSet;
            map6 = map8;
            hashSet13 = hashSet20;
            file5 = file;
            hashSet18 = hashSet19;
            file6 = file2;
            it2 = it3;
        }
        HashMap map11 = map7;
        File file10 = file6;
        File file11 = file5;
        Map map12 = map5;
        if (!file10.isDirectory() && !file10.mkdirs()) {
            System.err.println("Unable to makedir " + file10);
            System.exit(1);
            return;
        }
        for (SchemaDocument schemaDocument5 : map12.keySet()) {
            File file12 = (File) map12.get(schemaDocument5);
            File fileOutputFileFor2 = outputFileFor(file12, file11, file10);
            if (fileOutputFileFor2 == null) {
                System.out.println("Cannot copy " + file12);
            } else {
                schemaDocument5.save(fileOutputFileFor2, new XmlOptions().setSavePrettyPrint().setSaveAggresiveNamespaces());
            }
        }
        for (SchemaDocument schemaDocument6 : map11.keySet()) {
            schemaDocument6.save((File) map11.get(schemaDocument6), new XmlOptions().setSavePrettyPrint().setSaveAggresiveNamespaces());
        }
    }

    private static File outputFileFor(File file, File file2, File file3) {
        URI uriRelativize = file2.getAbsoluteFile().toURI().relativize(file.getAbsoluteFile().toURI());
        if (uriRelativize.isAbsolute()) {
            System.out.println("Cannot relativize " + file);
            return null;
        }
        return new File(CodeGenUtil.resolve(file3.toURI(), uriRelativize));
    }

    private static URI commonAncestor(URI uri, URI uri2) {
        String string = uri.toString();
        String string2 = uri2.toString();
        int length = string.length();
        if (string2.length() < length) {
            length = string2.length();
        }
        int i = 0;
        while (i < length && string.charAt(i) == string2.charAt(i)) {
            i++;
        }
        int iLastIndexOf = i - 1;
        if (iLastIndexOf >= 0) {
            iLastIndexOf = string.lastIndexOf(47, iLastIndexOf);
        }
        if (iLastIndexOf < 0) {
            return null;
        }
        try {
            return new URI(string.substring(0, iLastIndexOf));
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    private static String relativeURIFor(File file, File file2) {
        int iIndexOf;
        URI uri = file.getAbsoluteFile().toURI();
        URI uri2 = file2.getAbsoluteFile().toURI();
        URI uriCommonAncestor = commonAncestor(uri, uri2);
        if (uriCommonAncestor == null) {
            return uri2.toString();
        }
        URI uriRelativize = uriCommonAncestor.relativize(uri);
        URI uriRelativize2 = uriCommonAncestor.relativize(uri2);
        if (uriRelativize.isAbsolute() || uriRelativize2.isAbsolute()) {
            return uri2.toString();
        }
        String string = uriRelativize.toString();
        String str = "";
        int i = 0;
        while (i < string.length() && (iIndexOf = string.indexOf(47, i)) >= 0) {
            str = str + "../";
            i = iIndexOf + 1;
        }
        return str + uriRelativize2.toString();
    }

    private static File commonFileFor(String str, String str2, int i, File file) {
        if (i > 0) {
            int iLastIndexOf = str.lastIndexOf(46);
            if (iLastIndexOf < 0) {
                iLastIndexOf = str.length();
            }
            str = str.substring(0, iLastIndexOf) + i + str.substring(iLastIndexOf);
        }
        return new File(file, str);
    }

    private static void noteName(String str, String str2, Set set, Set set2, Set set3) {
        if (str == null) {
            return;
        }
        QName qName = new QName(str2, str);
        if (set.contains(qName)) {
            set2.add(qName);
            set3.add(str2);
        } else {
            set.add(qName);
        }
    }

    private static boolean isFirstDuplicate(String str, String str2, Set set, Set set2) {
        if (str == null) {
            return false;
        }
        QName qName = new QName(str2, str);
        if (!set2.contains(qName) || !set.contains(qName)) {
            return false;
        }
        set.remove(qName);
        return true;
    }

    private static boolean isDuplicate(String str, String str2, Set set) {
        if (str == null) {
            return false;
        }
        return set.contains(new QName(str2, str));
    }
}
