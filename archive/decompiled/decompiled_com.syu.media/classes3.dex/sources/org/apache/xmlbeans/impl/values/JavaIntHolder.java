package org.apache.xmlbeans.impl.values;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
import org.apache.xmlbeans.impl.util.XsTypeConverter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class JavaIntHolder extends XmlObjectBase {
    static final BigInteger _max = BigInteger.valueOf(2147483647L);
    static final BigInteger _min = BigInteger.valueOf(-2147483648L);
    private int _value;

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_INT;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager namespaceManager) {
        return Long.toString(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        try {
            set_int(XsTypeConverter.lexInt(str));
        } catch (Exception unused) {
            throw new XmlValueOutOfRangeException("int", new Object[]{str});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._value = 0;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public BigDecimal getBigDecimalValue() {
        check_dated();
        return new BigDecimal(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public BigInteger getBigIntegerValue() {
        check_dated();
        return BigInteger.valueOf(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public long getLongValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int getIntValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_BigDecimal(BigDecimal bigDecimal) {
        set_BigInteger(bigDecimal.toBigInteger());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_BigInteger(BigInteger bigInteger) {
        if (bigInteger.compareTo(_max) > 0 || bigInteger.compareTo(_min) < 0) {
            throw new XmlValueOutOfRangeException();
        }
        set_int(bigInteger.intValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_long(long j) {
        if (j > 2147483647L || j < -2147483648L) {
            throw new XmlValueOutOfRangeException();
        }
        set_int((int) j);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_int(int i) {
        this._value = i;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int compare_to(XmlObject xmlObject) {
        if (((SimpleValue) xmlObject).instanceType().getDecimalSize() > 32) {
            return -xmlObject.compareTo(this);
        }
        XmlObjectBase xmlObjectBase = (XmlObjectBase) xmlObject;
        if (this._value == xmlObjectBase.intValue()) {
            return 0;
        }
        return this._value < xmlObjectBase.intValue() ? -1 : 1;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        if (((SimpleValue) xmlObject).instanceType().getDecimalSize() > 32) {
            return xmlObject.valueEquals(this);
        }
        return this._value == ((XmlObjectBase) xmlObject).intValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        return this._value;
    }
}
