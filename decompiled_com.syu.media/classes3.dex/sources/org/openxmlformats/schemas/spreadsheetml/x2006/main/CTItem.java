package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTItem extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTItem.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctitemc69ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTItem newInstance() {
            return (CTItem) POIXMLTypeLoader.newInstance(CTItem.type, (XmlOptions) null);
        }

        public static CTItem newInstance(XmlOptions xmlOptions) {
            return (CTItem) POIXMLTypeLoader.newInstance(CTItem.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTItem.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTItem.type, xmlOptions);
        }

        public static CTItem parse(File file) throws XmlException, IOException {
            return (CTItem) POIXMLTypeLoader.parse(file, CTItem.type, (XmlOptions) null);
        }

        public static CTItem parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTItem) POIXMLTypeLoader.parse(file, CTItem.type, xmlOptions);
        }

        public static CTItem parse(InputStream inputStream) throws XmlException, IOException {
            return (CTItem) POIXMLTypeLoader.parse(inputStream, CTItem.type, (XmlOptions) null);
        }

        public static CTItem parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTItem) POIXMLTypeLoader.parse(inputStream, CTItem.type, xmlOptions);
        }

        public static CTItem parse(Reader reader) throws XmlException, IOException {
            return (CTItem) POIXMLTypeLoader.parse(reader, CTItem.type, (XmlOptions) null);
        }

        public static CTItem parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTItem) POIXMLTypeLoader.parse(reader, CTItem.type, xmlOptions);
        }

        public static CTItem parse(String str) throws XmlException {
            return (CTItem) POIXMLTypeLoader.parse(str, CTItem.type, (XmlOptions) null);
        }

        public static CTItem parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTItem) POIXMLTypeLoader.parse(str, CTItem.type, xmlOptions);
        }

        public static CTItem parse(URL url) throws XmlException, IOException {
            return (CTItem) POIXMLTypeLoader.parse(url, CTItem.type, (XmlOptions) null);
        }

        public static CTItem parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTItem) POIXMLTypeLoader.parse(url, CTItem.type, xmlOptions);
        }

        public static CTItem parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTItem) POIXMLTypeLoader.parse(xMLStreamReader, CTItem.type, (XmlOptions) null);
        }

        public static CTItem parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTItem) POIXMLTypeLoader.parse(xMLStreamReader, CTItem.type, xmlOptions);
        }

        public static CTItem parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTItem) POIXMLTypeLoader.parse(xMLInputStream, CTItem.type, (XmlOptions) null);
        }

        public static CTItem parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTItem) POIXMLTypeLoader.parse(xMLInputStream, CTItem.type, xmlOptions);
        }

        public static CTItem parse(Node node) throws XmlException {
            return (CTItem) POIXMLTypeLoader.parse(node, CTItem.type, (XmlOptions) null);
        }

        public static CTItem parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTItem) POIXMLTypeLoader.parse(node, CTItem.type, xmlOptions);
        }
    }

    boolean getC();

    boolean getD();

    boolean getE();

    boolean getF();

    boolean getH();

    boolean getM();

    String getN();

    boolean getS();

    boolean getSd();

    STItemType.Enum getT();

    long getX();

    boolean isSetC();

    boolean isSetD();

    boolean isSetE();

    boolean isSetF();

    boolean isSetH();

    boolean isSetM();

    boolean isSetN();

    boolean isSetS();

    boolean isSetSd();

    boolean isSetT();

    boolean isSetX();

    void setC(boolean z);

    void setD(boolean z);

    void setE(boolean z);

    void setF(boolean z);

    void setH(boolean z);

    void setM(boolean z);

    void setN(String str);

    void setS(boolean z);

    void setSd(boolean z);

    void setT(STItemType.Enum r1);

    void setX(long j);

    void unsetC();

    void unsetD();

    void unsetE();

    void unsetF();

    void unsetH();

    void unsetM();

    void unsetN();

    void unsetS();

    void unsetSd();

    void unsetT();

    void unsetX();

    XmlBoolean xgetC();

    XmlBoolean xgetD();

    XmlBoolean xgetE();

    XmlBoolean xgetF();

    XmlBoolean xgetH();

    XmlBoolean xgetM();

    STXstring xgetN();

    XmlBoolean xgetS();

    XmlBoolean xgetSd();

    STItemType xgetT();

    XmlUnsignedInt xgetX();

    void xsetC(XmlBoolean xmlBoolean);

    void xsetD(XmlBoolean xmlBoolean);

    void xsetE(XmlBoolean xmlBoolean);

    void xsetF(XmlBoolean xmlBoolean);

    void xsetH(XmlBoolean xmlBoolean);

    void xsetM(XmlBoolean xmlBoolean);

    void xsetN(STXstring sTXstring);

    void xsetS(XmlBoolean xmlBoolean);

    void xsetSd(XmlBoolean xmlBoolean);

    void xsetT(STItemType sTItemType);

    void xsetX(XmlUnsignedInt xmlUnsignedInt);
}
