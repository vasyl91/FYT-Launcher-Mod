package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleTypeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SimpleTypeDocumentImpl extends XmlComplexContentImpl implements SimpleTypeDocument {
    private static final QName SIMPLETYPE$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "simpleType");
    private static final long serialVersionUID = 1;

    public SimpleTypeDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleTypeDocument
    public TopLevelSimpleType getSimpleType() {
        synchronized (monitor()) {
            check_orphaned();
            TopLevelSimpleType topLevelSimpleType = (TopLevelSimpleType) get_store().find_element_user(SIMPLETYPE$0, 0);
            if (topLevelSimpleType == null) {
                return null;
            }
            return topLevelSimpleType;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleTypeDocument
    public void setSimpleType(TopLevelSimpleType topLevelSimpleType) {
        generatedSetterHelperImpl(topLevelSimpleType, SIMPLETYPE$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleTypeDocument
    public TopLevelSimpleType addNewSimpleType() {
        TopLevelSimpleType topLevelSimpleType;
        synchronized (monitor()) {
            check_orphaned();
            topLevelSimpleType = (TopLevelSimpleType) get_store().add_element_user(SIMPLETYPE$0);
        }
        return topLevelSimpleType;
    }
}
