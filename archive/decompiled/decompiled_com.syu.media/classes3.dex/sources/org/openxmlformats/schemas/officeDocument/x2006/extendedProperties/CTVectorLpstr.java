package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties;

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
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTVectorLpstr extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTVectorLpstr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctvectorlpstr9b1dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTVectorLpstr newInstance() {
            return (CTVectorLpstr) POIXMLTypeLoader.newInstance(CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr newInstance(XmlOptions xmlOptions) {
            return (CTVectorLpstr) POIXMLTypeLoader.newInstance(CTVectorLpstr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(File file) throws XmlException, IOException {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(file, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(file, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(inputStream, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(inputStream, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(Reader reader) throws XmlException, IOException {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(reader, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(reader, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(String str) throws XmlException {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(str, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(str, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(URL url) throws XmlException, IOException {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(url, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(url, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(xMLStreamReader, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(xMLStreamReader, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(xMLInputStream, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(xMLInputStream, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(Node node) throws XmlException {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(node, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(node, CTVectorLpstr.type, xmlOptions);
        }
    }

    CTVector addNewVector();

    CTVector getVector();

    void setVector(CTVector cTVector);
}
