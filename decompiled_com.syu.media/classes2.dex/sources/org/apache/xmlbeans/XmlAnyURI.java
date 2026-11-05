package org.apache.xmlbeans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface XmlAnyURI extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_anyURI");

    public static final class Factory {
        public static XmlAnyURI newInstance() {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().newInstance(XmlAnyURI.type, null);
        }

        public static XmlAnyURI newInstance(XmlOptions xmlOptions) {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().newInstance(XmlAnyURI.type, xmlOptions);
        }

        public static XmlAnyURI newValue(Object obj) {
            return (XmlAnyURI) XmlAnyURI.type.newValue(obj);
        }

        public static XmlAnyURI parse(String str) throws XmlException {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(str, XmlAnyURI.type, (XmlOptions) null);
        }

        public static XmlAnyURI parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(str, XmlAnyURI.type, xmlOptions);
        }

        public static XmlAnyURI parse(File file) throws XmlException, IOException {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(file, XmlAnyURI.type, (XmlOptions) null);
        }

        public static XmlAnyURI parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(file, XmlAnyURI.type, xmlOptions);
        }

        public static XmlAnyURI parse(URL url) throws XmlException, IOException {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(url, XmlAnyURI.type, (XmlOptions) null);
        }

        public static XmlAnyURI parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(url, XmlAnyURI.type, xmlOptions);
        }

        public static XmlAnyURI parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(inputStream, XmlAnyURI.type, (XmlOptions) null);
        }

        public static XmlAnyURI parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(inputStream, XmlAnyURI.type, xmlOptions);
        }

        public static XmlAnyURI parse(Reader reader) throws XmlException, IOException {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(reader, XmlAnyURI.type, (XmlOptions) null);
        }

        public static XmlAnyURI parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(reader, XmlAnyURI.type, xmlOptions);
        }

        public static XmlAnyURI parse(Node node) throws XmlException {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(node, XmlAnyURI.type, (XmlOptions) null);
        }

        public static XmlAnyURI parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(node, XmlAnyURI.type, xmlOptions);
        }

        public static XmlAnyURI parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlAnyURI.type, (XmlOptions) null);
        }

        public static XmlAnyURI parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlAnyURI.type, xmlOptions);
        }

        public static XmlAnyURI parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlAnyURI.type, (XmlOptions) null);
        }

        public static XmlAnyURI parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlAnyURI.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlAnyURI.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlAnyURI.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
