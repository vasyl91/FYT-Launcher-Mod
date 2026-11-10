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
public interface CTPivotCaches extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPivotCaches.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpivotcaches4f32type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPivotCaches newInstance() {
            return (CTPivotCaches) POIXMLTypeLoader.newInstance(CTPivotCaches.type, (XmlOptions) null);
        }

        public static CTPivotCaches newInstance(XmlOptions xmlOptions) {
            return (CTPivotCaches) POIXMLTypeLoader.newInstance(CTPivotCaches.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPivotCaches.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPivotCaches.type, xmlOptions);
        }

        public static CTPivotCaches parse(File file) throws XmlException, IOException {
            return (CTPivotCaches) POIXMLTypeLoader.parse(file, CTPivotCaches.type, (XmlOptions) null);
        }

        public static CTPivotCaches parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCaches) POIXMLTypeLoader.parse(file, CTPivotCaches.type, xmlOptions);
        }

        public static CTPivotCaches parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPivotCaches) POIXMLTypeLoader.parse(inputStream, CTPivotCaches.type, (XmlOptions) null);
        }

        public static CTPivotCaches parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCaches) POIXMLTypeLoader.parse(inputStream, CTPivotCaches.type, xmlOptions);
        }

        public static CTPivotCaches parse(Reader reader) throws XmlException, IOException {
            return (CTPivotCaches) POIXMLTypeLoader.parse(reader, CTPivotCaches.type, (XmlOptions) null);
        }

        public static CTPivotCaches parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCaches) POIXMLTypeLoader.parse(reader, CTPivotCaches.type, xmlOptions);
        }

        public static CTPivotCaches parse(String str) throws XmlException {
            return (CTPivotCaches) POIXMLTypeLoader.parse(str, CTPivotCaches.type, (XmlOptions) null);
        }

        public static CTPivotCaches parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotCaches) POIXMLTypeLoader.parse(str, CTPivotCaches.type, xmlOptions);
        }

        public static CTPivotCaches parse(URL url) throws XmlException, IOException {
            return (CTPivotCaches) POIXMLTypeLoader.parse(url, CTPivotCaches.type, (XmlOptions) null);
        }

        public static CTPivotCaches parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCaches) POIXMLTypeLoader.parse(url, CTPivotCaches.type, xmlOptions);
        }

        public static CTPivotCaches parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPivotCaches) POIXMLTypeLoader.parse(xMLStreamReader, CTPivotCaches.type, (XmlOptions) null);
        }

        public static CTPivotCaches parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotCaches) POIXMLTypeLoader.parse(xMLStreamReader, CTPivotCaches.type, xmlOptions);
        }

        public static CTPivotCaches parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPivotCaches) POIXMLTypeLoader.parse(xMLInputStream, CTPivotCaches.type, (XmlOptions) null);
        }

        public static CTPivotCaches parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPivotCaches) POIXMLTypeLoader.parse(xMLInputStream, CTPivotCaches.type, xmlOptions);
        }

        public static CTPivotCaches parse(Node node) throws XmlException {
            return (CTPivotCaches) POIXMLTypeLoader.parse(node, CTPivotCaches.type, (XmlOptions) null);
        }

        public static CTPivotCaches parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotCaches) POIXMLTypeLoader.parse(node, CTPivotCaches.type, xmlOptions);
        }
    }

    CTPivotCache addNewPivotCache();

    CTPivotCache getPivotCacheArray(int i);

    CTPivotCache[] getPivotCacheArray();

    List<CTPivotCache> getPivotCacheList();

    CTPivotCache insertNewPivotCache(int i);

    void removePivotCache(int i);

    void setPivotCacheArray(int i, CTPivotCache cTPivotCache);

    void setPivotCacheArray(CTPivotCache[] cTPivotCacheArr);

    int sizeOfPivotCacheArray();
}
