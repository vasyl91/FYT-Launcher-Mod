package org.apache.xmlbeans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface XmlTime extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_time");

    Calendar calendarValue();

    GDate gDateValue();

    Calendar getCalendarValue();

    GDate getGDateValue();

    void set(Calendar calendar);

    void set(GDateSpecification gDateSpecification);

    void setCalendarValue(Calendar calendar);

    void setGDateValue(GDate gDate);

    public static final class Factory {
        public static XmlTime newInstance() {
            return (XmlTime) XmlBeans.getContextTypeLoader().newInstance(XmlTime.type, null);
        }

        public static XmlTime newInstance(XmlOptions xmlOptions) {
            return (XmlTime) XmlBeans.getContextTypeLoader().newInstance(XmlTime.type, xmlOptions);
        }

        public static XmlTime newValue(Object obj) {
            return (XmlTime) XmlTime.type.newValue(obj);
        }

        public static XmlTime parse(String str) throws XmlException {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(str, XmlTime.type, (XmlOptions) null);
        }

        public static XmlTime parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(str, XmlTime.type, xmlOptions);
        }

        public static XmlTime parse(File file) throws XmlException, IOException {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(file, XmlTime.type, (XmlOptions) null);
        }

        public static XmlTime parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(file, XmlTime.type, xmlOptions);
        }

        public static XmlTime parse(URL url) throws XmlException, IOException {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(url, XmlTime.type, (XmlOptions) null);
        }

        public static XmlTime parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(url, XmlTime.type, xmlOptions);
        }

        public static XmlTime parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(inputStream, XmlTime.type, (XmlOptions) null);
        }

        public static XmlTime parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(inputStream, XmlTime.type, xmlOptions);
        }

        public static XmlTime parse(Reader reader) throws XmlException, IOException {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(reader, XmlTime.type, (XmlOptions) null);
        }

        public static XmlTime parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(reader, XmlTime.type, xmlOptions);
        }

        public static XmlTime parse(Node node) throws XmlException {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(node, XmlTime.type, (XmlOptions) null);
        }

        public static XmlTime parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(node, XmlTime.type, xmlOptions);
        }

        public static XmlTime parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlTime.type, (XmlOptions) null);
        }

        public static XmlTime parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlTime.type, xmlOptions);
        }

        public static XmlTime parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlTime.type, (XmlOptions) null);
        }

        public static XmlTime parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlTime.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlTime.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlTime.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
