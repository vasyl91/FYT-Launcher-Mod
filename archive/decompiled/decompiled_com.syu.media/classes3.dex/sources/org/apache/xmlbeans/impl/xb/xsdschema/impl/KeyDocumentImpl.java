package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.KeyDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class KeyDocumentImpl extends XmlComplexContentImpl implements KeyDocument {
    private static final QName KEY$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "key");
    private static final long serialVersionUID = 1;

    public KeyDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyDocument
    public Keybase getKey() {
        synchronized (monitor()) {
            check_orphaned();
            Keybase keybase = (Keybase) get_store().find_element_user(KEY$0, 0);
            if (keybase == null) {
                return null;
            }
            return keybase;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyDocument
    public void setKey(Keybase keybase) {
        generatedSetterHelperImpl(keybase, KEY$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyDocument
    public Keybase addNewKey() {
        Keybase keybase;
        synchronized (monitor()) {
            check_orphaned();
            keybase = (Keybase) get_store().add_element_user(KEY$0);
        }
        return keybase;
    }
}
