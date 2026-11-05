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
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface AttributeGroup extends Annotated {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(AttributeGroup.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("attributegroupe530type");

    Wildcard addNewAnyAttribute();

    Attribute addNewAttribute();

    AttributeGroupRef addNewAttributeGroup();

    Wildcard getAnyAttribute();

    Attribute getAttributeArray(int i);

    Attribute[] getAttributeArray();

    AttributeGroupRef getAttributeGroupArray(int i);

    AttributeGroupRef[] getAttributeGroupArray();

    String getName();

    QName getRef();

    Attribute insertNewAttribute(int i);

    AttributeGroupRef insertNewAttributeGroup(int i);

    boolean isSetAnyAttribute();

    boolean isSetName();

    boolean isSetRef();

    void removeAttribute(int i);

    void removeAttributeGroup(int i);

    void setAnyAttribute(Wildcard wildcard);

    void setAttributeArray(int i, Attribute attribute);

    void setAttributeArray(Attribute[] attributeArr);

    void setAttributeGroupArray(int i, AttributeGroupRef attributeGroupRef);

    void setAttributeGroupArray(AttributeGroupRef[] attributeGroupRefArr);

    void setName(String str);

    void setRef(QName qName);

    int sizeOfAttributeArray();

    int sizeOfAttributeGroupArray();

    void unsetAnyAttribute();

    void unsetName();

    void unsetRef();

    XmlNCName xgetName();

    XmlQName xgetRef();

    void xsetName(XmlNCName xmlNCName);

    void xsetRef(XmlQName xmlQName);

    public static final class Factory {
        public static AttributeGroup newInstance() {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().newInstance(AttributeGroup.type, (XmlOptions) null);
        }

        public static AttributeGroup newInstance(XmlOptions xmlOptions) {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().newInstance(AttributeGroup.type, xmlOptions);
        }

        public static AttributeGroup parse(String str) throws XmlException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(str, AttributeGroup.type, (XmlOptions) null);
        }

        public static AttributeGroup parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(str, AttributeGroup.type, xmlOptions);
        }

        public static AttributeGroup parse(File file) throws XmlException, IOException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(file, AttributeGroup.type, (XmlOptions) null);
        }

        public static AttributeGroup parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(file, AttributeGroup.type, xmlOptions);
        }

        public static AttributeGroup parse(URL url) throws XmlException, IOException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(url, AttributeGroup.type, (XmlOptions) null);
        }

        public static AttributeGroup parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(url, AttributeGroup.type, xmlOptions);
        }

        public static AttributeGroup parse(InputStream inputStream) throws XmlException, IOException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(inputStream, AttributeGroup.type, (XmlOptions) null);
        }

        public static AttributeGroup parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(inputStream, AttributeGroup.type, xmlOptions);
        }

        public static AttributeGroup parse(Reader reader) throws XmlException, IOException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(reader, AttributeGroup.type, (XmlOptions) null);
        }

        public static AttributeGroup parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(reader, AttributeGroup.type, xmlOptions);
        }

        public static AttributeGroup parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AttributeGroup.type, (XmlOptions) null);
        }

        public static AttributeGroup parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AttributeGroup.type, xmlOptions);
        }

        public static AttributeGroup parse(Node node) throws XmlException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(node, AttributeGroup.type, (XmlOptions) null);
        }

        public static AttributeGroup parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(node, AttributeGroup.type, xmlOptions);
        }

        public static AttributeGroup parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AttributeGroup.type, (XmlOptions) null);
        }

        public static AttributeGroup parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (AttributeGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AttributeGroup.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AttributeGroup.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AttributeGroup.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
