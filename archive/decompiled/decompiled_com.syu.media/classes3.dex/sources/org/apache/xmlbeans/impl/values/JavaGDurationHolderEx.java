package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.GDurationSpecification;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class JavaGDurationHolderEx extends XmlObjectBase {
    private SchemaType _schemaType;
    GDuration _value;

    public JavaGDurationHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        GDuration gDurationLex;
        if (_validateOnSet()) {
            gDurationLex = validateLexical(str, this._schemaType, _voorVc);
        } else {
            gDurationLex = lex(str, _voorVc);
        }
        if (_validateOnSet() && gDurationLex != null) {
            validateValue(gDurationLex, this._schemaType, _voorVc);
        }
        this._value = gDurationLex;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_GDuration(GDurationSpecification gDurationSpecification) {
        if (_validateOnSet()) {
            validateValue(gDurationSpecification, this._schemaType, _voorVc);
        }
        if (gDurationSpecification.isImmutable() && (gDurationSpecification instanceof GDuration)) {
            this._value = (GDuration) gDurationSpecification;
        } else {
            this._value = new GDuration(gDurationSpecification);
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected String compute_text(NamespaceManager namespaceManager) {
        GDuration gDuration = this._value;
        return gDuration == null ? "" : gDuration.toString();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public GDuration getGDurationValue() {
        check_dated();
        GDuration gDuration = this._value;
        if (gDuration == null) {
            return null;
        }
        return gDuration;
    }

    public static GDuration lex(String str, ValidationContext validationContext) {
        try {
            return new GDuration(str);
        } catch (Exception unused) {
            validationContext.invalid("duration", new Object[]{str});
            return null;
        }
    }

    public static GDuration validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        GDuration gDurationLex = lex(str, validationContext);
        if (gDurationLex != null && schemaType.hasPatternFacet() && !schemaType.matchPatternFacet(str)) {
            validationContext.invalid("cvc-datatype-valid.1.1", new Object[]{"duration", str, QNameHelper.readable(schemaType)});
        }
        return gDurationLex;
    }

    public static void validateValue(GDurationSpecification gDurationSpecification, SchemaType schemaType, ValidationContext validationContext) {
        XmlObjectBase facet = schemaType.getFacet(3);
        if (facet != null) {
            GDuration gDurationGDurationValue = facet.gDurationValue();
            if (gDurationSpecification.compareToGDuration(gDurationGDurationValue) <= 0) {
                validationContext.invalid("cvc-minExclusive-valid", new Object[]{"duration", gDurationSpecification, gDurationGDurationValue, QNameHelper.readable(schemaType)});
            }
        }
        XmlObjectBase facet2 = schemaType.getFacet(4);
        if (facet2 != null) {
            GDuration gDurationGDurationValue2 = facet2.gDurationValue();
            if (gDurationSpecification.compareToGDuration(gDurationGDurationValue2) < 0) {
                validationContext.invalid("cvc-minInclusive-valid", new Object[]{"duration", gDurationSpecification, gDurationGDurationValue2, QNameHelper.readable(schemaType)});
            }
        }
        XmlObjectBase facet3 = schemaType.getFacet(6);
        if (facet3 != null) {
            GDuration gDurationGDurationValue3 = facet3.gDurationValue();
            if (gDurationSpecification.compareToGDuration(gDurationGDurationValue3) >= 0) {
                validationContext.invalid("cvc-maxExclusive-valid", new Object[]{"duration", gDurationSpecification, gDurationGDurationValue3, QNameHelper.readable(schemaType)});
            }
        }
        XmlObjectBase facet4 = schemaType.getFacet(5);
        if (facet4 != null) {
            GDuration gDurationGDurationValue4 = facet4.gDurationValue();
            if (gDurationSpecification.compareToGDuration(gDurationGDurationValue4) > 0) {
                validationContext.invalid("cvc-maxInclusive-valid", new Object[]{"duration", gDurationSpecification, gDurationGDurationValue4, QNameHelper.readable(schemaType)});
            }
        }
        XmlObjectBase[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (XmlObjectBase xmlObjectBase : enumerationValues) {
                if (gDurationSpecification.compareToGDuration(xmlObjectBase.gDurationValue()) == 0) {
                    return;
                }
            }
            validationContext.invalid("cvc-enumeration-valid", new Object[]{"duration", gDurationSpecification, QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int compare_to(XmlObject xmlObject) {
        return this._value.compareToGDuration(((XmlObjectBase) xmlObject).gDurationValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        return this._value.equals(((XmlObjectBase) xmlObject).gDurationValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        return this._value.hashCode();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(gDurationValue(), schemaType(), validationContext);
    }
}
