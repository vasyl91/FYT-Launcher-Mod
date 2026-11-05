package org.apache.xmlbeans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface XmlObject extends XmlTokenSource {
    public static final int EQUAL = 0;
    public static final int GREATER_THAN = 1;
    public static final int LESS_THAN = -1;
    public static final int NOT_EQUAL = 2;
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_anyType");

    XmlObject changeType(SchemaType schemaType);

    int compareTo(Object obj);

    int compareValue(XmlObject xmlObject);

    XmlObject copy();

    XmlObject copy(XmlOptions xmlOptions);

    XmlObject[] execQuery(String str);

    XmlObject[] execQuery(String str, XmlOptions xmlOptions);

    boolean isImmutable();

    boolean isNil();

    SchemaType schemaType();

    XmlObject selectAttribute(String str, String str2);

    XmlObject selectAttribute(QName qName);

    XmlObject[] selectAttributes(QNameSet qNameSet);

    XmlObject[] selectChildren(String str, String str2);

    XmlObject[] selectChildren(QName qName);

    XmlObject[] selectChildren(QNameSet qNameSet);

    XmlObject[] selectPath(String str);

    XmlObject[] selectPath(String str, XmlOptions xmlOptions);

    XmlObject set(XmlObject xmlObject);

    void setNil();

    XmlObject substitute(QName qName, SchemaType schemaType);

    String toString();

    boolean validate();

    boolean validate(XmlOptions xmlOptions);

    boolean valueEquals(XmlObject xmlObject);

    int valueHashCode();

    public static final class Factory {
        public static XmlObject newInstance() {
            return XmlBeans.getContextTypeLoader().newInstance(null, null);
        }

        public static XmlObject newInstance(XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newInstance(null, xmlOptions);
        }

        public static XmlObject newValue(Object obj) {
            return XmlObject.type.newValue(obj);
        }

        public static XmlObject parse(String str) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, (SchemaType) null, (XmlOptions) null);
        }

        public static XmlObject parse(String str, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, (SchemaType) null, xmlOptions);
        }

        public static XmlObject parse(File file) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, (SchemaType) null, (XmlOptions) null);
        }

        public static XmlObject parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, (SchemaType) null, xmlOptions);
        }

        public static XmlObject parse(URL url) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, (SchemaType) null, (XmlOptions) null);
        }

        public static XmlObject parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, (SchemaType) null, xmlOptions);
        }

        public static XmlObject parse(InputStream inputStream) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, (SchemaType) null, (XmlOptions) null);
        }

        public static XmlObject parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, (SchemaType) null, (XmlOptions) null);
        }

        public static XmlObject parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, (SchemaType) null, xmlOptions);
        }

        public static XmlObject parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, (SchemaType) null, xmlOptions);
        }

        public static XmlObject parse(Reader reader) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, (SchemaType) null, (XmlOptions) null);
        }

        public static XmlObject parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, (SchemaType) null, xmlOptions);
        }

        public static XmlObject parse(Node node) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, (SchemaType) null, (XmlOptions) null);
        }

        public static XmlObject parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, (SchemaType) null, xmlOptions);
        }

        public static XmlObject parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, (SchemaType) null, (XmlOptions) null);
        }

        public static XmlObject parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, (SchemaType) null, xmlOptions);
        }

        public static XmlSaxHandler newXmlSaxHandler() {
            return XmlBeans.getContextTypeLoader().newXmlSaxHandler(null, null);
        }

        public static XmlSaxHandler newXmlSaxHandler(XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newXmlSaxHandler(null, xmlOptions);
        }

        public static DOMImplementation newDomImplementation() {
            return XmlBeans.getContextTypeLoader().newDomImplementation(null);
        }

        public static DOMImplementation newDomImplementation(XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newDomImplementation(xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, null, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, null, xmlOptions);
        }

        private Factory() {
        }
    }
}
