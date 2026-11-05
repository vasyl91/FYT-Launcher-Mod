package org.apache.xmlbeans.impl.xb.xmlschema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface BaseAttribute extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(BaseAttribute.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLLANG").resolveHandle("basece23attrtypetype");

    String getBase();

    boolean isSetBase();

    void setBase(String str);

    void unsetBase();

    XmlAnyURI xgetBase();

    void xsetBase(XmlAnyURI xmlAnyURI);

    public static final class Factory {
        public static BaseAttribute newInstance() {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().newInstance(BaseAttribute.type, (XmlOptions) null);
        }

        public static BaseAttribute newInstance(XmlOptions xmlOptions) {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().newInstance(BaseAttribute.type, xmlOptions);
        }

        public static BaseAttribute parse(String str) throws XmlException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(str, BaseAttribute.type, (XmlOptions) null);
        }

        public static BaseAttribute parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(str, BaseAttribute.type, xmlOptions);
        }

        public static BaseAttribute parse(File file) throws XmlException, IOException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(file, BaseAttribute.type, (XmlOptions) null);
        }

        public static BaseAttribute parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(file, BaseAttribute.type, xmlOptions);
        }

        public static BaseAttribute parse(URL url) throws XmlException, IOException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(url, BaseAttribute.type, (XmlOptions) null);
        }

        public static BaseAttribute parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(url, BaseAttribute.type, xmlOptions);
        }

        public static BaseAttribute parse(InputStream inputStream) throws XmlException, IOException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(inputStream, BaseAttribute.type, (XmlOptions) null);
        }

        public static BaseAttribute parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(inputStream, BaseAttribute.type, xmlOptions);
        }

        public static BaseAttribute parse(Reader reader) throws XmlException, IOException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(reader, BaseAttribute.type, (XmlOptions) null);
        }

        public static BaseAttribute parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(reader, BaseAttribute.type, xmlOptions);
        }

        public static BaseAttribute parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, BaseAttribute.type, (XmlOptions) null);
        }

        public static BaseAttribute parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, BaseAttribute.type, xmlOptions);
        }

        public static BaseAttribute parse(Node node) throws XmlException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(node, BaseAttribute.type, (XmlOptions) null);
        }

        public static BaseAttribute parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(node, BaseAttribute.type, xmlOptions);
        }

        public static BaseAttribute parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(xMLInputStream, BaseAttribute.type, (XmlOptions) null);
        }

        public static BaseAttribute parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (BaseAttribute) XmlBeans.getContextTypeLoader().parse(xMLInputStream, BaseAttribute.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, BaseAttribute.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, BaseAttribute.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
