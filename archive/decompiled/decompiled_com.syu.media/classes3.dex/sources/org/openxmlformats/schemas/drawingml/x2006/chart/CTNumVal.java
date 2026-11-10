package org.openxmlformats.schemas.drawingml.x2006.chart;

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
public interface CTNumVal extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTNumVal.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnumval2fe1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTNumVal newInstance() {
            return (CTNumVal) POIXMLTypeLoader.newInstance(CTNumVal.type, (XmlOptions) null);
        }

        public static CTNumVal newInstance(XmlOptions xmlOptions) {
            return (CTNumVal) POIXMLTypeLoader.newInstance(CTNumVal.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNumVal.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNumVal.type, xmlOptions);
        }

        public static CTNumVal parse(File file) throws XmlException, IOException {
            return (CTNumVal) POIXMLTypeLoader.parse(file, CTNumVal.type, (XmlOptions) null);
        }

        public static CTNumVal parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumVal) POIXMLTypeLoader.parse(file, CTNumVal.type, xmlOptions);
        }

        public static CTNumVal parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNumVal) POIXMLTypeLoader.parse(inputStream, CTNumVal.type, (XmlOptions) null);
        }

        public static CTNumVal parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumVal) POIXMLTypeLoader.parse(inputStream, CTNumVal.type, xmlOptions);
        }

        public static CTNumVal parse(Reader reader) throws XmlException, IOException {
            return (CTNumVal) POIXMLTypeLoader.parse(reader, CTNumVal.type, (XmlOptions) null);
        }

        public static CTNumVal parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumVal) POIXMLTypeLoader.parse(reader, CTNumVal.type, xmlOptions);
        }

        public static CTNumVal parse(String str) throws XmlException {
            return (CTNumVal) POIXMLTypeLoader.parse(str, CTNumVal.type, (XmlOptions) null);
        }

        public static CTNumVal parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNumVal) POIXMLTypeLoader.parse(str, CTNumVal.type, xmlOptions);
        }

        public static CTNumVal parse(URL url) throws XmlException, IOException {
            return (CTNumVal) POIXMLTypeLoader.parse(url, CTNumVal.type, (XmlOptions) null);
        }

        public static CTNumVal parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumVal) POIXMLTypeLoader.parse(url, CTNumVal.type, xmlOptions);
        }

        public static CTNumVal parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNumVal) POIXMLTypeLoader.parse(xMLStreamReader, CTNumVal.type, (XmlOptions) null);
        }

        public static CTNumVal parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNumVal) POIXMLTypeLoader.parse(xMLStreamReader, CTNumVal.type, xmlOptions);
        }

        public static CTNumVal parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTNumVal) POIXMLTypeLoader.parse(xMLInputStream, CTNumVal.type, (XmlOptions) null);
        }

        public static CTNumVal parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTNumVal) POIXMLTypeLoader.parse(xMLInputStream, CTNumVal.type, xmlOptions);
        }

        public static CTNumVal parse(Node node) throws XmlException {
            return (CTNumVal) POIXMLTypeLoader.parse(node, CTNumVal.type, (XmlOptions) null);
        }

        public static CTNumVal parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNumVal) POIXMLTypeLoader.parse(node, CTNumVal.type, xmlOptions);
        }
    }

    String getFormatCode();

    long getIdx();

    String getV();

    boolean isSetFormatCode();

    void setFormatCode(String str);

    void setIdx(long j);

    void setV(String str);

    void unsetFormatCode();

    STXstring xgetFormatCode();

    XmlUnsignedInt xgetIdx();

    STXstring xgetV();

    void xsetFormatCode(STXstring sTXstring);

    void xsetIdx(XmlUnsignedInt xmlUnsignedInt);

    void xsetV(STXstring sTXstring);
}
