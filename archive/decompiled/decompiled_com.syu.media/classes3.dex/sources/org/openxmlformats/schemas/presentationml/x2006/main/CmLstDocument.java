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
public interface CmLstDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CmLstDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cmlst3880doctype");

    public static final class Factory {
        private Factory() {
        }

        public static CmLstDocument newInstance() {
            return (CmLstDocument) POIXMLTypeLoader.newInstance(CmLstDocument.type, (XmlOptions) null);
        }

        public static CmLstDocument newInstance(XmlOptions xmlOptions) {
            return (CmLstDocument) POIXMLTypeLoader.newInstance(CmLstDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CmLstDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CmLstDocument.type, xmlOptions);
        }

        public static CmLstDocument parse(File file) throws XmlException, IOException {
            return (CmLstDocument) POIXMLTypeLoader.parse(file, CmLstDocument.type, (XmlOptions) null);
        }

        public static CmLstDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CmLstDocument) POIXMLTypeLoader.parse(file, CmLstDocument.type, xmlOptions);
        }

        public static CmLstDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (CmLstDocument) POIXMLTypeLoader.parse(inputStream, CmLstDocument.type, (XmlOptions) null);
        }

        public static CmLstDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CmLstDocument) POIXMLTypeLoader.parse(inputStream, CmLstDocument.type, xmlOptions);
        }

        public static CmLstDocument parse(Reader reader) throws XmlException, IOException {
            return (CmLstDocument) POIXMLTypeLoader.parse(reader, CmLstDocument.type, (XmlOptions) null);
        }

        public static CmLstDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CmLstDocument) POIXMLTypeLoader.parse(reader, CmLstDocument.type, xmlOptions);
        }

        public static CmLstDocument parse(String str) throws XmlException {
            return (CmLstDocument) POIXMLTypeLoader.parse(str, CmLstDocument.type, (XmlOptions) null);
        }

        public static CmLstDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CmLstDocument) POIXMLTypeLoader.parse(str, CmLstDocument.type, xmlOptions);
        }

        public static CmLstDocument parse(URL url) throws XmlException, IOException {
            return (CmLstDocument) POIXMLTypeLoader.parse(url, CmLstDocument.type, (XmlOptions) null);
        }

        public static CmLstDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CmLstDocument) POIXMLTypeLoader.parse(url, CmLstDocument.type, xmlOptions);
        }

        public static CmLstDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CmLstDocument) POIXMLTypeLoader.parse(xMLStreamReader, CmLstDocument.type, (XmlOptions) null);
        }

        public static CmLstDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CmLstDocument) POIXMLTypeLoader.parse(xMLStreamReader, CmLstDocument.type, xmlOptions);
        }

        public static CmLstDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CmLstDocument) POIXMLTypeLoader.parse(xMLInputStream, CmLstDocument.type, (XmlOptions) null);
        }

        public static CmLstDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CmLstDocument) POIXMLTypeLoader.parse(xMLInputStream, CmLstDocument.type, xmlOptions);
        }

        public static CmLstDocument parse(Node node) throws XmlException {
            return (CmLstDocument) POIXMLTypeLoader.parse(node, CmLstDocument.type, (XmlOptions) null);
        }

        public static CmLstDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CmLstDocument) POIXMLTypeLoader.parse(node, CmLstDocument.type, xmlOptions);
        }
    }

    CTCommentList addNewCmLst();

    CTCommentList getCmLst();

    void setCmLst(CTCommentList cTCommentList);
}
