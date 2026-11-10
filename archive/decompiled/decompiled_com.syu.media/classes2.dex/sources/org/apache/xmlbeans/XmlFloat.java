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
public interface XmlFloat extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_float");

    float floatValue();

    float getFloatValue();

    void set(float f);

    void setFloatValue(float f);

    public static final class Factory {
        public static XmlFloat newInstance() {
            return (XmlFloat) XmlBeans.getContextTypeLoader().newInstance(XmlFloat.type, null);
        }

        public static XmlFloat newInstance(XmlOptions xmlOptions) {
            return (XmlFloat) XmlBeans.getContextTypeLoader().newInstance(XmlFloat.type, xmlOptions);
        }

        public static XmlFloat newValue(Object obj) {
            return (XmlFloat) XmlFloat.type.newValue(obj);
        }

        public static XmlFloat parse(String str) throws XmlException {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(str, XmlFloat.type, (XmlOptions) null);
        }

        public static XmlFloat parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(str, XmlFloat.type, xmlOptions);
        }

        public static XmlFloat parse(File file) throws XmlException, IOException {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(file, XmlFloat.type, (XmlOptions) null);
        }

        public static XmlFloat parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(file, XmlFloat.type, xmlOptions);
        }

        public static XmlFloat parse(URL url) throws XmlException, IOException {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(url, XmlFloat.type, (XmlOptions) null);
        }

        public static XmlFloat parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(url, XmlFloat.type, xmlOptions);
        }

        public static XmlFloat parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(inputStream, XmlFloat.type, (XmlOptions) null);
        }

        public static XmlFloat parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(inputStream, XmlFloat.type, xmlOptions);
        }

        public static XmlFloat parse(Reader reader) throws XmlException, IOException {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(reader, XmlFloat.type, (XmlOptions) null);
        }

        public static XmlFloat parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(reader, XmlFloat.type, xmlOptions);
        }

        public static XmlFloat parse(Node node) throws XmlException {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(node, XmlFloat.type, (XmlOptions) null);
        }

        public static XmlFloat parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(node, XmlFloat.type, xmlOptions);
        }

        public static XmlFloat parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlFloat.type, (XmlOptions) null);
        }

        public static XmlFloat parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlFloat.type, xmlOptions);
        }

        public static XmlFloat parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlFloat.type, (XmlOptions) null);
        }

        public static XmlFloat parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlFloat.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlFloat.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlFloat.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
