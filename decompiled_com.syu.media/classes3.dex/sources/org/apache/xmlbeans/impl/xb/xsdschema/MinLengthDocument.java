package org.apache.xmlbeans.impl.xb.xsdschema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface MinLengthDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(MinLengthDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("minlengthe7fddoctype");

    NumFacet addNewMinLength();

    NumFacet getMinLength();

    void setMinLength(NumFacet numFacet);

    public static final class Factory {
        public static MinLengthDocument newInstance() {
            return (MinLengthDocument) XmlBeans.getContextTypeLoader().newInstance(MinLengthDocument.type, (XmlOptions) null);
        }

        public static MinLengthDocument newInstance(XmlOptions xmlOptions) {
            return (MinLengthDocument) XmlBeans.getContextTypeLoader().newInstance(MinLengthDocument.type, xmlOptions);
        }

        public static MinLengthDocument parse(String str) throws XmlException {
            return (MinLengthDocument) XmlBeans.getContextTypeLoader().parse(str, MinLengthDocument.type, (XmlOptions) null);
        }

        public static MinLengthDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (MinLengthDocument) XmlBeans.getContextTypeLoader().parse(str, MinLengthDocument.type, xmlOptions);
        }

        public static MinLengthDocument parse(File file) throws XmlException, IOException {
            return (MinLengthDocument) XmlBeans.getContextTypeLoader().parse(file, MinLengthDocument.type, (XmlOptions) null);
        }

        public static MinLengthDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinLengthDocument) XmlBeans.getContextTypeLoader().parse(file, MinLengthDocument.type, xmlOptions);
        }

        public static MinLengthDocument parse(URL url) throws XmlException, IOException {
            return (MinLengthDocument) XmlBeans.getContextTypeLoader().parse(url, MinLengthDocument.type, (XmlOptions) null);
        }

        public static MinLengthDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinLengthDocument) XmlBeans.getContextTypeLoader().parse(url, MinLengthDocument.type, xmlOptions);
        }

        public static MinLengthDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (MinLengthDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MinLengthDocument.type, (XmlOptions) null);
        }

        public static MinLengthDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinLengthDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MinLengthDocument.type, xmlOptions);
        }

        public static MinLengthDocument parse(Reader reader) throws XmlException, IOException {
            return (MinLengthDocument) XmlBeans.getContextTypeLoader().parse(reader, MinLengthDocument.type, (XmlOptions) null);
        }

        public static MinLengthDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinLengthDocument) XmlBeans.getContextTypeLoader().parse(reader, MinLengthDocument.type, xmlOptions);
        }

        public static MinLengthDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (MinLengthDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MinLengthDocument.type, (XmlOptions) null);
        }

        public static MinLengthDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (MinLengthDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MinLengthDocument.type, xmlOptions);
        }

        public static MinLengthDocument parse(Node node) throws XmlException {
            return (MinLengthDocument) XmlBeans.getContextTypeLoader().parse(node, MinLengthDocument.type, (XmlOptions) null);
        }

        public static MinLengthDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (MinLengthDocument) XmlBeans.getContextTypeLoader().parse(node, MinLengthDocument.type, xmlOptions);
        }

        public static MinLengthDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (MinLengthDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MinLengthDocument.type, (XmlOptions) null);
        }

        public static MinLengthDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (MinLengthDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MinLengthDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MinLengthDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MinLengthDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
