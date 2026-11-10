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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTTrPr extends CTTrPrBase {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTrPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttrpr2848type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTrPr newInstance() {
            return (CTTrPr) POIXMLTypeLoader.newInstance(CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr newInstance(XmlOptions xmlOptions) {
            return (CTTrPr) POIXMLTypeLoader.newInstance(CTTrPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTrPr.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(File file) throws XmlException, IOException {
            return (CTTrPr) POIXMLTypeLoader.parse(file, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrPr) POIXMLTypeLoader.parse(file, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTrPr) POIXMLTypeLoader.parse(inputStream, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrPr) POIXMLTypeLoader.parse(inputStream, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(Reader reader) throws XmlException, IOException {
            return (CTTrPr) POIXMLTypeLoader.parse(reader, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrPr) POIXMLTypeLoader.parse(reader, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(String str) throws XmlException {
            return (CTTrPr) POIXMLTypeLoader.parse(str, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTrPr) POIXMLTypeLoader.parse(str, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(URL url) throws XmlException, IOException {
            return (CTTrPr) POIXMLTypeLoader.parse(url, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrPr) POIXMLTypeLoader.parse(url, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTrPr) POIXMLTypeLoader.parse(xMLStreamReader, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTrPr) POIXMLTypeLoader.parse(xMLStreamReader, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTrPr) POIXMLTypeLoader.parse(xMLInputStream, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTrPr) POIXMLTypeLoader.parse(xMLInputStream, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(Node node) throws XmlException {
            return (CTTrPr) POIXMLTypeLoader.parse(node, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTrPr) POIXMLTypeLoader.parse(node, CTTrPr.type, xmlOptions);
        }
    }

    CTTrackChange addNewDel();

    CTTrackChange addNewIns();

    CTTrPrChange addNewTrPrChange();

    CTTrackChange getDel();

    CTTrackChange getIns();

    CTTrPrChange getTrPrChange();

    boolean isSetDel();

    boolean isSetIns();

    boolean isSetTrPrChange();

    void setDel(CTTrackChange cTTrackChange);

    void setIns(CTTrackChange cTTrackChange);

    void setTrPrChange(CTTrPrChange cTTrPrChange);

    void unsetDel();

    void unsetIns();

    void unsetTrPrChange();
}
