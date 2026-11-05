package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STProofErr$Enum;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTProofErrImpl extends XmlComplexContentImpl implements CTProofErr {
    private static final QName TYPE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "type");

    public CTProofErrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr
    public STProofErr$Enum getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TYPE$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STProofErr$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr
    public void setType(STProofErr$Enum sTProofErr$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTProofErr$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr
    public STProofErr xgetType() {
        STProofErr sTProofErrFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTProofErrFind_attribute_user = get_store().find_attribute_user(TYPE$0);
        }
        return sTProofErrFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr
    public void xsetType(STProofErr sTProofErr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$0;
            STProofErr sTProofErrFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTProofErrFind_attribute_user == null) {
                sTProofErrFind_attribute_user = (STProofErr) get_store().add_attribute_user(qName);
            }
            sTProofErrFind_attribute_user.set(sTProofErr);
        }
    }
}
