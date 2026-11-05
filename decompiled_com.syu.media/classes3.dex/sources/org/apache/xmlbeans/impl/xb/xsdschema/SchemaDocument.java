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
import org.apache.xmlbeans.XmlLanguage;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface SchemaDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SchemaDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("schema0782doctype");

    Schema addNewSchema();

    Schema getSchema();

    void setSchema(Schema schema);

    public interface Schema extends OpenAttrs {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Schema.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("schemad77felemtype");

        AnnotationDocument.Annotation addNewAnnotation();

        TopLevelAttribute addNewAttribute();

        NamedAttributeGroup addNewAttributeGroup();

        TopLevelComplexType addNewComplexType();

        TopLevelElement addNewElement();

        NamedGroup addNewGroup();

        ImportDocument.Import addNewImport();

        IncludeDocument.Include addNewInclude();

        NotationDocument.Notation addNewNotation();

        RedefineDocument.Redefine addNewRedefine();

        TopLevelSimpleType addNewSimpleType();

        AnnotationDocument.Annotation getAnnotationArray(int i);

        AnnotationDocument.Annotation[] getAnnotationArray();

        TopLevelAttribute getAttributeArray(int i);

        TopLevelAttribute[] getAttributeArray();

        FormChoice.Enum getAttributeFormDefault();

        NamedAttributeGroup getAttributeGroupArray(int i);

        NamedAttributeGroup[] getAttributeGroupArray();

        Object getBlockDefault();

        TopLevelComplexType getComplexTypeArray(int i);

        TopLevelComplexType[] getComplexTypeArray();

        TopLevelElement getElementArray(int i);

        TopLevelElement[] getElementArray();

        FormChoice.Enum getElementFormDefault();

        Object getFinalDefault();

        NamedGroup getGroupArray(int i);

        NamedGroup[] getGroupArray();

        String getId();

        ImportDocument.Import getImportArray(int i);

        ImportDocument.Import[] getImportArray();

        IncludeDocument.Include getIncludeArray(int i);

        IncludeDocument.Include[] getIncludeArray();

        String getLang();

        NotationDocument.Notation getNotationArray(int i);

        NotationDocument.Notation[] getNotationArray();

        RedefineDocument.Redefine getRedefineArray(int i);

        RedefineDocument.Redefine[] getRedefineArray();

        TopLevelSimpleType getSimpleTypeArray(int i);

        TopLevelSimpleType[] getSimpleTypeArray();

        String getTargetNamespace();

        String getVersion();

        AnnotationDocument.Annotation insertNewAnnotation(int i);

        TopLevelAttribute insertNewAttribute(int i);

        NamedAttributeGroup insertNewAttributeGroup(int i);

        TopLevelComplexType insertNewComplexType(int i);

        TopLevelElement insertNewElement(int i);

        NamedGroup insertNewGroup(int i);

        ImportDocument.Import insertNewImport(int i);

        IncludeDocument.Include insertNewInclude(int i);

        NotationDocument.Notation insertNewNotation(int i);

        RedefineDocument.Redefine insertNewRedefine(int i);

        TopLevelSimpleType insertNewSimpleType(int i);

        boolean isSetAttributeFormDefault();

        boolean isSetBlockDefault();

        boolean isSetElementFormDefault();

        boolean isSetFinalDefault();

        boolean isSetId();

        boolean isSetLang();

        boolean isSetTargetNamespace();

        boolean isSetVersion();

        void removeAnnotation(int i);

        void removeAttribute(int i);

        void removeAttributeGroup(int i);

        void removeComplexType(int i);

        void removeElement(int i);

        void removeGroup(int i);

        void removeImport(int i);

        void removeInclude(int i);

        void removeNotation(int i);

        void removeRedefine(int i);

        void removeSimpleType(int i);

        void setAnnotationArray(int i, AnnotationDocument.Annotation annotation);

        void setAnnotationArray(AnnotationDocument.Annotation[] annotationArr);

        void setAttributeArray(int i, TopLevelAttribute topLevelAttribute);

        void setAttributeArray(TopLevelAttribute[] topLevelAttributeArr);

        void setAttributeFormDefault(FormChoice.Enum r1);

        void setAttributeGroupArray(int i, NamedAttributeGroup namedAttributeGroup);

        void setAttributeGroupArray(NamedAttributeGroup[] namedAttributeGroupArr);

        void setBlockDefault(Object obj);

        void setComplexTypeArray(int i, TopLevelComplexType topLevelComplexType);

        void setComplexTypeArray(TopLevelComplexType[] topLevelComplexTypeArr);

        void setElementArray(int i, TopLevelElement topLevelElement);

        void setElementArray(TopLevelElement[] topLevelElementArr);

        void setElementFormDefault(FormChoice.Enum r1);

        void setFinalDefault(Object obj);

        void setGroupArray(int i, NamedGroup namedGroup);

        void setGroupArray(NamedGroup[] namedGroupArr);

        void setId(String str);

        void setImportArray(int i, ImportDocument.Import r2);

        void setImportArray(ImportDocument.Import[] importArr);

        void setIncludeArray(int i, IncludeDocument.Include include);

        void setIncludeArray(IncludeDocument.Include[] includeArr);

        void setLang(String str);

        void setNotationArray(int i, NotationDocument.Notation notation);

        void setNotationArray(NotationDocument.Notation[] notationArr);

        void setRedefineArray(int i, RedefineDocument.Redefine redefine);

        void setRedefineArray(RedefineDocument.Redefine[] redefineArr);

        void setSimpleTypeArray(int i, TopLevelSimpleType topLevelSimpleType);

        void setSimpleTypeArray(TopLevelSimpleType[] topLevelSimpleTypeArr);

        void setTargetNamespace(String str);

        void setVersion(String str);

        int sizeOfAnnotationArray();

        int sizeOfAttributeArray();

        int sizeOfAttributeGroupArray();

        int sizeOfComplexTypeArray();

        int sizeOfElementArray();

        int sizeOfGroupArray();

        int sizeOfImportArray();

        int sizeOfIncludeArray();

        int sizeOfNotationArray();

        int sizeOfRedefineArray();

        int sizeOfSimpleTypeArray();

        void unsetAttributeFormDefault();

        void unsetBlockDefault();

        void unsetElementFormDefault();

        void unsetFinalDefault();

        void unsetId();

        void unsetLang();

        void unsetTargetNamespace();

        void unsetVersion();

        FormChoice xgetAttributeFormDefault();

        BlockSet xgetBlockDefault();

        FormChoice xgetElementFormDefault();

        FullDerivationSet xgetFinalDefault();

        XmlID xgetId();

        XmlLanguage xgetLang();

        XmlAnyURI xgetTargetNamespace();

        XmlToken xgetVersion();

        void xsetAttributeFormDefault(FormChoice formChoice);

        void xsetBlockDefault(BlockSet blockSet);

        void xsetElementFormDefault(FormChoice formChoice);

        void xsetFinalDefault(FullDerivationSet fullDerivationSet);

        void xsetId(XmlID xmlID);

        void xsetLang(XmlLanguage xmlLanguage);

        void xsetTargetNamespace(XmlAnyURI xmlAnyURI);

        void xsetVersion(XmlToken xmlToken);

        public static final class Factory {
            public static Schema newInstance() {
                return (Schema) XmlBeans.getContextTypeLoader().newInstance(Schema.type, (XmlOptions) null);
            }

            public static Schema newInstance(XmlOptions xmlOptions) {
                return (Schema) XmlBeans.getContextTypeLoader().newInstance(Schema.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static SchemaDocument newInstance() {
            return (SchemaDocument) XmlBeans.getContextTypeLoader().newInstance(SchemaDocument.type, (XmlOptions) null);
        }

        public static SchemaDocument newInstance(XmlOptions xmlOptions) {
            return (SchemaDocument) XmlBeans.getContextTypeLoader().newInstance(SchemaDocument.type, xmlOptions);
        }

        public static SchemaDocument parse(String str) throws XmlException {
            return (SchemaDocument) XmlBeans.getContextTypeLoader().parse(str, SchemaDocument.type, (XmlOptions) null);
        }

        public static SchemaDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SchemaDocument) XmlBeans.getContextTypeLoader().parse(str, SchemaDocument.type, xmlOptions);
        }

        public static SchemaDocument parse(File file) throws XmlException, IOException {
            return (SchemaDocument) XmlBeans.getContextTypeLoader().parse(file, SchemaDocument.type, (XmlOptions) null);
        }

        public static SchemaDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SchemaDocument) XmlBeans.getContextTypeLoader().parse(file, SchemaDocument.type, xmlOptions);
        }

        public static SchemaDocument parse(URL url) throws XmlException, IOException {
            return (SchemaDocument) XmlBeans.getContextTypeLoader().parse(url, SchemaDocument.type, (XmlOptions) null);
        }

        public static SchemaDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SchemaDocument) XmlBeans.getContextTypeLoader().parse(url, SchemaDocument.type, xmlOptions);
        }

        public static SchemaDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SchemaDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SchemaDocument.type, (XmlOptions) null);
        }

        public static SchemaDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SchemaDocument) XmlBeans.getContextTypeLoader().parse(inputStream, SchemaDocument.type, xmlOptions);
        }

        public static SchemaDocument parse(Reader reader) throws XmlException, IOException {
            return (SchemaDocument) XmlBeans.getContextTypeLoader().parse(reader, SchemaDocument.type, (XmlOptions) null);
        }

        public static SchemaDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SchemaDocument) XmlBeans.getContextTypeLoader().parse(reader, SchemaDocument.type, xmlOptions);
        }

        public static SchemaDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SchemaDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SchemaDocument.type, (XmlOptions) null);
        }

        public static SchemaDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SchemaDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SchemaDocument.type, xmlOptions);
        }

        public static SchemaDocument parse(Node node) throws XmlException {
            return (SchemaDocument) XmlBeans.getContextTypeLoader().parse(node, SchemaDocument.type, (XmlOptions) null);
        }

        public static SchemaDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SchemaDocument) XmlBeans.getContextTypeLoader().parse(node, SchemaDocument.type, xmlOptions);
        }

        public static SchemaDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SchemaDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SchemaDocument.type, (XmlOptions) null);
        }

        public static SchemaDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SchemaDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SchemaDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SchemaDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SchemaDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
