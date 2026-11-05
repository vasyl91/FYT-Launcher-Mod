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
public interface NumFacet extends Facet {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(NumFacet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("numfacet93a2type");

    public static final class Factory {
        public static NumFacet newInstance() {
            return (NumFacet) XmlBeans.getContextTypeLoader().newInstance(NumFacet.type, (XmlOptions) null);
        }

        public static NumFacet newInstance(XmlOptions xmlOptions) {
            return (NumFacet) XmlBeans.getContextTypeLoader().newInstance(NumFacet.type, xmlOptions);
        }

        public static NumFacet parse(String str) throws XmlException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(str, NumFacet.type, (XmlOptions) null);
        }

        public static NumFacet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(str, NumFacet.type, xmlOptions);
        }

        public static NumFacet parse(File file) throws XmlException, IOException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(file, NumFacet.type, (XmlOptions) null);
        }

        public static NumFacet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(file, NumFacet.type, xmlOptions);
        }

        public static NumFacet parse(URL url) throws XmlException, IOException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(url, NumFacet.type, (XmlOptions) null);
        }

        public static NumFacet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(url, NumFacet.type, xmlOptions);
        }

        public static NumFacet parse(InputStream inputStream) throws XmlException, IOException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(inputStream, NumFacet.type, (XmlOptions) null);
        }

        public static NumFacet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(inputStream, NumFacet.type, xmlOptions);
        }

        public static NumFacet parse(Reader reader) throws XmlException, IOException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(reader, NumFacet.type, (XmlOptions) null);
        }

        public static NumFacet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(reader, NumFacet.type, xmlOptions);
        }

        public static NumFacet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NumFacet.type, (XmlOptions) null);
        }

        public static NumFacet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NumFacet.type, xmlOptions);
        }

        public static NumFacet parse(Node node) throws XmlException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(node, NumFacet.type, (XmlOptions) null);
        }

        public static NumFacet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(node, NumFacet.type, xmlOptions);
        }

        public static NumFacet parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NumFacet.type, (XmlOptions) null);
        }

        public static NumFacet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (NumFacet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NumFacet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NumFacet.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NumFacet.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
