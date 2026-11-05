package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTSharedItems extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSharedItems.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctshareditems677atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSharedItems newInstance() {
            return (CTSharedItems) POIXMLTypeLoader.newInstance(CTSharedItems.type, (XmlOptions) null);
        }

        public static CTSharedItems newInstance(XmlOptions xmlOptions) {
            return (CTSharedItems) POIXMLTypeLoader.newInstance(CTSharedItems.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSharedItems.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSharedItems.type, xmlOptions);
        }

        public static CTSharedItems parse(File file) throws XmlException, IOException {
            return (CTSharedItems) POIXMLTypeLoader.parse(file, CTSharedItems.type, (XmlOptions) null);
        }

        public static CTSharedItems parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSharedItems) POIXMLTypeLoader.parse(file, CTSharedItems.type, xmlOptions);
        }

        public static CTSharedItems parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSharedItems) POIXMLTypeLoader.parse(inputStream, CTSharedItems.type, (XmlOptions) null);
        }

        public static CTSharedItems parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSharedItems) POIXMLTypeLoader.parse(inputStream, CTSharedItems.type, xmlOptions);
        }

        public static CTSharedItems parse(Reader reader) throws XmlException, IOException {
            return (CTSharedItems) POIXMLTypeLoader.parse(reader, CTSharedItems.type, (XmlOptions) null);
        }

        public static CTSharedItems parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSharedItems) POIXMLTypeLoader.parse(reader, CTSharedItems.type, xmlOptions);
        }

        public static CTSharedItems parse(String str) throws XmlException {
            return (CTSharedItems) POIXMLTypeLoader.parse(str, CTSharedItems.type, (XmlOptions) null);
        }

        public static CTSharedItems parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSharedItems) POIXMLTypeLoader.parse(str, CTSharedItems.type, xmlOptions);
        }

        public static CTSharedItems parse(URL url) throws XmlException, IOException {
            return (CTSharedItems) POIXMLTypeLoader.parse(url, CTSharedItems.type, (XmlOptions) null);
        }

        public static CTSharedItems parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSharedItems) POIXMLTypeLoader.parse(url, CTSharedItems.type, xmlOptions);
        }

        public static CTSharedItems parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSharedItems) POIXMLTypeLoader.parse(xMLStreamReader, CTSharedItems.type, (XmlOptions) null);
        }

        public static CTSharedItems parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSharedItems) POIXMLTypeLoader.parse(xMLStreamReader, CTSharedItems.type, xmlOptions);
        }

        public static CTSharedItems parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSharedItems) POIXMLTypeLoader.parse(xMLInputStream, CTSharedItems.type, (XmlOptions) null);
        }

        public static CTSharedItems parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSharedItems) POIXMLTypeLoader.parse(xMLInputStream, CTSharedItems.type, xmlOptions);
        }

        public static CTSharedItems parse(Node node) throws XmlException {
            return (CTSharedItems) POIXMLTypeLoader.parse(node, CTSharedItems.type, (XmlOptions) null);
        }

        public static CTSharedItems parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSharedItems) POIXMLTypeLoader.parse(node, CTSharedItems.type, xmlOptions);
        }
    }

    CTBoolean addNewB();

    CTDateTime addNewD();

    CTError addNewE();

    CTMissing addNewM();

    CTNumber addNewN();

    CTString addNewS();

    CTBoolean getBArray(int i);

    CTBoolean[] getBArray();

    List<CTBoolean> getBList();

    boolean getContainsBlank();

    boolean getContainsDate();

    boolean getContainsInteger();

    boolean getContainsMixedTypes();

    boolean getContainsNonDate();

    boolean getContainsNumber();

    boolean getContainsSemiMixedTypes();

    boolean getContainsString();

    long getCount();

    CTDateTime getDArray(int i);

    CTDateTime[] getDArray();

    List<CTDateTime> getDList();

    CTError getEArray(int i);

    CTError[] getEArray();

    List<CTError> getEList();

    boolean getLongText();

    CTMissing getMArray(int i);

    CTMissing[] getMArray();

    List<CTMissing> getMList();

    Calendar getMaxDate();

    double getMaxValue();

    Calendar getMinDate();

    double getMinValue();

    CTNumber getNArray(int i);

    CTNumber[] getNArray();

    List<CTNumber> getNList();

    CTString getSArray(int i);

    CTString[] getSArray();

    List<CTString> getSList();

    CTBoolean insertNewB(int i);

    CTDateTime insertNewD(int i);

    CTError insertNewE(int i);

    CTMissing insertNewM(int i);

    CTNumber insertNewN(int i);

    CTString insertNewS(int i);

    boolean isSetContainsBlank();

    boolean isSetContainsDate();

    boolean isSetContainsInteger();

    boolean isSetContainsMixedTypes();

    boolean isSetContainsNonDate();

    boolean isSetContainsNumber();

    boolean isSetContainsSemiMixedTypes();

    boolean isSetContainsString();

    boolean isSetCount();

    boolean isSetLongText();

    boolean isSetMaxDate();

    boolean isSetMaxValue();

    boolean isSetMinDate();

    boolean isSetMinValue();

    void removeB(int i);

    void removeD(int i);

    void removeE(int i);

    void removeM(int i);

    void removeN(int i);

    void removeS(int i);

    void setBArray(int i, CTBoolean cTBoolean);

    void setBArray(CTBoolean[] cTBooleanArr);

    void setContainsBlank(boolean z);

    void setContainsDate(boolean z);

    void setContainsInteger(boolean z);

    void setContainsMixedTypes(boolean z);

    void setContainsNonDate(boolean z);

    void setContainsNumber(boolean z);

    void setContainsSemiMixedTypes(boolean z);

    void setContainsString(boolean z);

    void setCount(long j);

    void setDArray(int i, CTDateTime cTDateTime);

    void setDArray(CTDateTime[] cTDateTimeArr);

    void setEArray(int i, CTError cTError);

    void setEArray(CTError[] cTErrorArr);

    void setLongText(boolean z);

    void setMArray(int i, CTMissing cTMissing);

    void setMArray(CTMissing[] cTMissingArr);

    void setMaxDate(Calendar calendar);

    void setMaxValue(double d);

    void setMinDate(Calendar calendar);

    void setMinValue(double d);

    void setNArray(int i, CTNumber cTNumber);

    void setNArray(CTNumber[] cTNumberArr);

    void setSArray(int i, CTString cTString);

    void setSArray(CTString[] cTStringArr);

    int sizeOfBArray();

    int sizeOfDArray();

    int sizeOfEArray();

    int sizeOfMArray();

    int sizeOfNArray();

    int sizeOfSArray();

    void unsetContainsBlank();

    void unsetContainsDate();

    void unsetContainsInteger();

    void unsetContainsMixedTypes();

    void unsetContainsNonDate();

    void unsetContainsNumber();

    void unsetContainsSemiMixedTypes();

    void unsetContainsString();

    void unsetCount();

    void unsetLongText();

    void unsetMaxDate();

    void unsetMaxValue();

    void unsetMinDate();

    void unsetMinValue();

    XmlBoolean xgetContainsBlank();

    XmlBoolean xgetContainsDate();

    XmlBoolean xgetContainsInteger();

    XmlBoolean xgetContainsMixedTypes();

    XmlBoolean xgetContainsNonDate();

    XmlBoolean xgetContainsNumber();

    XmlBoolean xgetContainsSemiMixedTypes();

    XmlBoolean xgetContainsString();

    XmlUnsignedInt xgetCount();

    XmlBoolean xgetLongText();

    XmlDateTime xgetMaxDate();

    XmlDouble xgetMaxValue();

    XmlDateTime xgetMinDate();

    XmlDouble xgetMinValue();

    void xsetContainsBlank(XmlBoolean xmlBoolean);

    void xsetContainsDate(XmlBoolean xmlBoolean);

    void xsetContainsInteger(XmlBoolean xmlBoolean);

    void xsetContainsMixedTypes(XmlBoolean xmlBoolean);

    void xsetContainsNonDate(XmlBoolean xmlBoolean);

    void xsetContainsNumber(XmlBoolean xmlBoolean);

    void xsetContainsSemiMixedTypes(XmlBoolean xmlBoolean);

    void xsetContainsString(XmlBoolean xmlBoolean);

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetLongText(XmlBoolean xmlBoolean);

    void xsetMaxDate(XmlDateTime xmlDateTime);

    void xsetMaxValue(XmlDouble xmlDouble);

    void xsetMinDate(XmlDateTime xmlDateTime);

    void xsetMinValue(XmlDouble xmlDouble);
}
