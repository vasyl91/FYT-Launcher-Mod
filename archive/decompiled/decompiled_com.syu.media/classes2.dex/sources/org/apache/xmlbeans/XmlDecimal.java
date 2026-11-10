package org.apache.xmlbeans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface XmlDecimal extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_decimal");

    BigDecimal bigDecimalValue();

    BigDecimal getBigDecimalValue();

    void set(BigDecimal bigDecimal);

    void setBigDecimalValue(BigDecimal bigDecimal);

    public static final class Factory {
        public static XmlDecimal newInstance() {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().newInstance(XmlDecimal.type, null);
        }

        public static XmlDecimal newInstance(XmlOptions xmlOptions) {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().newInstance(XmlDecimal.type, xmlOptions);
        }

        public static XmlDecimal newValue(Object obj) {
            return (XmlDecimal) XmlDecimal.type.newValue(obj);
        }

        public static XmlDecimal parse(String str) throws XmlException {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(str, XmlDecimal.type, (XmlOptions) null);
        }

        public static XmlDecimal parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(str, XmlDecimal.type, xmlOptions);
        }

        public static XmlDecimal parse(File file) throws XmlException, IOException {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(file, XmlDecimal.type, (XmlOptions) null);
        }

        public static XmlDecimal parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(file, XmlDecimal.type, xmlOptions);
        }

        public static XmlDecimal parse(URL url) throws XmlException, IOException {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(url, XmlDecimal.type, (XmlOptions) null);
        }

        public static XmlDecimal parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(url, XmlDecimal.type, xmlOptions);
        }

        public static XmlDecimal parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDecimal.type, (XmlOptions) null);
        }

        public static XmlDecimal parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDecimal.type, xmlOptions);
        }

        public static XmlDecimal parse(Reader reader) throws XmlException, IOException {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(reader, XmlDecimal.type, (XmlOptions) null);
        }

        public static XmlDecimal parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(reader, XmlDecimal.type, xmlOptions);
        }

        public static XmlDecimal parse(Node node) throws XmlException {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(node, XmlDecimal.type, (XmlOptions) null);
        }

        public static XmlDecimal parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(node, XmlDecimal.type, xmlOptions);
        }

        public static XmlDecimal parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDecimal.type, (XmlOptions) null);
        }

        public static XmlDecimal parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDecimal.type, xmlOptions);
        }

        public static XmlDecimal parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDecimal.type, (XmlOptions) null);
        }

        public static XmlDecimal parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDecimal.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDecimal.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDecimal.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
