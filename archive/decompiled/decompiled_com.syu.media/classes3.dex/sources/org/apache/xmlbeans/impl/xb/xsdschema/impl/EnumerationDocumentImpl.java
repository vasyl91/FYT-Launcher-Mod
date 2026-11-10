package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.EnumerationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NoFixedFacet;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class EnumerationDocumentImpl extends XmlComplexContentImpl implements EnumerationDocument {
    private static final QName ENUMERATION$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "enumeration");
    private static final long serialVersionUID = 1;

    public EnumerationDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.EnumerationDocument
    public NoFixedFacet getEnumeration() {
        synchronized (monitor()) {
            check_orphaned();
            NoFixedFacet noFixedFacet = (NoFixedFacet) get_store().find_element_user(ENUMERATION$0, 0);
            if (noFixedFacet == null) {
                return null;
            }
            return noFixedFacet;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.EnumerationDocument
    public void setEnumeration(NoFixedFacet noFixedFacet) {
        generatedSetterHelperImpl(noFixedFacet, ENUMERATION$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.EnumerationDocument
    public NoFixedFacet addNewEnumeration() {
        NoFixedFacet noFixedFacet;
        synchronized (monitor()) {
            check_orphaned();
            noFixedFacet = (NoFixedFacet) get_store().add_element_user(ENUMERATION$0);
        }
        return noFixedFacet;
    }
}
