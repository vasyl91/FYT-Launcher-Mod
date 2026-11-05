package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.ElementDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ElementDocumentImpl extends XmlComplexContentImpl implements ElementDocument {
    private static final QName ELEMENT$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "element");
    private static final long serialVersionUID = 1;

    public ElementDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ElementDocument
    public TopLevelElement getElement() {
        synchronized (monitor()) {
            check_orphaned();
            TopLevelElement topLevelElement = (TopLevelElement) get_store().find_element_user(ELEMENT$0, 0);
            if (topLevelElement == null) {
                return null;
            }
            return topLevelElement;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ElementDocument
    public void setElement(TopLevelElement topLevelElement) {
        generatedSetterHelperImpl(topLevelElement, ELEMENT$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ElementDocument
    public TopLevelElement addNewElement() {
        TopLevelElement topLevelElement;
        synchronized (monitor()) {
            check_orphaned();
            topLevelElement = (TopLevelElement) get_store().add_element_user(ELEMENT$0);
        }
        return topLevelElement;
    }
}
