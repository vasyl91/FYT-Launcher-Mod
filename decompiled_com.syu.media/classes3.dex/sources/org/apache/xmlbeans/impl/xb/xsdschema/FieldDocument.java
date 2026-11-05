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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface FieldDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(FieldDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("field3f9bdoctype");

    Field addNewField();

    Field getField();

    void setField(Field field);

    public interface Field extends Annotated {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Field.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("field12f5elemtype");

        String getXpath();

        void setXpath(String str);

        Xpath xgetXpath();

        void xsetXpath(Xpath xpath);

        public interface Xpath extends XmlToken {
            public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Xpath.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("xpath7f90attrtype");

            public static final class Factory {
                public static Xpath newValue(Object obj) {
                    return Xpath.type.newValue(obj);
                }

                public static Xpath newInstance() {
                    return XmlBeans.getContextTypeLoader().newInstance(Xpath.type, (XmlOptions) null);
                }

                public static Xpath newInstance(XmlOptions xmlOptions) {
                    return XmlBeans.getContextTypeLoader().newInstance(Xpath.type, xmlOptions);
                }

                private Factory() {
                }
            }
        }

        public static final class Factory {
            public static Field newInstance() {
                return (Field) XmlBeans.getContextTypeLoader().newInstance(Field.type, (XmlOptions) null);
            }

            public static Field newInstance(XmlOptions xmlOptions) {
                return (Field) XmlBeans.getContextTypeLoader().newInstance(Field.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static FieldDocument newInstance() {
            return (FieldDocument) XmlBeans.getContextTypeLoader().newInstance(FieldDocument.type, (XmlOptions) null);
        }

        public static FieldDocument newInstance(XmlOptions xmlOptions) {
            return (FieldDocument) XmlBeans.getContextTypeLoader().newInstance(FieldDocument.type, xmlOptions);
        }

        public static FieldDocument parse(String str) throws XmlException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(str, FieldDocument.type, (XmlOptions) null);
        }

        public static FieldDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(str, FieldDocument.type, xmlOptions);
        }

        public static FieldDocument parse(File file) throws XmlException, IOException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(file, FieldDocument.type, (XmlOptions) null);
        }

        public static FieldDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(file, FieldDocument.type, xmlOptions);
        }

        public static FieldDocument parse(URL url) throws XmlException, IOException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(url, FieldDocument.type, (XmlOptions) null);
        }

        public static FieldDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(url, FieldDocument.type, xmlOptions);
        }

        public static FieldDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(inputStream, FieldDocument.type, (XmlOptions) null);
        }

        public static FieldDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(inputStream, FieldDocument.type, xmlOptions);
        }

        public static FieldDocument parse(Reader reader) throws XmlException, IOException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(reader, FieldDocument.type, (XmlOptions) null);
        }

        public static FieldDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(reader, FieldDocument.type, xmlOptions);
        }

        public static FieldDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, FieldDocument.type, (XmlOptions) null);
        }

        public static FieldDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, FieldDocument.type, xmlOptions);
        }

        public static FieldDocument parse(Node node) throws XmlException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(node, FieldDocument.type, (XmlOptions) null);
        }

        public static FieldDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(node, FieldDocument.type, xmlOptions);
        }

        public static FieldDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, FieldDocument.type, (XmlOptions) null);
        }

        public static FieldDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (FieldDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, FieldDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, FieldDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, FieldDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
