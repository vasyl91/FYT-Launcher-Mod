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
public interface CTNonVisualGroupDrawingShapeProps extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTNonVisualGroupDrawingShapeProps.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnonvisualgroupdrawingshapeprops610ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTNonVisualGroupDrawingShapeProps newInstance() {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.newInstance(CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps newInstance(XmlOptions xmlOptions) {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.newInstance(CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(File file) throws XmlException, IOException {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(file, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(file, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(inputStream, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(inputStream, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(Reader reader) throws XmlException, IOException {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(reader, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(reader, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(String str) throws XmlException {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(str, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(str, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(URL url) throws XmlException, IOException {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(url, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(url, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(xMLStreamReader, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(xMLStreamReader, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(xMLInputStream, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(xMLInputStream, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(Node node) throws XmlException {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(node, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(node, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTGroupLocking addNewGrpSpLocks();

    CTOfficeArtExtensionList getExtLst();

    CTGroupLocking getGrpSpLocks();

    boolean isSetExtLst();

    boolean isSetGrpSpLocks();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setGrpSpLocks(CTGroupLocking cTGroupLocking);

    void unsetExtLst();

    void unsetGrpSpLocks();
}
