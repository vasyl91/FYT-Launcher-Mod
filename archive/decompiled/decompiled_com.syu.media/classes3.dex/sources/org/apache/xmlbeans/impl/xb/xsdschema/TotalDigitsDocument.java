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
public interface TotalDigitsDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(TotalDigitsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("totaldigits4a8bdoctype");

    TotalDigits addNewTotalDigits();

    TotalDigits getTotalDigits();

    void setTotalDigits(TotalDigits totalDigits);

    public interface TotalDigits extends NumFacet {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(TotalDigits.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("totaldigits2615elemtype");

        public static final class Factory {
            public static TotalDigits newInstance() {
                return (TotalDigits) XmlBeans.getContextTypeLoader().newInstance(TotalDigits.type, (XmlOptions) null);
            }

            public static TotalDigits newInstance(XmlOptions xmlOptions) {
                return (TotalDigits) XmlBeans.getContextTypeLoader().newInstance(TotalDigits.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static TotalDigitsDocument newInstance() {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().newInstance(TotalDigitsDocument.type, (XmlOptions) null);
        }

        public static TotalDigitsDocument newInstance(XmlOptions xmlOptions) {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().newInstance(TotalDigitsDocument.type, xmlOptions);
        }

        public static TotalDigitsDocument parse(String str) throws XmlException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(str, TotalDigitsDocument.type, (XmlOptions) null);
        }

        public static TotalDigitsDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(str, TotalDigitsDocument.type, xmlOptions);
        }

        public static TotalDigitsDocument parse(File file) throws XmlException, IOException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(file, TotalDigitsDocument.type, (XmlOptions) null);
        }

        public static TotalDigitsDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(file, TotalDigitsDocument.type, xmlOptions);
        }

        public static TotalDigitsDocument parse(URL url) throws XmlException, IOException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(url, TotalDigitsDocument.type, (XmlOptions) null);
        }

        public static TotalDigitsDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(url, TotalDigitsDocument.type, xmlOptions);
        }

        public static TotalDigitsDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(inputStream, TotalDigitsDocument.type, (XmlOptions) null);
        }

        public static TotalDigitsDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(inputStream, TotalDigitsDocument.type, xmlOptions);
        }

        public static TotalDigitsDocument parse(Reader reader) throws XmlException, IOException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(reader, TotalDigitsDocument.type, (XmlOptions) null);
        }

        public static TotalDigitsDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(reader, TotalDigitsDocument.type, xmlOptions);
        }

        public static TotalDigitsDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TotalDigitsDocument.type, (XmlOptions) null);
        }

        public static TotalDigitsDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TotalDigitsDocument.type, xmlOptions);
        }

        public static TotalDigitsDocument parse(Node node) throws XmlException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(node, TotalDigitsDocument.type, (XmlOptions) null);
        }

        public static TotalDigitsDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(node, TotalDigitsDocument.type, xmlOptions);
        }

        public static TotalDigitsDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TotalDigitsDocument.type, (XmlOptions) null);
        }

        public static TotalDigitsDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (TotalDigitsDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TotalDigitsDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TotalDigitsDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TotalDigitsDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
