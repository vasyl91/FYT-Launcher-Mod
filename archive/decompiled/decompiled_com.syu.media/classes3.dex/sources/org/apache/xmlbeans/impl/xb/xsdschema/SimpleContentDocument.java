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
public interface SimpleContentDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SimpleContentDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simplecontent8acedoctype");

    SimpleContent addNewSimpleContent();

    SimpleContent getSimpleContent();

    void setSimpleContent(SimpleContent simpleContent);

    public interface SimpleContent extends Annotated {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SimpleContent.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simplecontent9a5belemtype");

        SimpleExtensionType addNewExtension();

        SimpleRestrictionType addNewRestriction();

        SimpleExtensionType getExtension();

        SimpleRestrictionType getRestriction();

        boolean isSetExtension();

        boolean isSetRestriction();

        void setExtension(SimpleExtensionType simpleExtensionType);

        void setRestriction(SimpleRestrictionType simpleRestrictionType);

        void unsetExtension();

        void unsetRestriction();

        public static final class Factory {
            public static SimpleContent newInstance() {
                return (SimpleContent) XmlBeans.getContextTypeLoader().newInstance(SimpleContent.type, (XmlOptions) null);
            }

            public static SimpleContent newInstance(XmlOptions xmlOptions) {
                return (SimpleContent) XmlBeans.getContextTypeLoader().newInstance(SimpleContent.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static SimpleContentDocument newInstance() {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().newInstance(SimpleContentDocument.type, (XmlOptions) null);
        }

        public static SimpleContentDocument newInstance(XmlOptions xmlOptions) {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().newInstance(SimpleContentDocument.type, xmlOptions);
        }

        public static SimpleContentDocument parse(String str) throws XmlException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(str, SimpleContentDocument.type, (XmlOptions) null);
        }

        public static SimpleContentDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(str, SimpleContentDocument.type, xmlOptions);
        }

        public static SimpleContentDocument parse(File file) throws XmlException, IOException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(file, SimpleContentDocument.type, (XmlOptions) null);
        }

        public static SimpleContentDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(file, SimpleContentDocument.type, xmlOptions);
        }

        public static SimpleContentDocument parse(URL url) throws XmlException, IOException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(url, SimpleContentDocument.type, (XmlOptions) null);
        }

        public static SimpleContentDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(url, SimpleContentDocument.type, xmlOptions);
        }

        public static SimpleContentDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleContentDocument.type, (XmlOptions) null);
        }

        public static SimpleContentDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleContentDocument.type, xmlOptions);
        }

        public static SimpleContentDocument parse(Reader reader) throws XmlException, IOException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(reader, SimpleContentDocument.type, (XmlOptions) null);
        }

        public static SimpleContentDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(reader, SimpleContentDocument.type, xmlOptions);
        }

        public static SimpleContentDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleContentDocument.type, (XmlOptions) null);
        }

        public static SimpleContentDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleContentDocument.type, xmlOptions);
        }

        public static SimpleContentDocument parse(Node node) throws XmlException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(node, SimpleContentDocument.type, (XmlOptions) null);
        }

        public static SimpleContentDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(node, SimpleContentDocument.type, xmlOptions);
        }

        public static SimpleContentDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleContentDocument.type, (XmlOptions) null);
        }

        public static SimpleContentDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SimpleContentDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleContentDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleContentDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleContentDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
