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
public interface XmlGMonth extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_gMonth");

    Calendar calendarValue();

    GDate gDateValue();

    Calendar getCalendarValue();

    GDate getGDateValue();

    int getIntValue();

    int intValue();

    void set(int i);

    void set(Calendar calendar);

    void set(GDateSpecification gDateSpecification);

    void setCalendarValue(Calendar calendar);

    void setGDateValue(GDate gDate);

    void setIntValue(int i);

    public static final class Factory {
        public static XmlGMonth newInstance() {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().newInstance(XmlGMonth.type, null);
        }

        public static XmlGMonth newInstance(XmlOptions xmlOptions) {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().newInstance(XmlGMonth.type, xmlOptions);
        }

        public static XmlGMonth newValue(Object obj) {
            return (XmlGMonth) XmlGMonth.type.newValue(obj);
        }

        public static XmlGMonth parse(String str) throws XmlException {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(str, XmlGMonth.type, (XmlOptions) null);
        }

        public static XmlGMonth parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(str, XmlGMonth.type, xmlOptions);
        }

        public static XmlGMonth parse(File file) throws XmlException, IOException {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(file, XmlGMonth.type, (XmlOptions) null);
        }

        public static XmlGMonth parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(file, XmlGMonth.type, xmlOptions);
        }

        public static XmlGMonth parse(URL url) throws XmlException, IOException {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(url, XmlGMonth.type, (XmlOptions) null);
        }

        public static XmlGMonth parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(url, XmlGMonth.type, xmlOptions);
        }

        public static XmlGMonth parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGMonth.type, (XmlOptions) null);
        }

        public static XmlGMonth parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGMonth.type, xmlOptions);
        }

        public static XmlGMonth parse(Reader reader) throws XmlException, IOException {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(reader, XmlGMonth.type, (XmlOptions) null);
        }

        public static XmlGMonth parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(reader, XmlGMonth.type, xmlOptions);
        }

        public static XmlGMonth parse(Node node) throws XmlException {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(node, XmlGMonth.type, (XmlOptions) null);
        }

        public static XmlGMonth parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(node, XmlGMonth.type, xmlOptions);
        }

        public static XmlGMonth parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGMonth.type, (XmlOptions) null);
        }

        public static XmlGMonth parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGMonth.type, xmlOptions);
        }

        public static XmlGMonth parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGMonth.type, (XmlOptions) null);
        }

        public static XmlGMonth parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGMonth.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGMonth.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGMonth.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
