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
public interface CTSdtRun extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSdtRun.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsdtrun5c60type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSdtRun newInstance() {
            return (CTSdtRun) POIXMLTypeLoader.newInstance(CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun newInstance(XmlOptions xmlOptions) {
            return (CTSdtRun) POIXMLTypeLoader.newInstance(CTSdtRun.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtRun.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(File file) throws XmlException, IOException {
            return (CTSdtRun) POIXMLTypeLoader.parse(file, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtRun) POIXMLTypeLoader.parse(file, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSdtRun) POIXMLTypeLoader.parse(inputStream, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtRun) POIXMLTypeLoader.parse(inputStream, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(Reader reader) throws XmlException, IOException {
            return (CTSdtRun) POIXMLTypeLoader.parse(reader, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtRun) POIXMLTypeLoader.parse(reader, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(String str) throws XmlException {
            return (CTSdtRun) POIXMLTypeLoader.parse(str, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtRun) POIXMLTypeLoader.parse(str, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(URL url) throws XmlException, IOException {
            return (CTSdtRun) POIXMLTypeLoader.parse(url, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtRun) POIXMLTypeLoader.parse(url, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSdtRun) POIXMLTypeLoader.parse(xMLStreamReader, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtRun) POIXMLTypeLoader.parse(xMLStreamReader, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSdtRun) POIXMLTypeLoader.parse(xMLInputStream, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSdtRun) POIXMLTypeLoader.parse(xMLInputStream, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(Node node) throws XmlException {
            return (CTSdtRun) POIXMLTypeLoader.parse(node, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtRun) POIXMLTypeLoader.parse(node, CTSdtRun.type, xmlOptions);
        }
    }

    CTSdtContentRun addNewSdtContent();

    CTSdtEndPr addNewSdtEndPr();

    CTSdtPr addNewSdtPr();

    CTSdtContentRun getSdtContent();

    CTSdtEndPr getSdtEndPr();

    CTSdtPr getSdtPr();

    boolean isSetSdtContent();

    boolean isSetSdtEndPr();

    boolean isSetSdtPr();

    void setSdtContent(CTSdtContentRun cTSdtContentRun);

    void setSdtEndPr(CTSdtEndPr cTSdtEndPr);

    void setSdtPr(CTSdtPr cTSdtPr);

    void unsetSdtContent();

    void unsetSdtEndPr();

    void unsetSdtPr();
}
