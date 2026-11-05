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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTComment extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTComment.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcomment7bfetype");

    public static final class Factory {
        private Factory() {
        }

        public static CTComment newInstance() {
            return (CTComment) POIXMLTypeLoader.newInstance(CTComment.type, (XmlOptions) null);
        }

        public static CTComment newInstance(XmlOptions xmlOptions) {
            return (CTComment) POIXMLTypeLoader.newInstance(CTComment.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTComment.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTComment.type, xmlOptions);
        }

        public static CTComment parse(File file) throws XmlException, IOException {
            return (CTComment) POIXMLTypeLoader.parse(file, CTComment.type, (XmlOptions) null);
        }

        public static CTComment parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTComment) POIXMLTypeLoader.parse(file, CTComment.type, xmlOptions);
        }

        public static CTComment parse(InputStream inputStream) throws XmlException, IOException {
            return (CTComment) POIXMLTypeLoader.parse(inputStream, CTComment.type, (XmlOptions) null);
        }

        public static CTComment parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTComment) POIXMLTypeLoader.parse(inputStream, CTComment.type, xmlOptions);
        }

        public static CTComment parse(Reader reader) throws XmlException, IOException {
            return (CTComment) POIXMLTypeLoader.parse(reader, CTComment.type, (XmlOptions) null);
        }

        public static CTComment parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTComment) POIXMLTypeLoader.parse(reader, CTComment.type, xmlOptions);
        }

        public static CTComment parse(String str) throws XmlException {
            return (CTComment) POIXMLTypeLoader.parse(str, CTComment.type, (XmlOptions) null);
        }

        public static CTComment parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTComment) POIXMLTypeLoader.parse(str, CTComment.type, xmlOptions);
        }

        public static CTComment parse(URL url) throws XmlException, IOException {
            return (CTComment) POIXMLTypeLoader.parse(url, CTComment.type, (XmlOptions) null);
        }

        public static CTComment parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTComment) POIXMLTypeLoader.parse(url, CTComment.type, xmlOptions);
        }

        public static CTComment parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTComment) POIXMLTypeLoader.parse(xMLStreamReader, CTComment.type, (XmlOptions) null);
        }

        public static CTComment parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTComment) POIXMLTypeLoader.parse(xMLStreamReader, CTComment.type, xmlOptions);
        }

        public static CTComment parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTComment) POIXMLTypeLoader.parse(xMLInputStream, CTComment.type, (XmlOptions) null);
        }

        public static CTComment parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTComment) POIXMLTypeLoader.parse(xMLInputStream, CTComment.type, xmlOptions);
        }

        public static CTComment parse(Node node) throws XmlException {
            return (CTComment) POIXMLTypeLoader.parse(node, CTComment.type, (XmlOptions) null);
        }

        public static CTComment parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTComment) POIXMLTypeLoader.parse(node, CTComment.type, xmlOptions);
        }
    }

    CTRst addNewText();

    long getAuthorId();

    String getGuid();

    String getRef();

    CTRst getText();

    boolean isSetGuid();

    void setAuthorId(long j);

    void setGuid(String str);

    void setRef(String str);

    void setText(CTRst cTRst);

    void unsetGuid();

    XmlUnsignedInt xgetAuthorId();

    STGuid xgetGuid();

    STRef xgetRef();

    void xsetAuthorId(XmlUnsignedInt xmlUnsignedInt);

    void xsetGuid(STGuid sTGuid);

    void xsetRef(STRef sTRef);
}
