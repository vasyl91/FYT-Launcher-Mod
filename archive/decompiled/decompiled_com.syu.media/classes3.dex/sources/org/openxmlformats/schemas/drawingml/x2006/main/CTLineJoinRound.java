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
public interface CTLineJoinRound extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTLineJoinRound.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlinejoinround7be1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLineJoinRound newInstance() {
            return (CTLineJoinRound) POIXMLTypeLoader.newInstance(CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound newInstance(XmlOptions xmlOptions) {
            return (CTLineJoinRound) POIXMLTypeLoader.newInstance(CTLineJoinRound.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(File file) throws XmlException, IOException {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(file, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(file, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(inputStream, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(inputStream, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(Reader reader) throws XmlException, IOException {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(reader, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(reader, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(String str) throws XmlException {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(str, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(str, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(URL url) throws XmlException, IOException {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(url, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(url, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(xMLStreamReader, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(xMLStreamReader, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(xMLInputStream, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(xMLInputStream, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(Node node) throws XmlException {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(node, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(node, CTLineJoinRound.type, xmlOptions);
        }
    }
}
