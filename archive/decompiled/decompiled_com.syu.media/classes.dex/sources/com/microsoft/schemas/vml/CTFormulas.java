package com.microsoft.schemas.vml;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface CTFormulas extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTFormulas.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctformulas808btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFormulas newInstance() {
            return (CTFormulas) POIXMLTypeLoader.newInstance(CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas newInstance(XmlOptions xmlOptions) {
            return (CTFormulas) POIXMLTypeLoader.newInstance(CTFormulas.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFormulas.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(File file) throws XmlException, IOException {
            return (CTFormulas) POIXMLTypeLoader.parse(file, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFormulas) POIXMLTypeLoader.parse(file, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFormulas) POIXMLTypeLoader.parse(inputStream, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFormulas) POIXMLTypeLoader.parse(inputStream, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(Reader reader) throws XmlException, IOException {
            return (CTFormulas) POIXMLTypeLoader.parse(reader, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFormulas) POIXMLTypeLoader.parse(reader, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(String str) throws XmlException {
            return (CTFormulas) POIXMLTypeLoader.parse(str, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFormulas) POIXMLTypeLoader.parse(str, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(URL url) throws XmlException, IOException {
            return (CTFormulas) POIXMLTypeLoader.parse(url, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFormulas) POIXMLTypeLoader.parse(url, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFormulas) POIXMLTypeLoader.parse(xMLStreamReader, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFormulas) POIXMLTypeLoader.parse(xMLStreamReader, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTFormulas) POIXMLTypeLoader.parse(xMLInputStream, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTFormulas) POIXMLTypeLoader.parse(xMLInputStream, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(Node node) throws XmlException {
            return (CTFormulas) POIXMLTypeLoader.parse(node, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFormulas) POIXMLTypeLoader.parse(node, CTFormulas.type, xmlOptions);
        }
    }

    CTF addNewF();

    CTF getFArray(int i);

    CTF[] getFArray();

    List<CTF> getFList();

    CTF insertNewF(int i);

    void removeF(int i);

    void setFArray(int i, CTF ctf);

    void setFArray(CTF[] ctfArr);

    int sizeOfFArray();
}
