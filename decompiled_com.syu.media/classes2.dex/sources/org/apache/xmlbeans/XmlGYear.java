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
public interface XmlGYear extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_gYear");

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
        public static XmlGYear newInstance() {
            return (XmlGYear) XmlBeans.getContextTypeLoader().newInstance(XmlGYear.type, null);
        }

        public static XmlGYear newInstance(XmlOptions xmlOptions) {
            return (XmlGYear) XmlBeans.getContextTypeLoader().newInstance(XmlGYear.type, xmlOptions);
        }

        public static XmlGYear newValue(Object obj) {
            return (XmlGYear) XmlGYear.type.newValue(obj);
        }

        public static XmlGYear parse(String str) throws XmlException {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(str, XmlGYear.type, (XmlOptions) null);
        }

        public static XmlGYear parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(str, XmlGYear.type, xmlOptions);
        }

        public static XmlGYear parse(File file) throws XmlException, IOException {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(file, XmlGYear.type, (XmlOptions) null);
        }

        public static XmlGYear parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(file, XmlGYear.type, xmlOptions);
        }

        public static XmlGYear parse(URL url) throws XmlException, IOException {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(url, XmlGYear.type, (XmlOptions) null);
        }

        public static XmlGYear parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(url, XmlGYear.type, xmlOptions);
        }

        public static XmlGYear parse(InputStream inputStream) throws XmlException, IOException {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGYear.type, (XmlOptions) null);
        }

        public static XmlGYear parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGYear.type, xmlOptions);
        }

        public static XmlGYear parse(Reader reader) throws XmlException, IOException {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(reader, XmlGYear.type, (XmlOptions) null);
        }

        public static XmlGYear parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(reader, XmlGYear.type, xmlOptions);
        }

        public static XmlGYear parse(Node node) throws XmlException {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(node, XmlGYear.type, (XmlOptions) null);
        }

        public static XmlGYear parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(node, XmlGYear.type, xmlOptions);
        }

        public static XmlGYear parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGYear.type, (XmlOptions) null);
        }

        public static XmlGYear parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGYear.type, xmlOptions);
        }

        public static XmlGYear parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGYear.type, (XmlOptions) null);
        }

        public static XmlGYear parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGYear.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGYear.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGYear.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
