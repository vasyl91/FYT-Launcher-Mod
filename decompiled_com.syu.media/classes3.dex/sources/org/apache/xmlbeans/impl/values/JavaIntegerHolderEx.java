package org.apache.xmlbeans.impl.values;

import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlPositiveInteger;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class JavaIntegerHolderEx extends JavaIntegerHolder {
    private SchemaType _schemaType;

    public JavaIntegerHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaIntegerHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaIntegerHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        BigInteger bigIntegerLex = lex(str, _voorVc);
        if (_validateOnSet()) {
            validateValue(bigIntegerLex, this._schemaType, _voorVc);
        }
        if (_validateOnSet()) {
            validateLexical(str, this._schemaType, _voorVc);
        }
        super.set_BigInteger(bigIntegerLex);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaIntegerHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_BigInteger(BigInteger bigInteger) {
        if (_validateOnSet()) {
            validateValue(bigInteger, this._schemaType, _voorVc);
        }
        super.set_BigInteger(bigInteger);
    }

    public static void validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        JavaDecimalHolder.validateLexical(str, validationContext);
        if (str.lastIndexOf(46) >= 0) {
            validationContext.invalid("integer", new Object[]{str});
        }
        if (!schemaType.hasPatternFacet() || schemaType.matchPatternFacet(str)) {
            return;
        }
        validationContext.invalid("cvc-datatype-valid.1.1", new Object[]{"integer", str, QNameHelper.readable(schemaType)});
    }

    private static void validateValue(BigInteger bigInteger, SchemaType schemaType, ValidationContext validationContext) {
        XmlPositiveInteger facet = schemaType.getFacet(7);
        if (facet != null) {
            String string = bigInteger.toString();
            int length = string.length();
            if (length > 0 && string.charAt(0) == '-') {
                length--;
            }
            if (length > facet.getBigIntegerValue().intValue()) {
                validationContext.invalid("cvc-totalDigits-valid", new Object[]{new Integer(length), string, new Integer(facet.getBigIntegerValue().intValue()), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet2 = schemaType.getFacet(3);
        if (facet2 != null) {
            BigInteger bigIntegerValue = getBigIntegerValue(facet2);
            if (bigInteger.compareTo(bigIntegerValue) <= 0) {
                validationContext.invalid("cvc-minExclusive-valid", new Object[]{"integer", bigInteger, bigIntegerValue, QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet3 = schemaType.getFacet(4);
        if (facet3 != null) {
            BigInteger bigIntegerValue2 = getBigIntegerValue(facet3);
            if (bigInteger.compareTo(bigIntegerValue2) < 0) {
                validationContext.invalid("cvc-minInclusive-valid", new Object[]{"integer", bigInteger, bigIntegerValue2, QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet4 = schemaType.getFacet(5);
        if (facet4 != null) {
            BigInteger bigIntegerValue3 = getBigIntegerValue(facet4);
            if (bigInteger.compareTo(bigIntegerValue3) > 0) {
                validationContext.invalid("cvc-maxInclusive-valid", new Object[]{"integer", bigInteger, bigIntegerValue3, QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet5 = schemaType.getFacet(6);
        if (facet5 != null) {
            BigInteger bigIntegerValue4 = getBigIntegerValue(facet5);
            if (bigInteger.compareTo(bigIntegerValue4) >= 0) {
                validationContext.invalid("cvc-maxExclusive-valid", new Object[]{"integer", bigInteger, bigIntegerValue4, QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlObject[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (XmlObject xmlObject : enumerationValues) {
                if (bigInteger.equals(getBigIntegerValue(xmlObject))) {
                    return;
                }
            }
            validationContext.invalid("cvc-enumeration-valid", new Object[]{"integer", bigInteger, QNameHelper.readable(schemaType)});
        }
    }

    private static BigInteger getBigIntegerValue(XmlObject xmlObject) {
        SchemaType schemaType = xmlObject.schemaType();
        switch (schemaType.getDecimalSize()) {
            case 1000000:
                return ((XmlObjectBase) xmlObject).bigIntegerValue();
            case 1000001:
                return ((XmlObjectBase) xmlObject).bigDecimalValue().toBigInteger();
            default:
                throw new IllegalStateException("Bad facet type for Big Int: " + schemaType);
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(getBigIntegerValue(), schemaType(), validationContext);
    }
}
