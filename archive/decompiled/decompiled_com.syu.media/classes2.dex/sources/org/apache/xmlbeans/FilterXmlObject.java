package org.apache.xmlbeans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class FilterXmlObject implements XmlObject, SimpleValue, DelegateXmlObject {
    @Override // org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return underlyingXmlObject().schemaType();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean validate() {
        return underlyingXmlObject().validate();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean validate(XmlOptions xmlOptions) {
        return underlyingXmlObject().validate(xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectPath(String str) {
        return underlyingXmlObject().selectPath(str);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectPath(String str, XmlOptions xmlOptions) {
        return underlyingXmlObject().selectPath(str, xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] execQuery(String str) {
        return underlyingXmlObject().execQuery(str);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] execQuery(String str, XmlOptions xmlOptions) {
        return underlyingXmlObject().execQuery(str, xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject changeType(SchemaType schemaType) {
        return underlyingXmlObject().changeType(schemaType);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean isNil() {
        return underlyingXmlObject().isNil();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public void setNil() {
        underlyingXmlObject().setNil();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean isImmutable() {
        return underlyingXmlObject().isImmutable();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject set(XmlObject xmlObject) {
        return underlyingXmlObject().set(xmlObject);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject copy() {
        return underlyingXmlObject().copy();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject copy(XmlOptions xmlOptions) {
        return underlyingXmlObject().copy(xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean valueEquals(XmlObject xmlObject) {
        return underlyingXmlObject().valueEquals(xmlObject);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public int valueHashCode() {
        return underlyingXmlObject().valueHashCode();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public int compareTo(Object obj) {
        return underlyingXmlObject().compareTo(obj);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public int compareValue(XmlObject xmlObject) {
        return underlyingXmlObject().compareValue(xmlObject);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Object monitor() {
        return underlyingXmlObject().monitor();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlDocumentProperties documentProperties() {
        return underlyingXmlObject().documentProperties();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlCursor newCursor() {
        return underlyingXmlObject().newCursor();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLInputStream newXMLInputStream() {
        return underlyingXmlObject().newXMLInputStream();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLStreamReader newXMLStreamReader() {
        return underlyingXmlObject().newXMLStreamReader();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText() {
        return underlyingXmlObject().xmlText();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public InputStream newInputStream() {
        return underlyingXmlObject().newInputStream();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Reader newReader() {
        return underlyingXmlObject().newReader();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node newDomNode() {
        return underlyingXmlObject().newDomNode();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node getDomNode() {
        return underlyingXmlObject().getDomNode();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(ContentHandler contentHandler, LexicalHandler lexicalHandler) throws SAXException {
        underlyingXmlObject().save(contentHandler, lexicalHandler);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(File file) throws IOException {
        underlyingXmlObject().save(file);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(OutputStream outputStream) throws IOException {
        underlyingXmlObject().save(outputStream);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(Writer writer) throws IOException {
        underlyingXmlObject().save(writer);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLInputStream newXMLInputStream(XmlOptions xmlOptions) {
        return underlyingXmlObject().newXMLInputStream(xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLStreamReader newXMLStreamReader(XmlOptions xmlOptions) {
        return underlyingXmlObject().newXMLStreamReader(xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText(XmlOptions xmlOptions) {
        return underlyingXmlObject().xmlText(xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public InputStream newInputStream(XmlOptions xmlOptions) {
        return underlyingXmlObject().newInputStream(xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Reader newReader(XmlOptions xmlOptions) {
        return underlyingXmlObject().newReader(xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node newDomNode(XmlOptions xmlOptions) {
        return underlyingXmlObject().newDomNode(xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(ContentHandler contentHandler, LexicalHandler lexicalHandler, XmlOptions xmlOptions) throws SAXException {
        underlyingXmlObject().save(contentHandler, lexicalHandler, xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(File file, XmlOptions xmlOptions) throws IOException {
        underlyingXmlObject().save(file, xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(OutputStream outputStream, XmlOptions xmlOptions) throws IOException {
        underlyingXmlObject().save(outputStream, xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(Writer writer, XmlOptions xmlOptions) throws IOException {
        underlyingXmlObject().save(writer, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public SchemaType instanceType() {
        return ((SimpleValue) underlyingXmlObject()).instanceType();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public String stringValue() {
        return ((SimpleValue) underlyingXmlObject()).stringValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public boolean booleanValue() {
        return ((SimpleValue) underlyingXmlObject()).booleanValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public byte byteValue() {
        return ((SimpleValue) underlyingXmlObject()).byteValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public short shortValue() {
        return ((SimpleValue) underlyingXmlObject()).shortValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public int intValue() {
        return ((SimpleValue) underlyingXmlObject()).intValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public long longValue() {
        return ((SimpleValue) underlyingXmlObject()).longValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public BigInteger bigIntegerValue() {
        return ((SimpleValue) underlyingXmlObject()).bigIntegerValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public BigDecimal bigDecimalValue() {
        return ((SimpleValue) underlyingXmlObject()).bigDecimalValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public float floatValue() {
        return ((SimpleValue) underlyingXmlObject()).floatValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public double doubleValue() {
        return ((SimpleValue) underlyingXmlObject()).doubleValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public byte[] byteArrayValue() {
        return ((SimpleValue) underlyingXmlObject()).byteArrayValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public StringEnumAbstractBase enumValue() {
        return ((SimpleValue) underlyingXmlObject()).enumValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public Calendar calendarValue() {
        return ((SimpleValue) underlyingXmlObject()).calendarValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public Date dateValue() {
        return ((SimpleValue) underlyingXmlObject()).dateValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public GDate gDateValue() {
        return ((SimpleValue) underlyingXmlObject()).gDateValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public GDuration gDurationValue() {
        return ((SimpleValue) underlyingXmlObject()).gDurationValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public QName qNameValue() {
        return ((SimpleValue) underlyingXmlObject()).qNameValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public List listValue() {
        return ((SimpleValue) underlyingXmlObject()).listValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public List xlistValue() {
        return ((SimpleValue) underlyingXmlObject()).xlistValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public Object objectValue() {
        return ((SimpleValue) underlyingXmlObject()).objectValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(String str) {
        ((SimpleValue) underlyingXmlObject()).set(str);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(boolean z) {
        ((SimpleValue) underlyingXmlObject()).set(z);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(byte b) {
        ((SimpleValue) underlyingXmlObject()).set(b);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(short s) {
        ((SimpleValue) underlyingXmlObject()).set(s);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(int i) {
        ((SimpleValue) underlyingXmlObject()).set(i);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(long j) {
        ((SimpleValue) underlyingXmlObject()).set(j);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(BigInteger bigInteger) {
        ((SimpleValue) underlyingXmlObject()).set(bigInteger);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(BigDecimal bigDecimal) {
        ((SimpleValue) underlyingXmlObject()).set(bigDecimal);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(float f) {
        ((SimpleValue) underlyingXmlObject()).set(f);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(double d) {
        ((SimpleValue) underlyingXmlObject()).set(d);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(byte[] bArr) {
        ((SimpleValue) underlyingXmlObject()).set(bArr);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(StringEnumAbstractBase stringEnumAbstractBase) {
        ((SimpleValue) underlyingXmlObject()).set(stringEnumAbstractBase);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(Calendar calendar) {
        ((SimpleValue) underlyingXmlObject()).set(calendar);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(Date date) {
        ((SimpleValue) underlyingXmlObject()).set(date);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(GDateSpecification gDateSpecification) {
        ((SimpleValue) underlyingXmlObject()).set(gDateSpecification);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(GDurationSpecification gDurationSpecification) {
        ((SimpleValue) underlyingXmlObject()).set(gDurationSpecification);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(QName qName) {
        ((SimpleValue) underlyingXmlObject()).set(qName);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void set(List list) {
        ((SimpleValue) underlyingXmlObject()).set(list);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public String getStringValue() {
        return ((SimpleValue) underlyingXmlObject()).getStringValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public boolean getBooleanValue() {
        return ((SimpleValue) underlyingXmlObject()).getBooleanValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public byte getByteValue() {
        return ((SimpleValue) underlyingXmlObject()).getByteValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public short getShortValue() {
        return ((SimpleValue) underlyingXmlObject()).getShortValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public int getIntValue() {
        return ((SimpleValue) underlyingXmlObject()).getIntValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public long getLongValue() {
        return ((SimpleValue) underlyingXmlObject()).getLongValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public BigInteger getBigIntegerValue() {
        return ((SimpleValue) underlyingXmlObject()).getBigIntegerValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public BigDecimal getBigDecimalValue() {
        return ((SimpleValue) underlyingXmlObject()).getBigDecimalValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public float getFloatValue() {
        return ((SimpleValue) underlyingXmlObject()).getFloatValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public double getDoubleValue() {
        return ((SimpleValue) underlyingXmlObject()).getDoubleValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public byte[] getByteArrayValue() {
        return ((SimpleValue) underlyingXmlObject()).getByteArrayValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public StringEnumAbstractBase getEnumValue() {
        return ((SimpleValue) underlyingXmlObject()).getEnumValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public Calendar getCalendarValue() {
        return ((SimpleValue) underlyingXmlObject()).getCalendarValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public Date getDateValue() {
        return ((SimpleValue) underlyingXmlObject()).getDateValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public GDate getGDateValue() {
        return ((SimpleValue) underlyingXmlObject()).getGDateValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public GDuration getGDurationValue() {
        return ((SimpleValue) underlyingXmlObject()).getGDurationValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public QName getQNameValue() {
        return ((SimpleValue) underlyingXmlObject()).getQNameValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public List getListValue() {
        return ((SimpleValue) underlyingXmlObject()).getListValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public List xgetListValue() {
        return ((SimpleValue) underlyingXmlObject()).xgetListValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public Object getObjectValue() {
        return ((SimpleValue) underlyingXmlObject()).getObjectValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setStringValue(String str) {
        ((SimpleValue) underlyingXmlObject()).setStringValue(str);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setBooleanValue(boolean z) {
        ((SimpleValue) underlyingXmlObject()).setBooleanValue(z);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setByteValue(byte b) {
        ((SimpleValue) underlyingXmlObject()).setByteValue(b);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setShortValue(short s) {
        ((SimpleValue) underlyingXmlObject()).setShortValue(s);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setIntValue(int i) {
        ((SimpleValue) underlyingXmlObject()).setIntValue(i);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setLongValue(long j) {
        ((SimpleValue) underlyingXmlObject()).setLongValue(j);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setBigIntegerValue(BigInteger bigInteger) {
        ((SimpleValue) underlyingXmlObject()).setBigIntegerValue(bigInteger);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setBigDecimalValue(BigDecimal bigDecimal) {
        ((SimpleValue) underlyingXmlObject()).setBigDecimalValue(bigDecimal);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setFloatValue(float f) {
        ((SimpleValue) underlyingXmlObject()).setFloatValue(f);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setDoubleValue(double d) {
        ((SimpleValue) underlyingXmlObject()).setDoubleValue(d);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setByteArrayValue(byte[] bArr) {
        ((SimpleValue) underlyingXmlObject()).setByteArrayValue(bArr);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase) {
        ((SimpleValue) underlyingXmlObject()).setEnumValue(stringEnumAbstractBase);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setCalendarValue(Calendar calendar) {
        ((SimpleValue) underlyingXmlObject()).setCalendarValue(calendar);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setDateValue(Date date) {
        ((SimpleValue) underlyingXmlObject()).setDateValue(date);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setGDateValue(GDate gDate) {
        ((SimpleValue) underlyingXmlObject()).setGDateValue(gDate);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setGDurationValue(GDuration gDuration) {
        ((SimpleValue) underlyingXmlObject()).setGDurationValue(gDuration);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setQNameValue(QName qName) {
        ((SimpleValue) underlyingXmlObject()).setQNameValue(qName);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setListValue(List list) {
        ((SimpleValue) underlyingXmlObject()).setListValue(list);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setObjectValue(Object obj) {
        ((SimpleValue) underlyingXmlObject()).setObjectValue(obj);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void objectSet(Object obj) {
        ((SimpleValue) underlyingXmlObject()).objectSet(obj);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectChildren(QName qName) {
        return underlyingXmlObject().selectChildren(qName);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectChildren(String str, String str2) {
        return underlyingXmlObject().selectChildren(str, str2);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectChildren(QNameSet qNameSet) {
        return underlyingXmlObject().selectChildren(qNameSet);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject selectAttribute(QName qName) {
        return underlyingXmlObject().selectAttribute(qName);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject selectAttribute(String str, String str2) {
        return underlyingXmlObject().selectAttribute(str, str2);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectAttributes(QNameSet qNameSet) {
        return underlyingXmlObject().selectAttributes(qNameSet);
    }
}
