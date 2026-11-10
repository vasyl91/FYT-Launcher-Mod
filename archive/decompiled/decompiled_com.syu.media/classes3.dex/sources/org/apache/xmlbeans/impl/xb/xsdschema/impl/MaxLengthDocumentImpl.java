package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.MaxLengthDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NumFacet;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class MaxLengthDocumentImpl extends XmlComplexContentImpl implements MaxLengthDocument {
    private static final QName MAXLENGTH$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "maxLength");
    private static final long serialVersionUID = 1;

    public MaxLengthDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MaxLengthDocument
    public NumFacet getMaxLength() {
        synchronized (monitor()) {
            check_orphaned();
            NumFacet numFacet = (NumFacet) get_store().find_element_user(MAXLENGTH$0, 0);
            if (numFacet == null) {
                return null;
            }
            return numFacet;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MaxLengthDocument
    public void setMaxLength(NumFacet numFacet) {
        generatedSetterHelperImpl(numFacet, MAXLENGTH$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MaxLengthDocument
    public NumFacet addNewMaxLength() {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().add_element_user(MAXLENGTH$0);
        }
        return numFacet;
    }
}
