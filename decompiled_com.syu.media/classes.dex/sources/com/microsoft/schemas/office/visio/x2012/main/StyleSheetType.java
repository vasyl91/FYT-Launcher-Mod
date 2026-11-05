package com.microsoft.schemas.office.visio.x2012.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface StyleSheetType extends SheetType {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(StyleSheetType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stylesheettypeebcbtype");

    public static final class Factory {
        private Factory() {
        }

        public static StyleSheetType newInstance() {
            return (StyleSheetType) POIXMLTypeLoader.newInstance(StyleSheetType.type, (XmlOptions) null);
        }

        public static StyleSheetType newInstance(XmlOptions xmlOptions) {
            return (StyleSheetType) POIXMLTypeLoader.newInstance(StyleSheetType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, StyleSheetType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, StyleSheetType.type, xmlOptions);
        }

        public static StyleSheetType parse(File file) throws XmlException, IOException {
            return (StyleSheetType) POIXMLTypeLoader.parse(file, StyleSheetType.type, (XmlOptions) null);
        }

        public static StyleSheetType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (StyleSheetType) POIXMLTypeLoader.parse(file, StyleSheetType.type, xmlOptions);
        }

        public static StyleSheetType parse(InputStream inputStream) throws XmlException, IOException {
            return (StyleSheetType) POIXMLTypeLoader.parse(inputStream, StyleSheetType.type, (XmlOptions) null);
        }

        public static StyleSheetType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (StyleSheetType) POIXMLTypeLoader.parse(inputStream, StyleSheetType.type, xmlOptions);
        }

        public static StyleSheetType parse(Reader reader) throws XmlException, IOException {
            return (StyleSheetType) POIXMLTypeLoader.parse(reader, StyleSheetType.type, (XmlOptions) null);
        }

        public static StyleSheetType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (StyleSheetType) POIXMLTypeLoader.parse(reader, StyleSheetType.type, xmlOptions);
        }

        public static StyleSheetType parse(String str) throws XmlException {
            return (StyleSheetType) POIXMLTypeLoader.parse(str, StyleSheetType.type, (XmlOptions) null);
        }

        public static StyleSheetType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (StyleSheetType) POIXMLTypeLoader.parse(str, StyleSheetType.type, xmlOptions);
        }

        public static StyleSheetType parse(URL url) throws XmlException, IOException {
            return (StyleSheetType) POIXMLTypeLoader.parse(url, StyleSheetType.type, (XmlOptions) null);
        }

        public static StyleSheetType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (StyleSheetType) POIXMLTypeLoader.parse(url, StyleSheetType.type, xmlOptions);
        }

        public static StyleSheetType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (StyleSheetType) POIXMLTypeLoader.parse(xMLStreamReader, StyleSheetType.type, (XmlOptions) null);
        }

        public static StyleSheetType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (StyleSheetType) POIXMLTypeLoader.parse(xMLStreamReader, StyleSheetType.type, xmlOptions);
        }

        public static StyleSheetType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (StyleSheetType) POIXMLTypeLoader.parse(xMLInputStream, StyleSheetType.type, (XmlOptions) null);
        }

        public static StyleSheetType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (StyleSheetType) POIXMLTypeLoader.parse(xMLInputStream, StyleSheetType.type, xmlOptions);
        }

        public static StyleSheetType parse(Node node) throws XmlException {
            return (StyleSheetType) POIXMLTypeLoader.parse(node, StyleSheetType.type, (XmlOptions) null);
        }

        public static StyleSheetType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (StyleSheetType) POIXMLTypeLoader.parse(node, StyleSheetType.type, xmlOptions);
        }
    }

    long getID();

    boolean getIsCustomName();

    boolean getIsCustomNameU();

    String getName();

    String getNameU();

    boolean isSetIsCustomName();

    boolean isSetIsCustomNameU();

    boolean isSetName();

    boolean isSetNameU();

    void setID(long j);

    void setIsCustomName(boolean z);

    void setIsCustomNameU(boolean z);

    void setName(String str);

    void setNameU(String str);

    void unsetIsCustomName();

    void unsetIsCustomNameU();

    void unsetName();

    void unsetNameU();

    XmlUnsignedInt xgetID();

    XmlBoolean xgetIsCustomName();

    XmlBoolean xgetIsCustomNameU();

    XmlString xgetName();

    XmlString xgetNameU();

    void xsetID(XmlUnsignedInt xmlUnsignedInt);

    void xsetIsCustomName(XmlBoolean xmlBoolean);

    void xsetIsCustomNameU(XmlBoolean xmlBoolean);

    void xsetName(XmlString xmlString);

    void xsetNameU(XmlString xmlString);
}
