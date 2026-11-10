package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTShd extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTShd.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctshd58c3type");

    public static final class Factory {
        private Factory() {
        }

        public static CTShd newInstance() {
            return (CTShd) POIXMLTypeLoader.newInstance(CTShd.type, (XmlOptions) null);
        }

        public static CTShd newInstance(XmlOptions xmlOptions) {
            return (CTShd) POIXMLTypeLoader.newInstance(CTShd.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShd.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShd.type, xmlOptions);
        }

        public static CTShd parse(File file) throws XmlException, IOException {
            return (CTShd) POIXMLTypeLoader.parse(file, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShd) POIXMLTypeLoader.parse(file, CTShd.type, xmlOptions);
        }

        public static CTShd parse(InputStream inputStream) throws XmlException, IOException {
            return (CTShd) POIXMLTypeLoader.parse(inputStream, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShd) POIXMLTypeLoader.parse(inputStream, CTShd.type, xmlOptions);
        }

        public static CTShd parse(Reader reader) throws XmlException, IOException {
            return (CTShd) POIXMLTypeLoader.parse(reader, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShd) POIXMLTypeLoader.parse(reader, CTShd.type, xmlOptions);
        }

        public static CTShd parse(String str) throws XmlException {
            return (CTShd) POIXMLTypeLoader.parse(str, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTShd) POIXMLTypeLoader.parse(str, CTShd.type, xmlOptions);
        }

        public static CTShd parse(URL url) throws XmlException, IOException {
            return (CTShd) POIXMLTypeLoader.parse(url, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShd) POIXMLTypeLoader.parse(url, CTShd.type, xmlOptions);
        }

        public static CTShd parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTShd) POIXMLTypeLoader.parse(xMLStreamReader, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTShd) POIXMLTypeLoader.parse(xMLStreamReader, CTShd.type, xmlOptions);
        }

        public static CTShd parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTShd) POIXMLTypeLoader.parse(xMLInputStream, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTShd) POIXMLTypeLoader.parse(xMLInputStream, CTShd.type, xmlOptions);
        }

        public static CTShd parse(Node node) throws XmlException {
            return (CTShd) POIXMLTypeLoader.parse(node, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTShd) POIXMLTypeLoader.parse(node, CTShd.type, xmlOptions);
        }
    }

    Object getColor();

    Object getFill();

    STThemeColor$Enum getThemeColor();

    STThemeColor$Enum getThemeFill();

    byte[] getThemeFillShade();

    byte[] getThemeFillTint();

    byte[] getThemeShade();

    byte[] getThemeTint();

    STShd.Enum getVal();

    boolean isSetColor();

    boolean isSetFill();

    boolean isSetThemeColor();

    boolean isSetThemeFill();

    boolean isSetThemeFillShade();

    boolean isSetThemeFillTint();

    boolean isSetThemeShade();

    boolean isSetThemeTint();

    void setColor(Object obj);

    void setFill(Object obj);

    void setThemeColor(STThemeColor$Enum sTThemeColor$Enum);

    void setThemeFill(STThemeColor$Enum sTThemeColor$Enum);

    void setThemeFillShade(byte[] bArr);

    void setThemeFillTint(byte[] bArr);

    void setThemeShade(byte[] bArr);

    void setThemeTint(byte[] bArr);

    void setVal(STShd.Enum r1);

    void unsetColor();

    void unsetFill();

    void unsetThemeColor();

    void unsetThemeFill();

    void unsetThemeFillShade();

    void unsetThemeFillTint();

    void unsetThemeShade();

    void unsetThemeTint();

    STHexColor xgetColor();

    STHexColor xgetFill();

    STThemeColor xgetThemeColor();

    STThemeColor xgetThemeFill();

    STUcharHexNumber xgetThemeFillShade();

    STUcharHexNumber xgetThemeFillTint();

    STUcharHexNumber xgetThemeShade();

    STUcharHexNumber xgetThemeTint();

    STShd xgetVal();

    void xsetColor(STHexColor sTHexColor);

    void xsetFill(STHexColor sTHexColor);

    void xsetThemeColor(STThemeColor sTThemeColor);

    void xsetThemeFill(STThemeColor sTThemeColor);

    void xsetThemeFillShade(STUcharHexNumber sTUcharHexNumber);

    void xsetThemeFillTint(STUcharHexNumber sTUcharHexNumber);

    void xsetThemeShade(STUcharHexNumber sTUcharHexNumber);

    void xsetThemeTint(STUcharHexNumber sTUcharHexNumber);

    void xsetVal(STShd sTShd);
}
