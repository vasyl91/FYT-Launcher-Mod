package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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
public interface CTSheetViews extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSheetViews.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsheetviewsb918type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSheetViews newInstance() {
            return (CTSheetViews) POIXMLTypeLoader.newInstance(CTSheetViews.type, (XmlOptions) null);
        }

        public static CTSheetViews newInstance(XmlOptions xmlOptions) {
            return (CTSheetViews) POIXMLTypeLoader.newInstance(CTSheetViews.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSheetViews.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSheetViews.type, xmlOptions);
        }

        public static CTSheetViews parse(File file) throws XmlException, IOException {
            return (CTSheetViews) POIXMLTypeLoader.parse(file, CTSheetViews.type, (XmlOptions) null);
        }

        public static CTSheetViews parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetViews) POIXMLTypeLoader.parse(file, CTSheetViews.type, xmlOptions);
        }

        public static CTSheetViews parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSheetViews) POIXMLTypeLoader.parse(inputStream, CTSheetViews.type, (XmlOptions) null);
        }

        public static CTSheetViews parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetViews) POIXMLTypeLoader.parse(inputStream, CTSheetViews.type, xmlOptions);
        }

        public static CTSheetViews parse(Reader reader) throws XmlException, IOException {
            return (CTSheetViews) POIXMLTypeLoader.parse(reader, CTSheetViews.type, (XmlOptions) null);
        }

        public static CTSheetViews parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetViews) POIXMLTypeLoader.parse(reader, CTSheetViews.type, xmlOptions);
        }

        public static CTSheetViews parse(String str) throws XmlException {
            return (CTSheetViews) POIXMLTypeLoader.parse(str, CTSheetViews.type, (XmlOptions) null);
        }

        public static CTSheetViews parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetViews) POIXMLTypeLoader.parse(str, CTSheetViews.type, xmlOptions);
        }

        public static CTSheetViews parse(URL url) throws XmlException, IOException {
            return (CTSheetViews) POIXMLTypeLoader.parse(url, CTSheetViews.type, (XmlOptions) null);
        }

        public static CTSheetViews parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetViews) POIXMLTypeLoader.parse(url, CTSheetViews.type, xmlOptions);
        }

        public static CTSheetViews parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSheetViews) POIXMLTypeLoader.parse(xMLStreamReader, CTSheetViews.type, (XmlOptions) null);
        }

        public static CTSheetViews parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetViews) POIXMLTypeLoader.parse(xMLStreamReader, CTSheetViews.type, xmlOptions);
        }

        public static CTSheetViews parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSheetViews) POIXMLTypeLoader.parse(xMLInputStream, CTSheetViews.type, (XmlOptions) null);
        }

        public static CTSheetViews parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSheetViews) POIXMLTypeLoader.parse(xMLInputStream, CTSheetViews.type, xmlOptions);
        }

        public static CTSheetViews parse(Node node) throws XmlException {
            return (CTSheetViews) POIXMLTypeLoader.parse(node, CTSheetViews.type, (XmlOptions) null);
        }

        public static CTSheetViews parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetViews) POIXMLTypeLoader.parse(node, CTSheetViews.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTSheetView addNewSheetView();

    CTExtensionList getExtLst();

    CTSheetView getSheetViewArray(int i);

    CTSheetView[] getSheetViewArray();

    List<CTSheetView> getSheetViewList();

    CTSheetView insertNewSheetView(int i);

    boolean isSetExtLst();

    void removeSheetView(int i);

    void setExtLst(CTExtensionList cTExtensionList);

    void setSheetViewArray(int i, CTSheetView cTSheetView);

    void setSheetViewArray(CTSheetView[] cTSheetViewArr);

    int sizeOfSheetViewArray();

    void unsetExtLst();
}
