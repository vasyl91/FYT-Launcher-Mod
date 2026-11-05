package org.apache.xmlbeans.impl.xb.xsdschema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface SimpleDerivationSet extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SimpleDerivationSet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simplederivationsetf70ctype");

    Object getObjectValue();

    SchemaType instanceType();

    void objectSet(Object obj);

    Object objectValue();

    void setObjectValue(Object obj);

    public interface Member extends XmlToken {
        public static final int INT_ALL = 1;
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Member.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon38c7type");
        public static final Enum ALL = Enum.forString("#all");

        StringEnumAbstractBase enumValue();

        void set(StringEnumAbstractBase stringEnumAbstractBase);

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_ALL = 1;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("#all", 1)});

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
            public static Member newValue(Object obj) {
                return Member.type.newValue(obj);
            }

            public static Member newInstance() {
                return XmlBeans.getContextTypeLoader().newInstance(Member.type, (XmlOptions) null);
            }

            public static Member newInstance(XmlOptions xmlOptions) {
                return XmlBeans.getContextTypeLoader().newInstance(Member.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public interface Member2 extends XmlAnySimpleType {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Member2.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon8ba6type");

        List getListValue();

        List listValue();

        void set(List list);

        void setListValue(List list);

        List xgetListValue();

        List xlistValue();

        public interface Item extends DerivationControl {
            public static final int INT_LIST = 4;
            public static final int INT_RESTRICTION = 3;
            public static final int INT_UNION = 5;
            public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Item.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anonf38etype");
            public static final DerivationControl.Enum LIST = DerivationControl.LIST;
            public static final DerivationControl.Enum UNION = DerivationControl.UNION;
            public static final DerivationControl.Enum RESTRICTION = DerivationControl.RESTRICTION;

            public static final class Factory {
                public static Item newValue(Object obj) {
                    return Item.type.newValue(obj);
                }

                public static Item newInstance() {
                    return XmlBeans.getContextTypeLoader().newInstance(Item.type, (XmlOptions) null);
                }

                public static Item newInstance(XmlOptions xmlOptions) {
                    return XmlBeans.getContextTypeLoader().newInstance(Item.type, xmlOptions);
                }

                private Factory() {
                }
            }
        }

        public static final class Factory {
            public static Member2 newValue(Object obj) {
                return (Member2) Member2.type.newValue(obj);
            }

            public static Member2 newInstance() {
                return XmlBeans.getContextTypeLoader().newInstance(Member2.type, (XmlOptions) null);
            }

            public static Member2 newInstance(XmlOptions xmlOptions) {
                return XmlBeans.getContextTypeLoader().newInstance(Member2.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static SimpleDerivationSet newValue(Object obj) {
            return (SimpleDerivationSet) SimpleDerivationSet.type.newValue(obj);
        }

        public static SimpleDerivationSet newInstance() {
            return XmlBeans.getContextTypeLoader().newInstance(SimpleDerivationSet.type, (XmlOptions) null);
        }

        public static SimpleDerivationSet newInstance(XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newInstance(SimpleDerivationSet.type, xmlOptions);
        }

        public static SimpleDerivationSet parse(String str) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, SimpleDerivationSet.type, (XmlOptions) null);
        }

        public static SimpleDerivationSet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, SimpleDerivationSet.type, xmlOptions);
        }

        public static SimpleDerivationSet parse(File file) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, SimpleDerivationSet.type, (XmlOptions) null);
        }

        public static SimpleDerivationSet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, SimpleDerivationSet.type, xmlOptions);
        }

        public static SimpleDerivationSet parse(URL url) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, SimpleDerivationSet.type, (XmlOptions) null);
        }

        public static SimpleDerivationSet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, SimpleDerivationSet.type, xmlOptions);
        }

        public static SimpleDerivationSet parse(InputStream inputStream) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, SimpleDerivationSet.type, (XmlOptions) null);
        }

        public static SimpleDerivationSet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, SimpleDerivationSet.type, xmlOptions);
        }

        public static SimpleDerivationSet parse(Reader reader) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, SimpleDerivationSet.type, (XmlOptions) null);
        }

        public static SimpleDerivationSet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, SimpleDerivationSet.type, xmlOptions);
        }

        public static SimpleDerivationSet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleDerivationSet.type, (XmlOptions) null);
        }

        public static SimpleDerivationSet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleDerivationSet.type, xmlOptions);
        }

        public static SimpleDerivationSet parse(Node node) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, SimpleDerivationSet.type, (XmlOptions) null);
        }

        public static SimpleDerivationSet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, SimpleDerivationSet.type, xmlOptions);
        }

        public static SimpleDerivationSet parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleDerivationSet.type, (XmlOptions) null);
        }

        public static SimpleDerivationSet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleDerivationSet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleDerivationSet.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleDerivationSet.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
