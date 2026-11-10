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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface SequenceDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SequenceDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("sequencecba2doctype");

    ExplicitGroup addNewSequence();

    ExplicitGroup getSequence();

    void setSequence(ExplicitGroup explicitGroup);

    public static final class Factory {
        public static SequenceDocument newInstance() {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().newInstance(SequenceDocument.type, (XmlOptions) null);
        }

        public static SequenceDocument newInstance(XmlOptions xmlOptions) {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().newInstance(SequenceDocument.type, xmlOptions);
        }

        public static SequenceDocument parse(String str) throws XmlException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(str, SequenceDocument.type, (XmlOptions) null);
        }

        public static SequenceDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(str, SequenceDocument.type, xmlOptions);
        }

        public static SequenceDocument parse(File file) throws XmlException, IOException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(file, SequenceDocument.type, (XmlOptions) null);
        }

        public static SequenceDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(file, SequenceDocument.type, xmlOptions);
        }

        public static SequenceDocument parse(URL url) throws XmlException, IOException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(url, SequenceDocument.type, (XmlOptions) null);
        }

        public static SequenceDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(url, SequenceDocument.type, xmlOptions);
        }

        public static SequenceDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SequenceDocument.type, (XmlOptions) null);
        }

        public static SequenceDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SequenceDocument.type, xmlOptions);
        }

        public static SequenceDocument parse(Reader reader) throws XmlException, IOException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(reader, SequenceDocument.type, (XmlOptions) null);
        }

        public static SequenceDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(reader, SequenceDocument.type, xmlOptions);
        }

        public static SequenceDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SequenceDocument.type, (XmlOptions) null);
        }

        public static SequenceDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SequenceDocument.type, xmlOptions);
        }

        public static SequenceDocument parse(Node node) throws XmlException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(node, SequenceDocument.type, (XmlOptions) null);
        }

        public static SequenceDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(node, SequenceDocument.type, xmlOptions);
        }

        public static SequenceDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SequenceDocument.type, (XmlOptions) null);
        }

        public static SequenceDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SequenceDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SequenceDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SequenceDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SequenceDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
