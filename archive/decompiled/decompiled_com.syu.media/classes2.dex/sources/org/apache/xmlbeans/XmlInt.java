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
public interface XmlInt extends XmlLong {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_int");

    int getIntValue();

    int intValue();

    void set(int i);

    void setIntValue(int i);

    public static final class Factory {
        public static XmlInt newInstance() {
            return (XmlInt) XmlBeans.getContextTypeLoader().newInstance(XmlInt.type, null);
        }

        public static XmlInt newInstance(XmlOptions xmlOptions) {
            return (XmlInt) XmlBeans.getContextTypeLoader().newInstance(XmlInt.type, xmlOptions);
        }

        public static XmlInt newValue(Object obj) {
            return (XmlInt) XmlInt.type.newValue(obj);
        }

        public static XmlInt parse(String str) throws XmlException {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(str, XmlInt.type, (XmlOptions) null);
        }

        public static XmlInt parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(str, XmlInt.type, xmlOptions);
        }

        public static XmlInt parse(File file) throws XmlException, IOException {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(file, XmlInt.type, (XmlOptions) null);
        }

        public static XmlInt parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(file, XmlInt.type, xmlOptions);
        }

        public static XmlInt parse(URL url) throws XmlException, IOException {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(url, XmlInt.type, (XmlOptions) null);
        }

        public static XmlInt parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(url, XmlInt.type, xmlOptions);
        }

        public static XmlInt parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(inputStream, XmlInt.type, (XmlOptions) null);
        }

        public static XmlInt parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(inputStream, XmlInt.type, xmlOptions);
        }

        public static XmlInt parse(Reader reader) throws XmlException, IOException {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(reader, XmlInt.type, (XmlOptions) null);
        }

        public static XmlInt parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(reader, XmlInt.type, xmlOptions);
        }

        public static XmlInt parse(Node node) throws XmlException {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(node, XmlInt.type, (XmlOptions) null);
        }

        public static XmlInt parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(node, XmlInt.type, xmlOptions);
        }

        public static XmlInt parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlInt.type, (XmlOptions) null);
        }

        public static XmlInt parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlInt.type, xmlOptions);
        }

        public static XmlInt parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlInt.type, (XmlOptions) null);
        }

        public static XmlInt parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlInt.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlInt.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlInt.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
