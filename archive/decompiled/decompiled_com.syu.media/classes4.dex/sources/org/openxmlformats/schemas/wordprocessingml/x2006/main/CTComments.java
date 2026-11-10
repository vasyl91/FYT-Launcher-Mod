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
public interface CTComments extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTComments.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcomments7674type");

    public static final class Factory {
        private Factory() {
        }

        public static CTComments newInstance() {
            return (CTComments) POIXMLTypeLoader.newInstance(CTComments.type, (XmlOptions) null);
        }

        public static CTComments newInstance(XmlOptions xmlOptions) {
            return (CTComments) POIXMLTypeLoader.newInstance(CTComments.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTComments.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTComments.type, xmlOptions);
        }

        public static CTComments parse(File file) throws XmlException, IOException {
            return (CTComments) POIXMLTypeLoader.parse(file, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTComments) POIXMLTypeLoader.parse(file, CTComments.type, xmlOptions);
        }

        public static CTComments parse(InputStream inputStream) throws XmlException, IOException {
            return (CTComments) POIXMLTypeLoader.parse(inputStream, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTComments) POIXMLTypeLoader.parse(inputStream, CTComments.type, xmlOptions);
        }

        public static CTComments parse(Reader reader) throws XmlException, IOException {
            return (CTComments) POIXMLTypeLoader.parse(reader, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTComments) POIXMLTypeLoader.parse(reader, CTComments.type, xmlOptions);
        }

        public static CTComments parse(String str) throws XmlException {
            return (CTComments) POIXMLTypeLoader.parse(str, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTComments) POIXMLTypeLoader.parse(str, CTComments.type, xmlOptions);
        }

        public static CTComments parse(URL url) throws XmlException, IOException {
            return (CTComments) POIXMLTypeLoader.parse(url, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTComments) POIXMLTypeLoader.parse(url, CTComments.type, xmlOptions);
        }

        public static CTComments parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTComments) POIXMLTypeLoader.parse(xMLStreamReader, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTComments) POIXMLTypeLoader.parse(xMLStreamReader, CTComments.type, xmlOptions);
        }

        public static CTComments parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTComments) POIXMLTypeLoader.parse(xMLInputStream, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTComments) POIXMLTypeLoader.parse(xMLInputStream, CTComments.type, xmlOptions);
        }

        public static CTComments parse(Node node) throws XmlException {
            return (CTComments) POIXMLTypeLoader.parse(node, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTComments) POIXMLTypeLoader.parse(node, CTComments.type, xmlOptions);
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
