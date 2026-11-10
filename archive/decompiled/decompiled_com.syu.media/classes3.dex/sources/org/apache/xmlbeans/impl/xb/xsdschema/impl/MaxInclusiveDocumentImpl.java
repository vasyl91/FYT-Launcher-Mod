package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
import org.apache.xmlbeans.impl.xb.xsdschema.MaxInclusiveDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class MaxInclusiveDocumentImpl extends XmlComplexContentImpl implements MaxInclusiveDocument {
    private static final QName MAXINCLUSIVE$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "maxInclusive");
    private static final long serialVersionUID = 1;

    public MaxInclusiveDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MaxInclusiveDocument
    public Facet getMaxInclusive() {
        synchronized (monitor()) {
            check_orphaned();
            Facet facet = (Facet) get_store().find_element_user(MAXINCLUSIVE$0, 0);
            if (facet == null) {
                return null;
            }
            return facet;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MaxInclusiveDocument
    public void setMaxInclusive(Facet facet) {
        generatedSetterHelperImpl(facet, MAXINCLUSIVE$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MaxInclusiveDocument
    public Facet addNewMaxInclusive() {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().add_element_user(MAXINCLUSIVE$0);
        }
        return facet;
    }
}
