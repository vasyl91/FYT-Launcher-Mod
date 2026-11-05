package org.apache.xmlbeans.impl.xb.substwsdl;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface TImport extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(TImport.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("timport22datype");

    String getLocation();

    String getNamespace();

    void setLocation(String str);

    void setNamespace(String str);

    XmlAnyURI xgetLocation();

    XmlAnyURI xgetNamespace();

    void xsetLocation(XmlAnyURI xmlAnyURI);

    void xsetNamespace(XmlAnyURI xmlAnyURI);

    public static final class Factory {
        public static TImport newInstance() {
            return (TImport) XmlBeans.getContextTypeLoader().newInstance(TImport.type, (XmlOptions) null);
        }

        public static TImport newInstance(XmlOptions xmlOptions) {
            return (TImport) XmlBeans.getContextTypeLoader().newInstance(TImport.type, xmlOptions);
        }

        public static TImport parse(String str) throws XmlException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(str, TImport.type, (XmlOptions) null);
        }

        public static TImport parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(str, TImport.type, xmlOptions);
        }

        public static TImport parse(File file) throws XmlException, IOException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(file, TImport.type, (XmlOptions) null);
        }

        public static TImport parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(file, TImport.type, xmlOptions);
        }

        public static TImport parse(URL url) throws XmlException, IOException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(url, TImport.type, (XmlOptions) null);
        }

        public static TImport parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(url, TImport.type, xmlOptions);
        }

        public static TImport parse(InputStream inputStream) throws XmlException, IOException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(inputStream, TImport.type, (XmlOptions) null);
        }

        public static TImport parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(inputStream, TImport.type, xmlOptions);
        }

        public static TImport parse(Reader reader) throws XmlException, IOException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(reader, TImport.type, (XmlOptions) null);
        }

        public static TImport parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(reader, TImport.type, xmlOptions);
        }

        public static TImport parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TImport.type, (XmlOptions) null);
        }

        public static TImport parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TImport.type, xmlOptions);
        }

        public static TImport parse(Node node) throws XmlException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(node, TImport.type, (XmlOptions) null);
        }

        public static TImport parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(node, TImport.type, xmlOptions);
        }

        public static TImport parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TImport.type, (XmlOptions) null);
        }

        public static TImport parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (TImport) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TImport.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TImport.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TImport.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
