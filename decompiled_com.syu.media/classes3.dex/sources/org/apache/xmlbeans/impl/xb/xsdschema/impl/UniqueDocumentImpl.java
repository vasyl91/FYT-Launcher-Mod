package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;
import org.apache.xmlbeans.impl.xb.xsdschema.UniqueDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class UniqueDocumentImpl extends XmlComplexContentImpl implements UniqueDocument {
    private static final QName UNIQUE$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "unique");
    private static final long serialVersionUID = 1;

    public UniqueDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.UniqueDocument
    public Keybase getUnique() {
        synchronized (monitor()) {
            check_orphaned();
            Keybase keybase = (Keybase) get_store().find_element_user(UNIQUE$0, 0);
            if (keybase == null) {
                return null;
            }
            return keybase;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.UniqueDocument
    public void setUnique(Keybase keybase) {
        generatedSetterHelperImpl(keybase, UNIQUE$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.UniqueDocument
    public Keybase addNewUnique() {
        Keybase keybase;
        synchronized (monitor()) {
            check_orphaned();
            keybase = (Keybase) get_store().add_element_user(UNIQUE$0);
        }
        return keybase;
    }
}
