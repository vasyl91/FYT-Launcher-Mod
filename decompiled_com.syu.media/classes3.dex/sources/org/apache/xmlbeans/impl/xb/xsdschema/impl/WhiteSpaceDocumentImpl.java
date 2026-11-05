package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class WhiteSpaceDocumentImpl extends XmlComplexContentImpl implements WhiteSpaceDocument {
    private static final QName WHITESPACE$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "whiteSpace");
    private static final long serialVersionUID = 1;

    public WhiteSpaceDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument
    public WhiteSpaceDocument.WhiteSpace getWhiteSpace() {
        synchronized (monitor()) {
            check_orphaned();
            WhiteSpaceDocument.WhiteSpace whiteSpace = (WhiteSpaceDocument.WhiteSpace) get_store().find_element_user(WHITESPACE$0, 0);
            if (whiteSpace == null) {
                return null;
            }
            return whiteSpace;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument
    public void setWhiteSpace(WhiteSpaceDocument.WhiteSpace whiteSpace) {
        generatedSetterHelperImpl(whiteSpace, WHITESPACE$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument
    public WhiteSpaceDocument.WhiteSpace addNewWhiteSpace() {
        WhiteSpaceDocument.WhiteSpace whiteSpace;
        synchronized (monitor()) {
            check_orphaned();
            whiteSpace = (WhiteSpaceDocument.WhiteSpace) get_store().add_element_user(WHITESPACE$0);
        }
        return whiteSpace;
    }

    public static class WhiteSpaceImpl extends FacetImpl implements WhiteSpaceDocument.WhiteSpace {
        private static final long serialVersionUID = 1;

        public WhiteSpaceImpl(SchemaType schemaType) {
            super(schemaType);
        }

        public static class ValueImpl extends JavaStringEnumerationHolderEx implements WhiteSpaceDocument.WhiteSpace.Value {
            private static final long serialVersionUID = 1;

            public ValueImpl(SchemaType schemaType) {
                super(schemaType, false);
            }

            protected ValueImpl(SchemaType schemaType, boolean z) {
                super(schemaType, z);
            }
        }
    }
}
