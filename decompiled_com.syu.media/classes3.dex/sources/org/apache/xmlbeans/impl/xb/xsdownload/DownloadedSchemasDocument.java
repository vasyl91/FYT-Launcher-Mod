package org.apache.xmlbeans.impl.xb.xsdownload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface DownloadedSchemasDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(DownloadedSchemasDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("downloadedschemas2dd7doctype");

    DownloadedSchemas addNewDownloadedSchemas();

    DownloadedSchemas getDownloadedSchemas();

    void setDownloadedSchemas(DownloadedSchemas downloadedSchemas);

    public interface DownloadedSchemas extends XmlObject {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(DownloadedSchemas.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("downloadedschemasb3efelemtype");

        DownloadedSchemaEntry addNewEntry();

        String getDefaultDirectory();

        DownloadedSchemaEntry getEntryArray(int i);

        DownloadedSchemaEntry[] getEntryArray();

        DownloadedSchemaEntry insertNewEntry(int i);

        boolean isSetDefaultDirectory();

        void removeEntry(int i);

        void setDefaultDirectory(String str);

        void setEntryArray(int i, DownloadedSchemaEntry downloadedSchemaEntry);

        void setEntryArray(DownloadedSchemaEntry[] downloadedSchemaEntryArr);

        int sizeOfEntryArray();

        void unsetDefaultDirectory();

        XmlToken xgetDefaultDirectory();

        void xsetDefaultDirectory(XmlToken xmlToken);

        public static final class Factory {
            public static DownloadedSchemas newInstance() {
                return (DownloadedSchemas) XmlBeans.getContextTypeLoader().newInstance(DownloadedSchemas.type, (XmlOptions) null);
            }

            public static DownloadedSchemas newInstance(XmlOptions xmlOptions) {
                return (DownloadedSchemas) XmlBeans.getContextTypeLoader().newInstance(DownloadedSchemas.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static DownloadedSchemasDocument newInstance() {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().newInstance(DownloadedSchemasDocument.type, (XmlOptions) null);
        }

        public static DownloadedSchemasDocument newInstance(XmlOptions xmlOptions) {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().newInstance(DownloadedSchemasDocument.type, xmlOptions);
        }

        public static DownloadedSchemasDocument parse(String str) throws XmlException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(str, DownloadedSchemasDocument.type, (XmlOptions) null);
        }

        public static DownloadedSchemasDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(str, DownloadedSchemasDocument.type, xmlOptions);
        }

        public static DownloadedSchemasDocument parse(File file) throws XmlException, IOException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(file, DownloadedSchemasDocument.type, (XmlOptions) null);
        }

        public static DownloadedSchemasDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(file, DownloadedSchemasDocument.type, xmlOptions);
        }

        public static DownloadedSchemasDocument parse(URL url) throws XmlException, IOException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(url, DownloadedSchemasDocument.type, (XmlOptions) null);
        }

        public static DownloadedSchemasDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(url, DownloadedSchemasDocument.type, xmlOptions);
        }

        public static DownloadedSchemasDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(inputStream, DownloadedSchemasDocument.type, (XmlOptions) null);
        }

        public static DownloadedSchemasDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(inputStream, DownloadedSchemasDocument.type, xmlOptions);
        }

        public static DownloadedSchemasDocument parse(Reader reader) throws XmlException, IOException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(reader, DownloadedSchemasDocument.type, (XmlOptions) null);
        }

        public static DownloadedSchemasDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(reader, DownloadedSchemasDocument.type, xmlOptions);
        }

        public static DownloadedSchemasDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DownloadedSchemasDocument.type, (XmlOptions) null);
        }

        public static DownloadedSchemasDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DownloadedSchemasDocument.type, xmlOptions);
        }

        public static DownloadedSchemasDocument parse(Node node) throws XmlException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(node, DownloadedSchemasDocument.type, (XmlOptions) null);
        }

        public static DownloadedSchemasDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(node, DownloadedSchemasDocument.type, xmlOptions);
        }

        public static DownloadedSchemasDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DownloadedSchemasDocument.type, (XmlOptions) null);
        }

        public static DownloadedSchemasDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (DownloadedSchemasDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DownloadedSchemasDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DownloadedSchemasDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DownloadedSchemasDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
