package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class TotalDigitsDocumentImpl extends XmlComplexContentImpl implements TotalDigitsDocument {
    private static final QName TOTALDIGITS$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "totalDigits");
    private static final long serialVersionUID = 1;

    public TotalDigitsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument
    public TotalDigitsDocument.TotalDigits getTotalDigits() {
        synchronized (monitor()) {
            check_orphaned();
            TotalDigitsDocument.TotalDigits totalDigits = (TotalDigitsDocument.TotalDigits) get_store().find_element_user(TOTALDIGITS$0, 0);
            if (totalDigits == null) {
                return null;
            }
            return totalDigits;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument
    public void setTotalDigits(TotalDigitsDocument.TotalDigits totalDigits) {
        generatedSetterHelperImpl(totalDigits, TOTALDIGITS$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument
    public TotalDigitsDocument.TotalDigits addNewTotalDigits() {
        TotalDigitsDocument.TotalDigits totalDigits;
        synchronized (monitor()) {
            check_orphaned();
            totalDigits = (TotalDigitsDocument.TotalDigits) get_store().add_element_user(TOTALDIGITS$0);
        }
        return totalDigits;
    }

    public static class TotalDigitsImpl extends NumFacetImpl implements TotalDigitsDocument.TotalDigits {
        private static final long serialVersionUID = 1;

        public TotalDigitsImpl(SchemaType schemaType) {
            super(schemaType);
        }
    }
}
