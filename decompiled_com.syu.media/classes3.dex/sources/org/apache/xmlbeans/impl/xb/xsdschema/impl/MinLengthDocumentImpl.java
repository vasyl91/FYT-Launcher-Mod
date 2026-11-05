package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.MinLengthDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NumFacet;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class MinLengthDocumentImpl extends XmlComplexContentImpl implements MinLengthDocument {
    private static final QName MINLENGTH$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "minLength");
    private static final long serialVersionUID = 1;

    public MinLengthDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MinLengthDocument
    public NumFacet getMinLength() {
        synchronized (monitor()) {
            check_orphaned();
            NumFacet numFacet = (NumFacet) get_store().find_element_user(MINLENGTH$0, 0);
            if (numFacet == null) {
                return null;
            }
            return numFacet;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MinLengthDocument
    public void setMinLength(NumFacet numFacet) {
        generatedSetterHelperImpl(numFacet, MINLENGTH$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MinLengthDocument
    public NumFacet addNewMinLength() {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().add_element_user(MINLENGTH$0);
        }
        return numFacet;
    }
}
