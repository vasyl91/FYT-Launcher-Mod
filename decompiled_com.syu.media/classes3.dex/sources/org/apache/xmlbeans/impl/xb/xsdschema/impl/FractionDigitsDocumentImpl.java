package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.FractionDigitsDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NumFacet;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class FractionDigitsDocumentImpl extends XmlComplexContentImpl implements FractionDigitsDocument {
    private static final QName FRACTIONDIGITS$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "fractionDigits");
    private static final long serialVersionUID = 1;

    public FractionDigitsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.FractionDigitsDocument
    public NumFacet getFractionDigits() {
        synchronized (monitor()) {
            check_orphaned();
            NumFacet numFacet = (NumFacet) get_store().find_element_user(FRACTIONDIGITS$0, 0);
            if (numFacet == null) {
                return null;
            }
            return numFacet;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.FractionDigitsDocument
    public void setFractionDigits(NumFacet numFacet) {
        generatedSetterHelperImpl(numFacet, FRACTIONDIGITS$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.FractionDigitsDocument
    public NumFacet addNewFractionDigits() {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().add_element_user(FRACTIONDIGITS$0);
        }
        return numFacet;
    }
}
