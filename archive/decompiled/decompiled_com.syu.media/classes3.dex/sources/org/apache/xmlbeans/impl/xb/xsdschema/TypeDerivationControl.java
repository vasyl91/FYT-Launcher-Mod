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
public interface TypeDerivationControl extends DerivationControl {
    public static final int INT_EXTENSION = 2;
    public static final int INT_LIST = 4;
    public static final int INT_RESTRICTION = 3;
    public static final int INT_UNION = 5;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(TypeDerivationControl.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("typederivationcontrol3239type");
    public static final DerivationControl.Enum EXTENSION = DerivationControl.EXTENSION;
    public static final DerivationControl.Enum RESTRICTION = DerivationControl.RESTRICTION;
    public static final DerivationControl.Enum LIST = DerivationControl.LIST;
    public static final DerivationControl.Enum UNION = DerivationControl.UNION;

    public static final class Factory {
        public static TypeDerivationControl newValue(Object obj) {
            return TypeDerivationControl.type.newValue(obj);
        }

        public static TypeDerivationControl newInstance() {
            return XmlBeans.getContextTypeLoader().newInstance(TypeDerivationControl.type, (XmlOptions) null);
        }

        public static TypeDerivationControl newInstance(XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newInstance(TypeDerivationControl.type, xmlOptions);
        }

        public static TypeDerivationControl parse(String str) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, TypeDerivationControl.type, (XmlOptions) null);
        }

        public static TypeDerivationControl parse(String str, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, TypeDerivationControl.type, xmlOptions);
        }

        public static TypeDerivationControl parse(File file) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, TypeDerivationControl.type, (XmlOptions) null);
        }

        public static TypeDerivationControl parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, TypeDerivationControl.type, xmlOptions);
        }

        public static TypeDerivationControl parse(URL url) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, TypeDerivationControl.type, (XmlOptions) null);
        }

        public static TypeDerivationControl parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, TypeDerivationControl.type, xmlOptions);
        }

        public static TypeDerivationControl parse(InputStream inputStream) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, TypeDerivationControl.type, (XmlOptions) null);
        }

        public static TypeDerivationControl parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, TypeDerivationControl.type, xmlOptions);
        }

        public static TypeDerivationControl parse(Reader reader) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, TypeDerivationControl.type, (XmlOptions) null);
        }

        public static TypeDerivationControl parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, TypeDerivationControl.type, xmlOptions);
        }

        public static TypeDerivationControl parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TypeDerivationControl.type, (XmlOptions) null);
        }

        public static TypeDerivationControl parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TypeDerivationControl.type, xmlOptions);
        }

        public static TypeDerivationControl parse(Node node) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, TypeDerivationControl.type, (XmlOptions) null);
        }

        public static TypeDerivationControl parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, TypeDerivationControl.type, xmlOptions);
        }

        public static TypeDerivationControl parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, TypeDerivationControl.type, (XmlOptions) null);
        }

        public static TypeDerivationControl parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, TypeDerivationControl.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TypeDerivationControl.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TypeDerivationControl.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
