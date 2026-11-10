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
public interface XmlUnsignedShort extends XmlUnsignedInt {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_unsignedShort");

    int getIntValue();

    int intValue();

    void set(int i);

    void setIntValue(int i);

    public static final class Factory {
        public static XmlUnsignedShort newInstance() {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedShort.type, null);
        }

        public static XmlUnsignedShort newInstance(XmlOptions xmlOptions) {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedShort.type, xmlOptions);
        }

        public static XmlUnsignedShort newValue(Object obj) {
            return (XmlUnsignedShort) XmlUnsignedShort.type.newValue(obj);
        }

        public static XmlUnsignedShort parse(String str) throws XmlException {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(str, XmlUnsignedShort.type, (XmlOptions) null);
        }

        public static XmlUnsignedShort parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(str, XmlUnsignedShort.type, xmlOptions);
        }

        public static XmlUnsignedShort parse(File file) throws XmlException, IOException {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(file, XmlUnsignedShort.type, (XmlOptions) null);
        }

        public static XmlUnsignedShort parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(file, XmlUnsignedShort.type, xmlOptions);
        }

        public static XmlUnsignedShort parse(URL url) throws XmlException, IOException {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(url, XmlUnsignedShort.type, (XmlOptions) null);
        }

        public static XmlUnsignedShort parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(url, XmlUnsignedShort.type, xmlOptions);
        }

        public static XmlUnsignedShort parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(inputStream, XmlUnsignedShort.type, (XmlOptions) null);
        }

        public static XmlUnsignedShort parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(inputStream, XmlUnsignedShort.type, xmlOptions);
        }

        public static XmlUnsignedShort parse(Reader reader) throws XmlException, IOException {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(reader, XmlUnsignedShort.type, (XmlOptions) null);
        }

        public static XmlUnsignedShort parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(reader, XmlUnsignedShort.type, xmlOptions);
        }

        public static XmlUnsignedShort parse(Node node) throws XmlException {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(node, XmlUnsignedShort.type, (XmlOptions) null);
        }

        public static XmlUnsignedShort parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(node, XmlUnsignedShort.type, xmlOptions);
        }

        public static XmlUnsignedShort parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlUnsignedShort.type, (XmlOptions) null);
        }

        public static XmlUnsignedShort parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlUnsignedShort.type, xmlOptions);
        }

        public static XmlUnsignedShort parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlUnsignedShort.type, (XmlOptions) null);
        }

        public static XmlUnsignedShort parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlUnsignedShort.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlUnsignedShort.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlUnsignedShort.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
