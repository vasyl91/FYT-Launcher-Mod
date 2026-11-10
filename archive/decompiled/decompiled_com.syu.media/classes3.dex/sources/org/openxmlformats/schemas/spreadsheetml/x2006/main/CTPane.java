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
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTPane extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPane.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpaneaab1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPane newInstance() {
            return (CTPane) POIXMLTypeLoader.newInstance(CTPane.type, (XmlOptions) null);
        }

        public static CTPane newInstance(XmlOptions xmlOptions) {
            return (CTPane) POIXMLTypeLoader.newInstance(CTPane.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPane.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPane.type, xmlOptions);
        }

        public static CTPane parse(File file) throws XmlException, IOException {
            return (CTPane) POIXMLTypeLoader.parse(file, CTPane.type, (XmlOptions) null);
        }

        public static CTPane parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPane) POIXMLTypeLoader.parse(file, CTPane.type, xmlOptions);
        }

        public static CTPane parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPane) POIXMLTypeLoader.parse(inputStream, CTPane.type, (XmlOptions) null);
        }

        public static CTPane parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPane) POIXMLTypeLoader.parse(inputStream, CTPane.type, xmlOptions);
        }

        public static CTPane parse(Reader reader) throws XmlException, IOException {
            return (CTPane) POIXMLTypeLoader.parse(reader, CTPane.type, (XmlOptions) null);
        }

        public static CTPane parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPane) POIXMLTypeLoader.parse(reader, CTPane.type, xmlOptions);
        }

        public static CTPane parse(String str) throws XmlException {
            return (CTPane) POIXMLTypeLoader.parse(str, CTPane.type, (XmlOptions) null);
        }

        public static CTPane parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPane) POIXMLTypeLoader.parse(str, CTPane.type, xmlOptions);
        }

        public static CTPane parse(URL url) throws XmlException, IOException {
            return (CTPane) POIXMLTypeLoader.parse(url, CTPane.type, (XmlOptions) null);
        }

        public static CTPane parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPane) POIXMLTypeLoader.parse(url, CTPane.type, xmlOptions);
        }

        public static CTPane parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPane) POIXMLTypeLoader.parse(xMLStreamReader, CTPane.type, (XmlOptions) null);
        }

        public static CTPane parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPane) POIXMLTypeLoader.parse(xMLStreamReader, CTPane.type, xmlOptions);
        }

        public static CTPane parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPane) POIXMLTypeLoader.parse(xMLInputStream, CTPane.type, (XmlOptions) null);
        }

        public static CTPane parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPane) POIXMLTypeLoader.parse(xMLInputStream, CTPane.type, xmlOptions);
        }

        public static CTPane parse(Node node) throws XmlException {
            return (CTPane) POIXMLTypeLoader.parse(node, CTPane.type, (XmlOptions) null);
        }

        public static CTPane parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPane) POIXMLTypeLoader.parse(node, CTPane.type, xmlOptions);
        }
    }

    STPane.Enum getActivePane();

    STPaneState.Enum getState();

    String getTopLeftCell();

    double getXSplit();

    double getYSplit();

    boolean isSetActivePane();

    boolean isSetState();

    boolean isSetTopLeftCell();

    boolean isSetXSplit();

    boolean isSetYSplit();

    void setActivePane(STPane.Enum r1);

    void setState(STPaneState.Enum r1);

    void setTopLeftCell(String str);

    void setXSplit(double d);

    void setYSplit(double d);

    void unsetActivePane();

    void unsetState();

    void unsetTopLeftCell();

    void unsetXSplit();

    void unsetYSplit();

    STPane xgetActivePane();

    STPaneState xgetState();

    STCellRef xgetTopLeftCell();

    XmlDouble xgetXSplit();

    XmlDouble xgetYSplit();

    void xsetActivePane(STPane sTPane);

    void xsetState(STPaneState sTPaneState);

    void xsetTopLeftCell(STCellRef sTCellRef);

    void xsetXSplit(XmlDouble xmlDouble);

    void xsetYSplit(XmlDouble xmlDouble);
}
