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
public interface XmlNCName extends XmlName {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_NCName");

    public static final class Factory {
        public static XmlNCName newInstance() {
            return (XmlNCName) XmlBeans.getContextTypeLoader().newInstance(XmlNCName.type, null);
        }

        public static XmlNCName newInstance(XmlOptions xmlOptions) {
            return (XmlNCName) XmlBeans.getContextTypeLoader().newInstance(XmlNCName.type, xmlOptions);
        }

        public static XmlNCName newValue(Object obj) {
            return (XmlNCName) XmlNCName.type.newValue(obj);
        }

        public static XmlNCName parse(String str) throws XmlException {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(str, XmlNCName.type, (XmlOptions) null);
        }

        public static XmlNCName parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(str, XmlNCName.type, xmlOptions);
        }

        public static XmlNCName parse(File file) throws XmlException, IOException {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(file, XmlNCName.type, (XmlOptions) null);
        }

        public static XmlNCName parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(file, XmlNCName.type, xmlOptions);
        }

        public static XmlNCName parse(URL url) throws XmlException, IOException {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(url, XmlNCName.type, (XmlOptions) null);
        }

        public static XmlNCName parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(url, XmlNCName.type, xmlOptions);
        }

        public static XmlNCName parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNCName.type, (XmlOptions) null);
        }

        public static XmlNCName parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNCName.type, xmlOptions);
        }

        public static XmlNCName parse(Reader reader) throws XmlException, IOException {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(reader, XmlNCName.type, (XmlOptions) null);
        }

        public static XmlNCName parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(reader, XmlNCName.type, xmlOptions);
        }

        public static XmlNCName parse(Node node) throws XmlException {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(node, XmlNCName.type, (XmlOptions) null);
        }

        public static XmlNCName parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(node, XmlNCName.type, xmlOptions);
        }

        public static XmlNCName parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNCName.type, (XmlOptions) null);
        }

        public static XmlNCName parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNCName.type, xmlOptions);
        }

        public static XmlNCName parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNCName.type, (XmlOptions) null);
        }

        public static XmlNCName parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNCName.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNCName.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNCName.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
