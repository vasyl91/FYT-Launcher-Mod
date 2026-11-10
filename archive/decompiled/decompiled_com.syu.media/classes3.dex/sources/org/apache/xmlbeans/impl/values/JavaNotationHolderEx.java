package org.apache.xmlbeans.impl.values;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class JavaNotationHolderEx extends JavaNotationHolder {
    private SchemaType _schemaType;

    @Override // org.apache.xmlbeans.impl.values.JavaNotationHolder, org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return this._schemaType;
    }

    public JavaNotationHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int get_wscanon_rule() {
        return schemaType().getWhiteSpaceRule();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
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

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_notation(String str) {
        set_text(str);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_xmlanysimple(XmlAnySimpleType xmlAnySimpleType) {
        QName qNameValidateLexical;
        if (_validateOnSet()) {
            qNameValidateLexical = validateLexical(xmlAnySimpleType.getStringValue(), this._schemaType, _voorVc, NamespaceContext.getCurrent());
            if (qNameValidateLexical != null) {
                validateValue(qNameValidateLexical, this._schemaType, _voorVc);
            }
        } else {
            qNameValidateLexical = JavaNotationHolder.validateLexical(xmlAnySimpleType.getStringValue(), _voorVc, NamespaceContext.getCurrent());
        }
        super.set_QName(qNameValidateLexical);
    }

    public static QName validateLexical(String str, SchemaType schemaType, ValidationContext validationContext, PrefixResolver prefixResolver) {
        QName qNameValidateLexical = JavaQNameHolder.validateLexical(str, validationContext, prefixResolver);
        if (schemaType.hasPatternFacet() && !schemaType.matchPatternFacet(str)) {
            validationContext.invalid("cvc-datatype-valid.1.1", new Object[]{"NOTATION", str, QNameHelper.readable(schemaType)});
        }
        check(str, schemaType);
        return qNameValidateLexical;
    }

    private static boolean check(String str, SchemaType schemaType) {
        XmlObjectBase facet = schemaType.getFacet(0);
        if (facet != null) {
            if (str.length() == facet.getBigIntegerValue().intValue()) {
                return false;
            }
        }
        XmlObjectBase facet2 = schemaType.getFacet(1);
        if (facet2 != null) {
            if (str.length() < facet2.getBigIntegerValue().intValue()) {
                return false;
            }
        }
        XmlObjectBase facet3 = schemaType.getFacet(2);
        if (facet3 != null) {
            if (str.length() > facet3.getBigIntegerValue().intValue()) {
                return false;
            }
        }
        return true;
    }

    public static void validateValue(QName qName, SchemaType schemaType, ValidationContext validationContext) {
        XmlObjectBase[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (XmlObjectBase xmlObjectBase : enumerationValues) {
                if (qName.equals(xmlObjectBase.getQNameValue())) {
                    return;
                }
            }
            validationContext.invalid("cvc-enumeration-valid", new Object[]{"NOTATION", qName, QNameHelper.readable(schemaType)});
        }
    }
}
