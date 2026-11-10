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
public interface CTFills extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTFills.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfills2c6ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFills newInstance() {
            return (CTFills) POIXMLTypeLoader.newInstance(CTFills.type, (XmlOptions) null);
        }

        public static CTFills newInstance(XmlOptions xmlOptions) {
            return (CTFills) POIXMLTypeLoader.newInstance(CTFills.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFills.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFills.type, xmlOptions);
        }

        public static CTFills parse(File file) throws XmlException, IOException {
            return (CTFills) POIXMLTypeLoader.parse(file, CTFills.type, (XmlOptions) null);
        }

        public static CTFills parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFills) POIXMLTypeLoader.parse(file, CTFills.type, xmlOptions);
        }

        public static CTFills parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFills) POIXMLTypeLoader.parse(inputStream, CTFills.type, (XmlOptions) null);
        }

        public static CTFills parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFills) POIXMLTypeLoader.parse(inputStream, CTFills.type, xmlOptions);
        }

        public static CTFills parse(Reader reader) throws XmlException, IOException {
            return (CTFills) POIXMLTypeLoader.parse(reader, CTFills.type, (XmlOptions) null);
        }

        public static CTFills parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFills) POIXMLTypeLoader.parse(reader, CTFills.type, xmlOptions);
        }

        public static CTFills parse(String str) throws XmlException {
            return (CTFills) POIXMLTypeLoader.parse(str, CTFills.type, (XmlOptions) null);
        }

        public static CTFills parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFills) POIXMLTypeLoader.parse(str, CTFills.type, xmlOptions);
        }

        public static CTFills parse(URL url) throws XmlException, IOException {
            return (CTFills) POIXMLTypeLoader.parse(url, CTFills.type, (XmlOptions) null);
        }

        public static CTFills parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFills) POIXMLTypeLoader.parse(url, CTFills.type, xmlOptions);
        }

        public static CTFills parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFills) POIXMLTypeLoader.parse(xMLStreamReader, CTFills.type, (XmlOptions) null);
        }

        public static CTFills parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFills) POIXMLTypeLoader.parse(xMLStreamReader, CTFills.type, xmlOptions);
        }

        public static CTFills parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTFills) POIXMLTypeLoader.parse(xMLInputStream, CTFills.type, (XmlOptions) null);
        }

        public static CTFills parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTFills) POIXMLTypeLoader.parse(xMLInputStream, CTFills.type, xmlOptions);
        }

        public static CTFills parse(Node node) throws XmlException {
            return (CTFills) POIXMLTypeLoader.parse(node, CTFills.type, (XmlOptions) null);
        }

        public static CTFills parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFills) POIXMLTypeLoader.parse(node, CTFills.type, xmlOptions);
        }
    }

    CTFill addNewFill();

    long getCount();

    CTFill getFillArray(int i);

    CTFill[] getFillArray();

    List<CTFill> getFillList();

    CTFill insertNewFill(int i);

    boolean isSetCount();

    void removeFill(int i);

    void setCount(long j);

    void setFillArray(int i, CTFill cTFill);

    void setFillArray(CTFill[] cTFillArr);

    int sizeOfFillArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
