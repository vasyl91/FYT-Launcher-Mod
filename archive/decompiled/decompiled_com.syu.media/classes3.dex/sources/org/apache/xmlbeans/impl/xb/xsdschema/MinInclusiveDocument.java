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
public interface MinInclusiveDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(MinInclusiveDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("mininclusive8b49doctype");

    Facet addNewMinInclusive();

    Facet getMinInclusive();

    void setMinInclusive(Facet facet);

    public static final class Factory {
        public static MinInclusiveDocument newInstance() {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().newInstance(MinInclusiveDocument.type, (XmlOptions) null);
        }

        public static MinInclusiveDocument newInstance(XmlOptions xmlOptions) {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().newInstance(MinInclusiveDocument.type, xmlOptions);
        }

        public static MinInclusiveDocument parse(String str) throws XmlException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(str, MinInclusiveDocument.type, (XmlOptions) null);
        }

        public static MinInclusiveDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(str, MinInclusiveDocument.type, xmlOptions);
        }

        public static MinInclusiveDocument parse(File file) throws XmlException, IOException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(file, MinInclusiveDocument.type, (XmlOptions) null);
        }

        public static MinInclusiveDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(file, MinInclusiveDocument.type, xmlOptions);
        }

        public static MinInclusiveDocument parse(URL url) throws XmlException, IOException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(url, MinInclusiveDocument.type, (XmlOptions) null);
        }

        public static MinInclusiveDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(url, MinInclusiveDocument.type, xmlOptions);
        }

        public static MinInclusiveDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MinInclusiveDocument.type, (XmlOptions) null);
        }

        public static MinInclusiveDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MinInclusiveDocument.type, xmlOptions);
        }

        public static MinInclusiveDocument parse(Reader reader) throws XmlException, IOException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(reader, MinInclusiveDocument.type, (XmlOptions) null);
        }

        public static MinInclusiveDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(reader, MinInclusiveDocument.type, xmlOptions);
        }

        public static MinInclusiveDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MinInclusiveDocument.type, (XmlOptions) null);
        }

        public static MinInclusiveDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MinInclusiveDocument.type, xmlOptions);
        }

        public static MinInclusiveDocument parse(Node node) throws XmlException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(node, MinInclusiveDocument.type, (XmlOptions) null);
        }

        public static MinInclusiveDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(node, MinInclusiveDocument.type, xmlOptions);
        }

        public static MinInclusiveDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MinInclusiveDocument.type, (XmlOptions) null);
        }

        public static MinInclusiveDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (MinInclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MinInclusiveDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MinInclusiveDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MinInclusiveDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
