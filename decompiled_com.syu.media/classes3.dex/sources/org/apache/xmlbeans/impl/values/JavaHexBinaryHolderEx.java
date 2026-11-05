package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class JavaHexBinaryHolderEx extends JavaHexBinaryHolder {
    private SchemaType _schemaType;

    @Override // org.apache.xmlbeans.impl.values.JavaHexBinaryHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return this._schemaType;
    }

    public JavaHexBinaryHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int get_wscanon_rule() {
        return schemaType().getWhiteSpaceRule();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaHexBinaryHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        byte[] bArrLex;
        if (_validateOnSet()) {
            bArrLex = validateLexical(str, schemaType(), _voorVc);
        } else {
            bArrLex = lex(str, _voorVc);
        }
        if (_validateOnSet() && bArrLex != null) {
            validateValue(bArrLex, schemaType(), XmlObjectBase._voorVc);
        }
        super.set_ByteArray(bArrLex);
        this._value = bArrLex;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaHexBinaryHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_ByteArray(byte[] bArr) {
        if (_validateOnSet()) {
            validateValue(bArr, schemaType(), _voorVc);
        }
        super.set_ByteArray(bArr);
    }

    public static void validateValue(byte[] bArr, SchemaType schemaType, ValidationContext validationContext) {
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        XmlObjectBase facet = schemaType.getFacet(0);
        if (facet != null && (iIntValue3 = facet.bigIntegerValue().intValue()) != bArr.length) {
            validationContext.invalid("cvc-length-valid.1.2", new Object[]{"hexBinary", new Integer(bArr.length), new Integer(iIntValue3), QNameHelper.readable(schemaType)});
        }
        XmlObjectBase facet2 = schemaType.getFacet(1);
        if (facet2 != null && (iIntValue2 = facet2.bigIntegerValue().intValue()) > bArr.length) {
            validationContext.invalid("cvc-minLength-valid.1.2", new Object[]{"hexBinary", new Integer(bArr.length), new Integer(iIntValue2), QNameHelper.readable(schemaType)});
        }
        XmlObjectBase facet3 = schemaType.getFacet(2);
        if (facet3 != null && (iIntValue = facet3.bigIntegerValue().intValue()) < bArr.length) {
            validationContext.invalid("cvc-maxLength-valid.1.2", new Object[]{"hexBinary", new Integer(bArr.length), new Integer(iIntValue), QNameHelper.readable(schemaType)});
        }
        XmlObjectBase[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            int i = 0;
            loop0: while (i < enumerationValues.length) {
                byte[] bArrByteArrayValue = enumerationValues[i].byteArrayValue();
                if (bArrByteArrayValue.length == bArr.length) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= bArrByteArrayValue.length) {
                            break loop0;
                        } else if (bArrByteArrayValue[i2] != bArr[i2]) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                i++;
            }
            if (i >= enumerationValues.length) {
                validationContext.invalid("cvc-enumeration-valid.b", new Object[]{"hexBinary", QNameHelper.readable(schemaType)});
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(byteArrayValue(), schemaType(), validationContext);
    }
}
