package org.apache.xmlbeans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface XmlDate extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_date");

    Calendar calendarValue();

    Date dateValue();

    GDate gDateValue();

    Calendar getCalendarValue();

    Date getDateValue();

    GDate getGDateValue();

    void set(Calendar calendar);

    void set(Date date);

    void set(GDateSpecification gDateSpecification);

    void setCalendarValue(Calendar calendar);

    void setDateValue(Date date);

    void setGDateValue(GDate gDate);

    public static final class Factory {
        public static XmlDate newInstance() {
            return (XmlDate) XmlBeans.getContextTypeLoader().newInstance(XmlDate.type, null);
        }

        public static XmlDate newInstance(XmlOptions xmlOptions) {
            return (XmlDate) XmlBeans.getContextTypeLoader().newInstance(XmlDate.type, xmlOptions);
        }

        public static XmlDate newValue(Object obj) {
            return (XmlDate) XmlDate.type.newValue(obj);
        }

        public static XmlDate parse(String str) throws XmlException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(str, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(str, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(File file) throws XmlException, IOException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(file, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(file, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(URL url) throws XmlException, IOException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(url, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(url, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(Reader reader) throws XmlException, IOException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(reader, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(reader, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(Node node) throws XmlException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(node, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(node, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDate.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDate.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDate.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
