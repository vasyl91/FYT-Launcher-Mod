package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class JavaBooleanHolder extends XmlObjectBase {
    private boolean _value;

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_BOOLEAN;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected String compute_text(NamespaceManager namespaceManager) {
        return this._value ? "true" : "false";
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        this._value = validateLexical(str, _voorVc);
    }

    public static boolean validateLexical(String str, ValidationContext validationContext) {
        if (str.equals("true") || str.equals("1")) {
            return true;
        }
        if (!str.equals("false") && !str.equals("0")) {
            validationContext.invalid("boolean", new Object[]{str});
        }
        return false;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._value = false;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean getBooleanValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_boolean(boolean z) {
        this._value = z;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int compare_to(XmlObject xmlObject) {
        return this._value == ((XmlBoolean) xmlObject).getBooleanValue() ? 0 : 2;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        return this._value == ((XmlBoolean) xmlObject).getBooleanValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        return this._value ? 957379554 : 676335975;
    }
}
