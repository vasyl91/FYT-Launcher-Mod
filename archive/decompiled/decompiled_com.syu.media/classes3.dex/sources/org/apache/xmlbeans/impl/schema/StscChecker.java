package org.apache.xmlbeans.impl.schema;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlNOTATION;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.XBeanDebug;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class StscChecker {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static void checkAll() {
        StscState stscState = StscState.get();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(stscState.documentTypes()));
        arrayList.addAll(Arrays.asList(stscState.attributeTypes()));
        arrayList.addAll(Arrays.asList(stscState.redefinedGlobalTypes()));
        arrayList.addAll(Arrays.asList(stscState.globalTypes()));
        for (int i = 0; i < arrayList.size(); i++) {
            SchemaType schemaType = (SchemaType) arrayList.get(i);
            if (!stscState.noPvr() && !schemaType.isDocumentType()) {
                checkRestriction((SchemaTypeImpl) schemaType);
            }
            checkFields((SchemaTypeImpl) schemaType);
            arrayList.addAll(Arrays.asList(schemaType.getAnonymousTypes()));
        }
        checkSubstitutionGroups(stscState.globalElements());
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:53:0x0100  */
    public static void checkFields(SchemaTypeImpl schemaTypeImpl) {
        boolean z;
        if (schemaTypeImpl.isSimpleType()) {
            return;
        }
        XmlObject parseObject = schemaTypeImpl.getParseObject();
        SchemaAttributeModel attributeModel = schemaTypeImpl.getAttributeModel();
        if (attributeModel != null) {
            SchemaLocalAttribute[] attributes = attributeModel.getAttributes();
            QName name = null;
            for (int i = 0; i < attributes.length; i++) {
                XmlObject xmlObject = ((SchemaLocalAttributeImpl) attributes[i])._parseObject;
                if (XmlID.type.isAssignableFrom(attributes[i].getType())) {
                    if (name == null) {
                        name = attributes[i].getName();
                    } else {
                        StscState.get().error("ag-props-correct.3", new Object[]{QNameHelper.pretty(name), attributes[i].getName()}, xmlObject != null ? xmlObject : parseObject);
                    }
                    if (attributes[i].getDefaultText() != null) {
                        StscState stscState = StscState.get();
                        if (xmlObject == null) {
                            xmlObject = parseObject;
                        }
                        stscState.error("a-props-correct.3", (Object[]) null, xmlObject);
                    }
                } else if (XmlNOTATION.type.isAssignableFrom(attributes[i].getType())) {
                    if (attributes[i].getType().getBuiltinTypeCode() == 8) {
                        StscState stscState2 = StscState.get();
                        Object[] objArr = {QNameHelper.pretty(attributes[i].getName())};
                        if (xmlObject == null) {
                            xmlObject = parseObject;
                        }
                        stscState2.recover("enumeration-required-notation-attr", objArr, xmlObject);
                    } else {
                        if (attributes[i].getType().getSimpleVariety() == 2) {
                            for (SchemaType schemaType : attributes[i].getType().getUnionConstituentTypes()) {
                                if (schemaType.getBuiltinTypeCode() == 8) {
                                    StscState.get().recover("enumeration-required-notation-attr", new Object[]{QNameHelper.pretty(attributes[i].getName())}, xmlObject != null ? xmlObject : parseObject);
                                }
                            }
                        }
                        if (schemaTypeImpl.isAttributeType()) {
                            if (attributes[i].getName().getNamespaceURI().length() > 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                        } else {
                            SchemaType outerType = schemaTypeImpl;
                            while (outerType.getOuterType() != null) {
                                outerType = outerType.getOuterType();
                            }
                            if (!outerType.isDocumentType() ? outerType.getName().getNamespaceURI().length() <= 0 : outerType.getDocumentElementName().getNamespaceURI().length() <= 0) {
                                z = false;
                            } else {
                                z = true;
                            }
                        }
                        if (z) {
                            StscState stscState3 = StscState.get();
                            Object[] objArr2 = {QNameHelper.pretty(attributes[i].getName())};
                            if (xmlObject == null) {
                                xmlObject = parseObject;
                            }
                            stscState3.warning("notation-targetns-attr", objArr2, xmlObject);
                        }
                    }
                } else {
                    String defaultText = attributes[i].getDefaultText();
                    if (defaultText != null) {
                        try {
                            XmlAnySimpleType defaultValue = attributes[i].getDefaultValue();
                            if (!defaultValue.validate()) {
                                throw new Exception();
                            }
                            SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl) schemaTypeImpl.getAttributeProperty(attributes[i].getName());
                            if (schemaPropertyImpl != null && schemaPropertyImpl.getDefaultText() != null) {
                                schemaPropertyImpl.setDefaultValue(new XmlValueRef(defaultValue));
                            }
                        } catch (Exception unused) {
                            String str = attributes[i].isFixed() ? "fixed" : "default";
                            if (xmlObject != null) {
                                XmlObject xmlObjectSelectAttribute = xmlObject.selectAttribute("", str);
                                if (xmlObjectSelectAttribute != null) {
                                    xmlObject = xmlObjectSelectAttribute;
                                }
                            } else {
                                xmlObject = parseObject;
                            }
                            StscState.get().error("a-props-correct.2", new Object[]{QNameHelper.pretty(attributes[i].getName()), str, defaultText, QNameHelper.pretty(attributes[i].getType().getName())}, xmlObject);
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        checkElementDefaults(schemaTypeImpl.getContentModel(), parseObject, schemaTypeImpl);
    }

    private static void checkElementDefaults(SchemaParticle schemaParticle, XmlObject xmlObject, SchemaType schemaType) {
        String localPart;
        String localPart2;
        String str;
        if (schemaParticle == null) {
            return;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1 || particleType == 2 || particleType == 3) {
            for (SchemaParticle schemaParticle2 : schemaParticle.getParticleChildren()) {
                checkElementDefaults(schemaParticle2, xmlObject, schemaType);
            }
            return;
        }
        if (particleType != 4) {
            return;
        }
        String defaultText = schemaParticle.getDefaultText();
        if (defaultText != null) {
            if (schemaParticle.getType().isSimpleType() || schemaParticle.getType().getContentType() == 2) {
                try {
                    XmlAnySimpleType defaultValue = schemaParticle.getDefaultValue();
                    XmlOptions xmlOptions = new XmlOptions();
                    xmlOptions.put("VALIDATE_TEXT_ONLY");
                    if (!defaultValue.validate(xmlOptions)) {
                        throw new Exception();
                    }
                    SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl) schemaType.getElementProperty(schemaParticle.getName());
                    if (schemaPropertyImpl != null && schemaPropertyImpl.getDefaultText() != null) {
                        schemaPropertyImpl.setDefaultValue(new XmlValueRef(defaultValue));
                    }
                } catch (Exception unused) {
                    str = schemaParticle.isFixed() ? "fixed" : "default";
                    XmlObject xmlObjectSelectAttribute = xmlObject.selectAttribute("", str);
                    StscState stscState = StscState.get();
                    Object[] objArr = {QNameHelper.pretty(schemaParticle.getName()), str, defaultText, QNameHelper.pretty(schemaParticle.getType().getName())};
                    if (xmlObjectSelectAttribute == null) {
                        xmlObjectSelectAttribute = xmlObject;
                    }
                    stscState.error("e-props-correct.2", objArr, xmlObjectSelectAttribute);
                }
            } else if (schemaParticle.getType().getContentType() == 4) {
                if (!schemaParticle.getType().getContentModel().isSkippable()) {
                    str = schemaParticle.isFixed() ? "fixed" : "default";
                    XmlObject xmlObjectSelectAttribute2 = xmlObject.selectAttribute("", str);
                    StscState stscState2 = StscState.get();
                    Object[] objArr2 = {QNameHelper.pretty(schemaParticle.getName()), str, defaultText};
                    if (xmlObjectSelectAttribute2 == null) {
                        xmlObjectSelectAttribute2 = xmlObject;
                    }
                    stscState2.error("cos-valid-default.2.2.2", objArr2, xmlObjectSelectAttribute2);
                } else {
                    SchemaPropertyImpl schemaPropertyImpl2 = (SchemaPropertyImpl) schemaType.getElementProperty(schemaParticle.getName());
                    if (schemaPropertyImpl2 != null && schemaPropertyImpl2.getDefaultText() != null) {
                        schemaPropertyImpl2.setDefaultValue(new XmlValueRef(XmlString.type.newValue(defaultText)));
                    }
                }
            } else if (schemaParticle.getType().getContentType() == 3) {
                XmlObject xmlObjectSelectAttribute3 = xmlObject.selectAttribute("", "default");
                StscState stscState3 = StscState.get();
                Object[] objArr3 = {QNameHelper.pretty(schemaParticle.getName()), defaultText, "element"};
                if (xmlObjectSelectAttribute3 == null) {
                    xmlObjectSelectAttribute3 = xmlObject;
                }
                stscState3.error("cos-valid-default.2.1", objArr3, xmlObjectSelectAttribute3);
            } else if (schemaParticle.getType().getContentType() == 1) {
                XmlObject xmlObjectSelectAttribute4 = xmlObject.selectAttribute("", "default");
                StscState stscState4 = StscState.get();
                Object[] objArr4 = {QNameHelper.pretty(schemaParticle.getName()), defaultText, "empty"};
                if (xmlObjectSelectAttribute4 == null) {
                    xmlObjectSelectAttribute4 = xmlObject;
                }
                stscState4.error("cos-valid-default.2.1", objArr4, xmlObjectSelectAttribute4);
            }
        }
        if (BuiltinSchemaTypeSystem.ST_ID.isAssignableFrom(schemaParticle.getType())) {
            localPart = BuiltinSchemaTypeSystem.ST_ID.getName().getLocalPart();
        } else if (BuiltinSchemaTypeSystem.ST_IDREF.isAssignableFrom(schemaParticle.getType())) {
            localPart = BuiltinSchemaTypeSystem.ST_IDREF.getName().getLocalPart();
        } else if (BuiltinSchemaTypeSystem.ST_IDREFS.isAssignableFrom(schemaParticle.getType())) {
            localPart = BuiltinSchemaTypeSystem.ST_IDREFS.getName().getLocalPart();
        } else if (BuiltinSchemaTypeSystem.ST_ENTITY.isAssignableFrom(schemaParticle.getType())) {
            localPart = BuiltinSchemaTypeSystem.ST_ENTITY.getName().getLocalPart();
        } else if (BuiltinSchemaTypeSystem.ST_ENTITIES.isAssignableFrom(schemaParticle.getType())) {
            localPart = BuiltinSchemaTypeSystem.ST_ENTITIES.getName().getLocalPart();
        } else if (BuiltinSchemaTypeSystem.ST_NOTATION.isAssignableFrom(schemaParticle.getType())) {
            if (schemaParticle.getType().getBuiltinTypeCode() == 8) {
                SchemaLocalElementImpl schemaLocalElementImpl = (SchemaLocalElementImpl) schemaParticle;
                StscState.get().recover("enumeration-required-notation-elem", new Object[]{QNameHelper.pretty(schemaParticle.getName())}, schemaLocalElementImpl._parseObject == null ? xmlObject : schemaLocalElementImpl._parseObject.selectAttribute("", JamXmlElements.TYPE));
                localPart2 = null;
            } else {
                if (schemaParticle.getType().getSimpleVariety() == 2) {
                    for (SchemaType schemaType2 : schemaParticle.getType().getUnionConstituentTypes()) {
                        if (schemaType2.getBuiltinTypeCode() == 8) {
                            SchemaLocalElementImpl schemaLocalElementImpl2 = (SchemaLocalElementImpl) schemaParticle;
                            StscState.get().recover("enumeration-required-notation-elem", new Object[]{QNameHelper.pretty(schemaParticle.getName())}, schemaLocalElementImpl2._parseObject == null ? xmlObject : schemaLocalElementImpl2._parseObject.selectAttribute("", JamXmlElements.TYPE));
                        }
                    }
                }
                localPart2 = BuiltinSchemaTypeSystem.ST_NOTATION.getName().getLocalPart();
            }
            while (schemaType.getOuterType() != null) {
                schemaType = schemaType.getOuterType();
            }
            if (!schemaType.isDocumentType() ? schemaType.getName().getNamespaceURI().length() <= 0 : schemaType.getDocumentElementName().getNamespaceURI().length() <= 0) {
                SchemaLocalElementImpl schemaLocalElementImpl3 = (SchemaLocalElementImpl) schemaParticle;
                StscState.get().warning("notation-targetns-elem", new Object[]{QNameHelper.pretty(schemaParticle.getName())}, schemaLocalElementImpl3._parseObject == null ? xmlObject : schemaLocalElementImpl3._parseObject);
            }
            localPart = localPart2;
        } else {
            localPart = null;
        }
        if (localPart != null) {
            StscState stscState5 = StscState.get();
            Object[] objArr5 = {QNameHelper.pretty(schemaParticle.getName()), localPart};
            SchemaLocalElementImpl schemaLocalElementImpl4 = (SchemaLocalElementImpl) schemaParticle;
            if (schemaLocalElementImpl4._parseObject != null) {
                xmlObject = schemaLocalElementImpl4._parseObject.selectAttribute("", JamXmlElements.TYPE);
            }
            stscState5.warning("id-idref-idrefs-entity-entities-notation", objArr5, xmlObject);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0056  */
    /* JADX WARN: Code duplicated, block: B:25:0x005c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0062  */
    /* JADX WARN: Code duplicated, block: B:29:0x0068  */
    public static boolean checkRestriction(SchemaTypeImpl schemaTypeImpl) {
        SchemaParticle contentModel;
        SchemaParticle contentModel2;
        if (schemaTypeImpl.getDerivationType() == 1 && !schemaTypeImpl.isSimpleType()) {
            StscState stscState = StscState.get();
            XmlObject parseObject = schemaTypeImpl.getParseObject();
            SchemaType baseType = schemaTypeImpl.getBaseType();
            if (baseType.isSimpleType()) {
                stscState.error("src-ct.1", new Object[]{QNameHelper.pretty(baseType.getName())}, parseObject);
                return false;
            }
            int contentType = schemaTypeImpl.getContentType();
            if (contentType == 1) {
                int contentType2 = baseType.getContentType();
                if (contentType2 != 1) {
                    if (contentType2 == 3 || contentType2 == 4) {
                        if (baseType.getContentModel() != null && !baseType.getContentModel().isSkippable()) {
                            stscState.error("derivation-ok-restriction.5.2.2", (Object[]) null, parseObject);
                            return false;
                        }
                    } else {
                        stscState.error("derivation-ok-restriction.5.2", (Object[]) null, parseObject);
                        return false;
                    }
                }
            } else if (contentType == 2) {
                int contentType3 = baseType.getContentType();
                if (contentType3 == 2) {
                    SchemaType contentBasedOnType = schemaTypeImpl.getContentBasedOnType();
                    if (contentBasedOnType != baseType) {
                        while (baseType != null && !baseType.isSimpleType()) {
                            baseType = baseType.getContentBasedOnType();
                        }
                        if (baseType != null && !baseType.isAssignableFrom(contentBasedOnType)) {
                            stscState.error("derivation-ok-restriction.5.2.2.1", (Object[]) null, parseObject);
                            return false;
                        }
                    }
                } else if (contentType3 == 4) {
                    if (baseType.getContentModel() != null && !baseType.getContentModel().isSkippable()) {
                        stscState.error("derivation-ok-restriction.5.1.2", (Object[]) null, parseObject);
                        return false;
                    }
                } else {
                    stscState.error("derivation-ok-restriction.5.1", (Object[]) null, parseObject);
                    return false;
                }
            } else if (contentType == 3) {
                if (baseType.getContentType() == 1) {
                    stscState.error("derivation-ok-restriction.5.3b", (Object[]) null, parseObject);
                    return false;
                }
                if (baseType.getContentType() == 2) {
                    stscState.error("derivation-ok-restriction.5.3c", (Object[]) null, parseObject);
                    return false;
                }
                contentModel = baseType.getContentModel();
                contentModel2 = schemaTypeImpl.getContentModel();
                if (contentModel2 != null && schemaTypeImpl.getDerivationType() == 1) {
                    return true;
                }
                if (contentModel != null || contentModel2 == null) {
                    XBeanDebug.logStackTrace("Null models that weren't caught by EMPTY_CONTENT: " + baseType + " (" + contentModel + "), " + schemaTypeImpl + " (" + contentModel2 + ")");
                    stscState.error("derivation-ok-restriction.5.3", (Object[]) null, parseObject);
                    return false;
                }
                ArrayList arrayList = new ArrayList();
                if (!isParticleValidRestriction(contentModel, contentModel2, arrayList, parseObject)) {
                    if (arrayList.size() == 0) {
                        stscState.error("derivation-ok-restriction.5.3", (Object[]) null, parseObject);
                    } else {
                        stscState.getErrorListener().add(arrayList.get(arrayList.size() - 1));
                    }
                    return false;
                }
            } else if (contentType == 4) {
                if (baseType.getContentType() != 4) {
                    stscState.error("derivation-ok-restriction.5.3a", (Object[]) null, parseObject);
                    return false;
                }
                if (baseType.getContentType() == 1) {
                    stscState.error("derivation-ok-restriction.5.3b", (Object[]) null, parseObject);
                    return false;
                }
                if (baseType.getContentType() == 2) {
                    stscState.error("derivation-ok-restriction.5.3c", (Object[]) null, parseObject);
                    return false;
                }
                contentModel = baseType.getContentModel();
                contentModel2 = schemaTypeImpl.getContentModel();
                if (contentModel2 != null) {
                }
                if (contentModel != null) {
                }
                XBeanDebug.logStackTrace("Null models that weren't caught by EMPTY_CONTENT: " + baseType + " (" + contentModel + "), " + schemaTypeImpl + " (" + contentModel2 + ")");
                stscState.error("derivation-ok-restriction.5.3", (Object[]) null, parseObject);
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006a  */
    /* JADX WARN: Code duplicated, block: B:42:0x009c  */
    /* JADX WARN: Code duplicated, block: B:53:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:63:0x0100  */
    public static boolean isParticleValidRestriction(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection collection, XmlObject xmlObject) {
        if (schemaParticle.equals(schemaParticle2)) {
            return true;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1) {
            int particleType2 = schemaParticle2.getParticleType();
            if (particleType2 == 1) {
                return recurse(schemaParticle, schemaParticle2, collection, xmlObject);
            }
            if (particleType2 == 2) {
                collection.add(XmlError.forObject("cos-particle-restrict.2", new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
            } else {
                if (particleType2 == 3) {
                    return recurseUnordered(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType2 == 4) {
                    return recurseAsIfGroup(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType2 == 5) {
                    collection.add(XmlError.forObject("cos-particle-restrict.2", new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
                }
            }
        } else if (particleType == 2) {
            int particleType3 = schemaParticle2.getParticleType();
            if (particleType3 == 1) {
                collection.add(XmlError.forObject("cos-particle-restrict.2", new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
            } else {
                if (particleType3 == 2) {
                    return recurseLax(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType3 == 3) {
                    return mapAndSum(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType3 == 4) {
                    return recurseAsIfGroup(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType3 == 5) {
                    collection.add(XmlError.forObject("cos-particle-restrict.2", new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
                }
            }
        } else if (particleType == 3) {
            int particleType4 = schemaParticle2.getParticleType();
            if (particleType4 == 1 || particleType4 == 2) {
                collection.add(XmlError.forObject("cos-particle-restrict.2", new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
            } else {
                if (particleType4 == 3) {
                    return recurse(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType4 == 4) {
                    return recurseAsIfGroup(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType4 == 5) {
                    collection.add(XmlError.forObject("cos-particle-restrict.2", new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
                }
            }
        } else if (particleType == 4) {
            int particleType5 = schemaParticle2.getParticleType();
            if (particleType5 == 1 || particleType5 == 2 || particleType5 == 3) {
                collection.add(XmlError.forObject("cos-particle-restrict.2", new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
            } else {
                if (particleType5 == 4) {
                    return nameAndTypeOK((SchemaLocalElement) schemaParticle, (SchemaLocalElement) schemaParticle2, collection, xmlObject);
                }
                if (particleType5 == 5) {
                    collection.add(XmlError.forObject("cos-particle-restrict.2", new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
                }
            }
        } else if (particleType == 5) {
            int particleType6 = schemaParticle2.getParticleType();
            if (particleType6 == 1) {
                return nsRecurseCheckCardinality(schemaParticle, schemaParticle2, collection, xmlObject);
            }
            if (particleType6 == 2) {
                return nsRecurseCheckCardinality(schemaParticle, schemaParticle2, collection, xmlObject);
            }
            if (particleType6 == 3) {
                return nsRecurseCheckCardinality(schemaParticle, schemaParticle2, collection, xmlObject);
            }
            if (particleType6 == 4) {
                return nsCompat(schemaParticle, (SchemaLocalElement) schemaParticle2, collection, xmlObject);
            }
            if (particleType6 == 5) {
                return nsSubset(schemaParticle, schemaParticle2, collection, xmlObject);
            }
        }
        return false;
    }

    private static boolean mapAndSum(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection collection, XmlObject xmlObject) {
        boolean z;
        SchemaParticle[] particleChildren = schemaParticle2.getParticleChildren();
        SchemaParticle[] particleChildren2 = schemaParticle.getParticleChildren();
        for (SchemaParticle schemaParticle3 : particleChildren) {
            int i = 0;
            while (true) {
                if (i >= particleChildren2.length) {
                    z = false;
                    break;
                }
                if (isParticleValidRestriction(particleChildren2[i], schemaParticle3, collection, xmlObject)) {
                    z = true;
                    break;
                }
                i++;
            }
            if (!z) {
                collection.add(XmlError.forObject("rcase-MapAndSum.1", new Object[]{printParticle(schemaParticle3)}, xmlObject));
                return false;
            }
        }
        BigInteger bigIntegerMultiply = schemaParticle2.getMinOccurs().multiply(BigInteger.valueOf(schemaParticle2.getParticleChildren().length));
        BigInteger bigIntegerMultiply2 = schemaParticle2.getMaxOccurs() == null ? null : schemaParticle2.getMaxOccurs().multiply(BigInteger.valueOf(schemaParticle2.getParticleChildren().length));
        if (bigIntegerMultiply.compareTo(schemaParticle.getMinOccurs()) < 0) {
            collection.add(XmlError.forObject("rcase-MapAndSum.2a", new Object[]{bigIntegerMultiply.toString(), schemaParticle.getMinOccurs().toString()}, xmlObject));
            return false;
        }
        if (schemaParticle.getMaxOccurs() == null || (bigIntegerMultiply2 != null && bigIntegerMultiply2.compareTo(schemaParticle.getMaxOccurs()) <= 0)) {
            return true;
        }
        Object[] objArr = new Object[2];
        objArr[0] = bigIntegerMultiply2 == null ? "unbounded" : bigIntegerMultiply2.toString();
        objArr[1] = schemaParticle.getMaxOccurs().toString();
        collection.add(XmlError.forObject("rcase-MapAndSum.2b", objArr, xmlObject));
        return false;
    }

    private static boolean recurseAsIfGroup(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection collection, XmlObject xmlObject) {
        SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
        schemaParticleImpl.setParticleType(schemaParticle.getParticleType());
        schemaParticleImpl.setMinOccurs(BigInteger.ONE);
        schemaParticleImpl.setMaxOccurs(BigInteger.ONE);
        schemaParticleImpl.setParticleChildren(new SchemaParticle[]{schemaParticle2});
        return isParticleValidRestriction(schemaParticle, schemaParticleImpl, collection, xmlObject);
    }

    private static boolean recurseLax(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection collection, XmlObject xmlObject) {
        if (!occurrenceRangeOK(schemaParticle, schemaParticle2, collection, xmlObject)) {
            return false;
        }
        SchemaParticle[] particleChildren = schemaParticle2.getParticleChildren();
        SchemaParticle[] particleChildren2 = schemaParticle.getParticleChildren();
        int i = 0;
        for (int i2 = 0; i < particleChildren.length && i2 < particleChildren2.length; i2++) {
            if (isParticleValidRestriction(particleChildren2[i2], particleChildren[i], collection, xmlObject)) {
                i++;
            }
        }
        if (i >= particleChildren.length) {
            return true;
        }
        collection.add(XmlError.forObject("rcase-RecurseLax.2", new Object[]{printParticles(particleChildren2, i)}, xmlObject));
        return false;
    }

    private static boolean recurseUnordered(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection collection, XmlObject xmlObject) {
        boolean z;
        if (!occurrenceRangeOK(schemaParticle, schemaParticle2, collection, xmlObject)) {
            return false;
        }
        SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
        HashMap map = new HashMap(10);
        Object obj = new Object();
        for (int i = 0; i < particleChildren.length; i++) {
            map.put(particleChildren[i].getName(), particleChildren[i]);
        }
        SchemaParticle[] particleChildren2 = schemaParticle2.getParticleChildren();
        int i2 = 0;
        while (true) {
            if (i2 >= particleChildren2.length) {
                z = true;
                break;
            }
            Object obj2 = map.get(particleChildren2[i2].getName());
            if (obj2 == null) {
                collection.add(XmlError.forObject("rcase-RecurseUnordered.2", new Object[]{printParticle(particleChildren2[i2])}, xmlObject));
            } else if (obj2 == obj) {
                collection.add(XmlError.forObject("rcase-RecurseUnordered.2.1", new Object[]{printParticle(particleChildren2[i2])}, xmlObject));
            } else {
                SchemaParticle schemaParticle3 = (SchemaParticle) obj2;
                if (particleChildren2[i2].getMaxOccurs() == null || particleChildren2[i2].getMaxOccurs().compareTo(BigInteger.ONE) > 0) {
                    collection.add(XmlError.forObject("rcase-RecurseUnordered.2.2a", new Object[]{printParticle(particleChildren2[i2]), printMaxOccurs(particleChildren2[i2].getMinOccurs())}, xmlObject));
                } else if (isParticleValidRestriction(schemaParticle3, particleChildren2[i2], collection, xmlObject)) {
                    map.put(particleChildren2[i2].getName(), obj);
                    i2++;
                }
            }
            z = false;
            break;
        }
        if (z) {
            for (QName qName : map.keySet()) {
                if (map.get(qName) != obj && !((SchemaParticle) map.get(qName)).isSkippable()) {
                    collection.add(XmlError.forObject("rcase-RecurseUnordered.2.3", new Object[]{printParticle((SchemaParticle) map.get(qName))}, xmlObject));
                    z = false;
                }
            }
        }
        return z;
    }

    private static boolean recurse(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection collection, XmlObject xmlObject) {
        boolean z;
        if (!occurrenceRangeOK(schemaParticle, schemaParticle2, collection, xmlObject)) {
            return false;
        }
        SchemaParticle[] particleChildren = schemaParticle2.getParticleChildren();
        SchemaParticle[] particleChildren2 = schemaParticle.getParticleChildren();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= particleChildren.length || i2 >= particleChildren2.length) {
                z = true;
                break;
            }
            SchemaParticle schemaParticle3 = particleChildren[i];
            SchemaParticle schemaParticle4 = particleChildren2[i2];
            if (!isParticleValidRestriction(schemaParticle4, schemaParticle3, collection, xmlObject)) {
                if (!schemaParticle4.isSkippable()) {
                    collection.add(XmlError.forObject("rcase-Recurse.2.1", new Object[]{printParticle(schemaParticle3), printParticle(schemaParticle2), printParticle(schemaParticle4), printParticle(schemaParticle)}, xmlObject));
                    z = false;
                    break;
                }
            } else {
                i++;
            }
            i2++;
        }
        if (i < particleChildren.length) {
            collection.add(XmlError.forObject("rcase-Recurse.2", new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle), printParticles(particleChildren, i)}, xmlObject));
            return false;
        }
        if (i2 < particleChildren2.length) {
            ArrayList arrayList = new ArrayList(particleChildren2.length);
            while (i2 < particleChildren2.length) {
                if (!particleChildren2[i2].isSkippable()) {
                    arrayList.add(particleChildren2[i2]);
                }
                i2++;
            }
            if (arrayList.size() > 0) {
                collection.add(XmlError.forObject("rcase-Recurse.2.2", new Object[]{printParticle(schemaParticle), printParticle(schemaParticle2), printParticles(arrayList)}, xmlObject));
                return false;
            }
        }
        return z;
    }

    private static boolean nsRecurseCheckCardinality(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection collection, XmlObject xmlObject) {
        SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
        schemaParticleImpl.setParticleType(schemaParticle.getParticleType());
        schemaParticleImpl.setWildcardProcess(schemaParticle.getWildcardProcess());
        schemaParticleImpl.setWildcardSet(schemaParticle.getWildcardSet());
        schemaParticleImpl.setMinOccurs(BigInteger.ZERO);
        schemaParticleImpl.setMaxOccurs(null);
        schemaParticleImpl.setTransitionRules(schemaParticle.getWildcardSet(), true);
        schemaParticleImpl.setTransitionNotes(schemaParticle.getWildcardSet(), true);
        boolean zNsRecurseCheckCardinality = true;
        for (SchemaLocalElement schemaLocalElement : schemaParticle2.getParticleChildren()) {
            int particleType = schemaLocalElement.getParticleType();
            if (particleType == 1 || particleType == 2 || particleType == 3) {
                zNsRecurseCheckCardinality = nsRecurseCheckCardinality(schemaParticleImpl, schemaLocalElement, collection, xmlObject);
            } else if (particleType == 4) {
                zNsRecurseCheckCardinality = nsCompat(schemaParticleImpl, schemaLocalElement, collection, xmlObject);
            } else if (particleType == 5) {
                zNsRecurseCheckCardinality = nsSubset(schemaParticleImpl, schemaLocalElement, collection, xmlObject);
            }
            if (!zNsRecurseCheckCardinality) {
                break;
            }
        }
        return zNsRecurseCheckCardinality ? checkGroupOccurrenceOK(schemaParticle, schemaParticle2, collection, xmlObject) : zNsRecurseCheckCardinality;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001b  */
    private static boolean checkGroupOccurrenceOK(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection collection, XmlObject xmlObject) {
        boolean z;
        BigInteger effectiveMinRangeAllSeq = BigInteger.ZERO;
        BigInteger effectiveMaxRangeAllSeq = BigInteger.ZERO;
        int particleType = schemaParticle2.getParticleType();
        if (particleType == 1) {
            effectiveMinRangeAllSeq = getEffectiveMinRangeAllSeq(schemaParticle2);
            effectiveMaxRangeAllSeq = getEffectiveMaxRangeAllSeq(schemaParticle2);
        } else if (particleType == 2) {
            effectiveMinRangeAllSeq = getEffectiveMinRangeChoice(schemaParticle2);
            effectiveMaxRangeAllSeq = getEffectiveMaxRangeChoice(schemaParticle2);
        } else if (particleType == 3) {
            effectiveMinRangeAllSeq = getEffectiveMinRangeAllSeq(schemaParticle2);
            effectiveMaxRangeAllSeq = getEffectiveMaxRangeAllSeq(schemaParticle2);
        }
        if (effectiveMinRangeAllSeq.compareTo(schemaParticle.getMinOccurs()) < 0) {
            collection.add(XmlError.forObject("range-ok.1", new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
            z = false;
        } else {
            z = true;
        }
        if (schemaParticle.getMaxOccurs() != null) {
            if (effectiveMaxRangeAllSeq == null) {
                collection.add(XmlError.forObject("range-ok.2", new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
                return false;
            }
            if (effectiveMaxRangeAllSeq.compareTo(schemaParticle.getMaxOccurs()) > 0) {
                collection.add(XmlError.forObject("range-ok.2", new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
                return false;
            }
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0051  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d A[PHI: r0
  0x005d: PHI (r0v6 java.math.BigInteger) = (r0v5 java.math.BigInteger), (r0v8 java.math.BigInteger) binds: [B:33:0x005b, B:28:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    private static BigInteger getEffectiveMaxRangeChoice(SchemaParticle schemaParticle) {
        BigInteger effectiveMaxRangeAllSeq = BigInteger.ZERO;
        BigInteger maxOccurs = BigInteger.ZERO;
        BigInteger bigInteger = BigInteger.ZERO;
        boolean z = false;
        for (SchemaParticle schemaParticle2 : schemaParticle.getParticleChildren()) {
            int particleType = schemaParticle2.getParticleType();
            if (particleType == 1) {
                effectiveMaxRangeAllSeq = getEffectiveMaxRangeAllSeq(schemaParticle2);
                if (effectiveMaxRangeAllSeq != null && effectiveMaxRangeAllSeq.compareTo(bigInteger) > 0) {
                    bigInteger = effectiveMaxRangeAllSeq;
                }
            } else if (particleType == 2) {
                effectiveMaxRangeAllSeq = getEffectiveMaxRangeChoice(schemaParticle2);
                if (effectiveMaxRangeAllSeq != null && effectiveMaxRangeAllSeq.compareTo(bigInteger) > 0) {
                    bigInteger = effectiveMaxRangeAllSeq;
                }
            } else if (particleType == 3) {
                effectiveMaxRangeAllSeq = getEffectiveMaxRangeAllSeq(schemaParticle2);
                if (effectiveMaxRangeAllSeq != null) {
                    bigInteger = effectiveMaxRangeAllSeq;
                }
            } else if (particleType == 4 || particleType == 5) {
                if (schemaParticle2.getMaxOccurs() == null) {
                    effectiveMaxRangeAllSeq = null;
                } else if (schemaParticle2.getIntMaxOccurs() > 0) {
                    if (schemaParticle2.getMaxOccurs().compareTo(maxOccurs) > 0) {
                        maxOccurs = schemaParticle2.getMaxOccurs();
                    }
                    z = true;
                }
            }
            if (effectiveMaxRangeAllSeq == null) {
                break;
            }
        }
        if (effectiveMaxRangeAllSeq == null) {
            return effectiveMaxRangeAllSeq;
        }
        if (z && schemaParticle.getMaxOccurs() == null) {
            return null;
        }
        return schemaParticle.getMaxOccurs().multiply(maxOccurs.add(bigInteger));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x004b  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057 A[PHI: r0
  0x0057: PHI (r0v6 java.math.BigInteger) = (r0v5 java.math.BigInteger), (r0v8 java.math.BigInteger) binds: [B:30:0x0055, B:25:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    private static BigInteger getEffectiveMaxRangeAllSeq(SchemaParticle schemaParticle) {
        BigInteger effectiveMaxRangeAllSeq = BigInteger.ZERO;
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        BigInteger bigInteger = BigInteger.ZERO;
        boolean z = false;
        for (SchemaParticle schemaParticle2 : schemaParticle.getParticleChildren()) {
            int particleType = schemaParticle2.getParticleType();
            if (particleType == 1) {
                effectiveMaxRangeAllSeq = getEffectiveMaxRangeAllSeq(schemaParticle2);
                if (effectiveMaxRangeAllSeq != null && effectiveMaxRangeAllSeq.compareTo(bigInteger) > 0) {
                    bigInteger = effectiveMaxRangeAllSeq;
                }
            } else if (particleType == 2) {
                effectiveMaxRangeAllSeq = getEffectiveMaxRangeChoice(schemaParticle2);
                if (effectiveMaxRangeAllSeq != null && effectiveMaxRangeAllSeq.compareTo(bigInteger) > 0) {
                    bigInteger = effectiveMaxRangeAllSeq;
                }
            } else if (particleType == 3) {
                effectiveMaxRangeAllSeq = getEffectiveMaxRangeAllSeq(schemaParticle2);
                if (effectiveMaxRangeAllSeq != null) {
                    bigInteger = effectiveMaxRangeAllSeq;
                }
            } else if (particleType == 4 || particleType == 5) {
                if (schemaParticle2.getMaxOccurs() == null) {
                    effectiveMaxRangeAllSeq = null;
                } else if (schemaParticle2.getIntMaxOccurs() > 0) {
                    bigIntegerAdd = bigIntegerAdd.add(schemaParticle2.getMaxOccurs());
                    z = true;
                }
            }
            if (effectiveMaxRangeAllSeq == null) {
                break;
            }
        }
        if (effectiveMaxRangeAllSeq == null) {
            return effectiveMaxRangeAllSeq;
        }
        if (z && schemaParticle.getMaxOccurs() == null) {
            return null;
        }
        return schemaParticle.getMaxOccurs().multiply(bigIntegerAdd.add(bigInteger));
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0043  */
    /* JADX WARN: Code duplicated, block: B:33:0x004f A[PHI: r3
  0x004f: PHI (r3v3 java.math.BigInteger) = (r3v2 java.math.BigInteger), (r3v2 java.math.BigInteger), (r3v4 java.math.BigInteger), (r3v4 java.math.BigInteger) binds: [B:30:0x0047, B:32:0x004d, B:25:0x003a, B:27:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    private static BigInteger getEffectiveMinRangeChoice(SchemaParticle schemaParticle) {
        BigInteger effectiveMinRangeAllSeq;
        SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
        if (particleChildren.length == 0) {
            return BigInteger.ZERO;
        }
        BigInteger minOccurs = null;
        for (SchemaParticle schemaParticle2 : particleChildren) {
            int particleType = schemaParticle2.getParticleType();
            if (particleType == 1) {
                effectiveMinRangeAllSeq = getEffectiveMinRangeAllSeq(schemaParticle2);
                if (minOccurs != null || minOccurs.compareTo(effectiveMinRangeAllSeq) > 0) {
                    minOccurs = effectiveMinRangeAllSeq;
                }
            } else if (particleType == 2) {
                effectiveMinRangeAllSeq = getEffectiveMinRangeChoice(schemaParticle2);
                if (minOccurs == null || minOccurs.compareTo(effectiveMinRangeAllSeq) > 0) {
                    minOccurs = effectiveMinRangeAllSeq;
                }
            } else if (particleType != 3) {
                if ((particleType == 4 || particleType == 5) && (minOccurs == null || minOccurs.compareTo(schemaParticle2.getMinOccurs()) > 0)) {
                    minOccurs = schemaParticle2.getMinOccurs();
                }
            } else {
                effectiveMinRangeAllSeq = getEffectiveMinRangeAllSeq(schemaParticle2);
                if (minOccurs != null) {
                    minOccurs = effectiveMinRangeAllSeq;
                } else {
                    minOccurs = effectiveMinRangeAllSeq;
                }
            }
        }
        if (minOccurs == null) {
            minOccurs = BigInteger.ZERO;
        }
        return schemaParticle.getMinOccurs().multiply(minOccurs);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    private static BigInteger getEffectiveMinRangeAllSeq(SchemaParticle schemaParticle) {
        BigInteger bigInteger = BigInteger.ZERO;
        SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (SchemaParticle schemaParticle2 : particleChildren) {
            int particleType = schemaParticle2.getParticleType();
            if (particleType == 1) {
                bigIntegerAdd = bigIntegerAdd.add(getEffectiveMinRangeAllSeq(schemaParticle2));
            } else if (particleType == 2) {
                bigIntegerAdd = bigIntegerAdd.add(getEffectiveMinRangeChoice(schemaParticle2));
            } else if (particleType == 3) {
                bigIntegerAdd = bigIntegerAdd.add(getEffectiveMinRangeAllSeq(schemaParticle2));
            } else if (particleType == 4 || particleType == 5) {
                bigIntegerAdd = bigIntegerAdd.add(schemaParticle2.getMinOccurs());
            }
        }
        return schemaParticle.getMinOccurs().multiply(bigIntegerAdd);
    }

    private static boolean nsSubset(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection collection, XmlObject xmlObject) {
        if (!occurrenceRangeOK(schemaParticle, schemaParticle2, collection, xmlObject)) {
            return false;
        }
        if (schemaParticle.getWildcardSet().inverse().isDisjoint(schemaParticle2.getWildcardSet())) {
            return true;
        }
        collection.add(XmlError.forObject("rcase-NSSubset.2", new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
        return false;
    }

    private static boolean nsCompat(SchemaParticle schemaParticle, SchemaLocalElement schemaLocalElement, Collection collection, XmlObject xmlObject) {
        if (!schemaParticle.getWildcardSet().contains(schemaLocalElement.getName())) {
            collection.add(XmlError.forObject("rcase-NSCompat.1", new Object[]{printParticle((SchemaParticle) schemaLocalElement), printParticle(schemaParticle)}, xmlObject));
        } else if (occurrenceRangeOK(schemaParticle, (SchemaParticle) schemaLocalElement, collection, xmlObject)) {
            return true;
        }
        return false;
    }

    private static boolean nameAndTypeOK(SchemaLocalElement schemaLocalElement, SchemaLocalElement schemaLocalElement2, Collection collection, XmlObject xmlObject) {
        SchemaParticle schemaParticle = (SchemaParticle) schemaLocalElement;
        if (!schemaParticle.canStartWithElement(schemaLocalElement2.getName())) {
            collection.add(XmlError.forObject("rcase-NameAndTypeOK.1", new Object[]{printParticle((SchemaParticle) schemaLocalElement2), printParticle(schemaParticle)}, xmlObject));
            return false;
        }
        if (schemaLocalElement.isNillable() || !schemaLocalElement2.isNillable()) {
            return occurrenceRangeOK(schemaParticle, (SchemaParticle) schemaLocalElement2, collection, xmlObject) && checkFixed(schemaLocalElement, schemaLocalElement2, collection, xmlObject) && checkIdentityConstraints(schemaLocalElement, schemaLocalElement2, collection, xmlObject) && typeDerivationOK(schemaLocalElement.getType(), schemaLocalElement2.getType(), collection, xmlObject) && blockSetOK(schemaLocalElement, schemaLocalElement2, collection, xmlObject);
        }
        collection.add(XmlError.forObject("rcase-NameAndTypeOK.2", new Object[]{printParticle((SchemaParticle) schemaLocalElement2), printParticle(schemaParticle)}, xmlObject));
        return false;
    }

    private static boolean blockSetOK(SchemaLocalElement schemaLocalElement, SchemaLocalElement schemaLocalElement2, Collection collection, XmlObject xmlObject) {
        if (schemaLocalElement.blockRestriction() && !schemaLocalElement2.blockRestriction()) {
            collection.add(XmlError.forObject("rcase-NameAndTypeOK.6", new Object[]{printParticle((SchemaParticle) schemaLocalElement2), "restriction", printParticle((SchemaParticle) schemaLocalElement)}, xmlObject));
            return false;
        }
        if (schemaLocalElement.blockExtension() && !schemaLocalElement2.blockExtension()) {
            collection.add(XmlError.forObject("rcase-NameAndTypeOK.6", new Object[]{printParticle((SchemaParticle) schemaLocalElement2), "extension", printParticle((SchemaParticle) schemaLocalElement)}, xmlObject));
            return false;
        }
        if (!schemaLocalElement.blockSubstitution() || schemaLocalElement2.blockSubstitution()) {
            return true;
        }
        collection.add(XmlError.forObject("rcase-NameAndTypeOK.6", new Object[]{printParticle((SchemaParticle) schemaLocalElement2), "substitution", printParticle((SchemaParticle) schemaLocalElement)}, xmlObject));
        return false;
    }

    private static boolean typeDerivationOK(SchemaType schemaType, SchemaType schemaType2, Collection collection, XmlObject xmlObject) {
        if (schemaType.isAssignableFrom(schemaType2)) {
            return checkAllDerivationsForRestriction(schemaType, schemaType2, collection, xmlObject);
        }
        collection.add(XmlError.forObject("rcase-NameAndTypeOK.7a", new Object[]{printType(schemaType2), printType(schemaType)}, xmlObject));
        return false;
    }

    private static boolean checkAllDerivationsForRestriction(SchemaType schemaType, SchemaType schemaType2, Collection collection, XmlObject xmlObject) {
        HashSet hashSet = schemaType.getSimpleVariety() == 2 ? new HashSet(Arrays.asList(schemaType.getUnionConstituentTypes())) : null;
        for (SchemaType baseType = schemaType2; !schemaType.equals(baseType) && hashSet != null && !hashSet.contains(baseType); baseType = baseType.getBaseType()) {
            if (baseType.getDerivationType() != 1) {
                collection.add(XmlError.forObject("rcase-NameAndTypeOK.7b", new Object[]{printType(schemaType2), printType(schemaType), printType(baseType)}, xmlObject));
                return false;
            }
        }
        return true;
    }

    private static boolean checkIdentityConstraints(SchemaLocalElement schemaLocalElement, SchemaLocalElement schemaLocalElement2, Collection collection, XmlObject xmlObject) {
        SchemaIdentityConstraint[] identityConstraints = schemaLocalElement.getIdentityConstraints();
        for (SchemaIdentityConstraint schemaIdentityConstraint : schemaLocalElement2.getIdentityConstraints()) {
            if (checkForIdentityConstraintExistence(identityConstraints, schemaIdentityConstraint)) {
                collection.add(XmlError.forObject("rcase-NameAndTypeOK.5", new Object[]{printParticle((SchemaParticle) schemaLocalElement2), printParticle((SchemaParticle) schemaLocalElement)}, xmlObject));
                return false;
            }
        }
        return true;
    }

    private static boolean checkForIdentityConstraintExistence(SchemaIdentityConstraint[] schemaIdentityConstraintArr, SchemaIdentityConstraint schemaIdentityConstraint) {
        for (SchemaIdentityConstraint schemaIdentityConstraint2 : schemaIdentityConstraintArr) {
            if (schemaIdentityConstraint2.getName().equals(schemaIdentityConstraint.getName())) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkFixed(SchemaLocalElement schemaLocalElement, SchemaLocalElement schemaLocalElement2, Collection collection, XmlObject xmlObject) {
        if (!schemaLocalElement.isFixed() || schemaLocalElement.getDefaultText().equals(schemaLocalElement2.getDefaultText())) {
            return true;
        }
        collection.add(XmlError.forObject("rcase-NameAndTypeOK.4", new Object[]{printParticle((SchemaParticle) schemaLocalElement2), schemaLocalElement2.getDefaultText(), printParticle((SchemaParticle) schemaLocalElement), schemaLocalElement.getDefaultText()}, xmlObject));
        return false;
    }

    private static boolean occurrenceRangeOK(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection collection, XmlObject xmlObject) {
        if (schemaParticle2.getMinOccurs().compareTo(schemaParticle.getMinOccurs()) < 0) {
            collection.add(XmlError.forObject("range-ok.1", new Object[]{printParticle(schemaParticle2), schemaParticle2.getMinOccurs().toString(), printParticle(schemaParticle), schemaParticle.getMinOccurs().toString()}, xmlObject));
        } else {
            if (schemaParticle.getMaxOccurs() == null) {
                return true;
            }
            if (schemaParticle2.getMaxOccurs() != null && schemaParticle.getMaxOccurs() != null && schemaParticle2.getMaxOccurs().compareTo(schemaParticle.getMaxOccurs()) <= 0) {
                return true;
            }
            collection.add(XmlError.forObject("range-ok.2", new Object[]{printParticle(schemaParticle2), printMaxOccurs(schemaParticle2.getMaxOccurs()), printParticle(schemaParticle), printMaxOccurs(schemaParticle.getMaxOccurs())}, xmlObject));
        }
        return false;
    }

    private static String printParticles(List list) {
        return printParticles((SchemaParticle[]) list.toArray(new SchemaParticle[list.size()]));
    }

    private static String printParticles(SchemaParticle[] schemaParticleArr) {
        return printParticles(schemaParticleArr, 0, schemaParticleArr.length);
    }

    private static String printParticles(SchemaParticle[] schemaParticleArr, int i) {
        return printParticles(schemaParticleArr, i, schemaParticleArr.length);
    }

    private static String printParticles(SchemaParticle[] schemaParticleArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(schemaParticleArr.length * 30);
        while (i < i2) {
            stringBuffer.append(printParticle(schemaParticleArr[i]));
            i++;
            if (i != i2) {
                stringBuffer.append(", ");
            }
        }
        return stringBuffer.toString();
    }

    private static String printParticle(SchemaParticle schemaParticle) {
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1) {
            return "<all>";
        }
        if (particleType == 2) {
            return "<choice>";
        }
        if (particleType == 3) {
            return "<sequence>";
        }
        if (particleType != 4) {
            return particleType != 5 ? "??" : "<any>";
        }
        return "<element name=\"" + QNameHelper.pretty(schemaParticle.getName()) + "\">";
    }

    private static String printMaxOccurs(BigInteger bigInteger) {
        return bigInteger == null ? "unbounded" : bigInteger.toString();
    }

    private static String printType(SchemaType schemaType) {
        if (schemaType.getName() != null) {
            return QNameHelper.pretty(schemaType.getName());
        }
        return schemaType.toString();
    }

    private static void checkSubstitutionGroups(SchemaGlobalElement[] schemaGlobalElementArr) {
        StscState stscState = StscState.get();
        for (SchemaGlobalElement schemaGlobalElement : schemaGlobalElementArr) {
            SchemaGlobalElement schemaGlobalElementSubstitutionGroup = schemaGlobalElement.substitutionGroup();
            if (schemaGlobalElementSubstitutionGroup != null) {
                SchemaType type = schemaGlobalElementSubstitutionGroup.getType();
                SchemaType type2 = schemaGlobalElement.getType();
                XmlObject xmlObject = ((SchemaGlobalElementImpl) schemaGlobalElement)._parseObject;
                if (!type.isAssignableFrom(type2)) {
                    stscState.error("e-props-correct.4", new Object[]{QNameHelper.pretty(schemaGlobalElement.getName()), QNameHelper.pretty(schemaGlobalElementSubstitutionGroup.getName())}, xmlObject);
                } else if (schemaGlobalElementSubstitutionGroup.finalExtension() && schemaGlobalElementSubstitutionGroup.finalRestriction()) {
                    stscState.error("e-props-correct.4a", new Object[]{QNameHelper.pretty(schemaGlobalElement.getName()), QNameHelper.pretty(schemaGlobalElementSubstitutionGroup.getName()), "#all"}, xmlObject);
                } else if (!type.equals(type2)) {
                    if (schemaGlobalElementSubstitutionGroup.finalExtension() && type2.getDerivationType() == 2) {
                        stscState.error("e-props-correct.4a", new Object[]{QNameHelper.pretty(schemaGlobalElement.getName()), QNameHelper.pretty(schemaGlobalElementSubstitutionGroup.getName()), "extension"}, xmlObject);
                    } else if (schemaGlobalElementSubstitutionGroup.finalRestriction() && type2.getDerivationType() == 1) {
                        stscState.error("e-props-correct.4a", new Object[]{QNameHelper.pretty(schemaGlobalElement.getName()), QNameHelper.pretty(schemaGlobalElementSubstitutionGroup.getName()), "restriction"}, xmlObject);
                    }
                }
            }
        }
    }
}
