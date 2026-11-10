package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTTblBorders extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTblBorders.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttblborders459ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblBorders newInstance() {
            return (CTTblBorders) POIXMLTypeLoader.newInstance(CTTblBorders.type, (XmlOptions) null);
        }

        public static CTTblBorders newInstance(XmlOptions xmlOptions) {
            return (CTTblBorders) POIXMLTypeLoader.newInstance(CTTblBorders.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblBorders.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblBorders.type, xmlOptions);
        }

        public static CTTblBorders parse(File file) throws XmlException, IOException {
            return (CTTblBorders) POIXMLTypeLoader.parse(file, CTTblBorders.type, (XmlOptions) null);
        }

        public static CTTblBorders parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblBorders) POIXMLTypeLoader.parse(file, CTTblBorders.type, xmlOptions);
        }

        public static CTTblBorders parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTblBorders) POIXMLTypeLoader.parse(inputStream, CTTblBorders.type, (XmlOptions) null);
        }

        public static CTTblBorders parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblBorders) POIXMLTypeLoader.parse(inputStream, CTTblBorders.type, xmlOptions);
        }

        public static CTTblBorders parse(Reader reader) throws XmlException, IOException {
            return (CTTblBorders) POIXMLTypeLoader.parse(reader, CTTblBorders.type, (XmlOptions) null);
        }

        public static CTTblBorders parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblBorders) POIXMLTypeLoader.parse(reader, CTTblBorders.type, xmlOptions);
        }

        public static CTTblBorders parse(String str) throws XmlException {
            return (CTTblBorders) POIXMLTypeLoader.parse(str, CTTblBorders.type, (XmlOptions) null);
        }

        public static CTTblBorders parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTblBorders) POIXMLTypeLoader.parse(str, CTTblBorders.type, xmlOptions);
        }

        public static CTTblBorders parse(URL url) throws XmlException, IOException {
            return (CTTblBorders) POIXMLTypeLoader.parse(url, CTTblBorders.type, (XmlOptions) null);
        }

        public static CTTblBorders parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblBorders) POIXMLTypeLoader.parse(url, CTTblBorders.type, xmlOptions);
        }

        public static CTTblBorders parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTblBorders) POIXMLTypeLoader.parse(xMLStreamReader, CTTblBorders.type, (XmlOptions) null);
        }

        public static CTTblBorders parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTblBorders) POIXMLTypeLoader.parse(xMLStreamReader, CTTblBorders.type, xmlOptions);
        }

        public static CTTblBorders parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTblBorders) POIXMLTypeLoader.parse(xMLInputStream, CTTblBorders.type, (XmlOptions) null);
        }

        public static CTTblBorders parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTblBorders) POIXMLTypeLoader.parse(xMLInputStream, CTTblBorders.type, xmlOptions);
        }

        public static CTTblBorders parse(Node node) throws XmlException {
            return (CTTblBorders) POIXMLTypeLoader.parse(node, CTTblBorders.type, (XmlOptions) null);
        }

        public static CTTblBorders parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTblBorders) POIXMLTypeLoader.parse(node, CTTblBorders.type, xmlOptions);
        }
    }

    CTBorder addNewBottom();

    CTBorder addNewInsideH();

    CTBorder addNewInsideV();

    CTBorder addNewLeft();

    CTBorder addNewRight();

    CTBorder addNewTop();

    CTBorder getBottom();

    CTBorder getInsideH();

    CTBorder getInsideV();

    CTBorder getLeft();

    CTBorder getRight();

    CTBorder getTop();

    boolean isSetBottom();

    boolean isSetInsideH();

    boolean isSetInsideV();

    boolean isSetLeft();

    boolean isSetRight();

    boolean isSetTop();

    void setBottom(CTBorder cTBorder);

    void setInsideH(CTBorder cTBorder);

    void setInsideV(CTBorder cTBorder);

    void setLeft(CTBorder cTBorder);

    void setRight(CTBorder cTBorder);

    void setTop(CTBorder cTBorder);

    void unsetBottom();

    void unsetInsideH();

    void unsetInsideV();

    void unsetLeft();

    void unsetRight();

    void unsetTop();
}
