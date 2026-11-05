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
import org.apache.xmlbeans.XmlLanguage;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface DocumentationDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(DocumentationDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("documentation6cdbdoctype");

    Documentation addNewDocumentation();

    Documentation getDocumentation();

    void setDocumentation(Documentation documentation);

    public interface Documentation extends XmlObject {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Documentation.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("documentationa475elemtype");

        String getLang();

        String getSource();

        boolean isSetLang();

        boolean isSetSource();

        void setLang(String str);

        void setSource(String str);

        void unsetLang();

        void unsetSource();

        XmlLanguage xgetLang();

        XmlAnyURI xgetSource();

        void xsetLang(XmlLanguage xmlLanguage);

        void xsetSource(XmlAnyURI xmlAnyURI);

        public static final class Factory {
            public static Documentation newInstance() {
                return (Documentation) XmlBeans.getContextTypeLoader().newInstance(Documentation.type, (XmlOptions) null);
            }

            public static Documentation newInstance(XmlOptions xmlOptions) {
                return (Documentation) XmlBeans.getContextTypeLoader().newInstance(Documentation.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static DocumentationDocument newInstance() {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().newInstance(DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument newInstance(XmlOptions xmlOptions) {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().newInstance(DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(String str) throws XmlException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(str, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(str, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(File file) throws XmlException, IOException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(file, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(file, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(URL url) throws XmlException, IOException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(url, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(url, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(Reader reader) throws XmlException, IOException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(reader, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(reader, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(Node node) throws XmlException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(node, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(node, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DocumentationDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DocumentationDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DocumentationDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
