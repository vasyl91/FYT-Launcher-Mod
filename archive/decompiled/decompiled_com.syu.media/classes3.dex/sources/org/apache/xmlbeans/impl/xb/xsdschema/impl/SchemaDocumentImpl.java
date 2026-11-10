package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import java.util.ArrayList;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlLanguage;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.BlockSet;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.apache.xmlbeans.impl.xb.xsdschema.FullDerivationSet;
import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SchemaDocumentImpl extends XmlComplexContentImpl implements SchemaDocument {
    private static final QName SCHEMA$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "schema");
    private static final long serialVersionUID = 1;

    public SchemaDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument
    public SchemaDocument.Schema getSchema() {
        synchronized (monitor()) {
            check_orphaned();
            SchemaDocument.Schema schema = (SchemaDocument.Schema) get_store().find_element_user(SCHEMA$0, 0);
            if (schema == null) {
                return null;
            }
            return schema;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument
    public void setSchema(SchemaDocument.Schema schema) {
        generatedSetterHelperImpl(schema, SCHEMA$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument
    public SchemaDocument.Schema addNewSchema() {
        SchemaDocument.Schema schema;
        synchronized (monitor()) {
            check_orphaned();
            schema = (SchemaDocument.Schema) get_store().add_element_user(SCHEMA$0);
        }
        return schema;
    }

    public static class SchemaImpl extends OpenAttrsImpl implements SchemaDocument.Schema {
        private static final long serialVersionUID = 1;
        private static final QName INCLUDE$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "include");
        private static final QName IMPORT$2 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "import");
        private static final QName REDEFINE$4 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "redefine");
        private static final QName ANNOTATION$6 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, JamXmlElements.ANNOTATION);
        private static final QName SIMPLETYPE$8 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "simpleType");
        private static final QName COMPLEXTYPE$10 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "complexType");
        private static final QName GROUP$12 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "group");
        private static final QName ATTRIBUTEGROUP$14 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "attributeGroup");
        private static final QName ELEMENT$16 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "element");
        private static final QName ATTRIBUTE$18 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "attribute");
        private static final QName NOTATION$20 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "notation");
        private static final QName TARGETNAMESPACE$22 = new QName("", "targetNamespace");
        private static final QName VERSION$24 = new QName("", "version");
        private static final QName FINALDEFAULT$26 = new QName("", "finalDefault");
        private static final QName BLOCKDEFAULT$28 = new QName("", "blockDefault");
        private static final QName ATTRIBUTEFORMDEFAULT$30 = new QName("", "attributeFormDefault");
        private static final QName ELEMENTFORMDEFAULT$32 = new QName("", "elementFormDefault");
        private static final QName ID$34 = new QName("", "id");
        private static final QName LANG$36 = new QName(XMLValidationSchema.SCHEMA_ID_DTD, "lang");

        public SchemaImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public IncludeDocument.Include[] getIncludeArray() {
            IncludeDocument.Include[] includeArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(INCLUDE$0, arrayList);
                includeArr = new IncludeDocument.Include[arrayList.size()];
                arrayList.toArray(includeArr);
            }
            return includeArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public IncludeDocument.Include getIncludeArray(int i) {
            IncludeDocument.Include include;
            synchronized (monitor()) {
                check_orphaned();
                include = (IncludeDocument.Include) get_store().find_element_user(INCLUDE$0, i);
                if (include == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return include;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfIncludeArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(INCLUDE$0);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setIncludeArray(IncludeDocument.Include[] includeArr) {
            check_orphaned();
            arraySetterHelper(includeArr, INCLUDE$0);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setIncludeArray(int i, IncludeDocument.Include include) {
            generatedSetterHelperImpl(include, INCLUDE$0, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public IncludeDocument.Include insertNewInclude(int i) {
            IncludeDocument.Include include;
            synchronized (monitor()) {
                check_orphaned();
                include = (IncludeDocument.Include) get_store().insert_element_user(INCLUDE$0, i);
            }
            return include;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public IncludeDocument.Include addNewInclude() {
            IncludeDocument.Include include;
            synchronized (monitor()) {
                check_orphaned();
                include = (IncludeDocument.Include) get_store().add_element_user(INCLUDE$0);
            }
            return include;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeInclude(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(INCLUDE$0, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public ImportDocument.Import[] getImportArray() {
            ImportDocument.Import[] importArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(IMPORT$2, arrayList);
                importArr = new ImportDocument.Import[arrayList.size()];
                arrayList.toArray(importArr);
            }
            return importArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public ImportDocument.Import getImportArray(int i) {
            ImportDocument.Import r4;
            synchronized (monitor()) {
                check_orphaned();
                r4 = (ImportDocument.Import) get_store().find_element_user(IMPORT$2, i);
                if (r4 == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return r4;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfImportArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(IMPORT$2);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setImportArray(ImportDocument.Import[] importArr) {
            check_orphaned();
            arraySetterHelper(importArr, IMPORT$2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setImportArray(int i, ImportDocument.Import r4) {
            generatedSetterHelperImpl(r4, IMPORT$2, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public ImportDocument.Import insertNewImport(int i) {
            ImportDocument.Import r4;
            synchronized (monitor()) {
                check_orphaned();
                r4 = (ImportDocument.Import) get_store().insert_element_user(IMPORT$2, i);
            }
            return r4;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public ImportDocument.Import addNewImport() {
            ImportDocument.Import r1;
            synchronized (monitor()) {
                check_orphaned();
                r1 = (ImportDocument.Import) get_store().add_element_user(IMPORT$2);
            }
            return r1;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeImport(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(IMPORT$2, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public RedefineDocument.Redefine[] getRedefineArray() {
            RedefineDocument.Redefine[] redefineArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(REDEFINE$4, arrayList);
                redefineArr = new RedefineDocument.Redefine[arrayList.size()];
                arrayList.toArray(redefineArr);
            }
            return redefineArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public RedefineDocument.Redefine getRedefineArray(int i) {
            RedefineDocument.Redefine redefine;
            synchronized (monitor()) {
                check_orphaned();
                redefine = (RedefineDocument.Redefine) get_store().find_element_user(REDEFINE$4, i);
                if (redefine == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return redefine;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfRedefineArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(REDEFINE$4);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setRedefineArray(RedefineDocument.Redefine[] redefineArr) {
            check_orphaned();
            arraySetterHelper(redefineArr, REDEFINE$4);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setRedefineArray(int i, RedefineDocument.Redefine redefine) {
            generatedSetterHelperImpl(redefine, REDEFINE$4, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public RedefineDocument.Redefine insertNewRedefine(int i) {
            RedefineDocument.Redefine redefine;
            synchronized (monitor()) {
                check_orphaned();
                redefine = (RedefineDocument.Redefine) get_store().insert_element_user(REDEFINE$4, i);
            }
            return redefine;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public RedefineDocument.Redefine addNewRedefine() {
            RedefineDocument.Redefine redefine;
            synchronized (monitor()) {
                check_orphaned();
                redefine = (RedefineDocument.Redefine) get_store().add_element_user(REDEFINE$4);
            }
            return redefine;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeRedefine(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(REDEFINE$4, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public AnnotationDocument.Annotation[] getAnnotationArray() {
            AnnotationDocument.Annotation[] annotationArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(ANNOTATION$6, arrayList);
                annotationArr = new AnnotationDocument.Annotation[arrayList.size()];
                arrayList.toArray(annotationArr);
            }
            return annotationArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public AnnotationDocument.Annotation getAnnotationArray(int i) {
            AnnotationDocument.Annotation annotation;
            synchronized (monitor()) {
                check_orphaned();
                annotation = (AnnotationDocument.Annotation) get_store().find_element_user(ANNOTATION$6, i);
                if (annotation == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return annotation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfAnnotationArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(ANNOTATION$6);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAnnotationArray(AnnotationDocument.Annotation[] annotationArr) {
            check_orphaned();
            arraySetterHelper(annotationArr, ANNOTATION$6);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAnnotationArray(int i, AnnotationDocument.Annotation annotation) {
            generatedSetterHelperImpl(annotation, ANNOTATION$6, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public AnnotationDocument.Annotation insertNewAnnotation(int i) {
            AnnotationDocument.Annotation annotation;
            synchronized (monitor()) {
                check_orphaned();
                annotation = (AnnotationDocument.Annotation) get_store().insert_element_user(ANNOTATION$6, i);
            }
            return annotation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public AnnotationDocument.Annotation addNewAnnotation() {
            AnnotationDocument.Annotation annotation;
            synchronized (monitor()) {
                check_orphaned();
                annotation = (AnnotationDocument.Annotation) get_store().add_element_user(ANNOTATION$6);
            }
            return annotation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeAnnotation(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(ANNOTATION$6, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelSimpleType[] getSimpleTypeArray() {
            TopLevelSimpleType[] topLevelSimpleTypeArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(SIMPLETYPE$8, arrayList);
                topLevelSimpleTypeArr = new TopLevelSimpleType[arrayList.size()];
                arrayList.toArray(topLevelSimpleTypeArr);
            }
            return topLevelSimpleTypeArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelSimpleType getSimpleTypeArray(int i) {
            TopLevelSimpleType topLevelSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelSimpleType = (TopLevelSimpleType) get_store().find_element_user(SIMPLETYPE$8, i);
                if (topLevelSimpleType == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return topLevelSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfSimpleTypeArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(SIMPLETYPE$8);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setSimpleTypeArray(TopLevelSimpleType[] topLevelSimpleTypeArr) {
            check_orphaned();
            arraySetterHelper(topLevelSimpleTypeArr, SIMPLETYPE$8);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setSimpleTypeArray(int i, TopLevelSimpleType topLevelSimpleType) {
            generatedSetterHelperImpl(topLevelSimpleType, SIMPLETYPE$8, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelSimpleType insertNewSimpleType(int i) {
            TopLevelSimpleType topLevelSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelSimpleType = (TopLevelSimpleType) get_store().insert_element_user(SIMPLETYPE$8, i);
            }
            return topLevelSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelSimpleType addNewSimpleType() {
            TopLevelSimpleType topLevelSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelSimpleType = (TopLevelSimpleType) get_store().add_element_user(SIMPLETYPE$8);
            }
            return topLevelSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeSimpleType(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(SIMPLETYPE$8, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelComplexType[] getComplexTypeArray() {
            TopLevelComplexType[] topLevelComplexTypeArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(COMPLEXTYPE$10, arrayList);
                topLevelComplexTypeArr = new TopLevelComplexType[arrayList.size()];
                arrayList.toArray(topLevelComplexTypeArr);
            }
            return topLevelComplexTypeArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelComplexType getComplexTypeArray(int i) {
            TopLevelComplexType topLevelComplexType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelComplexType = (TopLevelComplexType) get_store().find_element_user(COMPLEXTYPE$10, i);
                if (topLevelComplexType == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return topLevelComplexType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfComplexTypeArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(COMPLEXTYPE$10);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setComplexTypeArray(TopLevelComplexType[] topLevelComplexTypeArr) {
            check_orphaned();
            arraySetterHelper(topLevelComplexTypeArr, COMPLEXTYPE$10);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setComplexTypeArray(int i, TopLevelComplexType topLevelComplexType) {
            generatedSetterHelperImpl(topLevelComplexType, COMPLEXTYPE$10, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelComplexType insertNewComplexType(int i) {
            TopLevelComplexType topLevelComplexType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelComplexType = (TopLevelComplexType) get_store().insert_element_user(COMPLEXTYPE$10, i);
            }
            return topLevelComplexType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelComplexType addNewComplexType() {
            TopLevelComplexType topLevelComplexType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelComplexType = (TopLevelComplexType) get_store().add_element_user(COMPLEXTYPE$10);
            }
            return topLevelComplexType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeComplexType(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(COMPLEXTYPE$10, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedGroup[] getGroupArray() {
            NamedGroup[] namedGroupArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(GROUP$12, arrayList);
                namedGroupArr = new NamedGroup[arrayList.size()];
                arrayList.toArray(namedGroupArr);
            }
            return namedGroupArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedGroup getGroupArray(int i) {
            NamedGroup namedGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedGroup = (NamedGroup) get_store().find_element_user(GROUP$12, i);
                if (namedGroup == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return namedGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfGroupArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(GROUP$12);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setGroupArray(NamedGroup[] namedGroupArr) {
            check_orphaned();
            arraySetterHelper(namedGroupArr, GROUP$12);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setGroupArray(int i, NamedGroup namedGroup) {
            generatedSetterHelperImpl(namedGroup, GROUP$12, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedGroup insertNewGroup(int i) {
            NamedGroup namedGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedGroup = (NamedGroup) get_store().insert_element_user(GROUP$12, i);
            }
            return namedGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedGroup addNewGroup() {
            NamedGroup namedGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedGroup = (NamedGroup) get_store().add_element_user(GROUP$12);
            }
            return namedGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeGroup(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(GROUP$12, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedAttributeGroup[] getAttributeGroupArray() {
            NamedAttributeGroup[] namedAttributeGroupArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(ATTRIBUTEGROUP$14, arrayList);
                namedAttributeGroupArr = new NamedAttributeGroup[arrayList.size()];
                arrayList.toArray(namedAttributeGroupArr);
            }
            return namedAttributeGroupArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedAttributeGroup getAttributeGroupArray(int i) {
            NamedAttributeGroup namedAttributeGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedAttributeGroup = (NamedAttributeGroup) get_store().find_element_user(ATTRIBUTEGROUP$14, i);
                if (namedAttributeGroup == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return namedAttributeGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfAttributeGroupArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(ATTRIBUTEGROUP$14);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAttributeGroupArray(NamedAttributeGroup[] namedAttributeGroupArr) {
            check_orphaned();
            arraySetterHelper(namedAttributeGroupArr, ATTRIBUTEGROUP$14);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAttributeGroupArray(int i, NamedAttributeGroup namedAttributeGroup) {
            generatedSetterHelperImpl(namedAttributeGroup, ATTRIBUTEGROUP$14, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedAttributeGroup insertNewAttributeGroup(int i) {
            NamedAttributeGroup namedAttributeGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedAttributeGroup = (NamedAttributeGroup) get_store().insert_element_user(ATTRIBUTEGROUP$14, i);
            }
            return namedAttributeGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedAttributeGroup addNewAttributeGroup() {
            NamedAttributeGroup namedAttributeGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedAttributeGroup = (NamedAttributeGroup) get_store().add_element_user(ATTRIBUTEGROUP$14);
            }
            return namedAttributeGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeAttributeGroup(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(ATTRIBUTEGROUP$14, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelElement[] getElementArray() {
            TopLevelElement[] topLevelElementArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(ELEMENT$16, arrayList);
                topLevelElementArr = new TopLevelElement[arrayList.size()];
                arrayList.toArray(topLevelElementArr);
            }
            return topLevelElementArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelElement getElementArray(int i) {
            TopLevelElement topLevelElement;
            synchronized (monitor()) {
                check_orphaned();
                topLevelElement = (TopLevelElement) get_store().find_element_user(ELEMENT$16, i);
                if (topLevelElement == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return topLevelElement;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfElementArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(ELEMENT$16);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setElementArray(TopLevelElement[] topLevelElementArr) {
            check_orphaned();
            arraySetterHelper(topLevelElementArr, ELEMENT$16);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setElementArray(int i, TopLevelElement topLevelElement) {
            generatedSetterHelperImpl(topLevelElement, ELEMENT$16, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelElement insertNewElement(int i) {
            TopLevelElement topLevelElement;
            synchronized (monitor()) {
                check_orphaned();
                topLevelElement = (TopLevelElement) get_store().insert_element_user(ELEMENT$16, i);
            }
            return topLevelElement;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelElement addNewElement() {
            TopLevelElement topLevelElement;
            synchronized (monitor()) {
                check_orphaned();
                topLevelElement = (TopLevelElement) get_store().add_element_user(ELEMENT$16);
            }
            return topLevelElement;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeElement(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(ELEMENT$16, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelAttribute[] getAttributeArray() {
            TopLevelAttribute[] topLevelAttributeArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(ATTRIBUTE$18, arrayList);
                topLevelAttributeArr = new TopLevelAttribute[arrayList.size()];
                arrayList.toArray(topLevelAttributeArr);
            }
            return topLevelAttributeArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelAttribute getAttributeArray(int i) {
            TopLevelAttribute topLevelAttribute;
            synchronized (monitor()) {
                check_orphaned();
                topLevelAttribute = (TopLevelAttribute) get_store().find_element_user(ATTRIBUTE$18, i);
                if (topLevelAttribute == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return topLevelAttribute;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfAttributeArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(ATTRIBUTE$18);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAttributeArray(TopLevelAttribute[] topLevelAttributeArr) {
            check_orphaned();
            arraySetterHelper(topLevelAttributeArr, ATTRIBUTE$18);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAttributeArray(int i, TopLevelAttribute topLevelAttribute) {
            generatedSetterHelperImpl(topLevelAttribute, ATTRIBUTE$18, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelAttribute insertNewAttribute(int i) {
            TopLevelAttribute topLevelAttribute;
            synchronized (monitor()) {
                check_orphaned();
                topLevelAttribute = (TopLevelAttribute) get_store().insert_element_user(ATTRIBUTE$18, i);
            }
            return topLevelAttribute;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelAttribute addNewAttribute() {
            TopLevelAttribute topLevelAttribute;
            synchronized (monitor()) {
                check_orphaned();
                topLevelAttribute = (TopLevelAttribute) get_store().add_element_user(ATTRIBUTE$18);
            }
            return topLevelAttribute;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeAttribute(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(ATTRIBUTE$18, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NotationDocument.Notation[] getNotationArray() {
            NotationDocument.Notation[] notationArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(NOTATION$20, arrayList);
                notationArr = new NotationDocument.Notation[arrayList.size()];
                arrayList.toArray(notationArr);
            }
            return notationArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NotationDocument.Notation getNotationArray(int i) {
            NotationDocument.Notation notation;
            synchronized (monitor()) {
                check_orphaned();
                notation = (NotationDocument.Notation) get_store().find_element_user(NOTATION$20, i);
                if (notation == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return notation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfNotationArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(NOTATION$20);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setNotationArray(NotationDocument.Notation[] notationArr) {
            check_orphaned();
            arraySetterHelper(notationArr, NOTATION$20);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setNotationArray(int i, NotationDocument.Notation notation) {
            generatedSetterHelperImpl(notation, NOTATION$20, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NotationDocument.Notation insertNewNotation(int i) {
            NotationDocument.Notation notation;
            synchronized (monitor()) {
                check_orphaned();
                notation = (NotationDocument.Notation) get_store().insert_element_user(NOTATION$20, i);
            }
            return notation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NotationDocument.Notation addNewNotation() {
            NotationDocument.Notation notation;
            synchronized (monitor()) {
                check_orphaned();
                notation = (NotationDocument.Notation) get_store().add_element_user(NOTATION$20);
            }
            return notation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeNotation(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(NOTATION$20, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public String getTargetNamespace() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TARGETNAMESPACE$22);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public XmlAnyURI xgetTargetNamespace() {
            XmlAnyURI xmlAnyURIFind_attribute_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlAnyURIFind_attribute_user = get_store().find_attribute_user(TARGETNAMESPACE$22);
            }
            return xmlAnyURIFind_attribute_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetTargetNamespace() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(TARGETNAMESPACE$22) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setTargetNamespace(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TARGETNAMESPACE$22;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetTargetNamespace(XmlAnyURI xmlAnyURI) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TARGETNAMESPACE$22;
                XmlAnyURI xmlAnyURIFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlAnyURIFind_attribute_user == null) {
                    xmlAnyURIFind_attribute_user = (XmlAnyURI) get_store().add_attribute_user(qName);
                }
                xmlAnyURIFind_attribute_user.set(xmlAnyURI);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetTargetNamespace() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(TARGETNAMESPACE$22);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public String getVersion() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VERSION$24);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public XmlToken xgetVersion() {
            XmlToken xmlTokenFind_attribute_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlTokenFind_attribute_user = get_store().find_attribute_user(VERSION$24);
            }
            return xmlTokenFind_attribute_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetVersion() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(VERSION$24) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setVersion(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VERSION$24;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetVersion(XmlToken xmlToken) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VERSION$24;
                XmlToken xmlTokenFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlTokenFind_attribute_user == null) {
                    xmlTokenFind_attribute_user = (XmlToken) get_store().add_attribute_user(qName);
                }
                xmlTokenFind_attribute_user.set(xmlToken);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetVersion() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(VERSION$24);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public Object getFinalDefault() {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FINALDEFAULT$26;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getObjectValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public FullDerivationSet xgetFinalDefault() {
            FullDerivationSet fullDerivationSet;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FINALDEFAULT$26;
                fullDerivationSet = (FullDerivationSet) typeStore.find_attribute_user(qName);
                if (fullDerivationSet == null) {
                    fullDerivationSet = (FullDerivationSet) get_default_attribute_value(qName);
                }
            }
            return fullDerivationSet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetFinalDefault() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(FINALDEFAULT$26) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setFinalDefault(Object obj) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FINALDEFAULT$26;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setObjectValue(obj);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetFinalDefault(FullDerivationSet fullDerivationSet) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FINALDEFAULT$26;
                FullDerivationSet fullDerivationSet2 = (FullDerivationSet) typeStore.find_attribute_user(qName);
                if (fullDerivationSet2 == null) {
                    fullDerivationSet2 = (FullDerivationSet) get_store().add_attribute_user(qName);
                }
                fullDerivationSet2.set(fullDerivationSet);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetFinalDefault() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(FINALDEFAULT$26);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public Object getBlockDefault() {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BLOCKDEFAULT$28;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getObjectValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public BlockSet xgetBlockDefault() {
            BlockSet blockSet;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BLOCKDEFAULT$28;
                blockSet = (BlockSet) typeStore.find_attribute_user(qName);
                if (blockSet == null) {
                    blockSet = (BlockSet) get_default_attribute_value(qName);
                }
            }
            return blockSet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetBlockDefault() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(BLOCKDEFAULT$28) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setBlockDefault(Object obj) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BLOCKDEFAULT$28;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setObjectValue(obj);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetBlockDefault(BlockSet blockSet) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BLOCKDEFAULT$28;
                BlockSet blockSet2 = (BlockSet) typeStore.find_attribute_user(qName);
                if (blockSet2 == null) {
                    blockSet2 = (BlockSet) get_store().add_attribute_user(qName);
                }
                blockSet2.set(blockSet);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetBlockDefault() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(BLOCKDEFAULT$28);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public FormChoice.Enum getAttributeFormDefault() {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ATTRIBUTEFORMDEFAULT$30;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return (FormChoice.Enum) simpleValueFind_attribute_user.getEnumValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public FormChoice xgetAttributeFormDefault() {
            FormChoice formChoice;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ATTRIBUTEFORMDEFAULT$30;
                formChoice = (FormChoice) typeStore.find_attribute_user(qName);
                if (formChoice == null) {
                    formChoice = (FormChoice) get_default_attribute_value(qName);
                }
            }
            return formChoice;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetAttributeFormDefault() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(ATTRIBUTEFORMDEFAULT$30) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAttributeFormDefault(FormChoice.Enum r4) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ATTRIBUTEFORMDEFAULT$30;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setEnumValue(r4);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetAttributeFormDefault(FormChoice formChoice) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ATTRIBUTEFORMDEFAULT$30;
                FormChoice formChoice2 = (FormChoice) typeStore.find_attribute_user(qName);
                if (formChoice2 == null) {
                    formChoice2 = (FormChoice) get_store().add_attribute_user(qName);
                }
                formChoice2.set((XmlObject) formChoice);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetAttributeFormDefault() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(ATTRIBUTEFORMDEFAULT$30);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public FormChoice.Enum getElementFormDefault() {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ELEMENTFORMDEFAULT$32;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return (FormChoice.Enum) simpleValueFind_attribute_user.getEnumValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public FormChoice xgetElementFormDefault() {
            FormChoice formChoice;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ELEMENTFORMDEFAULT$32;
                formChoice = (FormChoice) typeStore.find_attribute_user(qName);
                if (formChoice == null) {
                    formChoice = (FormChoice) get_default_attribute_value(qName);
                }
            }
            return formChoice;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetElementFormDefault() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(ELEMENTFORMDEFAULT$32) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setElementFormDefault(FormChoice.Enum r4) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ELEMENTFORMDEFAULT$32;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setEnumValue(r4);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetElementFormDefault(FormChoice formChoice) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ELEMENTFORMDEFAULT$32;
                FormChoice formChoice2 = (FormChoice) typeStore.find_attribute_user(qName);
                if (formChoice2 == null) {
                    formChoice2 = (FormChoice) get_store().add_attribute_user(qName);
                }
                formChoice2.set((XmlObject) formChoice);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetElementFormDefault() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(ELEMENTFORMDEFAULT$32);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public String getId() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$34);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public XmlID xgetId() {
            XmlID xmlIDFind_attribute_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlIDFind_attribute_user = get_store().find_attribute_user(ID$34);
            }
            return xmlIDFind_attribute_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetId() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(ID$34) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setId(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$34;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetId(XmlID xmlID) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$34;
                XmlID xmlIDFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlIDFind_attribute_user == null) {
                    xmlIDFind_attribute_user = (XmlID) get_store().add_attribute_user(qName);
                }
                xmlIDFind_attribute_user.set(xmlID);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetId() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(ID$34);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public String getLang() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(LANG$36);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public XmlLanguage xgetLang() {
            XmlLanguage xmlLanguageFind_attribute_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlLanguageFind_attribute_user = get_store().find_attribute_user(LANG$36);
            }
            return xmlLanguageFind_attribute_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetLang() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(LANG$36) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setLang(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LANG$36;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetLang(XmlLanguage xmlLanguage) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LANG$36;
                XmlLanguage xmlLanguageFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlLanguageFind_attribute_user == null) {
                    xmlLanguageFind_attribute_user = (XmlLanguage) get_store().add_attribute_user(qName);
                }
                xmlLanguageFind_attribute_user.set(xmlLanguage);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetLang() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(LANG$36);
            }
        }
    }
}
