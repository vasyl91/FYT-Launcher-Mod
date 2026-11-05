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
public interface ChoiceDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(ChoiceDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("choicedf82doctype");

    ExplicitGroup addNewChoice();

    ExplicitGroup getChoice();

    void setChoice(ExplicitGroup explicitGroup);

    public static final class Factory {
        public static ChoiceDocument newInstance() {
            return (ChoiceDocument) XmlBeans.getContextTypeLoader().newInstance(ChoiceDocument.type, (XmlOptions) null);
        }

        public static ChoiceDocument newInstance(XmlOptions xmlOptions) {
            return (ChoiceDocument) XmlBeans.getContextTypeLoader().newInstance(ChoiceDocument.type, xmlOptions);
        }

        public static ChoiceDocument parse(String str) throws XmlException {
            return (ChoiceDocument) XmlBeans.getContextTypeLoader().parse(str, ChoiceDocument.type, (XmlOptions) null);
        }

        public static ChoiceDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ChoiceDocument) XmlBeans.getContextTypeLoader().parse(str, ChoiceDocument.type, xmlOptions);
        }

        public static ChoiceDocument parse(File file) throws XmlException, IOException {
            return (ChoiceDocument) XmlBeans.getContextTypeLoader().parse(file, ChoiceDocument.type, (XmlOptions) null);
        }

        public static ChoiceDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ChoiceDocument) XmlBeans.getContextTypeLoader().parse(file, ChoiceDocument.type, xmlOptions);
        }

        public static ChoiceDocument parse(URL url) throws XmlException, IOException {
            return (ChoiceDocument) XmlBeans.getContextTypeLoader().parse(url, ChoiceDocument.type, (XmlOptions) null);
        }

        public static ChoiceDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ChoiceDocument) XmlBeans.getContextTypeLoader().parse(url, ChoiceDocument.type, xmlOptions);
        }

        public static ChoiceDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (ChoiceDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ChoiceDocument.type, (XmlOptions) null);
        }

        public static ChoiceDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ChoiceDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ChoiceDocument.type, xmlOptions);
        }

        public static ChoiceDocument parse(Reader reader) throws XmlException, IOException {
            return (ChoiceDocument) XmlBeans.getContextTypeLoader().parse(reader, ChoiceDocument.type, (XmlOptions) null);
        }

        public static ChoiceDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ChoiceDocument) XmlBeans.getContextTypeLoader().parse(reader, ChoiceDocument.type, xmlOptions);
        }

        public static ChoiceDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ChoiceDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ChoiceDocument.type, (XmlOptions) null);
        }

        public static ChoiceDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ChoiceDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ChoiceDocument.type, xmlOptions);
        }

        public static ChoiceDocument parse(Node node) throws XmlException {
            return (ChoiceDocument) XmlBeans.getContextTypeLoader().parse(node, ChoiceDocument.type, (XmlOptions) null);
        }

        public static ChoiceDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ChoiceDocument) XmlBeans.getContextTypeLoader().parse(node, ChoiceDocument.type, xmlOptions);
        }

        public static ChoiceDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (ChoiceDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ChoiceDocument.type, (XmlOptions) null);
        }

        public static ChoiceDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (ChoiceDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ChoiceDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ChoiceDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ChoiceDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
