package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
public interface SingleXmlCellsDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SingleXmlCellsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("singlexmlcells33bfdoctype");

    public static final class Factory {
        private Factory() {
        }

        public static SingleXmlCellsDocument newInstance() {
            return (SingleXmlCellsDocument) POIXMLTypeLoader.newInstance(SingleXmlCellsDocument.type, (XmlOptions) null);
        }

        public static SingleXmlCellsDocument newInstance(XmlOptions xmlOptions) {
            return (SingleXmlCellsDocument) POIXMLTypeLoader.newInstance(SingleXmlCellsDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SingleXmlCellsDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SingleXmlCellsDocument.type, xmlOptions);
        }

        public static SingleXmlCellsDocument parse(File file) throws XmlException, IOException {
            return (SingleXmlCellsDocument) POIXMLTypeLoader.parse(file, SingleXmlCellsDocument.type, (XmlOptions) null);
        }

        public static SingleXmlCellsDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SingleXmlCellsDocument) POIXMLTypeLoader.parse(file, SingleXmlCellsDocument.type, xmlOptions);
        }

        public static SingleXmlCellsDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SingleXmlCellsDocument) POIXMLTypeLoader.parse(inputStream, SingleXmlCellsDocument.type, (XmlOptions) null);
        }

        public static SingleXmlCellsDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SingleXmlCellsDocument) POIXMLTypeLoader.parse(inputStream, SingleXmlCellsDocument.type, xmlOptions);
        }

        public static SingleXmlCellsDocument parse(Reader reader) throws XmlException, IOException {
            return (SingleXmlCellsDocument) POIXMLTypeLoader.parse(reader, SingleXmlCellsDocument.type, (XmlOptions) null);
        }

        public static SingleXmlCellsDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SingleXmlCellsDocument) POIXMLTypeLoader.parse(reader, SingleXmlCellsDocument.type, xmlOptions);
        }

        public static SingleXmlCellsDocument parse(String str) throws XmlException {
            return (SingleXmlCellsDocument) POIXMLTypeLoader.parse(str, SingleXmlCellsDocument.type, (XmlOptions) null);
        }

        public static SingleXmlCellsDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SingleXmlCellsDocument) POIXMLTypeLoader.parse(str, SingleXmlCellsDocument.type, xmlOptions);
        }

        public static SingleXmlCellsDocument parse(URL url) throws XmlException, IOException {
            return (SingleXmlCellsDocument) POIXMLTypeLoader.parse(url, SingleXmlCellsDocument.type, (XmlOptions) null);
        }

        public static SingleXmlCellsDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SingleXmlCellsDocument) POIXMLTypeLoader.parse(url, SingleXmlCellsDocument.type, xmlOptions);
        }

        public static SingleXmlCellsDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SingleXmlCellsDocument) POIXMLTypeLoader.parse(xMLStreamReader, SingleXmlCellsDocument.type, (XmlOptions) null);
        }

        public static SingleXmlCellsDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SingleXmlCellsDocument) POIXMLTypeLoader.parse(xMLStreamReader, SingleXmlCellsDocument.type, xmlOptions);
        }

        public static SingleXmlCellsDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SingleXmlCellsDocument) POIXMLTypeLoader.parse(xMLInputStream, SingleXmlCellsDocument.type, (XmlOptions) null);
        }

        public static SingleXmlCellsDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SingleXmlCellsDocument) POIXMLTypeLoader.parse(xMLInputStream, SingleXmlCellsDocument.type, xmlOptions);
        }

        public static SingleXmlCellsDocument parse(Node node) throws XmlException {
            return (SingleXmlCellsDocument) POIXMLTypeLoader.parse(node, SingleXmlCellsDocument.type, (XmlOptions) null);
        }

        public static SingleXmlCellsDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SingleXmlCellsDocument) POIXMLTypeLoader.parse(node, SingleXmlCellsDocument.type, xmlOptions);
        }
    }

    CTSingleXmlCells addNewSingleXmlCells();

    CTSingleXmlCells getSingleXmlCells();

    void setSingleXmlCells(CTSingleXmlCells cTSingleXmlCells);
}
