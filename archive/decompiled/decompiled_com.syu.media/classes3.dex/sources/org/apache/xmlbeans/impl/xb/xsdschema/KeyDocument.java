package org.apache.xmlbeans.impl.xb.xsdschema;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface KeyDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(KeyDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("key5d16doctype");

    Keybase addNewKey();

    Keybase getKey();

    void setKey(Keybase keybase);

    public static final class Factory {
        public static KeyDocument newInstance() {
            return (KeyDocument) XmlBeans.getContextTypeLoader().newInstance(KeyDocument.type, (XmlOptions) null);
        }

        public static KeyDocument newInstance(XmlOptions xmlOptions) {
            return (KeyDocument) XmlBeans.getContextTypeLoader().newInstance(KeyDocument.type, xmlOptions);
        }

        public static KeyDocument parse(String str) throws XmlException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(str, KeyDocument.type, (XmlOptions) null);
        }

        public static KeyDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(str, KeyDocument.type, xmlOptions);
        }

        public static KeyDocument parse(File file) throws XmlException, IOException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(file, KeyDocument.type, (XmlOptions) null);
        }

        public static KeyDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(file, KeyDocument.type, xmlOptions);
        }

        public static KeyDocument parse(URL url) throws XmlException, IOException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(url, KeyDocument.type, (XmlOptions) null);
        }

        public static KeyDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(url, KeyDocument.type, xmlOptions);
        }

        public static KeyDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(inputStream, KeyDocument.type, (XmlOptions) null);
        }

        public static KeyDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(inputStream, KeyDocument.type, xmlOptions);
        }

        public static KeyDocument parse(Reader reader) throws XmlException, IOException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(reader, KeyDocument.type, (XmlOptions) null);
        }

        public static KeyDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(reader, KeyDocument.type, xmlOptions);
        }

        public static KeyDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, KeyDocument.type, (XmlOptions) null);
        }

        public static KeyDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, KeyDocument.type, xmlOptions);
        }

        public static KeyDocument parse(Node node) throws XmlException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(node, KeyDocument.type, (XmlOptions) null);
        }

        public static KeyDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(node, KeyDocument.type, xmlOptions);
        }

        public static KeyDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, KeyDocument.type, (XmlOptions) null);
        }

        public static KeyDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (KeyDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, KeyDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, KeyDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, KeyDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
