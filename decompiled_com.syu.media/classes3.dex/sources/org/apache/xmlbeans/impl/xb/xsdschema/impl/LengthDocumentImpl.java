package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.LengthDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NumFacet;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class LengthDocumentImpl extends XmlComplexContentImpl implements LengthDocument {
    private static final QName LENGTH$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "length");
    private static final long serialVersionUID = 1;

    public LengthDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.LengthDocument
    public NumFacet getLength() {
        synchronized (monitor()) {
            check_orphaned();
            NumFacet numFacet = (NumFacet) get_store().find_element_user(LENGTH$0, 0);
            if (numFacet == null) {
                return null;
            }
            return numFacet;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.LengthDocument
    public void setLength(NumFacet numFacet) {
        generatedSetterHelperImpl(numFacet, LENGTH$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.LengthDocument
    public NumFacet addNewLength() {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().add_element_user(LENGTH$0);
        }
        return numFacet;
    }
}
