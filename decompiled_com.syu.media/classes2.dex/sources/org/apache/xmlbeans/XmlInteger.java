package org.apache.xmlbeans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface XmlInteger extends XmlDecimal {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_integer");

    BigInteger bigIntegerValue();

    BigInteger getBigIntegerValue();

    void set(BigInteger bigInteger);

    void setBigIntegerValue(BigInteger bigInteger);

    public static final class Factory {
        public static XmlInteger newInstance() {
            return (XmlInteger) XmlBeans.getContextTypeLoader().newInstance(XmlInteger.type, null);
        }

        public static XmlInteger newInstance(XmlOptions xmlOptions) {
            return (XmlInteger) XmlBeans.getContextTypeLoader().newInstance(XmlInteger.type, xmlOptions);
        }

        public static XmlInteger newValue(Object obj) {
            return (XmlInteger) XmlInteger.type.newValue(obj);
        }

        public static XmlInteger parse(String str) throws XmlException {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(str, XmlInteger.type, (XmlOptions) null);
        }

        public static XmlInteger parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(str, XmlInteger.type, xmlOptions);
        }

        public static XmlInteger parse(File file) throws XmlException, IOException {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(file, XmlInteger.type, (XmlOptions) null);
        }

        public static XmlInteger parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(file, XmlInteger.type, xmlOptions);
        }

        public static XmlInteger parse(URL url) throws XmlException, IOException {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(url, XmlInteger.type, (XmlOptions) null);
        }

        public static XmlInteger parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(url, XmlInteger.type, xmlOptions);
        }

        public static XmlInteger parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlInteger.type, (XmlOptions) null);
        }

        public static XmlInteger parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlInteger.type, xmlOptions);
        }

        public static XmlInteger parse(Reader reader) throws XmlException, IOException {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlInteger.type, (XmlOptions) null);
        }

        public static XmlInteger parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlInteger.type, xmlOptions);
        }

        public static XmlInteger parse(Node node) throws XmlException {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(node, XmlInteger.type, (XmlOptions) null);
        }

        public static XmlInteger parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(node, XmlInteger.type, xmlOptions);
        }

        public static XmlInteger parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlInteger.type, (XmlOptions) null);
        }

        public static XmlInteger parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlInteger.type, xmlOptions);
        }

        public static XmlInteger parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlInteger.type, (XmlOptions) null);
        }

        public static XmlInteger parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlInteger.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlInteger.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlInteger.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
