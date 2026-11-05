package org.apache.xmlbeans.impl.xb.xsdschema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface RedefineDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(RedefineDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("redefine3f55doctype");

    Redefine addNewRedefine();

    Redefine getRedefine();

    void setRedefine(Redefine redefine);

    public interface Redefine extends OpenAttrs {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Redefine.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("redefine9e9felemtype");

        AnnotationDocument.Annotation addNewAnnotation();

        NamedAttributeGroup addNewAttributeGroup();

        TopLevelComplexType addNewComplexType();

        NamedGroup addNewGroup();

        TopLevelSimpleType addNewSimpleType();

        AnnotationDocument.Annotation getAnnotationArray(int i);

        AnnotationDocument.Annotation[] getAnnotationArray();

        NamedAttributeGroup getAttributeGroupArray(int i);

        NamedAttributeGroup[] getAttributeGroupArray();

        TopLevelComplexType getComplexTypeArray(int i);

        TopLevelComplexType[] getComplexTypeArray();

        NamedGroup getGroupArray(int i);

        NamedGroup[] getGroupArray();

        String getId();

        String getSchemaLocation();

        TopLevelSimpleType getSimpleTypeArray(int i);

        TopLevelSimpleType[] getSimpleTypeArray();

        AnnotationDocument.Annotation insertNewAnnotation(int i);

        NamedAttributeGroup insertNewAttributeGroup(int i);

        TopLevelComplexType insertNewComplexType(int i);

        NamedGroup insertNewGroup(int i);

        TopLevelSimpleType insertNewSimpleType(int i);

        boolean isSetId();

        void removeAnnotation(int i);

        void removeAttributeGroup(int i);

        void removeComplexType(int i);

        void removeGroup(int i);

        void removeSimpleType(int i);

        void setAnnotationArray(int i, AnnotationDocument.Annotation annotation);

        void setAnnotationArray(AnnotationDocument.Annotation[] annotationArr);

        void setAttributeGroupArray(int i, NamedAttributeGroup namedAttributeGroup);

        void setAttributeGroupArray(NamedAttributeGroup[] namedAttributeGroupArr);

        void setComplexTypeArray(int i, TopLevelComplexType topLevelComplexType);

        void setComplexTypeArray(TopLevelComplexType[] topLevelComplexTypeArr);

        void setGroupArray(int i, NamedGroup namedGroup);

        void setGroupArray(NamedGroup[] namedGroupArr);

        void setId(String str);

        void setSchemaLocation(String str);

        void setSimpleTypeArray(int i, TopLevelSimpleType topLevelSimpleType);

        void setSimpleTypeArray(TopLevelSimpleType[] topLevelSimpleTypeArr);

        int sizeOfAnnotationArray();

        int sizeOfAttributeGroupArray();

        int sizeOfComplexTypeArray();

        int sizeOfGroupArray();

        int sizeOfSimpleTypeArray();

        void unsetId();

        XmlID xgetId();

        XmlAnyURI xgetSchemaLocation();

        void xsetId(XmlID xmlID);

        void xsetSchemaLocation(XmlAnyURI xmlAnyURI);

        public static final class Factory {
            public static Redefine newInstance() {
                return (Redefine) XmlBeans.getContextTypeLoader().newInstance(Redefine.type, (XmlOptions) null);
            }

            public static Redefine newInstance(XmlOptions xmlOptions) {
                return (Redefine) XmlBeans.getContextTypeLoader().newInstance(Redefine.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static RedefineDocument newInstance() {
            return (RedefineDocument) XmlBeans.getContextTypeLoader().newInstance(RedefineDocument.type, (XmlOptions) null);
        }

        public static RedefineDocument newInstance(XmlOptions xmlOptions) {
            return (RedefineDocument) XmlBeans.getContextTypeLoader().newInstance(RedefineDocument.type, xmlOptions);
        }

        public static RedefineDocument parse(String str) throws XmlException {
            return (RedefineDocument) XmlBeans.getContextTypeLoader().parse(str, RedefineDocument.type, (XmlOptions) null);
        }

        public static RedefineDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (RedefineDocument) XmlBeans.getContextTypeLoader().parse(str, RedefineDocument.type, xmlOptions);
        }

        public static RedefineDocument parse(File file) throws XmlException, IOException {
            return (RedefineDocument) XmlBeans.getContextTypeLoader().parse(file, RedefineDocument.type, (XmlOptions) null);
        }

        public static RedefineDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RedefineDocument) XmlBeans.getContextTypeLoader().parse(file, RedefineDocument.type, xmlOptions);
        }

        public static RedefineDocument parse(URL url) throws XmlException, IOException {
            return (RedefineDocument) XmlBeans.getContextTypeLoader().parse(url, RedefineDocument.type, (XmlOptions) null);
        }

        public static RedefineDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RedefineDocument) XmlBeans.getContextTypeLoader().parse(url, RedefineDocument.type, xmlOptions);
        }

        public static RedefineDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (RedefineDocument) XmlBeans.getContextTypeLoader().parse(inputStream, RedefineDocument.type, (XmlOptions) null);
        }

        public static RedefineDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RedefineDocument) XmlBeans.getContextTypeLoader().parse(inputStream, RedefineDocument.type, xmlOptions);
        }

        public static RedefineDocument parse(Reader reader) throws XmlException, IOException {
            return (RedefineDocument) XmlBeans.getContextTypeLoader().parse(reader, RedefineDocument.type, (XmlOptions) null);
        }

        public static RedefineDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RedefineDocument) XmlBeans.getContextTypeLoader().parse(reader, RedefineDocument.type, xmlOptions);
        }

        public static RedefineDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (RedefineDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, RedefineDocument.type, (XmlOptions) null);
        }

        public static RedefineDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (RedefineDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, RedefineDocument.type, xmlOptions);
        }

        public static RedefineDocument parse(Node node) throws XmlException {
            return (RedefineDocument) XmlBeans.getContextTypeLoader().parse(node, RedefineDocument.type, (XmlOptions) null);
        }

        public static RedefineDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (RedefineDocument) XmlBeans.getContextTypeLoader().parse(node, RedefineDocument.type, xmlOptions);
        }

        public static RedefineDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (RedefineDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, RedefineDocument.type, (XmlOptions) null);
        }

        public static RedefineDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (RedefineDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, RedefineDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, RedefineDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, RedefineDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
