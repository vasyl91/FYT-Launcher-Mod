package org.apache.xmlbeans.impl.schema;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.QNameSetBuilder;
import org.apache.xmlbeans.QNameSetSpecification;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
import org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexRestrictionType;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType;
import org.apache.xmlbeans.impl.xb.xsdschema.Group;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalElement;
import org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleExtensionType;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleRestrictionType;
import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class StscComplexTypeResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ANY_ATTRIBUTE_CODE = 102;
    private static final int ATTRIBUTE_CODE = 100;
    private static final int ATTRIBUTE_GROUP_CODE = 101;
    private static final int MODEL_GROUP_CODE = 100;
    private static CodeForNameEntry[] particleCodes = {new CodeForNameEntry(QNameHelper.forLNS("all", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 1), new CodeForNameEntry(QNameHelper.forLNS("sequence", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 3), new CodeForNameEntry(QNameHelper.forLNS("choice", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 2), new CodeForNameEntry(QNameHelper.forLNS("element", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 4), new CodeForNameEntry(QNameHelper.forLNS("any", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 5), new CodeForNameEntry(QNameHelper.forLNS("group", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 100)};
    private static Map particleCodeMap = buildParticleCodeMap();
    private static CodeForNameEntry[] attributeCodes = {new CodeForNameEntry(QNameHelper.forLNS("attribute", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 100), new CodeForNameEntry(QNameHelper.forLNS("attributeGroup", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 101), new CodeForNameEntry(QNameHelper.forLNS("anyAttribute", XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA), 102)};
    private static Map attributeCodeMap = buildAttributeCodeMap();

    public static Group getContentModel(ComplexType complexType) {
        if (complexType.getAll() != null) {
            return complexType.getAll();
        }
        if (complexType.getSequence() != null) {
            return complexType.getSequence();
        }
        if (complexType.getChoice() != null) {
            return complexType.getChoice();
        }
        if (complexType.getGroup() != null) {
            return complexType.getGroup();
        }
        return null;
    }

    public static Group getContentModel(ComplexRestrictionType complexRestrictionType) {
        if (complexRestrictionType.getAll() != null) {
            return complexRestrictionType.getAll();
        }
        if (complexRestrictionType.getSequence() != null) {
            return complexRestrictionType.getSequence();
        }
        if (complexRestrictionType.getChoice() != null) {
            return complexRestrictionType.getChoice();
        }
        if (complexRestrictionType.getGroup() != null) {
            return complexRestrictionType.getGroup();
        }
        return null;
    }

    public static Group getContentModel(ExtensionType extensionType) {
        if (extensionType.getAll() != null) {
            return extensionType.getAll();
        }
        if (extensionType.getSequence() != null) {
            return extensionType.getSequence();
        }
        if (extensionType.getChoice() != null) {
            return extensionType.getChoice();
        }
        if (extensionType.getGroup() != null) {
            return extensionType.getGroup();
        }
        return null;
    }

    static SchemaDocument.Schema getSchema(XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        while (xmlCursorNewCursor.toParent()) {
            try {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object.schemaType().equals(SchemaDocument.Schema.type)) {
                    SchemaDocument.Schema schema = (SchemaDocument.Schema) object;
                    xmlCursorNewCursor.dispose();
                    return schema;
                }
            } catch (Throwable th) {
                xmlCursorNewCursor.dispose();
                throw th;
            }
        }
        xmlCursorNewCursor.dispose();
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0064  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d6  */
    public static void resolveComplexType(SchemaTypeImpl schemaTypeImpl) {
        Object finalDefault;
        boolean zContains;
        boolean z;
        boolean z2;
        boolean z3;
        Object blockDefault;
        boolean z4;
        boolean zContains2;
        SimpleContentDocument.SimpleContent simpleContent;
        ComplexType complexType = (ComplexType) schemaTypeImpl.getParseObject();
        StscState stscState = StscState.get();
        SchemaDocument.Schema schema = getSchema(complexType);
        boolean z5 = complexType.isSetAbstract() ? complexType.getAbstract() : false;
        if (complexType.isSetFinal()) {
            finalDefault = complexType.getFinal();
        } else {
            finalDefault = (schema == null || !schema.isSetFinalDefault()) ? null : schema.getFinalDefault();
        }
        if (finalDefault == null) {
            zContains = false;
            z3 = zContains;
            z2 = z3;
            z = z2;
        } else if ((finalDefault instanceof String) && finalDefault.equals("#all")) {
            zContains = true;
            z3 = zContains;
            z2 = z3;
            z = z2;
        } else if (finalDefault instanceof List) {
            List list = (List) finalDefault;
            zContains = list.contains("extension");
            if (list.contains("restriction")) {
                z2 = false;
                z = false;
                z3 = true;
            } else {
                z3 = false;
                z2 = z3;
                z = z2;
            }
        } else {
            zContains = false;
            z3 = zContains;
            z2 = z3;
            z = z2;
        }
        schemaTypeImpl.setAbstractFinal(z5, zContains, z3, z2, z);
        if (complexType.isSetBlock()) {
            blockDefault = complexType.getBlock();
        } else {
            blockDefault = (schema == null || !schema.isSetBlockDefault()) ? null : schema.getBlockDefault();
        }
        if (blockDefault == null) {
            z4 = false;
            zContains2 = z4;
        } else if ((blockDefault instanceof String) && blockDefault.equals("#all")) {
            z4 = true;
            zContains2 = z4;
        } else if (blockDefault instanceof List) {
            List list2 = (List) blockDefault;
            zContains2 = list2.contains("extension");
            z4 = list2.contains("restriction");
        } else {
            z4 = false;
            zContains2 = z4;
        }
        schemaTypeImpl.setBlock(zContains2, z4);
        ComplexContentDocument.ComplexContent complexContent = complexType.getComplexContent();
        SimpleContentDocument.SimpleContent simpleContent2 = complexType.getSimpleContent();
        if ((complexContent != null ? 1 : 0) + (simpleContent2 != null ? 1 : 0) + (getContentModel(complexType) != null ? 1 : 0) > 1) {
            stscState.error("A complex type must define either a content model, or a simpleContent or complexContent derivation: more than one found.", 26, complexType);
            simpleContent = (complexContent == null || simpleContent2 == null) ? simpleContent2 : null;
        }
        if (complexContent != null) {
            if (complexContent.getExtension() != null && complexContent.getRestriction() != null) {
                stscState.error("Restriction conflicts with extension", 26, complexContent.getRestriction());
            }
            boolean mixed = complexContent.isSetMixed() ? complexContent.getMixed() : complexType.getMixed();
            if (complexContent.getExtension() != null) {
                resolveCcExtension(schemaTypeImpl, complexContent.getExtension(), mixed);
                return;
            } else if (complexContent.getRestriction() != null) {
                resolveCcRestriction(schemaTypeImpl, complexContent.getRestriction(), mixed);
                return;
            } else {
                stscState.error("Missing restriction or extension", 27, complexContent);
                resolveErrorType(schemaTypeImpl);
                return;
            }
        }
        if (simpleContent != null) {
            if (simpleContent.getExtension() != null && simpleContent.getRestriction() != null) {
                stscState.error("Restriction conflicts with extension", 26, simpleContent.getRestriction());
            }
            if (simpleContent.getExtension() != null) {
                resolveScExtension(schemaTypeImpl, simpleContent.getExtension());
                return;
            } else if (simpleContent.getRestriction() != null) {
                resolveScRestriction(schemaTypeImpl, simpleContent.getRestriction());
                return;
            } else {
                stscState.error("Missing restriction or extension", 27, simpleContent);
                resolveErrorType(schemaTypeImpl);
                return;
            }
        }
        resolveBasicComplexType(schemaTypeImpl);
    }

    static void resolveErrorType(SchemaTypeImpl schemaTypeImpl) {
        throw new RuntimeException("This type of error recovery not yet implemented.");
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

    static void resolveBasicComplexType(SchemaTypeImpl schemaTypeImpl) {
        int i;
        ArrayList arrayList = new ArrayList();
        ComplexType complexType = (ComplexType) schemaTypeImpl.getParseObject();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z = schemaTypeImpl.getChameleonNamespace() != null;
        Group contentModel = getContentModel(complexType);
        if (schemaTypeImpl.isRedefinition()) {
            StscState.get().error("src-redefine.5a", new Object[]{"<complexType>"}, complexType);
        }
        SchemaParticle schemaParticleTranslateContentModel = translateContentModel(schemaTypeImpl, contentModel, targetNamespace, z, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), translateParticleCode(contentModel), arrayList, new LinkedHashMap(), $assertionsDisabled, null);
        boolean z2 = (schemaParticleTranslateContentModel == null || schemaParticleTranslateContentModel.getParticleType() != 1) ? $assertionsDisabled : true;
        SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
        translateAttributeModel(complexType, targetNamespace, z, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl, null, true, null);
        WildcardResult wildcardResultSummarizeEltWildcards = summarizeEltWildcards(schemaParticleTranslateContentModel);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl);
        if (schemaParticleTranslateContentModel != null) {
            buildStateMachine(schemaParticleTranslateContentModel);
            if (!StscState.get().noUpa() && !((SchemaParticleImpl) schemaParticleTranslateContentModel).isDeterministic()) {
                StscState.get().error("cos-nonambig", (Object[]) null, contentModel);
            }
        }
        Map mapBuildContentPropertyModelByQName = buildContentPropertyModelByQName(schemaParticleTranslateContentModel, schemaTypeImpl);
        Map mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl);
        if (complexType.getMixed()) {
            i = 4;
        } else {
            i = schemaParticleTranslateContentModel == null ? 1 : 3;
        }
        schemaTypeImpl.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_TYPE.getRef());
        schemaTypeImpl.setBaseDepth(BuiltinSchemaTypeSystem.ST_ANY_TYPE.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(2);
        schemaTypeImpl.setComplexTypeVariety(i);
        schemaTypeImpl.setContentModel(schemaParticleTranslateContentModel, schemaAttributeModelImpl, mapBuildContentPropertyModelByQName, mapBuildAttributePropertyModelByQName, z2);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(wildcardResultSummarizeEltWildcards.typedWildcards, wildcardResultSummarizeEltWildcards.hasWildcards, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
    }

    static void resolveCcRestriction(SchemaTypeImpl schemaTypeImpl, ComplexRestrictionType complexRestrictionType, boolean z) {
        SchemaTypeImpl schemaTypeImplFindGlobalType;
        SchemaAttributeModelImpl schemaAttributeModelImpl;
        int i;
        StscState stscState = StscState.get();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z2 = schemaTypeImpl.getChameleonNamespace() != null;
        if (complexRestrictionType.getBase() == null) {
            stscState.error("A complexContent must define a base type", 28, complexRestrictionType);
            schemaTypeImplFindGlobalType = null;
        } else {
            if (schemaTypeImpl.isRedefinition()) {
                schemaTypeImplFindGlobalType = stscState.findRedefinedGlobalType(complexRestrictionType.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (schemaTypeImplFindGlobalType != null && !schemaTypeImplFindGlobalType.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error("src-redefine.5b", new Object[]{"<complexType>", QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, complexRestrictionType);
                }
            } else {
                schemaTypeImplFindGlobalType = stscState.findGlobalType(complexRestrictionType.getBase(), schemaTypeImpl.getChameleonNamespace(), targetNamespace);
            }
            if (schemaTypeImplFindGlobalType == null) {
                stscState.notFoundError(complexRestrictionType.getBase(), 0, complexRestrictionType.xgetBase(), true);
            }
        }
        if (schemaTypeImplFindGlobalType == null) {
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
        }
        if (schemaTypeImplFindGlobalType != null && schemaTypeImplFindGlobalType.finalRestriction()) {
            stscState.error("derivation-ok-restriction.1", new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, (XmlObject) complexRestrictionType.xgetBase());
        }
        SchemaTypeImpl schemaTypeImpl2 = (schemaTypeImplFindGlobalType == null || StscResolver.resolveType(schemaTypeImplFindGlobalType)) ? schemaTypeImplFindGlobalType : null;
        ArrayList arrayList = new ArrayList();
        Group contentModel = getContentModel(complexRestrictionType);
        SchemaParticle schemaParticleTranslateContentModel = translateContentModel(schemaTypeImpl, contentModel, targetNamespace, z2, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), translateParticleCode(contentModel), arrayList, new LinkedHashMap(), $assertionsDisabled, null);
        boolean z3 = (schemaParticleTranslateContentModel == null || schemaParticleTranslateContentModel.getParticleType() != 1) ? $assertionsDisabled : true;
        if (schemaTypeImpl2 == null) {
            schemaAttributeModelImpl = new SchemaAttributeModelImpl();
        } else {
            schemaAttributeModelImpl = new SchemaAttributeModelImpl(schemaTypeImpl2.getAttributeModel());
        }
        SchemaAttributeModelImpl schemaAttributeModelImpl2 = schemaAttributeModelImpl;
        translateAttributeModel(complexRestrictionType, targetNamespace, z2, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl2, schemaTypeImpl2, $assertionsDisabled, null);
        WildcardResult wildcardResultSummarizeEltWildcards = summarizeEltWildcards(schemaParticleTranslateContentModel);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl2);
        if (schemaParticleTranslateContentModel != null) {
            buildStateMachine(schemaParticleTranslateContentModel);
            if (!StscState.get().noUpa() && !((SchemaParticleImpl) schemaParticleTranslateContentModel).isDeterministic()) {
                StscState.get().error("cos-nonambig", (Object[]) null, contentModel);
            }
        }
        Map mapBuildContentPropertyModelByQName = buildContentPropertyModelByQName(schemaParticleTranslateContentModel, schemaTypeImpl);
        Map mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl2, schemaTypeImpl);
        if (z) {
            i = 4;
        } else {
            i = schemaParticleTranslateContentModel == null ? 1 : 3;
        }
        schemaTypeImpl.setBaseTypeRef(schemaTypeImpl2.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImpl2.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        schemaTypeImpl.setComplexTypeVariety(i);
        schemaTypeImpl.setContentModel(schemaParticleTranslateContentModel, schemaAttributeModelImpl2, mapBuildContentPropertyModelByQName, mapBuildAttributePropertyModelByQName, z3);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(wildcardResultSummarizeEltWildcards.typedWildcards, wildcardResultSummarizeEltWildcards.hasWildcards, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
    }

    static Map extractElementModel(SchemaType schemaType) {
        HashMap map = new HashMap();
        if (schemaType != null) {
            SchemaProperty[] properties = schemaType.getProperties();
            for (int i = 0; i < properties.length; i++) {
                if (!properties[i].isAttribute()) {
                    map.put(properties[i].getName(), properties[i].getType());
                }
            }
        }
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:62:0x0174  */
    /* JADX WARN: Code duplicated, block: B:97:0x022d  */
    /* JADX WARN: Multi-variable type inference failed */
    static void resolveCcExtension(SchemaTypeImpl schemaTypeImpl, ExtensionType extensionType, boolean z) {
        SchemaTypeImpl schemaTypeImplFindGlobalType;
        SchemaType schemaType;
        boolean z2;
        SchemaParticle schemaParticle;
        SchemaAttributeModelImpl schemaAttributeModelImpl;
        int i;
        int i2;
        StscState stscState = StscState.get();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z3 = schemaTypeImpl.getChameleonNamespace() != null;
        if (extensionType.getBase() == null) {
            stscState.error("A complexContent must define a base type", 28, extensionType);
            schemaTypeImplFindGlobalType = null;
        } else {
            if (schemaTypeImpl.isRedefinition()) {
                schemaTypeImplFindGlobalType = stscState.findRedefinedGlobalType(extensionType.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (schemaTypeImplFindGlobalType != null && !schemaTypeImplFindGlobalType.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error("src-redefine.5b", new Object[]{"<complexType>", QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, extensionType);
                }
            } else {
                schemaTypeImplFindGlobalType = stscState.findGlobalType(extensionType.getBase(), schemaTypeImpl.getChameleonNamespace(), targetNamespace);
            }
            if (schemaTypeImplFindGlobalType == null) {
                stscState.notFoundError(extensionType.getBase(), 0, extensionType.xgetBase(), true);
            }
        }
        if (schemaTypeImplFindGlobalType != null && !StscResolver.resolveType(schemaTypeImplFindGlobalType)) {
            schemaTypeImplFindGlobalType = null;
        }
        if (schemaTypeImplFindGlobalType != null && schemaTypeImplFindGlobalType.isSimpleType()) {
            stscState.recover("src-ct.1", new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName())}, extensionType.xgetBase());
            schemaTypeImplFindGlobalType = null;
        }
        if (schemaTypeImplFindGlobalType != null && schemaTypeImplFindGlobalType.finalExtension()) {
            stscState.error("cos-ct-extends.1.1", new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, (XmlObject) extensionType.xgetBase());
        }
        SchemaParticle contentModel = schemaTypeImplFindGlobalType == null ? null : schemaTypeImplFindGlobalType.getContentModel();
        ArrayList arrayList = new ArrayList();
        Map mapExtractElementModel = extractElementModel(schemaTypeImplFindGlobalType);
        Group contentModel2 = getContentModel(extensionType);
        if (schemaTypeImplFindGlobalType == null || schemaTypeImplFindGlobalType.getContentType() != 2) {
            schemaType = schemaTypeImplFindGlobalType;
        } else if (contentModel2 == null) {
            resolveScExtensionPart2(schemaTypeImpl, schemaTypeImplFindGlobalType, extensionType, targetNamespace, z3);
            return;
        } else {
            stscState.recover("cos-ct-extends.1.4.1", new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName())}, extensionType.xgetBase());
            schemaType = null;
        }
        SchemaParticle schemaParticle2 = contentModel;
        boolean z4 = z3;
        SchemaParticle schemaParticleTranslateContentModel = translateContentModel(schemaTypeImpl, contentModel2, targetNamespace, z3, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), translateParticleCode(contentModel2), arrayList, mapExtractElementModel, $assertionsDisabled, null);
        if (schemaParticleTranslateContentModel != null || z) {
            z2 = z;
        } else {
            z2 = (schemaType == null || schemaType.getContentType() != 4) ? $assertionsDisabled : true;
        }
        if (schemaType == null || schemaType.getContentType() == 1) {
            schemaParticle = null;
        } else {
            if ((schemaType.getContentType() == 4 ? true : $assertionsDisabled) != z2) {
                schemaParticle = null;
                stscState.error("cos-ct-extends.1.4.2.2", (Object[]) null, (XmlObject) extensionType.xgetBase());
            } else {
                schemaParticle = null;
            }
        }
        if (schemaType != null && schemaType.hasAllContent() && schemaParticleTranslateContentModel != null) {
            stscState.error("Cannot extend a type with 'all' content model", 42, (XmlObject) extensionType.xgetBase());
            schemaParticleTranslateContentModel = schemaParticle;
        }
        SchemaParticle schemaParticleExtendContentModel = extendContentModel(schemaParticle2, schemaParticleTranslateContentModel, extensionType);
        boolean z5 = (schemaParticleExtendContentModel == null || schemaParticleExtendContentModel.getParticleType() != 1) ? $assertionsDisabled : true;
        if (schemaType == null) {
            schemaAttributeModelImpl = new SchemaAttributeModelImpl();
        } else {
            schemaAttributeModelImpl = new SchemaAttributeModelImpl(schemaType.getAttributeModel());
        }
        SchemaAttributeModelImpl schemaAttributeModelImpl2 = schemaAttributeModelImpl;
        Object[] objArr = schemaParticle;
        boolean z6 = z2;
        translateAttributeModel(extensionType, targetNamespace, z4, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl2, schemaType, true, null);
        WildcardResult wildcardResultSummarizeEltWildcards = summarizeEltWildcards(schemaParticleExtendContentModel);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl2);
        if (schemaParticleExtendContentModel != null) {
            buildStateMachine(schemaParticleExtendContentModel);
            if (!StscState.get().noUpa() && !((SchemaParticleImpl) schemaParticleExtendContentModel).isDeterministic()) {
                StscState.get().error("cos-nonambig", objArr, contentModel2);
            }
        }
        Map mapBuildContentPropertyModelByQName = buildContentPropertyModelByQName(schemaParticleExtendContentModel, schemaTypeImpl);
        Map mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl2, schemaTypeImpl);
        if (schemaParticleExtendContentModel == null && schemaType != null) {
            i = 2;
            if (schemaType.getContentType() == 2) {
                schemaTypeImpl.setContentBasedOnTypeRef(schemaType.getContentBasedOnType().getRef());
                i2 = 2;
            }
            if (schemaType == null) {
                schemaType = XmlObject.type;
            }
            schemaTypeImpl.setBaseTypeRef(schemaType.getRef());
            schemaTypeImpl.setBaseDepth(((SchemaTypeImpl) schemaType).getBaseDepth() + 1);
            schemaTypeImpl.setDerivationType(i);
            schemaTypeImpl.setComplexTypeVariety(i2);
            schemaTypeImpl.setContentModel(schemaParticleExtendContentModel, schemaAttributeModelImpl2, mapBuildContentPropertyModelByQName, mapBuildAttributePropertyModelByQName, z5);
            schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
            schemaTypeImpl.setWildcardSummary(wildcardResultSummarizeEltWildcards.typedWildcards, wildcardResultSummarizeEltWildcards.hasWildcards, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
        }
        i = 2;
        if (z6) {
            i2 = 4;
        } else {
            i2 = schemaParticleExtendContentModel == null ? 1 : 3;
        }
        if (schemaType == null) {
            schemaType = XmlObject.type;
        }
        schemaTypeImpl.setBaseTypeRef(schemaType.getRef());
        schemaTypeImpl.setBaseDepth(((SchemaTypeImpl) schemaType).getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(i);
        schemaTypeImpl.setComplexTypeVariety(i2);
        schemaTypeImpl.setContentModel(schemaParticleExtendContentModel, schemaAttributeModelImpl2, mapBuildContentPropertyModelByQName, mapBuildAttributePropertyModelByQName, z5);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(wildcardResultSummarizeEltWildcards.typedWildcards, wildcardResultSummarizeEltWildcards.hasWildcards, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
    }

    static void resolveScRestriction(SchemaTypeImpl schemaTypeImpl, SimpleRestrictionType simpleRestrictionType) {
        SchemaTypeImpl schemaTypeImplFindGlobalType;
        SchemaTypeImpl schemaTypeImpl2;
        SchemaAttributeModelImpl schemaAttributeModelImpl;
        StscState stscState = StscState.get();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z = schemaTypeImpl.getChameleonNamespace() != null;
        ArrayList arrayList = new ArrayList();
        SchemaTypeImpl schemaTypeImplTranslateAnonymousSimpleType = simpleRestrictionType.getSimpleType() != null ? StscTranslator.translateAnonymousSimpleType(simpleRestrictionType.getSimpleType(), targetNamespace, z, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl) : null;
        if (simpleRestrictionType.getBase() == null) {
            stscState.error("A simpleContent restriction must define a base type", 28, simpleRestrictionType);
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        } else {
            if (schemaTypeImpl.isRedefinition()) {
                schemaTypeImplFindGlobalType = stscState.findRedefinedGlobalType(simpleRestrictionType.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (schemaTypeImplFindGlobalType != null && !schemaTypeImplFindGlobalType.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error("src-redefine.5b", new Object[]{"<simpleType>", QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, simpleRestrictionType);
                }
            } else {
                schemaTypeImplFindGlobalType = stscState.findGlobalType(simpleRestrictionType.getBase(), schemaTypeImpl.getChameleonNamespace(), targetNamespace);
            }
            if (schemaTypeImplFindGlobalType == null) {
                stscState.notFoundError(simpleRestrictionType.getBase(), 0, simpleRestrictionType.xgetBase(), true);
                schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
            }
        }
        StscResolver.resolveType(schemaTypeImplFindGlobalType);
        if (schemaTypeImplTranslateAnonymousSimpleType != null) {
            StscResolver.resolveType(schemaTypeImplTranslateAnonymousSimpleType);
            schemaTypeImpl2 = schemaTypeImplTranslateAnonymousSimpleType;
        } else {
            schemaTypeImpl2 = schemaTypeImplFindGlobalType;
        }
        if (schemaTypeImplFindGlobalType.isSimpleType()) {
            stscState.recover("ct-props-correct.2", new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName())}, simpleRestrictionType);
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        } else if (schemaTypeImplFindGlobalType.getContentType() != 2 && schemaTypeImpl2 == null) {
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        SchemaTypeImpl schemaTypeImpl3 = schemaTypeImplFindGlobalType;
        if (schemaTypeImpl3 != null && schemaTypeImpl3.finalRestriction()) {
            stscState.error("derivation-ok-restriction.1", new Object[]{QNameHelper.pretty(schemaTypeImpl3.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, (XmlObject) simpleRestrictionType.xgetBase());
        }
        if (schemaTypeImpl3 == null) {
            schemaAttributeModelImpl = new SchemaAttributeModelImpl();
        } else {
            schemaAttributeModelImpl = new SchemaAttributeModelImpl(schemaTypeImpl3.getAttributeModel());
        }
        SchemaAttributeModelImpl schemaAttributeModelImpl2 = schemaAttributeModelImpl;
        SchemaTypeImpl schemaTypeImpl4 = schemaTypeImpl2;
        translateAttributeModel(simpleRestrictionType, targetNamespace, z, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl2, schemaTypeImpl3, $assertionsDisabled, null);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl2);
        Map mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl2, schemaTypeImpl);
        schemaTypeImpl.setBaseTypeRef(schemaTypeImpl3.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImpl3.getBaseDepth() + 1);
        schemaTypeImpl.setContentBasedOnTypeRef(schemaTypeImpl4.getRef());
        schemaTypeImpl.setDerivationType(1);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(QNameSet.EMPTY, $assertionsDisabled, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
        schemaTypeImpl.setComplexTypeVariety(2);
        schemaTypeImpl.setContentModel(null, schemaAttributeModelImpl2, null, mapBuildAttributePropertyModelByQName, $assertionsDisabled);
        schemaTypeImpl.setSimpleTypeVariety(schemaTypeImpl4.getSimpleVariety());
        schemaTypeImpl.setPrimitiveTypeRef(schemaTypeImpl4.getPrimitiveType() != null ? schemaTypeImpl4.getPrimitiveType().getRef() : null);
        int simpleVariety = schemaTypeImpl.getSimpleVariety();
        if (simpleVariety == 2) {
            schemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(Arrays.asList(schemaTypeImpl4.getUnionMemberTypes())));
        } else if (simpleVariety == 3) {
            schemaTypeImpl.setListItemTypeRef(schemaTypeImpl4.getListItemType().getRef());
        }
        StscSimpleTypeResolver.resolveFacets(schemaTypeImpl, simpleRestrictionType, schemaTypeImpl4);
        StscSimpleTypeResolver.resolveFundamentalFacets(schemaTypeImpl);
    }

    static void resolveScExtension(SchemaTypeImpl schemaTypeImpl, SimpleExtensionType simpleExtensionType) {
        SchemaTypeImpl schemaTypeImplFindGlobalType;
        StscState stscState = StscState.get();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z = schemaTypeImpl.getChameleonNamespace() != null;
        if (simpleExtensionType.getBase() == null) {
            stscState.error("A simpleContent extension must define a base type", 28, simpleExtensionType);
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        } else {
            if (schemaTypeImpl.isRedefinition()) {
                schemaTypeImplFindGlobalType = stscState.findRedefinedGlobalType(simpleExtensionType.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (schemaTypeImplFindGlobalType != null && !schemaTypeImplFindGlobalType.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error("src-redefine.5b", new Object[]{"<simpleType>", QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, simpleExtensionType);
                }
            } else {
                schemaTypeImplFindGlobalType = stscState.findGlobalType(simpleExtensionType.getBase(), schemaTypeImpl.getChameleonNamespace(), targetNamespace);
            }
            if (schemaTypeImplFindGlobalType == null) {
                stscState.notFoundError(simpleExtensionType.getBase(), 0, simpleExtensionType.xgetBase(), true);
                schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
            }
        }
        StscResolver.resolveType(schemaTypeImplFindGlobalType);
        if (!schemaTypeImplFindGlobalType.isSimpleType() && schemaTypeImplFindGlobalType.getContentType() != 2) {
            stscState.error("src-ct.2", new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName())}, simpleExtensionType);
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (schemaTypeImplFindGlobalType != null && schemaTypeImplFindGlobalType.finalExtension()) {
            stscState.error("cos-ct-extends.1.1", new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, (XmlObject) simpleExtensionType.xgetBase());
        }
        resolveScExtensionPart2(schemaTypeImpl, schemaTypeImplFindGlobalType, simpleExtensionType, targetNamespace, z);
    }

    static void resolveScExtensionPart2(SchemaTypeImpl schemaTypeImpl, SchemaType schemaType, ExtensionType extensionType, String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl(schemaType.getAttributeModel());
        translateAttributeModel(extensionType, str, z, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl, schemaType, true, null);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl);
        Map mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl);
        schemaTypeImpl.setBaseTypeRef(schemaType.getRef());
        SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) schemaType;
        schemaTypeImpl.setBaseDepth(schemaTypeImpl2.getBaseDepth() + 1);
        schemaTypeImpl.setContentBasedOnTypeRef(schemaType.getRef());
        schemaTypeImpl.setDerivationType(2);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(QNameSet.EMPTY, $assertionsDisabled, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
        schemaTypeImpl.setComplexTypeVariety(2);
        schemaTypeImpl.setContentModel(null, schemaAttributeModelImpl, null, mapBuildAttributePropertyModelByQName, $assertionsDisabled);
        schemaTypeImpl.setSimpleTypeVariety(schemaType.getSimpleVariety());
        schemaTypeImpl.setPrimitiveTypeRef(schemaType.getPrimitiveType() == null ? null : schemaType.getPrimitiveType().getRef());
        int simpleVariety = schemaTypeImpl.getSimpleVariety();
        if (simpleVariety == 2) {
            schemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(Arrays.asList(schemaType.getUnionMemberTypes())));
        } else if (simpleVariety == 3) {
            schemaTypeImpl.setListItemTypeRef(schemaType.getListItemType().getRef());
        }
        StscSimpleTypeResolver.resolveFacets(schemaTypeImpl, null, schemaTypeImpl2);
        StscSimpleTypeResolver.resolveFundamentalFacets(schemaTypeImpl);
    }

    static class WildcardResult {
        boolean hasWildcards;
        QNameSet typedWildcards;

        WildcardResult(QNameSet qNameSet, boolean z) {
            this.typedWildcards = qNameSet;
            this.hasWildcards = z;
        }
    }

    static WildcardResult summarizeAttrWildcards(SchemaAttributeModel schemaAttributeModel) {
        if (schemaAttributeModel.getWildcardProcess() == 0) {
            return new WildcardResult(QNameSet.EMPTY, $assertionsDisabled);
        }
        if (schemaAttributeModel.getWildcardProcess() == 3) {
            return new WildcardResult(QNameSet.EMPTY, true);
        }
        return new WildcardResult(schemaAttributeModel.getWildcardSet(), true);
    }

    static WildcardResult summarizeEltWildcards(SchemaParticle schemaParticle) {
        if (schemaParticle == null) {
            return new WildcardResult(QNameSet.EMPTY, $assertionsDisabled);
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType != 1 && particleType != 2 && particleType != 3) {
            if (particleType == 5) {
                return new WildcardResult(schemaParticle.getWildcardProcess() == 3 ? QNameSet.EMPTY : schemaParticle.getWildcardSet(), true);
            }
            return new WildcardResult(QNameSet.EMPTY, $assertionsDisabled);
        }
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
        boolean z = false;
        for (int i = 0; i < schemaParticle.countOfParticleChild(); i++) {
            WildcardResult wildcardResultSummarizeEltWildcards = summarizeEltWildcards(schemaParticle.getParticleChild(i));
            qNameSetBuilder.addAll(wildcardResultSummarizeEltWildcards.typedWildcards);
            z |= wildcardResultSummarizeEltWildcards.hasWildcards;
        }
        return new WildcardResult(qNameSetBuilder.toQNameSet(), z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x0085  */
    /* JADX WARN: Code duplicated, block: B:33:0x0093  */
    /* JADX WARN: Code duplicated, block: B:34:0x009a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x009c  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:60:0x0114  */
    /* JADX WARN: Code duplicated, block: B:61:0x011d  */
    /* JADX WARN: Code duplicated, block: B:63:0x0123  */
    /* JADX WARN: Code duplicated, block: B:66:0x013e  */
    /* JADX WARN: Code duplicated, block: B:68:0x0144  */
    /* JADX WARN: Code duplicated, block: B:70:0x014e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0150  */
    /* JADX WARN: Code duplicated, block: B:73:0x0153  */
    /* JADX WARN: Code duplicated, block: B:76:0x015e  */
    /* JADX WARN: Code duplicated, block: B:77:0x0161  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [org.apache.xmlbeans.impl.schema.StscState] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v3, types: [org.apache.xmlbeans.impl.schema.StscState] */
    /* JADX WARN: Type inference failed for: r4v4, types: [org.apache.xmlbeans.impl.schema.StscState] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v3 */
    static void translateAttributeModel(XmlObject xmlObject, String str, boolean z, String str2, List list, SchemaType schemaType, Set set, SchemaAttributeModelImpl schemaAttributeModelImpl, SchemaType schemaType2, boolean z2, SchemaAttributeGroupImpl schemaAttributeGroupImpl) {
        Set set2;
        int i;
        SchemaAttributeGroupImpl schemaAttributeGroupImplFindAttributeGroup;
        boolean z3;
        SchemaAttributeGroupImpl schemaAttributeGroupImpl2;
        String str3;
        ?? r9;
        SchemaAttributeGroupImpl schemaAttributeGroupImpl3;
        int i2;
        boolean z4;
        int iTranslateWildcardProcess;
        List list2 = list;
        SchemaAttributeModelImpl schemaAttributeModelImpl2 = schemaAttributeModelImpl;
        StscState stscState = StscState.get();
        Set hashSet = set == null ? new HashSet() : set;
        Object[] objArr = null;
        SchemaAttributeModel attributeModel = schemaType2 != null ? schemaType2.getAttributeModel() : null;
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        boolean firstChild = xmlCursorNewCursor.toFirstChild();
        int i3 = 0;
        boolean z5 = z;
        boolean z6 = false;
        boolean z7 = false;
        ?? r4 = stscState;
        while (firstChild) {
            switch (translateAttributeCode(xmlCursorNewCursor.getName())) {
                case 100:
                    Attribute attribute = (Attribute) xmlCursorNewCursor.getObject();
                    attributeModel = attributeModel;
                    set2 = hashSet;
                    ?? r22 = r4;
                    SchemaLocalAttributeImpl schemaLocalAttributeImplTranslateAttribute = StscTranslator.translateAttribute(attribute, str, str2, z5 ? 1 : 0, list, schemaType, attributeModel, true);
                    if (schemaLocalAttributeImplTranslateAttribute == null) {
                        list2 = list;
                        schemaAttributeModelImpl2 = schemaAttributeModelImpl;
                        r4 = r22;
                        z5 = z5;
                        z6 = z6;
                        i = 0;
                    } else if (!set2.contains(schemaLocalAttributeImplTranslateAttribute.getName())) {
                        r4 = r22;
                        i = 0;
                        set2.add(schemaLocalAttributeImplTranslateAttribute.getName());
                        if (attributeModel == null) {
                            schemaAttributeModelImpl2 = schemaAttributeModelImpl;
                        } else {
                            SchemaLocalAttribute attribute2 = attributeModel.getAttribute(schemaLocalAttributeImplTranslateAttribute.getName());
                            if (attribute2 == null) {
                                if (!z2 && !attributeModel.getWildcardSet().contains(schemaLocalAttributeImplTranslateAttribute.getName())) {
                                    r4.error("derivation-ok-restriction.2.2", new Object[]{QNameHelper.pretty(schemaLocalAttributeImplTranslateAttribute.getName()), QNameHelper.pretty(schemaType.getName())}, attribute);
                                }
                            } else if (z2) {
                                if (schemaLocalAttributeImplTranslateAttribute.getUse() == 1) {
                                    r4.error("An extension cannot prohibit an attribute from the base type; use restriction instead.", 37, attribute.xgetUse());
                                }
                            } else if (schemaLocalAttributeImplTranslateAttribute.getUse() != 3) {
                                if (attribute2.getUse() == 3) {
                                    r4.error("derivation-ok-restriction.2.1.1", new Object[]{QNameHelper.pretty(schemaLocalAttributeImplTranslateAttribute.getName()), QNameHelper.pretty(schemaType.getName())}, attribute);
                                }
                                if (schemaLocalAttributeImplTranslateAttribute.getUse() == 1) {
                                    schemaAttributeModelImpl2 = schemaAttributeModelImpl;
                                    schemaAttributeModelImpl2.removeProhibitedAttribute(schemaLocalAttributeImplTranslateAttribute.getName());
                                }
                            }
                            schemaAttributeModelImpl2 = schemaAttributeModelImpl;
                        }
                        if (schemaLocalAttributeImplTranslateAttribute.getUse() != 1) {
                            schemaAttributeModelImpl2.addAttribute(schemaLocalAttributeImplTranslateAttribute);
                            list2 = list;
                        } else {
                            SchemaType type = schemaLocalAttributeImplTranslateAttribute.getType();
                            list2 = list;
                            if (list2 != null && list2.contains(type)) {
                                list2.remove(type);
                            }
                        }
                        if (schemaLocalAttributeImplTranslateAttribute.getDefaultText() != null && !schemaLocalAttributeImplTranslateAttribute.isFixed() && schemaLocalAttributeImplTranslateAttribute.getUse() != 2) {
                            r4.error("src-attribute.2", new Object[]{QNameHelper.pretty(schemaLocalAttributeImplTranslateAttribute.getName())}, attribute);
                        }
                    } else {
                        i = 0;
                        r4 = r22;
                        r4.error("ct-props-correct.4", new Object[]{QNameHelper.pretty(schemaLocalAttributeImplTranslateAttribute.getName()), QNameHelper.pretty(schemaType.getName())}, attribute.xgetName());
                        list2 = list;
                        schemaAttributeModelImpl2 = schemaAttributeModelImpl;
                    }
                    break;
                case 101:
                    AttributeGroupRef attributeGroupRef = (AttributeGroupRef) xmlCursorNewCursor.getObject();
                    QName ref = attributeGroupRef.getRef();
                    if (ref == null) {
                        r4.error("Attribute group reference must have a ref attribute", 39, attributeGroupRef);
                        z4 = z6;
                    } else {
                        if (schemaAttributeGroupImpl != 0) {
                            schemaAttributeGroupImplFindAttributeGroup = r4.findRedefinedAttributeGroup(ref, z5 ? str : objArr, schemaAttributeGroupImpl);
                            if (schemaAttributeGroupImplFindAttributeGroup != null && schemaAttributeGroupImpl.getName().equals(schemaAttributeGroupImplFindAttributeGroup.getName())) {
                                if (z6) {
                                    Object[] objArr2 = new Object[1];
                                    objArr2[i3] = QNameHelper.pretty(schemaAttributeGroupImpl.getName());
                                    r4.error("src-redefine.7.1", objArr2, attributeGroupRef);
                                }
                                z3 = true;
                            }
                            schemaAttributeGroupImpl2 = schemaAttributeGroupImplFindAttributeGroup;
                            if (schemaAttributeGroupImpl2 == null) {
                                r4.notFoundError(ref, 4, attributeGroupRef.xgetRef(), true);
                            } else if (r4.isProcessing(schemaAttributeGroupImpl2)) {
                                Object[] objArr3 = new Object[1];
                                objArr3[i3] = QNameHelper.pretty(schemaAttributeGroupImpl2.getName());
                                r4.error("src-attribute_group.3", objArr3, schemaAttributeGroupImpl2.getParseObject());
                            } else {
                                if (schemaAttributeGroupImpl2.getTargetNamespace() != null) {
                                    String targetNamespace = schemaAttributeGroupImpl2.getTargetNamespace();
                                    if (schemaAttributeGroupImpl2.getChameleonNamespace() != null) {
                                        i2 = 1;
                                    } else {
                                        i2 = i3;
                                    }
                                    str3 = targetNamespace;
                                    r9 = i2;
                                } else {
                                    str3 = str;
                                    r9 = z5;
                                }
                                ?? r0 = r9;
                                r4.startProcessing(schemaAttributeGroupImpl2);
                                if (schemaAttributeGroupImpl2.isRedefinition()) {
                                    schemaAttributeGroupImpl3 = schemaAttributeGroupImpl2;
                                } else {
                                    schemaAttributeGroupImpl3 = null;
                                }
                                set2 = hashSet;
                                translateAttributeModel(schemaAttributeGroupImpl2.getParseObject(), str3, r0, schemaAttributeGroupImpl2.getFormDefault(), list, schemaType, set2, schemaAttributeModelImpl, schemaType2, z2, schemaAttributeGroupImpl3);
                                r4.finishProcessing(schemaAttributeGroupImpl2);
                                z5 = r0 == true ? 1 : 0;
                                attributeModel = attributeModel;
                                z6 = z3;
                                schemaAttributeModelImpl2 = schemaAttributeModelImpl2;
                                list2 = list2;
                                r4 = r4;
                                i = 0;
                            }
                            z4 = z3;
                        } else {
                            schemaAttributeGroupImplFindAttributeGroup = r4.findAttributeGroup(ref, z5 ? str : null, str);
                        }
                        z3 = z6;
                        schemaAttributeGroupImpl2 = schemaAttributeGroupImplFindAttributeGroup;
                        if (schemaAttributeGroupImpl2 == null) {
                            r4.notFoundError(ref, 4, attributeGroupRef.xgetRef(), true);
                        } else if (r4.isProcessing(schemaAttributeGroupImpl2)) {
                            Object[] objArr4 = new Object[1];
                            objArr4[i3] = QNameHelper.pretty(schemaAttributeGroupImpl2.getName());
                            r4.error("src-attribute_group.3", objArr4, schemaAttributeGroupImpl2.getParseObject());
                        } else {
                            if (schemaAttributeGroupImpl2.getTargetNamespace() != null) {
                                String targetNamespace2 = schemaAttributeGroupImpl2.getTargetNamespace();
                                if (schemaAttributeGroupImpl2.getChameleonNamespace() != null) {
                                    i2 = 1;
                                } else {
                                    i2 = i3;
                                }
                                str3 = targetNamespace2;
                                r9 = i2;
                            } else {
                                str3 = str;
                                r9 = z5;
                            }
                            ?? r1 = r9;
                            r4.startProcessing(schemaAttributeGroupImpl2);
                            if (schemaAttributeGroupImpl2.isRedefinition()) {
                                schemaAttributeGroupImpl3 = schemaAttributeGroupImpl2;
                            } else {
                                schemaAttributeGroupImpl3 = null;
                            }
                            set2 = hashSet;
                            translateAttributeModel(schemaAttributeGroupImpl2.getParseObject(), str3, r1, schemaAttributeGroupImpl2.getFormDefault(), list, schemaType, set2, schemaAttributeModelImpl, schemaType2, z2, schemaAttributeGroupImpl3);
                            r4.finishProcessing(schemaAttributeGroupImpl2);
                            z5 = r1 == true ? 1 : 0;
                            attributeModel = attributeModel;
                            z6 = z3;
                            schemaAttributeModelImpl2 = schemaAttributeModelImpl2;
                            list2 = list2;
                            r4 = r4;
                            i = 0;
                        }
                        z4 = z3;
                    }
                    z6 = z4;
                    z7 = z7;
                    int i4 = i3;
                    set2 = hashSet;
                    i = i4;
                    break;
                case 102:
                    Wildcard wildcard = (Wildcard) xmlCursorNewCursor.getObject();
                    if (z7) {
                        r4.error("Only one attribute wildcard allowed", 38, wildcard);
                        z4 = z6;
                        z6 = z4;
                        z7 = z7;
                    } else {
                        NamespaceList namespaceListXgetNamespace = wildcard.xgetNamespace();
                        String stringValue = namespaceListXgetNamespace == null ? "##any" : namespaceListXgetNamespace.getStringValue();
                        QNameSet qNameSetForWildcardNamespaceString = QNameSet.forWildcardNamespaceString(stringValue, str);
                        if (attributeModel != null && !z2) {
                            if (attributeModel.getWildcardSet() == null) {
                                r4.error("derivation-ok-restriction.4.1", objArr, wildcard);
                            } else if (!attributeModel.getWildcardSet().containsAll(qNameSetForWildcardNamespaceString)) {
                                Object[] objArr5 = new Object[1];
                                objArr5[i3] = stringValue;
                                r4.error("derivation-ok-restriction.4.2", objArr5, wildcard);
                            } else {
                                iTranslateWildcardProcess = translateWildcardProcess(wildcard.xgetProcessContents());
                                if (schemaAttributeModelImpl.getWildcardProcess() == 0) {
                                    schemaAttributeModelImpl2.setWildcardSet(qNameSetForWildcardNamespaceString);
                                    schemaAttributeModelImpl2.setWildcardProcess(iTranslateWildcardProcess);
                                } else if (z2) {
                                    schemaAttributeModelImpl2.setWildcardSet(qNameSetForWildcardNamespaceString.union(schemaAttributeModelImpl.getWildcardSet()));
                                    schemaAttributeModelImpl2.setWildcardProcess(iTranslateWildcardProcess);
                                } else {
                                    schemaAttributeModelImpl2.setWildcardSet(qNameSetForWildcardNamespaceString.intersect(schemaAttributeModelImpl.getWildcardSet()));
                                }
                            }
                        } else {
                            iTranslateWildcardProcess = translateWildcardProcess(wildcard.xgetProcessContents());
                            if (schemaAttributeModelImpl.getWildcardProcess() == 0) {
                                schemaAttributeModelImpl2.setWildcardSet(qNameSetForWildcardNamespaceString);
                                schemaAttributeModelImpl2.setWildcardProcess(iTranslateWildcardProcess);
                            } else if (z2) {
                                schemaAttributeModelImpl2.setWildcardSet(qNameSetForWildcardNamespaceString.union(schemaAttributeModelImpl.getWildcardSet()));
                                schemaAttributeModelImpl2.setWildcardProcess(iTranslateWildcardProcess);
                            } else {
                                schemaAttributeModelImpl2.setWildcardSet(qNameSetForWildcardNamespaceString.intersect(schemaAttributeModelImpl.getWildcardSet()));
                            }
                        }
                        attributeModel = attributeModel;
                        z7 = true;
                        z6 = z6;
                    }
                    int i5 = i3;
                    set2 = hashSet;
                    i = i5;
                    break;
                default:
                    z4 = z6;
                    z6 = z4;
                    z7 = z7;
                    int i6 = i3;
                    set2 = hashSet;
                    i = i6;
                    break;
            }
            firstChild = xmlCursorNewCursor.toNextSibling();
            list2 = list2;
            attributeModel = attributeModel;
            objArr = null;
            schemaAttributeModelImpl2 = schemaAttributeModelImpl2;
            Set set3 = set2;
            i3 = i;
            hashSet = set3;
            r4 = r4;
            z5 = z5;
            z6 = z6;
            z7 = z7;
        }
        SchemaAttributeModelImpl schemaAttributeModelImpl3 = schemaAttributeModelImpl2;
        int i7 = i3;
        if (z2 || z7) {
            return;
        }
        schemaAttributeModelImpl3.setWildcardSet(null);
        schemaAttributeModelImpl3.setWildcardProcess(i7);
    }

    static SchemaParticle extendContentModel(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, XmlObject xmlObject) {
        if (schemaParticle2 == null) {
            return schemaParticle;
        }
        if (schemaParticle == null) {
            return schemaParticle2;
        }
        SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
        schemaParticleImpl.setParticleType(3);
        ArrayList arrayList = new ArrayList();
        addMinusPointlessParticles(arrayList, schemaParticle, 3);
        addMinusPointlessParticles(arrayList, schemaParticle2, 3);
        schemaParticleImpl.setMinOccurs(BigInteger.ONE);
        schemaParticleImpl.setMaxOccurs(BigInteger.ONE);
        schemaParticleImpl.setParticleChildren((SchemaParticle[]) arrayList.toArray(new SchemaParticle[arrayList.size()]));
        return filterPointlessParticlesAndVerifyAllParticles(schemaParticleImpl, xmlObject);
    }

    static BigInteger extractMinOccurs(XmlNonNegativeInteger xmlNonNegativeInteger) {
        if (xmlNonNegativeInteger == null) {
            return BigInteger.ONE;
        }
        BigInteger bigIntegerValue = xmlNonNegativeInteger.getBigIntegerValue();
        return bigIntegerValue == null ? BigInteger.ONE : bigIntegerValue;
    }

    static BigInteger extractMaxOccurs(AllNNI allNNI) {
        if (allNNI == null) {
            return BigInteger.ONE;
        }
        if (allNNI.instanceType().getPrimitiveType().getBuiltinTypeCode() == 11) {
            return ((XmlInteger) allNNI).getBigIntegerValue();
        }
        return null;
    }

    private static class RedefinitionForGroup {
        private SchemaModelGroupImpl group;
        private boolean seenRedefinition = StscComplexTypeResolver.$assertionsDisabled;

        public RedefinitionForGroup(SchemaModelGroupImpl schemaModelGroupImpl) {
            this.group = schemaModelGroupImpl;
        }

        public SchemaModelGroupImpl getGroup() {
            return this.group;
        }

        public boolean isSeenRedefinition() {
            return this.seenRedefinition;
        }

        public void setSeenRedefinition(boolean z) {
            this.seenRedefinition = z;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x025c  */
    /* JADX WARN: Code duplicated, block: B:109:0x0280  */
    /* JADX WARN: Code duplicated, block: B:111:0x0289  */
    /* JADX WARN: Code duplicated, block: B:112:0x0291  */
    /* JADX WARN: Code duplicated, block: B:113:0x0294  */
    /* JADX WARN: Code duplicated, block: B:115:0x0298  */
    /* JADX WARN: Code duplicated, block: B:117:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:119:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:120:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:123:0x0309  */
    /* JADX WARN: Code duplicated, block: B:126:0x0311  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object[], org.apache.xmlbeans.SchemaParticle] */
    /* JADX WARN: Type inference failed for: r4v13 */
    static SchemaParticle translateContentModel(SchemaType schemaType, XmlObject xmlObject, String str, boolean z, String str2, String str3, int i, List list, Map map, boolean z2, RedefinitionForGroup redefinitionForGroup) {
        String elemFormDefault;
        String attFormDefault;
        SchemaModelGroupImpl schemaModelGroupImplFindModelGroup;
        SchemaParticleImpl schemaParticleImpl;
        BigInteger bigIntegerExtractMinOccurs;
        BigInteger bigIntegerExtractMaxOccurs;
        XmlObject xmlObject2;
        boolean z3;
        QNameSet qNameSetForWildcardNamespaceString;
        ?? r4;
        RedefinitionForGroup redefinitionForGroup2;
        SchemaModelGroupImpl schemaModelGroupImpl;
        SchemaParticleImpl schemaParticleImpl2;
        XmlCursor xmlCursorNewCursor;
        ArrayList arrayList;
        boolean firstChild;
        int iTranslateParticleCode;
        ArrayList arrayList2;
        SchemaParticleImpl schemaParticleImpl3;
        XmlObject xmlObject3 = xmlObject;
        String str4 = str;
        int iTranslateParticleCode2 = i;
        SchemaModelGroupImpl schemaModelGroupImpl2 = null;
        if (xmlObject3 == null || iTranslateParticleCode2 == 0) {
            return null;
        }
        StscState stscState = StscState.get();
        boolean z4 = $assertionsDisabled;
        if (iTranslateParticleCode2 == 4) {
            if (!z2) {
                stscState.error("Must be a sequence, choice or all here", 32, xmlObject3);
            }
            LocalElement localElement = (LocalElement) xmlObject3;
            SchemaLocalElementImpl schemaLocalElementImplTranslateElement = StscTranslator.translateElement(localElement, str, z, str2, str3, list, schemaType);
            if (schemaLocalElementImplTranslateElement == null) {
                return null;
            }
            bigIntegerExtractMinOccurs = extractMinOccurs(localElement.xgetMinOccurs());
            bigIntegerExtractMaxOccurs = extractMaxOccurs(localElement.xgetMaxOccurs());
            SchemaType schemaType2 = (SchemaType) map.get(schemaLocalElementImplTranslateElement.getName());
            if (schemaType2 == null) {
                map.put(schemaLocalElementImplTranslateElement.getName(), schemaLocalElementImplTranslateElement.getType());
            } else if (!schemaLocalElementImplTranslateElement.getType().equals(schemaType2)) {
                stscState.error("cos-element-consistent", new Object[]{QNameHelper.pretty(schemaLocalElementImplTranslateElement.getName())}, xmlObject3);
                return null;
            }
            schemaParticleImpl = schemaLocalElementImplTranslateElement;
        } else {
            if (iTranslateParticleCode2 == 5) {
                if (!z2) {
                    stscState.error("Must be a sequence, choice or all here", 32, xmlObject3);
                }
                AnyDocument.Any any = (AnyDocument.Any) xmlObject3;
                SchemaParticleImpl schemaParticleImpl4 = new SchemaParticleImpl();
                schemaParticleImpl4.setParticleType(5);
                NamespaceList namespaceListXgetNamespace = any.xgetNamespace();
                if (namespaceListXgetNamespace == null) {
                    qNameSetForWildcardNamespaceString = QNameSet.ALL;
                } else {
                    qNameSetForWildcardNamespaceString = QNameSet.forWildcardNamespaceString(namespaceListXgetNamespace.getStringValue(), str4);
                }
                schemaParticleImpl4.setWildcardSet(qNameSetForWildcardNamespaceString);
                schemaParticleImpl4.setWildcardProcess(translateWildcardProcess(any.xgetProcessContents()));
                bigIntegerExtractMinOccurs = extractMinOccurs(any.xgetMinOccurs());
                schemaParticleImpl = schemaParticleImpl4;
                bigIntegerExtractMaxOccurs = extractMaxOccurs(any.xgetMaxOccurs());
            } else {
                Group group = (Group) xmlObject3;
                SchemaParticleImpl schemaParticleImpl5 = new SchemaParticleImpl();
                BigInteger bigIntegerExtractMinOccurs2 = extractMinOccurs(group.xgetMinOccurs());
                BigInteger bigIntegerExtractMaxOccurs2 = extractMaxOccurs(group.xgetMaxOccurs());
                if (iTranslateParticleCode2 == 100) {
                    QName ref = group.getRef();
                    if (ref == null) {
                        stscState.error("Group reference must have a ref attribute", 33, xmlObject3);
                        return null;
                    }
                    if (redefinitionForGroup != null) {
                        schemaModelGroupImplFindModelGroup = stscState.findRedefinedModelGroup(ref, z ? str4 : null, redefinitionForGroup.getGroup());
                        if (schemaModelGroupImplFindModelGroup != null && schemaModelGroupImplFindModelGroup.getName().equals(redefinitionForGroup.getGroup().getName())) {
                            if (redefinitionForGroup.isSeenRedefinition()) {
                                stscState.error("src-redefine.6.1.1", new Object[]{QNameHelper.pretty(schemaModelGroupImplFindModelGroup.getName())}, xmlObject3);
                            }
                            if (!BigInteger.ONE.equals(bigIntegerExtractMaxOccurs2) || !BigInteger.ONE.equals(bigIntegerExtractMinOccurs2)) {
                                stscState.error("src-redefine.6.1.2", new Object[]{QNameHelper.pretty(schemaModelGroupImplFindModelGroup.getName())}, xmlObject3);
                            }
                            redefinitionForGroup.setSeenRedefinition(true);
                        }
                    } else {
                        schemaModelGroupImplFindModelGroup = stscState.findModelGroup(ref, z ? str4 : null, str4);
                    }
                    if (schemaModelGroupImplFindModelGroup == null) {
                        stscState.notFoundError(ref, 6, group.xgetRef(), true);
                        return null;
                    }
                    if (stscState.isProcessing(schemaModelGroupImplFindModelGroup)) {
                        stscState.error("mg-props-correct.2", new Object[]{QNameHelper.pretty(schemaModelGroupImplFindModelGroup.getName())}, schemaModelGroupImplFindModelGroup.getParseObject());
                        return null;
                    }
                    XmlCursor xmlCursorNewCursor2 = schemaModelGroupImplFindModelGroup.getParseObject().newCursor();
                    for (boolean firstChild2 = xmlCursorNewCursor2.toFirstChild(); firstChild2; firstChild2 = xmlCursorNewCursor2.toNextSibling()) {
                        iTranslateParticleCode2 = translateParticleCode(xmlCursorNewCursor2.getName());
                        if (iTranslateParticleCode2 != 0) {
                            xmlObject3 = (Group) xmlCursorNewCursor2.getObject();
                            break;
                        }
                    }
                    if (iTranslateParticleCode2 == 0) {
                        stscState.error("Model group " + QNameHelper.pretty(schemaModelGroupImplFindModelGroup.getName()) + " is empty", 32, schemaModelGroupImplFindModelGroup.getParseObject());
                        return null;
                    }
                    if (iTranslateParticleCode2 != 1 && iTranslateParticleCode2 != 3 && iTranslateParticleCode2 != 2) {
                        stscState.error("Model group " + QNameHelper.pretty(schemaModelGroupImplFindModelGroup.getName()) + " is not a sequence, all, or choice", 32, schemaModelGroupImplFindModelGroup.getParseObject());
                    }
                    String targetNamespace = schemaModelGroupImplFindModelGroup.getTargetNamespace();
                    if (targetNamespace != null) {
                        str4 = targetNamespace;
                    }
                    elemFormDefault = schemaModelGroupImplFindModelGroup.getElemFormDefault();
                    attFormDefault = schemaModelGroupImplFindModelGroup.getAttFormDefault();
                    if (schemaModelGroupImplFindModelGroup.getChameleonNamespace() != null) {
                        z4 = true;
                    }
                } else {
                    z4 = z;
                    elemFormDefault = str2;
                    attFormDefault = str3;
                    schemaModelGroupImplFindModelGroup = null;
                }
                if (iTranslateParticleCode2 == 1 || iTranslateParticleCode2 == 2 || iTranslateParticleCode2 == 3) {
                    schemaParticleImpl5.setParticleType(iTranslateParticleCode2);
                    str2 = elemFormDefault;
                    schemaParticleImpl = schemaParticleImpl5;
                    bigIntegerExtractMinOccurs = bigIntegerExtractMinOccurs2;
                    bigIntegerExtractMaxOccurs = bigIntegerExtractMaxOccurs2;
                    str3 = attFormDefault;
                    z = z4;
                    xmlObject2 = xmlObject3;
                    z3 = true;
                    str4 = str4;
                    schemaModelGroupImpl2 = schemaModelGroupImplFindModelGroup;
                } else {
                    throw new IllegalStateException();
                }
            }
            if (bigIntegerExtractMaxOccurs != null || bigIntegerExtractMinOccurs.compareTo(bigIntegerExtractMaxOccurs) <= 0) {
                r4 = 0;
            } else {
                r4 = 0;
                stscState.error("p-props-correct.2.1", (Object[]) null, xmlObject2);
                bigIntegerExtractMaxOccurs = bigIntegerExtractMinOccurs;
            }
            if (bigIntegerExtractMaxOccurs == null && bigIntegerExtractMaxOccurs.compareTo(BigInteger.ONE) < 0) {
                stscState.warning("p-props-correct.2.2", (Object[]) r4, xmlObject2);
                list.remove(schemaParticleImpl.getType());
                return r4;
            }
            schemaParticleImpl.setMinOccurs(bigIntegerExtractMinOccurs);
            schemaParticleImpl.setMaxOccurs(bigIntegerExtractMaxOccurs);
            if (schemaModelGroupImpl2 != null) {
                stscState.startProcessing(schemaModelGroupImpl2);
                if (schemaModelGroupImpl2.isRedefinition()) {
                    redefinitionForGroup2 = new RedefinitionForGroup(schemaModelGroupImpl2);
                } else {
                    redefinitionForGroup2 = null;
                }
            } else {
                redefinitionForGroup2 = redefinitionForGroup;
            }
            if (z3) {
                xmlCursorNewCursor = xmlObject2.newCursor();
                arrayList = new ArrayList();
                firstChild = xmlCursorNewCursor.toFirstChild();
                while (firstChild) {
                    iTranslateParticleCode = translateParticleCode(xmlCursorNewCursor.getName());
                    if (iTranslateParticleCode == 0) {
                        schemaParticleImpl3 = schemaParticleImpl;
                        arrayList2 = arrayList;
                    } else {
                        arrayList2 = arrayList;
                        schemaParticleImpl3 = schemaParticleImpl;
                        addMinusPointlessParticles(arrayList2, translateContentModel(schemaType, xmlCursorNewCursor.getObject(), str4, z, str2, str3, iTranslateParticleCode, list, map, true, redefinitionForGroup2), schemaParticleImpl3.getParticleType());
                    }
                    firstChild = xmlCursorNewCursor.toNextSibling();
                    schemaParticleImpl = schemaParticleImpl3;
                    schemaModelGroupImpl2 = schemaModelGroupImpl2;
                    arrayList = arrayList2;
                    str4 = str4;
                }
                schemaModelGroupImpl = schemaModelGroupImpl2;
                ArrayList arrayList3 = arrayList;
                schemaParticleImpl2 = schemaParticleImpl;
                schemaParticleImpl2.setParticleChildren((SchemaParticle[]) arrayList3.toArray(new SchemaParticle[arrayList3.size()]));
                xmlCursorNewCursor.dispose();
            } else {
                schemaModelGroupImpl = schemaModelGroupImpl2;
                schemaParticleImpl2 = schemaParticleImpl;
            }
            SchemaParticle schemaParticleFilterPointlessParticlesAndVerifyAllParticles = filterPointlessParticlesAndVerifyAllParticles(schemaParticleImpl2, xmlObject2);
            if (schemaModelGroupImpl != null) {
                stscState.finishProcessing(schemaModelGroupImpl);
            }
            return schemaParticleFilterPointlessParticlesAndVerifyAllParticles;
        }
        xmlObject2 = xmlObject3;
        z3 = false;
        if (bigIntegerExtractMaxOccurs != null) {
            r4 = 0;
        } else {
            r4 = 0;
        }
        if (bigIntegerExtractMaxOccurs == null) {
        }
        schemaParticleImpl.setMinOccurs(bigIntegerExtractMinOccurs);
        schemaParticleImpl.setMaxOccurs(bigIntegerExtractMaxOccurs);
        if (schemaModelGroupImpl2 != null) {
            stscState.startProcessing(schemaModelGroupImpl2);
            if (schemaModelGroupImpl2.isRedefinition()) {
                redefinitionForGroup2 = new RedefinitionForGroup(schemaModelGroupImpl2);
            } else {
                redefinitionForGroup2 = null;
            }
        } else {
            redefinitionForGroup2 = redefinitionForGroup;
        }
        if (z3) {
            xmlCursorNewCursor = xmlObject2.newCursor();
            arrayList = new ArrayList();
            firstChild = xmlCursorNewCursor.toFirstChild();
            while (firstChild) {
                iTranslateParticleCode = translateParticleCode(xmlCursorNewCursor.getName());
                if (iTranslateParticleCode == 0) {
                    schemaParticleImpl3 = schemaParticleImpl;
                    arrayList2 = arrayList;
                } else {
                    arrayList2 = arrayList;
                    schemaParticleImpl3 = schemaParticleImpl;
                    addMinusPointlessParticles(arrayList2, translateContentModel(schemaType, xmlCursorNewCursor.getObject(), str4, z, str2, str3, iTranslateParticleCode, list, map, true, redefinitionForGroup2), schemaParticleImpl3.getParticleType());
                }
                firstChild = xmlCursorNewCursor.toNextSibling();
                schemaParticleImpl = schemaParticleImpl3;
                schemaModelGroupImpl2 = schemaModelGroupImpl2;
                arrayList = arrayList2;
                str4 = str4;
            }
            schemaModelGroupImpl = schemaModelGroupImpl2;
            ArrayList arrayList4 = arrayList;
            schemaParticleImpl2 = schemaParticleImpl;
            schemaParticleImpl2.setParticleChildren((SchemaParticle[]) arrayList4.toArray(new SchemaParticle[arrayList4.size()]));
            xmlCursorNewCursor.dispose();
        } else {
            schemaModelGroupImpl = schemaModelGroupImpl2;
            schemaParticleImpl2 = schemaParticleImpl;
        }
        SchemaParticle schemaParticleFilterPointlessParticlesAndVerifyAllParticles2 = filterPointlessParticlesAndVerifyAllParticles(schemaParticleImpl2, xmlObject2);
        if (schemaModelGroupImpl != null) {
            stscState.finishProcessing(schemaModelGroupImpl);
        }
        return schemaParticleFilterPointlessParticlesAndVerifyAllParticles2;
    }

    static int translateWildcardProcess(Wildcard.ProcessContents processContents) {
        if (processContents == null) {
            return 1;
        }
        String stringValue = processContents.getStringValue();
        if ("lax".equals(stringValue)) {
            return 2;
        }
        return "skip".equals(stringValue) ? 3 : 1;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x005a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x005b  */
    static SchemaParticle filterPointlessParticlesAndVerifyAllParticles(SchemaParticle schemaParticle, XmlObject xmlObject) {
        if (schemaParticle.getMaxOccurs() != null && schemaParticle.getMaxOccurs().signum() == 0) {
            return null;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1) {
            if (schemaParticle.getParticleChildren().length == 0) {
                return null;
            }
            if (schemaParticle.isSingleton() && schemaParticle.countOfParticleChild() == 1) {
                return schemaParticle.getParticleChild(0);
            }
        } else if (particleType != 2) {
            if (particleType != 3) {
                if (particleType == 4 || particleType == 5) {
                    return schemaParticle;
                }
                throw new IllegalStateException();
            }
            if (schemaParticle.getParticleChildren().length == 0) {
                return null;
            }
            if (schemaParticle.isSingleton()) {
                return schemaParticle.getParticleChild(0);
            }
        } else {
            if (schemaParticle.getParticleChildren().length == 0 && schemaParticle.getMinOccurs().compareTo(BigInteger.ZERO) == 0) {
                return null;
            }
            if (schemaParticle.isSingleton() && schemaParticle.countOfParticleChild() == 1) {
                return schemaParticle.getParticleChild(0);
            }
        }
        boolean z = schemaParticle.getParticleType() == 1;
        if (z && (schemaParticle.getMaxOccurs() == null || schemaParticle.getMaxOccurs().compareTo(BigInteger.ONE) > 0)) {
            StscState.get().error("cos-all-limited.1.2a", (Object[]) null, xmlObject);
        }
        for (int i = 0; i < schemaParticle.countOfParticleChild(); i++) {
            SchemaParticle particleChild = schemaParticle.getParticleChild(i);
            if (particleChild.getParticleType() == 1) {
                StscState.get().error("cos-all-limited.1.2b", (Object[]) null, xmlObject);
            } else if (z && (particleChild.getParticleType() != 4 || particleChild.getMaxOccurs() == null || particleChild.getMaxOccurs().compareTo(BigInteger.ONE) > 0)) {
                StscState.get().error("cos-all-limited.2", (Object[]) null, xmlObject);
            }
        }
        return schemaParticle;
    }

    static void addMinusPointlessParticles(List list, SchemaParticle schemaParticle, int i) {
        if (schemaParticle == null) {
            return;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType != 2) {
            if (particleType == 3 && i == 3 && schemaParticle.isSingleton()) {
                list.addAll(Arrays.asList(schemaParticle.getParticleChildren()));
                return;
            }
        } else if (i == 2 && schemaParticle.isSingleton()) {
            list.addAll(Arrays.asList(schemaParticle.getParticleChildren()));
            return;
        }
        list.add(schemaParticle);
    }

    static Map buildAttributePropertyModelByQName(SchemaAttributeModel schemaAttributeModel, SchemaType schemaType) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SchemaField[] attributes = schemaAttributeModel.getAttributes();
        for (int i = 0; i < attributes.length; i++) {
            linkedHashMap.put(attributes[i].getName(), buildUseProperty(attributes[i], schemaType));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002e  */
    static Map buildContentPropertyModelByQName(SchemaParticle schemaParticle, SchemaType schemaType) {
        Map linkedHashMap;
        if (schemaParticle == null) {
            return Collections.EMPTY_MAP;
        }
        int particleType = schemaParticle.getParticleType();
        boolean z = true;
        if (particleType == 1) {
            linkedHashMap = null;
        } else {
            if (particleType == 2) {
                linkedHashMap = null;
            } else if (particleType == 3) {
                linkedHashMap = null;
            } else if (particleType == 4) {
                linkedHashMap = buildElementPropertyModel((SchemaLocalElement) schemaParticle, schemaType);
            } else if (particleType == 5) {
                linkedHashMap = Collections.EMPTY_MAP;
            } else {
                throw new IllegalStateException();
            }
            z = false;
        }
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap();
            for (SchemaParticle schemaParticle2 : schemaParticle.getParticleChildren()) {
                for (SchemaProperty schemaProperty : buildContentPropertyModelByQName(schemaParticle2, schemaType).values()) {
                    SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl) linkedHashMap.get(schemaProperty.getName());
                    if (schemaPropertyImpl == null) {
                        if (!z) {
                            ((SchemaPropertyImpl) schemaProperty).setMinOccurs(BigInteger.ZERO);
                        }
                        linkedHashMap.put(schemaProperty.getName(), schemaProperty);
                    } else {
                        mergeProperties(schemaPropertyImpl, schemaProperty, z);
                    }
                }
            }
            BigInteger minOccurs = schemaParticle.getMinOccurs();
            BigInteger maxOccurs = schemaParticle.getMaxOccurs();
            for (SchemaProperty schemaProperty2 : linkedHashMap.values()) {
                BigInteger minOccurs2 = schemaProperty2.getMinOccurs();
                BigInteger maxOccurs2 = schemaProperty2.getMaxOccurs();
                BigInteger bigIntegerMultiply = minOccurs2.multiply(minOccurs);
                if (maxOccurs != null && maxOccurs.equals(BigInteger.ZERO)) {
                    maxOccurs2 = BigInteger.ZERO;
                } else if (maxOccurs2 != null && !maxOccurs2.equals(BigInteger.ZERO)) {
                    maxOccurs2 = maxOccurs == null ? null : maxOccurs2.multiply(maxOccurs);
                }
                SchemaPropertyImpl schemaPropertyImpl2 = (SchemaPropertyImpl) schemaProperty2;
                schemaPropertyImpl2.setMinOccurs(bigIntegerMultiply);
                schemaPropertyImpl2.setMaxOccurs(maxOccurs2);
            }
        }
        return linkedHashMap;
    }

    static Map buildElementPropertyModel(SchemaLocalElement schemaLocalElement, SchemaType schemaType) {
        HashMap map = new HashMap(1);
        SchemaProperty schemaPropertyBuildUseProperty = buildUseProperty(schemaLocalElement, schemaType);
        map.put(schemaPropertyBuildUseProperty.getName(), schemaPropertyBuildUseProperty);
        return map;
    }

    static SchemaProperty buildUseProperty(SchemaField schemaField, SchemaType schemaType) {
        SchemaPropertyImpl schemaPropertyImpl = new SchemaPropertyImpl();
        schemaPropertyImpl.setName(schemaField.getName());
        schemaPropertyImpl.setContainerTypeRef(schemaType.getRef());
        schemaPropertyImpl.setTypeRef(schemaField.getType().getRef());
        schemaPropertyImpl.setAttribute(schemaField.isAttribute());
        schemaPropertyImpl.setDefault(schemaField.isDefault() ? 2 : 0);
        schemaPropertyImpl.setFixed(schemaField.isFixed() ? 2 : 0);
        schemaPropertyImpl.setNillable(schemaField.isNillable() ? 2 : 0);
        schemaPropertyImpl.setDefaultText(schemaField.getDefaultText());
        schemaPropertyImpl.setMinOccurs(schemaField.getMinOccurs());
        schemaPropertyImpl.setMaxOccurs(schemaField.getMaxOccurs());
        if (schemaField instanceof SchemaLocalElementImpl) {
            schemaPropertyImpl.setAcceptedNames(((SchemaLocalElementImpl) schemaField).acceptedStartNames());
        }
        return schemaPropertyImpl;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001b A[PHI: r5
  0x001b: PHI (r5v11 java.math.BigInteger) = (r5v2 java.math.BigInteger), (r5v13 java.math.BigInteger) binds: [B:14:0x0035, B:7:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    static void mergeProperties(SchemaPropertyImpl schemaPropertyImpl, SchemaProperty schemaProperty, boolean z) {
        BigInteger bigIntegerMin;
        BigInteger bigIntegerMax;
        BigInteger minOccurs = schemaPropertyImpl.getMinOccurs();
        BigInteger maxOccurs = schemaPropertyImpl.getMaxOccurs();
        if (z) {
            bigIntegerMin = minOccurs.add(schemaProperty.getMinOccurs());
            if (maxOccurs != null) {
                if (schemaProperty.getMaxOccurs() == null) {
                    maxOccurs = null;
                } else {
                    bigIntegerMax = maxOccurs.add(schemaProperty.getMaxOccurs());
                    maxOccurs = bigIntegerMax;
                }
            }
        } else {
            bigIntegerMin = minOccurs.min(schemaProperty.getMinOccurs());
            if (maxOccurs != null) {
                if (schemaProperty.getMaxOccurs() == null) {
                    maxOccurs = null;
                } else {
                    bigIntegerMax = maxOccurs.max(schemaProperty.getMaxOccurs());
                    maxOccurs = bigIntegerMax;
                }
            }
        }
        schemaPropertyImpl.setMinOccurs(bigIntegerMin);
        schemaPropertyImpl.setMaxOccurs(maxOccurs);
        if (schemaProperty.hasNillable() != schemaPropertyImpl.hasNillable()) {
            schemaPropertyImpl.setNillable(1);
        }
        if (schemaProperty.hasDefault() != schemaPropertyImpl.hasDefault()) {
            schemaPropertyImpl.setDefault(1);
        }
        if (schemaProperty.hasFixed() != schemaPropertyImpl.hasFixed()) {
            schemaPropertyImpl.setFixed(1);
        }
        if (schemaPropertyImpl.getDefaultText() != null) {
            if (schemaProperty.getDefaultText() == null || !schemaPropertyImpl.getDefaultText().equals(schemaProperty.getDefaultText())) {
                schemaPropertyImpl.setDefaultText(null);
            }
        }
    }

    static SchemaParticle[] ensureStateMachine(SchemaParticle[] schemaParticleArr) {
        for (SchemaParticle schemaParticle : schemaParticleArr) {
            buildStateMachine(schemaParticle);
        }
        return schemaParticleArr;
    }

    static void buildStateMachine(SchemaParticle schemaParticle) {
        boolean zAfterMapSubsumedByStartMap;
        boolean z;
        if (schemaParticle == null) {
            return;
        }
        SchemaParticleImpl schemaParticleImpl = (SchemaParticleImpl) schemaParticle;
        if (schemaParticleImpl.hasTransitionNotes()) {
            return;
        }
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
        QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder();
        int iSignum = schemaParticleImpl.getMinOccurs().signum();
        boolean z2 = $assertionsDisabled;
        boolean z3 = iSignum == 0;
        int particleType = schemaParticleImpl.getParticleType();
        if (particleType != 1) {
            if (particleType == 2) {
                SchemaParticle[] schemaParticleArrEnsureStateMachine = ensureStateMachine(schemaParticleImpl.getParticleChildren());
                z = false;
                for (int i = 0; !z && i < schemaParticleArrEnsureStateMachine.length; i++) {
                    if (schemaParticleArrEnsureStateMachine[i].isSkippable()) {
                        z = true;
                    }
                }
                zAfterMapSubsumedByStartMap = true;
                for (int i2 = 0; zAfterMapSubsumedByStartMap && i2 < schemaParticleArrEnsureStateMachine.length; i2++) {
                    if (!((SchemaParticleImpl) schemaParticleArrEnsureStateMachine[i2]).isDeterministic()) {
                        zAfterMapSubsumedByStartMap = false;
                    }
                }
                for (int i3 = 0; i3 < schemaParticleArrEnsureStateMachine.length; i3++) {
                    if (zAfterMapSubsumedByStartMap && !qNameSetBuilder.isDisjoint(schemaParticleArrEnsureStateMachine[i3].acceptedStartNames())) {
                        zAfterMapSubsumedByStartMap = false;
                    }
                    qNameSetBuilder.addAll(schemaParticleArrEnsureStateMachine[i3].acceptedStartNames());
                    qNameSetBuilder2.addAll(((SchemaParticleImpl) schemaParticleArrEnsureStateMachine[i3]).getExcludeNextSet());
                }
            } else if (particleType != 3) {
                if (particleType != 4) {
                    if (particleType == 5) {
                        qNameSetBuilder.addAll(schemaParticleImpl.getWildcardSet());
                    } else {
                        throw new IllegalStateException("Unrecognized schema particle");
                    }
                } else if (schemaParticleImpl.hasTransitionRules()) {
                    qNameSetBuilder.addAll(schemaParticleImpl.acceptedStartNames());
                } else {
                    qNameSetBuilder.add(schemaParticleImpl.getName());
                }
                zAfterMapSubsumedByStartMap = true;
            } else {
                SchemaParticle[] schemaParticleArrEnsureStateMachine2 = ensureStateMachine(schemaParticleImpl.getParticleChildren());
                z = true;
                for (int i4 = 0; z && i4 < schemaParticleArrEnsureStateMachine2.length; i4++) {
                    if (!schemaParticleArrEnsureStateMachine2[i4].isSkippable()) {
                        z = false;
                    }
                }
                zAfterMapSubsumedByStartMap = true;
                for (int i5 = 0; zAfterMapSubsumedByStartMap && i5 < schemaParticleArrEnsureStateMachine2.length; i5++) {
                    if (!((SchemaParticleImpl) schemaParticleArrEnsureStateMachine2[i5]).isDeterministic()) {
                        zAfterMapSubsumedByStartMap = false;
                    }
                }
                for (int i6 = 1; i6 < schemaParticleArrEnsureStateMachine2.length; i6++) {
                    qNameSetBuilder2.addAll(((SchemaParticleImpl) schemaParticleArrEnsureStateMachine2[i6 - 1]).getExcludeNextSet());
                    if (zAfterMapSubsumedByStartMap && !qNameSetBuilder2.isDisjoint(schemaParticleArrEnsureStateMachine2[i6].acceptedStartNames())) {
                        zAfterMapSubsumedByStartMap = false;
                    }
                    if (schemaParticleArrEnsureStateMachine2[i6].isSkippable()) {
                        qNameSetBuilder2.addAll(schemaParticleArrEnsureStateMachine2[i6].acceptedStartNames());
                    } else {
                        qNameSetBuilder2.clear();
                    }
                }
                for (int i7 = 0; i7 < schemaParticleArrEnsureStateMachine2.length; i7++) {
                    qNameSetBuilder.addAll(schemaParticleArrEnsureStateMachine2[i7].acceptedStartNames());
                    if (!schemaParticleArrEnsureStateMachine2[i7].isSkippable()) {
                        break;
                    }
                }
            }
            z3 = z;
        } else {
            SchemaParticle[] schemaParticleArrEnsureStateMachine3 = ensureStateMachine(schemaParticleImpl.getParticleChildren());
            boolean z4 = true;
            for (int i8 = 0; z4 && i8 < schemaParticleArrEnsureStateMachine3.length; i8++) {
                if (!((SchemaParticleImpl) schemaParticleArrEnsureStateMachine3[i8]).isDeterministic()) {
                    z4 = false;
                }
            }
            zAfterMapSubsumedByStartMap = z4;
            for (int i9 = 0; i9 < schemaParticleArrEnsureStateMachine3.length; i9++) {
                if (zAfterMapSubsumedByStartMap && !qNameSetBuilder.isDisjoint(schemaParticleArrEnsureStateMachine3[i9].acceptedStartNames())) {
                    zAfterMapSubsumedByStartMap = false;
                }
                qNameSetBuilder.addAll(schemaParticleArrEnsureStateMachine3[i9].acceptedStartNames());
                qNameSetBuilder2.addAll(((SchemaParticleImpl) schemaParticleArrEnsureStateMachine3[i9]).getExcludeNextSet());
            }
            qNameSetBuilder2.addAll(qNameSetBuilder);
            z3 = true;
        }
        BigInteger minOccurs = schemaParticleImpl.getMinOccurs();
        BigInteger maxOccurs = schemaParticleImpl.getMaxOccurs();
        boolean z5 = maxOccurs == null || maxOccurs.compareTo(BigInteger.ONE) > 0;
        boolean z6 = maxOccurs == null || minOccurs.compareTo(maxOccurs) < 0;
        if (z5 && zAfterMapSubsumedByStartMap && !qNameSetBuilder2.isDisjoint(qNameSetBuilder)) {
            QNameSet qNameSetIntersect = qNameSetBuilder2.intersect(qNameSetBuilder);
            HashMap map = new HashMap();
            particlesMatchingStart(schemaParticleImpl, qNameSetIntersect, map, new QNameSetBuilder());
            HashMap map2 = new HashMap();
            particlesMatchingAfter(schemaParticleImpl, qNameSetIntersect, map2, new QNameSetBuilder(), true);
            zAfterMapSubsumedByStartMap = afterMapSubsumedByStartMap(map, map2);
        }
        if (z6) {
            qNameSetBuilder2.addAll(qNameSetBuilder);
        }
        if (z3 || minOccurs.signum() == 0) {
            z2 = true;
        }
        schemaParticleImpl.setTransitionRules(qNameSetBuilder.toQNameSet(), z2);
        schemaParticleImpl.setTransitionNotes(qNameSetBuilder2.toQNameSet(), zAfterMapSubsumedByStartMap);
    }

    private static boolean afterMapSubsumedByStartMap(Map map, Map map2) {
        if (map2.size() > map.size()) {
            return $assertionsDisabled;
        }
        if (map2.isEmpty()) {
            return true;
        }
        for (SchemaParticle schemaParticle : map.keySet()) {
            if (schemaParticle.getParticleType() == 5 && map2.containsKey(schemaParticle) && !((QNameSet) map.get(schemaParticle)).containsAll((QNameSet) map2.get(schemaParticle))) {
                return $assertionsDisabled;
            }
            map2.remove(schemaParticle);
            if (map2.isEmpty()) {
                return true;
            }
        }
        return map2.isEmpty();
    }

    private static void particlesMatchingStart(SchemaParticle schemaParticle, QNameSetSpecification qNameSetSpecification, Map map, QNameSetBuilder qNameSetBuilder) {
        int particleType = schemaParticle.getParticleType();
        int i = 0;
        if (particleType == 1 || particleType == 2) {
            SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
            while (i < particleChildren.length) {
                particlesMatchingStart(particleChildren[i], qNameSetSpecification, map, qNameSetBuilder);
                i++;
            }
            return;
        }
        if (particleType != 3) {
            if (particleType == 4) {
                if (qNameSetSpecification.contains(schemaParticle.getName())) {
                    map.put(schemaParticle, null);
                    qNameSetBuilder.add(schemaParticle.getName());
                    return;
                }
                return;
            }
            if (particleType == 5 && !qNameSetSpecification.isDisjoint(schemaParticle.getWildcardSet())) {
                map.put(schemaParticle, schemaParticle.getWildcardSet().intersect(qNameSetSpecification));
                qNameSetBuilder.addAll(schemaParticle.getWildcardSet());
                return;
            }
            return;
        }
        SchemaParticle[] particleChildren2 = schemaParticle.getParticleChildren();
        if (particleChildren2.length == 0) {
            return;
        }
        if (!particleChildren2[0].isSkippable()) {
            particlesMatchingStart(particleChildren2[0], qNameSetSpecification, map, qNameSetBuilder);
            return;
        }
        QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder(qNameSetSpecification);
        QNameSetBuilder qNameSetBuilder3 = new QNameSetBuilder();
        while (i < particleChildren2.length) {
            particlesMatchingStart(particleChildren2[i], qNameSetBuilder2, map, qNameSetBuilder3);
            qNameSetBuilder.addAll(qNameSetBuilder3);
            if (!particleChildren2[i].isSkippable()) {
                return;
            }
            qNameSetBuilder2.removeAll(qNameSetBuilder3);
            if (qNameSetBuilder2.isEmpty()) {
                return;
            }
            qNameSetBuilder3.clear();
            i++;
        }
    }

    private static void particlesMatchingAfter(SchemaParticle schemaParticle, QNameSetSpecification qNameSetSpecification, Map map, QNameSetBuilder qNameSetBuilder, boolean z) {
        int particleType = schemaParticle.getParticleType();
        boolean z2 = true;
        if (particleType == 1 || particleType == 2) {
            for (SchemaParticle schemaParticle2 : schemaParticle.getParticleChildren()) {
                particlesMatchingAfter(schemaParticle2, qNameSetSpecification, map, qNameSetBuilder, $assertionsDisabled);
            }
        } else if (particleType == 3) {
            SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
            if (particleChildren.length != 0) {
                if (!particleChildren[particleChildren.length - 1].isSkippable()) {
                    particlesMatchingAfter(particleChildren[0], qNameSetSpecification, map, qNameSetBuilder, $assertionsDisabled);
                } else {
                    QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder(qNameSetSpecification);
                    QNameSetBuilder qNameSetBuilder3 = new QNameSetBuilder();
                    for (int length = particleChildren.length - 1; length >= 0; length--) {
                        particlesMatchingAfter(particleChildren[length], qNameSetBuilder2, map, qNameSetBuilder3, $assertionsDisabled);
                        qNameSetBuilder.addAll(qNameSetBuilder3);
                        if (!particleChildren[length].isSkippable()) {
                            break;
                        }
                        qNameSetBuilder2.removeAll(qNameSetBuilder3);
                        if (qNameSetBuilder2.isEmpty()) {
                            break;
                        }
                        qNameSetBuilder3.clear();
                    }
                }
            }
        }
        if (z) {
            return;
        }
        BigInteger minOccurs = schemaParticle.getMinOccurs();
        BigInteger maxOccurs = schemaParticle.getMaxOccurs();
        if (maxOccurs != null && minOccurs.compareTo(maxOccurs) >= 0) {
            z2 = false;
        }
        if (z2) {
            particlesMatchingStart(schemaParticle, qNameSetSpecification, map, qNameSetBuilder);
        }
    }

    private static class CodeForNameEntry {
        public int code;
        public QName name;

        CodeForNameEntry(QName qName, int i) {
            this.name = qName;
            this.code = i;
        }
    }

    private static Map buildParticleCodeMap() {
        HashMap map = new HashMap();
        int i = 0;
        while (true) {
            CodeForNameEntry[] codeForNameEntryArr = particleCodes;
            if (i >= codeForNameEntryArr.length) {
                return map;
            }
            map.put(codeForNameEntryArr[i].name, new Integer(particleCodes[i].code));
            i++;
        }
    }

    private static int translateParticleCode(Group group) {
        if (group == null) {
            return 0;
        }
        return translateParticleCode(group.newCursor().getName());
    }

    private static int translateParticleCode(QName qName) {
        Integer num = (Integer) particleCodeMap.get(qName);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static Map buildAttributeCodeMap() {
        HashMap map = new HashMap();
        int i = 0;
        while (true) {
            CodeForNameEntry[] codeForNameEntryArr = attributeCodes;
            if (i >= codeForNameEntryArr.length) {
                return map;
            }
            map.put(codeForNameEntryArr[i].name, new Integer(attributeCodes[i].code));
            i++;
        }
    }

    static int translateAttributeCode(QName qName) {
        Integer num = (Integer) attributeCodeMap.get(qName);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }
}
