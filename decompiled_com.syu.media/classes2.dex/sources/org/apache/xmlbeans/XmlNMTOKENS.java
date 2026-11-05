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
public interface XmlNMTOKENS extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_NMTOKENS");

    List getListValue();

    List listValue();

    void set(List list);

    void setListValue(List list);

    List xgetListValue();

    List xlistValue();

    public static final class Factory {
        public static XmlNMTOKENS newInstance() {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().newInstance(XmlNMTOKENS.type, null);
        }

        public static XmlNMTOKENS newInstance(XmlOptions xmlOptions) {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().newInstance(XmlNMTOKENS.type, xmlOptions);
        }

        public static XmlNMTOKENS newValue(Object obj) {
            return (XmlNMTOKENS) XmlNMTOKENS.type.newValue(obj);
        }

        public static XmlNMTOKENS parse(String str) throws XmlException {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(str, XmlNMTOKENS.type, (XmlOptions) null);
        }

        public static XmlNMTOKENS parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(str, XmlNMTOKENS.type, xmlOptions);
        }

        public static XmlNMTOKENS parse(File file) throws XmlException, IOException {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(file, XmlNMTOKENS.type, (XmlOptions) null);
        }

        public static XmlNMTOKENS parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(file, XmlNMTOKENS.type, xmlOptions);
        }

        public static XmlNMTOKENS parse(URL url) throws XmlException, IOException {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(url, XmlNMTOKENS.type, (XmlOptions) null);
        }

        public static XmlNMTOKENS parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(url, XmlNMTOKENS.type, xmlOptions);
        }

        public static XmlNMTOKENS parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNMTOKENS.type, (XmlOptions) null);
        }

        public static XmlNMTOKENS parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNMTOKENS.type, xmlOptions);
        }

        public static XmlNMTOKENS parse(Reader reader) throws XmlException, IOException {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(reader, XmlNMTOKENS.type, (XmlOptions) null);
        }

        public static XmlNMTOKENS parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(reader, XmlNMTOKENS.type, xmlOptions);
        }

        public static XmlNMTOKENS parse(Node node) throws XmlException {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(node, XmlNMTOKENS.type, (XmlOptions) null);
        }

        public static XmlNMTOKENS parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(node, XmlNMTOKENS.type, xmlOptions);
        }

        public static XmlNMTOKENS parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNMTOKENS.type, (XmlOptions) null);
        }

        public static XmlNMTOKENS parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNMTOKENS.type, xmlOptions);
        }

        public static XmlNMTOKENS parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNMTOKENS.type, (XmlOptions) null);
        }

        public static XmlNMTOKENS parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNMTOKENS.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNMTOKENS.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNMTOKENS.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
