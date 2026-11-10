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
public interface CTFill extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTFill.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfill550ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFill newInstance() {
            return (CTFill) POIXMLTypeLoader.newInstance(CTFill.type, (XmlOptions) null);
        }

        public static CTFill newInstance(XmlOptions xmlOptions) {
            return (CTFill) POIXMLTypeLoader.newInstance(CTFill.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFill.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFill.type, xmlOptions);
        }

        public static CTFill parse(File file) throws XmlException, IOException {
            return (CTFill) POIXMLTypeLoader.parse(file, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFill) POIXMLTypeLoader.parse(file, CTFill.type, xmlOptions);
        }

        public static CTFill parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFill) POIXMLTypeLoader.parse(inputStream, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFill) POIXMLTypeLoader.parse(inputStream, CTFill.type, xmlOptions);
        }

        public static CTFill parse(Reader reader) throws XmlException, IOException {
            return (CTFill) POIXMLTypeLoader.parse(reader, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFill) POIXMLTypeLoader.parse(reader, CTFill.type, xmlOptions);
        }

        public static CTFill parse(String str) throws XmlException {
            return (CTFill) POIXMLTypeLoader.parse(str, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFill) POIXMLTypeLoader.parse(str, CTFill.type, xmlOptions);
        }

        public static CTFill parse(URL url) throws XmlException, IOException {
            return (CTFill) POIXMLTypeLoader.parse(url, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFill) POIXMLTypeLoader.parse(url, CTFill.type, xmlOptions);
        }

        public static CTFill parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFill) POIXMLTypeLoader.parse(xMLStreamReader, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFill) POIXMLTypeLoader.parse(xMLStreamReader, CTFill.type, xmlOptions);
        }

        public static CTFill parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTFill) POIXMLTypeLoader.parse(xMLInputStream, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTFill) POIXMLTypeLoader.parse(xMLInputStream, CTFill.type, xmlOptions);
        }

        public static CTFill parse(Node node) throws XmlException {
            return (CTFill) POIXMLTypeLoader.parse(node, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFill) POIXMLTypeLoader.parse(node, CTFill.type, xmlOptions);
        }
    }

    CTGradientFill addNewGradientFill();

    CTPatternFill addNewPatternFill();

    CTGradientFill getGradientFill();

    CTPatternFill getPatternFill();

    boolean isSetGradientFill();

    boolean isSetPatternFill();

    void setGradientFill(CTGradientFill cTGradientFill);

    void setPatternFill(CTPatternFill cTPatternFill);

    void unsetGradientFill();

    void unsetPatternFill();
}
