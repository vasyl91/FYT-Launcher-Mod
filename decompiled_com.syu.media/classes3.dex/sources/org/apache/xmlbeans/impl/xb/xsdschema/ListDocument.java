package org.apache.xmlbeans.impl.xb.xsdschema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface ListDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(ListDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("listcde5doctype");

    List addNewList();

    List getList();

    void setList(List list);

    public interface List extends Annotated {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(List.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("list391felemtype");

        LocalSimpleType addNewSimpleType();

        QName getItemType();

        LocalSimpleType getSimpleType();

        boolean isSetItemType();

        boolean isSetSimpleType();

        void setItemType(QName qName);

        void setSimpleType(LocalSimpleType localSimpleType);

        void unsetItemType();

        void unsetSimpleType();

        XmlQName xgetItemType();

        void xsetItemType(XmlQName xmlQName);

        public static final class Factory {
            public static List newInstance() {
                return (List) XmlBeans.getContextTypeLoader().newInstance(List.type, (XmlOptions) null);
            }

            public static List newInstance(XmlOptions xmlOptions) {
                return (List) XmlBeans.getContextTypeLoader().newInstance(List.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static ListDocument newInstance() {
            return (ListDocument) XmlBeans.getContextTypeLoader().newInstance(ListDocument.type, (XmlOptions) null);
        }

        public static ListDocument newInstance(XmlOptions xmlOptions) {
            return (ListDocument) XmlBeans.getContextTypeLoader().newInstance(ListDocument.type, xmlOptions);
        }

        public static ListDocument parse(String str) throws XmlException {
            return (ListDocument) XmlBeans.getContextTypeLoader().parse(str, ListDocument.type, (XmlOptions) null);
        }

        public static ListDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ListDocument) XmlBeans.getContextTypeLoader().parse(str, ListDocument.type, xmlOptions);
        }

        public static ListDocument parse(File file) throws XmlException, IOException {
            return (ListDocument) XmlBeans.getContextTypeLoader().parse(file, ListDocument.type, (XmlOptions) null);
        }

        public static ListDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ListDocument) XmlBeans.getContextTypeLoader().parse(file, ListDocument.type, xmlOptions);
        }

        public static ListDocument parse(URL url) throws XmlException, IOException {
            return (ListDocument) XmlBeans.getContextTypeLoader().parse(url, ListDocument.type, (XmlOptions) null);
        }

        public static ListDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ListDocument) XmlBeans.getContextTypeLoader().parse(url, ListDocument.type, xmlOptions);
        }

        public static ListDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (ListDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ListDocument.type, (XmlOptions) null);
        }

        public static ListDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ListDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ListDocument.type, xmlOptions);
        }

        public static ListDocument parse(Reader reader) throws XmlException, IOException {
            return (ListDocument) XmlBeans.getContextTypeLoader().parse(reader, ListDocument.type, (XmlOptions) null);
        }

        public static ListDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ListDocument) XmlBeans.getContextTypeLoader().parse(reader, ListDocument.type, xmlOptions);
        }

        public static ListDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ListDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ListDocument.type, (XmlOptions) null);
        }

        public static ListDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ListDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ListDocument.type, xmlOptions);
        }

        public static ListDocument parse(Node node) throws XmlException {
            return (ListDocument) XmlBeans.getContextTypeLoader().parse(node, ListDocument.type, (XmlOptions) null);
        }

        public static ListDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ListDocument) XmlBeans.getContextTypeLoader().parse(node, ListDocument.type, xmlOptions);
        }

        public static ListDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (ListDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ListDocument.type, (XmlOptions) null);
        }

        public static ListDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (ListDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ListDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ListDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ListDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
