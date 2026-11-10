package org.apache.xmlbeans.impl.xb.xsdschema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlNMTOKEN;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface Attribute extends Annotated {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Attribute.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("attribute83a9type");

    LocalSimpleType addNewSimpleType();

    String getDefault();

    String getFixed();

    FormChoice.Enum getForm();

    String getName();

    QName getRef();

    LocalSimpleType getSimpleType();

    QName getType();

    Use.Enum getUse();

    boolean isSetDefault();

    boolean isSetFixed();

    boolean isSetForm();

    boolean isSetName();

    boolean isSetRef();

    boolean isSetSimpleType();

    boolean isSetType();

    boolean isSetUse();

    void setDefault(String str);

    void setFixed(String str);

    void setForm(FormChoice.Enum r1);

    void setName(String str);

    void setRef(QName qName);

    void setSimpleType(LocalSimpleType localSimpleType);

    void setType(QName qName);

    void setUse(Use.Enum r1);

    void unsetDefault();

    void unsetFixed();

    void unsetForm();

    void unsetName();

    void unsetRef();

    void unsetSimpleType();

    void unsetType();

    void unsetUse();

    XmlString xgetDefault();

    XmlString xgetFixed();

    FormChoice xgetForm();

    XmlNCName xgetName();

    XmlQName xgetRef();

    XmlQName xgetType();

    Use xgetUse();

    void xsetDefault(XmlString xmlString);

    void xsetFixed(XmlString xmlString);

    void xsetForm(FormChoice formChoice);

    void xsetName(XmlNCName xmlNCName);

    void xsetRef(XmlQName xmlQName);

    void xsetType(XmlQName xmlQName);

    void xsetUse(Use use);

    public interface Use extends XmlNMTOKEN {
        public static final int INT_OPTIONAL = 2;
        public static final int INT_PROHIBITED = 1;
        public static final int INT_REQUIRED = 3;
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Use.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("usea41aattrtype");
        public static final Enum PROHIBITED = Enum.forString("prohibited");
        public static final Enum OPTIONAL = Enum.forString("optional");
        public static final Enum REQUIRED = Enum.forString("required");

        StringEnumAbstractBase enumValue();

        void set(StringEnumAbstractBase stringEnumAbstractBase);

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_OPTIONAL = 2;
            static final int INT_PROHIBITED = 1;
            static final int INT_REQUIRED = 3;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("prohibited", 1), new Enum("optional", 2), new Enum("required", 3)});

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
            public static Use newValue(Object obj) {
                return Use.type.newValue(obj);
            }

            public static Use newInstance() {
                return XmlBeans.getContextTypeLoader().newInstance(Use.type, (XmlOptions) null);
            }

            public static Use newInstance(XmlOptions xmlOptions) {
                return XmlBeans.getContextTypeLoader().newInstance(Use.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static Attribute newInstance() {
            return (Attribute) XmlBeans.getContextTypeLoader().newInstance(Attribute.type, (XmlOptions) null);
        }

        public static Attribute newInstance(XmlOptions xmlOptions) {
            return (Attribute) XmlBeans.getContextTypeLoader().newInstance(Attribute.type, xmlOptions);
        }

        public static Attribute parse(String str) throws XmlException {
            return (Attribute) XmlBeans.getContextTypeLoader().parse(str, Attribute.type, (XmlOptions) null);
        }

        public static Attribute parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (Attribute) XmlBeans.getContextTypeLoader().parse(str, Attribute.type, xmlOptions);
        }

        public static Attribute parse(File file) throws XmlException, IOException {
            return (Attribute) XmlBeans.getContextTypeLoader().parse(file, Attribute.type, (XmlOptions) null);
        }

        public static Attribute parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Attribute) XmlBeans.getContextTypeLoader().parse(file, Attribute.type, xmlOptions);
        }

        public static Attribute parse(URL url) throws XmlException, IOException {
            return (Attribute) XmlBeans.getContextTypeLoader().parse(url, Attribute.type, (XmlOptions) null);
        }

        public static Attribute parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Attribute) XmlBeans.getContextTypeLoader().parse(url, Attribute.type, xmlOptions);
        }

        public static Attribute parse(InputStream inputStream) throws XmlException, IOException {
            return (Attribute) XmlBeans.getContextTypeLoader().parse(inputStream, Attribute.type, (XmlOptions) null);
        }

        public static Attribute parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Attribute) XmlBeans.getContextTypeLoader().parse(inputStream, Attribute.type, xmlOptions);
        }

        public static Attribute parse(Reader reader) throws XmlException, IOException {
            return (Attribute) XmlBeans.getContextTypeLoader().parse(reader, Attribute.type, (XmlOptions) null);
        }

        public static Attribute parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Attribute) XmlBeans.getContextTypeLoader().parse(reader, Attribute.type, xmlOptions);
        }

        public static Attribute parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (Attribute) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Attribute.type, (XmlOptions) null);
        }

        public static Attribute parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (Attribute) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Attribute.type, xmlOptions);
        }

        public static Attribute parse(Node node) throws XmlException {
            return (Attribute) XmlBeans.getContextTypeLoader().parse(node, Attribute.type, (XmlOptions) null);
        }

        public static Attribute parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (Attribute) XmlBeans.getContextTypeLoader().parse(node, Attribute.type, xmlOptions);
        }

        public static Attribute parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (Attribute) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Attribute.type, (XmlOptions) null);
        }

        public static Attribute parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (Attribute) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Attribute.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Attribute.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Attribute.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
