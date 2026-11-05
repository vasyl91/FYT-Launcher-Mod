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
public interface XmlENTITIES extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_ENTITIES");

    List getListValue();

    List listValue();

    void set(List list);

    void setListValue(List list);

    List xgetListValue();

    List xlistValue();

    public static final class Factory {
        public static XmlENTITIES newInstance() {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().newInstance(XmlENTITIES.type, null);
        }

        public static XmlENTITIES newInstance(XmlOptions xmlOptions) {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().newInstance(XmlENTITIES.type, xmlOptions);
        }

        public static XmlENTITIES newValue(Object obj) {
            return (XmlENTITIES) XmlENTITIES.type.newValue(obj);
        }

        public static XmlENTITIES parse(String str) throws XmlException {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(str, XmlENTITIES.type, (XmlOptions) null);
        }

        public static XmlENTITIES parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(str, XmlENTITIES.type, xmlOptions);
        }

        public static XmlENTITIES parse(File file) throws XmlException, IOException {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(file, XmlENTITIES.type, (XmlOptions) null);
        }

        public static XmlENTITIES parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(file, XmlENTITIES.type, xmlOptions);
        }

        public static XmlENTITIES parse(URL url) throws XmlException, IOException {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(url, XmlENTITIES.type, (XmlOptions) null);
        }

        public static XmlENTITIES parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(url, XmlENTITIES.type, xmlOptions);
        }

        public static XmlENTITIES parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(inputStream, XmlENTITIES.type, (XmlOptions) null);
        }

        public static XmlENTITIES parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(inputStream, XmlENTITIES.type, xmlOptions);
        }

        public static XmlENTITIES parse(Reader reader) throws XmlException, IOException {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(reader, XmlENTITIES.type, (XmlOptions) null);
        }

        public static XmlENTITIES parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(reader, XmlENTITIES.type, xmlOptions);
        }

        public static XmlENTITIES parse(Node node) throws XmlException {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(node, XmlENTITIES.type, (XmlOptions) null);
        }

        public static XmlENTITIES parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(node, XmlENTITIES.type, xmlOptions);
        }

        public static XmlENTITIES parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlENTITIES.type, (XmlOptions) null);
        }

        public static XmlENTITIES parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlENTITIES.type, xmlOptions);
        }

        public static XmlENTITIES parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlENTITIES.type, (XmlOptions) null);
        }

        public static XmlENTITIES parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlENTITIES.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlENTITIES.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlENTITIES.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
