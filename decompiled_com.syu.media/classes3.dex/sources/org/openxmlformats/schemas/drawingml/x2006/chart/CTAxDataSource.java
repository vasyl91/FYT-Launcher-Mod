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
public interface CTAxDataSource extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTAxDataSource.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctaxdatasource1440type");

    public static final class Factory {
        private Factory() {
        }

        public static CTAxDataSource newInstance() {
            return (CTAxDataSource) POIXMLTypeLoader.newInstance(CTAxDataSource.type, (XmlOptions) null);
        }

        public static CTAxDataSource newInstance(XmlOptions xmlOptions) {
            return (CTAxDataSource) POIXMLTypeLoader.newInstance(CTAxDataSource.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAxDataSource.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAxDataSource.type, xmlOptions);
        }

        public static CTAxDataSource parse(File file) throws XmlException, IOException {
            return (CTAxDataSource) POIXMLTypeLoader.parse(file, CTAxDataSource.type, (XmlOptions) null);
        }

        public static CTAxDataSource parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAxDataSource) POIXMLTypeLoader.parse(file, CTAxDataSource.type, xmlOptions);
        }

        public static CTAxDataSource parse(InputStream inputStream) throws XmlException, IOException {
            return (CTAxDataSource) POIXMLTypeLoader.parse(inputStream, CTAxDataSource.type, (XmlOptions) null);
        }

        public static CTAxDataSource parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAxDataSource) POIXMLTypeLoader.parse(inputStream, CTAxDataSource.type, xmlOptions);
        }

        public static CTAxDataSource parse(Reader reader) throws XmlException, IOException {
            return (CTAxDataSource) POIXMLTypeLoader.parse(reader, CTAxDataSource.type, (XmlOptions) null);
        }

        public static CTAxDataSource parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAxDataSource) POIXMLTypeLoader.parse(reader, CTAxDataSource.type, xmlOptions);
        }

        public static CTAxDataSource parse(String str) throws XmlException {
            return (CTAxDataSource) POIXMLTypeLoader.parse(str, CTAxDataSource.type, (XmlOptions) null);
        }

        public static CTAxDataSource parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTAxDataSource) POIXMLTypeLoader.parse(str, CTAxDataSource.type, xmlOptions);
        }

        public static CTAxDataSource parse(URL url) throws XmlException, IOException {
            return (CTAxDataSource) POIXMLTypeLoader.parse(url, CTAxDataSource.type, (XmlOptions) null);
        }

        public static CTAxDataSource parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAxDataSource) POIXMLTypeLoader.parse(url, CTAxDataSource.type, xmlOptions);
        }

        public static CTAxDataSource parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTAxDataSource) POIXMLTypeLoader.parse(xMLStreamReader, CTAxDataSource.type, (XmlOptions) null);
        }

        public static CTAxDataSource parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTAxDataSource) POIXMLTypeLoader.parse(xMLStreamReader, CTAxDataSource.type, xmlOptions);
        }

        public static CTAxDataSource parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTAxDataSource) POIXMLTypeLoader.parse(xMLInputStream, CTAxDataSource.type, (XmlOptions) null);
        }

        public static CTAxDataSource parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTAxDataSource) POIXMLTypeLoader.parse(xMLInputStream, CTAxDataSource.type, xmlOptions);
        }

        public static CTAxDataSource parse(Node node) throws XmlException {
            return (CTAxDataSource) POIXMLTypeLoader.parse(node, CTAxDataSource.type, (XmlOptions) null);
        }

        public static CTAxDataSource parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTAxDataSource) POIXMLTypeLoader.parse(node, CTAxDataSource.type, xmlOptions);
        }
    }

    CTMultiLvlStrRef addNewMultiLvlStrRef();

    CTNumData addNewNumLit();

    CTNumRef addNewNumRef();

    CTStrData addNewStrLit();

    CTStrRef addNewStrRef();

    CTMultiLvlStrRef getMultiLvlStrRef();

    CTNumData getNumLit();

    CTNumRef getNumRef();

    CTStrData getStrLit();

    CTStrRef getStrRef();

    boolean isSetMultiLvlStrRef();

    boolean isSetNumLit();

    boolean isSetNumRef();

    boolean isSetStrLit();

    boolean isSetStrRef();

    void setMultiLvlStrRef(CTMultiLvlStrRef cTMultiLvlStrRef);

    void setNumLit(CTNumData cTNumData);

    void setNumRef(CTNumRef cTNumRef);

    void setStrLit(CTStrData cTStrData);

    void setStrRef(CTStrRef cTStrRef);

    void unsetMultiLvlStrRef();

    void unsetNumLit();

    void unsetNumRef();

    void unsetStrLit();

    void unsetStrRef();
}
