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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTBlipFillProperties extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTBlipFillProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctblipfillproperties0382type");

    public static final class Factory {
        private Factory() {
        }

        public static CTBlipFillProperties newInstance() {
            return (CTBlipFillProperties) POIXMLTypeLoader.newInstance(CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties newInstance(XmlOptions xmlOptions) {
            return (CTBlipFillProperties) POIXMLTypeLoader.newInstance(CTBlipFillProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(File file) throws XmlException, IOException {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(file, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(file, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(inputStream, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(inputStream, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(Reader reader) throws XmlException, IOException {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(reader, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(reader, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(String str) throws XmlException {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(str, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(str, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(URL url) throws XmlException, IOException {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(url, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(url, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(Node node) throws XmlException {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(node, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(node, CTBlipFillProperties.type, xmlOptions);
        }
    }

    CTBlip addNewBlip();

    CTRelativeRect addNewSrcRect();

    CTStretchInfoProperties addNewStretch();

    CTTileInfoProperties addNewTile();

    CTBlip getBlip();

    long getDpi();

    boolean getRotWithShape();

    CTRelativeRect getSrcRect();

    CTStretchInfoProperties getStretch();

    CTTileInfoProperties getTile();

    boolean isSetBlip();

    boolean isSetDpi();

    boolean isSetRotWithShape();

    boolean isSetSrcRect();

    boolean isSetStretch();

    boolean isSetTile();

    void setBlip(CTBlip cTBlip);

    void setDpi(long j);

    void setRotWithShape(boolean z);

    void setSrcRect(CTRelativeRect cTRelativeRect);

    void setStretch(CTStretchInfoProperties cTStretchInfoProperties);

    void setTile(CTTileInfoProperties cTTileInfoProperties);

    void unsetBlip();

    void unsetDpi();

    void unsetRotWithShape();

    void unsetSrcRect();

    void unsetStretch();

    void unsetTile();

    XmlUnsignedInt xgetDpi();

    XmlBoolean xgetRotWithShape();

    void xsetDpi(XmlUnsignedInt xmlUnsignedInt);

    void xsetRotWithShape(XmlBoolean xmlBoolean);
}
