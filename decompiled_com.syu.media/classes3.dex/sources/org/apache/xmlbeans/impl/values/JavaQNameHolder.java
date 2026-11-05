package org.apache.xmlbeans.impl.values;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class JavaQNameHolder extends XmlObjectBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final NamespaceManager PRETTY_PREFIXER = new PrettyNamespaceManager();
    private QName _value;

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int get_wscanon_rule() {
        return 1;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_QNAME;
    }

    private static class PrettyNamespaceManager implements NamespaceManager {
        private PrettyNamespaceManager() {
        }

        @Override // org.apache.xmlbeans.impl.values.NamespaceManager
        public String find_prefix_for_nsuri(String str, String str2) {
            return QNameHelper.suggestPrefix(str);
        }

        @Override // org.apache.xmlbeans.impl.common.PrefixResolver
        public String getNamespaceForPrefix(String str) {
            throw new RuntimeException("Should not be called");
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager namespaceManager) {
        if (namespaceManager == null) {
            namespaceManager = PRETTY_PREFIXER;
        }
        String namespaceURI = this._value.getNamespaceURI();
        String localPart = this._value.getLocalPart();
        if (namespaceURI == null || namespaceURI.length() == 0) {
            return localPart;
        }
        String strFind_prefix_for_nsuri = namespaceManager.find_prefix_for_nsuri(namespaceURI, null);
        return "".equals(strFind_prefix_for_nsuri) ? localPart : strFind_prefix_for_nsuri + ":" + localPart;
    }

    public static QName validateLexical(String str, ValidationContext validationContext, PrefixResolver prefixResolver) {
        try {
            return parse(str, prefixResolver);
        } catch (XmlValueOutOfRangeException e) {
            validationContext.invalid(e.getMessage());
            return null;
        }
    }

    private static QName parse(String str, PrefixResolver prefixResolver) {
        String strSubstring;
        String strSubstring2;
        int length = str.length();
        while (length > 0 && XMLChar.isSpace(str.charAt(length - 1))) {
            length--;
        }
        int i = 0;
        while (i < length && XMLChar.isSpace(str.charAt(i))) {
            i++;
        }
        int iIndexOf = str.indexOf(58, i);
        String str2 = "";
        if (iIndexOf >= 0) {
            strSubstring2 = str.substring(i, iIndexOf);
            strSubstring = str.substring(iIndexOf + 1, length);
        } else {
            strSubstring = str.substring(i, length);
            strSubstring2 = "";
        }
        if (strSubstring2.length() > 0 && !XMLChar.isValidNCName(strSubstring2)) {
            throw new XmlValueOutOfRangeException("QName", new Object[]{"Prefix not a valid NCName in '" + str + "'"});
        }
        if (!XMLChar.isValidNCName(strSubstring)) {
            throw new XmlValueOutOfRangeException("QName", new Object[]{"Localname not a valid NCName in '" + str + "'"});
        }
        String namespaceForPrefix = prefixResolver == null ? null : prefixResolver.getNamespaceForPrefix(strSubstring2);
        if (namespaceForPrefix != null) {
            str2 = namespaceForPrefix;
        } else if (strSubstring2.length() > 0) {
            throw new XmlValueOutOfRangeException("QName", new Object[]{"Can't resolve prefix '" + strSubstring2 + "'"});
        }
        if (strSubstring2 != null && strSubstring2.length() > 0) {
            return new QName(str2, strSubstring, strSubstring2);
        }
        return new QName(str2, strSubstring);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        PrefixResolver current = NamespaceContext.getCurrent();
        if (current == null && has_store()) {
            current = get_store();
        }
        this._value = parse(str, current);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_QName(QName qName) {
        if (has_store()) {
            get_store().find_prefix_for_nsuri(qName.getNamespaceURI(), null);
        }
        this._value = qName;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_xmlanysimple(XmlAnySimpleType xmlAnySimpleType) {
        this._value = parse(xmlAnySimpleType.getStringValue(), NamespaceContext.getCurrent());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public QName getQNameValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        return this._value.equals(((XmlObjectBase) xmlObject).qNameValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        return this._value.hashCode();
    }
}
