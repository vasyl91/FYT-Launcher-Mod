package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class AttributeGroupDocumentImpl extends XmlComplexContentImpl implements AttributeGroupDocument {
    private static final QName ATTRIBUTEGROUP$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "attributeGroup");
    private static final long serialVersionUID = 1;

    public AttributeGroupDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupDocument
    public NamedAttributeGroup getAttributeGroup() {
        synchronized (monitor()) {
            check_orphaned();
            NamedAttributeGroup namedAttributeGroup = (NamedAttributeGroup) get_store().find_element_user(ATTRIBUTEGROUP$0, 0);
            if (namedAttributeGroup == null) {
                return null;
            }
            return namedAttributeGroup;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupDocument
    public void setAttributeGroup(NamedAttributeGroup namedAttributeGroup) {
        generatedSetterHelperImpl(namedAttributeGroup, ATTRIBUTEGROUP$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupDocument
    public NamedAttributeGroup addNewAttributeGroup() {
        NamedAttributeGroup namedAttributeGroup;
        synchronized (monitor()) {
            check_orphaned();
            namedAttributeGroup = (NamedAttributeGroup) get_store().add_element_user(ATTRIBUTEGROUP$0);
        }
        return namedAttributeGroup;
    }
}
