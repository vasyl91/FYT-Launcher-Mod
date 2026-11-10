package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTProofErr extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTProofErr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctprooferr1e07type");

    public static final class Factory {
        private Factory() {
        }

        public static CTProofErr newInstance() {
            return (CTProofErr) POIXMLTypeLoader.newInstance(CTProofErr.type, (XmlOptions) null);
        }

        public static CTProofErr newInstance(XmlOptions xmlOptions) {
            return (CTProofErr) POIXMLTypeLoader.newInstance(CTProofErr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTProofErr.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTProofErr.type, xmlOptions);
        }

        public static CTProofErr parse(File file) throws XmlException, IOException {
            return (CTProofErr) POIXMLTypeLoader.parse(file, CTProofErr.type, (XmlOptions) null);
        }

        public static CTProofErr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProofErr) POIXMLTypeLoader.parse(file, CTProofErr.type, xmlOptions);
        }

        public static CTProofErr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTProofErr) POIXMLTypeLoader.parse(inputStream, CTProofErr.type, (XmlOptions) null);
        }

        public static CTProofErr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProofErr) POIXMLTypeLoader.parse(inputStream, CTProofErr.type, xmlOptions);
        }

        public static CTProofErr parse(Reader reader) throws XmlException, IOException {
            return (CTProofErr) POIXMLTypeLoader.parse(reader, CTProofErr.type, (XmlOptions) null);
        }

        public static CTProofErr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProofErr) POIXMLTypeLoader.parse(reader, CTProofErr.type, xmlOptions);
        }

        public static CTProofErr parse(String str) throws XmlException {
            return (CTProofErr) POIXMLTypeLoader.parse(str, CTProofErr.type, (XmlOptions) null);
        }

        public static CTProofErr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTProofErr) POIXMLTypeLoader.parse(str, CTProofErr.type, xmlOptions);
        }

        public static CTProofErr parse(URL url) throws XmlException, IOException {
            return (CTProofErr) POIXMLTypeLoader.parse(url, CTProofErr.type, (XmlOptions) null);
        }

        public static CTProofErr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProofErr) POIXMLTypeLoader.parse(url, CTProofErr.type, xmlOptions);
        }

        public static CTProofErr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTProofErr) POIXMLTypeLoader.parse(xMLStreamReader, CTProofErr.type, (XmlOptions) null);
        }

        public static CTProofErr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTProofErr) POIXMLTypeLoader.parse(xMLStreamReader, CTProofErr.type, xmlOptions);
        }

        public static CTProofErr parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTProofErr) POIXMLTypeLoader.parse(xMLInputStream, CTProofErr.type, (XmlOptions) null);
        }

        public static CTProofErr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTProofErr) POIXMLTypeLoader.parse(xMLInputStream, CTProofErr.type, xmlOptions);
        }

        public static CTProofErr parse(Node node) throws XmlException {
            return (CTProofErr) POIXMLTypeLoader.parse(node, CTProofErr.type, (XmlOptions) null);
        }

        public static CTProofErr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTProofErr) POIXMLTypeLoader.parse(node, CTProofErr.type, xmlOptions);
        }
    }

    STProofErr$Enum getType();

    void setType(STProofErr$Enum sTProofErr$Enum);

    STProofErr xgetType();

    void xsetType(STProofErr sTProofErr);
}
