package org.apache.xmlbeans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface XmlQName extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_QName");

    QName getQNameValue();

    QName qNameValue();

    void set(QName qName);

    void setQNameValue(QName qName);

    public static final class Factory {
        public static XmlQName newInstance() {
            return (XmlQName) XmlBeans.getContextTypeLoader().newInstance(XmlQName.type, null);
        }

        public static XmlQName newInstance(XmlOptions xmlOptions) {
            return (XmlQName) XmlBeans.getContextTypeLoader().newInstance(XmlQName.type, xmlOptions);
        }

        public static XmlQName newValue(Object obj) {
            return (XmlQName) XmlQName.type.newValue(obj);
        }

        public static XmlQName parse(String str) throws XmlException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(str, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(str, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(File file) throws XmlException, IOException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(file, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(file, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(URL url) throws XmlException, IOException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(url, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(url, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(inputStream, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(inputStream, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(Reader reader) throws XmlException, IOException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(reader, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(reader, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(Node node) throws XmlException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(node, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(node, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlQName.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlQName.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlQName.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
