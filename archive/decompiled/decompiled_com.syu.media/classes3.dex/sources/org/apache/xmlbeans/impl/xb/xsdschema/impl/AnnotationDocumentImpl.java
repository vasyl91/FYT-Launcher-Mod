package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import java.util.ArrayList;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class AnnotationDocumentImpl extends XmlComplexContentImpl implements AnnotationDocument {
    private static final QName ANNOTATION$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, JamXmlElements.ANNOTATION);
    private static final long serialVersionUID = 1;

    public AnnotationDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument
    public AnnotationDocument.Annotation getAnnotation() {
        synchronized (monitor()) {
            check_orphaned();
            AnnotationDocument.Annotation annotation = (AnnotationDocument.Annotation) get_store().find_element_user(ANNOTATION$0, 0);
            if (annotation == null) {
                return null;
            }
            return annotation;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument
    public void setAnnotation(AnnotationDocument.Annotation annotation) {
        generatedSetterHelperImpl(annotation, ANNOTATION$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument
    public AnnotationDocument.Annotation addNewAnnotation() {
        AnnotationDocument.Annotation annotation;
        synchronized (monitor()) {
            check_orphaned();
            annotation = (AnnotationDocument.Annotation) get_store().add_element_user(ANNOTATION$0);
        }
        return annotation;
    }

    public static class AnnotationImpl extends OpenAttrsImpl implements AnnotationDocument.Annotation {
        private static final QName APPINFO$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "appinfo");
        private static final QName DOCUMENTATION$2 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "documentation");
        private static final QName ID$4 = new QName("", "id");
        private static final long serialVersionUID = 1;

        public AnnotationImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public AppinfoDocument.Appinfo[] getAppinfoArray() {
            AppinfoDocument.Appinfo[] appinfoArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(APPINFO$0, arrayList);
                appinfoArr = new AppinfoDocument.Appinfo[arrayList.size()];
                arrayList.toArray(appinfoArr);
            }
            return appinfoArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public AppinfoDocument.Appinfo getAppinfoArray(int i) {
            AppinfoDocument.Appinfo appinfo;
            synchronized (monitor()) {
                check_orphaned();
                appinfo = (AppinfoDocument.Appinfo) get_store().find_element_user(APPINFO$0, i);
                if (appinfo == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return appinfo;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public int sizeOfAppinfoArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(APPINFO$0);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void setAppinfoArray(AppinfoDocument.Appinfo[] appinfoArr) {
            check_orphaned();
            arraySetterHelper(appinfoArr, APPINFO$0);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void setAppinfoArray(int i, AppinfoDocument.Appinfo appinfo) {
            generatedSetterHelperImpl(appinfo, APPINFO$0, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public AppinfoDocument.Appinfo insertNewAppinfo(int i) {
            AppinfoDocument.Appinfo appinfo;
            synchronized (monitor()) {
                check_orphaned();
                appinfo = (AppinfoDocument.Appinfo) get_store().insert_element_user(APPINFO$0, i);
            }
            return appinfo;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public AppinfoDocument.Appinfo addNewAppinfo() {
            AppinfoDocument.Appinfo appinfo;
            synchronized (monitor()) {
                check_orphaned();
                appinfo = (AppinfoDocument.Appinfo) get_store().add_element_user(APPINFO$0);
            }
            return appinfo;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void removeAppinfo(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(APPINFO$0, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public DocumentationDocument.Documentation[] getDocumentationArray() {
            DocumentationDocument.Documentation[] documentationArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(DOCUMENTATION$2, arrayList);
                documentationArr = new DocumentationDocument.Documentation[arrayList.size()];
                arrayList.toArray(documentationArr);
            }
            return documentationArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public DocumentationDocument.Documentation getDocumentationArray(int i) {
            DocumentationDocument.Documentation documentation;
            synchronized (monitor()) {
                check_orphaned();
                documentation = (DocumentationDocument.Documentation) get_store().find_element_user(DOCUMENTATION$2, i);
                if (documentation == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return documentation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public int sizeOfDocumentationArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(DOCUMENTATION$2);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void setDocumentationArray(DocumentationDocument.Documentation[] documentationArr) {
            check_orphaned();
            arraySetterHelper(documentationArr, DOCUMENTATION$2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void setDocumentationArray(int i, DocumentationDocument.Documentation documentation) {
            generatedSetterHelperImpl(documentation, DOCUMENTATION$2, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public DocumentationDocument.Documentation insertNewDocumentation(int i) {
            DocumentationDocument.Documentation documentation;
            synchronized (monitor()) {
                check_orphaned();
                documentation = (DocumentationDocument.Documentation) get_store().insert_element_user(DOCUMENTATION$2, i);
            }
            return documentation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public DocumentationDocument.Documentation addNewDocumentation() {
            DocumentationDocument.Documentation documentation;
            synchronized (monitor()) {
                check_orphaned();
                documentation = (DocumentationDocument.Documentation) get_store().add_element_user(DOCUMENTATION$2);
            }
            return documentation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void removeDocumentation(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(DOCUMENTATION$2, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public String getId() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$4);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public XmlID xgetId() {
            XmlID xmlIDFind_attribute_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlIDFind_attribute_user = get_store().find_attribute_user(ID$4);
            }
            return xmlIDFind_attribute_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public boolean isSetId() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(ID$4) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void setId(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$4;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void xsetId(XmlID xmlID) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$4;
                XmlID xmlIDFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlIDFind_attribute_user == null) {
                    xmlIDFind_attribute_user = (XmlID) get_store().add_attribute_user(qName);
                }
                xmlIDFind_attribute_user.set(xmlID);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void unsetId() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(ID$4);
            }
        }
    }
}
