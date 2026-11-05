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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface AnnotationDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(AnnotationDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("annotationb034doctype");

    Annotation addNewAnnotation();

    Annotation getAnnotation();

    void setAnnotation(Annotation annotation);

    public interface Annotation extends OpenAttrs {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Annotation.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("annotation5abfelemtype");

        AppinfoDocument.Appinfo addNewAppinfo();

        DocumentationDocument.Documentation addNewDocumentation();

        AppinfoDocument.Appinfo getAppinfoArray(int i);

        AppinfoDocument.Appinfo[] getAppinfoArray();

        DocumentationDocument.Documentation getDocumentationArray(int i);

        DocumentationDocument.Documentation[] getDocumentationArray();

        String getId();

        AppinfoDocument.Appinfo insertNewAppinfo(int i);

        DocumentationDocument.Documentation insertNewDocumentation(int i);

        boolean isSetId();

        void removeAppinfo(int i);

        void removeDocumentation(int i);

        void setAppinfoArray(int i, AppinfoDocument.Appinfo appinfo);

        void setAppinfoArray(AppinfoDocument.Appinfo[] appinfoArr);

        void setDocumentationArray(int i, DocumentationDocument.Documentation documentation);

        void setDocumentationArray(DocumentationDocument.Documentation[] documentationArr);

        void setId(String str);

        int sizeOfAppinfoArray();

        int sizeOfDocumentationArray();

        void unsetId();

        XmlID xgetId();

        void xsetId(XmlID xmlID);

        public static final class Factory {
            public static Annotation newInstance() {
                return (Annotation) XmlBeans.getContextTypeLoader().newInstance(Annotation.type, (XmlOptions) null);
            }

            public static Annotation newInstance(XmlOptions xmlOptions) {
                return (Annotation) XmlBeans.getContextTypeLoader().newInstance(Annotation.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static AnnotationDocument newInstance() {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().newInstance(AnnotationDocument.type, (XmlOptions) null);
        }

        public static AnnotationDocument newInstance(XmlOptions xmlOptions) {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().newInstance(AnnotationDocument.type, xmlOptions);
        }

        public static AnnotationDocument parse(String str) throws XmlException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(str, AnnotationDocument.type, (XmlOptions) null);
        }

        public static AnnotationDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(str, AnnotationDocument.type, xmlOptions);
        }

        public static AnnotationDocument parse(File file) throws XmlException, IOException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(file, AnnotationDocument.type, (XmlOptions) null);
        }

        public static AnnotationDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(file, AnnotationDocument.type, xmlOptions);
        }

        public static AnnotationDocument parse(URL url) throws XmlException, IOException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(url, AnnotationDocument.type, (XmlOptions) null);
        }

        public static AnnotationDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(url, AnnotationDocument.type, xmlOptions);
        }

        public static AnnotationDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AnnotationDocument.type, (XmlOptions) null);
        }

        public static AnnotationDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AnnotationDocument.type, xmlOptions);
        }

        public static AnnotationDocument parse(Reader reader) throws XmlException, IOException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(reader, AnnotationDocument.type, (XmlOptions) null);
        }

        public static AnnotationDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(reader, AnnotationDocument.type, xmlOptions);
        }

        public static AnnotationDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AnnotationDocument.type, (XmlOptions) null);
        }

        public static AnnotationDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AnnotationDocument.type, xmlOptions);
        }

        public static AnnotationDocument parse(Node node) throws XmlException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(node, AnnotationDocument.type, (XmlOptions) null);
        }

        public static AnnotationDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(node, AnnotationDocument.type, xmlOptions);
        }

        public static AnnotationDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AnnotationDocument.type, (XmlOptions) null);
        }

        public static AnnotationDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (AnnotationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AnnotationDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AnnotationDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AnnotationDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
