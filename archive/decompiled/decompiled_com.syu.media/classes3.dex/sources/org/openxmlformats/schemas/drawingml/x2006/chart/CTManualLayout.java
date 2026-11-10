package org.openxmlformats.schemas.drawingml.x2006.chart;

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
public interface CTManualLayout extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTManualLayout.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctmanuallayout872ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTManualLayout newInstance() {
            return (CTManualLayout) POIXMLTypeLoader.newInstance(CTManualLayout.type, (XmlOptions) null);
        }

        public static CTManualLayout newInstance(XmlOptions xmlOptions) {
            return (CTManualLayout) POIXMLTypeLoader.newInstance(CTManualLayout.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTManualLayout.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTManualLayout.type, xmlOptions);
        }

        public static CTManualLayout parse(File file) throws XmlException, IOException {
            return (CTManualLayout) POIXMLTypeLoader.parse(file, CTManualLayout.type, (XmlOptions) null);
        }

        public static CTManualLayout parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTManualLayout) POIXMLTypeLoader.parse(file, CTManualLayout.type, xmlOptions);
        }

        public static CTManualLayout parse(InputStream inputStream) throws XmlException, IOException {
            return (CTManualLayout) POIXMLTypeLoader.parse(inputStream, CTManualLayout.type, (XmlOptions) null);
        }

        public static CTManualLayout parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTManualLayout) POIXMLTypeLoader.parse(inputStream, CTManualLayout.type, xmlOptions);
        }

        public static CTManualLayout parse(Reader reader) throws XmlException, IOException {
            return (CTManualLayout) POIXMLTypeLoader.parse(reader, CTManualLayout.type, (XmlOptions) null);
        }

        public static CTManualLayout parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTManualLayout) POIXMLTypeLoader.parse(reader, CTManualLayout.type, xmlOptions);
        }

        public static CTManualLayout parse(String str) throws XmlException {
            return (CTManualLayout) POIXMLTypeLoader.parse(str, CTManualLayout.type, (XmlOptions) null);
        }

        public static CTManualLayout parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTManualLayout) POIXMLTypeLoader.parse(str, CTManualLayout.type, xmlOptions);
        }

        public static CTManualLayout parse(URL url) throws XmlException, IOException {
            return (CTManualLayout) POIXMLTypeLoader.parse(url, CTManualLayout.type, (XmlOptions) null);
        }

        public static CTManualLayout parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTManualLayout) POIXMLTypeLoader.parse(url, CTManualLayout.type, xmlOptions);
        }

        public static CTManualLayout parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTManualLayout) POIXMLTypeLoader.parse(xMLStreamReader, CTManualLayout.type, (XmlOptions) null);
        }

        public static CTManualLayout parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTManualLayout) POIXMLTypeLoader.parse(xMLStreamReader, CTManualLayout.type, xmlOptions);
        }

        public static CTManualLayout parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTManualLayout) POIXMLTypeLoader.parse(xMLInputStream, CTManualLayout.type, (XmlOptions) null);
        }

        public static CTManualLayout parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTManualLayout) POIXMLTypeLoader.parse(xMLInputStream, CTManualLayout.type, xmlOptions);
        }

        public static CTManualLayout parse(Node node) throws XmlException {
            return (CTManualLayout) POIXMLTypeLoader.parse(node, CTManualLayout.type, (XmlOptions) null);
        }

        public static CTManualLayout parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTManualLayout) POIXMLTypeLoader.parse(node, CTManualLayout.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTDouble addNewH();

    CTLayoutMode addNewHMode();

    CTLayoutTarget addNewLayoutTarget();

    CTDouble addNewW();

    CTLayoutMode addNewWMode();

    CTDouble addNewX();

    CTLayoutMode addNewXMode();

    CTDouble addNewY();

    CTLayoutMode addNewYMode();

    CTExtensionList getExtLst();

    CTDouble getH();

    CTLayoutMode getHMode();

    CTLayoutTarget getLayoutTarget();

    CTDouble getW();

    CTLayoutMode getWMode();

    CTDouble getX();

    CTLayoutMode getXMode();

    CTDouble getY();

    CTLayoutMode getYMode();

    boolean isSetExtLst();

    boolean isSetH();

    boolean isSetHMode();

    boolean isSetLayoutTarget();

    boolean isSetW();

    boolean isSetWMode();

    boolean isSetX();

    boolean isSetXMode();

    boolean isSetY();

    boolean isSetYMode();

    void setExtLst(CTExtensionList cTExtensionList);

    void setH(CTDouble cTDouble);

    void setHMode(CTLayoutMode cTLayoutMode);

    void setLayoutTarget(CTLayoutTarget cTLayoutTarget);

    void setW(CTDouble cTDouble);

    void setWMode(CTLayoutMode cTLayoutMode);

    void setX(CTDouble cTDouble);

    void setXMode(CTLayoutMode cTLayoutMode);

    void setY(CTDouble cTDouble);

    void setYMode(CTLayoutMode cTLayoutMode);

    void unsetExtLst();

    void unsetH();

    void unsetHMode();

    void unsetLayoutTarget();

    void unsetW();

    void unsetWMode();

    void unsetX();

    void unsetXMode();

    void unsetY();

    void unsetYMode();
}
