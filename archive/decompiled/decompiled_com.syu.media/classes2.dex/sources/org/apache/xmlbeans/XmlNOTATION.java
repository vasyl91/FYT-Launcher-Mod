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
public interface XmlNOTATION extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_NOTATION");

    public static final class Factory {
        public static XmlNOTATION newInstance() {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().newInstance(XmlNOTATION.type, null);
        }

        public static XmlNOTATION newInstance(XmlOptions xmlOptions) {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().newInstance(XmlNOTATION.type, xmlOptions);
        }

        public static XmlNOTATION newValue(Object obj) {
            return (XmlNOTATION) XmlNOTATION.type.newValue(obj);
        }

        public static XmlNOTATION parse(String str) throws XmlException {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(str, XmlNOTATION.type, (XmlOptions) null);
        }

        public static XmlNOTATION parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(str, XmlNOTATION.type, xmlOptions);
        }

        public static XmlNOTATION parse(File file) throws XmlException, IOException {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(file, XmlNOTATION.type, (XmlOptions) null);
        }

        public static XmlNOTATION parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(file, XmlNOTATION.type, xmlOptions);
        }

        public static XmlNOTATION parse(URL url) throws XmlException, IOException {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(url, XmlNOTATION.type, (XmlOptions) null);
        }

        public static XmlNOTATION parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(url, XmlNOTATION.type, xmlOptions);
        }

        public static XmlNOTATION parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNOTATION.type, (XmlOptions) null);
        }

        public static XmlNOTATION parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNOTATION.type, xmlOptions);
        }

        public static XmlNOTATION parse(Reader reader) throws XmlException, IOException {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(reader, XmlNOTATION.type, (XmlOptions) null);
        }

        public static XmlNOTATION parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(reader, XmlNOTATION.type, xmlOptions);
        }

        public static XmlNOTATION parse(Node node) throws XmlException {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(node, XmlNOTATION.type, (XmlOptions) null);
        }

        public static XmlNOTATION parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(node, XmlNOTATION.type, xmlOptions);
        }

        public static XmlNOTATION parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNOTATION.type, (XmlOptions) null);
        }

        public static XmlNOTATION parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNOTATION.type, xmlOptions);
        }

        public static XmlNOTATION parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNOTATION.type, (XmlOptions) null);
        }

        public static XmlNOTATION parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNOTATION.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNOTATION.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNOTATION.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
