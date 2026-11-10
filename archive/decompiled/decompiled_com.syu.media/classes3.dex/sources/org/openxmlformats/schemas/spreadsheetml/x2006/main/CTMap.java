package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTMap extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTMap.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctmap023btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTMap newInstance() {
            return (CTMap) POIXMLTypeLoader.newInstance(CTMap.type, (XmlOptions) null);
        }

        public static CTMap newInstance(XmlOptions xmlOptions) {
            return (CTMap) POIXMLTypeLoader.newInstance(CTMap.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTMap.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTMap.type, xmlOptions);
        }

        public static CTMap parse(File file) throws XmlException, IOException {
            return (CTMap) POIXMLTypeLoader.parse(file, CTMap.type, (XmlOptions) null);
        }

        public static CTMap parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMap) POIXMLTypeLoader.parse(file, CTMap.type, xmlOptions);
        }

        public static CTMap parse(InputStream inputStream) throws XmlException, IOException {
            return (CTMap) POIXMLTypeLoader.parse(inputStream, CTMap.type, (XmlOptions) null);
        }

        public static CTMap parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMap) POIXMLTypeLoader.parse(inputStream, CTMap.type, xmlOptions);
        }

        public static CTMap parse(Reader reader) throws XmlException, IOException {
            return (CTMap) POIXMLTypeLoader.parse(reader, CTMap.type, (XmlOptions) null);
        }

        public static CTMap parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMap) POIXMLTypeLoader.parse(reader, CTMap.type, xmlOptions);
        }

        public static CTMap parse(String str) throws XmlException {
            return (CTMap) POIXMLTypeLoader.parse(str, CTMap.type, (XmlOptions) null);
        }

        public static CTMap parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTMap) POIXMLTypeLoader.parse(str, CTMap.type, xmlOptions);
        }

        public static CTMap parse(URL url) throws XmlException, IOException {
            return (CTMap) POIXMLTypeLoader.parse(url, CTMap.type, (XmlOptions) null);
        }

        public static CTMap parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMap) POIXMLTypeLoader.parse(url, CTMap.type, xmlOptions);
        }

        public static CTMap parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTMap) POIXMLTypeLoader.parse(xMLStreamReader, CTMap.type, (XmlOptions) null);
        }

        public static CTMap parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTMap) POIXMLTypeLoader.parse(xMLStreamReader, CTMap.type, xmlOptions);
        }

        public static CTMap parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTMap) POIXMLTypeLoader.parse(xMLInputStream, CTMap.type, (XmlOptions) null);
        }

        public static CTMap parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTMap) POIXMLTypeLoader.parse(xMLInputStream, CTMap.type, xmlOptions);
        }

        public static CTMap parse(Node node) throws XmlException {
            return (CTMap) POIXMLTypeLoader.parse(node, CTMap.type, (XmlOptions) null);
        }

        public static CTMap parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTMap) POIXMLTypeLoader.parse(node, CTMap.type, xmlOptions);
        }
    }

    CTDataBinding addNewDataBinding();

    boolean getAppend();

    boolean getAutoFit();

    CTDataBinding getDataBinding();

    long getID();

    String getName();

    boolean getPreserveFormat();

    boolean getPreserveSortAFLayout();

    String getRootElement();

    String getSchemaID();

    boolean getShowImportExportValidationErrors();

    boolean isSetDataBinding();

    void setAppend(boolean z);

    void setAutoFit(boolean z);

    void setDataBinding(CTDataBinding cTDataBinding);

    void setID(long j);

    void setName(String str);

    void setPreserveFormat(boolean z);

    void setPreserveSortAFLayout(boolean z);

    void setRootElement(String str);

    void setSchemaID(String str);

    void setShowImportExportValidationErrors(boolean z);

    void unsetDataBinding();

    XmlBoolean xgetAppend();

    XmlBoolean xgetAutoFit();

    XmlUnsignedInt xgetID();

    XmlString xgetName();

    XmlBoolean xgetPreserveFormat();

    XmlBoolean xgetPreserveSortAFLayout();

    XmlString xgetRootElement();

    XmlString xgetSchemaID();

    XmlBoolean xgetShowImportExportValidationErrors();

    void xsetAppend(XmlBoolean xmlBoolean);

    void xsetAutoFit(XmlBoolean xmlBoolean);

    void xsetID(XmlUnsignedInt xmlUnsignedInt);

    void xsetName(XmlString xmlString);

    void xsetPreserveFormat(XmlBoolean xmlBoolean);

    void xsetPreserveSortAFLayout(XmlBoolean xmlBoolean);

    void xsetRootElement(XmlString xmlString);

    void xsetSchemaID(XmlString xmlString);

    void xsetShowImportExportValidationErrors(XmlBoolean xmlBoolean);
}
