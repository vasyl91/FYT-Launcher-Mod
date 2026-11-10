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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTSingleXmlCell extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSingleXmlCell.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsinglexmlcell7790type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSingleXmlCell newInstance() {
            return (CTSingleXmlCell) POIXMLTypeLoader.newInstance(CTSingleXmlCell.type, (XmlOptions) null);
        }

        public static CTSingleXmlCell newInstance(XmlOptions xmlOptions) {
            return (CTSingleXmlCell) POIXMLTypeLoader.newInstance(CTSingleXmlCell.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSingleXmlCell.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSingleXmlCell.type, xmlOptions);
        }

        public static CTSingleXmlCell parse(File file) throws XmlException, IOException {
            return (CTSingleXmlCell) POIXMLTypeLoader.parse(file, CTSingleXmlCell.type, (XmlOptions) null);
        }

        public static CTSingleXmlCell parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSingleXmlCell) POIXMLTypeLoader.parse(file, CTSingleXmlCell.type, xmlOptions);
        }

        public static CTSingleXmlCell parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSingleXmlCell) POIXMLTypeLoader.parse(inputStream, CTSingleXmlCell.type, (XmlOptions) null);
        }

        public static CTSingleXmlCell parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSingleXmlCell) POIXMLTypeLoader.parse(inputStream, CTSingleXmlCell.type, xmlOptions);
        }

        public static CTSingleXmlCell parse(Reader reader) throws XmlException, IOException {
            return (CTSingleXmlCell) POIXMLTypeLoader.parse(reader, CTSingleXmlCell.type, (XmlOptions) null);
        }

        public static CTSingleXmlCell parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSingleXmlCell) POIXMLTypeLoader.parse(reader, CTSingleXmlCell.type, xmlOptions);
        }

        public static CTSingleXmlCell parse(String str) throws XmlException {
            return (CTSingleXmlCell) POIXMLTypeLoader.parse(str, CTSingleXmlCell.type, (XmlOptions) null);
        }

        public static CTSingleXmlCell parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSingleXmlCell) POIXMLTypeLoader.parse(str, CTSingleXmlCell.type, xmlOptions);
        }

        public static CTSingleXmlCell parse(URL url) throws XmlException, IOException {
            return (CTSingleXmlCell) POIXMLTypeLoader.parse(url, CTSingleXmlCell.type, (XmlOptions) null);
        }

        public static CTSingleXmlCell parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSingleXmlCell) POIXMLTypeLoader.parse(url, CTSingleXmlCell.type, xmlOptions);
        }

        public static CTSingleXmlCell parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSingleXmlCell) POIXMLTypeLoader.parse(xMLStreamReader, CTSingleXmlCell.type, (XmlOptions) null);
        }

        public static CTSingleXmlCell parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSingleXmlCell) POIXMLTypeLoader.parse(xMLStreamReader, CTSingleXmlCell.type, xmlOptions);
        }

        public static CTSingleXmlCell parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSingleXmlCell) POIXMLTypeLoader.parse(xMLInputStream, CTSingleXmlCell.type, (XmlOptions) null);
        }

        public static CTSingleXmlCell parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSingleXmlCell) POIXMLTypeLoader.parse(xMLInputStream, CTSingleXmlCell.type, xmlOptions);
        }

        public static CTSingleXmlCell parse(Node node) throws XmlException {
            return (CTSingleXmlCell) POIXMLTypeLoader.parse(node, CTSingleXmlCell.type, (XmlOptions) null);
        }

        public static CTSingleXmlCell parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSingleXmlCell) POIXMLTypeLoader.parse(node, CTSingleXmlCell.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTXmlCellPr addNewXmlCellPr();

    long getConnectionId();

    CTExtensionList getExtLst();

    long getId();

    String getR();

    CTXmlCellPr getXmlCellPr();

    boolean isSetExtLst();

    void setConnectionId(long j);

    void setExtLst(CTExtensionList cTExtensionList);

    void setId(long j);

    void setR(String str);

    void setXmlCellPr(CTXmlCellPr cTXmlCellPr);

    void unsetExtLst();

    XmlUnsignedInt xgetConnectionId();

    XmlUnsignedInt xgetId();

    STCellRef xgetR();

    void xsetConnectionId(XmlUnsignedInt xmlUnsignedInt);

    void xsetId(XmlUnsignedInt xmlUnsignedInt);

    void xsetR(STCellRef sTCellRef);
}
