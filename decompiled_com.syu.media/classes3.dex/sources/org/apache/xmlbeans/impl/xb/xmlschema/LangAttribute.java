package org.apache.xmlbeans.impl.xb.xmlschema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlLanguage;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface LangAttribute extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(LangAttribute.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLLANG").resolveHandle("lange126attrtypetype");

    String getLang();

    boolean isSetLang();

    void setLang(String str);

    void unsetLang();

    XmlLanguage xgetLang();

    void xsetLang(XmlLanguage xmlLanguage);

    public static final class Factory {
        public static LangAttribute newInstance() {
            return (LangAttribute) XmlBeans.getContextTypeLoader().newInstance(LangAttribute.type, (XmlOptions) null);
        }

        public static LangAttribute newInstance(XmlOptions xmlOptions) {
            return (LangAttribute) XmlBeans.getContextTypeLoader().newInstance(LangAttribute.type, xmlOptions);
        }

        public static LangAttribute parse(String str) throws XmlException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(str, LangAttribute.type, (XmlOptions) null);
        }

        public static LangAttribute parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(str, LangAttribute.type, xmlOptions);
        }

        public static LangAttribute parse(File file) throws XmlException, IOException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(file, LangAttribute.type, (XmlOptions) null);
        }

        public static LangAttribute parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(file, LangAttribute.type, xmlOptions);
        }

        public static LangAttribute parse(URL url) throws XmlException, IOException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(url, LangAttribute.type, (XmlOptions) null);
        }

        public static LangAttribute parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(url, LangAttribute.type, xmlOptions);
        }

        public static LangAttribute parse(InputStream inputStream) throws XmlException, IOException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(inputStream, LangAttribute.type, (XmlOptions) null);
        }

        public static LangAttribute parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(inputStream, LangAttribute.type, xmlOptions);
        }

        public static LangAttribute parse(Reader reader) throws XmlException, IOException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(reader, LangAttribute.type, (XmlOptions) null);
        }

        public static LangAttribute parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(reader, LangAttribute.type, xmlOptions);
        }

        public static LangAttribute parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, LangAttribute.type, (XmlOptions) null);
        }

        public static LangAttribute parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, LangAttribute.type, xmlOptions);
        }

        public static LangAttribute parse(Node node) throws XmlException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(node, LangAttribute.type, (XmlOptions) null);
        }

        public static LangAttribute parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(node, LangAttribute.type, xmlOptions);
        }

        public static LangAttribute parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(xMLInputStream, LangAttribute.type, (XmlOptions) null);
        }

        public static LangAttribute parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (LangAttribute) XmlBeans.getContextTypeLoader().parse(xMLInputStream, LangAttribute.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, LangAttribute.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, LangAttribute.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
