package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.SequenceDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SequenceDocumentImpl extends XmlComplexContentImpl implements SequenceDocument {
    private static final QName SEQUENCE$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "sequence");
    private static final long serialVersionUID = 1;

    public SequenceDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SequenceDocument
    public ExplicitGroup getSequence() {
        synchronized (monitor()) {
            check_orphaned();
            ExplicitGroup explicitGroup = (ExplicitGroup) get_store().find_element_user(SEQUENCE$0, 0);
            if (explicitGroup == null) {
                return null;
            }
            return explicitGroup;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SequenceDocument
    public void setSequence(ExplicitGroup explicitGroup) {
        generatedSetterHelperImpl(explicitGroup, SEQUENCE$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SequenceDocument
    public ExplicitGroup addNewSequence() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(SEQUENCE$0);
        }
        return explicitGroup;
    }
}
