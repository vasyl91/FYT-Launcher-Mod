package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class JavaFloatHolderEx extends JavaFloatHolder {
    private SchemaType _schemaType;

    public JavaFloatHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaFloatHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaFloatHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_float(float f) {
        if (_validateOnSet()) {
            validateValue(f, this._schemaType, _voorVc);
        }
        super.set_float(f);
    }

    public static float validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        float fValidateLexical = JavaFloatHolder.validateLexical(str, validationContext);
        if (!schemaType.matchPatternFacet(str)) {
            validationContext.invalid("cvc-datatype-valid.1.1", new Object[]{"float", str, QNameHelper.readable(schemaType)});
        }
        return fValidateLexical;
    }

    public static void validateValue(float f, SchemaType schemaType, ValidationContext validationContext) {
        XmlObjectBase facet = schemaType.getFacet(3);
        if (facet != null) {
            float fFloatValue = facet.floatValue();
            if (compare(f, fFloatValue) <= 0) {
                validationContext.invalid("cvc-minExclusive-valid", new Object[]{"float", new Float(f), new Float(fFloatValue), QNameHelper.readable(schemaType)});
            }
        }
        XmlObjectBase facet2 = schemaType.getFacet(4);
        if (facet2 != null) {
            float fFloatValue2 = facet2.floatValue();
            if (compare(f, fFloatValue2) < 0) {
                validationContext.invalid("cvc-minInclusive-valid", new Object[]{"float", new Float(f), new Float(fFloatValue2), QNameHelper.readable(schemaType)});
            }
        }
        XmlObjectBase facet3 = schemaType.getFacet(5);
        if (facet3 != null) {
            float fFloatValue3 = facet3.floatValue();
            if (compare(f, fFloatValue3) > 0) {
                validationContext.invalid("cvc-maxInclusive-valid", new Object[]{"float", new Float(f), new Float(fFloatValue3), QNameHelper.readable(schemaType)});
            }
        }
        XmlObjectBase facet4 = schemaType.getFacet(6);
        if (facet4 != null) {
            float fFloatValue4 = facet4.floatValue();
            if (compare(f, fFloatValue4) >= 0) {
                validationContext.invalid("cvc-maxExclusive-valid", new Object[]{"float", new Float(f), new Float(fFloatValue4), QNameHelper.readable(schemaType)});
            }
        }
        XmlObjectBase[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (XmlObjectBase xmlObjectBase : enumerationValues) {
                if (compare(f, xmlObjectBase.floatValue()) == 0) {
                    return;
                }
            }
            validationContext.invalid("cvc-enumeration-valid", new Object[]{"float", new Float(f), QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(floatValue(), schemaType(), validationContext);
    }
}
