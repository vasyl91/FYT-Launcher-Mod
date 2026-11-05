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
public interface XmlUnsignedInt extends XmlUnsignedLong {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_unsignedInt");

    long getLongValue();

    long longValue();

    void set(long j);

    void setLongValue(long j);

    public static final class Factory {
        public static XmlUnsignedInt newInstance() {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedInt.type, null);
        }

        public static XmlUnsignedInt newInstance(XmlOptions xmlOptions) {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedInt.type, xmlOptions);
        }

        public static XmlUnsignedInt newValue(Object obj) {
            return (XmlUnsignedInt) XmlUnsignedInt.type.newValue(obj);
        }

        public static XmlUnsignedInt parse(String str) throws XmlException {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(str, XmlUnsignedInt.type, (XmlOptions) null);
        }

        public static XmlUnsignedInt parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(str, XmlUnsignedInt.type, xmlOptions);
        }

        public static XmlUnsignedInt parse(File file) throws XmlException, IOException {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(file, XmlUnsignedInt.type, (XmlOptions) null);
        }

        public static XmlUnsignedInt parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(file, XmlUnsignedInt.type, xmlOptions);
        }

        public static XmlUnsignedInt parse(URL url) throws XmlException, IOException {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(url, XmlUnsignedInt.type, (XmlOptions) null);
        }

        public static XmlUnsignedInt parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(url, XmlUnsignedInt.type, xmlOptions);
        }

        public static XmlUnsignedInt parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(inputStream, XmlUnsignedInt.type, (XmlOptions) null);
        }

        public static XmlUnsignedInt parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(inputStream, XmlUnsignedInt.type, xmlOptions);
        }

        public static XmlUnsignedInt parse(Reader reader) throws XmlException, IOException {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(reader, XmlUnsignedInt.type, (XmlOptions) null);
        }

        public static XmlUnsignedInt parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(reader, XmlUnsignedInt.type, xmlOptions);
        }

        public static XmlUnsignedInt parse(Node node) throws XmlException {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(node, XmlUnsignedInt.type, (XmlOptions) null);
        }

        public static XmlUnsignedInt parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(node, XmlUnsignedInt.type, xmlOptions);
        }

        public static XmlUnsignedInt parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlUnsignedInt.type, (XmlOptions) null);
        }

        public static XmlUnsignedInt parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlUnsignedInt.type, xmlOptions);
        }

        public static XmlUnsignedInt parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlUnsignedInt.type, (XmlOptions) null);
        }

        public static XmlUnsignedInt parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlUnsignedInt.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlUnsignedInt.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlUnsignedInt.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
