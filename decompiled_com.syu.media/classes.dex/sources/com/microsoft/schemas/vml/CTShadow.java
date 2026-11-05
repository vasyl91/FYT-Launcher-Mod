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
public interface CTShadow extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTShadow.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctshadowdfdetype");

    public static final class Factory {
        private Factory() {
        }

        public static CTShadow newInstance() {
            return (CTShadow) POIXMLTypeLoader.newInstance(CTShadow.type, (XmlOptions) null);
        }

        public static CTShadow newInstance(XmlOptions xmlOptions) {
            return (CTShadow) POIXMLTypeLoader.newInstance(CTShadow.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShadow.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShadow.type, xmlOptions);
        }

        public static CTShadow parse(File file) throws XmlException, IOException {
            return (CTShadow) POIXMLTypeLoader.parse(file, CTShadow.type, (XmlOptions) null);
        }

        public static CTShadow parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShadow) POIXMLTypeLoader.parse(file, CTShadow.type, xmlOptions);
        }

        public static CTShadow parse(InputStream inputStream) throws XmlException, IOException {
            return (CTShadow) POIXMLTypeLoader.parse(inputStream, CTShadow.type, (XmlOptions) null);
        }

        public static CTShadow parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShadow) POIXMLTypeLoader.parse(inputStream, CTShadow.type, xmlOptions);
        }

        public static CTShadow parse(Reader reader) throws XmlException, IOException {
            return (CTShadow) POIXMLTypeLoader.parse(reader, CTShadow.type, (XmlOptions) null);
        }

        public static CTShadow parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShadow) POIXMLTypeLoader.parse(reader, CTShadow.type, xmlOptions);
        }

        public static CTShadow parse(String str) throws XmlException {
            return (CTShadow) POIXMLTypeLoader.parse(str, CTShadow.type, (XmlOptions) null);
        }

        public static CTShadow parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTShadow) POIXMLTypeLoader.parse(str, CTShadow.type, xmlOptions);
        }

        public static CTShadow parse(URL url) throws XmlException, IOException {
            return (CTShadow) POIXMLTypeLoader.parse(url, CTShadow.type, (XmlOptions) null);
        }

        public static CTShadow parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShadow) POIXMLTypeLoader.parse(url, CTShadow.type, xmlOptions);
        }

        public static CTShadow parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTShadow) POIXMLTypeLoader.parse(xMLStreamReader, CTShadow.type, (XmlOptions) null);
        }

        public static CTShadow parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTShadow) POIXMLTypeLoader.parse(xMLStreamReader, CTShadow.type, xmlOptions);
        }

        public static CTShadow parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTShadow) POIXMLTypeLoader.parse(xMLInputStream, CTShadow.type, (XmlOptions) null);
        }

        public static CTShadow parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTShadow) POIXMLTypeLoader.parse(xMLInputStream, CTShadow.type, xmlOptions);
        }

        public static CTShadow parse(Node node) throws XmlException {
            return (CTShadow) POIXMLTypeLoader.parse(node, CTShadow.type, (XmlOptions) null);
        }

        public static CTShadow parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTShadow) POIXMLTypeLoader.parse(node, CTShadow.type, xmlOptions);
        }
    }

    String getColor();

    String getColor2();

    String getId();

    String getMatrix();

    STTrueFalse.Enum getObscured();

    String getOffset();

    String getOffset2();

    STTrueFalse.Enum getOn();

    String getOpacity();

    String getOrigin();

    STShadowType$Enum getType();

    boolean isSetColor();

    boolean isSetColor2();

    boolean isSetId();

    boolean isSetMatrix();

    boolean isSetObscured();

    boolean isSetOffset();

    boolean isSetOffset2();

    boolean isSetOn();

    boolean isSetOpacity();

    boolean isSetOrigin();

    boolean isSetType();

    void setColor(String str);

    void setColor2(String str);

    void setId(String str);

    void setMatrix(String str);

    void setObscured(STTrueFalse.Enum r1);

    void setOffset(String str);

    void setOffset2(String str);

    void setOn(STTrueFalse.Enum r1);

    void setOpacity(String str);

    void setOrigin(String str);

    void setType(STShadowType$Enum sTShadowType$Enum);

    void unsetColor();

    void unsetColor2();

    void unsetId();

    void unsetMatrix();

    void unsetObscured();

    void unsetOffset();

    void unsetOffset2();

    void unsetOn();

    void unsetOpacity();

    void unsetOrigin();

    void unsetType();

    STColorType xgetColor();

    STColorType xgetColor2();

    XmlString xgetId();

    XmlString xgetMatrix();

    STTrueFalse xgetObscured();

    XmlString xgetOffset();

    XmlString xgetOffset2();

    STTrueFalse xgetOn();

    XmlString xgetOpacity();

    XmlString xgetOrigin();

    STShadowType xgetType();

    void xsetColor(STColorType sTColorType);

    void xsetColor2(STColorType sTColorType);

    void xsetId(XmlString xmlString);

    void xsetMatrix(XmlString xmlString);

    void xsetObscured(STTrueFalse sTTrueFalse);

    void xsetOffset(XmlString xmlString);

    void xsetOffset2(XmlString xmlString);

    void xsetOn(STTrueFalse sTTrueFalse);

    void xsetOpacity(XmlString xmlString);

    void xsetOrigin(XmlString xmlString);

    void xsetType(STShadowType sTShadowType);
}
