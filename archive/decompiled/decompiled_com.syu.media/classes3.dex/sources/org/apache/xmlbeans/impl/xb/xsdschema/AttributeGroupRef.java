package org.apache.xmlbeans.impl.xb.xsdschema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface AttributeGroupRef extends AttributeGroup {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(AttributeGroupRef.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("attributegroupref8375type");

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    QName getRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    boolean isSetRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    void setRef(QName qName);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    void unsetRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    XmlQName xgetRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    void xsetRef(XmlQName xmlQName);

    public static final class Factory {
        public static AttributeGroupRef newInstance() {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().newInstance(AttributeGroupRef.type, (XmlOptions) null);
        }

        public static AttributeGroupRef newInstance(XmlOptions xmlOptions) {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().newInstance(AttributeGroupRef.type, xmlOptions);
        }

        public static AttributeGroupRef parse(String str) throws XmlException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(str, AttributeGroupRef.type, (XmlOptions) null);
        }

        public static AttributeGroupRef parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(str, AttributeGroupRef.type, xmlOptions);
        }

        public static AttributeGroupRef parse(File file) throws XmlException, IOException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(file, AttributeGroupRef.type, (XmlOptions) null);
        }

        public static AttributeGroupRef parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(file, AttributeGroupRef.type, xmlOptions);
        }

        public static AttributeGroupRef parse(URL url) throws XmlException, IOException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(url, AttributeGroupRef.type, (XmlOptions) null);
        }

        public static AttributeGroupRef parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(url, AttributeGroupRef.type, xmlOptions);
        }

        public static AttributeGroupRef parse(InputStream inputStream) throws XmlException, IOException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(inputStream, AttributeGroupRef.type, (XmlOptions) null);
        }

        public static AttributeGroupRef parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(inputStream, AttributeGroupRef.type, xmlOptions);
        }

        public static AttributeGroupRef parse(Reader reader) throws XmlException, IOException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(reader, AttributeGroupRef.type, (XmlOptions) null);
        }

        public static AttributeGroupRef parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(reader, AttributeGroupRef.type, xmlOptions);
        }

        public static AttributeGroupRef parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AttributeGroupRef.type, (XmlOptions) null);
        }

        public static AttributeGroupRef parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AttributeGroupRef.type, xmlOptions);
        }

        public static AttributeGroupRef parse(Node node) throws XmlException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(node, AttributeGroupRef.type, (XmlOptions) null);
        }

        public static AttributeGroupRef parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(node, AttributeGroupRef.type, xmlOptions);
        }

        public static AttributeGroupRef parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AttributeGroupRef.type, (XmlOptions) null);
        }

        public static AttributeGroupRef parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (AttributeGroupRef) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AttributeGroupRef.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AttributeGroupRef.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AttributeGroupRef.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
