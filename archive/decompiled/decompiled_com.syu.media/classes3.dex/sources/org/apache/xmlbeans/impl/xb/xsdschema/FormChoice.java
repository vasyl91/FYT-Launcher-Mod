package org.apache.xmlbeans.impl.xb.xsdschema;

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
import org.apache.xmlbeans.XmlNMTOKEN;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface FormChoice extends XmlNMTOKEN {
    public static final int INT_QUALIFIED = 1;
    public static final int INT_UNQUALIFIED = 2;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(FormChoice.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("formchoicef2aetype");
    public static final Enum QUALIFIED = Enum.forString("qualified");
    public static final Enum UNQUALIFIED = Enum.forString("unqualified");

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_QUALIFIED = 1;
        static final int INT_UNQUALIFIED = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("qualified", 1), new Enum("unqualified", 2)});

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
        public static FormChoice newValue(Object obj) {
            return FormChoice.type.newValue(obj);
        }

        public static FormChoice newInstance() {
            return XmlBeans.getContextTypeLoader().newInstance(FormChoice.type, (XmlOptions) null);
        }

        public static FormChoice newInstance(XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newInstance(FormChoice.type, xmlOptions);
        }

        public static FormChoice parse(String str) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, FormChoice.type, (XmlOptions) null);
        }

        public static FormChoice parse(String str, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, FormChoice.type, xmlOptions);
        }

        public static FormChoice parse(File file) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, FormChoice.type, (XmlOptions) null);
        }

        public static FormChoice parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, FormChoice.type, xmlOptions);
        }

        public static FormChoice parse(URL url) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, FormChoice.type, (XmlOptions) null);
        }

        public static FormChoice parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, FormChoice.type, xmlOptions);
        }

        public static FormChoice parse(InputStream inputStream) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, FormChoice.type, (XmlOptions) null);
        }

        public static FormChoice parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, FormChoice.type, xmlOptions);
        }

        public static FormChoice parse(Reader reader) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, FormChoice.type, (XmlOptions) null);
        }

        public static FormChoice parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, FormChoice.type, xmlOptions);
        }

        public static FormChoice parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, FormChoice.type, (XmlOptions) null);
        }

        public static FormChoice parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, FormChoice.type, xmlOptions);
        }

        public static FormChoice parse(Node node) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, FormChoice.type, (XmlOptions) null);
        }

        public static FormChoice parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, FormChoice.type, xmlOptions);
        }

        public static FormChoice parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, FormChoice.type, (XmlOptions) null);
        }

        public static FormChoice parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, FormChoice.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, FormChoice.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, FormChoice.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
