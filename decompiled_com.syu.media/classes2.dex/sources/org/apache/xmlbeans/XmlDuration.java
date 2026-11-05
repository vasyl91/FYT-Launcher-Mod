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
public interface XmlDuration extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_duration");

    GDuration gDurationValue();

    GDuration getGDurationValue();

    void set(GDurationSpecification gDurationSpecification);

    void setGDurationValue(GDuration gDuration);

    public static final class Factory {
        public static XmlDuration newInstance() {
            return (XmlDuration) XmlBeans.getContextTypeLoader().newInstance(XmlDuration.type, null);
        }

        public static XmlDuration newInstance(XmlOptions xmlOptions) {
            return (XmlDuration) XmlBeans.getContextTypeLoader().newInstance(XmlDuration.type, xmlOptions);
        }

        public static XmlDuration newValue(Object obj) {
            return (XmlDuration) XmlDuration.type.newValue(obj);
        }

        public static XmlDuration parse(String str) throws XmlException {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(str, XmlDuration.type, (XmlOptions) null);
        }

        public static XmlDuration parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(str, XmlDuration.type, xmlOptions);
        }

        public static XmlDuration parse(File file) throws XmlException, IOException {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(file, XmlDuration.type, (XmlOptions) null);
        }

        public static XmlDuration parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(file, XmlDuration.type, xmlOptions);
        }

        public static XmlDuration parse(URL url) throws XmlException, IOException {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(url, XmlDuration.type, (XmlOptions) null);
        }

        public static XmlDuration parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(url, XmlDuration.type, xmlOptions);
        }

        public static XmlDuration parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDuration.type, (XmlOptions) null);
        }

        public static XmlDuration parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDuration.type, xmlOptions);
        }

        public static XmlDuration parse(Reader reader) throws XmlException, IOException {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(reader, XmlDuration.type, (XmlOptions) null);
        }

        public static XmlDuration parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(reader, XmlDuration.type, xmlOptions);
        }

        public static XmlDuration parse(Node node) throws XmlException {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(node, XmlDuration.type, (XmlOptions) null);
        }

        public static XmlDuration parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(node, XmlDuration.type, xmlOptions);
        }

        public static XmlDuration parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDuration.type, (XmlOptions) null);
        }

        public static XmlDuration parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDuration.type, xmlOptions);
        }

        public static XmlDuration parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDuration.type, (XmlOptions) null);
        }

        public static XmlDuration parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDuration.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDuration.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDuration.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
