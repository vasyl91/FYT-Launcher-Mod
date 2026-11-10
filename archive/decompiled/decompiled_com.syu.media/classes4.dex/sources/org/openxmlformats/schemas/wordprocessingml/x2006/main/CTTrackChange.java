package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTTrackChange extends CTMarkup {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTrackChange.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttrackchangec317type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTrackChange newInstance() {
            return (CTTrackChange) POIXMLTypeLoader.newInstance(CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange newInstance(XmlOptions xmlOptions) {
            return (CTTrackChange) POIXMLTypeLoader.newInstance(CTTrackChange.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTrackChange.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(File file) throws XmlException, IOException {
            return (CTTrackChange) POIXMLTypeLoader.parse(file, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrackChange) POIXMLTypeLoader.parse(file, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTrackChange) POIXMLTypeLoader.parse(inputStream, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrackChange) POIXMLTypeLoader.parse(inputStream, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(Reader reader) throws XmlException, IOException {
            return (CTTrackChange) POIXMLTypeLoader.parse(reader, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrackChange) POIXMLTypeLoader.parse(reader, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(String str) throws XmlException {
            return (CTTrackChange) POIXMLTypeLoader.parse(str, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTrackChange) POIXMLTypeLoader.parse(str, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(URL url) throws XmlException, IOException {
            return (CTTrackChange) POIXMLTypeLoader.parse(url, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTrackChange) POIXMLTypeLoader.parse(url, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTrackChange) POIXMLTypeLoader.parse(xMLStreamReader, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTrackChange) POIXMLTypeLoader.parse(xMLStreamReader, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTrackChange) POIXMLTypeLoader.parse(xMLInputStream, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTrackChange) POIXMLTypeLoader.parse(xMLInputStream, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(Node node) throws XmlException {
            return (CTTrackChange) POIXMLTypeLoader.parse(node, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTrackChange) POIXMLTypeLoader.parse(node, CTTrackChange.type, xmlOptions);
        }
    }

    String getAuthor();

    Calendar getDate();

    boolean isSetDate();

    void setAuthor(String str);

    void setDate(Calendar calendar);

    void unsetDate();

    STString xgetAuthor();

    STDateTime xgetDate();

    void xsetAuthor(STString sTString);

    void xsetDate(STDateTime sTDateTime);
}
