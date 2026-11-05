package org.apache.xmlbeans.impl.xb.xsdownload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface DownloadedSchemaEntry extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(DownloadedSchemaEntry.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("downloadedschemaentry1c75type");

    XmlAnyURI addNewSchemaLocation();

    void addSchemaLocation(String str);

    String getFilename();

    String getNamespace();

    String getSchemaLocationArray(int i);

    String[] getSchemaLocationArray();

    String getSha1();

    XmlAnyURI insertNewSchemaLocation(int i);

    void insertSchemaLocation(int i, String str);

    boolean isSetNamespace();

    void removeSchemaLocation(int i);

    void setFilename(String str);

    void setNamespace(String str);

    void setSchemaLocationArray(int i, String str);

    void setSchemaLocationArray(String[] strArr);

    void setSha1(String str);

    int sizeOfSchemaLocationArray();

    void unsetNamespace();

    XmlToken xgetFilename();

    XmlAnyURI xgetNamespace();

    XmlAnyURI xgetSchemaLocationArray(int i);

    XmlAnyURI[] xgetSchemaLocationArray();

    XmlToken xgetSha1();

    void xsetFilename(XmlToken xmlToken);

    void xsetNamespace(XmlAnyURI xmlAnyURI);

    void xsetSchemaLocationArray(int i, XmlAnyURI xmlAnyURI);

    void xsetSchemaLocationArray(XmlAnyURI[] xmlAnyURIArr);

    void xsetSha1(XmlToken xmlToken);

    public static final class Factory {
        public static DownloadedSchemaEntry newInstance() {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().newInstance(DownloadedSchemaEntry.type, (XmlOptions) null);
        }

        public static DownloadedSchemaEntry newInstance(XmlOptions xmlOptions) {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().newInstance(DownloadedSchemaEntry.type, xmlOptions);
        }

        public static DownloadedSchemaEntry parse(String str) throws XmlException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(str, DownloadedSchemaEntry.type, (XmlOptions) null);
        }

        public static DownloadedSchemaEntry parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(str, DownloadedSchemaEntry.type, xmlOptions);
        }

        public static DownloadedSchemaEntry parse(File file) throws XmlException, IOException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(file, DownloadedSchemaEntry.type, (XmlOptions) null);
        }

        public static DownloadedSchemaEntry parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(file, DownloadedSchemaEntry.type, xmlOptions);
        }

        public static DownloadedSchemaEntry parse(URL url) throws XmlException, IOException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(url, DownloadedSchemaEntry.type, (XmlOptions) null);
        }

        public static DownloadedSchemaEntry parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(url, DownloadedSchemaEntry.type, xmlOptions);
        }

        public static DownloadedSchemaEntry parse(InputStream inputStream) throws XmlException, IOException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(inputStream, DownloadedSchemaEntry.type, (XmlOptions) null);
        }

        public static DownloadedSchemaEntry parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(inputStream, DownloadedSchemaEntry.type, xmlOptions);
        }

        public static DownloadedSchemaEntry parse(Reader reader) throws XmlException, IOException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(reader, DownloadedSchemaEntry.type, (XmlOptions) null);
        }

        public static DownloadedSchemaEntry parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(reader, DownloadedSchemaEntry.type, xmlOptions);
        }

        public static DownloadedSchemaEntry parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DownloadedSchemaEntry.type, (XmlOptions) null);
        }

        public static DownloadedSchemaEntry parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DownloadedSchemaEntry.type, xmlOptions);
        }

        public static DownloadedSchemaEntry parse(Node node) throws XmlException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(node, DownloadedSchemaEntry.type, (XmlOptions) null);
        }

        public static DownloadedSchemaEntry parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(node, DownloadedSchemaEntry.type, xmlOptions);
        }

        public static DownloadedSchemaEntry parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DownloadedSchemaEntry.type, (XmlOptions) null);
        }

        public static DownloadedSchemaEntry parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (DownloadedSchemaEntry) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DownloadedSchemaEntry.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DownloadedSchemaEntry.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DownloadedSchemaEntry.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
