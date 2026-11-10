package org.apache.xmlbeans;

import javax.xml.namespace.QName;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface SchemaType extends SchemaComponent, SchemaAnnotated {
    public static final int ATOMIC = 1;
    public static final int BTC_ANY_SIMPLE = 2;
    public static final int BTC_ANY_TYPE = 1;
    public static final int BTC_ANY_URI = 6;
    public static final int BTC_BASE_64_BINARY = 4;
    public static final int BTC_BOOLEAN = 3;
    public static final int BTC_BYTE = 26;
    public static final int BTC_DATE = 16;
    public static final int BTC_DATE_TIME = 14;
    public static final int BTC_DECIMAL = 11;
    public static final int BTC_DOUBLE = 10;
    public static final int BTC_DURATION = 13;
    public static final int BTC_ENTITIES = 44;
    public static final int BTC_ENTITY = 43;
    public static final int BTC_FIRST_PRIMITIVE = 2;
    public static final int BTC_FLOAT = 9;
    public static final int BTC_G_DAY = 20;
    public static final int BTC_G_MONTH = 21;
    public static final int BTC_G_MONTH_DAY = 19;
    public static final int BTC_G_YEAR = 18;
    public static final int BTC_G_YEAR_MONTH = 17;
    public static final int BTC_HEX_BINARY = 5;
    public static final int BTC_ID = 40;
    public static final int BTC_IDREF = 41;
    public static final int BTC_IDREFS = 42;
    public static final int BTC_INT = 24;
    public static final int BTC_INTEGER = 22;
    public static final int BTC_LANGUAGE = 39;
    public static final int BTC_LAST_BUILTIN = 46;
    public static final int BTC_LAST_PRIMITIVE = 21;
    public static final int BTC_LONG = 23;
    public static final int BTC_NAME = 37;
    public static final int BTC_NCNAME = 38;
    public static final int BTC_NEGATIVE_INTEGER = 28;
    public static final int BTC_NMTOKEN = 45;
    public static final int BTC_NMTOKENS = 46;
    public static final int BTC_NON_NEGATIVE_INTEGER = 29;
    public static final int BTC_NON_POSITIVE_INTEGER = 27;
    public static final int BTC_NORMALIZED_STRING = 35;
    public static final int BTC_NOTATION = 8;
    public static final int BTC_NOT_BUILTIN = 0;
    public static final int BTC_POSITIVE_INTEGER = 30;
    public static final int BTC_QNAME = 7;
    public static final int BTC_SHORT = 25;
    public static final int BTC_STRING = 12;
    public static final int BTC_TIME = 15;
    public static final int BTC_TOKEN = 36;
    public static final int BTC_UNSIGNED_BYTE = 34;
    public static final int BTC_UNSIGNED_INT = 32;
    public static final int BTC_UNSIGNED_LONG = 31;
    public static final int BTC_UNSIGNED_SHORT = 33;
    public static final int DT_EXTENSION = 2;
    public static final int DT_NOT_DERIVED = 0;
    public static final int DT_RESTRICTION = 1;
    public static final int ELEMENT_CONTENT = 3;
    public static final int EMPTY_CONTENT = 1;
    public static final int FACET_ENUMERATION = 11;
    public static final int FACET_FRACTION_DIGITS = 8;
    public static final int FACET_LENGTH = 0;
    public static final int FACET_MAX_EXCLUSIVE = 6;
    public static final int FACET_MAX_INCLUSIVE = 5;
    public static final int FACET_MAX_LENGTH = 2;
    public static final int FACET_MIN_EXCLUSIVE = 3;
    public static final int FACET_MIN_INCLUSIVE = 4;
    public static final int FACET_MIN_LENGTH = 1;
    public static final int FACET_PATTERN = 10;
    public static final int FACET_TOTAL_DIGITS = 7;
    public static final int FACET_WHITE_SPACE = 9;
    public static final int LAST_BASIC_FACET = 8;
    public static final int LAST_FACET = 11;
    public static final int LAST_PROPERTY = 15;
    public static final int LIST = 3;
    public static final int MIXED_CONTENT = 4;
    public static final int NOT_COMPLEX_TYPE = 0;
    public static final int NOT_DECIMAL = 0;
    public static final int NOT_SIMPLE = 0;
    public static final int PARTIAL_ORDER = 1;
    public static final int PROPERTY_BOUNDED = 13;
    public static final int PROPERTY_CARDINALITY = 14;
    public static final int PROPERTY_NUMERIC = 15;
    public static final int PROPERTY_ORDERED = 12;
    public static final int SIMPLE_CONTENT = 2;
    public static final int SIZE_BIG_DECIMAL = 1000001;
    public static final int SIZE_BIG_INTEGER = 1000000;
    public static final int SIZE_BYTE = 8;
    public static final int SIZE_INT = 32;
    public static final int SIZE_LONG = 64;
    public static final int SIZE_SHORT = 16;
    public static final int TOTAL_ORDER = 2;
    public static final int UNION = 2;
    public static final int UNORDERED = 0;
    public static final int WS_COLLAPSE = 3;
    public static final int WS_PRESERVE = 1;
    public static final int WS_REPLACE = 2;
    public static final int WS_UNSPECIFIED = 0;

    boolean blockExtension();

    boolean blockRestriction();

    SchemaStringEnumEntry enumEntryForString(String str);

    StringEnumAbstractBase enumForInt(int i);

    StringEnumAbstractBase enumForString(String str);

    boolean finalExtension();

    boolean finalList();

    boolean finalRestriction();

    boolean finalUnion();

    SchemaType[] getAnonymousTypes();

    int getAnonymousUnionMemberOrdinal();

    SchemaAttributeModel getAttributeModel();

    SchemaProperty[] getAttributeProperties();

    SchemaProperty getAttributeProperty(QName qName);

    SchemaType getAttributeType(QName qName, SchemaTypeLoader schemaTypeLoader);

    QName getAttributeTypeAttributeName();

    SchemaType getBaseEnumType();

    SchemaType getBaseType();

    int getBuiltinTypeCode();

    SchemaType getCommonBaseType(SchemaType schemaType);

    SchemaField getContainerField();

    SchemaType getContentBasedOnType();

    SchemaParticle getContentModel();

    int getContentType();

    int getDecimalSize();

    int getDerivationType();

    SchemaProperty[] getDerivedProperties();

    QName getDocumentElementName();

    SchemaProperty[] getElementProperties();

    SchemaProperty getElementProperty(QName qName);

    SchemaTypeElementSequencer getElementSequencer();

    SchemaType getElementType(QName qName, QName qName2, SchemaTypeLoader schemaTypeLoader);

    Class getEnumJavaClass();

    XmlAnySimpleType[] getEnumerationValues();

    XmlAnySimpleType getFacet(int i);

    String getFullJavaImplName();

    String getFullJavaName();

    Class getJavaClass();

    SchemaType getListItemType();

    @Override // org.apache.xmlbeans.SchemaComponent
    QName getName();

    SchemaType getOuterType();

    String[] getPatterns();

    SchemaType getPrimitiveType();

    SchemaProperty[] getProperties();

    Ref getRef();

    String getShortJavaImplName();

    String getShortJavaName();

    int getSimpleVariety();

    SchemaStringEnumEntry[] getStringEnumEntries();

    @Override // org.apache.xmlbeans.SchemaComponent
    SchemaTypeSystem getTypeSystem();

    SchemaType getUnionCommonBaseType();

    SchemaType[] getUnionConstituentTypes();

    SchemaType[] getUnionMemberTypes();

    SchemaType[] getUnionSubTypes();

    Object getUserData();

    int getWhiteSpaceRule();

    boolean hasAllContent();

    boolean hasAttributeWildcards();

    boolean hasElementWildcards();

    boolean hasPatternFacet();

    boolean hasStringEnumValues();

    boolean isAbstract();

    boolean isAnonymousType();

    boolean isAssignableFrom(SchemaType schemaType);

    boolean isAttributeType();

    boolean isBounded();

    boolean isBuiltinType();

    boolean isCompiled();

    boolean isDocumentType();

    boolean isFacetFixed(int i);

    boolean isFinite();

    boolean isNoType();

    boolean isNumeric();

    boolean isOrderSensitive();

    boolean isPrimitiveType();

    boolean isSimpleType();

    boolean isSkippedAnonymousType();

    boolean isURType();

    boolean isValidSubstitution(QName qName);

    boolean matchPatternFacet(String str);

    XmlAnySimpleType newValue(Object obj);

    int ordered();

    QNameSet qnameSetForWildcardAttributes();

    QNameSet qnameSetForWildcardElements();

    public static final class Ref extends SchemaComponent.Ref {
        @Override // org.apache.xmlbeans.SchemaComponent.Ref
        public final int getComponentType() {
            return 0;
        }

        public Ref(SchemaType schemaType) {
            super(schemaType);
        }

        public Ref(SchemaTypeSystem schemaTypeSystem, String str) {
            super(schemaTypeSystem, str);
        }

        public final SchemaType get() {
            return (SchemaType) getComponent();
        }
    }
}
