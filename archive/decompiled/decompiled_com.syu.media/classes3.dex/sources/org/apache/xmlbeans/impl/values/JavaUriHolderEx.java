package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class JavaUriHolderEx extends JavaUriHolder {
    private SchemaType _schemaType;

    @Override // org.apache.xmlbeans.impl.values.JavaUriHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return this._schemaType;
    }

    public JavaUriHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int get_wscanon_rule() {
        return schemaType().getWhiteSpaceRule();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaUriHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        if (_validateOnSet()) {
            if (!check(str, this._schemaType)) {
                throw new XmlValueOutOfRangeException();
            }
            if (!this._schemaType.matchPatternFacet(str)) {
                throw new XmlValueOutOfRangeException();
            }
        }
        super.set_text(str);
    }

    public static void validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        XmlAnyUriImpl.validateLexical(str, validationContext);
        SimpleValue[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            int i = 0;
            while (i < enumerationValues.length && !enumerationValues[i].getStringValue().equals(str)) {
                i++;
            }
            if (i >= enumerationValues.length) {
                validationContext.invalid("cvc-enumeration-valid", new Object[]{"anyURI", str, QNameHelper.readable(schemaType)});
            }
        }
        if (schemaType.hasPatternFacet() && !schemaType.matchPatternFacet(str)) {
            validationContext.invalid("cvc-datatype-valid.1.1", new Object[]{"anyURI", str, QNameHelper.readable(schemaType)});
        }
        SimpleValue facet = schemaType.getFacet(0);
        if (facet != null && (iIntValue3 = facet.getBigIntegerValue().intValue()) != str.length()) {
            validationContext.invalid("cvc-length-valid.1.1", new Object[]{"anyURI", str, new Integer(iIntValue3), QNameHelper.readable(schemaType)});
        }
        SimpleValue facet2 = schemaType.getFacet(1);
        if (facet2 != null && (iIntValue2 = facet2.getBigIntegerValue().intValue()) > str.length()) {
            validationContext.invalid("cvc-minLength-valid.1.1", new Object[]{"anyURI", str, new Integer(iIntValue2), QNameHelper.readable(schemaType)});
        }
        SimpleValue facet3 = schemaType.getFacet(2);
        if (facet3 == null || (iIntValue = facet3.getBigIntegerValue().intValue()) >= str.length()) {
            return;
        }
        validationContext.invalid("cvc-maxLength-valid.1.1", new Object[]{"anyURI", str, new Integer(iIntValue), QNameHelper.readable(schemaType)});
    }

    private static boolean check(String str, SchemaType schemaType) {
        int length = str == null ? 0 : str.length();
        SimpleValue facet = schemaType.getFacet(0);
        if (facet != null && length == facet.getBigIntegerValue().intValue()) {
            return false;
        }
        SimpleValue facet2 = schemaType.getFacet(1);
        if (facet2 != null && length < facet2.getBigIntegerValue().intValue()) {
            return false;
        }
        SimpleValue facet3 = schemaType.getFacet(2);
        return facet3 == null || length <= facet3.getBigIntegerValue().intValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(stringValue(), schemaType(), validationContext);
    }
}
