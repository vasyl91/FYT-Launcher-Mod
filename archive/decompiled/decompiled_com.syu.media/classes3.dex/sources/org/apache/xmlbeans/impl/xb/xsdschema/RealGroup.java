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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface RealGroup extends Group {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(RealGroup.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("realgroup1f64type");

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    All addNewAll();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    ExplicitGroup addNewChoice();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    ExplicitGroup addNewSequence();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    All getAllArray(int i);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    All[] getAllArray();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    ExplicitGroup getChoiceArray(int i);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    ExplicitGroup[] getChoiceArray();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    ExplicitGroup getSequenceArray(int i);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    ExplicitGroup[] getSequenceArray();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    All insertNewAll(int i);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    ExplicitGroup insertNewChoice(int i);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    ExplicitGroup insertNewSequence(int i);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void removeAll(int i);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void removeChoice(int i);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void removeSequence(int i);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void setAllArray(int i, All all);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void setAllArray(All[] allArr);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void setChoiceArray(int i, ExplicitGroup explicitGroup);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void setChoiceArray(ExplicitGroup[] explicitGroupArr);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void setSequenceArray(int i, ExplicitGroup explicitGroup);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void setSequenceArray(ExplicitGroup[] explicitGroupArr);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    int sizeOfAllArray();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    int sizeOfChoiceArray();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    int sizeOfSequenceArray();

    public static final class Factory {
        public static RealGroup newInstance() {
            return (RealGroup) XmlBeans.getContextTypeLoader().newInstance(RealGroup.type, (XmlOptions) null);
        }

        public static RealGroup newInstance(XmlOptions xmlOptions) {
            return (RealGroup) XmlBeans.getContextTypeLoader().newInstance(RealGroup.type, xmlOptions);
        }

        public static RealGroup parse(String str) throws XmlException {
            return (RealGroup) XmlBeans.getContextTypeLoader().parse(str, RealGroup.type, (XmlOptions) null);
        }

        public static RealGroup parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (RealGroup) XmlBeans.getContextTypeLoader().parse(str, RealGroup.type, xmlOptions);
        }

        public static RealGroup parse(File file) throws XmlException, IOException {
            return (RealGroup) XmlBeans.getContextTypeLoader().parse(file, RealGroup.type, (XmlOptions) null);
        }

        public static RealGroup parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RealGroup) XmlBeans.getContextTypeLoader().parse(file, RealGroup.type, xmlOptions);
        }

        public static RealGroup parse(URL url) throws XmlException, IOException {
            return (RealGroup) XmlBeans.getContextTypeLoader().parse(url, RealGroup.type, (XmlOptions) null);
        }

        public static RealGroup parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RealGroup) XmlBeans.getContextTypeLoader().parse(url, RealGroup.type, xmlOptions);
        }

        public static RealGroup parse(InputStream inputStream) throws XmlException, IOException {
            return (RealGroup) XmlBeans.getContextTypeLoader().parse(inputStream, RealGroup.type, (XmlOptions) null);
        }

        public static RealGroup parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RealGroup) XmlBeans.getContextTypeLoader().parse(inputStream, RealGroup.type, xmlOptions);
        }

        public static RealGroup parse(Reader reader) throws XmlException, IOException {
            return (RealGroup) XmlBeans.getContextTypeLoader().parse(reader, RealGroup.type, (XmlOptions) null);
        }

        public static RealGroup parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RealGroup) XmlBeans.getContextTypeLoader().parse(reader, RealGroup.type, xmlOptions);
        }

        public static RealGroup parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (RealGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, RealGroup.type, (XmlOptions) null);
        }

        public static RealGroup parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (RealGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, RealGroup.type, xmlOptions);
        }

        public static RealGroup parse(Node node) throws XmlException {
            return (RealGroup) XmlBeans.getContextTypeLoader().parse(node, RealGroup.type, (XmlOptions) null);
        }

        public static RealGroup parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (RealGroup) XmlBeans.getContextTypeLoader().parse(node, RealGroup.type, xmlOptions);
        }

        public static RealGroup parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (RealGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, RealGroup.type, (XmlOptions) null);
        }

        public static RealGroup parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (RealGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, RealGroup.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, RealGroup.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, RealGroup.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
