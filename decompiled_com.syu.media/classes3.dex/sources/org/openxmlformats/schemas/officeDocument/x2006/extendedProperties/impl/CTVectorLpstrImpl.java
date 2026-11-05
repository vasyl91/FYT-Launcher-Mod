package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTVectorLpstr;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTVectorLpstrImpl extends XmlComplexContentImpl implements CTVectorLpstr {
    private static final QName VECTOR$0 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "vector");

    public CTVectorLpstrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTVectorLpstr
    public CTVector addNewVector() {
        CTVector cTVector;
        synchronized (monitor()) {
            check_orphaned();
            cTVector = (CTVector) get_store().add_element_user(VECTOR$0);
        }
        return cTVector;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTVectorLpstr
    public CTVector getVector() {
        synchronized (monitor()) {
            check_orphaned();
            CTVector cTVector = (CTVector) get_store().find_element_user(VECTOR$0, 0);
            if (cTVector == null) {
                return null;
            }
            return cTVector;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTVectorLpstr
    public void setVector(CTVector cTVector) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VECTOR$0;
            CTVector cTVector2 = (CTVector) typeStore.find_element_user(qName, 0);
            if (cTVector2 == null) {
                cTVector2 = (CTVector) get_store().add_element_user(qName);
            }
            cTVector2.set(cTVector);
        }
    }
}
