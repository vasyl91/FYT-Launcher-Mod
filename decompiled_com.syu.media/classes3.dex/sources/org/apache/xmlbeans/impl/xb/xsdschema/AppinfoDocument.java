package org.apache.xmlbeans.impl.xb.xsdschema;

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
public interface AppinfoDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(AppinfoDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("appinfo2ea6doctype");

    Appinfo addNewAppinfo();

    Appinfo getAppinfo();

    void setAppinfo(Appinfo appinfo);

    public interface Appinfo extends XmlObject {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Appinfo.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("appinfo650belemtype");

        String getSource();

        boolean isSetSource();

        void setSource(String str);

        void unsetSource();

        XmlAnyURI xgetSource();

        void xsetSource(XmlAnyURI xmlAnyURI);

        public static final class Factory {
            public static Appinfo newInstance() {
                return (Appinfo) XmlBeans.getContextTypeLoader().newInstance(Appinfo.type, (XmlOptions) null);
            }

            public static Appinfo newInstance(XmlOptions xmlOptions) {
                return (Appinfo) XmlBeans.getContextTypeLoader().newInstance(Appinfo.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static AppinfoDocument newInstance() {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().newInstance(AppinfoDocument.type, (XmlOptions) null);
        }

        public static AppinfoDocument newInstance(XmlOptions xmlOptions) {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().newInstance(AppinfoDocument.type, xmlOptions);
        }

        public static AppinfoDocument parse(String str) throws XmlException {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(str, AppinfoDocument.type, (XmlOptions) null);
        }

        public static AppinfoDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(str, AppinfoDocument.type, xmlOptions);
        }

        public static AppinfoDocument parse(File file) throws XmlException, IOException {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(file, AppinfoDocument.type, (XmlOptions) null);
        }

        public static AppinfoDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(file, AppinfoDocument.type, xmlOptions);
        }

        public static AppinfoDocument parse(URL url) throws XmlException, IOException {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(url, AppinfoDocument.type, (XmlOptions) null);
        }

        public static AppinfoDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(url, AppinfoDocument.type, xmlOptions);
        }

        public static AppinfoDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AppinfoDocument.type, (XmlOptions) null);
        }

        public static AppinfoDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AppinfoDocument.type, xmlOptions);
        }

        public static AppinfoDocument parse(Reader reader) throws XmlException, IOException {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(reader, AppinfoDocument.type, (XmlOptions) null);
        }

        public static AppinfoDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(reader, AppinfoDocument.type, xmlOptions);
        }

        public static AppinfoDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AppinfoDocument.type, (XmlOptions) null);
        }

        public static AppinfoDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AppinfoDocument.type, xmlOptions);
        }

        public static AppinfoDocument parse(Node node) throws XmlException {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(node, AppinfoDocument.type, (XmlOptions) null);
        }

        public static AppinfoDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(node, AppinfoDocument.type, xmlOptions);
        }

        public static AppinfoDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AppinfoDocument.type, (XmlOptions) null);
        }

        public static AppinfoDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AppinfoDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AppinfoDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AppinfoDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
