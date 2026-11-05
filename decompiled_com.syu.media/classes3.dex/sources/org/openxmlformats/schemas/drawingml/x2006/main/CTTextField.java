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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTTextField extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTextField.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextfield187etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextField newInstance() {
            return (CTTextField) POIXMLTypeLoader.newInstance(CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField newInstance(XmlOptions xmlOptions) {
            return (CTTextField) POIXMLTypeLoader.newInstance(CTTextField.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextField.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(File file) throws XmlException, IOException {
            return (CTTextField) POIXMLTypeLoader.parse(file, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextField) POIXMLTypeLoader.parse(file, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextField) POIXMLTypeLoader.parse(inputStream, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextField) POIXMLTypeLoader.parse(inputStream, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(Reader reader) throws XmlException, IOException {
            return (CTTextField) POIXMLTypeLoader.parse(reader, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextField) POIXMLTypeLoader.parse(reader, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(String str) throws XmlException {
            return (CTTextField) POIXMLTypeLoader.parse(str, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextField) POIXMLTypeLoader.parse(str, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(URL url) throws XmlException, IOException {
            return (CTTextField) POIXMLTypeLoader.parse(url, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextField) POIXMLTypeLoader.parse(url, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextField) POIXMLTypeLoader.parse(xMLStreamReader, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextField) POIXMLTypeLoader.parse(xMLStreamReader, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTextField) POIXMLTypeLoader.parse(xMLInputStream, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTextField) POIXMLTypeLoader.parse(xMLInputStream, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(Node node) throws XmlException {
            return (CTTextField) POIXMLTypeLoader.parse(node, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextField) POIXMLTypeLoader.parse(node, CTTextField.type, xmlOptions);
        }
    }

    CTTextParagraphProperties addNewPPr();

    CTTextCharacterProperties addNewRPr();

    String getId();

    CTTextParagraphProperties getPPr();

    CTTextCharacterProperties getRPr();

    String getT();

    String getType();

    boolean isSetPPr();

    boolean isSetRPr();

    boolean isSetT();

    boolean isSetType();

    void setId(String str);

    void setPPr(CTTextParagraphProperties cTTextParagraphProperties);

    void setRPr(CTTextCharacterProperties cTTextCharacterProperties);

    void setT(String str);

    void setType(String str);

    void unsetPPr();

    void unsetRPr();

    void unsetT();

    void unsetType();

    STGuid xgetId();

    XmlString xgetT();

    XmlString xgetType();

    void xsetId(STGuid sTGuid);

    void xsetT(XmlString xmlString);

    void xsetType(XmlString xmlString);
}
