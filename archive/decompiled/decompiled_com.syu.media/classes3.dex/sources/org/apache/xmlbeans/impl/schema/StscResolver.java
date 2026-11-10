package org.apache.xmlbeans.impl.schema;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.Element;
import org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class StscResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static void resolveAll() {
        StscState stscState = StscState.get();
        for (SchemaType schemaType : stscState.documentTypes()) {
            resolveSubstitutionGroup((SchemaTypeImpl) schemaType);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(stscState.documentTypes()));
        arrayList.addAll(Arrays.asList(stscState.attributeTypes()));
        arrayList.addAll(Arrays.asList(stscState.redefinedGlobalTypes()));
        arrayList.addAll(Arrays.asList(stscState.globalTypes()));
        for (int i = 0; i < arrayList.size(); i++) {
            SchemaType schemaType2 = (SchemaType) arrayList.get(i);
            resolveType((SchemaTypeImpl) schemaType2);
            arrayList.addAll(Arrays.asList(schemaType2.getAnonymousTypes()));
        }
        resolveIdentityConstraints();
    }

    public static boolean resolveType(SchemaTypeImpl schemaTypeImpl) {
        if (schemaTypeImpl.isResolved()) {
            return true;
        }
        if (schemaTypeImpl.isResolving()) {
            StscState.get().error("Cyclic dependency error", 13, schemaTypeImpl.getParseObject());
            return false;
        }
        schemaTypeImpl.startResolving();
        if (schemaTypeImpl.isDocumentType()) {
            resolveDocumentType(schemaTypeImpl);
        } else if (schemaTypeImpl.isAttributeType()) {
            resolveAttributeType(schemaTypeImpl);
        } else if (schemaTypeImpl.isSimpleType()) {
            StscSimpleTypeResolver.resolveSimpleType(schemaTypeImpl);
        } else {
            StscComplexTypeResolver.resolveComplexType(schemaTypeImpl);
        }
        schemaTypeImpl.finishResolving();
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0071  */
    /* JADX WARN: Code duplicated, block: B:20:0x0074  */
    /* JADX WARN: Code duplicated, block: B:23:0x007e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0071 -> B:19:0x0072). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:19:0x0072
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static boolean resolveSubstitutionGroup(org.apache.xmlbeans.impl.schema.SchemaTypeImpl r8) {
        /*
            boolean r0 = r8.isSGResolved()
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            boolean r0 = r8.isSGResolving()
            if (r0 == 0) goto L1f
            org.apache.xmlbeans.impl.schema.StscState r0 = org.apache.xmlbeans.impl.schema.StscState.get()
            r1 = 13
            org.apache.xmlbeans.XmlObject r8 = r8.getParseObject()
            java.lang.String r2 = "Cyclic dependency error"
            r0.error(r2, r1, r8)
            r8 = 0
            return r8
        L1f:
            r8.startResolvingSGs()
            org.apache.xmlbeans.XmlObject r0 = r8.getParseObject()
            org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement r0 = (org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement) r0
            javax.xml.namespace.QName r2 = new javax.xml.namespace.QName
            java.lang.String r3 = r8.getTargetNamespace()
            java.lang.String r4 = r0.getName()
            r2.<init>(r3, r4)
            boolean r3 = r0.isSetSubstitutionGroup()
            r4 = 0
            if (r3 == 0) goto L71
            org.apache.xmlbeans.impl.schema.StscState r3 = org.apache.xmlbeans.impl.schema.StscState.get()
            javax.xml.namespace.QName r5 = r0.getSubstitutionGroup()
            java.lang.String r6 = r8.getChameleonNamespace()
            java.lang.String r7 = r8.getTargetNamespace()
            org.apache.xmlbeans.impl.schema.SchemaTypeImpl r3 = r3.findDocumentType(r5, r6, r7)
            if (r3 != 0) goto L62
            org.apache.xmlbeans.impl.schema.StscState r5 = org.apache.xmlbeans.impl.schema.StscState.get()
            javax.xml.namespace.QName r6 = r0.getSubstitutionGroup()
            org.apache.xmlbeans.XmlQName r0 = r0.xgetSubstitutionGroup()
            r5.notFoundError(r6, r1, r0, r1)
            goto L72
        L62:
            boolean r5 = resolveSubstitutionGroup(r3)
            if (r5 != 0) goto L69
            goto L71
        L69:
            javax.xml.namespace.QName r0 = r0.getSubstitutionGroup()
            r8.setSubstitutionGroup(r0)
            goto L72
        L71:
            r3 = r4
        L72:
            if (r3 == 0) goto L95
            r3.addSubstitutionGroupMember(r2)
            javax.xml.namespace.QName r0 = r3.getSubstitutionGroup()
            if (r0 != 0) goto L7e
            goto L95
        L7e:
            org.apache.xmlbeans.impl.schema.StscState r0 = org.apache.xmlbeans.impl.schema.StscState.get()
            javax.xml.namespace.QName r5 = r3.getSubstitutionGroup()
            java.lang.String r3 = r3.getChameleonNamespace()
            org.apache.xmlbeans.impl.schema.SchemaTypeImpl r3 = r0.findDocumentType(r5, r3, r4)
            boolean r0 = resolveSubstitutionGroup(r3)
            if (r0 != 0) goto L72
            goto L71
        L95:
            r8.finishResolvingSGs()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.StscResolver.resolveSubstitutionGroup(org.apache.xmlbeans.impl.schema.SchemaTypeImpl):boolean");
    }

    public static void resolveDocumentType(SchemaTypeImpl schemaTypeImpl) {
        SchemaParticle schemaParticle;
        SchemaTypeImpl schemaTypeImplFindDocumentType;
        ArrayList arrayList = new ArrayList();
        SchemaGlobalElementImpl schemaGlobalElementImpl = (SchemaGlobalElementImpl) StscTranslator.translateElement((Element) schemaTypeImpl.getParseObject(), schemaTypeImpl.getTargetNamespace(), schemaTypeImpl.isChameleon(), null, null, arrayList, schemaTypeImpl);
        if (schemaGlobalElementImpl != null) {
            StscState.get().addGlobalElement(schemaGlobalElementImpl);
            SchemaLocalElementImpl schemaLocalElementImpl = new SchemaLocalElementImpl();
            schemaLocalElementImpl.setParticleType(4);
            StscTranslator.copyGlobalElementToLocalElement(schemaGlobalElementImpl, schemaLocalElementImpl);
            schemaLocalElementImpl.setMinOccurs(BigInteger.ONE);
            schemaLocalElementImpl.setMaxOccurs(BigInteger.ONE);
            schemaLocalElementImpl.setTransitionNotes(QNameSet.EMPTY, true);
            schemaParticle = schemaLocalElementImpl;
        } else {
            schemaParticle = null;
        }
        Map mapBuildContentPropertyModelByQName = StscComplexTypeResolver.buildContentPropertyModelByQName(schemaParticle, schemaTypeImpl);
        if (schemaTypeImpl.getSubstitutionGroup() == null) {
            schemaTypeImplFindDocumentType = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
        } else {
            schemaTypeImplFindDocumentType = StscState.get().findDocumentType(schemaTypeImpl.getSubstitutionGroup(), schemaTypeImpl.isChameleon() ? schemaTypeImpl.getTargetNamespace() : null, null);
        }
        schemaTypeImpl.setBaseTypeRef(schemaTypeImplFindDocumentType.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImplFindDocumentType.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        schemaTypeImpl.setComplexTypeVariety(3);
        schemaTypeImpl.setContentModel(schemaParticle, new SchemaAttributeModelImpl(), mapBuildContentPropertyModelByQName, Collections.EMPTY_MAP, false);
        schemaTypeImpl.setWildcardSummary(QNameSet.EMPTY, false, QNameSet.EMPTY, false);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
    }

    public static void resolveAttributeType(SchemaTypeImpl schemaTypeImpl) {
        ArrayList arrayList = new ArrayList();
        SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = (SchemaGlobalAttributeImpl) StscTranslator.translateAttribute((Attribute) schemaTypeImpl.getParseObject(), schemaTypeImpl.getTargetNamespace(), null, schemaTypeImpl.isChameleon(), arrayList, schemaTypeImpl, null, false);
        SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
        if (schemaGlobalAttributeImpl != null) {
            StscState.get().addGlobalAttribute(schemaGlobalAttributeImpl);
            SchemaLocalAttributeImpl schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
            StscTranslator.copyGlobalAttributeToLocalAttribute(schemaGlobalAttributeImpl, schemaLocalAttributeImpl);
            schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl);
        }
        schemaTypeImpl.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_TYPE.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImpl.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        schemaTypeImpl.setComplexTypeVariety(1);
        schemaTypeImpl.setContentModel(null, schemaAttributeModelImpl, Collections.EMPTY_MAP, StscComplexTypeResolver.buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl), false);
        schemaTypeImpl.setWildcardSummary(QNameSet.EMPTY, false, QNameSet.EMPTY, false);
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

    public static void resolveIdentityConstraints() {
        StscState stscState = StscState.get();
        SchemaIdentityConstraintImpl[] schemaIdentityConstraintImplArrIdConstraints = stscState.idConstraints();
        for (int i = 0; i < schemaIdentityConstraintImplArrIdConstraints.length; i++) {
            if (!schemaIdentityConstraintImplArrIdConstraints[i].isResolved()) {
                KeyrefDocument.Keyref keyref = (KeyrefDocument.Keyref) schemaIdentityConstraintImplArrIdConstraints[i].getParseObject();
                QName refer = keyref.getRefer();
                SchemaIdentityConstraintImpl schemaIdentityConstraintImplFindIdConstraint = stscState.findIdConstraint(refer, schemaIdentityConstraintImplArrIdConstraints[i].getChameleonNamespace(), schemaIdentityConstraintImplArrIdConstraints[i].getTargetNamespace());
                if (schemaIdentityConstraintImplFindIdConstraint == null) {
                    stscState.notFoundError(refer, 5, keyref, true);
                } else {
                    if (schemaIdentityConstraintImplFindIdConstraint.getConstraintCategory() == 2) {
                        stscState.error("c-props-correct.1", (Object[]) null, schemaIdentityConstraintImplArrIdConstraints[i].getParseObject());
                    }
                    if (schemaIdentityConstraintImplFindIdConstraint.getFields().length != schemaIdentityConstraintImplArrIdConstraints[i].getFields().length) {
                        stscState.error("c-props-correct.2", (Object[]) null, schemaIdentityConstraintImplArrIdConstraints[i].getParseObject());
                    }
                    schemaIdentityConstraintImplArrIdConstraints[i].setReferencedKey(schemaIdentityConstraintImplFindIdConstraint.getRef());
                }
            }
        }
    }
}
