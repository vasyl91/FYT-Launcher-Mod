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
public interface DerivationControl extends XmlNMTOKEN {
    public static final int INT_EXTENSION = 2;
    public static final int INT_LIST = 4;
    public static final int INT_RESTRICTION = 3;
    public static final int INT_SUBSTITUTION = 1;
    public static final int INT_UNION = 5;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(DerivationControl.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("derivationcontrola5dftype");
    public static final Enum SUBSTITUTION = Enum.forString("substitution");
    public static final Enum EXTENSION = Enum.forString("extension");
    public static final Enum RESTRICTION = Enum.forString("restriction");
    public static final Enum LIST = Enum.forString("list");
    public static final Enum UNION = Enum.forString("union");

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_EXTENSION = 2;
        static final int INT_LIST = 4;
        static final int INT_RESTRICTION = 3;
        static final int INT_SUBSTITUTION = 1;
        static final int INT_UNION = 5;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("substitution", 1), new Enum("extension", 2), new Enum("restriction", 3), new Enum("list", 4), new Enum("union", 5)});

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
        public static DerivationControl newValue(Object obj) {
            return DerivationControl.type.newValue(obj);
        }

        public static DerivationControl newInstance() {
            return XmlBeans.getContextTypeLoader().newInstance(DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl newInstance(XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newInstance(DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(String str) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(String str, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(File file) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(URL url) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(InputStream inputStream) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(Reader reader) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(Node node) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, DerivationControl.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DerivationControl.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DerivationControl.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
