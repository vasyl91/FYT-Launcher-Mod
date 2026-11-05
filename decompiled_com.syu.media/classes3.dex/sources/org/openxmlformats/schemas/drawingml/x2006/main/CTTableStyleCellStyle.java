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
public interface CTTableStyleCellStyle extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTableStyleCellStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablestylecellstyle1fddtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableStyleCellStyle newInstance() {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.newInstance(CTTableStyleCellStyle.type, (XmlOptions) null);
        }

        public static CTTableStyleCellStyle newInstance(XmlOptions xmlOptions) {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.newInstance(CTTableStyleCellStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableStyleCellStyle.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableStyleCellStyle.type, xmlOptions);
        }

        public static CTTableStyleCellStyle parse(File file) throws XmlException, IOException {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(file, CTTableStyleCellStyle.type, (XmlOptions) null);
        }

        public static CTTableStyleCellStyle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(file, CTTableStyleCellStyle.type, xmlOptions);
        }

        public static CTTableStyleCellStyle parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(inputStream, CTTableStyleCellStyle.type, (XmlOptions) null);
        }

        public static CTTableStyleCellStyle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(inputStream, CTTableStyleCellStyle.type, xmlOptions);
        }

        public static CTTableStyleCellStyle parse(Reader reader) throws XmlException, IOException {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(reader, CTTableStyleCellStyle.type, (XmlOptions) null);
        }

        public static CTTableStyleCellStyle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(reader, CTTableStyleCellStyle.type, xmlOptions);
        }

        public static CTTableStyleCellStyle parse(String str) throws XmlException {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(str, CTTableStyleCellStyle.type, (XmlOptions) null);
        }

        public static CTTableStyleCellStyle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(str, CTTableStyleCellStyle.type, xmlOptions);
        }

        public static CTTableStyleCellStyle parse(URL url) throws XmlException, IOException {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(url, CTTableStyleCellStyle.type, (XmlOptions) null);
        }

        public static CTTableStyleCellStyle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(url, CTTableStyleCellStyle.type, xmlOptions);
        }

        public static CTTableStyleCellStyle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTTableStyleCellStyle.type, (XmlOptions) null);
        }

        public static CTTableStyleCellStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTTableStyleCellStyle.type, xmlOptions);
        }

        public static CTTableStyleCellStyle parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(xMLInputStream, CTTableStyleCellStyle.type, (XmlOptions) null);
        }

        public static CTTableStyleCellStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(xMLInputStream, CTTableStyleCellStyle.type, xmlOptions);
        }

        public static CTTableStyleCellStyle parse(Node node) throws XmlException {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(node, CTTableStyleCellStyle.type, (XmlOptions) null);
        }

        public static CTTableStyleCellStyle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(node, CTTableStyleCellStyle.type, xmlOptions);
        }
    }

    CTCell3D addNewCell3D();

    CTFillProperties addNewFill();

    CTStyleMatrixReference addNewFillRef();

    CTTableCellBorderStyle addNewTcBdr();

    CTCell3D getCell3D();

    CTFillProperties getFill();

    CTStyleMatrixReference getFillRef();

    CTTableCellBorderStyle getTcBdr();

    boolean isSetCell3D();

    boolean isSetFill();

    boolean isSetFillRef();

    boolean isSetTcBdr();

    void setCell3D(CTCell3D cTCell3D);

    void setFill(CTFillProperties cTFillProperties);

    void setFillRef(CTStyleMatrixReference cTStyleMatrixReference);

    void setTcBdr(CTTableCellBorderStyle cTTableCellBorderStyle);

    void unsetCell3D();

    void unsetFill();

    void unsetFillRef();

    void unsetTcBdr();
}
