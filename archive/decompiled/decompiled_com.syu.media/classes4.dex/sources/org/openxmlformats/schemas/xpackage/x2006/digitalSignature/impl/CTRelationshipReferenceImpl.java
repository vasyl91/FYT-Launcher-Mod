package org.openxmlformats.schemas.xpackage.x2006.digitalSignature.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.JavaStringHolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTRelationshipReference;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTRelationshipReferenceImpl extends JavaStringHolderEx implements CTRelationshipReference {
    private static final QName SOURCEID$0 = new QName("", "SourceId");

    public CTRelationshipReferenceImpl(SchemaType schemaType) {
        super(schemaType, true);
    }

    protected CTRelationshipReferenceImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTRelationshipReference
    public String getSourceId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SOURCEID$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTRelationshipReference
    public void setSourceId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SOURCEID$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTRelationshipReference
    public XmlString xgetSourceId() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(SOURCEID$0);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTRelationshipReference
    public void xsetSourceId(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SOURCEID$0;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}
