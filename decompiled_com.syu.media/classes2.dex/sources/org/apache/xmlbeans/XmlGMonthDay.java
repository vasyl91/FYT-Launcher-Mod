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
public interface XmlGMonthDay extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_gMonthDay");

    Calendar calendarValue();

    GDate gDateValue();

    Calendar getCalendarValue();

    GDate getGDateValue();

    void set(Calendar calendar);

    void set(GDateSpecification gDateSpecification);

    void setCalendarValue(Calendar calendar);

    void setGDateValue(GDate gDate);

    public static final class Factory {
        public static XmlGMonthDay newInstance() {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().newInstance(XmlGMonthDay.type, null);
        }

        public static XmlGMonthDay newInstance(XmlOptions xmlOptions) {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().newInstance(XmlGMonthDay.type, xmlOptions);
        }

        public static XmlGMonthDay newValue(Object obj) {
            return (XmlGMonthDay) XmlGMonthDay.type.newValue(obj);
        }

        public static XmlGMonthDay parse(String str) throws XmlException {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(str, XmlGMonthDay.type, (XmlOptions) null);
        }

        public static XmlGMonthDay parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(str, XmlGMonthDay.type, xmlOptions);
        }

        public static XmlGMonthDay parse(File file) throws XmlException, IOException {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(file, XmlGMonthDay.type, (XmlOptions) null);
        }

        public static XmlGMonthDay parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(file, XmlGMonthDay.type, xmlOptions);
        }

        public static XmlGMonthDay parse(URL url) throws XmlException, IOException {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(url, XmlGMonthDay.type, (XmlOptions) null);
        }

        public static XmlGMonthDay parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(url, XmlGMonthDay.type, xmlOptions);
        }

        public static XmlGMonthDay parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGMonthDay.type, (XmlOptions) null);
        }

        public static XmlGMonthDay parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGMonthDay.type, xmlOptions);
        }

        public static XmlGMonthDay parse(Reader reader) throws XmlException, IOException {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(reader, XmlGMonthDay.type, (XmlOptions) null);
        }

        public static XmlGMonthDay parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(reader, XmlGMonthDay.type, xmlOptions);
        }

        public static XmlGMonthDay parse(Node node) throws XmlException {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(node, XmlGMonthDay.type, (XmlOptions) null);
        }

        public static XmlGMonthDay parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(node, XmlGMonthDay.type, xmlOptions);
        }

        public static XmlGMonthDay parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGMonthDay.type, (XmlOptions) null);
        }

        public static XmlGMonthDay parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGMonthDay.type, xmlOptions);
        }

        public static XmlGMonthDay parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGMonthDay.type, (XmlOptions) null);
        }

        public static XmlGMonthDay parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGMonthDay.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGMonthDay.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGMonthDay.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
