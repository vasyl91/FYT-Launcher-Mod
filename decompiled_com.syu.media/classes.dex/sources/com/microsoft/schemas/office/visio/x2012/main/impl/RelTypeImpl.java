package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.RelType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class RelTypeImpl extends XmlComplexContentImpl implements RelType {
    private static final QName ID$0 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id");

    public RelTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.RelType
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.RelType
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.RelType
    public STRelationshipId xgetId() {
        STRelationshipId sTRelationshipIdFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTRelationshipIdFind_attribute_user = get_store().find_attribute_user(ID$0);
        }
        return sTRelationshipIdFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.RelType
    public void xsetId(STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$0;
            STRelationshipId sTRelationshipIdFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTRelationshipIdFind_attribute_user == null) {
                sTRelationshipIdFind_attribute_user = (STRelationshipId) get_store().add_attribute_user(qName);
            }
            sTRelationshipIdFind_attribute_user.set(sTRelationshipId);
        }
    }
}
