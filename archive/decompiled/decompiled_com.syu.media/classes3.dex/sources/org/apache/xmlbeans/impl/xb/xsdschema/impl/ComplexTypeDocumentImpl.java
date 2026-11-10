package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexTypeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ComplexTypeDocumentImpl extends XmlComplexContentImpl implements ComplexTypeDocument {
    private static final QName COMPLEXTYPE$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "complexType");
    private static final long serialVersionUID = 1;

    public ComplexTypeDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexTypeDocument
    public TopLevelComplexType getComplexType() {
        synchronized (monitor()) {
            check_orphaned();
            TopLevelComplexType topLevelComplexType = (TopLevelComplexType) get_store().find_element_user(COMPLEXTYPE$0, 0);
            if (topLevelComplexType == null) {
                return null;
            }
            return topLevelComplexType;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexTypeDocument
    public void setComplexType(TopLevelComplexType topLevelComplexType) {
        generatedSetterHelperImpl(topLevelComplexType, COMPLEXTYPE$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexTypeDocument
    public TopLevelComplexType addNewComplexType() {
        TopLevelComplexType topLevelComplexType;
        synchronized (monitor()) {
            check_orphaned();
            topLevelComplexType = (TopLevelComplexType) get_store().add_element_user(COMPLEXTYPE$0);
        }
        return topLevelComplexType;
    }
}
