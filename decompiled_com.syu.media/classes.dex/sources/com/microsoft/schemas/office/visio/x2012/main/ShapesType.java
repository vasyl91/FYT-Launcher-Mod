package com.microsoft.schemas.office.visio.x2012.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface ShapesType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(ShapesType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("shapestypef507type");

    public static final class Factory {
        private Factory() {
        }

        public static ShapesType newInstance() {
            return (ShapesType) POIXMLTypeLoader.newInstance(ShapesType.type, (XmlOptions) null);
        }

        public static ShapesType newInstance(XmlOptions xmlOptions) {
            return (ShapesType) POIXMLTypeLoader.newInstance(ShapesType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, ShapesType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, ShapesType.type, xmlOptions);
        }

        public static ShapesType parse(File file) throws XmlException, IOException {
            return (ShapesType) POIXMLTypeLoader.parse(file, ShapesType.type, (XmlOptions) null);
        }

        public static ShapesType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ShapesType) POIXMLTypeLoader.parse(file, ShapesType.type, xmlOptions);
        }

        public static ShapesType parse(InputStream inputStream) throws XmlException, IOException {
            return (ShapesType) POIXMLTypeLoader.parse(inputStream, ShapesType.type, (XmlOptions) null);
        }

        public static ShapesType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ShapesType) POIXMLTypeLoader.parse(inputStream, ShapesType.type, xmlOptions);
        }

        public static ShapesType parse(Reader reader) throws XmlException, IOException {
            return (ShapesType) POIXMLTypeLoader.parse(reader, ShapesType.type, (XmlOptions) null);
        }

        public static ShapesType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ShapesType) POIXMLTypeLoader.parse(reader, ShapesType.type, xmlOptions);
        }

        public static ShapesType parse(String str) throws XmlException {
            return (ShapesType) POIXMLTypeLoader.parse(str, ShapesType.type, (XmlOptions) null);
        }

        public static ShapesType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ShapesType) POIXMLTypeLoader.parse(str, ShapesType.type, xmlOptions);
        }

        public static ShapesType parse(URL url) throws XmlException, IOException {
            return (ShapesType) POIXMLTypeLoader.parse(url, ShapesType.type, (XmlOptions) null);
        }

        public static ShapesType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ShapesType) POIXMLTypeLoader.parse(url, ShapesType.type, xmlOptions);
        }

        public static ShapesType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ShapesType) POIXMLTypeLoader.parse(xMLStreamReader, ShapesType.type, (XmlOptions) null);
        }

        public static ShapesType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ShapesType) POIXMLTypeLoader.parse(xMLStreamReader, ShapesType.type, xmlOptions);
        }

        public static ShapesType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (ShapesType) POIXMLTypeLoader.parse(xMLInputStream, ShapesType.type, (XmlOptions) null);
        }

        public static ShapesType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (ShapesType) POIXMLTypeLoader.parse(xMLInputStream, ShapesType.type, xmlOptions);
        }

        public static ShapesType parse(Node node) throws XmlException {
            return (ShapesType) POIXMLTypeLoader.parse(node, ShapesType.type, (XmlOptions) null);
        }

        public static ShapesType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ShapesType) POIXMLTypeLoader.parse(node, ShapesType.type, xmlOptions);
        }
    }

    ShapeSheetType addNewShape();

    ShapeSheetType getShapeArray(int i);

    ShapeSheetType[] getShapeArray();

    List<ShapeSheetType> getShapeList();

    ShapeSheetType insertNewShape(int i);

    void removeShape(int i);

    void setShapeArray(int i, ShapeSheetType shapeSheetType);

    void setShapeArray(ShapeSheetType[] shapeSheetTypeArr);

    int sizeOfShapeArray();
}
