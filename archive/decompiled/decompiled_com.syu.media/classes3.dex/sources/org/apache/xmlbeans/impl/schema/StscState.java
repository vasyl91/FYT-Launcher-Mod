package org.apache.xmlbeans.impl.schema;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.BindingConfig;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ResolverUtil;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.util.HexBin;
import org.apache.xmlbeans.impl.values.XmlStringImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.xml.sax.EntityResolver;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class StscState {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final XmlValueRef[] FACETS_LIST;
    private static final XmlValueRef[] FACETS_NONE;
    static final XmlValueRef[] FACETS_UNION;
    private static final XmlValueRef[] FACETS_WS_COLLAPSE;
    static final boolean[] FIXED_FACETS_LIST;
    private static final boolean[] FIXED_FACETS_NONE;
    static final boolean[] FIXED_FACETS_UNION;
    private static final boolean[] FIXED_FACETS_WS;
    private static final String PROJECT_URL_PREFIX = "project://local";
    private boolean _allowPartial;
    private List _annotations;
    private Map _attributeGroups;
    private Map _attributeTypes;
    URI _baseURI;
    private Map _compatMap;
    private BindingConfig _config;
    private Map _containers;
    private SchemaDependencies _dependencies;
    private byte[] _digest;
    private Map _documentTypes;
    private boolean _doingDownloads;
    private EntityResolver _entityResolver;
    private Collection _errorListener;
    private String _givenStsName;
    private Map _globalAttributes;
    private Map _globalElements;
    private Map _globalTypes;
    private Map _idConstraints;
    private SchemaTypeLoader _importingLoader;
    private boolean _mdefAll;
    private Set _mdefNamespaces;
    private Map _misspelledNames;
    private Map _modelGroups;
    private Set _namespaces;
    private boolean _noAnn;
    private boolean _noDigest;
    private boolean _noPvr;
    private boolean _noUpa;
    private Set _processingGroups;
    private int _recoveredErrors;
    private Map _redefinedAttributeGroups;
    private Map _redefinedGlobalTypes;
    private Map _redefinedModelGroups;
    SchemaTypeLoader _s4sloader;
    private File _schemasDir;
    Map _sourceForUri;
    private SchemaTypeSystemImpl _target;
    private Map _typesByClassname;
    public static final Object CHAMELEON_INCLUDE_URI = new Object();
    private static ThreadLocal tl_stscStack = new ThreadLocal();
    private static final XmlValueRef XMLSTR_PRESERVE = buildString("preserve");
    private static final XmlValueRef XMLSTR_REPLACE = buildString("preserve");
    private static final XmlValueRef XMLSTR_COLLAPSE = buildString("preserve");
    static final SchemaType[] EMPTY_ST_ARRAY = new SchemaType[0];
    static final SchemaType.Ref[] EMPTY_STREF_ARRAY = new SchemaType.Ref[0];

    private static Set buildDefaultMdefNamespaces() {
        return new HashSet(Arrays.asList("http://www.openuri.org/2002/04/soap/conversation/"));
    }

    static {
        XmlValueRef[] xmlValueRefArr = {null, null, null, null, null, null, null, null, null, null, null, null};
        FACETS_NONE = xmlValueRefArr;
        boolean[] zArr = {$assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled};
        FIXED_FACETS_NONE = zArr;
        XmlValueRef[] xmlValueRefArr2 = {null, null, null, null, null, null, null, null, null, build_wsstring(3), null, null};
        FACETS_WS_COLLAPSE = xmlValueRefArr2;
        boolean[] zArr2 = {$assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, $assertionsDisabled, true, $assertionsDisabled, $assertionsDisabled};
        FIXED_FACETS_WS = zArr2;
        FACETS_UNION = xmlValueRefArr;
        FIXED_FACETS_UNION = zArr;
        FACETS_LIST = xmlValueRefArr2;
        FIXED_FACETS_LIST = zArr2;
    }

    private StscState() {
        this._digest = null;
        this._noDigest = $assertionsDisabled;
        this._allowPartial = $assertionsDisabled;
        this._recoveredErrors = 0;
        this._containers = new LinkedHashMap();
        this._redefinedGlobalTypes = new LinkedHashMap();
        this._redefinedModelGroups = new LinkedHashMap();
        this._redefinedAttributeGroups = new LinkedHashMap();
        this._globalTypes = new LinkedHashMap();
        this._globalElements = new LinkedHashMap();
        this._globalAttributes = new LinkedHashMap();
        this._modelGroups = new LinkedHashMap();
        this._attributeGroups = new LinkedHashMap();
        this._documentTypes = new LinkedHashMap();
        this._attributeTypes = new LinkedHashMap();
        this._typesByClassname = new LinkedHashMap();
        this._misspelledNames = new HashMap();
        this._processingGroups = new LinkedHashSet();
        this._idConstraints = new LinkedHashMap();
        this._namespaces = new HashSet();
        this._annotations = new ArrayList();
        this._mdefNamespaces = buildDefaultMdefNamespaces();
        this._sourceForUri = new HashMap();
        this._baseURI = URI.create("project://local/");
        this._s4sloader = XmlBeans.typeLoaderForClassLoader(SchemaDocument.class.getClassLoader());
    }

    public void initFromTypeSystem(SchemaTypeSystemImpl schemaTypeSystemImpl, Set set) {
        SchemaContainer[] schemaContainerArrContainers = schemaTypeSystemImpl.containers();
        for (int i = 0; i < schemaContainerArrContainers.length; i++) {
            if (!set.contains(schemaContainerArrContainers[i].getNamespace())) {
                addContainer(schemaContainerArrContainers[i]);
            }
        }
    }

    void addNewContainer(String str) {
        if (this._containers.containsKey(str)) {
            return;
        }
        SchemaContainer schemaContainer = new SchemaContainer(str);
        schemaContainer.setTypeSystem(sts());
        addNamespace(str);
        this._containers.put(str, schemaContainer);
    }

    private void addContainer(SchemaContainer schemaContainer) {
        this._containers.put(schemaContainer.getNamespace(), schemaContainer);
        List listRedefinedModelGroups = schemaContainer.redefinedModelGroups();
        for (int i = 0; i < listRedefinedModelGroups.size(); i++) {
            this._redefinedModelGroups.put(((SchemaModelGroup) listRedefinedModelGroups.get(i)).getName(), listRedefinedModelGroups.get(i));
        }
        List listRedefinedAttributeGroups = schemaContainer.redefinedAttributeGroups();
        for (int i2 = 0; i2 < listRedefinedAttributeGroups.size(); i2++) {
            this._redefinedAttributeGroups.put(((SchemaAttributeGroup) listRedefinedAttributeGroups.get(i2)).getName(), listRedefinedAttributeGroups.get(i2));
        }
        List listRedefinedGlobalTypes = schemaContainer.redefinedGlobalTypes();
        for (int i3 = 0; i3 < listRedefinedGlobalTypes.size(); i3++) {
            this._redefinedGlobalTypes.put(((SchemaType) listRedefinedGlobalTypes.get(i3)).getName(), listRedefinedGlobalTypes.get(i3));
        }
        List listGlobalElements = schemaContainer.globalElements();
        for (int i4 = 0; i4 < listGlobalElements.size(); i4++) {
            this._globalElements.put(((SchemaGlobalElement) listGlobalElements.get(i4)).getName(), listGlobalElements.get(i4));
        }
        List listGlobalAttributes = schemaContainer.globalAttributes();
        for (int i5 = 0; i5 < listGlobalAttributes.size(); i5++) {
            this._globalAttributes.put(((SchemaGlobalAttribute) listGlobalAttributes.get(i5)).getName(), listGlobalAttributes.get(i5));
        }
        List listModelGroups = schemaContainer.modelGroups();
        for (int i6 = 0; i6 < listModelGroups.size(); i6++) {
            this._modelGroups.put(((SchemaModelGroup) listModelGroups.get(i6)).getName(), listModelGroups.get(i6));
        }
        List listAttributeGroups = schemaContainer.attributeGroups();
        for (int i7 = 0; i7 < listAttributeGroups.size(); i7++) {
            this._attributeGroups.put(((SchemaAttributeGroup) listAttributeGroups.get(i7)).getName(), listAttributeGroups.get(i7));
        }
        List listGlobalTypes = schemaContainer.globalTypes();
        for (int i8 = 0; i8 < listGlobalTypes.size(); i8++) {
            SchemaType schemaType = (SchemaType) listGlobalTypes.get(i8);
            this._globalTypes.put(schemaType.getName(), schemaType);
            if (schemaType.getFullJavaName() != null) {
                addClassname(schemaType.getFullJavaName(), schemaType);
            }
        }
        List listDocumentTypes = schemaContainer.documentTypes();
        for (int i9 = 0; i9 < listDocumentTypes.size(); i9++) {
            SchemaType schemaType2 = (SchemaType) listDocumentTypes.get(i9);
            this._documentTypes.put(schemaType2.getProperties()[0].getName(), schemaType2);
            if (schemaType2.getFullJavaName() != null) {
                addClassname(schemaType2.getFullJavaName(), schemaType2);
            }
        }
        List listAttributeTypes = schemaContainer.attributeTypes();
        for (int i10 = 0; i10 < listAttributeTypes.size(); i10++) {
            SchemaType schemaType3 = (SchemaType) listAttributeTypes.get(i10);
            this._attributeTypes.put(schemaType3.getProperties()[0].getName(), schemaType3);
            if (schemaType3.getFullJavaName() != null) {
                addClassname(schemaType3.getFullJavaName(), schemaType3);
            }
        }
        List listIdentityConstraints = schemaContainer.identityConstraints();
        for (int i11 = 0; i11 < listIdentityConstraints.size(); i11++) {
            this._idConstraints.put(((SchemaIdentityConstraint) listIdentityConstraints.get(i11)).getName(), listIdentityConstraints.get(i11));
        }
        this._annotations.addAll(schemaContainer.annotations());
        this._namespaces.add(schemaContainer.getNamespace());
        schemaContainer.unsetImmutable();
    }

    SchemaContainer getContainer(String str) {
        return (SchemaContainer) this._containers.get(str);
    }

    Map getContainerMap() {
        return Collections.unmodifiableMap(this._containers);
    }

    void registerDependency(String str, String str2) {
        this._dependencies.registerDependency(str, str2);
    }

    void registerContribution(String str, String str2) {
        this._dependencies.registerContribution(str, str2);
    }

    SchemaDependencies getDependencies() {
        return this._dependencies;
    }

    void setDependencies(SchemaDependencies schemaDependencies) {
        this._dependencies = schemaDependencies;
    }

    boolean isFileProcessed(String str) {
        return this._dependencies.isFileRepresented(str);
    }

    public void setImportingTypeLoader(SchemaTypeLoader schemaTypeLoader) {
        this._importingLoader = schemaTypeLoader;
    }

    public void setErrorListener(Collection collection) {
        this._errorListener = collection;
    }

    public void error(String str, int i, XmlObject xmlObject) {
        addError(this._errorListener, str, i, xmlObject);
    }

    public void error(String str, Object[] objArr, XmlObject xmlObject) {
        addError(this._errorListener, str, objArr, xmlObject);
    }

    public void recover(String str, Object[] objArr, XmlObject xmlObject) {
        addError(this._errorListener, str, objArr, xmlObject);
        this._recoveredErrors++;
    }

    public void warning(String str, int i, XmlObject xmlObject) {
        addWarning(this._errorListener, str, i, xmlObject);
    }

    public void warning(String str, Object[] objArr, XmlObject xmlObject) {
        if (str != "reserved-type-name" || xmlObject.documentProperties().getSourceName() == null || xmlObject.documentProperties().getSourceName().indexOf("XMLSchema.xsd") <= 0) {
            addWarning(this._errorListener, str, objArr, xmlObject);
        }
    }

    public void info(String str) {
        addInfo(this._errorListener, str);
    }

    public void info(String str, Object[] objArr) {
        addInfo(this._errorListener, str, objArr);
    }

    public static void addError(Collection collection, String str, int i, XmlObject xmlObject) {
        collection.add(XmlError.forObject(str, 0, xmlObject));
    }

    public static void addError(Collection collection, String str, Object[] objArr, XmlObject xmlObject) {
        collection.add(XmlError.forObject(str, objArr, 0, xmlObject));
    }

    public static void addError(Collection collection, String str, Object[] objArr, File file) {
        collection.add(XmlError.forLocation(str, objArr, 0, file.toURI().toString(), 0, 0, 0));
    }

    public static void addError(Collection collection, String str, Object[] objArr, URL url) {
        collection.add(XmlError.forLocation(str, objArr, 0, url.toString(), 0, 0, 0));
    }

    public static void addWarning(Collection collection, String str, int i, XmlObject xmlObject) {
        collection.add(XmlError.forObject(str, 1, xmlObject));
    }

    public static void addWarning(Collection collection, String str, Object[] objArr, XmlObject xmlObject) {
        collection.add(XmlError.forObject(str, objArr, 1, xmlObject));
    }

    public static void addInfo(Collection collection, String str) {
        collection.add(XmlError.forMessage(str, 2));
    }

    public static void addInfo(Collection collection, String str, Object[] objArr) {
        collection.add(XmlError.forMessage(str, objArr, 2));
    }

    public void setGivenTypeSystemName(String str) {
        this._givenStsName = str;
    }

    public void setTargetSchemaTypeSystem(SchemaTypeSystemImpl schemaTypeSystemImpl) {
        this._target = schemaTypeSystemImpl;
    }

    public void addSchemaDigest(byte[] bArr) {
        if (this._noDigest) {
            return;
        }
        if (bArr == null) {
            this._noDigest = true;
            this._digest = null;
            return;
        }
        if (this._digest == null) {
            this._digest = new byte[16];
        }
        int length = this._digest.length;
        if (bArr.length < length) {
            length = bArr.length;
        }
        for (int i = 0; i < length; i++) {
            byte[] bArr2 = this._digest;
            bArr2[i] = (byte) (bArr2[i] ^ bArr[i]);
        }
    }

    public SchemaTypeSystemImpl sts() {
        SchemaTypeSystemImpl schemaTypeSystemImpl = this._target;
        if (schemaTypeSystemImpl != null) {
            return schemaTypeSystemImpl;
        }
        String strConcat = this._givenStsName;
        if (strConcat == null && this._digest != null) {
            strConcat = "s".concat(new String(HexBin.encode(this._digest)));
        }
        SchemaTypeSystemImpl schemaTypeSystemImpl2 = new SchemaTypeSystemImpl(strConcat);
        this._target = schemaTypeSystemImpl2;
        return schemaTypeSystemImpl2;
    }

    public boolean shouldDownloadURI(String str) {
        if (this._doingDownloads) {
            return true;
        }
        if (str == null) {
            return $assertionsDisabled;
        }
        try {
            URI uri = new URI(str);
            if (!uri.getScheme().equalsIgnoreCase("jar") && !uri.getScheme().equalsIgnoreCase("zip")) {
                return uri.getScheme().equalsIgnoreCase("file");
            }
            String schemeSpecificPart = uri.getSchemeSpecificPart();
            int iLastIndexOf = schemeSpecificPart.lastIndexOf(33);
            if (iLastIndexOf > 0) {
                schemeSpecificPart = schemeSpecificPart.substring(0, iLastIndexOf);
            }
            return shouldDownloadURI(schemeSpecificPart);
        } catch (Exception unused) {
            return $assertionsDisabled;
        }
    }

    public void setOptions(XmlOptions xmlOptions) {
        if (xmlOptions == null) {
            return;
        }
        this._allowPartial = xmlOptions.hasOption("COMPILE_PARTIAL_TYPESYSTEM");
        this._compatMap = (Map) xmlOptions.get("COMPILE_SUBSTITUTE_NAMES");
        boolean zHasOption = xmlOptions.hasOption("COMPILE_NO_UPA_RULE");
        boolean z = $assertionsDisabled;
        this._noUpa = zHasOption || !"true".equals(SystemProperties.getProperty("xmlbean.uniqueparticleattribution", "true"));
        this._noPvr = xmlOptions.hasOption("COMPILE_NO_PVR_RULE") || !"true".equals(SystemProperties.getProperty("xmlbean.particlerestriction", "true"));
        if (xmlOptions.hasOption("COMPILE_NO_ANNOTATIONS") || !"true".equals(SystemProperties.getProperty("xmlbean.schemaannotations", "true"))) {
            z = true;
        }
        this._noAnn = z;
        this._doingDownloads = xmlOptions.hasOption("COMPILE_DOWNLOAD_URLS") ? true : "true".equals(SystemProperties.getProperty("xmlbean.downloadurls", "false"));
        EntityResolver entityResolver = (EntityResolver) xmlOptions.get("ENTITY_RESOLVER");
        this._entityResolver = entityResolver;
        if (entityResolver == null) {
            this._entityResolver = ResolverUtil.getGlobalEntityResolver();
        }
        if (this._entityResolver != null) {
            this._doingDownloads = true;
        }
        if (xmlOptions.hasOption("COMPILE_MDEF_NAMESPACES")) {
            this._mdefNamespaces.addAll((Collection) xmlOptions.get("COMPILE_MDEF_NAMESPACES"));
            if (this._mdefNamespaces.contains("##local")) {
                this._mdefNamespaces.remove("##local");
                this._mdefNamespaces.add("");
            }
            if (this._mdefNamespaces.contains("##any")) {
                this._mdefNamespaces.remove("##any");
                this._mdefAll = true;
            }
        }
    }

    public EntityResolver getEntityResolver() {
        return this._entityResolver;
    }

    public boolean noUpa() {
        return this._noUpa;
    }

    public boolean noPvr() {
        return this._noPvr;
    }

    public boolean noAnn() {
        return this._noAnn;
    }

    public boolean allowPartial() {
        return this._allowPartial;
    }

    public int getRecovered() {
        return this._recoveredErrors;
    }

    private QName compatName(QName qName, String str) {
        QName qName2;
        if (qName.getNamespaceURI().length() == 0 && str != null && str.length() > 0) {
            qName = new QName(str, qName.getLocalPart());
        }
        Map map = this._compatMap;
        return (map == null || (qName2 = (QName) map.get(qName)) == null) ? qName : qName2;
    }

    public void setBindingConfig(BindingConfig bindingConfig) throws IllegalArgumentException {
        this._config = bindingConfig;
    }

    public BindingConfig getBindingConfig() throws IllegalArgumentException {
        return this._config;
    }

    public String getPackageOverride(String str) {
        BindingConfig bindingConfig = this._config;
        if (bindingConfig == null) {
            return null;
        }
        return bindingConfig.lookupPackageForNamespace(str);
    }

    public String getJavaPrefix(String str) {
        BindingConfig bindingConfig = this._config;
        if (bindingConfig == null) {
            return null;
        }
        return bindingConfig.lookupPrefixForNamespace(str);
    }

    public String getJavaSuffix(String str) {
        BindingConfig bindingConfig = this._config;
        if (bindingConfig == null) {
            return null;
        }
        return bindingConfig.lookupSuffixForNamespace(str);
    }

    public String getJavaname(QName qName, int i) {
        BindingConfig bindingConfig = this._config;
        if (bindingConfig == null) {
            return null;
        }
        return bindingConfig.lookupJavanameForQName(qName, i);
    }

    private static String crunchName(QName qName) {
        return qName.getLocalPart().toLowerCase();
    }

    void addSpelling(QName qName, SchemaComponent schemaComponent) {
        this._misspelledNames.put(crunchName(qName), schemaComponent);
    }

    SchemaComponent findSpelling(QName qName) {
        return (SchemaComponent) this._misspelledNames.get(crunchName(qName));
    }

    void addNamespace(String str) {
        this._namespaces.add(str);
    }

    String[] getNamespaces() {
        Set set = this._namespaces;
        return (String[]) set.toArray(new String[set.size()]);
    }

    boolean linkerDefinesNamespace(String str) {
        return this._importingLoader.isNamespaceDefined(str);
    }

    SchemaTypeImpl findGlobalType(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) this._globalTypes.get(qNameCompatName);
        boolean z = $assertionsDisabled;
        if (schemaTypeImpl == null && (schemaTypeImpl = (SchemaTypeImpl) this._importingLoader.findType(qNameCompatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaTypeImpl;
    }

    SchemaTypeImpl findRedefinedGlobalType(QName qName, String str, SchemaTypeImpl schemaTypeImpl) {
        QName name = schemaTypeImpl.getName();
        QName qNameCompatName = compatName(qName, str);
        if (qNameCompatName.equals(name)) {
            return (SchemaTypeImpl) this._redefinedGlobalTypes.get(schemaTypeImpl);
        }
        SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) this._globalTypes.get(qNameCompatName);
        return schemaTypeImpl2 == null ? (SchemaTypeImpl) this._importingLoader.findType(qNameCompatName) : schemaTypeImpl2;
    }

    void addGlobalType(SchemaTypeImpl schemaTypeImpl, SchemaTypeImpl schemaTypeImpl2) {
        if (schemaTypeImpl != null) {
            QName name = schemaTypeImpl.getName();
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (schemaTypeImpl2 != null) {
                if (this._redefinedGlobalTypes.containsKey(schemaTypeImpl2)) {
                    if (ignoreMdef(name)) {
                        return;
                    }
                    if (this._mdefAll) {
                        warning("sch-props-correct.2", new Object[]{"global type", QNameHelper.pretty(name), ((SchemaType) this._redefinedGlobalTypes.get(schemaTypeImpl2)).getSourceName()}, schemaTypeImpl.getParseObject());
                        return;
                    } else {
                        error("sch-props-correct.2", new Object[]{"global type", QNameHelper.pretty(name), ((SchemaType) this._redefinedGlobalTypes.get(schemaTypeImpl2)).getSourceName()}, schemaTypeImpl.getParseObject());
                        return;
                    }
                }
                this._redefinedGlobalTypes.put(schemaTypeImpl2, schemaTypeImpl);
                container.addRedefinedType(schemaTypeImpl.getRef());
                return;
            }
            if (this._globalTypes.containsKey(name)) {
                if (ignoreMdef(name)) {
                    return;
                }
                if (this._mdefAll) {
                    warning("sch-props-correct.2", new Object[]{"global type", QNameHelper.pretty(name), ((SchemaType) this._globalTypes.get(name)).getSourceName()}, schemaTypeImpl.getParseObject());
                    return;
                } else {
                    error("sch-props-correct.2", new Object[]{"global type", QNameHelper.pretty(name), ((SchemaType) this._globalTypes.get(name)).getSourceName()}, schemaTypeImpl.getParseObject());
                    return;
                }
            }
            this._globalTypes.put(name, schemaTypeImpl);
            container.addGlobalType(schemaTypeImpl.getRef());
            addSpelling(name, schemaTypeImpl);
        }
    }

    private boolean ignoreMdef(QName qName) {
        return this._mdefNamespaces.contains(qName.getNamespaceURI());
    }

    SchemaType[] globalTypes() {
        return (SchemaType[]) this._globalTypes.values().toArray(new SchemaType[this._globalTypes.size()]);
    }

    SchemaType[] redefinedGlobalTypes() {
        return (SchemaType[]) this._redefinedGlobalTypes.values().toArray(new SchemaType[this._redefinedGlobalTypes.size()]);
    }

    SchemaTypeImpl findDocumentType(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) this._documentTypes.get(qNameCompatName);
        boolean z = $assertionsDisabled;
        if (schemaTypeImpl == null && (schemaTypeImpl = (SchemaTypeImpl) this._importingLoader.findDocumentType(qNameCompatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaTypeImpl;
    }

    void addDocumentType(SchemaTypeImpl schemaTypeImpl, QName qName) {
        if (this._documentTypes.containsKey(qName)) {
            if (ignoreMdef(qName)) {
                return;
            }
            if (this._mdefAll) {
                warning("sch-props-correct.2", new Object[]{"global element", QNameHelper.pretty(qName), ((SchemaComponent) this._documentTypes.get(qName)).getSourceName()}, schemaTypeImpl.getParseObject());
                return;
            } else {
                error("sch-props-correct.2", new Object[]{"global element", QNameHelper.pretty(qName), ((SchemaComponent) this._documentTypes.get(qName)).getSourceName()}, schemaTypeImpl.getParseObject());
                return;
            }
        }
        this._documentTypes.put(qName, schemaTypeImpl);
        getContainer(qName.getNamespaceURI()).addDocumentType(schemaTypeImpl.getRef());
    }

    SchemaType[] documentTypes() {
        return (SchemaType[]) this._documentTypes.values().toArray(new SchemaType[this._documentTypes.size()]);
    }

    SchemaTypeImpl findAttributeType(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) this._attributeTypes.get(qNameCompatName);
        boolean z = $assertionsDisabled;
        if (schemaTypeImpl == null && (schemaTypeImpl = (SchemaTypeImpl) this._importingLoader.findAttributeType(qNameCompatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaTypeImpl;
    }

    void addAttributeType(SchemaTypeImpl schemaTypeImpl, QName qName) {
        if (this._attributeTypes.containsKey(qName)) {
            if (ignoreMdef(qName)) {
                return;
            }
            if (this._mdefAll) {
                warning("sch-props-correct.2", new Object[]{"global attribute", QNameHelper.pretty(qName), ((SchemaComponent) this._attributeTypes.get(qName)).getSourceName()}, schemaTypeImpl.getParseObject());
                return;
            } else {
                error("sch-props-correct.2", new Object[]{"global attribute", QNameHelper.pretty(qName), ((SchemaComponent) this._attributeTypes.get(qName)).getSourceName()}, schemaTypeImpl.getParseObject());
                return;
            }
        }
        this._attributeTypes.put(qName, schemaTypeImpl);
        getContainer(qName.getNamespaceURI()).addAttributeType(schemaTypeImpl.getRef());
    }

    SchemaType[] attributeTypes() {
        return (SchemaType[]) this._attributeTypes.values().toArray(new SchemaType[this._attributeTypes.size()]);
    }

    SchemaGlobalAttributeImpl findGlobalAttribute(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = (SchemaGlobalAttributeImpl) this._globalAttributes.get(qNameCompatName);
        boolean z = $assertionsDisabled;
        if (schemaGlobalAttributeImpl == null && (schemaGlobalAttributeImpl = (SchemaGlobalAttributeImpl) this._importingLoader.findAttribute(qNameCompatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaGlobalAttributeImpl;
    }

    void addGlobalAttribute(SchemaGlobalAttributeImpl schemaGlobalAttributeImpl) {
        if (schemaGlobalAttributeImpl != null) {
            QName name = schemaGlobalAttributeImpl.getName();
            this._globalAttributes.put(name, schemaGlobalAttributeImpl);
            addSpelling(name, schemaGlobalAttributeImpl);
            getContainer(name.getNamespaceURI()).addGlobalAttribute(schemaGlobalAttributeImpl.getRef());
        }
    }

    SchemaGlobalAttribute[] globalAttributes() {
        return (SchemaGlobalAttribute[]) this._globalAttributes.values().toArray(new SchemaGlobalAttribute[this._globalAttributes.size()]);
    }

    SchemaGlobalElementImpl findGlobalElement(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaGlobalElementImpl schemaGlobalElementImpl = (SchemaGlobalElementImpl) this._globalElements.get(qNameCompatName);
        boolean z = $assertionsDisabled;
        if (schemaGlobalElementImpl == null && (schemaGlobalElementImpl = (SchemaGlobalElementImpl) this._importingLoader.findElement(qNameCompatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaGlobalElementImpl;
    }

    void addGlobalElement(SchemaGlobalElementImpl schemaGlobalElementImpl) {
        if (schemaGlobalElementImpl != null) {
            QName name = schemaGlobalElementImpl.getName();
            this._globalElements.put(name, schemaGlobalElementImpl);
            getContainer(name.getNamespaceURI()).addGlobalElement(schemaGlobalElementImpl.getRef());
            addSpelling(name, schemaGlobalElementImpl);
        }
    }

    SchemaGlobalElement[] globalElements() {
        return (SchemaGlobalElement[]) this._globalElements.values().toArray(new SchemaGlobalElement[this._globalElements.size()]);
    }

    SchemaAttributeGroupImpl findAttributeGroup(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaAttributeGroupImpl schemaAttributeGroupImpl = (SchemaAttributeGroupImpl) this._attributeGroups.get(qNameCompatName);
        boolean z = $assertionsDisabled;
        if (schemaAttributeGroupImpl == null && (schemaAttributeGroupImpl = (SchemaAttributeGroupImpl) this._importingLoader.findAttributeGroup(qNameCompatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaAttributeGroupImpl;
    }

    SchemaAttributeGroupImpl findRedefinedAttributeGroup(QName qName, String str, SchemaAttributeGroupImpl schemaAttributeGroupImpl) {
        QName name = schemaAttributeGroupImpl.getName();
        QName qNameCompatName = compatName(qName, str);
        if (qNameCompatName.equals(name)) {
            return (SchemaAttributeGroupImpl) this._redefinedAttributeGroups.get(schemaAttributeGroupImpl);
        }
        SchemaAttributeGroupImpl schemaAttributeGroupImpl2 = (SchemaAttributeGroupImpl) this._attributeGroups.get(qNameCompatName);
        return schemaAttributeGroupImpl2 == null ? (SchemaAttributeGroupImpl) this._importingLoader.findAttributeGroup(qNameCompatName) : schemaAttributeGroupImpl2;
    }

    void addAttributeGroup(SchemaAttributeGroupImpl schemaAttributeGroupImpl, SchemaAttributeGroupImpl schemaAttributeGroupImpl2) {
        if (schemaAttributeGroupImpl != null) {
            QName name = schemaAttributeGroupImpl.getName();
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (schemaAttributeGroupImpl2 != null) {
                if (this._redefinedAttributeGroups.containsKey(schemaAttributeGroupImpl2)) {
                    if (ignoreMdef(name)) {
                        return;
                    }
                    if (this._mdefAll) {
                        warning("sch-props-correct.2", new Object[]{"attribute group", QNameHelper.pretty(name), ((SchemaComponent) this._redefinedAttributeGroups.get(schemaAttributeGroupImpl2)).getSourceName()}, schemaAttributeGroupImpl.getParseObject());
                        return;
                    } else {
                        error("sch-props-correct.2", new Object[]{"attribute group", QNameHelper.pretty(name), ((SchemaComponent) this._redefinedAttributeGroups.get(schemaAttributeGroupImpl2)).getSourceName()}, schemaAttributeGroupImpl.getParseObject());
                        return;
                    }
                }
                this._redefinedAttributeGroups.put(schemaAttributeGroupImpl2, schemaAttributeGroupImpl);
                container.addRedefinedAttributeGroup(schemaAttributeGroupImpl.getRef());
                return;
            }
            if (this._attributeGroups.containsKey(name)) {
                if (ignoreMdef(name)) {
                    return;
                }
                if (this._mdefAll) {
                    warning("sch-props-correct.2", new Object[]{"attribute group", QNameHelper.pretty(name), ((SchemaComponent) this._attributeGroups.get(name)).getSourceName()}, schemaAttributeGroupImpl.getParseObject());
                    return;
                } else {
                    error("sch-props-correct.2", new Object[]{"attribute group", QNameHelper.pretty(name), ((SchemaComponent) this._attributeGroups.get(name)).getSourceName()}, schemaAttributeGroupImpl.getParseObject());
                    return;
                }
            }
            this._attributeGroups.put(schemaAttributeGroupImpl.getName(), schemaAttributeGroupImpl);
            addSpelling(schemaAttributeGroupImpl.getName(), schemaAttributeGroupImpl);
            container.addAttributeGroup(schemaAttributeGroupImpl.getRef());
        }
    }

    SchemaAttributeGroup[] attributeGroups() {
        return (SchemaAttributeGroup[]) this._attributeGroups.values().toArray(new SchemaAttributeGroup[this._attributeGroups.size()]);
    }

    SchemaAttributeGroup[] redefinedAttributeGroups() {
        return (SchemaAttributeGroup[]) this._redefinedAttributeGroups.values().toArray(new SchemaAttributeGroup[this._redefinedAttributeGroups.size()]);
    }

    SchemaModelGroupImpl findModelGroup(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaModelGroupImpl schemaModelGroupImpl = (SchemaModelGroupImpl) this._modelGroups.get(qNameCompatName);
        boolean z = $assertionsDisabled;
        if (schemaModelGroupImpl == null && (schemaModelGroupImpl = (SchemaModelGroupImpl) this._importingLoader.findModelGroup(qNameCompatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaModelGroupImpl;
    }

    SchemaModelGroupImpl findRedefinedModelGroup(QName qName, String str, SchemaModelGroupImpl schemaModelGroupImpl) {
        QName name = schemaModelGroupImpl.getName();
        QName qNameCompatName = compatName(qName, str);
        if (qNameCompatName.equals(name)) {
            return (SchemaModelGroupImpl) this._redefinedModelGroups.get(schemaModelGroupImpl);
        }
        SchemaModelGroupImpl schemaModelGroupImpl2 = (SchemaModelGroupImpl) this._modelGroups.get(qNameCompatName);
        return schemaModelGroupImpl2 == null ? (SchemaModelGroupImpl) this._importingLoader.findModelGroup(qNameCompatName) : schemaModelGroupImpl2;
    }

    void addModelGroup(SchemaModelGroupImpl schemaModelGroupImpl, SchemaModelGroupImpl schemaModelGroupImpl2) {
        if (schemaModelGroupImpl != null) {
            QName name = schemaModelGroupImpl.getName();
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (schemaModelGroupImpl2 != null) {
                if (this._redefinedModelGroups.containsKey(schemaModelGroupImpl2)) {
                    if (ignoreMdef(name)) {
                        return;
                    }
                    if (this._mdefAll) {
                        warning("sch-props-correct.2", new Object[]{"model group", QNameHelper.pretty(name), ((SchemaComponent) this._redefinedModelGroups.get(schemaModelGroupImpl2)).getSourceName()}, schemaModelGroupImpl.getParseObject());
                        return;
                    } else {
                        error("sch-props-correct.2", new Object[]{"model group", QNameHelper.pretty(name), ((SchemaComponent) this._redefinedModelGroups.get(schemaModelGroupImpl2)).getSourceName()}, schemaModelGroupImpl.getParseObject());
                        return;
                    }
                }
                this._redefinedModelGroups.put(schemaModelGroupImpl2, schemaModelGroupImpl);
                container.addRedefinedModelGroup(schemaModelGroupImpl.getRef());
                return;
            }
            if (this._modelGroups.containsKey(name)) {
                if (ignoreMdef(name)) {
                    return;
                }
                if (this._mdefAll) {
                    warning("sch-props-correct.2", new Object[]{"model group", QNameHelper.pretty(name), ((SchemaComponent) this._modelGroups.get(name)).getSourceName()}, schemaModelGroupImpl.getParseObject());
                    return;
                } else {
                    error("sch-props-correct.2", new Object[]{"model group", QNameHelper.pretty(name), ((SchemaComponent) this._modelGroups.get(name)).getSourceName()}, schemaModelGroupImpl.getParseObject());
                    return;
                }
            }
            this._modelGroups.put(schemaModelGroupImpl.getName(), schemaModelGroupImpl);
            addSpelling(schemaModelGroupImpl.getName(), schemaModelGroupImpl);
            container.addModelGroup(schemaModelGroupImpl.getRef());
        }
    }

    SchemaModelGroup[] modelGroups() {
        return (SchemaModelGroup[]) this._modelGroups.values().toArray(new SchemaModelGroup[this._modelGroups.size()]);
    }

    SchemaModelGroup[] redefinedModelGroups() {
        return (SchemaModelGroup[]) this._redefinedModelGroups.values().toArray(new SchemaModelGroup[this._redefinedModelGroups.size()]);
    }

    SchemaIdentityConstraintImpl findIdConstraint(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        if (str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return (SchemaIdentityConstraintImpl) this._idConstraints.get(qNameCompatName);
    }

    void addIdConstraint(SchemaIdentityConstraintImpl schemaIdentityConstraintImpl) {
        if (schemaIdentityConstraintImpl != null) {
            QName name = schemaIdentityConstraintImpl.getName();
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (this._idConstraints.containsKey(name)) {
                if (ignoreMdef(name)) {
                    return;
                }
                warning("sch-props-correct.2", new Object[]{"identity constraint", QNameHelper.pretty(name), ((SchemaComponent) this._idConstraints.get(name)).getSourceName()}, schemaIdentityConstraintImpl.getParseObject());
            } else {
                this._idConstraints.put(name, schemaIdentityConstraintImpl);
                addSpelling(schemaIdentityConstraintImpl.getName(), schemaIdentityConstraintImpl);
                container.addIdentityConstraint(schemaIdentityConstraintImpl.getRef());
            }
        }
    }

    SchemaIdentityConstraintImpl[] idConstraints() {
        return (SchemaIdentityConstraintImpl[]) this._idConstraints.values().toArray(new SchemaIdentityConstraintImpl[this._idConstraints.size()]);
    }

    void addAnnotation(SchemaAnnotationImpl schemaAnnotationImpl, String str) {
        if (schemaAnnotationImpl != null) {
            SchemaContainer container = getContainer(str);
            this._annotations.add(schemaAnnotationImpl);
            container.addAnnotation(schemaAnnotationImpl);
        }
    }

    List annotations() {
        return this._annotations;
    }

    boolean isProcessing(Object obj) {
        return this._processingGroups.contains(obj);
    }

    void startProcessing(Object obj) {
        this._processingGroups.add(obj);
    }

    void finishProcessing(Object obj) {
        this._processingGroups.remove(obj);
    }

    Object[] getCurrentProcessing() {
        return this._processingGroups.toArray();
    }

    Map typesByClassname() {
        return Collections.unmodifiableMap(this._typesByClassname);
    }

    void addClassname(String str, SchemaType schemaType) {
        this._typesByClassname.put(str, schemaType);
    }

    private static final class StscStack {
        StscState current;
        ArrayList stack;

        private StscStack() {
            this.stack = new ArrayList();
        }

        final StscState push() {
            this.stack.add(this.current);
            StscState stscState = new StscState();
            this.current = stscState;
            return stscState;
        }

        final void pop() {
            ArrayList arrayList = this.stack;
            this.current = (StscState) arrayList.get(arrayList.size() - 1);
            ArrayList arrayList2 = this.stack;
            arrayList2.remove(arrayList2.size() - 1);
        }
    }

    public static void clearThreadLocals() {
        tl_stscStack.remove();
    }

    public static StscState start() {
        StscStack stscStack = (StscStack) tl_stscStack.get();
        if (stscStack == null) {
            stscStack = new StscStack();
            tl_stscStack.set(stscStack);
        }
        return stscStack.push();
    }

    public static StscState get() {
        return ((StscStack) tl_stscStack.get()).current;
    }

    public static void end() {
        StscStack stscStack = (StscStack) tl_stscStack.get();
        stscStack.pop();
        if (stscStack.stack.size() == 0) {
            tl_stscStack.set(null);
        }
    }

    static XmlValueRef build_wsstring(int i) {
        if (i == 1) {
            return XMLSTR_PRESERVE;
        }
        if (i == 2) {
            return XMLSTR_REPLACE;
        }
        if (i != 3) {
            return null;
        }
        return XMLSTR_COLLAPSE;
    }

    static XmlValueRef buildString(String str) {
        if (str == null) {
            return null;
        }
        try {
            XmlStringImpl xmlStringImpl = new XmlStringImpl();
            xmlStringImpl.set(str);
            xmlStringImpl.setImmutable();
            return new XmlValueRef(xmlStringImpl);
        } catch (XmlValueOutOfRangeException unused) {
            return null;
        }
    }

    public void notFoundError(QName qName, int i, XmlObject xmlObject, boolean z) {
        Object obj;
        Object objPretty;
        Object obj2;
        Object obj3;
        QName name;
        String sourceName;
        Object objPretty2 = QNameHelper.pretty(qName);
        if (z) {
            this._recoveredErrors++;
        }
        Object obj4 = "attribute group";
        if (i == 0) {
            obj = JamXmlElements.TYPE;
        } else if (i == 1) {
            obj = "element";
        } else if (i == 3) {
            obj = "attribute";
        } else if (i == 4) {
            obj = "attribute group";
        } else if (i != 5) {
            obj = i != 6 ? "definition" : "model group";
        } else {
            obj = "identity constraint";
        }
        SchemaComponent schemaComponentFindSpelling = findSpelling(qName);
        if (schemaComponentFindSpelling == null || (name = schemaComponentFindSpelling.getName()) == null) {
            objPretty = null;
            obj2 = null;
            obj3 = null;
        } else {
            int componentType = schemaComponentFindSpelling.getComponentType();
            if (componentType == 0) {
                sourceName = ((SchemaType) schemaComponentFindSpelling).getSourceName();
                obj4 = JamXmlElements.TYPE;
            } else if (componentType == 1) {
                sourceName = ((SchemaGlobalElement) schemaComponentFindSpelling).getSourceName();
                obj4 = "element";
            } else if (componentType == 3) {
                sourceName = ((SchemaGlobalAttribute) schemaComponentFindSpelling).getSourceName();
                obj4 = "attribute";
            } else if (componentType == 4) {
                sourceName = null;
            } else if (componentType != 6) {
                sourceName = null;
                obj4 = null;
            } else {
                obj4 = "model group";
                sourceName = null;
            }
            if (sourceName != null) {
                sourceName = sourceName.substring(sourceName.lastIndexOf(47) + 1);
            }
            if (name.equals(qName)) {
                obj3 = obj4;
                obj2 = sourceName;
                objPretty = null;
            } else {
                Object obj5 = obj4;
                obj2 = sourceName;
                objPretty = QNameHelper.pretty(name);
                obj3 = obj5;
            }
        }
        if (obj3 == null) {
            error("src-resolve", new Object[]{obj, objPretty2}, xmlObject);
            return;
        }
        Object[] objArr = new Object[7];
        objArr[0] = obj;
        objArr[1] = objPretty2;
        objArr[2] = obj3;
        objArr[3] = objPretty == null ? new Integer(0) : new Integer(1);
        objArr[4] = objPretty;
        objArr[5] = obj2 == null ? new Integer(0) : new Integer(1);
        objArr[6] = obj2;
        error("src-resolve.a", objArr, xmlObject);
    }

    public String sourceNameForUri(String str) {
        return (String) this._sourceForUri.get(str);
    }

    public Map sourceCopyMap() {
        return Collections.unmodifiableMap(this._sourceForUri);
    }

    public void setBaseUri(URI uri) {
        this._baseURI = uri;
    }

    public String relativize(String str) {
        return relativize(str, $assertionsDisabled);
    }

    public String computeSavedFilename(String str) {
        return relativize(str, true);
    }

    private String relativize(String str, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("/")) {
            str = PROJECT_URL_PREFIX + str.replace('\\', '/');
        } else {
            int iIndexOf = str.indexOf(58);
            if (iIndexOf <= 1 || !str.substring(0, iIndexOf).matches("^\\w+$")) {
                str = "project://local/" + str.replace('\\', '/');
            }
        }
        URI uri = this._baseURI;
        if (uri != null) {
            try {
                URI uriRelativize = uri.relativize(new URI(str));
                if (!uriRelativize.isAbsolute()) {
                    return uriRelativize.toString();
                }
                str = uriRelativize.toString();
            } catch (URISyntaxException unused) {
            }
        }
        if (!z) {
            return str;
        }
        int iLastIndexOf = str.lastIndexOf(47);
        String strHexsafe = QNameHelper.hexsafe(iLastIndexOf == -1 ? "" : str.substring(0, iLastIndexOf));
        int i = iLastIndexOf + 1;
        int iIndexOf2 = str.indexOf(63, i);
        if (iIndexOf2 == -1) {
            return strHexsafe + "/" + str.substring(i);
        }
        String strHexsafe2 = QNameHelper.hexsafe(iIndexOf2 != -1 ? str.substring(iIndexOf2) : "");
        if (strHexsafe2.startsWith(QNameHelper.URI_SHA1_PREFIX)) {
            return strHexsafe + "/" + str.substring(i, iIndexOf2);
        }
        return strHexsafe + "/" + str.substring(i, iIndexOf2) + strHexsafe2;
    }

    public void addSourceUri(String str, String str2) {
        if (str == null) {
            return;
        }
        if (str2 == null) {
            str2 = computeSavedFilename(str);
        }
        this._sourceForUri.put(str, str2);
    }

    public Collection getErrorListener() {
        return this._errorListener;
    }

    public SchemaTypeLoader getS4SLoader() {
        return this._s4sloader;
    }

    public File getSchemasDir() {
        return this._schemasDir;
    }

    public void setSchemasDir(File file) {
        this._schemasDir = file;
    }
}
