package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
import org.apache.xmlbeans.impl.xb.xsdschema.MinExclusiveDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class MinExclusiveDocumentImpl extends XmlComplexContentImpl implements MinExclusiveDocument {
    private static final QName MINEXCLUSIVE$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "minExclusive");
    private static final long serialVersionUID = 1;

    public MinExclusiveDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MinExclusiveDocument
    public Facet getMinExclusive() {
        synchronized (monitor()) {
            check_orphaned();
            Facet facet = (Facet) get_store().find_element_user(MINEXCLUSIVE$0, 0);
            if (facet == null) {
                return null;
            }
            return facet;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MinExclusiveDocument
    public void setMinExclusive(Facet facet) {
        generatedSetterHelperImpl(facet, MINEXCLUSIVE$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MinExclusiveDocument
    public Facet addNewMinExclusive() {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().add_element_user(MINEXCLUSIVE$0);
        }
        return facet;
    }
}
