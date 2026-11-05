package org.apache.xmlbeans.impl.xb.xmlconfig;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface NamespacePrefixList extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(NamespacePrefixList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("namespaceprefixlistec0ctype");

    List getListValue();

    List listValue();

    void set(List list);

    void setListValue(List list);

    List xgetListValue();

    List xlistValue();

    public static final class Factory {
        public static NamespacePrefixList newValue(Object obj) {
            return (NamespacePrefixList) NamespacePrefixList.type.newValue(obj);
        }

        public static NamespacePrefixList newInstance() {
            return XmlBeans.getContextTypeLoader().newInstance(NamespacePrefixList.type, (XmlOptions) null);
        }

        public static NamespacePrefixList newInstance(XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newInstance(NamespacePrefixList.type, xmlOptions);
        }

        public static NamespacePrefixList parse(String str) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, NamespacePrefixList.type, (XmlOptions) null);
        }

        public static NamespacePrefixList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, NamespacePrefixList.type, xmlOptions);
        }

        public static NamespacePrefixList parse(File file) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, NamespacePrefixList.type, (XmlOptions) null);
        }

        public static NamespacePrefixList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, NamespacePrefixList.type, xmlOptions);
        }

        public static NamespacePrefixList parse(URL url) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, NamespacePrefixList.type, (XmlOptions) null);
        }

        public static NamespacePrefixList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, NamespacePrefixList.type, xmlOptions);
        }

        public static NamespacePrefixList parse(InputStream inputStream) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, NamespacePrefixList.type, (XmlOptions) null);
        }

        public static NamespacePrefixList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, NamespacePrefixList.type, xmlOptions);
        }

        public static NamespacePrefixList parse(Reader reader) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, NamespacePrefixList.type, (XmlOptions) null);
        }

        public static NamespacePrefixList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, NamespacePrefixList.type, xmlOptions);
        }

        public static NamespacePrefixList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NamespacePrefixList.type, (XmlOptions) null);
        }

        public static NamespacePrefixList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NamespacePrefixList.type, xmlOptions);
        }

        public static NamespacePrefixList parse(Node node) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, NamespacePrefixList.type, (XmlOptions) null);
        }

        public static NamespacePrefixList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, NamespacePrefixList.type, xmlOptions);
        }

        public static NamespacePrefixList parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, NamespacePrefixList.type, (XmlOptions) null);
        }

        public static NamespacePrefixList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, NamespacePrefixList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NamespacePrefixList.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NamespacePrefixList.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
