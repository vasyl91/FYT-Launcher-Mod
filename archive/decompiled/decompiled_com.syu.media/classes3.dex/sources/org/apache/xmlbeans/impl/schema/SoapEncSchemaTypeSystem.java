package org.apache.xmlbeans.impl.schema;

import java.io.File;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.Filer;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SoapEncSchemaTypeSystem extends SchemaTypeLoaderBase implements SchemaTypeSystem {
    public static final String ARRAY_TYPE = "arrayType";
    private static final String ATTR_HREF = "href";
    private static final String ATTR_ID = "id";
    private static final String ATTR_OFFSET = "offset";
    public static final String SOAPENC = "http://schemas.xmlsoap.org/soap/encoding/";
    public static final String SOAP_ARRAY = "Array";
    private SchemaContainer _container;
    private Map _handlesToObjects = new HashMap();
    private SchemaGlobalAttributeImpl arrayType;
    private SchemaTypeImpl soapArray;
    private String soapArrayHandle;
    private static final SchemaType[] EMPTY_SCHEMATYPE_ARRAY = new SchemaType[0];
    private static final SchemaGlobalElement[] EMPTY_SCHEMAELEMENT_ARRAY = new SchemaGlobalElement[0];
    private static final SchemaModelGroup[] EMPTY_SCHEMAMODELGROUP_ARRAY = new SchemaModelGroup[0];
    private static final SchemaAttributeGroup[] EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY = new SchemaAttributeGroup[0];
    private static final SchemaAnnotation[] EMPTY_SCHEMAANNOTATION_ARRAY = new SchemaAnnotation[0];
    private static SoapEncSchemaTypeSystem _global = new SoapEncSchemaTypeSystem();

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase
    public SchemaAttributeGroup findAttributeGroup(QName qName) {
        return null;
    }

    public SchemaAttributeGroup.Ref findAttributeGroupRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase
    public SchemaType findAttributeType(QName qName) {
        return null;
    }

    public SchemaType.Ref findAttributeTypeRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase
    public SchemaType findDocumentType(QName qName) {
        return null;
    }

    public SchemaType.Ref findDocumentTypeRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase
    public SchemaGlobalElement findElement(QName qName) {
        return null;
    }

    public SchemaGlobalElement.Ref findElementRef(QName qName) {
        return null;
    }

    public SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase
    public SchemaModelGroup findModelGroup(QName qName) {
        return null;
    }

    public SchemaModelGroup.Ref findModelGroupRef(QName qName) {
        return null;
    }

    public String getName() {
        return "schema.typesystem.soapenc.builtin";
    }

    public InputStream getSourceAsStream(String str) {
        return null;
    }

    public void resolve() {
    }

    public SchemaType typeForClassname(String str) {
        return null;
    }

    public static SchemaTypeSystem get() {
        return _global;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private SoapEncSchemaTypeSystem() {
        SchemaContainer schemaContainer = new SchemaContainer("http://schemas.xmlsoap.org/soap/encoding/");
        this._container = schemaContainer;
        schemaContainer.setTypeSystem(this);
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(this._container, true);
        this.soapArray = schemaTypeImpl;
        this._container.addGlobalType(schemaTypeImpl.getRef());
        this.soapArray.setName(new QName("http://schemas.xmlsoap.org/soap/encoding/", SOAP_ARRAY));
        this.soapArrayHandle = SOAP_ARRAY.toLowerCase() + JamXmlElements.TYPE;
        this.soapArray.setComplexTypeVariety(3);
        this.soapArray.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_TYPE.getRef());
        this.soapArray.setBaseDepth(1);
        this.soapArray.setDerivationType(2);
        this.soapArray.setSimpleTypeVariety(0);
        SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
        schemaParticleImpl.setParticleType(3);
        schemaParticleImpl.setMinOccurs(BigInteger.ZERO);
        schemaParticleImpl.setMaxOccurs(BigInteger.ONE);
        schemaParticleImpl.setTransitionRules(QNameSet.ALL, true);
        schemaParticleImpl.setParticleChildren(new SchemaParticleImpl[]{schemaParticleImpl});
        SchemaParticleImpl schemaParticleImpl2 = new SchemaParticleImpl();
        schemaParticleImpl2.setParticleType(5);
        schemaParticleImpl2.setWildcardSet(QNameSet.ALL);
        schemaParticleImpl2.setWildcardProcess(2);
        schemaParticleImpl2.setMinOccurs(BigInteger.ZERO);
        schemaParticleImpl2.setMaxOccurs(null);
        schemaParticleImpl2.setTransitionRules(QNameSet.ALL, true);
        SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
        schemaAttributeModelImpl.setWildcardProcess(2);
        HashSet hashSet = new HashSet();
        hashSet.add("http://schemas.xmlsoap.org/soap/encoding/");
        schemaAttributeModelImpl.setWildcardSet(QNameSet.forSets(hashSet, (Set) null, Collections.EMPTY_SET, Collections.EMPTY_SET));
        SchemaLocalAttributeImpl schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
        schemaLocalAttributeImpl.init(new QName("", ATTR_ID), BuiltinSchemaTypeSystem.ST_ID.getRef(), 2, null, null, null, false, null, null, null);
        schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl);
        SchemaLocalAttributeImpl schemaLocalAttributeImpl2 = new SchemaLocalAttributeImpl();
        schemaLocalAttributeImpl2.init(new QName("", ATTR_HREF), BuiltinSchemaTypeSystem.ST_ANY_URI.getRef(), 2, null, null, null, false, null, null, null);
        schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl2);
        SchemaLocalAttributeImpl schemaLocalAttributeImpl3 = new SchemaLocalAttributeImpl();
        schemaLocalAttributeImpl3.init(new QName("http://schemas.xmlsoap.org/soap/encoding/", ARRAY_TYPE), BuiltinSchemaTypeSystem.ST_STRING.getRef(), 2, null, null, null, false, null, null, null);
        schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl3);
        SchemaLocalAttributeImpl schemaLocalAttributeImpl4 = new SchemaLocalAttributeImpl();
        schemaLocalAttributeImpl4.init(new QName("http://schemas.xmlsoap.org/soap/encoding/", ATTR_OFFSET), BuiltinSchemaTypeSystem.ST_STRING.getRef(), 2, null, null, null, false, null, null, null);
        schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl4);
        this.soapArray.setContentModel(schemaParticleImpl, schemaAttributeModelImpl, Collections.EMPTY_MAP, Collections.EMPTY_MAP, false);
        SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = new SchemaGlobalAttributeImpl(this._container);
        this.arrayType = schemaGlobalAttributeImpl;
        this._container.addGlobalAttribute(schemaGlobalAttributeImpl.getRef());
        this.arrayType.init(new QName("http://schemas.xmlsoap.org/soap/encoding/", ARRAY_TYPE), BuiltinSchemaTypeSystem.ST_STRING.getRef(), 2, null, null, null, false, null, null, null);
        this._handlesToObjects.put(this.soapArrayHandle, this.soapArray);
        this._handlesToObjects.put(ARRAY_TYPE.toLowerCase() + "attribute", this.arrayType);
        this._container.setImmutable();
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase
    public SchemaType findType(QName qName) {
        if ("http://schemas.xmlsoap.org/soap/encoding/".equals(qName.getNamespaceURI()) && SOAP_ARRAY.equals(qName.getLocalPart())) {
            return this.soapArray;
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase
    public SchemaGlobalAttribute findAttribute(QName qName) {
        if ("http://schemas.xmlsoap.org/soap/encoding/".equals(qName.getNamespaceURI()) && ARRAY_TYPE.equals(qName.getLocalPart())) {
            return this.arrayType;
        }
        return null;
    }

    public boolean isNamespaceDefined(String str) {
        return "http://schemas.xmlsoap.org/soap/encoding/".equals(str);
    }

    public SchemaType.Ref findTypeRef(QName qName) {
        SchemaType schemaTypeFindType = findType(qName);
        if (schemaTypeFindType == null) {
            return null;
        }
        return schemaTypeFindType.getRef();
    }

    public SchemaGlobalAttribute.Ref findAttributeRef(QName qName) {
        SchemaGlobalAttribute schemaGlobalAttributeFindAttribute = findAttribute(qName);
        if (schemaGlobalAttributeFindAttribute == null) {
            return null;
        }
        return schemaGlobalAttributeFindAttribute.getRef();
    }

    public ClassLoader getClassLoader() {
        return SoapEncSchemaTypeSystem.class.getClassLoader();
    }

    public SchemaType[] globalTypes() {
        return new SchemaType[]{this.soapArray};
    }

    public SchemaType[] documentTypes() {
        return EMPTY_SCHEMATYPE_ARRAY;
    }

    public SchemaType[] attributeTypes() {
        return EMPTY_SCHEMATYPE_ARRAY;
    }

    public SchemaGlobalElement[] globalElements() {
        return EMPTY_SCHEMAELEMENT_ARRAY;
    }

    public SchemaGlobalAttribute[] globalAttributes() {
        return new SchemaGlobalAttribute[]{this.arrayType};
    }

    public SchemaModelGroup[] modelGroups() {
        return EMPTY_SCHEMAMODELGROUP_ARRAY;
    }

    public SchemaAttributeGroup[] attributeGroups() {
        return EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY;
    }

    public SchemaAnnotation[] annotations() {
        return EMPTY_SCHEMAANNOTATION_ARRAY;
    }

    public String handleForType(SchemaType schemaType) {
        if (this.soapArray.equals(schemaType)) {
            return this.soapArrayHandle;
        }
        return null;
    }

    public SchemaComponent resolveHandle(String str) {
        return (SchemaComponent) this._handlesToObjects.get(str);
    }

    public SchemaType typeForHandle(String str) {
        return (SchemaType) this._handlesToObjects.get(str);
    }

    public void saveToDirectory(File file) {
        throw new UnsupportedOperationException("The builtin soap encoding schema type system cannot be saved.");
    }

    public void save(Filer filer) {
        throw new UnsupportedOperationException("The builtin soap encoding schema type system cannot be saved.");
    }
}
