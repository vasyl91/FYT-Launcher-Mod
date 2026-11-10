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
public interface MinExclusiveDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(MinExclusiveDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("minexclusive64d7doctype");

    Facet addNewMinExclusive();

    Facet getMinExclusive();

    void setMinExclusive(Facet facet);

    public static final class Factory {
        public static MinExclusiveDocument newInstance() {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().newInstance(MinExclusiveDocument.type, (XmlOptions) null);
        }

        public static MinExclusiveDocument newInstance(XmlOptions xmlOptions) {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().newInstance(MinExclusiveDocument.type, xmlOptions);
        }

        public static MinExclusiveDocument parse(String str) throws XmlException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(str, MinExclusiveDocument.type, (XmlOptions) null);
        }

        public static MinExclusiveDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(str, MinExclusiveDocument.type, xmlOptions);
        }

        public static MinExclusiveDocument parse(File file) throws XmlException, IOException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(file, MinExclusiveDocument.type, (XmlOptions) null);
        }

        public static MinExclusiveDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(file, MinExclusiveDocument.type, xmlOptions);
        }

        public static MinExclusiveDocument parse(URL url) throws XmlException, IOException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(url, MinExclusiveDocument.type, (XmlOptions) null);
        }

        public static MinExclusiveDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(url, MinExclusiveDocument.type, xmlOptions);
        }

        public static MinExclusiveDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MinExclusiveDocument.type, (XmlOptions) null);
        }

        public static MinExclusiveDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MinExclusiveDocument.type, xmlOptions);
        }

        public static MinExclusiveDocument parse(Reader reader) throws XmlException, IOException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(reader, MinExclusiveDocument.type, (XmlOptions) null);
        }

        public static MinExclusiveDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(reader, MinExclusiveDocument.type, xmlOptions);
        }

        public static MinExclusiveDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MinExclusiveDocument.type, (XmlOptions) null);
        }

        public static MinExclusiveDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MinExclusiveDocument.type, xmlOptions);
        }

        public static MinExclusiveDocument parse(Node node) throws XmlException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(node, MinExclusiveDocument.type, (XmlOptions) null);
        }

        public static MinExclusiveDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(node, MinExclusiveDocument.type, xmlOptions);
        }

        public static MinExclusiveDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MinExclusiveDocument.type, (XmlOptions) null);
        }

        public static MinExclusiveDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (MinExclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MinExclusiveDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MinExclusiveDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MinExclusiveDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
