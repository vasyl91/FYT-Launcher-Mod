package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHdrFtr;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTHdrFtrRefImpl extends CTRelImpl implements CTHdrFtrRef {
    private static final QName TYPE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "type");

    public CTHdrFtrRefImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef
    public STHdrFtr.Enum getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TYPE$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STHdrFtr.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef
    public void setType(STHdrFtr.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef
    public STHdrFtr xgetType() {
        STHdrFtr sTHdrFtrFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTHdrFtrFind_attribute_user = get_store().find_attribute_user(TYPE$0);
        }
        return sTHdrFtrFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef
    public void xsetType(STHdrFtr sTHdrFtr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$0;
            STHdrFtr sTHdrFtrFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTHdrFtrFind_attribute_user == null) {
                sTHdrFtrFind_attribute_user = (STHdrFtr) get_store().add_attribute_user(qName);
            }
            sTHdrFtrFind_attribute_user.set((XmlObject) sTHdrFtr);
        }
    }
}
