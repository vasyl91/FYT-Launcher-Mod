package org.apache.xmlbeans.impl.xb.xsdschema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface AnyDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(AnyDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anye729doctype");

    Any addNewAny();

    Any getAny();

    void setAny(Any any);

    public interface Any extends Wildcard {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Any.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anye9d1elemtype");

        Object getMaxOccurs();

        BigInteger getMinOccurs();

        boolean isSetMaxOccurs();

        boolean isSetMinOccurs();

        void setMaxOccurs(Object obj);

        void setMinOccurs(BigInteger bigInteger);

        void unsetMaxOccurs();

        void unsetMinOccurs();

        AllNNI xgetMaxOccurs();

        XmlNonNegativeInteger xgetMinOccurs();

        void xsetMaxOccurs(AllNNI allNNI);

        void xsetMinOccurs(XmlNonNegativeInteger xmlNonNegativeInteger);

        public static final class Factory {
            public static Any newInstance() {
                return (Any) XmlBeans.getContextTypeLoader().newInstance(Any.type, (XmlOptions) null);
            }

            public static Any newInstance(XmlOptions xmlOptions) {
                return (Any) XmlBeans.getContextTypeLoader().newInstance(Any.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static AnyDocument newInstance() {
            return (AnyDocument) XmlBeans.getContextTypeLoader().newInstance(AnyDocument.type, (XmlOptions) null);
        }

        public static AnyDocument newInstance(XmlOptions xmlOptions) {
            return (AnyDocument) XmlBeans.getContextTypeLoader().newInstance(AnyDocument.type, xmlOptions);
        }

        public static AnyDocument parse(String str) throws XmlException {
            return (AnyDocument) XmlBeans.getContextTypeLoader().parse(str, AnyDocument.type, (XmlOptions) null);
        }

        public static AnyDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (AnyDocument) XmlBeans.getContextTypeLoader().parse(str, AnyDocument.type, xmlOptions);
        }

        public static AnyDocument parse(File file) throws XmlException, IOException {
            return (AnyDocument) XmlBeans.getContextTypeLoader().parse(file, AnyDocument.type, (XmlOptions) null);
        }

        public static AnyDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AnyDocument) XmlBeans.getContextTypeLoader().parse(file, AnyDocument.type, xmlOptions);
        }

        public static AnyDocument parse(URL url) throws XmlException, IOException {
            return (AnyDocument) XmlBeans.getContextTypeLoader().parse(url, AnyDocument.type, (XmlOptions) null);
        }

        public static AnyDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AnyDocument) XmlBeans.getContextTypeLoader().parse(url, AnyDocument.type, xmlOptions);
        }

        public static AnyDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (AnyDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AnyDocument.type, (XmlOptions) null);
        }

        public static AnyDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AnyDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AnyDocument.type, xmlOptions);
        }

        public static AnyDocument parse(Reader reader) throws XmlException, IOException {
            return (AnyDocument) XmlBeans.getContextTypeLoader().parse(reader, AnyDocument.type, (XmlOptions) null);
        }

        public static AnyDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AnyDocument) XmlBeans.getContextTypeLoader().parse(reader, AnyDocument.type, xmlOptions);
        }

        public static AnyDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (AnyDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AnyDocument.type, (XmlOptions) null);
        }

        public static AnyDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (AnyDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AnyDocument.type, xmlOptions);
        }

        public static AnyDocument parse(Node node) throws XmlException {
            return (AnyDocument) XmlBeans.getContextTypeLoader().parse(node, AnyDocument.type, (XmlOptions) null);
        }

        public static AnyDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (AnyDocument) XmlBeans.getContextTypeLoader().parse(node, AnyDocument.type, xmlOptions);
        }

        public static AnyDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (AnyDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AnyDocument.type, (XmlOptions) null);
        }

        public static AnyDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (AnyDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AnyDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AnyDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AnyDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
