package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTFtnEdnRef extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTFtnEdnRef.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctftnednref89eetype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFtnEdnRef newInstance() {
            return (CTFtnEdnRef) POIXMLTypeLoader.newInstance(CTFtnEdnRef.type, (XmlOptions) null);
        }

        public static CTFtnEdnRef newInstance(XmlOptions xmlOptions) {
            return (CTFtnEdnRef) POIXMLTypeLoader.newInstance(CTFtnEdnRef.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFtnEdnRef.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFtnEdnRef.type, xmlOptions);
        }

        public static CTFtnEdnRef parse(File file) throws XmlException, IOException {
            return (CTFtnEdnRef) POIXMLTypeLoader.parse(file, CTFtnEdnRef.type, (XmlOptions) null);
        }

        public static CTFtnEdnRef parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFtnEdnRef) POIXMLTypeLoader.parse(file, CTFtnEdnRef.type, xmlOptions);
        }

        public static CTFtnEdnRef parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFtnEdnRef) POIXMLTypeLoader.parse(inputStream, CTFtnEdnRef.type, (XmlOptions) null);
        }

        public static CTFtnEdnRef parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFtnEdnRef) POIXMLTypeLoader.parse(inputStream, CTFtnEdnRef.type, xmlOptions);
        }

        public static CTFtnEdnRef parse(Reader reader) throws XmlException, IOException {
            return (CTFtnEdnRef) POIXMLTypeLoader.parse(reader, CTFtnEdnRef.type, (XmlOptions) null);
        }

        public static CTFtnEdnRef parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFtnEdnRef) POIXMLTypeLoader.parse(reader, CTFtnEdnRef.type, xmlOptions);
        }

        public static CTFtnEdnRef parse(String str) throws XmlException {
            return (CTFtnEdnRef) POIXMLTypeLoader.parse(str, CTFtnEdnRef.type, (XmlOptions) null);
        }

        public static CTFtnEdnRef parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFtnEdnRef) POIXMLTypeLoader.parse(str, CTFtnEdnRef.type, xmlOptions);
        }

        public static CTFtnEdnRef parse(URL url) throws XmlException, IOException {
            return (CTFtnEdnRef) POIXMLTypeLoader.parse(url, CTFtnEdnRef.type, (XmlOptions) null);
        }

        public static CTFtnEdnRef parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFtnEdnRef) POIXMLTypeLoader.parse(url, CTFtnEdnRef.type, xmlOptions);
        }

        public static CTFtnEdnRef parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFtnEdnRef) POIXMLTypeLoader.parse(xMLStreamReader, CTFtnEdnRef.type, (XmlOptions) null);
        }

        public static CTFtnEdnRef parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFtnEdnRef) POIXMLTypeLoader.parse(xMLStreamReader, CTFtnEdnRef.type, xmlOptions);
        }

        public static CTFtnEdnRef parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTFtnEdnRef) POIXMLTypeLoader.parse(xMLInputStream, CTFtnEdnRef.type, (XmlOptions) null);
        }

        public static CTFtnEdnRef parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTFtnEdnRef) POIXMLTypeLoader.parse(xMLInputStream, CTFtnEdnRef.type, xmlOptions);
        }

        public static CTFtnEdnRef parse(Node node) throws XmlException {
            return (CTFtnEdnRef) POIXMLTypeLoader.parse(node, CTFtnEdnRef.type, (XmlOptions) null);
        }

        public static CTFtnEdnRef parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFtnEdnRef) POIXMLTypeLoader.parse(node, CTFtnEdnRef.type, xmlOptions);
        }
    }

    STOnOff.Enum getCustomMarkFollows();

    BigInteger getId();

    boolean isSetCustomMarkFollows();

    void setCustomMarkFollows(STOnOff.Enum r1);

    void setId(BigInteger bigInteger);

    void unsetCustomMarkFollows();

    STOnOff xgetCustomMarkFollows();

    STDecimalNumber xgetId();

    void xsetCustomMarkFollows(STOnOff sTOnOff);

    void xsetId(STDecimalNumber sTDecimalNumber);
}
