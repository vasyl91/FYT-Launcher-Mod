package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class AttributeDocumentImpl extends XmlComplexContentImpl implements AttributeDocument {
    private static final QName ATTRIBUTE$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "attribute");
    private static final long serialVersionUID = 1;

    public AttributeDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeDocument
    public TopLevelAttribute getAttribute() {
        synchronized (monitor()) {
            check_orphaned();
            TopLevelAttribute topLevelAttribute = (TopLevelAttribute) get_store().find_element_user(ATTRIBUTE$0, 0);
            if (topLevelAttribute == null) {
                return null;
            }
            return topLevelAttribute;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeDocument
    public void setAttribute(TopLevelAttribute topLevelAttribute) {
        generatedSetterHelperImpl(topLevelAttribute, ATTRIBUTE$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeDocument
    public TopLevelAttribute addNewAttribute() {
        TopLevelAttribute topLevelAttribute;
        synchronized (monitor()) {
            check_orphaned();
            topLevelAttribute = (TopLevelAttribute) get_store().add_element_user(ATTRIBUTE$0);
        }
        return topLevelAttribute;
    }
}
