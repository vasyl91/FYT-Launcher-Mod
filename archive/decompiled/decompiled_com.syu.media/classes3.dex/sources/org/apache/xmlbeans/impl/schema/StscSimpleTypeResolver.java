package org.apache.xmlbeans.impl.schema;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlShort;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class StscSimpleTypeResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final RegularExpression[] EMPTY_REGEX_ARRAY = new RegularExpression[0];
    private static CodeForNameEntry[] facetCodes = {new CodeForNameEntry(QNameHelper.forLNS("length", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 0), new CodeForNameEntry(QNameHelper.forLNS("minLength", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 1), new CodeForNameEntry(QNameHelper.forLNS("maxLength", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 2), new CodeForNameEntry(QNameHelper.forLNS("pattern", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 10), new CodeForNameEntry(QNameHelper.forLNS("enumeration", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 11), new CodeForNameEntry(QNameHelper.forLNS("whiteSpace", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 9), new CodeForNameEntry(QNameHelper.forLNS("maxInclusive", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 5), new CodeForNameEntry(QNameHelper.forLNS("maxExclusive", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 6), new CodeForNameEntry(QNameHelper.forLNS("minInclusive", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 4), new CodeForNameEntry(QNameHelper.forLNS("minExclusive", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 3), new CodeForNameEntry(QNameHelper.forLNS("totalDigits", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 7), new CodeForNameEntry(QNameHelper.forLNS("fractionDigits", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 8)};
    private static final Map facetCodeMap = buildFacetCodeMap();

    static boolean isMultipleFacet(int i) {
        return i == 11 || i == 10;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0080  */
    public static void resolveSimpleType(SchemaTypeImpl schemaTypeImpl) {
        Object finalDefault;
        boolean zContains;
        SimpleType simpleType = (SimpleType) schemaTypeImpl.getParseObject();
        SchemaDocument.Schema schema = StscComplexTypeResolver.getSchema(simpleType);
        int i = (simpleType.isSetList() ? 1 : 0) + (simpleType.isSetUnion() ? 1 : 0) + (simpleType.isSetRestriction() ? 1 : 0);
        boolean z = true;
        if (i > 1) {
            StscState.get().error("A simple type must define either a list, a union, or a restriction: more than one found.", 52, simpleType);
        } else if (i < 1) {
            StscState.get().error("A simple type must define either a list, a union, or a restriction: none was found.", 52, simpleType);
            resolveErrorSimpleType(schemaTypeImpl);
            return;
        }
        if (simpleType.isSetFinal()) {
            finalDefault = simpleType.getFinal();
        } else {
            finalDefault = (schema == null || !schema.isSetFinalDefault()) ? null : schema.getFinalDefault();
        }
        boolean z2 = false;
        if (finalDefault == null) {
            z = false;
            zContains = false;
        } else if (finalDefault instanceof String) {
            if ("#all".equals((String) finalDefault)) {
                z2 = true;
                zContains = true;
            } else {
                z = false;
                zContains = false;
            }
        } else if (finalDefault instanceof List) {
            List list = (List) finalDefault;
            boolean zContains2 = list.contains("restriction");
            zContains = list.contains("list");
            z2 = list.contains("union");
            z = zContains2;
        } else {
            z = false;
            zContains = false;
        }
        schemaTypeImpl.setSimpleFinal(z, zContains, z2);
        ArrayList arrayList = new ArrayList();
        if (simpleType.getList() != null) {
            resolveListType(schemaTypeImpl, simpleType.getList(), arrayList);
        } else if (simpleType.getUnion() != null) {
            resolveUnionType(schemaTypeImpl, simpleType.getUnion(), arrayList);
        } else if (simpleType.getRestriction() != null) {
            resolveSimpleRestrictionType(schemaTypeImpl, simpleType.getRestriction(), arrayList);
        }
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
    }

    private static SchemaType.Ref[] makeRefArray(Collection collection) {
        SchemaType.Ref[] refArr = new SchemaType.Ref[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            refArr[i] = ((SchemaType) it.next()).getRef();
            i++;
        }
        return refArr;
    }

    static void resolveErrorSimpleType(SchemaTypeImpl schemaTypeImpl) {
        schemaTypeImpl.setSimpleTypeVariety(1);
        schemaTypeImpl.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
        schemaTypeImpl.setBaseDepth(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getBaseDepth() + 1);
        schemaTypeImpl.setPrimitiveTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00e2  */
    static void resolveListType(SchemaTypeImpl schemaTypeImpl, ListDocument.List list, List list2) {
        XmlQName xmlQNameXgetItemType;
        SchemaTypeImpl schemaTypeImplTranslateAnonymousSimpleType;
        SchemaTypeImpl schemaTypeImpl2;
        StscState stscState = StscState.get();
        schemaTypeImpl.setSimpleTypeVariety(3);
        schemaTypeImpl.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
        schemaTypeImpl.setBaseDepth(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        if (schemaTypeImpl.isRedefinition()) {
            stscState.error("src-redefine.5a", new Object[]{"list"}, list);
        }
        QName itemType = list.getItemType();
        XmlQName simpleType = list.getSimpleType();
        if (itemType == null || simpleType == null) {
            xmlQNameXgetItemType = simpleType;
        } else {
            stscState.error("src-simple-type.3a", (Object[]) null, list);
            xmlQNameXgetItemType = null;
        }
        if (itemType != null) {
            schemaTypeImplTranslateAnonymousSimpleType = stscState.findGlobalType(itemType, schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl.getTargetNamespace());
            xmlQNameXgetItemType = list.xgetItemType();
            if (schemaTypeImplTranslateAnonymousSimpleType == null) {
                stscState.notFoundError(itemType, 0, list.xgetItemType(), true);
                schemaTypeImplTranslateAnonymousSimpleType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
            }
        } else if (xmlQNameXgetItemType != null) {
            schemaTypeImplTranslateAnonymousSimpleType = StscTranslator.translateAnonymousSimpleType(xmlQNameXgetItemType, schemaTypeImpl.getTargetNamespace(), schemaTypeImpl.getChameleonNamespace() != null, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), list2, schemaTypeImpl);
        } else {
            stscState.error("src-simple-type.3b", (Object[]) null, list);
            resolveErrorSimpleType(schemaTypeImpl);
            return;
        }
        if (schemaTypeImplTranslateAnonymousSimpleType.finalList()) {
            stscState.error("st-props-correct.4.2.1", (Object[]) null, list);
        }
        StscResolver.resolveType(schemaTypeImplTranslateAnonymousSimpleType);
        if (schemaTypeImplTranslateAnonymousSimpleType.isSimpleType()) {
            schemaTypeImpl2 = schemaTypeImpl;
        } else {
            stscState.error("cos-st-restricts.2.1a", (Object[]) null, (XmlObject) xmlQNameXgetItemType);
            schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        int simpleVariety = schemaTypeImplTranslateAnonymousSimpleType.getSimpleVariety();
        if (simpleVariety == 1) {
            schemaTypeImpl2.setListItemTypeRef(schemaTypeImplTranslateAnonymousSimpleType.getRef());
            if (schemaTypeImpl2.getBuiltinTypeCode() == 8) {
                stscState.recover("enumeration-required-notation", null, xmlQNameXgetItemType);
            }
        } else if (simpleVariety == 2) {
            if (schemaTypeImplTranslateAnonymousSimpleType.isUnionOfLists()) {
                stscState.error("cos-st-restricts.2.1c", (Object[]) null, (XmlObject) xmlQNameXgetItemType);
                resolveErrorSimpleType(schemaTypeImpl2);
                return;
            }
            schemaTypeImpl2.setListItemTypeRef(schemaTypeImplTranslateAnonymousSimpleType.getRef());
            if (schemaTypeImpl2.getBuiltinTypeCode() == 8) {
                stscState.recover("enumeration-required-notation", null, xmlQNameXgetItemType);
            }
        } else {
            if (simpleVariety == 3) {
                stscState.error("cos-st-restricts.2.1b", (Object[]) null, (XmlObject) xmlQNameXgetItemType);
                resolveErrorSimpleType(schemaTypeImpl2);
                return;
            }
            schemaTypeImpl2.setListItemTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
        }
        schemaTypeImpl2.setBasicFacets(StscState.FACETS_LIST, StscState.FIXED_FACETS_LIST);
        schemaTypeImpl2.setWhiteSpaceRule(3);
        resolveFundamentalFacets(schemaTypeImpl2);
    }

    static void resolveUnionType(SchemaTypeImpl schemaTypeImpl, UnionDocument.Union union, List list) {
        String str;
        XmlObject xmlObjectXgetMemberTypes;
        XmlObject xmlObjectXgetMemberTypes2;
        schemaTypeImpl.setSimpleTypeVariety(2);
        schemaTypeImpl.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
        schemaTypeImpl.setBaseDepth(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        StscState stscState = StscState.get();
        if (schemaTypeImpl.isRedefinition()) {
            stscState.error("src-redefine.5a", new Object[]{"union"}, union);
        }
        List<QName> memberTypes = union.getMemberTypes();
        LocalSimpleType[] simpleTypeArray = union.getSimpleTypeArray();
        ArrayList arrayList = new ArrayList();
        if (simpleTypeArray.length == 0 && (memberTypes == null || memberTypes.size() == 0)) {
            stscState.error("src-union-memberTypes-or-simpleTypes", (Object[]) null, union);
        }
        if (memberTypes != null) {
            for (QName qName : memberTypes) {
                SchemaTypeImpl schemaTypeImplFindGlobalType = stscState.findGlobalType(qName, schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl.getTargetNamespace());
                if (schemaTypeImplFindGlobalType == null) {
                    stscState.notFoundError(qName, 0, union.xgetMemberTypes(), true);
                } else {
                    arrayList.add(schemaTypeImplFindGlobalType);
                }
            }
        }
        int i = 0;
        while (i < simpleTypeArray.length) {
            SchemaTypeImpl schemaTypeImplTranslateAnonymousSimpleType = StscTranslator.translateAnonymousSimpleType(simpleTypeArray[i], schemaTypeImpl.getTargetNamespace(), schemaTypeImpl.getChameleonNamespace() != null, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), list, schemaTypeImpl);
            arrayList.add(schemaTypeImplTranslateAnonymousSimpleType);
            i++;
            schemaTypeImplTranslateAnonymousSimpleType.setAnonymousUnionMemberOrdinal(i);
        }
        Iterator it = arrayList.iterator();
        while (true) {
            String str2 = "";
            if (!it.hasNext()) {
                break;
            }
            SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) it.next();
            if (!StscResolver.resolveType(schemaTypeImpl2)) {
                if (schemaTypeImpl2.getOuterType().equals(schemaTypeImpl)) {
                    xmlObjectXgetMemberTypes2 = schemaTypeImpl2.getParseObject();
                } else {
                    str2 = QNameHelper.pretty(schemaTypeImpl2.getName()) + " ";
                    xmlObjectXgetMemberTypes2 = union.xgetMemberTypes();
                }
                stscState.error("src-simple-type.4", new Object[]{str2}, xmlObjectXgetMemberTypes2);
                it.remove();
            }
        }
        Iterator it2 = arrayList.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            SchemaTypeImpl schemaTypeImpl3 = (SchemaTypeImpl) it2.next();
            if (!schemaTypeImpl3.isSimpleType()) {
                if (schemaTypeImpl3.getOuterType() != null && schemaTypeImpl3.getOuterType().equals(schemaTypeImpl)) {
                    xmlObjectXgetMemberTypes = schemaTypeImpl3.getParseObject();
                    str = "";
                } else {
                    str = QNameHelper.pretty(schemaTypeImpl3.getName()) + " ";
                    xmlObjectXgetMemberTypes = union.xgetMemberTypes();
                }
                stscState.error("cos-st-restricts.3.1", new Object[]{str}, xmlObjectXgetMemberTypes);
                it2.remove();
            } else if (schemaTypeImpl3.getSimpleVariety() == 3 || (schemaTypeImpl3.getSimpleVariety() == 2 && schemaTypeImpl3.isUnionOfLists())) {
                z = true;
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (((SchemaTypeImpl) arrayList.get(i2)).finalUnion()) {
                stscState.error("st-props-correct.4.2.2", (Object[]) null, union);
            }
        }
        schemaTypeImpl.setUnionOfLists(z);
        schemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setBasicFacets(StscState.FACETS_UNION, StscState.FIXED_FACETS_UNION);
        resolveFundamentalFacets(schemaTypeImpl);
    }

    static void resolveSimpleRestrictionType(SchemaTypeImpl schemaTypeImpl, RestrictionDocument.Restriction restriction, List list) {
        LocalSimpleType localSimpleType;
        SchemaTypeImpl schemaTypeImplTranslateAnonymousSimpleType;
        QName base = restriction.getBase();
        LocalSimpleType simpleType = restriction.getSimpleType();
        StscState stscState = StscState.get();
        if (base == null || simpleType == null) {
            localSimpleType = simpleType;
        } else {
            stscState.error("src-simple-type.2a", (Object[]) null, restriction);
            localSimpleType = null;
        }
        if (base != null) {
            if (schemaTypeImpl.isRedefinition()) {
                schemaTypeImplTranslateAnonymousSimpleType = stscState.findRedefinedGlobalType(restriction.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (schemaTypeImplTranslateAnonymousSimpleType != null && !schemaTypeImplTranslateAnonymousSimpleType.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error("src-redefine.5b", new Object[]{"<simpleType>", QNameHelper.pretty(base), QNameHelper.pretty(schemaTypeImpl.getName())}, restriction);
                }
            } else {
                schemaTypeImplTranslateAnonymousSimpleType = stscState.findGlobalType(base, schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl.getTargetNamespace());
            }
            if (schemaTypeImplTranslateAnonymousSimpleType == null) {
                stscState.notFoundError(base, 0, restriction.xgetBase(), true);
                schemaTypeImplTranslateAnonymousSimpleType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
            }
        } else if (localSimpleType != null) {
            if (schemaTypeImpl.isRedefinition()) {
                StscState.get().error("src-redefine.5a", new Object[]{"<simpleType>"}, localSimpleType);
            }
            schemaTypeImplTranslateAnonymousSimpleType = StscTranslator.translateAnonymousSimpleType(localSimpleType, schemaTypeImpl.getTargetNamespace(), schemaTypeImpl.getChameleonNamespace() != null, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), list, schemaTypeImpl);
        } else {
            stscState.error("src-simple-type.2b", (Object[]) null, restriction);
            schemaTypeImplTranslateAnonymousSimpleType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (!StscResolver.resolveType(schemaTypeImplTranslateAnonymousSimpleType)) {
            schemaTypeImplTranslateAnonymousSimpleType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (schemaTypeImplTranslateAnonymousSimpleType.finalRestriction()) {
            stscState.error("st-props-correct.3", (Object[]) null, restriction);
        }
        schemaTypeImpl.setBaseTypeRef(schemaTypeImplTranslateAnonymousSimpleType.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImplTranslateAnonymousSimpleType.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        if (!schemaTypeImplTranslateAnonymousSimpleType.isSimpleType()) {
            stscState.error("cos-st-restricts.1.1", (Object[]) null, (XmlObject) restriction.xgetBase());
            resolveErrorSimpleType(schemaTypeImpl);
            return;
        }
        schemaTypeImpl.setSimpleTypeVariety(schemaTypeImplTranslateAnonymousSimpleType.getSimpleVariety());
        int simpleVariety = schemaTypeImplTranslateAnonymousSimpleType.getSimpleVariety();
        if (simpleVariety == 1) {
            schemaTypeImpl.setPrimitiveTypeRef(schemaTypeImplTranslateAnonymousSimpleType.getPrimitiveType().getRef());
        } else if (simpleVariety == 2) {
            schemaTypeImpl.setUnionOfLists(schemaTypeImplTranslateAnonymousSimpleType.isUnionOfLists());
            schemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(Arrays.asList(schemaTypeImplTranslateAnonymousSimpleType.getUnionMemberTypes())));
        } else if (simpleVariety == 3) {
            schemaTypeImpl.setListItemTypeRef(schemaTypeImplTranslateAnonymousSimpleType.getListItemType().getRef());
        }
        resolveFacets(schemaTypeImpl, restriction, schemaTypeImplTranslateAnonymousSimpleType);
        resolveFundamentalFacets(schemaTypeImpl);
    }

    static int translateWhitespaceCode(XmlAnySimpleType xmlAnySimpleType) {
        String stringValue = xmlAnySimpleType.getStringValue();
        if (stringValue.equals("collapse")) {
            return 3;
        }
        if (stringValue.equals("preserve")) {
            return 1;
        }
        if (stringValue.equals("replace")) {
            return 2;
        }
        StscState.get().error("Unrecognized whitespace value \"" + stringValue + "\"", 20, (XmlObject) xmlAnySimpleType);
        return 0;
    }

    static boolean facetAppliesToType(int i, SchemaTypeImpl schemaTypeImpl) {
        int simpleVariety = schemaTypeImpl.getSimpleVariety();
        if (simpleVariety == 2) {
            return i == 10 || i == 11;
        }
        if (simpleVariety == 3) {
            if (i != 0 && i != 1 && i != 2) {
                switch (i) {
                    case 9:
                    case 10:
                    case 11:
                        break;
                    default:
                        return false;
                }
            }
            return true;
        }
        switch (schemaTypeImpl.getPrimitiveType().getBuiltinTypeCode()) {
            case 2:
            default:
                return false;
            case 3:
                return i == 9 || i == 10;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 12:
                if (i != 0 && i != 1 && i != 2) {
                    switch (i) {
                        case 9:
                        case 10:
                        case 11:
                            break;
                        default:
                            return false;
                    }
                }
                return true;
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
                switch (i) {
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 9:
                    case 10:
                    case 11:
                        return true;
                    case 7:
                    case 8:
                    default:
                        return false;
                }
            case 11:
                switch (i) {
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        return true;
                    default:
                        return false;
                }
        }
    }

    private static int other_similar_limit(int i) {
        if (i == 3) {
            return 4;
        }
        if (i == 4) {
            return 3;
        }
        if (i == 5) {
            return 6;
        }
        if (i == 6) {
            return 5;
        }
        throw new IllegalStateException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:210:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:229:0x0435  */
    /* JADX WARN: Code duplicated, block: B:258:0x03cd A[SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x025b, code lost:
    
        if (r9 == r13) goto L123;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void resolveFacets(org.apache.xmlbeans.impl.schema.SchemaTypeImpl r22, org.apache.xmlbeans.XmlObject r23, org.apache.xmlbeans.impl.schema.SchemaTypeImpl r24) {
        /*
            Method dump skipped, instruction units count: 1174
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.StscSimpleTypeResolver.resolveFacets(org.apache.xmlbeans.impl.schema.SchemaTypeImpl, org.apache.xmlbeans.XmlObject, org.apache.xmlbeans.impl.schema.SchemaTypeImpl):void");
    }

    private static XmlValueRef[] makeValueRefArray(XmlAnySimpleType[] xmlAnySimpleTypeArr) {
        int length = xmlAnySimpleTypeArr.length;
        XmlValueRef[] xmlValueRefArr = new XmlValueRef[length];
        for (int i = 0; i < length; i++) {
            xmlValueRefArr[i] = xmlAnySimpleTypeArr[i] == null ? null : new XmlValueRef(xmlAnySimpleTypeArr[i]);
        }
        return xmlValueRefArr;
    }

    private static boolean isDiscreteType(SchemaTypeImpl schemaTypeImpl) {
        int builtinTypeCode;
        if (schemaTypeImpl.getFacet(8) == null && (builtinTypeCode = schemaTypeImpl.getPrimitiveType().getBuiltinTypeCode()) != 3) {
            switch (builtinTypeCode) {
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private static boolean isNumericPrimitive(SchemaType schemaType) {
        switch (schemaType.getBuiltinTypeCode()) {
            case 9:
            case 10:
            case 11:
                return true;
            default:
                return false;
        }
    }

    private static int decimalSizeOfType(SchemaTypeImpl schemaTypeImpl) {
        int iMathematicalSizeOfType = mathematicalSizeOfType(schemaTypeImpl);
        if (iMathematicalSizeOfType == 8 && !XmlByte.type.isAssignableFrom(schemaTypeImpl)) {
            iMathematicalSizeOfType = 16;
        }
        if (iMathematicalSizeOfType != 16 || XmlShort.type.isAssignableFrom(schemaTypeImpl) || XmlUnsignedByte.type.isAssignableFrom(schemaTypeImpl)) {
            return iMathematicalSizeOfType;
        }
        return 32;
    }

    private static int mathematicalSizeOfType(SchemaTypeImpl schemaTypeImpl) {
        BigInteger bigIntegerValueOf;
        if (schemaTypeImpl.getPrimitiveType().getBuiltinTypeCode() != 11) {
            return 0;
        }
        if (schemaTypeImpl.getFacet(8) == null || schemaTypeImpl.getFacet(8).getBigIntegerValue().signum() != 0) {
            return 1000001;
        }
        BigInteger bigInteger = null;
        BigInteger bigIntegerValue = schemaTypeImpl.getFacet(3) != null ? schemaTypeImpl.getFacet(3).getBigIntegerValue() : null;
        if (schemaTypeImpl.getFacet(4) != null) {
            bigIntegerValue = schemaTypeImpl.getFacet(4).getBigIntegerValue();
        }
        BigInteger bigIntegerValue2 = schemaTypeImpl.getFacet(5) != null ? schemaTypeImpl.getFacet(5).getBigIntegerValue() : null;
        if (schemaTypeImpl.getFacet(6) != null) {
            bigIntegerValue2 = schemaTypeImpl.getFacet(6).getBigIntegerValue();
        }
        if (schemaTypeImpl.getFacet(7) != null) {
            try {
                switch (schemaTypeImpl.getFacet(7).getBigIntegerValue().intValue()) {
                    case 0:
                    case 1:
                    case 2:
                        bigIntegerValueOf = BigInteger.valueOf(99L);
                        bigInteger = bigIntegerValueOf;
                        break;
                    case 3:
                    case 4:
                        bigIntegerValueOf = BigInteger.valueOf(9999L);
                        bigInteger = bigIntegerValueOf;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        bigIntegerValueOf = BigInteger.valueOf(999999999L);
                        bigInteger = bigIntegerValueOf;
                        break;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        bigIntegerValueOf = BigInteger.valueOf(999999999999999999L);
                        bigInteger = bigIntegerValueOf;
                        break;
                }
            } catch (XmlValueOutOfRangeException unused) {
            }
            if (bigInteger != null) {
                BigInteger bigIntegerNegate = bigInteger.negate();
                if (bigIntegerValue != null) {
                    bigIntegerNegate = bigIntegerValue.max(bigIntegerNegate);
                }
                bigIntegerValue = bigIntegerNegate;
                bigIntegerValue2 = bigIntegerValue2 == null ? bigInteger : bigIntegerValue2.min(bigInteger);
            }
        }
        if (bigIntegerValue == null || bigIntegerValue2 == null) {
            return 1000000;
        }
        if (bigIntegerValue.signum() < 0) {
            bigIntegerValue = bigIntegerValue.negate().subtract(BigInteger.ONE);
        }
        if (bigIntegerValue2.signum() < 0) {
            bigIntegerValue2 = bigIntegerValue2.negate().subtract(BigInteger.ONE);
        }
        BigInteger bigIntegerMax = bigIntegerValue2.max(bigIntegerValue);
        if (bigIntegerMax.compareTo(BigInteger.valueOf(127L)) <= 0) {
            return 8;
        }
        if (bigIntegerMax.compareTo(BigInteger.valueOf(32767L)) <= 0) {
            return 16;
        }
        if (bigIntegerMax.compareTo(BigInteger.valueOf(2147483647L)) <= 0) {
            return 32;
        }
        return bigIntegerMax.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0 ? 64 : 1000000;
    }

    static void resolveFundamentalFacets(SchemaTypeImpl schemaTypeImpl) {
        int simpleVariety = schemaTypeImpl.getSimpleVariety();
        boolean z = true;
        if (simpleVariety == 1) {
            SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) schemaTypeImpl.getBaseType();
            schemaTypeImpl.setOrdered(schemaTypeImpl2.ordered());
            schemaTypeImpl.setBounded(((schemaTypeImpl.getFacet(3) == null && schemaTypeImpl.getFacet(4) == null) || (schemaTypeImpl.getFacet(5) == null && schemaTypeImpl.getFacet(6) == null)) ? false : true);
            schemaTypeImpl.setFinite(schemaTypeImpl2.isFinite() || (schemaTypeImpl.isBounded() && isDiscreteType(schemaTypeImpl)));
            if (!schemaTypeImpl2.isNumeric() && !isNumericPrimitive(schemaTypeImpl.getPrimitiveType())) {
                z = false;
            }
            schemaTypeImpl.setNumeric(z);
            schemaTypeImpl.setDecimalSize(decimalSizeOfType(schemaTypeImpl));
            return;
        }
        if (simpleVariety != 2) {
            if (simpleVariety != 3) {
                return;
            }
            schemaTypeImpl.setOrdered(0);
            schemaTypeImpl.setBounded((schemaTypeImpl.getFacet(0) == null && schemaTypeImpl.getFacet(2) == null) ? false : true);
            schemaTypeImpl.setFinite(schemaTypeImpl.getListItemType().isFinite() && schemaTypeImpl.isBounded());
            schemaTypeImpl.setNumeric(false);
            schemaTypeImpl.setDecimalSize(0);
            return;
        }
        SchemaType[] unionMemberTypes = schemaTypeImpl.getUnionMemberTypes();
        boolean z2 = true;
        boolean z3 = true;
        boolean z4 = true;
        int i = 0;
        for (int i2 = 0; i2 < unionMemberTypes.length; i2++) {
            if (unionMemberTypes[i2].ordered() != 0) {
                i = 1;
            }
            if (!unionMemberTypes[i2].isBounded()) {
                z2 = false;
            }
            if (!unionMemberTypes[i2].isFinite()) {
                z3 = false;
            }
            if (!unionMemberTypes[i2].isNumeric()) {
                z4 = false;
            }
        }
        schemaTypeImpl.setOrdered(i);
        schemaTypeImpl.setBounded(z2);
        schemaTypeImpl.setFinite(z3);
        schemaTypeImpl.setNumeric(z4);
        schemaTypeImpl.setDecimalSize(0);
    }

    private static class CodeForNameEntry {
        public int code;
        public QName name;

        CodeForNameEntry(QName qName, int i) {
            this.name = qName;
            this.code = i;
        }
    }

    private static Map buildFacetCodeMap() {
        HashMap map = new HashMap();
        int i = 0;
        while (true) {
            CodeForNameEntry[] codeForNameEntryArr = facetCodes;
            if (i >= codeForNameEntryArr.length) {
                return map;
            }
            map.put(codeForNameEntryArr[i].name, new Integer(facetCodes[i].code));
            i++;
        }
    }

    private static int translateFacetCode(QName qName) {
        Integer num = (Integer) facetCodeMap.get(qName);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }
}
