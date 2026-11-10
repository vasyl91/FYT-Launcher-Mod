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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTXmlPr extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTXmlPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctxmlpr2c58type");

    public static final class Factory {
        private Factory() {
        }

        public static CTXmlPr newInstance() {
            return (CTXmlPr) POIXMLTypeLoader.newInstance(CTXmlPr.type, (XmlOptions) null);
        }

        public static CTXmlPr newInstance(XmlOptions xmlOptions) {
            return (CTXmlPr) POIXMLTypeLoader.newInstance(CTXmlPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTXmlPr.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTXmlPr.type, xmlOptions);
        }

        public static CTXmlPr parse(File file) throws XmlException, IOException {
            return (CTXmlPr) POIXMLTypeLoader.parse(file, CTXmlPr.type, (XmlOptions) null);
        }

        public static CTXmlPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlPr) POIXMLTypeLoader.parse(file, CTXmlPr.type, xmlOptions);
        }

        public static CTXmlPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTXmlPr) POIXMLTypeLoader.parse(inputStream, CTXmlPr.type, (XmlOptions) null);
        }

        public static CTXmlPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlPr) POIXMLTypeLoader.parse(inputStream, CTXmlPr.type, xmlOptions);
        }

        public static CTXmlPr parse(Reader reader) throws XmlException, IOException {
            return (CTXmlPr) POIXMLTypeLoader.parse(reader, CTXmlPr.type, (XmlOptions) null);
        }

        public static CTXmlPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlPr) POIXMLTypeLoader.parse(reader, CTXmlPr.type, xmlOptions);
        }

        public static CTXmlPr parse(String str) throws XmlException {
            return (CTXmlPr) POIXMLTypeLoader.parse(str, CTXmlPr.type, (XmlOptions) null);
        }

        public static CTXmlPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTXmlPr) POIXMLTypeLoader.parse(str, CTXmlPr.type, xmlOptions);
        }

        public static CTXmlPr parse(URL url) throws XmlException, IOException {
            return (CTXmlPr) POIXMLTypeLoader.parse(url, CTXmlPr.type, (XmlOptions) null);
        }

        public static CTXmlPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlPr) POIXMLTypeLoader.parse(url, CTXmlPr.type, xmlOptions);
        }

        public static CTXmlPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTXmlPr) POIXMLTypeLoader.parse(xMLStreamReader, CTXmlPr.type, (XmlOptions) null);
        }

        public static CTXmlPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTXmlPr) POIXMLTypeLoader.parse(xMLStreamReader, CTXmlPr.type, xmlOptions);
        }

        public static CTXmlPr parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTXmlPr) POIXMLTypeLoader.parse(xMLInputStream, CTXmlPr.type, (XmlOptions) null);
        }

        public static CTXmlPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTXmlPr) POIXMLTypeLoader.parse(xMLInputStream, CTXmlPr.type, xmlOptions);
        }

        public static CTXmlPr parse(Node node) throws XmlException {
            return (CTXmlPr) POIXMLTypeLoader.parse(node, CTXmlPr.type, (XmlOptions) null);
        }

        public static CTXmlPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTXmlPr) POIXMLTypeLoader.parse(node, CTXmlPr.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTExtensionList getExtLst();

    long getMapId();

    STXmlDataType.Enum getXmlDataType();

    String getXpath();

    boolean isSetExtLst();

    void setExtLst(CTExtensionList cTExtensionList);

    void setMapId(long j);

    void setXmlDataType(STXmlDataType.Enum r1);

    void setXpath(String str);

    void unsetExtLst();

    XmlUnsignedInt xgetMapId();

    STXmlDataType xgetXmlDataType();

    STXstring xgetXpath();

    void xsetMapId(XmlUnsignedInt xmlUnsignedInt);

    void xsetXmlDataType(STXmlDataType sTXmlDataType);

    void xsetXpath(STXstring sTXstring);
}
