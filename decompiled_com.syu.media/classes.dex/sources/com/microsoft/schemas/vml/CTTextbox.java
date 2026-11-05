package com.microsoft.schemas.vml;

import com.microsoft.schemas.office.office.STInsetMode;
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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface CTTextbox extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTextbox.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextboxf712type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextbox newInstance() {
            return (CTTextbox) POIXMLTypeLoader.newInstance(CTTextbox.type, (XmlOptions) null);
        }

        public static CTTextbox newInstance(XmlOptions xmlOptions) {
            return (CTTextbox) POIXMLTypeLoader.newInstance(CTTextbox.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextbox.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextbox.type, xmlOptions);
        }

        public static CTTextbox parse(File file) throws XmlException, IOException {
            return (CTTextbox) POIXMLTypeLoader.parse(file, CTTextbox.type, (XmlOptions) null);
        }

        public static CTTextbox parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextbox) POIXMLTypeLoader.parse(file, CTTextbox.type, xmlOptions);
        }

        public static CTTextbox parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextbox) POIXMLTypeLoader.parse(inputStream, CTTextbox.type, (XmlOptions) null);
        }

        public static CTTextbox parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextbox) POIXMLTypeLoader.parse(inputStream, CTTextbox.type, xmlOptions);
        }

        public static CTTextbox parse(Reader reader) throws XmlException, IOException {
            return (CTTextbox) POIXMLTypeLoader.parse(reader, CTTextbox.type, (XmlOptions) null);
        }

        public static CTTextbox parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextbox) POIXMLTypeLoader.parse(reader, CTTextbox.type, xmlOptions);
        }

        public static CTTextbox parse(String str) throws XmlException {
            return (CTTextbox) POIXMLTypeLoader.parse(str, CTTextbox.type, (XmlOptions) null);
        }

        public static CTTextbox parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextbox) POIXMLTypeLoader.parse(str, CTTextbox.type, xmlOptions);
        }

        public static CTTextbox parse(URL url) throws XmlException, IOException {
            return (CTTextbox) POIXMLTypeLoader.parse(url, CTTextbox.type, (XmlOptions) null);
        }

        public static CTTextbox parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextbox) POIXMLTypeLoader.parse(url, CTTextbox.type, xmlOptions);
        }

        public static CTTextbox parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextbox) POIXMLTypeLoader.parse(xMLStreamReader, CTTextbox.type, (XmlOptions) null);
        }

        public static CTTextbox parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextbox) POIXMLTypeLoader.parse(xMLStreamReader, CTTextbox.type, xmlOptions);
        }

        public static CTTextbox parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTextbox) POIXMLTypeLoader.parse(xMLInputStream, CTTextbox.type, (XmlOptions) null);
        }

        public static CTTextbox parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTextbox) POIXMLTypeLoader.parse(xMLInputStream, CTTextbox.type, xmlOptions);
        }

        public static CTTextbox parse(Node node) throws XmlException {
            return (CTTextbox) POIXMLTypeLoader.parse(node, CTTextbox.type, (XmlOptions) null);
        }

        public static CTTextbox parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextbox) POIXMLTypeLoader.parse(node, CTTextbox.type, xmlOptions);
        }
    }

    CTTxbxContent addNewTxbxContent();

    String getId();

    String getInset();

    STInsetMode.Enum getInsetmode();

    com.microsoft.schemas.office.office.STTrueFalse$Enum getSingleclick();

    String getStyle();

    CTTxbxContent getTxbxContent();

    boolean isSetId();

    boolean isSetInset();

    boolean isSetInsetmode();

    boolean isSetSingleclick();

    boolean isSetStyle();

    boolean isSetTxbxContent();

    void setId(String str);

    void setInset(String str);

    void setInsetmode(STInsetMode.Enum r1);

    void setSingleclick(com.microsoft.schemas.office.office.STTrueFalse$Enum sTTrueFalse$Enum);

    void setStyle(String str);

    void setTxbxContent(CTTxbxContent cTTxbxContent);

    void unsetId();

    void unsetInset();

    void unsetInsetmode();

    void unsetSingleclick();

    void unsetStyle();

    void unsetTxbxContent();

    XmlString xgetId();

    XmlString xgetInset();

    STInsetMode xgetInsetmode();

    com.microsoft.schemas.office.office.STTrueFalse xgetSingleclick();

    XmlString xgetStyle();

    void xsetId(XmlString xmlString);

    void xsetInset(XmlString xmlString);

    void xsetInsetmode(STInsetMode sTInsetMode);

    void xsetSingleclick(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse);

    void xsetStyle(XmlString xmlString);
}
