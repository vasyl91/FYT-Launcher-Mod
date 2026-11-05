package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import java.util.ArrayList;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
import org.apache.xmlbeans.impl.xb.xsdschema.GroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.NoFixedFacet;
import org.apache.xmlbeans.impl.xb.xsdschema.NumFacet;
import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType;
import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class RestrictionTypeImpl extends AnnotatedImpl implements RestrictionType {
    private static final long serialVersionUID = 1;
    private static final QName GROUP$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "group");
    private static final QName ALL$2 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "all");
    private static final QName CHOICE$4 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "choice");
    private static final QName SEQUENCE$6 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "sequence");
    private static final QName SIMPLETYPE$8 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "simpleType");
    private static final QName MINEXCLUSIVE$10 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "minExclusive");
    private static final QName MININCLUSIVE$12 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "minInclusive");
    private static final QName MAXEXCLUSIVE$14 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "maxExclusive");
    private static final QName MAXINCLUSIVE$16 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "maxInclusive");
    private static final QName TOTALDIGITS$18 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "totalDigits");
    private static final QName FRACTIONDIGITS$20 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "fractionDigits");
    private static final QName LENGTH$22 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "length");
    private static final QName MINLENGTH$24 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "minLength");
    private static final QName MAXLENGTH$26 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "maxLength");
    private static final QName ENUMERATION$28 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "enumeration");
    private static final QName WHITESPACE$30 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "whiteSpace");
    private static final QName PATTERN$32 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "pattern");
    private static final QName ATTRIBUTE$34 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "attribute");
    private static final QName ATTRIBUTEGROUP$36 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "attributeGroup");
    private static final QName ANYATTRIBUTE$38 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "anyAttribute");
    private static final QName BASE$40 = new QName("", "base");

    public RestrictionTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public GroupRef getGroup() {
        synchronized (monitor()) {
            check_orphaned();
            GroupRef groupRef = (GroupRef) get_store().find_element_user(GROUP$0, 0);
            if (groupRef == null) {
                return null;
            }
            return groupRef;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public boolean isSetGroup() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GROUP$0) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setGroup(GroupRef groupRef) {
        generatedSetterHelperImpl(groupRef, GROUP$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public GroupRef addNewGroup() {
        GroupRef groupRef;
        synchronized (monitor()) {
            check_orphaned();
            groupRef = (GroupRef) get_store().add_element_user(GROUP$0);
        }
        return groupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void unsetGroup() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GROUP$0, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public All getAll() {
        synchronized (monitor()) {
            check_orphaned();
            All all = (All) get_store().find_element_user(ALL$2, 0);
            if (all == null) {
                return null;
            }
            return all;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public boolean isSetAll() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ALL$2) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setAll(All all) {
        generatedSetterHelperImpl(all, ALL$2, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public All addNewAll() {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().add_element_user(ALL$2);
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void unsetAll() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALL$2, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public ExplicitGroup getChoice() {
        synchronized (monitor()) {
            check_orphaned();
            ExplicitGroup explicitGroup = (ExplicitGroup) get_store().find_element_user(CHOICE$4, 0);
            if (explicitGroup == null) {
                return null;
            }
            return explicitGroup;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public boolean isSetChoice() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CHOICE$4) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setChoice(ExplicitGroup explicitGroup) {
        generatedSetterHelperImpl(explicitGroup, CHOICE$4, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public ExplicitGroup addNewChoice() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(CHOICE$4);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void unsetChoice() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHOICE$4, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public ExplicitGroup getSequence() {
        synchronized (monitor()) {
            check_orphaned();
            ExplicitGroup explicitGroup = (ExplicitGroup) get_store().find_element_user(SEQUENCE$6, 0);
            if (explicitGroup == null) {
                return null;
            }
            return explicitGroup;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public boolean isSetSequence() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SEQUENCE$6) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setSequence(ExplicitGroup explicitGroup) {
        generatedSetterHelperImpl(explicitGroup, SEQUENCE$6, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public ExplicitGroup addNewSequence() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(SEQUENCE$6);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void unsetSequence() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SEQUENCE$6, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public LocalSimpleType getSimpleType() {
        synchronized (monitor()) {
            check_orphaned();
            LocalSimpleType localSimpleType = (LocalSimpleType) get_store().find_element_user(SIMPLETYPE$8, 0);
            if (localSimpleType == null) {
                return null;
            }
            return localSimpleType;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public boolean isSetSimpleType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIMPLETYPE$8) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setSimpleType(LocalSimpleType localSimpleType) {
        generatedSetterHelperImpl(localSimpleType, SIMPLETYPE$8, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public LocalSimpleType addNewSimpleType() {
        LocalSimpleType localSimpleType;
        synchronized (monitor()) {
            check_orphaned();
            localSimpleType = (LocalSimpleType) get_store().add_element_user(SIMPLETYPE$8);
        }
        return localSimpleType;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void unsetSimpleType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIMPLETYPE$8, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet[] getMinExclusiveArray() {
        Facet[] facetArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MINEXCLUSIVE$10, arrayList);
            facetArr = new Facet[arrayList.size()];
            arrayList.toArray(facetArr);
        }
        return facetArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet getMinExclusiveArray(int i) {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().find_element_user(MINEXCLUSIVE$10, i);
            if (facet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfMinExclusiveArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MINEXCLUSIVE$10);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMinExclusiveArray(Facet[] facetArr) {
        check_orphaned();
        arraySetterHelper(facetArr, MINEXCLUSIVE$10);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMinExclusiveArray(int i, Facet facet) {
        generatedSetterHelperImpl(facet, MINEXCLUSIVE$10, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet insertNewMinExclusive(int i) {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().insert_element_user(MINEXCLUSIVE$10, i);
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet addNewMinExclusive() {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().add_element_user(MINEXCLUSIVE$10);
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeMinExclusive(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MINEXCLUSIVE$10, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet[] getMinInclusiveArray() {
        Facet[] facetArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MININCLUSIVE$12, arrayList);
            facetArr = new Facet[arrayList.size()];
            arrayList.toArray(facetArr);
        }
        return facetArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet getMinInclusiveArray(int i) {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().find_element_user(MININCLUSIVE$12, i);
            if (facet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfMinInclusiveArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MININCLUSIVE$12);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMinInclusiveArray(Facet[] facetArr) {
        check_orphaned();
        arraySetterHelper(facetArr, MININCLUSIVE$12);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMinInclusiveArray(int i, Facet facet) {
        generatedSetterHelperImpl(facet, MININCLUSIVE$12, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet insertNewMinInclusive(int i) {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().insert_element_user(MININCLUSIVE$12, i);
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet addNewMinInclusive() {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().add_element_user(MININCLUSIVE$12);
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeMinInclusive(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MININCLUSIVE$12, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet[] getMaxExclusiveArray() {
        Facet[] facetArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MAXEXCLUSIVE$14, arrayList);
            facetArr = new Facet[arrayList.size()];
            arrayList.toArray(facetArr);
        }
        return facetArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet getMaxExclusiveArray(int i) {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().find_element_user(MAXEXCLUSIVE$14, i);
            if (facet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfMaxExclusiveArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MAXEXCLUSIVE$14);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMaxExclusiveArray(Facet[] facetArr) {
        check_orphaned();
        arraySetterHelper(facetArr, MAXEXCLUSIVE$14);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMaxExclusiveArray(int i, Facet facet) {
        generatedSetterHelperImpl(facet, MAXEXCLUSIVE$14, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet insertNewMaxExclusive(int i) {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().insert_element_user(MAXEXCLUSIVE$14, i);
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet addNewMaxExclusive() {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().add_element_user(MAXEXCLUSIVE$14);
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeMaxExclusive(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MAXEXCLUSIVE$14, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet[] getMaxInclusiveArray() {
        Facet[] facetArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MAXINCLUSIVE$16, arrayList);
            facetArr = new Facet[arrayList.size()];
            arrayList.toArray(facetArr);
        }
        return facetArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet getMaxInclusiveArray(int i) {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().find_element_user(MAXINCLUSIVE$16, i);
            if (facet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfMaxInclusiveArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MAXINCLUSIVE$16);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMaxInclusiveArray(Facet[] facetArr) {
        check_orphaned();
        arraySetterHelper(facetArr, MAXINCLUSIVE$16);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMaxInclusiveArray(int i, Facet facet) {
        generatedSetterHelperImpl(facet, MAXINCLUSIVE$16, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet insertNewMaxInclusive(int i) {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().insert_element_user(MAXINCLUSIVE$16, i);
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet addNewMaxInclusive() {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().add_element_user(MAXINCLUSIVE$16);
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeMaxInclusive(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MAXINCLUSIVE$16, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public TotalDigitsDocument.TotalDigits[] getTotalDigitsArray() {
        TotalDigitsDocument.TotalDigits[] totalDigitsArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TOTALDIGITS$18, arrayList);
            totalDigitsArr = new TotalDigitsDocument.TotalDigits[arrayList.size()];
            arrayList.toArray(totalDigitsArr);
        }
        return totalDigitsArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public TotalDigitsDocument.TotalDigits getTotalDigitsArray(int i) {
        TotalDigitsDocument.TotalDigits totalDigits;
        synchronized (monitor()) {
            check_orphaned();
            totalDigits = (TotalDigitsDocument.TotalDigits) get_store().find_element_user(TOTALDIGITS$18, i);
            if (totalDigits == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return totalDigits;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfTotalDigitsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TOTALDIGITS$18);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setTotalDigitsArray(TotalDigitsDocument.TotalDigits[] totalDigitsArr) {
        check_orphaned();
        arraySetterHelper(totalDigitsArr, TOTALDIGITS$18);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setTotalDigitsArray(int i, TotalDigitsDocument.TotalDigits totalDigits) {
        generatedSetterHelperImpl(totalDigits, TOTALDIGITS$18, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public TotalDigitsDocument.TotalDigits insertNewTotalDigits(int i) {
        TotalDigitsDocument.TotalDigits totalDigits;
        synchronized (monitor()) {
            check_orphaned();
            totalDigits = (TotalDigitsDocument.TotalDigits) get_store().insert_element_user(TOTALDIGITS$18, i);
        }
        return totalDigits;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public TotalDigitsDocument.TotalDigits addNewTotalDigits() {
        TotalDigitsDocument.TotalDigits totalDigits;
        synchronized (monitor()) {
            check_orphaned();
            totalDigits = (TotalDigitsDocument.TotalDigits) get_store().add_element_user(TOTALDIGITS$18);
        }
        return totalDigits;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeTotalDigits(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TOTALDIGITS$18, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet[] getFractionDigitsArray() {
        NumFacet[] numFacetArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FRACTIONDIGITS$20, arrayList);
            numFacetArr = new NumFacet[arrayList.size()];
            arrayList.toArray(numFacetArr);
        }
        return numFacetArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet getFractionDigitsArray(int i) {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().find_element_user(FRACTIONDIGITS$20, i);
            if (numFacet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfFractionDigitsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FRACTIONDIGITS$20);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setFractionDigitsArray(NumFacet[] numFacetArr) {
        check_orphaned();
        arraySetterHelper(numFacetArr, FRACTIONDIGITS$20);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setFractionDigitsArray(int i, NumFacet numFacet) {
        generatedSetterHelperImpl(numFacet, FRACTIONDIGITS$20, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet insertNewFractionDigits(int i) {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().insert_element_user(FRACTIONDIGITS$20, i);
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet addNewFractionDigits() {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().add_element_user(FRACTIONDIGITS$20);
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeFractionDigits(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FRACTIONDIGITS$20, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet[] getLengthArray() {
        NumFacet[] numFacetArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LENGTH$22, arrayList);
            numFacetArr = new NumFacet[arrayList.size()];
            arrayList.toArray(numFacetArr);
        }
        return numFacetArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet getLengthArray(int i) {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().find_element_user(LENGTH$22, i);
            if (numFacet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfLengthArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LENGTH$22);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setLengthArray(NumFacet[] numFacetArr) {
        check_orphaned();
        arraySetterHelper(numFacetArr, LENGTH$22);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setLengthArray(int i, NumFacet numFacet) {
        generatedSetterHelperImpl(numFacet, LENGTH$22, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet insertNewLength(int i) {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().insert_element_user(LENGTH$22, i);
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet addNewLength() {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().add_element_user(LENGTH$22);
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeLength(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LENGTH$22, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet[] getMinLengthArray() {
        NumFacet[] numFacetArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MINLENGTH$24, arrayList);
            numFacetArr = new NumFacet[arrayList.size()];
            arrayList.toArray(numFacetArr);
        }
        return numFacetArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet getMinLengthArray(int i) {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().find_element_user(MINLENGTH$24, i);
            if (numFacet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfMinLengthArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MINLENGTH$24);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMinLengthArray(NumFacet[] numFacetArr) {
        check_orphaned();
        arraySetterHelper(numFacetArr, MINLENGTH$24);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMinLengthArray(int i, NumFacet numFacet) {
        generatedSetterHelperImpl(numFacet, MINLENGTH$24, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet insertNewMinLength(int i) {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().insert_element_user(MINLENGTH$24, i);
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet addNewMinLength() {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().add_element_user(MINLENGTH$24);
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeMinLength(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MINLENGTH$24, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet[] getMaxLengthArray() {
        NumFacet[] numFacetArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MAXLENGTH$26, arrayList);
            numFacetArr = new NumFacet[arrayList.size()];
            arrayList.toArray(numFacetArr);
        }
        return numFacetArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet getMaxLengthArray(int i) {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().find_element_user(MAXLENGTH$26, i);
            if (numFacet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfMaxLengthArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MAXLENGTH$26);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMaxLengthArray(NumFacet[] numFacetArr) {
        check_orphaned();
        arraySetterHelper(numFacetArr, MAXLENGTH$26);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMaxLengthArray(int i, NumFacet numFacet) {
        generatedSetterHelperImpl(numFacet, MAXLENGTH$26, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet insertNewMaxLength(int i) {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().insert_element_user(MAXLENGTH$26, i);
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet addNewMaxLength() {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().add_element_user(MAXLENGTH$26);
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeMaxLength(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MAXLENGTH$26, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NoFixedFacet[] getEnumerationArray() {
        NoFixedFacet[] noFixedFacetArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ENUMERATION$28, arrayList);
            noFixedFacetArr = new NoFixedFacet[arrayList.size()];
            arrayList.toArray(noFixedFacetArr);
        }
        return noFixedFacetArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NoFixedFacet getEnumerationArray(int i) {
        NoFixedFacet noFixedFacet;
        synchronized (monitor()) {
            check_orphaned();
            noFixedFacet = (NoFixedFacet) get_store().find_element_user(ENUMERATION$28, i);
            if (noFixedFacet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return noFixedFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfEnumerationArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ENUMERATION$28);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setEnumerationArray(NoFixedFacet[] noFixedFacetArr) {
        check_orphaned();
        arraySetterHelper(noFixedFacetArr, ENUMERATION$28);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setEnumerationArray(int i, NoFixedFacet noFixedFacet) {
        generatedSetterHelperImpl(noFixedFacet, ENUMERATION$28, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NoFixedFacet insertNewEnumeration(int i) {
        NoFixedFacet noFixedFacet;
        synchronized (monitor()) {
            check_orphaned();
            noFixedFacet = (NoFixedFacet) get_store().insert_element_user(ENUMERATION$28, i);
        }
        return noFixedFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NoFixedFacet addNewEnumeration() {
        NoFixedFacet noFixedFacet;
        synchronized (monitor()) {
            check_orphaned();
            noFixedFacet = (NoFixedFacet) get_store().add_element_user(ENUMERATION$28);
        }
        return noFixedFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeEnumeration(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENUMERATION$28, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public WhiteSpaceDocument.WhiteSpace[] getWhiteSpaceArray() {
        WhiteSpaceDocument.WhiteSpace[] whiteSpaceArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(WHITESPACE$30, arrayList);
            whiteSpaceArr = new WhiteSpaceDocument.WhiteSpace[arrayList.size()];
            arrayList.toArray(whiteSpaceArr);
        }
        return whiteSpaceArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public WhiteSpaceDocument.WhiteSpace getWhiteSpaceArray(int i) {
        WhiteSpaceDocument.WhiteSpace whiteSpace;
        synchronized (monitor()) {
            check_orphaned();
            whiteSpace = (WhiteSpaceDocument.WhiteSpace) get_store().find_element_user(WHITESPACE$30, i);
            if (whiteSpace == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return whiteSpace;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfWhiteSpaceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(WHITESPACE$30);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setWhiteSpaceArray(WhiteSpaceDocument.WhiteSpace[] whiteSpaceArr) {
        check_orphaned();
        arraySetterHelper(whiteSpaceArr, WHITESPACE$30);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setWhiteSpaceArray(int i, WhiteSpaceDocument.WhiteSpace whiteSpace) {
        generatedSetterHelperImpl(whiteSpace, WHITESPACE$30, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public WhiteSpaceDocument.WhiteSpace insertNewWhiteSpace(int i) {
        WhiteSpaceDocument.WhiteSpace whiteSpace;
        synchronized (monitor()) {
            check_orphaned();
            whiteSpace = (WhiteSpaceDocument.WhiteSpace) get_store().insert_element_user(WHITESPACE$30, i);
        }
        return whiteSpace;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public WhiteSpaceDocument.WhiteSpace addNewWhiteSpace() {
        WhiteSpaceDocument.WhiteSpace whiteSpace;
        synchronized (monitor()) {
            check_orphaned();
            whiteSpace = (WhiteSpaceDocument.WhiteSpace) get_store().add_element_user(WHITESPACE$30);
        }
        return whiteSpace;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeWhiteSpace(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WHITESPACE$30, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public PatternDocument.Pattern[] getPatternArray() {
        PatternDocument.Pattern[] patternArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PATTERN$32, arrayList);
            patternArr = new PatternDocument.Pattern[arrayList.size()];
            arrayList.toArray(patternArr);
        }
        return patternArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public PatternDocument.Pattern getPatternArray(int i) {
        PatternDocument.Pattern pattern;
        synchronized (monitor()) {
            check_orphaned();
            pattern = (PatternDocument.Pattern) get_store().find_element_user(PATTERN$32, i);
            if (pattern == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return pattern;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfPatternArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PATTERN$32);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setPatternArray(PatternDocument.Pattern[] patternArr) {
        check_orphaned();
        arraySetterHelper(patternArr, PATTERN$32);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setPatternArray(int i, PatternDocument.Pattern pattern) {
        generatedSetterHelperImpl(pattern, PATTERN$32, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public PatternDocument.Pattern insertNewPattern(int i) {
        PatternDocument.Pattern pattern;
        synchronized (monitor()) {
            check_orphaned();
            pattern = (PatternDocument.Pattern) get_store().insert_element_user(PATTERN$32, i);
        }
        return pattern;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public PatternDocument.Pattern addNewPattern() {
        PatternDocument.Pattern pattern;
        synchronized (monitor()) {
            check_orphaned();
            pattern = (PatternDocument.Pattern) get_store().add_element_user(PATTERN$32);
        }
        return pattern;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removePattern(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATTERN$32, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Attribute[] getAttributeArray() {
        Attribute[] attributeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ATTRIBUTE$34, arrayList);
            attributeArr = new Attribute[arrayList.size()];
            arrayList.toArray(attributeArr);
        }
        return attributeArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Attribute getAttributeArray(int i) {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().find_element_user(ATTRIBUTE$34, i);
            if (attribute == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfAttributeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ATTRIBUTE$34);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setAttributeArray(Attribute[] attributeArr) {
        check_orphaned();
        arraySetterHelper(attributeArr, ATTRIBUTE$34);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setAttributeArray(int i, Attribute attribute) {
        generatedSetterHelperImpl(attribute, ATTRIBUTE$34, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Attribute insertNewAttribute(int i) {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().insert_element_user(ATTRIBUTE$34, i);
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Attribute addNewAttribute() {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().add_element_user(ATTRIBUTE$34);
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeAttribute(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ATTRIBUTE$34, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public AttributeGroupRef[] getAttributeGroupArray() {
        AttributeGroupRef[] attributeGroupRefArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ATTRIBUTEGROUP$36, arrayList);
            attributeGroupRefArr = new AttributeGroupRef[arrayList.size()];
            arrayList.toArray(attributeGroupRefArr);
        }
        return attributeGroupRefArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public AttributeGroupRef getAttributeGroupArray(int i) {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().find_element_user(ATTRIBUTEGROUP$36, i);
            if (attributeGroupRef == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfAttributeGroupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ATTRIBUTEGROUP$36);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setAttributeGroupArray(AttributeGroupRef[] attributeGroupRefArr) {
        check_orphaned();
        arraySetterHelper(attributeGroupRefArr, ATTRIBUTEGROUP$36);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setAttributeGroupArray(int i, AttributeGroupRef attributeGroupRef) {
        generatedSetterHelperImpl(attributeGroupRef, ATTRIBUTEGROUP$36, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public AttributeGroupRef insertNewAttributeGroup(int i) {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().insert_element_user(ATTRIBUTEGROUP$36, i);
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public AttributeGroupRef addNewAttributeGroup() {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().add_element_user(ATTRIBUTEGROUP$36);
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeAttributeGroup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ATTRIBUTEGROUP$36, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Wildcard getAnyAttribute() {
        synchronized (monitor()) {
            check_orphaned();
            Wildcard wildcard = (Wildcard) get_store().find_element_user(ANYATTRIBUTE$38, 0);
            if (wildcard == null) {
                return null;
            }
            return wildcard;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public boolean isSetAnyAttribute() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ANYATTRIBUTE$38) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setAnyAttribute(Wildcard wildcard) {
        generatedSetterHelperImpl(wildcard, ANYATTRIBUTE$38, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Wildcard addNewAnyAttribute() {
        Wildcard wildcard;
        synchronized (monitor()) {
            check_orphaned();
            wildcard = (Wildcard) get_store().add_element_user(ANYATTRIBUTE$38);
        }
        return wildcard;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void unsetAnyAttribute() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANYATTRIBUTE$38, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public QName getBase() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BASE$40);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public XmlQName xgetBase() {
        XmlQName xmlQNameFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlQNameFind_attribute_user = get_store().find_attribute_user(BASE$40);
        }
        return xmlQNameFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setBase(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = BASE$40;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName2);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValueFind_attribute_user.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void xsetBase(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BASE$40;
            XmlQName xmlQNameFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlQNameFind_attribute_user == null) {
                xmlQNameFind_attribute_user = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQNameFind_attribute_user.set(xmlQName);
        }
    }
}
