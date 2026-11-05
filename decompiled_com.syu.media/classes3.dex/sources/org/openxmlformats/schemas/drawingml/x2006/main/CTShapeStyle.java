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
public interface CTShapeStyle extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTShapeStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctshapestyle81ebtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTShapeStyle newInstance() {
            return (CTShapeStyle) POIXMLTypeLoader.newInstance(CTShapeStyle.type, (XmlOptions) null);
        }

        public static CTShapeStyle newInstance(XmlOptions xmlOptions) {
            return (CTShapeStyle) POIXMLTypeLoader.newInstance(CTShapeStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShapeStyle.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShapeStyle.type, xmlOptions);
        }

        public static CTShapeStyle parse(File file) throws XmlException, IOException {
            return (CTShapeStyle) POIXMLTypeLoader.parse(file, CTShapeStyle.type, (XmlOptions) null);
        }

        public static CTShapeStyle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapeStyle) POIXMLTypeLoader.parse(file, CTShapeStyle.type, xmlOptions);
        }

        public static CTShapeStyle parse(InputStream inputStream) throws XmlException, IOException {
            return (CTShapeStyle) POIXMLTypeLoader.parse(inputStream, CTShapeStyle.type, (XmlOptions) null);
        }

        public static CTShapeStyle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapeStyle) POIXMLTypeLoader.parse(inputStream, CTShapeStyle.type, xmlOptions);
        }

        public static CTShapeStyle parse(Reader reader) throws XmlException, IOException {
            return (CTShapeStyle) POIXMLTypeLoader.parse(reader, CTShapeStyle.type, (XmlOptions) null);
        }

        public static CTShapeStyle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapeStyle) POIXMLTypeLoader.parse(reader, CTShapeStyle.type, xmlOptions);
        }

        public static CTShapeStyle parse(String str) throws XmlException {
            return (CTShapeStyle) POIXMLTypeLoader.parse(str, CTShapeStyle.type, (XmlOptions) null);
        }

        public static CTShapeStyle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTShapeStyle) POIXMLTypeLoader.parse(str, CTShapeStyle.type, xmlOptions);
        }

        public static CTShapeStyle parse(URL url) throws XmlException, IOException {
            return (CTShapeStyle) POIXMLTypeLoader.parse(url, CTShapeStyle.type, (XmlOptions) null);
        }

        public static CTShapeStyle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShapeStyle) POIXMLTypeLoader.parse(url, CTShapeStyle.type, xmlOptions);
        }

        public static CTShapeStyle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTShapeStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTShapeStyle.type, (XmlOptions) null);
        }

        public static CTShapeStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTShapeStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTShapeStyle.type, xmlOptions);
        }

        public static CTShapeStyle parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTShapeStyle) POIXMLTypeLoader.parse(xMLInputStream, CTShapeStyle.type, (XmlOptions) null);
        }

        public static CTShapeStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTShapeStyle) POIXMLTypeLoader.parse(xMLInputStream, CTShapeStyle.type, xmlOptions);
        }

        public static CTShapeStyle parse(Node node) throws XmlException {
            return (CTShapeStyle) POIXMLTypeLoader.parse(node, CTShapeStyle.type, (XmlOptions) null);
        }

        public static CTShapeStyle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTShapeStyle) POIXMLTypeLoader.parse(node, CTShapeStyle.type, xmlOptions);
        }
    }

    CTStyleMatrixReference addNewEffectRef();

    CTStyleMatrixReference addNewFillRef();

    CTFontReference addNewFontRef();

    CTStyleMatrixReference addNewLnRef();

    CTStyleMatrixReference getEffectRef();

    CTStyleMatrixReference getFillRef();

    CTFontReference getFontRef();

    CTStyleMatrixReference getLnRef();

    void setEffectRef(CTStyleMatrixReference cTStyleMatrixReference);

    void setFillRef(CTStyleMatrixReference cTStyleMatrixReference);

    void setFontRef(CTFontReference cTFontReference);

    void setLnRef(CTStyleMatrixReference cTStyleMatrixReference);
}
