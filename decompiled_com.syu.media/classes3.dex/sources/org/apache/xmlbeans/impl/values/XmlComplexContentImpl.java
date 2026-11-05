package org.apache.xmlbeans.impl.values;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateSpecification;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.GDurationSpecification;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XmlComplexContentImpl extends XmlObjectBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private SchemaTypeImpl _schemaType;

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager namespaceManager) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void update_from_complex_content() {
    }

    public XmlComplexContentImpl(SchemaType schemaType) {
        this._schemaType = (SchemaTypeImpl) schemaType;
        initComplexType(true, true);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected final void set_String(String str) {
        if (this._schemaType.getContentType() != 4 && !this._schemaType.isNoType()) {
            throw new IllegalArgumentException("Type does not allow for textual content: " + this._schemaType);
        }
        super.set_String(str);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject xmlObject) {
        return this._schemaType.equals(xmlObject.schemaType());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        throw new IllegalStateException("Complex types cannot be used as hash keys");
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public TypeStoreVisitor new_visitor() {
        return new SchemaTypeVisitorImpl(this._schemaType.getContentModel());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public boolean is_child_element_order_sensitive() {
        return schemaType().isOrderSensitive();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public int get_elementflags(QName qName) {
        SchemaProperty elementProperty = schemaType().getElementProperty(qName);
        if (elementProperty == null) {
            return 0;
        }
        if (elementProperty.hasDefault() == 1 || elementProperty.hasFixed() == 1 || elementProperty.hasNillable() == 1) {
            return -1;
        }
        return (elementProperty.hasDefault() == 0 ? 0 : 2) | (elementProperty.hasFixed() == 0 ? 0 : 4) | (elementProperty.hasNillable() != 0 ? 1 : 0);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public String get_default_attribute_text(QName qName) {
        return super.get_default_attribute_text(qName);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public String get_default_element_text(QName qName) {
        SchemaProperty elementProperty = schemaType().getElementProperty(qName);
        return elementProperty == null ? "" : elementProperty.getDefaultText();
    }

    protected void unionArraySetterHelper(Object[] objArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = objArr == null ? 0 : objArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).objectSet(objArr[i]);
        }
    }

    protected SimpleValue[] arraySetterHelper(int i, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        SimpleValue[] simpleValueArr = new SimpleValue[i];
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > i) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i2);
            }
            simpleValueArr[i2] = (SimpleValue) typeStoreUserFind_element_user;
        }
        return simpleValueArr;
    }

    protected SimpleValue[] arraySetterHelper(int i, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        SimpleValue[] simpleValueArr = new SimpleValue[i];
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > i) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i2);
            }
            simpleValueArr[i2] = (SimpleValue) typeStoreUserFind_element_user;
        }
        return simpleValueArr;
    }

    protected void arraySetterHelper(boolean[] zArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = zArr == null ? 0 : zArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(zArr[i]);
        }
    }

    protected void arraySetterHelper(float[] fArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = fArr == null ? 0 : fArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(fArr[i]);
        }
    }

    protected void arraySetterHelper(double[] dArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = dArr == null ? 0 : dArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(dArr[i]);
        }
    }

    protected void arraySetterHelper(byte[] bArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = bArr == null ? 0 : bArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(bArr[i]);
        }
    }

    protected void arraySetterHelper(short[] sArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = sArr == null ? 0 : sArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(sArr[i]);
        }
    }

    protected void arraySetterHelper(int[] iArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = iArr == null ? 0 : iArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(iArr[i]);
        }
    }

    protected void arraySetterHelper(long[] jArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = jArr == null ? 0 : jArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(jArr[i]);
        }
    }

    protected void arraySetterHelper(BigDecimal[] bigDecimalArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = bigDecimalArr == null ? 0 : bigDecimalArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(bigDecimalArr[i]);
        }
    }

    protected void arraySetterHelper(BigInteger[] bigIntegerArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = bigIntegerArr == null ? 0 : bigIntegerArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(bigIntegerArr[i]);
        }
    }

    protected void arraySetterHelper(String[] strArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = strArr == null ? 0 : strArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(strArr[i]);
        }
    }

    protected void arraySetterHelper(byte[][] bArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = bArr == null ? 0 : bArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(bArr[i]);
        }
    }

    protected void arraySetterHelper(GDate[] gDateArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = gDateArr == null ? 0 : gDateArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set((GDateSpecification) gDateArr[i]);
        }
    }

    protected void arraySetterHelper(GDuration[] gDurationArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = gDurationArr == null ? 0 : gDurationArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set((GDurationSpecification) gDurationArr[i]);
        }
    }

    protected void arraySetterHelper(Calendar[] calendarArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = calendarArr == null ? 0 : calendarArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(calendarArr[i]);
        }
    }

    protected void arraySetterHelper(Date[] dateArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = dateArr == null ? 0 : dateArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(dateArr[i]);
        }
    }

    protected void arraySetterHelper(QName[] qNameArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = qNameArr == null ? 0 : qNameArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(qNameArr[i]);
        }
    }

    protected void arraySetterHelper(StringEnumAbstractBase[] stringEnumAbstractBaseArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = stringEnumAbstractBaseArr == null ? 0 : stringEnumAbstractBaseArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(stringEnumAbstractBaseArr[i]);
        }
    }

    protected void arraySetterHelper(List[] listArr, QName qName) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = listArr == null ? 0 : listArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qName);
        while (iCount_elements > length) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(listArr[i]);
        }
    }

    protected void unionArraySetterHelper(Object[] objArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = objArr == null ? 0 : objArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).objectSet(objArr[i]);
        }
    }

    protected void arraySetterHelper(boolean[] zArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = zArr == null ? 0 : zArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(zArr[i]);
        }
    }

    protected void arraySetterHelper(float[] fArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = fArr == null ? 0 : fArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(fArr[i]);
        }
    }

    protected void arraySetterHelper(double[] dArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = dArr == null ? 0 : dArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(dArr[i]);
        }
    }

    protected void arraySetterHelper(byte[] bArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = bArr == null ? 0 : bArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(bArr[i]);
        }
    }

    protected void arraySetterHelper(short[] sArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = sArr == null ? 0 : sArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(sArr[i]);
        }
    }

    protected void arraySetterHelper(int[] iArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = iArr == null ? 0 : iArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(iArr[i]);
        }
    }

    protected void arraySetterHelper(long[] jArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = jArr == null ? 0 : jArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(jArr[i]);
        }
    }

    protected void arraySetterHelper(BigDecimal[] bigDecimalArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = bigDecimalArr == null ? 0 : bigDecimalArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(bigDecimalArr[i]);
        }
    }

    protected void arraySetterHelper(BigInteger[] bigIntegerArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = bigIntegerArr == null ? 0 : bigIntegerArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(bigIntegerArr[i]);
        }
    }

    protected void arraySetterHelper(String[] strArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = strArr == null ? 0 : strArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(strArr[i]);
        }
    }

    protected void arraySetterHelper(byte[][] bArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = bArr == null ? 0 : bArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(bArr[i]);
        }
    }

    protected void arraySetterHelper(GDate[] gDateArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = gDateArr == null ? 0 : gDateArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set((GDateSpecification) gDateArr[i]);
        }
    }

    protected void arraySetterHelper(GDuration[] gDurationArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = gDurationArr == null ? 0 : gDurationArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set((GDurationSpecification) gDurationArr[i]);
        }
    }

    protected void arraySetterHelper(Calendar[] calendarArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = calendarArr == null ? 0 : calendarArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(calendarArr[i]);
        }
    }

    protected void arraySetterHelper(Date[] dateArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = dateArr == null ? 0 : dateArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(dateArr[i]);
        }
    }

    protected void arraySetterHelper(QName[] qNameArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = qNameArr == null ? 0 : qNameArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(qNameArr[i]);
        }
    }

    protected void arraySetterHelper(StringEnumAbstractBase[] stringEnumAbstractBaseArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = stringEnumAbstractBaseArr == null ? 0 : stringEnumAbstractBaseArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(stringEnumAbstractBaseArr[i]);
        }
    }

    protected void arraySetterHelper(List[] listArr, QName qName, QNameSet qNameSet) {
        TypeStoreUser typeStoreUserFind_element_user;
        int length = listArr == null ? 0 : listArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        for (int i = 0; i < length; i++) {
            if (i >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(listArr[i]);
        }
    }

    protected void arraySetterHelper(XmlObject[] xmlObjectArr, QName qName) throws Throwable {
        int i;
        int iCount_elements;
        int i2;
        TypeStoreUser typeStoreUserFind_element_user;
        TypeStore typeStore = get_store();
        int i3 = 0;
        if (xmlObjectArr == null || xmlObjectArr.length == 0) {
            for (int iCount_elements2 = typeStore.count_elements(qName); iCount_elements2 > 0; iCount_elements2--) {
                typeStore.remove_element(qName, 0);
            }
            return;
        }
        int iCount_elements3 = typeStore.count_elements(qName);
        int i4 = 0;
        while (i4 < xmlObjectArr.length) {
            if (!xmlObjectArr[i4].isImmutable()) {
                XmlCursor xmlCursorNewCursor = xmlObjectArr[i4].newCursor();
                if (xmlCursorNewCursor.toParent() && xmlCursorNewCursor.getObject() == this) {
                    xmlCursorNewCursor.dispose();
                    break;
                }
                xmlCursorNewCursor.dispose();
            }
            i4++;
        }
        if (i4 >= xmlObjectArr.length || typeStore.find_element_user(qName, 0) != xmlObjectArr[i4]) {
            i = i4;
            iCount_elements = iCount_elements3;
            i2 = 0;
        } else {
            while (i3 < i4) {
                ((XmlObjectBase) typeStore.insert_element_user(qName, i3)).set(xmlObjectArr[i3]);
                i3++;
            }
            i2 = i3 + 1;
            i3 = i4 + 1;
            while (i3 < xmlObjectArr.length) {
                XmlCursor xmlCursorNewCursor2 = xmlObjectArr[i3].isImmutable() ? null : xmlObjectArr[i3].newCursor();
                if (xmlCursorNewCursor2 != null && xmlCursorNewCursor2.toParent() && xmlCursorNewCursor2.getObject() == this) {
                    xmlCursorNewCursor2.dispose();
                    if (typeStore.find_element_user(qName, i2) != xmlObjectArr[i3]) {
                        break;
                    }
                } else {
                    xmlCursorNewCursor2.dispose();
                    ((XmlObjectBase) typeStore.insert_element_user(qName, i2)).set(xmlObjectArr[i3]);
                }
                i3++;
                i2++;
            }
            iCount_elements = typeStore.count_elements(qName);
            i = i3;
        }
        for (int i5 = i; i5 < xmlObjectArr.length; i5++) {
            ((XmlObjectBase) typeStore.add_element_user(qName)).set(xmlObjectArr[i5]);
        }
        while (iCount_elements > (i - i3) + i2) {
            typeStore.remove_element(qName, iCount_elements - 1);
            iCount_elements--;
        }
        while (i3 < i) {
            if (i2 >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qName, i2);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(xmlObjectArr[i3]);
            i3++;
            i2++;
        }
    }

    protected void arraySetterHelper(XmlObject[] xmlObjectArr, QName qName, QNameSet qNameSet) throws Throwable {
        int i;
        int iCount_elements;
        int i2;
        TypeStoreUser typeStoreUserFind_element_user;
        TypeStore typeStore = get_store();
        int i3 = 0;
        if (xmlObjectArr == null || xmlObjectArr.length == 0) {
            for (int iCount_elements2 = typeStore.count_elements(qNameSet); iCount_elements2 > 0; iCount_elements2--) {
                typeStore.remove_element(qNameSet, 0);
            }
            return;
        }
        int iCount_elements3 = typeStore.count_elements(qNameSet);
        int i4 = 0;
        while (i4 < xmlObjectArr.length) {
            if (!xmlObjectArr[i4].isImmutable()) {
                XmlCursor xmlCursorNewCursor = xmlObjectArr[i4].newCursor();
                if (xmlCursorNewCursor.toParent() && xmlCursorNewCursor.getObject() == this) {
                    xmlCursorNewCursor.dispose();
                    break;
                }
                xmlCursorNewCursor.dispose();
            }
            i4++;
        }
        if (i4 >= xmlObjectArr.length || typeStore.find_element_user(qNameSet, 0) != xmlObjectArr[i4]) {
            i = i4;
            iCount_elements = iCount_elements3;
            i2 = 0;
        } else {
            while (i3 < i4) {
                ((XmlObjectBase) typeStore.insert_element_user(qNameSet, qName, i3)).set(xmlObjectArr[i3]);
                i3++;
            }
            i2 = i3 + 1;
            i3 = i4 + 1;
            while (i3 < xmlObjectArr.length) {
                XmlCursor xmlCursorNewCursor2 = xmlObjectArr[i3].isImmutable() ? null : xmlObjectArr[i3].newCursor();
                if (xmlCursorNewCursor2 != null && xmlCursorNewCursor2.toParent() && xmlCursorNewCursor2.getObject() == this) {
                    xmlCursorNewCursor2.dispose();
                    if (typeStore.find_element_user(qNameSet, i2) != xmlObjectArr[i3]) {
                        break;
                    }
                } else {
                    xmlCursorNewCursor2.dispose();
                    ((XmlObjectBase) typeStore.insert_element_user(qNameSet, qName, i2)).set(xmlObjectArr[i3]);
                }
                i3++;
                i2++;
            }
            iCount_elements = typeStore.count_elements(qName);
            i = i3;
        }
        for (int i5 = i; i5 < xmlObjectArr.length; i5++) {
            ((XmlObjectBase) typeStore.add_element_user(qName)).set(xmlObjectArr[i5]);
        }
        while (iCount_elements > (i - i3) + i2) {
            typeStore.remove_element(qNameSet, iCount_elements - 1);
            iCount_elements--;
        }
        while (i3 < i) {
            if (i2 >= iCount_elements) {
                typeStoreUserFind_element_user = typeStore.add_element_user(qName);
            } else {
                typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i2);
            }
            ((XmlObjectBase) typeStoreUserFind_element_user).set(xmlObjectArr[i3]);
            i3++;
            i2++;
        }
    }
}
