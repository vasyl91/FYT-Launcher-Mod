package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
import org.apache.xmlbeans.impl.xb.xsdschema.MaxExclusiveDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class MaxExclusiveDocumentImpl extends XmlComplexContentImpl implements MaxExclusiveDocument {
    private static final QName MAXEXCLUSIVE$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "maxExclusive");
    private static final long serialVersionUID = 1;

    public MaxExclusiveDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MaxExclusiveDocument
    public Facet getMaxExclusive() {
        synchronized (monitor()) {
            check_orphaned();
            Facet facet = (Facet) get_store().find_element_user(MAXEXCLUSIVE$0, 0);
            if (facet == null) {
                return null;
            }
            return facet;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MaxExclusiveDocument
    public void setMaxExclusive(Facet facet) {
        generatedSetterHelperImpl(facet, MAXEXCLUSIVE$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MaxExclusiveDocument
    public Facet addNewMaxExclusive() {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().add_element_user(MAXEXCLUSIVE$0);
        }
        return facet;
    }
}
