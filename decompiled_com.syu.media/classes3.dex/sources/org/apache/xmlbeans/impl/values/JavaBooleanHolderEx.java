package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class JavaBooleanHolderEx extends JavaBooleanHolder {
    private SchemaType _schemaType;

    @Override // org.apache.xmlbeans.impl.values.JavaBooleanHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return this._schemaType;
    }

    public static boolean validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        boolean zValidateLexical = JavaBooleanHolder.validateLexical(str, validationContext);
        validatePattern(str, schemaType, validationContext);
        return zValidateLexical;
    }

    public static void validatePattern(String str, SchemaType schemaType, ValidationContext validationContext) {
        if (schemaType.matchPatternFacet(str)) {
            return;
        }
        validationContext.invalid("cvc-datatype-valid.1.1", new Object[]{"boolean", str, QNameHelper.readable(schemaType)});
    }

    public JavaBooleanHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaBooleanHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        if (_validateOnSet()) {
            validatePattern(str, this._schemaType, _voorVc);
        }
        super.set_text(str);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
    }
}
