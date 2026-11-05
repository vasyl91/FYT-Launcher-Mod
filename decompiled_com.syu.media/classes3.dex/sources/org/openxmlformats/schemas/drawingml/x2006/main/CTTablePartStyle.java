package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTTablePartStyle extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTablePartStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablepartstylef22btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTablePartStyle newInstance() {
            return (CTTablePartStyle) POIXMLTypeLoader.newInstance(CTTablePartStyle.type, (XmlOptions) null);
        }

        public static CTTablePartStyle newInstance(XmlOptions xmlOptions) {
            return (CTTablePartStyle) POIXMLTypeLoader.newInstance(CTTablePartStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTablePartStyle.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTablePartStyle.type, xmlOptions);
        }

        public static CTTablePartStyle parse(File file) throws XmlException, IOException {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(file, CTTablePartStyle.type, (XmlOptions) null);
        }

        public static CTTablePartStyle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(file, CTTablePartStyle.type, xmlOptions);
        }

        public static CTTablePartStyle parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(inputStream, CTTablePartStyle.type, (XmlOptions) null);
        }

        public static CTTablePartStyle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(inputStream, CTTablePartStyle.type, xmlOptions);
        }

        public static CTTablePartStyle parse(Reader reader) throws XmlException, IOException {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(reader, CTTablePartStyle.type, (XmlOptions) null);
        }

        public static CTTablePartStyle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(reader, CTTablePartStyle.type, xmlOptions);
        }

        public static CTTablePartStyle parse(String str) throws XmlException {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(str, CTTablePartStyle.type, (XmlOptions) null);
        }

        public static CTTablePartStyle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(str, CTTablePartStyle.type, xmlOptions);
        }

        public static CTTablePartStyle parse(URL url) throws XmlException, IOException {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(url, CTTablePartStyle.type, (XmlOptions) null);
        }

        public static CTTablePartStyle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(url, CTTablePartStyle.type, xmlOptions);
        }

        public static CTTablePartStyle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTTablePartStyle.type, (XmlOptions) null);
        }

        public static CTTablePartStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTTablePartStyle.type, xmlOptions);
        }

        public static CTTablePartStyle parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(xMLInputStream, CTTablePartStyle.type, (XmlOptions) null);
        }

        public static CTTablePartStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(xMLInputStream, CTTablePartStyle.type, xmlOptions);
        }

        public static CTTablePartStyle parse(Node node) throws XmlException {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(node, CTTablePartStyle.type, (XmlOptions) null);
        }

        public static CTTablePartStyle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(node, CTTablePartStyle.type, xmlOptions);
        }
    }

    CTTableStyleCellStyle addNewTcStyle();

    CTTableStyleTextStyle addNewTcTxStyle();

    CTTableStyleCellStyle getTcStyle();

    CTTableStyleTextStyle getTcTxStyle();

    boolean isSetTcStyle();

    boolean isSetTcTxStyle();

    void setTcStyle(CTTableStyleCellStyle cTTableStyleCellStyle);

    void setTcTxStyle(CTTableStyleTextStyle cTTableStyleTextStyle);

    void unsetTcStyle();

    void unsetTcTxStyle();
}
