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
public interface XmlHexBinary extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_hexBinary");

    byte[] byteArrayValue();

    byte[] getByteArrayValue();

    void set(byte[] bArr);

    void setByteArrayValue(byte[] bArr);

    public static final class Factory {
        public static XmlHexBinary newInstance() {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().newInstance(XmlHexBinary.type, null);
        }

        public static XmlHexBinary newInstance(XmlOptions xmlOptions) {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().newInstance(XmlHexBinary.type, xmlOptions);
        }

        public static XmlHexBinary newValue(Object obj) {
            return (XmlHexBinary) XmlHexBinary.type.newValue(obj);
        }

        public static XmlHexBinary parse(String str) throws XmlException {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(str, XmlHexBinary.type, (XmlOptions) null);
        }

        public static XmlHexBinary parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(str, XmlHexBinary.type, xmlOptions);
        }

        public static XmlHexBinary parse(File file) throws XmlException, IOException {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(file, XmlHexBinary.type, (XmlOptions) null);
        }

        public static XmlHexBinary parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(file, XmlHexBinary.type, xmlOptions);
        }

        public static XmlHexBinary parse(URL url) throws XmlException, IOException {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(url, XmlHexBinary.type, (XmlOptions) null);
        }

        public static XmlHexBinary parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(url, XmlHexBinary.type, xmlOptions);
        }

        public static XmlHexBinary parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(inputStream, XmlHexBinary.type, (XmlOptions) null);
        }

        public static XmlHexBinary parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(inputStream, XmlHexBinary.type, xmlOptions);
        }

        public static XmlHexBinary parse(Reader reader) throws XmlException, IOException {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(reader, XmlHexBinary.type, (XmlOptions) null);
        }

        public static XmlHexBinary parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(reader, XmlHexBinary.type, xmlOptions);
        }

        public static XmlHexBinary parse(Node node) throws XmlException {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(node, XmlHexBinary.type, (XmlOptions) null);
        }

        public static XmlHexBinary parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(node, XmlHexBinary.type, xmlOptions);
        }

        public static XmlHexBinary parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlHexBinary.type, (XmlOptions) null);
        }

        public static XmlHexBinary parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlHexBinary.type, xmlOptions);
        }

        public static XmlHexBinary parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlHexBinary.type, (XmlOptions) null);
        }

        public static XmlHexBinary parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlHexBinary.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlHexBinary.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlHexBinary.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
