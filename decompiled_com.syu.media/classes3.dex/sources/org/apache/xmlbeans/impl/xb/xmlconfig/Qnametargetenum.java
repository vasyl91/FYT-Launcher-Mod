package org.apache.xmlbeans.impl.xb.xmlconfig;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface Qnametargetenum extends XmlToken {
    public static final int INT_ACCESSOR_ATTRIBUTE = 4;
    public static final int INT_ACCESSOR_ELEMENT = 3;
    public static final int INT_DOCUMENT_TYPE = 2;
    public static final int INT_TYPE = 1;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Qnametargetenum.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("qnametargetenum9f8ftype");
    public static final Enum TYPE = Enum.forString(JamXmlElements.TYPE);
    public static final Enum DOCUMENT_TYPE = Enum.forString("document-type");
    public static final Enum ACCESSOR_ELEMENT = Enum.forString("accessor-element");
    public static final Enum ACCESSOR_ATTRIBUTE = Enum.forString("accessor-attribute");

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ACCESSOR_ATTRIBUTE = 4;
        static final int INT_ACCESSOR_ELEMENT = 3;
        static final int INT_DOCUMENT_TYPE = 2;
        static final int INT_TYPE = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum(JamXmlElements.TYPE, 1), new Enum("document-type", 2), new Enum("accessor-element", 3), new Enum("accessor-attribute", 4)});

        public static Enum forString(String str) {
            return (Enum) table.forString(str);
        }

        public static Enum forInt(int i) {
            return (Enum) table.forInt(i);
        }

        private Enum(String str, int i) {
            super(str, i);
        }

        private Object readResolve() {
            return forInt(intValue());
        }
    }

    public static final class Factory {
        public static Qnametargetenum newValue(Object obj) {
            return Qnametargetenum.type.newValue(obj);
        }

        public static Qnametargetenum newInstance() {
            return XmlBeans.getContextTypeLoader().newInstance(Qnametargetenum.type, (XmlOptions) null);
        }

        public static Qnametargetenum newInstance(XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newInstance(Qnametargetenum.type, xmlOptions);
        }

        public static Qnametargetenum parse(String str) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, Qnametargetenum.type, (XmlOptions) null);
        }

        public static Qnametargetenum parse(String str, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, Qnametargetenum.type, xmlOptions);
        }

        public static Qnametargetenum parse(File file) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, Qnametargetenum.type, (XmlOptions) null);
        }

        public static Qnametargetenum parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, Qnametargetenum.type, xmlOptions);
        }

        public static Qnametargetenum parse(URL url) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, Qnametargetenum.type, (XmlOptions) null);
        }

        public static Qnametargetenum parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, Qnametargetenum.type, xmlOptions);
        }

        public static Qnametargetenum parse(InputStream inputStream) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, Qnametargetenum.type, (XmlOptions) null);
        }

        public static Qnametargetenum parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, Qnametargetenum.type, xmlOptions);
        }

        public static Qnametargetenum parse(Reader reader) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, Qnametargetenum.type, (XmlOptions) null);
        }

        public static Qnametargetenum parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, Qnametargetenum.type, xmlOptions);
        }

        public static Qnametargetenum parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Qnametargetenum.type, (XmlOptions) null);
        }

        public static Qnametargetenum parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Qnametargetenum.type, xmlOptions);
        }

        public static Qnametargetenum parse(Node node) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, Qnametargetenum.type, (XmlOptions) null);
        }

        public static Qnametargetenum parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, Qnametargetenum.type, xmlOptions);
        }

        public static Qnametargetenum parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, Qnametargetenum.type, (XmlOptions) null);
        }

        public static Qnametargetenum parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, Qnametargetenum.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Qnametargetenum.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Qnametargetenum.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
