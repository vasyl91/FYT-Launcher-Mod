package org.apache.xmlbeans.impl.xb.xmlconfig;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface Usertypeconfig extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Usertypeconfig.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("usertypeconfig7bbatype");

    String getJavaname();

    QName getName();

    String getStaticHandler();

    boolean isSetJavaname();

    boolean isSetName();

    void setJavaname(String str);

    void setName(QName qName);

    void setStaticHandler(String str);

    void unsetJavaname();

    void unsetName();

    XmlString xgetJavaname();

    XmlQName xgetName();

    XmlString xgetStaticHandler();

    void xsetJavaname(XmlString xmlString);

    void xsetName(XmlQName xmlQName);

    void xsetStaticHandler(XmlString xmlString);

    public static final class Factory {
        public static Usertypeconfig newInstance() {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().newInstance(Usertypeconfig.type, (XmlOptions) null);
        }

        public static Usertypeconfig newInstance(XmlOptions xmlOptions) {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().newInstance(Usertypeconfig.type, xmlOptions);
        }

        public static Usertypeconfig parse(String str) throws XmlException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(str, Usertypeconfig.type, (XmlOptions) null);
        }

        public static Usertypeconfig parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(str, Usertypeconfig.type, xmlOptions);
        }

        public static Usertypeconfig parse(File file) throws XmlException, IOException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(file, Usertypeconfig.type, (XmlOptions) null);
        }

        public static Usertypeconfig parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(file, Usertypeconfig.type, xmlOptions);
        }

        public static Usertypeconfig parse(URL url) throws XmlException, IOException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(url, Usertypeconfig.type, (XmlOptions) null);
        }

        public static Usertypeconfig parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(url, Usertypeconfig.type, xmlOptions);
        }

        public static Usertypeconfig parse(InputStream inputStream) throws XmlException, IOException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(inputStream, Usertypeconfig.type, (XmlOptions) null);
        }

        public static Usertypeconfig parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(inputStream, Usertypeconfig.type, xmlOptions);
        }

        public static Usertypeconfig parse(Reader reader) throws XmlException, IOException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(reader, Usertypeconfig.type, (XmlOptions) null);
        }

        public static Usertypeconfig parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(reader, Usertypeconfig.type, xmlOptions);
        }

        public static Usertypeconfig parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Usertypeconfig.type, (XmlOptions) null);
        }

        public static Usertypeconfig parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Usertypeconfig.type, xmlOptions);
        }

        public static Usertypeconfig parse(Node node) throws XmlException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(node, Usertypeconfig.type, (XmlOptions) null);
        }

        public static Usertypeconfig parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(node, Usertypeconfig.type, xmlOptions);
        }

        public static Usertypeconfig parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Usertypeconfig.type, (XmlOptions) null);
        }

        public static Usertypeconfig parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (Usertypeconfig) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Usertypeconfig.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Usertypeconfig.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Usertypeconfig.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
