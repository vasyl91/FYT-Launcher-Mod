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
public interface XmlAnySimpleType extends XmlObject {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_anySimpleType");

    String getStringValue();

    void set(String str);

    void setStringValue(String str);

    String stringValue();

    public static final class Factory {
        public static XmlAnySimpleType newInstance() {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().newInstance(XmlAnySimpleType.type, null);
        }

        public static XmlAnySimpleType newInstance(XmlOptions xmlOptions) {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().newInstance(XmlAnySimpleType.type, xmlOptions);
        }

        public static XmlAnySimpleType newValue(Object obj) {
            return XmlAnySimpleType.type.newValue(obj);
        }

        public static XmlAnySimpleType parse(String str) throws XmlException {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(str, XmlAnySimpleType.type, (XmlOptions) null);
        }

        public static XmlAnySimpleType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(str, XmlAnySimpleType.type, xmlOptions);
        }

        public static XmlAnySimpleType parse(File file) throws XmlException, IOException {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(file, XmlAnySimpleType.type, (XmlOptions) null);
        }

        public static XmlAnySimpleType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(file, XmlAnySimpleType.type, xmlOptions);
        }

        public static XmlAnySimpleType parse(URL url) throws XmlException, IOException {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(url, XmlAnySimpleType.type, (XmlOptions) null);
        }

        public static XmlAnySimpleType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(url, XmlAnySimpleType.type, xmlOptions);
        }

        public static XmlAnySimpleType parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(inputStream, XmlAnySimpleType.type, (XmlOptions) null);
        }

        public static XmlAnySimpleType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(inputStream, XmlAnySimpleType.type, xmlOptions);
        }

        public static XmlAnySimpleType parse(Reader reader) throws XmlException, IOException {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(reader, XmlAnySimpleType.type, (XmlOptions) null);
        }

        public static XmlAnySimpleType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(reader, XmlAnySimpleType.type, xmlOptions);
        }

        public static XmlAnySimpleType parse(Node node) throws XmlException {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(node, XmlAnySimpleType.type, (XmlOptions) null);
        }

        public static XmlAnySimpleType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(node, XmlAnySimpleType.type, xmlOptions);
        }

        public static XmlAnySimpleType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlAnySimpleType.type, (XmlOptions) null);
        }

        public static XmlAnySimpleType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlAnySimpleType.type, xmlOptions);
        }

        public static XmlAnySimpleType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlAnySimpleType.type, (XmlOptions) null);
        }

        public static XmlAnySimpleType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlAnySimpleType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlAnySimpleType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlAnySimpleType.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
