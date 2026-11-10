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
public interface MaxInclusiveDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(MaxInclusiveDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("maxinclusive93dbdoctype");

    Facet addNewMaxInclusive();

    Facet getMaxInclusive();

    void setMaxInclusive(Facet facet);

    public static final class Factory {
        public static MaxInclusiveDocument newInstance() {
            return (MaxInclusiveDocument) XmlBeans.getContextTypeLoader().newInstance(MaxInclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxInclusiveDocument newInstance(XmlOptions xmlOptions) {
            return (MaxInclusiveDocument) XmlBeans.getContextTypeLoader().newInstance(MaxInclusiveDocument.type, xmlOptions);
        }

        public static MaxInclusiveDocument parse(String str) throws XmlException {
            return (MaxInclusiveDocument) XmlBeans.getContextTypeLoader().parse(str, MaxInclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxInclusiveDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (MaxInclusiveDocument) XmlBeans.getContextTypeLoader().parse(str, MaxInclusiveDocument.type, xmlOptions);
        }

        public static MaxInclusiveDocument parse(File file) throws XmlException, IOException {
            return (MaxInclusiveDocument) XmlBeans.getContextTypeLoader().parse(file, MaxInclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxInclusiveDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxInclusiveDocument) XmlBeans.getContextTypeLoader().parse(file, MaxInclusiveDocument.type, xmlOptions);
        }

        public static MaxInclusiveDocument parse(URL url) throws XmlException, IOException {
            return (MaxInclusiveDocument) XmlBeans.getContextTypeLoader().parse(url, MaxInclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxInclusiveDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxInclusiveDocument) XmlBeans.getContextTypeLoader().parse(url, MaxInclusiveDocument.type, xmlOptions);
        }

        public static MaxInclusiveDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (MaxInclusiveDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MaxInclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxInclusiveDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxInclusiveDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MaxInclusiveDocument.type, xmlOptions);
        }

        public static MaxInclusiveDocument parse(Reader reader) throws XmlException, IOException {
            return (MaxInclusiveDocument) XmlBeans.getContextTypeLoader().parse(reader, MaxInclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxInclusiveDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxInclusiveDocument) XmlBeans.getContextTypeLoader().parse(reader, MaxInclusiveDocument.type, xmlOptions);
        }

        public static MaxInclusiveDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (MaxInclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MaxInclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxInclusiveDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (MaxInclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MaxInclusiveDocument.type, xmlOptions);
        }

        public static MaxInclusiveDocument parse(Node node) throws XmlException {
            return (MaxInclusiveDocument) XmlBeans.getContextTypeLoader().parse(node, MaxInclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxInclusiveDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (MaxInclusiveDocument) XmlBeans.getContextTypeLoader().parse(node, MaxInclusiveDocument.type, xmlOptions);
        }

        public static MaxInclusiveDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (MaxInclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MaxInclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxInclusiveDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (MaxInclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MaxInclusiveDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MaxInclusiveDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MaxInclusiveDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
