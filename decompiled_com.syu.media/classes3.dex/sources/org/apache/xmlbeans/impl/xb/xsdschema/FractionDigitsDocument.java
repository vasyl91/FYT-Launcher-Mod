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
public interface FractionDigitsDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(FractionDigitsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("fractiondigitsed7bdoctype");

    NumFacet addNewFractionDigits();

    NumFacet getFractionDigits();

    void setFractionDigits(NumFacet numFacet);

    public static final class Factory {
        public static FractionDigitsDocument newInstance() {
            return (FractionDigitsDocument) XmlBeans.getContextTypeLoader().newInstance(FractionDigitsDocument.type, (XmlOptions) null);
        }

        public static FractionDigitsDocument newInstance(XmlOptions xmlOptions) {
            return (FractionDigitsDocument) XmlBeans.getContextTypeLoader().newInstance(FractionDigitsDocument.type, xmlOptions);
        }

        public static FractionDigitsDocument parse(String str) throws XmlException {
            return (FractionDigitsDocument) XmlBeans.getContextTypeLoader().parse(str, FractionDigitsDocument.type, (XmlOptions) null);
        }

        public static FractionDigitsDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (FractionDigitsDocument) XmlBeans.getContextTypeLoader().parse(str, FractionDigitsDocument.type, xmlOptions);
        }

        public static FractionDigitsDocument parse(File file) throws XmlException, IOException {
            return (FractionDigitsDocument) XmlBeans.getContextTypeLoader().parse(file, FractionDigitsDocument.type, (XmlOptions) null);
        }

        public static FractionDigitsDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FractionDigitsDocument) XmlBeans.getContextTypeLoader().parse(file, FractionDigitsDocument.type, xmlOptions);
        }

        public static FractionDigitsDocument parse(URL url) throws XmlException, IOException {
            return (FractionDigitsDocument) XmlBeans.getContextTypeLoader().parse(url, FractionDigitsDocument.type, (XmlOptions) null);
        }

        public static FractionDigitsDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FractionDigitsDocument) XmlBeans.getContextTypeLoader().parse(url, FractionDigitsDocument.type, xmlOptions);
        }

        public static FractionDigitsDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (FractionDigitsDocument) XmlBeans.getContextTypeLoader().parse(inputStream, FractionDigitsDocument.type, (XmlOptions) null);
        }

        public static FractionDigitsDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FractionDigitsDocument) XmlBeans.getContextTypeLoader().parse(inputStream, FractionDigitsDocument.type, xmlOptions);
        }

        public static FractionDigitsDocument parse(Reader reader) throws XmlException, IOException {
            return (FractionDigitsDocument) XmlBeans.getContextTypeLoader().parse(reader, FractionDigitsDocument.type, (XmlOptions) null);
        }

        public static FractionDigitsDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FractionDigitsDocument) XmlBeans.getContextTypeLoader().parse(reader, FractionDigitsDocument.type, xmlOptions);
        }

        public static FractionDigitsDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (FractionDigitsDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, FractionDigitsDocument.type, (XmlOptions) null);
        }

        public static FractionDigitsDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (FractionDigitsDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, FractionDigitsDocument.type, xmlOptions);
        }

        public static FractionDigitsDocument parse(Node node) throws XmlException {
            return (FractionDigitsDocument) XmlBeans.getContextTypeLoader().parse(node, FractionDigitsDocument.type, (XmlOptions) null);
        }

        public static FractionDigitsDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (FractionDigitsDocument) XmlBeans.getContextTypeLoader().parse(node, FractionDigitsDocument.type, xmlOptions);
        }

        public static FractionDigitsDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (FractionDigitsDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, FractionDigitsDocument.type, (XmlOptions) null);
        }

        public static FractionDigitsDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (FractionDigitsDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, FractionDigitsDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, FractionDigitsDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, FractionDigitsDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
