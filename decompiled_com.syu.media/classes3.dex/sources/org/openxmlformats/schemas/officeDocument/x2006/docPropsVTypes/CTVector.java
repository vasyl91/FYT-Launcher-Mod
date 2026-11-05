package org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlDateTime;
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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTVector extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTVector.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctvectorc3e2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTVector newInstance() {
            return (CTVector) POIXMLTypeLoader.newInstance(CTVector.type, (XmlOptions) null);
        }

        public static CTVector newInstance(XmlOptions xmlOptions) {
            return (CTVector) POIXMLTypeLoader.newInstance(CTVector.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVector.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVector.type, xmlOptions);
        }

        public static CTVector parse(File file) throws XmlException, IOException {
            return (CTVector) POIXMLTypeLoader.parse(file, CTVector.type, (XmlOptions) null);
        }

        public static CTVector parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVector) POIXMLTypeLoader.parse(file, CTVector.type, xmlOptions);
        }

        public static CTVector parse(InputStream inputStream) throws XmlException, IOException {
            return (CTVector) POIXMLTypeLoader.parse(inputStream, CTVector.type, (XmlOptions) null);
        }

        public static CTVector parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVector) POIXMLTypeLoader.parse(inputStream, CTVector.type, xmlOptions);
        }

        public static CTVector parse(Reader reader) throws XmlException, IOException {
            return (CTVector) POIXMLTypeLoader.parse(reader, CTVector.type, (XmlOptions) null);
        }

        public static CTVector parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVector) POIXMLTypeLoader.parse(reader, CTVector.type, xmlOptions);
        }

        public static CTVector parse(String str) throws XmlException {
            return (CTVector) POIXMLTypeLoader.parse(str, CTVector.type, (XmlOptions) null);
        }

        public static CTVector parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTVector) POIXMLTypeLoader.parse(str, CTVector.type, xmlOptions);
        }

        public static CTVector parse(URL url) throws XmlException, IOException {
            return (CTVector) POIXMLTypeLoader.parse(url, CTVector.type, (XmlOptions) null);
        }

        public static CTVector parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVector) POIXMLTypeLoader.parse(url, CTVector.type, xmlOptions);
        }

        public static CTVector parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTVector) POIXMLTypeLoader.parse(xMLStreamReader, CTVector.type, (XmlOptions) null);
        }

        public static CTVector parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTVector) POIXMLTypeLoader.parse(xMLStreamReader, CTVector.type, xmlOptions);
        }

        public static CTVector parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTVector) POIXMLTypeLoader.parse(xMLInputStream, CTVector.type, (XmlOptions) null);
        }

        public static CTVector parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTVector) POIXMLTypeLoader.parse(xMLInputStream, CTVector.type, xmlOptions);
        }

        public static CTVector parse(Node node) throws XmlException {
            return (CTVector) POIXMLTypeLoader.parse(node, CTVector.type, (XmlOptions) null);
        }

        public static CTVector parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTVector) POIXMLTypeLoader.parse(node, CTVector.type, xmlOptions);
        }
    }

    void addBool(boolean z);

    void addBstr(String str);

    void addClsid(String str);

    void addCy(String str);

    void addDate(Calendar calendar);

    void addError(String str);

    void addFiletime(Calendar calendar);

    void addI1(byte b);

    void addI2(short s);

    void addI4(int i);

    void addI8(long j);

    void addLpstr(String str);

    void addLpwstr(String str);

    XmlBoolean addNewBool();

    XmlString addNewBstr();

    CTCf addNewCf();

    STClsid addNewClsid();

    STCy addNewCy();

    XmlDateTime addNewDate();

    STError addNewError();

    XmlDateTime addNewFiletime();

    XmlByte addNewI1();

    XmlShort addNewI2();

    XmlInt addNewI4();

    XmlLong addNewI8();

    XmlString addNewLpstr();

    XmlString addNewLpwstr();

    XmlFloat addNewR4();

    XmlDouble addNewR8();

    XmlUnsignedByte addNewUi1();

    XmlUnsignedShort addNewUi2();

    XmlUnsignedInt addNewUi4();

    XmlUnsignedLong addNewUi8();

    CTVariant addNewVariant();

    void addR4(float f);

    void addR8(double d);

    void addUi1(short s);

    void addUi2(int i);

    void addUi4(long j);

    void addUi8(BigInteger bigInteger);

    STVectorBaseType$Enum getBaseType();

    boolean getBoolArray(int i);

    boolean[] getBoolArray();

    List<Boolean> getBoolList();

    String getBstrArray(int i);

    String[] getBstrArray();

    List<String> getBstrList();

    CTCf getCfArray(int i);

    CTCf[] getCfArray();

    List<CTCf> getCfList();

    String getClsidArray(int i);

    String[] getClsidArray();

    List<String> getClsidList();

    String getCyArray(int i);

    String[] getCyArray();

    List<String> getCyList();

    Calendar getDateArray(int i);

    Calendar[] getDateArray();

    List<Calendar> getDateList();

    String getErrorArray(int i);

    String[] getErrorArray();

    List<String> getErrorList();

    Calendar getFiletimeArray(int i);

    Calendar[] getFiletimeArray();

    List<Calendar> getFiletimeList();

    byte getI1Array(int i);

    byte[] getI1Array();

    List<Byte> getI1List();

    short getI2Array(int i);

    short[] getI2Array();

    List<Short> getI2List();

    int getI4Array(int i);

    int[] getI4Array();

    List<Integer> getI4List();

    long getI8Array(int i);

    long[] getI8Array();

    List<Long> getI8List();

    String getLpstrArray(int i);

    String[] getLpstrArray();

    List<String> getLpstrList();

    String getLpwstrArray(int i);

    String[] getLpwstrArray();

    List<String> getLpwstrList();

    float getR4Array(int i);

    float[] getR4Array();

    List<Float> getR4List();

    double getR8Array(int i);

    double[] getR8Array();

    List<Double> getR8List();

    long getSize();

    short getUi1Array(int i);

    short[] getUi1Array();

    List<Short> getUi1List();

    int getUi2Array(int i);

    int[] getUi2Array();

    List<Integer> getUi2List();

    long getUi4Array(int i);

    long[] getUi4Array();

    List<Long> getUi4List();

    BigInteger getUi8Array(int i);

    BigInteger[] getUi8Array();

    List<BigInteger> getUi8List();

    CTVariant getVariantArray(int i);

    CTVariant[] getVariantArray();

    List<CTVariant> getVariantList();

    void insertBool(int i, boolean z);

    void insertBstr(int i, String str);

    void insertClsid(int i, String str);

    void insertCy(int i, String str);

    void insertDate(int i, Calendar calendar);

    void insertError(int i, String str);

    void insertFiletime(int i, Calendar calendar);

    void insertI1(int i, byte b);

    void insertI2(int i, short s);

    void insertI4(int i, int i2);

    void insertI8(int i, long j);

    void insertLpstr(int i, String str);

    void insertLpwstr(int i, String str);

    XmlBoolean insertNewBool(int i);

    XmlString insertNewBstr(int i);

    CTCf insertNewCf(int i);

    STClsid insertNewClsid(int i);

    STCy insertNewCy(int i);

    XmlDateTime insertNewDate(int i);

    STError insertNewError(int i);

    XmlDateTime insertNewFiletime(int i);

    XmlByte insertNewI1(int i);

    XmlShort insertNewI2(int i);

    XmlInt insertNewI4(int i);

    XmlLong insertNewI8(int i);

    XmlString insertNewLpstr(int i);

    XmlString insertNewLpwstr(int i);

    XmlFloat insertNewR4(int i);

    XmlDouble insertNewR8(int i);

    XmlUnsignedByte insertNewUi1(int i);

    XmlUnsignedShort insertNewUi2(int i);

    XmlUnsignedInt insertNewUi4(int i);

    XmlUnsignedLong insertNewUi8(int i);

    CTVariant insertNewVariant(int i);

    void insertR4(int i, float f);

    void insertR8(int i, double d);

    void insertUi1(int i, short s);

    void insertUi2(int i, int i2);

    void insertUi4(int i, long j);

    void insertUi8(int i, BigInteger bigInteger);

    void removeBool(int i);

    void removeBstr(int i);

    void removeCf(int i);

    void removeClsid(int i);

    void removeCy(int i);

    void removeDate(int i);

    void removeError(int i);

    void removeFiletime(int i);

    void removeI1(int i);

    void removeI2(int i);

    void removeI4(int i);

    void removeI8(int i);

    void removeLpstr(int i);

    void removeLpwstr(int i);

    void removeR4(int i);

    void removeR8(int i);

    void removeUi1(int i);

    void removeUi2(int i);

    void removeUi4(int i);

    void removeUi8(int i);

    void removeVariant(int i);

    void setBaseType(STVectorBaseType$Enum sTVectorBaseType$Enum);

    void setBoolArray(int i, boolean z);

    void setBoolArray(boolean[] zArr);

    void setBstrArray(int i, String str);

    void setBstrArray(String[] strArr);

    void setCfArray(int i, CTCf cTCf);

    void setCfArray(CTCf[] cTCfArr);

    void setClsidArray(int i, String str);

    void setClsidArray(String[] strArr);

    void setCyArray(int i, String str);

    void setCyArray(String[] strArr);

    void setDateArray(int i, Calendar calendar);

    void setDateArray(Calendar[] calendarArr);

    void setErrorArray(int i, String str);

    void setErrorArray(String[] strArr);

    void setFiletimeArray(int i, Calendar calendar);

    void setFiletimeArray(Calendar[] calendarArr);

    void setI1Array(int i, byte b);

    void setI1Array(byte[] bArr);

    void setI2Array(int i, short s);

    void setI2Array(short[] sArr);

    void setI4Array(int i, int i2);

    void setI4Array(int[] iArr);

    void setI8Array(int i, long j);

    void setI8Array(long[] jArr);

    void setLpstrArray(int i, String str);

    void setLpstrArray(String[] strArr);

    void setLpwstrArray(int i, String str);

    void setLpwstrArray(String[] strArr);

    void setR4Array(int i, float f);

    void setR4Array(float[] fArr);

    void setR8Array(int i, double d);

    void setR8Array(double[] dArr);

    void setSize(long j);

    void setUi1Array(int i, short s);

    void setUi1Array(short[] sArr);

    void setUi2Array(int i, int i2);

    void setUi2Array(int[] iArr);

    void setUi4Array(int i, long j);

    void setUi4Array(long[] jArr);

    void setUi8Array(int i, BigInteger bigInteger);

    void setUi8Array(BigInteger[] bigIntegerArr);

    void setVariantArray(int i, CTVariant cTVariant);

    void setVariantArray(CTVariant[] cTVariantArr);

    int sizeOfBoolArray();

    int sizeOfBstrArray();

    int sizeOfCfArray();

    int sizeOfClsidArray();

    int sizeOfCyArray();

    int sizeOfDateArray();

    int sizeOfErrorArray();

    int sizeOfFiletimeArray();

    int sizeOfI1Array();

    int sizeOfI2Array();

    int sizeOfI4Array();

    int sizeOfI8Array();

    int sizeOfLpstrArray();

    int sizeOfLpwstrArray();

    int sizeOfR4Array();

    int sizeOfR8Array();

    int sizeOfUi1Array();

    int sizeOfUi2Array();

    int sizeOfUi4Array();

    int sizeOfUi8Array();

    int sizeOfVariantArray();

    STVectorBaseType xgetBaseType();

    XmlBoolean xgetBoolArray(int i);

    XmlBoolean[] xgetBoolArray();

    List<XmlBoolean> xgetBoolList();

    XmlString xgetBstrArray(int i);

    XmlString[] xgetBstrArray();

    List<XmlString> xgetBstrList();

    STClsid xgetClsidArray(int i);

    STClsid[] xgetClsidArray();

    List<STClsid> xgetClsidList();

    STCy xgetCyArray(int i);

    STCy[] xgetCyArray();

    List<STCy> xgetCyList();

    XmlDateTime xgetDateArray(int i);

    XmlDateTime[] xgetDateArray();

    List<XmlDateTime> xgetDateList();

    STError xgetErrorArray(int i);

    STError[] xgetErrorArray();

    List<STError> xgetErrorList();

    XmlDateTime xgetFiletimeArray(int i);

    XmlDateTime[] xgetFiletimeArray();

    List<XmlDateTime> xgetFiletimeList();

    XmlByte xgetI1Array(int i);

    XmlByte[] xgetI1Array();

    List<XmlByte> xgetI1List();

    XmlShort xgetI2Array(int i);

    XmlShort[] xgetI2Array();

    List<XmlShort> xgetI2List();

    XmlInt xgetI4Array(int i);

    XmlInt[] xgetI4Array();

    List<XmlInt> xgetI4List();

    XmlLong xgetI8Array(int i);

    XmlLong[] xgetI8Array();

    List<XmlLong> xgetI8List();

    XmlString xgetLpstrArray(int i);

    XmlString[] xgetLpstrArray();

    List<XmlString> xgetLpstrList();

    XmlString xgetLpwstrArray(int i);

    XmlString[] xgetLpwstrArray();

    List<XmlString> xgetLpwstrList();

    XmlFloat xgetR4Array(int i);

    XmlFloat[] xgetR4Array();

    List<XmlFloat> xgetR4List();

    XmlDouble xgetR8Array(int i);

    XmlDouble[] xgetR8Array();

    List<XmlDouble> xgetR8List();

    XmlUnsignedInt xgetSize();

    XmlUnsignedByte xgetUi1Array(int i);

    XmlUnsignedByte[] xgetUi1Array();

    List<XmlUnsignedByte> xgetUi1List();

    XmlUnsignedShort xgetUi2Array(int i);

    XmlUnsignedShort[] xgetUi2Array();

    List<XmlUnsignedShort> xgetUi2List();

    XmlUnsignedInt xgetUi4Array(int i);

    XmlUnsignedInt[] xgetUi4Array();

    List<XmlUnsignedInt> xgetUi4List();

    XmlUnsignedLong xgetUi8Array(int i);

    XmlUnsignedLong[] xgetUi8Array();

    List<XmlUnsignedLong> xgetUi8List();

    void xsetBaseType(STVectorBaseType sTVectorBaseType);

    void xsetBoolArray(int i, XmlBoolean xmlBoolean);

    void xsetBoolArray(XmlBoolean[] xmlBooleanArr);

    void xsetBstrArray(int i, XmlString xmlString);

    void xsetBstrArray(XmlString[] xmlStringArr);

    void xsetClsidArray(int i, STClsid sTClsid);

    void xsetClsidArray(STClsid[] sTClsidArr);

    void xsetCyArray(int i, STCy sTCy);

    void xsetCyArray(STCy[] sTCyArr);

    void xsetDateArray(int i, XmlDateTime xmlDateTime);

    void xsetDateArray(XmlDateTime[] xmlDateTimeArr);

    void xsetErrorArray(int i, STError sTError);

    void xsetErrorArray(STError[] sTErrorArr);

    void xsetFiletimeArray(int i, XmlDateTime xmlDateTime);

    void xsetFiletimeArray(XmlDateTime[] xmlDateTimeArr);

    void xsetI1Array(int i, XmlByte xmlByte);

    void xsetI1Array(XmlByte[] xmlByteArr);

    void xsetI2Array(int i, XmlShort xmlShort);

    void xsetI2Array(XmlShort[] xmlShortArr);

    void xsetI4Array(int i, XmlInt xmlInt);

    void xsetI4Array(XmlInt[] xmlIntArr);

    void xsetI8Array(int i, XmlLong xmlLong);

    void xsetI8Array(XmlLong[] xmlLongArr);

    void xsetLpstrArray(int i, XmlString xmlString);

    void xsetLpstrArray(XmlString[] xmlStringArr);

    void xsetLpwstrArray(int i, XmlString xmlString);

    void xsetLpwstrArray(XmlString[] xmlStringArr);

    void xsetR4Array(int i, XmlFloat xmlFloat);

    void xsetR4Array(XmlFloat[] xmlFloatArr);

    void xsetR8Array(int i, XmlDouble xmlDouble);

    void xsetR8Array(XmlDouble[] xmlDoubleArr);

    void xsetSize(XmlUnsignedInt xmlUnsignedInt);

    void xsetUi1Array(int i, XmlUnsignedByte xmlUnsignedByte);

    void xsetUi1Array(XmlUnsignedByte[] xmlUnsignedByteArr);

    void xsetUi2Array(int i, XmlUnsignedShort xmlUnsignedShort);

    void xsetUi2Array(XmlUnsignedShort[] xmlUnsignedShortArr);

    void xsetUi4Array(int i, XmlUnsignedInt xmlUnsignedInt);

    void xsetUi4Array(XmlUnsignedInt[] xmlUnsignedIntArr);

    void xsetUi8Array(int i, XmlUnsignedLong xmlUnsignedLong);

    void xsetUi8Array(XmlUnsignedLong[] xmlUnsignedLongArr);
}
