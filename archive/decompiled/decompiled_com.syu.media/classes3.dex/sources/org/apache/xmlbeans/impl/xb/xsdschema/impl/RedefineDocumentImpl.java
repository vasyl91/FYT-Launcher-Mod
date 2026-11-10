package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import java.util.ArrayList;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class RedefineDocumentImpl extends XmlComplexContentImpl implements RedefineDocument {
    private static final QName REDEFINE$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "redefine");
    private static final long serialVersionUID = 1;

    public RedefineDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument
    public RedefineDocument.Redefine getRedefine() {
        synchronized (monitor()) {
            check_orphaned();
            RedefineDocument.Redefine redefine = (RedefineDocument.Redefine) get_store().find_element_user(REDEFINE$0, 0);
            if (redefine == null) {
                return null;
            }
            return redefine;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument
    public void setRedefine(RedefineDocument.Redefine redefine) {
        generatedSetterHelperImpl(redefine, REDEFINE$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument
    public RedefineDocument.Redefine addNewRedefine() {
        RedefineDocument.Redefine redefine;
        synchronized (monitor()) {
            check_orphaned();
            redefine = (RedefineDocument.Redefine) get_store().add_element_user(REDEFINE$0);
        }
        return redefine;
    }

    public static class RedefineImpl extends OpenAttrsImpl implements RedefineDocument.Redefine {
        private static final long serialVersionUID = 1;
        private static final QName ANNOTATION$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, JamXmlElements.ANNOTATION);
        private static final QName SIMPLETYPE$2 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "simpleType");
        private static final QName COMPLEXTYPE$4 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "complexType");
        private static final QName GROUP$6 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "group");
        private static final QName ATTRIBUTEGROUP$8 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "attributeGroup");
        private static final QName SCHEMALOCATION$10 = new QName("", "schemaLocation");
        private static final QName ID$12 = new QName("", "id");

        public RedefineImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public AnnotationDocument.Annotation[] getAnnotationArray() {
            AnnotationDocument.Annotation[] annotationArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(ANNOTATION$0, arrayList);
                annotationArr = new AnnotationDocument.Annotation[arrayList.size()];
                arrayList.toArray(annotationArr);
            }
            return annotationArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public AnnotationDocument.Annotation getAnnotationArray(int i) {
            AnnotationDocument.Annotation annotation;
            synchronized (monitor()) {
                check_orphaned();
                annotation = (AnnotationDocument.Annotation) get_store().find_element_user(ANNOTATION$0, i);
                if (annotation == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return annotation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public int sizeOfAnnotationArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(ANNOTATION$0);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void setAnnotationArray(AnnotationDocument.Annotation[] annotationArr) {
            check_orphaned();
            arraySetterHelper(annotationArr, ANNOTATION$0);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void setAnnotationArray(int i, AnnotationDocument.Annotation annotation) {
            generatedSetterHelperImpl(annotation, ANNOTATION$0, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public AnnotationDocument.Annotation insertNewAnnotation(int i) {
            AnnotationDocument.Annotation annotation;
            synchronized (monitor()) {
                check_orphaned();
                annotation = (AnnotationDocument.Annotation) get_store().insert_element_user(ANNOTATION$0, i);
            }
            return annotation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public AnnotationDocument.Annotation addNewAnnotation() {
            AnnotationDocument.Annotation annotation;
            synchronized (monitor()) {
                check_orphaned();
                annotation = (AnnotationDocument.Annotation) get_store().add_element_user(ANNOTATION$0);
            }
            return annotation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void removeAnnotation(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(ANNOTATION$0, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public TopLevelSimpleType[] getSimpleTypeArray() {
            TopLevelSimpleType[] topLevelSimpleTypeArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(SIMPLETYPE$2, arrayList);
                topLevelSimpleTypeArr = new TopLevelSimpleType[arrayList.size()];
                arrayList.toArray(topLevelSimpleTypeArr);
            }
            return topLevelSimpleTypeArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public TopLevelSimpleType getSimpleTypeArray(int i) {
            TopLevelSimpleType topLevelSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelSimpleType = (TopLevelSimpleType) get_store().find_element_user(SIMPLETYPE$2, i);
                if (topLevelSimpleType == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return topLevelSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public int sizeOfSimpleTypeArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(SIMPLETYPE$2);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void setSimpleTypeArray(TopLevelSimpleType[] topLevelSimpleTypeArr) {
            check_orphaned();
            arraySetterHelper(topLevelSimpleTypeArr, SIMPLETYPE$2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void setSimpleTypeArray(int i, TopLevelSimpleType topLevelSimpleType) {
            generatedSetterHelperImpl(topLevelSimpleType, SIMPLETYPE$2, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public TopLevelSimpleType insertNewSimpleType(int i) {
            TopLevelSimpleType topLevelSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelSimpleType = (TopLevelSimpleType) get_store().insert_element_user(SIMPLETYPE$2, i);
            }
            return topLevelSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public TopLevelSimpleType addNewSimpleType() {
            TopLevelSimpleType topLevelSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelSimpleType = (TopLevelSimpleType) get_store().add_element_user(SIMPLETYPE$2);
            }
            return topLevelSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void removeSimpleType(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(SIMPLETYPE$2, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public TopLevelComplexType[] getComplexTypeArray() {
            TopLevelComplexType[] topLevelComplexTypeArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(COMPLEXTYPE$4, arrayList);
                topLevelComplexTypeArr = new TopLevelComplexType[arrayList.size()];
                arrayList.toArray(topLevelComplexTypeArr);
            }
            return topLevelComplexTypeArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public TopLevelComplexType getComplexTypeArray(int i) {
            TopLevelComplexType topLevelComplexType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelComplexType = (TopLevelComplexType) get_store().find_element_user(COMPLEXTYPE$4, i);
                if (topLevelComplexType == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return topLevelComplexType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public int sizeOfComplexTypeArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(COMPLEXTYPE$4);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void setComplexTypeArray(TopLevelComplexType[] topLevelComplexTypeArr) {
            check_orphaned();
            arraySetterHelper(topLevelComplexTypeArr, COMPLEXTYPE$4);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void setComplexTypeArray(int i, TopLevelComplexType topLevelComplexType) {
            generatedSetterHelperImpl(topLevelComplexType, COMPLEXTYPE$4, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public TopLevelComplexType insertNewComplexType(int i) {
            TopLevelComplexType topLevelComplexType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelComplexType = (TopLevelComplexType) get_store().insert_element_user(COMPLEXTYPE$4, i);
            }
            return topLevelComplexType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public TopLevelComplexType addNewComplexType() {
            TopLevelComplexType topLevelComplexType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelComplexType = (TopLevelComplexType) get_store().add_element_user(COMPLEXTYPE$4);
            }
            return topLevelComplexType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void removeComplexType(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(COMPLEXTYPE$4, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public NamedGroup[] getGroupArray() {
            NamedGroup[] namedGroupArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(GROUP$6, arrayList);
                namedGroupArr = new NamedGroup[arrayList.size()];
                arrayList.toArray(namedGroupArr);
            }
            return namedGroupArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public NamedGroup getGroupArray(int i) {
            NamedGroup namedGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedGroup = (NamedGroup) get_store().find_element_user(GROUP$6, i);
                if (namedGroup == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return namedGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public int sizeOfGroupArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(GROUP$6);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void setGroupArray(NamedGroup[] namedGroupArr) {
            check_orphaned();
            arraySetterHelper(namedGroupArr, GROUP$6);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void setGroupArray(int i, NamedGroup namedGroup) {
            generatedSetterHelperImpl(namedGroup, GROUP$6, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public NamedGroup insertNewGroup(int i) {
            NamedGroup namedGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedGroup = (NamedGroup) get_store().insert_element_user(GROUP$6, i);
            }
            return namedGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public NamedGroup addNewGroup() {
            NamedGroup namedGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedGroup = (NamedGroup) get_store().add_element_user(GROUP$6);
            }
            return namedGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void removeGroup(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(GROUP$6, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public NamedAttributeGroup[] getAttributeGroupArray() {
            NamedAttributeGroup[] namedAttributeGroupArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(ATTRIBUTEGROUP$8, arrayList);
                namedAttributeGroupArr = new NamedAttributeGroup[arrayList.size()];
                arrayList.toArray(namedAttributeGroupArr);
            }
            return namedAttributeGroupArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public NamedAttributeGroup getAttributeGroupArray(int i) {
            NamedAttributeGroup namedAttributeGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedAttributeGroup = (NamedAttributeGroup) get_store().find_element_user(ATTRIBUTEGROUP$8, i);
                if (namedAttributeGroup == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return namedAttributeGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public int sizeOfAttributeGroupArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(ATTRIBUTEGROUP$8);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void setAttributeGroupArray(NamedAttributeGroup[] namedAttributeGroupArr) {
            check_orphaned();
            arraySetterHelper(namedAttributeGroupArr, ATTRIBUTEGROUP$8);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void setAttributeGroupArray(int i, NamedAttributeGroup namedAttributeGroup) {
            generatedSetterHelperImpl(namedAttributeGroup, ATTRIBUTEGROUP$8, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public NamedAttributeGroup insertNewAttributeGroup(int i) {
            NamedAttributeGroup namedAttributeGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedAttributeGroup = (NamedAttributeGroup) get_store().insert_element_user(ATTRIBUTEGROUP$8, i);
            }
            return namedAttributeGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public NamedAttributeGroup addNewAttributeGroup() {
            NamedAttributeGroup namedAttributeGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedAttributeGroup = (NamedAttributeGroup) get_store().add_element_user(ATTRIBUTEGROUP$8);
            }
            return namedAttributeGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void removeAttributeGroup(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(ATTRIBUTEGROUP$8, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public String getSchemaLocation() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SCHEMALOCATION$10);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public XmlAnyURI xgetSchemaLocation() {
            XmlAnyURI xmlAnyURIFind_attribute_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlAnyURIFind_attribute_user = get_store().find_attribute_user(SCHEMALOCATION$10);
            }
            return xmlAnyURIFind_attribute_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void setSchemaLocation(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SCHEMALOCATION$10;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void xsetSchemaLocation(XmlAnyURI xmlAnyURI) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SCHEMALOCATION$10;
                XmlAnyURI xmlAnyURIFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlAnyURIFind_attribute_user == null) {
                    xmlAnyURIFind_attribute_user = (XmlAnyURI) get_store().add_attribute_user(qName);
                }
                xmlAnyURIFind_attribute_user.set(xmlAnyURI);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public String getId() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$12);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public XmlID xgetId() {
            XmlID xmlIDFind_attribute_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlIDFind_attribute_user = get_store().find_attribute_user(ID$12);
            }
            return xmlIDFind_attribute_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public boolean isSetId() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(ID$12) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void setId(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$12;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void xsetId(XmlID xmlID) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$12;
                XmlID xmlIDFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlIDFind_attribute_user == null) {
                    xmlIDFind_attribute_user = (XmlID) get_store().add_attribute_user(qName);
                }
                xmlIDFind_attribute_user.set(xmlID);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument.Redefine
        public void unsetId() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(ID$12);
            }
        }
    }
}
