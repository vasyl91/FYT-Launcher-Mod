package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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
public interface CTSmartTagPr extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSmartTagPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsmarttagprf715type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSmartTagPr newInstance() {
            return (CTSmartTagPr) POIXMLTypeLoader.newInstance(CTSmartTagPr.type, (XmlOptions) null);
        }

        public static CTSmartTagPr newInstance(XmlOptions xmlOptions) {
            return (CTSmartTagPr) POIXMLTypeLoader.newInstance(CTSmartTagPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSmartTagPr.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSmartTagPr.type, xmlOptions);
        }

        public static CTSmartTagPr parse(File file) throws XmlException, IOException {
            return (CTSmartTagPr) POIXMLTypeLoader.parse(file, CTSmartTagPr.type, (XmlOptions) null);
        }

        public static CTSmartTagPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSmartTagPr) POIXMLTypeLoader.parse(file, CTSmartTagPr.type, xmlOptions);
        }

        public static CTSmartTagPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSmartTagPr) POIXMLTypeLoader.parse(inputStream, CTSmartTagPr.type, (XmlOptions) null);
        }

        public static CTSmartTagPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSmartTagPr) POIXMLTypeLoader.parse(inputStream, CTSmartTagPr.type, xmlOptions);
        }

        public static CTSmartTagPr parse(Reader reader) throws XmlException, IOException {
            return (CTSmartTagPr) POIXMLTypeLoader.parse(reader, CTSmartTagPr.type, (XmlOptions) null);
        }

        public static CTSmartTagPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSmartTagPr) POIXMLTypeLoader.parse(reader, CTSmartTagPr.type, xmlOptions);
        }

        public static CTSmartTagPr parse(String str) throws XmlException {
            return (CTSmartTagPr) POIXMLTypeLoader.parse(str, CTSmartTagPr.type, (XmlOptions) null);
        }

        public static CTSmartTagPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSmartTagPr) POIXMLTypeLoader.parse(str, CTSmartTagPr.type, xmlOptions);
        }

        public static CTSmartTagPr parse(URL url) throws XmlException, IOException {
            return (CTSmartTagPr) POIXMLTypeLoader.parse(url, CTSmartTagPr.type, (XmlOptions) null);
        }

        public static CTSmartTagPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSmartTagPr) POIXMLTypeLoader.parse(url, CTSmartTagPr.type, xmlOptions);
        }

        public static CTSmartTagPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSmartTagPr) POIXMLTypeLoader.parse(xMLStreamReader, CTSmartTagPr.type, (XmlOptions) null);
        }

        public static CTSmartTagPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSmartTagPr) POIXMLTypeLoader.parse(xMLStreamReader, CTSmartTagPr.type, xmlOptions);
        }

        public static CTSmartTagPr parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSmartTagPr) POIXMLTypeLoader.parse(xMLInputStream, CTSmartTagPr.type, (XmlOptions) null);
        }

        public static CTSmartTagPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSmartTagPr) POIXMLTypeLoader.parse(xMLInputStream, CTSmartTagPr.type, xmlOptions);
        }

        public static CTSmartTagPr parse(Node node) throws XmlException {
            return (CTSmartTagPr) POIXMLTypeLoader.parse(node, CTSmartTagPr.type, (XmlOptions) null);
        }

        public static CTSmartTagPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSmartTagPr) POIXMLTypeLoader.parse(node, CTSmartTagPr.type, xmlOptions);
        }
    }

    CTAttr addNewAttr();

    CTAttr getAttrArray(int i);

    CTAttr[] getAttrArray();

    List<CTAttr> getAttrList();

    CTAttr insertNewAttr(int i);

    void removeAttr(int i);

    void setAttrArray(int i, CTAttr cTAttr);

    void setAttrArray(CTAttr[] cTAttrArr);

    int sizeOfAttrArray();
}
