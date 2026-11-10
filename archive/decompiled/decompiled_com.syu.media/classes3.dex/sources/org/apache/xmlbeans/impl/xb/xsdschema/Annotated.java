package org.apache.xmlbeans.impl.xb.xsdschema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface Annotated extends OpenAttrs {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Annotated.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("annotateda52dtype");

    AnnotationDocument.Annotation addNewAnnotation();

    AnnotationDocument.Annotation getAnnotation();

    String getId();

    boolean isSetAnnotation();

    boolean isSetId();

    void setAnnotation(AnnotationDocument.Annotation annotation);

    void setId(String str);

    void unsetAnnotation();

    void unsetId();

    XmlID xgetId();

    void xsetId(XmlID xmlID);

    public static final class Factory {
        public static Annotated newInstance() {
            return (Annotated) XmlBeans.getContextTypeLoader().newInstance(Annotated.type, (XmlOptions) null);
        }

        public static Annotated newInstance(XmlOptions xmlOptions) {
            return (Annotated) XmlBeans.getContextTypeLoader().newInstance(Annotated.type, xmlOptions);
        }

        public static Annotated parse(String str) throws XmlException {
            return (Annotated) XmlBeans.getContextTypeLoader().parse(str, Annotated.type, (XmlOptions) null);
        }

        public static Annotated parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (Annotated) XmlBeans.getContextTypeLoader().parse(str, Annotated.type, xmlOptions);
        }

        public static Annotated parse(File file) throws XmlException, IOException {
            return (Annotated) XmlBeans.getContextTypeLoader().parse(file, Annotated.type, (XmlOptions) null);
        }

        public static Annotated parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Annotated) XmlBeans.getContextTypeLoader().parse(file, Annotated.type, xmlOptions);
        }

        public static Annotated parse(URL url) throws XmlException, IOException {
            return (Annotated) XmlBeans.getContextTypeLoader().parse(url, Annotated.type, (XmlOptions) null);
        }

        public static Annotated parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Annotated) XmlBeans.getContextTypeLoader().parse(url, Annotated.type, xmlOptions);
        }

        public static Annotated parse(InputStream inputStream) throws XmlException, IOException {
            return (Annotated) XmlBeans.getContextTypeLoader().parse(inputStream, Annotated.type, (XmlOptions) null);
        }

        public static Annotated parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Annotated) XmlBeans.getContextTypeLoader().parse(inputStream, Annotated.type, xmlOptions);
        }

        public static Annotated parse(Reader reader) throws XmlException, IOException {
            return (Annotated) XmlBeans.getContextTypeLoader().parse(reader, Annotated.type, (XmlOptions) null);
        }

        public static Annotated parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Annotated) XmlBeans.getContextTypeLoader().parse(reader, Annotated.type, xmlOptions);
        }

        public static Annotated parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (Annotated) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Annotated.type, (XmlOptions) null);
        }

        public static Annotated parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (Annotated) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Annotated.type, xmlOptions);
        }

        public static Annotated parse(Node node) throws XmlException {
            return (Annotated) XmlBeans.getContextTypeLoader().parse(node, Annotated.type, (XmlOptions) null);
        }

        public static Annotated parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (Annotated) XmlBeans.getContextTypeLoader().parse(node, Annotated.type, xmlOptions);
        }

        public static Annotated parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (Annotated) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Annotated.type, (XmlOptions) null);
        }

        public static Annotated parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (Annotated) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Annotated.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Annotated.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Annotated.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
