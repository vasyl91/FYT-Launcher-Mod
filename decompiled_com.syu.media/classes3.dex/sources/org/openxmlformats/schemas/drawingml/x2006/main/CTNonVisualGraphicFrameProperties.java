package org.openxmlformats.schemas.drawingml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTNonVisualGraphicFrameProperties extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTNonVisualGraphicFrameProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnonvisualgraphicframeproperties43b6type");

    public static final class Factory {
        private Factory() {
        }

        public static CTNonVisualGraphicFrameProperties newInstance() {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.newInstance(CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties newInstance(XmlOptions xmlOptions) {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.newInstance(CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(File file) throws XmlException, IOException {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(file, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(file, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(inputStream, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(inputStream, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(Reader reader) throws XmlException, IOException {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(reader, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(reader, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(String str) throws XmlException {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(str, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(str, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(URL url) throws XmlException, IOException {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(url, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(url, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(xMLInputStream, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(xMLInputStream, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(Node node) throws XmlException {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(node, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(node, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTGraphicalObjectFrameLocking addNewGraphicFrameLocks();

    CTOfficeArtExtensionList getExtLst();

    CTGraphicalObjectFrameLocking getGraphicFrameLocks();

    boolean isSetExtLst();

    boolean isSetGraphicFrameLocks();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setGraphicFrameLocks(CTGraphicalObjectFrameLocking cTGraphicalObjectFrameLocking);

    void unsetExtLst();

    void unsetGraphicFrameLocks();
}
