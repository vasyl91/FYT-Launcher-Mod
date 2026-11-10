package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.ChoiceDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ChoiceDocumentImpl extends XmlComplexContentImpl implements ChoiceDocument {
    private static final QName CHOICE$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "choice");
    private static final long serialVersionUID = 1;

    public ChoiceDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ChoiceDocument
    public ExplicitGroup getChoice() {
        synchronized (monitor()) {
            check_orphaned();
            ExplicitGroup explicitGroup = (ExplicitGroup) get_store().find_element_user(CHOICE$0, 0);
            if (explicitGroup == null) {
                return null;
            }
            return explicitGroup;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ChoiceDocument
    public void setChoice(ExplicitGroup explicitGroup) {
        generatedSetterHelperImpl(explicitGroup, CHOICE$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ChoiceDocument
    public ExplicitGroup addNewChoice() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(CHOICE$0);
        }
        return explicitGroup;
    }
}
