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
public interface XmlByte extends XmlShort {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_byte");

    byte byteValue();

    byte getByteValue();

    void set(byte b);

    void setByteValue(byte b);

    public static final class Factory {
        public static XmlByte newInstance() {
            return (XmlByte) XmlBeans.getContextTypeLoader().newInstance(XmlByte.type, null);
        }

        public static XmlByte newInstance(XmlOptions xmlOptions) {
            return (XmlByte) XmlBeans.getContextTypeLoader().newInstance(XmlByte.type, xmlOptions);
        }

        public static XmlByte newValue(Object obj) {
            return (XmlByte) XmlByte.type.newValue(obj);
        }

        public static XmlByte parse(String str) throws XmlException {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(str, XmlByte.type, (XmlOptions) null);
        }

        public static XmlByte parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(str, XmlByte.type, xmlOptions);
        }

        public static XmlByte parse(File file) throws XmlException, IOException {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(file, XmlByte.type, (XmlOptions) null);
        }

        public static XmlByte parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(file, XmlByte.type, xmlOptions);
        }

        public static XmlByte parse(URL url) throws XmlException, IOException {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(url, XmlByte.type, (XmlOptions) null);
        }

        public static XmlByte parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(url, XmlByte.type, xmlOptions);
        }

        public static XmlByte parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(inputStream, XmlByte.type, (XmlOptions) null);
        }

        public static XmlByte parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(inputStream, XmlByte.type, xmlOptions);
        }

        public static XmlByte parse(Reader reader) throws XmlException, IOException {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(reader, XmlByte.type, (XmlOptions) null);
        }

        public static XmlByte parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(reader, XmlByte.type, xmlOptions);
        }

        public static XmlByte parse(Node node) throws XmlException {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(node, XmlByte.type, (XmlOptions) null);
        }

        public static XmlByte parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(node, XmlByte.type, xmlOptions);
        }

        public static XmlByte parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlByte.type, (XmlOptions) null);
        }

        public static XmlByte parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlByte.type, xmlOptions);
        }

        public static XmlByte parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlByte.type, (XmlOptions) null);
        }

        public static XmlByte parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlByte.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlByte.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlByte.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
