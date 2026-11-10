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
public interface CTTextSpacing extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTextSpacing.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextspacingef87type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextSpacing newInstance() {
            return (CTTextSpacing) POIXMLTypeLoader.newInstance(CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing newInstance(XmlOptions xmlOptions) {
            return (CTTextSpacing) POIXMLTypeLoader.newInstance(CTTextSpacing.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextSpacing.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(File file) throws XmlException, IOException {
            return (CTTextSpacing) POIXMLTypeLoader.parse(file, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacing) POIXMLTypeLoader.parse(file, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextSpacing) POIXMLTypeLoader.parse(inputStream, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacing) POIXMLTypeLoader.parse(inputStream, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(Reader reader) throws XmlException, IOException {
            return (CTTextSpacing) POIXMLTypeLoader.parse(reader, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacing) POIXMLTypeLoader.parse(reader, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(String str) throws XmlException {
            return (CTTextSpacing) POIXMLTypeLoader.parse(str, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextSpacing) POIXMLTypeLoader.parse(str, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(URL url) throws XmlException, IOException {
            return (CTTextSpacing) POIXMLTypeLoader.parse(url, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextSpacing) POIXMLTypeLoader.parse(url, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextSpacing) POIXMLTypeLoader.parse(xMLStreamReader, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextSpacing) POIXMLTypeLoader.parse(xMLStreamReader, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTextSpacing) POIXMLTypeLoader.parse(xMLInputStream, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTextSpacing) POIXMLTypeLoader.parse(xMLInputStream, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(Node node) throws XmlException {
            return (CTTextSpacing) POIXMLTypeLoader.parse(node, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextSpacing) POIXMLTypeLoader.parse(node, CTTextSpacing.type, xmlOptions);
        }
    }

    CTTextSpacingPercent addNewSpcPct();

    CTTextSpacingPoint addNewSpcPts();

    CTTextSpacingPercent getSpcPct();

    CTTextSpacingPoint getSpcPts();

    boolean isSetSpcPct();

    boolean isSetSpcPts();

    void setSpcPct(CTTextSpacingPercent cTTextSpacingPercent);

    void setSpcPts(CTTextSpacingPoint cTTextSpacingPoint);

    void unsetSpcPct();

    void unsetSpcPts();
}
