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
public interface CTLayout extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTLayout.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlayout3192type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLayout newInstance() {
            return (CTLayout) POIXMLTypeLoader.newInstance(CTLayout.type, (XmlOptions) null);
        }

        public static CTLayout newInstance(XmlOptions xmlOptions) {
            return (CTLayout) POIXMLTypeLoader.newInstance(CTLayout.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLayout.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLayout.type, xmlOptions);
        }

        public static CTLayout parse(File file) throws XmlException, IOException {
            return (CTLayout) POIXMLTypeLoader.parse(file, CTLayout.type, (XmlOptions) null);
        }

        public static CTLayout parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayout) POIXMLTypeLoader.parse(file, CTLayout.type, xmlOptions);
        }

        public static CTLayout parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLayout) POIXMLTypeLoader.parse(inputStream, CTLayout.type, (XmlOptions) null);
        }

        public static CTLayout parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayout) POIXMLTypeLoader.parse(inputStream, CTLayout.type, xmlOptions);
        }

        public static CTLayout parse(Reader reader) throws XmlException, IOException {
            return (CTLayout) POIXMLTypeLoader.parse(reader, CTLayout.type, (XmlOptions) null);
        }

        public static CTLayout parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayout) POIXMLTypeLoader.parse(reader, CTLayout.type, xmlOptions);
        }

        public static CTLayout parse(String str) throws XmlException {
            return (CTLayout) POIXMLTypeLoader.parse(str, CTLayout.type, (XmlOptions) null);
        }

        public static CTLayout parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLayout) POIXMLTypeLoader.parse(str, CTLayout.type, xmlOptions);
        }

        public static CTLayout parse(URL url) throws XmlException, IOException {
            return (CTLayout) POIXMLTypeLoader.parse(url, CTLayout.type, (XmlOptions) null);
        }

        public static CTLayout parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayout) POIXMLTypeLoader.parse(url, CTLayout.type, xmlOptions);
        }

        public static CTLayout parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLayout) POIXMLTypeLoader.parse(xMLStreamReader, CTLayout.type, (XmlOptions) null);
        }

        public static CTLayout parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLayout) POIXMLTypeLoader.parse(xMLStreamReader, CTLayout.type, xmlOptions);
        }

        public static CTLayout parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTLayout) POIXMLTypeLoader.parse(xMLInputStream, CTLayout.type, (XmlOptions) null);
        }

        public static CTLayout parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTLayout) POIXMLTypeLoader.parse(xMLInputStream, CTLayout.type, xmlOptions);
        }

        public static CTLayout parse(Node node) throws XmlException {
            return (CTLayout) POIXMLTypeLoader.parse(node, CTLayout.type, (XmlOptions) null);
        }

        public static CTLayout parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLayout) POIXMLTypeLoader.parse(node, CTLayout.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTManualLayout addNewManualLayout();

    CTExtensionList getExtLst();

    CTManualLayout getManualLayout();

    boolean isSetExtLst();

    boolean isSetManualLayout();

    void setExtLst(CTExtensionList cTExtensionList);

    void setManualLayout(CTManualLayout cTManualLayout);

    void unsetExtLst();

    void unsetManualLayout();
}
