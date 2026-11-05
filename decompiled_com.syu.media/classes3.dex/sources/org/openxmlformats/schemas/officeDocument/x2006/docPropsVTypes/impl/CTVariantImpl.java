package org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlShort;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.XmlUnsignedLong;
import org.apache.xmlbeans.XmlUnsignedShort;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTArray;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTCf;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTEmpty;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTNull;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVstream;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STClsid;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STCy;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STError;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTVariantImpl extends XmlComplexContentImpl implements CTVariant {
    private static final QName VARIANT$0 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "variant");
    private static final QName VECTOR$2 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "vector");
    private static final QName ARRAY$4 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "array");
    private static final QName BLOB$6 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "blob");
    private static final QName OBLOB$8 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "oblob");
    private static final QName EMPTY$10 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "empty");
    private static final QName NULL$12 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "null");
    private static final QName I1$14 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i1");
    private static final QName I2$16 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i2");
    private static final QName I4$18 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i4");
    private static final QName I8$20 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i8");
    private static final QName INT$22 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "int");
    private static final QName UI1$24 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui1");
    private static final QName UI2$26 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui2");
    private static final QName UI4$28 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui4");
    private static final QName UI8$30 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui8");
    private static final QName UINT$32 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "uint");
    private static final QName R4$34 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "r4");
    private static final QName R8$36 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "r8");
    private static final QName DECIMAL$38 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "decimal");
    private static final QName LPSTR$40 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "lpstr");
    private static final QName LPWSTR$42 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "lpwstr");
    private static final QName BSTR$44 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "bstr");
    private static final QName DATE$46 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "date");
    private static final QName FILETIME$48 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "filetime");
    private static final QName BOOL$50 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "bool");
    private static final QName CY$52 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "cy");
    private static final QName ERROR$54 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "error");
    private static final QName STREAM$56 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "stream");
    private static final QName OSTREAM$58 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ostream");
    private static final QName STORAGE$60 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "storage");
    private static final QName OSTORAGE$62 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ostorage");
    private static final QName VSTREAM$64 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "vstream");
    private static final QName CLSID$66 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "clsid");
    private static final QName CF$68 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "cf");

    public CTVariantImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public CTArray addNewArray() {
        CTArray cTArrayAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTArrayAdd_element_user = get_store().add_element_user(ARRAY$4);
        }
        return cTArrayAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public CTCf addNewCf() {
        CTCf cTCfAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCfAdd_element_user = get_store().add_element_user(CF$68);
        }
        return cTCfAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public CTEmpty addNewEmpty() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(EMPTY$10);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public CTNull addNewNull() {
        CTNull cTNullAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNullAdd_element_user = get_store().add_element_user(NULL$12);
        }
        return cTNullAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public CTVariant addNewVariant() {
        CTVariant cTVariant;
        synchronized (monitor()) {
            check_orphaned();
            cTVariant = (CTVariant) get_store().add_element_user(VARIANT$0);
        }
        return cTVariant;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public CTVector addNewVector() {
        CTVector cTVector;
        synchronized (monitor()) {
            check_orphaned();
            cTVector = (CTVector) get_store().add_element_user(VECTOR$2);
        }
        return cTVector;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public CTVstream addNewVstream() {
        CTVstream cTVstreamAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTVstreamAdd_element_user = get_store().add_element_user(VSTREAM$64);
        }
        return cTVstreamAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public CTArray getArray() {
        synchronized (monitor()) {
            check_orphaned();
            CTArray cTArrayFind_element_user = get_store().find_element_user(ARRAY$4, 0);
            if (cTArrayFind_element_user == null) {
                return null;
            }
            return cTArrayFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public byte[] getBlob() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(BLOB$6, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean getBool() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(BOOL$50, 0);
            if (simpleValueFind_element_user == null) {
                return false;
            }
            return simpleValueFind_element_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public String getBstr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(BSTR$44, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public CTCf getCf() {
        synchronized (monitor()) {
            check_orphaned();
            CTCf cTCfFind_element_user = get_store().find_element_user(CF$68, 0);
            if (cTCfFind_element_user == null) {
                return null;
            }
            return cTCfFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public String getClsid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(CLSID$66, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public String getCy() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(CY$52, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public Calendar getDate() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(DATE$46, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getCalendarValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public BigDecimal getDecimal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(DECIMAL$38, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getBigDecimalValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public CTEmpty getEmpty() {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(EMPTY$10, 0);
            if (cTEmptyFind_element_user == null) {
                return null;
            }
            return cTEmptyFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public String getError() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(ERROR$54, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public Calendar getFiletime() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(FILETIME$48, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getCalendarValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public byte getI1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(I1$14, 0);
            if (simpleValueFind_element_user == null) {
                return (byte) 0;
            }
            return simpleValueFind_element_user.getByteValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public short getI2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(I2$16, 0);
            if (simpleValueFind_element_user == null) {
                return (short) 0;
            }
            return simpleValueFind_element_user.getShortValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public int getI4() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(I4$18, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public long getI8() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(I8$20, 0);
            if (simpleValueFind_element_user == null) {
                return 0L;
            }
            return simpleValueFind_element_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public int getInt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(INT$22, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public String getLpstr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(LPSTR$40, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public String getLpwstr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(LPWSTR$42, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public CTNull getNull() {
        synchronized (monitor()) {
            check_orphaned();
            CTNull cTNullFind_element_user = get_store().find_element_user(NULL$12, 0);
            if (cTNullFind_element_user == null) {
                return null;
            }
            return cTNullFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public byte[] getOblob() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(OBLOB$8, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public byte[] getOstorage() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(OSTORAGE$62, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public byte[] getOstream() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(OSTREAM$58, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public float getR4() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(R4$34, 0);
            if (simpleValueFind_element_user == null) {
                return 0.0f;
            }
            return simpleValueFind_element_user.getFloatValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public double getR8() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(R8$36, 0);
            if (simpleValueFind_element_user == null) {
                return 0.0d;
            }
            return simpleValueFind_element_user.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public byte[] getStorage() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(STORAGE$60, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public byte[] getStream() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(STREAM$56, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public short getUi1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(UI1$24, 0);
            if (simpleValueFind_element_user == null) {
                return (short) 0;
            }
            return simpleValueFind_element_user.getShortValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public int getUi2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(UI2$26, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public long getUi4() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(UI4$28, 0);
            if (simpleValueFind_element_user == null) {
                return 0L;
            }
            return simpleValueFind_element_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public BigInteger getUi8() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(UI8$30, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public long getUint() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(UINT$32, 0);
            if (simpleValueFind_element_user == null) {
                return 0L;
            }
            return simpleValueFind_element_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public CTVariant getVariant() {
        synchronized (monitor()) {
            check_orphaned();
            CTVariant cTVariant = (CTVariant) get_store().find_element_user(VARIANT$0, 0);
            if (cTVariant == null) {
                return null;
            }
            return cTVariant;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public CTVector getVector() {
        synchronized (monitor()) {
            check_orphaned();
            CTVector cTVector = (CTVector) get_store().find_element_user(VECTOR$2, 0);
            if (cTVector == null) {
                return null;
            }
            return cTVector;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public CTVstream getVstream() {
        synchronized (monitor()) {
            check_orphaned();
            CTVstream cTVstreamFind_element_user = get_store().find_element_user(VSTREAM$64, 0);
            if (cTVstreamFind_element_user == null) {
                return null;
            }
            return cTVstreamFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetArray() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ARRAY$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetBlob() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BLOB$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetBool() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BOOL$50) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetBstr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BSTR$44) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetCf() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CF$68) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetClsid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CLSID$66) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetCy() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CY$52) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetDate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DATE$46) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetDecimal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DECIMAL$38) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetEmpty() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EMPTY$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetError() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ERROR$54) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetFiletime() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FILETIME$48) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetI1() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(I1$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetI2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(I2$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetI4() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(I4$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetI8() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(I8$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetInt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(INT$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetLpstr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LPSTR$40) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetLpwstr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LPWSTR$42) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetNull() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NULL$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetOblob() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OBLOB$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetOstorage() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OSTORAGE$62) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetOstream() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OSTREAM$58) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetR4() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(R4$34) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetR8() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(R8$36) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetStorage() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STORAGE$60) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetStream() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STREAM$56) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetUi1() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UI1$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetUi2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UI2$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetUi4() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UI4$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetUi8() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UI8$30) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetUint() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UINT$32) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetVariant() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VARIANT$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetVector() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VECTOR$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public boolean isSetVstream() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VSTREAM$64) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setArray(CTArray cTArray) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ARRAY$4;
            CTArray cTArrayFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTArrayFind_element_user == null) {
                cTArrayFind_element_user = (CTArray) get_store().add_element_user(qName);
            }
            cTArrayFind_element_user.set(cTArray);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setBlob(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOB$6;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setBool(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOOL$50;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setBstr(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BSTR$44;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setCf(CTCf cTCf) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CF$68;
            CTCf cTCfFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCfFind_element_user == null) {
                cTCfFind_element_user = (CTCf) get_store().add_element_user(qName);
            }
            cTCfFind_element_user.set(cTCf);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setClsid(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLSID$66;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setCy(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CY$52;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setDate(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATE$46;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setDecimal(BigDecimal bigDecimal) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DECIMAL$38;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setBigDecimalValue(bigDecimal);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setEmpty(CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EMPTY$10;
            CTEmpty cTEmptyFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTEmptyFind_element_user == null) {
                cTEmptyFind_element_user = (CTEmpty) get_store().add_element_user(qName);
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setError(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ERROR$54;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setFiletime(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILETIME$48;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setI1(byte b) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I1$14;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setByteValue(b);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setI2(short s) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I2$16;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setI4(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I4$18;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setI8(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I8$20;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setInt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INT$22;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setLpstr(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LPSTR$40;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setLpwstr(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LPWSTR$42;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setNull(CTNull cTNull) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NULL$12;
            CTNull cTNullFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTNullFind_element_user == null) {
                cTNullFind_element_user = (CTNull) get_store().add_element_user(qName);
            }
            cTNullFind_element_user.set(cTNull);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setOblob(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OBLOB$8;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setOstorage(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OSTORAGE$62;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setOstream(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OSTREAM$58;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setR4(float f) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R4$34;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setFloatValue(f);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setR8(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R8$36;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setStorage(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STORAGE$60;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setStream(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STREAM$56;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setUi1(short s) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI1$24;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setUi2(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI2$26;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setUi4(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI4$28;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setUi8(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI8$30;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setUint(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UINT$32;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setVariant(CTVariant cTVariant) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VARIANT$0;
            CTVariant cTVariant2 = (CTVariant) typeStore.find_element_user(qName, 0);
            if (cTVariant2 == null) {
                cTVariant2 = (CTVariant) get_store().add_element_user(qName);
            }
            cTVariant2.set(cTVariant);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setVector(CTVector cTVector) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VECTOR$2;
            CTVector cTVector2 = (CTVector) typeStore.find_element_user(qName, 0);
            if (cTVector2 == null) {
                cTVector2 = (CTVector) get_store().add_element_user(qName);
            }
            cTVector2.set(cTVector);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void setVstream(CTVstream cTVstream) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VSTREAM$64;
            CTVstream cTVstreamFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTVstreamFind_element_user == null) {
                cTVstreamFind_element_user = (CTVstream) get_store().add_element_user(qName);
            }
            cTVstreamFind_element_user.set(cTVstream);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetArray() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ARRAY$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetBlob() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BLOB$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetBool() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOL$50, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetBstr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BSTR$44, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetCf() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CF$68, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetClsid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLSID$66, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetCy() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CY$52, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DATE$46, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetDecimal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DECIMAL$38, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetEmpty() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EMPTY$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetError() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ERROR$54, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetFiletime() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILETIME$48, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetI1() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I1$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetI2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I2$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetI4() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I4$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetI8() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I8$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetInt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INT$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetLpstr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LPSTR$40, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetLpwstr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LPWSTR$42, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetNull() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NULL$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetOblob() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OBLOB$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetOstorage() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OSTORAGE$62, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetOstream() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OSTREAM$58, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetR4() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R4$34, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetR8() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R8$36, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetStorage() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STORAGE$60, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetStream() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STREAM$56, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetUi1() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UI1$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetUi2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UI2$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetUi4() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UI4$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetUi8() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UI8$30, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetUint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UINT$32, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetVariant() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VARIANT$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetVector() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VECTOR$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void unsetVstream() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VSTREAM$64, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlBase64Binary xgetBlob() {
        XmlBase64Binary xmlBase64BinaryFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_element_user = get_store().find_element_user(BLOB$6, 0);
        }
        return xmlBase64BinaryFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlBoolean xgetBool() {
        XmlBoolean xmlBooleanFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_element_user = get_store().find_element_user(BOOL$50, 0);
        }
        return xmlBooleanFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlString xgetBstr() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(BSTR$44, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public STClsid xgetClsid() {
        STClsid sTClsid;
        synchronized (monitor()) {
            check_orphaned();
            sTClsid = (STClsid) get_store().find_element_user(CLSID$66, 0);
        }
        return sTClsid;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public STCy xgetCy() {
        STCy sTCyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTCyFind_element_user = get_store().find_element_user(CY$52, 0);
        }
        return sTCyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlDateTime xgetDate() {
        XmlDateTime xmlDateTimeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTimeFind_element_user = get_store().find_element_user(DATE$46, 0);
        }
        return xmlDateTimeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlDecimal xgetDecimal() {
        XmlDecimal xmlDecimalFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDecimalFind_element_user = get_store().find_element_user(DECIMAL$38, 0);
        }
        return xmlDecimalFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public STError xgetError() {
        STError sTErrorFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTErrorFind_element_user = get_store().find_element_user(ERROR$54, 0);
        }
        return sTErrorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlDateTime xgetFiletime() {
        XmlDateTime xmlDateTimeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTimeFind_element_user = get_store().find_element_user(FILETIME$48, 0);
        }
        return xmlDateTimeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlByte xgetI1() {
        XmlByte xmlByteFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlByteFind_element_user = get_store().find_element_user(I1$14, 0);
        }
        return xmlByteFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlShort xgetI2() {
        XmlShort xmlShortFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlShortFind_element_user = get_store().find_element_user(I2$16, 0);
        }
        return xmlShortFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlInt xgetI4() {
        XmlInt xmlIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_element_user = get_store().find_element_user(I4$18, 0);
        }
        return xmlIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlLong xgetI8() {
        XmlLong xmlLongFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlLongFind_element_user = get_store().find_element_user(I8$20, 0);
        }
        return xmlLongFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlInt xgetInt() {
        XmlInt xmlIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_element_user = get_store().find_element_user(INT$22, 0);
        }
        return xmlIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlString xgetLpstr() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(LPSTR$40, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlString xgetLpwstr() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(LPWSTR$42, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlBase64Binary xgetOblob() {
        XmlBase64Binary xmlBase64BinaryFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_element_user = get_store().find_element_user(OBLOB$8, 0);
        }
        return xmlBase64BinaryFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlBase64Binary xgetOstorage() {
        XmlBase64Binary xmlBase64BinaryFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_element_user = get_store().find_element_user(OSTORAGE$62, 0);
        }
        return xmlBase64BinaryFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlBase64Binary xgetOstream() {
        XmlBase64Binary xmlBase64BinaryFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_element_user = get_store().find_element_user(OSTREAM$58, 0);
        }
        return xmlBase64BinaryFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlFloat xgetR4() {
        XmlFloat xmlFloatFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloatFind_element_user = get_store().find_element_user(R4$34, 0);
        }
        return xmlFloatFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlDouble xgetR8() {
        XmlDouble xmlDoubleFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDoubleFind_element_user = get_store().find_element_user(R8$36, 0);
        }
        return xmlDoubleFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlBase64Binary xgetStorage() {
        XmlBase64Binary xmlBase64BinaryFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_element_user = get_store().find_element_user(STORAGE$60, 0);
        }
        return xmlBase64BinaryFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlBase64Binary xgetStream() {
        XmlBase64Binary xmlBase64BinaryFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_element_user = get_store().find_element_user(STREAM$56, 0);
        }
        return xmlBase64BinaryFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlUnsignedByte xgetUi1() {
        XmlUnsignedByte xmlUnsignedByteFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedByteFind_element_user = get_store().find_element_user(UI1$24, 0);
        }
        return xmlUnsignedByteFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlUnsignedShort xgetUi2() {
        XmlUnsignedShort xmlUnsignedShortFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedShortFind_element_user = get_store().find_element_user(UI2$26, 0);
        }
        return xmlUnsignedShortFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlUnsignedInt xgetUi4() {
        XmlUnsignedInt xmlUnsignedIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_element_user = get_store().find_element_user(UI4$28, 0);
        }
        return xmlUnsignedIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlUnsignedLong xgetUi8() {
        XmlUnsignedLong xmlUnsignedLongFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedLongFind_element_user = get_store().find_element_user(UI8$30, 0);
        }
        return xmlUnsignedLongFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public XmlUnsignedInt xgetUint() {
        XmlUnsignedInt xmlUnsignedIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_element_user = get_store().find_element_user(UINT$32, 0);
        }
        return xmlUnsignedIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetBlob(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOB$6;
            XmlBase64Binary xmlBase64BinaryFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBase64BinaryFind_element_user == null) {
                xmlBase64BinaryFind_element_user = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64BinaryFind_element_user.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetBool(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOOL$50;
            XmlBoolean xmlBooleanFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBooleanFind_element_user == null) {
                xmlBooleanFind_element_user = (XmlBoolean) get_store().add_element_user(qName);
            }
            xmlBooleanFind_element_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetBstr(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BSTR$44;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetClsid(STClsid sTClsid) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLSID$66;
            STClsid sTClsid2 = (STClsid) typeStore.find_element_user(qName, 0);
            if (sTClsid2 == null) {
                sTClsid2 = (STClsid) get_store().add_element_user(qName);
            }
            sTClsid2.set(sTClsid);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetCy(STCy sTCy) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CY$52;
            STCy sTCyFind_element_user = typeStore.find_element_user(qName, 0);
            if (sTCyFind_element_user == null) {
                sTCyFind_element_user = (STCy) get_store().add_element_user(qName);
            }
            sTCyFind_element_user.set(sTCy);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetDate(XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATE$46;
            XmlDateTime xmlDateTimeFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlDateTimeFind_element_user == null) {
                xmlDateTimeFind_element_user = (XmlDateTime) get_store().add_element_user(qName);
            }
            xmlDateTimeFind_element_user.set(xmlDateTime);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetDecimal(XmlDecimal xmlDecimal) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DECIMAL$38;
            XmlDecimal xmlDecimalFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlDecimalFind_element_user == null) {
                xmlDecimalFind_element_user = (XmlDecimal) get_store().add_element_user(qName);
            }
            xmlDecimalFind_element_user.set(xmlDecimal);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetError(STError sTError) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ERROR$54;
            STError sTErrorFind_element_user = typeStore.find_element_user(qName, 0);
            if (sTErrorFind_element_user == null) {
                sTErrorFind_element_user = (STError) get_store().add_element_user(qName);
            }
            sTErrorFind_element_user.set(sTError);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetFiletime(XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILETIME$48;
            XmlDateTime xmlDateTimeFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlDateTimeFind_element_user == null) {
                xmlDateTimeFind_element_user = (XmlDateTime) get_store().add_element_user(qName);
            }
            xmlDateTimeFind_element_user.set(xmlDateTime);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetI1(XmlByte xmlByte) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I1$14;
            XmlByte xmlByteFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlByteFind_element_user == null) {
                xmlByteFind_element_user = (XmlByte) get_store().add_element_user(qName);
            }
            xmlByteFind_element_user.set(xmlByte);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetI2(XmlShort xmlShort) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I2$16;
            XmlShort xmlShortFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlShortFind_element_user == null) {
                xmlShortFind_element_user = (XmlShort) get_store().add_element_user(qName);
            }
            xmlShortFind_element_user.set(xmlShort);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetI4(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I4$18;
            XmlInt xmlIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlIntFind_element_user == null) {
                xmlIntFind_element_user = (XmlInt) get_store().add_element_user(qName);
            }
            xmlIntFind_element_user.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetI8(XmlLong xmlLong) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I8$20;
            XmlLong xmlLongFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlLongFind_element_user == null) {
                xmlLongFind_element_user = (XmlLong) get_store().add_element_user(qName);
            }
            xmlLongFind_element_user.set(xmlLong);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetInt(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INT$22;
            XmlInt xmlIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlIntFind_element_user == null) {
                xmlIntFind_element_user = (XmlInt) get_store().add_element_user(qName);
            }
            xmlIntFind_element_user.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetLpstr(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LPSTR$40;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetLpwstr(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LPWSTR$42;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetOblob(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OBLOB$8;
            XmlBase64Binary xmlBase64BinaryFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBase64BinaryFind_element_user == null) {
                xmlBase64BinaryFind_element_user = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64BinaryFind_element_user.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetOstorage(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OSTORAGE$62;
            XmlBase64Binary xmlBase64BinaryFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBase64BinaryFind_element_user == null) {
                xmlBase64BinaryFind_element_user = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64BinaryFind_element_user.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetOstream(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OSTREAM$58;
            XmlBase64Binary xmlBase64BinaryFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBase64BinaryFind_element_user == null) {
                xmlBase64BinaryFind_element_user = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64BinaryFind_element_user.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetR4(XmlFloat xmlFloat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R4$34;
            XmlFloat xmlFloatFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlFloatFind_element_user == null) {
                xmlFloatFind_element_user = (XmlFloat) get_store().add_element_user(qName);
            }
            xmlFloatFind_element_user.set(xmlFloat);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetR8(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R8$36;
            XmlDouble xmlDoubleFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlDoubleFind_element_user == null) {
                xmlDoubleFind_element_user = (XmlDouble) get_store().add_element_user(qName);
            }
            xmlDoubleFind_element_user.set(xmlDouble);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetStorage(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STORAGE$60;
            XmlBase64Binary xmlBase64BinaryFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBase64BinaryFind_element_user == null) {
                xmlBase64BinaryFind_element_user = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64BinaryFind_element_user.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetStream(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STREAM$56;
            XmlBase64Binary xmlBase64BinaryFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBase64BinaryFind_element_user == null) {
                xmlBase64BinaryFind_element_user = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64BinaryFind_element_user.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetUi1(XmlUnsignedByte xmlUnsignedByte) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI1$24;
            XmlUnsignedByte xmlUnsignedByteFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlUnsignedByteFind_element_user == null) {
                xmlUnsignedByteFind_element_user = (XmlUnsignedByte) get_store().add_element_user(qName);
            }
            xmlUnsignedByteFind_element_user.set(xmlUnsignedByte);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetUi2(XmlUnsignedShort xmlUnsignedShort) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI2$26;
            XmlUnsignedShort xmlUnsignedShortFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlUnsignedShortFind_element_user == null) {
                xmlUnsignedShortFind_element_user = (XmlUnsignedShort) get_store().add_element_user(qName);
            }
            xmlUnsignedShortFind_element_user.set(xmlUnsignedShort);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetUi4(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI4$28;
            XmlUnsignedInt xmlUnsignedIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlUnsignedIntFind_element_user == null) {
                xmlUnsignedIntFind_element_user = (XmlUnsignedInt) get_store().add_element_user(qName);
            }
            xmlUnsignedIntFind_element_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetUi8(XmlUnsignedLong xmlUnsignedLong) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI8$30;
            XmlUnsignedLong xmlUnsignedLongFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlUnsignedLongFind_element_user == null) {
                xmlUnsignedLongFind_element_user = (XmlUnsignedLong) get_store().add_element_user(qName);
            }
            xmlUnsignedLongFind_element_user.set(xmlUnsignedLong);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant
    public void xsetUint(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UINT$32;
            XmlUnsignedInt xmlUnsignedIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlUnsignedIntFind_element_user == null) {
                xmlUnsignedIntFind_element_user = (XmlUnsignedInt) get_store().add_element_user(qName);
            }
            xmlUnsignedIntFind_element_user.set(xmlUnsignedInt);
        }
    }
}
