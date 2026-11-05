package org.openxmlformats.schemas.officeDocument.x2006.customProperties.impl;

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
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTArray;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTCf;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTEmpty;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTNull;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVstream;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STClsid;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STCy;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STError;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPropertyImpl extends XmlComplexContentImpl implements CTProperty {
    private static final QName VECTOR$0 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "vector");
    private static final QName ARRAY$2 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "array");
    private static final QName BLOB$4 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "blob");
    private static final QName OBLOB$6 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "oblob");
    private static final QName EMPTY$8 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "empty");
    private static final QName NULL$10 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "null");
    private static final QName I1$12 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i1");
    private static final QName I2$14 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i2");
    private static final QName I4$16 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i4");
    private static final QName I8$18 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i8");
    private static final QName INT$20 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "int");
    private static final QName UI1$22 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui1");
    private static final QName UI2$24 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui2");
    private static final QName UI4$26 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui4");
    private static final QName UI8$28 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui8");
    private static final QName UINT$30 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "uint");
    private static final QName R4$32 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "r4");
    private static final QName R8$34 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "r8");
    private static final QName DECIMAL$36 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "decimal");
    private static final QName LPSTR$38 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "lpstr");
    private static final QName LPWSTR$40 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "lpwstr");
    private static final QName BSTR$42 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "bstr");
    private static final QName DATE$44 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "date");
    private static final QName FILETIME$46 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "filetime");
    private static final QName BOOL$48 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "bool");
    private static final QName CY$50 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "cy");
    private static final QName ERROR$52 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "error");
    private static final QName STREAM$54 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "stream");
    private static final QName OSTREAM$56 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ostream");
    private static final QName STORAGE$58 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "storage");
    private static final QName OSTORAGE$60 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ostorage");
    private static final QName VSTREAM$62 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "vstream");
    private static final QName CLSID$64 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "clsid");
    private static final QName CF$66 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "cf");
    private static final QName FMTID$68 = new QName("", "fmtid");
    private static final QName PID$70 = new QName("", "pid");
    private static final QName NAME$72 = new QName("", "name");
    private static final QName LINKTARGET$74 = new QName("", "linkTarget");

    public CTPropertyImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTArray addNewArray() {
        CTArray cTArrayAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTArrayAdd_element_user = get_store().add_element_user(ARRAY$2);
        }
        return cTArrayAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTCf addNewCf() {
        CTCf cTCfAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCfAdd_element_user = get_store().add_element_user(CF$66);
        }
        return cTCfAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTEmpty addNewEmpty() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(EMPTY$8);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTNull addNewNull() {
        CTNull cTNullAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNullAdd_element_user = get_store().add_element_user(NULL$10);
        }
        return cTNullAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTVector addNewVector() {
        CTVector cTVector;
        synchronized (monitor()) {
            check_orphaned();
            cTVector = (CTVector) get_store().add_element_user(VECTOR$0);
        }
        return cTVector;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTVstream addNewVstream() {
        CTVstream cTVstreamAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTVstreamAdd_element_user = get_store().add_element_user(VSTREAM$62);
        }
        return cTVstreamAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTArray getArray() {
        synchronized (monitor()) {
            check_orphaned();
            CTArray cTArrayFind_element_user = get_store().find_element_user(ARRAY$2, 0);
            if (cTArrayFind_element_user == null) {
                return null;
            }
            return cTArrayFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public byte[] getBlob() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(BLOB$4, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean getBool() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(BOOL$48, 0);
            if (simpleValueFind_element_user == null) {
                return false;
            }
            return simpleValueFind_element_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public String getBstr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(BSTR$42, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTCf getCf() {
        synchronized (monitor()) {
            check_orphaned();
            CTCf cTCfFind_element_user = get_store().find_element_user(CF$66, 0);
            if (cTCfFind_element_user == null) {
                return null;
            }
            return cTCfFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public String getClsid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(CLSID$64, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public String getCy() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(CY$50, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public Calendar getDate() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(DATE$44, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getCalendarValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public BigDecimal getDecimal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(DECIMAL$36, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getBigDecimalValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTEmpty getEmpty() {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(EMPTY$8, 0);
            if (cTEmptyFind_element_user == null) {
                return null;
            }
            return cTEmptyFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public String getError() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(ERROR$52, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public Calendar getFiletime() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(FILETIME$46, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getCalendarValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public String getFmtid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FMTID$68);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public byte getI1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(I1$12, 0);
            if (simpleValueFind_element_user == null) {
                return (byte) 0;
            }
            return simpleValueFind_element_user.getByteValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public short getI2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(I2$14, 0);
            if (simpleValueFind_element_user == null) {
                return (short) 0;
            }
            return simpleValueFind_element_user.getShortValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public int getI4() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(I4$16, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public long getI8() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(I8$18, 0);
            if (simpleValueFind_element_user == null) {
                return 0L;
            }
            return simpleValueFind_element_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public int getInt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(INT$20, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public String getLinkTarget() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(LINKTARGET$74);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public String getLpstr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(LPSTR$38, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public String getLpwstr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(LPWSTR$40, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAME$72);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTNull getNull() {
        synchronized (monitor()) {
            check_orphaned();
            CTNull cTNullFind_element_user = get_store().find_element_user(NULL$10, 0);
            if (cTNullFind_element_user == null) {
                return null;
            }
            return cTNullFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public byte[] getOblob() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(OBLOB$6, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public byte[] getOstorage() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(OSTORAGE$60, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public byte[] getOstream() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(OSTREAM$56, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public int getPid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PID$70);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public float getR4() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(R4$32, 0);
            if (simpleValueFind_element_user == null) {
                return 0.0f;
            }
            return simpleValueFind_element_user.getFloatValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public double getR8() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(R8$34, 0);
            if (simpleValueFind_element_user == null) {
                return 0.0d;
            }
            return simpleValueFind_element_user.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public byte[] getStorage() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(STORAGE$58, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public byte[] getStream() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(STREAM$54, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public short getUi1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(UI1$22, 0);
            if (simpleValueFind_element_user == null) {
                return (short) 0;
            }
            return simpleValueFind_element_user.getShortValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public int getUi2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(UI2$24, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public long getUi4() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(UI4$26, 0);
            if (simpleValueFind_element_user == null) {
                return 0L;
            }
            return simpleValueFind_element_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public BigInteger getUi8() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(UI8$28, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public long getUint() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(UINT$30, 0);
            if (simpleValueFind_element_user == null) {
                return 0L;
            }
            return simpleValueFind_element_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTVector getVector() {
        synchronized (monitor()) {
            check_orphaned();
            CTVector cTVector = (CTVector) get_store().find_element_user(VECTOR$0, 0);
            if (cTVector == null) {
                return null;
            }
            return cTVector;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public CTVstream getVstream() {
        synchronized (monitor()) {
            check_orphaned();
            CTVstream cTVstreamFind_element_user = get_store().find_element_user(VSTREAM$62, 0);
            if (cTVstreamFind_element_user == null) {
                return null;
            }
            return cTVstreamFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetArray() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ARRAY$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetBlob() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BLOB$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetBool() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BOOL$48) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetBstr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BSTR$42) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetCf() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CF$66) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetClsid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CLSID$64) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetCy() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CY$50) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetDate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DATE$44) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetDecimal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DECIMAL$36) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetEmpty() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EMPTY$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetError() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ERROR$52) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetFiletime() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FILETIME$46) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetI1() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(I1$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetI2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(I2$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetI4() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(I4$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetI8() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(I8$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetInt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(INT$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetLinkTarget() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LINKTARGET$74) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetLpstr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LPSTR$38) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetLpwstr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LPWSTR$40) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$72) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetNull() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NULL$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetOblob() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OBLOB$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetOstorage() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OSTORAGE$60) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetOstream() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OSTREAM$56) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetR4() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(R4$32) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetR8() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(R8$34) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetStorage() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STORAGE$58) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetStream() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STREAM$54) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetUi1() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UI1$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetUi2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UI2$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetUi4() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UI4$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetUi8() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UI8$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetUint() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UINT$30) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetVector() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VECTOR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public boolean isSetVstream() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VSTREAM$62) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setArray(CTArray cTArray) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ARRAY$2;
            CTArray cTArrayFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTArrayFind_element_user == null) {
                cTArrayFind_element_user = (CTArray) get_store().add_element_user(qName);
            }
            cTArrayFind_element_user.set(cTArray);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setBlob(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOB$4;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setBool(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOOL$48;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setBstr(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BSTR$42;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setCf(CTCf cTCf) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CF$66;
            CTCf cTCfFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCfFind_element_user == null) {
                cTCfFind_element_user = (CTCf) get_store().add_element_user(qName);
            }
            cTCfFind_element_user.set(cTCf);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setClsid(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLSID$64;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setCy(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CY$50;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setDate(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATE$44;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setDecimal(BigDecimal bigDecimal) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DECIMAL$36;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setBigDecimalValue(bigDecimal);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setEmpty(CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EMPTY$8;
            CTEmpty cTEmptyFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTEmptyFind_element_user == null) {
                cTEmptyFind_element_user = (CTEmpty) get_store().add_element_user(qName);
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setError(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ERROR$52;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setFiletime(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILETIME$46;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setFmtid(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FMTID$68;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setI1(byte b) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I1$12;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setByteValue(b);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setI2(short s) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I2$14;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setI4(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I4$16;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setI8(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I8$18;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setInt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INT$20;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setLinkTarget(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINKTARGET$74;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setLpstr(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LPSTR$38;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setLpwstr(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LPWSTR$40;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$72;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setNull(CTNull cTNull) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NULL$10;
            CTNull cTNullFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTNullFind_element_user == null) {
                cTNullFind_element_user = (CTNull) get_store().add_element_user(qName);
            }
            cTNullFind_element_user.set(cTNull);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setOblob(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OBLOB$6;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setOstorage(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OSTORAGE$60;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setOstream(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OSTREAM$56;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setPid(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PID$70;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setR4(float f) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R4$32;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setFloatValue(f);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setR8(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R8$34;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setStorage(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STORAGE$58;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setStream(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STREAM$54;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setUi1(short s) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI1$22;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setUi2(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI2$24;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setUi4(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI4$26;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setUi8(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI8$28;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setUint(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UINT$30;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setVector(CTVector cTVector) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VECTOR$0;
            CTVector cTVector2 = (CTVector) typeStore.find_element_user(qName, 0);
            if (cTVector2 == null) {
                cTVector2 = (CTVector) get_store().add_element_user(qName);
            }
            cTVector2.set(cTVector);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void setVstream(CTVstream cTVstream) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VSTREAM$62;
            CTVstream cTVstreamFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTVstreamFind_element_user == null) {
                cTVstreamFind_element_user = (CTVstream) get_store().add_element_user(qName);
            }
            cTVstreamFind_element_user.set(cTVstream);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetArray() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ARRAY$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetBlob() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BLOB$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetBool() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOL$48, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetBstr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BSTR$42, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetCf() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CF$66, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetClsid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLSID$64, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetCy() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CY$50, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DATE$44, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetDecimal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DECIMAL$36, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetEmpty() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EMPTY$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetError() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ERROR$52, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetFiletime() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILETIME$46, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetI1() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I1$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetI2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I2$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetI4() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I4$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetI8() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I8$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetInt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INT$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetLinkTarget() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LINKTARGET$74);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetLpstr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LPSTR$38, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetLpwstr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LPWSTR$40, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$72);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetNull() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NULL$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetOblob() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OBLOB$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetOstorage() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OSTORAGE$60, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetOstream() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OSTREAM$56, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetR4() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R4$32, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetR8() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R8$34, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetStorage() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STORAGE$58, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetStream() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STREAM$54, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetUi1() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UI1$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetUi2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UI2$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetUi4() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UI4$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetUi8() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UI8$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetUint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UINT$30, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetVector() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VECTOR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void unsetVstream() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VSTREAM$62, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlBase64Binary xgetBlob() {
        XmlBase64Binary xmlBase64BinaryFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_element_user = get_store().find_element_user(BLOB$4, 0);
        }
        return xmlBase64BinaryFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlBoolean xgetBool() {
        XmlBoolean xmlBooleanFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_element_user = get_store().find_element_user(BOOL$48, 0);
        }
        return xmlBooleanFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlString xgetBstr() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(BSTR$42, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public STClsid xgetClsid() {
        STClsid sTClsid;
        synchronized (monitor()) {
            check_orphaned();
            sTClsid = (STClsid) get_store().find_element_user(CLSID$64, 0);
        }
        return sTClsid;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public STCy xgetCy() {
        STCy sTCyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTCyFind_element_user = get_store().find_element_user(CY$50, 0);
        }
        return sTCyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlDateTime xgetDate() {
        XmlDateTime xmlDateTimeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTimeFind_element_user = get_store().find_element_user(DATE$44, 0);
        }
        return xmlDateTimeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlDecimal xgetDecimal() {
        XmlDecimal xmlDecimalFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDecimalFind_element_user = get_store().find_element_user(DECIMAL$36, 0);
        }
        return xmlDecimalFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public STError xgetError() {
        STError sTErrorFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTErrorFind_element_user = get_store().find_element_user(ERROR$52, 0);
        }
        return sTErrorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlDateTime xgetFiletime() {
        XmlDateTime xmlDateTimeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTimeFind_element_user = get_store().find_element_user(FILETIME$46, 0);
        }
        return xmlDateTimeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public STClsid xgetFmtid() {
        STClsid sTClsid;
        synchronized (monitor()) {
            check_orphaned();
            sTClsid = (STClsid) get_store().find_attribute_user(FMTID$68);
        }
        return sTClsid;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlByte xgetI1() {
        XmlByte xmlByteFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlByteFind_element_user = get_store().find_element_user(I1$12, 0);
        }
        return xmlByteFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlShort xgetI2() {
        XmlShort xmlShortFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlShortFind_element_user = get_store().find_element_user(I2$14, 0);
        }
        return xmlShortFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlInt xgetI4() {
        XmlInt xmlIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_element_user = get_store().find_element_user(I4$16, 0);
        }
        return xmlIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlLong xgetI8() {
        XmlLong xmlLongFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlLongFind_element_user = get_store().find_element_user(I8$18, 0);
        }
        return xmlLongFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlInt xgetInt() {
        XmlInt xmlIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_element_user = get_store().find_element_user(INT$20, 0);
        }
        return xmlIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlString xgetLinkTarget() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(LINKTARGET$74);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlString xgetLpstr() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(LPSTR$38, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlString xgetLpwstr() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(LPWSTR$40, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlString xgetName() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(NAME$72);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlBase64Binary xgetOblob() {
        XmlBase64Binary xmlBase64BinaryFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_element_user = get_store().find_element_user(OBLOB$6, 0);
        }
        return xmlBase64BinaryFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlBase64Binary xgetOstorage() {
        XmlBase64Binary xmlBase64BinaryFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_element_user = get_store().find_element_user(OSTORAGE$60, 0);
        }
        return xmlBase64BinaryFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlBase64Binary xgetOstream() {
        XmlBase64Binary xmlBase64BinaryFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_element_user = get_store().find_element_user(OSTREAM$56, 0);
        }
        return xmlBase64BinaryFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlInt xgetPid() {
        XmlInt xmlIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_attribute_user = get_store().find_attribute_user(PID$70);
        }
        return xmlIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlFloat xgetR4() {
        XmlFloat xmlFloatFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloatFind_element_user = get_store().find_element_user(R4$32, 0);
        }
        return xmlFloatFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlDouble xgetR8() {
        XmlDouble xmlDoubleFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDoubleFind_element_user = get_store().find_element_user(R8$34, 0);
        }
        return xmlDoubleFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlBase64Binary xgetStorage() {
        XmlBase64Binary xmlBase64BinaryFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_element_user = get_store().find_element_user(STORAGE$58, 0);
        }
        return xmlBase64BinaryFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlBase64Binary xgetStream() {
        XmlBase64Binary xmlBase64BinaryFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_element_user = get_store().find_element_user(STREAM$54, 0);
        }
        return xmlBase64BinaryFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlUnsignedByte xgetUi1() {
        XmlUnsignedByte xmlUnsignedByteFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedByteFind_element_user = get_store().find_element_user(UI1$22, 0);
        }
        return xmlUnsignedByteFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlUnsignedShort xgetUi2() {
        XmlUnsignedShort xmlUnsignedShortFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedShortFind_element_user = get_store().find_element_user(UI2$24, 0);
        }
        return xmlUnsignedShortFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlUnsignedInt xgetUi4() {
        XmlUnsignedInt xmlUnsignedIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_element_user = get_store().find_element_user(UI4$26, 0);
        }
        return xmlUnsignedIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlUnsignedLong xgetUi8() {
        XmlUnsignedLong xmlUnsignedLongFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedLongFind_element_user = get_store().find_element_user(UI8$28, 0);
        }
        return xmlUnsignedLongFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public XmlUnsignedInt xgetUint() {
        XmlUnsignedInt xmlUnsignedIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_element_user = get_store().find_element_user(UINT$30, 0);
        }
        return xmlUnsignedIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetBlob(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOB$4;
            XmlBase64Binary xmlBase64BinaryFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBase64BinaryFind_element_user == null) {
                xmlBase64BinaryFind_element_user = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64BinaryFind_element_user.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetBool(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOOL$48;
            XmlBoolean xmlBooleanFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBooleanFind_element_user == null) {
                xmlBooleanFind_element_user = (XmlBoolean) get_store().add_element_user(qName);
            }
            xmlBooleanFind_element_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetBstr(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BSTR$42;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetClsid(STClsid sTClsid) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLSID$64;
            STClsid sTClsid2 = (STClsid) typeStore.find_element_user(qName, 0);
            if (sTClsid2 == null) {
                sTClsid2 = (STClsid) get_store().add_element_user(qName);
            }
            sTClsid2.set(sTClsid);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetCy(STCy sTCy) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CY$50;
            STCy sTCyFind_element_user = typeStore.find_element_user(qName, 0);
            if (sTCyFind_element_user == null) {
                sTCyFind_element_user = (STCy) get_store().add_element_user(qName);
            }
            sTCyFind_element_user.set(sTCy);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetDate(XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATE$44;
            XmlDateTime xmlDateTimeFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlDateTimeFind_element_user == null) {
                xmlDateTimeFind_element_user = (XmlDateTime) get_store().add_element_user(qName);
            }
            xmlDateTimeFind_element_user.set(xmlDateTime);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetDecimal(XmlDecimal xmlDecimal) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DECIMAL$36;
            XmlDecimal xmlDecimalFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlDecimalFind_element_user == null) {
                xmlDecimalFind_element_user = (XmlDecimal) get_store().add_element_user(qName);
            }
            xmlDecimalFind_element_user.set(xmlDecimal);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetError(STError sTError) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ERROR$52;
            STError sTErrorFind_element_user = typeStore.find_element_user(qName, 0);
            if (sTErrorFind_element_user == null) {
                sTErrorFind_element_user = (STError) get_store().add_element_user(qName);
            }
            sTErrorFind_element_user.set(sTError);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetFiletime(XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILETIME$46;
            XmlDateTime xmlDateTimeFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlDateTimeFind_element_user == null) {
                xmlDateTimeFind_element_user = (XmlDateTime) get_store().add_element_user(qName);
            }
            xmlDateTimeFind_element_user.set(xmlDateTime);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetFmtid(STClsid sTClsid) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FMTID$68;
            STClsid sTClsid2 = (STClsid) typeStore.find_attribute_user(qName);
            if (sTClsid2 == null) {
                sTClsid2 = (STClsid) get_store().add_attribute_user(qName);
            }
            sTClsid2.set(sTClsid);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetI1(XmlByte xmlByte) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I1$12;
            XmlByte xmlByteFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlByteFind_element_user == null) {
                xmlByteFind_element_user = (XmlByte) get_store().add_element_user(qName);
            }
            xmlByteFind_element_user.set(xmlByte);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetI2(XmlShort xmlShort) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I2$14;
            XmlShort xmlShortFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlShortFind_element_user == null) {
                xmlShortFind_element_user = (XmlShort) get_store().add_element_user(qName);
            }
            xmlShortFind_element_user.set(xmlShort);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetI4(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I4$16;
            XmlInt xmlIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlIntFind_element_user == null) {
                xmlIntFind_element_user = (XmlInt) get_store().add_element_user(qName);
            }
            xmlIntFind_element_user.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetI8(XmlLong xmlLong) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I8$18;
            XmlLong xmlLongFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlLongFind_element_user == null) {
                xmlLongFind_element_user = (XmlLong) get_store().add_element_user(qName);
            }
            xmlLongFind_element_user.set(xmlLong);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetInt(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INT$20;
            XmlInt xmlIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlIntFind_element_user == null) {
                xmlIntFind_element_user = (XmlInt) get_store().add_element_user(qName);
            }
            xmlIntFind_element_user.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetLinkTarget(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINKTARGET$74;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetLpstr(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LPSTR$38;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetLpwstr(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LPWSTR$40;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$72;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetOblob(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OBLOB$6;
            XmlBase64Binary xmlBase64BinaryFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBase64BinaryFind_element_user == null) {
                xmlBase64BinaryFind_element_user = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64BinaryFind_element_user.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetOstorage(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OSTORAGE$60;
            XmlBase64Binary xmlBase64BinaryFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBase64BinaryFind_element_user == null) {
                xmlBase64BinaryFind_element_user = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64BinaryFind_element_user.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetOstream(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OSTREAM$56;
            XmlBase64Binary xmlBase64BinaryFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBase64BinaryFind_element_user == null) {
                xmlBase64BinaryFind_element_user = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64BinaryFind_element_user.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetPid(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PID$70;
            XmlInt xmlIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntFind_attribute_user == null) {
                xmlIntFind_attribute_user = (XmlInt) get_store().add_attribute_user(qName);
            }
            xmlIntFind_attribute_user.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetR4(XmlFloat xmlFloat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R4$32;
            XmlFloat xmlFloatFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlFloatFind_element_user == null) {
                xmlFloatFind_element_user = (XmlFloat) get_store().add_element_user(qName);
            }
            xmlFloatFind_element_user.set(xmlFloat);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetR8(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = R8$34;
            XmlDouble xmlDoubleFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlDoubleFind_element_user == null) {
                xmlDoubleFind_element_user = (XmlDouble) get_store().add_element_user(qName);
            }
            xmlDoubleFind_element_user.set(xmlDouble);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetStorage(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STORAGE$58;
            XmlBase64Binary xmlBase64BinaryFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBase64BinaryFind_element_user == null) {
                xmlBase64BinaryFind_element_user = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64BinaryFind_element_user.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetStream(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STREAM$54;
            XmlBase64Binary xmlBase64BinaryFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBase64BinaryFind_element_user == null) {
                xmlBase64BinaryFind_element_user = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64BinaryFind_element_user.set(xmlBase64Binary);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetUi1(XmlUnsignedByte xmlUnsignedByte) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI1$22;
            XmlUnsignedByte xmlUnsignedByteFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlUnsignedByteFind_element_user == null) {
                xmlUnsignedByteFind_element_user = (XmlUnsignedByte) get_store().add_element_user(qName);
            }
            xmlUnsignedByteFind_element_user.set(xmlUnsignedByte);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetUi2(XmlUnsignedShort xmlUnsignedShort) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI2$24;
            XmlUnsignedShort xmlUnsignedShortFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlUnsignedShortFind_element_user == null) {
                xmlUnsignedShortFind_element_user = (XmlUnsignedShort) get_store().add_element_user(qName);
            }
            xmlUnsignedShortFind_element_user.set(xmlUnsignedShort);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetUi4(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI4$26;
            XmlUnsignedInt xmlUnsignedIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlUnsignedIntFind_element_user == null) {
                xmlUnsignedIntFind_element_user = (XmlUnsignedInt) get_store().add_element_user(qName);
            }
            xmlUnsignedIntFind_element_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetUi8(XmlUnsignedLong xmlUnsignedLong) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UI8$28;
            XmlUnsignedLong xmlUnsignedLongFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlUnsignedLongFind_element_user == null) {
                xmlUnsignedLongFind_element_user = (XmlUnsignedLong) get_store().add_element_user(qName);
            }
            xmlUnsignedLongFind_element_user.set(xmlUnsignedLong);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty
    public void xsetUint(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UINT$30;
            XmlUnsignedInt xmlUnsignedIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlUnsignedIntFind_element_user == null) {
                xmlUnsignedIntFind_element_user = (XmlUnsignedInt) get_store().add_element_user(qName);
            }
            xmlUnsignedIntFind_element_user.set(xmlUnsignedInt);
        }
    }
}
