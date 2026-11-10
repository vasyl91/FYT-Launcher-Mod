package org.apache.xmlbeans.impl.values;

import java.math.BigDecimal;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class JavaDecimalHolderEx extends JavaDecimalHolder {
    private SchemaType _schemaType;

    @Override // org.apache.xmlbeans.impl.values.JavaDecimalHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return this._schemaType;
    }

    public JavaDecimalHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaDecimalHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        BigDecimal bigDecimal;
        if (_validateOnSet()) {
            validateLexical(str, this._schemaType, _voorVc);
        }
        try {
            bigDecimal = new BigDecimal(str);
        } catch (NumberFormatException unused) {
            _voorVc.invalid("decimal", new Object[]{str});
            bigDecimal = null;
        }
        if (_validateOnSet()) {
            validateValue(bigDecimal, this._schemaType, _voorVc);
        }
        super.set_BigDecimal(bigDecimal);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaDecimalHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_BigDecimal(BigDecimal bigDecimal) {
        if (_validateOnSet()) {
            validateValue(bigDecimal, this._schemaType, _voorVc);
        }
        super.set_BigDecimal(bigDecimal);
    }

    public static void validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        JavaDecimalHolder.validateLexical(str, validationContext);
        if (!schemaType.hasPatternFacet() || schemaType.matchPatternFacet(str)) {
            return;
        }
        validationContext.invalid("cvc-datatype-valid.1.1", new Object[]{"decimal", str, QNameHelper.readable(schemaType)});
    }

    public static void validateValue(BigDecimal bigDecimal, SchemaType schemaType, ValidationContext validationContext) {
        XmlObjectBase facet = schemaType.getFacet(8);
        if (facet != null) {
            int iIntValue = facet.getBigIntegerValue().intValue();
            try {
                bigDecimal.setScale(iIntValue);
            } catch (ArithmeticException unused) {
                validationContext.invalid("cvc-fractionDigits-valid", new Object[]{new Integer(bigDecimal.scale()), bigDecimal.toString(), new Integer(iIntValue), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlObjectBase facet2 = schemaType.getFacet(7);
        if (facet2 != null) {
            String string = bigDecimal.unscaledValue().toString();
            int iIntValue2 = facet2.getBigIntegerValue().intValue();
            int length = string.length();
            if (length > 0) {
                int i = string.charAt(0) == '-' ? length - 1 : length;
                int iScale = bigDecimal.scale();
                int i2 = 0;
                for (int i3 = length - 1; string.charAt(i3) == '0' && i3 > 0 && i2 < iScale; i3--) {
                    i2++;
                }
                length = i - i2;
            }
            if (length > iIntValue2) {
                validationContext.invalid("cvc-totalDigits-valid", new Object[]{new Integer(length), bigDecimal.toString(), new Integer(iIntValue2), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlObjectBase facet3 = schemaType.getFacet(3);
        if (facet3 != null) {
            BigDecimal bigDecimalValue = facet3.getBigDecimalValue();
            if (bigDecimal.compareTo(bigDecimalValue) <= 0) {
                validationContext.invalid("cvc-minExclusive-valid", new Object[]{"decimal", bigDecimal, bigDecimalValue, QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlObjectBase facet4 = schemaType.getFacet(4);
        if (facet4 != null) {
            BigDecimal bigDecimalValue2 = facet4.getBigDecimalValue();
            if (bigDecimal.compareTo(bigDecimalValue2) < 0) {
                validationContext.invalid("cvc-minInclusive-valid", new Object[]{"decimal", bigDecimal, bigDecimalValue2, QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlObjectBase facet5 = schemaType.getFacet(5);
        if (facet5 != null) {
            BigDecimal bigDecimalValue3 = facet5.getBigDecimalValue();
            if (bigDecimal.compareTo(bigDecimalValue3) > 0) {
                validationContext.invalid("cvc-maxInclusive-valid", new Object[]{"decimal", bigDecimal, bigDecimalValue3, QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlObjectBase facet6 = schemaType.getFacet(6);
        if (facet6 != null) {
            BigDecimal bigDecimalValue4 = facet6.getBigDecimalValue();
            if (bigDecimal.compareTo(bigDecimalValue4) >= 0) {
                validationContext.invalid("cvc-maxExclusive-valid", new Object[]{"decimal", bigDecimal, bigDecimalValue4, QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlObjectBase[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (XmlObjectBase xmlObjectBase : enumerationValues) {
                if (bigDecimal.equals(xmlObjectBase.getBigDecimalValue())) {
                    return;
                }
            }
            validationContext.invalid("cvc-enumeration-valid", new Object[]{"decimal", bigDecimal, QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(getBigDecimalValue(), schemaType(), validationContext);
    }
}
