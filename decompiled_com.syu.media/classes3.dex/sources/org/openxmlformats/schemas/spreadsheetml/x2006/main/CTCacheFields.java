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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTCacheFields extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTCacheFields.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcachefieldsf5fatype");

    public static final class Factory {
        private Factory() {
        }

        public static CTCacheFields newInstance() {
            return (CTCacheFields) POIXMLTypeLoader.newInstance(CTCacheFields.type, (XmlOptions) null);
        }

        public static CTCacheFields newInstance(XmlOptions xmlOptions) {
            return (CTCacheFields) POIXMLTypeLoader.newInstance(CTCacheFields.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCacheFields.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCacheFields.type, xmlOptions);
        }

        public static CTCacheFields parse(File file) throws XmlException, IOException {
            return (CTCacheFields) POIXMLTypeLoader.parse(file, CTCacheFields.type, (XmlOptions) null);
        }

        public static CTCacheFields parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCacheFields) POIXMLTypeLoader.parse(file, CTCacheFields.type, xmlOptions);
        }

        public static CTCacheFields parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCacheFields) POIXMLTypeLoader.parse(inputStream, CTCacheFields.type, (XmlOptions) null);
        }

        public static CTCacheFields parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCacheFields) POIXMLTypeLoader.parse(inputStream, CTCacheFields.type, xmlOptions);
        }

        public static CTCacheFields parse(Reader reader) throws XmlException, IOException {
            return (CTCacheFields) POIXMLTypeLoader.parse(reader, CTCacheFields.type, (XmlOptions) null);
        }

        public static CTCacheFields parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCacheFields) POIXMLTypeLoader.parse(reader, CTCacheFields.type, xmlOptions);
        }

        public static CTCacheFields parse(String str) throws XmlException {
            return (CTCacheFields) POIXMLTypeLoader.parse(str, CTCacheFields.type, (XmlOptions) null);
        }

        public static CTCacheFields parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCacheFields) POIXMLTypeLoader.parse(str, CTCacheFields.type, xmlOptions);
        }

        public static CTCacheFields parse(URL url) throws XmlException, IOException {
            return (CTCacheFields) POIXMLTypeLoader.parse(url, CTCacheFields.type, (XmlOptions) null);
        }

        public static CTCacheFields parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCacheFields) POIXMLTypeLoader.parse(url, CTCacheFields.type, xmlOptions);
        }

        public static CTCacheFields parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCacheFields) POIXMLTypeLoader.parse(xMLStreamReader, CTCacheFields.type, (XmlOptions) null);
        }

        public static CTCacheFields parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCacheFields) POIXMLTypeLoader.parse(xMLStreamReader, CTCacheFields.type, xmlOptions);
        }

        public static CTCacheFields parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTCacheFields) POIXMLTypeLoader.parse(xMLInputStream, CTCacheFields.type, (XmlOptions) null);
        }

        public static CTCacheFields parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTCacheFields) POIXMLTypeLoader.parse(xMLInputStream, CTCacheFields.type, xmlOptions);
        }

        public static CTCacheFields parse(Node node) throws XmlException {
            return (CTCacheFields) POIXMLTypeLoader.parse(node, CTCacheFields.type, (XmlOptions) null);
        }

        public static CTCacheFields parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCacheFields) POIXMLTypeLoader.parse(node, CTCacheFields.type, xmlOptions);
        }
    }

    CTCacheField addNewCacheField();

    CTCacheField getCacheFieldArray(int i);

    CTCacheField[] getCacheFieldArray();

    List<CTCacheField> getCacheFieldList();

    long getCount();

    CTCacheField insertNewCacheField(int i);

    boolean isSetCount();

    void removeCacheField(int i);

    void setCacheFieldArray(int i, CTCacheField cTCacheField);

    void setCacheFieldArray(CTCacheField[] cTCacheFieldArr);

    void setCount(long j);

    int sizeOfCacheFieldArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
