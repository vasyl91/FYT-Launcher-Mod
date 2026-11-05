package org.apache.xmlbeans.impl.xb.xmlschema;

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
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface SpaceAttribute extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SpaceAttribute.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLLANG").resolveHandle("space9344attrtypetype");

    Space.Enum getSpace();

    boolean isSetSpace();

    void setSpace(Space.Enum r1);

    void unsetSpace();

    Space xgetSpace();

    void xsetSpace(Space space);

    public interface Space extends XmlNCName {
        public static final int INT_DEFAULT = 1;
        public static final int INT_PRESERVE = 2;
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Space.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLLANG").resolveHandle("spaceb986attrtype");
        public static final Enum DEFAULT = Enum.forString("default");
        public static final Enum PRESERVE = Enum.forString("preserve");

        StringEnumAbstractBase enumValue();

        void set(StringEnumAbstractBase stringEnumAbstractBase);

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_DEFAULT = 1;
            static final int INT_PRESERVE = 2;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("default", 1), new Enum("preserve", 2)});

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
            public static Space newValue(Object obj) {
                return Space.type.newValue(obj);
            }

            public static Space newInstance() {
                return XmlBeans.getContextTypeLoader().newInstance(Space.type, (XmlOptions) null);
            }

            public static Space newInstance(XmlOptions xmlOptions) {
                return XmlBeans.getContextTypeLoader().newInstance(Space.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static SpaceAttribute newInstance() {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().newInstance(SpaceAttribute.type, (XmlOptions) null);
        }

        public static SpaceAttribute newInstance(XmlOptions xmlOptions) {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().newInstance(SpaceAttribute.type, xmlOptions);
        }

        public static SpaceAttribute parse(String str) throws XmlException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(str, SpaceAttribute.type, (XmlOptions) null);
        }

        public static SpaceAttribute parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(str, SpaceAttribute.type, xmlOptions);
        }

        public static SpaceAttribute parse(File file) throws XmlException, IOException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(file, SpaceAttribute.type, (XmlOptions) null);
        }

        public static SpaceAttribute parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(file, SpaceAttribute.type, xmlOptions);
        }

        public static SpaceAttribute parse(URL url) throws XmlException, IOException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(url, SpaceAttribute.type, (XmlOptions) null);
        }

        public static SpaceAttribute parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(url, SpaceAttribute.type, xmlOptions);
        }

        public static SpaceAttribute parse(InputStream inputStream) throws XmlException, IOException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(inputStream, SpaceAttribute.type, (XmlOptions) null);
        }

        public static SpaceAttribute parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(inputStream, SpaceAttribute.type, xmlOptions);
        }

        public static SpaceAttribute parse(Reader reader) throws XmlException, IOException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(reader, SpaceAttribute.type, (XmlOptions) null);
        }

        public static SpaceAttribute parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(reader, SpaceAttribute.type, xmlOptions);
        }

        public static SpaceAttribute parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SpaceAttribute.type, (XmlOptions) null);
        }

        public static SpaceAttribute parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SpaceAttribute.type, xmlOptions);
        }

        public static SpaceAttribute parse(Node node) throws XmlException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(node, SpaceAttribute.type, (XmlOptions) null);
        }

        public static SpaceAttribute parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(node, SpaceAttribute.type, xmlOptions);
        }

        public static SpaceAttribute parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SpaceAttribute.type, (XmlOptions) null);
        }

        public static SpaceAttribute parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SpaceAttribute) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SpaceAttribute.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SpaceAttribute.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SpaceAttribute.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
