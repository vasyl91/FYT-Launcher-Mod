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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTCommonSlideData extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTCommonSlideData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcommonslidedata8c7ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTCommonSlideData newInstance() {
            return (CTCommonSlideData) POIXMLTypeLoader.newInstance(CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData newInstance(XmlOptions xmlOptions) {
            return (CTCommonSlideData) POIXMLTypeLoader.newInstance(CTCommonSlideData.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(File file) throws XmlException, IOException {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(file, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(file, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(inputStream, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(inputStream, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(Reader reader) throws XmlException, IOException {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(reader, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(reader, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(String str) throws XmlException {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(str, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(str, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(URL url) throws XmlException, IOException {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(url, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(url, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(xMLStreamReader, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(xMLStreamReader, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(xMLInputStream, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(xMLInputStream, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(Node node) throws XmlException {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(node, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(node, CTCommonSlideData.type, xmlOptions);
        }
    }

    CTBackground addNewBg();

    CTControlList addNewControls();

    CTCustomerDataList addNewCustDataLst();

    CTExtensionList addNewExtLst();

    CTGroupShape addNewSpTree();

    CTBackground getBg();

    CTControlList getControls();

    CTCustomerDataList getCustDataLst();

    CTExtensionList getExtLst();

    String getName();

    CTGroupShape getSpTree();

    boolean isSetBg();

    boolean isSetControls();

    boolean isSetCustDataLst();

    boolean isSetExtLst();

    boolean isSetName();

    void setBg(CTBackground cTBackground);

    void setControls(CTControlList cTControlList);

    void setCustDataLst(CTCustomerDataList cTCustomerDataList);

    void setExtLst(CTExtensionList cTExtensionList);

    void setName(String str);

    void setSpTree(CTGroupShape cTGroupShape);

    void unsetBg();

    void unsetControls();

    void unsetCustDataLst();

    void unsetExtLst();

    void unsetName();

    XmlString xgetName();

    void xsetName(XmlString xmlString);
}
