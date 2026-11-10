package org.apache.xmlbeans.impl.xb.ltgfmt;

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
public interface Code extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Code.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("codef72ftype");

    String getID();

    boolean isSetID();

    void setID(String str);

    void unsetID();

    XmlToken xgetID();

    void xsetID(XmlToken xmlToken);

    public static final class Factory {
        public static Code newInstance() {
            return (Code) XmlBeans.getContextTypeLoader().newInstance(Code.type, (XmlOptions) null);
        }

        public static Code newInstance(XmlOptions xmlOptions) {
            return (Code) XmlBeans.getContextTypeLoader().newInstance(Code.type, xmlOptions);
        }

        public static Code parse(String str) throws XmlException {
            return (Code) XmlBeans.getContextTypeLoader().parse(str, Code.type, (XmlOptions) null);
        }

        public static Code parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (Code) XmlBeans.getContextTypeLoader().parse(str, Code.type, xmlOptions);
        }

        public static Code parse(File file) throws XmlException, IOException {
            return (Code) XmlBeans.getContextTypeLoader().parse(file, Code.type, (XmlOptions) null);
        }

        public static Code parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Code) XmlBeans.getContextTypeLoader().parse(file, Code.type, xmlOptions);
        }

        public static Code parse(URL url) throws XmlException, IOException {
            return (Code) XmlBeans.getContextTypeLoader().parse(url, Code.type, (XmlOptions) null);
        }

        public static Code parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Code) XmlBeans.getContextTypeLoader().parse(url, Code.type, xmlOptions);
        }

        public static Code parse(InputStream inputStream) throws XmlException, IOException {
            return (Code) XmlBeans.getContextTypeLoader().parse(inputStream, Code.type, (XmlOptions) null);
        }

        public static Code parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Code) XmlBeans.getContextTypeLoader().parse(inputStream, Code.type, xmlOptions);
        }

        public static Code parse(Reader reader) throws XmlException, IOException {
            return (Code) XmlBeans.getContextTypeLoader().parse(reader, Code.type, (XmlOptions) null);
        }

        public static Code parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Code) XmlBeans.getContextTypeLoader().parse(reader, Code.type, xmlOptions);
        }

        public static Code parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (Code) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Code.type, (XmlOptions) null);
        }

        public static Code parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (Code) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Code.type, xmlOptions);
        }

        public static Code parse(Node node) throws XmlException {
            return (Code) XmlBeans.getContextTypeLoader().parse(node, Code.type, (XmlOptions) null);
        }

        public static Code parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (Code) XmlBeans.getContextTypeLoader().parse(node, Code.type, xmlOptions);
        }

        public static Code parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (Code) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Code.type, (XmlOptions) null);
        }

        public static Code parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (Code) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Code.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Code.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Code.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
