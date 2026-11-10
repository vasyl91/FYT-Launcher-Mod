package org.apache.xmlbeans.impl.tool;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.util.HexBin;
import org.apache.xmlbeans.soap.SOAPArrayType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XsbDumper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DATA_BABE = -629491010;
    public static final int FIELD_GLOBAL = 1;
    public static final int FIELD_LOCALATTR = 2;
    public static final int FIELD_LOCALELT = 3;
    public static final int FIELD_NONE = 0;
    public static final int FILETYPE_SCHEMAATTRIBUTE = 4;
    public static final int FILETYPE_SCHEMAATTRIBUTEGROUP = 7;
    public static final int FILETYPE_SCHEMAELEMENT = 3;
    public static final int FILETYPE_SCHEMAINDEX = 1;
    public static final int FILETYPE_SCHEMAMODELGROUP = 6;
    public static final int FILETYPE_SCHEMAPOINTER = 5;
    public static final int FILETYPE_SCHEMATYPE = 2;
    static final int FLAG_ABSTRACT = 262144;
    static final int FLAG_ATTRIBUTE_TYPE = 524288;
    static final int FLAG_BLOCK_EXT = 4096;
    static final int FLAG_BLOCK_REST = 8192;
    static final int FLAG_BOUNDED = 8;
    static final int FLAG_COMPILED = 2048;
    static final int FLAG_DOCUMENT_TYPE = 2;
    static final int FLAG_FINAL_EXT = 16384;
    static final int FLAG_FINAL_LIST = 131072;
    static final int FLAG_FINAL_REST = 32768;
    static final int FLAG_FINAL_UNION = 65536;
    static final int FLAG_FINITE = 16;
    static final int FLAG_HAS_PATTERN = 256;
    static final int FLAG_NUMERIC = 32;
    static final int FLAG_ORDERED = 4;
    static final int FLAG_ORDER_SENSITIVE = 512;
    public static final int FLAG_PART_ABSTRACT = 128;
    public static final int FLAG_PART_BLOCKEXT = 16;
    public static final int FLAG_PART_BLOCKREST = 32;
    public static final int FLAG_PART_BLOCKSUBST = 64;
    public static final int FLAG_PART_FINALEXT = 256;
    public static final int FLAG_PART_FINALREST = 512;
    public static final int FLAG_PART_FIXED = 4;
    public static final int FLAG_PART_NILLABLE = 8;
    public static final int FLAG_PART_SKIPPABLE = 1;
    public static final int FLAG_PROP_ISATTR = 1;
    public static final int FLAG_PROP_JAVAARRAY = 8;
    public static final int FLAG_PROP_JAVAOPTIONAL = 4;
    public static final int FLAG_PROP_JAVASINGLETON = 2;
    static final int FLAG_SIMPLE_TYPE = 1;
    static final int FLAG_STRINGENUM = 64;
    static final int FLAG_TOTAL_ORDER = 1024;
    static final int FLAG_UNION_OF_LISTS = 128;
    public static final int MAJOR_VERSION = 2;
    public static final int MINOR_VERSION = 24;
    private String _indent;
    DataInputStream _input;
    private int _majorver;
    private int _minorver;
    private PrintStream _out;
    private int _releaseno;
    StringPool _stringPool;
    private static final XmlOptions prettyOptions = new XmlOptions().setSavePrettyPrint();
    static final byte[] SINGLE_ZERO_BYTE = {0};

    public static void printUsage() {
        System.out.println("Prints the contents of an XSB file in human-readable form.");
        System.out.println("An XSB file contains schema meta information needed to ");
        System.out.println("perform tasks such as binding and validation.");
        System.out.println("Usage: dumpxsb myfile.xsb");
        System.out.println("    myfile.xsb - Path to an XSB file.");
        System.out.println();
    }

    public static void main(String[] strArr) {
        if (strArr.length == 0) {
            printUsage();
            System.exit(0);
        } else {
            for (String str : strArr) {
                dump(new File(str), true);
            }
        }
    }

    private static void dump(File file, boolean z) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles(new FileFilter() { // from class: org.apache.xmlbeans.impl.tool.XsbDumper.1
                @Override // java.io.FileFilter
                public boolean accept(File file3) {
                    if (file3.isDirectory() || (file3.isFile() && file3.getName().endsWith(".xsb"))) {
                        return true;
                    }
                    return XsbDumper.$assertionsDisabled;
                }
            })) {
                dump(file2, $assertionsDisabled);
            }
            return;
        }
        if (file.getName().endsWith(".jar") || file.getName().endsWith(".zip")) {
            dumpZip(file);
            return;
        }
        if (z || file.getName().endsWith(".xsb")) {
            try {
                System.out.println(file.toString());
                dump(new FileInputStream(file), "  ");
                System.out.println();
            } catch (FileNotFoundException e) {
                System.out.println(e.toString());
            }
        }
    }

    public static void dumpZip(File file) {
        try {
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                if (zipEntryNextElement.getName().endsWith(".xsb")) {
                    System.out.println(zipEntryNextElement.getName());
                    dump(zipFile.getInputStream(zipEntryNextElement), "  ");
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void dump(InputStream inputStream) {
        dump(inputStream, "", System.out);
    }

    public static void dump(InputStream inputStream, String str) {
        dump(inputStream, str, System.out);
    }

    public static void dump(InputStream inputStream, String str, PrintStream printStream) {
        new XsbDumper(inputStream, str, printStream).dumpAll();
    }

    private XsbDumper(InputStream inputStream, String str, PrintStream printStream) {
        this._input = new DataInputStream(inputStream);
        this._indent = str;
        this._out = printStream;
    }

    void flush() {
        this._out.flush();
    }

    void emit(String str) {
        this._out.println(this._indent + str);
        flush();
    }

    void emit() {
        this._out.println();
        flush();
    }

    void error(Exception exc) {
        this._out.println(exc.toString());
        flush();
        IllegalStateException illegalStateException = new IllegalStateException(exc.getMessage());
        illegalStateException.initCause(exc);
        throw illegalStateException;
    }

    void error(String str) {
        this._out.println(str);
        flush();
        throw new IllegalStateException(str);
    }

    void indent() {
        this._indent += "  ";
    }

    void outdent() {
        String str = this._indent;
        this._indent = str.substring(0, str.length() - 2);
    }

    static String filetypeString(int i) {
        switch (i) {
            case 1:
                return "FILETYPE_SCHEMAINDEX";
            case 2:
                return "FILETYPE_SCHEMATYPE";
            case 3:
                return "FILETYPE_SCHEMAELEMENT";
            case 4:
                return "FILETYPE_SCHEMAATTRIBUTE";
            case 5:
                return "FILETYPE_SCHEMAPOINTER";
            case 6:
                return "FILETYPE_SCHEMAMODELGROUP";
            case 7:
                return "FILETYPE_SCHEMAATTRIBUTEGROUP";
            default:
                return "Unknown FILETYPE (" + i + ")";
        }
    }

    static String particleflagsString(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if ((i & 1) != 0) {
            stringBuffer.append("FLAG_PART_SKIPPABLE | ");
        }
        if ((i & 4) != 0) {
            stringBuffer.append("FLAG_PART_FIXED | ");
        }
        if ((i & 8) != 0) {
            stringBuffer.append("FLAG_PART_NILLABLE | ");
        }
        if ((i & 16) != 0) {
            stringBuffer.append("FLAG_PART_BLOCKEXT | ");
        }
        if ((i & 32) != 0) {
            stringBuffer.append("FLAG_PART_BLOCKREST | ");
        }
        if ((i & 64) != 0) {
            stringBuffer.append("FLAG_PART_BLOCKSUBST | ");
        }
        if ((i & 128) != 0) {
            stringBuffer.append("FLAG_PART_ABSTRACT | ");
        }
        if ((i & 256) != 0) {
            stringBuffer.append("FLAG_PART_FINALEXT | ");
        }
        if ((i & 512) != 0) {
            stringBuffer.append("FLAG_PART_FINALREST | ");
        }
        if (stringBuffer.length() == 0) {
            stringBuffer.append("0 | ");
        }
        return stringBuffer.substring(0, stringBuffer.length() - 3);
    }

    static String propertyflagsString(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if ((i & 1) != 0) {
            stringBuffer.append("FLAG_PROP_ISATTR | ");
        }
        if ((i & 2) != 0) {
            stringBuffer.append("FLAG_PROP_JAVASINGLETON | ");
        }
        if ((i & 4) != 0) {
            stringBuffer.append("FLAG_PROP_JAVAOPTIONAL | ");
        }
        if ((i & 8) != 0) {
            stringBuffer.append("FLAG_PROP_JAVAARRAY | ");
        }
        if (stringBuffer.length() == 0) {
            stringBuffer.append("0 | ");
        }
        return stringBuffer.substring(0, stringBuffer.length() - 3);
    }

    static String containerfieldTypeString(int i) {
        if (i == 0) {
            return "FIELD_NONE";
        }
        if (i == 1) {
            return "FIELD_GLOBAL";
        }
        if (i != 2) {
            return i != 3 ? "Unknown container field type (" + i + ")" : "FIELD_LOCALELT";
        }
        return "FIELD_LOCALATTR";
    }

    static String typeflagsString(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if ((i & 1) != 0) {
            stringBuffer.append("FLAG_SIMPLE_TYPE | ");
        }
        if ((i & 2) != 0) {
            stringBuffer.append("FLAG_DOCUMENT_TYPE | ");
        }
        if ((FLAG_ATTRIBUTE_TYPE & i) != 0) {
            stringBuffer.append("FLAG_ATTRIBUTE_TYPE | ");
        }
        if ((i & 4) != 0) {
            stringBuffer.append("FLAG_ORDERED | ");
        }
        if ((i & 8) != 0) {
            stringBuffer.append("FLAG_BOUNDED | ");
        }
        if ((i & 16) != 0) {
            stringBuffer.append("FLAG_FINITE | ");
        }
        if ((i & 32) != 0) {
            stringBuffer.append("FLAG_NUMERIC | ");
        }
        if ((i & 64) != 0) {
            stringBuffer.append("FLAG_STRINGENUM | ");
        }
        if ((i & 128) != 0) {
            stringBuffer.append("FLAG_UNION_OF_LISTS | ");
        }
        if ((i & 256) != 0) {
            stringBuffer.append("FLAG_HAS_PATTERN | ");
        }
        if ((i & 1024) != 0) {
            stringBuffer.append("FLAG_TOTAL_ORDER | ");
        }
        if ((i & 2048) != 0) {
            stringBuffer.append("FLAG_COMPILED | ");
        }
        if ((i & 4096) != 0) {
            stringBuffer.append("FLAG_BLOCK_EXT | ");
        }
        if ((i & 8192) != 0) {
            stringBuffer.append("FLAG_BLOCK_REST | ");
        }
        if ((i & FLAG_FINAL_EXT) != 0) {
            stringBuffer.append("FLAG_FINAL_EXT | ");
        }
        if ((FLAG_FINAL_REST & i) != 0) {
            stringBuffer.append("FLAG_FINAL_REST | ");
        }
        if ((FLAG_FINAL_UNION & i) != 0) {
            stringBuffer.append("FLAG_FINAL_UNION | ");
        }
        if ((FLAG_FINAL_LIST & i) != 0) {
            stringBuffer.append("FLAG_FINAL_LIST | ");
        }
        if ((i & FLAG_ABSTRACT) != 0) {
            stringBuffer.append("FLAG_ABSTRACT | ");
        }
        if (stringBuffer.length() == 0) {
            stringBuffer.append("0 | ");
        }
        return stringBuffer.substring(0, stringBuffer.length() - 3);
    }

    void dumpAll() {
        switch (dumpHeader()) {
            case 1:
                dumpIndexData();
                return;
            case 2:
                dumpTypeFileData();
                break;
            case 3:
                dumpParticleData(true);
                break;
            case 4:
                dumpAttributeData(true);
                break;
            case 5:
                dumpPointerData();
                break;
            case 6:
                dumpModelGroupData();
                break;
            case 7:
                dumpAttributeGroupData();
                break;
        }
        readEnd();
    }

    static String hex32String(int i) {
        return Integer.toHexString(i);
    }

    protected int dumpHeader() {
        int i = readInt();
        emit("Magic cookie: " + hex32String(i));
        if (i != -629491010) {
            emit("Wrong magic cookie.");
            return 0;
        }
        this._majorver = readShort();
        this._minorver = readShort();
        if (atLeast(2, 18, 0)) {
            this._releaseno = readShort();
        }
        emit("Major version: " + this._majorver);
        emit("Minor version: " + this._minorver);
        emit("Release number: " + this._releaseno);
        if (this._majorver != 2 || this._minorver > 24) {
            emit("Incompatible version.");
            return 0;
        }
        int i2 = readShort();
        emit("Filetype: " + filetypeString(i2));
        StringPool stringPool = new StringPool();
        this._stringPool = stringPool;
        stringPool.readFrom(this._input);
        return i2;
    }

    void dumpPointerData() {
        emit("Type system: " + readString());
    }

    protected void dumpIndexData() {
        int i = readShort();
        emit("Handle pool (" + i + "):");
        indent();
        for (int i2 = 0; i2 < i; i2++) {
            emit(readString() + " (" + filetypeString(readShort()) + ")");
        }
        outdent();
        dumpQNameMap("Global elements");
        dumpQNameMap("Global attributes");
        dumpQNameMap("Model groups");
        dumpQNameMap("Attribute groups");
        dumpQNameMap("Identity constraints");
        dumpQNameMap("Global types");
        dumpQNameMap("Document types");
        dumpQNameMap("Attribute types");
        dumpClassnameIndex("All types by classname");
        dumpStringArray("Defined namespaces");
        if (atLeast(2, 15, 0)) {
            dumpQNameMap("Redefined global types");
            dumpQNameMap("Redfined model groups");
            dumpQNameMap("Redfined attribute groups");
        }
        if (atLeast(2, 19, 0)) {
            dumpAnnotations();
        }
        readEnd();
    }

    class StringPool {
        private List intsToStrings = new ArrayList();
        private Map stringsToInts = new HashMap();

        StringPool() {
            this.intsToStrings.add(null);
        }

        String stringForCode(int i) {
            if (i == 0) {
                return null;
            }
            return (String) this.intsToStrings.get(i);
        }

        int codeForString(String str) {
            if (str == null) {
                return 0;
            }
            Integer num = (Integer) this.stringsToInts.get(str);
            if (num == null) {
                num = new Integer(this.intsToStrings.size());
                this.intsToStrings.add(str);
                this.stringsToInts.put(str, num);
            }
            return num.intValue();
        }

        void readFrom(DataInputStream dataInputStream) {
            if (this.intsToStrings.size() != 1 || this.stringsToInts.size() != 0) {
                throw new IllegalStateException();
            }
            try {
                short s = dataInputStream.readShort();
                XsbDumper.this.emit("String pool (" + ((int) s) + "):");
                XsbDumper.this.indent();
                for (int i = 1; i < s; i++) {
                    String utf = dataInputStream.readUTF();
                    int iCodeForString = codeForString(utf);
                    if (iCodeForString != i) {
                        throw new IllegalStateException();
                    }
                    XsbDumper.this.emit(iCodeForString + " = \"" + utf + "\"");
                }
                XsbDumper.this.outdent();
            } catch (IOException e) {
                XsbDumper.this.emit(e.toString());
            }
        }
    }

    int readShort() {
        try {
            return this._input.readUnsignedShort();
        } catch (IOException e) {
            error(e);
            return 0;
        }
    }

    int readInt() {
        try {
            return this._input.readInt();
        } catch (IOException e) {
            error(e);
            return 0;
        }
    }

    String readString() {
        return this._stringPool.stringForCode(readShort());
    }

    QName readQName() {
        String string = readString();
        String string2 = readString();
        if (string2 == null) {
            return null;
        }
        return new QName(string, string2);
    }

    String readHandle() {
        return readString();
    }

    String readType() {
        return readHandle();
    }

    static String qnameString(QName qName) {
        if (qName == null) {
            return "(null)";
        }
        if (qName.getNamespaceURI() != null) {
            return qName.getLocalPart() + "@" + qName.getNamespaceURI();
        }
        return qName.getLocalPart();
    }

    static String qnameSetString(QNameSet qNameSet) {
        return qNameSet.toString();
    }

    void dumpQNameMap(String str) {
        int i = readShort();
        emit(str + " (" + i + "):");
        indent();
        for (int i2 = 0; i2 < i; i2++) {
            emit(qnameString(readQName()) + " = " + readHandle());
        }
        outdent();
    }

    void dumpTypeArray(String str) {
        int i = readShort();
        emit(str + " (" + i + "):");
        indent();
        for (int i2 = 0; i2 < i; i2++) {
            emit(i2 + " = " + readType());
        }
        outdent();
    }

    void dumpClassnameIndex(String str) {
        int i = readShort();
        emit(str + " (" + i + "):");
        indent();
        for (int i2 = 0; i2 < i; i2++) {
            emit(readString() + " = " + readType());
        }
        outdent();
    }

    void dumpStringArray(String str) {
        int i = readShort();
        emit(str + " (" + i + "):");
        indent();
        for (int i2 = 0; i2 < i; i2++) {
            emit(readString());
        }
        outdent();
    }

    void readEnd() {
        try {
            this._input.close();
        } catch (IOException unused) {
        }
        this._input = null;
        this._stringPool = null;
    }

    static String particleTypeString(int i) {
        if (i == 1) {
            return "ALL";
        }
        if (i == 2) {
            return "CHOICE";
        }
        if (i == 3) {
            return "SEQUENCE";
        }
        if (i != 4) {
            return i != 5 ? "Unknown particle type (" + i + ")" : "WILDCARD";
        }
        return "ELEMENT";
    }

    static String bigIntegerString(BigInteger bigInteger) {
        return bigInteger == null ? "(null)" : bigInteger.toString();
    }

    static String wcprocessString(int i) {
        if (i == 0) {
            return "NOT_WILDCARD";
        }
        if (i == 1) {
            return "STRICT";
        }
        if (i != 2) {
            return i != 3 ? "Unknown process type (" + i + ")" : "SKIP";
        }
        return "LAX";
    }

    void dumpAnnotation() {
        int i;
        boolean z;
        boolean z2 = $assertionsDisabled;
        if (atLeast(2, 19, 0) && (i = readInt()) != -1) {
            emit("Annotation");
            indent();
            if (i > 0) {
                emit("Attributes (" + i + "):");
                indent();
                for (int i2 = 0; i2 < i; i2++) {
                    if (atLeast(2, 24, 0)) {
                        emit("Name: " + qnameString(readQName()) + ", Value: " + readString() + ", ValueURI: " + readString());
                    } else {
                        emit("Name: " + qnameString(readQName()) + ", Value: " + readString());
                    }
                }
                outdent();
                z = false;
            } else {
                z = true;
            }
            int i3 = readInt();
            if (i3 > 0) {
                emit("Documentation elements (" + i3 + "):");
                indent();
                for (int i4 = 0; i4 < i3; i4++) {
                    emit(readString());
                }
                outdent();
                z = false;
            }
            int i5 = readInt();
            if (i5 > 0) {
                emit("Appinfo elements (" + i5 + "):");
                indent();
                for (int i6 = 0; i6 < i5; i6++) {
                    emit(readString());
                }
                outdent();
            } else {
                z2 = z;
            }
            if (z2) {
                emit("<empty>");
            }
            outdent();
        }
    }

    void dumpAnnotations() {
        int i = readInt();
        if (i > 0) {
            emit("Top-level annotations (" + i + "):");
            indent();
            for (int i2 = 0; i2 < i; i2++) {
                dumpAnnotation();
            }
            outdent();
        }
    }

    void dumpParticleData(boolean z) {
        int i = readShort();
        emit(particleTypeString(i) + ":");
        indent();
        emit("Flags: " + particleflagsString(readShort()));
        emit("MinOccurs: " + bigIntegerString(readBigInteger()));
        emit("MaxOccurs: " + bigIntegerString(readBigInteger()));
        emit("Transition: " + qnameSetString(readQNameSet()));
        if (i == 1 || i == 2 || i == 3) {
            dumpParticleArray("Particle children");
        } else if (i == 4) {
            emit("Name: " + qnameString(readQName()));
            emit("Type: " + readType());
            emit("Default: " + readString());
            if (atLeast(2, 16, 0)) {
                emit("Default value: " + readXmlValueObject());
            }
            emit("WsdlArrayType: " + SOAPArrayTypeString(readSOAPArrayType()));
            dumpAnnotation();
            if (z) {
                if (atLeast(2, 17, 0)) {
                    emit("Substitution group ref: " + readHandle());
                }
                int i2 = readShort();
                emit("Substitution group members (" + i2 + ")");
                indent();
                for (int i3 = 0; i3 < i2; i3++) {
                    emit(qnameString(readQName()));
                }
                outdent();
            }
            int i4 = readShort();
            emit("Identity constraints (" + i4 + "):");
            indent();
            for (int i5 = 0; i5 < i4; i5++) {
                emit(readHandle());
            }
            outdent();
            if (z) {
                emit("Filename: " + readString());
            }
        } else if (i == 5) {
            emit("Wildcard set: " + qnameSetString(readQNameSet()));
            emit("Wildcard process: " + wcprocessString(readShort()));
        } else {
            error("Unrecognized schema particle type");
        }
        outdent();
    }

    void dumpParticleArray(String str) {
        int i = readShort();
        emit(str + "(" + i + "):");
        indent();
        for (int i2 = 0; i2 < i; i2++) {
            dumpParticleData($assertionsDisabled);
        }
        outdent();
    }

    static String complexVarietyString(int i) {
        if (i == 1) {
            return "EMPTY_CONTENT";
        }
        if (i == 2) {
            return "SIMPLE_CONTENT";
        }
        if (i != 3) {
            return i != 4 ? "Unknown complex variety (" + i + ")" : "MIXED_CONTENT";
        }
        return "ELEMENT_CONTENT";
    }

    static String simpleVarietyString(int i) {
        if (i == 1) {
            return "ATOMIC";
        }
        if (i != 2) {
            return i != 3 ? "Unknown simple variety (" + i + ")" : "LIST";
        }
        return "UNION";
    }

    String facetCodeString(int i) {
        switch (i) {
            case 0:
                return "FACET_LENGTH";
            case 1:
                return "FACET_MIN_LENGTH";
            case 2:
                return "FACET_MAX_LENGTH";
            case 3:
                return "FACET_MIN_EXCLUSIVE";
            case 4:
                return "FACET_MIN_INCLUSIVE";
            case 5:
                return "FACET_MAX_INCLUSIVE";
            case 6:
                return "FACET_MAX_EXCLUSIVE";
            case 7:
                return "FACET_TOTAL_DIGITS";
            case 8:
                return "FACET_FRACTION_DIGITS";
            default:
                return "Unknown facet code (" + i + ")";
        }
    }

    String whitespaceCodeString(int i) {
        if (i == 0) {
            return "WS_UNSPECIFIED";
        }
        if (i == 1) {
            return "WS_PRESERVE";
        }
        if (i != 2) {
            return i != 3 ? "Unknown whitespace code (" + i + ")" : "WS_COLLAPSE";
        }
        return "WS_REPLACE";
    }

    String derivationTypeString(int i) {
        if (i == 0) {
            return "DT_NOT_DERIVED";
        }
        if (i != 1) {
            return i != 2 ? "Unknown derivation code (" + i + ")" : "DT_EXTENSION";
        }
        return "DT_RESTRICTION";
    }

    void dumpTypeFileData() {
        int i;
        emit("Name: " + qnameString(readQName()));
        emit("Outer type: " + readType());
        emit("Depth: " + readShort());
        emit("Base type: " + readType());
        emit("Derivation type: " + derivationTypeString(readShort()));
        dumpAnnotation();
        emit("Container field:");
        indent();
        int i2 = readShort();
        emit("Reftype: " + containerfieldTypeString(i2));
        if (i2 == 1) {
            emit("Handle: " + readHandle());
        } else if (i2 == 2 || i2 == 3) {
            emit("Index: " + readShort());
        }
        outdent();
        emit("Java class name: " + readString());
        emit("Java impl class name: " + readString());
        dumpTypeArray("Anonymous types");
        emit("Anonymous union member ordinal: " + readShort());
        int i3 = readInt();
        emit("Flags: " + typeflagsString(i3));
        boolean z = (i3 & 1) == 0;
        if (z) {
            i = readShort();
            emit("Complex variety: " + complexVarietyString(i));
            if (atLeast(2, 23, 0)) {
                emit("Content based on type: " + readType());
            }
            int i4 = readShort();
            emit("Attribute model (" + i4 + "):");
            indent();
            for (int i5 = 0; i5 < i4; i5++) {
                dumpAttributeData($assertionsDisabled);
            }
            emit("Wildcard set: " + qnameSetString(readQNameSet()));
            emit("Wildcard process: " + wcprocessString(readShort()));
            outdent();
            int i6 = readShort();
            emit("Attribute properties (" + i6 + "):");
            indent();
            for (int i7 = 0; i7 < i6; i7++) {
                dumpPropertyData();
            }
            outdent();
            if (i == 3 || i == 4) {
                emit("IsAll: " + readShort());
                dumpParticleArray("Content model");
                int i8 = readShort();
                emit("Element properties (" + i8 + "):");
                indent();
                for (int i9 = 0; i9 < i8; i9++) {
                    dumpPropertyData();
                }
                outdent();
            }
        } else {
            i = 0;
        }
        if (!z || i == 2) {
            int i10 = readShort();
            emit("Simple type variety: " + simpleVarietyString(i10));
            boolean z2 = (i3 & 64) != 0;
            int i11 = readShort();
            emit("Facets (" + i11 + "):");
            indent();
            for (int i12 = 0; i12 < i11; i12++) {
                emit(facetCodeString(readShort()));
                emit("Value: " + readXmlValueObject());
                emit("Fixed: " + readShort());
            }
            outdent();
            emit("Whitespace rule: " + whitespaceCodeString(readShort()));
            int i13 = readShort();
            emit("Patterns (" + i13 + "):");
            indent();
            for (int i14 = 0; i14 < i13; i14++) {
                emit(readString());
            }
            outdent();
            int i15 = readShort();
            emit("Enumeration values (" + i15 + "):");
            indent();
            for (int i16 = 0; i16 < i15; i16++) {
                emit(readXmlValueObject());
            }
            outdent();
            emit("Base enum type: " + readType());
            if (z2) {
                int i17 = readShort();
                emit("String enum entries (" + i17 + "):");
                indent();
                for (int i18 = 0; i18 < i17; i18++) {
                    emit("\"" + readString() + "\" -> " + readShort() + " = " + readString());
                }
                outdent();
            }
            if (i10 == 1) {
                emit("Primitive type: " + readType());
                emit("Decimal size: " + readInt());
            } else if (i10 == 2) {
                dumpTypeArray("Union members");
            } else if (i10 == 3) {
                emit("List item type: " + readType());
            } else {
                error("Unknown simple type variety");
            }
        }
        emit("Filename: " + readString());
    }

    static String attruseCodeString(int i) {
        if (i == 1) {
            return "PROHIBITED";
        }
        if (i != 2) {
            return i != 3 ? "Unknown use code (" + i + ")" : "REQUIRED";
        }
        return "OPTIONAL";
    }

    void dumpAttributeData(boolean z) {
        emit("Name: " + qnameString(readQName()));
        emit("Type: " + readType());
        emit("Use: " + attruseCodeString(readShort()));
        emit("Default: " + readString());
        if (atLeast(2, 16, 0)) {
            emit("Default value: " + readXmlValueObject());
        }
        emit("Fixed: " + readShort());
        emit("WsdlArrayType: " + SOAPArrayTypeString(readSOAPArrayType()));
        dumpAnnotation();
        if (z) {
            emit("Filename: " + readString());
        }
    }

    void dumpXml() {
        String string = readString();
        try {
            emit(XmlObject.Factory.parse(string).xmlText(prettyOptions));
        } catch (XmlException unused) {
            emit("!!!!!! BAD XML !!!!!");
            emit(string);
        }
    }

    void dumpModelGroupData() {
        emit("Name: " + qnameString(readQName()));
        emit("Target namespace: " + readString());
        emit("Chameleon: " + readShort());
        if (atLeast(2, 22, 0)) {
            emit("Element form default: " + readString());
        }
        if (atLeast(2, 22, 0)) {
            emit("Attribute form default: " + readString());
        }
        if (atLeast(2, 15, 0)) {
            emit("Redefine: " + readShort());
        }
        emit("Model Group Xml: ");
        dumpXml();
        dumpAnnotation();
        if (atLeast(2, 21, 0)) {
            emit("Filename: " + readString());
        }
    }

    void dumpAttributeGroupData() {
        emit("Name: " + qnameString(readQName()));
        emit("Target namespace: " + readString());
        emit("Chameleon: " + readShort());
        if (atLeast(2, 22, 0)) {
            emit("Form default: " + readString());
        }
        if (atLeast(2, 15, 0)) {
            emit("Redefine: " + readShort());
        }
        emit("Attribute Group Xml: ");
        dumpXml();
        dumpAnnotation();
        if (atLeast(2, 21, 0)) {
            emit("Filename: " + readString());
        }
    }

    static String alwaysString(int i) {
        if (i == 0) {
            return "NEVER";
        }
        if (i != 1) {
            return i != 2 ? "Unknown frequency code (" + i + ")" : "CONSISTENTLY";
        }
        return "VARIABLE";
    }

    static String jtcString(int i) {
        switch (i) {
            case 0:
                return "XML_OBJECT";
            case 1:
                return "JAVA_BOOLEAN";
            case 2:
                return "JAVA_FLOAT";
            case 3:
                return "JAVA_DOUBLE";
            case 4:
                return "JAVA_BYTE";
            case 5:
                return "JAVA_SHORT";
            case 6:
                return "JAVA_INT";
            case 7:
                return "JAVA_LONG";
            case 8:
                return "JAVA_BIG_DECIMAL";
            case 9:
                return "JAVA_BIG_INTEGER";
            case 10:
                return "JAVA_STRING";
            case 11:
                return "JAVA_BYTE_ARRAY";
            case 12:
                return "JAVA_GDATE";
            case 13:
                return "JAVA_GDURATION";
            case 14:
                return "JAVA_DATE";
            case 15:
                return "JAVA_QNAME";
            case 16:
                return "JAVA_LIST";
            case 17:
                return "JAVA_CALENDAR";
            case 18:
                return "JAVA_ENUM";
            case 19:
                return "JAVA_OBJECT";
            default:
                return "Unknown java type code (" + i + ")";
        }
    }

    void dumpPropertyData() {
        emit("Property");
        indent();
        emit("Name: " + qnameString(readQName()));
        emit("Type: " + readType());
        int i = readShort();
        emit("Flags: " + propertyflagsString(i));
        emit("Container type: " + readType());
        emit("Min occurances: " + bigIntegerString(readBigInteger()));
        emit("Max occurances: " + bigIntegerString(readBigInteger()));
        emit("Nillable: " + alwaysString(readShort()));
        emit("Default: " + alwaysString(readShort()));
        emit("Fixed: " + alwaysString(readShort()));
        emit("Default text: " + readString());
        emit("Java prop name: " + readString());
        emit("Java type code: " + jtcString(readShort()));
        emit("Type for java signature: " + readType());
        if (atMost(2, 19, 0)) {
            emit("Java setter delimiter: " + qnameSetString(readQNameSet()));
        }
        if (atLeast(2, 16, 0)) {
            emit("Default value: " + readXmlValueObject());
        }
        if ((i & 1) == 0 && atLeast(2, 17, 0)) {
            int i2 = readShort();
            emit("Accepted substitutions (" + i2 + "):");
            for (int i3 = 0; i3 < i2; i3++) {
                emit("  Accepted name " + readQName());
            }
        }
        outdent();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005a  */
    String readXmlValueObject() {
        String string;
        String type = readType();
        if (type == null) {
            return "null";
        }
        int i = readShort();
        if (i != 0) {
            switch (i) {
                case 2:
                case 3:
                case 6:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    string = readString();
                    break;
                case 4:
                case 5:
                    string = new String(HexBin.encode(readByteArray()));
                    if (string.length() > 19) {
                        string = ((Object) string.subSequence(0, 16)) + "...";
                    }
                    break;
                case 7:
                case 8:
                    string = QNameHelper.pretty(readQName());
                    break;
                case 9:
                case 10:
                    string = Double.toString(readDouble());
                    break;
                default:
                    string = "nil";
                    break;
            }
        } else {
            string = "nil";
        }
        return string + " (" + type + ": " + i + ")";
    }

    double readDouble() {
        try {
            return this._input.readDouble();
        } catch (IOException e) {
            error(e);
            return 0.0d;
        }
    }

    String SOAPArrayTypeString(SOAPArrayType sOAPArrayType) {
        return sOAPArrayType == null ? "null" : QNameHelper.pretty(sOAPArrayType.getQName()) + sOAPArrayType.soap11DimensionString();
    }

    SOAPArrayType readSOAPArrayType() {
        QName qName = readQName();
        String string = readString();
        if (qName == null) {
            return null;
        }
        return new SOAPArrayType(qName, string);
    }

    QNameSet readQNameSet() {
        int i = readShort();
        HashSet hashSet = new HashSet();
        int i2 = readShort();
        for (int i3 = 0; i3 < i2; i3++) {
            hashSet.add(readString());
        }
        HashSet hashSet2 = new HashSet();
        int i4 = readShort();
        for (int i5 = 0; i5 < i4; i5++) {
            hashSet2.add(readQName());
        }
        HashSet hashSet3 = new HashSet();
        int i6 = readShort();
        for (int i7 = 0; i7 < i6; i7++) {
            hashSet3.add(readQName());
        }
        if (i == 1) {
            return QNameSet.forSets(hashSet, (Set) null, hashSet2, hashSet3);
        }
        return QNameSet.forSets((Set) null, hashSet, hashSet3, hashSet2);
    }

    byte[] readByteArray() {
        try {
            byte[] bArr = new byte[this._input.readShort()];
            this._input.readFully(bArr);
            return bArr;
        } catch (IOException e) {
            error(e);
            return null;
        }
    }

    BigInteger readBigInteger() {
        byte[] byteArray = readByteArray();
        if (byteArray.length == 0) {
            return null;
        }
        if (byteArray.length == 1 && byteArray[0] == 0) {
            return BigInteger.ZERO;
        }
        if (byteArray.length == 1 && byteArray[0] == 1) {
            return BigInteger.ONE;
        }
        return new BigInteger(byteArray);
    }

    protected boolean atLeast(int i, int i2, int i3) {
        int i4 = this._majorver;
        if (i4 > i) {
            return true;
        }
        if (i4 < i) {
            return $assertionsDisabled;
        }
        int i5 = this._minorver;
        if (i5 > i2) {
            return true;
        }
        if (i5 >= i2 && this._releaseno >= i3) {
            return true;
        }
        return $assertionsDisabled;
    }

    protected boolean atMost(int i, int i2, int i3) {
        int i4 = this._majorver;
        if (i4 > i) {
            return $assertionsDisabled;
        }
        if (i4 < i) {
            return true;
        }
        int i5 = this._minorver;
        if (i5 > i2) {
            return $assertionsDisabled;
        }
        if (i5 >= i2 && this._releaseno > i3) {
            return $assertionsDisabled;
        }
        return true;
    }
}
