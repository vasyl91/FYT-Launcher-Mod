package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.Annotated;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class AnnotatedImpl extends OpenAttrsImpl implements Annotated {
    private static final QName ANNOTATION$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, JamXmlElements.ANNOTATION);
    private static final QName ID$2 = new QName("", "id");
    private static final long serialVersionUID = 1;

    public AnnotatedImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
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

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public boolean isSetAnnotation() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ANNOTATION$0) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public void setAnnotation(AnnotationDocument.Annotation annotation) {
        generatedSetterHelperImpl(annotation, ANNOTATION$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public AnnotationDocument.Annotation addNewAnnotation() {
        AnnotationDocument.Annotation annotation;
        synchronized (monitor()) {
            check_orphaned();
            annotation = (AnnotationDocument.Annotation) get_store().add_element_user(ANNOTATION$0);
        }
        return annotation;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public void unsetAnnotation() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANNOTATION$0, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public XmlID xgetId() {
        XmlID xmlIDFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIDFind_attribute_user = get_store().find_attribute_user(ID$2);
        }
        return xmlIDFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$2) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public void xsetId(XmlID xmlID) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$2;
            XmlID xmlIDFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIDFind_attribute_user == null) {
                xmlIDFind_attribute_user = (XmlID) get_store().add_attribute_user(qName);
            }
            xmlIDFind_attribute_user.set(xmlID);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$2);
        }
    }
}
