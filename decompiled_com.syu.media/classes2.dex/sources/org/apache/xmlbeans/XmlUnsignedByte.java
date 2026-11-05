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
public interface XmlUnsignedByte extends XmlUnsignedShort {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_unsignedByte");

    short getShortValue();

    void set(short s);

    void setShortValue(short s);

    short shortValue();

    public static final class Factory {
        public static XmlUnsignedByte newInstance() {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedByte.type, null);
        }

        public static XmlUnsignedByte newInstance(XmlOptions xmlOptions) {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedByte.type, xmlOptions);
        }

        public static XmlUnsignedByte newValue(Object obj) {
            return (XmlUnsignedByte) XmlUnsignedByte.type.newValue(obj);
        }

        public static XmlUnsignedByte parse(String str) throws XmlException {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(str, XmlUnsignedByte.type, (XmlOptions) null);
        }

        public static XmlUnsignedByte parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(str, XmlUnsignedByte.type, xmlOptions);
        }

        public static XmlUnsignedByte parse(File file) throws XmlException, IOException {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(file, XmlUnsignedByte.type, (XmlOptions) null);
        }

        public static XmlUnsignedByte parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(file, XmlUnsignedByte.type, xmlOptions);
        }

        public static XmlUnsignedByte parse(URL url) throws XmlException, IOException {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(url, XmlUnsignedByte.type, (XmlOptions) null);
        }

        public static XmlUnsignedByte parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(url, XmlUnsignedByte.type, xmlOptions);
        }

        public static XmlUnsignedByte parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(inputStream, XmlUnsignedByte.type, (XmlOptions) null);
        }

        public static XmlUnsignedByte parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(inputStream, XmlUnsignedByte.type, xmlOptions);
        }

        public static XmlUnsignedByte parse(Reader reader) throws XmlException, IOException {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(reader, XmlUnsignedByte.type, (XmlOptions) null);
        }

        public static XmlUnsignedByte parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(reader, XmlUnsignedByte.type, xmlOptions);
        }

        public static XmlUnsignedByte parse(Node node) throws XmlException {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(node, XmlUnsignedByte.type, (XmlOptions) null);
        }

        public static XmlUnsignedByte parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(node, XmlUnsignedByte.type, xmlOptions);
        }

        public static XmlUnsignedByte parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlUnsignedByte.type, (XmlOptions) null);
        }

        public static XmlUnsignedByte parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlUnsignedByte.type, xmlOptions);
        }

        public static XmlUnsignedByte parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlUnsignedByte.type, (XmlOptions) null);
        }

        public static XmlUnsignedByte parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlUnsignedByte.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlUnsignedByte.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlUnsignedByte.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
