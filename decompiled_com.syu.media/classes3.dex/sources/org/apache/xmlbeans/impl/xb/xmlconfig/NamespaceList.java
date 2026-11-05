package org.apache.xmlbeans.impl.xb.xmlconfig;

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
public interface NamespaceList extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(NamespaceList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("namespacelist20datype");

    Object getObjectValue();

    SchemaType instanceType();

    void objectSet(Object obj);

    Object objectValue();

    void setObjectValue(Object obj);

    public interface Member extends XmlToken {
        public static final int INT_ANY = 1;
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Member.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("anonc6fftype");
        public static final Enum ANY = Enum.forString("##any");

        StringEnumAbstractBase enumValue();

        void set(StringEnumAbstractBase stringEnumAbstractBase);

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_ANY = 1;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("##any", 1)});

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
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Member2.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("anon5680type");

        List getListValue();

        List listValue();

        void set(List list);

        void setListValue(List list);

        List xgetListValue();

        List xlistValue();

        public interface Item extends XmlAnySimpleType {
            public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Item.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("anon0798type");

            Object getObjectValue();

            SchemaType instanceType();

            void objectSet(Object obj);

            Object objectValue();

            void setObjectValue(Object obj);

            public interface Member extends XmlToken {
                public static final int INT_LOCAL = 1;
                public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Member.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("anon1dd3type");
                public static final Enum LOCAL = Enum.forString("##local");

                StringEnumAbstractBase enumValue();

                void set(StringEnumAbstractBase stringEnumAbstractBase);

                public static final class Enum extends StringEnumAbstractBase {
                    static final int INT_LOCAL = 1;
                    private static final long serialVersionUID = 1;
                    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("##local", 1)});

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

            public static final class Factory {
                public static Item newValue(Object obj) {
                    return (Item) Item.type.newValue(obj);
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
        public static NamespaceList newValue(Object obj) {
            return (NamespaceList) NamespaceList.type.newValue(obj);
        }

        public static NamespaceList newInstance() {
            return XmlBeans.getContextTypeLoader().newInstance(NamespaceList.type, (XmlOptions) null);
        }

        public static NamespaceList newInstance(XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newInstance(NamespaceList.type, xmlOptions);
        }

        public static NamespaceList parse(String str) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, NamespaceList.type, (XmlOptions) null);
        }

        public static NamespaceList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, NamespaceList.type, xmlOptions);
        }

        public static NamespaceList parse(File file) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, NamespaceList.type, (XmlOptions) null);
        }

        public static NamespaceList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, NamespaceList.type, xmlOptions);
        }

        public static NamespaceList parse(URL url) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, NamespaceList.type, (XmlOptions) null);
        }

        public static NamespaceList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, NamespaceList.type, xmlOptions);
        }

        public static NamespaceList parse(InputStream inputStream) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, NamespaceList.type, (XmlOptions) null);
        }

        public static NamespaceList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, NamespaceList.type, xmlOptions);
        }

        public static NamespaceList parse(Reader reader) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, NamespaceList.type, (XmlOptions) null);
        }

        public static NamespaceList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, NamespaceList.type, xmlOptions);
        }

        public static NamespaceList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NamespaceList.type, (XmlOptions) null);
        }

        public static NamespaceList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NamespaceList.type, xmlOptions);
        }

        public static NamespaceList parse(Node node) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, NamespaceList.type, (XmlOptions) null);
        }

        public static NamespaceList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, NamespaceList.type, xmlOptions);
        }

        public static NamespaceList parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, NamespaceList.type, (XmlOptions) null);
        }

        public static NamespaceList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, NamespaceList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NamespaceList.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NamespaceList.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
