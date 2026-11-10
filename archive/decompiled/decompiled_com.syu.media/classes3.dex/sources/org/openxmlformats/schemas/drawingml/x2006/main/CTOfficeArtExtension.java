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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTOfficeArtExtension extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTOfficeArtExtension.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctofficeartextension8e53type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOfficeArtExtension newInstance() {
            return (CTOfficeArtExtension) POIXMLTypeLoader.newInstance(CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension newInstance(XmlOptions xmlOptions) {
            return (CTOfficeArtExtension) POIXMLTypeLoader.newInstance(CTOfficeArtExtension.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(File file) throws XmlException, IOException {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(file, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(file, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(InputStream inputStream) throws XmlException, IOException {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(inputStream, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(inputStream, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(Reader reader) throws XmlException, IOException {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(reader, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(reader, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(String str) throws XmlException {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(str, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(str, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(URL url) throws XmlException, IOException {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(url, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(url, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(xMLStreamReader, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(xMLStreamReader, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(xMLInputStream, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(xMLInputStream, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(Node node) throws XmlException {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(node, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(node, CTOfficeArtExtension.type, xmlOptions);
        }
    }

    String getUri();

    boolean isSetUri();

    void setUri(String str);

    void unsetUri();

    XmlToken xgetUri();

    void xsetUri(XmlToken xmlToken);
}
