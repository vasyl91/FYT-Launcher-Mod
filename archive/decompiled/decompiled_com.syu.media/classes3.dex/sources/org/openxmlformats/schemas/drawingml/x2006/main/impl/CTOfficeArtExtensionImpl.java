package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtension;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTOfficeArtExtensionImpl extends XmlComplexContentImpl implements CTOfficeArtExtension {
    private static final QName URI$0 = new QName("", "uri");

    public CTOfficeArtExtensionImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtension
    public String getUri() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(URI$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtension
    public boolean isSetUri() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(URI$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtension
    public void setUri(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtension
    public void unsetUri() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(URI$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtension
    public XmlToken xgetUri() {
        XmlToken xmlTokenFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlTokenFind_attribute_user = get_store().find_attribute_user(URI$0);
        }
        return xmlTokenFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtension
    public void xsetUri(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$0;
            XmlToken xmlTokenFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlTokenFind_attribute_user == null) {
                xmlTokenFind_attribute_user = (XmlToken) get_store().add_attribute_user(qName);
            }
            xmlTokenFind_attribute_user.set(xmlToken);
        }
    }
}
