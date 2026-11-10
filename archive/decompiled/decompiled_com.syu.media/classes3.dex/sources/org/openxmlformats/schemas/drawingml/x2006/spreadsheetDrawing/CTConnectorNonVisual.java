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
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTConnectorNonVisual extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTConnectorNonVisual.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctconnectornonvisual1a74type");

    public static final class Factory {
        private Factory() {
        }

        public static CTConnectorNonVisual newInstance() {
            return (CTConnectorNonVisual) POIXMLTypeLoader.newInstance(CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual newInstance(XmlOptions xmlOptions) {
            return (CTConnectorNonVisual) POIXMLTypeLoader.newInstance(CTConnectorNonVisual.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(File file) throws XmlException, IOException {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(file, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(file, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(InputStream inputStream) throws XmlException, IOException {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(inputStream, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(inputStream, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(Reader reader) throws XmlException, IOException {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(reader, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(reader, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(String str) throws XmlException {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(str, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(str, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(URL url) throws XmlException, IOException {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(url, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(url, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(Node node) throws XmlException {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(node, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(node, CTConnectorNonVisual.type, xmlOptions);
        }
    }

    CTNonVisualConnectorProperties addNewCNvCxnSpPr();

    CTNonVisualDrawingProps addNewCNvPr();

    CTNonVisualConnectorProperties getCNvCxnSpPr();

    CTNonVisualDrawingProps getCNvPr();

    void setCNvCxnSpPr(CTNonVisualConnectorProperties cTNonVisualConnectorProperties);

    void setCNvPr(CTNonVisualDrawingProps cTNonVisualDrawingProps);
}
