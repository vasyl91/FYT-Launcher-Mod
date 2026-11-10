package org.apache.xmlbeans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface XmlBoolean extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_boolean");

    boolean booleanValue();

    boolean getBooleanValue();

    void set(boolean z);

    void setBooleanValue(boolean z);

    public static final class Factory {
        public static XmlBoolean newInstance() {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().newInstance(XmlBoolean.type, null);
        }

        public static XmlBoolean newInstance(XmlOptions xmlOptions) {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().newInstance(XmlBoolean.type, xmlOptions);
        }

        public static XmlBoolean newValue(Object obj) {
            return (XmlBoolean) XmlBoolean.type.newValue(obj);
        }

        public static XmlBoolean parse(String str) throws XmlException {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(str, XmlBoolean.type, (XmlOptions) null);
        }

        public static XmlBoolean parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(str, XmlBoolean.type, xmlOptions);
        }

        public static XmlBoolean parse(File file) throws XmlException, IOException {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(file, XmlBoolean.type, (XmlOptions) null);
        }

        public static XmlBoolean parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(file, XmlBoolean.type, xmlOptions);
        }

        public static XmlBoolean parse(URL url) throws XmlException, IOException {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(url, XmlBoolean.type, (XmlOptions) null);
        }

        public static XmlBoolean parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(url, XmlBoolean.type, xmlOptions);
        }

        public static XmlBoolean parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(inputStream, XmlBoolean.type, (XmlOptions) null);
        }

        public static XmlBoolean parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(inputStream, XmlBoolean.type, xmlOptions);
        }

        public static XmlBoolean parse(Reader reader) throws XmlException, IOException {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(reader, XmlBoolean.type, (XmlOptions) null);
        }

        public static XmlBoolean parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(reader, XmlBoolean.type, xmlOptions);
        }

        public static XmlBoolean parse(Node node) throws XmlException {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(node, XmlBoolean.type, (XmlOptions) null);
        }

        public static XmlBoolean parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(node, XmlBoolean.type, xmlOptions);
        }

        public static XmlBoolean parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlBoolean.type, (XmlOptions) null);
        }

        public static XmlBoolean parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlBoolean.type, xmlOptions);
        }

        public static XmlBoolean parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlBoolean.type, (XmlOptions) null);
        }

        public static XmlBoolean parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlBoolean.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlBoolean.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlBoolean.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
