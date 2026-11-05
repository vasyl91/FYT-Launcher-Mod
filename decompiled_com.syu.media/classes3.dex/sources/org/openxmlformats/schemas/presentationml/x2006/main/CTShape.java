package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTShape extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTShape.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctshapecfcetype");

    public static final class Factory {
        private Factory() {
        }

        public static CTShape newInstance() {
            return (CTShape) POIXMLTypeLoader.newInstance(CTShape.type, (XmlOptions) null);
        }

        public static CTShape newInstance(XmlOptions xmlOptions) {
            return (CTShape) POIXMLTypeLoader.newInstance(CTShape.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShape.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShape.type, xmlOptions);
        }

        public static CTShape parse(File file) throws XmlException, IOException {
            return (CTShape) POIXMLTypeLoader.parse(file, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShape) POIXMLTypeLoader.parse(file, CTShape.type, xmlOptions);
        }

        public static CTShape parse(InputStream inputStream) throws XmlException, IOException {
            return (CTShape) POIXMLTypeLoader.parse(inputStream, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShape) POIXMLTypeLoader.parse(inputStream, CTShape.type, xmlOptions);
        }

        public static CTShape parse(Reader reader) throws XmlException, IOException {
            return (CTShape) POIXMLTypeLoader.parse(reader, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShape) POIXMLTypeLoader.parse(reader, CTShape.type, xmlOptions);
        }

        public static CTShape parse(String str) throws XmlException {
            return (CTShape) POIXMLTypeLoader.parse(str, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTShape) POIXMLTypeLoader.parse(str, CTShape.type, xmlOptions);
        }

        public static CTShape parse(URL url) throws XmlException, IOException {
            return (CTShape) POIXMLTypeLoader.parse(url, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShape) POIXMLTypeLoader.parse(url, CTShape.type, xmlOptions);
        }

        public static CTShape parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTShape) POIXMLTypeLoader.parse(xMLStreamReader, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTShape) POIXMLTypeLoader.parse(xMLStreamReader, CTShape.type, xmlOptions);
        }

        public static CTShape parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTShape) POIXMLTypeLoader.parse(xMLInputStream, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTShape) POIXMLTypeLoader.parse(xMLInputStream, CTShape.type, xmlOptions);
        }

        public static CTShape parse(Node node) throws XmlException {
            return (CTShape) POIXMLTypeLoader.parse(node, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTShape) POIXMLTypeLoader.parse(node, CTShape.type, xmlOptions);
        }
    }

    CTExtensionListModify addNewExtLst();

    CTShapeNonVisual addNewNvSpPr();

    CTShapeProperties addNewSpPr();

    CTShapeStyle addNewStyle();

    CTTextBody addNewTxBody();

    CTExtensionListModify getExtLst();

    CTShapeNonVisual getNvSpPr();

    CTShapeProperties getSpPr();

    CTShapeStyle getStyle();

    CTTextBody getTxBody();

    boolean getUseBgFill();

    boolean isSetExtLst();

    boolean isSetStyle();

    boolean isSetTxBody();

    boolean isSetUseBgFill();

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setNvSpPr(CTShapeNonVisual cTShapeNonVisual);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setStyle(CTShapeStyle cTShapeStyle);

    void setTxBody(CTTextBody cTTextBody);

    void setUseBgFill(boolean z);

    void unsetExtLst();

    void unsetStyle();

    void unsetTxBody();

    void unsetUseBgFill();

    XmlBoolean xgetUseBgFill();

    void xsetUseBgFill(XmlBoolean xmlBoolean);
}
