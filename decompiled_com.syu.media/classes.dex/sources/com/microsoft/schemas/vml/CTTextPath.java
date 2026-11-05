package com.microsoft.schemas.vml;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface CTTextPath extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTextPath.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextpath14f0type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextPath newInstance() {
            return (CTTextPath) POIXMLTypeLoader.newInstance(CTTextPath.type, (XmlOptions) null);
        }

        public static CTTextPath newInstance(XmlOptions xmlOptions) {
            return (CTTextPath) POIXMLTypeLoader.newInstance(CTTextPath.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextPath.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextPath.type, xmlOptions);
        }

        public static CTTextPath parse(File file) throws XmlException, IOException {
            return (CTTextPath) POIXMLTypeLoader.parse(file, CTTextPath.type, (XmlOptions) null);
        }

        public static CTTextPath parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextPath) POIXMLTypeLoader.parse(file, CTTextPath.type, xmlOptions);
        }

        public static CTTextPath parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextPath) POIXMLTypeLoader.parse(inputStream, CTTextPath.type, (XmlOptions) null);
        }

        public static CTTextPath parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextPath) POIXMLTypeLoader.parse(inputStream, CTTextPath.type, xmlOptions);
        }

        public static CTTextPath parse(Reader reader) throws XmlException, IOException {
            return (CTTextPath) POIXMLTypeLoader.parse(reader, CTTextPath.type, (XmlOptions) null);
        }

        public static CTTextPath parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextPath) POIXMLTypeLoader.parse(reader, CTTextPath.type, xmlOptions);
        }

        public static CTTextPath parse(String str) throws XmlException {
            return (CTTextPath) POIXMLTypeLoader.parse(str, CTTextPath.type, (XmlOptions) null);
        }

        public static CTTextPath parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextPath) POIXMLTypeLoader.parse(str, CTTextPath.type, xmlOptions);
        }

        public static CTTextPath parse(URL url) throws XmlException, IOException {
            return (CTTextPath) POIXMLTypeLoader.parse(url, CTTextPath.type, (XmlOptions) null);
        }

        public static CTTextPath parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextPath) POIXMLTypeLoader.parse(url, CTTextPath.type, xmlOptions);
        }

        public static CTTextPath parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextPath) POIXMLTypeLoader.parse(xMLStreamReader, CTTextPath.type, (XmlOptions) null);
        }

        public static CTTextPath parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextPath) POIXMLTypeLoader.parse(xMLStreamReader, CTTextPath.type, xmlOptions);
        }

        public static CTTextPath parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTextPath) POIXMLTypeLoader.parse(xMLInputStream, CTTextPath.type, (XmlOptions) null);
        }

        public static CTTextPath parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTextPath) POIXMLTypeLoader.parse(xMLInputStream, CTTextPath.type, xmlOptions);
        }

        public static CTTextPath parse(Node node) throws XmlException {
            return (CTTextPath) POIXMLTypeLoader.parse(node, CTTextPath.type, (XmlOptions) null);
        }

        public static CTTextPath parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextPath) POIXMLTypeLoader.parse(node, CTTextPath.type, xmlOptions);
        }
    }

    STTrueFalse.Enum getFitpath();

    STTrueFalse.Enum getFitshape();

    String getId();

    STTrueFalse.Enum getOn();

    String getString();

    String getStyle();

    STTrueFalse.Enum getTrim();

    STTrueFalse.Enum getXscale();

    boolean isSetFitpath();

    boolean isSetFitshape();

    boolean isSetId();

    boolean isSetOn();

    boolean isSetString();

    boolean isSetStyle();

    boolean isSetTrim();

    boolean isSetXscale();

    void setFitpath(STTrueFalse.Enum r1);

    void setFitshape(STTrueFalse.Enum r1);

    void setId(String str);

    void setOn(STTrueFalse.Enum r1);

    void setString(String str);

    void setStyle(String str);

    void setTrim(STTrueFalse.Enum r1);

    void setXscale(STTrueFalse.Enum r1);

    void unsetFitpath();

    void unsetFitshape();

    void unsetId();

    void unsetOn();

    void unsetString();

    void unsetStyle();

    void unsetTrim();

    void unsetXscale();

    STTrueFalse xgetFitpath();

    STTrueFalse xgetFitshape();

    XmlString xgetId();

    STTrueFalse xgetOn();

    XmlString xgetString();

    XmlString xgetStyle();

    STTrueFalse xgetTrim();

    STTrueFalse xgetXscale();

    void xsetFitpath(STTrueFalse sTTrueFalse);

    void xsetFitshape(STTrueFalse sTTrueFalse);

    void xsetId(XmlString xmlString);

    void xsetOn(STTrueFalse sTTrueFalse);

    void xsetString(XmlString xmlString);

    void xsetStyle(XmlString xmlString);

    void xsetTrim(STTrueFalse sTTrueFalse);

    void xsetXscale(STTrueFalse sTTrueFalse);
}
