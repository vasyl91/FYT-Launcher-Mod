package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
import org.apache.xmlbeans.impl.xb.xsdschema.MinInclusiveDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class MinInclusiveDocumentImpl extends XmlComplexContentImpl implements MinInclusiveDocument {
    private static final QName MININCLUSIVE$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "minInclusive");
    private static final long serialVersionUID = 1;

    public MinInclusiveDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MinInclusiveDocument
    public Facet getMinInclusive() {
        synchronized (monitor()) {
            check_orphaned();
            Facet facet = (Facet) get_store().find_element_user(MININCLUSIVE$0, 0);
            if (facet == null) {
                return null;
            }
            return facet;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MinInclusiveDocument
    public void setMinInclusive(Facet facet) {
        generatedSetterHelperImpl(facet, MININCLUSIVE$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MinInclusiveDocument
    public Facet addNewMinInclusive() {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().add_element_user(MININCLUSIVE$0);
        }
        return facet;
    }
}
