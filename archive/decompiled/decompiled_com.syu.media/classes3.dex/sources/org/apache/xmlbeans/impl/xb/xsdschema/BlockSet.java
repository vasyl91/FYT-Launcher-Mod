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
public interface BlockSet extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(BlockSet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("blockset815etype");

    Object getObjectValue();

    SchemaType instanceType();

    void objectSet(Object obj);

    Object objectValue();

    void setObjectValue(Object obj);

    public interface Member extends XmlToken {
        public static final int INT_ALL = 1;
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Member.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon0683type");
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
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Member2.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anonc904type");

        List getListValue();

        List listValue();

        void set(List list);

        void setListValue(List list);

        List xgetListValue();

        List xlistValue();

        public interface Item extends DerivationControl {
            public static final int INT_EXTENSION = 2;
            public static final int INT_RESTRICTION = 3;
            public static final int INT_SUBSTITUTION = 1;
            public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Item.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon421ctype");
            public static final DerivationControl.Enum EXTENSION = DerivationControl.EXTENSION;
            public static final DerivationControl.Enum RESTRICTION = DerivationControl.RESTRICTION;
            public static final DerivationControl.Enum SUBSTITUTION = DerivationControl.SUBSTITUTION;

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
        public static BlockSet newValue(Object obj) {
            return (BlockSet) BlockSet.type.newValue(obj);
        }

        public static BlockSet newInstance() {
            return XmlBeans.getContextTypeLoader().newInstance(BlockSet.type, (XmlOptions) null);
        }

        public static BlockSet newInstance(XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newInstance(BlockSet.type, xmlOptions);
        }

        public static BlockSet parse(String str) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, BlockSet.type, (XmlOptions) null);
        }

        public static BlockSet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, BlockSet.type, xmlOptions);
        }

        public static BlockSet parse(File file) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, BlockSet.type, (XmlOptions) null);
        }

        public static BlockSet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, BlockSet.type, xmlOptions);
        }

        public static BlockSet parse(URL url) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, BlockSet.type, (XmlOptions) null);
        }

        public static BlockSet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, BlockSet.type, xmlOptions);
        }

        public static BlockSet parse(InputStream inputStream) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, BlockSet.type, (XmlOptions) null);
        }

        public static BlockSet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, BlockSet.type, xmlOptions);
        }

        public static BlockSet parse(Reader reader) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, BlockSet.type, (XmlOptions) null);
        }

        public static BlockSet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, BlockSet.type, xmlOptions);
        }

        public static BlockSet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, BlockSet.type, (XmlOptions) null);
        }

        public static BlockSet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, BlockSet.type, xmlOptions);
        }

        public static BlockSet parse(Node node) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, BlockSet.type, (XmlOptions) null);
        }

        public static BlockSet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, BlockSet.type, xmlOptions);
        }

        public static BlockSet parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, BlockSet.type, (XmlOptions) null);
        }

        public static BlockSet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, BlockSet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, BlockSet.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, BlockSet.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
