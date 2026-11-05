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
public interface MaxExclusiveDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(MaxExclusiveDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("maxexclusive6d69doctype");

    Facet addNewMaxExclusive();

    Facet getMaxExclusive();

    void setMaxExclusive(Facet facet);

    public static final class Factory {
        public static MaxExclusiveDocument newInstance() {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().newInstance(MaxExclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxExclusiveDocument newInstance(XmlOptions xmlOptions) {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().newInstance(MaxExclusiveDocument.type, xmlOptions);
        }

        public static MaxExclusiveDocument parse(String str) throws XmlException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(str, MaxExclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxExclusiveDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(str, MaxExclusiveDocument.type, xmlOptions);
        }

        public static MaxExclusiveDocument parse(File file) throws XmlException, IOException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(file, MaxExclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxExclusiveDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(file, MaxExclusiveDocument.type, xmlOptions);
        }

        public static MaxExclusiveDocument parse(URL url) throws XmlException, IOException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(url, MaxExclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxExclusiveDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(url, MaxExclusiveDocument.type, xmlOptions);
        }

        public static MaxExclusiveDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MaxExclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxExclusiveDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MaxExclusiveDocument.type, xmlOptions);
        }

        public static MaxExclusiveDocument parse(Reader reader) throws XmlException, IOException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(reader, MaxExclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxExclusiveDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(reader, MaxExclusiveDocument.type, xmlOptions);
        }

        public static MaxExclusiveDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MaxExclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxExclusiveDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MaxExclusiveDocument.type, xmlOptions);
        }

        public static MaxExclusiveDocument parse(Node node) throws XmlException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(node, MaxExclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxExclusiveDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(node, MaxExclusiveDocument.type, xmlOptions);
        }

        public static MaxExclusiveDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MaxExclusiveDocument.type, (XmlOptions) null);
        }

        public static MaxExclusiveDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (MaxExclusiveDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MaxExclusiveDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MaxExclusiveDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MaxExclusiveDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
