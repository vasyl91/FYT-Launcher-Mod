package org.apache.xmlbeans.impl.values;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class JavaQNameHolderEx extends JavaQNameHolder {
    private SchemaType _schemaType;

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return this._schemaType;
    }

    public JavaQNameHolderEx(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int get_wscanon_rule() {
        return schemaType().getWhiteSpaceRule();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        QName qNameValidateLexical;
        PrefixResolver current = NamespaceContext.getCurrent();
        if (current == null && has_store()) {
            current = get_store();
        }
        if (_validateOnSet()) {
            qNameValidateLexical = validateLexical(str, this._schemaType, _voorVc, current);
            if (qNameValidateLexical != null) {
                validateValue(qNameValidateLexical, this._schemaType, _voorVc);
            }
        } else {
            qNameValidateLexical = JavaQNameHolder.validateLexical(str, _voorVc, current);
        }
        super.set_QName(qNameValidateLexical);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_QName(QName qName) {
        if (_validateOnSet()) {
            validateValue(qName, this._schemaType, _voorVc);
        }
        super.set_QName(qName);
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
            qNameValidateLexical = JavaQNameHolder.validateLexical(xmlAnySimpleType.getStringValue(), _voorVc, NamespaceContext.getCurrent());
        }
        super.set_QName(qNameValidateLexical);
    }

    public static QName validateLexical(String str, SchemaType schemaType, ValidationContext validationContext, PrefixResolver prefixResolver) {
        QName qNameValidateLexical = JavaQNameHolder.validateLexical(str, validationContext, prefixResolver);
        if (schemaType.hasPatternFacet() && !schemaType.matchPatternFacet(str)) {
            validationContext.invalid("cvc-datatype-valid.1.1", new Object[]{"QName", str, QNameHelper.readable(schemaType)});
        }
        return qNameValidateLexical;
    }

    public static void validateValue(QName qName, SchemaType schemaType, ValidationContext validationContext) {
        XmlObjectBase[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (XmlObjectBase xmlObjectBase : enumerationValues) {
                if (qName.equals(xmlObjectBase.getQNameValue())) {
                    return;
                }
            }
            validationContext.invalid("cvc-enumeration-valid", new Object[]{"QName", qName, QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateValue(getQNameValue(), schemaType(), validationContext);
    }
}
