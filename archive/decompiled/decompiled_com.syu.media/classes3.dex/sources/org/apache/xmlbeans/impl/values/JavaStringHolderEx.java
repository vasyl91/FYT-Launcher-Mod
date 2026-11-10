package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class JavaStringHolderEx extends JavaStringHolder {
    private SchemaType _schemaType;

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return this._schemaType;
    }

    public JavaStringHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int get_wscanon_rule() {
        return schemaType().getWhiteSpaceRule();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        if (_validateOnSet()) {
            validateLexical(str, this._schemaType, _voorVc);
        }
        super.set_text(str);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean is_defaultable_ws(String str) {
        try {
            validateLexical(str, this._schemaType, _voorVc);
            return false;
        } catch (XmlValueOutOfRangeException unused) {
            return true;
        }
    }

    public static void validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        if (!schemaType.matchPatternFacet(str)) {
            validationContext.invalid("cvc-datatype-valid.1.1", new Object[]{"string", str, QNameHelper.readable(schemaType)});
            return;
        }
        XmlObjectBase facet = schemaType.getFacet(0);
        if (facet != null && str.length() != (iIntValue3 = facet.bigIntegerValue().intValue())) {
            validationContext.invalid("cvc-length-valid.1.1", new Object[]{"string", new Integer(str.length()), new Integer(iIntValue3), QNameHelper.readable(schemaType)});
            return;
        }
        XmlObjectBase facet2 = schemaType.getFacet(1);
        if (facet2 != null && str.length() < (iIntValue2 = facet2.bigIntegerValue().intValue())) {
            validationContext.invalid("cvc-minLength-valid.1.1", new Object[]{"string", new Integer(str.length()), new Integer(iIntValue2), QNameHelper.readable(schemaType)});
            return;
        }
        XmlObjectBase facet3 = schemaType.getFacet(2);
        if (facet3 != null && str.length() > (iIntValue = facet3.bigIntegerValue().intValue())) {
            validationContext.invalid("cvc-maxLength-valid.1.1", new Object[]{"string", new Integer(str.length()), new Integer(iIntValue), QNameHelper.readable(schemaType)});
            return;
        }
        XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (XmlAnySimpleType xmlAnySimpleType : enumerationValues) {
                if (str.equals(xmlAnySimpleType.getStringValue())) {
                    return;
                }
            }
            validationContext.invalid("cvc-enumeration-valid", new Object[]{"string", str, QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(stringValue(), schemaType(), validationContext);
    }
}
