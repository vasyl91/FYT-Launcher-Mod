package org.apache.xmlbeans.impl.xb.xsdschema;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface KeyrefDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(KeyrefDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("keyref45afdoctype");

    Keyref addNewKeyref();

    Keyref getKeyref();

    void setKeyref(Keyref keyref);

    public interface Keyref extends Keybase {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Keyref.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("keyref7a1felemtype");

        QName getRefer();

        void setRefer(QName qName);

        XmlQName xgetRefer();

        void xsetRefer(XmlQName xmlQName);

        public static final class Factory {
            public static Keyref newInstance() {
                return (Keyref) XmlBeans.getContextTypeLoader().newInstance(Keyref.type, (XmlOptions) null);
            }

            public static Keyref newInstance(XmlOptions xmlOptions) {
                return (Keyref) XmlBeans.getContextTypeLoader().newInstance(Keyref.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static KeyrefDocument newInstance() {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().newInstance(KeyrefDocument.type, (XmlOptions) null);
        }

        public static KeyrefDocument newInstance(XmlOptions xmlOptions) {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().newInstance(KeyrefDocument.type, xmlOptions);
        }

        public static KeyrefDocument parse(String str) throws XmlException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(str, KeyrefDocument.type, (XmlOptions) null);
        }

        public static KeyrefDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(str, KeyrefDocument.type, xmlOptions);
        }

        public static KeyrefDocument parse(File file) throws XmlException, IOException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(file, KeyrefDocument.type, (XmlOptions) null);
        }

        public static KeyrefDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(file, KeyrefDocument.type, xmlOptions);
        }

        public static KeyrefDocument parse(URL url) throws XmlException, IOException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(url, KeyrefDocument.type, (XmlOptions) null);
        }

        public static KeyrefDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(url, KeyrefDocument.type, xmlOptions);
        }

        public static KeyrefDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(inputStream, KeyrefDocument.type, (XmlOptions) null);
        }

        public static KeyrefDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(inputStream, KeyrefDocument.type, xmlOptions);
        }

        public static KeyrefDocument parse(Reader reader) throws XmlException, IOException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(reader, KeyrefDocument.type, (XmlOptions) null);
        }

        public static KeyrefDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(reader, KeyrefDocument.type, xmlOptions);
        }

        public static KeyrefDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, KeyrefDocument.type, (XmlOptions) null);
        }

        public static KeyrefDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, KeyrefDocument.type, xmlOptions);
        }

        public static KeyrefDocument parse(Node node) throws XmlException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(node, KeyrefDocument.type, (XmlOptions) null);
        }

        public static KeyrefDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(node, KeyrefDocument.type, xmlOptions);
        }

        public static KeyrefDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, KeyrefDocument.type, (XmlOptions) null);
        }

        public static KeyrefDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (KeyrefDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, KeyrefDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, KeyrefDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, KeyrefDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
