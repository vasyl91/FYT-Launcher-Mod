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
public interface Keybase extends Annotated {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Keybase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("keybase3955type");

    FieldDocument.Field addNewField();

    SelectorDocument.Selector addNewSelector();

    FieldDocument.Field getFieldArray(int i);

    FieldDocument.Field[] getFieldArray();

    String getName();

    SelectorDocument.Selector getSelector();

    FieldDocument.Field insertNewField(int i);

    void removeField(int i);

    void setFieldArray(int i, FieldDocument.Field field);

    void setFieldArray(FieldDocument.Field[] fieldArr);

    void setName(String str);

    void setSelector(SelectorDocument.Selector selector);

    int sizeOfFieldArray();

    XmlNCName xgetName();

    void xsetName(XmlNCName xmlNCName);

    public static final class Factory {
        public static Keybase newInstance() {
            return (Keybase) XmlBeans.getContextTypeLoader().newInstance(Keybase.type, (XmlOptions) null);
        }

        public static Keybase newInstance(XmlOptions xmlOptions) {
            return (Keybase) XmlBeans.getContextTypeLoader().newInstance(Keybase.type, xmlOptions);
        }

        public static Keybase parse(String str) throws XmlException {
            return (Keybase) XmlBeans.getContextTypeLoader().parse(str, Keybase.type, (XmlOptions) null);
        }

        public static Keybase parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (Keybase) XmlBeans.getContextTypeLoader().parse(str, Keybase.type, xmlOptions);
        }

        public static Keybase parse(File file) throws XmlException, IOException {
            return (Keybase) XmlBeans.getContextTypeLoader().parse(file, Keybase.type, (XmlOptions) null);
        }

        public static Keybase parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Keybase) XmlBeans.getContextTypeLoader().parse(file, Keybase.type, xmlOptions);
        }

        public static Keybase parse(URL url) throws XmlException, IOException {
            return (Keybase) XmlBeans.getContextTypeLoader().parse(url, Keybase.type, (XmlOptions) null);
        }

        public static Keybase parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Keybase) XmlBeans.getContextTypeLoader().parse(url, Keybase.type, xmlOptions);
        }

        public static Keybase parse(InputStream inputStream) throws XmlException, IOException {
            return (Keybase) XmlBeans.getContextTypeLoader().parse(inputStream, Keybase.type, (XmlOptions) null);
        }

        public static Keybase parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Keybase) XmlBeans.getContextTypeLoader().parse(inputStream, Keybase.type, xmlOptions);
        }

        public static Keybase parse(Reader reader) throws XmlException, IOException {
            return (Keybase) XmlBeans.getContextTypeLoader().parse(reader, Keybase.type, (XmlOptions) null);
        }

        public static Keybase parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Keybase) XmlBeans.getContextTypeLoader().parse(reader, Keybase.type, xmlOptions);
        }

        public static Keybase parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (Keybase) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Keybase.type, (XmlOptions) null);
        }

        public static Keybase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (Keybase) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Keybase.type, xmlOptions);
        }

        public static Keybase parse(Node node) throws XmlException {
            return (Keybase) XmlBeans.getContextTypeLoader().parse(node, Keybase.type, (XmlOptions) null);
        }

        public static Keybase parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (Keybase) XmlBeans.getContextTypeLoader().parse(node, Keybase.type, xmlOptions);
        }

        public static Keybase parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (Keybase) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Keybase.type, (XmlOptions) null);
        }

        public static Keybase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (Keybase) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Keybase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Keybase.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Keybase.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
