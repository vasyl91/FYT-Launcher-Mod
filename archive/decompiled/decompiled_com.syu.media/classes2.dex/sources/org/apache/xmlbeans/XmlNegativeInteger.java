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
public interface XmlNegativeInteger extends XmlNonPositiveInteger {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_negativeInteger");

    public static final class Factory {
        public static XmlNegativeInteger newInstance() {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().newInstance(XmlNegativeInteger.type, null);
        }

        public static XmlNegativeInteger newInstance(XmlOptions xmlOptions) {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().newInstance(XmlNegativeInteger.type, xmlOptions);
        }

        public static XmlNegativeInteger newValue(Object obj) {
            return (XmlNegativeInteger) XmlNegativeInteger.type.newValue(obj);
        }

        public static XmlNegativeInteger parse(String str) throws XmlException {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(str, XmlNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNegativeInteger parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(str, XmlNegativeInteger.type, xmlOptions);
        }

        public static XmlNegativeInteger parse(File file) throws XmlException, IOException {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(file, XmlNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNegativeInteger parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(file, XmlNegativeInteger.type, xmlOptions);
        }

        public static XmlNegativeInteger parse(URL url) throws XmlException, IOException {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(url, XmlNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNegativeInteger parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(url, XmlNegativeInteger.type, xmlOptions);
        }

        public static XmlNegativeInteger parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNegativeInteger parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNegativeInteger.type, xmlOptions);
        }

        public static XmlNegativeInteger parse(Reader reader) throws XmlException, IOException {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNegativeInteger parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlNegativeInteger.type, xmlOptions);
        }

        public static XmlNegativeInteger parse(Node node) throws XmlException {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(node, XmlNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNegativeInteger parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(node, XmlNegativeInteger.type, xmlOptions);
        }

        public static XmlNegativeInteger parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNegativeInteger parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNegativeInteger.type, xmlOptions);
        }

        public static XmlNegativeInteger parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNegativeInteger parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNegativeInteger.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNegativeInteger.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNegativeInteger.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
