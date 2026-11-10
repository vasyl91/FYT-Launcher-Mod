package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTDrawing extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTDrawing.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdrawing8d34type");

    public static final class Factory {
        private Factory() {
        }

        public static CTDrawing newInstance() {
            return (CTDrawing) POIXMLTypeLoader.newInstance(CTDrawing.type, (XmlOptions) null);
        }

        public static CTDrawing newInstance(XmlOptions xmlOptions) {
            return (CTDrawing) POIXMLTypeLoader.newInstance(CTDrawing.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDrawing.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDrawing.type, xmlOptions);
        }

        public static CTDrawing parse(File file) throws XmlException, IOException {
            return (CTDrawing) POIXMLTypeLoader.parse(file, CTDrawing.type, (XmlOptions) null);
        }

        public static CTDrawing parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDrawing) POIXMLTypeLoader.parse(file, CTDrawing.type, xmlOptions);
        }

        public static CTDrawing parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDrawing) POIXMLTypeLoader.parse(inputStream, CTDrawing.type, (XmlOptions) null);
        }

        public static CTDrawing parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDrawing) POIXMLTypeLoader.parse(inputStream, CTDrawing.type, xmlOptions);
        }

        public static CTDrawing parse(Reader reader) throws XmlException, IOException {
            return (CTDrawing) POIXMLTypeLoader.parse(reader, CTDrawing.type, (XmlOptions) null);
        }

        public static CTDrawing parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDrawing) POIXMLTypeLoader.parse(reader, CTDrawing.type, xmlOptions);
        }

        public static CTDrawing parse(String str) throws XmlException {
            return (CTDrawing) POIXMLTypeLoader.parse(str, CTDrawing.type, (XmlOptions) null);
        }

        public static CTDrawing parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDrawing) POIXMLTypeLoader.parse(str, CTDrawing.type, xmlOptions);
        }

        public static CTDrawing parse(URL url) throws XmlException, IOException {
            return (CTDrawing) POIXMLTypeLoader.parse(url, CTDrawing.type, (XmlOptions) null);
        }

        public static CTDrawing parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDrawing) POIXMLTypeLoader.parse(url, CTDrawing.type, xmlOptions);
        }

        public static CTDrawing parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDrawing) POIXMLTypeLoader.parse(xMLStreamReader, CTDrawing.type, (XmlOptions) null);
        }

        public static CTDrawing parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDrawing) POIXMLTypeLoader.parse(xMLStreamReader, CTDrawing.type, xmlOptions);
        }

        public static CTDrawing parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTDrawing) POIXMLTypeLoader.parse(xMLInputStream, CTDrawing.type, (XmlOptions) null);
        }

        public static CTDrawing parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTDrawing) POIXMLTypeLoader.parse(xMLInputStream, CTDrawing.type, xmlOptions);
        }

        public static CTDrawing parse(Node node) throws XmlException {
            return (CTDrawing) POIXMLTypeLoader.parse(node, CTDrawing.type, (XmlOptions) null);
        }

        public static CTDrawing parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDrawing) POIXMLTypeLoader.parse(node, CTDrawing.type, xmlOptions);
        }
    }

    CTAnchor addNewAnchor();

    CTInline addNewInline();

    CTAnchor getAnchorArray(int i);

    CTAnchor[] getAnchorArray();

    List<CTAnchor> getAnchorList();

    CTInline getInlineArray(int i);

    CTInline[] getInlineArray();

    List<CTInline> getInlineList();

    CTAnchor insertNewAnchor(int i);

    CTInline insertNewInline(int i);

    void removeAnchor(int i);

    void removeInline(int i);

    void setAnchorArray(int i, CTAnchor cTAnchor);

    void setAnchorArray(CTAnchor[] cTAnchorArr);

    void setInlineArray(int i, CTInline cTInline);

    void setInlineArray(CTInline[] cTInlineArr);

    int sizeOfAnchorArray();

    int sizeOfInlineArray();
}
