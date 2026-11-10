package org.apache.xmlbeans.impl.schema;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.QNameSetBuilder;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaBookmark;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlPositiveInteger;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.common.XPath;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.values.NamespaceContext;
import org.apache.xmlbeans.impl.values.XmlNonNegativeIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlPositiveIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
import org.apache.xmlbeans.impl.xb.xsdschema.Annotated;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.Element;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;
import org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalElement;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;
import org.apache.xmlbeans.soap.SOAPArrayType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class StscTranslator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String FORM_QUALIFIED = "qualified";
    private static final QName WSDL_ARRAYTYPE_NAME = QNameHelper.forLNS(SoapEncSchemaTypeSystem.ARRAY_TYPE, "http://schemas.xmlsoap.org/wsdl/");
    public static final RegularExpression XPATH_REGEXP = new RegularExpression("(\\.//)?((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)/)*((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)|((attribute::|@)((\\i\\c*:)?(\\i\\c*|\\*))))(\\|(\\.//)?((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)/)*((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)|((attribute::|@)((\\i\\c*:)?(\\i\\c*|\\*)))))*", "X");

    /* JADX WARN: Multi-variable type inference failed */
    public static void addAllDefinitions(StscImporter.SchemaToProcess[] schemaToProcessArr) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < schemaToProcessArr.length; i2++) {
            List redefines = schemaToProcessArr[i2].getRedefines();
            if (redefines != null) {
                List redefineObjects = schemaToProcessArr[i2].getRedefineObjects();
                Iterator it = redefines.iterator();
                Iterator it2 = redefineObjects.iterator();
                while (it.hasNext()) {
                    arrayList.add(new RedefinitionHolder((StscImporter.SchemaToProcess) it.next(), (RedefineDocument.Redefine) it2.next()));
                }
            }
        }
        RedefinitionMaster redefinitionMaster = new RedefinitionMaster((RedefinitionHolder[]) arrayList.toArray(new RedefinitionHolder[arrayList.size()]));
        StscState stscState = StscState.get();
        int i3 = 0;
        while (i3 < schemaToProcessArr.length) {
            SchemaDocument.Schema schema = schemaToProcessArr[i3].getSchema();
            String chameleonNamespace = schemaToProcessArr[i3].getChameleonNamespace();
            if (schema.sizeOfNotationArray() > 0) {
                stscState.warning("Schema <notation> is not yet supported for this release.", 51, schema.getNotationArray(i));
            }
            String targetNamespace = schema.getTargetNamespace();
            if (chameleonNamespace == null || targetNamespace != null) {
                chameleonNamespace = targetNamespace;
                z = i;
            } else {
                z = 1;
            }
            if (chameleonNamespace == null) {
                chameleonNamespace = "";
            }
            if (chameleonNamespace.length() > 0 || !isEmptySchema(schema)) {
                stscState.registerContribution(chameleonNamespace, schema.documentProperties().getSourceName());
                stscState.addNewContainer(chameleonNamespace);
            }
            ArrayList arrayList2 = new ArrayList();
            TopLevelComplexType[] complexTypeArray = schema.getComplexTypeArray();
            for (int i4 = i; i4 < complexTypeArray.length; i4++) {
                TopLevelComplexType topLevelComplexType = complexTypeArray[i4];
                for (RedefinitionHolder redefinitionHolder : redefinitionMaster.getComplexTypeRedefinitions(topLevelComplexType.getName(), schemaToProcessArr[i3])) {
                    if (redefinitionHolder != null) {
                        TopLevelComplexType topLevelComplexTypeRedefineComplexType = redefinitionHolder.redefineComplexType(topLevelComplexType.getName());
                        arrayList2.add(topLevelComplexType);
                        topLevelComplexType = topLevelComplexTypeRedefineComplexType;
                    }
                }
                SchemaTypeImpl schemaTypeImplTranslateGlobalComplexType = translateGlobalComplexType(topLevelComplexType, chameleonNamespace, z, arrayList2.size() > 0 ? true : $assertionsDisabled);
                stscState.addGlobalType(schemaTypeImplTranslateGlobalComplexType, null);
                int size = arrayList2.size() - 1;
                while (size >= 0) {
                    SchemaTypeImpl schemaTypeImplTranslateGlobalComplexType2 = translateGlobalComplexType((TopLevelComplexType) arrayList2.remove(size), chameleonNamespace, z, size > 0 ? true : $assertionsDisabled);
                    stscState.addGlobalType(schemaTypeImplTranslateGlobalComplexType2, schemaTypeImplTranslateGlobalComplexType);
                    size--;
                    schemaTypeImplTranslateGlobalComplexType = schemaTypeImplTranslateGlobalComplexType2;
                }
            }
            TopLevelSimpleType[] simpleTypeArray = schema.getSimpleTypeArray();
            for (int i5 = 0; i5 < simpleTypeArray.length; i5++) {
                TopLevelSimpleType topLevelSimpleType = simpleTypeArray[i5];
                for (RedefinitionHolder redefinitionHolder2 : redefinitionMaster.getSimpleTypeRedefinitions(topLevelSimpleType.getName(), schemaToProcessArr[i3])) {
                    if (redefinitionHolder2 != null) {
                        TopLevelSimpleType topLevelSimpleTypeRedefineSimpleType = redefinitionHolder2.redefineSimpleType(topLevelSimpleType.getName());
                        arrayList2.add(topLevelSimpleType);
                        topLevelSimpleType = topLevelSimpleTypeRedefineSimpleType;
                    }
                }
                SchemaTypeImpl schemaTypeImplTranslateGlobalSimpleType = translateGlobalSimpleType(topLevelSimpleType, chameleonNamespace, z, arrayList2.size() > 0 ? true : $assertionsDisabled);
                stscState.addGlobalType(schemaTypeImplTranslateGlobalSimpleType, null);
                int size2 = arrayList2.size() - 1;
                while (size2 >= 0) {
                    SchemaTypeImpl schemaTypeImplTranslateGlobalSimpleType2 = translateGlobalSimpleType((TopLevelSimpleType) arrayList2.remove(size2), chameleonNamespace, z, size2 > 0 ? true : $assertionsDisabled);
                    stscState.addGlobalType(schemaTypeImplTranslateGlobalSimpleType2, schemaTypeImplTranslateGlobalSimpleType);
                    size2--;
                    schemaTypeImplTranslateGlobalSimpleType = schemaTypeImplTranslateGlobalSimpleType2;
                }
            }
            for (TopLevelElement topLevelElement : schema.getElementArray()) {
                stscState.addDocumentType(translateDocumentType(topLevelElement, chameleonNamespace, z), QNameHelper.forLNS(topLevelElement.getName(), chameleonNamespace));
            }
            for (TopLevelAttribute topLevelAttribute : schema.getAttributeArray()) {
                stscState.addAttributeType(translateAttributeType(topLevelAttribute, chameleonNamespace, z), QNameHelper.forLNS(topLevelAttribute.getName(), chameleonNamespace));
            }
            NamedGroup[] groupArray = schema.getGroupArray();
            for (int i6 = 0; i6 < groupArray.length; i6++) {
                NamedGroup namedGroup = groupArray[i6];
                for (RedefinitionHolder redefinitionHolder3 : redefinitionMaster.getModelGroupRedefinitions(namedGroup.getName(), schemaToProcessArr[i3])) {
                    if (redefinitionHolder3 != null) {
                        NamedGroup namedGroupRedefineModelGroup = redefinitionHolder3.redefineModelGroup(namedGroup.getName());
                        arrayList2.add(namedGroup);
                        namedGroup = namedGroupRedefineModelGroup;
                    }
                }
                SchemaModelGroupImpl schemaModelGroupImplTranslateModelGroup = translateModelGroup(namedGroup, chameleonNamespace, z, arrayList2.size() > 0 ? true : $assertionsDisabled);
                stscState.addModelGroup(schemaModelGroupImplTranslateModelGroup, null);
                int size3 = arrayList2.size() - 1;
                while (size3 >= 0) {
                    SchemaModelGroupImpl schemaModelGroupImplTranslateModelGroup2 = translateModelGroup((NamedGroup) arrayList2.remove(size3), chameleonNamespace, z, size3 > 0 ? true : $assertionsDisabled);
                    stscState.addModelGroup(schemaModelGroupImplTranslateModelGroup2, schemaModelGroupImplTranslateModelGroup);
                    size3--;
                    schemaModelGroupImplTranslateModelGroup = schemaModelGroupImplTranslateModelGroup2;
                }
            }
            NamedAttributeGroup[] attributeGroupArray = schema.getAttributeGroupArray();
            for (int i7 = 0; i7 < attributeGroupArray.length; i7++) {
                NamedAttributeGroup namedAttributeGroup = attributeGroupArray[i7];
                for (RedefinitionHolder redefinitionHolder4 : redefinitionMaster.getAttributeGroupRedefinitions(namedAttributeGroup.getName(), schemaToProcessArr[i3])) {
                    if (redefinitionHolder4 != null) {
                        NamedAttributeGroup namedAttributeGroupRedefineAttributeGroup = redefinitionHolder4.redefineAttributeGroup(namedAttributeGroup.getName());
                        arrayList2.add(namedAttributeGroup);
                        namedAttributeGroup = namedAttributeGroupRedefineAttributeGroup;
                    }
                }
                SchemaAttributeGroupImpl schemaAttributeGroupImplTranslateAttributeGroup = translateAttributeGroup(namedAttributeGroup, chameleonNamespace, z, arrayList2.size() > 0 ? true : $assertionsDisabled);
                stscState.addAttributeGroup(schemaAttributeGroupImplTranslateAttributeGroup, null);
                int size4 = arrayList2.size() - 1;
                while (size4 >= 0) {
                    SchemaAttributeGroupImpl schemaAttributeGroupImplTranslateAttributeGroup2 = translateAttributeGroup((NamedAttributeGroup) arrayList2.remove(size4), chameleonNamespace, z, size4 > 0 ? true : $assertionsDisabled);
                    stscState.addAttributeGroup(schemaAttributeGroupImplTranslateAttributeGroup2, schemaAttributeGroupImplTranslateAttributeGroup);
                    size4--;
                    schemaAttributeGroupImplTranslateAttributeGroup = schemaAttributeGroupImplTranslateAttributeGroup2;
                }
            }
            for (AnnotationDocument.Annotation annotation : schema.getAnnotationArray()) {
                stscState.addAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(chameleonNamespace), schema, annotation), chameleonNamespace);
            }
            i3++;
            i = 0;
        }
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            ((RedefinitionHolder) arrayList.get(i8)).complainAboutMissingDefinitions();
        }
    }

    private static class RedefinitionHolder {
        private Map agRedefinitions;
        private Map ctRedefinitions;
        private Map mgRedefinitions;
        private String schemaLocation;
        private StscImporter.SchemaToProcess schemaRedefined;
        private Map stRedefinitions;

        RedefinitionHolder(StscImporter.SchemaToProcess schemaToProcess, RedefineDocument.Redefine redefine) {
            this.stRedefinitions = Collections.EMPTY_MAP;
            this.ctRedefinitions = Collections.EMPTY_MAP;
            this.agRedefinitions = Collections.EMPTY_MAP;
            this.mgRedefinitions = Collections.EMPTY_MAP;
            this.schemaLocation = "";
            this.schemaRedefined = schemaToProcess;
            if (redefine != null) {
                StscState stscState = StscState.get();
                this.stRedefinitions = new HashMap();
                this.ctRedefinitions = new HashMap();
                this.agRedefinitions = new HashMap();
                this.mgRedefinitions = new HashMap();
                if (redefine.getSchemaLocation() != null) {
                    this.schemaLocation = redefine.getSchemaLocation();
                }
                TopLevelComplexType[] complexTypeArray = redefine.getComplexTypeArray();
                for (int i = 0; i < complexTypeArray.length; i++) {
                    if (complexTypeArray[i].getName() != null) {
                        if (this.ctRedefinitions.containsKey(complexTypeArray[i].getName())) {
                            stscState.error("Duplicate type redefinition: " + complexTypeArray[i].getName(), 49, (XmlObject) null);
                        } else {
                            this.ctRedefinitions.put(complexTypeArray[i].getName(), complexTypeArray[i]);
                        }
                    }
                }
                TopLevelSimpleType[] simpleTypeArray = redefine.getSimpleTypeArray();
                for (int i2 = 0; i2 < simpleTypeArray.length; i2++) {
                    if (simpleTypeArray[i2].getName() != null) {
                        if (this.stRedefinitions.containsKey(simpleTypeArray[i2].getName())) {
                            stscState.error("Duplicate type redefinition: " + simpleTypeArray[i2].getName(), 49, (XmlObject) null);
                        } else {
                            this.stRedefinitions.put(simpleTypeArray[i2].getName(), simpleTypeArray[i2]);
                        }
                    }
                }
                NamedGroup[] groupArray = redefine.getGroupArray();
                for (int i3 = 0; i3 < groupArray.length; i3++) {
                    if (groupArray[i3].getName() != null) {
                        if (this.mgRedefinitions.containsKey(groupArray[i3].getName())) {
                            stscState.error("Duplicate type redefinition: " + groupArray[i3].getName(), 49, (XmlObject) null);
                        } else {
                            this.mgRedefinitions.put(groupArray[i3].getName(), groupArray[i3]);
                        }
                    }
                }
                NamedAttributeGroup[] attributeGroupArray = redefine.getAttributeGroupArray();
                for (int i4 = 0; i4 < attributeGroupArray.length; i4++) {
                    if (attributeGroupArray[i4].getName() != null) {
                        if (this.agRedefinitions.containsKey(attributeGroupArray[i4].getName())) {
                            stscState.error("Duplicate type redefinition: " + attributeGroupArray[i4].getName(), 49, (XmlObject) null);
                        } else {
                            this.agRedefinitions.put(attributeGroupArray[i4].getName(), attributeGroupArray[i4]);
                        }
                    }
                }
            }
        }

        public TopLevelSimpleType redefineSimpleType(String str) {
            if (str == null || !this.stRedefinitions.containsKey(str)) {
                return null;
            }
            return (TopLevelSimpleType) this.stRedefinitions.remove(str);
        }

        public TopLevelComplexType redefineComplexType(String str) {
            if (str == null || !this.ctRedefinitions.containsKey(str)) {
                return null;
            }
            return (TopLevelComplexType) this.ctRedefinitions.remove(str);
        }

        public NamedGroup redefineModelGroup(String str) {
            if (str == null || !this.mgRedefinitions.containsKey(str)) {
                return null;
            }
            return (NamedGroup) this.mgRedefinitions.remove(str);
        }

        public NamedAttributeGroup redefineAttributeGroup(String str) {
            if (str == null || !this.agRedefinitions.containsKey(str)) {
                return null;
            }
            return (NamedAttributeGroup) this.agRedefinitions.remove(str);
        }

        public void complainAboutMissingDefinitions() {
            if (this.stRedefinitions.isEmpty() && this.ctRedefinitions.isEmpty() && this.agRedefinitions.isEmpty() && this.mgRedefinitions.isEmpty()) {
                return;
            }
            StscState stscState = StscState.get();
            for (String str : this.stRedefinitions.keySet()) {
                stscState.error("Redefined simple type " + str + " not found in " + this.schemaLocation, 60, (XmlObject) this.stRedefinitions.get(str));
            }
            for (String str2 : this.ctRedefinitions.keySet()) {
                stscState.error("Redefined complex type " + str2 + " not found in " + this.schemaLocation, 60, (XmlObject) this.ctRedefinitions.get(str2));
            }
            for (String str3 : this.agRedefinitions.keySet()) {
                stscState.error("Redefined attribute group " + str3 + " not found in " + this.schemaLocation, 60, (XmlObject) this.agRedefinitions.get(str3));
            }
            for (String str4 : this.mgRedefinitions.keySet()) {
                stscState.error("Redefined model group " + str4 + " not found in " + this.schemaLocation, 60, (XmlObject) this.mgRedefinitions.get(str4));
            }
        }
    }

    private static class RedefinitionMaster {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final short ATTRIBUTE_GROUP = 4;
        private static final short COMPLEX_TYPE = 2;
        private static final RedefinitionHolder[] EMPTY_REDEFINTION_HOLDER_ARRAY = new RedefinitionHolder[0];
        private static final short MODEL_GROUP = 3;
        private static final short SIMPLE_TYPE = 1;
        private Map agRedefinitions;
        private Map ctRedefinitions;
        private Map mgRedefinitions;
        private Map stRedefinitions;

        private String componentNameFromCode(short s) {
            if (s == 1) {
                return "simple type";
            }
            if (s == 2) {
                return "complex type";
            }
            if (s != 3) {
                return s != 4 ? "" : "attribute group";
            }
            return "model group";
        }

        RedefinitionMaster(RedefinitionHolder[] redefinitionHolderArr) {
            this.stRedefinitions = Collections.EMPTY_MAP;
            this.ctRedefinitions = Collections.EMPTY_MAP;
            this.agRedefinitions = Collections.EMPTY_MAP;
            this.mgRedefinitions = Collections.EMPTY_MAP;
            if (redefinitionHolderArr.length > 0) {
                this.stRedefinitions = new HashMap();
                this.ctRedefinitions = new HashMap();
                this.agRedefinitions = new HashMap();
                this.mgRedefinitions = new HashMap();
                for (int i = 0; i < redefinitionHolderArr.length; i++) {
                    RedefinitionHolder redefinitionHolder = redefinitionHolderArr[i];
                    for (Object obj : redefinitionHolder.stRedefinitions.keySet()) {
                        List arrayList = (List) this.stRedefinitions.get(obj);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            this.stRedefinitions.put(obj, arrayList);
                        }
                        arrayList.add(redefinitionHolderArr[i]);
                    }
                    for (Object obj2 : redefinitionHolder.ctRedefinitions.keySet()) {
                        List arrayList2 = (List) this.ctRedefinitions.get(obj2);
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                            this.ctRedefinitions.put(obj2, arrayList2);
                        }
                        arrayList2.add(redefinitionHolderArr[i]);
                    }
                    for (Object obj3 : redefinitionHolder.agRedefinitions.keySet()) {
                        List arrayList3 = (List) this.agRedefinitions.get(obj3);
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                            this.agRedefinitions.put(obj3, arrayList3);
                        }
                        arrayList3.add(redefinitionHolderArr[i]);
                    }
                    for (Object obj4 : redefinitionHolder.mgRedefinitions.keySet()) {
                        List arrayList4 = (List) this.mgRedefinitions.get(obj4);
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                            this.mgRedefinitions.put(obj4, arrayList4);
                        }
                        arrayList4.add(redefinitionHolderArr[i]);
                    }
                }
            }
        }

        RedefinitionHolder[] getSimpleTypeRedefinitions(String str, StscImporter.SchemaToProcess schemaToProcess) {
            List list = (List) this.stRedefinitions.get(str);
            if (list == null) {
                return EMPTY_REDEFINTION_HOLDER_ARRAY;
            }
            return doTopologicalSort(list, schemaToProcess, str, (short) 1);
        }

        RedefinitionHolder[] getComplexTypeRedefinitions(String str, StscImporter.SchemaToProcess schemaToProcess) {
            List list = (List) this.ctRedefinitions.get(str);
            if (list == null) {
                return EMPTY_REDEFINTION_HOLDER_ARRAY;
            }
            return doTopologicalSort(list, schemaToProcess, str, (short) 2);
        }

        RedefinitionHolder[] getAttributeGroupRedefinitions(String str, StscImporter.SchemaToProcess schemaToProcess) {
            List list = (List) this.agRedefinitions.get(str);
            if (list == null) {
                return EMPTY_REDEFINTION_HOLDER_ARRAY;
            }
            return doTopologicalSort(list, schemaToProcess, str, ATTRIBUTE_GROUP);
        }

        RedefinitionHolder[] getModelGroupRedefinitions(String str, StscImporter.SchemaToProcess schemaToProcess) {
            List list = (List) this.mgRedefinitions.get(str);
            if (list == null) {
                return EMPTY_REDEFINTION_HOLDER_ARRAY;
            }
            return doTopologicalSort(list, schemaToProcess, str, MODEL_GROUP);
        }

        private RedefinitionHolder[] doTopologicalSort(List list, StscImporter.SchemaToProcess schemaToProcess, String str, short s) {
            RedefinitionHolder[] redefinitionHolderArr = new RedefinitionHolder[list.size()];
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                RedefinitionHolder redefinitionHolder = (RedefinitionHolder) list.get(i2);
                if (redefinitionHolder.schemaRedefined == schemaToProcess || redefinitionHolder.schemaRedefined.indirectIncludes(schemaToProcess)) {
                    redefinitionHolderArr[i] = redefinitionHolder;
                    i++;
                }
            }
            RedefinitionHolder[] redefinitionHolderArr2 = new RedefinitionHolder[i];
            int[] iArr = new int[i];
            int i3 = 0;
            while (i3 < i - 1) {
                RedefinitionHolder redefinitionHolder2 = redefinitionHolderArr[i3];
                int i4 = i3 + 1;
                for (int i5 = i4; i5 < i; i5++) {
                    if (redefinitionHolder2.schemaRedefined.indirectIncludes(redefinitionHolderArr[i5].schemaRedefined)) {
                        iArr[i3] = iArr[i3] + 1;
                    }
                    if (redefinitionHolderArr[i5].schemaRedefined.indirectIncludes(redefinitionHolder2.schemaRedefined)) {
                        iArr[i5] = iArr[i5] + 1;
                    }
                }
                i3 = i4;
            }
            int i6 = 0;
            boolean z = $assertionsDisabled;
            while (true) {
                XmlObject xmlObjectLocationFromRedefinitionAndCode = null;
                if (i6 >= i) {
                    break;
                }
                int i7 = -1;
                for (int i8 = 0; i8 < i; i8++) {
                    if (iArr[i8] == 0 && i7 < 0) {
                        i7 = i8;
                    }
                }
                if (i7 < 0) {
                    if (!z) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i9 = 0; i9 < i; i9++) {
                            RedefinitionHolder redefinitionHolder3 = redefinitionHolderArr[i9];
                            if (redefinitionHolder3 != null) {
                                stringBuffer.append(redefinitionHolder3.schemaLocation).append(", ");
                                if (xmlObjectLocationFromRedefinitionAndCode == null) {
                                    xmlObjectLocationFromRedefinitionAndCode = locationFromRedefinitionAndCode(redefinitionHolderArr[i9], str, s);
                                }
                            }
                        }
                        StscState.get().error("Detected circular redefinition of " + componentNameFromCode(s) + " \"" + str + "\"; Files involved: " + stringBuffer.toString(), 60, xmlObjectLocationFromRedefinitionAndCode);
                        z = true;
                    }
                    int i10 = i;
                    for (int i11 = 0; i11 < i; i11++) {
                        int i12 = iArr[i11];
                        if (i12 > 0 && i12 < i10) {
                            i7 = i11;
                            i10 = i12;
                        }
                    }
                    iArr[i7] = iArr[i7] - 1;
                } else {
                    int i13 = i6 + 1;
                    redefinitionHolderArr2[i6] = redefinitionHolderArr[i7];
                    for (int i14 = 0; i14 < i; i14++) {
                        RedefinitionHolder redefinitionHolder4 = redefinitionHolderArr[i14];
                        if (redefinitionHolder4 != null && redefinitionHolder4.schemaRedefined.indirectIncludes(redefinitionHolderArr[i7].schemaRedefined)) {
                            iArr[i14] = iArr[i14] - 1;
                        }
                    }
                    redefinitionHolderArr[i7] = null;
                    iArr[i7] = iArr[i7] - 1;
                    i6 = i13;
                }
            }
            for (int i15 = 1; i15 < i; i15++) {
                int i16 = i15 - 1;
                while (i16 >= 0 && redefinitionHolderArr2[i16] == null) {
                    i16--;
                }
                if (!redefinitionHolderArr2[i15].schemaRedefined.indirectIncludes(redefinitionHolderArr2[i16].schemaRedefined)) {
                    StscState.get().error("Detected multiple redefinitions of " + componentNameFromCode(s) + " \"" + str + "\"; Files involved: " + redefinitionHolderArr2[i16].schemaRedefined.getSourceName() + ", " + redefinitionHolderArr2[i15].schemaRedefined.getSourceName(), 49, locationFromRedefinitionAndCode(redefinitionHolderArr2[i15], str, s));
                    if (s == 1) {
                        redefinitionHolderArr2[i15].redefineSimpleType(str);
                    } else if (s == 2) {
                        redefinitionHolderArr2[i15].redefineComplexType(str);
                    } else if (s == 3) {
                        redefinitionHolderArr2[i15].redefineModelGroup(str);
                    } else if (s == 4) {
                        redefinitionHolderArr2[i15].redefineAttributeGroup(str);
                    }
                    redefinitionHolderArr2[i15] = null;
                }
            }
            return redefinitionHolderArr2;
        }

        private XmlObject locationFromRedefinitionAndCode(RedefinitionHolder redefinitionHolder, String str, short s) {
            if (s == 1) {
                return (XmlObject) redefinitionHolder.stRedefinitions.get(str);
            }
            if (s == 2) {
                return (XmlObject) redefinitionHolder.ctRedefinitions.get(str);
            }
            if (s == 3) {
                return (XmlObject) redefinitionHolder.mgRedefinitions.get(str);
            }
            if (s != 4) {
                return null;
            }
            return (XmlObject) redefinitionHolder.agRedefinitions.get(str);
        }
    }

    private static String findFilename(XmlObject xmlObject) {
        return StscState.get().sourceNameForUri(xmlObject.documentProperties().getSourceName());
    }

    private static SchemaTypeImpl translateDocumentType(TopLevelElement topLevelElement, String str, boolean z) {
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(StscState.get().getContainer(str));
        schemaTypeImpl.setDocumentType(true);
        schemaTypeImpl.setParseContext(topLevelElement, str, z, null, null, $assertionsDisabled);
        schemaTypeImpl.setFilename(findFilename(topLevelElement));
        return schemaTypeImpl;
    }

    private static SchemaTypeImpl translateAttributeType(TopLevelAttribute topLevelAttribute, String str, boolean z) {
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(StscState.get().getContainer(str));
        schemaTypeImpl.setAttributeType(true);
        schemaTypeImpl.setParseContext(topLevelAttribute, str, z, null, null, $assertionsDisabled);
        schemaTypeImpl.setFilename(findFilename(topLevelAttribute));
        return schemaTypeImpl;
    }

    private static SchemaTypeImpl translateGlobalComplexType(TopLevelComplexType topLevelComplexType, String str, boolean z, boolean z2) {
        StscState stscState = StscState.get();
        String name = topLevelComplexType.getName();
        if (name == null) {
            stscState.error("missing-name", new Object[]{"global type"}, topLevelComplexType);
            return null;
        }
        if (!XMLChar.isValidNCName(name)) {
            stscState.error("invalid-value", new Object[]{name, "name"}, (XmlObject) topLevelComplexType.xgetName());
        }
        QName qNameForLNS = QNameHelper.forLNS(name, str);
        if (isReservedTypeName(qNameForLNS)) {
            stscState.warning("reserved-type-name", new Object[]{QNameHelper.pretty(qNameForLNS)}, topLevelComplexType);
            return null;
        }
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(stscState.getContainer(str));
        schemaTypeImpl.setParseContext(topLevelComplexType, str, z, null, null, z2);
        schemaTypeImpl.setFilename(findFilename(topLevelComplexType));
        schemaTypeImpl.setName(QNameHelper.forLNS(name, str));
        schemaTypeImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), topLevelComplexType));
        schemaTypeImpl.setUserData(getUserData(topLevelComplexType));
        return schemaTypeImpl;
    }

    private static SchemaTypeImpl translateGlobalSimpleType(TopLevelSimpleType topLevelSimpleType, String str, boolean z, boolean z2) {
        StscState stscState = StscState.get();
        String name = topLevelSimpleType.getName();
        if (name == null) {
            stscState.error("missing-name", new Object[]{"global type"}, topLevelSimpleType);
            return null;
        }
        if (!XMLChar.isValidNCName(name)) {
            stscState.error("invalid-value", new Object[]{name, "name"}, (XmlObject) topLevelSimpleType.xgetName());
        }
        QName qNameForLNS = QNameHelper.forLNS(name, str);
        if (isReservedTypeName(qNameForLNS)) {
            stscState.warning("reserved-type-name", new Object[]{QNameHelper.pretty(qNameForLNS)}, topLevelSimpleType);
            return null;
        }
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(stscState.getContainer(str));
        schemaTypeImpl.setSimpleType(true);
        schemaTypeImpl.setParseContext(topLevelSimpleType, str, z, null, null, z2);
        schemaTypeImpl.setFilename(findFilename(topLevelSimpleType));
        schemaTypeImpl.setName(qNameForLNS);
        schemaTypeImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), topLevelSimpleType));
        schemaTypeImpl.setUserData(getUserData(topLevelSimpleType));
        return schemaTypeImpl;
    }

    static SchemaTypeImpl translateAnonymousSimpleType(SimpleType simpleType, String str, boolean z, String str2, String str3, List list, SchemaType schemaType) {
        StscState stscState = StscState.get();
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(stscState.getContainer(str));
        schemaTypeImpl.setSimpleType(true);
        schemaTypeImpl.setParseContext(simpleType, str, z, str2, str3, $assertionsDisabled);
        schemaTypeImpl.setOuterSchemaTypeRef(schemaType.getRef());
        schemaTypeImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), simpleType));
        schemaTypeImpl.setUserData(getUserData(simpleType));
        list.add(schemaTypeImpl);
        return schemaTypeImpl;
    }

    static FormChoice findElementFormDefault(XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        while (xmlCursorNewCursor.getObject().schemaType() != SchemaDocument.Schema.type) {
            if (!xmlCursorNewCursor.toParent()) {
                return null;
            }
        }
        return ((SchemaDocument.Schema) xmlCursorNewCursor.getObject()).xgetElementFormDefault();
    }

    public static boolean uriMatch(String str, String str2) {
        if (str != null) {
            if (str2 == null) {
                return str.equals("");
            }
            return str.equals(str2);
        }
        if (str2 == null || str2.equals("")) {
            return true;
        }
        return $assertionsDisabled;
    }

    public static void copyGlobalElementToLocalElement(SchemaGlobalElement schemaGlobalElement, SchemaLocalElementImpl schemaLocalElementImpl) {
        schemaLocalElementImpl.setNameAndTypeRef(schemaGlobalElement.getName(), schemaGlobalElement.getType().getRef());
        schemaLocalElementImpl.setNillable(schemaGlobalElement.isNillable());
        schemaLocalElementImpl.setDefault(schemaGlobalElement.getDefaultText(), schemaGlobalElement.isFixed(), ((SchemaGlobalElementImpl) schemaGlobalElement).getParseObject());
        schemaLocalElementImpl.setIdentityConstraints(((SchemaLocalElementImpl) schemaGlobalElement).getIdentityConstraintRefs());
        schemaLocalElementImpl.setBlock(schemaGlobalElement.blockExtension(), schemaGlobalElement.blockRestriction(), schemaGlobalElement.blockSubstitution());
        schemaLocalElementImpl.setAbstract(schemaGlobalElement.isAbstract());
        SchemaParticle schemaParticle = (SchemaParticle) schemaGlobalElement;
        schemaLocalElementImpl.setTransitionRules(schemaParticle.acceptedStartNames(), schemaParticle.isSkippable());
        schemaLocalElementImpl.setAnnotation(schemaGlobalElement.getAnnotation());
    }

    public static void copyGlobalAttributeToLocalAttribute(SchemaGlobalAttributeImpl schemaGlobalAttributeImpl, SchemaLocalAttributeImpl schemaLocalAttributeImpl) {
        schemaLocalAttributeImpl.init(schemaGlobalAttributeImpl.getName(), schemaGlobalAttributeImpl.getTypeRef(), schemaGlobalAttributeImpl.getUse(), schemaGlobalAttributeImpl.getDefaultText(), schemaGlobalAttributeImpl.getParseObject(), schemaGlobalAttributeImpl._defaultValue, schemaGlobalAttributeImpl.isFixed(), schemaGlobalAttributeImpl.getWSDLArrayType(), schemaGlobalAttributeImpl.getAnnotation(), null);
    }

    /* JADX WARN: Code duplicated, block: B:108:0x021d  */
    /* JADX WARN: Code duplicated, block: B:149:0x031d  */
    /* JADX WARN: Code duplicated, block: B:150:0x031f  */
    /* JADX WARN: Code duplicated, block: B:153:0x0326  */
    /* JADX WARN: Code duplicated, block: B:155:0x032c  */
    /* JADX WARN: Code duplicated, block: B:161:0x0355  */
    /* JADX WARN: Code duplicated, block: B:165:0x0364 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:169:0x0386  */
    /* JADX WARN: Code duplicated, block: B:170:0x038b  */
    /* JADX WARN: Code duplicated, block: B:173:0x0398  */
    /* JADX WARN: Code duplicated, block: B:175:0x039c  */
    /* JADX WARN: Code duplicated, block: B:178:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:180:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:182:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:183:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:184:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:188:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:190:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:191:0x03f5  */
    /* JADX WARN: Code duplicated, block: B:196:0x0405  */
    /* JADX WARN: Code duplicated, block: B:198:0x040f  */
    /* JADX WARN: Code duplicated, block: B:199:0x0414  */
    /* JADX WARN: Code duplicated, block: B:204:0x0422  */
    /* JADX WARN: Code duplicated, block: B:206:0x042c  */
    /* JADX WARN: Code duplicated, block: B:207:0x0431  */
    /* JADX WARN: Code duplicated, block: B:210:0x043a  */
    /* JADX WARN: Code duplicated, block: B:212:0x043f A[LOOP:4: B:211:0x043d->B:212:0x043f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:215:0x033d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [int] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [int] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v2, types: [int] */
    /* JADX WARN: Type inference failed for: r6v3, types: [int] */
    /* JADX WARN: Type inference failed for: r6v4, types: [int] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static SchemaLocalElementImpl translateElement(Element element, String str, boolean z, String str2, String str3, List list, SchemaType schemaType) {
        SchemaTypeImpl schemaTypeImpl;
        SchemaField schemaGlobalElementImpl;
        QName qNameForLNS;
        boolean z2;
        boolean zContains;
        SchemaType type;
        boolean z3;
        Annotated annotated;
        Object obj;
        int i;
        String attributeText;
        boolean z4;
        SOAPArrayType sOAPArrayType;
        boolean zIsSetFixed;
        String fixed;
        Object block;
        boolean z5;
        boolean zContains2;
        boolean zContains3;
        int iSizeOfKeyArray;
        SchemaIdentityConstraintImpl[] schemaIdentityConstraintImplArr;
        Keybase[] keyArray;
        boolean z6;
        ?? r6;
        ?? r5;
        Keybase[] uniqueArray;
        ?? r7;
        boolean z7;
        ?? r8;
        KeyrefDocument.Keyref[] keyrefArray;
        ?? r4;
        boolean z8;
        ?? r9;
        SchemaIdentityConstraint.Ref[] refArr;
        int i2;
        SchemaIdentityConstraintImpl schemaIdentityConstraintImplTranslateIdentityConstraint;
        SchemaIdentityConstraintImpl schemaIdentityConstraintImplTranslateIdentityConstraint2;
        SchemaIdentityConstraintImpl schemaIdentityConstraintImplTranslateIdentityConstraint3;
        List list2;
        String str4;
        SchemaGlobalElementImpl schemaGlobalElementImplFindGlobalElement;
        boolean zEquals;
        StscState stscState = StscState.get();
        if (element.isSetSubstitutionGroup()) {
            SchemaTypeImpl schemaTypeImplFindDocumentType = stscState.findDocumentType(element.getSubstitutionGroup(), ((SchemaTypeImpl) schemaType).getChameleonNamespace(), str);
            if (schemaTypeImplFindDocumentType != null) {
                StscResolver.resolveType(schemaTypeImplFindDocumentType);
            }
            schemaTypeImpl = schemaTypeImplFindDocumentType;
        } else {
            schemaTypeImpl = null;
        }
        String name = element.getName();
        QName ref = element.getRef();
        if (ref != null && name != null) {
            stscState.error("src-element.2.1a", new Object[]{name}, element.xgetRef());
            name = null;
        }
        if (ref == null && name == null) {
            stscState.error("src-element.2.1b", (Object[]) null, element);
            return null;
        }
        if (name != null && !XMLChar.isValidNCName(name)) {
            stscState.error("invalid-value", new Object[]{name, "name"}, element.xgetName());
        }
        if (ref != null) {
            if (element.getType() != null) {
                stscState.error("src-element.2.2", new Object[]{JamXmlElements.TYPE}, element.xgetType());
            }
            if (element.getSimpleType() != null) {
                stscState.error("src-element.2.2", new Object[]{"<simpleType>"}, element.getSimpleType());
            }
            if (element.getComplexType() != null) {
                stscState.error("src-element.2.2", new Object[]{"<complexType>"}, element.getComplexType());
            }
            if (element.getForm() != null) {
                stscState.error("src-element.2.2", new Object[]{"form"}, element.xgetForm());
            }
            if (element.sizeOfKeyArray() > 0) {
                stscState.warning("src-element.2.2", new Object[]{"<key>"}, element);
            }
            if (element.sizeOfKeyrefArray() > 0) {
                stscState.warning("src-element.2.2", new Object[]{"<keyref>"}, element);
            }
            if (element.sizeOfUniqueArray() > 0) {
                stscState.warning("src-element.2.2", new Object[]{"<unique>"}, element);
            }
            if (element.isSetDefault()) {
                stscState.warning("src-element.2.2", new Object[]{"default"}, element.xgetDefault());
            }
            if (element.isSetFixed()) {
                stscState.warning("src-element.2.2", new Object[]{"fixed"}, element.xgetFixed());
            }
            if (element.isSetBlock()) {
                stscState.warning("src-element.2.2", new Object[]{"block"}, element.xgetBlock());
            }
            if (element.isSetNillable()) {
                stscState.warning("src-element.2.2", new Object[]{"nillable"}, element.xgetNillable());
            }
            SchemaGlobalElementImpl schemaGlobalElementImplFindGlobalElement2 = stscState.findGlobalElement(ref, z ? str : null, str);
            if (schemaGlobalElementImplFindGlobalElement2 == null) {
                stscState.notFoundError(ref, 1, element.xgetRef(), true);
                return null;
            }
            SchemaLocalElementImpl schemaLocalElementImpl = new SchemaLocalElementImpl();
            schemaLocalElementImpl.setParticleType(4);
            schemaLocalElementImpl.setUserData(getUserData(element));
            copyGlobalElementToLocalElement(schemaGlobalElementImplFindGlobalElement2, schemaLocalElementImpl);
            return schemaLocalElementImpl;
        }
        String str5 = "restriction";
        String str6 = "extension";
        if (element instanceof LocalElement) {
            schemaGlobalElementImpl = new SchemaLocalElementImpl();
            FormChoice formChoiceXgetForm = element.xgetForm();
            if (formChoiceXgetForm != null) {
                zEquals = formChoiceXgetForm.getStringValue().equals(FORM_QUALIFIED);
            } else if (str2 != null) {
                zEquals = str2.equals(FORM_QUALIFIED);
            } else {
                FormChoice formChoiceFindElementFormDefault = findElementFormDefault(element);
                zEquals = formChoiceFindElementFormDefault != null && formChoiceFindElementFormDefault.getStringValue().equals(FORM_QUALIFIED);
            }
            qNameForLNS = zEquals ? QNameHelper.forLNS(name, str) : QNameHelper.forLN(name);
        } else {
            schemaGlobalElementImpl = new SchemaGlobalElementImpl(stscState.getContainer(str));
            if (schemaTypeImpl != null) {
                SchemaGlobalElementImpl schemaGlobalElementImplFindGlobalElement3 = stscState.findGlobalElement(element.getSubstitutionGroup(), z ? str : null, str);
                if (schemaGlobalElementImplFindGlobalElement3 != null) {
                    schemaGlobalElementImpl.setSubstitutionGroup(schemaGlobalElementImplFindGlobalElement3.getRef());
                }
            }
            qNameForLNS = QNameHelper.forLNS(name, str);
            QName[] substitutionGroupMembers = ((SchemaTypeImpl) schemaType).getSubstitutionGroupMembers();
            QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
            qNameSetBuilder.add(qNameForLNS);
            for (int i3 = 0; i3 < substitutionGroupMembers.length; i3++) {
                schemaGlobalElementImpl.addSubstitutionGroupMember(substitutionGroupMembers[i3]);
                qNameSetBuilder.add(substitutionGroupMembers[i3]);
            }
            schemaGlobalElementImpl.setTransitionRules(QNameSet.forSpecification(qNameSetBuilder), $assertionsDisabled);
            schemaGlobalElementImpl.setTransitionNotes(QNameSet.EMPTY, true);
            Object obj2 = element.getFinal();
            if (obj2 == null) {
                z2 = false;
                zContains = false;
            } else if ((obj2 instanceof String) && obj2.equals("#all")) {
                z2 = true;
                zContains = true;
            } else if (obj2 instanceof List) {
                List list3 = (List) obj2;
                zContains = list3.contains("extension");
                z2 = list3.contains("restriction");
            } else {
                z2 = false;
                zContains = false;
            }
            schemaGlobalElementImpl.setFinal(zContains, z2);
            schemaGlobalElementImpl.setAbstract(element.getAbstract());
            schemaGlobalElementImpl.setFilename(findFilename(element));
            schemaGlobalElementImpl.setParseContext(element, str, z);
        }
        QName qName = qNameForLNS;
        SchemaField schemaField = schemaGlobalElementImpl;
        schemaField.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), element));
        schemaField.setUserData(getUserData(element));
        if (element.getType() != null) {
            type = stscState.findGlobalType(element.getType(), z ? str : null, str);
            if (type == null) {
                stscState.notFoundError(element.getType(), 0, element.xgetType(), true);
            }
        } else {
            type = null;
        }
        Annotated complexType = element.getComplexType();
        if (complexType == null) {
            complexType = element.getSimpleType();
            z3 = true;
        } else {
            z3 = false;
        }
        if (type == null || complexType == null) {
            annotated = complexType;
        } else {
            stscState.error("src-element.3", (Object[]) null, complexType);
            annotated = null;
        }
        if (annotated != null) {
            Object[] currentProcessing = stscState.getCurrentProcessing();
            int length = currentProcessing.length;
            QName[] qNameArr = new QName[length];
            int i4 = 0;
            while (i4 < length) {
                int i5 = length;
                Object obj3 = currentProcessing[i4];
                Object[] objArr = currentProcessing;
                if (obj3 instanceof SchemaModelGroupImpl) {
                    qNameArr[i4] = ((SchemaModelGroupImpl) obj3).getName();
                }
                i4++;
                length = i5;
                currentProcessing = objArr;
            }
            type = checkRecursiveGroupReference(qNameArr, qName, (SchemaTypeImpl) schemaType);
            if (type != null) {
                obj = "#all";
            } else {
                SchemaTypeImpl schemaTypeImpl2 = new SchemaTypeImpl(stscState.getContainer(str));
                schemaTypeImpl2.setContainerField(schemaField);
                schemaTypeImpl2.setOuterSchemaTypeRef(schemaType == null ? null : schemaType.getRef());
                schemaTypeImpl2.setGroupReferenceContext(qNameArr);
                list.add(schemaTypeImpl2);
                schemaTypeImpl2.setSimpleType(z3);
                obj = "#all";
                str6 = "extension";
                str5 = "restriction";
                i = 4;
                schemaTypeImpl2.setParseContext(annotated, str, z, str2, str3, $assertionsDisabled);
                schemaTypeImpl2.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), annotated));
                schemaTypeImpl2.setUserData(getUserData(annotated));
                type = schemaTypeImpl2;
            }
            if (type == null && schemaTypeImpl != null) {
                QName substitutionGroup = element.getSubstitutionGroup();
                if (z) {
                    str4 = str;
                } else {
                    str4 = null;
                }
                schemaGlobalElementImplFindGlobalElement = stscState.findGlobalElement(substitutionGroup, str4, str);
                if (schemaGlobalElementImplFindGlobalElement != null) {
                    type = schemaGlobalElementImplFindGlobalElement.getType();
                }
            }
            if (type == null) {
                type = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
            }
            XmlCursor xmlCursorNewCursor = element.newCursor();
            attributeText = xmlCursorNewCursor.getAttributeText(WSDL_ARRAYTYPE_NAME);
            xmlCursorNewCursor.dispose();
            if (attributeText != null) {
                try {
                    sOAPArrayType = new SOAPArrayType(attributeText, new NamespaceContext(element));
                    z4 = $assertionsDisabled;
                } catch (XmlValueOutOfRangeException unused) {
                    z4 = $assertionsDisabled;
                    stscState.error("soaparray", new Object[]{attributeText}, element);
                    sOAPArrayType = null;
                }
                schemaField.setWsdlArrayType(sOAPArrayType);
                zIsSetFixed = element.isSetFixed();
                if (element.isSetDefault() && zIsSetFixed) {
                    stscState.error("src-element.1", (Object[]) null, element.xgetFixed());
                    zIsSetFixed = z4;
                }
                schemaField.setParticleType(i);
                schemaField.setNameAndTypeRef(qName, type.getRef());
                schemaField.setNillable(element.getNillable());
                if (zIsSetFixed) {
                    fixed = element.getFixed();
                } else {
                    fixed = element.getDefault();
                }
                schemaField.setDefault(fixed, zIsSetFixed, element);
                block = element.getBlock();
                if (block == null) {
                    z5 = z4;
                    zContains2 = z5;
                    zContains3 = zContains2;
                } else if (!(block instanceof String) && block.equals(obj)) {
                    z5 = true;
                    zContains2 = true;
                    zContains3 = true;
                } else if (block instanceof List) {
                    list2 = (List) block;
                    zContains3 = list2.contains(str6);
                    zContains2 = list2.contains(str5);
                    if (list2.contains("substitution")) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                } else {
                    z5 = z4;
                    zContains2 = z5;
                    zContains3 = zContains2;
                }
                schemaField.setBlock(zContains3, zContains2, z5);
                iSizeOfKeyArray = element.sizeOfKeyArray() + element.sizeOfKeyrefArray() + element.sizeOfUniqueArray();
                schemaIdentityConstraintImplArr = new SchemaIdentityConstraintImpl[iSizeOfKeyArray];
                keyArray = element.getKeyArray();
                boolean z9 = z4;
                boolean z10 = z9;
                z6 = z10;
                r5 = z9;
                r6 = z10;
                while (r5 < keyArray.length) {
                    schemaIdentityConstraintImplTranslateIdentityConstraint3 = translateIdentityConstraint(keyArray[r5], str, z);
                    schemaIdentityConstraintImplArr[r6] = schemaIdentityConstraintImplTranslateIdentityConstraint3;
                    if (schemaIdentityConstraintImplTranslateIdentityConstraint3 != null) {
                        schemaIdentityConstraintImplTranslateIdentityConstraint3.setConstraintCategory(1);
                    } else {
                        z6 = true;
                    }
                    r5++;
                    r6++;
                    z6 = z6;
                }
                uniqueArray = element.getUniqueArray();
                r7 = z4;
                r8 = r6;
                z7 = z6;
                while (r7 < uniqueArray.length) {
                    schemaIdentityConstraintImplTranslateIdentityConstraint2 = translateIdentityConstraint(uniqueArray[r7], str, z);
                    schemaIdentityConstraintImplArr[r8] = schemaIdentityConstraintImplTranslateIdentityConstraint2;
                    if (schemaIdentityConstraintImplTranslateIdentityConstraint2 != null) {
                        schemaIdentityConstraintImplTranslateIdentityConstraint2.setConstraintCategory(3);
                    } else {
                        z7 = true;
                    }
                    r7++;
                    r8++;
                    z7 = z7;
                }
                keyrefArray = element.getKeyrefArray();
                r4 = z4;
                r9 = r8;
                z8 = z7;
                while (r4 < keyrefArray.length) {
                    schemaIdentityConstraintImplTranslateIdentityConstraint = translateIdentityConstraint(keyrefArray[r4], str, z);
                    schemaIdentityConstraintImplArr[r9] = schemaIdentityConstraintImplTranslateIdentityConstraint;
                    if (schemaIdentityConstraintImplTranslateIdentityConstraint != null) {
                        schemaIdentityConstraintImplTranslateIdentityConstraint.setConstraintCategory(2);
                    } else {
                        z8 = true;
                    }
                    r4++;
                    r9++;
                    z8 = z8;
                }
                if (!z8) {
                    refArr = new SchemaIdentityConstraint.Ref[iSizeOfKeyArray];
                    for (i2 = z4; i2 < iSizeOfKeyArray; i2++) {
                        refArr[i2] = schemaIdentityConstraintImplArr[i2].getRef();
                    }
                    schemaField.setIdentityConstraints(refArr);
                }
                return schemaField;
            }
            z4 = $assertionsDisabled;
            sOAPArrayType = null;
            schemaField.setWsdlArrayType(sOAPArrayType);
            zIsSetFixed = element.isSetFixed();
            if (element.isSetDefault()) {
                stscState.error("src-element.1", (Object[]) null, element.xgetFixed());
                zIsSetFixed = z4;
            }
            schemaField.setParticleType(i);
            schemaField.setNameAndTypeRef(qName, type.getRef());
            schemaField.setNillable(element.getNillable());
            if (zIsSetFixed) {
                fixed = element.getFixed();
            } else {
                fixed = element.getDefault();
            }
            schemaField.setDefault(fixed, zIsSetFixed, element);
            block = element.getBlock();
            if (block == null) {
                z5 = z4;
                zContains2 = z5;
                zContains3 = zContains2;
            } else if (!(block instanceof String)) {
                if (block instanceof List) {
                    list2 = (List) block;
                    zContains3 = list2.contains(str6);
                    zContains2 = list2.contains(str5);
                    if (list2.contains("substitution")) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                } else {
                    z5 = z4;
                    zContains2 = z5;
                    zContains3 = zContains2;
                }
            } else if (block instanceof List) {
                list2 = (List) block;
                zContains3 = list2.contains(str6);
                zContains2 = list2.contains(str5);
                if (list2.contains("substitution")) {
                    z5 = true;
                } else {
                    z5 = z4;
                }
            } else {
                z5 = z4;
                zContains2 = z5;
                zContains3 = zContains2;
            }
            schemaField.setBlock(zContains3, zContains2, z5);
            iSizeOfKeyArray = element.sizeOfKeyArray() + element.sizeOfKeyrefArray() + element.sizeOfUniqueArray();
            schemaIdentityConstraintImplArr = new SchemaIdentityConstraintImpl[iSizeOfKeyArray];
            keyArray = element.getKeyArray();
            boolean z11 = z4;
            boolean z12 = z11;
            z6 = z12;
            r5 = z11;
            r6 = z12;
            while (r5 < keyArray.length) {
                schemaIdentityConstraintImplTranslateIdentityConstraint3 = translateIdentityConstraint(keyArray[r5], str, z);
                schemaIdentityConstraintImplArr[r6] = schemaIdentityConstraintImplTranslateIdentityConstraint3;
                if (schemaIdentityConstraintImplTranslateIdentityConstraint3 != null) {
                    schemaIdentityConstraintImplTranslateIdentityConstraint3.setConstraintCategory(1);
                } else {
                    z6 = true;
                }
                r5++;
                r6++;
                z6 = z6;
            }
            uniqueArray = element.getUniqueArray();
            r7 = z4;
            r8 = r6;
            z7 = z6;
            while (r7 < uniqueArray.length) {
                schemaIdentityConstraintImplTranslateIdentityConstraint2 = translateIdentityConstraint(uniqueArray[r7], str, z);
                schemaIdentityConstraintImplArr[r8] = schemaIdentityConstraintImplTranslateIdentityConstraint2;
                if (schemaIdentityConstraintImplTranslateIdentityConstraint2 != null) {
                    schemaIdentityConstraintImplTranslateIdentityConstraint2.setConstraintCategory(3);
                } else {
                    z7 = true;
                }
                r7++;
                r8++;
                z7 = z7;
            }
            keyrefArray = element.getKeyrefArray();
            r4 = z4;
            r9 = r8;
            z8 = z7;
            while (r4 < keyrefArray.length) {
                schemaIdentityConstraintImplTranslateIdentityConstraint = translateIdentityConstraint(keyrefArray[r4], str, z);
                schemaIdentityConstraintImplArr[r9] = schemaIdentityConstraintImplTranslateIdentityConstraint;
                if (schemaIdentityConstraintImplTranslateIdentityConstraint != null) {
                    schemaIdentityConstraintImplTranslateIdentityConstraint.setConstraintCategory(2);
                } else {
                    z8 = true;
                }
                r4++;
                r9++;
                z8 = z8;
            }
            if (!z8) {
                refArr = new SchemaIdentityConstraint.Ref[iSizeOfKeyArray];
                while (i2 < iSizeOfKeyArray) {
                    refArr[i2] = schemaIdentityConstraintImplArr[i2].getRef();
                }
                schemaField.setIdentityConstraints(refArr);
            }
            return schemaField;
        }
        obj = "#all";
        i = 4;
        if (type == null) {
            QName substitutionGroup2 = element.getSubstitutionGroup();
            if (z) {
                str4 = str;
            } else {
                str4 = null;
            }
            schemaGlobalElementImplFindGlobalElement = stscState.findGlobalElement(substitutionGroup2, str4, str);
            if (schemaGlobalElementImplFindGlobalElement != null) {
                type = schemaGlobalElementImplFindGlobalElement.getType();
            }
        }
        if (type == null) {
            type = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
        }
        XmlCursor xmlCursorNewCursor2 = element.newCursor();
        attributeText = xmlCursorNewCursor2.getAttributeText(WSDL_ARRAYTYPE_NAME);
        xmlCursorNewCursor2.dispose();
        if (attributeText != null) {
            sOAPArrayType = new SOAPArrayType(attributeText, new NamespaceContext(element));
            z4 = $assertionsDisabled;
            schemaField.setWsdlArrayType(sOAPArrayType);
            zIsSetFixed = element.isSetFixed();
            if (element.isSetDefault()) {
                stscState.error("src-element.1", (Object[]) null, element.xgetFixed());
                zIsSetFixed = z4;
            }
            schemaField.setParticleType(i);
            schemaField.setNameAndTypeRef(qName, type.getRef());
            schemaField.setNillable(element.getNillable());
            if (zIsSetFixed) {
                fixed = element.getFixed();
            } else {
                fixed = element.getDefault();
            }
            schemaField.setDefault(fixed, zIsSetFixed, element);
            block = element.getBlock();
            if (block == null) {
                z5 = z4;
                zContains2 = z5;
                zContains3 = zContains2;
            } else if (!(block instanceof String)) {
                if (block instanceof List) {
                    list2 = (List) block;
                    zContains3 = list2.contains(str6);
                    zContains2 = list2.contains(str5);
                    if (list2.contains("substitution")) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                } else {
                    z5 = z4;
                    zContains2 = z5;
                    zContains3 = zContains2;
                }
            } else if (block instanceof List) {
                list2 = (List) block;
                zContains3 = list2.contains(str6);
                zContains2 = list2.contains(str5);
                if (list2.contains("substitution")) {
                    z5 = true;
                } else {
                    z5 = z4;
                }
            } else {
                z5 = z4;
                zContains2 = z5;
                zContains3 = zContains2;
            }
            schemaField.setBlock(zContains3, zContains2, z5);
            iSizeOfKeyArray = element.sizeOfKeyArray() + element.sizeOfKeyrefArray() + element.sizeOfUniqueArray();
            schemaIdentityConstraintImplArr = new SchemaIdentityConstraintImpl[iSizeOfKeyArray];
            keyArray = element.getKeyArray();
            boolean z13 = z4;
            boolean z14 = z13;
            z6 = z14;
            r5 = z13;
            r6 = z14;
            while (r5 < keyArray.length) {
                schemaIdentityConstraintImplTranslateIdentityConstraint3 = translateIdentityConstraint(keyArray[r5], str, z);
                schemaIdentityConstraintImplArr[r6] = schemaIdentityConstraintImplTranslateIdentityConstraint3;
                if (schemaIdentityConstraintImplTranslateIdentityConstraint3 != null) {
                    schemaIdentityConstraintImplTranslateIdentityConstraint3.setConstraintCategory(1);
                } else {
                    z6 = true;
                }
                r5++;
                r6++;
                z6 = z6;
            }
            uniqueArray = element.getUniqueArray();
            r7 = z4;
            r8 = r6;
            z7 = z6;
            while (r7 < uniqueArray.length) {
                schemaIdentityConstraintImplTranslateIdentityConstraint2 = translateIdentityConstraint(uniqueArray[r7], str, z);
                schemaIdentityConstraintImplArr[r8] = schemaIdentityConstraintImplTranslateIdentityConstraint2;
                if (schemaIdentityConstraintImplTranslateIdentityConstraint2 != null) {
                    schemaIdentityConstraintImplTranslateIdentityConstraint2.setConstraintCategory(3);
                } else {
                    z7 = true;
                }
                r7++;
                r8++;
                z7 = z7;
            }
            keyrefArray = element.getKeyrefArray();
            r4 = z4;
            r9 = r8;
            z8 = z7;
            while (r4 < keyrefArray.length) {
                schemaIdentityConstraintImplTranslateIdentityConstraint = translateIdentityConstraint(keyrefArray[r4], str, z);
                schemaIdentityConstraintImplArr[r9] = schemaIdentityConstraintImplTranslateIdentityConstraint;
                if (schemaIdentityConstraintImplTranslateIdentityConstraint != null) {
                    schemaIdentityConstraintImplTranslateIdentityConstraint.setConstraintCategory(2);
                } else {
                    z8 = true;
                }
                r4++;
                r9++;
                z8 = z8;
            }
            if (!z8) {
                refArr = new SchemaIdentityConstraint.Ref[iSizeOfKeyArray];
                while (i2 < iSizeOfKeyArray) {
                    refArr[i2] = schemaIdentityConstraintImplArr[i2].getRef();
                }
                schemaField.setIdentityConstraints(refArr);
            }
            return schemaField;
        }
        z4 = $assertionsDisabled;
        sOAPArrayType = null;
        schemaField.setWsdlArrayType(sOAPArrayType);
        zIsSetFixed = element.isSetFixed();
        if (element.isSetDefault()) {
            stscState.error("src-element.1", (Object[]) null, element.xgetFixed());
            zIsSetFixed = z4;
        }
        schemaField.setParticleType(i);
        schemaField.setNameAndTypeRef(qName, type.getRef());
        schemaField.setNillable(element.getNillable());
        if (zIsSetFixed) {
            fixed = element.getFixed();
        } else {
            fixed = element.getDefault();
        }
        schemaField.setDefault(fixed, zIsSetFixed, element);
        block = element.getBlock();
        if (block == null) {
            z5 = z4;
            zContains2 = z5;
            zContains3 = zContains2;
        } else if (!(block instanceof String)) {
            if (block instanceof List) {
                list2 = (List) block;
                zContains3 = list2.contains(str6);
                zContains2 = list2.contains(str5);
                if (list2.contains("substitution")) {
                    z5 = true;
                } else {
                    z5 = z4;
                }
            } else {
                z5 = z4;
                zContains2 = z5;
                zContains3 = zContains2;
            }
        } else if (block instanceof List) {
            list2 = (List) block;
            zContains3 = list2.contains(str6);
            zContains2 = list2.contains(str5);
            if (list2.contains("substitution")) {
                z5 = true;
            } else {
                z5 = z4;
            }
        } else {
            z5 = z4;
            zContains2 = z5;
            zContains3 = zContains2;
        }
        schemaField.setBlock(zContains3, zContains2, z5);
        iSizeOfKeyArray = element.sizeOfKeyArray() + element.sizeOfKeyrefArray() + element.sizeOfUniqueArray();
        schemaIdentityConstraintImplArr = new SchemaIdentityConstraintImpl[iSizeOfKeyArray];
        keyArray = element.getKeyArray();
        boolean z15 = z4;
        boolean z16 = z15;
        z6 = z16;
        r5 = z15;
        r6 = z16;
        while (r5 < keyArray.length) {
            schemaIdentityConstraintImplTranslateIdentityConstraint3 = translateIdentityConstraint(keyArray[r5], str, z);
            schemaIdentityConstraintImplArr[r6] = schemaIdentityConstraintImplTranslateIdentityConstraint3;
            if (schemaIdentityConstraintImplTranslateIdentityConstraint3 != null) {
                schemaIdentityConstraintImplTranslateIdentityConstraint3.setConstraintCategory(1);
            } else {
                z6 = true;
            }
            r5++;
            r6++;
            z6 = z6;
        }
        uniqueArray = element.getUniqueArray();
        r7 = z4;
        r8 = r6;
        z7 = z6;
        while (r7 < uniqueArray.length) {
            schemaIdentityConstraintImplTranslateIdentityConstraint2 = translateIdentityConstraint(uniqueArray[r7], str, z);
            schemaIdentityConstraintImplArr[r8] = schemaIdentityConstraintImplTranslateIdentityConstraint2;
            if (schemaIdentityConstraintImplTranslateIdentityConstraint2 != null) {
                schemaIdentityConstraintImplTranslateIdentityConstraint2.setConstraintCategory(3);
            } else {
                z7 = true;
            }
            r7++;
            r8++;
            z7 = z7;
        }
        keyrefArray = element.getKeyrefArray();
        r4 = z4;
        r9 = r8;
        z8 = z7;
        while (r4 < keyrefArray.length) {
            schemaIdentityConstraintImplTranslateIdentityConstraint = translateIdentityConstraint(keyrefArray[r4], str, z);
            schemaIdentityConstraintImplArr[r9] = schemaIdentityConstraintImplTranslateIdentityConstraint;
            if (schemaIdentityConstraintImplTranslateIdentityConstraint != null) {
                schemaIdentityConstraintImplTranslateIdentityConstraint.setConstraintCategory(2);
            } else {
                z8 = true;
            }
            r4++;
            r9++;
            z8 = z8;
        }
        if (!z8) {
            refArr = new SchemaIdentityConstraint.Ref[iSizeOfKeyArray];
            while (i2 < iSizeOfKeyArray) {
                refArr[i2] = schemaIdentityConstraintImplArr[i2].getRef();
            }
            schemaField.setIdentityConstraints(refArr);
        }
        return schemaField;
    }

    private static SchemaType checkRecursiveGroupReference(QName[] qNameArr, QName qName, SchemaTypeImpl schemaTypeImpl) {
        QName[] groupReferenceContext;
        if (qNameArr.length < 1) {
            return null;
        }
        while (schemaTypeImpl != null && schemaTypeImpl.getName() == null && !schemaTypeImpl.isDocumentType()) {
            if (qName.equals(schemaTypeImpl.getContainerField().getName()) && (groupReferenceContext = schemaTypeImpl.getGroupReferenceContext()) != null && groupReferenceContext.length == qNameArr.length) {
                boolean z = $assertionsDisabled;
                int i = 0;
                while (true) {
                    if (i >= qNameArr.length) {
                        z = true;
                        break;
                    }
                    QName qName2 = qNameArr[i];
                    if (!(qName2 == null && groupReferenceContext[i] == null) && (qName2 == null || !qName2.equals(groupReferenceContext[i]))) {
                        break;
                    }
                    i++;
                }
                if (z) {
                    return schemaTypeImpl;
                }
            }
            schemaTypeImpl = (SchemaTypeImpl) schemaTypeImpl.getOuterType();
        }
        return null;
    }

    private static String removeWhitespace(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (!XMLChar.isSpace(cCharAt)) {
                stringBuffer.append(cCharAt);
            }
        }
        return stringBuffer.toString();
    }

    private static boolean checkXPathSyntax(String str) {
        boolean zMatches;
        if (str == null) {
            return $assertionsDisabled;
        }
        String strRemoveWhitespace = removeWhitespace(str);
        RegularExpression regularExpression = XPATH_REGEXP;
        synchronized (regularExpression) {
            zMatches = regularExpression.matches(strRemoveWhitespace);
        }
        return zMatches;
    }

    private static SchemaIdentityConstraintImpl translateIdentityConstraint(Keybase keybase, String str, boolean z) {
        StscState stscState = StscState.get();
        String xpath = keybase.getSelector() == null ? null : keybase.getSelector().getXpath();
        if (!checkXPathSyntax(xpath)) {
            stscState.error("c-selector-xpath", new Object[]{xpath}, (XmlObject) keybase.getSelector().xgetXpath());
            return null;
        }
        FieldDocument.Field[] fieldArray = keybase.getFieldArray();
        for (int i = 0; i < fieldArray.length; i++) {
            if (!checkXPathSyntax(fieldArray[i].getXpath())) {
                stscState.error("c-fields-xpaths", new Object[]{fieldArray[i].getXpath()}, (XmlObject) fieldArray[i].xgetXpath());
                return null;
            }
        }
        SchemaIdentityConstraintImpl schemaIdentityConstraintImpl = new SchemaIdentityConstraintImpl(stscState.getContainer(str));
        schemaIdentityConstraintImpl.setName(QNameHelper.forLNS(keybase.getName(), str));
        schemaIdentityConstraintImpl.setSelector(keybase.getSelector().getXpath());
        schemaIdentityConstraintImpl.setParseContext(keybase, str, z);
        schemaIdentityConstraintImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), keybase));
        schemaIdentityConstraintImpl.setUserData(getUserData(keybase));
        XmlCursor xmlCursorNewCursor = keybase.newCursor();
        HashMap map = new HashMap();
        xmlCursorNewCursor.getAllNamespaces(map);
        map.remove("");
        schemaIdentityConstraintImpl.setNSMap(map);
        xmlCursorNewCursor.dispose();
        int length = fieldArray.length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = fieldArray[i2].getXpath();
        }
        schemaIdentityConstraintImpl.setFields(strArr);
        try {
            schemaIdentityConstraintImpl.buildPaths();
            stscState.addIdConstraint(schemaIdentityConstraintImpl);
            schemaIdentityConstraintImpl.setFilename(findFilename(keybase));
            return stscState.findIdConstraint(schemaIdentityConstraintImpl.getName(), str, null);
        } catch (XPath.XPathCompileException e) {
            stscState.error("invalid-xpath", new Object[]{e.getMessage()}, keybase);
            return null;
        }
    }

    public static SchemaModelGroupImpl translateModelGroup(NamedGroup namedGroup, String str, boolean z, boolean z2) {
        String name = namedGroup.getName();
        if (name == null) {
            StscState.get().error("missing-name", new Object[]{"model group"}, namedGroup);
            return null;
        }
        SchemaContainer container = StscState.get().getContainer(str);
        SchemaModelGroupImpl schemaModelGroupImpl = new SchemaModelGroupImpl(container);
        SchemaAnnotationImpl annotation = SchemaAnnotationImpl.getAnnotation(container, namedGroup);
        FormChoice formChoiceFindElementFormDefault = findElementFormDefault(namedGroup);
        FormChoice formChoiceFindAttributeFormDefault = findAttributeFormDefault(namedGroup);
        schemaModelGroupImpl.init(QNameHelper.forLNS(name, str), str, z, formChoiceFindElementFormDefault == null ? null : formChoiceFindElementFormDefault.getStringValue(), formChoiceFindAttributeFormDefault == null ? null : formChoiceFindAttributeFormDefault.getStringValue(), z2, namedGroup, annotation, getUserData(namedGroup));
        schemaModelGroupImpl.setFilename(findFilename(namedGroup));
        return schemaModelGroupImpl;
    }

    public static SchemaAttributeGroupImpl translateAttributeGroup(AttributeGroup attributeGroup, String str, boolean z, boolean z2) {
        String name = attributeGroup.getName();
        if (name == null) {
            StscState.get().error("missing-name", new Object[]{"attribute group"}, attributeGroup);
            return null;
        }
        SchemaContainer container = StscState.get().getContainer(str);
        SchemaAttributeGroupImpl schemaAttributeGroupImpl = new SchemaAttributeGroupImpl(container);
        SchemaAnnotationImpl annotation = SchemaAnnotationImpl.getAnnotation(container, attributeGroup);
        FormChoice formChoiceFindAttributeFormDefault = findAttributeFormDefault(attributeGroup);
        schemaAttributeGroupImpl.init(QNameHelper.forLNS(name, str), str, z, formChoiceFindAttributeFormDefault == null ? null : formChoiceFindAttributeFormDefault.getStringValue(), z2, attributeGroup, annotation, getUserData(attributeGroup));
        schemaAttributeGroupImpl.setFilename(findFilename(attributeGroup));
        return schemaAttributeGroupImpl;
    }

    static FormChoice findAttributeFormDefault(XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        while (xmlCursorNewCursor.getObject().schemaType() != SchemaDocument.Schema.type) {
            if (!xmlCursorNewCursor.toParent()) {
                return null;
            }
        }
        return ((SchemaDocument.Schema) xmlCursorNewCursor.getObject()).xgetAttributeFormDefault();
    }

    static SchemaLocalAttributeImpl translateAttribute(Attribute attribute, String str, String str2, boolean z, List list, SchemaType schemaType, SchemaAttributeModel schemaAttributeModel, boolean z2) {
        SchemaField schemaGlobalAttributeImpl;
        SchemaTypeImpl schemaTypeImplFindGlobalType;
        LocalSimpleType localSimpleType;
        SchemaTypeImpl schemaTypeImpl;
        SchemaType type;
        String defaultText;
        String str3;
        boolean zIsFixed;
        boolean zEquals;
        boolean z3;
        StscState stscState = StscState.get();
        String name = attribute.getName();
        QName ref = attribute.getRef();
        SOAPArrayType sOAPArrayType = null;
        if (ref != null && name != null) {
            if (name.equals(ref.getLocalPart()) && uriMatch(str, ref.getNamespaceURI())) {
                stscState.warning("src-attribute.3.1a", new Object[]{name}, attribute.xgetRef());
            } else {
                stscState.error("src-attribute.3.1a", new Object[]{name}, attribute.xgetRef());
            }
            name = null;
        }
        if (ref == null && name == null) {
            stscState.error("src-attribute.3.1b", (Object[]) null, attribute);
            return null;
        }
        int i = 2;
        if (name != null && !XMLChar.isValidNCName(name)) {
            stscState.error("invalid-value", new Object[]{name, "name"}, attribute.xgetName());
        }
        if (z2) {
            schemaGlobalAttributeImpl = new SchemaLocalAttributeImpl();
        } else {
            schemaGlobalAttributeImpl = new SchemaGlobalAttributeImpl(StscState.get().getContainer(str));
            schemaGlobalAttributeImpl.setParseContext(attribute, str, z);
        }
        SchemaField schemaField = schemaGlobalAttributeImpl;
        if (ref != null) {
            if (attribute.getType() != null) {
                stscState.error("src-attribute.3.2", new Object[]{JamXmlElements.TYPE}, attribute.xgetType());
            }
            if (attribute.getSimpleType() != null) {
                stscState.error("src-attribute.3.2", new Object[]{"<simpleType>"}, attribute.getSimpleType());
            }
            if (attribute.getForm() != null) {
                stscState.error("src-attribute.3.2", new Object[]{"form"}, attribute.xgetForm());
            }
            SchemaGlobalAttributeImpl schemaGlobalAttributeImplFindGlobalAttribute = stscState.findGlobalAttribute(ref, z ? str : null, str);
            if (schemaGlobalAttributeImplFindGlobalAttribute == null) {
                stscState.notFoundError(ref, 3, attribute.xgetRef(), true);
                return null;
            }
            int use = schemaGlobalAttributeImplFindGlobalAttribute.getUse();
            type = schemaGlobalAttributeImplFindGlobalAttribute.getType();
            defaultText = schemaGlobalAttributeImplFindGlobalAttribute.getDefaultText();
            if (defaultText != null) {
                zIsFixed = schemaGlobalAttributeImplFindGlobalAttribute.isFixed();
                if (zIsFixed) {
                    str3 = defaultText;
                }
                schemaField = schemaField;
                i = 2;
                i = use;
            } else {
                zIsFixed = false;
            }
            str3 = null;
            schemaField = schemaField;
            i = 2;
            i = use;
        } else {
            if (z2) {
                FormChoice formChoiceXgetForm = attribute.xgetForm();
                if (formChoiceXgetForm != null) {
                    zEquals = formChoiceXgetForm.getStringValue().equals(FORM_QUALIFIED);
                } else if (str2 != null) {
                    zEquals = str2.equals(FORM_QUALIFIED);
                } else {
                    FormChoice formChoiceFindAttributeFormDefault = findAttributeFormDefault(attribute);
                    zEquals = formChoiceFindAttributeFormDefault != null && formChoiceFindAttributeFormDefault.getStringValue().equals(FORM_QUALIFIED);
                }
                ref = zEquals ? QNameHelper.forLNS(name, str) : QNameHelper.forLN(name);
            } else {
                ref = QNameHelper.forLNS(name, str);
            }
            if (attribute.getType() != null) {
                schemaTypeImplFindGlobalType = stscState.findGlobalType(attribute.getType(), z ? str : null, str);
                if (schemaTypeImplFindGlobalType == null) {
                    stscState.notFoundError(attribute.getType(), 0, attribute.xgetType(), true);
                }
            } else {
                schemaTypeImplFindGlobalType = null;
            }
            if (ref.getNamespaceURI().equals("http://www.w3.org/2001/XMLSchema-instance")) {
                stscState.error("no-xsi", new Object[]{"http://www.w3.org/2001/XMLSchema-instance"}, attribute.xgetName());
            }
            if (ref.getNamespaceURI().length() == 0 && ref.getLocalPart().equals(Sax2Dom.XMLNS_PREFIX)) {
                stscState.error("no-xmlns", (Object[]) null, attribute.xgetName());
            }
            LocalSimpleType simpleType = attribute.getSimpleType();
            if (schemaTypeImplFindGlobalType == null || simpleType == null) {
                localSimpleType = simpleType;
            } else {
                stscState.error("src-attribute.4", (Object[]) null, simpleType);
                localSimpleType = null;
            }
            if (localSimpleType != null) {
                SchemaTypeImpl schemaTypeImpl2 = new SchemaTypeImpl(stscState.getContainer(str));
                schemaTypeImpl2.setContainerField(schemaField);
                schemaTypeImpl2.setOuterSchemaTypeRef(schemaType == null ? null : schemaType.getRef());
                list.add(schemaTypeImpl2);
                schemaTypeImpl2.setSimpleType(true);
                schemaTypeImpl = schemaTypeImpl2;
                LocalSimpleType localSimpleType2 = localSimpleType;
                schemaTypeImpl2.setParseContext(localSimpleType, str, z, null, null, $assertionsDisabled);
                schemaTypeImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), localSimpleType2));
                schemaTypeImpl.setUserData(getUserData(localSimpleType2));
            } else {
                schemaTypeImpl = schemaTypeImplFindGlobalType;
            }
            type = (schemaTypeImpl != null || schemaAttributeModel == null || schemaAttributeModel.getAttribute(ref) == null) ? schemaTypeImpl : schemaAttributeModel.getAttribute(ref).getType();
            defaultText = null;
            str3 = null;
            zIsFixed = $assertionsDisabled;
        }
        if (type == null) {
            type = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (!type.isSimpleType()) {
            stscState.error("Attributes must have a simple type (not complex).", 46, attribute);
            type = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (attribute.isSetUse()) {
            int iTranslateUseCode = translateUseCode(attribute.xgetUse());
            if (iTranslateUseCode == i || zIsFixed) {
                i = iTranslateUseCode;
            } else {
                i = iTranslateUseCode;
                defaultText = null;
            }
        }
        if (attribute.isSetDefault() || attribute.isSetFixed()) {
            if (zIsFixed && !attribute.isSetFixed()) {
                stscState.error("A use of a fixed attribute definition must also be fixed", 9, attribute.xgetFixed());
            }
            boolean zIsSetFixed = attribute.isSetFixed();
            if (attribute.isSetDefault() && zIsSetFixed) {
                stscState.error("src-attribute.1", (Object[]) null, attribute.xgetFixed());
                zIsSetFixed = $assertionsDisabled;
            }
            Object fixed = zIsSetFixed ? attribute.getFixed() : attribute.getDefault();
            if (str3 == null || str3.equals(fixed)) {
                z3 = zIsSetFixed;
                str3 = fixed;
            } else {
                stscState.error("au-value_constraint", (Object[]) null, attribute.xgetFixed());
                z3 = zIsSetFixed;
            }
        } else {
            z3 = zIsFixed;
            str3 = defaultText;
        }
        if (!z2) {
            ((SchemaGlobalAttributeImpl) schemaField).setFilename(findFilename(attribute));
        }
        XmlCursor xmlCursorNewCursor = attribute.newCursor();
        String attributeText = xmlCursorNewCursor.getAttributeText(WSDL_ARRAYTYPE_NAME);
        xmlCursorNewCursor.dispose();
        if (attributeText != null) {
            try {
                sOAPArrayType = new SOAPArrayType(attributeText, new NamespaceContext(attribute));
            } catch (XmlValueOutOfRangeException unused) {
                stscState.error("soaparray", new Object[]{attributeText}, attribute);
            }
        }
        schemaField.init(ref, type.getRef(), i, str3, attribute, null, z3, sOAPArrayType, SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), attribute), getUserData(attribute));
        return schemaField;
    }

    static int translateUseCode(Attribute.Use use) {
        if (use == null) {
            return 2;
        }
        String stringValue = use.getStringValue();
        if (stringValue.equals("optional")) {
            return 2;
        }
        if (stringValue.equals("required")) {
            return 3;
        }
        return stringValue.equals("prohibited") ? 1 : 2;
    }

    static BigInteger buildBigInt(XmlAnySimpleType xmlAnySimpleType) {
        if (xmlAnySimpleType == null) {
            return null;
        }
        String stringValue = xmlAnySimpleType.getStringValue();
        try {
            BigInteger bigInteger = new BigInteger(stringValue);
            if (bigInteger.signum() >= 0) {
                return bigInteger;
            }
            StscState.get().error("invalid-value", new Object[]{stringValue, "nonNegativeInteger"}, (XmlObject) xmlAnySimpleType);
            return null;
        } catch (NumberFormatException e) {
            StscState.get().error("invalid-value-detail", new Object[]{stringValue, "nonNegativeInteger", e.getMessage()}, (XmlObject) xmlAnySimpleType);
            return null;
        }
    }

    static XmlNonNegativeInteger buildNnInteger(XmlAnySimpleType xmlAnySimpleType) {
        BigInteger bigIntegerBuildBigInt = buildBigInt(xmlAnySimpleType);
        try {
            XmlNonNegativeIntegerImpl xmlNonNegativeIntegerImpl = new XmlNonNegativeIntegerImpl();
            xmlNonNegativeIntegerImpl.set(bigIntegerBuildBigInt);
            xmlNonNegativeIntegerImpl.setImmutable();
            return xmlNonNegativeIntegerImpl;
        } catch (XmlValueOutOfRangeException unused) {
            StscState.get().error("Internal error processing number", 21, (XmlObject) xmlAnySimpleType);
            return null;
        }
    }

    static XmlPositiveInteger buildPosInteger(XmlAnySimpleType xmlAnySimpleType) {
        BigInteger bigIntegerBuildBigInt = buildBigInt(xmlAnySimpleType);
        try {
            XmlPositiveIntegerImpl xmlPositiveIntegerImpl = new XmlPositiveIntegerImpl();
            xmlPositiveIntegerImpl.set(bigIntegerBuildBigInt);
            xmlPositiveIntegerImpl.setImmutable();
            return xmlPositiveIntegerImpl;
        } catch (XmlValueOutOfRangeException unused) {
            StscState.get().error("Internal error processing number", 21, (XmlObject) xmlAnySimpleType);
            return null;
        }
    }

    private static Object getUserData(XmlObject xmlObject) {
        SchemaBookmark bookmark = xmlObject.newCursor().getBookmark(SchemaBookmark.class);
        if (bookmark == null || !(bookmark instanceof SchemaBookmark)) {
            return null;
        }
        return bookmark.getValue();
    }

    private static boolean isEmptySchema(SchemaDocument.Schema schema) {
        XmlCursor xmlCursorNewCursor = schema.newCursor();
        boolean z = !xmlCursorNewCursor.toFirstChild();
        xmlCursorNewCursor.dispose();
        return z;
    }

    private static boolean isReservedTypeName(QName qName) {
        if (BuiltinSchemaTypeSystem.get().findType(qName) != null) {
            return true;
        }
        return $assertionsDisabled;
    }
}
