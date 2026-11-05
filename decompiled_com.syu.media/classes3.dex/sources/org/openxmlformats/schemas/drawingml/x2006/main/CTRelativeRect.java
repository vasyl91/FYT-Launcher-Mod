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
public interface CTRelativeRect extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTRelativeRect.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctrelativerecta4ebtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTRelativeRect newInstance() {
            return (CTRelativeRect) POIXMLTypeLoader.newInstance(CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect newInstance(XmlOptions xmlOptions) {
            return (CTRelativeRect) POIXMLTypeLoader.newInstance(CTRelativeRect.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRelativeRect.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(File file) throws XmlException, IOException {
            return (CTRelativeRect) POIXMLTypeLoader.parse(file, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelativeRect) POIXMLTypeLoader.parse(file, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(InputStream inputStream) throws XmlException, IOException {
            return (CTRelativeRect) POIXMLTypeLoader.parse(inputStream, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelativeRect) POIXMLTypeLoader.parse(inputStream, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(Reader reader) throws XmlException, IOException {
            return (CTRelativeRect) POIXMLTypeLoader.parse(reader, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelativeRect) POIXMLTypeLoader.parse(reader, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(String str) throws XmlException {
            return (CTRelativeRect) POIXMLTypeLoader.parse(str, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTRelativeRect) POIXMLTypeLoader.parse(str, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(URL url) throws XmlException, IOException {
            return (CTRelativeRect) POIXMLTypeLoader.parse(url, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelativeRect) POIXMLTypeLoader.parse(url, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTRelativeRect) POIXMLTypeLoader.parse(xMLStreamReader, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTRelativeRect) POIXMLTypeLoader.parse(xMLStreamReader, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTRelativeRect) POIXMLTypeLoader.parse(xMLInputStream, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTRelativeRect) POIXMLTypeLoader.parse(xMLInputStream, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(Node node) throws XmlException {
            return (CTRelativeRect) POIXMLTypeLoader.parse(node, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTRelativeRect) POIXMLTypeLoader.parse(node, CTRelativeRect.type, xmlOptions);
        }
    }

    int getB();

    int getL();

    int getR();

    int getT();

    boolean isSetB();

    boolean isSetL();

    boolean isSetR();

    boolean isSetT();

    void setB(int i);

    void setL(int i);

    void setR(int i);

    void setT(int i);

    void unsetB();

    void unsetL();

    void unsetR();

    void unsetT();

    STPercentage xgetB();

    STPercentage xgetL();

    STPercentage xgetR();

    STPercentage xgetT();

    void xsetB(STPercentage sTPercentage);

    void xsetL(STPercentage sTPercentage);

    void xsetR(STPercentage sTPercentage);

    void xsetT(STPercentage sTPercentage);
}
