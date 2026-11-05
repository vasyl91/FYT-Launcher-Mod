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
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XmlUnionImpl extends XmlObjectBase implements XmlAnySimpleType {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int JAVA_BYTEARRAY = 50;
    private static final int JAVA_CALENDAR = 49;
    private static final int JAVA_DATE = 48;
    private static final int JAVA_LIST = 51;
    private static final int JAVA_NUMBER = 47;
    private SchemaType _schemaType;
    private String _textvalue = "";
    private XmlAnySimpleType _value;

    static boolean lexical_overlap(int i, int i2) {
        if (i != i2 && i != 2 && i2 != 2 && i != 12 && i2 != 12 && i != 6 && i2 != 6) {
            if (i != 3) {
                if (i == 4) {
                    if (i2 != 3 && i2 != 5 && i2 != 13 && i2 != 18) {
                        switch (i2) {
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                                break;
                            default:
                                return $assertionsDisabled;
                        }
                    }
                    return true;
                }
                if (i == 5) {
                    if (i2 != 3 && i2 != 4 && i2 != 18) {
                        switch (i2) {
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                                break;
                            default:
                                return $assertionsDisabled;
                        }
                    }
                    return true;
                }
                if (i == 13) {
                    if (i2 == 4 || i2 == 7 || i2 == 8) {
                        return true;
                    }
                    return $assertionsDisabled;
                }
                if (i != 18) {
                    switch (i) {
                        case 7:
                        case 8:
                            if (i2 == 3 || i2 == 4 || i2 == 5 || i2 == 7 || i2 == 8 || i2 == 13) {
                                return true;
                            }
                            return $assertionsDisabled;
                        case 9:
                        case 10:
                        case 11:
                            break;
                        default:
                            return $assertionsDisabled;
                    }
                }
                if (i2 != 4 && i2 != 5 && i2 != 18) {
                    switch (i2) {
                        case 9:
                        case 10:
                        case 11:
                            break;
                        default:
                            return $assertionsDisabled;
                    }
                }
                return true;
            }
            if (i2 != 7 && i2 != 8) {
                return $assertionsDisabled;
            }
        }
        return true;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int get_wscanon_rule() {
        return 1;
    }

    public XmlUnionImpl(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, $assertionsDisabled);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType instanceType() {
        check_dated();
        SimpleValue simpleValue = this._value;
        if (simpleValue == null) {
            return null;
        }
        return simpleValue.instanceType();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected String compute_text(NamespaceManager namespaceManager) {
        return this._textvalue;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean is_defaultable_ws(String str) {
        try {
            XmlAnySimpleType xmlAnySimpleType = this._value;
            set_text(str);
            this._value = xmlAnySimpleType;
            return $assertionsDisabled;
        } catch (XmlValueOutOfRangeException unused) {
            return true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006a  */
    /* JADX WARN: Code duplicated, block: B:26:0x006b A[Catch: all -> 0x0054, Exception -> 0x0073, XmlValueOutOfRangeException -> 0x008d, TRY_LEAVE, TryCatch #3 {XmlValueOutOfRangeException -> 0x008d, Exception -> 0x0073, blocks: (B:23:0x005a, B:26:0x006b), top: B:45:0x005a, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x006f  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ad A[LOOP:0: B:14:0x004b->B:39:0x00ad, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:45:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0092 A[EDGE_INSN: B:47:0x0092->B:35:0x0092 BREAK  A[LOOP:0: B:14:0x004b->B:39:0x00ad], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:? A[RETURN, SYNTHETIC] */
    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        boolean z;
        int i;
        XmlAnySimpleType xmlAnySimpleTypeNewValue;
        if (!this._schemaType.matchPatternFacet(str) && _validateOnSet()) {
            throw new XmlValueOutOfRangeException("cvc-datatype-valid.1.1", new Object[]{"string", str, QNameHelper.readable(this._schemaType)});
        }
        String str2 = this._textvalue;
        this._textvalue = str;
        SchemaType[] unionConstituentTypes = this._schemaType.getUnionConstituentTypes();
        if (has_store()) {
            NamespaceContext.push(new NamespaceContext(get_store()));
            z = true;
        } else {
            z = false;
        }
        boolean z2 = true;
        while (true) {
            if (!z2) {
                try {
                    if (_validateOnSet()) {
                        break;
                    }
                    for (SchemaType schemaType : unionConstituentTypes) {
                        try {
                            xmlAnySimpleTypeNewValue = ((SchemaTypeImpl) schemaType).newValue(str, z2);
                            if (!check(xmlAnySimpleTypeNewValue, this._schemaType)) {
                                this._value = xmlAnySimpleTypeNewValue;
                                if (z) {
                                    NamespaceContext.pop();
                                    return;
                                }
                                return;
                            }
                        } catch (XmlValueOutOfRangeException unused) {
                        } catch (Exception e) {
                            throw new RuntimeException("Troublesome union exception caused by unexpected " + e, e);
                        }
                    }
                    if (!z2) {
                        break;
                    } else {
                        z2 = false;
                    }
                } catch (Throwable th) {
                    if (z) {
                        NamespaceContext.pop();
                    }
                    throw th;
                }
            } else {
                while (i < unionConstituentTypes.length) {
                    xmlAnySimpleTypeNewValue = ((SchemaTypeImpl) schemaType).newValue(str, z2);
                    if (!check(xmlAnySimpleTypeNewValue, this._schemaType)) {
                        this._value = xmlAnySimpleTypeNewValue;
                        if (z) {
                            NamespaceContext.pop();
                            return;
                        }
                        return;
                    }
                }
                if (!z2) {
                    break;
                    break;
                }
                z2 = false;
            }
        }
        if (z) {
            NamespaceContext.pop();
        }
        this._textvalue = str2;
        throw new XmlValueOutOfRangeException("cvc-datatype-valid.1.2.3", new Object[]{str, QNameHelper.readable(this._schemaType)});
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._value = null;
        this._textvalue = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public float getFloatValue() {
        check_dated();
        SimpleValue simpleValue = this._value;
        if (simpleValue == null) {
            return 0.0f;
        }
        return simpleValue.getFloatValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public double getDoubleValue() {
        check_dated();
        SimpleValue simpleValue = this._value;
        if (simpleValue == null) {
            return 0.0d;
        }
        return simpleValue.getDoubleValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public BigDecimal getBigDecimalValue() {
        check_dated();
        SimpleValue simpleValue = this._value;
        if (simpleValue == null) {
            return null;
        }
        return simpleValue.getBigDecimalValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public BigInteger getBigIntegerValue() {
        check_dated();
        SimpleValue simpleValue = this._value;
        if (simpleValue == null) {
            return null;
        }
        return simpleValue.getBigIntegerValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public byte getByteValue() {
        check_dated();
        SimpleValue simpleValue = this._value;
        if (simpleValue == null) {
            return (byte) 0;
        }
        return simpleValue.getByteValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public short getShortValue() {
        check_dated();
        SimpleValue simpleValue = this._value;
        if (simpleValue == null) {
            return (short) 0;
        }
        return simpleValue.getShortValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int getIntValue() {
        check_dated();
        SimpleValue simpleValue = this._value;
        if (simpleValue == null) {
            return 0;
        }
        return simpleValue.getIntValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public long getLongValue() {
        check_dated();
        SimpleValue simpleValue = this._value;
        if (simpleValue == null) {
            return 0L;
        }
        return simpleValue.getLongValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public byte[] getByteArrayValue() {
        check_dated();
        SimpleValue simpleValue = this._value;
        if (simpleValue == null) {
            return null;
        }
        return simpleValue.getByteArrayValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean getBooleanValue() {
        check_dated();
        SimpleValue simpleValue = this._value;
        return simpleValue == null ? $assertionsDisabled : simpleValue.getBooleanValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public Calendar getCalendarValue() {
        check_dated();
        SimpleValue simpleValue = this._value;
        if (simpleValue == null) {
            return null;
        }
        return simpleValue.getCalendarValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public Date getDateValue() {
        check_dated();
        SimpleValue simpleValue = this._value;
        if (simpleValue == null) {
            return null;
        }
        return simpleValue.getDateValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public GDate getGDateValue() {
        check_dated();
        SimpleValue simpleValue = this._value;
        if (simpleValue == null) {
            return null;
        }
        return simpleValue.getGDateValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public GDuration getGDurationValue() {
        check_dated();
        SimpleValue simpleValue = this._value;
        if (simpleValue == null) {
            return null;
        }
        return simpleValue.getGDurationValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public QName getQNameValue() {
        check_dated();
        SimpleValue simpleValue = this._value;
        if (simpleValue == null) {
            return null;
        }
        return simpleValue.getQNameValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public List getListValue() {
        check_dated();
        SimpleValue simpleValue = this._value;
        if (simpleValue == null) {
            return null;
        }
        return simpleValue.getListValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public List xgetListValue() {
        check_dated();
        SimpleValue simpleValue = this._value;
        if (simpleValue == null) {
            return null;
        }
        return simpleValue.xgetListValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public StringEnumAbstractBase getEnumValue() {
        check_dated();
        SimpleValue simpleValue = this._value;
        if (simpleValue == null) {
            return null;
        }
        return simpleValue.getEnumValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String getStringValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return xmlAnySimpleType.getStringValue();
    }

    private static boolean logical_overlap(SchemaType schemaType, int i) {
        if (i <= 46) {
            if (schemaType.getSimpleVariety() == 1 && schemaType.getPrimitiveType().getBuiltinTypeCode() == i) {
                return true;
            }
            return $assertionsDisabled;
        }
        switch (i) {
            case 47:
                if (schemaType.getSimpleVariety() != 1) {
                    return $assertionsDisabled;
                }
                int builtinTypeCode = schemaType.getPrimitiveType().getBuiltinTypeCode();
                if (builtinTypeCode != 18 && builtinTypeCode != 20 && builtinTypeCode != 21) {
                    switch (builtinTypeCode) {
                        case 9:
                        case 10:
                        case 11:
                            break;
                        default:
                            return $assertionsDisabled;
                    }
                }
                return true;
            case 48:
                if (schemaType.getSimpleVariety() != 1) {
                    return $assertionsDisabled;
                }
                int builtinTypeCode2 = schemaType.getPrimitiveType().getBuiltinTypeCode();
                if (builtinTypeCode2 == 14 || builtinTypeCode2 == 16) {
                    return true;
                }
                return $assertionsDisabled;
            case 49:
                if (schemaType.getSimpleVariety() != 1) {
                    return $assertionsDisabled;
                }
                switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        return true;
                    default:
                        return $assertionsDisabled;
                }
            case 50:
                if (schemaType.getSimpleVariety() != 1) {
                    return $assertionsDisabled;
                }
                int builtinTypeCode3 = schemaType.getPrimitiveType().getBuiltinTypeCode();
                if (builtinTypeCode3 == 4 || builtinTypeCode3 == 5) {
                    return true;
                }
                return $assertionsDisabled;
            case 51:
                if (schemaType.getSimpleVariety() == 3) {
                    return true;
                }
                return $assertionsDisabled;
            default:
                return $assertionsDisabled;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002d A[Catch: all -> 0x0027, TRY_LEAVE, TryCatch #1 {all -> 0x0027, blocks: (B:8:0x0020, B:14:0x002a, B:16:0x002d, B:18:0x0035, B:19:0x003d), top: B:36:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0047  */
    /* JADX WARN: Code duplicated, block: B:29:0x006e A[LOOP:0: B:7:0x001e->B:29:0x006e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0050 A[EDGE_INSN: B:40:0x0050->B:25:0x0050 BREAK  A[LOOP:0: B:7:0x001e->B:29:0x006e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x004b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    private void set_primitive(int i, Object obj) {
        boolean z;
        int i2;
        SchemaType[] unionConstituentTypes = this._schemaType.getUnionConstituentTypes();
        if (has_store()) {
            NamespaceContext.push(new NamespaceContext(get_store()));
            z = true;
        } else {
            z = false;
        }
        boolean z2 = true;
        while (true) {
            if (!z2) {
                try {
                    if (_validateOnSet()) {
                        break;
                    }
                    for (i2 = 0; i2 < unionConstituentTypes.length; i2++) {
                        if (logical_overlap(unionConstituentTypes[i2], i)) {
                            try {
                                XmlAnySimpleType xmlAnySimpleTypeNewValue = ((SchemaTypeImpl) unionConstituentTypes[i2]).newValue(obj, z2);
                                this._value = xmlAnySimpleTypeNewValue;
                                this._textvalue = xmlAnySimpleTypeNewValue.stringValue();
                                if (z) {
                                    NamespaceContext.pop();
                                    return;
                                }
                                return;
                            } catch (XmlValueOutOfRangeException | Exception unused) {
                                continue;
                            }
                        }
                    }
                    if (!z2) {
                        break;
                    } else {
                        z2 = false;
                    }
                } catch (Throwable th) {
                    if (z) {
                        NamespaceContext.pop();
                    }
                    throw th;
                }
            } else {
                while (i2 < unionConstituentTypes.length) {
                    if (logical_overlap(unionConstituentTypes[i2], i)) {
                        XmlAnySimpleType xmlAnySimpleTypeNewValue2 = ((SchemaTypeImpl) unionConstituentTypes[i2]).newValue(obj, z2);
                        this._value = xmlAnySimpleTypeNewValue2;
                        this._textvalue = xmlAnySimpleTypeNewValue2.stringValue();
                        if (z) {
                            NamespaceContext.pop();
                            return;
                        }
                        return;
                    }
                }
                if (!z2) {
                    break;
                    break;
                }
                z2 = false;
            }
        }
        if (z) {
            NamespaceContext.pop();
        }
        throw new XmlValueOutOfRangeException("cvc-datatype-valid.1.2.3", new Object[]{obj.toString(), QNameHelper.readable(this._schemaType)});
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_boolean(boolean z) {
        set_primitive(3, new Boolean(z));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_byte(byte b) {
        set_primitive(47, new Byte(b));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_short(short s) {
        set_primitive(47, new Short(s));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_int(int i) {
        set_primitive(47, new Integer(i));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_long(long j) {
        set_primitive(47, new Long(j));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_float(float f) {
        set_primitive(47, new Float(f));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_double(double d) {
        set_primitive(47, new Double(d));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_ByteArray(byte[] bArr) {
        set_primitive(50, bArr);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_hex(byte[] bArr) {
        set_primitive(50, bArr);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_b64(byte[] bArr) {
        set_primitive(50, bArr);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_BigInteger(BigInteger bigInteger) {
        set_primitive(47, bigInteger);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_BigDecimal(BigDecimal bigDecimal) {
        set_primitive(47, bigDecimal);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_QName(QName qName) {
        set_primitive(7, qName);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_Calendar(Calendar calendar) {
        set_primitive(49, calendar);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_Date(Date date) {
        set_primitive(48, date);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_GDate(GDateSpecification gDateSpecification) {
        int builtinTypeCode = gDateSpecification.getBuiltinTypeCode();
        if (builtinTypeCode <= 0) {
            throw new XmlValueOutOfRangeException();
        }
        set_primitive(builtinTypeCode, gDateSpecification);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_GDuration(GDurationSpecification gDurationSpecification) {
        set_primitive(13, gDurationSpecification);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_enum(StringEnumAbstractBase stringEnumAbstractBase) {
        set_primitive(12, stringEnumAbstractBase);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_list(List list) {
        set_primitive(51, list);
    }

    protected void set_xmlfloat(XmlObject xmlObject) {
        set_primitive(9, xmlObject);
    }

    protected void set_xmldouble(XmlObject xmlObject) {
        set_primitive(10, xmlObject);
    }

    protected void set_xmldecimal(XmlObject xmlObject) {
        set_primitive(11, xmlObject);
    }

    protected void set_xmlduration(XmlObject xmlObject) {
        set_primitive(13, xmlObject);
    }

    protected void set_xmldatetime(XmlObject xmlObject) {
        set_primitive(14, xmlObject);
    }

    protected void set_xmltime(XmlObject xmlObject) {
        set_primitive(15, xmlObject);
    }

    protected void set_xmldate(XmlObject xmlObject) {
        set_primitive(16, xmlObject);
    }

    protected void set_xmlgyearmonth(XmlObject xmlObject) {
        set_primitive(17, xmlObject);
    }

    protected void set_xmlgyear(XmlObject xmlObject) {
        set_primitive(18, xmlObject);
    }

    protected void set_xmlgmonthday(XmlObject xmlObject) {
        set_primitive(19, xmlObject);
    }

    protected void set_xmlgday(XmlObject xmlObject) {
        set_primitive(20, xmlObject);
    }

    protected void set_xmlgmonth(XmlObject xmlObject) {
        set_primitive(21, xmlObject);
    }

    private static boolean check(XmlObject xmlObject, SchemaType schemaType) {
        XmlObject[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues == null) {
            return true;
        }
        for (XmlObject xmlObject2 : enumerationValues) {
            if (xmlObject2.valueEquals(xmlObject)) {
                return true;
            }
        }
        return $assertionsDisabled;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        return this._value.valueEquals(xmlObject);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        return this._value.hashCode();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        try {
            check_dated();
            XmlObjectBase xmlObjectBase = this._value;
            if (xmlObjectBase == null) {
                validationContext.invalid("union", new Object[]{"'" + str + "' does not match any of the member types for " + QNameHelper.readable(schemaType())});
            } else {
                xmlObjectBase.validate_simpleval(str, validationContext);
            }
        } catch (Exception unused) {
            validationContext.invalid("union", new Object[]{"'" + str + "' does not match any of the member types for " + QNameHelper.readable(schemaType())});
        }
    }
}
