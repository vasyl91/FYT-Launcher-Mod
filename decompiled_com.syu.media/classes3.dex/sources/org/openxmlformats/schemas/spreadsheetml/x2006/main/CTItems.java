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
public interface CTItems extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTItems.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctitemsecdftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTItems newInstance() {
            return (CTItems) POIXMLTypeLoader.newInstance(CTItems.type, (XmlOptions) null);
        }

        public static CTItems newInstance(XmlOptions xmlOptions) {
            return (CTItems) POIXMLTypeLoader.newInstance(CTItems.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTItems.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTItems.type, xmlOptions);
        }

        public static CTItems parse(File file) throws XmlException, IOException {
            return (CTItems) POIXMLTypeLoader.parse(file, CTItems.type, (XmlOptions) null);
        }

        public static CTItems parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTItems) POIXMLTypeLoader.parse(file, CTItems.type, xmlOptions);
        }

        public static CTItems parse(InputStream inputStream) throws XmlException, IOException {
            return (CTItems) POIXMLTypeLoader.parse(inputStream, CTItems.type, (XmlOptions) null);
        }

        public static CTItems parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTItems) POIXMLTypeLoader.parse(inputStream, CTItems.type, xmlOptions);
        }

        public static CTItems parse(Reader reader) throws XmlException, IOException {
            return (CTItems) POIXMLTypeLoader.parse(reader, CTItems.type, (XmlOptions) null);
        }

        public static CTItems parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTItems) POIXMLTypeLoader.parse(reader, CTItems.type, xmlOptions);
        }

        public static CTItems parse(String str) throws XmlException {
            return (CTItems) POIXMLTypeLoader.parse(str, CTItems.type, (XmlOptions) null);
        }

        public static CTItems parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTItems) POIXMLTypeLoader.parse(str, CTItems.type, xmlOptions);
        }

        public static CTItems parse(URL url) throws XmlException, IOException {
            return (CTItems) POIXMLTypeLoader.parse(url, CTItems.type, (XmlOptions) null);
        }

        public static CTItems parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTItems) POIXMLTypeLoader.parse(url, CTItems.type, xmlOptions);
        }

        public static CTItems parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTItems) POIXMLTypeLoader.parse(xMLStreamReader, CTItems.type, (XmlOptions) null);
        }

        public static CTItems parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTItems) POIXMLTypeLoader.parse(xMLStreamReader, CTItems.type, xmlOptions);
        }

        public static CTItems parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTItems) POIXMLTypeLoader.parse(xMLInputStream, CTItems.type, (XmlOptions) null);
        }

        public static CTItems parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTItems) POIXMLTypeLoader.parse(xMLInputStream, CTItems.type, xmlOptions);
        }

        public static CTItems parse(Node node) throws XmlException {
            return (CTItems) POIXMLTypeLoader.parse(node, CTItems.type, (XmlOptions) null);
        }

        public static CTItems parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTItems) POIXMLTypeLoader.parse(node, CTItems.type, xmlOptions);
        }
    }

    CTItem addNewItem();

    long getCount();

    CTItem getItemArray(int i);

    CTItem[] getItemArray();

    List<CTItem> getItemList();

    CTItem insertNewItem(int i);

    boolean isSetCount();

    void removeItem(int i);

    void setCount(long j);

    void setItemArray(int i, CTItem cTItem);

    void setItemArray(CTItem[] cTItemArr);

    int sizeOfItemArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
