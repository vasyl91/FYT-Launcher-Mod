package org.w3.x2000.x09.xmldsig.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.w3.x2000.x09.xmldsig.TransformDocument;
import org.w3.x2000.x09.xmldsig.TransformType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class TransformDocumentImpl extends XmlComplexContentImpl implements TransformDocument {
    private static final QName TRANSFORM$0 = new QName("http://www.w3.org/2000/09/xmldsig#", "Transform");

    public TransformDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformDocument
    public TransformType addNewTransform() {
        TransformType transformTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            transformTypeAdd_element_user = get_store().add_element_user(TRANSFORM$0);
        }
        return transformTypeAdd_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformDocument
    public TransformType getTransform() {
        synchronized (monitor()) {
            check_orphaned();
            TransformType transformTypeFind_element_user = get_store().find_element_user(TRANSFORM$0, 0);
            if (transformTypeFind_element_user == null) {
                return null;
            }
            return transformTypeFind_element_user;
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformDocument
    public void setTransform(TransformType transformType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRANSFORM$0;
            TransformType transformTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (transformTypeFind_element_user == null) {
                transformTypeFind_element_user = (TransformType) get_store().add_element_user(qName);
            }
            transformTypeFind_element_user.set(transformType);
        }
    }
}
