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
public interface TblStyleLstDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(TblStyleLstDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("tblstylelst4997doctype");

    public static final class Factory {
        private Factory() {
        }

        public static TblStyleLstDocument newInstance() {
            return (TblStyleLstDocument) POIXMLTypeLoader.newInstance(TblStyleLstDocument.type, (XmlOptions) null);
        }

        public static TblStyleLstDocument newInstance(XmlOptions xmlOptions) {
            return (TblStyleLstDocument) POIXMLTypeLoader.newInstance(TblStyleLstDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, TblStyleLstDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, TblStyleLstDocument.type, xmlOptions);
        }

        public static TblStyleLstDocument parse(File file) throws XmlException, IOException {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(file, TblStyleLstDocument.type, (XmlOptions) null);
        }

        public static TblStyleLstDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(file, TblStyleLstDocument.type, xmlOptions);
        }

        public static TblStyleLstDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(inputStream, TblStyleLstDocument.type, (XmlOptions) null);
        }

        public static TblStyleLstDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(inputStream, TblStyleLstDocument.type, xmlOptions);
        }

        public static TblStyleLstDocument parse(Reader reader) throws XmlException, IOException {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(reader, TblStyleLstDocument.type, (XmlOptions) null);
        }

        public static TblStyleLstDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(reader, TblStyleLstDocument.type, xmlOptions);
        }

        public static TblStyleLstDocument parse(String str) throws XmlException {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(str, TblStyleLstDocument.type, (XmlOptions) null);
        }

        public static TblStyleLstDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(str, TblStyleLstDocument.type, xmlOptions);
        }

        public static TblStyleLstDocument parse(URL url) throws XmlException, IOException {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(url, TblStyleLstDocument.type, (XmlOptions) null);
        }

        public static TblStyleLstDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(url, TblStyleLstDocument.type, xmlOptions);
        }

        public static TblStyleLstDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(xMLStreamReader, TblStyleLstDocument.type, (XmlOptions) null);
        }

        public static TblStyleLstDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(xMLStreamReader, TblStyleLstDocument.type, xmlOptions);
        }

        public static TblStyleLstDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(xMLInputStream, TblStyleLstDocument.type, (XmlOptions) null);
        }

        public static TblStyleLstDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(xMLInputStream, TblStyleLstDocument.type, xmlOptions);
        }

        public static TblStyleLstDocument parse(Node node) throws XmlException {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(node, TblStyleLstDocument.type, (XmlOptions) null);
        }

        public static TblStyleLstDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(node, TblStyleLstDocument.type, xmlOptions);
        }
    }

    CTTableStyleList addNewTblStyleLst();

    CTTableStyleList getTblStyleLst();

    void setTblStyleLst(CTTableStyleList cTTableStyleList);
}
