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
public interface CTCellXfs extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTCellXfs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcellxfs1322type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCellXfs newInstance() {
            return (CTCellXfs) POIXMLTypeLoader.newInstance(CTCellXfs.type, (XmlOptions) null);
        }

        public static CTCellXfs newInstance(XmlOptions xmlOptions) {
            return (CTCellXfs) POIXMLTypeLoader.newInstance(CTCellXfs.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCellXfs.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCellXfs.type, xmlOptions);
        }

        public static CTCellXfs parse(File file) throws XmlException, IOException {
            return (CTCellXfs) POIXMLTypeLoader.parse(file, CTCellXfs.type, (XmlOptions) null);
        }

        public static CTCellXfs parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellXfs) POIXMLTypeLoader.parse(file, CTCellXfs.type, xmlOptions);
        }

        public static CTCellXfs parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCellXfs) POIXMLTypeLoader.parse(inputStream, CTCellXfs.type, (XmlOptions) null);
        }

        public static CTCellXfs parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellXfs) POIXMLTypeLoader.parse(inputStream, CTCellXfs.type, xmlOptions);
        }

        public static CTCellXfs parse(Reader reader) throws XmlException, IOException {
            return (CTCellXfs) POIXMLTypeLoader.parse(reader, CTCellXfs.type, (XmlOptions) null);
        }

        public static CTCellXfs parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellXfs) POIXMLTypeLoader.parse(reader, CTCellXfs.type, xmlOptions);
        }

        public static CTCellXfs parse(String str) throws XmlException {
            return (CTCellXfs) POIXMLTypeLoader.parse(str, CTCellXfs.type, (XmlOptions) null);
        }

        public static CTCellXfs parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCellXfs) POIXMLTypeLoader.parse(str, CTCellXfs.type, xmlOptions);
        }

        public static CTCellXfs parse(URL url) throws XmlException, IOException {
            return (CTCellXfs) POIXMLTypeLoader.parse(url, CTCellXfs.type, (XmlOptions) null);
        }

        public static CTCellXfs parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellXfs) POIXMLTypeLoader.parse(url, CTCellXfs.type, xmlOptions);
        }

        public static CTCellXfs parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCellXfs) POIXMLTypeLoader.parse(xMLStreamReader, CTCellXfs.type, (XmlOptions) null);
        }

        public static CTCellXfs parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCellXfs) POIXMLTypeLoader.parse(xMLStreamReader, CTCellXfs.type, xmlOptions);
        }

        public static CTCellXfs parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTCellXfs) POIXMLTypeLoader.parse(xMLInputStream, CTCellXfs.type, (XmlOptions) null);
        }

        public static CTCellXfs parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTCellXfs) POIXMLTypeLoader.parse(xMLInputStream, CTCellXfs.type, xmlOptions);
        }

        public static CTCellXfs parse(Node node) throws XmlException {
            return (CTCellXfs) POIXMLTypeLoader.parse(node, CTCellXfs.type, (XmlOptions) null);
        }

        public static CTCellXfs parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCellXfs) POIXMLTypeLoader.parse(node, CTCellXfs.type, xmlOptions);
        }
    }

    CTXf addNewXf();

    long getCount();

    CTXf getXfArray(int i);

    CTXf[] getXfArray();

    List<CTXf> getXfList();

    CTXf insertNewXf(int i);

    boolean isSetCount();

    void removeXf(int i);

    void setCount(long j);

    void setXfArray(int i, CTXf cTXf);

    void setXfArray(CTXf[] cTXfArr);

    int sizeOfXfArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
