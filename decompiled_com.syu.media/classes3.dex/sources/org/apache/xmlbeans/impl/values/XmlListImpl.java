package org.apache.xmlbeans.impl.values;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlSimpleList;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.XMLChar;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XmlListImpl extends XmlObjectBase implements XmlAnySimpleType {
    private static final String[] EMPTY_STRINGARRAY = new String[0];
    private XmlSimpleList _jvalue;
    private SchemaType _schemaType;
    private XmlSimpleList _value;

    private static String nullAsEmpty(String str) {
        return str == null ? "" : str;
    }

    public XmlListImpl(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return this._schemaType;
    }

    private static String compute_list_text(List list) {
        if (list.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(nullAsEmpty(((SimpleValue) list.get(0)).getStringValue()));
        for (int i = 1; i < list.size(); i++) {
            stringBuffer.append(' ');
            stringBuffer.append(nullAsEmpty(((SimpleValue) list.get(i)).getStringValue()));
        }
        return stringBuffer.toString();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected String compute_text(NamespaceManager namespaceManager) {
        return compute_list_text(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean is_defaultable_ws(String str) {
        try {
            XmlSimpleList xmlSimpleList = this._value;
            set_text(str);
            this._value = xmlSimpleList;
            return false;
        } catch (XmlValueOutOfRangeException unused) {
            return true;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        if (_validateOnSet() && !this._schemaType.matchPatternFacet(str)) {
            throw new XmlValueOutOfRangeException("cvc-datatype-valid.1.1", new Object[]{"list", str, QNameHelper.readable(this._schemaType)});
        }
        XmlSimpleList xmlSimpleListLex = lex(str, this._schemaType.getListItemType(), _voorVc, has_store() ? get_store() : null);
        if (_validateOnSet()) {
            validateValue(xmlSimpleListLex, this._schemaType, _voorVc);
        }
        this._value = xmlSimpleListLex;
        this._jvalue = null;
    }

    public static String[] split_list(String str) {
        if (str.length() == 0) {
            return EMPTY_STRINGARRAY;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            if (i < str.length() && XMLChar.isSpace(str.charAt(i))) {
                i++;
            } else {
                if (i >= str.length()) {
                    return (String[]) arrayList.toArray(EMPTY_STRINGARRAY);
                }
                int i2 = i;
                while (i2 < str.length() && !XMLChar.isSpace(str.charAt(i2))) {
                    i2++;
                }
                arrayList.add(str.substring(i, i2));
                i = i2;
            }
        }
    }

    public static XmlSimpleList lex(String str, SchemaType schemaType, ValidationContext validationContext, PrefixResolver prefixResolver) {
        boolean z;
        String[] strArrSplit_list = split_list(str);
        XmlAnySimpleType[] xmlAnySimpleTypeArr = new XmlAnySimpleType[strArrSplit_list.length];
        if (prefixResolver != null) {
            NamespaceContext.push(new NamespaceContext(prefixResolver));
            z = true;
        } else {
            z = false;
        }
        for (int i = 0; i < strArrSplit_list.length; i++) {
            try {
                try {
                    xmlAnySimpleTypeArr[i] = schemaType.newValue(strArrSplit_list[i]);
                } catch (XmlValueOutOfRangeException unused) {
                    validationContext.invalid("list", new Object[]{"item '" + strArrSplit_list[i] + "' is not a valid value of " + QNameHelper.readable(schemaType)});
                }
            } catch (Throwable th) {
                if (z) {
                    NamespaceContext.pop();
                }
                throw th;
            }
        }
        if (z) {
            NamespaceContext.pop();
        }
        return new XmlSimpleList(Arrays.asList(xmlAnySimpleTypeArr));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public List xgetListValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public List getListValue() {
        check_dated();
        if (this._value == null) {
            return null;
        }
        XmlSimpleList xmlSimpleList = this._jvalue;
        if (xmlSimpleList != null) {
            return xmlSimpleList;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this._value.size(); i++) {
            arrayList.add(java_value((XmlObject) this._value.get(i)));
        }
        XmlSimpleList xmlSimpleList2 = new XmlSimpleList(arrayList);
        this._jvalue = xmlSimpleList2;
        return xmlSimpleList2;
    }

    private static boolean permits_inner_space(XmlObject xmlObject) {
        int builtinTypeCode = ((SimpleValue) xmlObject).instanceType().getPrimitiveType().getBuiltinTypeCode();
        return builtinTypeCode == 1 || builtinTypeCode == 2 || builtinTypeCode == 6 || builtinTypeCode == 12;
    }

    private static boolean contains_white_space(String str) {
        return str.indexOf(32) >= 0 || str.indexOf(9) >= 0 || str.indexOf(10) >= 0 || str.indexOf(13) >= 0;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_list(List list) {
        boolean z;
        SchemaType listItemType = this._schemaType.getListItemType();
        if (has_store()) {
            NamespaceContext.push(new NamespaceContext(get_store()));
            z = true;
        } else {
            z = false;
        }
        try {
            XmlAnySimpleType[] xmlAnySimpleTypeArr = new XmlAnySimpleType[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Object obj = list.get(i);
                if ((obj instanceof XmlObject) && permits_inner_space((XmlObject) list.get(i)) && contains_white_space(list.get(i).toString())) {
                    throw new XmlValueOutOfRangeException();
                }
                xmlAnySimpleTypeArr[i] = listItemType.newValue(obj);
            }
            XmlSimpleList xmlSimpleList = new XmlSimpleList(Arrays.asList(xmlAnySimpleTypeArr));
            if (z) {
                NamespaceContext.pop();
            }
            if (_validateOnSet()) {
                validateValue(xmlSimpleList, this._schemaType, _voorVc);
            }
            this._value = xmlSimpleList;
            this._jvalue = null;
        } catch (Throwable th) {
            if (z) {
                NamespaceContext.pop();
            }
            throw th;
        }
    }

    public static void validateValue(XmlSimpleList xmlSimpleList, SchemaType schemaType, ValidationContext validationContext) {
        int intValue;
        int intValue2;
        int intValue3;
        XmlObjectBase[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            int i = 0;
            while (true) {
                if (i >= enumerationValues.length) {
                    validationContext.invalid("cvc-enumeration-valid", new Object[]{"list", xmlSimpleList, QNameHelper.readable(schemaType)});
                    break;
                } else if (equal_xmlLists(xmlSimpleList, enumerationValues[i].xlistValue())) {
                    break;
                } else {
                    i++;
                }
            }
        }
        SimpleValue facet = schemaType.getFacet(0);
        if (facet != null && (intValue3 = facet.getIntValue()) != xmlSimpleList.size()) {
            validationContext.invalid("cvc-length-valid.2", new Object[]{xmlSimpleList, new Integer(xmlSimpleList.size()), new Integer(intValue3), QNameHelper.readable(schemaType)});
        }
        SimpleValue facet2 = schemaType.getFacet(1);
        if (facet2 != null && (intValue2 = facet2.getIntValue()) > xmlSimpleList.size()) {
            validationContext.invalid("cvc-minLength-valid.2", new Object[]{xmlSimpleList, new Integer(xmlSimpleList.size()), new Integer(intValue2), QNameHelper.readable(schemaType)});
        }
        SimpleValue facet3 = schemaType.getFacet(2);
        if (facet3 == null || (intValue = facet3.getIntValue()) >= xmlSimpleList.size()) {
            return;
        }
        validationContext.invalid("cvc-maxLength-valid.2", new Object[]{xmlSimpleList, new Integer(xmlSimpleList.size()), new Integer(intValue), QNameHelper.readable(schemaType)});
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        return equal_xmlLists(this._value, ((XmlObjectBase) xmlObject).xlistValue());
    }

    private static boolean equal_xmlLists(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        XmlSimpleList xmlSimpleList = this._value;
        int i = 0;
        if (xmlSimpleList == null) {
            return 0;
        }
        int size = xmlSimpleList.size();
        int size2 = this._value.size() / 9;
        if (size2 < 1) {
            size2 = 1;
        }
        while (i < this._value.size()) {
            size = (size * 19) + this._value.get(i).hashCode();
            i += size2;
        }
        return i < this._value.size() ? (size * 19) + this._value.get(i).hashCode() : size;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateValue(xlistValue(), schemaType(), validationContext);
    }
}
