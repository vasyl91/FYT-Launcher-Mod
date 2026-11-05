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
public interface CmAuthorLstDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CmAuthorLstDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cmauthorlst86abdoctype");

    public static final class Factory {
        private Factory() {
        }

        public static CmAuthorLstDocument newInstance() {
            return (CmAuthorLstDocument) POIXMLTypeLoader.newInstance(CmAuthorLstDocument.type, (XmlOptions) null);
        }

        public static CmAuthorLstDocument newInstance(XmlOptions xmlOptions) {
            return (CmAuthorLstDocument) POIXMLTypeLoader.newInstance(CmAuthorLstDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CmAuthorLstDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CmAuthorLstDocument.type, xmlOptions);
        }

        public static CmAuthorLstDocument parse(File file) throws XmlException, IOException {
            return (CmAuthorLstDocument) POIXMLTypeLoader.parse(file, CmAuthorLstDocument.type, (XmlOptions) null);
        }

        public static CmAuthorLstDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CmAuthorLstDocument) POIXMLTypeLoader.parse(file, CmAuthorLstDocument.type, xmlOptions);
        }

        public static CmAuthorLstDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (CmAuthorLstDocument) POIXMLTypeLoader.parse(inputStream, CmAuthorLstDocument.type, (XmlOptions) null);
        }

        public static CmAuthorLstDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CmAuthorLstDocument) POIXMLTypeLoader.parse(inputStream, CmAuthorLstDocument.type, xmlOptions);
        }

        public static CmAuthorLstDocument parse(Reader reader) throws XmlException, IOException {
            return (CmAuthorLstDocument) POIXMLTypeLoader.parse(reader, CmAuthorLstDocument.type, (XmlOptions) null);
        }

        public static CmAuthorLstDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CmAuthorLstDocument) POIXMLTypeLoader.parse(reader, CmAuthorLstDocument.type, xmlOptions);
        }

        public static CmAuthorLstDocument parse(String str) throws XmlException {
            return (CmAuthorLstDocument) POIXMLTypeLoader.parse(str, CmAuthorLstDocument.type, (XmlOptions) null);
        }

        public static CmAuthorLstDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CmAuthorLstDocument) POIXMLTypeLoader.parse(str, CmAuthorLstDocument.type, xmlOptions);
        }

        public static CmAuthorLstDocument parse(URL url) throws XmlException, IOException {
            return (CmAuthorLstDocument) POIXMLTypeLoader.parse(url, CmAuthorLstDocument.type, (XmlOptions) null);
        }

        public static CmAuthorLstDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CmAuthorLstDocument) POIXMLTypeLoader.parse(url, CmAuthorLstDocument.type, xmlOptions);
        }

        public static CmAuthorLstDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CmAuthorLstDocument) POIXMLTypeLoader.parse(xMLStreamReader, CmAuthorLstDocument.type, (XmlOptions) null);
        }

        public static CmAuthorLstDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CmAuthorLstDocument) POIXMLTypeLoader.parse(xMLStreamReader, CmAuthorLstDocument.type, xmlOptions);
        }

        public static CmAuthorLstDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CmAuthorLstDocument) POIXMLTypeLoader.parse(xMLInputStream, CmAuthorLstDocument.type, (XmlOptions) null);
        }

        public static CmAuthorLstDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CmAuthorLstDocument) POIXMLTypeLoader.parse(xMLInputStream, CmAuthorLstDocument.type, xmlOptions);
        }

        public static CmAuthorLstDocument parse(Node node) throws XmlException {
            return (CmAuthorLstDocument) POIXMLTypeLoader.parse(node, CmAuthorLstDocument.type, (XmlOptions) null);
        }

        public static CmAuthorLstDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CmAuthorLstDocument) POIXMLTypeLoader.parse(node, CmAuthorLstDocument.type, xmlOptions);
        }
    }

    CTCommentAuthorList addNewCmAuthorLst();

    CTCommentAuthorList getCmAuthorLst();

    void setCmAuthorLst(CTCommentAuthorList cTCommentAuthorList);
}
