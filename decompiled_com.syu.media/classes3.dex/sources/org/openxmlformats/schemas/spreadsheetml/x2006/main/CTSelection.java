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
public interface CTSelection extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSelection.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctselectionca2btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSelection newInstance() {
            return (CTSelection) POIXMLTypeLoader.newInstance(CTSelection.type, (XmlOptions) null);
        }

        public static CTSelection newInstance(XmlOptions xmlOptions) {
            return (CTSelection) POIXMLTypeLoader.newInstance(CTSelection.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSelection.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSelection.type, xmlOptions);
        }

        public static CTSelection parse(File file) throws XmlException, IOException {
            return (CTSelection) POIXMLTypeLoader.parse(file, CTSelection.type, (XmlOptions) null);
        }

        public static CTSelection parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSelection) POIXMLTypeLoader.parse(file, CTSelection.type, xmlOptions);
        }

        public static CTSelection parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSelection) POIXMLTypeLoader.parse(inputStream, CTSelection.type, (XmlOptions) null);
        }

        public static CTSelection parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSelection) POIXMLTypeLoader.parse(inputStream, CTSelection.type, xmlOptions);
        }

        public static CTSelection parse(Reader reader) throws XmlException, IOException {
            return (CTSelection) POIXMLTypeLoader.parse(reader, CTSelection.type, (XmlOptions) null);
        }

        public static CTSelection parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSelection) POIXMLTypeLoader.parse(reader, CTSelection.type, xmlOptions);
        }

        public static CTSelection parse(String str) throws XmlException {
            return (CTSelection) POIXMLTypeLoader.parse(str, CTSelection.type, (XmlOptions) null);
        }

        public static CTSelection parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSelection) POIXMLTypeLoader.parse(str, CTSelection.type, xmlOptions);
        }

        public static CTSelection parse(URL url) throws XmlException, IOException {
            return (CTSelection) POIXMLTypeLoader.parse(url, CTSelection.type, (XmlOptions) null);
        }

        public static CTSelection parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSelection) POIXMLTypeLoader.parse(url, CTSelection.type, xmlOptions);
        }

        public static CTSelection parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSelection) POIXMLTypeLoader.parse(xMLStreamReader, CTSelection.type, (XmlOptions) null);
        }

        public static CTSelection parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSelection) POIXMLTypeLoader.parse(xMLStreamReader, CTSelection.type, xmlOptions);
        }

        public static CTSelection parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSelection) POIXMLTypeLoader.parse(xMLInputStream, CTSelection.type, (XmlOptions) null);
        }

        public static CTSelection parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSelection) POIXMLTypeLoader.parse(xMLInputStream, CTSelection.type, xmlOptions);
        }

        public static CTSelection parse(Node node) throws XmlException {
            return (CTSelection) POIXMLTypeLoader.parse(node, CTSelection.type, (XmlOptions) null);
        }

        public static CTSelection parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSelection) POIXMLTypeLoader.parse(node, CTSelection.type, xmlOptions);
        }
    }

    String getActiveCell();

    long getActiveCellId();

    STPane.Enum getPane();

    List getSqref();

    boolean isSetActiveCell();

    boolean isSetActiveCellId();

    boolean isSetPane();

    boolean isSetSqref();

    void setActiveCell(String str);

    void setActiveCellId(long j);

    void setPane(STPane.Enum r1);

    void setSqref(List list);

    void unsetActiveCell();

    void unsetActiveCellId();

    void unsetPane();

    void unsetSqref();

    STCellRef xgetActiveCell();

    XmlUnsignedInt xgetActiveCellId();

    STPane xgetPane();

    STSqref xgetSqref();

    void xsetActiveCell(STCellRef sTCellRef);

    void xsetActiveCellId(XmlUnsignedInt xmlUnsignedInt);

    void xsetPane(STPane sTPane);

    void xsetSqref(STSqref sTSqref);
}
