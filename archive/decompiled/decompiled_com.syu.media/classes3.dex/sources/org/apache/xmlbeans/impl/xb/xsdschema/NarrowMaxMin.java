package org.apache.xmlbeans.impl.xb.xsdschema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface NarrowMaxMin extends LocalElement {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(NarrowMaxMin.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("narrowmaxmin926atype");

    public interface MinOccurs extends XmlNonNegativeInteger {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(MinOccurs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("minoccurs1acbattrtype");

        public static final class Factory {
            public static MinOccurs newValue(Object obj) {
                return MinOccurs.type.newValue(obj);
            }

            public static MinOccurs newInstance() {
                return XmlBeans.getContextTypeLoader().newInstance(MinOccurs.type, (XmlOptions) null);
            }

            public static MinOccurs newInstance(XmlOptions xmlOptions) {
                return XmlBeans.getContextTypeLoader().newInstance(MinOccurs.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public interface MaxOccurs extends AllNNI {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(MaxOccurs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("maxoccursd85dattrtype");

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AllNNI
        Object getObjectValue();

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AllNNI
        SchemaType instanceType();

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AllNNI
        void objectSet(Object obj);

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AllNNI
        Object objectValue();

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AllNNI
        void setObjectValue(Object obj);

        public static final class Factory {
            public static MaxOccurs newValue(Object obj) {
                return (MaxOccurs) MaxOccurs.type.newValue(obj);
            }

            public static MaxOccurs newInstance() {
                return XmlBeans.getContextTypeLoader().newInstance(MaxOccurs.type, (XmlOptions) null);
            }

            public static MaxOccurs newInstance(XmlOptions xmlOptions) {
                return XmlBeans.getContextTypeLoader().newInstance(MaxOccurs.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static NarrowMaxMin newInstance() {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().newInstance(NarrowMaxMin.type, (XmlOptions) null);
        }

        public static NarrowMaxMin newInstance(XmlOptions xmlOptions) {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().newInstance(NarrowMaxMin.type, xmlOptions);
        }

        public static NarrowMaxMin parse(String str) throws XmlException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(str, NarrowMaxMin.type, (XmlOptions) null);
        }

        public static NarrowMaxMin parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(str, NarrowMaxMin.type, xmlOptions);
        }

        public static NarrowMaxMin parse(File file) throws XmlException, IOException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(file, NarrowMaxMin.type, (XmlOptions) null);
        }

        public static NarrowMaxMin parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(file, NarrowMaxMin.type, xmlOptions);
        }

        public static NarrowMaxMin parse(URL url) throws XmlException, IOException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(url, NarrowMaxMin.type, (XmlOptions) null);
        }

        public static NarrowMaxMin parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(url, NarrowMaxMin.type, xmlOptions);
        }

        public static NarrowMaxMin parse(InputStream inputStream) throws XmlException, IOException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(inputStream, NarrowMaxMin.type, (XmlOptions) null);
        }

        public static NarrowMaxMin parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(inputStream, NarrowMaxMin.type, xmlOptions);
        }

        public static NarrowMaxMin parse(Reader reader) throws XmlException, IOException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(reader, NarrowMaxMin.type, (XmlOptions) null);
        }

        public static NarrowMaxMin parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(reader, NarrowMaxMin.type, xmlOptions);
        }

        public static NarrowMaxMin parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NarrowMaxMin.type, (XmlOptions) null);
        }

        public static NarrowMaxMin parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NarrowMaxMin.type, xmlOptions);
        }

        public static NarrowMaxMin parse(Node node) throws XmlException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(node, NarrowMaxMin.type, (XmlOptions) null);
        }

        public static NarrowMaxMin parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(node, NarrowMaxMin.type, xmlOptions);
        }

        public static NarrowMaxMin parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NarrowMaxMin.type, (XmlOptions) null);
        }

        public static NarrowMaxMin parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (NarrowMaxMin) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NarrowMaxMin.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NarrowMaxMin.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NarrowMaxMin.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
