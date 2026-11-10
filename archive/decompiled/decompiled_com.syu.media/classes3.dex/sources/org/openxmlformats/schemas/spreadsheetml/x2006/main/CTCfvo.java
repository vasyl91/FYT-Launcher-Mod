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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTCfvo extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTCfvo.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcfvo7ca5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCfvo newInstance() {
            return (CTCfvo) POIXMLTypeLoader.newInstance(CTCfvo.type, (XmlOptions) null);
        }

        public static CTCfvo newInstance(XmlOptions xmlOptions) {
            return (CTCfvo) POIXMLTypeLoader.newInstance(CTCfvo.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCfvo.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCfvo.type, xmlOptions);
        }

        public static CTCfvo parse(File file) throws XmlException, IOException {
            return (CTCfvo) POIXMLTypeLoader.parse(file, CTCfvo.type, (XmlOptions) null);
        }

        public static CTCfvo parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCfvo) POIXMLTypeLoader.parse(file, CTCfvo.type, xmlOptions);
        }

        public static CTCfvo parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCfvo) POIXMLTypeLoader.parse(inputStream, CTCfvo.type, (XmlOptions) null);
        }

        public static CTCfvo parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCfvo) POIXMLTypeLoader.parse(inputStream, CTCfvo.type, xmlOptions);
        }

        public static CTCfvo parse(Reader reader) throws XmlException, IOException {
            return (CTCfvo) POIXMLTypeLoader.parse(reader, CTCfvo.type, (XmlOptions) null);
        }

        public static CTCfvo parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCfvo) POIXMLTypeLoader.parse(reader, CTCfvo.type, xmlOptions);
        }

        public static CTCfvo parse(String str) throws XmlException {
            return (CTCfvo) POIXMLTypeLoader.parse(str, CTCfvo.type, (XmlOptions) null);
        }

        public static CTCfvo parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCfvo) POIXMLTypeLoader.parse(str, CTCfvo.type, xmlOptions);
        }

        public static CTCfvo parse(URL url) throws XmlException, IOException {
            return (CTCfvo) POIXMLTypeLoader.parse(url, CTCfvo.type, (XmlOptions) null);
        }

        public static CTCfvo parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCfvo) POIXMLTypeLoader.parse(url, CTCfvo.type, xmlOptions);
        }

        public static CTCfvo parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCfvo) POIXMLTypeLoader.parse(xMLStreamReader, CTCfvo.type, (XmlOptions) null);
        }

        public static CTCfvo parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCfvo) POIXMLTypeLoader.parse(xMLStreamReader, CTCfvo.type, xmlOptions);
        }

        public static CTCfvo parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTCfvo) POIXMLTypeLoader.parse(xMLInputStream, CTCfvo.type, (XmlOptions) null);
        }

        public static CTCfvo parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTCfvo) POIXMLTypeLoader.parse(xMLInputStream, CTCfvo.type, xmlOptions);
        }

        public static CTCfvo parse(Node node) throws XmlException {
            return (CTCfvo) POIXMLTypeLoader.parse(node, CTCfvo.type, (XmlOptions) null);
        }

        public static CTCfvo parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCfvo) POIXMLTypeLoader.parse(node, CTCfvo.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTExtensionList getExtLst();

    boolean getGte();

    STCfvoType.Enum getType();

    String getVal();

    boolean isSetExtLst();

    boolean isSetGte();

    boolean isSetVal();

    void setExtLst(CTExtensionList cTExtensionList);

    void setGte(boolean z);

    void setType(STCfvoType.Enum r1);

    void setVal(String str);

    void unsetExtLst();

    void unsetGte();

    void unsetVal();

    XmlBoolean xgetGte();

    STCfvoType xgetType();

    STXstring xgetVal();

    void xsetGte(XmlBoolean xmlBoolean);

    void xsetType(STCfvoType sTCfvoType);

    void xsetVal(STXstring sTXstring);
}
