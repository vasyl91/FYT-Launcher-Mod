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
public interface ImportDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(ImportDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("import99fedoctype");

    Import addNewImport();

    Import getImport();

    void setImport(Import r1);

    public interface Import extends Annotated {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Import.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("importe2ffelemtype");

        String getNamespace();

        String getSchemaLocation();

        boolean isSetNamespace();

        boolean isSetSchemaLocation();

        void setNamespace(String str);

        void setSchemaLocation(String str);

        void unsetNamespace();

        void unsetSchemaLocation();

        XmlAnyURI xgetNamespace();

        XmlAnyURI xgetSchemaLocation();

        void xsetNamespace(XmlAnyURI xmlAnyURI);

        void xsetSchemaLocation(XmlAnyURI xmlAnyURI);

        public static final class Factory {
            public static Import newInstance() {
                return (Import) XmlBeans.getContextTypeLoader().newInstance(Import.type, (XmlOptions) null);
            }

            public static Import newInstance(XmlOptions xmlOptions) {
                return (Import) XmlBeans.getContextTypeLoader().newInstance(Import.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static ImportDocument newInstance() {
            return (ImportDocument) XmlBeans.getContextTypeLoader().newInstance(ImportDocument.type, (XmlOptions) null);
        }

        public static ImportDocument newInstance(XmlOptions xmlOptions) {
            return (ImportDocument) XmlBeans.getContextTypeLoader().newInstance(ImportDocument.type, xmlOptions);
        }

        public static ImportDocument parse(String str) throws XmlException {
            return (ImportDocument) XmlBeans.getContextTypeLoader().parse(str, ImportDocument.type, (XmlOptions) null);
        }

        public static ImportDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ImportDocument) XmlBeans.getContextTypeLoader().parse(str, ImportDocument.type, xmlOptions);
        }

        public static ImportDocument parse(File file) throws XmlException, IOException {
            return (ImportDocument) XmlBeans.getContextTypeLoader().parse(file, ImportDocument.type, (XmlOptions) null);
        }

        public static ImportDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ImportDocument) XmlBeans.getContextTypeLoader().parse(file, ImportDocument.type, xmlOptions);
        }

        public static ImportDocument parse(URL url) throws XmlException, IOException {
            return (ImportDocument) XmlBeans.getContextTypeLoader().parse(url, ImportDocument.type, (XmlOptions) null);
        }

        public static ImportDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ImportDocument) XmlBeans.getContextTypeLoader().parse(url, ImportDocument.type, xmlOptions);
        }

        public static ImportDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (ImportDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ImportDocument.type, (XmlOptions) null);
        }

        public static ImportDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ImportDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ImportDocument.type, xmlOptions);
        }

        public static ImportDocument parse(Reader reader) throws XmlException, IOException {
            return (ImportDocument) XmlBeans.getContextTypeLoader().parse(reader, ImportDocument.type, (XmlOptions) null);
        }

        public static ImportDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ImportDocument) XmlBeans.getContextTypeLoader().parse(reader, ImportDocument.type, xmlOptions);
        }

        public static ImportDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ImportDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ImportDocument.type, (XmlOptions) null);
        }

        public static ImportDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ImportDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ImportDocument.type, xmlOptions);
        }

        public static ImportDocument parse(Node node) throws XmlException {
            return (ImportDocument) XmlBeans.getContextTypeLoader().parse(node, ImportDocument.type, (XmlOptions) null);
        }

        public static ImportDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ImportDocument) XmlBeans.getContextTypeLoader().parse(node, ImportDocument.type, xmlOptions);
        }

        public static ImportDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (ImportDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ImportDocument.type, (XmlOptions) null);
        }

        public static ImportDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (ImportDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ImportDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ImportDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ImportDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
