package org.apache.xmlbeans.impl.xb.xsdschema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlNMTOKEN;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface AllNNI extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(AllNNI.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("allnni78cbtype");

    Object getObjectValue();

    SchemaType instanceType();

    void objectSet(Object obj);

    Object objectValue();

    void setObjectValue(Object obj);

    public interface Member extends XmlNMTOKEN {
        public static final int INT_UNBOUNDED = 1;
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Member.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon0330type");
        public static final Enum UNBOUNDED = Enum.forString("unbounded");

        StringEnumAbstractBase enumValue();

        void set(StringEnumAbstractBase stringEnumAbstractBase);

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_UNBOUNDED = 1;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("unbounded", 1)});

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
        public static AllNNI newValue(Object obj) {
            return (AllNNI) AllNNI.type.newValue(obj);
        }

        public static AllNNI newInstance() {
            return XmlBeans.getContextTypeLoader().newInstance(AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI newInstance(XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newInstance(AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(String str) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(String str, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(File file) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(URL url) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(InputStream inputStream) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(Reader reader) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(Node node) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, AllNNI.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AllNNI.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AllNNI.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
