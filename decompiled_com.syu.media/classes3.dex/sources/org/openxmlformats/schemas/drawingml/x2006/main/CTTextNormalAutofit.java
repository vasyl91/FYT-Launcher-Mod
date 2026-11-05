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
public interface CTTextNormalAutofit extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTextNormalAutofit.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextnormalautofitbbdftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextNormalAutofit newInstance() {
            return (CTTextNormalAutofit) POIXMLTypeLoader.newInstance(CTTextNormalAutofit.type, (XmlOptions) null);
        }

        public static CTTextNormalAutofit newInstance(XmlOptions xmlOptions) {
            return (CTTextNormalAutofit) POIXMLTypeLoader.newInstance(CTTextNormalAutofit.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextNormalAutofit.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextNormalAutofit.type, xmlOptions);
        }

        public static CTTextNormalAutofit parse(File file) throws XmlException, IOException {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(file, CTTextNormalAutofit.type, (XmlOptions) null);
        }

        public static CTTextNormalAutofit parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(file, CTTextNormalAutofit.type, xmlOptions);
        }

        public static CTTextNormalAutofit parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(inputStream, CTTextNormalAutofit.type, (XmlOptions) null);
        }

        public static CTTextNormalAutofit parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(inputStream, CTTextNormalAutofit.type, xmlOptions);
        }

        public static CTTextNormalAutofit parse(Reader reader) throws XmlException, IOException {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(reader, CTTextNormalAutofit.type, (XmlOptions) null);
        }

        public static CTTextNormalAutofit parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(reader, CTTextNormalAutofit.type, xmlOptions);
        }

        public static CTTextNormalAutofit parse(String str) throws XmlException {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(str, CTTextNormalAutofit.type, (XmlOptions) null);
        }

        public static CTTextNormalAutofit parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(str, CTTextNormalAutofit.type, xmlOptions);
        }

        public static CTTextNormalAutofit parse(URL url) throws XmlException, IOException {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(url, CTTextNormalAutofit.type, (XmlOptions) null);
        }

        public static CTTextNormalAutofit parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(url, CTTextNormalAutofit.type, xmlOptions);
        }

        public static CTTextNormalAutofit parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(xMLStreamReader, CTTextNormalAutofit.type, (XmlOptions) null);
        }

        public static CTTextNormalAutofit parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(xMLStreamReader, CTTextNormalAutofit.type, xmlOptions);
        }

        public static CTTextNormalAutofit parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(xMLInputStream, CTTextNormalAutofit.type, (XmlOptions) null);
        }

        public static CTTextNormalAutofit parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(xMLInputStream, CTTextNormalAutofit.type, xmlOptions);
        }

        public static CTTextNormalAutofit parse(Node node) throws XmlException {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(node, CTTextNormalAutofit.type, (XmlOptions) null);
        }

        public static CTTextNormalAutofit parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(node, CTTextNormalAutofit.type, xmlOptions);
        }
    }

    int getFontScale();

    int getLnSpcReduction();

    boolean isSetFontScale();

    boolean isSetLnSpcReduction();

    void setFontScale(int i);

    void setLnSpcReduction(int i);

    void unsetFontScale();

    void unsetLnSpcReduction();

    STTextFontScalePercent xgetFontScale();

    STTextSpacingPercent xgetLnSpcReduction();

    void xsetFontScale(STTextFontScalePercent sTTextFontScalePercent);

    void xsetLnSpcReduction(STTextSpacingPercent sTTextSpacingPercent);
}
