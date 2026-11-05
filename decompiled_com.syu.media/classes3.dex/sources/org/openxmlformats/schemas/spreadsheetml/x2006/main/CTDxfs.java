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
public interface CTDxfs extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTDxfs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdxfsb26atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTDxfs newInstance() {
            return (CTDxfs) POIXMLTypeLoader.newInstance(CTDxfs.type, (XmlOptions) null);
        }

        public static CTDxfs newInstance(XmlOptions xmlOptions) {
            return (CTDxfs) POIXMLTypeLoader.newInstance(CTDxfs.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDxfs.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDxfs.type, xmlOptions);
        }

        public static CTDxfs parse(File file) throws XmlException, IOException {
            return (CTDxfs) POIXMLTypeLoader.parse(file, CTDxfs.type, (XmlOptions) null);
        }

        public static CTDxfs parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDxfs) POIXMLTypeLoader.parse(file, CTDxfs.type, xmlOptions);
        }

        public static CTDxfs parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDxfs) POIXMLTypeLoader.parse(inputStream, CTDxfs.type, (XmlOptions) null);
        }

        public static CTDxfs parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDxfs) POIXMLTypeLoader.parse(inputStream, CTDxfs.type, xmlOptions);
        }

        public static CTDxfs parse(Reader reader) throws XmlException, IOException {
            return (CTDxfs) POIXMLTypeLoader.parse(reader, CTDxfs.type, (XmlOptions) null);
        }

        public static CTDxfs parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDxfs) POIXMLTypeLoader.parse(reader, CTDxfs.type, xmlOptions);
        }

        public static CTDxfs parse(String str) throws XmlException {
            return (CTDxfs) POIXMLTypeLoader.parse(str, CTDxfs.type, (XmlOptions) null);
        }

        public static CTDxfs parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDxfs) POIXMLTypeLoader.parse(str, CTDxfs.type, xmlOptions);
        }

        public static CTDxfs parse(URL url) throws XmlException, IOException {
            return (CTDxfs) POIXMLTypeLoader.parse(url, CTDxfs.type, (XmlOptions) null);
        }

        public static CTDxfs parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDxfs) POIXMLTypeLoader.parse(url, CTDxfs.type, xmlOptions);
        }

        public static CTDxfs parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDxfs) POIXMLTypeLoader.parse(xMLStreamReader, CTDxfs.type, (XmlOptions) null);
        }

        public static CTDxfs parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDxfs) POIXMLTypeLoader.parse(xMLStreamReader, CTDxfs.type, xmlOptions);
        }

        public static CTDxfs parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTDxfs) POIXMLTypeLoader.parse(xMLInputStream, CTDxfs.type, (XmlOptions) null);
        }

        public static CTDxfs parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTDxfs) POIXMLTypeLoader.parse(xMLInputStream, CTDxfs.type, xmlOptions);
        }

        public static CTDxfs parse(Node node) throws XmlException {
            return (CTDxfs) POIXMLTypeLoader.parse(node, CTDxfs.type, (XmlOptions) null);
        }

        public static CTDxfs parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDxfs) POIXMLTypeLoader.parse(node, CTDxfs.type, xmlOptions);
        }
    }

    CTDxf addNewDxf();

    long getCount();

    CTDxf getDxfArray(int i);

    CTDxf[] getDxfArray();

    List<CTDxf> getDxfList();

    CTDxf insertNewDxf(int i);

    boolean isSetCount();

    void removeDxf(int i);

    void setCount(long j);

    void setDxfArray(int i, CTDxf cTDxf);

    void setDxfArray(CTDxf[] cTDxfArr);

    int sizeOfDxfArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
