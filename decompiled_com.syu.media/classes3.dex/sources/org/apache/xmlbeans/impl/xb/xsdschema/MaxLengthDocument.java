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
public interface MaxLengthDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(MaxLengthDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("maxlengthf8abdoctype");

    NumFacet addNewMaxLength();

    NumFacet getMaxLength();

    void setMaxLength(NumFacet numFacet);

    public static final class Factory {
        public static MaxLengthDocument newInstance() {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().newInstance(MaxLengthDocument.type, (XmlOptions) null);
        }

        public static MaxLengthDocument newInstance(XmlOptions xmlOptions) {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().newInstance(MaxLengthDocument.type, xmlOptions);
        }

        public static MaxLengthDocument parse(String str) throws XmlException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(str, MaxLengthDocument.type, (XmlOptions) null);
        }

        public static MaxLengthDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(str, MaxLengthDocument.type, xmlOptions);
        }

        public static MaxLengthDocument parse(File file) throws XmlException, IOException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(file, MaxLengthDocument.type, (XmlOptions) null);
        }

        public static MaxLengthDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(file, MaxLengthDocument.type, xmlOptions);
        }

        public static MaxLengthDocument parse(URL url) throws XmlException, IOException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(url, MaxLengthDocument.type, (XmlOptions) null);
        }

        public static MaxLengthDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(url, MaxLengthDocument.type, xmlOptions);
        }

        public static MaxLengthDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MaxLengthDocument.type, (XmlOptions) null);
        }

        public static MaxLengthDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MaxLengthDocument.type, xmlOptions);
        }

        public static MaxLengthDocument parse(Reader reader) throws XmlException, IOException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(reader, MaxLengthDocument.type, (XmlOptions) null);
        }

        public static MaxLengthDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(reader, MaxLengthDocument.type, xmlOptions);
        }

        public static MaxLengthDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MaxLengthDocument.type, (XmlOptions) null);
        }

        public static MaxLengthDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MaxLengthDocument.type, xmlOptions);
        }

        public static MaxLengthDocument parse(Node node) throws XmlException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(node, MaxLengthDocument.type, (XmlOptions) null);
        }

        public static MaxLengthDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(node, MaxLengthDocument.type, xmlOptions);
        }

        public static MaxLengthDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MaxLengthDocument.type, (XmlOptions) null);
        }

        public static MaxLengthDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (MaxLengthDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MaxLengthDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MaxLengthDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MaxLengthDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
