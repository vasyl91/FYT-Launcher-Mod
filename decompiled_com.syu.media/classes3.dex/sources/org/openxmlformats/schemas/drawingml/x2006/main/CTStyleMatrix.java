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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTStyleMatrix extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTStyleMatrix.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctstylematrix1903type");

    public static final class Factory {
        private Factory() {
        }

        public static CTStyleMatrix newInstance() {
            return (CTStyleMatrix) POIXMLTypeLoader.newInstance(CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix newInstance(XmlOptions xmlOptions) {
            return (CTStyleMatrix) POIXMLTypeLoader.newInstance(CTStyleMatrix.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(File file) throws XmlException, IOException {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(file, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(file, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(InputStream inputStream) throws XmlException, IOException {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(inputStream, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(inputStream, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(Reader reader) throws XmlException, IOException {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(reader, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(reader, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(String str) throws XmlException {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(str, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(str, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(URL url) throws XmlException, IOException {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(url, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(url, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(xMLStreamReader, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(xMLStreamReader, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(xMLInputStream, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(xMLInputStream, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(Node node) throws XmlException {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(node, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(node, CTStyleMatrix.type, xmlOptions);
        }
    }

    CTBackgroundFillStyleList addNewBgFillStyleLst();

    CTEffectStyleList addNewEffectStyleLst();

    CTFillStyleList addNewFillStyleLst();

    CTLineStyleList addNewLnStyleLst();

    CTBackgroundFillStyleList getBgFillStyleLst();

    CTEffectStyleList getEffectStyleLst();

    CTFillStyleList getFillStyleLst();

    CTLineStyleList getLnStyleLst();

    String getName();

    boolean isSetName();

    void setBgFillStyleLst(CTBackgroundFillStyleList cTBackgroundFillStyleList);

    void setEffectStyleLst(CTEffectStyleList cTEffectStyleList);

    void setFillStyleLst(CTFillStyleList cTFillStyleList);

    void setLnStyleLst(CTLineStyleList cTLineStyleList);

    void setName(String str);

    void unsetName();

    XmlString xgetName();

    void xsetName(XmlString xmlString);
}
