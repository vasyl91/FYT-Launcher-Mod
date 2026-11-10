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
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTGroupShapeNonVisual extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTGroupShapeNonVisual.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgroupshapenonvisual5a55type");

    public static final class Factory {
        private Factory() {
        }

        public static CTGroupShapeNonVisual newInstance() {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.newInstance(CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual newInstance(XmlOptions xmlOptions) {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.newInstance(CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(File file) throws XmlException, IOException {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(file, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(file, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(inputStream, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(inputStream, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(Reader reader) throws XmlException, IOException {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(reader, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(reader, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(String str) throws XmlException {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(str, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(str, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(URL url) throws XmlException, IOException {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(url, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(url, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(Node node) throws XmlException {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(node, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(node, CTGroupShapeNonVisual.type, xmlOptions);
        }
    }

    CTNonVisualGroupDrawingShapeProps addNewCNvGrpSpPr();

    CTNonVisualDrawingProps addNewCNvPr();

    CTNonVisualGroupDrawingShapeProps getCNvGrpSpPr();

    CTNonVisualDrawingProps getCNvPr();

    void setCNvGrpSpPr(CTNonVisualGroupDrawingShapeProps cTNonVisualGroupDrawingShapeProps);

    void setCNvPr(CTNonVisualDrawingProps cTNonVisualDrawingProps);
}
