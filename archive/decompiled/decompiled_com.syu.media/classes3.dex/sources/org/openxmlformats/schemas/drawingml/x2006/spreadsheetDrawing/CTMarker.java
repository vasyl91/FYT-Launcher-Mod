package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

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
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTMarker extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTMarker.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctmarkeree8etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTMarker newInstance() {
            return (CTMarker) POIXMLTypeLoader.newInstance(CTMarker.type, (XmlOptions) null);
        }

        public static CTMarker newInstance(XmlOptions xmlOptions) {
            return (CTMarker) POIXMLTypeLoader.newInstance(CTMarker.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTMarker.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTMarker.type, xmlOptions);
        }

        public static CTMarker parse(File file) throws XmlException, IOException {
            return (CTMarker) POIXMLTypeLoader.parse(file, CTMarker.type, (XmlOptions) null);
        }

        public static CTMarker parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarker) POIXMLTypeLoader.parse(file, CTMarker.type, xmlOptions);
        }

        public static CTMarker parse(InputStream inputStream) throws XmlException, IOException {
            return (CTMarker) POIXMLTypeLoader.parse(inputStream, CTMarker.type, (XmlOptions) null);
        }

        public static CTMarker parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarker) POIXMLTypeLoader.parse(inputStream, CTMarker.type, xmlOptions);
        }

        public static CTMarker parse(Reader reader) throws XmlException, IOException {
            return (CTMarker) POIXMLTypeLoader.parse(reader, CTMarker.type, (XmlOptions) null);
        }

        public static CTMarker parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarker) POIXMLTypeLoader.parse(reader, CTMarker.type, xmlOptions);
        }

        public static CTMarker parse(String str) throws XmlException {
            return (CTMarker) POIXMLTypeLoader.parse(str, CTMarker.type, (XmlOptions) null);
        }

        public static CTMarker parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTMarker) POIXMLTypeLoader.parse(str, CTMarker.type, xmlOptions);
        }

        public static CTMarker parse(URL url) throws XmlException, IOException {
            return (CTMarker) POIXMLTypeLoader.parse(url, CTMarker.type, (XmlOptions) null);
        }

        public static CTMarker parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarker) POIXMLTypeLoader.parse(url, CTMarker.type, xmlOptions);
        }

        public static CTMarker parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTMarker) POIXMLTypeLoader.parse(xMLStreamReader, CTMarker.type, (XmlOptions) null);
        }

        public static CTMarker parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTMarker) POIXMLTypeLoader.parse(xMLStreamReader, CTMarker.type, xmlOptions);
        }

        public static CTMarker parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTMarker) POIXMLTypeLoader.parse(xMLInputStream, CTMarker.type, (XmlOptions) null);
        }

        public static CTMarker parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTMarker) POIXMLTypeLoader.parse(xMLInputStream, CTMarker.type, xmlOptions);
        }

        public static CTMarker parse(Node node) throws XmlException {
            return (CTMarker) POIXMLTypeLoader.parse(node, CTMarker.type, (XmlOptions) null);
        }

        public static CTMarker parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTMarker) POIXMLTypeLoader.parse(node, CTMarker.type, xmlOptions);
        }
    }

    int getCol();

    long getColOff();

    int getRow();

    long getRowOff();

    void setCol(int i);

    void setColOff(long j);

    void setRow(int i);

    void setRowOff(long j);

    STColID xgetCol();

    STCoordinate xgetColOff();

    STRowID xgetRow();

    STCoordinate xgetRowOff();

    void xsetCol(STColID sTColID);

    void xsetColOff(STCoordinate sTCoordinate);

    void xsetRow(STRowID sTRowID);

    void xsetRowOff(STCoordinate sTCoordinate);
}
