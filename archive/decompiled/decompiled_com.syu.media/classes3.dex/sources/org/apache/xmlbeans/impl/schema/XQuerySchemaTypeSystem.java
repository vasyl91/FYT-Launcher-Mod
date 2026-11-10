package org.apache.xmlbeans.impl.schema;

import java.io.File;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.Filer;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.regex.ParseException;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.regex.SchemaRegularExpression;
import org.apache.xmlbeans.impl.values.XmlIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlStringImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XQuerySchemaTypeSystem extends SchemaTypeLoaderBase implements SchemaTypeSystem {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BTC_ANY_ATOMIC = 52;
    public static final int BTC_DAY_TIME_DURATION = 53;
    public static final int BTC_FIRST_XQUERY = 52;
    public static final int BTC_LAST_XQUERY = 54;
    public static final int BTC_YEAR_MONTH_DURATION = 54;
    private static final XmlValueRef[] FACETS_BUILTIN_LIST;
    private static final XmlValueRef[] FACETS_BYTE;
    private static final XmlValueRef[] FACETS_INT;
    private static final XmlValueRef[] FACETS_INTEGER;
    static final XmlValueRef[] FACETS_LIST;
    private static final XmlValueRef[] FACETS_LONG;
    private static final XmlValueRef[] FACETS_NEGATIVE;
    private static final XmlValueRef[] FACETS_NONE;
    private static final XmlValueRef[] FACETS_NONNEGATIVE;
    private static final XmlValueRef[] FACETS_NONPOSITIVE;
    private static final XmlValueRef[] FACETS_POSITIVE;
    private static final XmlValueRef[] FACETS_SHORT;
    static final XmlValueRef[] FACETS_UNION;
    private static final XmlValueRef[] FACETS_UNSIGNED_BYTE;
    private static final XmlValueRef[] FACETS_UNSIGNED_INT;
    private static final XmlValueRef[] FACETS_UNSIGNED_LONG;
    private static final XmlValueRef[] FACETS_UNSIGNED_SHORT;
    private static final XmlValueRef[] FACETS_WS_COLLAPSE;
    private static final XmlValueRef[] FACETS_WS_PRESERVE;
    private static final XmlValueRef[] FACETS_WS_REPLACE;
    private static final boolean[] FIXED_FACETS_INTEGER;
    static final boolean[] FIXED_FACETS_LIST;
    private static final boolean[] FIXED_FACETS_NONE;
    static final boolean[] FIXED_FACETS_UNION;
    private static final boolean[] FIXED_FACETS_WS;
    public static final SchemaTypeImpl ST_ANY_ATOMIC;
    public static final SchemaTypeImpl ST_ANY_SIMPLE;
    public static final SchemaTypeImpl ST_ANY_TYPE;
    public static final SchemaTypeImpl ST_ANY_URI;
    public static final SchemaTypeImpl ST_BASE_64_BINARY;
    public static final SchemaTypeImpl ST_BOOLEAN;
    public static final SchemaTypeImpl ST_BYTE;
    public static final SchemaTypeImpl ST_DATE;
    public static final SchemaTypeImpl ST_DATE_TIME;
    public static final SchemaTypeImpl ST_DAY_TIME_DURATION;
    public static final SchemaTypeImpl ST_DECIMAL;
    public static final SchemaTypeImpl ST_DOUBLE;
    public static final SchemaTypeImpl ST_DURATION;
    public static final SchemaTypeImpl ST_ENTITIES;
    public static final SchemaTypeImpl ST_ENTITY;
    public static final SchemaTypeImpl ST_FLOAT;
    public static final SchemaTypeImpl ST_G_DAY;
    public static final SchemaTypeImpl ST_G_MONTH;
    public static final SchemaTypeImpl ST_G_MONTH_DAY;
    public static final SchemaTypeImpl ST_G_YEAR;
    public static final SchemaTypeImpl ST_G_YEAR_MONTH;
    public static final SchemaTypeImpl ST_HEX_BINARY;
    public static final SchemaTypeImpl ST_ID;
    public static final SchemaTypeImpl ST_IDREF;
    public static final SchemaTypeImpl ST_IDREFS;
    public static final SchemaTypeImpl ST_INT;
    public static final SchemaTypeImpl ST_INTEGER;
    public static final SchemaTypeImpl ST_LANGUAGE;
    public static final SchemaTypeImpl ST_LONG;
    public static final SchemaTypeImpl ST_NAME;
    public static final SchemaTypeImpl ST_NCNAME;
    public static final SchemaTypeImpl ST_NEGATIVE_INTEGER;
    public static final SchemaTypeImpl ST_NMTOKEN;
    public static final SchemaTypeImpl ST_NMTOKENS;
    public static final SchemaTypeImpl ST_NON_NEGATIVE_INTEGER;
    public static final SchemaTypeImpl ST_NON_POSITIVE_INTEGER;
    public static final SchemaTypeImpl ST_NORMALIZED_STRING;
    public static final SchemaTypeImpl ST_NOTATION;
    public static final SchemaTypeImpl ST_NO_TYPE;
    public static final SchemaTypeImpl ST_POSITIVE_INTEGER;
    public static final SchemaTypeImpl ST_QNAME;
    public static final SchemaTypeImpl ST_SHORT;
    public static final SchemaTypeImpl ST_STRING;
    public static final SchemaTypeImpl ST_TIME;
    public static final SchemaTypeImpl ST_TOKEN;
    public static final SchemaTypeImpl ST_UNSIGNED_BYTE;
    public static final SchemaTypeImpl ST_UNSIGNED_INT;
    public static final SchemaTypeImpl ST_UNSIGNED_LONG;
    public static final SchemaTypeImpl ST_UNSIGNED_SHORT;
    public static final SchemaTypeImpl ST_YEAR_MONTH_DURATION;
    private static final XmlValueRef XMLSTR_COLLAPSE;
    private static final XmlValueRef XMLSTR_PRESERVE;
    private static final XmlValueRef XMLSTR_REPLACE;
    private static XQuerySchemaTypeSystem _global;
    private SchemaContainer _container;
    private static final SchemaType[] EMPTY_SCHEMATYPE_ARRAY = new SchemaType[0];
    private static final SchemaType.Ref[] EMPTY_SCHEMATYPEREF_ARRAY = new SchemaType.Ref[0];
    private static final SchemaGlobalElement[] EMPTY_SCHEMAELEMENT_ARRAY = new SchemaGlobalElement[0];
    private static final SchemaGlobalAttribute[] EMPTY_SCHEMAATTRIBUTE_ARRAY = new SchemaGlobalAttribute[0];
    private static final SchemaModelGroup[] EMPTY_SCHEMAMODELGROUP_ARRAY = new SchemaModelGroup[0];
    private static final SchemaAttributeGroup[] EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY = new SchemaAttributeGroup[0];
    private static final SchemaAnnotation[] EMPTY_SCHEMAANNOTATION_ARRAY = new SchemaAnnotation[0];
    private Map _typeMap = new HashMap();
    private SchemaTypeImpl[] _typeArray = new SchemaTypeImpl[50];
    private Map _handlesToObjects = new HashMap();
    private Map _objectsToHandles = new HashMap();
    private Map _typesByClassname = new HashMap();

    private int arrayIndexForBtc(int i) {
        return i > 46 ? (i - 52) + 46 + 1 : i;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase
    public SchemaGlobalAttribute findAttribute(QName qName) {
        return null;
    }

    public SchemaAttributeGroup.Ref findAttributeGroupRef(QName qName) {
        return null;
    }

    public SchemaGlobalAttribute.Ref findAttributeRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase
    public SchemaType findAttributeType(QName qName) {
        return null;
    }

    public SchemaType.Ref findAttributeTypeRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase
    public SchemaType findDocumentType(QName qName) {
        return null;
    }

    public SchemaType.Ref findDocumentTypeRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase
    public SchemaGlobalElement findElement(QName qName) {
        return null;
    }

    public SchemaGlobalElement.Ref findElementRef(QName qName) {
        return null;
    }

    public SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName qName) {
        return null;
    }

    public SchemaModelGroup.Ref findModelGroupRef(QName qName) {
        return null;
    }

    public String getName() {
        return "xquery.typesystem.builtin";
    }

    public InputStream getSourceAsStream(String str) {
        return null;
    }

    public void resolve() {
    }

    public static SchemaTypeSystem get() {
        return _global;
    }

    static {
        XQuerySchemaTypeSystem xQuerySchemaTypeSystem = new XQuerySchemaTypeSystem();
        _global = xQuerySchemaTypeSystem;
        ST_ANY_TYPE = xQuerySchemaTypeSystem.getBuiltinType(1);
        ST_ANY_SIMPLE = _global.getBuiltinType(2);
        ST_ANY_ATOMIC = _global.getBuiltinType(52);
        ST_BOOLEAN = _global.getBuiltinType(3);
        ST_BASE_64_BINARY = _global.getBuiltinType(4);
        ST_HEX_BINARY = _global.getBuiltinType(5);
        ST_ANY_URI = _global.getBuiltinType(6);
        ST_QNAME = _global.getBuiltinType(7);
        ST_NOTATION = _global.getBuiltinType(8);
        ST_FLOAT = _global.getBuiltinType(9);
        ST_DOUBLE = _global.getBuiltinType(10);
        ST_DECIMAL = _global.getBuiltinType(11);
        ST_STRING = _global.getBuiltinType(12);
        ST_DURATION = _global.getBuiltinType(13);
        ST_DATE_TIME = _global.getBuiltinType(14);
        ST_TIME = _global.getBuiltinType(15);
        ST_DATE = _global.getBuiltinType(16);
        ST_G_YEAR_MONTH = _global.getBuiltinType(17);
        ST_G_YEAR = _global.getBuiltinType(18);
        ST_G_MONTH_DAY = _global.getBuiltinType(19);
        ST_G_DAY = _global.getBuiltinType(20);
        ST_G_MONTH = _global.getBuiltinType(21);
        ST_INTEGER = _global.getBuiltinType(22);
        ST_LONG = _global.getBuiltinType(23);
        ST_INT = _global.getBuiltinType(24);
        ST_SHORT = _global.getBuiltinType(25);
        ST_BYTE = _global.getBuiltinType(26);
        ST_NON_POSITIVE_INTEGER = _global.getBuiltinType(27);
        ST_NEGATIVE_INTEGER = _global.getBuiltinType(28);
        ST_NON_NEGATIVE_INTEGER = _global.getBuiltinType(29);
        ST_POSITIVE_INTEGER = _global.getBuiltinType(30);
        ST_UNSIGNED_LONG = _global.getBuiltinType(31);
        ST_UNSIGNED_INT = _global.getBuiltinType(32);
        ST_UNSIGNED_SHORT = _global.getBuiltinType(33);
        ST_UNSIGNED_BYTE = _global.getBuiltinType(34);
        ST_NORMALIZED_STRING = _global.getBuiltinType(35);
        ST_TOKEN = _global.getBuiltinType(36);
        ST_NAME = _global.getBuiltinType(37);
        ST_NCNAME = _global.getBuiltinType(38);
        ST_LANGUAGE = _global.getBuiltinType(39);
        ST_ID = _global.getBuiltinType(40);
        ST_IDREF = _global.getBuiltinType(41);
        ST_IDREFS = _global.getBuiltinType(42);
        ST_ENTITY = _global.getBuiltinType(43);
        ST_ENTITIES = _global.getBuiltinType(44);
        ST_NMTOKEN = _global.getBuiltinType(45);
        ST_NMTOKENS = _global.getBuiltinType(46);
        ST_DAY_TIME_DURATION = _global.getBuiltinType(53);
        ST_YEAR_MONTH_DURATION = _global.getBuiltinType(54);
        ST_NO_TYPE = _global.getBuiltinType(0);
        XMLSTR_PRESERVE = buildString("preserve");
        XMLSTR_REPLACE = buildString("preserve");
        XMLSTR_COLLAPSE = buildString("preserve");
        XmlValueRef[] xmlValueRefArr = {null, null, null, null, null, null, null, null, null, null, null, null};
        FACETS_NONE = xmlValueRefArr;
        boolean[] zArr = {$assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled};
        FIXED_FACETS_NONE = zArr;
        XmlValueRef[] xmlValueRefArr2 = {null, null, null, null, null, null, null, null, null, build_wsstring(3), null, null};
        FACETS_WS_COLLAPSE = xmlValueRefArr2;
        FACETS_WS_REPLACE = new XmlValueRef[]{null, null, null, null, null, null, null, null, null, build_wsstring(2), null, null};
        FACETS_WS_PRESERVE = new XmlValueRef[]{null, null, null, null, null, null, null, null, null, build_wsstring(1), null, null};
        FACETS_INTEGER = new XmlValueRef[]{null, null, null, null, null, null, null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_LONG = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.valueOf(Long.MIN_VALUE)), buildInteger(BigInteger.valueOf(Long.MAX_VALUE)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_INT = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.valueOf(-2147483648L)), buildInteger(BigInteger.valueOf(2147483647L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_SHORT = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.valueOf(-32768L)), buildInteger(BigInteger.valueOf(32767L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_BYTE = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.valueOf(-128L)), buildInteger(BigInteger.valueOf(127L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_NONNEGATIVE = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.ZERO), null, null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_POSITIVE = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.ONE), null, null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_NONPOSITIVE = new XmlValueRef[]{null, null, null, null, null, buildInteger(BigInteger.ZERO), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_NEGATIVE = new XmlValueRef[]{null, null, null, null, null, buildInteger(BigInteger.ONE.negate()), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_UNSIGNED_LONG = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(new BigInteger("18446744073709551615")), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_UNSIGNED_INT = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(BigInteger.valueOf(4294967295L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_UNSIGNED_SHORT = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(BigInteger.valueOf(65535L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_UNSIGNED_BYTE = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(BigInteger.valueOf(255L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_BUILTIN_LIST = new XmlValueRef[]{null, buildNnInteger(BigInteger.ONE), null, null, null, null, null, null, null, build_wsstring(3), null, null};
        boolean[] zArr2 = {$assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, true, $assertionsDisabled, $assertionsDisabled};
        FIXED_FACETS_WS = zArr2;
        FIXED_FACETS_INTEGER = new boolean[]{$assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, true, true, $assertionsDisabled, $assertionsDisabled};
        FACETS_UNION = xmlValueRefArr;
        FIXED_FACETS_UNION = zArr;
        FACETS_LIST = xmlValueRefArr2;
        FIXED_FACETS_LIST = zArr2;
        for (int i = 0; i <= 46; i++) {
            _global.fillInType(i);
        }
        for (int i2 = 52; i2 <= 54; i2++) {
            _global.fillInType(i2);
        }
    }

    private SchemaTypeImpl getBuiltinType(int i) {
        return this._typeArray[arrayIndexForBtc(i)];
    }

    private XQuerySchemaTypeSystem() {
        SchemaContainer schemaContainer = new SchemaContainer(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA);
        this._container = schemaContainer;
        schemaContainer.setTypeSystem(this);
        setupType(1, "anyType", "org.apache.xmlbeans.XmlObject");
        setupType(2, "anySimpleType", "org.apache.xmlbeans.XmlAnySimpleType");
        setupType(52, "anyAtomicType", null);
        setupType(3, "boolean", "org.apache.xmlbeans.XmlBoolean");
        setupType(4, "base64Binary", "org.apache.xmlbeans.XmlBase64Binary");
        setupType(5, "hexBinary", "org.apache.xmlbeans.XmlHexBinary");
        setupType(6, "anyURI", "org.apache.xmlbeans.XmlAnyURI");
        setupType(7, "QName", "org.apache.xmlbeans.XmlQName");
        setupType(8, "NOTATION", "org.apache.xmlbeans.XmlNOTATION");
        setupType(9, "float", "org.apache.xmlbeans.XmlFloat");
        setupType(10, "double", "org.apache.xmlbeans.XmlDouble");
        setupType(11, "decimal", "org.apache.xmlbeans.XmlDecimal");
        setupType(12, "string", "org.apache.xmlbeans.XmlString");
        setupType(13, "duration", "org.apache.xmlbeans.XmlDuration");
        setupType(14, "dateTime", "org.apache.xmlbeans.XmlDateTime");
        setupType(15, "time", "org.apache.xmlbeans.XmlTime");
        setupType(16, "date", "org.apache.xmlbeans.XmlDate");
        setupType(17, "gYearMonth", "org.apache.xmlbeans.XmlGYearMonth");
        setupType(18, "gYear", "org.apache.xmlbeans.XmlGYear");
        setupType(19, "gMonthDay", "org.apache.xmlbeans.XmlGMonthDay");
        setupType(20, "gDay", "org.apache.xmlbeans.XmlGDay");
        setupType(21, "gMonth", "org.apache.xmlbeans.XmlGMonth");
        setupType(22, "integer", "org.apache.xmlbeans.XmlInteger");
        setupType(23, "long", "org.apache.xmlbeans.XmlLong");
        setupType(24, "int", "org.apache.xmlbeans.XmlInt");
        setupType(25, "short", "org.apache.xmlbeans.XmlShort");
        setupType(26, "byte", "org.apache.xmlbeans.XmlByte");
        setupType(27, "nonPositiveInteger", "org.apache.xmlbeans.XmlNonPositiveInteger");
        setupType(28, "negativeInteger", "org.apache.xmlbeans.XmlNegativeInteger");
        setupType(29, "nonNegativeInteger", "org.apache.xmlbeans.XmlNonNegativeInteger");
        setupType(30, "positiveInteger", "org.apache.xmlbeans.XmlPositiveInteger");
        setupType(31, "unsignedLong", "org.apache.xmlbeans.XmlUnsignedLong");
        setupType(32, "unsignedInt", "org.apache.xmlbeans.XmlUnsignedInt");
        setupType(33, "unsignedShort", "org.apache.xmlbeans.XmlUnsignedShort");
        setupType(34, "unsignedByte", "org.apache.xmlbeans.XmlUnsignedByte");
        setupType(35, "normalizedString", "org.apache.xmlbeans.XmlNormalizedString");
        setupType(36, "token", "org.apache.xmlbeans.XmlToken");
        setupType(37, "Name", "org.apache.xmlbeans.XmlName");
        setupType(38, "NCName", "org.apache.xmlbeans.XmlNCName");
        setupType(39, "language", "org.apache.xmlbeans.XmlLanguage");
        setupType(40, "ID", "org.apache.xmlbeans.XmlID");
        setupType(41, "IDREF", "org.apache.xmlbeans.XmlIDREF");
        setupType(42, "IDREFS", "org.apache.xmlbeans.XmlIDREFS");
        setupType(43, "ENTITY", "org.apache.xmlbeans.XmlENTITY");
        setupType(44, "ENTITIES", "org.apache.xmlbeans.XmlENTITIES");
        setupType(45, "NMTOKEN", "org.apache.xmlbeans.XmlNMTOKEN");
        setupType(46, "NMTOKENS", "org.apache.xmlbeans.XmlNMTOKENS");
        setupType(53, "dayTimeDuration", null);
        setupType(54, "yearMonthDuration", null);
        setupType(0, null, null);
        this._container.setImmutable();
    }

    public boolean isNamespaceDefined(String str) {
        return str.equals(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA);
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase
    public SchemaType findType(QName qName) {
        return (SchemaType) this._typeMap.get(qName);
    }

    public SchemaType.Ref findTypeRef(QName qName) {
        SchemaType schemaTypeFindType = findType(qName);
        if (schemaTypeFindType == null) {
            return null;
        }
        return schemaTypeFindType.getRef();
    }

    public SchemaType typeForClassname(String str) {
        return (SchemaType) this._typesByClassname.get(str);
    }

    public SchemaType[] globalTypes() {
        SchemaTypeImpl[] schemaTypeImplArr = this._typeArray;
        int length = schemaTypeImplArr.length - 1;
        SchemaType[] schemaTypeArr = new SchemaType[length];
        System.arraycopy(schemaTypeImplArr, 1, schemaTypeArr, 0, length);
        return schemaTypeArr;
    }

    public SchemaType[] documentTypes() {
        return EMPTY_SCHEMATYPE_ARRAY;
    }

    public SchemaType[] attributeTypes() {
        return EMPTY_SCHEMATYPE_ARRAY;
    }

    public SchemaGlobalElement[] globalElements() {
        return EMPTY_SCHEMAELEMENT_ARRAY;
    }

    public SchemaGlobalAttribute[] globalAttributes() {
        return EMPTY_SCHEMAATTRIBUTE_ARRAY;
    }

    public SchemaModelGroup[] modelGroups() {
        return EMPTY_SCHEMAMODELGROUP_ARRAY;
    }

    public SchemaAttributeGroup[] attributeGroups() {
        return EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY;
    }

    public SchemaAnnotation[] annotations() {
        return EMPTY_SCHEMAANNOTATION_ARRAY;
    }

    public String handleForType(SchemaType schemaType) {
        return (String) this._objectsToHandles.get(schemaType);
    }

    public ClassLoader getClassLoader() {
        return BuiltinSchemaTypeSystem.class.getClassLoader();
    }

    public void saveToDirectory(File file) {
        throw new UnsupportedOperationException("The builtin schema type system cannot be saved.");
    }

    public void save(Filer filer) {
        throw new UnsupportedOperationException("The builtin schema type system cannot be saved.");
    }

    private static XmlValueRef build_wsstring(int i) {
        if (i == 1) {
            return XMLSTR_PRESERVE;
        }
        if (i == 2) {
            return XMLSTR_REPLACE;
        }
        if (i != 3) {
            return null;
        }
        return XMLSTR_COLLAPSE;
    }

    private static XmlValueRef buildNnInteger(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0) {
            return null;
        }
        try {
            XmlIntegerImpl xmlIntegerImpl = new XmlIntegerImpl();
            xmlIntegerImpl.setBigIntegerValue(bigInteger);
            xmlIntegerImpl.setImmutable();
            return new XmlValueRef(xmlIntegerImpl);
        } catch (XmlValueOutOfRangeException unused) {
            return null;
        }
    }

    private static XmlValueRef buildInteger(BigInteger bigInteger) {
        if (bigInteger == null) {
            return null;
        }
        try {
            XmlIntegerImpl xmlIntegerImpl = new XmlIntegerImpl();
            xmlIntegerImpl.setBigIntegerValue(bigInteger);
            xmlIntegerImpl.setImmutable();
            return new XmlValueRef(xmlIntegerImpl);
        } catch (XmlValueOutOfRangeException unused) {
            return null;
        }
    }

    private static XmlValueRef buildString(String str) {
        if (str == null) {
            return null;
        }
        try {
            XmlStringImpl xmlStringImpl = new XmlStringImpl();
            xmlStringImpl.setStringValue(str);
            xmlStringImpl.setImmutable();
            return new XmlValueRef(xmlStringImpl);
        } catch (XmlValueOutOfRangeException unused) {
            return null;
        }
    }

    private void setupType(int i, String str, String str2) {
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(this._container, true);
        this._container.addGlobalType(schemaTypeImpl.getRef());
        QName qNameForLNS = str == null ? null : QNameHelper.forLNS(str, XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA);
        StringBuilder sb = new StringBuilder("_BI_");
        if (str == null) {
            str = "NO_TYPE";
        }
        String string = sb.append(str).toString();
        schemaTypeImpl.setName(qNameForLNS);
        schemaTypeImpl.setBuiltinTypeCode(i);
        if (str2 != null) {
            schemaTypeImpl.setFullJavaName(str2);
        }
        this._typeArray[arrayIndexForBtc(i)] = schemaTypeImpl;
        this._typeMap.put(qNameForLNS, schemaTypeImpl);
        this._handlesToObjects.put(string, schemaTypeImpl);
        this._objectsToHandles.put(schemaTypeImpl, string);
        if (str2 != null) {
            this._typesByClassname.put(str2, schemaTypeImpl);
        }
    }

    public SchemaType typeForHandle(String str) {
        return (SchemaType) this._handlesToObjects.get(str);
    }

    public SchemaComponent resolveHandle(String str) {
        return (SchemaComponent) this._handlesToObjects.get(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:105:0x018b  */
    /* JADX WARN: Code duplicated, block: B:108:0x019a  */
    /* JADX WARN: Code duplicated, block: B:127:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:99:0x017b  */
    /* JADX WARN: Failed to find 'out' block for switch in B:72:0x0100. Please report as an issue. */
    public void fillInType(int i) {
        SchemaTypeImpl schemaTypeImpl;
        SchemaTypeImpl schemaTypeImpl2;
        int i2;
        XmlValueRef[] xmlValueRefArr;
        boolean[] zArr;
        boolean[] zArr2;
        XmlValueRef[] xmlValueRefArr2;
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        boolean z4;
        RegularExpression regularExpressionForPattern;
        SchemaTypeImpl builtinType = getBuiltinType(i);
        int i4 = 3;
        switch (i) {
            case 0:
                schemaTypeImpl = ST_ANY_TYPE;
                schemaTypeImpl2 = null;
                i2 = 0;
                break;
            case 1:
                schemaTypeImpl = null;
                schemaTypeImpl2 = null;
                i2 = 0;
                break;
            case 2:
                schemaTypeImpl = ST_ANY_TYPE;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
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
                schemaTypeImpl = ST_ANY_ATOMIC;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 22:
                schemaTypeImpl = ST_DECIMAL;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 23:
                schemaTypeImpl = ST_INTEGER;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 24:
                schemaTypeImpl = ST_LONG;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 25:
                schemaTypeImpl = ST_INT;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 26:
                schemaTypeImpl = ST_SHORT;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 27:
                schemaTypeImpl = ST_INTEGER;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 28:
                schemaTypeImpl = ST_NON_POSITIVE_INTEGER;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 29:
                schemaTypeImpl = ST_INTEGER;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 30:
                schemaTypeImpl = ST_NON_NEGATIVE_INTEGER;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 31:
                schemaTypeImpl = ST_NON_NEGATIVE_INTEGER;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 32:
                schemaTypeImpl = ST_UNSIGNED_LONG;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 33:
                schemaTypeImpl = ST_UNSIGNED_INT;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 34:
                schemaTypeImpl = ST_UNSIGNED_SHORT;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 35:
                schemaTypeImpl = ST_STRING;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 36:
                schemaTypeImpl = ST_NORMALIZED_STRING;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 37:
                schemaTypeImpl = ST_TOKEN;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 38:
                schemaTypeImpl = ST_NAME;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 39:
            case 45:
                schemaTypeImpl = ST_TOKEN;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 40:
            case 41:
            case 43:
                schemaTypeImpl = ST_NCNAME;
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
            case 42:
            case 44:
            case 46:
                schemaTypeImpl = ST_ANY_SIMPLE;
                if (i == 42) {
                    schemaTypeImpl2 = ST_IDREF;
                } else if (i == 44) {
                    schemaTypeImpl2 = ST_ENTITY;
                } else {
                    schemaTypeImpl2 = ST_NMTOKEN;
                }
                i2 = 3;
                break;
            default:
                switch (i) {
                    case 52:
                        schemaTypeImpl = ST_ANY_ATOMIC;
                        break;
                    case 53:
                    case 54:
                        schemaTypeImpl = ST_DURATION;
                        break;
                    default:
                        schemaTypeImpl = ST_ANY_TYPE;
                        break;
                }
                schemaTypeImpl2 = null;
                i2 = 1;
                break;
        }
        builtinType.setDerivationType(1);
        builtinType.setSimpleTypeVariety(i2);
        if (i2 != 0) {
            builtinType.setSimpleType(true);
        }
        builtinType.setBaseTypeRef(schemaTypeImpl == null ? null : schemaTypeImpl.getRef());
        builtinType.setBaseDepth(schemaTypeImpl == null ? 0 : schemaTypeImpl.getBaseDepth() + 1);
        builtinType.setListItemTypeRef(schemaTypeImpl2 == null ? null : schemaTypeImpl2.getRef());
        if ((i >= 2 && i <= 21) || i == 52) {
            builtinType.setPrimitiveTypeRef(builtinType.getRef());
        } else if (i2 == 1) {
            if (schemaTypeImpl == null) {
                throw new IllegalStateException("Base was null for " + i);
            }
            if (schemaTypeImpl.getPrimitiveType() == null) {
                throw new IllegalStateException("Base.gpt was null for " + i);
            }
            builtinType.setPrimitiveTypeRef(schemaTypeImpl.getPrimitiveType().getRef());
        }
        int i5 = 64;
        int i6 = 1000000;
        switch (i) {
            case 0:
            case 1:
            case 2:
                xmlValueRefArr = FACETS_NONE;
                zArr = FIXED_FACETS_NONE;
                i4 = 0;
                i6 = 0;
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                xmlValueRefArr = FACETS_WS_COLLAPSE;
                zArr = FIXED_FACETS_WS;
                i6 = 0;
                break;
            case 11:
                xmlValueRefArr = FACETS_WS_COLLAPSE;
                zArr = FIXED_FACETS_WS;
                i5 = 1000001;
                i6 = i5;
                break;
            case 12:
                xmlValueRefArr = FACETS_WS_PRESERVE;
                zArr = FIXED_FACETS_NONE;
                i6 = 0;
                i4 = 1;
                break;
            case 22:
                xmlValueRefArr = FACETS_INTEGER;
                zArr = FIXED_FACETS_INTEGER;
                break;
            case 23:
                xmlValueRefArr = FACETS_LONG;
                zArr = FIXED_FACETS_INTEGER;
                i6 = i5;
                break;
            case 24:
                xmlValueRefArr = FACETS_INT;
                zArr2 = FIXED_FACETS_INTEGER;
                i6 = 32;
                zArr = zArr2;
                break;
            case 25:
                xmlValueRefArr2 = FACETS_SHORT;
                zArr2 = FIXED_FACETS_INTEGER;
                i6 = 16;
                xmlValueRefArr = xmlValueRefArr2;
                zArr = zArr2;
                break;
            case 26:
                xmlValueRefArr = FACETS_BYTE;
                zArr = FIXED_FACETS_INTEGER;
                i5 = 8;
                i6 = i5;
                break;
            case 27:
                xmlValueRefArr = FACETS_NONPOSITIVE;
                zArr = FIXED_FACETS_INTEGER;
                break;
            case 28:
                xmlValueRefArr = FACETS_NEGATIVE;
                zArr = FIXED_FACETS_INTEGER;
                break;
            case 29:
                xmlValueRefArr = FACETS_NONNEGATIVE;
                zArr = FIXED_FACETS_INTEGER;
                break;
            case 30:
                xmlValueRefArr = FACETS_POSITIVE;
                zArr = FIXED_FACETS_INTEGER;
                break;
            case 31:
                xmlValueRefArr = FACETS_UNSIGNED_LONG;
                zArr = FIXED_FACETS_INTEGER;
                break;
            case 32:
                xmlValueRefArr = FACETS_UNSIGNED_INT;
                zArr = FIXED_FACETS_INTEGER;
                i6 = i5;
                break;
            case 33:
                xmlValueRefArr = FACETS_UNSIGNED_SHORT;
                zArr2 = FIXED_FACETS_INTEGER;
                i6 = 32;
                zArr = zArr2;
                break;
            case 34:
                xmlValueRefArr2 = FACETS_UNSIGNED_BYTE;
                zArr2 = FIXED_FACETS_INTEGER;
                i6 = 16;
                xmlValueRefArr = xmlValueRefArr2;
                zArr = zArr2;
                break;
            case 35:
                xmlValueRefArr = FACETS_WS_REPLACE;
                zArr = FIXED_FACETS_NONE;
                i4 = 2;
                i6 = 0;
                break;
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 45:
                xmlValueRefArr = FACETS_WS_COLLAPSE;
                zArr = FIXED_FACETS_NONE;
                i6 = 0;
                break;
            case 44:
            case 46:
                xmlValueRefArr = FACETS_BUILTIN_LIST;
                zArr = FIXED_FACETS_NONE;
                i4 = 0;
                i6 = 0;
                break;
            default:
                switch (i) {
                    case 52:
                    default:
                        xmlValueRefArr = FACETS_NONE;
                        zArr = FIXED_FACETS_NONE;
                        i4 = 0;
                        i6 = 0;
                        break;
                    case 53:
                    case 54:
                        xmlValueRefArr = FACETS_WS_COLLAPSE;
                        zArr = FIXED_FACETS_WS;
                        i6 = 0;
                        break;
                }
                break;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 12:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
                i3 = 0;
                z = false;
                z2 = z;
                z3 = z2;
                break;
            case 3:
                i3 = 0;
                z = false;
                z2 = false;
                z3 = true;
                break;
            case 9:
            case 10:
            case 11:
            case 22:
                i3 = 2;
                z = false;
                z3 = false;
                z2 = true;
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                z = false;
                z2 = false;
                z3 = false;
                i3 = 1;
                break;
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
                i3 = 2;
                z = true;
                z2 = z;
                z3 = z2;
                break;
            default:
                switch (i) {
                    case 52:
                    default:
                        i3 = 0;
                        z = false;
                        z2 = z;
                        z3 = z2;
                        break;
                    case 53:
                    case 54:
                        z = false;
                        z2 = false;
                        z3 = false;
                        i3 = 1;
                        break;
                }
                break;
        }
        builtinType.setBasicFacets(xmlValueRefArr, zArr);
        builtinType.setWhiteSpaceRule(i4);
        builtinType.setOrdered(i3);
        builtinType.setBounded(z);
        builtinType.setNumeric(z2);
        builtinType.setFinite(z3);
        builtinType.setDecimalSize(i6);
        builtinType.setAnonymousTypeRefs(EMPTY_SCHEMATYPEREF_ARRAY);
        if (i == 43) {
            str = null;
            z4 = true;
        } else {
            if (i == 45) {
                str = "\\c+";
            } else if (i == 53) {
                str = "[^YM]*[DT].*";
            } else if (i != 54) {
                switch (i) {
                    case 37:
                        str = "\\i\\c*";
                        break;
                    case 38:
                        str = "[\\i-[:]][\\c-[:]]*";
                        break;
                    case 39:
                        str = "[a-zA-Z]{1,8}(-[a-zA-Z0-9]{1,8})*";
                        break;
                    case 40:
                    case 41:
                        str = null;
                        break;
                    default:
                        str = null;
                        z4 = false;
                        break;
                }
            } else {
                str = "[^DT]*";
            }
            z4 = true;
        }
        if (str != null) {
            try {
                regularExpressionForPattern = SchemaRegularExpression.forPattern(str);
            } catch (ParseException unused) {
                regularExpressionForPattern = null;
            }
            builtinType.setPatterns(new RegularExpression[]{regularExpressionForPattern});
        }
        builtinType.setPatternFacet(z4);
        if (i == 1) {
            SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
            schemaParticleImpl.setParticleType(5);
            schemaParticleImpl.setWildcardSet(QNameSet.ALL);
            schemaParticleImpl.setWildcardProcess(2);
            schemaParticleImpl.setMinOccurs(BigInteger.ZERO);
            schemaParticleImpl.setMaxOccurs(null);
            schemaParticleImpl.setTransitionRules(QNameSet.ALL, true);
            schemaParticleImpl.setTransitionNotes(QNameSet.ALL, true);
            SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
            schemaAttributeModelImpl.setWildcardProcess(2);
            schemaAttributeModelImpl.setWildcardSet(QNameSet.ALL);
            builtinType.setComplexTypeVariety(4);
            builtinType.setContentModel(schemaParticleImpl, schemaAttributeModelImpl, Collections.EMPTY_MAP, Collections.EMPTY_MAP, $assertionsDisabled);
            builtinType.setAnonymousTypeRefs(EMPTY_SCHEMATYPEREF_ARRAY);
            builtinType.setWildcardSummary(QNameSet.ALL, true, QNameSet.ALL, true);
        } else if (i == 0) {
            SchemaAttributeModelImpl schemaAttributeModelImpl2 = new SchemaAttributeModelImpl();
            builtinType.setComplexTypeVariety(1);
            builtinType.setContentModel(null, schemaAttributeModelImpl2, Collections.EMPTY_MAP, Collections.EMPTY_MAP, $assertionsDisabled);
            builtinType.setAnonymousTypeRefs(EMPTY_SCHEMATYPEREF_ARRAY);
            builtinType.setWildcardSummary(QNameSet.EMPTY, $assertionsDisabled, QNameSet.EMPTY, $assertionsDisabled);
        }
        builtinType.setOrderSensitive($assertionsDisabled);
    }

    public static SchemaType getNoType() {
        return ST_NO_TYPE;
    }
}
