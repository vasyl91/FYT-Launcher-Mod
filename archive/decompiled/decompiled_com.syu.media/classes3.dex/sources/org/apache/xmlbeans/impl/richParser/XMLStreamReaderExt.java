package org.apache.xmlbeans.impl.richParser;

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.XmlCalendar;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface XMLStreamReaderExt extends XMLStreamReader {
    public static final int WS_COLLAPSE = 3;
    public static final int WS_PRESERVE = 1;
    public static final int WS_REPLACE = 2;

    InputStream getAttributeBase64Value(int i) throws XMLStreamException;

    InputStream getAttributeBase64Value(String str, String str2) throws XMLStreamException;

    BigDecimal getAttributeBigDecimalValue(int i) throws XMLStreamException;

    BigDecimal getAttributeBigDecimalValue(String str, String str2) throws XMLStreamException;

    BigInteger getAttributeBigIntegerValue(int i) throws XMLStreamException;

    BigInteger getAttributeBigIntegerValue(String str, String str2) throws XMLStreamException;

    boolean getAttributeBooleanValue(int i) throws XMLStreamException;

    boolean getAttributeBooleanValue(String str, String str2) throws XMLStreamException;

    byte getAttributeByteValue(int i) throws XMLStreamException;

    byte getAttributeByteValue(String str, String str2) throws XMLStreamException;

    XmlCalendar getAttributeCalendarValue(int i) throws XMLStreamException;

    XmlCalendar getAttributeCalendarValue(String str, String str2) throws XMLStreamException;

    Date getAttributeDateValue(int i) throws XMLStreamException;

    Date getAttributeDateValue(String str, String str2) throws XMLStreamException;

    double getAttributeDoubleValue(int i) throws XMLStreamException;

    double getAttributeDoubleValue(String str, String str2) throws XMLStreamException;

    float getAttributeFloatValue(int i) throws XMLStreamException;

    float getAttributeFloatValue(String str, String str2) throws XMLStreamException;

    GDate getAttributeGDateValue(int i) throws XMLStreamException;

    GDate getAttributeGDateValue(String str, String str2) throws XMLStreamException;

    GDuration getAttributeGDurationValue(int i) throws XMLStreamException;

    GDuration getAttributeGDurationValue(String str, String str2) throws XMLStreamException;

    InputStream getAttributeHexBinaryValue(int i) throws XMLStreamException;

    InputStream getAttributeHexBinaryValue(String str, String str2) throws XMLStreamException;

    int getAttributeIntValue(int i) throws XMLStreamException;

    int getAttributeIntValue(String str, String str2) throws XMLStreamException;

    long getAttributeLongValue(int i) throws XMLStreamException;

    long getAttributeLongValue(String str, String str2) throws XMLStreamException;

    QName getAttributeQNameValue(int i) throws XMLStreamException;

    QName getAttributeQNameValue(String str, String str2) throws XMLStreamException;

    short getAttributeShortValue(int i) throws XMLStreamException;

    short getAttributeShortValue(String str, String str2) throws XMLStreamException;

    String getAttributeStringValue(int i) throws XMLStreamException;

    String getAttributeStringValue(int i, int i2) throws XMLStreamException;

    String getAttributeStringValue(String str, String str2) throws XMLStreamException;

    String getAttributeStringValue(String str, String str2, int i) throws XMLStreamException;

    InputStream getBase64Value() throws XMLStreamException;

    BigDecimal getBigDecimalValue() throws XMLStreamException;

    BigInteger getBigIntegerValue() throws XMLStreamException;

    boolean getBooleanValue() throws XMLStreamException;

    byte getByteValue() throws XMLStreamException;

    XmlCalendar getCalendarValue() throws XMLStreamException;

    Date getDateValue() throws XMLStreamException;

    double getDoubleValue() throws XMLStreamException;

    float getFloatValue() throws XMLStreamException;

    GDate getGDateValue() throws XMLStreamException;

    GDuration getGDurationValue() throws XMLStreamException;

    InputStream getHexBinaryValue() throws XMLStreamException;

    int getIntValue() throws XMLStreamException;

    long getLongValue() throws XMLStreamException;

    QName getQNameValue() throws XMLStreamException;

    short getShortValue() throws XMLStreamException;

    String getStringValue() throws XMLStreamException;

    String getStringValue(int i) throws XMLStreamException;

    void setDefaultValue(String str) throws XMLStreamException;
}
