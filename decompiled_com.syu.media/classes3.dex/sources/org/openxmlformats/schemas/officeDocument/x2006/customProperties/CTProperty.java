package org.openxmlformats.schemas.officeDocument.x2006.customProperties;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.Calendar;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlShort;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.XmlUnsignedLong;
import org.apache.xmlbeans.XmlUnsignedShort;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTArray;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTCf;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTEmpty;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTNull;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVstream;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STClsid;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STCy;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STError;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTProperty extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTProperty.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctproperty5ffatype");

    public static final class Factory {
        private Factory() {
        }

        public static CTProperty newInstance() {
            return (CTProperty) POIXMLTypeLoader.newInstance(CTProperty.type, (XmlOptions) null);
        }

        public static CTProperty newInstance(XmlOptions xmlOptions) {
            return (CTProperty) POIXMLTypeLoader.newInstance(CTProperty.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTProperty.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTProperty.type, xmlOptions);
        }

        public static CTProperty parse(File file) throws XmlException, IOException {
            return (CTProperty) POIXMLTypeLoader.parse(file, CTProperty.type, (XmlOptions) null);
        }

        public static CTProperty parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProperty) POIXMLTypeLoader.parse(file, CTProperty.type, xmlOptions);
        }

        public static CTProperty parse(InputStream inputStream) throws XmlException, IOException {
            return (CTProperty) POIXMLTypeLoader.parse(inputStream, CTProperty.type, (XmlOptions) null);
        }

        public static CTProperty parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProperty) POIXMLTypeLoader.parse(inputStream, CTProperty.type, xmlOptions);
        }

        public static CTProperty parse(Reader reader) throws XmlException, IOException {
            return (CTProperty) POIXMLTypeLoader.parse(reader, CTProperty.type, (XmlOptions) null);
        }

        public static CTProperty parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProperty) POIXMLTypeLoader.parse(reader, CTProperty.type, xmlOptions);
        }

        public static CTProperty parse(String str) throws XmlException {
            return (CTProperty) POIXMLTypeLoader.parse(str, CTProperty.type, (XmlOptions) null);
        }

        public static CTProperty parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTProperty) POIXMLTypeLoader.parse(str, CTProperty.type, xmlOptions);
        }

        public static CTProperty parse(URL url) throws XmlException, IOException {
            return (CTProperty) POIXMLTypeLoader.parse(url, CTProperty.type, (XmlOptions) null);
        }

        public static CTProperty parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProperty) POIXMLTypeLoader.parse(url, CTProperty.type, xmlOptions);
        }

        public static CTProperty parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTProperty) POIXMLTypeLoader.parse(xMLStreamReader, CTProperty.type, (XmlOptions) null);
        }

        public static CTProperty parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTProperty) POIXMLTypeLoader.parse(xMLStreamReader, CTProperty.type, xmlOptions);
        }

        public static CTProperty parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTProperty) POIXMLTypeLoader.parse(xMLInputStream, CTProperty.type, (XmlOptions) null);
        }

        public static CTProperty parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTProperty) POIXMLTypeLoader.parse(xMLInputStream, CTProperty.type, xmlOptions);
        }

        public static CTProperty parse(Node node) throws XmlException {
            return (CTProperty) POIXMLTypeLoader.parse(node, CTProperty.type, (XmlOptions) null);
        }

        public static CTProperty parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTProperty) POIXMLTypeLoader.parse(node, CTProperty.type, xmlOptions);
        }
    }

    CTArray addNewArray();

    CTCf addNewCf();

    CTEmpty addNewEmpty();

    CTNull addNewNull();

    CTVector addNewVector();

    CTVstream addNewVstream();

    CTArray getArray();

    byte[] getBlob();

    boolean getBool();

    String getBstr();

    CTCf getCf();

    String getClsid();

    String getCy();

    Calendar getDate();

    BigDecimal getDecimal();

    CTEmpty getEmpty();

    String getError();

    Calendar getFiletime();

    String getFmtid();

    byte getI1();

    short getI2();

    int getI4();

    long getI8();

    int getInt();

    String getLinkTarget();

    String getLpstr();

    String getLpwstr();

    String getName();

    CTNull getNull();

    byte[] getOblob();

    byte[] getOstorage();

    byte[] getOstream();

    int getPid();

    float getR4();

    double getR8();

    byte[] getStorage();

    byte[] getStream();

    short getUi1();

    int getUi2();

    long getUi4();

    BigInteger getUi8();

    long getUint();

    CTVector getVector();

    CTVstream getVstream();

    boolean isSetArray();

    boolean isSetBlob();

    boolean isSetBool();

    boolean isSetBstr();

    boolean isSetCf();

    boolean isSetClsid();

    boolean isSetCy();

    boolean isSetDate();

    boolean isSetDecimal();

    boolean isSetEmpty();

    boolean isSetError();

    boolean isSetFiletime();

    boolean isSetI1();

    boolean isSetI2();

    boolean isSetI4();

    boolean isSetI8();

    boolean isSetInt();

    boolean isSetLinkTarget();

    boolean isSetLpstr();

    boolean isSetLpwstr();

    boolean isSetName();

    boolean isSetNull();

    boolean isSetOblob();

    boolean isSetOstorage();

    boolean isSetOstream();

    boolean isSetR4();

    boolean isSetR8();

    boolean isSetStorage();

    boolean isSetStream();

    boolean isSetUi1();

    boolean isSetUi2();

    boolean isSetUi4();

    boolean isSetUi8();

    boolean isSetUint();

    boolean isSetVector();

    boolean isSetVstream();

    void setArray(CTArray cTArray);

    void setBlob(byte[] bArr);

    void setBool(boolean z);

    void setBstr(String str);

    void setCf(CTCf cTCf);

    void setClsid(String str);

    void setCy(String str);

    void setDate(Calendar calendar);

    void setDecimal(BigDecimal bigDecimal);

    void setEmpty(CTEmpty cTEmpty);

    void setError(String str);

    void setFiletime(Calendar calendar);

    void setFmtid(String str);

    void setI1(byte b);

    void setI2(short s);

    void setI4(int i);

    void setI8(long j);

    void setInt(int i);

    void setLinkTarget(String str);

    void setLpstr(String str);

    void setLpwstr(String str);

    void setName(String str);

    void setNull(CTNull cTNull);

    void setOblob(byte[] bArr);

    void setOstorage(byte[] bArr);

    void setOstream(byte[] bArr);

    void setPid(int i);

    void setR4(float f);

    void setR8(double d);

    void setStorage(byte[] bArr);

    void setStream(byte[] bArr);

    void setUi1(short s);

    void setUi2(int i);

    void setUi4(long j);

    void setUi8(BigInteger bigInteger);

    void setUint(long j);

    void setVector(CTVector cTVector);

    void setVstream(CTVstream cTVstream);

    void unsetArray();

    void unsetBlob();

    void unsetBool();

    void unsetBstr();

    void unsetCf();

    void unsetClsid();

    void unsetCy();

    void unsetDate();

    void unsetDecimal();

    void unsetEmpty();

    void unsetError();

    void unsetFiletime();

    void unsetI1();

    void unsetI2();

    void unsetI4();

    void unsetI8();

    void unsetInt();

    void unsetLinkTarget();

    void unsetLpstr();

    void unsetLpwstr();

    void unsetName();

    void unsetNull();

    void unsetOblob();

    void unsetOstorage();

    void unsetOstream();

    void unsetR4();

    void unsetR8();

    void unsetStorage();

    void unsetStream();

    void unsetUi1();

    void unsetUi2();

    void unsetUi4();

    void unsetUi8();

    void unsetUint();

    void unsetVector();

    void unsetVstream();

    XmlBase64Binary xgetBlob();

    XmlBoolean xgetBool();

    XmlString xgetBstr();

    STClsid xgetClsid();

    STCy xgetCy();

    XmlDateTime xgetDate();

    XmlDecimal xgetDecimal();

    STError xgetError();

    XmlDateTime xgetFiletime();

    STClsid xgetFmtid();

    XmlByte xgetI1();

    XmlShort xgetI2();

    XmlInt xgetI4();

    XmlLong xgetI8();

    XmlInt xgetInt();

    XmlString xgetLinkTarget();

    XmlString xgetLpstr();

    XmlString xgetLpwstr();

    XmlString xgetName();

    XmlBase64Binary xgetOblob();

    XmlBase64Binary xgetOstorage();

    XmlBase64Binary xgetOstream();

    XmlInt xgetPid();

    XmlFloat xgetR4();

    XmlDouble xgetR8();

    XmlBase64Binary xgetStorage();

    XmlBase64Binary xgetStream();

    XmlUnsignedByte xgetUi1();

    XmlUnsignedShort xgetUi2();

    XmlUnsignedInt xgetUi4();

    XmlUnsignedLong xgetUi8();

    XmlUnsignedInt xgetUint();

    void xsetBlob(XmlBase64Binary xmlBase64Binary);

    void xsetBool(XmlBoolean xmlBoolean);

    void xsetBstr(XmlString xmlString);

    void xsetClsid(STClsid sTClsid);

    void xsetCy(STCy sTCy);

    void xsetDate(XmlDateTime xmlDateTime);

    void xsetDecimal(XmlDecimal xmlDecimal);

    void xsetError(STError sTError);

    void xsetFiletime(XmlDateTime xmlDateTime);

    void xsetFmtid(STClsid sTClsid);

    void xsetI1(XmlByte xmlByte);

    void xsetI2(XmlShort xmlShort);

    void xsetI4(XmlInt xmlInt);

    void xsetI8(XmlLong xmlLong);

    void xsetInt(XmlInt xmlInt);

    void xsetLinkTarget(XmlString xmlString);

    void xsetLpstr(XmlString xmlString);

    void xsetLpwstr(XmlString xmlString);

    void xsetName(XmlString xmlString);

    void xsetOblob(XmlBase64Binary xmlBase64Binary);

    void xsetOstorage(XmlBase64Binary xmlBase64Binary);

    void xsetOstream(XmlBase64Binary xmlBase64Binary);

    void xsetPid(XmlInt xmlInt);

    void xsetR4(XmlFloat xmlFloat);

    void xsetR8(XmlDouble xmlDouble);

    void xsetStorage(XmlBase64Binary xmlBase64Binary);

    void xsetStream(XmlBase64Binary xmlBase64Binary);

    void xsetUi1(XmlUnsignedByte xmlUnsignedByte);

    void xsetUi2(XmlUnsignedShort xmlUnsignedShort);

    void xsetUi4(XmlUnsignedInt xmlUnsignedInt);

    void xsetUi8(XmlUnsignedLong xmlUnsignedLong);

    void xsetUint(XmlUnsignedInt xmlUnsignedInt);
}
