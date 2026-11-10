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
public interface TopLevelComplexType extends ComplexType {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(TopLevelComplexType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("toplevelcomplextypee58atype");

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    String getName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    boolean isSetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    void setName(String str);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    void unsetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    XmlNCName xgetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    void xsetName(XmlNCName xmlNCName);

    public static final class Factory {
        public static TopLevelComplexType newInstance() {
            return (TopLevelComplexType) XmlBeans.getContextTypeLoader().newInstance(TopLevelComplexType.type, (XmlOptions) null);
        }

        public static TopLevelComplexType newInstance(XmlOptions xmlOptions) {
            return (TopLevelComplexType) XmlBeans.getContextTypeLoader().newInstance(TopLevelComplexType.type, xmlOptions);
        }

        public static TopLevelComplexType parse(String str) throws XmlException {
            return (TopLevelComplexType) XmlBeans.getContextTypeLoader().parse(str, TopLevelComplexType.type, (XmlOptions) null);
        }

        public static TopLevelComplexType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelComplexType) XmlBeans.getContextTypeLoader().parse(str, TopLevelComplexType.type, xmlOptions);
        }

        public static TopLevelComplexType parse(File file) throws XmlException, IOException {
            return (TopLevelComplexType) XmlBeans.getContextTypeLoader().parse(file, TopLevelComplexType.type, (XmlOptions) null);
        }

        public static TopLevelComplexType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelComplexType) XmlBeans.getContextTypeLoader().parse(file, TopLevelComplexType.type, xmlOptions);
        }

        public static TopLevelComplexType parse(URL url) throws XmlException, IOException {
            return (TopLevelComplexType) XmlBeans.getContextTypeLoader().parse(url, TopLevelComplexType.type, (XmlOptions) null);
        }

        public static TopLevelComplexType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelComplexType) XmlBeans.getContextTypeLoader().parse(url, TopLevelComplexType.type, xmlOptions);
        }

        public static TopLevelComplexType parse(InputStream inputStream) throws XmlException, IOException {
            return (TopLevelComplexType) XmlBeans.getContextTypeLoader().parse(inputStream, TopLevelComplexType.type, (XmlOptions) null);
        }

        public static TopLevelComplexType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelComplexType) XmlBeans.getContextTypeLoader().parse(inputStream, TopLevelComplexType.type, xmlOptions);
        }

        public static TopLevelComplexType parse(Reader reader) throws XmlException, IOException {
            return (TopLevelComplexType) XmlBeans.getContextTypeLoader().parse(reader, TopLevelComplexType.type, (XmlOptions) null);
        }

        public static TopLevelComplexType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelComplexType) XmlBeans.getContextTypeLoader().parse(reader, TopLevelComplexType.type, xmlOptions);
        }

        public static TopLevelComplexType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TopLevelComplexType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TopLevelComplexType.type, (XmlOptions) null);
        }

        public static TopLevelComplexType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelComplexType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TopLevelComplexType.type, xmlOptions);
        }

        public static TopLevelComplexType parse(Node node) throws XmlException {
            return (TopLevelComplexType) XmlBeans.getContextTypeLoader().parse(node, TopLevelComplexType.type, (XmlOptions) null);
        }

        public static TopLevelComplexType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelComplexType) XmlBeans.getContextTypeLoader().parse(node, TopLevelComplexType.type, xmlOptions);
        }

        public static TopLevelComplexType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (TopLevelComplexType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TopLevelComplexType.type, (XmlOptions) null);
        }

        public static TopLevelComplexType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (TopLevelComplexType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TopLevelComplexType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TopLevelComplexType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TopLevelComplexType.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
