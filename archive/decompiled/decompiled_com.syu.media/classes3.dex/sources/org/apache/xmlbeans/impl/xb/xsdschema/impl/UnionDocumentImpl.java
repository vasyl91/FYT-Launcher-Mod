package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class UnionDocumentImpl extends XmlComplexContentImpl implements UnionDocument {
    private static final QName UNION$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "union");
    private static final long serialVersionUID = 1;

    public UnionDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument
    public UnionDocument.Union getUnion() {
        synchronized (monitor()) {
            check_orphaned();
            UnionDocument.Union union = (UnionDocument.Union) get_store().find_element_user(UNION$0, 0);
            if (union == null) {
                return null;
            }
            return union;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument
    public void setUnion(UnionDocument.Union union) {
        generatedSetterHelperImpl(union, UNION$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument
    public UnionDocument.Union addNewUnion() {
        UnionDocument.Union union;
        synchronized (monitor()) {
            check_orphaned();
            union = (UnionDocument.Union) get_store().add_element_user(UNION$0);
        }
        return union;
    }

    public static class UnionImpl extends AnnotatedImpl implements UnionDocument.Union {
        private static final long serialVersionUID = 1;
        private static final QName SIMPLETYPE$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "simpleType");
        private static final QName MEMBERTYPES$2 = new QName("", "memberTypes");

        public UnionImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public LocalSimpleType[] getSimpleTypeArray() {
            LocalSimpleType[] localSimpleTypeArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(SIMPLETYPE$0, arrayList);
                localSimpleTypeArr = new LocalSimpleType[arrayList.size()];
                arrayList.toArray(localSimpleTypeArr);
            }
            return localSimpleTypeArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public LocalSimpleType getSimpleTypeArray(int i) {
            LocalSimpleType localSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                localSimpleType = (LocalSimpleType) get_store().find_element_user(SIMPLETYPE$0, i);
                if (localSimpleType == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return localSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public int sizeOfSimpleTypeArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(SIMPLETYPE$0);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public void setSimpleTypeArray(LocalSimpleType[] localSimpleTypeArr) {
            check_orphaned();
            arraySetterHelper(localSimpleTypeArr, SIMPLETYPE$0);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public void setSimpleTypeArray(int i, LocalSimpleType localSimpleType) {
            generatedSetterHelperImpl(localSimpleType, SIMPLETYPE$0, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public LocalSimpleType insertNewSimpleType(int i) {
            LocalSimpleType localSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                localSimpleType = (LocalSimpleType) get_store().insert_element_user(SIMPLETYPE$0, i);
            }
            return localSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public LocalSimpleType addNewSimpleType() {
            LocalSimpleType localSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                localSimpleType = (LocalSimpleType) get_store().add_element_user(SIMPLETYPE$0);
            }
            return localSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public void removeSimpleType(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(SIMPLETYPE$0, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public List getMemberTypes() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(MEMBERTYPES$2);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getListValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public UnionDocument.Union.MemberTypes xgetMemberTypes() {
            UnionDocument.Union.MemberTypes memberTypes;
            synchronized (monitor()) {
                check_orphaned();
                memberTypes = (UnionDocument.Union.MemberTypes) get_store().find_attribute_user(MEMBERTYPES$2);
            }
            return memberTypes;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public boolean isSetMemberTypes() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(MEMBERTYPES$2) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public void setMemberTypes(List list) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MEMBERTYPES$2;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setListValue(list);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public void xsetMemberTypes(UnionDocument.Union.MemberTypes memberTypes) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MEMBERTYPES$2;
                UnionDocument.Union.MemberTypes memberTypes2 = (UnionDocument.Union.MemberTypes) typeStore.find_attribute_user(qName);
                if (memberTypes2 == null) {
                    memberTypes2 = (UnionDocument.Union.MemberTypes) get_store().add_attribute_user(qName);
                }
                memberTypes2.set((XmlObject) memberTypes);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public void unsetMemberTypes() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(MEMBERTYPES$2);
            }
        }

        public static class MemberTypesImpl extends XmlListImpl implements UnionDocument.Union.MemberTypes {
            private static final long serialVersionUID = 1;

            public MemberTypesImpl(SchemaType schemaType) {
                super(schemaType, false);
            }

            protected MemberTypesImpl(SchemaType schemaType, boolean z) {
                super(schemaType, z);
            }
        }
    }
}
