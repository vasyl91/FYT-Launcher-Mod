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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingShapeProps;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTShapeNonVisual extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTShapeNonVisual.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctshapenonvisualb619type");

    public static final class Factory {
        private Factory() {
        }

        public static CTShapeNonVisual newInstance() {
            return (CTShapeNonVisual) POIXMLTypeLoader.newInstance(CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual newInstance(XmlOptions xmlOptions) {
            return (CTShapeNonVisual) POIXMLTypeLoader.newInstance(CTShapeNonVisual.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(File file) throws XmlException, IOException {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(file, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(file, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(InputStream inputStream) throws XmlException, IOException {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(inputStream, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(inputStream, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(Reader reader) throws XmlException, IOException {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(reader, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(reader, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(String str) throws XmlException {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(str, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(str, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(URL url) throws XmlException, IOException {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(url, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(url, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(Node node) throws XmlException {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(node, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(node, CTShapeNonVisual.type, xmlOptions);
        }
    }

    CTNonVisualDrawingProps addNewCNvPr();

    CTNonVisualDrawingShapeProps addNewCNvSpPr();

    CTApplicationNonVisualDrawingProps addNewNvPr();

    CTNonVisualDrawingProps getCNvPr();

    CTNonVisualDrawingShapeProps getCNvSpPr();

    CTApplicationNonVisualDrawingProps getNvPr();

    void setCNvPr(CTNonVisualDrawingProps cTNonVisualDrawingProps);

    void setCNvSpPr(CTNonVisualDrawingShapeProps cTNonVisualDrawingShapeProps);

    void setNvPr(CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps);
}
