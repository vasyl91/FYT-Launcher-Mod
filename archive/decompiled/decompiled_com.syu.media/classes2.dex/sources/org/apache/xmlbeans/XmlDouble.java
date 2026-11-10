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
public interface XmlDouble extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_double");

    double doubleValue();

    double getDoubleValue();

    void set(double d);

    void setDoubleValue(double d);

    public static final class Factory {
        public static XmlDouble newInstance() {
            return (XmlDouble) XmlBeans.getContextTypeLoader().newInstance(XmlDouble.type, null);
        }

        public static XmlDouble newInstance(XmlOptions xmlOptions) {
            return (XmlDouble) XmlBeans.getContextTypeLoader().newInstance(XmlDouble.type, xmlOptions);
        }

        public static XmlDouble newValue(Object obj) {
            return (XmlDouble) XmlDouble.type.newValue(obj);
        }

        public static XmlDouble parse(String str) throws XmlException {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(str, XmlDouble.type, (XmlOptions) null);
        }

        public static XmlDouble parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(str, XmlDouble.type, xmlOptions);
        }

        public static XmlDouble parse(File file) throws XmlException, IOException {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(file, XmlDouble.type, (XmlOptions) null);
        }

        public static XmlDouble parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(file, XmlDouble.type, xmlOptions);
        }

        public static XmlDouble parse(URL url) throws XmlException, IOException {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(url, XmlDouble.type, (XmlOptions) null);
        }

        public static XmlDouble parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(url, XmlDouble.type, xmlOptions);
        }

        public static XmlDouble parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDouble.type, (XmlOptions) null);
        }

        public static XmlDouble parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDouble.type, xmlOptions);
        }

        public static XmlDouble parse(Reader reader) throws XmlException, IOException {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(reader, XmlDouble.type, (XmlOptions) null);
        }

        public static XmlDouble parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(reader, XmlDouble.type, xmlOptions);
        }

        public static XmlDouble parse(Node node) throws XmlException {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(node, XmlDouble.type, (XmlOptions) null);
        }

        public static XmlDouble parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(node, XmlDouble.type, xmlOptions);
        }

        public static XmlDouble parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDouble.type, (XmlOptions) null);
        }

        public static XmlDouble parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDouble.type, xmlOptions);
        }

        public static XmlDouble parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDouble.type, (XmlOptions) null);
        }

        public static XmlDouble parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDouble.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDouble.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDouble.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
