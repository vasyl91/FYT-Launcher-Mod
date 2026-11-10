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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTBorder extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTBorder.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctborderf935type");

    public static final class Factory {
        private Factory() {
        }

        public static CTBorder newInstance() {
            return (CTBorder) POIXMLTypeLoader.newInstance(CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder newInstance(XmlOptions xmlOptions) {
            return (CTBorder) POIXMLTypeLoader.newInstance(CTBorder.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBorder.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(File file) throws XmlException, IOException {
            return (CTBorder) POIXMLTypeLoader.parse(file, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBorder) POIXMLTypeLoader.parse(file, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBorder) POIXMLTypeLoader.parse(inputStream, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBorder) POIXMLTypeLoader.parse(inputStream, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(Reader reader) throws XmlException, IOException {
            return (CTBorder) POIXMLTypeLoader.parse(reader, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBorder) POIXMLTypeLoader.parse(reader, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(String str) throws XmlException {
            return (CTBorder) POIXMLTypeLoader.parse(str, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBorder) POIXMLTypeLoader.parse(str, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(URL url) throws XmlException, IOException {
            return (CTBorder) POIXMLTypeLoader.parse(url, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBorder) POIXMLTypeLoader.parse(url, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBorder) POIXMLTypeLoader.parse(xMLStreamReader, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBorder) POIXMLTypeLoader.parse(xMLStreamReader, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTBorder) POIXMLTypeLoader.parse(xMLInputStream, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTBorder) POIXMLTypeLoader.parse(xMLInputStream, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(Node node) throws XmlException {
            return (CTBorder) POIXMLTypeLoader.parse(node, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBorder) POIXMLTypeLoader.parse(node, CTBorder.type, xmlOptions);
        }
    }

    CTBorderPr addNewBottom();

    CTBorderPr addNewDiagonal();

    CTBorderPr addNewHorizontal();

    CTBorderPr addNewLeft();

    CTBorderPr addNewRight();

    CTBorderPr addNewTop();

    CTBorderPr addNewVertical();

    CTBorderPr getBottom();

    CTBorderPr getDiagonal();

    boolean getDiagonalDown();

    boolean getDiagonalUp();

    CTBorderPr getHorizontal();

    CTBorderPr getLeft();

    boolean getOutline();

    CTBorderPr getRight();

    CTBorderPr getTop();

    CTBorderPr getVertical();

    boolean isSetBottom();

    boolean isSetDiagonal();

    boolean isSetDiagonalDown();

    boolean isSetDiagonalUp();

    boolean isSetHorizontal();

    boolean isSetLeft();

    boolean isSetOutline();

    boolean isSetRight();

    boolean isSetTop();

    boolean isSetVertical();

    void setBottom(CTBorderPr cTBorderPr);

    void setDiagonal(CTBorderPr cTBorderPr);

    void setDiagonalDown(boolean z);

    void setDiagonalUp(boolean z);

    void setHorizontal(CTBorderPr cTBorderPr);

    void setLeft(CTBorderPr cTBorderPr);

    void setOutline(boolean z);

    void setRight(CTBorderPr cTBorderPr);

    void setTop(CTBorderPr cTBorderPr);

    void setVertical(CTBorderPr cTBorderPr);

    void unsetBottom();

    void unsetDiagonal();

    void unsetDiagonalDown();

    void unsetDiagonalUp();

    void unsetHorizontal();

    void unsetLeft();

    void unsetOutline();

    void unsetRight();

    void unsetTop();

    void unsetVertical();

    XmlBoolean xgetDiagonalDown();

    XmlBoolean xgetDiagonalUp();

    XmlBoolean xgetOutline();

    void xsetDiagonalDown(XmlBoolean xmlBoolean);

    void xsetDiagonalUp(XmlBoolean xmlBoolean);

    void xsetOutline(XmlBoolean xmlBoolean);
}
