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
public interface UniqueDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(UniqueDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("unique3752doctype");

    Keybase addNewUnique();

    Keybase getUnique();

    void setUnique(Keybase keybase);

    public static final class Factory {
        public static UniqueDocument newInstance() {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().newInstance(UniqueDocument.type, (XmlOptions) null);
        }

        public static UniqueDocument newInstance(XmlOptions xmlOptions) {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().newInstance(UniqueDocument.type, xmlOptions);
        }

        public static UniqueDocument parse(String str) throws XmlException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(str, UniqueDocument.type, (XmlOptions) null);
        }

        public static UniqueDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(str, UniqueDocument.type, xmlOptions);
        }

        public static UniqueDocument parse(File file) throws XmlException, IOException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(file, UniqueDocument.type, (XmlOptions) null);
        }

        public static UniqueDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(file, UniqueDocument.type, xmlOptions);
        }

        public static UniqueDocument parse(URL url) throws XmlException, IOException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(url, UniqueDocument.type, (XmlOptions) null);
        }

        public static UniqueDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(url, UniqueDocument.type, xmlOptions);
        }

        public static UniqueDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(inputStream, UniqueDocument.type, (XmlOptions) null);
        }

        public static UniqueDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(inputStream, UniqueDocument.type, xmlOptions);
        }

        public static UniqueDocument parse(Reader reader) throws XmlException, IOException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(reader, UniqueDocument.type, (XmlOptions) null);
        }

        public static UniqueDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(reader, UniqueDocument.type, xmlOptions);
        }

        public static UniqueDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, UniqueDocument.type, (XmlOptions) null);
        }

        public static UniqueDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, UniqueDocument.type, xmlOptions);
        }

        public static UniqueDocument parse(Node node) throws XmlException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(node, UniqueDocument.type, (XmlOptions) null);
        }

        public static UniqueDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(node, UniqueDocument.type, xmlOptions);
        }

        public static UniqueDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, UniqueDocument.type, (XmlOptions) null);
        }

        public static UniqueDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (UniqueDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, UniqueDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, UniqueDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, UniqueDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
