package org.openxmlformats.schemas.presentationml.x2006.main;

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
public interface SldMasterDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SldMasterDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sldmaster5156doctype");

    public static final class Factory {
        private Factory() {
        }

        public static SldMasterDocument newInstance() {
            return (SldMasterDocument) POIXMLTypeLoader.newInstance(SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument newInstance(XmlOptions xmlOptions) {
            return (SldMasterDocument) POIXMLTypeLoader.newInstance(SldMasterDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SldMasterDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(File file) throws XmlException, IOException {
            return (SldMasterDocument) POIXMLTypeLoader.parse(file, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldMasterDocument) POIXMLTypeLoader.parse(file, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SldMasterDocument) POIXMLTypeLoader.parse(inputStream, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldMasterDocument) POIXMLTypeLoader.parse(inputStream, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(Reader reader) throws XmlException, IOException {
            return (SldMasterDocument) POIXMLTypeLoader.parse(reader, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldMasterDocument) POIXMLTypeLoader.parse(reader, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(String str) throws XmlException {
            return (SldMasterDocument) POIXMLTypeLoader.parse(str, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SldMasterDocument) POIXMLTypeLoader.parse(str, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(URL url) throws XmlException, IOException {
            return (SldMasterDocument) POIXMLTypeLoader.parse(url, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldMasterDocument) POIXMLTypeLoader.parse(url, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SldMasterDocument) POIXMLTypeLoader.parse(xMLStreamReader, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SldMasterDocument) POIXMLTypeLoader.parse(xMLStreamReader, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SldMasterDocument) POIXMLTypeLoader.parse(xMLInputStream, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SldMasterDocument) POIXMLTypeLoader.parse(xMLInputStream, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(Node node) throws XmlException {
            return (SldMasterDocument) POIXMLTypeLoader.parse(node, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SldMasterDocument) POIXMLTypeLoader.parse(node, SldMasterDocument.type, xmlOptions);
        }
    }

    CTSlideMaster addNewSldMaster();

    CTSlideMaster getSldMaster();

    void setSldMaster(CTSlideMaster cTSlideMaster);
}
