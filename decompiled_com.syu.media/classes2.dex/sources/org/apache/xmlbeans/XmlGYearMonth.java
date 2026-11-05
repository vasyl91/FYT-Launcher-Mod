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
public interface XmlGYearMonth extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_gYearMonth");

    Calendar calendarValue();

    GDate gDateValue();

    Calendar getCalendarValue();

    GDate getGDateValue();

    void set(Calendar calendar);

    void set(GDateSpecification gDateSpecification);

    void setCalendarValue(Calendar calendar);

    void setGDateValue(GDate gDate);

    public static final class Factory {
        public static XmlGYearMonth newInstance() {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().newInstance(XmlGYearMonth.type, null);
        }

        public static XmlGYearMonth newInstance(XmlOptions xmlOptions) {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().newInstance(XmlGYearMonth.type, xmlOptions);
        }

        public static XmlGYearMonth newValue(Object obj) {
            return (XmlGYearMonth) XmlGYearMonth.type.newValue(obj);
        }

        public static XmlGYearMonth parse(String str) throws XmlException {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(str, XmlGYearMonth.type, (XmlOptions) null);
        }

        public static XmlGYearMonth parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(str, XmlGYearMonth.type, xmlOptions);
        }

        public static XmlGYearMonth parse(File file) throws XmlException, IOException {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(file, XmlGYearMonth.type, (XmlOptions) null);
        }

        public static XmlGYearMonth parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(file, XmlGYearMonth.type, xmlOptions);
        }

        public static XmlGYearMonth parse(URL url) throws XmlException, IOException {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(url, XmlGYearMonth.type, (XmlOptions) null);
        }

        public static XmlGYearMonth parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(url, XmlGYearMonth.type, xmlOptions);
        }

        public static XmlGYearMonth parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGYearMonth.type, (XmlOptions) null);
        }

        public static XmlGYearMonth parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGYearMonth.type, xmlOptions);
        }

        public static XmlGYearMonth parse(Reader reader) throws XmlException, IOException {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(reader, XmlGYearMonth.type, (XmlOptions) null);
        }

        public static XmlGYearMonth parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(reader, XmlGYearMonth.type, xmlOptions);
        }

        public static XmlGYearMonth parse(Node node) throws XmlException {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(node, XmlGYearMonth.type, (XmlOptions) null);
        }

        public static XmlGYearMonth parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(node, XmlGYearMonth.type, xmlOptions);
        }

        public static XmlGYearMonth parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGYearMonth.type, (XmlOptions) null);
        }

        public static XmlGYearMonth parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGYearMonth.type, xmlOptions);
        }

        public static XmlGYearMonth parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGYearMonth.type, (XmlOptions) null);
        }

        public static XmlGYearMonth parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGYearMonth.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGYearMonth.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGYearMonth.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
