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
public interface CTSdtBlock extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSdtBlock.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsdtblock221etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSdtBlock newInstance() {
            return (CTSdtBlock) POIXMLTypeLoader.newInstance(CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock newInstance(XmlOptions xmlOptions) {
            return (CTSdtBlock) POIXMLTypeLoader.newInstance(CTSdtBlock.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtBlock.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(File file) throws XmlException, IOException {
            return (CTSdtBlock) POIXMLTypeLoader.parse(file, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtBlock) POIXMLTypeLoader.parse(file, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSdtBlock) POIXMLTypeLoader.parse(inputStream, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtBlock) POIXMLTypeLoader.parse(inputStream, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(Reader reader) throws XmlException, IOException {
            return (CTSdtBlock) POIXMLTypeLoader.parse(reader, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtBlock) POIXMLTypeLoader.parse(reader, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(String str) throws XmlException {
            return (CTSdtBlock) POIXMLTypeLoader.parse(str, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtBlock) POIXMLTypeLoader.parse(str, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(URL url) throws XmlException, IOException {
            return (CTSdtBlock) POIXMLTypeLoader.parse(url, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSdtBlock) POIXMLTypeLoader.parse(url, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSdtBlock) POIXMLTypeLoader.parse(xMLStreamReader, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtBlock) POIXMLTypeLoader.parse(xMLStreamReader, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSdtBlock) POIXMLTypeLoader.parse(xMLInputStream, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSdtBlock) POIXMLTypeLoader.parse(xMLInputStream, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(Node node) throws XmlException {
            return (CTSdtBlock) POIXMLTypeLoader.parse(node, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSdtBlock) POIXMLTypeLoader.parse(node, CTSdtBlock.type, xmlOptions);
        }
    }

    CTSdtContentBlock addNewSdtContent();

    CTSdtEndPr addNewSdtEndPr();

    CTSdtPr addNewSdtPr();

    CTSdtContentBlock getSdtContent();

    CTSdtEndPr getSdtEndPr();

    CTSdtPr getSdtPr();

    boolean isSetSdtContent();

    boolean isSetSdtEndPr();

    boolean isSetSdtPr();

    void setSdtContent(CTSdtContentBlock cTSdtContentBlock);

    void setSdtEndPr(CTSdtEndPr cTSdtEndPr);

    void setSdtPr(CTSdtPr cTSdtPr);

    void unsetSdtContent();

    void unsetSdtEndPr();

    void unsetSdtPr();
}
