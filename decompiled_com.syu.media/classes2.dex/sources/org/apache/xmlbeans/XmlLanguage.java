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
public interface XmlLanguage extends XmlToken {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_language");

    public static final class Factory {
        public static XmlLanguage newInstance() {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().newInstance(XmlLanguage.type, null);
        }

        public static XmlLanguage newInstance(XmlOptions xmlOptions) {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().newInstance(XmlLanguage.type, xmlOptions);
        }

        public static XmlLanguage newValue(Object obj) {
            return (XmlLanguage) XmlLanguage.type.newValue(obj);
        }

        public static XmlLanguage parse(String str) throws XmlException {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(str, XmlLanguage.type, (XmlOptions) null);
        }

        public static XmlLanguage parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(str, XmlLanguage.type, xmlOptions);
        }

        public static XmlLanguage parse(File file) throws XmlException, IOException {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(file, XmlLanguage.type, (XmlOptions) null);
        }

        public static XmlLanguage parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(file, XmlLanguage.type, xmlOptions);
        }

        public static XmlLanguage parse(URL url) throws XmlException, IOException {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(url, XmlLanguage.type, (XmlOptions) null);
        }

        public static XmlLanguage parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(url, XmlLanguage.type, xmlOptions);
        }

        public static XmlLanguage parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(inputStream, XmlLanguage.type, (XmlOptions) null);
        }

        public static XmlLanguage parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(inputStream, XmlLanguage.type, xmlOptions);
        }

        public static XmlLanguage parse(Reader reader) throws XmlException, IOException {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(reader, XmlLanguage.type, (XmlOptions) null);
        }

        public static XmlLanguage parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(reader, XmlLanguage.type, xmlOptions);
        }

        public static XmlLanguage parse(Node node) throws XmlException {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(node, XmlLanguage.type, (XmlOptions) null);
        }

        public static XmlLanguage parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(node, XmlLanguage.type, xmlOptions);
        }

        public static XmlLanguage parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlLanguage.type, (XmlOptions) null);
        }

        public static XmlLanguage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlLanguage.type, xmlOptions);
        }

        public static XmlLanguage parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlLanguage.type, (XmlOptions) null);
        }

        public static XmlLanguage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlLanguage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlLanguage.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlLanguage.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
