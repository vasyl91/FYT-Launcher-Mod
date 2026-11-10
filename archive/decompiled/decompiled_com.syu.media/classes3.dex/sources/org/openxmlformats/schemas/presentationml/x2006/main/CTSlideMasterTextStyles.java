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
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTSlideMasterTextStyles extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSlideMasterTextStyles.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctslidemastertextstylesb48dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlideMasterTextStyles newInstance() {
            return (CTSlideMasterTextStyles) POIXMLTypeLoader.newInstance(CTSlideMasterTextStyles.type, (XmlOptions) null);
        }

        public static CTSlideMasterTextStyles newInstance(XmlOptions xmlOptions) {
            return (CTSlideMasterTextStyles) POIXMLTypeLoader.newInstance(CTSlideMasterTextStyles.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideMasterTextStyles.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideMasterTextStyles.type, xmlOptions);
        }

        public static CTSlideMasterTextStyles parse(File file) throws XmlException, IOException {
            return (CTSlideMasterTextStyles) POIXMLTypeLoader.parse(file, CTSlideMasterTextStyles.type, (XmlOptions) null);
        }

        public static CTSlideMasterTextStyles parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMasterTextStyles) POIXMLTypeLoader.parse(file, CTSlideMasterTextStyles.type, xmlOptions);
        }

        public static CTSlideMasterTextStyles parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSlideMasterTextStyles) POIXMLTypeLoader.parse(inputStream, CTSlideMasterTextStyles.type, (XmlOptions) null);
        }

        public static CTSlideMasterTextStyles parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMasterTextStyles) POIXMLTypeLoader.parse(inputStream, CTSlideMasterTextStyles.type, xmlOptions);
        }

        public static CTSlideMasterTextStyles parse(Reader reader) throws XmlException, IOException {
            return (CTSlideMasterTextStyles) POIXMLTypeLoader.parse(reader, CTSlideMasterTextStyles.type, (XmlOptions) null);
        }

        public static CTSlideMasterTextStyles parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMasterTextStyles) POIXMLTypeLoader.parse(reader, CTSlideMasterTextStyles.type, xmlOptions);
        }

        public static CTSlideMasterTextStyles parse(String str) throws XmlException {
            return (CTSlideMasterTextStyles) POIXMLTypeLoader.parse(str, CTSlideMasterTextStyles.type, (XmlOptions) null);
        }

        public static CTSlideMasterTextStyles parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideMasterTextStyles) POIXMLTypeLoader.parse(str, CTSlideMasterTextStyles.type, xmlOptions);
        }

        public static CTSlideMasterTextStyles parse(URL url) throws XmlException, IOException {
            return (CTSlideMasterTextStyles) POIXMLTypeLoader.parse(url, CTSlideMasterTextStyles.type, (XmlOptions) null);
        }

        public static CTSlideMasterTextStyles parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMasterTextStyles) POIXMLTypeLoader.parse(url, CTSlideMasterTextStyles.type, xmlOptions);
        }

        public static CTSlideMasterTextStyles parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSlideMasterTextStyles) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideMasterTextStyles.type, (XmlOptions) null);
        }

        public static CTSlideMasterTextStyles parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideMasterTextStyles) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideMasterTextStyles.type, xmlOptions);
        }

        public static CTSlideMasterTextStyles parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSlideMasterTextStyles) POIXMLTypeLoader.parse(xMLInputStream, CTSlideMasterTextStyles.type, (XmlOptions) null);
        }

        public static CTSlideMasterTextStyles parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSlideMasterTextStyles) POIXMLTypeLoader.parse(xMLInputStream, CTSlideMasterTextStyles.type, xmlOptions);
        }

        public static CTSlideMasterTextStyles parse(Node node) throws XmlException {
            return (CTSlideMasterTextStyles) POIXMLTypeLoader.parse(node, CTSlideMasterTextStyles.type, (XmlOptions) null);
        }

        public static CTSlideMasterTextStyles parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideMasterTextStyles) POIXMLTypeLoader.parse(node, CTSlideMasterTextStyles.type, xmlOptions);
        }
    }

    CTTextListStyle addNewBodyStyle();

    CTExtensionList addNewExtLst();

    CTTextListStyle addNewOtherStyle();

    CTTextListStyle addNewTitleStyle();

    CTTextListStyle getBodyStyle();

    CTExtensionList getExtLst();

    CTTextListStyle getOtherStyle();

    CTTextListStyle getTitleStyle();

    boolean isSetBodyStyle();

    boolean isSetExtLst();

    boolean isSetOtherStyle();

    boolean isSetTitleStyle();

    void setBodyStyle(CTTextListStyle cTTextListStyle);

    void setExtLst(CTExtensionList cTExtensionList);

    void setOtherStyle(CTTextListStyle cTTextListStyle);

    void setTitleStyle(CTTextListStyle cTTextListStyle);

    void unsetBodyStyle();

    void unsetExtLst();

    void unsetOtherStyle();

    void unsetTitleStyle();
}
