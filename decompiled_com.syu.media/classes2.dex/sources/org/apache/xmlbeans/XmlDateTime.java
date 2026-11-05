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
public interface XmlDateTime extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_dateTime");

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
        public static XmlDateTime newInstance() {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().newInstance(XmlDateTime.type, null);
        }

        public static XmlDateTime newInstance(XmlOptions xmlOptions) {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().newInstance(XmlDateTime.type, xmlOptions);
        }

        public static XmlDateTime newValue(Object obj) {
            return (XmlDateTime) XmlDateTime.type.newValue(obj);
        }

        public static XmlDateTime parse(String str) throws XmlException {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(str, XmlDateTime.type, (XmlOptions) null);
        }

        public static XmlDateTime parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(str, XmlDateTime.type, xmlOptions);
        }

        public static XmlDateTime parse(File file) throws XmlException, IOException {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(file, XmlDateTime.type, (XmlOptions) null);
        }

        public static XmlDateTime parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(file, XmlDateTime.type, xmlOptions);
        }

        public static XmlDateTime parse(URL url) throws XmlException, IOException {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(url, XmlDateTime.type, (XmlOptions) null);
        }

        public static XmlDateTime parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(url, XmlDateTime.type, xmlOptions);
        }

        public static XmlDateTime parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDateTime.type, (XmlOptions) null);
        }

        public static XmlDateTime parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDateTime.type, xmlOptions);
        }

        public static XmlDateTime parse(Reader reader) throws XmlException, IOException {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(reader, XmlDateTime.type, (XmlOptions) null);
        }

        public static XmlDateTime parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(reader, XmlDateTime.type, xmlOptions);
        }

        public static XmlDateTime parse(Node node) throws XmlException {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(node, XmlDateTime.type, (XmlOptions) null);
        }

        public static XmlDateTime parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(node, XmlDateTime.type, xmlOptions);
        }

        public static XmlDateTime parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDateTime.type, (XmlOptions) null);
        }

        public static XmlDateTime parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDateTime.type, xmlOptions);
        }

        public static XmlDateTime parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDateTime.type, (XmlOptions) null);
        }

        public static XmlDateTime parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDateTime.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDateTime.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDateTime.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
