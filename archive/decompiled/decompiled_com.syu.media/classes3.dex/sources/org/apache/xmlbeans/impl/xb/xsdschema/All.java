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
public interface All extends ExplicitGroup {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(All.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("all3c04type");

    public interface MinOccurs extends XmlNonNegativeInteger {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(MinOccurs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("minoccurs9283attrtype");

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
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(MaxOccurs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("maxoccurse8b1attrtype");

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
        public static All newInstance() {
            return (All) XmlBeans.getContextTypeLoader().newInstance(All.type, (XmlOptions) null);
        }

        public static All newInstance(XmlOptions xmlOptions) {
            return (All) XmlBeans.getContextTypeLoader().newInstance(All.type, xmlOptions);
        }

        public static All parse(String str) throws XmlException {
            return (All) XmlBeans.getContextTypeLoader().parse(str, All.type, (XmlOptions) null);
        }

        public static All parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (All) XmlBeans.getContextTypeLoader().parse(str, All.type, xmlOptions);
        }

        public static All parse(File file) throws XmlException, IOException {
            return (All) XmlBeans.getContextTypeLoader().parse(file, All.type, (XmlOptions) null);
        }

        public static All parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (All) XmlBeans.getContextTypeLoader().parse(file, All.type, xmlOptions);
        }

        public static All parse(URL url) throws XmlException, IOException {
            return (All) XmlBeans.getContextTypeLoader().parse(url, All.type, (XmlOptions) null);
        }

        public static All parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (All) XmlBeans.getContextTypeLoader().parse(url, All.type, xmlOptions);
        }

        public static All parse(InputStream inputStream) throws XmlException, IOException {
            return (All) XmlBeans.getContextTypeLoader().parse(inputStream, All.type, (XmlOptions) null);
        }

        public static All parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (All) XmlBeans.getContextTypeLoader().parse(inputStream, All.type, xmlOptions);
        }

        public static All parse(Reader reader) throws XmlException, IOException {
            return (All) XmlBeans.getContextTypeLoader().parse(reader, All.type, (XmlOptions) null);
        }

        public static All parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (All) XmlBeans.getContextTypeLoader().parse(reader, All.type, xmlOptions);
        }

        public static All parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (All) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, All.type, (XmlOptions) null);
        }

        public static All parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (All) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, All.type, xmlOptions);
        }

        public static All parse(Node node) throws XmlException {
            return (All) XmlBeans.getContextTypeLoader().parse(node, All.type, (XmlOptions) null);
        }

        public static All parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (All) XmlBeans.getContextTypeLoader().parse(node, All.type, xmlOptions);
        }

        public static All parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (All) XmlBeans.getContextTypeLoader().parse(xMLInputStream, All.type, (XmlOptions) null);
        }

        public static All parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (All) XmlBeans.getContextTypeLoader().parse(xMLInputStream, All.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, All.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, All.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
