package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleDerivationSet;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SimpleTypeImpl extends AnnotatedImpl implements SimpleType {
    private static final long serialVersionUID = 1;
    private static final QName RESTRICTION$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "restriction");
    private static final QName LIST$2 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "list");
    private static final QName UNION$4 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "union");
    private static final QName FINAL$6 = new QName("", "final");
    private static final QName NAME$8 = new QName("", "name");

    public SimpleTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public RestrictionDocument.Restriction getRestriction() {
        synchronized (monitor()) {
            check_orphaned();
            RestrictionDocument.Restriction restriction = (RestrictionDocument.Restriction) get_store().find_element_user(RESTRICTION$0, 0);
            if (restriction == null) {
                return null;
            }
            return restriction;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public boolean isSetRestriction() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RESTRICTION$0) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void setRestriction(RestrictionDocument.Restriction restriction) {
        generatedSetterHelperImpl(restriction, RESTRICTION$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public RestrictionDocument.Restriction addNewRestriction() {
        RestrictionDocument.Restriction restriction;
        synchronized (monitor()) {
            check_orphaned();
            restriction = (RestrictionDocument.Restriction) get_store().add_element_user(RESTRICTION$0);
        }
        return restriction;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void unsetRestriction() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RESTRICTION$0, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public ListDocument.List getList() {
        synchronized (monitor()) {
            check_orphaned();
            ListDocument.List list = (ListDocument.List) get_store().find_element_user(LIST$2, 0);
            if (list == null) {
                return null;
            }
            return list;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public boolean isSetList() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LIST$2) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void setList(ListDocument.List list) {
        generatedSetterHelperImpl(list, LIST$2, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public ListDocument.List addNewList() {
        ListDocument.List list;
        synchronized (monitor()) {
            check_orphaned();
            list = (ListDocument.List) get_store().add_element_user(LIST$2);
        }
        return list;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void unsetList() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LIST$2, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public UnionDocument.Union getUnion() {
        synchronized (monitor()) {
            check_orphaned();
            UnionDocument.Union union = (UnionDocument.Union) get_store().find_element_user(UNION$4, 0);
            if (union == null) {
                return null;
            }
            return union;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public boolean isSetUnion() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UNION$4) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void setUnion(UnionDocument.Union union) {
        generatedSetterHelperImpl(union, UNION$4, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public UnionDocument.Union addNewUnion() {
        UnionDocument.Union union;
        synchronized (monitor()) {
            check_orphaned();
            union = (UnionDocument.Union) get_store().add_element_user(UNION$4);
        }
        return union;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void unsetUnion() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UNION$4, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public Object getFinal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FINAL$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getObjectValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public SimpleDerivationSet xgetFinal() {
        SimpleDerivationSet simpleDerivationSet;
        synchronized (monitor()) {
            check_orphaned();
            simpleDerivationSet = (SimpleDerivationSet) get_store().find_attribute_user(FINAL$6);
        }
        return simpleDerivationSet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public boolean isSetFinal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FINAL$6) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void setFinal(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FINAL$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setObjectValue(obj);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void xsetFinal(SimpleDerivationSet simpleDerivationSet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FINAL$6;
            SimpleDerivationSet simpleDerivationSet2 = (SimpleDerivationSet) typeStore.find_attribute_user(qName);
            if (simpleDerivationSet2 == null) {
                simpleDerivationSet2 = (SimpleDerivationSet) get_store().add_attribute_user(qName);
            }
            simpleDerivationSet2.set(simpleDerivationSet);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void unsetFinal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FINAL$6);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAME$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public XmlNCName xgetName() {
        XmlNCName xmlNCNameFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlNCNameFind_attribute_user = get_store().find_attribute_user(NAME$8);
        }
        return xmlNCNameFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$8) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void xsetName(XmlNCName xmlNCName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$8;
            XmlNCName xmlNCNameFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlNCNameFind_attribute_user == null) {
                xmlNCNameFind_attribute_user = (XmlNCName) get_store().add_attribute_user(qName);
            }
            xmlNCNameFind_attribute_user.set(xmlNCName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$8);
        }
    }
}
