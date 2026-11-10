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
public interface XmlUnsignedLong extends XmlNonNegativeInteger {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_unsignedLong");

    public static final class Factory {
        public static XmlUnsignedLong newInstance() {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedLong.type, null);
        }

        public static XmlUnsignedLong newInstance(XmlOptions xmlOptions) {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedLong.type, xmlOptions);
        }

        public static XmlUnsignedLong newValue(Object obj) {
            return (XmlUnsignedLong) XmlUnsignedLong.type.newValue(obj);
        }

        public static XmlUnsignedLong parse(String str) throws XmlException {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(str, XmlUnsignedLong.type, (XmlOptions) null);
        }

        public static XmlUnsignedLong parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(str, XmlUnsignedLong.type, xmlOptions);
        }

        public static XmlUnsignedLong parse(File file) throws XmlException, IOException {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(file, XmlUnsignedLong.type, (XmlOptions) null);
        }

        public static XmlUnsignedLong parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(file, XmlUnsignedLong.type, xmlOptions);
        }

        public static XmlUnsignedLong parse(URL url) throws XmlException, IOException {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(url, XmlUnsignedLong.type, (XmlOptions) null);
        }

        public static XmlUnsignedLong parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(url, XmlUnsignedLong.type, xmlOptions);
        }

        public static XmlUnsignedLong parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(inputStream, XmlUnsignedLong.type, (XmlOptions) null);
        }

        public static XmlUnsignedLong parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(inputStream, XmlUnsignedLong.type, xmlOptions);
        }

        public static XmlUnsignedLong parse(Reader reader) throws XmlException, IOException {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(reader, XmlUnsignedLong.type, (XmlOptions) null);
        }

        public static XmlUnsignedLong parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(reader, XmlUnsignedLong.type, xmlOptions);
        }

        public static XmlUnsignedLong parse(Node node) throws XmlException {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(node, XmlUnsignedLong.type, (XmlOptions) null);
        }

        public static XmlUnsignedLong parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(node, XmlUnsignedLong.type, xmlOptions);
        }

        public static XmlUnsignedLong parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlUnsignedLong.type, (XmlOptions) null);
        }

        public static XmlUnsignedLong parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlUnsignedLong.type, xmlOptions);
        }

        public static XmlUnsignedLong parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlUnsignedLong.type, (XmlOptions) null);
        }

        public static XmlUnsignedLong parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlUnsignedLong.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlUnsignedLong.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlUnsignedLong.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
