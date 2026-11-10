package org.apache.xmlbeans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface XmlIDREFS extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_IDREFS");

    List getListValue();

    List listValue();

    void set(List list);

    void setListValue(List list);

    List xgetListValue();

    List xlistValue();

    public static final class Factory {
        public static XmlIDREFS newInstance() {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().newInstance(XmlIDREFS.type, null);
        }

        public static XmlIDREFS newInstance(XmlOptions xmlOptions) {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().newInstance(XmlIDREFS.type, xmlOptions);
        }

        public static XmlIDREFS newValue(Object obj) {
            return (XmlIDREFS) XmlIDREFS.type.newValue(obj);
        }

        public static XmlIDREFS parse(String str) throws XmlException {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(str, XmlIDREFS.type, (XmlOptions) null);
        }

        public static XmlIDREFS parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(str, XmlIDREFS.type, xmlOptions);
        }

        public static XmlIDREFS parse(File file) throws XmlException, IOException {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(file, XmlIDREFS.type, (XmlOptions) null);
        }

        public static XmlIDREFS parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(file, XmlIDREFS.type, xmlOptions);
        }

        public static XmlIDREFS parse(URL url) throws XmlException, IOException {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(url, XmlIDREFS.type, (XmlOptions) null);
        }

        public static XmlIDREFS parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(url, XmlIDREFS.type, xmlOptions);
        }

        public static XmlIDREFS parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(inputStream, XmlIDREFS.type, (XmlOptions) null);
        }

        public static XmlIDREFS parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(inputStream, XmlIDREFS.type, xmlOptions);
        }

        public static XmlIDREFS parse(Reader reader) throws XmlException, IOException {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(reader, XmlIDREFS.type, (XmlOptions) null);
        }

        public static XmlIDREFS parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(reader, XmlIDREFS.type, xmlOptions);
        }

        public static XmlIDREFS parse(Node node) throws XmlException {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(node, XmlIDREFS.type, (XmlOptions) null);
        }

        public static XmlIDREFS parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(node, XmlIDREFS.type, xmlOptions);
        }

        public static XmlIDREFS parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlIDREFS.type, (XmlOptions) null);
        }

        public static XmlIDREFS parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlIDREFS.type, xmlOptions);
        }

        public static XmlIDREFS parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlIDREFS.type, (XmlOptions) null);
        }

        public static XmlIDREFS parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlIDREFS.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlIDREFS.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlIDREFS.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
