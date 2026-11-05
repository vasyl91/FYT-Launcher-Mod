package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class JavaDoubleHolderEx extends JavaDoubleHolder {
    private SchemaType _schemaType;

    public JavaDoubleHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaDoubleHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaDoubleHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_double(double d) {
        if (_validateOnSet()) {
            validateValue(d, this._schemaType, _voorVc);
        }
        super.set_double(d);
    }

    public static double validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        double dValidateLexical = JavaDoubleHolder.validateLexical(str, validationContext);
        if (!schemaType.matchPatternFacet(str)) {
            validationContext.invalid("cvc-datatype-valid.1.1", new Object[]{"double", str, QNameHelper.readable(schemaType)});
        }
        return dValidateLexical;
    }

    public static void validateValue(double d, SchemaType schemaType, ValidationContext validationContext) {
        XmlObjectBase facet = schemaType.getFacet(3);
        if (facet != null) {
            double dDoubleValue = facet.doubleValue();
            if (compare(d, dDoubleValue) <= 0) {
                validationContext.invalid("cvc-minExclusive-valid", new Object[]{"double", new Double(d), new Double(dDoubleValue), QNameHelper.readable(schemaType)});
            }
        }
        XmlObjectBase facet2 = schemaType.getFacet(4);
        if (facet2 != null) {
            double dDoubleValue2 = facet2.doubleValue();
            if (compare(d, dDoubleValue2) < 0) {
                validationContext.invalid("cvc-minInclusive-valid", new Object[]{"double", new Double(d), new Double(dDoubleValue2), QNameHelper.readable(schemaType)});
            }
        }
        XmlObjectBase facet3 = schemaType.getFacet(5);
        if (facet3 != null) {
            double dDoubleValue3 = facet3.doubleValue();
            if (compare(d, dDoubleValue3) > 0) {
                validationContext.invalid("cvc-maxInclusive-valid", new Object[]{"double", new Double(d), new Double(dDoubleValue3), QNameHelper.readable(schemaType)});
            }
        }
        XmlObjectBase facet4 = schemaType.getFacet(6);
        if (facet4 != null) {
            double dDoubleValue4 = facet4.doubleValue();
            if (compare(d, dDoubleValue4) >= 0) {
                validationContext.invalid("cvc-maxExclusive-valid", new Object[]{"double", new Double(d), new Double(dDoubleValue4), QNameHelper.readable(schemaType)});
            }
        }
        XmlObjectBase[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (XmlObjectBase xmlObjectBase : enumerationValues) {
                if (compare(d, xmlObjectBase.doubleValue()) == 0) {
                    return;
                }
            }
            validationContext.invalid("cvc-enumeration-valid", new Object[]{"double", new Double(d), QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(doubleValue(), schemaType(), validationContext);
    }
}
