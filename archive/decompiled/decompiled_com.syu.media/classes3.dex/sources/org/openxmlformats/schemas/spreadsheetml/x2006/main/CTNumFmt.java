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
public interface CTNumFmt extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTNumFmt.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnumfmt3870type");

    public static final class Factory {
        private Factory() {
        }

        public static CTNumFmt newInstance() {
            return (CTNumFmt) POIXMLTypeLoader.newInstance(CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt newInstance(XmlOptions xmlOptions) {
            return (CTNumFmt) POIXMLTypeLoader.newInstance(CTNumFmt.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNumFmt.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(File file) throws XmlException, IOException {
            return (CTNumFmt) POIXMLTypeLoader.parse(file, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumFmt) POIXMLTypeLoader.parse(file, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNumFmt) POIXMLTypeLoader.parse(inputStream, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumFmt) POIXMLTypeLoader.parse(inputStream, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(Reader reader) throws XmlException, IOException {
            return (CTNumFmt) POIXMLTypeLoader.parse(reader, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumFmt) POIXMLTypeLoader.parse(reader, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(String str) throws XmlException {
            return (CTNumFmt) POIXMLTypeLoader.parse(str, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNumFmt) POIXMLTypeLoader.parse(str, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(URL url) throws XmlException, IOException {
            return (CTNumFmt) POIXMLTypeLoader.parse(url, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumFmt) POIXMLTypeLoader.parse(url, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNumFmt) POIXMLTypeLoader.parse(xMLStreamReader, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNumFmt) POIXMLTypeLoader.parse(xMLStreamReader, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTNumFmt) POIXMLTypeLoader.parse(xMLInputStream, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTNumFmt) POIXMLTypeLoader.parse(xMLInputStream, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(Node node) throws XmlException {
            return (CTNumFmt) POIXMLTypeLoader.parse(node, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNumFmt) POIXMLTypeLoader.parse(node, CTNumFmt.type, xmlOptions);
        }
    }

    String getFormatCode();

    long getNumFmtId();

    void setFormatCode(String str);

    void setNumFmtId(long j);

    STXstring xgetFormatCode();

    STNumFmtId xgetNumFmtId();

    void xsetFormatCode(STXstring sTXstring);

    void xsetNumFmtId(STNumFmtId sTNumFmtId);
}
