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
public interface XmlLong extends XmlInteger {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_long");

    long getLongValue();

    long longValue();

    void set(long j);

    void setLongValue(long j);

    public static final class Factory {
        public static XmlLong newInstance() {
            return (XmlLong) XmlBeans.getContextTypeLoader().newInstance(XmlLong.type, null);
        }

        public static XmlLong newInstance(XmlOptions xmlOptions) {
            return (XmlLong) XmlBeans.getContextTypeLoader().newInstance(XmlLong.type, xmlOptions);
        }

        public static XmlLong newValue(Object obj) {
            return (XmlLong) XmlLong.type.newValue(obj);
        }

        public static XmlLong parse(String str) throws XmlException {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(str, XmlLong.type, (XmlOptions) null);
        }

        public static XmlLong parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(str, XmlLong.type, xmlOptions);
        }

        public static XmlLong parse(File file) throws XmlException, IOException {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(file, XmlLong.type, (XmlOptions) null);
        }

        public static XmlLong parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(file, XmlLong.type, xmlOptions);
        }

        public static XmlLong parse(URL url) throws XmlException, IOException {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(url, XmlLong.type, (XmlOptions) null);
        }

        public static XmlLong parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(url, XmlLong.type, xmlOptions);
        }

        public static XmlLong parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(inputStream, XmlLong.type, (XmlOptions) null);
        }

        public static XmlLong parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(inputStream, XmlLong.type, xmlOptions);
        }

        public static XmlLong parse(Reader reader) throws XmlException, IOException {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(reader, XmlLong.type, (XmlOptions) null);
        }

        public static XmlLong parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(reader, XmlLong.type, xmlOptions);
        }

        public static XmlLong parse(Node node) throws XmlException {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(node, XmlLong.type, (XmlOptions) null);
        }

        public static XmlLong parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(node, XmlLong.type, xmlOptions);
        }

        public static XmlLong parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlLong.type, (XmlOptions) null);
        }

        public static XmlLong parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlLong.type, xmlOptions);
        }

        public static XmlLong parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlLong.type, (XmlOptions) null);
        }

        public static XmlLong parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlLong.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlLong.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlLong.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
