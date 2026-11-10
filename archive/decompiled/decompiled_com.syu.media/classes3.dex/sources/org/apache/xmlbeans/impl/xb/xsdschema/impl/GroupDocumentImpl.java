package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class GroupDocumentImpl extends XmlComplexContentImpl implements GroupDocument {
    private static final QName GROUP$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "group");
    private static final long serialVersionUID = 1;

    public GroupDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument
    public NamedGroup getGroup() {
        synchronized (monitor()) {
            check_orphaned();
            NamedGroup namedGroup = (NamedGroup) get_store().find_element_user(GROUP$0, 0);
            if (namedGroup == null) {
                return null;
            }
            return namedGroup;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument
    public void setGroup(NamedGroup namedGroup) {
        generatedSetterHelperImpl(namedGroup, GROUP$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument
    public NamedGroup addNewGroup() {
        NamedGroup namedGroup;
        synchronized (monitor()) {
            check_orphaned();
            namedGroup = (NamedGroup) get_store().add_element_user(GROUP$0);
        }
        return namedGroup;
    }
}
