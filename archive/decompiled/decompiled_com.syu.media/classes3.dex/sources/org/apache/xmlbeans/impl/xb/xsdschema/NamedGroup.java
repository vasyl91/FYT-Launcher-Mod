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
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface NamedGroup extends RealGroup {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(NamedGroup.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("namedgroup878dtype");

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    String getName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    boolean isSetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void setName(String str);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void unsetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    XmlNCName xgetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void xsetName(XmlNCName xmlNCName);

    public interface All extends org.apache.xmlbeans.impl.xb.xsdschema.All {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(All.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("all82daelemtype");

        public static final class Factory {
            public static All newInstance() {
                return (All) XmlBeans.getContextTypeLoader().newInstance(All.type, (XmlOptions) null);
            }

            public static All newInstance(XmlOptions xmlOptions) {
                return (All) XmlBeans.getContextTypeLoader().newInstance(All.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static NamedGroup newInstance() {
            return (NamedGroup) XmlBeans.getContextTypeLoader().newInstance(NamedGroup.type, (XmlOptions) null);
        }

        public static NamedGroup newInstance(XmlOptions xmlOptions) {
            return (NamedGroup) XmlBeans.getContextTypeLoader().newInstance(NamedGroup.type, xmlOptions);
        }

        public static NamedGroup parse(String str) throws XmlException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(str, NamedGroup.type, (XmlOptions) null);
        }

        public static NamedGroup parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(str, NamedGroup.type, xmlOptions);
        }

        public static NamedGroup parse(File file) throws XmlException, IOException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(file, NamedGroup.type, (XmlOptions) null);
        }

        public static NamedGroup parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(file, NamedGroup.type, xmlOptions);
        }

        public static NamedGroup parse(URL url) throws XmlException, IOException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(url, NamedGroup.type, (XmlOptions) null);
        }

        public static NamedGroup parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(url, NamedGroup.type, xmlOptions);
        }

        public static NamedGroup parse(InputStream inputStream) throws XmlException, IOException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(inputStream, NamedGroup.type, (XmlOptions) null);
        }

        public static NamedGroup parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(inputStream, NamedGroup.type, xmlOptions);
        }

        public static NamedGroup parse(Reader reader) throws XmlException, IOException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(reader, NamedGroup.type, (XmlOptions) null);
        }

        public static NamedGroup parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(reader, NamedGroup.type, xmlOptions);
        }

        public static NamedGroup parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NamedGroup.type, (XmlOptions) null);
        }

        public static NamedGroup parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NamedGroup.type, xmlOptions);
        }

        public static NamedGroup parse(Node node) throws XmlException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(node, NamedGroup.type, (XmlOptions) null);
        }

        public static NamedGroup parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(node, NamedGroup.type, xmlOptions);
        }

        public static NamedGroup parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NamedGroup.type, (XmlOptions) null);
        }

        public static NamedGroup parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (NamedGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NamedGroup.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NamedGroup.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NamedGroup.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
