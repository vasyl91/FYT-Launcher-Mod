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
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTGraphicalObjectFrameNonVisual extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTGraphicalObjectFrameNonVisual.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgraphicalobjectframenonvisual833ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGraphicalObjectFrameNonVisual newInstance() {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.newInstance(CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual newInstance(XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.newInstance(CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(File file) throws XmlException, IOException {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(file, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(file, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(inputStream, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(inputStream, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(Reader reader) throws XmlException, IOException {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(reader, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(reader, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(String str) throws XmlException {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(str, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(str, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(URL url) throws XmlException, IOException {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(url, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(url, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(Node node) throws XmlException {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(node, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(node, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }
    }

    CTNonVisualGraphicFrameProperties addNewCNvGraphicFramePr();

    CTNonVisualDrawingProps addNewCNvPr();

    CTNonVisualGraphicFrameProperties getCNvGraphicFramePr();

    CTNonVisualDrawingProps getCNvPr();

    void setCNvGraphicFramePr(CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties);

    void setCNvPr(CTNonVisualDrawingProps cTNonVisualDrawingProps);
}
