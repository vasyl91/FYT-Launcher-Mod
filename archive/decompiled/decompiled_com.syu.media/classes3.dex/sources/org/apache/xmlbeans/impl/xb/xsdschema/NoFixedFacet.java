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
public interface NoFixedFacet extends Facet {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(NoFixedFacet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("nofixedfacet250ftype");

    public static final class Factory {
        public static NoFixedFacet newInstance() {
            return (NoFixedFacet) XmlBeans.getContextTypeLoader().newInstance(NoFixedFacet.type, (XmlOptions) null);
        }

        public static NoFixedFacet newInstance(XmlOptions xmlOptions) {
            return (NoFixedFacet) XmlBeans.getContextTypeLoader().newInstance(NoFixedFacet.type, xmlOptions);
        }

        public static NoFixedFacet parse(String str) throws XmlException {
            return (NoFixedFacet) XmlBeans.getContextTypeLoader().parse(str, NoFixedFacet.type, (XmlOptions) null);
        }

        public static NoFixedFacet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (NoFixedFacet) XmlBeans.getContextTypeLoader().parse(str, NoFixedFacet.type, xmlOptions);
        }

        public static NoFixedFacet parse(File file) throws XmlException, IOException {
            return (NoFixedFacet) XmlBeans.getContextTypeLoader().parse(file, NoFixedFacet.type, (XmlOptions) null);
        }

        public static NoFixedFacet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NoFixedFacet) XmlBeans.getContextTypeLoader().parse(file, NoFixedFacet.type, xmlOptions);
        }

        public static NoFixedFacet parse(URL url) throws XmlException, IOException {
            return (NoFixedFacet) XmlBeans.getContextTypeLoader().parse(url, NoFixedFacet.type, (XmlOptions) null);
        }

        public static NoFixedFacet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NoFixedFacet) XmlBeans.getContextTypeLoader().parse(url, NoFixedFacet.type, xmlOptions);
        }

        public static NoFixedFacet parse(InputStream inputStream) throws XmlException, IOException {
            return (NoFixedFacet) XmlBeans.getContextTypeLoader().parse(inputStream, NoFixedFacet.type, (XmlOptions) null);
        }

        public static NoFixedFacet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NoFixedFacet) XmlBeans.getContextTypeLoader().parse(inputStream, NoFixedFacet.type, xmlOptions);
        }

        public static NoFixedFacet parse(Reader reader) throws XmlException, IOException {
            return (NoFixedFacet) XmlBeans.getContextTypeLoader().parse(reader, NoFixedFacet.type, (XmlOptions) null);
        }

        public static NoFixedFacet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NoFixedFacet) XmlBeans.getContextTypeLoader().parse(reader, NoFixedFacet.type, xmlOptions);
        }

        public static NoFixedFacet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (NoFixedFacet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NoFixedFacet.type, (XmlOptions) null);
        }

        public static NoFixedFacet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (NoFixedFacet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NoFixedFacet.type, xmlOptions);
        }

        public static NoFixedFacet parse(Node node) throws XmlException {
            return (NoFixedFacet) XmlBeans.getContextTypeLoader().parse(node, NoFixedFacet.type, (XmlOptions) null);
        }

        public static NoFixedFacet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (NoFixedFacet) XmlBeans.getContextTypeLoader().parse(node, NoFixedFacet.type, xmlOptions);
        }

        public static NoFixedFacet parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (NoFixedFacet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NoFixedFacet.type, (XmlOptions) null);
        }

        public static NoFixedFacet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (NoFixedFacet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NoFixedFacet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NoFixedFacet.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NoFixedFacet.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
