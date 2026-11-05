package org.openxmlformats.schemas.officeDocument.x2006.customProperties.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.PropertiesDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class PropertiesDocumentImpl extends XmlComplexContentImpl implements PropertiesDocument {
    private static final QName PROPERTIES$0 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/custom-properties", "Properties");

    public PropertiesDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.PropertiesDocument
    public CTProperties addNewProperties() {
        CTProperties cTProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTProperties = (CTProperties) get_store().add_element_user(PROPERTIES$0);
        }
        return cTProperties;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.PropertiesDocument
    public CTProperties getProperties() {
        synchronized (monitor()) {
            check_orphaned();
            CTProperties cTProperties = (CTProperties) get_store().find_element_user(PROPERTIES$0, 0);
            if (cTProperties == null) {
                return null;
            }
            return cTProperties;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.PropertiesDocument
    public void setProperties(CTProperties cTProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PROPERTIES$0;
            CTProperties cTProperties2 = (CTProperties) typeStore.find_element_user(qName, 0);
            if (cTProperties2 == null) {
                cTProperties2 = (CTProperties) get_store().add_element_user(qName);
            }
            cTProperties2.set(cTProperties);
        }
    }
}
