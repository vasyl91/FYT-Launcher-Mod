package org.apache.xmlbeans.impl.schema;

import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.InterfaceExtension;
import org.apache.xmlbeans.PrePostExtension;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.QNameSetBuilder;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeElementSequencer;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.values.StringEnumValue;
import org.apache.xmlbeans.impl.values.TypeStoreUser;
import org.apache.xmlbeans.impl.values.TypeStoreUserFactory;
import org.apache.xmlbeans.impl.values.XmlAnySimpleTypeImpl;
import org.apache.xmlbeans.impl.values.XmlAnySimpleTypeRestriction;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.apache.xmlbeans.impl.values.XmlAnyUriImpl;
import org.apache.xmlbeans.impl.values.XmlAnyUriRestriction;
import org.apache.xmlbeans.impl.values.XmlBase64BinaryImpl;
import org.apache.xmlbeans.impl.values.XmlBase64BinaryRestriction;
import org.apache.xmlbeans.impl.values.XmlBooleanImpl;
import org.apache.xmlbeans.impl.values.XmlBooleanRestriction;
import org.apache.xmlbeans.impl.values.XmlByteImpl;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.values.XmlDateImpl;
import org.apache.xmlbeans.impl.values.XmlDateTimeImpl;
import org.apache.xmlbeans.impl.values.XmlDecimalImpl;
import org.apache.xmlbeans.impl.values.XmlDecimalRestriction;
import org.apache.xmlbeans.impl.values.XmlDoubleImpl;
import org.apache.xmlbeans.impl.values.XmlDoubleRestriction;
import org.apache.xmlbeans.impl.values.XmlDurationImpl;
import org.apache.xmlbeans.impl.values.XmlEntitiesImpl;
import org.apache.xmlbeans.impl.values.XmlEntityImpl;
import org.apache.xmlbeans.impl.values.XmlFloatImpl;
import org.apache.xmlbeans.impl.values.XmlFloatRestriction;
import org.apache.xmlbeans.impl.values.XmlGDayImpl;
import org.apache.xmlbeans.impl.values.XmlGMonthDayImpl;
import org.apache.xmlbeans.impl.values.XmlGMonthImpl;
import org.apache.xmlbeans.impl.values.XmlGYearImpl;
import org.apache.xmlbeans.impl.values.XmlGYearMonthImpl;
import org.apache.xmlbeans.impl.values.XmlHexBinaryImpl;
import org.apache.xmlbeans.impl.values.XmlHexBinaryRestriction;
import org.apache.xmlbeans.impl.values.XmlIdImpl;
import org.apache.xmlbeans.impl.values.XmlIdRefImpl;
import org.apache.xmlbeans.impl.values.XmlIdRefsImpl;
import org.apache.xmlbeans.impl.values.XmlIntImpl;
import org.apache.xmlbeans.impl.values.XmlIntRestriction;
import org.apache.xmlbeans.impl.values.XmlIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlIntegerRestriction;
import org.apache.xmlbeans.impl.values.XmlLanguageImpl;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.values.XmlLongImpl;
import org.apache.xmlbeans.impl.values.XmlLongRestriction;
import org.apache.xmlbeans.impl.values.XmlNCNameImpl;
import org.apache.xmlbeans.impl.values.XmlNameImpl;
import org.apache.xmlbeans.impl.values.XmlNegativeIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlNmTokenImpl;
import org.apache.xmlbeans.impl.values.XmlNmTokensImpl;
import org.apache.xmlbeans.impl.values.XmlNonNegativeIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlNonPositiveIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlNormalizedStringImpl;
import org.apache.xmlbeans.impl.values.XmlNotationImpl;
import org.apache.xmlbeans.impl.values.XmlNotationRestriction;
import org.apache.xmlbeans.impl.values.XmlObjectBase;
import org.apache.xmlbeans.impl.values.XmlPositiveIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlQNameImpl;
import org.apache.xmlbeans.impl.values.XmlQNameRestriction;
import org.apache.xmlbeans.impl.values.XmlShortImpl;
import org.apache.xmlbeans.impl.values.XmlStringEnumeration;
import org.apache.xmlbeans.impl.values.XmlStringImpl;
import org.apache.xmlbeans.impl.values.XmlStringRestriction;
import org.apache.xmlbeans.impl.values.XmlTimeImpl;
import org.apache.xmlbeans.impl.values.XmlTokenImpl;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.apache.xmlbeans.impl.values.XmlUnsignedByteImpl;
import org.apache.xmlbeans.impl.values.XmlUnsignedIntImpl;
import org.apache.xmlbeans.impl.values.XmlUnsignedLongImpl;
import org.apache.xmlbeans.impl.values.XmlUnsignedShortImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class SchemaTypeImpl implements SchemaType, TypeStoreUserFactory {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int JAVAIZED = 6;
    private static final int JAVAIZING = 5;
    private static final SchemaProperty[] NO_PROPERTIES = new SchemaProperty[0];
    private static final int RESOLVED = 4;
    private static final int RESOLVED_SGS = 2;
    private static final int RESOLVING = 3;
    private static final int RESOLVING_SGS = 1;
    private static final int UNRESOLVED = 0;
    private boolean _abs;
    private SchemaAnnotation _annotation;
    private SchemaType.Ref[] _anonymousTyperefs;
    private int _anonymousUnionMemberOrdinal;
    private String _attFormDefault;
    private volatile Map _attrToIndexMap;
    private SchemaAttributeModel _attributeModel;
    private int _baseDepth;
    private SchemaType.Ref _baseEnumTyperef;
    private SchemaType.Ref _baseTyperef;
    private boolean _blockExt;
    private boolean _blockRest;
    private int _builtinTypeCode;
    private boolean _chameleon;
    private int _complexTypeVariety;
    private SchemaContainer _container;
    private volatile SchemaField _containerField;
    private volatile int _containerFieldCode;
    private volatile int _containerFieldIndex;
    private volatile SchemaComponent.Ref _containerFieldRef;
    private SchemaType.Ref _contentBasedOnTyperef;
    private SchemaParticle _contentModel;
    private int _decimalSize;
    private int _derivationType;
    private String _elemFormDefault;
    private volatile Map _eltToIndexMap;
    private XmlValueRef[] _enumerationValues;
    private XmlValueRef[] _facetArray;
    private String _filename;
    private boolean _finalExt;
    private boolean _finalList;
    private boolean _finalRest;
    private boolean _finalUnion;
    private boolean[] _fixedFacetArray;
    private String _fullJavaImplName;
    private String _fullJavaName;
    private volatile QName[] _groupReferenceContext;
    private boolean _hasAllContent;
    private boolean _hasPatterns;
    private boolean _hasWildcardAttributes;
    private boolean _hasWildcardElements;
    private volatile boolean _implNotAvailable;
    private InterfaceExtension[] _interfaces;
    private boolean _isAttributeType;
    private boolean _isBounded;
    private boolean _isCompiled;
    private boolean _isDocumentType;
    private boolean _isFinite;
    private boolean _isNumeric;
    private boolean _isSimpleType;
    private boolean _isUnionOfLists;
    private volatile Class _javaClass;
    private volatile Class _javaEnumClass;
    private volatile Class _javaImplClass;
    private volatile Constructor _javaImplConstructor;
    private volatile Constructor _javaImplConstructor2;
    private SchemaType.Ref _listItemTyperef;
    private volatile List _listOfStringEnum;
    private volatile SchemaLocalElement[] _localElts;
    private volatile Map _lookupStringEnum;
    private volatile Map _lookupStringEnumEntry;
    private QName _name;
    private boolean _orderSensitive;
    private int _ordered;
    private SchemaType.Ref _outerSchemaTypeRef;
    private XmlObject _parseObject;
    private String _parseTNS;
    private RegularExpression[] _patterns;
    private PrePostExtension _prepost;
    private SchemaType.Ref _primitiveTypeRef;
    private Map _propertyModelByAttributeName;
    private Map _propertyModelByElementName;
    private boolean _redefinition;
    private int _resolvePhase;
    private QName _sg;
    private String _shortJavaImplName;
    private String _shortJavaName;
    private int _simpleTypeVariety;
    private boolean _stringEnumEnsured;
    private SchemaStringEnumEntry[] _stringEnumEntries;
    private QNameSet _typedWildcardAttributes;
    private QNameSet _typedWildcardElements;
    private volatile SchemaType _unionCommonBaseType;
    private volatile SchemaType[] _unionConstituentTypes;
    private SchemaType.Ref[] _unionMemberTyperefs;
    private volatile SchemaType[] _unionSubTypes;
    private volatile boolean _unloaded;
    private volatile Object _userData;
    private volatile Class _userTypeClass;
    private String _userTypeHandler;
    private volatile Class _userTypeHandlerClass;
    private String _userTypeName;
    private int _whiteSpaceRule;
    private final Object[] _ctrArgs = {this};
    private Set _validSubstitutions = Collections.EMPTY_SET;
    private List _sgMembers = new ArrayList();
    private SchemaType.Ref _selfref = new SchemaType.Ref(this);

    public int getComponentType() {
        return 0;
    }

    public boolean isUnloaded() {
        return this._unloaded;
    }

    public void finishLoading() {
        this._unloaded = $assertionsDisabled;
    }

    SchemaTypeImpl(SchemaContainer schemaContainer) {
        this._container = schemaContainer;
    }

    SchemaTypeImpl(SchemaContainer schemaContainer, boolean z) {
        this._container = schemaContainer;
        this._unloaded = z;
        if (z) {
            finishQuick();
        }
    }

    public boolean isSGResolved() {
        if (this._resolvePhase >= 2) {
            return true;
        }
        return $assertionsDisabled;
    }

    public boolean isSGResolving() {
        if (this._resolvePhase >= 1) {
            return true;
        }
        return $assertionsDisabled;
    }

    public boolean isResolved() {
        if (this._resolvePhase >= 4) {
            return true;
        }
        return $assertionsDisabled;
    }

    public boolean isResolving() {
        if (this._resolvePhase == 3) {
            return true;
        }
        return $assertionsDisabled;
    }

    public boolean isUnjavaized() {
        if (this._resolvePhase < 6) {
            return true;
        }
        return $assertionsDisabled;
    }

    public boolean isJavaized() {
        if (this._resolvePhase == 6) {
            return true;
        }
        return $assertionsDisabled;
    }

    public void startResolvingSGs() {
        if (this._resolvePhase != 0) {
            throw new IllegalStateException();
        }
        this._resolvePhase = 1;
    }

    public void finishResolvingSGs() {
        if (this._resolvePhase != 1) {
            throw new IllegalStateException();
        }
        this._resolvePhase = 2;
    }

    public void startResolving() {
        boolean z = this._isDocumentType;
        if ((z && this._resolvePhase != 2) || (!z && this._resolvePhase != 0)) {
            throw new IllegalStateException();
        }
        this._resolvePhase = 3;
    }

    public void finishResolving() {
        if (this._resolvePhase != 3) {
            throw new IllegalStateException();
        }
        this._resolvePhase = 4;
    }

    public void startJavaizing() {
        if (this._resolvePhase != 4) {
            throw new IllegalStateException();
        }
        this._resolvePhase = 5;
    }

    public void finishJavaizing() {
        if (this._resolvePhase != 5) {
            throw new IllegalStateException();
        }
        this._resolvePhase = 6;
    }

    private void finishQuick() {
        this._resolvePhase = 6;
    }

    private void assertUnresolved() {
        if (this._resolvePhase != 0 && !this._unloaded) {
            throw new IllegalStateException();
        }
    }

    private void assertSGResolving() {
        if (this._resolvePhase != 1 && !this._unloaded) {
            throw new IllegalStateException();
        }
    }

    private void assertSGResolved() {
        if (this._resolvePhase != 2 && !this._unloaded) {
            throw new IllegalStateException();
        }
    }

    private void assertResolving() {
        if (this._resolvePhase != 3 && !this._unloaded) {
            throw new IllegalStateException();
        }
    }

    private void assertResolved() {
        if (this._resolvePhase != 4 && !this._unloaded) {
            throw new IllegalStateException();
        }
    }

    private void assertJavaizing() {
        if (this._resolvePhase != 5 && !this._unloaded) {
            throw new IllegalStateException();
        }
    }

    public QName getName() {
        return this._name;
    }

    public void setName(QName qName) {
        assertUnresolved();
        this._name = qName;
    }

    public String getSourceName() {
        String str = this._filename;
        if (str != null) {
            return str;
        }
        if (getOuterType() != null) {
            return getOuterType().getSourceName();
        }
        SchemaGlobalElement containerField = getContainerField();
        if (containerField == null) {
            return null;
        }
        if (containerField instanceof SchemaGlobalElement) {
            return containerField.getSourceName();
        }
        if (containerField instanceof SchemaGlobalAttribute) {
            return ((SchemaGlobalAttribute) containerField).getSourceName();
        }
        return null;
    }

    public void setFilename(String str) {
        assertUnresolved();
        this._filename = str;
    }

    public boolean isAnonymousType() {
        if (this._name == null) {
            return true;
        }
        return $assertionsDisabled;
    }

    public boolean isDocumentType() {
        return this._isDocumentType;
    }

    public boolean isAttributeType() {
        return this._isAttributeType;
    }

    public QName getDocumentElementName() {
        SchemaParticle contentModel;
        if (!this._isDocumentType || (contentModel = getContentModel()) == null) {
            return null;
        }
        return contentModel.getName();
    }

    public QName getAttributeTypeAttributeName() {
        SchemaAttributeModel attributeModel;
        SchemaLocalAttribute[] attributes;
        if (!this._isAttributeType || (attributeModel = getAttributeModel()) == null || (attributes = attributeModel.getAttributes()) == null || attributes.length <= 0) {
            return null;
        }
        return attributes[0].getName();
    }

    public void setAnnotation(SchemaAnnotation schemaAnnotation) {
        assertUnresolved();
        this._annotation = schemaAnnotation;
    }

    public SchemaAnnotation getAnnotation() {
        return this._annotation;
    }

    public void setDocumentType(boolean z) {
        assertUnresolved();
        this._isDocumentType = z;
    }

    public void setAttributeType(boolean z) {
        assertUnresolved();
        this._isAttributeType = z;
    }

    public int getContentType() {
        return this._complexTypeVariety;
    }

    public void setComplexTypeVariety(int i) {
        assertResolving();
        this._complexTypeVariety = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SchemaTypeElementSequencer getElementSequencer() {
        SchemaTypeVisitorImpl schemaTypeVisitorImpl = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (this._complexTypeVariety == 0) {
            return new SequencerImpl(schemaTypeVisitorImpl);
        }
        return new SequencerImpl(new SchemaTypeVisitorImpl(this._contentModel));
    }

    void setAbstractFinal(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        assertResolving();
        this._abs = z;
        this._finalExt = z2;
        this._finalRest = z3;
        this._finalList = z4;
        this._finalUnion = z5;
    }

    void setSimpleFinal(boolean z, boolean z2, boolean z3) {
        assertResolving();
        this._finalRest = z;
        this._finalList = z2;
        this._finalUnion = z3;
    }

    void setBlock(boolean z, boolean z2) {
        assertResolving();
        this._blockExt = z;
        this._blockRest = z2;
    }

    public boolean blockRestriction() {
        return this._blockRest;
    }

    public boolean blockExtension() {
        return this._blockExt;
    }

    public boolean isAbstract() {
        return this._abs;
    }

    public boolean finalExtension() {
        return this._finalExt;
    }

    public boolean finalRestriction() {
        return this._finalRest;
    }

    public boolean finalList() {
        return this._finalList;
    }

    public boolean finalUnion() {
        return this._finalUnion;
    }

    public synchronized SchemaField getContainerField() {
        if (this._containerFieldCode != -1) {
            SchemaType outerType = getOuterType();
            if (this._containerFieldCode == 0) {
                this._containerField = this._containerFieldRef == null ? null : this._containerFieldRef.getComponent();
            } else if (this._containerFieldCode == 1) {
                this._containerField = outerType.getAttributeModel().getAttributes()[this._containerFieldIndex];
            } else {
                this._containerField = ((SchemaTypeImpl) outerType).getLocalElementByIndex(this._containerFieldIndex);
            }
            this._containerFieldCode = -1;
        }
        return this._containerField;
    }

    public void setContainerField(SchemaField schemaField) {
        assertUnresolved();
        this._containerField = schemaField;
        this._containerFieldCode = -1;
    }

    public void setContainerFieldRef(SchemaComponent.Ref ref) {
        assertUnresolved();
        this._containerFieldRef = ref;
        this._containerFieldCode = 0;
    }

    public void setContainerFieldIndex(short s, int i) {
        assertUnresolved();
        this._containerFieldCode = s;
        this._containerFieldIndex = i;
    }

    void setGroupReferenceContext(QName[] qNameArr) {
        assertUnresolved();
        this._groupReferenceContext = qNameArr;
    }

    QName[] getGroupReferenceContext() {
        return this._groupReferenceContext;
    }

    public SchemaType getOuterType() {
        SchemaType.Ref ref = this._outerSchemaTypeRef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public void setOuterSchemaTypeRef(SchemaType.Ref ref) {
        assertUnresolved();
        this._outerSchemaTypeRef = ref;
    }

    public boolean isCompiled() {
        return this._isCompiled;
    }

    public void setCompiled(boolean z) {
        assertJavaizing();
        this._isCompiled = z;
    }

    public boolean isSkippedAnonymousType() {
        SchemaType outerType = getOuterType();
        if (outerType == null) {
            return $assertionsDisabled;
        }
        if (outerType.getBaseType() == this || outerType.getContentBasedOnType() == this) {
            return true;
        }
        return $assertionsDisabled;
    }

    public String getShortJavaName() {
        return this._shortJavaName;
    }

    public void setShortJavaName(String str) {
        assertResolved();
        this._shortJavaName = str;
        SchemaType outerType = this._outerSchemaTypeRef.get();
        while (outerType.getFullJavaName() == null) {
            outerType = outerType.getOuterType();
        }
        this._fullJavaName = outerType.getFullJavaName() + "$" + this._shortJavaName;
    }

    public String getFullJavaName() {
        return this._fullJavaName;
    }

    public void setFullJavaName(String str) {
        assertResolved();
        this._fullJavaName = str;
        this._shortJavaName = this._fullJavaName.substring(Math.max(str.lastIndexOf(36), this._fullJavaName.lastIndexOf(46)) + 1);
    }

    public void setShortJavaImplName(String str) {
        assertResolved();
        this._shortJavaImplName = str;
        SchemaType outerType = this._outerSchemaTypeRef.get();
        while (outerType.getFullJavaImplName() == null) {
            outerType = outerType.getOuterType();
        }
        this._fullJavaImplName = outerType.getFullJavaImplName() + "$" + this._shortJavaImplName;
    }

    public void setFullJavaImplName(String str) {
        assertResolved();
        this._fullJavaImplName = str;
        this._shortJavaImplName = this._fullJavaImplName.substring(Math.max(str.lastIndexOf(36), this._fullJavaImplName.lastIndexOf(46)) + 1);
    }

    public String getFullJavaImplName() {
        return this._fullJavaImplName;
    }

    public String getShortJavaImplName() {
        return this._shortJavaImplName;
    }

    public String getUserTypeName() {
        return this._userTypeName;
    }

    public void setUserTypeName(String str) {
        this._userTypeName = str;
    }

    public String getUserTypeHandlerName() {
        return this._userTypeHandler;
    }

    public void setUserTypeHandlerName(String str) {
        this._userTypeHandler = str;
    }

    public void setInterfaceExtensions(InterfaceExtension[] interfaceExtensionArr) {
        assertResolved();
        this._interfaces = interfaceExtensionArr;
    }

    public InterfaceExtension[] getInterfaceExtensions() {
        return this._interfaces;
    }

    public void setPrePostExtension(PrePostExtension prePostExtension) {
        assertResolved();
        this._prepost = prePostExtension;
    }

    public PrePostExtension getPrePostExtension() {
        return this._prepost;
    }

    public Object getUserData() {
        return this._userData;
    }

    public void setUserData(Object obj) {
        this._userData = obj;
    }

    SchemaContainer getContainer() {
        return this._container;
    }

    void setContainer(SchemaContainer schemaContainer) {
        this._container = schemaContainer;
    }

    public SchemaTypeSystem getTypeSystem() {
        return this._container.getTypeSystem();
    }

    public SchemaParticle getContentModel() {
        return this._contentModel;
    }

    private static void buildEltList(List list, SchemaParticle schemaParticle) {
        if (schemaParticle == null) {
            return;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType != 1 && particleType != 2 && particleType != 3) {
            if (particleType != 4) {
                return;
            }
            list.add(schemaParticle);
        } else {
            for (int i = 0; i < schemaParticle.countOfParticleChild(); i++) {
                buildEltList(list, schemaParticle.getParticleChild(i));
            }
        }
    }

    private void buildLocalElts() {
        ArrayList arrayList = new ArrayList();
        buildEltList(arrayList, this._contentModel);
        this._localElts = (SchemaLocalElement[]) arrayList.toArray(new SchemaLocalElement[arrayList.size()]);
    }

    public SchemaLocalElement getLocalElementByIndex(int i) {
        SchemaLocalElement[] schemaLocalElementArr = this._localElts;
        if (schemaLocalElementArr == null) {
            buildLocalElts();
            schemaLocalElementArr = this._localElts;
        }
        return schemaLocalElementArr[i];
    }

    public int getIndexForLocalElement(SchemaLocalElement schemaLocalElement) {
        Map map = this._eltToIndexMap;
        if (map == null) {
            if (this._localElts == null) {
                buildLocalElts();
            }
            map = new HashMap();
            for (int i = 0; i < this._localElts.length; i++) {
                map.put(this._localElts[i], new Integer(i));
            }
            this._eltToIndexMap = map;
        }
        return ((Integer) map.get(schemaLocalElement)).intValue();
    }

    public int getIndexForLocalAttribute(SchemaLocalAttribute schemaLocalAttribute) {
        Map map = this._attrToIndexMap;
        if (map == null) {
            map = new HashMap();
            SchemaLocalAttribute[] attributes = this._attributeModel.getAttributes();
            for (int i = 0; i < attributes.length; i++) {
                map.put(attributes[i], new Integer(i));
            }
            this._attrToIndexMap = map;
        }
        return ((Integer) map.get(schemaLocalAttribute)).intValue();
    }

    public SchemaAttributeModel getAttributeModel() {
        return this._attributeModel;
    }

    public SchemaProperty[] getProperties() {
        if (this._propertyModelByElementName == null) {
            return getAttributeProperties();
        }
        if (this._propertyModelByAttributeName == null) {
            return getElementProperties();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this._propertyModelByElementName.values());
        arrayList.addAll(this._propertyModelByAttributeName.values());
        return (SchemaProperty[]) arrayList.toArray(new SchemaProperty[arrayList.size()]);
    }

    public SchemaProperty[] getDerivedProperties() {
        SchemaType baseType = getBaseType();
        if (baseType == null) {
            return getProperties();
        }
        ArrayList arrayList = new ArrayList();
        Map map = this._propertyModelByElementName;
        if (map != null) {
            arrayList.addAll(map.values());
        }
        Map map2 = this._propertyModelByAttributeName;
        if (map2 != null) {
            arrayList.addAll(map2.values());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            SchemaProperty schemaProperty = (SchemaProperty) it.next();
            SchemaProperty attributeProperty = schemaProperty.isAttribute() ? baseType.getAttributeProperty(schemaProperty.getName()) : baseType.getElementProperty(schemaProperty.getName());
            if (attributeProperty != null && eq(schemaProperty.getMinOccurs(), attributeProperty.getMinOccurs()) && eq(schemaProperty.getMaxOccurs(), attributeProperty.getMaxOccurs()) && schemaProperty.hasNillable() == attributeProperty.hasNillable() && eq(schemaProperty.getDefaultText(), attributeProperty.getDefaultText())) {
                it.remove();
            }
        }
        return (SchemaProperty[]) arrayList.toArray(new SchemaProperty[arrayList.size()]);
    }

    private static boolean eq(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger == null && bigInteger2 == null) {
            return true;
        }
        return (bigInteger == null || bigInteger2 == null) ? $assertionsDisabled : bigInteger.equals(bigInteger2);
    }

    private static boolean eq(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        return (str == null || str2 == null) ? $assertionsDisabled : str.equals(str2);
    }

    public SchemaProperty[] getElementProperties() {
        Map map = this._propertyModelByElementName;
        if (map == null) {
            return NO_PROPERTIES;
        }
        return (SchemaProperty[]) map.values().toArray(new SchemaProperty[this._propertyModelByElementName.size()]);
    }

    public SchemaProperty[] getAttributeProperties() {
        Map map = this._propertyModelByAttributeName;
        if (map == null) {
            return NO_PROPERTIES;
        }
        return (SchemaProperty[]) map.values().toArray(new SchemaProperty[this._propertyModelByAttributeName.size()]);
    }

    public SchemaProperty getElementProperty(QName qName) {
        Map map = this._propertyModelByElementName;
        if (map == null) {
            return null;
        }
        return (SchemaProperty) map.get(qName);
    }

    public SchemaProperty getAttributeProperty(QName qName) {
        Map map = this._propertyModelByAttributeName;
        if (map == null) {
            return null;
        }
        return (SchemaProperty) map.get(qName);
    }

    public boolean hasAllContent() {
        return this._hasAllContent;
    }

    public boolean isOrderSensitive() {
        return this._orderSensitive;
    }

    public void setOrderSensitive(boolean z) {
        assertJavaizing();
        this._orderSensitive = z;
    }

    public void setContentModel(SchemaParticle schemaParticle, SchemaAttributeModel schemaAttributeModel, Map map, Map map2, boolean z) {
        assertResolving();
        this._contentModel = schemaParticle;
        this._attributeModel = schemaAttributeModel;
        this._propertyModelByElementName = map;
        this._propertyModelByAttributeName = map2;
        this._hasAllContent = z;
        if (map != null) {
            this._validSubstitutions = new LinkedHashSet();
            Iterator it = this._propertyModelByElementName.values().iterator();
            while (it.hasNext()) {
                QName[] qNameArrAcceptedNames = ((SchemaProperty) it.next()).acceptedNames();
                for (int i = 0; i < qNameArrAcceptedNames.length; i++) {
                    if (!this._propertyModelByElementName.containsKey(qNameArrAcceptedNames[i])) {
                        this._validSubstitutions.add(qNameArrAcceptedNames[i]);
                    }
                }
            }
        }
    }

    private boolean containsElements() {
        if (getContentType() == 3 || getContentType() == 4) {
            return true;
        }
        return $assertionsDisabled;
    }

    public boolean hasAttributeWildcards() {
        return this._hasWildcardAttributes;
    }

    public boolean hasElementWildcards() {
        return this._hasWildcardElements;
    }

    public boolean isValidSubstitution(QName qName) {
        return this._validSubstitutions.contains(qName);
    }

    public SchemaType getElementType(QName qName, QName qName2, SchemaTypeLoader schemaTypeLoader) {
        SchemaType type;
        SchemaType schemaTypeFindType;
        if (isSimpleType() || !containsElements() || isNoType()) {
            return BuiltinSchemaTypeSystem.ST_NO_TYPE;
        }
        SchemaProperty schemaProperty = (SchemaProperty) this._propertyModelByElementName.get(qName);
        if (schemaProperty != null) {
            type = schemaProperty.getType();
        } else {
            if (schemaTypeLoader == null) {
                return BuiltinSchemaTypeSystem.ST_NO_TYPE;
            }
            if (this._typedWildcardElements.contains(qName) || this._validSubstitutions.contains(qName)) {
                SchemaGlobalElement schemaGlobalElementFindElement = schemaTypeLoader.findElement(qName);
                if (schemaGlobalElementFindElement == null) {
                    return BuiltinSchemaTypeSystem.ST_NO_TYPE;
                }
                type = schemaGlobalElementFindElement.getType();
            } else {
                return BuiltinSchemaTypeSystem.ST_NO_TYPE;
            }
        }
        return (qName2 == null || schemaTypeLoader == null || (schemaTypeFindType = schemaTypeLoader.findType(qName2)) == null || !type.isAssignableFrom(schemaTypeFindType)) ? type : schemaTypeFindType;
    }

    public SchemaType getAttributeType(QName qName, SchemaTypeLoader schemaTypeLoader) {
        if (isSimpleType() || isNoType()) {
            return BuiltinSchemaTypeSystem.ST_NO_TYPE;
        }
        if (isURType()) {
            return BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        SchemaProperty schemaProperty = (SchemaProperty) this._propertyModelByAttributeName.get(qName);
        if (schemaProperty != null) {
            return schemaProperty.getType();
        }
        if (!this._typedWildcardAttributes.contains(qName) || schemaTypeLoader == null) {
            return BuiltinSchemaTypeSystem.ST_NO_TYPE;
        }
        SchemaGlobalAttribute schemaGlobalAttributeFindAttribute = schemaTypeLoader.findAttribute(qName);
        if (schemaGlobalAttributeFindAttribute == null) {
            return BuiltinSchemaTypeSystem.ST_NO_TYPE;
        }
        return schemaGlobalAttributeFindAttribute.getType();
    }

    public XmlObject createElementType(QName qName, QName qName2, SchemaTypeLoader schemaTypeLoader) {
        SchemaType type;
        SchemaProperty elementProperty;
        SchemaGlobalElement schemaGlobalElementFindElement;
        SchemaType schemaTypeFindType;
        if (isSimpleType() || !containsElements() || isNoType()) {
            type = BuiltinSchemaTypeSystem.ST_NO_TYPE;
            elementProperty = null;
        } else {
            elementProperty = (SchemaProperty) this._propertyModelByElementName.get(qName);
            if (elementProperty != null) {
                type = elementProperty.getType();
            } else if ((this._typedWildcardElements.contains(qName) || this._validSubstitutions.contains(qName)) && (schemaGlobalElementFindElement = schemaTypeLoader.findElement(qName)) != null) {
                SchemaType type2 = schemaGlobalElementFindElement.getType();
                SchemaType schemaTypeFindDocumentType = schemaTypeLoader.findDocumentType(qName);
                if (schemaTypeFindDocumentType != null) {
                    elementProperty = schemaTypeFindDocumentType.getElementProperty(qName);
                }
                type = type2;
            } else {
                type = BuiltinSchemaTypeSystem.ST_NO_TYPE;
            }
            if (qName2 != null && (schemaTypeFindType = schemaTypeLoader.findType(qName2)) != null && type.isAssignableFrom(schemaTypeFindType)) {
                type = schemaTypeFindType;
            }
        }
        if (type != null) {
            return ((SchemaTypeImpl) type).createUnattachedNode(elementProperty);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:25:0x004d A[RETURN] */
    public XmlObject createAttributeType(QName qName, SchemaTypeLoader schemaTypeLoader) {
        SchemaTypeImpl schemaTypeImpl;
        SchemaProperty schemaProperty;
        SchemaGlobalAttribute schemaGlobalAttributeFindAttribute;
        if (isSimpleType() || isNoType()) {
            schemaTypeImpl = BuiltinSchemaTypeSystem.ST_NO_TYPE;
        } else {
            if (isURType()) {
                schemaTypeImpl = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
            } else {
                schemaProperty = (SchemaProperty) this._propertyModelByAttributeName.get(qName);
                if (schemaProperty != null) {
                    schemaTypeImpl = (SchemaTypeImpl) schemaProperty.getType();
                } else if (this._typedWildcardAttributes.contains(qName) && (schemaGlobalAttributeFindAttribute = schemaTypeLoader.findAttribute(qName)) != null) {
                    schemaTypeImpl = (SchemaTypeImpl) schemaGlobalAttributeFindAttribute.getType();
                } else {
                    schemaTypeImpl = BuiltinSchemaTypeSystem.ST_NO_TYPE;
                }
            }
            if (schemaTypeImpl != null) {
                return schemaTypeImpl.createUnattachedNode(schemaProperty);
            }
            return null;
        }
        schemaProperty = null;
        if (schemaTypeImpl != null) {
            return schemaTypeImpl.createUnattachedNode(schemaProperty);
        }
        return null;
    }

    public void setWildcardSummary(QNameSet qNameSet, boolean z, QNameSet qNameSet2, boolean z2) {
        assertResolving();
        this._typedWildcardElements = qNameSet;
        this._hasWildcardElements = z;
        this._typedWildcardAttributes = qNameSet2;
        this._hasWildcardAttributes = z2;
    }

    public SchemaType[] getAnonymousTypes() {
        int length = this._anonymousTyperefs.length;
        SchemaType[] schemaTypeArr = new SchemaType[length];
        for (int i = 0; i < length; i++) {
            schemaTypeArr[i] = this._anonymousTyperefs[i].get();
        }
        return schemaTypeArr;
    }

    public void setAnonymousTypeRefs(SchemaType.Ref[] refArr) {
        this._anonymousTyperefs = refArr;
    }

    private static SchemaType[] staCopy(SchemaType[] schemaTypeArr) {
        if (schemaTypeArr == null) {
            return null;
        }
        SchemaType[] schemaTypeArr2 = new SchemaType[schemaTypeArr.length];
        System.arraycopy(schemaTypeArr, 0, schemaTypeArr2, 0, schemaTypeArr.length);
        return schemaTypeArr2;
    }

    private static boolean[] boaCopy(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        boolean[] zArr2 = new boolean[zArr.length];
        System.arraycopy(zArr, 0, zArr2, 0, zArr.length);
        return zArr2;
    }

    public void setSimpleTypeVariety(int i) {
        assertResolving();
        this._simpleTypeVariety = i;
    }

    public int getSimpleVariety() {
        return this._simpleTypeVariety;
    }

    public boolean isURType() {
        int i = this._builtinTypeCode;
        if (i == 1 || i == 2) {
            return true;
        }
        return $assertionsDisabled;
    }

    public boolean isNoType() {
        if (this == BuiltinSchemaTypeSystem.ST_NO_TYPE) {
            return true;
        }
        return $assertionsDisabled;
    }

    public boolean isSimpleType() {
        return this._isSimpleType;
    }

    public void setSimpleType(boolean z) {
        assertUnresolved();
        this._isSimpleType = z;
    }

    public boolean isUnionOfLists() {
        return this._isUnionOfLists;
    }

    public void setUnionOfLists(boolean z) {
        assertResolving();
        this._isUnionOfLists = z;
    }

    public SchemaType getPrimitiveType() {
        SchemaType.Ref ref = this._primitiveTypeRef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public void setPrimitiveTypeRef(SchemaType.Ref ref) {
        assertResolving();
        this._primitiveTypeRef = ref;
    }

    public int getDecimalSize() {
        return this._decimalSize;
    }

    public void setDecimalSize(int i) {
        assertResolving();
        this._decimalSize = i;
    }

    public SchemaType getBaseType() {
        SchemaType.Ref ref = this._baseTyperef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public void setBaseTypeRef(SchemaType.Ref ref) {
        assertResolving();
        this._baseTyperef = ref;
    }

    public int getBaseDepth() {
        return this._baseDepth;
    }

    public void setBaseDepth(int i) {
        assertResolving();
        this._baseDepth = i;
    }

    public SchemaType getContentBasedOnType() {
        SchemaType.Ref ref = this._contentBasedOnTyperef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public void setContentBasedOnTypeRef(SchemaType.Ref ref) {
        assertResolving();
        this._contentBasedOnTyperef = ref;
    }

    public int getDerivationType() {
        return this._derivationType;
    }

    public void setDerivationType(int i) {
        assertResolving();
        this._derivationType = i;
    }

    public SchemaType getListItemType() {
        SchemaType.Ref ref = this._listItemTyperef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public void setListItemTypeRef(SchemaType.Ref ref) {
        assertResolving();
        this._listItemTyperef = ref;
    }

    public SchemaType[] getUnionMemberTypes() {
        SchemaType.Ref[] refArr = this._unionMemberTyperefs;
        int length = refArr == null ? 0 : refArr.length;
        SchemaType[] schemaTypeArr = new SchemaType[length];
        for (int i = 0; i < length; i++) {
            schemaTypeArr[i] = this._unionMemberTyperefs[i].get();
        }
        return schemaTypeArr;
    }

    public void setUnionMemberTypeRefs(SchemaType.Ref[] refArr) {
        assertResolving();
        this._unionMemberTyperefs = refArr;
    }

    public int getAnonymousUnionMemberOrdinal() {
        return this._anonymousUnionMemberOrdinal;
    }

    public void setAnonymousUnionMemberOrdinal(int i) {
        assertUnresolved();
        this._anonymousUnionMemberOrdinal = i;
    }

    public synchronized SchemaType[] getUnionConstituentTypes() {
        if (this._unionCommonBaseType == null) {
            computeFlatUnionModel();
        }
        return staCopy(this._unionConstituentTypes);
    }

    private void setUnionConstituentTypes(SchemaType[] schemaTypeArr) {
        this._unionConstituentTypes = schemaTypeArr;
    }

    public synchronized SchemaType[] getUnionSubTypes() {
        if (this._unionCommonBaseType == null) {
            computeFlatUnionModel();
        }
        return staCopy(this._unionSubTypes);
    }

    private void setUnionSubTypes(SchemaType[] schemaTypeArr) {
        this._unionSubTypes = schemaTypeArr;
    }

    public synchronized SchemaType getUnionCommonBaseType() {
        if (this._unionCommonBaseType == null) {
            computeFlatUnionModel();
        }
        return this._unionCommonBaseType;
    }

    private void setUnionCommonBaseType(SchemaType schemaType) {
        this._unionCommonBaseType = schemaType;
    }

    private void computeFlatUnionModel() {
        if (getSimpleVariety() != 2) {
            throw new IllegalStateException("Operation is only supported on union types");
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        linkedHashSet2.add(this);
        SchemaType commonBaseType = null;
        int i = 0;
        while (true) {
            SchemaType.Ref[] refArr = this._unionMemberTyperefs;
            if (i < refArr.length) {
                SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) refArr[i].get();
                int simpleVariety = schemaTypeImpl.getSimpleVariety();
                if (simpleVariety == 1) {
                    linkedHashSet.add(schemaTypeImpl);
                    linkedHashSet2.add(schemaTypeImpl);
                    commonBaseType = schemaTypeImpl.getCommonBaseType(commonBaseType);
                } else if (simpleVariety == 2) {
                    linkedHashSet.addAll(Arrays.asList(schemaTypeImpl.getUnionConstituentTypes()));
                    linkedHashSet2.addAll(Arrays.asList(schemaTypeImpl.getUnionSubTypes()));
                    SchemaType unionCommonBaseType = schemaTypeImpl.getUnionCommonBaseType();
                    if (unionCommonBaseType != null) {
                        commonBaseType = unionCommonBaseType.getCommonBaseType(commonBaseType);
                    }
                } else if (simpleVariety == 3) {
                    linkedHashSet.add(schemaTypeImpl);
                    linkedHashSet2.add(schemaTypeImpl);
                    commonBaseType = schemaTypeImpl.getCommonBaseType(commonBaseType);
                }
                i++;
            } else {
                setUnionConstituentTypes((SchemaType[]) linkedHashSet.toArray(StscState.EMPTY_ST_ARRAY));
                setUnionSubTypes((SchemaType[]) linkedHashSet2.toArray(StscState.EMPTY_ST_ARRAY));
                setUnionCommonBaseType(commonBaseType);
                return;
            }
        }
    }

    public QName getSubstitutionGroup() {
        return this._sg;
    }

    public void setSubstitutionGroup(QName qName) {
        assertSGResolving();
        this._sg = qName;
    }

    public void addSubstitutionGroupMember(QName qName) {
        assertSGResolved();
        this._sgMembers.add(qName);
    }

    public QName[] getSubstitutionGroupMembers() {
        return (QName[]) this._sgMembers.toArray(new QName[this._sgMembers.size()]);
    }

    public int getWhiteSpaceRule() {
        return this._whiteSpaceRule;
    }

    public void setWhiteSpaceRule(int i) {
        assertResolving();
        this._whiteSpaceRule = i;
    }

    public XmlAnySimpleType getFacet(int i) {
        XmlValueRef xmlValueRef;
        XmlValueRef[] xmlValueRefArr = this._facetArray;
        if (xmlValueRefArr == null || (xmlValueRef = xmlValueRefArr[i]) == null) {
            return null;
        }
        return xmlValueRef.get();
    }

    public boolean isFacetFixed(int i) {
        return this._fixedFacetArray[i];
    }

    public XmlAnySimpleType[] getBasicFacets() {
        XmlAnySimpleType[] xmlAnySimpleTypeArr = new XmlAnySimpleType[12];
        for (int i = 0; i <= 11; i++) {
            xmlAnySimpleTypeArr[i] = getFacet(i);
        }
        return xmlAnySimpleTypeArr;
    }

    public boolean[] getFixedFacets() {
        return boaCopy(this._fixedFacetArray);
    }

    public void setBasicFacets(XmlValueRef[] xmlValueRefArr, boolean[] zArr) {
        assertResolving();
        this._facetArray = xmlValueRefArr;
        this._fixedFacetArray = zArr;
    }

    public int ordered() {
        return this._ordered;
    }

    public void setOrdered(int i) {
        assertResolving();
        this._ordered = i;
    }

    public boolean isBounded() {
        return this._isBounded;
    }

    public void setBounded(boolean z) {
        assertResolving();
        this._isBounded = z;
    }

    public boolean isFinite() {
        return this._isFinite;
    }

    public void setFinite(boolean z) {
        assertResolving();
        this._isFinite = z;
    }

    public boolean isNumeric() {
        return this._isNumeric;
    }

    public void setNumeric(boolean z) {
        assertResolving();
        this._isNumeric = z;
    }

    public boolean hasPatternFacet() {
        return this._hasPatterns;
    }

    public void setPatternFacet(boolean z) {
        assertResolving();
        this._hasPatterns = z;
    }

    public boolean matchPatternFacet(String str) {
        if (!this._hasPatterns) {
            return true;
        }
        RegularExpression[] regularExpressionArr = this._patterns;
        if (regularExpressionArr != null && regularExpressionArr.length > 0) {
            int i = 0;
            while (true) {
                RegularExpression[] regularExpressionArr2 = this._patterns;
                if (i >= regularExpressionArr2.length || regularExpressionArr2[i].matches(str)) {
                    break;
                }
                i++;
            }
            if (i >= this._patterns.length) {
                return $assertionsDisabled;
            }
        }
        return getBaseType().matchPatternFacet(str);
    }

    public String[] getPatterns() {
        RegularExpression[] regularExpressionArr = this._patterns;
        int i = 0;
        if (regularExpressionArr == null) {
            return new String[0];
        }
        String[] strArr = new String[regularExpressionArr.length];
        while (true) {
            RegularExpression[] regularExpressionArr2 = this._patterns;
            if (i >= regularExpressionArr2.length) {
                return strArr;
            }
            strArr[i] = regularExpressionArr2[i].getPattern();
            i++;
        }
    }

    public RegularExpression[] getPatternExpressions() {
        RegularExpression[] regularExpressionArr = this._patterns;
        if (regularExpressionArr == null) {
            return new RegularExpression[0];
        }
        RegularExpression[] regularExpressionArr2 = new RegularExpression[regularExpressionArr.length];
        System.arraycopy(regularExpressionArr, 0, regularExpressionArr2, 0, regularExpressionArr.length);
        return regularExpressionArr2;
    }

    public void setPatterns(RegularExpression[] regularExpressionArr) {
        assertResolving();
        this._patterns = regularExpressionArr;
    }

    public XmlAnySimpleType[] getEnumerationValues() {
        XmlValueRef[] xmlValueRefArr = this._enumerationValues;
        if (xmlValueRefArr == null) {
            return null;
        }
        int length = xmlValueRefArr.length;
        XmlAnySimpleType[] xmlAnySimpleTypeArr = new XmlAnySimpleType[length];
        for (int i = 0; i < length; i++) {
            XmlValueRef xmlValueRef = this._enumerationValues[i];
            xmlAnySimpleTypeArr[i] = xmlValueRef == null ? null : xmlValueRef.get();
        }
        return xmlAnySimpleTypeArr;
    }

    public void setEnumerationValues(XmlValueRef[] xmlValueRefArr) {
        assertResolving();
        this._enumerationValues = xmlValueRefArr;
    }

    public StringEnumAbstractBase enumForString(String str) {
        ensureStringEnumInfo();
        if (this._lookupStringEnum == null) {
            return null;
        }
        return (StringEnumAbstractBase) this._lookupStringEnum.get(str);
    }

    public StringEnumAbstractBase enumForInt(int i) {
        ensureStringEnumInfo();
        if (this._listOfStringEnum == null || i < 0 || i >= this._listOfStringEnum.size()) {
            return null;
        }
        return (StringEnumAbstractBase) this._listOfStringEnum.get(i);
    }

    public SchemaStringEnumEntry enumEntryForString(String str) {
        ensureStringEnumInfo();
        if (this._lookupStringEnumEntry == null) {
            return null;
        }
        return (SchemaStringEnumEntry) this._lookupStringEnumEntry.get(str);
    }

    public SchemaType getBaseEnumType() {
        SchemaType.Ref ref = this._baseEnumTyperef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public void setBaseEnumTypeRef(SchemaType.Ref ref) {
        this._baseEnumTyperef = ref;
    }

    public SchemaStringEnumEntry[] getStringEnumEntries() {
        SchemaStringEnumEntry[] schemaStringEnumEntryArr = this._stringEnumEntries;
        if (schemaStringEnumEntryArr == null) {
            return null;
        }
        int length = schemaStringEnumEntryArr.length;
        SchemaStringEnumEntry[] schemaStringEnumEntryArr2 = new SchemaStringEnumEntry[length];
        System.arraycopy(schemaStringEnumEntryArr, 0, schemaStringEnumEntryArr2, 0, length);
        return schemaStringEnumEntryArr2;
    }

    public void setStringEnumEntries(SchemaStringEnumEntry[] schemaStringEnumEntryArr) {
        assertJavaizing();
        this._stringEnumEntries = schemaStringEnumEntryArr;
    }

    private void ensureStringEnumInfo() {
        if (this._stringEnumEnsured) {
            return;
        }
        SchemaStringEnumEntry[] schemaStringEnumEntryArr = this._stringEnumEntries;
        if (schemaStringEnumEntryArr == null) {
            this._stringEnumEnsured = true;
            return;
        }
        HashMap map = new HashMap(schemaStringEnumEntryArr.length);
        ArrayList arrayList = new ArrayList(schemaStringEnumEntryArr.length + 1);
        HashMap map2 = new HashMap(schemaStringEnumEntryArr.length);
        for (int i = 0; i < schemaStringEnumEntryArr.length; i++) {
            map2.put(schemaStringEnumEntryArr[i].getString(), schemaStringEnumEntryArr[i]);
        }
        Class enumJavaClass = this._baseEnumTyperef.get().getEnumJavaClass();
        if (enumJavaClass != null) {
            try {
                StringEnumAbstractBase.Table table = (StringEnumAbstractBase.Table) enumJavaClass.getField("table").get(null);
                for (int i2 = 0; i2 < schemaStringEnumEntryArr.length; i2++) {
                    int intValue = schemaStringEnumEntryArr[i2].getIntValue();
                    StringEnumAbstractBase stringEnumAbstractBaseForInt = table.forInt(intValue);
                    map.put(schemaStringEnumEntryArr[i2].getString(), stringEnumAbstractBaseForInt);
                    while (arrayList.size() <= intValue) {
                        arrayList.add(null);
                    }
                    arrayList.set(intValue, stringEnumAbstractBaseForInt);
                }
            } catch (Exception unused) {
                System.err.println("Something wrong: could not locate enum table for " + enumJavaClass);
                map.clear();
                arrayList.clear();
                enumJavaClass = null;
            }
        }
        if (enumJavaClass == null) {
            for (int i3 = 0; i3 < schemaStringEnumEntryArr.length; i3++) {
                int intValue2 = schemaStringEnumEntryArr[i3].getIntValue();
                String string = schemaStringEnumEntryArr[i3].getString();
                StringEnumValue stringEnumValue = new StringEnumValue(string, intValue2);
                map.put(string, stringEnumValue);
                while (arrayList.size() <= intValue2) {
                    arrayList.add(null);
                }
                arrayList.set(intValue2, stringEnumValue);
            }
        }
        synchronized (this) {
            if (!this._stringEnumEnsured) {
                this._lookupStringEnum = map;
                this._listOfStringEnum = arrayList;
                this._lookupStringEnumEntry = map2;
            }
        }
        synchronized (this) {
            this._stringEnumEnsured = true;
        }
    }

    public boolean hasStringEnumValues() {
        if (this._stringEnumEntries != null) {
            return true;
        }
        return $assertionsDisabled;
    }

    public void copyEnumerationValues(SchemaTypeImpl schemaTypeImpl) {
        assertResolving();
        this._enumerationValues = schemaTypeImpl._enumerationValues;
        this._baseEnumTyperef = schemaTypeImpl._baseEnumTyperef;
    }

    public int getBuiltinTypeCode() {
        return this._builtinTypeCode;
    }

    public void setBuiltinTypeCode(int i) {
        assertResolving();
        this._builtinTypeCode = i;
    }

    synchronized void assignJavaElementSetterModel() {
        SchemaProperty[] elementProperties = getElementProperties();
        SchemaParticle contentModel = getContentModel();
        HashMap map = new HashMap();
        QNameSet qNameSetComputeAllContainedElements = computeAllContainedElements(contentModel, map);
        for (SchemaProperty schemaProperty : elementProperties) {
            SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl) schemaProperty;
            QNameSet qNameSetComputeNondelimitingElements = computeNondelimitingElements(schemaPropertyImpl.getName(), contentModel, map);
            QNameSetBuilder qNameSetBuilder = new QNameSetBuilder(qNameSetComputeAllContainedElements);
            qNameSetBuilder.removeAll(qNameSetComputeNondelimitingElements);
            schemaPropertyImpl.setJavaSetterDelimiter(qNameSetBuilder.toQNameSet());
        }
    }

    private static QNameSet computeNondelimitingElements(QName qName, SchemaParticle schemaParticle, Map map) {
        QNameSet qNameSetComputeAllContainedElements = computeAllContainedElements(schemaParticle, map);
        if (!qNameSetComputeAllContainedElements.contains(qName)) {
            return QNameSet.EMPTY;
        }
        if (schemaParticle.getMaxOccurs() == null || schemaParticle.getMaxOccurs().compareTo(BigInteger.ONE) > 0) {
            return qNameSetComputeAllContainedElements;
        }
        int particleType = schemaParticle.getParticleType();
        int i = 0;
        if (particleType == 2) {
            QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
            while (i < schemaParticle.countOfParticleChild()) {
                if (computeAllContainedElements(schemaParticle.getParticleChild(i), map).contains(qName)) {
                    qNameSetBuilder.addAll(computeNondelimitingElements(qName, schemaParticle.getParticleChild(i), map));
                }
                i++;
            }
            return qNameSetBuilder.toQNameSet();
        }
        if (particleType != 3) {
            return particleType != 5 ? qNameSetComputeAllContainedElements : QNameSet.singleton(qName);
        }
        QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder();
        int iCountOfParticleChild = schemaParticle.countOfParticleChild();
        while (iCountOfParticleChild > 0) {
            iCountOfParticleChild--;
            QNameSet qNameSetComputeAllContainedElements2 = computeAllContainedElements(schemaParticle.getParticleChild(iCountOfParticleChild), map);
            if (i != 0) {
                qNameSetBuilder2.addAll(qNameSetComputeAllContainedElements2);
            } else if (qNameSetComputeAllContainedElements2.contains(qName)) {
                qNameSetBuilder2.addAll(computeNondelimitingElements(qName, schemaParticle.getParticleChild(iCountOfParticleChild), map));
                i = 1;
            }
        }
        return qNameSetBuilder2.toQNameSet();
    }

    private static QNameSet computeAllContainedElements(SchemaParticle schemaParticle, Map map) {
        QNameSet qNameSetAcceptedStartNames;
        QNameSet qNameSet = (QNameSet) map.get(schemaParticle);
        if (qNameSet != null) {
            return qNameSet;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType == 4) {
            qNameSetAcceptedStartNames = ((SchemaLocalElementImpl) schemaParticle).acceptedStartNames();
        } else if (particleType != 5) {
            QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
            for (int i = 0; i < schemaParticle.countOfParticleChild(); i++) {
                qNameSetBuilder.addAll(computeAllContainedElements(schemaParticle.getParticleChild(i), map));
            }
            qNameSetAcceptedStartNames = qNameSetBuilder.toQNameSet();
        } else {
            qNameSetAcceptedStartNames = schemaParticle.getWildcardSet();
        }
        map.put(schemaParticle, qNameSetAcceptedStartNames);
        return qNameSetAcceptedStartNames;
    }

    public Class getJavaClass() {
        if (this._javaClass == null && getFullJavaName() != null) {
            try {
                this._javaClass = Class.forName(getFullJavaName(), $assertionsDisabled, getTypeSystem().getClassLoader());
            } catch (ClassNotFoundException unused) {
                this._javaClass = null;
            }
        }
        return this._javaClass;
    }

    public Class getJavaImplClass() {
        if (this._implNotAvailable) {
            return null;
        }
        if (this._javaImplClass == null) {
            try {
                if (getFullJavaImplName() != null) {
                    this._javaImplClass = Class.forName(getFullJavaImplName(), $assertionsDisabled, getTypeSystem().getClassLoader());
                } else {
                    this._implNotAvailable = true;
                }
            } catch (ClassNotFoundException unused) {
                this._implNotAvailable = true;
            }
        }
        return this._javaImplClass;
    }

    public Class getUserTypeClass() {
        if (this._userTypeClass == null && getUserTypeName() != null) {
            try {
                this._userTypeClass = Class.forName(this._userTypeName, $assertionsDisabled, getTypeSystem().getClassLoader());
            } catch (ClassNotFoundException unused) {
                this._userTypeClass = null;
            }
        }
        return this._userTypeClass;
    }

    public Class getUserTypeHandlerClass() {
        if (this._userTypeHandlerClass == null && getUserTypeHandlerName() != null) {
            try {
                this._userTypeHandlerClass = Class.forName(this._userTypeHandler, $assertionsDisabled, getTypeSystem().getClassLoader());
            } catch (ClassNotFoundException unused) {
                this._userTypeHandlerClass = null;
            }
        }
        return this._userTypeHandlerClass;
    }

    public Constructor getJavaImplConstructor() {
        if (this._javaImplConstructor == null && !this._implNotAvailable) {
            Class javaImplClass = getJavaImplClass();
            if (javaImplClass == null) {
                return null;
            }
            try {
                this._javaImplConstructor = javaImplClass.getConstructor(SchemaType.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return this._javaImplConstructor;
    }

    public Constructor getJavaImplConstructor2() {
        if (this._javaImplConstructor2 == null && !this._implNotAvailable) {
            Class javaImplClass = getJavaImplClass();
            if (javaImplClass == null) {
                return null;
            }
            try {
                this._javaImplConstructor2 = javaImplClass.getDeclaredConstructor(SchemaType.class, Boolean.TYPE);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return this._javaImplConstructor2;
    }

    public Class getEnumJavaClass() {
        if (this._javaEnumClass == null && getBaseEnumType() != null) {
            try {
                this._javaEnumClass = Class.forName(getBaseEnumType().getFullJavaName() + "$Enum", $assertionsDisabled, getTypeSystem().getClassLoader());
            } catch (ClassNotFoundException unused) {
                this._javaEnumClass = null;
            }
        }
        return this._javaEnumClass;
    }

    public void setJavaClass(Class cls) {
        assertResolved();
        this._javaClass = cls;
        setFullJavaName(cls.getName());
    }

    public boolean isPrimitiveType() {
        if (getBuiltinTypeCode() < 2 || getBuiltinTypeCode() > 21) {
            return $assertionsDisabled;
        }
        return true;
    }

    public boolean isBuiltinType() {
        if (getBuiltinTypeCode() != 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    public XmlObject createUnwrappedNode() {
        return createUnattachedNode(null);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUserFactory
    public TypeStoreUser createTypeStoreUser() {
        return createUnattachedNode(null);
    }

    public XmlAnySimpleType newValidatingValue(Object obj) {
        return newValue(obj, true);
    }

    public XmlAnySimpleType newValue(Object obj) {
        return newValue(obj, $assertionsDisabled);
    }

    public XmlAnySimpleType newValue(Object obj, boolean z) {
        if (!isSimpleType() && getContentType() != 2) {
            throw new XmlValueOutOfRangeException();
        }
        XmlAnySimpleType xmlAnySimpleType = (XmlObjectBase) createUnattachedNode(null);
        if (z) {
            xmlAnySimpleType.setValidateOnSet();
        }
        if (obj instanceof XmlObject) {
            xmlAnySimpleType.set_newValue((XmlObject) obj);
        } else {
            xmlAnySimpleType.objectSet(obj);
        }
        xmlAnySimpleType.check_dated();
        xmlAnySimpleType.setImmutable();
        return xmlAnySimpleType;
    }

    private XmlObject createUnattachedNode(SchemaProperty schemaProperty) {
        XmlObject xmlObjectCreateBuiltinInstance;
        if (!isBuiltinType() && !isNoType()) {
            Constructor javaImplConstructor = getJavaImplConstructor();
            if (javaImplConstructor != null) {
                try {
                    return (XmlObject) javaImplConstructor.newInstance(this._ctrArgs);
                } catch (Exception e) {
                    System.out.println("Exception trying to instantiate impl class.");
                    e.printStackTrace();
                }
            }
            xmlObjectCreateBuiltinInstance = null;
        } else {
            xmlObjectCreateBuiltinInstance = createBuiltinInstance();
        }
        SchemaType baseType = this;
        while (xmlObjectCreateBuiltinInstance == null) {
            xmlObjectCreateBuiltinInstance = ((SchemaTypeImpl) baseType).createUnattachedSubclass(this);
            baseType = baseType.getBaseType();
        }
        ((XmlObjectBase) xmlObjectCreateBuiltinInstance).init_flags(schemaProperty);
        return xmlObjectCreateBuiltinInstance;
    }

    private XmlObject createUnattachedSubclass(SchemaType schemaType) {
        if (!isBuiltinType() && !isNoType()) {
            Constructor javaImplConstructor2 = getJavaImplConstructor2();
            if (javaImplConstructor2 == null) {
                return null;
            }
            boolean zIsAccessible = javaImplConstructor2.isAccessible();
            try {
                javaImplConstructor2.setAccessible(true);
                try {
                    try {
                        Object[] objArr = new Object[2];
                        objArr[0] = schemaType;
                        objArr[1] = schemaType.isSimpleType() ? Boolean.FALSE : Boolean.TRUE;
                        XmlObject xmlObject = (XmlObject) javaImplConstructor2.newInstance(objArr);
                        try {
                            javaImplConstructor2.setAccessible(zIsAccessible);
                        } catch (SecurityException unused) {
                        }
                        return xmlObject;
                    } catch (Exception e) {
                        System.out.println("Exception trying to instantiate impl class.");
                        e.printStackTrace();
                        try {
                            javaImplConstructor2.setAccessible(zIsAccessible);
                            return null;
                        } catch (SecurityException unused2) {
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    try {
                        javaImplConstructor2.setAccessible(zIsAccessible);
                    } catch (SecurityException unused3) {
                    }
                    throw th;
                }
            } catch (Exception e2) {
                System.out.println("Exception trying to instantiate impl class.");
                e2.printStackTrace();
                return null;
            }
        }
        return createBuiltinSubclass(schemaType);
    }

    private XmlObject createBuiltinInstance() {
        switch (getBuiltinTypeCode()) {
            case 0:
                return new XmlAnyTypeImpl(BuiltinSchemaTypeSystem.ST_NO_TYPE);
            case 1:
                return new XmlAnyTypeImpl();
            case 2:
                return new XmlAnySimpleTypeImpl();
            case 3:
                return new XmlBooleanImpl();
            case 4:
                return new XmlBase64BinaryImpl();
            case 5:
                return new XmlHexBinaryImpl();
            case 6:
                return new XmlAnyUriImpl();
            case 7:
                return new XmlQNameImpl();
            case 8:
                return new XmlNotationImpl();
            case 9:
                return new XmlFloatImpl();
            case 10:
                return new XmlDoubleImpl();
            case 11:
                return new XmlDecimalImpl();
            case 12:
                return new XmlStringImpl();
            case 13:
                return new XmlDurationImpl();
            case 14:
                return new XmlDateTimeImpl();
            case 15:
                return new XmlTimeImpl();
            case 16:
                return new XmlDateImpl();
            case 17:
                return new XmlGYearMonthImpl();
            case 18:
                return new XmlGYearImpl();
            case 19:
                return new XmlGMonthDayImpl();
            case 20:
                return new XmlGDayImpl();
            case 21:
                return new XmlGMonthImpl();
            case 22:
                return new XmlIntegerImpl();
            case 23:
                return new XmlLongImpl();
            case 24:
                return new XmlIntImpl();
            case 25:
                return new XmlShortImpl();
            case 26:
                return new XmlByteImpl();
            case 27:
                return new XmlNonPositiveIntegerImpl();
            case 28:
                return new XmlNegativeIntegerImpl();
            case 29:
                return new XmlNonNegativeIntegerImpl();
            case 30:
                return new XmlPositiveIntegerImpl();
            case 31:
                return new XmlUnsignedLongImpl();
            case 32:
                return new XmlUnsignedIntImpl();
            case 33:
                return new XmlUnsignedShortImpl();
            case 34:
                return new XmlUnsignedByteImpl();
            case 35:
                return new XmlNormalizedStringImpl();
            case 36:
                return new XmlTokenImpl();
            case 37:
                return new XmlNameImpl();
            case 38:
                return new XmlNCNameImpl();
            case 39:
                return new XmlLanguageImpl();
            case 40:
                return new XmlIdImpl();
            case 41:
                return new XmlIdRefImpl();
            case 42:
                return new XmlIdRefsImpl();
            case 43:
                return new XmlEntityImpl();
            case 44:
                return new XmlEntitiesImpl();
            case 45:
                return new XmlNmTokenImpl();
            case 46:
                return new XmlNmTokensImpl();
            default:
                throw new IllegalStateException("Unrecognized builtin type: " + getBuiltinTypeCode());
        }
    }

    private XmlObject createBuiltinSubclass(SchemaType schemaType) {
        boolean z = !schemaType.isSimpleType();
        switch (getBuiltinTypeCode()) {
            case 0:
                return new XmlAnyTypeImpl(BuiltinSchemaTypeSystem.ST_NO_TYPE);
            case 1:
            case 2:
                int simpleVariety = schemaType.getSimpleVariety();
                if (simpleVariety == 0) {
                    return new XmlComplexContentImpl(schemaType);
                }
                if (simpleVariety == 1) {
                    return new XmlAnySimpleTypeRestriction(schemaType, z);
                }
                if (simpleVariety == 2) {
                    return new XmlUnionImpl(schemaType, z);
                }
                if (simpleVariety == 3) {
                    return new XmlListImpl(schemaType, z);
                }
                throw new IllegalStateException();
            case 3:
                return new XmlBooleanRestriction(schemaType, z);
            case 4:
                return new XmlBase64BinaryRestriction(schemaType, z);
            case 5:
                return new XmlHexBinaryRestriction(schemaType, z);
            case 6:
                return new XmlAnyUriRestriction(schemaType, z);
            case 7:
                return new XmlQNameRestriction(schemaType, z);
            case 8:
                return new XmlNotationRestriction(schemaType, z);
            case 9:
                return new XmlFloatRestriction(schemaType, z);
            case 10:
                return new XmlDoubleRestriction(schemaType, z);
            case 11:
                return new XmlDecimalRestriction(schemaType, z);
            case 12:
                if (schemaType.hasStringEnumValues()) {
                    return new XmlStringEnumeration(schemaType, z);
                }
                return new XmlStringRestriction(schemaType, z);
            case 13:
                return new XmlDurationImpl(schemaType, z);
            case 14:
                return new XmlDateTimeImpl(schemaType, z);
            case 15:
                return new XmlTimeImpl(schemaType, z);
            case 16:
                return new XmlDateImpl(schemaType, z);
            case 17:
                return new XmlGYearMonthImpl(schemaType, z);
            case 18:
                return new XmlGYearImpl(schemaType, z);
            case 19:
                return new XmlGMonthDayImpl(schemaType, z);
            case 20:
                return new XmlGDayImpl(schemaType, z);
            case 21:
                return new XmlGMonthImpl(schemaType, z);
            case 22:
                return new XmlIntegerRestriction(schemaType, z);
            case 23:
                return new XmlLongRestriction(schemaType, z);
            case 24:
                return new XmlIntRestriction(schemaType, z);
            case 25:
                return new XmlShortImpl(schemaType, z);
            case 26:
                return new XmlByteImpl(schemaType, z);
            case 27:
                return new XmlNonPositiveIntegerImpl(schemaType, z);
            case 28:
                return new XmlNegativeIntegerImpl(schemaType, z);
            case 29:
                return new XmlNonNegativeIntegerImpl(schemaType, z);
            case 30:
                return new XmlPositiveIntegerImpl(schemaType, z);
            case 31:
                return new XmlUnsignedLongImpl(schemaType, z);
            case 32:
                return new XmlUnsignedIntImpl(schemaType, z);
            case 33:
                return new XmlUnsignedShortImpl(schemaType, z);
            case 34:
                return new XmlUnsignedByteImpl(schemaType, z);
            case 35:
                return new XmlNormalizedStringImpl(schemaType, z);
            case 36:
                return new XmlTokenImpl(schemaType, z);
            case 37:
                return new XmlNameImpl(schemaType, z);
            case 38:
                return new XmlNCNameImpl(schemaType, z);
            case 39:
                return new XmlLanguageImpl(schemaType, z);
            case 40:
                return new XmlIdImpl(schemaType, z);
            case 41:
                return new XmlIdRefImpl(schemaType, z);
            case 42:
                return new XmlIdRefsImpl(schemaType, z);
            case 43:
                return new XmlEntityImpl(schemaType, z);
            case 44:
                return new XmlEntitiesImpl(schemaType, z);
            case 45:
                return new XmlNmTokenImpl(schemaType, z);
            case 46:
                return new XmlNmTokensImpl(schemaType, z);
            default:
                throw new IllegalStateException("Unrecognized builtin type: " + getBuiltinTypeCode());
        }
    }

    public SchemaType getCommonBaseType(SchemaType schemaType) {
        SchemaTypeImpl schemaTypeImpl;
        if (this == BuiltinSchemaTypeSystem.ST_ANY_TYPE || schemaType == null || schemaType.isNoType()) {
            return this;
        }
        if (schemaType == BuiltinSchemaTypeSystem.ST_ANY_TYPE || isNoType()) {
            return schemaType;
        }
        while (true) {
            schemaTypeImpl = (SchemaTypeImpl) schemaType;
            if (schemaTypeImpl.getBaseDepth() <= getBaseDepth()) {
                break;
            }
            schemaType = schemaTypeImpl.getBaseType();
        }
        SchemaTypeImpl schemaTypeImpl2 = this;
        while (schemaTypeImpl2.getBaseDepth() > schemaTypeImpl.getBaseDepth()) {
            schemaTypeImpl2 = (SchemaTypeImpl) schemaTypeImpl2.getBaseType();
        }
        while (!schemaTypeImpl.equals(schemaTypeImpl2)) {
            schemaTypeImpl = (SchemaTypeImpl) schemaTypeImpl.getBaseType();
            schemaTypeImpl2 = (SchemaTypeImpl) schemaTypeImpl2.getBaseType();
        }
        return schemaTypeImpl;
    }

    public boolean isAssignableFrom(SchemaType schemaType) {
        if (schemaType == null || schemaType.isNoType()) {
            return true;
        }
        if (isNoType()) {
            return $assertionsDisabled;
        }
        if (getSimpleVariety() == 2) {
            for (SchemaType schemaType2 : getUnionMemberTypes()) {
                if (schemaType2.isAssignableFrom(schemaType)) {
                    return true;
                }
            }
        }
        int baseDepth = ((SchemaTypeImpl) schemaType).getBaseDepth() - getBaseDepth();
        if (baseDepth < 0) {
            return $assertionsDisabled;
        }
        while (baseDepth > 0) {
            schemaType = schemaType.getBaseType();
            baseDepth--;
        }
        if (schemaType == null || !schemaType.equals(this)) {
            return $assertionsDisabled;
        }
        return true;
    }

    public String toString() {
        String string;
        String str;
        if (getName() != null) {
            return "T=" + QNameHelper.pretty(getName());
        }
        if (isDocumentType()) {
            return "D=" + QNameHelper.pretty(getDocumentElementName());
        }
        if (isAttributeType()) {
            return "R=" + QNameHelper.pretty(getAttributeTypeAttributeName());
        }
        if (getContainerField() != null) {
            StringBuilder sb = new StringBuilder();
            if (getContainerField().getName().getNamespaceURI().length() > 0) {
                str = getContainerField().isAttribute() ? "Q=" : "E=";
            } else {
                str = getContainerField().isAttribute() ? "A=" : "U=";
            }
            string = sb.append(str).append(getContainerField().getName().getLocalPart()).toString();
            if (getOuterType() == null) {
                return string + "@" + getContainerField().getName().getNamespaceURI();
            }
        } else {
            if (isNoType()) {
                return "N=";
            }
            if (getOuterType() == null) {
                return "noouter";
            }
            if (getOuterType().getBaseType() == this) {
                string = "B=";
            } else if (getOuterType().getContentBasedOnType() == this) {
                string = "S=";
            } else if (getOuterType().getSimpleVariety() == 3) {
                string = "I=";
            } else {
                string = getOuterType().getSimpleVariety() == 2 ? "M=" + getAnonymousUnionMemberOrdinal() : "strange=";
            }
        }
        return string + "|" + getOuterType().toString();
    }

    public void setParseContext(XmlObject xmlObject, String str, boolean z, String str2, String str3, boolean z2) {
        this._parseObject = xmlObject;
        this._parseTNS = str;
        this._chameleon = z;
        this._elemFormDefault = str2;
        this._attFormDefault = str3;
        this._redefinition = z2;
    }

    public XmlObject getParseObject() {
        return this._parseObject;
    }

    public String getTargetNamespace() {
        return this._parseTNS;
    }

    public boolean isChameleon() {
        return this._chameleon;
    }

    public String getElemFormDefault() {
        return this._elemFormDefault;
    }

    public String getAttFormDefault() {
        return this._attFormDefault;
    }

    public String getChameleonNamespace() {
        if (this._chameleon) {
            return this._parseTNS;
        }
        return null;
    }

    public boolean isRedefinition() {
        return this._redefinition;
    }

    public SchemaType.Ref getRef() {
        return this._selfref;
    }

    public SchemaComponent.Ref getComponentRef() {
        return getRef();
    }

    private static class SequencerImpl implements SchemaTypeElementSequencer {
        private SchemaTypeVisitorImpl _visitor;

        private SequencerImpl(SchemaTypeVisitorImpl schemaTypeVisitorImpl) {
            this._visitor = schemaTypeVisitorImpl;
        }

        public boolean next(QName qName) {
            SchemaTypeVisitorImpl schemaTypeVisitorImpl = this._visitor;
            return schemaTypeVisitorImpl == null ? SchemaTypeImpl.$assertionsDisabled : schemaTypeVisitorImpl.visit(qName);
        }

        public boolean peek(QName qName) {
            SchemaTypeVisitorImpl schemaTypeVisitorImpl = this._visitor;
            return schemaTypeVisitorImpl == null ? SchemaTypeImpl.$assertionsDisabled : schemaTypeVisitorImpl.testValid(qName);
        }
    }

    public QNameSet qnameSetForWildcardElements() {
        SchemaParticle contentModel = getContentModel();
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
        computeWildcardSet(contentModel, qNameSetBuilder);
        QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder(qNameSetBuilder);
        for (SchemaProperty schemaProperty : getElementProperties()) {
            qNameSetBuilder2.remove(schemaProperty.getName());
        }
        return qNameSetBuilder2.toQNameSet();
    }

    private static void computeWildcardSet(SchemaParticle schemaParticle, QNameSetBuilder qNameSetBuilder) {
        if (schemaParticle.getParticleType() == 5) {
            qNameSetBuilder.addAll(schemaParticle.getWildcardSet());
            return;
        }
        for (int i = 0; i < schemaParticle.countOfParticleChild(); i++) {
            computeWildcardSet(schemaParticle.getParticleChild(i), qNameSetBuilder);
        }
    }

    public QNameSet qnameSetForWildcardAttributes() {
        QNameSet wildcardSet = getAttributeModel().getWildcardSet();
        if (wildcardSet == null) {
            return QNameSet.EMPTY;
        }
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder(wildcardSet);
        for (SchemaProperty schemaProperty : getAttributeProperties()) {
            qNameSetBuilder.remove(schemaProperty.getName());
        }
        return qNameSetBuilder.toQNameSet();
    }
}
