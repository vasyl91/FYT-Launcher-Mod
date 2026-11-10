package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class PatternDocumentImpl extends XmlComplexContentImpl implements PatternDocument {
    private static final QName PATTERN$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "pattern");
    private static final long serialVersionUID = 1;

    public PatternDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument
    public PatternDocument.Pattern getPattern() {
        synchronized (monitor()) {
            check_orphaned();
            PatternDocument.Pattern pattern = (PatternDocument.Pattern) get_store().find_element_user(PATTERN$0, 0);
            if (pattern == null) {
                return null;
            }
            return pattern;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument
    public void setPattern(PatternDocument.Pattern pattern) {
        generatedSetterHelperImpl(pattern, PATTERN$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument
    public PatternDocument.Pattern addNewPattern() {
        PatternDocument.Pattern pattern;
        synchronized (monitor()) {
            check_orphaned();
            pattern = (PatternDocument.Pattern) get_store().add_element_user(PATTERN$0);
        }
        return pattern;
    }

    public static class PatternImpl extends NoFixedFacetImpl implements PatternDocument.Pattern {
        private static final long serialVersionUID = 1;

        public PatternImpl(SchemaType schemaType) {
            super(schemaType);
        }
    }
}
