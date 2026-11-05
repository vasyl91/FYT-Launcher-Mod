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
public interface Qnametargetlist extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Qnametargetlist.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("qnametargetlist16actype");

    List getListValue();

    List listValue();

    void set(List list);

    void setListValue(List list);

    List xgetListValue();

    List xlistValue();

    public static final class Factory {
        public static Qnametargetlist newValue(Object obj) {
            return (Qnametargetlist) Qnametargetlist.type.newValue(obj);
        }

        public static Qnametargetlist newInstance() {
            return XmlBeans.getContextTypeLoader().newInstance(Qnametargetlist.type, (XmlOptions) null);
        }

        public static Qnametargetlist newInstance(XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newInstance(Qnametargetlist.type, xmlOptions);
        }

        public static Qnametargetlist parse(String str) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, Qnametargetlist.type, (XmlOptions) null);
        }

        public static Qnametargetlist parse(String str, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, Qnametargetlist.type, xmlOptions);
        }

        public static Qnametargetlist parse(File file) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, Qnametargetlist.type, (XmlOptions) null);
        }

        public static Qnametargetlist parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, Qnametargetlist.type, xmlOptions);
        }

        public static Qnametargetlist parse(URL url) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, Qnametargetlist.type, (XmlOptions) null);
        }

        public static Qnametargetlist parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, Qnametargetlist.type, xmlOptions);
        }

        public static Qnametargetlist parse(InputStream inputStream) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, Qnametargetlist.type, (XmlOptions) null);
        }

        public static Qnametargetlist parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, Qnametargetlist.type, xmlOptions);
        }

        public static Qnametargetlist parse(Reader reader) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, Qnametargetlist.type, (XmlOptions) null);
        }

        public static Qnametargetlist parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, Qnametargetlist.type, xmlOptions);
        }

        public static Qnametargetlist parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Qnametargetlist.type, (XmlOptions) null);
        }

        public static Qnametargetlist parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Qnametargetlist.type, xmlOptions);
        }

        public static Qnametargetlist parse(Node node) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, Qnametargetlist.type, (XmlOptions) null);
        }

        public static Qnametargetlist parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, Qnametargetlist.type, xmlOptions);
        }

        public static Qnametargetlist parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, Qnametargetlist.type, (XmlOptions) null);
        }

        public static Qnametargetlist parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, Qnametargetlist.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Qnametargetlist.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Qnametargetlist.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
