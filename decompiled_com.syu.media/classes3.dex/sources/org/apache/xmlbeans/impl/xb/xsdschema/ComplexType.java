package org.apache.xmlbeans.impl.xb.xsdschema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface ComplexType extends Annotated {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(ComplexType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("complextype5dbbtype");

    All addNewAll();

    Wildcard addNewAnyAttribute();

    Attribute addNewAttribute();

    AttributeGroupRef addNewAttributeGroup();

    ExplicitGroup addNewChoice();

    ComplexContentDocument.ComplexContent addNewComplexContent();

    GroupRef addNewGroup();

    ExplicitGroup addNewSequence();

    SimpleContentDocument.SimpleContent addNewSimpleContent();

    boolean getAbstract();

    All getAll();

    Wildcard getAnyAttribute();

    Attribute getAttributeArray(int i);

    Attribute[] getAttributeArray();

    AttributeGroupRef getAttributeGroupArray(int i);

    AttributeGroupRef[] getAttributeGroupArray();

    Object getBlock();

    ExplicitGroup getChoice();

    ComplexContentDocument.ComplexContent getComplexContent();

    Object getFinal();

    GroupRef getGroup();

    boolean getMixed();

    String getName();

    ExplicitGroup getSequence();

    SimpleContentDocument.SimpleContent getSimpleContent();

    Attribute insertNewAttribute(int i);

    AttributeGroupRef insertNewAttributeGroup(int i);

    boolean isSetAbstract();

    boolean isSetAll();

    boolean isSetAnyAttribute();

    boolean isSetBlock();

    boolean isSetChoice();

    boolean isSetComplexContent();

    boolean isSetFinal();

    boolean isSetGroup();

    boolean isSetMixed();

    boolean isSetName();

    boolean isSetSequence();

    boolean isSetSimpleContent();

    void removeAttribute(int i);

    void removeAttributeGroup(int i);

    void setAbstract(boolean z);

    void setAll(All all);

    void setAnyAttribute(Wildcard wildcard);

    void setAttributeArray(int i, Attribute attribute);

    void setAttributeArray(Attribute[] attributeArr);

    void setAttributeGroupArray(int i, AttributeGroupRef attributeGroupRef);

    void setAttributeGroupArray(AttributeGroupRef[] attributeGroupRefArr);

    void setBlock(Object obj);

    void setChoice(ExplicitGroup explicitGroup);

    void setComplexContent(ComplexContentDocument.ComplexContent complexContent);

    void setFinal(Object obj);

    void setGroup(GroupRef groupRef);

    void setMixed(boolean z);

    void setName(String str);

    void setSequence(ExplicitGroup explicitGroup);

    void setSimpleContent(SimpleContentDocument.SimpleContent simpleContent);

    int sizeOfAttributeArray();

    int sizeOfAttributeGroupArray();

    void unsetAbstract();

    void unsetAll();

    void unsetAnyAttribute();

    void unsetBlock();

    void unsetChoice();

    void unsetComplexContent();

    void unsetFinal();

    void unsetGroup();

    void unsetMixed();

    void unsetName();

    void unsetSequence();

    void unsetSimpleContent();

    XmlBoolean xgetAbstract();

    DerivationSet xgetBlock();

    DerivationSet xgetFinal();

    XmlBoolean xgetMixed();

    XmlNCName xgetName();

    void xsetAbstract(XmlBoolean xmlBoolean);

    void xsetBlock(DerivationSet derivationSet);

    void xsetFinal(DerivationSet derivationSet);

    void xsetMixed(XmlBoolean xmlBoolean);

    void xsetName(XmlNCName xmlNCName);

    public static final class Factory {
        public static ComplexType newInstance() {
            return (ComplexType) XmlBeans.getContextTypeLoader().newInstance(ComplexType.type, (XmlOptions) null);
        }

        public static ComplexType newInstance(XmlOptions xmlOptions) {
            return (ComplexType) XmlBeans.getContextTypeLoader().newInstance(ComplexType.type, xmlOptions);
        }

        public static ComplexType parse(String str) throws XmlException {
            return (ComplexType) XmlBeans.getContextTypeLoader().parse(str, ComplexType.type, (XmlOptions) null);
        }

        public static ComplexType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ComplexType) XmlBeans.getContextTypeLoader().parse(str, ComplexType.type, xmlOptions);
        }

        public static ComplexType parse(File file) throws XmlException, IOException {
            return (ComplexType) XmlBeans.getContextTypeLoader().parse(file, ComplexType.type, (XmlOptions) null);
        }

        public static ComplexType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexType) XmlBeans.getContextTypeLoader().parse(file, ComplexType.type, xmlOptions);
        }

        public static ComplexType parse(URL url) throws XmlException, IOException {
            return (ComplexType) XmlBeans.getContextTypeLoader().parse(url, ComplexType.type, (XmlOptions) null);
        }

        public static ComplexType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexType) XmlBeans.getContextTypeLoader().parse(url, ComplexType.type, xmlOptions);
        }

        public static ComplexType parse(InputStream inputStream) throws XmlException, IOException {
            return (ComplexType) XmlBeans.getContextTypeLoader().parse(inputStream, ComplexType.type, (XmlOptions) null);
        }

        public static ComplexType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexType) XmlBeans.getContextTypeLoader().parse(inputStream, ComplexType.type, xmlOptions);
        }

        public static ComplexType parse(Reader reader) throws XmlException, IOException {
            return (ComplexType) XmlBeans.getContextTypeLoader().parse(reader, ComplexType.type, (XmlOptions) null);
        }

        public static ComplexType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexType) XmlBeans.getContextTypeLoader().parse(reader, ComplexType.type, xmlOptions);
        }

        public static ComplexType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ComplexType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ComplexType.type, (XmlOptions) null);
        }

        public static ComplexType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ComplexType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ComplexType.type, xmlOptions);
        }

        public static ComplexType parse(Node node) throws XmlException {
            return (ComplexType) XmlBeans.getContextTypeLoader().parse(node, ComplexType.type, (XmlOptions) null);
        }

        public static ComplexType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ComplexType) XmlBeans.getContextTypeLoader().parse(node, ComplexType.type, xmlOptions);
        }

        public static ComplexType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (ComplexType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ComplexType.type, (XmlOptions) null);
        }

        public static ComplexType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (ComplexType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ComplexType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ComplexType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ComplexType.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
