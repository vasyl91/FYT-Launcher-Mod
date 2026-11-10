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
public interface CTTblGridBase extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTblGridBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttblgridbasea11dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblGridBase newInstance() {
            return (CTTblGridBase) POIXMLTypeLoader.newInstance(CTTblGridBase.type, (XmlOptions) null);
        }

        public static CTTblGridBase newInstance(XmlOptions xmlOptions) {
            return (CTTblGridBase) POIXMLTypeLoader.newInstance(CTTblGridBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblGridBase.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblGridBase.type, xmlOptions);
        }

        public static CTTblGridBase parse(File file) throws XmlException, IOException {
            return (CTTblGridBase) POIXMLTypeLoader.parse(file, CTTblGridBase.type, (XmlOptions) null);
        }

        public static CTTblGridBase parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblGridBase) POIXMLTypeLoader.parse(file, CTTblGridBase.type, xmlOptions);
        }

        public static CTTblGridBase parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTblGridBase) POIXMLTypeLoader.parse(inputStream, CTTblGridBase.type, (XmlOptions) null);
        }

        public static CTTblGridBase parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblGridBase) POIXMLTypeLoader.parse(inputStream, CTTblGridBase.type, xmlOptions);
        }

        public static CTTblGridBase parse(Reader reader) throws XmlException, IOException {
            return (CTTblGridBase) POIXMLTypeLoader.parse(reader, CTTblGridBase.type, (XmlOptions) null);
        }

        public static CTTblGridBase parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblGridBase) POIXMLTypeLoader.parse(reader, CTTblGridBase.type, xmlOptions);
        }

        public static CTTblGridBase parse(String str) throws XmlException {
            return (CTTblGridBase) POIXMLTypeLoader.parse(str, CTTblGridBase.type, (XmlOptions) null);
        }

        public static CTTblGridBase parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTblGridBase) POIXMLTypeLoader.parse(str, CTTblGridBase.type, xmlOptions);
        }

        public static CTTblGridBase parse(URL url) throws XmlException, IOException {
            return (CTTblGridBase) POIXMLTypeLoader.parse(url, CTTblGridBase.type, (XmlOptions) null);
        }

        public static CTTblGridBase parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblGridBase) POIXMLTypeLoader.parse(url, CTTblGridBase.type, xmlOptions);
        }

        public static CTTblGridBase parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTblGridBase) POIXMLTypeLoader.parse(xMLStreamReader, CTTblGridBase.type, (XmlOptions) null);
        }

        public static CTTblGridBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTblGridBase) POIXMLTypeLoader.parse(xMLStreamReader, CTTblGridBase.type, xmlOptions);
        }

        public static CTTblGridBase parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTblGridBase) POIXMLTypeLoader.parse(xMLInputStream, CTTblGridBase.type, (XmlOptions) null);
        }

        public static CTTblGridBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTblGridBase) POIXMLTypeLoader.parse(xMLInputStream, CTTblGridBase.type, xmlOptions);
        }

        public static CTTblGridBase parse(Node node) throws XmlException {
            return (CTTblGridBase) POIXMLTypeLoader.parse(node, CTTblGridBase.type, (XmlOptions) null);
        }

        public static CTTblGridBase parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTblGridBase) POIXMLTypeLoader.parse(node, CTTblGridBase.type, xmlOptions);
        }
    }

    CTTblGridCol addNewGridCol();

    CTTblGridCol getGridColArray(int i);

    CTTblGridCol[] getGridColArray();

    List<CTTblGridCol> getGridColList();

    CTTblGridCol insertNewGridCol(int i);

    void removeGridCol(int i);

    void setGridColArray(int i, CTTblGridCol cTTblGridCol);

    void setGridColArray(CTTblGridCol[] cTTblGridColArr);

    int sizeOfGridColArray();
}
