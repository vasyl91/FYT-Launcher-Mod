package org.apache.xmlbeans.impl.values;

import java.util.Calendar;
import java.util.Date;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateBuilder;
import org.apache.xmlbeans.GDateSpecification;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class JavaGDateHolderEx extends XmlObjectBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private SchemaType _schemaType;
    private GDate _value;

    public JavaGDateHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected String compute_text(NamespaceManager namespaceManager) {
        GDate gDate = this._value;
        return gDate == null ? "" : gDate.toString();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        GDate gDateLex;
        if (_validateOnSet()) {
            gDateLex = validateLexical(str, this._schemaType, _voorVc);
        } else {
            gDateLex = lex(str, this._schemaType, _voorVc);
        }
        if (_validateOnSet() && gDateLex != null) {
            validateValue(gDateLex, this._schemaType, _voorVc);
        }
        this._value = gDateLex;
    }

    public static GDate lex(String str, SchemaType schemaType, ValidationContext validationContext) {
        GDate gDate;
        try {
            gDate = new GDate(str);
        } catch (Exception unused) {
            validationContext.invalid("date", new Object[]{str});
            gDate = null;
        }
        if (gDate != null) {
            if (gDate.getBuiltinTypeCode() != schemaType.getPrimitiveType().getBuiltinTypeCode()) {
                validationContext.invalid("date", new Object[]{"wrong type: " + str});
                return null;
            }
            if (!gDate.isValid()) {
                validationContext.invalid("date", new Object[]{str});
                return null;
            }
        }
        return gDate;
    }

    public static GDate validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        GDate gDateLex = lex(str, schemaType, validationContext);
        if (gDateLex != null && schemaType.hasPatternFacet() && !schemaType.matchPatternFacet(str)) {
            validationContext.invalid("cvc-datatype-valid.1.1", new Object[]{"date", str, QNameHelper.readable(schemaType)});
        }
        return gDateLex;
    }

    public static void validateValue(GDateSpecification gDateSpecification, SchemaType schemaType, ValidationContext validationContext) {
        if (gDateSpecification.getBuiltinTypeCode() != schemaType.getPrimitiveType().getBuiltinTypeCode()) {
            validationContext.invalid("date", new Object[]{"Date (" + gDateSpecification + ") does not have the set of fields required for " + QNameHelper.readable(schemaType)});
        }
        XmlObjectBase facet = schemaType.getFacet(3);
        if (facet != null) {
            GDate gDateGDateValue = facet.gDateValue();
            if (gDateSpecification.compareToGDate(gDateGDateValue) <= 0) {
                validationContext.invalid("cvc-minExclusive-valid", new Object[]{"date", gDateSpecification, gDateGDateValue, QNameHelper.readable(schemaType)});
            }
        }
        XmlObjectBase facet2 = schemaType.getFacet(4);
        if (facet2 != null) {
            GDate gDateGDateValue2 = facet2.gDateValue();
            if (gDateSpecification.compareToGDate(gDateGDateValue2) < 0) {
                validationContext.invalid("cvc-minInclusive-valid", new Object[]{"date", gDateSpecification, gDateGDateValue2, QNameHelper.readable(schemaType)});
            }
        }
        XmlObjectBase facet3 = schemaType.getFacet(6);
        if (facet3 != null) {
            GDate gDateGDateValue3 = facet3.gDateValue();
            if (gDateSpecification.compareToGDate(gDateGDateValue3) >= 0) {
                validationContext.invalid("cvc-maxExclusive-valid", new Object[]{"date", gDateSpecification, gDateGDateValue3, QNameHelper.readable(schemaType)});
            }
        }
        XmlObjectBase facet4 = schemaType.getFacet(5);
        if (facet4 != null) {
            GDate gDateGDateValue4 = facet4.gDateValue();
            if (gDateSpecification.compareToGDate(gDateGDateValue4) > 0) {
                validationContext.invalid("cvc-maxInclusive-valid", new Object[]{"date", gDateSpecification, gDateGDateValue4, QNameHelper.readable(schemaType)});
            }
        }
        XmlObjectBase[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (XmlObjectBase xmlObjectBase : enumerationValues) {
                if (gDateSpecification.compareToGDate(xmlObjectBase.gDateValue()) == 0) {
                    return;
                }
            }
            validationContext.invalid("cvc-enumeration-valid", new Object[]{"date", gDateSpecification, QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int getIntValue() {
        int builtinTypeCode = schemaType().getPrimitiveType().getBuiltinTypeCode();
        if (builtinTypeCode != 20 && builtinTypeCode != 21 && builtinTypeCode != 18) {
            throw new XmlValueOutOfRangeException();
        }
        check_dated();
        GDate gDate = this._value;
        if (gDate == null) {
            return 0;
        }
        if (builtinTypeCode == 18) {
            return gDate.getYear();
        }
        if (builtinTypeCode == 20) {
            return gDate.getDay();
        }
        if (builtinTypeCode == 21) {
            return gDate.getMonth();
        }
        throw new IllegalStateException();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public GDate getGDateValue() {
        check_dated();
        GDate gDate = this._value;
        if (gDate == null) {
            return null;
        }
        return gDate;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public Calendar getCalendarValue() {
        check_dated();
        GDate gDate = this._value;
        if (gDate == null) {
            return null;
        }
        return gDate.getCalendar();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public Date getDateValue() {
        check_dated();
        GDate gDate = this._value;
        if (gDate == null) {
            return null;
        }
        return gDate.getDate();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_int(int i) {
        int builtinTypeCode = schemaType().getPrimitiveType().getBuiltinTypeCode();
        if (builtinTypeCode != 20 && builtinTypeCode != 21 && builtinTypeCode != 18) {
            throw new XmlValueOutOfRangeException();
        }
        GDateBuilder gDateBuilder = new GDateBuilder();
        if (builtinTypeCode == 18) {
            gDateBuilder.setYear(i);
        } else if (builtinTypeCode == 20) {
            gDateBuilder.setDay(i);
        } else if (builtinTypeCode == 21) {
            gDateBuilder.setMonth(i);
        }
        if (_validateOnSet()) {
            validateValue(gDateBuilder, this._schemaType, _voorVc);
        }
        this._value = gDateBuilder.toGDate();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_GDate(GDateSpecification gDateSpecification) {
        GDate gDate;
        int builtinTypeCode = schemaType().getPrimitiveType().getBuiltinTypeCode();
        if (gDateSpecification.isImmutable() && (gDateSpecification instanceof GDate) && gDateSpecification.getBuiltinTypeCode() == builtinTypeCode) {
            gDate = (GDate) gDateSpecification;
        } else {
            if (gDateSpecification.getBuiltinTypeCode() != builtinTypeCode) {
                GDateSpecification gDateBuilder = new GDateBuilder(gDateSpecification);
                gDateBuilder.setBuiltinTypeCode(builtinTypeCode);
                gDateSpecification = gDateBuilder;
            }
            gDate = new GDate(gDateSpecification);
        }
        if (_validateOnSet()) {
            validateValue(gDate, this._schemaType, _voorVc);
        }
        this._value = gDate;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_Calendar(Calendar calendar) {
        int builtinTypeCode = schemaType().getPrimitiveType().getBuiltinTypeCode();
        GDateBuilder gDateBuilder = new GDateBuilder(calendar);
        gDateBuilder.setBuiltinTypeCode(builtinTypeCode);
        GDate gDate = gDateBuilder.toGDate();
        if (_validateOnSet()) {
            validateValue(gDate, this._schemaType, _voorVc);
        }
        this._value = gDate;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_Date(Date date) {
        int builtinTypeCode = schemaType().getPrimitiveType().getBuiltinTypeCode();
        if ((builtinTypeCode != 16 && builtinTypeCode != 14) || date == null) {
            throw new XmlValueOutOfRangeException();
        }
        GDateBuilder gDateBuilder = new GDateBuilder(date);
        gDateBuilder.setBuiltinTypeCode(builtinTypeCode);
        GDate gDate = gDateBuilder.toGDate();
        if (_validateOnSet()) {
            validateValue(gDate, this._schemaType, _voorVc);
        }
        this._value = gDate;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int compare_to(XmlObject xmlObject) {
        return this._value.compareToGDate(((XmlObjectBase) xmlObject).gDateValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        return this._value.equals(((XmlObjectBase) xmlObject).gDateValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        return this._value.hashCode();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(gDateValue(), schemaType(), validationContext);
    }
}
