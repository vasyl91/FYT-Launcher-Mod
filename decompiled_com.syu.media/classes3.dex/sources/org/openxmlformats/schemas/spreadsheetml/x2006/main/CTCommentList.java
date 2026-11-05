package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTCommentList extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTCommentList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcommentlist7a3ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTCommentList newInstance() {
            return (CTCommentList) POIXMLTypeLoader.newInstance(CTCommentList.type, (XmlOptions) null);
        }

        public static CTCommentList newInstance(XmlOptions xmlOptions) {
            return (CTCommentList) POIXMLTypeLoader.newInstance(CTCommentList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCommentList.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCommentList.type, xmlOptions);
        }

        public static CTCommentList parse(File file) throws XmlException, IOException {
            return (CTCommentList) POIXMLTypeLoader.parse(file, CTCommentList.type, (XmlOptions) null);
        }

        public static CTCommentList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommentList) POIXMLTypeLoader.parse(file, CTCommentList.type, xmlOptions);
        }

        public static CTCommentList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCommentList) POIXMLTypeLoader.parse(inputStream, CTCommentList.type, (XmlOptions) null);
        }

        public static CTCommentList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommentList) POIXMLTypeLoader.parse(inputStream, CTCommentList.type, xmlOptions);
        }

        public static CTCommentList parse(Reader reader) throws XmlException, IOException {
            return (CTCommentList) POIXMLTypeLoader.parse(reader, CTCommentList.type, (XmlOptions) null);
        }

        public static CTCommentList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommentList) POIXMLTypeLoader.parse(reader, CTCommentList.type, xmlOptions);
        }

        public static CTCommentList parse(String str) throws XmlException {
            return (CTCommentList) POIXMLTypeLoader.parse(str, CTCommentList.type, (XmlOptions) null);
        }

        public static CTCommentList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCommentList) POIXMLTypeLoader.parse(str, CTCommentList.type, xmlOptions);
        }

        public static CTCommentList parse(URL url) throws XmlException, IOException {
            return (CTCommentList) POIXMLTypeLoader.parse(url, CTCommentList.type, (XmlOptions) null);
        }

        public static CTCommentList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommentList) POIXMLTypeLoader.parse(url, CTCommentList.type, xmlOptions);
        }

        public static CTCommentList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCommentList) POIXMLTypeLoader.parse(xMLStreamReader, CTCommentList.type, (XmlOptions) null);
        }

        public static CTCommentList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCommentList) POIXMLTypeLoader.parse(xMLStreamReader, CTCommentList.type, xmlOptions);
        }

        public static CTCommentList parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTCommentList) POIXMLTypeLoader.parse(xMLInputStream, CTCommentList.type, (XmlOptions) null);
        }

        public static CTCommentList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTCommentList) POIXMLTypeLoader.parse(xMLInputStream, CTCommentList.type, xmlOptions);
        }

        public static CTCommentList parse(Node node) throws XmlException {
            return (CTCommentList) POIXMLTypeLoader.parse(node, CTCommentList.type, (XmlOptions) null);
        }

        public static CTCommentList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCommentList) POIXMLTypeLoader.parse(node, CTCommentList.type, xmlOptions);
        }
    }

    CTComment addNewComment();

    CTComment getCommentArray(int i);

    CTComment[] getCommentArray();

    List<CTComment> getCommentList();

    CTComment insertNewComment(int i);

    void removeComment(int i);

    void setCommentArray(int i, CTComment cTComment);

    void setCommentArray(CTComment[] cTCommentArr);

    int sizeOfCommentArray();
}
