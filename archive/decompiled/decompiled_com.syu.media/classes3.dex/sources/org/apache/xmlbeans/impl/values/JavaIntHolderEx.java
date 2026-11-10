package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.util.XsTypeConverter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class JavaIntHolderEx extends JavaIntHolder {
    private SchemaType _schemaType;

    public JavaIntHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaIntHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaIntHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        try {
            int iLexInt = XsTypeConverter.lexInt(str);
            if (_validateOnSet()) {
                validateValue(iLexInt, this._schemaType, _voorVc);
                validateLexical(str, this._schemaType, _voorVc);
            }
            super.set_int(iLexInt);
        } catch (Exception unused) {
            throw new XmlValueOutOfRangeException();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.JavaIntHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_int(int i) {
        if (_validateOnSet()) {
            validateValue(i, this._schemaType, _voorVc);
        }
        super.set_int(i);
    }

    public static void validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        JavaDecimalHolder.validateLexical(str, validationContext);
        if (!schemaType.hasPatternFacet() || schemaType.matchPatternFacet(str)) {
            return;
        }
        validationContext.invalid("cvc-datatype-valid.1.1", new Object[]{"int", str, QNameHelper.readable(schemaType)});
    }

    private static void validateValue(int i, SchemaType schemaType, ValidationContext validationContext) {
        int intValue;
        int intValue2;
        int intValue3;
        int intValue4;
        XmlAnySimpleType facet = schemaType.getFacet(7);
        if (facet != null) {
            String string = Integer.toString(i);
            int length = string.length();
            if (length > 0 && string.charAt(0) == '-') {
                length--;
            }
            if (length > getIntValue(facet)) {
                validationContext.invalid("cvc-totalDigits-valid", new Object[]{new Integer(length), string, new Integer(getIntValue(facet)), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet2 = schemaType.getFacet(3);
        if (facet2 != null && i <= (intValue4 = getIntValue(facet2))) {
            validationContext.invalid("cvc-minExclusive-valid", new Object[]{"int", new Integer(i), new Integer(intValue4), QNameHelper.readable(schemaType)});
            return;
        }
        XmlAnySimpleType facet3 = schemaType.getFacet(4);
        if (facet3 != null && i < (intValue3 = getIntValue(facet3))) {
            validationContext.invalid("cvc-minInclusive-valid", new Object[]{"int", new Integer(i), new Integer(intValue3), QNameHelper.readable(schemaType)});
            return;
        }
        XmlAnySimpleType facet4 = schemaType.getFacet(5);
        if (facet4 != null && i > (intValue2 = getIntValue(facet4))) {
            validationContext.invalid("cvc-maxExclusive-valid", new Object[]{"int", new Integer(i), new Integer(intValue2), QNameHelper.readable(schemaType)});
            return;
        }
        XmlAnySimpleType facet5 = schemaType.getFacet(6);
        if (facet5 != null && i >= (intValue = getIntValue(facet5))) {
            validationContext.invalid("cvc-maxExclusive-valid", new Object[]{"int", new Integer(i), new Integer(intValue), QNameHelper.readable(schemaType)});
            return;
        }
        XmlObject[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (XmlObject xmlObject : enumerationValues) {
                if (i == getIntValue(xmlObject)) {
                    return;
                }
            }
            validationContext.invalid("cvc-enumeration-valid", new Object[]{"int", new Integer(i), QNameHelper.readable(schemaType)});
        }
    }

    private static int getIntValue(XmlObject xmlObject) {
        int decimalSize = xmlObject.schemaType().getDecimalSize();
        if (decimalSize != 64) {
            switch (decimalSize) {
                case 1000000:
                    return ((XmlObjectBase) xmlObject).getBigIntegerValue().intValue();
                case 1000001:
                    return ((XmlObjectBase) xmlObject).getBigDecimalValue().intValue();
                default:
                    return ((XmlObjectBase) xmlObject).getIntValue();
            }
        }
        return (int) ((XmlObjectBase) xmlObject).getLongValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(getIntValue(), schemaType(), validationContext);
    }
}
