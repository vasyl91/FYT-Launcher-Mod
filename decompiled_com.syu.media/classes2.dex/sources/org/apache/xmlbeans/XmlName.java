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
public interface XmlName extends XmlToken {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_Name");

    public static final class Factory {
        public static XmlName newInstance() {
            return (XmlName) XmlBeans.getContextTypeLoader().newInstance(XmlName.type, null);
        }

        public static XmlName newInstance(XmlOptions xmlOptions) {
            return (XmlName) XmlBeans.getContextTypeLoader().newInstance(XmlName.type, xmlOptions);
        }

        public static XmlName newValue(Object obj) {
            return (XmlName) XmlName.type.newValue(obj);
        }

        public static XmlName parse(String str) throws XmlException {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(str, XmlName.type, (XmlOptions) null);
        }

        public static XmlName parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(str, XmlName.type, xmlOptions);
        }

        public static XmlName parse(File file) throws XmlException, IOException {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(file, XmlName.type, (XmlOptions) null);
        }

        public static XmlName parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(file, XmlName.type, xmlOptions);
        }

        public static XmlName parse(URL url) throws XmlException, IOException {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(url, XmlName.type, (XmlOptions) null);
        }

        public static XmlName parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(url, XmlName.type, xmlOptions);
        }

        public static XmlName parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(inputStream, XmlName.type, (XmlOptions) null);
        }

        public static XmlName parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(inputStream, XmlName.type, xmlOptions);
        }

        public static XmlName parse(Reader reader) throws XmlException, IOException {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(reader, XmlName.type, (XmlOptions) null);
        }

        public static XmlName parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(reader, XmlName.type, xmlOptions);
        }

        public static XmlName parse(Node node) throws XmlException {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(node, XmlName.type, (XmlOptions) null);
        }

        public static XmlName parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(node, XmlName.type, xmlOptions);
        }

        public static XmlName parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlName.type, (XmlOptions) null);
        }

        public static XmlName parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlName.type, xmlOptions);
        }

        public static XmlName parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlName.type, (XmlOptions) null);
        }

        public static XmlName parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlName.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlName.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlName.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
