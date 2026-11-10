package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.util.XsTypeConverter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class JavaLongHolderEx extends JavaLongHolder {
    private SchemaType _schemaType;

    public JavaLongHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaLongHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaLongHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        try {
            long jLexLong = XsTypeConverter.lexLong(str);
            if (_validateOnSet()) {
                validateValue(jLexLong, this._schemaType, _voorVc);
                validateLexical(str, this._schemaType, _voorVc);
            }
            super.set_long(jLexLong);
        } catch (Exception unused) {
            throw new XmlValueOutOfRangeException();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.JavaLongHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_long(long j) {
        if (_validateOnSet()) {
            validateValue(j, this._schemaType, _voorVc);
        }
        super.set_long(j);
    }

    public static void validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        JavaDecimalHolder.validateLexical(str, validationContext);
        if (!schemaType.hasPatternFacet() || schemaType.matchPatternFacet(str)) {
            return;
        }
        validationContext.invalid("cvc-datatype-valid.1.1", new Object[]{"long", str, QNameHelper.readable(schemaType)});
    }

    private static void validateValue(long j, SchemaType schemaType, ValidationContext validationContext) {
        XmlAnySimpleType facet = schemaType.getFacet(7);
        if (facet != null) {
            long longValue = getLongValue(facet);
            String string = Long.toString(j);
            int length = string.length();
            if (length > 0 && string.charAt(0) == '-') {
                length--;
            }
            if (length > longValue) {
                validationContext.invalid("cvc-totalDigits-valid", new Object[]{new Integer(length), string, new Long(longValue), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet2 = schemaType.getFacet(3);
        if (facet2 != null) {
            long longValue2 = getLongValue(facet2);
            if (j <= longValue2) {
                validationContext.invalid("cvc-minExclusive-valid", new Object[]{"long", new Long(j), new Long(longValue2), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet3 = schemaType.getFacet(4);
        if (facet3 != null) {
            long longValue3 = getLongValue(facet3);
            if (j < longValue3) {
                validationContext.invalid("cvc-minInclusive-valid", new Object[]{"long", new Long(j), new Long(longValue3), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet4 = schemaType.getFacet(5);
        if (facet4 != null) {
            long longValue4 = getLongValue(facet4);
            if (j > longValue4) {
                validationContext.invalid("cvc-maxInclusive-valid", new Object[]{"long", new Long(j), new Long(longValue4), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet5 = schemaType.getFacet(6);
        if (facet5 != null) {
            long longValue5 = getLongValue(facet5);
            if (j >= longValue5) {
                validationContext.invalid("cvc-maxExclusive-valid", new Object[]{"long", new Long(j), new Long(longValue5), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlObject[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (XmlObject xmlObject : enumerationValues) {
                if (j == getLongValue(xmlObject)) {
                    return;
                }
            }
            validationContext.invalid("cvc-enumeration-valid", new Object[]{"long", new Long(j), QNameHelper.readable(schemaType)});
        }
    }

    private static long getLongValue(XmlObject xmlObject) {
        SchemaType schemaType = xmlObject.schemaType();
        int decimalSize = schemaType.getDecimalSize();
        if (decimalSize != 64) {
            switch (decimalSize) {
                case 1000000:
                    return ((XmlObjectBase) xmlObject).getBigIntegerValue().longValue();
                case 1000001:
                    return ((XmlObjectBase) xmlObject).getBigDecimalValue().longValue();
                default:
                    throw new IllegalStateException("Bad facet type: " + schemaType);
            }
        }
        return ((XmlObjectBase) xmlObject).getLongValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(getLongValue(), schemaType(), validationContext);
    }
}
