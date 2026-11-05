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
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTPictureNonVisual extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPictureNonVisual.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpicturenonvisualb236type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPictureNonVisual newInstance() {
            return (CTPictureNonVisual) POIXMLTypeLoader.newInstance(CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual newInstance(XmlOptions xmlOptions) {
            return (CTPictureNonVisual) POIXMLTypeLoader.newInstance(CTPictureNonVisual.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(File file) throws XmlException, IOException {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(file, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(file, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(inputStream, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(inputStream, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(Reader reader) throws XmlException, IOException {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(reader, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(reader, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(String str) throws XmlException {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(str, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(str, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(URL url) throws XmlException, IOException {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(url, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(url, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(Node node) throws XmlException {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(node, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(node, CTPictureNonVisual.type, xmlOptions);
        }
    }

    CTNonVisualPictureProperties addNewCNvPicPr();

    CTNonVisualDrawingProps addNewCNvPr();

    CTApplicationNonVisualDrawingProps addNewNvPr();

    CTNonVisualPictureProperties getCNvPicPr();

    CTNonVisualDrawingProps getCNvPr();

    CTApplicationNonVisualDrawingProps getNvPr();

    void setCNvPicPr(CTNonVisualPictureProperties cTNonVisualPictureProperties);

    void setCNvPr(CTNonVisualDrawingProps cTNonVisualDrawingProps);

    void setNvPr(CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps);
}
