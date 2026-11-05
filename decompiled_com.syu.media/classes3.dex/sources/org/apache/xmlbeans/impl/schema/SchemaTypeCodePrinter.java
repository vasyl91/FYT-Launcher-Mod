package org.apache.xmlbeans.impl.schema;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.InterfaceExtension;
import org.apache.xmlbeans.PrePostExtension;
import org.apache.xmlbeans.SchemaCodePrinter;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class SchemaTypeCodePrinter implements SchemaCodePrinter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ADD_NEW_VALUE = 3;
    static final int INDENT_INCREMENT = 4;
    public static final String INDEX_CLASSNAME = "TypeSystemHolder";
    static final String LINE_SEPARATOR;
    static final String MAX_SPACES = "                                        ";
    private static final int NOTHING = 1;
    private static final int THROW_EXCEPTION = 4;
    int _indent = 0;
    boolean _useJava15;
    Writer _writer;

    static boolean isJavaPrimitive(int i) {
        if (i >= 1 && i <= 7) {
            return true;
        }
        return $assertionsDisabled;
    }

    static String shortIndexClassForSystem(SchemaTypeSystem schemaTypeSystem) {
        return INDEX_CLASSNAME;
    }

    String prePostOpString(int i) {
        if (i == 1) {
            return "org.apache.xmlbeans.PrePostExtension.OPERATION_SET";
        }
        if (i != 2) {
            return i != 3 ? "org.apache.xmlbeans.PrePostExtension.OPERATION_SET" : "org.apache.xmlbeans.PrePostExtension.OPERATION_REMOVE";
        }
        return "org.apache.xmlbeans.PrePostExtension.OPERATION_INSERT";
    }

    public void printLoader(Writer writer, SchemaTypeSystem schemaTypeSystem) throws IOException {
    }

    static {
        LINE_SEPARATOR = SystemProperties.getProperty("line.separator") == null ? "\n" : SystemProperties.getProperty("line.separator");
    }

    public static void printTypeImpl(Writer writer, SchemaType schemaType, XmlOptions xmlOptions) throws IOException {
        getPrinter(xmlOptions).printTypeImpl(writer, schemaType);
    }

    public static void printType(Writer writer, SchemaType schemaType, XmlOptions xmlOptions) throws IOException {
        getPrinter(xmlOptions).printType(writer, schemaType);
    }

    public static void printLoader(Writer writer, SchemaTypeSystem schemaTypeSystem, XmlOptions xmlOptions) throws IOException {
        getPrinter(xmlOptions).printLoader(writer, schemaTypeSystem);
    }

    private static SchemaCodePrinter getPrinter(XmlOptions xmlOptions) {
        Object objSafeGet = XmlOptions.safeGet(xmlOptions, "SCHEMA_CODE_PRINTER");
        if (objSafeGet == null || !(objSafeGet instanceof SchemaCodePrinter)) {
            objSafeGet = new SchemaTypeCodePrinter(xmlOptions);
        }
        return (SchemaCodePrinter) objSafeGet;
    }

    public SchemaTypeCodePrinter(XmlOptions xmlOptions) {
        String str = (xmlOptions == null || !XmlOptions.hasOption(xmlOptions, "GENERATE_JAVA_VERSION")) ? null : (String) xmlOptions.get("GENERATE_JAVA_VERSION");
        this._useJava15 = "1.5".equals(str == null ? "1.4" : str);
    }

    void indent() {
        this._indent += 4;
    }

    void outdent() {
        this._indent -= 4;
    }

    String encodeString(String str) {
        StringBuffer stringBuffer = new StringBuffer("\"");
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"') {
                stringBuffer.append("\\\"");
            } else if (cCharAt == '\\') {
                stringBuffer.append("\\\\");
            } else if (cCharAt == '\r') {
                stringBuffer.append("\\r");
            } else if (cCharAt == '\n') {
                stringBuffer.append("\\n");
            } else if (cCharAt == '\t') {
                stringBuffer.append("\\t");
            } else {
                stringBuffer.append(cCharAt);
            }
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }

    void emit(String str) throws IOException {
        int i = this._indent;
        if (i > 20) {
            i = (i / 2) + 10;
        }
        if (i > 40) {
            i = 40;
        }
        this._writer.write(MAX_SPACES.substring(0, i));
        try {
            this._writer.write(str);
        } catch (CharacterCodingException unused) {
            this._writer.write(makeSafe(str));
        }
        this._writer.write(LINE_SEPARATOR);
    }

    private static String makeSafe(String str) {
        Charset charsetForName = Charset.forName(System.getProperty("file.encoding"));
        if (charsetForName == null) {
            throw new IllegalStateException("Default character set is null!");
        }
        CharsetEncoder charsetEncoderNewEncoder = charsetForName.newEncoder();
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < str.length() && charsetEncoderNewEncoder.canEncode(str.charAt(i))) {
            i++;
        }
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (charsetEncoderNewEncoder.canEncode(cCharAt)) {
                stringBuffer.append(cCharAt);
            } else {
                String hexString = Integer.toHexString(cCharAt);
                int length = hexString.length();
                if (length == 1) {
                    stringBuffer.append("\\u000").append(hexString);
                } else if (length == 2) {
                    stringBuffer.append("\\u00").append(hexString);
                } else if (length == 3) {
                    stringBuffer.append("\\u0").append(hexString);
                } else if (length == 4) {
                    stringBuffer.append("\\u").append(hexString);
                } else {
                    throw new IllegalStateException();
                }
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public void printType(Writer writer, SchemaType schemaType) throws IOException {
        this._writer = writer;
        printTopComment(schemaType);
        printPackage(schemaType, true);
        emit("");
        printInnerType(schemaType, schemaType.getTypeSystem());
        this._writer.flush();
    }

    public void printTypeImpl(Writer writer, SchemaType schemaType) throws IOException {
        this._writer = writer;
        printTopComment(schemaType);
        printPackage(schemaType, $assertionsDisabled);
        printInnerTypeImpl(schemaType, schemaType.getTypeSystem(), $assertionsDisabled);
    }

    String findJavaType(SchemaType schemaType) {
        while (schemaType.getFullJavaName() == null) {
            schemaType = schemaType.getBaseType();
        }
        return schemaType.getFullJavaName();
    }

    static String prettyQName(QName qName) {
        String localPart = qName.getLocalPart();
        return qName.getNamespaceURI() != null ? localPart + "(@" + qName.getNamespaceURI() + ")" : localPart;
    }

    void printInnerTypeJavaDoc(SchemaType schemaType) throws IOException {
        QName name = schemaType.getName();
        if (name == null) {
            if (schemaType.isDocumentType()) {
                name = schemaType.getDocumentElementName();
            } else if (schemaType.isAttributeType()) {
                name = schemaType.getAttributeTypeAttributeName();
            } else if (schemaType.getContainerField() != null) {
                name = schemaType.getContainerField().getName();
            }
        }
        emit("/**");
        if (schemaType.isDocumentType()) {
            emit(" * A document containing one " + prettyQName(name) + " element.");
        } else if (schemaType.isAttributeType()) {
            emit(" * A document containing one " + prettyQName(name) + " attribute.");
        } else if (name != null) {
            emit(" * An XML " + prettyQName(name) + ".");
        } else {
            emit(" * An anonymous inner XML type.");
        }
        emit(" *");
        int simpleVariety = schemaType.getSimpleVariety();
        if (simpleVariety == 0) {
            emit(" * This is a complex type.");
        } else if (simpleVariety == 1) {
            emit(" * This is an atomic type that is a restriction of " + getFullJavaName(schemaType) + ".");
        } else if (simpleVariety == 2) {
            emit(" * This is a union type. Instances are of one of the following types:");
            for (SchemaType schemaType2 : schemaType.getUnionConstituentTypes()) {
                emit(" *     " + schemaType2.getFullJavaName());
            }
        } else if (simpleVariety == 3) {
            emit(" * This is a list type whose items are " + schemaType.getListItemType().getFullJavaName() + ".");
        }
        emit(" */");
    }

    private String getFullJavaName(SchemaType schemaType) {
        SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) schemaType;
        String fullJavaName = schemaTypeImpl.getFullJavaName();
        while (schemaTypeImpl.isRedefinition()) {
            fullJavaName = schemaTypeImpl.getFullJavaName();
            schemaTypeImpl = (SchemaTypeImpl) schemaTypeImpl.getBaseType();
        }
        return fullJavaName;
    }

    private String getUserTypeStaticHandlerMethod(boolean z, SchemaTypeImpl schemaTypeImpl) {
        String upperCase;
        String localPart = schemaTypeImpl.getName().getLocalPart();
        if (localPart.length() < 2) {
            upperCase = localPart.toUpperCase();
        } else {
            upperCase = localPart.substring(0, 1).toUpperCase() + localPart.substring(1);
        }
        if (z) {
            return schemaTypeImpl.getUserTypeHandlerName() + ".encode" + upperCase;
        }
        return schemaTypeImpl.getUserTypeHandlerName() + ".decode" + upperCase;
    }

    public static String indexClassForSystem(SchemaTypeSystem schemaTypeSystem) {
        return schemaTypeSystem.getName() + ".TypeSystemHolder";
    }

    void printStaticTypeDeclaration(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem) throws IOException {
        String shortJavaName = schemaType.getShortJavaName();
        emit("public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)");
        indent();
        emit("org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(" + shortJavaName + ".class.getClassLoader(), \"" + schemaTypeSystem.getName() + "\").resolveHandle(\"" + ((SchemaTypeSystemImpl) schemaTypeSystem).handleForType(schemaType) + "\");");
        outdent();
    }

    void printInnerType(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem) throws IOException {
        emit("");
        printInnerTypeJavaDoc(schemaType);
        startInterface(schemaType);
        printStaticTypeDeclaration(schemaType, schemaTypeSystem);
        if (schemaType.isSimpleType()) {
            if (schemaType.hasStringEnumValues()) {
                printStringEnumeration(schemaType);
            }
        } else {
            if (schemaType.getContentType() == 2 && schemaType.hasStringEnumValues()) {
                printStringEnumeration(schemaType);
            }
            for (SchemaProperty schemaProperty : getDerivedProperties(schemaType)) {
                printPropertyGetters(schemaProperty.getName(), schemaProperty.isAttribute(), schemaProperty.getJavaPropertyName(), schemaProperty.getJavaTypeCode(), javaTypeForProperty(schemaProperty), xmlTypeForProperty(schemaProperty), schemaProperty.hasNillable() != 0, schemaProperty.extendsJavaOption(), schemaProperty.extendsJavaArray(), schemaProperty.extendsJavaSingleton());
                if (!schemaProperty.isReadOnly()) {
                    printPropertySetters(schemaProperty.getName(), schemaProperty.isAttribute(), schemaProperty.getJavaPropertyName(), schemaProperty.getJavaTypeCode(), javaTypeForProperty(schemaProperty), xmlTypeForProperty(schemaProperty), schemaProperty.hasNillable() != 0, schemaProperty.extendsJavaOption(), schemaProperty.extendsJavaArray(), schemaProperty.extendsJavaSingleton());
                }
            }
        }
        printNestedInnerTypes(schemaType, schemaTypeSystem);
        printFactory(schemaType);
        endBlock();
    }

    void printFactory(SchemaType schemaType) throws IOException {
        boolean z = (!schemaType.isAnonymousType() || schemaType.isDocumentType() || schemaType.isAttributeType()) ? true : $assertionsDisabled;
        String strReplace = schemaType.getFullJavaName().replace('$', NameUtil.PERIOD);
        emit("");
        emit("/**");
        emit(" * A factory class with static methods for creating instances");
        emit(" * of this type.");
        emit(" */");
        emit("");
        emit("public static final class Factory");
        emit("{");
        indent();
        if (schemaType.isSimpleType()) {
            emit("public static " + strReplace + " newValue(java.lang.Object obj) {");
            emit("  return (" + strReplace + ") type.newValue( obj ); }");
            emit("");
        }
        if (schemaType.isAbstract()) {
            emit("/** @deprecated No need to be able to create instances of abstract types */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
        }
        emit("public static " + strReplace + " newInstance() {");
        emit("  return (" + strReplace + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }");
        emit("");
        if (schemaType.isAbstract()) {
            emit("/** @deprecated No need to be able to create instances of abstract types */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
        }
        emit("public static " + strReplace + " newInstance(org.apache.xmlbeans.XmlOptions options) {");
        emit("  return (" + strReplace + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }");
        emit("");
        if (z) {
            emit("/** @param xmlAsString the string value to parse */");
            emit("public static " + strReplace + " parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {");
            emit("  return (" + strReplace + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }");
            emit("");
            emit("public static " + strReplace + " parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {");
            emit("  return (" + strReplace + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }");
            emit("");
            emit("/** @param file the file from which to load an xml document */");
            emit("public static " + strReplace + " parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {");
            emit("  return (" + strReplace + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }");
            emit("");
            emit("public static " + strReplace + " parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {");
            emit("  return (" + strReplace + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }");
            emit("");
            emit("public static " + strReplace + " parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {");
            emit("  return (" + strReplace + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }");
            emit("");
            emit("public static " + strReplace + " parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {");
            emit("  return (" + strReplace + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }");
            emit("");
            emit("public static " + strReplace + " parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {");
            emit("  return (" + strReplace + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }");
            emit("");
            emit("public static " + strReplace + " parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {");
            emit("  return (" + strReplace + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }");
            emit("");
            emit("public static " + strReplace + " parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {");
            emit("  return (" + strReplace + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }");
            emit("");
            emit("public static " + strReplace + " parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {");
            emit("  return (" + strReplace + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }");
            emit("");
            emit("public static " + strReplace + " parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {");
            emit("  return (" + strReplace + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }");
            emit("");
            emit("public static " + strReplace + " parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {");
            emit("  return (" + strReplace + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }");
            emit("");
            emit("public static " + strReplace + " parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {");
            emit("  return (" + strReplace + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }");
            emit("");
            emit("public static " + strReplace + " parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {");
            emit("  return (" + strReplace + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }");
            emit("");
            emit("/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
            emit("public static " + strReplace + " parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {");
            emit("  return (" + strReplace + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }");
            emit("");
            emit("/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
            emit("public static " + strReplace + " parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {");
            emit("  return (" + strReplace + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }");
            emit("");
            emit("/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
            emit("public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {");
            emit("  return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }");
            emit("");
            emit("/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
            emit("public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {");
            emit("  return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }");
            emit("");
        }
        emit("private Factory() { } // No instance of this class allowed");
        outdent();
        emit("}");
    }

    void printNestedInnerTypes(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem) throws IOException {
        boolean z = schemaType.getName() != null && schemaType.getName().equals(schemaType.getBaseType().getName());
        while (schemaType != null) {
            SchemaType[] anonymousTypes = schemaType.getAnonymousTypes();
            for (int i = 0; i < anonymousTypes.length; i++) {
                if (anonymousTypes[i].isSkippedAnonymousType()) {
                    printNestedInnerTypes(anonymousTypes[i], schemaTypeSystem);
                } else {
                    printInnerType(anonymousTypes[i], schemaTypeSystem);
                }
            }
            if (!z) {
                return;
            }
            if (schemaType.getDerivationType() != 2 && !schemaType.isSimpleType()) {
                return;
            } else {
                schemaType = schemaType.getBaseType();
            }
        }
    }

    void printTopComment(SchemaType schemaType) throws IOException {
        QName attributeTypeAttributeName;
        emit("/*");
        if (schemaType.getName() != null) {
            emit(" * XML Type:  " + schemaType.getName().getLocalPart());
            emit(" * Namespace: " + schemaType.getName().getNamespaceURI());
        } else {
            if (schemaType.isDocumentType()) {
                attributeTypeAttributeName = schemaType.getDocumentElementName();
                emit(" * An XML document type.");
            } else if (schemaType.isAttributeType()) {
                attributeTypeAttributeName = schemaType.getAttributeTypeAttributeName();
                emit(" * An XML attribute type.");
            } else {
                attributeTypeAttributeName = null;
            }
            emit(" * Localname: " + attributeTypeAttributeName.getLocalPart());
            emit(" * Namespace: " + attributeTypeAttributeName.getNamespaceURI());
        }
        emit(" * Java type: " + schemaType.getFullJavaName());
        emit(" *");
        emit(" * Automatically generated - do not modify.");
        emit(" */");
    }

    void printPackage(SchemaType schemaType, boolean z) throws IOException {
        String fullJavaImplName;
        if (z) {
            fullJavaImplName = schemaType.getFullJavaName();
        } else {
            fullJavaImplName = schemaType.getFullJavaImplName();
        }
        int iLastIndexOf = fullJavaImplName.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return;
        }
        emit("package " + fullJavaImplName.substring(0, iLastIndexOf) + ";");
    }

    void startInterface(SchemaType schemaType) throws IOException {
        emit("public interface " + schemaType.getShortJavaName() + " extends " + findJavaType(schemaType.getBaseType()) + getExtensionInterfaces(schemaType));
        emit("{");
        indent();
        emitSpecializedAccessors(schemaType);
    }

    private static String getExtensionInterfaces(SchemaType schemaType) {
        SchemaTypeImpl impl = getImpl(schemaType);
        if (impl == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        InterfaceExtension[] interfaceExtensions = impl.getInterfaceExtensions();
        if (interfaceExtensions != null) {
            for (InterfaceExtension interfaceExtension : interfaceExtensions) {
                stringBuffer.append(", " + interfaceExtension.getInterface());
            }
        }
        return stringBuffer.toString();
    }

    private static SchemaTypeImpl getImpl(SchemaType schemaType) {
        if (schemaType instanceof SchemaTypeImpl) {
            return (SchemaTypeImpl) schemaType;
        }
        return null;
    }

    private void emitSpecializedAccessors(SchemaType schemaType) throws IOException {
        int decimalSize;
        if (schemaType.getSimpleVariety() == 1 && schemaType.getPrimitiveType().getBuiltinTypeCode() == 11 && ((decimalSize = schemaType.getDecimalSize()) != schemaType.getBaseType().getDecimalSize() || schemaType.getBaseType().getFullJavaName() == null)) {
            if (decimalSize == 1000000) {
                emit("java.math.BigInteger getBigIntegerValue();");
                emit("void setBigIntegerValue(java.math.BigInteger bi);");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("java.math.BigInteger bigIntegerValue();");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("void set(java.math.BigInteger bi);");
            } else if (decimalSize == 64) {
                emit("long getLongValue();");
                emit("void setLongValue(long l);");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("long longValue();");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("void set(long l);");
            } else if (decimalSize == 32) {
                emit("int getIntValue();");
                emit("void setIntValue(int i);");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("int intValue();");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("void set(int i);");
            } else if (decimalSize == 16) {
                emit("short getShortValue();");
                emit("void setShortValue(short s);");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("short shortValue();");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("void set(short s);");
            } else if (decimalSize == 8) {
                emit("byte getByteValue();");
                emit("void setByteValue(byte b);");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("byte byteValue();");
                emit("/** @deprecated */");
                if (this._useJava15) {
                    emit("@Deprecated");
                }
                emit("void set(byte b);");
            }
        }
        if (schemaType.getSimpleVariety() == 2) {
            emit("java.lang.Object getObjectValue();");
            emit("void setObjectValue(java.lang.Object val);");
            emit("/** @deprecated */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
            emit("java.lang.Object objectValue();");
            emit("/** @deprecated */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
            emit("void objectSet(java.lang.Object val);");
            emit("org.apache.xmlbeans.SchemaType instanceType();");
            SchemaType unionCommonBaseType = schemaType.getUnionCommonBaseType();
            if (unionCommonBaseType != null) {
                unionCommonBaseType.getSimpleVariety();
            }
            emitSpecializedAccessors(unionCommonBaseType);
        }
        if (schemaType.getSimpleVariety() == 3) {
            emit("java.util.List getListValue();");
            emit("java.util.List xgetListValue();");
            emit("void setListValue(java.util.List list);");
            emit("/** @deprecated */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
            emit("java.util.List listValue();");
            emit("/** @deprecated */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
            emit("java.util.List xlistValue();");
            emit("/** @deprecated */");
            if (this._useJava15) {
                emit("@Deprecated");
            }
            emit("void set(java.util.List list);");
        }
    }

    void startBlock() throws IOException {
        emit("{");
        indent();
    }

    void endBlock() throws IOException {
        outdent();
        emit("}");
    }

    void printJavaDoc(String str) throws IOException {
        emit("");
        emit("/**");
        emit(" * " + str);
        emit(" */");
    }

    void printShortJavaDoc(String str) throws IOException {
        emit("/** " + str + " */");
    }

    public static String javaStringEscape(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\"' || cCharAt == '\\') {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < str.length(); i2++) {
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 == '\n') {
                        stringBuffer.append("\\n");
                    } else if (cCharAt2 == '\r') {
                        stringBuffer.append("\\r");
                    } else if (cCharAt2 == '\"') {
                        stringBuffer.append("\\\"");
                    } else if (cCharAt2 != '\\') {
                        stringBuffer.append(cCharAt2);
                    } else {
                        stringBuffer.append("\\\\");
                    }
                }
                return stringBuffer.toString();
            }
        }
        return str;
    }

    void printStringEnumeration(SchemaType schemaType) throws IOException {
        String fullJavaName = schemaType.getBaseEnumType().getFullJavaName();
        boolean zHasBase = hasBase(schemaType);
        if (!zHasBase) {
            emit("");
            emit("org.apache.xmlbeans.StringEnumAbstractBase enumValue();");
            emit("void set(org.apache.xmlbeans.StringEnumAbstractBase e);");
        }
        emit("");
        SchemaStringEnumEntry[] stringEnumEntries = schemaType.getStringEnumEntries();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (int i = 0; i < stringEnumEntries.length; i++) {
            String string = stringEnumEntries[i].getString();
            if (hashSet.contains(string)) {
                hashSet2.add(string);
            } else {
                hashSet.add(string);
                String enumName = stringEnumEntries[i].getEnumName();
                if (zHasBase) {
                    emit("static final " + fullJavaName + ".Enum " + enumName + " = " + fullJavaName + "." + enumName + ";");
                } else {
                    emit("static final Enum " + enumName + " = Enum.forString(\"" + javaStringEscape(string) + "\");");
                }
            }
        }
        emit("");
        for (int i2 = 0; i2 < stringEnumEntries.length; i2++) {
            if (!hashSet2.contains(stringEnumEntries[i2].getString())) {
                String str = "INT_" + stringEnumEntries[i2].getEnumName();
                if (zHasBase) {
                    emit("static final int " + str + " = " + fullJavaName + "." + str + ";");
                } else {
                    emit("static final int " + str + " = Enum." + str + ";");
                }
            }
        }
        if (zHasBase) {
            return;
        }
        emit("");
        emit("/**");
        emit(" * Enumeration value class for " + fullJavaName + ".");
        emit(" * These enum values can be used as follows:");
        emit(" * <pre>");
        emit(" * enum.toString(); // returns the string value of the enum");
        emit(" * enum.intValue(); // returns an int value, useful for switches");
        if (stringEnumEntries.length > 0) {
            emit(" * // e.g., case Enum.INT_" + stringEnumEntries[0].getEnumName());
        }
        emit(" * Enum.forString(s); // returns the enum value for a string");
        emit(" * Enum.forInt(i); // returns the enum value for an int");
        emit(" * </pre>");
        emit(" * Enumeration objects are immutable singleton objects that");
        emit(" * can be compared using == object equality. They have no");
        emit(" * public constructor. See the constants defined within this");
        emit(" * class for all the valid values.");
        emit(" */");
        emit("static final class Enum extends org.apache.xmlbeans.StringEnumAbstractBase");
        emit("{");
        indent();
        emit("/**");
        emit(" * Returns the enum value for a string, or null if none.");
        emit(" */");
        emit("public static Enum forString(java.lang.String s)");
        emit("    { return (Enum)table.forString(s); }");
        emit("/**");
        emit(" * Returns the enum value corresponding to an int, or null if none.");
        emit(" */");
        emit("public static Enum forInt(int i)");
        emit("    { return (Enum)table.forInt(i); }");
        emit("");
        emit("private Enum(java.lang.String s, int i)");
        emit("    { super(s, i); }");
        emit("");
        for (int i3 = 0; i3 < stringEnumEntries.length; i3++) {
            emit("static final int " + ("INT_" + stringEnumEntries[i3].getEnumName()) + " = " + stringEnumEntries[i3].getIntValue() + ";");
        }
        emit("");
        emit("public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =");
        emit("    new org.apache.xmlbeans.StringEnumAbstractBase.Table");
        emit("(");
        indent();
        emit("new Enum[]");
        emit("{");
        indent();
        for (int i4 = 0; i4 < stringEnumEntries.length; i4++) {
            emit("new Enum(\"" + javaStringEscape(stringEnumEntries[i4].getString()) + "\", " + ("INT_" + stringEnumEntries[i4].getEnumName()) + "),");
        }
        outdent();
        emit("}");
        outdent();
        emit(");");
        emit("private static final long serialVersionUID = 1L;");
        emit("private java.lang.Object readResolve() { return forInt(intValue()); } ");
        outdent();
        emit("}");
    }

    private boolean hasBase(SchemaType schemaType) {
        SchemaType baseEnumType = schemaType.getBaseEnumType();
        if (baseEnumType.isAnonymousType() && baseEnumType.isSkippedAnonymousType()) {
            if (schemaType.getContentBasedOnType() != null) {
                if (schemaType.getContentBasedOnType().getBaseType() != baseEnumType) {
                    return true;
                }
            } else if (schemaType.getBaseType() != baseEnumType) {
                return true;
            }
        } else if (baseEnumType != schemaType) {
            return true;
        }
        return $assertionsDisabled;
    }

    String xmlTypeForProperty(SchemaProperty schemaProperty) {
        return findJavaType(schemaProperty.javaBasedOnType()).replace('$', NameUtil.PERIOD);
    }

    static boolean xmlTypeForPropertyIsUnion(SchemaProperty schemaProperty) {
        SchemaType schemaTypeJavaBasedOnType = schemaProperty.javaBasedOnType();
        if (schemaTypeJavaBasedOnType.isSimpleType() && schemaTypeJavaBasedOnType.getSimpleVariety() == 2) {
            return true;
        }
        return $assertionsDisabled;
    }

    static String javaWrappedType(int i) {
        switch (i) {
            case 1:
                return "java.lang.Boolean";
            case 2:
                return "java.lang.Float";
            case 3:
                return "java.lang.Double";
            case 4:
                return "java.lang.Byte";
            case 5:
                return "java.lang.Short";
            case 6:
                return "java.lang.Integer";
            case 7:
                return "java.lang.Long";
            default:
                throw new IllegalStateException();
        }
    }

    String javaTypeForProperty(SchemaProperty schemaProperty) {
        if (schemaProperty.getJavaTypeCode() == 0) {
            return findJavaType(schemaProperty.javaBasedOnType()).replace('$', NameUtil.PERIOD);
        }
        if (schemaProperty.getJavaTypeCode() == 20) {
            return ((SchemaTypeImpl) schemaProperty.getType()).getUserTypeName();
        }
        switch (schemaProperty.getJavaTypeCode()) {
            case 1:
                return "boolean";
            case 2:
                return "float";
            case 3:
                return "double";
            case 4:
                return "byte";
            case 5:
                return "short";
            case 6:
                return "int";
            case 7:
                return "long";
            case 8:
                return "java.math.BigDecimal";
            case 9:
                return "java.math.BigInteger";
            case 10:
                return "java.lang.String";
            case 11:
                return "byte[]";
            case 12:
                return "org.apache.xmlbeans.GDate";
            case 13:
                return "org.apache.xmlbeans.GDuration";
            case 14:
                return "java.util.Date";
            case 15:
                return "javax.xml.namespace.QName";
            case 16:
                return "java.util.List";
            case 17:
                return "java.util.Calendar";
            case 18:
                SchemaType schemaTypeJavaBasedOnType = schemaProperty.javaBasedOnType();
                if (schemaTypeJavaBasedOnType.getSimpleVariety() == 2) {
                    schemaTypeJavaBasedOnType = schemaTypeJavaBasedOnType.getUnionCommonBaseType();
                }
                if (hasBase(schemaTypeJavaBasedOnType)) {
                    return findJavaType(schemaTypeJavaBasedOnType.getBaseEnumType()).replace('$', NameUtil.PERIOD) + ".Enum";
                }
                return findJavaType(schemaTypeJavaBasedOnType).replace('$', NameUtil.PERIOD) + ".Enum";
            case 19:
                return "java.lang.Object";
            default:
                throw new IllegalStateException();
        }
    }

    void printPropertyGetters(QName qName, boolean z, String str, int i, String str2, String str3, boolean z2, boolean z3, boolean z4, boolean z5) throws IOException {
        String str4 = "\"" + qName.getLocalPart() + "\"" + (z ? " attribute" : " element");
        boolean z6 = i == 0 ? true : $assertionsDisabled;
        if (z5) {
            printJavaDoc((z4 ? "Gets first " : "Gets the ") + str4);
            emit(str2 + " get" + str + "();");
            if (!z6) {
                printJavaDoc((z4 ? "Gets (as xml) first " : "Gets (as xml) the ") + str4);
                emit(str3 + " xget" + str + "();");
            }
            if (z2) {
                printJavaDoc((z4 ? "Tests for nil first " : "Tests for nil ") + str4);
                emit("boolean isNil" + str + "();");
            }
        }
        if (z3) {
            printJavaDoc((z4 ? "True if has at least one " : "True if has ") + str4);
            emit("boolean isSet" + str + "();");
        }
        if (z4) {
            String str5 = str + SoapEncSchemaTypeSystem.SOAP_ARRAY;
            if (this._useJava15) {
                String strJavaWrappedType = isJavaPrimitive(i) ? javaWrappedType(i) : str2;
                printJavaDoc("Gets a List of " + str4 + "s");
                emit("java.util.List<" + strJavaWrappedType + "> get" + str + "List();");
            }
            if (this._useJava15) {
                emit("");
                emit("/**");
                emit(" * Gets array of all " + str4 + "s");
                emit(" * @deprecated");
                emit(" */");
                emit("@Deprecated");
            } else {
                printJavaDoc("Gets array of all " + str4 + "s");
            }
            emit(str2 + "[] get" + str5 + "();");
            printJavaDoc("Gets ith " + str4);
            emit(str2 + " get" + str5 + "(int i);");
            if (!z6) {
                if (this._useJava15) {
                    printJavaDoc("Gets (as xml) a List of " + str4 + "s");
                    emit("java.util.List<" + str3 + "> xget" + str + "List();");
                }
                if (this._useJava15) {
                    emit("");
                    emit("/**");
                    emit(" * Gets (as xml) array of all " + str4 + "s");
                    emit(" * @deprecated");
                    emit(" */");
                    emit("@Deprecated");
                } else {
                    printJavaDoc("Gets (as xml) array of all " + str4 + "s");
                }
                emit(str3 + "[] xget" + str5 + "();");
                printJavaDoc("Gets (as xml) ith " + str4);
                emit(str3 + " xget" + str5 + "(int i);");
            }
            if (z2) {
                printJavaDoc("Tests for nil ith " + str4);
                emit("boolean isNil" + str5 + "(int i);");
            }
            printJavaDoc("Returns number of " + str4);
            emit("int sizeOf" + str5 + "();");
        }
    }

    void printPropertySetters(QName qName, boolean z, String str, int i, String str2, String str3, boolean z2, boolean z3, boolean z4, boolean z5) throws IOException {
        String str4;
        String str5;
        String strNonJavaKeyword = NameUtil.nonJavaKeyword(NameUtil.lowerCamelCase(str));
        if (strNonJavaKeyword.equals("i")) {
            strNonJavaKeyword = "iValue";
        }
        boolean z6 = i == 0 ? true : $assertionsDisabled;
        String str6 = "\"" + qName.getLocalPart() + "\"" + (z ? " attribute" : " element");
        if (z5) {
            printJavaDoc((z4 ? "Sets first " : "Sets the ") + str6);
            emit("void set" + str + "(" + str2 + " " + strNonJavaKeyword + ");");
            if (!z6) {
                printJavaDoc((z4 ? "Sets (as xml) first " : "Sets (as xml) the ") + str6);
                emit("void xset" + str + "(" + str3 + " " + strNonJavaKeyword + ");");
            }
            if (z6 && !z4) {
                printJavaDoc("Appends and returns a new empty " + str6);
                emit(str3 + " addNew" + str + "();");
            }
            if (z2) {
                printJavaDoc((z4 ? "Nils the first " : "Nils the ") + str6);
                str4 = "void setNil";
                emit(str4 + str + "();");
            } else {
                str4 = "void setNil";
            }
        } else {
            str4 = "void setNil";
        }
        if (z3) {
            printJavaDoc((z4 ? "Removes first " : "Unsets the ") + str6);
            emit("void unset" + str + "();");
        }
        if (z4) {
            String str7 = str + SoapEncSchemaTypeSystem.SOAP_ARRAY;
            printJavaDoc("Sets array of all " + str6);
            emit("void set" + str7 + "(" + str2 + "[] " + strNonJavaKeyword + "Array);");
            String str8 = str4;
            printJavaDoc("Sets ith " + str6);
            emit("void set" + str7 + "(int i, " + str2 + " " + strNonJavaKeyword + ");");
            if (!z6) {
                printJavaDoc("Sets (as xml) array of all " + str6);
                emit("void xset" + str7 + "(" + str3 + "[] " + strNonJavaKeyword + "Array);");
                printJavaDoc("Sets (as xml) ith " + str6);
                emit("void xset" + str7 + "(int i, " + str3 + " " + strNonJavaKeyword + ");");
            }
            if (z2) {
                printJavaDoc("Nils the ith " + str6);
                emit(str8 + str7 + "(int i);");
            }
            if (z6) {
                str5 = str;
            } else {
                printJavaDoc("Inserts the value as the ith " + str6);
                str5 = str;
                emit("void insert" + str5 + "(int i, " + str2 + " " + strNonJavaKeyword + ");");
                printJavaDoc("Appends the value as the last " + str6);
                emit("void add" + str5 + "(" + str2 + " " + strNonJavaKeyword + ");");
            }
            printJavaDoc("Inserts and returns a new empty value (as xml) as the ith " + str6);
            emit(str3 + " insertNew" + str5 + "(int i);");
            printJavaDoc("Appends and returns a new empty value (as xml) as the last " + str6);
            emit(str3 + " addNew" + str5 + "();");
            printJavaDoc("Removes the ith " + str6);
            emit("void remove" + str5 + "(int i);");
        }
    }

    String getAtomicRestrictionType(SchemaType schemaType) {
        switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
            case 2:
                return "org.apache.xmlbeans.impl.values.XmlAnySimpleTypeImpl";
            case 3:
                return "org.apache.xmlbeans.impl.values.JavaBooleanHolderEx";
            case 4:
                return "org.apache.xmlbeans.impl.values.JavaBase64HolderEx";
            case 5:
                return "org.apache.xmlbeans.impl.values.JavaHexBinaryHolderEx";
            case 6:
                return "org.apache.xmlbeans.impl.values.JavaUriHolderEx";
            case 7:
                return "org.apache.xmlbeans.impl.values.JavaQNameHolderEx";
            case 8:
                return "org.apache.xmlbeans.impl.values.JavaNotationHolderEx";
            case 9:
                return "org.apache.xmlbeans.impl.values.JavaFloatHolderEx";
            case 10:
                return "org.apache.xmlbeans.impl.values.JavaDoubleHolderEx";
            case 11:
                int decimalSize = schemaType.getDecimalSize();
                if (decimalSize == 8 || decimalSize == 16 || decimalSize == 32) {
                    return "org.apache.xmlbeans.impl.values.JavaIntHolderEx";
                }
                if (decimalSize == 64) {
                    return "org.apache.xmlbeans.impl.values.JavaLongHolderEx";
                }
                switch (decimalSize) {
                    case 1000000:
                        return "org.apache.xmlbeans.impl.values.JavaIntegerHolderEx";
                    case 1000001:
                    default:
                        return "org.apache.xmlbeans.impl.values.JavaDecimalHolderEx";
                }
            case 12:
                return schemaType.hasStringEnumValues() ? "org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx" : "org.apache.xmlbeans.impl.values.JavaStringHolderEx";
            case 13:
                return "org.apache.xmlbeans.impl.values.JavaGDurationHolderEx";
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return "org.apache.xmlbeans.impl.values.JavaGDateHolderEx";
            default:
                return null;
        }
    }

    static SchemaType findBaseType(SchemaType schemaType) {
        while (schemaType.getFullJavaName() == null) {
            schemaType = schemaType.getBaseType();
        }
        return schemaType;
    }

    String getBaseClass(SchemaType schemaType) {
        SchemaType schemaTypeFindBaseType = findBaseType(schemaType.getBaseType());
        int simpleVariety = schemaType.getSimpleVariety();
        if (simpleVariety == 0) {
            return !XmlObject.type.equals(schemaTypeFindBaseType) ? schemaTypeFindBaseType.getFullJavaImplName() : "org.apache.xmlbeans.impl.values.XmlComplexContentImpl";
        }
        if (simpleVariety == 1) {
            return getAtomicRestrictionType(schemaType);
        }
        if (simpleVariety == 2) {
            return "org.apache.xmlbeans.impl.values.XmlUnionImpl";
        }
        if (simpleVariety == 3) {
            return "org.apache.xmlbeans.impl.values.XmlListImpl";
        }
        throw new IllegalStateException();
    }

    void printConstructor(SchemaType schemaType, String str) throws IOException {
        emit("");
        emit("public " + str + "(org.apache.xmlbeans.SchemaType sType)");
        startBlock();
        emit("super(sType" + (schemaType.getSimpleVariety() == 0 ? "" : ", " + (!schemaType.isSimpleType())) + ");");
        endBlock();
        if (schemaType.getSimpleVariety() != 0) {
            emit("");
            emit("protected " + str + "(org.apache.xmlbeans.SchemaType sType, boolean b)");
            startBlock();
            emit("super(sType, b);");
            endBlock();
        }
    }

    void startClass(SchemaType schemaType, boolean z) throws IOException {
        String shortJavaImplName = schemaType.getShortJavaImplName();
        String baseClass = getBaseClass(schemaType);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(schemaType.getFullJavaName().replace('$', NameUtil.PERIOD));
        if (schemaType.getSimpleVariety() == 2) {
            for (SchemaType schemaType2 : schemaType.getUnionMemberTypes()) {
                stringBuffer.append(", " + schemaType2.getFullJavaName().replace('$', NameUtil.PERIOD));
            }
        }
        emit("public " + (z ? "static " : "") + "class " + shortJavaImplName + " extends " + baseClass + " implements " + stringBuffer.toString());
        startBlock();
        emit("private static final long serialVersionUID = 1L;");
    }

    void makeAttributeDefaultValue(String str, SchemaProperty schemaProperty, String str2) throws IOException {
        if (str == null) {
            str = schemaProperty.javaBasedOnType().getFullJavaName().replace('$', NameUtil.PERIOD);
        }
        emit("target = (" + str + ")get_default_attribute_value(" + str2 + ");");
    }

    void makeMissingValue(int i) throws IOException {
        switch (i) {
            case 1:
                emit("return false;");
                break;
            case 2:
                emit("return 0.0f;");
                break;
            case 3:
                emit("return 0.0;");
                break;
            case 4:
            case 5:
            case 6:
                emit("return 0;");
                break;
            case 7:
                emit("return 0L;");
                break;
            default:
                emit("return null;");
                break;
        }
    }

    void printJGetArrayValue(int i, String str, SchemaTypeImpl schemaTypeImpl) throws IOException {
        switch (i) {
            case 0:
                emit(str + "[] result = new " + str + "[targetList.size()];");
                emit("targetList.toArray(result);");
                break;
            case 1:
                emit("boolean[] result = new boolean[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getBooleanValue();");
                break;
            case 2:
                emit("float[] result = new float[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getFloatValue();");
                break;
            case 3:
                emit("double[] result = new double[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getDoubleValue();");
                break;
            case 4:
                emit("byte[] result = new byte[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getByteValue();");
                break;
            case 5:
                emit("short[] result = new short[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getShortValue();");
                break;
            case 6:
                emit("int[] result = new int[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getIntValue();");
                break;
            case 7:
                emit("long[] result = new long[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getLongValue();");
                break;
            case 8:
                emit("java.math.BigDecimal[] result = new java.math.BigDecimal[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getBigDecimalValue();");
                break;
            case 9:
                emit("java.math.BigInteger[] result = new java.math.BigInteger[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getBigIntegerValue();");
                break;
            case 10:
                emit("java.lang.String[] result = new java.lang.String[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();");
                break;
            case 11:
                emit("byte[][] result = new byte[targetList.size()][];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getByteArrayValue();");
                break;
            case 12:
                emit("org.apache.xmlbeans.GDate[] result = new org.apache.xmlbeans.GDate[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getGDateValue();");
                break;
            case 13:
                emit("org.apache.xmlbeans.GDuration[] result = new org.apache.xmlbeans.GDuration[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getGDurationValue();");
                break;
            case 14:
                emit("java.util.Date[] result = new java.util.Date[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getDateValue();");
                break;
            case 15:
                emit("javax.xml.namespace.QName[] result = new javax.xml.namespace.QName[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getQNameValue();");
                break;
            case 16:
                emit("java.util.List[] result = new java.util.List[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getListValue();");
                break;
            case 17:
                emit("java.util.Calendar[] result = new java.util.Calendar[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getCalendarValue();");
                break;
            case 18:
                emit(str + "[] result = new " + str + "[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = (" + str + ")((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getEnumValue();");
                break;
            case 19:
                emit("java.lang.Object[] result = new java.lang.Object[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getObjectValue();");
                break;
            case 20:
                emit(schemaTypeImpl.getUserTypeName() + "[] result = new " + schemaTypeImpl.getUserTypeName() + "[targetList.size()];");
                emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
                emit("    result[i] = " + getUserTypeStaticHandlerMethod($assertionsDisabled, schemaTypeImpl) + "((org.apache.xmlbeans.SimpleValue)targetList.get(i));");
                break;
            default:
                throw new IllegalStateException();
        }
        emit("return result;");
    }

    void printJGetValue(int i, String str, SchemaTypeImpl schemaTypeImpl) throws IOException {
        switch (i) {
            case 0:
                emit("return target;");
                return;
            case 1:
                emit("return target.getBooleanValue();");
                return;
            case 2:
                emit("return target.getFloatValue();");
                return;
            case 3:
                emit("return target.getDoubleValue();");
                return;
            case 4:
                emit("return target.getByteValue();");
                return;
            case 5:
                emit("return target.getShortValue();");
                return;
            case 6:
                emit("return target.getIntValue();");
                return;
            case 7:
                emit("return target.getLongValue();");
                return;
            case 8:
                emit("return target.getBigDecimalValue();");
                return;
            case 9:
                emit("return target.getBigIntegerValue();");
                return;
            case 10:
                emit("return target.getStringValue();");
                return;
            case 11:
                emit("return target.getByteArrayValue();");
                return;
            case 12:
                emit("return target.getGDateValue();");
                return;
            case 13:
                emit("return target.getGDurationValue();");
                return;
            case 14:
                emit("return target.getDateValue();");
                return;
            case 15:
                emit("return target.getQNameValue();");
                return;
            case 16:
                emit("return target.getListValue();");
                return;
            case 17:
                emit("return target.getCalendarValue();");
                return;
            case 18:
                emit("return (" + str + ")target.getEnumValue();");
                return;
            case 19:
                emit("return target.getObjectValue();");
                return;
            case 20:
                emit("return " + getUserTypeStaticHandlerMethod($assertionsDisabled, schemaTypeImpl) + "(target);");
                return;
            default:
                throw new IllegalStateException();
        }
    }

    void printJSetValue(int i, String str, SchemaTypeImpl schemaTypeImpl) throws IOException {
        switch (i) {
            case 0:
                emit("target.set(" + str + ");");
                return;
            case 1:
                emit("target.setBooleanValue(" + str + ");");
                return;
            case 2:
                emit("target.setFloatValue(" + str + ");");
                return;
            case 3:
                emit("target.setDoubleValue(" + str + ");");
                return;
            case 4:
                emit("target.setByteValue(" + str + ");");
                return;
            case 5:
                emit("target.setShortValue(" + str + ");");
                return;
            case 6:
                emit("target.setIntValue(" + str + ");");
                return;
            case 7:
                emit("target.setLongValue(" + str + ");");
                return;
            case 8:
                emit("target.setBigDecimalValue(" + str + ");");
                return;
            case 9:
                emit("target.setBigIntegerValue(" + str + ");");
                return;
            case 10:
                emit("target.setStringValue(" + str + ");");
                return;
            case 11:
                emit("target.setByteArrayValue(" + str + ");");
                return;
            case 12:
                emit("target.setGDateValue(" + str + ");");
                return;
            case 13:
                emit("target.setGDurationValue(" + str + ");");
                return;
            case 14:
                emit("target.setDateValue(" + str + ");");
                return;
            case 15:
                emit("target.setQNameValue(" + str + ");");
                return;
            case 16:
                emit("target.setListValue(" + str + ");");
                return;
            case 17:
                emit("target.setCalendarValue(" + str + ");");
                return;
            case 18:
                emit("target.setEnumValue(" + str + ");");
                return;
            case 19:
                emit("target.setObjectValue(" + str + ");");
                return;
            case 20:
                emit(getUserTypeStaticHandlerMethod(true, schemaTypeImpl) + "(" + str + ", target);");
                return;
            default:
                throw new IllegalStateException();
        }
    }

    String getIdentifier(Map map, QName qName) {
        return ((String[]) map.get(qName))[0];
    }

    String getSetIdentifier(Map map, QName qName) {
        String[] strArr = (String[]) map.get(qName);
        String str = strArr[1];
        return str == null ? strArr[0] : str;
    }

    Map printStaticFields(SchemaProperty[] schemaPropertyArr) throws IOException {
        HashMap map = new HashMap();
        emit("");
        for (int i = 0; i < schemaPropertyArr.length; i++) {
            String[] strArr = new String[2];
            SchemaProperty schemaProperty = schemaPropertyArr[i];
            QName name = schemaProperty.getName();
            map.put(name, strArr);
            String javaPropertyName = schemaProperty.getJavaPropertyName();
            int i2 = i * 2;
            strArr[0] = (javaPropertyName + "$" + i2).toUpperCase();
            String str = "\"" + name.getNamespaceURI() + "\"";
            emit("private static final javax.xml.namespace.QName " + strArr[0] + " = ");
            indent();
            emit("new javax.xml.namespace.QName(" + str + ", \"" + name.getLocalPart() + "\");");
            outdent();
            if (schemaPropertyArr[i].acceptedNames() != null) {
                QName[] qNameArrAcceptedNames = schemaPropertyArr[i].acceptedNames();
                if (qNameArrAcceptedNames.length > 1) {
                    strArr[1] = (javaPropertyName + "$" + (i2 + 1)).toUpperCase();
                    emit("private static final org.apache.xmlbeans.QNameSet " + strArr[1] + " = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { ");
                    indent();
                    for (int i3 = 0; i3 < qNameArrAcceptedNames.length; i3++) {
                        emit("new javax.xml.namespace.QName(\"" + qNameArrAcceptedNames[i3].getNamespaceURI() + "\", \"" + qNameArrAcceptedNames[i3].getLocalPart() + "\"),");
                    }
                    outdent();
                    emit("});");
                }
            }
        }
        emit("");
        return map;
    }

    void emitImplementationPreamble() throws IOException {
        emit("synchronized (monitor())");
        emit("{");
        indent();
        emit("check_orphaned();");
    }

    void emitImplementationPostamble() throws IOException {
        outdent();
        emit("}");
    }

    void emitDeclareTarget(boolean z, String str) throws IOException {
        if (z) {
            emit(str + " target = null;");
        }
    }

    void emitAddTarget(String str, boolean z, boolean z2, String str2) throws IOException {
        if (z) {
            emit("target = (" + str2 + ")get_store().add_attribute_user(" + str + ");");
        } else {
            emit("target = (" + str2 + ")get_store().add_element_user(" + str + ");");
        }
    }

    void emitPre(SchemaType schemaType, int i, String str, boolean z) throws IOException {
        emitPre(schemaType, i, str, z, "-1");
    }

    void emitPre(SchemaType schemaType, int i, String str, boolean z, String str2) throws IOException {
        PrePostExtension prePostExtension;
        SchemaTypeImpl impl = getImpl(schemaType);
        if (impl == null || (prePostExtension = impl.getPrePostExtension()) == null || !prePostExtension.hasPreCall()) {
            return;
        }
        emit("if ( " + prePostExtension.getStaticHandler() + ".preSet(" + prePostOpString(i) + ", this, " + str + ", " + z + ", " + str2 + "))");
        startBlock();
    }

    void emitPost(SchemaType schemaType, int i, String str, boolean z) throws IOException {
        emitPost(schemaType, i, str, z, "-1");
    }

    void emitPost(SchemaType schemaType, int i, String str, boolean z, String str2) throws IOException {
        PrePostExtension prePostExtension;
        SchemaTypeImpl impl = getImpl(schemaType);
        if (impl == null || (prePostExtension = impl.getPrePostExtension()) == null) {
            return;
        }
        if (prePostExtension.hasPreCall()) {
            endBlock();
        }
        if (prePostExtension.hasPostCall()) {
            emit(prePostExtension.getStaticHandler() + ".postSet(" + prePostOpString(i) + ", this, " + str + ", " + z + ", " + str2 + ");");
        }
    }

    void emitGetTarget(String str, String str2, boolean z, String str3, int i, String str4) throws IOException {
        emit(str4 + " target = null;");
        if (z) {
            emit("target = (" + str4 + ")get_store().find_attribute_user(" + str2 + ");");
        } else {
            emit("target = (" + str4 + ")get_store().find_element_user(" + str + ", " + str3 + ");");
        }
        if (i == 1) {
            return;
        }
        emit("if (target == null)");
        startBlock();
        if (i != 1) {
            if (i == 3) {
                emitAddTarget(str2, z, $assertionsDisabled, str4);
            } else if (i == 4) {
                emit("throw new IndexOutOfBoundsException();");
            }
        }
        endBlock();
    }

    void printListGetter15Impl(String str, String str2, String str3, String str4, String str5, boolean z, boolean z2) throws IOException {
        String str6 = str3 + SoapEncSchemaTypeSystem.SOAP_ARRAY;
        String str7 = str3 + "List";
        String str8 = str + ".this.";
        String strConcat = (z2 ? "x" : "").concat("get");
        String strConcat2 = (z2 ? "x" : "").concat("set");
        printJavaDoc("Gets " + (z2 ? "(as xml) " : "") + "a List of " + str2 + "s");
        emit("public java.util.List<" + str4 + "> " + strConcat + str7 + "()");
        startBlock();
        emit("final class " + str7 + " extends java.util.AbstractList<" + str4 + ">");
        startBlock();
        if (this._useJava15) {
            emit("@Override");
        }
        emit("public " + str4 + " get(int i)");
        emit("    { return " + str8 + strConcat + str6 + "(i); }");
        emit("");
        if (this._useJava15) {
            emit("@Override");
        }
        emit("public " + str4 + " set(int i, " + str4 + " o)");
        startBlock();
        emit(str4 + " old = " + str8 + strConcat + str6 + "(i);");
        emit(str8 + strConcat2 + str6 + "(i, o);");
        emit("return old;");
        endBlock();
        emit("");
        if (this._useJava15) {
            emit("@Override");
        }
        emit("public void add(int i, " + str4 + " o)");
        if (z || z2) {
            emit("    { " + str8 + "insertNew" + str3 + "(i).set(o); }");
        } else {
            emit("    { " + str8 + "insert" + str3 + "(i, o); }");
        }
        emit("");
        if (this._useJava15) {
            emit("@Override");
        }
        emit("public " + str4 + " remove(int i)");
        startBlock();
        emit(str4 + " old = " + str8 + strConcat + str6 + "(i);");
        emit(str8 + "remove" + str3 + "(i);");
        emit("return old;");
        endBlock();
        emit("");
        if (this._useJava15) {
            emit("@Override");
        }
        emit("public int size()");
        emit("    { return " + str8 + "sizeOf" + str6 + "(); }");
        emit("");
        endBlock();
        emit("");
        emitImplementationPreamble();
        emit("return new " + str7 + "();");
        emitImplementationPostamble();
        endBlock();
    }

    void printGetterImpls(String str, SchemaProperty schemaProperty, QName qName, boolean z, String str2, int i, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str5, String str6) throws IOException {
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16 = "\"" + qName.getLocalPart() + "\"" + (z ? " attribute" : " element");
        boolean z7 = i == 0 ? true : $assertionsDisabled;
        String str17 = (z6 || !z7) ? "org.apache.xmlbeans.SimpleValue" : str4;
        if (z5) {
            printJavaDoc((z4 ? "Gets first " : "Gets the ") + str16);
            emit("public " + str3 + " get" + str2 + "()");
            startBlock();
            emitImplementationPreamble();
            str9 = " get";
            String str18 = str17;
            str11 = " xget";
            emitGetTarget(str6, str5, z, "0", 1, str18);
            if (z && (schemaProperty.hasDefault() == 2 || schemaProperty.hasFixed() == 2)) {
                emit("if (target == null)");
                startBlock();
                str10 = str18;
                makeAttributeDefaultValue(str10, schemaProperty, str5);
                endBlock();
            } else {
                str10 = str18;
            }
            emit("if (target == null)");
            startBlock();
            makeMissingValue(i);
            endBlock();
            printJGetValue(i, str3, (SchemaTypeImpl) schemaProperty.getType());
            emitImplementationPostamble();
            endBlock();
            if (z7) {
                str15 = "()";
                str8 = "public ";
            } else {
                printJavaDoc((z4 ? "Gets (as xml) first " : "Gets (as xml) the ") + str16);
                emit("public " + str4 + str11 + str2 + "()");
                startBlock();
                emitImplementationPreamble();
                str15 = "()";
                str8 = "public ";
                emitGetTarget(str6, str5, z, "0", 1, str4);
                if (z && (schemaProperty.hasDefault() == 2 || schemaProperty.hasFixed() == 2)) {
                    emit("if (target == null)");
                    startBlock();
                    makeAttributeDefaultValue(str4, schemaProperty, str5);
                    endBlock();
                }
                emit("return target;");
                emitImplementationPostamble();
                endBlock();
            }
            if (z2) {
                printJavaDoc((z4 ? "Tests for nil first " : "Tests for nil ") + str16);
                str7 = str15;
                emit("public boolean isNil" + str2 + str7);
                startBlock();
                emitImplementationPreamble();
                emitGetTarget(str6, str5, z, "0", 1, str4);
                emit("if (target == null) return false;");
                emit("return target.isNil();");
                emitImplementationPostamble();
                endBlock();
            } else {
                str7 = str15;
            }
        } else {
            str7 = "()";
            str8 = "public ";
            str9 = " get";
            str10 = str17;
            str11 = " xget";
        }
        if (z3) {
            printJavaDoc((z4 ? "True if has at least one " : "True if has ") + str16);
            emit("public boolean isSet" + str2 + str7);
            startBlock();
            emitImplementationPreamble();
            if (z) {
                emit("return get_store().find_attribute_user(" + str5 + ") != null;");
            } else {
                emit("return get_store().count_elements(" + str6 + ") != 0;");
            }
            emitImplementationPostamble();
            endBlock();
        } else {
            str11 = str11;
        }
        if (z4) {
            String str19 = str2 + SoapEncSchemaTypeSystem.SOAP_ARRAY;
            if (this._useJava15) {
                printListGetter15Impl(str, str16, str2, isJavaPrimitive(i) ? javaWrappedType(i) : str3, str4, z7, $assertionsDisabled);
            }
            if (this._useJava15) {
                emit("");
                emit("/**");
                emit(" * Gets array of all " + str16 + "s");
                emit(" * @deprecated");
                emit(" */");
                emit("@Deprecated");
            } else {
                printJavaDoc("Gets array of all " + str16 + "s");
            }
            String str20 = str8;
            emit(str20 + str3 + "[] get" + str19 + str7);
            startBlock();
            emitImplementationPreamble();
            if (this._useJava15) {
                emit("java.util.List<" + str4 + "> targetList = new java.util.ArrayList<" + str4 + ">();");
            } else {
                emit("java.util.List targetList = new java.util.ArrayList();");
            }
            emit("get_store().find_all_element_users(" + str6 + ", targetList);");
            printJGetArrayValue(i, str3, (SchemaTypeImpl) schemaProperty.getType());
            emitImplementationPostamble();
            endBlock();
            printJavaDoc("Gets ith " + str16);
            emit(str20 + str3 + str9 + str19 + "(int i)");
            startBlock();
            emitImplementationPreamble();
            emitGetTarget(str6, str5, z, "i", 4, str10);
            printJGetValue(i, str3, (SchemaTypeImpl) schemaProperty.getType());
            emitImplementationPostamble();
            endBlock();
            if (z7) {
                str12 = str6;
                str13 = str19;
                str14 = "(int i)";
            } else {
                if (this._useJava15) {
                    printListGetter15Impl(str, str16, str2, str4, str4, z7, true);
                }
                if (this._useJava15) {
                    emit("");
                    emit("/**");
                    emit(" * Gets array of all " + str16 + "s");
                    emit(" * @deprecated");
                    emit(" */");
                    emit("@Deprecated");
                } else {
                    printJavaDoc("Gets (as xml) array of all " + str16 + "s");
                }
                str13 = str19;
                emit(str20 + str4 + "[] xget" + str13 + str7);
                startBlock();
                emitImplementationPreamble();
                if (this._useJava15) {
                    emit("java.util.List<" + str4 + "> targetList = new java.util.ArrayList<" + str4 + ">();");
                } else {
                    emit("java.util.List targetList = new java.util.ArrayList();");
                }
                str12 = str6;
                emit("get_store().find_all_element_users(" + str12 + ", targetList);");
                emit(str4 + "[] result = new " + str4 + "[targetList.size()];");
                emit("targetList.toArray(result);");
                emit("return result;");
                emitImplementationPostamble();
                endBlock();
                printJavaDoc("Gets (as xml) ith " + str16);
                str14 = "(int i)";
                emit(str20 + str4 + str11 + str13 + str14);
                startBlock();
                emitImplementationPreamble();
                emitGetTarget(str6, str5, z, "i", 4, str4);
                emit("return target;");
                emitImplementationPostamble();
                endBlock();
            }
            if (z2) {
                printJavaDoc("Tests for nil ith " + str16);
                emit("public boolean isNil" + str13 + str14);
                startBlock();
                emitImplementationPreamble();
                emitGetTarget(str6, str5, z, "i", 4, str4);
                emit("return target.isNil();");
                emitImplementationPostamble();
                endBlock();
            }
            printJavaDoc("Returns number of " + str16);
            emit("public int sizeOf" + str13 + str7);
            startBlock();
            emitImplementationPreamble();
            emit("return get_store().count_elements(" + str12 + ");");
            emitImplementationPostamble();
            endBlock();
        }
    }

    void printSetterImpls(QName qName, SchemaProperty schemaProperty, boolean z, String str, int i, String str2, String str3, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str4, String str5, SchemaType schemaType) throws IOException {
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        SchemaType schemaType2;
        boolean z7;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        int i2;
        SchemaType schemaType3;
        String str22;
        String str23;
        String str24;
        boolean z8;
        SchemaType schemaType4;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        int i3;
        String str30;
        String str31;
        String str32;
        SchemaType schemaType5;
        String str33;
        String str34;
        String strNonExtraKeyword = NameUtil.nonExtraKeyword(NameUtil.nonJavaKeyword(NameUtil.lowerCamelCase(str)));
        boolean z9 = i == 0;
        boolean z10 = i == 19;
        boolean z11 = str4 != str5;
        String str35 = (z6 || !z9) ? "org.apache.xmlbeans.SimpleValue" : str3;
        String str36 = "\"" + qName.getLocalPart() + "\"" + (z ? " attribute" : " element");
        String str37 = "public void xset";
        String str38 = " ";
        if (z5) {
            printJavaDoc((z4 ? "Sets first " : "Sets the ") + str36);
            emit("public void set" + str + "(" + str2 + " " + strNonExtraKeyword + ")");
            startBlock();
            if (z9 && !z11 && !z) {
                str9 = str35;
                str7 = "public void set";
                str8 = str36;
                emitPre(schemaType, 1, str4, z, z4 ? "0" : "-1");
                emit("generatedSetterHelperImpl(" + strNonExtraKeyword + ", " + str5 + ", 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);");
                str12 = ");";
                emitPost(schemaType, 1, str4, z, z4 ? "0" : "-1");
                str10 = strNonExtraKeyword;
                i3 = i;
                str30 = "public ";
                str15 = "(";
            } else {
                str7 = "public void set";
                str8 = str36;
                str12 = ");";
                str9 = str35;
                emitImplementationPreamble();
                emitPre(schemaType, 1, str4, z, z4 ? "0" : "-1");
                str10 = strNonExtraKeyword;
                emitGetTarget(str5, str4, z, "0", 3, str9);
                i3 = i;
                printJSetValue(i3, str10, (SchemaTypeImpl) schemaProperty.getType());
                str30 = "public ";
                str15 = "(";
                emitPost(schemaType, 1, str4, z, z4 ? "0" : "-1");
                emitImplementationPostamble();
            }
            endBlock();
            if (z9) {
                str11 = r12;
                str31 = str3;
            } else {
                printJavaDoc((z4 ? "Sets (as xml) first " : "Sets (as xml) the ") + str8);
                emit("public void xset" + str + str15 + str3 + " " + str10 + ")");
                startBlock();
                emitImplementationPreamble();
                str11 = ", ";
                str31 = str3;
                emitPre(schemaType, 1, str4, z, z4 ? "0" : "-1");
                emitGetTarget(str5, str4, z, "0", 3, str3);
                emit("target.set(" + str10 + str12);
                emitPost(schemaType, 1, str4, z, z4 ? "0" : "-1");
                emitImplementationPostamble();
                endBlock();
            }
            if (!z9 || z4) {
                str32 = str4;
                schemaType5 = schemaType;
                str33 = str30;
                str34 = 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x02b6: MOVE (r5v36 'str34' java.lang.String) = (r23v3 java.lang.String) in method: org.apache.xmlbeans.impl.schema.SchemaTypeCodePrinter.printSetterImpls(javax.xml.namespace.QName, org.apache.xmlbeans.SchemaProperty, boolean, java.lang.String, int, java.lang.String, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.lang.String, java.lang.String, org.apache.xmlbeans.SchemaType):void, file: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                    	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                    	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r23v3 java.lang.String
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                    */
                /*
                    Method dump skipped, instruction units count: 3097
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.SchemaTypeCodePrinter.printSetterImpls(javax.xml.namespace.QName, org.apache.xmlbeans.SchemaProperty, boolean, java.lang.String, int, java.lang.String, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.lang.String, java.lang.String, org.apache.xmlbeans.SchemaType):void");
            }

            static void getTypeName(Class cls, StringBuffer stringBuffer) {
                int i = 0;
                while (cls.isArray()) {
                    cls = cls.getComponentType();
                    i++;
                }
                stringBuffer.append(cls.getName());
                for (int i2 = 0; i2 < i; i2++) {
                    stringBuffer.append("[]");
                }
            }

            void printInnerTypeImpl(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem, boolean z) throws IOException {
                SchemaProperty[] derivedProperties;
                Map map;
                SchemaTypeCodePrinter schemaTypeCodePrinter = this;
                String shortJavaImplName = schemaType.getShortJavaImplName();
                printInnerTypeJavaDoc(schemaType);
                schemaTypeCodePrinter.startClass(schemaType, z);
                schemaTypeCodePrinter.printConstructor(schemaType, shortJavaImplName);
                printExtensionImplMethods(schemaType);
                if (!schemaType.isSimpleType()) {
                    if (schemaType.getContentType() == 2) {
                        ArrayList arrayList = null;
                        for (SchemaType baseType = schemaType.getBaseType(); !baseType.isSimpleType() && !baseType.isBuiltinType(); baseType = baseType.getBaseType()) {
                            SchemaProperty[] derivedProperties2 = baseType.getDerivedProperties();
                            for (int i = 0; i < derivedProperties2.length; i++) {
                                if (!derivedProperties2[i].isAttribute() || schemaType.getAttributeProperty(derivedProperties2[i].getName()) == null) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(derivedProperties2[i]);
                                }
                            }
                        }
                        derivedProperties = schemaType.getProperties();
                        if (arrayList != null) {
                            for (SchemaProperty schemaProperty : derivedProperties) {
                                arrayList.add(schemaProperty);
                            }
                            derivedProperties = (SchemaProperty[]) arrayList.toArray(new SchemaProperty[arrayList.size()]);
                        }
                    } else {
                        derivedProperties = getDerivedProperties(schemaType);
                    }
                    SchemaProperty[] schemaPropertyArr = derivedProperties;
                    Map mapPrintStaticFields = schemaTypeCodePrinter.printStaticFields(schemaPropertyArr);
                    int i2 = 0;
                    while (i2 < schemaPropertyArr.length) {
                        SchemaProperty schemaProperty2 = schemaPropertyArr[i2];
                        QName name = schemaProperty2.getName();
                        String strXmlTypeForProperty = schemaTypeCodePrinter.xmlTypeForProperty(schemaProperty2);
                        int i3 = i2;
                        Map map2 = mapPrintStaticFields;
                        SchemaProperty[] schemaPropertyArr2 = schemaPropertyArr;
                        String str = shortJavaImplName;
                        printGetterImpls(shortJavaImplName, schemaProperty2, name, schemaProperty2.isAttribute(), schemaProperty2.getJavaPropertyName(), schemaProperty2.getJavaTypeCode(), schemaTypeCodePrinter.javaTypeForProperty(schemaProperty2), strXmlTypeForProperty, schemaProperty2.hasNillable() != 0, schemaProperty2.extendsJavaOption(), schemaProperty2.extendsJavaArray(), schemaProperty2.extendsJavaSingleton(), xmlTypeForPropertyIsUnion(schemaProperty2), schemaTypeCodePrinter.getIdentifier(mapPrintStaticFields, name), schemaTypeCodePrinter.getSetIdentifier(mapPrintStaticFields, name));
                        if (schemaProperty2.isReadOnly()) {
                            map = map2;
                        } else {
                            map = map2;
                            printSetterImpls(name, schemaProperty2, schemaProperty2.isAttribute(), schemaProperty2.getJavaPropertyName(), schemaProperty2.getJavaTypeCode(), javaTypeForProperty(schemaProperty2), strXmlTypeForProperty, schemaProperty2.hasNillable() != 0, schemaProperty2.extendsJavaOption(), schemaProperty2.extendsJavaArray(), schemaProperty2.extendsJavaSingleton(), xmlTypeForPropertyIsUnion(schemaProperty2), getIdentifier(map2, name), getSetIdentifier(map2, name), schemaType);
                        }
                        i2 = i3 + 1;
                        schemaTypeCodePrinter = this;
                        mapPrintStaticFields = map;
                        schemaPropertyArr = schemaPropertyArr2;
                        shortJavaImplName = str;
                    }
                }
                printNestedTypeImpls(schemaType, schemaTypeSystem);
                endBlock();
            }

            private SchemaProperty[] getDerivedProperties(SchemaType schemaType) {
                QName name = schemaType.getName();
                if (name != null && name.equals(schemaType.getBaseType().getName())) {
                    SchemaProperty[] derivedProperties = schemaType.getDerivedProperties();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (int i = 0; i < derivedProperties.length; i++) {
                        linkedHashMap.put(derivedProperties[i].getName(), derivedProperties[i]);
                    }
                    for (SchemaType baseType = schemaType.getBaseType(); baseType != null && name.equals(baseType.getName()); baseType = baseType.getBaseType()) {
                        SchemaProperty[] derivedProperties2 = baseType.getDerivedProperties();
                        for (int i2 = 0; i2 < derivedProperties2.length; i2++) {
                            if (!linkedHashMap.containsKey(derivedProperties2[i2].getName())) {
                                linkedHashMap.put(derivedProperties2[i2].getName(), derivedProperties2[i2]);
                            }
                        }
                    }
                    return (SchemaProperty[]) linkedHashMap.values().toArray(new SchemaProperty[0]);
                }
                return schemaType.getDerivedProperties();
            }

            private void printExtensionImplMethods(SchemaType schemaType) throws IOException {
                InterfaceExtension[] interfaceExtensions;
                SchemaTypeImpl impl = getImpl(schemaType);
                if (impl == null || (interfaceExtensions = impl.getInterfaceExtensions()) == null) {
                    return;
                }
                for (int i = 0; i < interfaceExtensions.length; i++) {
                    InterfaceExtension.MethodSignature[] methods = interfaceExtensions[i].getMethods();
                    if (methods != null) {
                        for (int i2 = 0; i2 < methods.length; i2++) {
                            printJavaDoc("Implementation method for interface " + interfaceExtensions[i].getStaticHandler());
                            printInterfaceMethodDecl(methods[i2]);
                            startBlock();
                            printInterfaceMethodImpl(interfaceExtensions[i].getStaticHandler(), methods[i2]);
                            endBlock();
                        }
                    }
                }
            }

            void printInterfaceMethodDecl(InterfaceExtension.MethodSignature methodSignature) throws IOException {
                StringBuffer stringBuffer = new StringBuffer(60);
                stringBuffer.append("public ").append(methodSignature.getReturnType());
                stringBuffer.append(" ").append(methodSignature.getName()).append("(");
                String[] parameterTypes = methodSignature.getParameterTypes();
                int i = 0;
                for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                    if (i2 != 0) {
                        stringBuffer.append(", ");
                    }
                    stringBuffer.append(parameterTypes[i2]).append(" p").append(i2);
                }
                stringBuffer.append(")");
                String[] exceptionTypes = methodSignature.getExceptionTypes();
                while (i < exceptionTypes.length) {
                    stringBuffer.append((i == 0 ? " throws " : ", ") + exceptionTypes[i]);
                    i++;
                }
                emit(stringBuffer.toString());
            }

            void printInterfaceMethodImpl(String str, InterfaceExtension.MethodSignature methodSignature) throws IOException {
                StringBuffer stringBuffer = new StringBuffer(60);
                if (!methodSignature.getReturnType().equals("void")) {
                    stringBuffer.append("return ");
                }
                stringBuffer.append(str).append(".").append(methodSignature.getName()).append("(this");
                String[] parameterTypes = methodSignature.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    stringBuffer.append(", p" + i);
                }
                stringBuffer.append(");");
                emit(stringBuffer.toString());
            }

            void printNestedTypeImpls(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem) throws IOException {
                boolean z = schemaType.getName() != null && schemaType.getName().equals(schemaType.getBaseType().getName());
                while (schemaType != null) {
                    SchemaType[] anonymousTypes = schemaType.getAnonymousTypes();
                    for (int i = 0; i < anonymousTypes.length; i++) {
                        if (anonymousTypes[i].isSkippedAnonymousType()) {
                            printNestedTypeImpls(anonymousTypes[i], schemaTypeSystem);
                        } else {
                            printInnerTypeImpl(anonymousTypes[i], schemaTypeSystem, true);
                        }
                    }
                    if (!z) {
                        return;
                    }
                    if (schemaType.getDerivationType() != 2 && !schemaType.isSimpleType()) {
                        return;
                    } else {
                        schemaType = schemaType.getBaseType();
                    }
                }
            }
        }
