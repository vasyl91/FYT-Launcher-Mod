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
public interface ComplexRestrictionType extends RestrictionType {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(ComplexRestrictionType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("complexrestrictiontype1b7dtype");

    public static final class Factory {
        public static ComplexRestrictionType newInstance() {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().newInstance(ComplexRestrictionType.type, (XmlOptions) null);
        }

        public static ComplexRestrictionType newInstance(XmlOptions xmlOptions) {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().newInstance(ComplexRestrictionType.type, xmlOptions);
        }

        public static ComplexRestrictionType parse(String str) throws XmlException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(str, ComplexRestrictionType.type, (XmlOptions) null);
        }

        public static ComplexRestrictionType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(str, ComplexRestrictionType.type, xmlOptions);
        }

        public static ComplexRestrictionType parse(File file) throws XmlException, IOException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(file, ComplexRestrictionType.type, (XmlOptions) null);
        }

        public static ComplexRestrictionType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(file, ComplexRestrictionType.type, xmlOptions);
        }

        public static ComplexRestrictionType parse(URL url) throws XmlException, IOException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(url, ComplexRestrictionType.type, (XmlOptions) null);
        }

        public static ComplexRestrictionType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(url, ComplexRestrictionType.type, xmlOptions);
        }

        public static ComplexRestrictionType parse(InputStream inputStream) throws XmlException, IOException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(inputStream, ComplexRestrictionType.type, (XmlOptions) null);
        }

        public static ComplexRestrictionType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(inputStream, ComplexRestrictionType.type, xmlOptions);
        }

        public static ComplexRestrictionType parse(Reader reader) throws XmlException, IOException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(reader, ComplexRestrictionType.type, (XmlOptions) null);
        }

        public static ComplexRestrictionType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(reader, ComplexRestrictionType.type, xmlOptions);
        }

        public static ComplexRestrictionType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ComplexRestrictionType.type, (XmlOptions) null);
        }

        public static ComplexRestrictionType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ComplexRestrictionType.type, xmlOptions);
        }

        public static ComplexRestrictionType parse(Node node) throws XmlException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(node, ComplexRestrictionType.type, (XmlOptions) null);
        }

        public static ComplexRestrictionType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(node, ComplexRestrictionType.type, xmlOptions);
        }

        public static ComplexRestrictionType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ComplexRestrictionType.type, (XmlOptions) null);
        }

        public static ComplexRestrictionType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (ComplexRestrictionType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ComplexRestrictionType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ComplexRestrictionType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ComplexRestrictionType.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
