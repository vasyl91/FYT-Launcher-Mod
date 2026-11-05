package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AnyAttributeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class AnyAttributeDocumentImpl extends XmlComplexContentImpl implements AnyAttributeDocument {
    private static final QName ANYATTRIBUTE$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "anyAttribute");
    private static final long serialVersionUID = 1;

    public AnyAttributeDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyAttributeDocument
    public Wildcard getAnyAttribute() {
        synchronized (monitor()) {
            check_orphaned();
            Wildcard wildcard = (Wildcard) get_store().find_element_user(ANYATTRIBUTE$0, 0);
            if (wildcard == null) {
                return null;
            }
            return wildcard;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyAttributeDocument
    public void setAnyAttribute(Wildcard wildcard) {
        generatedSetterHelperImpl(wildcard, ANYATTRIBUTE$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyAttributeDocument
    public Wildcard addNewAnyAttribute() {
        Wildcard wildcard;
        synchronized (monitor()) {
            check_orphaned();
            wildcard = (Wildcard) get_store().add_element_user(ANYATTRIBUTE$0);
        }
        return wildcard;
    }
}
