package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

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
public interface CTAnchorClientData extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTAnchorClientData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctanchorclientdata02betype");

    public static final class Factory {
        private Factory() {
        }

        public static CTAnchorClientData newInstance() {
            return (CTAnchorClientData) POIXMLTypeLoader.newInstance(CTAnchorClientData.type, (XmlOptions) null);
        }

        public static CTAnchorClientData newInstance(XmlOptions xmlOptions) {
            return (CTAnchorClientData) POIXMLTypeLoader.newInstance(CTAnchorClientData.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAnchorClientData.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAnchorClientData.type, xmlOptions);
        }

        public static CTAnchorClientData parse(File file) throws XmlException, IOException {
            return (CTAnchorClientData) POIXMLTypeLoader.parse(file, CTAnchorClientData.type, (XmlOptions) null);
        }

        public static CTAnchorClientData parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAnchorClientData) POIXMLTypeLoader.parse(file, CTAnchorClientData.type, xmlOptions);
        }

        public static CTAnchorClientData parse(InputStream inputStream) throws XmlException, IOException {
            return (CTAnchorClientData) POIXMLTypeLoader.parse(inputStream, CTAnchorClientData.type, (XmlOptions) null);
        }

        public static CTAnchorClientData parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAnchorClientData) POIXMLTypeLoader.parse(inputStream, CTAnchorClientData.type, xmlOptions);
        }

        public static CTAnchorClientData parse(Reader reader) throws XmlException, IOException {
            return (CTAnchorClientData) POIXMLTypeLoader.parse(reader, CTAnchorClientData.type, (XmlOptions) null);
        }

        public static CTAnchorClientData parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAnchorClientData) POIXMLTypeLoader.parse(reader, CTAnchorClientData.type, xmlOptions);
        }

        public static CTAnchorClientData parse(String str) throws XmlException {
            return (CTAnchorClientData) POIXMLTypeLoader.parse(str, CTAnchorClientData.type, (XmlOptions) null);
        }

        public static CTAnchorClientData parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTAnchorClientData) POIXMLTypeLoader.parse(str, CTAnchorClientData.type, xmlOptions);
        }

        public static CTAnchorClientData parse(URL url) throws XmlException, IOException {
            return (CTAnchorClientData) POIXMLTypeLoader.parse(url, CTAnchorClientData.type, (XmlOptions) null);
        }

        public static CTAnchorClientData parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAnchorClientData) POIXMLTypeLoader.parse(url, CTAnchorClientData.type, xmlOptions);
        }

        public static CTAnchorClientData parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTAnchorClientData) POIXMLTypeLoader.parse(xMLStreamReader, CTAnchorClientData.type, (XmlOptions) null);
        }

        public static CTAnchorClientData parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTAnchorClientData) POIXMLTypeLoader.parse(xMLStreamReader, CTAnchorClientData.type, xmlOptions);
        }

        public static CTAnchorClientData parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTAnchorClientData) POIXMLTypeLoader.parse(xMLInputStream, CTAnchorClientData.type, (XmlOptions) null);
        }

        public static CTAnchorClientData parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTAnchorClientData) POIXMLTypeLoader.parse(xMLInputStream, CTAnchorClientData.type, xmlOptions);
        }

        public static CTAnchorClientData parse(Node node) throws XmlException {
            return (CTAnchorClientData) POIXMLTypeLoader.parse(node, CTAnchorClientData.type, (XmlOptions) null);
        }

        public static CTAnchorClientData parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTAnchorClientData) POIXMLTypeLoader.parse(node, CTAnchorClientData.type, xmlOptions);
        }
    }

    boolean getFLocksWithSheet();

    boolean getFPrintsWithSheet();

    boolean isSetFLocksWithSheet();

    boolean isSetFPrintsWithSheet();

    void setFLocksWithSheet(boolean z);

    void setFPrintsWithSheet(boolean z);

    void unsetFLocksWithSheet();

    void unsetFPrintsWithSheet();

    XmlBoolean xgetFLocksWithSheet();

    XmlBoolean xgetFPrintsWithSheet();

    void xsetFLocksWithSheet(XmlBoolean xmlBoolean);

    void xsetFPrintsWithSheet(XmlBoolean xmlBoolean);
}
