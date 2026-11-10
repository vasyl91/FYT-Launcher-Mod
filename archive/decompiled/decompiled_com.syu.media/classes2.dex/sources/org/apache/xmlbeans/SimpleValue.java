package org.apache.xmlbeans;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface SimpleValue extends XmlObject {
    BigDecimal bigDecimalValue();

    BigInteger bigIntegerValue();

    boolean booleanValue();

    byte[] byteArrayValue();

    byte byteValue();

    Calendar calendarValue();

    Date dateValue();

    double doubleValue();

    StringEnumAbstractBase enumValue();

    float floatValue();

    GDate gDateValue();

    GDuration gDurationValue();

    BigDecimal getBigDecimalValue();

    BigInteger getBigIntegerValue();

    boolean getBooleanValue();

    byte[] getByteArrayValue();

    byte getByteValue();

    Calendar getCalendarValue();

    Date getDateValue();

    double getDoubleValue();

    StringEnumAbstractBase getEnumValue();

    float getFloatValue();

    GDate getGDateValue();

    GDuration getGDurationValue();

    int getIntValue();

    List getListValue();

    long getLongValue();

    Object getObjectValue();

    QName getQNameValue();

    short getShortValue();

    String getStringValue();

    SchemaType instanceType();

    int intValue();

    List listValue();

    long longValue();

    void objectSet(Object obj);

    Object objectValue();

    QName qNameValue();

    void set(byte b);

    void set(double d);

    void set(float f);

    void set(int i);

    void set(long j);

    void set(String str);

    void set(BigDecimal bigDecimal);

    void set(BigInteger bigInteger);

    void set(Calendar calendar);

    void set(Date date);

    void set(List list);

    void set(QName qName);

    void set(GDateSpecification gDateSpecification);

    void set(GDurationSpecification gDurationSpecification);

    void set(StringEnumAbstractBase stringEnumAbstractBase);

    void set(short s);

    void set(boolean z);

    void set(byte[] bArr);

    void setBigDecimalValue(BigDecimal bigDecimal);

    void setBigIntegerValue(BigInteger bigInteger);

    void setBooleanValue(boolean z);

    void setByteArrayValue(byte[] bArr);

    void setByteValue(byte b);

    void setCalendarValue(Calendar calendar);

    void setDateValue(Date date);

    void setDoubleValue(double d);

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);

    void setFloatValue(float f);

    void setGDateValue(GDate gDate);

    void setGDurationValue(GDuration gDuration);

    void setIntValue(int i);

    void setListValue(List list);

    void setLongValue(long j);

    void setObjectValue(Object obj);

    void setQNameValue(QName qName);

    void setShortValue(short s);

    void setStringValue(String str);

    short shortValue();

    String stringValue();

    List xgetListValue();

    List xlistValue();
}
