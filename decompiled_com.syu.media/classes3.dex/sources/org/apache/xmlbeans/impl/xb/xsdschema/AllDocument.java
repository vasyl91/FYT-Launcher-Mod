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
public interface AllDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(AllDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("all7214doctype");

    All addNewAll();

    All getAll();

    void setAll(All all);

    public static final class Factory {
        public static AllDocument newInstance() {
            return (AllDocument) XmlBeans.getContextTypeLoader().newInstance(AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument newInstance(XmlOptions xmlOptions) {
            return (AllDocument) XmlBeans.getContextTypeLoader().newInstance(AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(String str) throws XmlException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(str, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(str, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(File file) throws XmlException, IOException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(file, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(file, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(URL url) throws XmlException, IOException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(url, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(url, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(Reader reader) throws XmlException, IOException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(reader, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(reader, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(Node node) throws XmlException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(node, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(node, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AllDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AllDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AllDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
