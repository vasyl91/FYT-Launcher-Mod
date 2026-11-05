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
public interface XmlNonNegativeInteger extends XmlInteger {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_nonNegativeInteger");

    public static final class Factory {
        public static XmlNonNegativeInteger newInstance() {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().newInstance(XmlNonNegativeInteger.type, null);
        }

        public static XmlNonNegativeInteger newInstance(XmlOptions xmlOptions) {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().newInstance(XmlNonNegativeInteger.type, xmlOptions);
        }

        public static XmlNonNegativeInteger newValue(Object obj) {
            return (XmlNonNegativeInteger) XmlNonNegativeInteger.type.newValue(obj);
        }

        public static XmlNonNegativeInteger parse(String str) throws XmlException {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(str, XmlNonNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNonNegativeInteger parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(str, XmlNonNegativeInteger.type, xmlOptions);
        }

        public static XmlNonNegativeInteger parse(File file) throws XmlException, IOException {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(file, XmlNonNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNonNegativeInteger parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(file, XmlNonNegativeInteger.type, xmlOptions);
        }

        public static XmlNonNegativeInteger parse(URL url) throws XmlException, IOException {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(url, XmlNonNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNonNegativeInteger parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(url, XmlNonNegativeInteger.type, xmlOptions);
        }

        public static XmlNonNegativeInteger parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNonNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNonNegativeInteger parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNonNegativeInteger.type, xmlOptions);
        }

        public static XmlNonNegativeInteger parse(Reader reader) throws XmlException, IOException {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlNonNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNonNegativeInteger parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlNonNegativeInteger.type, xmlOptions);
        }

        public static XmlNonNegativeInteger parse(Node node) throws XmlException {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(node, XmlNonNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNonNegativeInteger parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(node, XmlNonNegativeInteger.type, xmlOptions);
        }

        public static XmlNonNegativeInteger parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNonNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNonNegativeInteger parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNonNegativeInteger.type, xmlOptions);
        }

        public static XmlNonNegativeInteger parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNonNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNonNegativeInteger parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNonNegativeInteger.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNonNegativeInteger.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNonNegativeInteger.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
