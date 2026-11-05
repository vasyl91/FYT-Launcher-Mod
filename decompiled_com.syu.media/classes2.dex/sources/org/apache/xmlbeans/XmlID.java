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
public interface XmlID extends XmlNCName {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_ID");

    public static final class Factory {
        public static XmlID newInstance() {
            return (XmlID) XmlBeans.getContextTypeLoader().newInstance(XmlID.type, null);
        }

        public static XmlID newInstance(XmlOptions xmlOptions) {
            return (XmlID) XmlBeans.getContextTypeLoader().newInstance(XmlID.type, xmlOptions);
        }

        public static XmlID newValue(Object obj) {
            return (XmlID) XmlID.type.newValue(obj);
        }

        public static XmlID parse(String str) throws XmlException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(str, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(str, XmlID.type, xmlOptions);
        }

        public static XmlID parse(File file) throws XmlException, IOException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(file, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(file, XmlID.type, xmlOptions);
        }

        public static XmlID parse(URL url) throws XmlException, IOException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(url, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(url, XmlID.type, xmlOptions);
        }

        public static XmlID parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(inputStream, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(inputStream, XmlID.type, xmlOptions);
        }

        public static XmlID parse(Reader reader) throws XmlException, IOException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(reader, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(reader, XmlID.type, xmlOptions);
        }

        public static XmlID parse(Node node) throws XmlException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(node, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(node, XmlID.type, xmlOptions);
        }

        public static XmlID parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlID.type, xmlOptions);
        }

        public static XmlID parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlID.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlID.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlID.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
