package org.openxmlformats.schemas.drawingml.x2006.picture;

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
public interface PicDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(PicDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("pic8010doctype");

    public static final class Factory {
        private Factory() {
        }

        public static PicDocument newInstance() {
            return (PicDocument) POIXMLTypeLoader.newInstance(PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument newInstance(XmlOptions xmlOptions) {
            return (PicDocument) POIXMLTypeLoader.newInstance(PicDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PicDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(File file) throws XmlException, IOException {
            return (PicDocument) POIXMLTypeLoader.parse(file, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PicDocument) POIXMLTypeLoader.parse(file, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (PicDocument) POIXMLTypeLoader.parse(inputStream, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PicDocument) POIXMLTypeLoader.parse(inputStream, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(Reader reader) throws XmlException, IOException {
            return (PicDocument) POIXMLTypeLoader.parse(reader, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PicDocument) POIXMLTypeLoader.parse(reader, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(String str) throws XmlException {
            return (PicDocument) POIXMLTypeLoader.parse(str, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (PicDocument) POIXMLTypeLoader.parse(str, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(URL url) throws XmlException, IOException {
            return (PicDocument) POIXMLTypeLoader.parse(url, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PicDocument) POIXMLTypeLoader.parse(url, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (PicDocument) POIXMLTypeLoader.parse(xMLStreamReader, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (PicDocument) POIXMLTypeLoader.parse(xMLStreamReader, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (PicDocument) POIXMLTypeLoader.parse(xMLInputStream, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (PicDocument) POIXMLTypeLoader.parse(xMLInputStream, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(Node node) throws XmlException {
            return (PicDocument) POIXMLTypeLoader.parse(node, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (PicDocument) POIXMLTypeLoader.parse(node, PicDocument.type, xmlOptions);
        }
    }

    CTPicture addNewPic();

    CTPicture getPic();

    void setPic(CTPicture cTPicture);
}
