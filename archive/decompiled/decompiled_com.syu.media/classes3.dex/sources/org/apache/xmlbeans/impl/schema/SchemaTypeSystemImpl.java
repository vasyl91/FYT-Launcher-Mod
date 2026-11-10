package org.apache.xmlbeans.impl.schema;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.Filer;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.ResourceLoader;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeLoaderException;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.DefaultClassLoaderResourceLoader;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.apache.xmlbeans.impl.common.XBeanDebug;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.repackage.Repackager;
import org.apache.xmlbeans.impl.util.FilerImpl;
import org.apache.xmlbeans.impl.util.HexBin;
import org.apache.xmlbeans.impl.values.XmlObjectBase;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument;
import org.apache.xmlbeans.soap.SOAPArrayType;
import org.apache.xmlbeans.soap.SchemaWSDLArrayType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SchemaTypeSystemImpl extends SchemaTypeLoaderBase implements SchemaTypeSystem {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CONSTANT_CLASS = 7;
    private static final int CONSTANT_DOUBLE = 6;
    private static final int CONSTANT_FIELD = 9;
    private static final int CONSTANT_FLOAT = 4;
    private static final int CONSTANT_INTEGER = 3;
    private static final int CONSTANT_INTERFACEMETHOD = 11;
    private static final int CONSTANT_LONG = 5;
    private static final int CONSTANT_METHOD = 10;
    private static final int CONSTANT_NAMEANDTYPE = 12;
    private static final int CONSTANT_STRING = 8;
    private static final int CONSTANT_UNICODE = 2;
    private static final int CONSTANT_UTF8 = 1;
    public static final int DATA_BABE = -629491010;
    private static final SchemaAttributeGroup[] EMPTY_AG_ARRAY;
    private static final SchemaAnnotation[] EMPTY_ANN_ARRAY;
    private static final SchemaGlobalAttribute[] EMPTY_GA_ARRAY;
    private static final SchemaGlobalElement[] EMPTY_GE_ARRAY;
    private static final SchemaIdentityConstraint[] EMPTY_IC_ARRAY;
    private static final SchemaModelGroup[] EMPTY_MG_ARRAY;
    private static final SchemaType[] EMPTY_ST_ARRAY;
    public static final int FIELD_GLOBAL = 1;
    public static final int FIELD_LOCALATTR = 2;
    public static final int FIELD_LOCALELT = 3;
    public static final int FIELD_NONE = 0;
    public static final int FILETYPE_SCHEMAATTRIBUTE = 4;
    public static final int FILETYPE_SCHEMAATTRIBUTEGROUP = 7;
    public static final int FILETYPE_SCHEMAELEMENT = 3;
    public static final int FILETYPE_SCHEMAIDENTITYCONSTRAINT = 8;
    public static final int FILETYPE_SCHEMAINDEX = 1;
    public static final int FILETYPE_SCHEMAMODELGROUP = 6;
    public static final int FILETYPE_SCHEMAPOINTER = 5;
    public static final int FILETYPE_SCHEMATYPE = 2;
    static final int FLAG_ABSTRACT = 262144;
    static final int FLAG_ATTRIBUTE_TYPE = 524288;
    static final int FLAG_BLOCK_EXT = 4096;
    static final int FLAG_BLOCK_REST = 8192;
    static final int FLAG_BOUNDED = 8;
    static final int FLAG_COMPILED = 2048;
    static final int FLAG_DOCUMENT_TYPE = 2;
    static final int FLAG_FINAL_EXT = 16384;
    static final int FLAG_FINAL_LIST = 131072;
    static final int FLAG_FINAL_REST = 32768;
    static final int FLAG_FINAL_UNION = 65536;
    static final int FLAG_FINITE = 16;
    static final int FLAG_HAS_PATTERN = 256;
    static final int FLAG_NUMERIC = 32;
    static final int FLAG_ORDERED = 4;
    static final int FLAG_ORDER_SENSITIVE = 512;
    public static final int FLAG_PART_ABSTRACT = 128;
    public static final int FLAG_PART_BLOCKEXT = 16;
    public static final int FLAG_PART_BLOCKREST = 32;
    public static final int FLAG_PART_BLOCKSUBST = 64;
    public static final int FLAG_PART_FINALEXT = 256;
    public static final int FLAG_PART_FINALREST = 512;
    public static final int FLAG_PART_FIXED = 4;
    public static final int FLAG_PART_NILLABLE = 8;
    public static final int FLAG_PART_SKIPPABLE = 1;
    public static final int FLAG_PROP_ISATTR = 1;
    public static final int FLAG_PROP_JAVAARRAY = 8;
    public static final int FLAG_PROP_JAVAOPTIONAL = 4;
    public static final int FLAG_PROP_JAVASINGLETON = 2;
    static final int FLAG_SIMPLE_TYPE = 1;
    static final int FLAG_STRINGENUM = 64;
    static final int FLAG_TOTAL_ORDER = 1024;
    static final int FLAG_UNION_OF_LISTS = 128;
    private static final String HOLDER_TEMPLATE_CLASS = "org.apache.xmlbeans.impl.schema.TypeSystemHolder";
    private static final String HOLDER_TEMPLATE_CLASSFILE = "TypeSystemHolder.template";
    private static final String[] HOLDER_TEMPLATE_NAMES;
    public static final int MAJOR_VERSION = 2;
    private static final int MAX_UNSIGNED_SHORT = 65535;
    public static String METADATA_PACKAGE_GEN = null;
    public static final int MINOR_VERSION = 24;
    public static final int RELEASE_NUMBER = 0;
    static final byte[] SINGLE_ZERO_BYTE;
    private static byte[] _mask;
    private static Random _random;
    private List _annotations;
    private Map _attributeGroups;
    private Map _attributeTypes;
    private String _basePackage;
    private ClassLoader _classloader;
    private SchemaDependencies _deps;
    private Map _documentTypes;
    private Filer _filer;
    private Map _globalAttributes;
    private Map _globalElements;
    private Map _globalTypes;
    SchemaTypeLoader _linker;
    private HandlePool _localHandles;
    private Map _modelGroups;
    private String _name;
    private Set _namespaces;
    private List _redefinedAttributeGroups;
    private List _redefinedGlobalTypes;
    private List _redefinedModelGroups;
    private ResourceLoader _resourceLoader;
    private boolean _incomplete = $assertionsDisabled;
    private Map _containers = new HashMap();
    private Map _identityConstraints = Collections.EMPTY_MAP;
    private Map _typeRefsByClassname = new HashMap();
    private final Map _resolvedHandles = new HashMap();
    private boolean _allNonGroupHandlesResolved = $assertionsDisabled;

    private void assertContainersSynchronized() {
    }

    final SchemaTypeSystemImpl getTypeSystem() {
        return this;
    }

    static {
        Package r0 = SchemaTypeSystem.class.getPackage();
        METADATA_PACKAGE_GEN = (r0 == null ? SchemaTypeSystem.class.getName().substring(0, SchemaTypeSystem.class.getName().lastIndexOf(".")) : r0.getName()).replaceAll("\\.", "_");
        HOLDER_TEMPLATE_NAMES = makeClassStrings(HOLDER_TEMPLATE_CLASS);
        _mask = new byte[16];
        EMPTY_ST_ARRAY = new SchemaType[0];
        EMPTY_GE_ARRAY = new SchemaGlobalElement[0];
        EMPTY_GA_ARRAY = new SchemaGlobalAttribute[0];
        EMPTY_MG_ARRAY = new SchemaModelGroup[0];
        EMPTY_AG_ARRAY = new SchemaAttributeGroup[0];
        EMPTY_IC_ARRAY = new SchemaIdentityConstraint[0];
        EMPTY_ANN_ARRAY = new SchemaAnnotation[0];
        SINGLE_ZERO_BYTE = new byte[]{0};
    }

    private static String nameToPathString(String str) {
        String strReplace = str.replace(NameUtil.PERIOD, '/');
        return (strReplace.endsWith("/") || strReplace.length() <= 0) ? strReplace : strReplace + "/";
    }

    public SchemaTypeSystemImpl(Class cls) throws Throwable {
        String name = cls.getName();
        this._name = name.substring(0, name.lastIndexOf(46));
        XBeanDebug.trace(1, "Loading type system " + this._name, 1);
        this._basePackage = nameToPathString(this._name);
        ClassLoader classLoader = cls.getClassLoader();
        this._classloader = classLoader;
        this._linker = SchemaTypeLoaderImpl.build(null, null, classLoader, getMetadataPath());
        this._resourceLoader = new ClassLoaderResourceLoader(this._classloader);
        try {
            initFromHeader();
            XBeanDebug.trace(1, "Finished loading type system " + this._name, -1);
        } catch (Error e) {
            XBeanDebug.logException(e);
            throw e;
        } catch (RuntimeException e2) {
            XBeanDebug.logException(e2);
            throw e2;
        }
    }

    public static boolean fileContainsTypeSystem(File file, String str) throws Throwable {
        String str2 = nameToPathString(str) + "index.xsb";
        if (file.isDirectory()) {
            return new File(file, str2).isFile();
        }
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    ZipEntry entry = zipFile2.getEntry(str2);
                    boolean z = (entry == null || entry.isDirectory()) ? $assertionsDisabled : true;
                    try {
                        zipFile2.close();
                    } catch (IOException unused) {
                    }
                    return z;
                } catch (IOException e) {
                    e = e;
                    zipFile = zipFile2;
                    XBeanDebug.log("Problem loading SchemaTypeSystem, zipfilename " + file);
                    XBeanDebug.logException(e);
                    throw new SchemaTypeLoaderException(e.getMessage(), str, "index", 9);
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static SchemaTypeSystemImpl forName(String str, ClassLoader classLoader) {
        try {
            return (SchemaTypeSystemImpl) Class.forName(str + ".TypeSystemHolder", true, classLoader).getField("typeSystem").get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    public SchemaTypeSystemImpl(ResourceLoader resourceLoader, String str, SchemaTypeLoader schemaTypeLoader) throws Throwable {
        this._name = str;
        this._basePackage = nameToPathString(str);
        this._linker = schemaTypeLoader;
        this._resourceLoader = resourceLoader;
        try {
            initFromHeader();
        } catch (Error e) {
            XBeanDebug.logException(e);
            throw e;
        } catch (RuntimeException e2) {
            XBeanDebug.logException(e2);
            throw e2;
        }
    }

    private void initFromHeader() throws Throwable {
        XsbReader xsbReader;
        Throwable th;
        XBeanDebug.trace(1, "Reading unresolved handles for type system " + this._name, 0);
        try {
            xsbReader = new XsbReader("index", 1);
            try {
                HandlePool handlePool = new HandlePool();
                this._localHandles = handlePool;
                xsbReader.readHandlePool(handlePool);
                this._globalElements = xsbReader.readQNameRefMap();
                this._globalAttributes = xsbReader.readQNameRefMap();
                this._modelGroups = xsbReader.readQNameRefMap();
                this._attributeGroups = xsbReader.readQNameRefMap();
                this._identityConstraints = xsbReader.readQNameRefMap();
                this._globalTypes = xsbReader.readQNameRefMap();
                this._documentTypes = xsbReader.readQNameRefMap();
                this._attributeTypes = xsbReader.readQNameRefMap();
                this._typeRefsByClassname = xsbReader.readClassnameRefMap();
                this._namespaces = xsbReader.readNamespaces();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                if (xsbReader.atLeast(2, 15, 0)) {
                    this._redefinedGlobalTypes = xsbReader.readQNameRefMapAsList(arrayList);
                    this._redefinedModelGroups = xsbReader.readQNameRefMapAsList(arrayList2);
                    this._redefinedAttributeGroups = xsbReader.readQNameRefMapAsList(arrayList3);
                }
                if (xsbReader.atLeast(2, 19, 0)) {
                    this._annotations = xsbReader.readAnnotations();
                }
                buildContainers(arrayList, arrayList2, arrayList3);
                xsbReader.readEnd();
            } catch (Throwable th2) {
                th = th2;
                if (xsbReader != null) {
                    xsbReader.readEnd();
                }
                throw th;
            }
        } catch (Throwable th3) {
            xsbReader = null;
            th = th3;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
    void saveIndex() throws SchemaTypeLoaderException {
        XsbReader xsbReader = new XsbReader("index");
        xsbReader.writeIndexData();
        xsbReader.writeRealHeader("index", 1);
        xsbReader.writeIndexData();
        xsbReader.writeEnd();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
    void savePointers() throws SchemaTypeLoaderException {
        savePointersForComponents(globalElements(), getMetadataPath() + "/element/");
        savePointersForComponents(globalAttributes(), getMetadataPath() + "/attribute/");
        savePointersForComponents(modelGroups(), getMetadataPath() + "/modelgroup/");
        savePointersForComponents(attributeGroups(), getMetadataPath() + "/attributegroup/");
        savePointersForComponents(globalTypes(), getMetadataPath() + "/type/");
        savePointersForComponents(identityConstraints(), getMetadataPath() + "/identityconstraint/");
        savePointersForNamespaces(this._namespaces, getMetadataPath() + "/namespace/");
        savePointersForClassnames(this._typeRefsByClassname.keySet(), getMetadataPath() + "/javaname/");
        savePointersForComponents(redefinedModelGroups(), getMetadataPath() + "/redefinedmodelgroup/");
        savePointersForComponents(redefinedAttributeGroups(), getMetadataPath() + "/redefinedattributegroup/");
        savePointersForComponents(redefinedGlobalTypes(), getMetadataPath() + "/redefinedtype/");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
    void savePointersForComponents(SchemaComponent[] schemaComponentArr, String str) throws SchemaTypeLoaderException {
        for (SchemaComponent schemaComponent : schemaComponentArr) {
            savePointerFile(str + QNameHelper.hexsafedir(schemaComponent.getName()), this._name);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
    void savePointersForClassnames(Set set, String str) throws SchemaTypeLoaderException {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            savePointerFile(str + ((String) it.next()).replace(NameUtil.PERIOD, '/'), this._name);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
    void savePointersForNamespaces(Set set, String str) throws SchemaTypeLoaderException {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            savePointerFile(str + QNameHelper.hexsafedir(new QName((String) it.next(), Sax2Dom.XMLNS_PREFIX)), this._name);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
    void savePointerFile(String str, String str2) throws SchemaTypeLoaderException {
        XsbReader xsbReader = new XsbReader(str);
        xsbReader.writeString(str2);
        xsbReader.writeRealHeader(str, 5);
        xsbReader.writeString(str2);
        xsbReader.writeEnd();
    }

    void saveLoader() throws Throwable {
        String strIndexClassForSystem = SchemaTypeCodePrinter.indexClassForSystem(this);
        String[] strArrMakeClassStrings = makeClassStrings(strIndexClassForSystem);
        Filer filer = this._filer;
        InputStream inputStream = null;
        Repackager repackager = filer instanceof FilerImpl ? ((FilerImpl) filer).getRepackager() : null;
        try {
            try {
                InputStream resourceAsStream = SchemaTypeSystemImpl.class.getResourceAsStream(HOLDER_TEMPLATE_CLASSFILE);
                if (resourceAsStream == null) {
                    try {
                        resourceAsStream = new DefaultClassLoaderResourceLoader().getResourceAsStream(HOLDER_TEMPLATE_CLASSFILE);
                    } catch (IOException unused) {
                        inputStream = resourceAsStream;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        if (inputStream != 0) {
                            inputStream.close();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = resourceAsStream;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (inputStream == 0) {
                            throw th;
                        }
                        try {
                            inputStream.close();
                            throw th;
                        } catch (Exception unused4) {
                            throw th;
                        }
                    }
                }
                if (resourceAsStream == null) {
                    throw new SchemaTypeLoaderException("couldn't find resource: TypeSystemHolder.template", this._name, (String) null, 9);
                }
                DataInputStream dataInputStream = new DataInputStream(resourceAsStream);
                OutputStream outputStreamCreateBinaryFile = this._filer.createBinaryFile(strIndexClassForSystem.replace(NameUtil.PERIOD, '/') + ".class");
                DataOutputStream dataOutputStream = new DataOutputStream(outputStreamCreateBinaryFile);
                dataOutputStream.writeInt(dataInputStream.readInt());
                dataOutputStream.writeShort(dataInputStream.readUnsignedShort());
                dataOutputStream.writeShort(dataInputStream.readUnsignedShort());
                int unsignedShort = dataInputStream.readUnsignedShort();
                dataOutputStream.writeShort(unsignedShort);
                for (int i = 1; i < unsignedShort; i++) {
                    int unsignedByte = dataInputStream.readUnsignedByte();
                    dataOutputStream.writeByte(unsignedByte);
                    switch (unsignedByte) {
                        case 1:
                            dataOutputStream.writeUTF(repackageConstant(dataInputStream.readUTF(), strArrMakeClassStrings, repackager));
                            break;
                        case 2:
                        default:
                            throw new RuntimeException("Unexpected constant type: " + unsignedByte);
                        case 3:
                        case 4:
                            dataOutputStream.writeInt(dataInputStream.readInt());
                            break;
                        case 5:
                        case 6:
                            dataOutputStream.writeInt(dataInputStream.readInt());
                            dataOutputStream.writeInt(dataInputStream.readInt());
                            break;
                        case 7:
                        case 8:
                            dataOutputStream.writeShort(dataInputStream.readUnsignedShort());
                            break;
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                            dataOutputStream.writeShort(dataInputStream.readUnsignedShort());
                            dataOutputStream.writeShort(dataInputStream.readUnsignedShort());
                            break;
                    }
                }
                while (true) {
                    try {
                        dataOutputStream.writeByte(dataInputStream.readByte());
                    } catch (EOFException unused5) {
                        if (resourceAsStream != null) {
                            try {
                                resourceAsStream.close();
                            } catch (Exception unused6) {
                            }
                        }
                        if (outputStreamCreateBinaryFile != null) {
                            outputStreamCreateBinaryFile.close();
                        }
                        return;
                    }
                }
            } catch (Exception unused7) {
            }
        } catch (IOException unused8) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String repackageConstant(String str, String[] strArr, Repackager repackager) {
        int i = 0;
        while (true) {
            String[] strArr2 = HOLDER_TEMPLATE_NAMES;
            if (i >= strArr2.length) {
                return repackager != null ? repackager.repackage(new StringBuffer(str)).toString() : str;
            }
            if (strArr2[i].equals(str)) {
                return strArr[i];
            }
            i++;
        }
    }

    private static String[] makeClassStrings(String str) {
        String[] strArr = new String[4];
        strArr[0] = str;
        strArr[1] = str.replace(NameUtil.PERIOD, '/');
        strArr[2] = "L" + strArr[1] + ";";
        strArr[3] = "class$" + str.replace(NameUtil.PERIOD, '$');
        return strArr;
    }

    private Map buildTypeRefsByClassname() {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        arrayList.addAll(Arrays.asList(documentTypes()));
        arrayList.addAll(Arrays.asList(attributeTypes()));
        arrayList.addAll(Arrays.asList(globalTypes()));
        for (int i = 0; i < arrayList.size(); i++) {
            SchemaType schemaType = (SchemaType) arrayList.get(i);
            String fullJavaName = schemaType.getFullJavaName();
            if (fullJavaName != null) {
                linkedHashMap.put(fullJavaName.replace('$', NameUtil.PERIOD), schemaType.getRef());
            }
            arrayList.addAll(Arrays.asList(schemaType.getAnonymousTypes()));
        }
        return linkedHashMap;
    }

    private Map buildTypeRefsByClassname(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : map.keySet()) {
            linkedHashMap.put(str, ((SchemaType) map.get(str)).getRef());
        }
        return linkedHashMap;
    }

    private static Map buildComponentRefMap(SchemaComponent[] schemaComponentArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < schemaComponentArr.length; i++) {
            linkedHashMap.put(schemaComponentArr[i].getName(), schemaComponentArr[i].getComponentRef());
        }
        return linkedHashMap;
    }

    private static List buildComponentRefList(SchemaComponent[] schemaComponentArr) {
        ArrayList arrayList = new ArrayList();
        for (SchemaComponent schemaComponent : schemaComponentArr) {
            arrayList.add(schemaComponent.getComponentRef());
        }
        return arrayList;
    }

    private static Map buildDocumentMap(SchemaType[] schemaTypeArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < schemaTypeArr.length; i++) {
            linkedHashMap.put(schemaTypeArr[i].getDocumentElementName(), schemaTypeArr[i].getRef());
        }
        return linkedHashMap;
    }

    private static Map buildAttributeTypeMap(SchemaType[] schemaTypeArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < schemaTypeArr.length; i++) {
            linkedHashMap.put(schemaTypeArr[i].getAttributeTypeAttributeName(), schemaTypeArr[i].getRef());
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SchemaContainer getContainer(String str) {
        return (SchemaContainer) this._containers.get(str);
    }

    private void addContainer(String str) {
        SchemaContainer schemaContainer = new SchemaContainer(str);
        schemaContainer.setTypeSystem(this);
        this._containers.put(str, schemaContainer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SchemaContainer getContainerNonNull(String str) {
        SchemaContainer container = getContainer(str);
        if (container != null) {
            return container;
        }
        addContainer(str);
        return getContainer(str);
    }

    private void buildContainers(List list, List list2, List list3) {
        for (Map.Entry entry : this._globalElements.entrySet()) {
            getContainerNonNull(((QName) entry.getKey()).getNamespaceURI()).addGlobalElement((SchemaGlobalElement.Ref) entry.getValue());
        }
        for (Map.Entry entry2 : this._globalAttributes.entrySet()) {
            getContainerNonNull(((QName) entry2.getKey()).getNamespaceURI()).addGlobalAttribute((SchemaGlobalAttribute.Ref) entry2.getValue());
        }
        for (Map.Entry entry3 : this._modelGroups.entrySet()) {
            getContainerNonNull(((QName) entry3.getKey()).getNamespaceURI()).addModelGroup((SchemaModelGroup.Ref) entry3.getValue());
        }
        for (Map.Entry entry4 : this._attributeGroups.entrySet()) {
            getContainerNonNull(((QName) entry4.getKey()).getNamespaceURI()).addAttributeGroup((SchemaAttributeGroup.Ref) entry4.getValue());
        }
        for (Map.Entry entry5 : this._identityConstraints.entrySet()) {
            getContainerNonNull(((QName) entry5.getKey()).getNamespaceURI()).addIdentityConstraint((SchemaIdentityConstraint.Ref) entry5.getValue());
        }
        for (Map.Entry entry6 : this._globalTypes.entrySet()) {
            getContainerNonNull(((QName) entry6.getKey()).getNamespaceURI()).addGlobalType((SchemaType.Ref) entry6.getValue());
        }
        for (Map.Entry entry7 : this._documentTypes.entrySet()) {
            getContainerNonNull(((QName) entry7.getKey()).getNamespaceURI()).addDocumentType((SchemaType.Ref) entry7.getValue());
        }
        for (Map.Entry entry8 : this._attributeTypes.entrySet()) {
            getContainerNonNull(((QName) entry8.getKey()).getNamespaceURI()).addAttributeType((SchemaType.Ref) entry8.getValue());
        }
        List list4 = this._redefinedGlobalTypes;
        if (list4 != null && this._redefinedModelGroups != null && this._redefinedAttributeGroups != null) {
            Iterator it = list4.iterator();
            Iterator it2 = list.iterator();
            while (it.hasNext()) {
                getContainerNonNull(((QName) it2.next()).getNamespaceURI()).addRedefinedType((SchemaType.Ref) it.next());
            }
            Iterator it3 = this._redefinedModelGroups.iterator();
            Iterator it4 = list2.iterator();
            while (it3.hasNext()) {
                getContainerNonNull(((QName) it4.next()).getNamespaceURI()).addRedefinedModelGroup((SchemaModelGroup.Ref) it3.next());
            }
            Iterator it5 = this._redefinedAttributeGroups.iterator();
            Iterator it6 = list3.iterator();
            while (it5.hasNext()) {
                getContainerNonNull(((QName) it6.next()).getNamespaceURI()).addRedefinedAttributeGroup((SchemaAttributeGroup.Ref) it5.next());
            }
        }
        List list5 = this._annotations;
        if (list5 != null) {
            Iterator it7 = list5.iterator();
            while (it7.hasNext()) {
                getContainerNonNull("").addAnnotation((SchemaAnnotation) it7.next());
            }
        }
        Iterator it8 = this._containers.values().iterator();
        while (it8.hasNext()) {
            ((SchemaContainer) it8.next()).setImmutable();
        }
    }

    private void fixupContainers() {
        for (SchemaContainer schemaContainer : this._containers.values()) {
            schemaContainer.setTypeSystem(this);
            schemaContainer.setImmutable();
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x008b A[Catch: all -> 0x009c, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0003, B:7:0x0008, B:10:0x0036, B:12:0x003e, B:13:0x0048, B:14:0x004b, B:15:0x005e, B:17:0x0061, B:21:0x0078, B:22:0x0083, B:23:0x0088, B:25:0x008b, B:20:0x0075), top: B:34:0x0003, inners: #0 }] */
    private static synchronized void nextBytes(byte[] bArr) {
        if (_random == null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeInt(System.identityHashCode(SchemaTypeSystemImpl.class));
                String[] strArr = {"user.name", "user.dir", "user.timezone", "user.country", "java.class.path", "java.home", "java.vendor", "java.version", "os.version"};
                for (int i = 0; i < 9; i++) {
                    String property = SystemProperties.getProperty(strArr[i]);
                    if (property != null) {
                        dataOutputStream.writeUTF(property);
                        dataOutputStream.writeInt(System.identityHashCode(property));
                    }
                }
                dataOutputStream.writeLong(Runtime.getRuntime().freeMemory());
                dataOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                for (int i2 = 0; i2 < byteArray.length; i2++) {
                    byte[] bArr2 = _mask;
                    int length = i2 % bArr2.length;
                    byte b = (byte) (bArr2[length] * 21);
                    bArr2[length] = b;
                    bArr2[length] = (byte) (b + i2);
                }
            } catch (IOException e) {
                XBeanDebug.logException(e);
            }
            _random = new Random(System.currentTimeMillis());
            _random.nextBytes(bArr);
            for (int i3 = 0; i3 < bArr.length; i3++) {
                byte[] bArr3 = _mask;
                bArr[i3] = (byte) (bArr3[bArr3.length & i3] ^ bArr[i3]);
            }
        } else {
            _random.nextBytes(bArr);
            while (i3 < bArr.length) {
                byte[] bArr4 = _mask;
                bArr[i3] = (byte) (bArr4[bArr4.length & i3] ^ bArr[i3]);
            }
        }
        throw th;
    }

    public SchemaTypeSystemImpl(String str) {
        if (str == null) {
            byte[] bArr = new byte[16];
            nextBytes(bArr);
            str = "s".concat(new String(HexBin.encode(bArr)));
        }
        String str2 = getMetadataPath().replace('/', NameUtil.PERIOD) + ".system." + str;
        this._name = str2;
        this._basePackage = nameToPathString(str2);
        this._classloader = null;
    }

    public void loadFromBuilder(SchemaGlobalElement[] schemaGlobalElementArr, SchemaGlobalAttribute[] schemaGlobalAttributeArr, SchemaType[] schemaTypeArr, SchemaType[] schemaTypeArr2, SchemaType[] schemaTypeArr3) {
        this._localHandles = new HandlePool();
        this._globalElements = buildComponentRefMap(schemaGlobalElementArr);
        this._globalAttributes = buildComponentRefMap(schemaGlobalAttributeArr);
        this._globalTypes = buildComponentRefMap(schemaTypeArr);
        this._documentTypes = buildDocumentMap(schemaTypeArr2);
        this._attributeTypes = buildAttributeTypeMap(schemaTypeArr3);
        this._typeRefsByClassname = buildTypeRefsByClassname();
        buildContainers(Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST);
        this._namespaces = new HashSet();
    }

    public void loadFromStscState(StscState stscState) {
        this._localHandles = new HandlePool();
        this._globalElements = buildComponentRefMap(stscState.globalElements());
        this._globalAttributes = buildComponentRefMap(stscState.globalAttributes());
        this._modelGroups = buildComponentRefMap(stscState.modelGroups());
        this._redefinedModelGroups = buildComponentRefList(stscState.redefinedModelGroups());
        this._attributeGroups = buildComponentRefMap(stscState.attributeGroups());
        this._redefinedAttributeGroups = buildComponentRefList(stscState.redefinedAttributeGroups());
        this._globalTypes = buildComponentRefMap(stscState.globalTypes());
        this._redefinedGlobalTypes = buildComponentRefList(stscState.redefinedGlobalTypes());
        this._documentTypes = buildDocumentMap(stscState.documentTypes());
        this._attributeTypes = buildAttributeTypeMap(stscState.attributeTypes());
        this._typeRefsByClassname = buildTypeRefsByClassname(stscState.typesByClassname());
        this._identityConstraints = buildComponentRefMap(stscState.idConstraints());
        this._annotations = stscState.annotations();
        this._namespaces = new HashSet(Arrays.asList(stscState.getNamespaces()));
        this._containers = stscState.getContainerMap();
        fixupContainers();
        assertContainersSynchronized();
        setDependencies(stscState.getDependencies());
    }

    void setDependencies(SchemaDependencies schemaDependencies) {
        this._deps = schemaDependencies;
    }

    SchemaDependencies getDependencies() {
        return this._deps;
    }

    public boolean isIncomplete() {
        return this._incomplete;
    }

    void setIncomplete(boolean z) {
        this._incomplete = z;
    }

    static class StringPool {
        private String _handle;
        private String _name;
        private List intsToStrings = new ArrayList();
        private Map stringsToInts = new HashMap();

        StringPool(String str, String str2) {
            this._handle = str;
            this._name = str2;
            this.intsToStrings.add(null);
        }

        int codeForString(String str) {
            if (str == null) {
                return 0;
            }
            Integer num = (Integer) this.stringsToInts.get(str);
            if (num == null) {
                num = new Integer(this.intsToStrings.size());
                this.intsToStrings.add(str);
                this.stringsToInts.put(str, num);
            }
            return num.intValue();
        }

        String stringForCode(int i) {
            if (i == 0) {
                return null;
            }
            return (String) this.intsToStrings.get(i);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeTo(DataOutputStream dataOutputStream) throws SchemaTypeLoaderException {
            if (this.intsToStrings.size() >= SchemaTypeSystemImpl.MAX_UNSIGNED_SHORT) {
                throw new SchemaTypeLoaderException("Too many strings (" + this.intsToStrings.size() + ")", this._name, this._handle, 10);
            }
            try {
                dataOutputStream.writeShort(this.intsToStrings.size());
                Iterator it = this.intsToStrings.iterator();
                it.next();
                while (it.hasNext()) {
                    dataOutputStream.writeUTF((String) it.next());
                }
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), this._name, this._handle, 9);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void readFrom(DataInputStream dataInputStream) throws SchemaTypeLoaderException {
            if (this.intsToStrings.size() != 1 || this.stringsToInts.size() != 0) {
                throw new IllegalStateException();
            }
            try {
                int unsignedShort = dataInputStream.readUnsignedShort();
                for (int i = 1; i < unsignedShort; i++) {
                    if (codeForString(dataInputStream.readUTF().intern()) != i) {
                        throw new IllegalStateException();
                    }
                }
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage() == null ? e.getMessage() : "IO Exception", this._name, this._handle, 9, e);
            }
        }
    }

    class HandlePool {
        private boolean _started;
        private Map _handlesToRefs = new LinkedHashMap();
        private Map _componentsToHandles = new LinkedHashMap();

        HandlePool() {
        }

        private String addUniqueHandle(SchemaComponent schemaComponent, String str) {
            String lowerCase = str.toLowerCase();
            int i = 2;
            String str2 = lowerCase;
            while (this._handlesToRefs.containsKey(str2)) {
                str2 = lowerCase + i;
                i++;
            }
            this._handlesToRefs.put(str2, schemaComponent.getComponentRef());
            this._componentsToHandles.put(schemaComponent, str2);
            return str2;
        }

        String handleForComponent(SchemaComponent schemaComponent) {
            if (schemaComponent == null) {
                return null;
            }
            if (schemaComponent.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            if (schemaComponent instanceof SchemaType) {
                return handleForType((SchemaType) schemaComponent);
            }
            if (schemaComponent instanceof SchemaGlobalElement) {
                return handleForElement((SchemaGlobalElement) schemaComponent);
            }
            if (schemaComponent instanceof SchemaGlobalAttribute) {
                return handleForAttribute((SchemaGlobalAttribute) schemaComponent);
            }
            if (schemaComponent instanceof SchemaModelGroup) {
                return handleForModelGroup((SchemaModelGroup) schemaComponent);
            }
            if (schemaComponent instanceof SchemaAttributeGroup) {
                return handleForAttributeGroup((SchemaAttributeGroup) schemaComponent);
            }
            if (schemaComponent instanceof SchemaIdentityConstraint) {
                return handleForIdentityConstraint((SchemaIdentityConstraint) schemaComponent);
            }
            throw new IllegalStateException("Component type cannot have a handle");
        }

        String handleForElement(SchemaGlobalElement schemaGlobalElement) {
            if (schemaGlobalElement == null) {
                return null;
            }
            if (schemaGlobalElement.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            String str = (String) this._componentsToHandles.get(schemaGlobalElement);
            return str == null ? addUniqueHandle(schemaGlobalElement, NameUtil.upperCamelCase(schemaGlobalElement.getName().getLocalPart()) + "Element") : str;
        }

        String handleForAttribute(SchemaGlobalAttribute schemaGlobalAttribute) {
            if (schemaGlobalAttribute == null) {
                return null;
            }
            if (schemaGlobalAttribute.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            String str = (String) this._componentsToHandles.get(schemaGlobalAttribute);
            return str == null ? addUniqueHandle(schemaGlobalAttribute, NameUtil.upperCamelCase(schemaGlobalAttribute.getName().getLocalPart()) + "Attribute") : str;
        }

        String handleForModelGroup(SchemaModelGroup schemaModelGroup) {
            if (schemaModelGroup == null) {
                return null;
            }
            if (schemaModelGroup.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            String str = (String) this._componentsToHandles.get(schemaModelGroup);
            return str == null ? addUniqueHandle(schemaModelGroup, NameUtil.upperCamelCase(schemaModelGroup.getName().getLocalPart()) + "ModelGroup") : str;
        }

        String handleForAttributeGroup(SchemaAttributeGroup schemaAttributeGroup) {
            if (schemaAttributeGroup == null) {
                return null;
            }
            if (schemaAttributeGroup.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            String str = (String) this._componentsToHandles.get(schemaAttributeGroup);
            return str == null ? addUniqueHandle(schemaAttributeGroup, NameUtil.upperCamelCase(schemaAttributeGroup.getName().getLocalPart()) + "AttributeGroup") : str;
        }

        String handleForIdentityConstraint(SchemaIdentityConstraint schemaIdentityConstraint) {
            if (schemaIdentityConstraint == null) {
                return null;
            }
            if (schemaIdentityConstraint.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            String str = (String) this._componentsToHandles.get(schemaIdentityConstraint);
            return str == null ? addUniqueHandle(schemaIdentityConstraint, NameUtil.upperCamelCase(schemaIdentityConstraint.getName().getLocalPart()) + "IdentityConstraint") : str;
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0058  */
        String handleForType(SchemaType schemaType) {
            String str;
            String str2;
            if (schemaType == null) {
                return null;
            }
            if (schemaType.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            String str3 = (String) this._componentsToHandles.get(schemaType);
            if (str3 != null) {
                return str3;
            }
            QName name = schemaType.getName();
            if (name != null) {
                str = "";
            } else if (schemaType.isDocumentType()) {
                name = schemaType.getDocumentElementName();
                str = "Doc";
            } else if (schemaType.isAttributeType()) {
                name = schemaType.getAttributeTypeAttributeName();
                str = "AttrType";
            } else if (schemaType.getContainerField() != null) {
                name = schemaType.getContainerField().getName();
                str = schemaType.getContainerField().isAttribute() ? "Attr" : "Elem";
            } else {
                str = "";
            }
            String upperCase = Integer.toHexString(schemaType.toString().hashCode() | Integer.MIN_VALUE).substring(4).toUpperCase();
            if (name == null) {
                str2 = "Anon" + upperCase + "Type";
            } else {
                str2 = NameUtil.upperCamelCase(name.getLocalPart()) + upperCase + str + "Type";
            }
            return addUniqueHandle(schemaType, str2);
        }

        SchemaComponent.Ref refForHandle(String str) {
            if (str == null) {
                return null;
            }
            return (SchemaComponent.Ref) this._handlesToRefs.get(str);
        }

        Set getAllHandles() {
            return this._handlesToRefs.keySet();
        }

        void startWriteMode() {
            this._started = true;
            this._componentsToHandles = new LinkedHashMap();
            for (String str : this._handlesToRefs.keySet()) {
                this._componentsToHandles.put(((SchemaComponent.Ref) this._handlesToRefs.get(str)).getComponent(), str);
            }
        }
    }

    public void saveToDirectory(File file) {
        save(new FilerImpl(file, null, null, $assertionsDisabled, $assertionsDisabled));
    }

    public void save(Filer filer) {
        if (this._incomplete) {
            throw new IllegalStateException("Incomplete SchemaTypeSystems cannot be saved.");
        }
        if (filer == null) {
            throw new IllegalArgumentException("filer must not be null");
        }
        this._filer = filer;
        this._localHandles.startWriteMode();
        saveTypesRecursively(globalTypes());
        saveTypesRecursively(documentTypes());
        saveTypesRecursively(attributeTypes());
        saveGlobalElements(globalElements());
        saveGlobalAttributes(globalAttributes());
        saveModelGroups(modelGroups());
        saveAttributeGroups(attributeGroups());
        saveIdentityConstraints(identityConstraints());
        saveTypesRecursively(redefinedGlobalTypes());
        saveModelGroups(redefinedModelGroups());
        saveAttributeGroups(redefinedAttributeGroups());
        saveIndex();
        savePointers();
        saveLoader();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
    void saveTypesRecursively(SchemaType[] schemaTypeArr) throws SchemaTypeLoaderException {
        for (int i = 0; i < schemaTypeArr.length; i++) {
            if (schemaTypeArr[i].getTypeSystem() == getTypeSystem()) {
                saveType(schemaTypeArr[i]);
                saveTypesRecursively(schemaTypeArr[i].getAnonymousTypes());
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
    public void saveGlobalElements(SchemaGlobalElement[] schemaGlobalElementArr) throws SchemaTypeLoaderException {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaGlobalElement schemaGlobalElement : schemaGlobalElementArr) {
            saveGlobalElement(schemaGlobalElement);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
    public void saveGlobalAttributes(SchemaGlobalAttribute[] schemaGlobalAttributeArr) throws SchemaTypeLoaderException {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaGlobalAttribute schemaGlobalAttribute : schemaGlobalAttributeArr) {
            saveGlobalAttribute(schemaGlobalAttribute);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
    public void saveModelGroups(SchemaModelGroup[] schemaModelGroupArr) throws SchemaTypeLoaderException {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaModelGroup schemaModelGroup : schemaModelGroupArr) {
            saveModelGroup(schemaModelGroup);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
    public void saveAttributeGroups(SchemaAttributeGroup[] schemaAttributeGroupArr) throws SchemaTypeLoaderException {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaAttributeGroup schemaAttributeGroup : schemaAttributeGroupArr) {
            saveAttributeGroup(schemaAttributeGroup);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
    public void saveIdentityConstraints(SchemaIdentityConstraint[] schemaIdentityConstraintArr) throws SchemaTypeLoaderException {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaIdentityConstraint schemaIdentityConstraint : schemaIdentityConstraintArr) {
            saveIdentityConstraint(schemaIdentityConstraint);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
    public void saveGlobalElement(SchemaGlobalElement schemaGlobalElement) throws SchemaTypeLoaderException {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String strHandleForElement = this._localHandles.handleForElement(schemaGlobalElement);
        XsbReader xsbReader = new XsbReader(strHandleForElement);
        SchemaParticle schemaParticle = (SchemaParticle) schemaGlobalElement;
        xsbReader.writeParticleData(schemaParticle);
        xsbReader.writeString(schemaGlobalElement.getSourceName());
        xsbReader.writeRealHeader(strHandleForElement, 3);
        xsbReader.writeParticleData(schemaParticle);
        xsbReader.writeString(schemaGlobalElement.getSourceName());
        xsbReader.writeEnd();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
    public void saveGlobalAttribute(SchemaGlobalAttribute schemaGlobalAttribute) throws SchemaTypeLoaderException {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String strHandleForAttribute = this._localHandles.handleForAttribute(schemaGlobalAttribute);
        XsbReader xsbReader = new XsbReader(strHandleForAttribute);
        xsbReader.writeAttributeData(schemaGlobalAttribute);
        xsbReader.writeString(schemaGlobalAttribute.getSourceName());
        xsbReader.writeRealHeader(strHandleForAttribute, 4);
        xsbReader.writeAttributeData(schemaGlobalAttribute);
        xsbReader.writeString(schemaGlobalAttribute.getSourceName());
        xsbReader.writeEnd();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
    public void saveModelGroup(SchemaModelGroup schemaModelGroup) throws SchemaTypeLoaderException {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String strHandleForModelGroup = this._localHandles.handleForModelGroup(schemaModelGroup);
        XsbReader xsbReader = new XsbReader(strHandleForModelGroup);
        xsbReader.writeModelGroupData(schemaModelGroup);
        xsbReader.writeRealHeader(strHandleForModelGroup, 6);
        xsbReader.writeModelGroupData(schemaModelGroup);
        xsbReader.writeEnd();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
    public void saveAttributeGroup(SchemaAttributeGroup schemaAttributeGroup) throws SchemaTypeLoaderException {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String strHandleForAttributeGroup = this._localHandles.handleForAttributeGroup(schemaAttributeGroup);
        XsbReader xsbReader = new XsbReader(strHandleForAttributeGroup);
        xsbReader.writeAttributeGroupData(schemaAttributeGroup);
        xsbReader.writeRealHeader(strHandleForAttributeGroup, 7);
        xsbReader.writeAttributeGroupData(schemaAttributeGroup);
        xsbReader.writeEnd();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
    public void saveIdentityConstraint(SchemaIdentityConstraint schemaIdentityConstraint) throws SchemaTypeLoaderException {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String strHandleForIdentityConstraint = this._localHandles.handleForIdentityConstraint(schemaIdentityConstraint);
        XsbReader xsbReader = new XsbReader(strHandleForIdentityConstraint);
        xsbReader.writeIdConstraintData(schemaIdentityConstraint);
        xsbReader.writeRealHeader(strHandleForIdentityConstraint, 8);
        xsbReader.writeIdConstraintData(schemaIdentityConstraint);
        xsbReader.writeEnd();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
    void saveType(SchemaType schemaType) throws SchemaTypeLoaderException {
        String strHandleForType = this._localHandles.handleForType(schemaType);
        XsbReader xsbReader = new XsbReader(strHandleForType);
        xsbReader.writeTypeData(schemaType);
        xsbReader.writeRealHeader(strHandleForType, 2);
        xsbReader.writeTypeData(schemaType);
        xsbReader.writeEnd();
    }

    public static String crackPointer(InputStream inputStream) throws Throwable {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        try {
            dataInputStream = new DataInputStream(inputStream);
            try {
                if (dataInputStream.readInt() != -629491010) {
                    try {
                        dataInputStream.close();
                    } catch (IOException unused) {
                    }
                    return null;
                }
                short s = dataInputStream.readShort();
                short s2 = dataInputStream.readShort();
                if (s != 2) {
                    try {
                        dataInputStream.close();
                    } catch (IOException unused2) {
                    }
                    return null;
                }
                if (s2 > 24) {
                    try {
                        dataInputStream.close();
                    } catch (IOException unused3) {
                    }
                    return null;
                }
                if (s > 2 || (s == 2 && s2 >= 18)) {
                    dataInputStream.readShort();
                }
                if (dataInputStream.readShort() != 5) {
                    try {
                        dataInputStream.close();
                    } catch (IOException unused4) {
                    }
                    return null;
                }
                StringPool stringPool = new StringPool("pointer", "unk");
                stringPool.readFrom(dataInputStream);
                String strStringForCode = stringPool.stringForCode(dataInputStream.readShort());
                try {
                    dataInputStream.close();
                } catch (IOException unused5) {
                }
                return strStringForCode;
            } catch (IOException unused6) {
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException unused7) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    try {
                        dataInputStream2.close();
                    } catch (IOException unused8) {
                    }
                }
                throw th;
            }
        } catch (IOException unused9) {
            dataInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private class XsbReader {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        int _actualfiletype;
        String _handle;
        DataInputStream _input;
        private int _majorver;
        private int _minorver;
        DataOutputStream _output;
        private int _releaseno;
        StringPool _stringPool;

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        public XsbReader(String str, int i) throws SchemaTypeLoaderException {
            String str2 = SchemaTypeSystemImpl.this._basePackage + str + ".xsb";
            InputStream loaderStream = getLoaderStream(str2);
            if (loaderStream == null) {
                throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Could not locate compiled schema resource " + str2, SchemaTypeSystemImpl.this._name, str, 0);
            }
            this._input = new DataInputStream(loaderStream);
            this._handle = str;
            if (readInt() != -629491010) {
                throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Wrong magic cookie", SchemaTypeSystemImpl.this._name, str, 1);
            }
            this._majorver = readShort();
            int i2 = readShort();
            this._minorver = i2;
            if (this._majorver != 2) {
                throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Wrong major version - expecting 2, got " + this._majorver, SchemaTypeSystemImpl.this._name, str, 2);
            }
            if (i2 > 24) {
                throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Incompatible minor version - expecting up to 24, got " + this._minorver, SchemaTypeSystemImpl.this._name, str, 3);
            }
            if (i2 < 14) {
                throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Incompatible minor version - expecting at least 14, got " + this._minorver, SchemaTypeSystemImpl.this._name, str, 3);
            }
            if (atLeast(2, 18, 0)) {
                this._releaseno = readShort();
            }
            int i3 = readShort();
            if (i3 != i && i != SchemaTypeSystemImpl.MAX_UNSIGNED_SHORT) {
                throw new SchemaTypeLoaderException("XML-BEANS compiled schema: File has the wrong type - expecting type " + i + ", got type " + i3, SchemaTypeSystemImpl.this._name, str, 4);
            }
            StringPool stringPool = new StringPool(this._handle, SchemaTypeSystemImpl.this._name);
            this._stringPool = stringPool;
            stringPool.readFrom(this._input);
            this._actualfiletype = i3;
        }

        protected boolean atLeast(int i, int i2, int i3) {
            int i4 = this._majorver;
            if (i4 > i) {
                return true;
            }
            if (i4 < i) {
                return SchemaTypeSystemImpl.$assertionsDisabled;
            }
            int i5 = this._minorver;
            if (i5 > i2) {
                return true;
            }
            if (i5 >= i2 && this._releaseno >= i3) {
                return true;
            }
            return SchemaTypeSystemImpl.$assertionsDisabled;
        }

        protected boolean atMost(int i, int i2, int i3) {
            int i4 = this._majorver;
            if (i4 > i) {
                return SchemaTypeSystemImpl.$assertionsDisabled;
            }
            if (i4 < i) {
                return true;
            }
            int i5 = this._minorver;
            if (i5 > i2) {
                return SchemaTypeSystemImpl.$assertionsDisabled;
            }
            if (i5 >= i2 && this._releaseno > i3) {
                return SchemaTypeSystemImpl.$assertionsDisabled;
            }
            return true;
        }

        int getActualFiletype() {
            return this._actualfiletype;
        }

        XsbReader(String str) {
            this._handle = str;
            this._stringPool = new StringPool(this._handle, SchemaTypeSystemImpl.this._name);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeRealHeader(String str, int i) throws SchemaTypeLoaderException {
            String str2;
            if (str.indexOf(47) < 0) {
                str2 = SchemaTypeSystemImpl.this._basePackage + str + ".xsb";
            } else {
                str2 = str + ".xsb";
            }
            OutputStream saverStream = getSaverStream(str2);
            if (saverStream == null) {
                throw new SchemaTypeLoaderException("Could not write compiled schema resource " + str2, SchemaTypeSystemImpl.this._name, str, 12);
            }
            this._output = new DataOutputStream(saverStream);
            this._handle = str;
            writeInt(-629491010);
            writeShort(2);
            writeShort(24);
            writeShort(0);
            writeShort(i);
            this._stringPool.writeTo(this._output);
        }

        void readEnd() {
            try {
                DataInputStream dataInputStream = this._input;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
            } catch (IOException unused) {
            }
            this._input = null;
            this._stringPool = null;
            this._handle = null;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeEnd() throws SchemaTypeLoaderException {
            try {
                DataOutputStream dataOutputStream = this._output;
                if (dataOutputStream != null) {
                    dataOutputStream.flush();
                    this._output.close();
                }
                this._output = null;
                this._stringPool = null;
                this._handle = null;
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        int fileTypeFromComponentType(int i) {
            if (i == 0) {
                return 2;
            }
            if (i == 1) {
                return 3;
            }
            if (i == 3) {
                return 4;
            }
            if (i == 4) {
                return 7;
            }
            if (i == 5) {
                return 8;
            }
            if (i == 6) {
                return 6;
            }
            throw new IllegalStateException("Unexpected component type");
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeIndexData() throws SchemaTypeLoaderException {
            writeHandlePool(SchemaTypeSystemImpl.this._localHandles);
            writeQNameMap(SchemaTypeSystemImpl.this.globalElements());
            writeQNameMap(SchemaTypeSystemImpl.this.globalAttributes());
            writeQNameMap(SchemaTypeSystemImpl.this.modelGroups());
            writeQNameMap(SchemaTypeSystemImpl.this.attributeGroups());
            writeQNameMap(SchemaTypeSystemImpl.this.identityConstraints());
            writeQNameMap(SchemaTypeSystemImpl.this.globalTypes());
            writeDocumentTypeMap(SchemaTypeSystemImpl.this.documentTypes());
            writeAttributeTypeMap(SchemaTypeSystemImpl.this.attributeTypes());
            writeClassnameMap(SchemaTypeSystemImpl.this._typeRefsByClassname);
            writeNamespaces(SchemaTypeSystemImpl.this._namespaces);
            writeQNameMap(SchemaTypeSystemImpl.this.redefinedGlobalTypes());
            writeQNameMap(SchemaTypeSystemImpl.this.redefinedModelGroups());
            writeQNameMap(SchemaTypeSystemImpl.this.redefinedAttributeGroups());
            writeAnnotations(SchemaTypeSystemImpl.this.annotations());
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeHandlePool(HandlePool handlePool) throws SchemaTypeLoaderException {
            writeShort(handlePool._componentsToHandles.size());
            for (SchemaComponent schemaComponent : handlePool._componentsToHandles.keySet()) {
                String str = (String) handlePool._componentsToHandles.get(schemaComponent);
                int iFileTypeFromComponentType = fileTypeFromComponentType(schemaComponent.getComponentType());
                writeString(str);
                writeShort(iFileTypeFromComponentType);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void readHandlePool(HandlePool handlePool) throws SchemaTypeLoaderException {
            SchemaIdentityConstraint.Ref ref;
            if (handlePool._handlesToRefs.size() != 0 || handlePool._started) {
                throw new IllegalStateException("Nonempty handle set before read");
            }
            int i = readShort();
            for (int i2 = 0; i2 < i; i2++) {
                String string = readString();
                int i3 = readShort();
                if (i3 == 2) {
                    ref = new SchemaType.Ref(SchemaTypeSystemImpl.this.getTypeSystem(), string);
                } else if (i3 == 3) {
                    ref = new SchemaGlobalElement.Ref(SchemaTypeSystemImpl.this.getTypeSystem(), string);
                } else if (i3 == 4) {
                    ref = new SchemaGlobalAttribute.Ref(SchemaTypeSystemImpl.this.getTypeSystem(), string);
                } else if (i3 == 6) {
                    ref = new SchemaModelGroup.Ref(SchemaTypeSystemImpl.this.getTypeSystem(), string);
                } else if (i3 == 7) {
                    ref = new SchemaAttributeGroup.Ref(SchemaTypeSystemImpl.this.getTypeSystem(), string);
                } else if (i3 == 8) {
                    ref = new SchemaIdentityConstraint.Ref(SchemaTypeSystemImpl.this.getTypeSystem(), string);
                } else {
                    throw new SchemaTypeLoaderException("Schema index has an unrecognized entry of type " + i3, SchemaTypeSystemImpl.this._name, string, 5);
                }
                handlePool._handlesToRefs.put(string, ref);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        int readShort() throws SchemaTypeLoaderException {
            try {
                return this._input.readUnsignedShort();
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeShort(int i) throws SchemaTypeLoaderException {
            if (i >= SchemaTypeSystemImpl.MAX_UNSIGNED_SHORT || i < -1) {
                throw new SchemaTypeLoaderException("Value " + i + " out of range: must fit in a 16-bit unsigned short.", SchemaTypeSystemImpl.this._name, this._handle, 10);
            }
            DataOutputStream dataOutputStream = this._output;
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.writeShort(i);
                } catch (IOException e) {
                    throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
                }
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        int readInt() throws SchemaTypeLoaderException {
            try {
                return this._input.readInt();
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeInt(int i) throws SchemaTypeLoaderException {
            DataOutputStream dataOutputStream = this._output;
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.writeInt(i);
                } catch (IOException e) {
                    throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
                }
            }
        }

        String readString() {
            return this._stringPool.stringForCode(readShort());
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeString(String str) throws SchemaTypeLoaderException {
            writeShort(this._stringPool.codeForString(str));
        }

        QName readQName() {
            String string = readString();
            String string2 = readString();
            if (string2 == null) {
                return null;
            }
            return new QName(string, string2);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeQName(QName qName) throws SchemaTypeLoaderException {
            if (qName == null) {
                writeString(null);
                writeString(null);
            } else {
                writeString(qName.getNamespaceURI());
                writeString(qName.getLocalPart());
            }
        }

        SOAPArrayType readSOAPArrayType() {
            QName qName = readQName();
            String string = readString();
            if (qName == null) {
                return null;
            }
            return new SOAPArrayType(qName, string);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeSOAPArrayType(SOAPArrayType sOAPArrayType) throws SchemaTypeLoaderException {
            if (sOAPArrayType == null) {
                writeQName(null);
                writeString(null);
            } else {
                writeQName(sOAPArrayType.getQName());
                writeString(sOAPArrayType.soap11DimensionString());
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeAnnotation(SchemaAnnotation schemaAnnotation) throws SchemaTypeLoaderException {
            if (schemaAnnotation == null) {
                writeInt(-1);
                return;
            }
            SchemaAnnotation.Attribute[] attributes = schemaAnnotation.getAttributes();
            writeInt(attributes.length);
            for (int i = 0; i < attributes.length; i++) {
                QName name = attributes[i].getName();
                String value = attributes[i].getValue();
                String valueUri = attributes[i].getValueUri();
                writeQName(name);
                writeString(value);
                writeString(valueUri);
            }
            XmlObject[] userInformation = schemaAnnotation.getUserInformation();
            writeInt(userInformation.length);
            XmlOptions saveAggressiveNamespaces = new XmlOptions().setSaveOuter().setSaveAggressiveNamespaces();
            for (XmlObject xmlObject : userInformation) {
                writeString(xmlObject.xmlText(saveAggressiveNamespaces));
            }
            XmlObject[] applicationInformation = schemaAnnotation.getApplicationInformation();
            writeInt(applicationInformation.length);
            for (XmlObject xmlObject2 : applicationInformation) {
                writeString(xmlObject2.xmlText(saveAggressiveNamespaces));
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        SchemaAnnotation readAnnotation(SchemaContainer schemaContainer) throws SchemaTypeLoaderException {
            int i;
            if (!atLeast(2, 19, 0) || (i = readInt()) == -1) {
                return null;
            }
            SchemaAnnotation.Attribute[] attributeArr = new SchemaAnnotation.Attribute[i];
            for (int i2 = 0; i2 < i; i2++) {
                attributeArr[i2] = new SchemaAnnotationImpl.AttributeImpl(readQName(), readString(), atLeast(2, 24, 0) ? readString() : null);
            }
            int i3 = readInt();
            String[] strArr = new String[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                strArr[i4] = readString();
            }
            int i5 = readInt();
            String[] strArr2 = new String[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                strArr2[i6] = readString();
            }
            return new SchemaAnnotationImpl(schemaContainer, strArr2, strArr, attributeArr);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeAnnotations(SchemaAnnotation[] schemaAnnotationArr) throws SchemaTypeLoaderException {
            writeInt(schemaAnnotationArr.length);
            for (SchemaAnnotation schemaAnnotation : schemaAnnotationArr) {
                writeAnnotation(schemaAnnotation);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        List readAnnotations() throws SchemaTypeLoaderException {
            int i = readInt();
            ArrayList arrayList = new ArrayList(i);
            SchemaContainer containerNonNull = SchemaTypeSystemImpl.this.getContainerNonNull("");
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(readAnnotation(containerNonNull));
            }
            return arrayList;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        SchemaComponent.Ref readHandle() throws SchemaTypeLoaderException {
            String string = readString();
            if (string == null) {
                return null;
            }
            if (string.charAt(0) != '_') {
                return SchemaTypeSystemImpl.this._localHandles.refForHandle(string);
            }
            char cCharAt = string.charAt(2);
            if (cCharAt == 'A') {
                return SchemaTypeSystemImpl.this._linker.findAttributeRef(QNameHelper.forPretty(string, 4));
            }
            if (cCharAt == 'I') {
                SchemaType schemaTypeResolveHandle = BuiltinSchemaTypeSystem.get().resolveHandle(string);
                if (schemaTypeResolveHandle != null) {
                    return schemaTypeResolveHandle.getRef();
                }
                return XQuerySchemaTypeSystem.get().resolveHandle(string).getRef();
            }
            if (cCharAt == 'Y') {
                SchemaType schemaTypeTypeForSignature = SchemaTypeSystemImpl.this._linker.typeForSignature(string.substring(4));
                if (schemaTypeTypeForSignature == null) {
                    throw new SchemaTypeLoaderException("Cannot resolve type for handle " + string, SchemaTypeSystemImpl.this._name, this._handle, 13);
                }
                return schemaTypeTypeForSignature.getRef();
            }
            if (cCharAt == 'D') {
                return SchemaTypeSystemImpl.this._linker.findIdentityConstraintRef(QNameHelper.forPretty(string, 4));
            }
            if (cCharAt == 'E') {
                return SchemaTypeSystemImpl.this._linker.findElementRef(QNameHelper.forPretty(string, 4));
            }
            switch (cCharAt) {
                case 'M':
                    return SchemaTypeSystemImpl.this._linker.findModelGroupRef(QNameHelper.forPretty(string, 4));
                case 'N':
                    return SchemaTypeSystemImpl.this._linker.findAttributeGroupRef(QNameHelper.forPretty(string, 4));
                case 'O':
                    return SchemaTypeSystemImpl.this._linker.findDocumentTypeRef(QNameHelper.forPretty(string, 4));
                default:
                    switch (cCharAt) {
                        case 'R':
                            SchemaGlobalAttribute schemaGlobalAttributeFindAttribute = SchemaTypeSystemImpl.this._linker.findAttribute(QNameHelper.forPretty(string, 4));
                            if (schemaGlobalAttributeFindAttribute == null) {
                                throw new SchemaTypeLoaderException("Cannot resolve attribute for handle " + string, SchemaTypeSystemImpl.this._name, this._handle, 13);
                            }
                            return schemaGlobalAttributeFindAttribute.getType().getRef();
                        case 'S':
                            SchemaGlobalElement schemaGlobalElementFindElement = SchemaTypeSystemImpl.this._linker.findElement(QNameHelper.forPretty(string, 4));
                            if (schemaGlobalElementFindElement == null) {
                                throw new SchemaTypeLoaderException("Cannot resolve element for handle " + string, SchemaTypeSystemImpl.this._name, this._handle, 13);
                            }
                            return schemaGlobalElementFindElement.getType().getRef();
                        case 'T':
                            return SchemaTypeSystemImpl.this._linker.findTypeRef(QNameHelper.forPretty(string, 4));
                        default:
                            throw new SchemaTypeLoaderException("Cannot resolve handle " + string, SchemaTypeSystemImpl.this._name, this._handle, 13);
                    }
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeHandle(SchemaComponent schemaComponent) throws SchemaTypeLoaderException {
            if (schemaComponent == null || schemaComponent.getTypeSystem() == SchemaTypeSystemImpl.this.getTypeSystem()) {
                writeString(SchemaTypeSystemImpl.this._localHandles.handleForComponent(schemaComponent));
                return;
            }
            int componentType = schemaComponent.getComponentType();
            if (componentType == 0) {
                SchemaType schemaType = (SchemaType) schemaComponent;
                if (schemaType.isBuiltinType()) {
                    writeString("_BI_" + schemaType.getName().getLocalPart());
                    return;
                }
                if (schemaType.getName() != null) {
                    writeString("_XT_" + QNameHelper.pretty(schemaType.getName()));
                    return;
                } else if (schemaType.isDocumentType()) {
                    writeString("_XO_" + QNameHelper.pretty(schemaType.getDocumentElementName()));
                    return;
                } else {
                    writeString("_XY_" + schemaType.toString());
                    return;
                }
            }
            if (componentType == 1) {
                writeString("_XE_" + QNameHelper.pretty(schemaComponent.getName()));
                return;
            }
            if (componentType == 3) {
                writeString("_XA_" + QNameHelper.pretty(schemaComponent.getName()));
                return;
            }
            if (componentType == 4) {
                writeString("_XN_" + QNameHelper.pretty(schemaComponent.getName()));
            } else if (componentType == 5) {
                writeString("_XD_" + QNameHelper.pretty(schemaComponent.getName()));
            } else {
                if (componentType == 6) {
                    writeString("_XM_" + QNameHelper.pretty(schemaComponent.getName()));
                    return;
                }
                throw new SchemaTypeLoaderException("Cannot write handle for component " + schemaComponent, SchemaTypeSystemImpl.this._name, this._handle, 13);
            }
        }

        SchemaType.Ref readTypeRef() {
            return readHandle();
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeType(SchemaType schemaType) throws SchemaTypeLoaderException {
            writeHandle(schemaType);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        Map readQNameRefMap() throws SchemaTypeLoaderException {
            HashMap map = new HashMap();
            int i = readShort();
            for (int i2 = 0; i2 < i; i2++) {
                map.put(readQName(), readHandle());
            }
            return map;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        List readQNameRefMapAsList(List list) throws SchemaTypeLoaderException {
            int i = readShort();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                QName qName = readQName();
                arrayList.add(readHandle());
                list.add(qName);
            }
            return arrayList;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeQNameMap(SchemaComponent[] schemaComponentArr) throws SchemaTypeLoaderException {
            writeShort(schemaComponentArr.length);
            for (int i = 0; i < schemaComponentArr.length; i++) {
                writeQName(schemaComponentArr[i].getName());
                writeHandle(schemaComponentArr[i]);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeDocumentTypeMap(SchemaType[] schemaTypeArr) throws SchemaTypeLoaderException {
            writeShort(schemaTypeArr.length);
            for (int i = 0; i < schemaTypeArr.length; i++) {
                writeQName(schemaTypeArr[i].getDocumentElementName());
                writeHandle(schemaTypeArr[i]);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeAttributeTypeMap(SchemaType[] schemaTypeArr) throws SchemaTypeLoaderException {
            writeShort(schemaTypeArr.length);
            for (int i = 0; i < schemaTypeArr.length; i++) {
                writeQName(schemaTypeArr[i].getAttributeTypeAttributeName());
                writeHandle(schemaTypeArr[i]);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        SchemaType.Ref[] readTypeRefArray() throws SchemaTypeLoaderException {
            int i = readShort();
            SchemaType.Ref[] refArr = new SchemaType.Ref[i];
            for (int i2 = 0; i2 < i; i2++) {
                refArr[i2] = readTypeRef();
            }
            return refArr;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeTypeArray(SchemaType[] schemaTypeArr) throws SchemaTypeLoaderException {
            writeShort(schemaTypeArr.length);
            for (SchemaType schemaType : schemaTypeArr) {
                writeHandle(schemaType);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        Map readClassnameRefMap() throws SchemaTypeLoaderException {
            HashMap map = new HashMap();
            int i = readShort();
            for (int i2 = 0; i2 < i; i2++) {
                map.put(readString(), readHandle());
            }
            return map;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeClassnameMap(Map map) throws SchemaTypeLoaderException {
            writeShort(map.size());
            for (String str : map.keySet()) {
                writeString(str);
                writeHandle(((SchemaType.Ref) map.get(str)).get());
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        Set readNamespaces() throws SchemaTypeLoaderException {
            HashSet hashSet = new HashSet();
            int i = readShort();
            for (int i2 = 0; i2 < i; i2++) {
                hashSet.add(readString());
            }
            return hashSet;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeNamespaces(Set set) throws SchemaTypeLoaderException {
            writeShort(set.size());
            Iterator it = set.iterator();
            while (it.hasNext()) {
                writeString((String) it.next());
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        OutputStream getSaverStream(String str) throws SchemaTypeLoaderException {
            try {
                return SchemaTypeSystemImpl.this._filer.createBinaryFile(str);
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        InputStream getLoaderStream(String str) {
            return SchemaTypeSystemImpl.this._resourceLoader.getResourceAsStream(str);
        }

        void checkContainerNotNull(SchemaContainer schemaContainer, QName qName) {
            if (schemaContainer == null) {
                throw new LinkageError("Loading of resource " + SchemaTypeSystemImpl.this._name + NameUtil.PERIOD + this._handle + "failed, information from " + SchemaTypeSystemImpl.this._name + ".index.xsb is  out of sync (or conflicting index files found)");
            }
        }

        public SchemaGlobalElement finishLoadingElement() {
            try {
                try {
                    int i = readShort();
                    if (i != 4) {
                        throw new SchemaTypeLoaderException("Wrong particle type ", SchemaTypeSystemImpl.this._name, this._handle, 11);
                    }
                    int i2 = readShort();
                    BigInteger bigInteger = readBigInteger();
                    BigInteger bigInteger2 = readBigInteger();
                    QNameSet qNameSet = readQNameSet();
                    QName qName = readQName();
                    SchemaContainer container = SchemaTypeSystemImpl.this.getContainer(qName.getNamespaceURI());
                    checkContainerNotNull(container, qName);
                    SchemaGlobalElementImpl schemaGlobalElementImpl = new SchemaGlobalElementImpl(container);
                    schemaGlobalElementImpl.setParticleType(i);
                    schemaGlobalElementImpl.setMinOccurs(bigInteger);
                    schemaGlobalElementImpl.setMaxOccurs(bigInteger2);
                    boolean z = true;
                    schemaGlobalElementImpl.setTransitionRules(qNameSet, (i2 & 1) != 0);
                    schemaGlobalElementImpl.setNameAndTypeRef(qName, readTypeRef());
                    schemaGlobalElementImpl.setDefault(readString(), (i2 & 4) != 0, null);
                    if (atLeast(2, 16, 0)) {
                        schemaGlobalElementImpl.setDefaultValue(readXmlValueObject());
                    }
                    schemaGlobalElementImpl.setNillable((i2 & 8) != 0);
                    schemaGlobalElementImpl.setBlock((i2 & 16) != 0, (i2 & 32) != 0, (i2 & 64) != 0);
                    schemaGlobalElementImpl.setWsdlArrayType(readSOAPArrayType());
                    schemaGlobalElementImpl.setAbstract((i2 & 128) != 0);
                    schemaGlobalElementImpl.setAnnotation(readAnnotation(container));
                    boolean z2 = (i2 & 256) != 0;
                    if ((i2 & 512) == 0) {
                        z = false;
                    }
                    schemaGlobalElementImpl.setFinal(z2, z);
                    if (atLeast(2, 17, 0)) {
                        schemaGlobalElementImpl.setSubstitutionGroup((SchemaGlobalElement.Ref) readHandle());
                    }
                    int i3 = readShort();
                    for (int i4 = 0; i4 < i3; i4++) {
                        schemaGlobalElementImpl.addSubstitutionGroupMember(readQName());
                    }
                    int i5 = readShort();
                    SchemaIdentityConstraint.Ref[] refArr = new SchemaIdentityConstraint.Ref[i5];
                    for (int i6 = 0; i6 < i5; i6++) {
                        refArr[i6] = (SchemaIdentityConstraint.Ref) readHandle();
                    }
                    schemaGlobalElementImpl.setIdentityConstraints(refArr);
                    schemaGlobalElementImpl.setFilename(readString());
                    readEnd();
                    return schemaGlobalElementImpl;
                } catch (SchemaTypeLoaderException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new SchemaTypeLoaderException("Cannot load type from typesystem", SchemaTypeSystemImpl.this._name, (String) null, 14, e2);
                }
            } catch (Throwable th) {
                readEnd();
                throw th;
            }
        }

        public SchemaGlobalAttribute finishLoadingAttribute() {
            try {
                try {
                    QName qName = readQName();
                    SchemaContainer container = SchemaTypeSystemImpl.this.getContainer(qName.getNamespaceURI());
                    checkContainerNotNull(container, qName);
                    SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = new SchemaGlobalAttributeImpl(container);
                    loadAttribute(schemaGlobalAttributeImpl, qName, container);
                    schemaGlobalAttributeImpl.setFilename(readString());
                    readEnd();
                    return schemaGlobalAttributeImpl;
                } catch (SchemaTypeLoaderException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new SchemaTypeLoaderException("Cannot load type from typesystem", SchemaTypeSystemImpl.this._name, this._handle, 14, e2);
                }
            } catch (Throwable th) {
                readEnd();
                throw th;
            }
        }

        SchemaModelGroup finishLoadingModelGroup() {
            QName qName = readQName();
            SchemaContainer container = SchemaTypeSystemImpl.this.getContainer(qName.getNamespaceURI());
            checkContainerNotNull(container, qName);
            SchemaModelGroupImpl schemaModelGroupImpl = new SchemaModelGroupImpl(container);
            try {
                try {
                    schemaModelGroupImpl.init(qName, readString(), readShort() == 1, atLeast(2, 22, 0) ? readString() : null, atLeast(2, 22, 0) ? readString() : null, atLeast(2, 15, 0) && readShort() == 1, GroupDocument.Factory.parse(readString()).getGroup(), readAnnotation(container), null);
                    if (atLeast(2, 21, 0)) {
                        schemaModelGroupImpl.setFilename(readString());
                    }
                    readEnd();
                    return schemaModelGroupImpl;
                } catch (SchemaTypeLoaderException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new SchemaTypeLoaderException("Cannot load type from typesystem", SchemaTypeSystemImpl.this._name, this._handle, 14, e2);
                }
            } catch (Throwable th) {
                readEnd();
                throw th;
            }
        }

        SchemaIdentityConstraint finishLoadingIdentityConstraint() {
            try {
                try {
                    QName qName = readQName();
                    SchemaContainer container = SchemaTypeSystemImpl.this.getContainer(qName.getNamespaceURI());
                    checkContainerNotNull(container, qName);
                    SchemaIdentityConstraintImpl schemaIdentityConstraintImpl = new SchemaIdentityConstraintImpl(container);
                    schemaIdentityConstraintImpl.setName(qName);
                    schemaIdentityConstraintImpl.setConstraintCategory(readShort());
                    schemaIdentityConstraintImpl.setSelector(readString());
                    schemaIdentityConstraintImpl.setAnnotation(readAnnotation(container));
                    int i = readShort();
                    String[] strArr = new String[i];
                    for (int i2 = 0; i2 < i; i2++) {
                        strArr[i2] = readString();
                    }
                    schemaIdentityConstraintImpl.setFields(strArr);
                    if (schemaIdentityConstraintImpl.getConstraintCategory() == 2) {
                        schemaIdentityConstraintImpl.setReferencedKey((SchemaIdentityConstraint.Ref) readHandle());
                    }
                    int i3 = readShort();
                    HashMap map = new HashMap();
                    for (int i4 = 0; i4 < i3; i4++) {
                        map.put(readString(), readString());
                    }
                    schemaIdentityConstraintImpl.setNSMap(map);
                    if (atLeast(2, 21, 0)) {
                        schemaIdentityConstraintImpl.setFilename(readString());
                    }
                    readEnd();
                    return schemaIdentityConstraintImpl;
                } catch (SchemaTypeLoaderException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new SchemaTypeLoaderException("Cannot load type from typesystem", SchemaTypeSystemImpl.this._name, this._handle, 14, e2);
                }
            } catch (Throwable th) {
                readEnd();
                throw th;
            }
        }

        SchemaAttributeGroup finishLoadingAttributeGroup() {
            QName qName = readQName();
            SchemaContainer container = SchemaTypeSystemImpl.this.getContainer(qName.getNamespaceURI());
            checkContainerNotNull(container, qName);
            SchemaAttributeGroupImpl schemaAttributeGroupImpl = new SchemaAttributeGroupImpl(container);
            try {
                try {
                    try {
                        schemaAttributeGroupImpl.init(qName, readString(), readShort() == 1, atLeast(2, 22, 0) ? readString() : null, atLeast(2, 15, 0) && readShort() == 1, AttributeGroupDocument.Factory.parse(readString()).getAttributeGroup(), readAnnotation(container), null);
                        if (atLeast(2, 21, 0)) {
                            schemaAttributeGroupImpl.setFilename(readString());
                        }
                        readEnd();
                        return schemaAttributeGroupImpl;
                    } catch (Exception e) {
                        throw new SchemaTypeLoaderException("Cannot load type from typesystem", SchemaTypeSystemImpl.this._name, this._handle, 14, e);
                    }
                } catch (SchemaTypeLoaderException e2) {
                    throw e2;
                }
            } catch (Throwable th) {
                readEnd();
                throw th;
            }
        }

        public SchemaType finishLoadingType() {
            int i;
            QName attributeTypeAttributeName;
            int i2;
            SchemaParticle schemaParticle;
            LinkedHashMap linkedHashMap;
            SchemaParticle schemaParticle2;
            int i3;
            String str = "";
            try {
                try {
                    try {
                        int i4 = 1;
                        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(SchemaTypeSystemImpl.this.getContainerNonNull(""), true);
                        schemaTypeImpl.setName(readQName());
                        schemaTypeImpl.setOuterSchemaTypeRef(readTypeRef());
                        schemaTypeImpl.setBaseDepth(readShort());
                        schemaTypeImpl.setBaseTypeRef(readTypeRef());
                        schemaTypeImpl.setDerivationType(readShort());
                        schemaTypeImpl.setAnnotation(readAnnotation(null));
                        int i5 = readShort();
                        if (i5 == 1) {
                            schemaTypeImpl.setContainerFieldRef(readHandle());
                        } else if (i5 == 2) {
                            schemaTypeImpl.setContainerFieldIndex((short) 1, readShort());
                        } else if (i5 == 3) {
                            schemaTypeImpl.setContainerFieldIndex((short) 2, readShort());
                        }
                        String string = readString();
                        if (string == null) {
                            string = "";
                        }
                        schemaTypeImpl.setFullJavaName(string);
                        String string2 = readString();
                        if (string2 != null) {
                            str = string2;
                        }
                        schemaTypeImpl.setFullJavaImplName(str);
                        schemaTypeImpl.setAnonymousTypeRefs(readTypeRefArray());
                        schemaTypeImpl.setAnonymousUnionMemberOrdinal(readShort());
                        int i6 = readInt();
                        boolean z = (i6 & 1) == 0;
                        schemaTypeImpl.setCompiled((i6 & 2048) != 0);
                        schemaTypeImpl.setDocumentType((i6 & 2) != 0);
                        schemaTypeImpl.setAttributeType((SchemaTypeSystemImpl.FLAG_ATTRIBUTE_TYPE & i6) != 0);
                        schemaTypeImpl.setSimpleType(!z);
                        if (z) {
                            schemaTypeImpl.setAbstractFinal((SchemaTypeSystemImpl.FLAG_ABSTRACT & i6) != 0, (i6 & SchemaTypeSystemImpl.FLAG_FINAL_EXT) != 0, (i6 & SchemaTypeSystemImpl.FLAG_FINAL_REST) != 0, (i6 & SchemaTypeSystemImpl.FLAG_FINAL_LIST) != 0, (i6 & SchemaTypeSystemImpl.FLAG_FINAL_UNION) != 0);
                            schemaTypeImpl.setBlock((i6 & 4096) != 0, (i6 & 8192) != 0);
                            schemaTypeImpl.setOrderSensitive((i6 & 512) != 0);
                            int i7 = readShort();
                            schemaTypeImpl.setComplexTypeVariety(i7);
                            if (atLeast(2, 23, 0)) {
                                schemaTypeImpl.setContentBasedOnTypeRef(readTypeRef());
                            }
                            SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
                            int i8 = readShort();
                            for (int i9 = 0; i9 < i8; i9++) {
                                schemaAttributeModelImpl.addAttribute(readAttributeData());
                            }
                            schemaAttributeModelImpl.setWildcardSet(readQNameSet());
                            schemaAttributeModelImpl.setWildcardProcess(readShort());
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                            int i10 = readShort();
                            for (int i11 = 0; i11 < i10; i11++) {
                                SchemaProperty propertyData = readPropertyData();
                                if (!propertyData.isAttribute()) {
                                    throw new SchemaTypeLoaderException("Attribute property " + i11 + " is not an attribute", SchemaTypeSystemImpl.this._name, this._handle, 6);
                                }
                                linkedHashMap2.put(propertyData.getName(), propertyData);
                            }
                            if (i7 == 3 || i7 == 4) {
                                i2 = readShort();
                                SchemaParticle[] particleArray = readParticleArray();
                                if (particleArray.length == 1) {
                                    schemaParticle = particleArray[0];
                                } else {
                                    if (particleArray.length != 0) {
                                        throw new SchemaTypeLoaderException("Content model not well-formed", SchemaTypeSystemImpl.this._name, this._handle, 7);
                                    }
                                    schemaParticle = null;
                                }
                                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                                int i12 = readShort();
                                int i13 = 0;
                                while (i13 < i12) {
                                    SchemaProperty propertyData2 = readPropertyData();
                                    if (propertyData2.isAttribute()) {
                                        throw new SchemaTypeLoaderException("Element property " + i13 + " is not an element", SchemaTypeSystemImpl.this._name, this._handle, 6);
                                    }
                                    linkedHashMap3.put(propertyData2.getName(), propertyData2);
                                    i13++;
                                    i4 = 1;
                                }
                                linkedHashMap = linkedHashMap3;
                                int i14 = i4;
                                schemaParticle2 = schemaParticle;
                                i3 = i14;
                            } else {
                                i3 = 1;
                                i2 = 0;
                                schemaParticle2 = null;
                                linkedHashMap = null;
                            }
                            schemaTypeImpl.setContentModel(schemaParticle2, schemaAttributeModelImpl, linkedHashMap, linkedHashMap2, i2 == i3 ? true : SchemaTypeSystemImpl.$assertionsDisabled);
                            StscComplexTypeResolver.WildcardResult wildcardResultSummarizeEltWildcards = StscComplexTypeResolver.summarizeEltWildcards(schemaParticle2);
                            StscComplexTypeResolver.WildcardResult wildcardResultSummarizeAttrWildcards = StscComplexTypeResolver.summarizeAttrWildcards(schemaAttributeModelImpl);
                            schemaTypeImpl.setWildcardSummary(wildcardResultSummarizeEltWildcards.typedWildcards, wildcardResultSummarizeEltWildcards.hasWildcards, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
                            i = i7;
                        } else {
                            i = 0;
                        }
                        if (!z || i == 2) {
                            int i15 = readShort();
                            schemaTypeImpl.setSimpleTypeVariety(i15);
                            boolean z2 = (i6 & 64) != 0 ? true : SchemaTypeSystemImpl.$assertionsDisabled;
                            schemaTypeImpl.setOrdered((i6 & 4) != 0 ? 0 : (i6 & 1024) != 0 ? 2 : 1);
                            schemaTypeImpl.setBounded((i6 & 8) != 0 ? true : SchemaTypeSystemImpl.$assertionsDisabled);
                            schemaTypeImpl.setFinite((i6 & 16) != 0 ? true : SchemaTypeSystemImpl.$assertionsDisabled);
                            schemaTypeImpl.setNumeric((i6 & 32) != 0 ? true : SchemaTypeSystemImpl.$assertionsDisabled);
                            schemaTypeImpl.setUnionOfLists((i6 & 128) != 0 ? true : SchemaTypeSystemImpl.$assertionsDisabled);
                            schemaTypeImpl.setSimpleFinal((i6 & SchemaTypeSystemImpl.FLAG_FINAL_REST) != 0 ? true : SchemaTypeSystemImpl.$assertionsDisabled, (i6 & SchemaTypeSystemImpl.FLAG_FINAL_LIST) != 0 ? true : SchemaTypeSystemImpl.$assertionsDisabled, (i6 & SchemaTypeSystemImpl.FLAG_FINAL_UNION) != 0 ? true : SchemaTypeSystemImpl.$assertionsDisabled);
                            XmlValueRef[] xmlValueRefArr = new XmlValueRef[12];
                            boolean[] zArr = new boolean[12];
                            int i16 = readShort();
                            for (int i17 = 0; i17 < i16; i17++) {
                                int i18 = readShort();
                                xmlValueRefArr[i18] = readXmlValueObject();
                                zArr[i18] = readShort() == 1 ? true : SchemaTypeSystemImpl.$assertionsDisabled;
                            }
                            schemaTypeImpl.setBasicFacets(xmlValueRefArr, zArr);
                            schemaTypeImpl.setWhiteSpaceRule(readShort());
                            schemaTypeImpl.setPatternFacet((i6 & 256) != 0 ? true : SchemaTypeSystemImpl.$assertionsDisabled);
                            int i19 = readShort();
                            RegularExpression[] regularExpressionArr = new RegularExpression[i19];
                            for (int i20 = 0; i20 < i19; i20++) {
                                regularExpressionArr[i20] = new RegularExpression(readString(), "X");
                            }
                            schemaTypeImpl.setPatterns(regularExpressionArr);
                            int i21 = readShort();
                            XmlValueRef[] xmlValueRefArr2 = new XmlValueRef[i21];
                            for (int i22 = 0; i22 < i21; i22++) {
                                xmlValueRefArr2[i22] = readXmlValueObject();
                            }
                            if (i21 == 0) {
                                xmlValueRefArr2 = null;
                            }
                            schemaTypeImpl.setEnumerationValues(xmlValueRefArr2);
                            schemaTypeImpl.setBaseEnumTypeRef(readTypeRef());
                            if (z2) {
                                int i23 = readShort();
                                SchemaStringEnumEntry[] schemaStringEnumEntryArr = new SchemaStringEnumEntry[i23];
                                for (int i24 = 0; i24 < i23; i24++) {
                                    schemaStringEnumEntryArr[i24] = new SchemaStringEnumEntryImpl(readString(), readShort(), readString());
                                }
                                schemaTypeImpl.setStringEnumEntries(schemaStringEnumEntryArr);
                            }
                            if (i15 == 1) {
                                schemaTypeImpl.setPrimitiveTypeRef(readTypeRef());
                                schemaTypeImpl.setDecimalSize(readInt());
                            } else if (i15 == 2) {
                                schemaTypeImpl.setPrimitiveTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
                                schemaTypeImpl.setUnionMemberTypeRefs(readTypeRefArray());
                            } else if (i15 == 3) {
                                schemaTypeImpl.setPrimitiveTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
                                schemaTypeImpl.setListItemTypeRef(readTypeRef());
                            } else {
                                throw new SchemaTypeLoaderException("Simple type does not have a recognized variety", SchemaTypeSystemImpl.this._name, this._handle, 8);
                            }
                        }
                        schemaTypeImpl.setFilename(readString());
                        if (schemaTypeImpl.getName() != null) {
                            SchemaContainer container = SchemaTypeSystemImpl.this.getContainer(schemaTypeImpl.getName().getNamespaceURI());
                            checkContainerNotNull(container, schemaTypeImpl.getName());
                            schemaTypeImpl.setContainer(container);
                        } else if (schemaTypeImpl.isDocumentType()) {
                            QName documentElementName = schemaTypeImpl.getDocumentElementName();
                            if (documentElementName != null) {
                                SchemaContainer container2 = SchemaTypeSystemImpl.this.getContainer(documentElementName.getNamespaceURI());
                                checkContainerNotNull(container2, documentElementName);
                                schemaTypeImpl.setContainer(container2);
                            }
                        } else if (schemaTypeImpl.isAttributeType() && (attributeTypeAttributeName = schemaTypeImpl.getAttributeTypeAttributeName()) != null) {
                            SchemaContainer container3 = SchemaTypeSystemImpl.this.getContainer(attributeTypeAttributeName.getNamespaceURI());
                            checkContainerNotNull(container3, attributeTypeAttributeName);
                            schemaTypeImpl.setContainer(container3);
                        }
                        readEnd();
                        return schemaTypeImpl;
                    } catch (Exception e) {
                        throw new SchemaTypeLoaderException("Cannot load type from typesystem", SchemaTypeSystemImpl.this._name, this._handle, 14, e);
                    }
                } catch (SchemaTypeLoaderException e2) {
                    throw e2;
                }
            } catch (Throwable th) {
                readEnd();
                throw th;
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v119 */
        /* JADX WARN: Type inference failed for: r1v120 */
        /* JADX WARN: Type inference failed for: r1v121 */
        /* JADX WARN: Type inference failed for: r1v122 */
        /* JADX WARN: Type inference failed for: r1v123 */
        /* JADX WARN: Type inference failed for: r1v124 */
        /* JADX WARN: Type inference failed for: r1v125 */
        /* JADX WARN: Type inference failed for: r1v126 */
        /* JADX WARN: Type inference failed for: r1v127 */
        /* JADX WARN: Type inference failed for: r1v128 */
        /* JADX WARN: Type inference failed for: r1v129 */
        /* JADX WARN: Type inference failed for: r1v130 */
        /* JADX WARN: Type inference failed for: r1v131 */
        /* JADX WARN: Type inference failed for: r1v132 */
        /* JADX WARN: Type inference failed for: r1v133 */
        /* JADX WARN: Type inference failed for: r1v134 */
        /* JADX WARN: Type inference failed for: r1v135 */
        /* JADX WARN: Type inference failed for: r1v136 */
        /* JADX WARN: Type inference failed for: r1v137 */
        /* JADX WARN: Type inference failed for: r1v138 */
        /* JADX WARN: Type inference failed for: r1v139 */
        /* JADX WARN: Type inference failed for: r1v140 */
        /* JADX WARN: Type inference failed for: r1v141 */
        /* JADX WARN: Type inference failed for: r1v142 */
        /* JADX WARN: Type inference failed for: r1v143 */
        /* JADX WARN: Type inference failed for: r1v144 */
        /* JADX WARN: Type inference failed for: r1v145 */
        /* JADX WARN: Type inference failed for: r1v146 */
        /* JADX WARN: Type inference failed for: r1v147 */
        /* JADX WARN: Type inference failed for: r1v148 */
        /* JADX WARN: Type inference failed for: r1v149 */
        /* JADX WARN: Type inference failed for: r1v150 */
        /* JADX WARN: Type inference failed for: r1v151 */
        /* JADX WARN: Type inference failed for: r1v152 */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r1v26 */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v30 */
        /* JADX WARN: Type inference failed for: r1v31 */
        /* JADX WARN: Type inference failed for: r1v32 */
        /* JADX WARN: Type inference failed for: r1v33 */
        /* JADX WARN: Type inference failed for: r1v34 */
        /* JADX WARN: Type inference failed for: r1v35 */
        /* JADX WARN: Type inference failed for: r1v36 */
        /* JADX WARN: Type inference failed for: r1v37 */
        /* JADX WARN: Type inference failed for: r1v38 */
        /* JADX WARN: Type inference failed for: r1v39 */
        /* JADX WARN: Type inference failed for: r1v40 */
        void writeTypeData(SchemaType schemaType) throws SchemaTypeLoaderException {
            writeQName(schemaType.getName());
            writeType(schemaType.getOuterType());
            SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) schemaType;
            writeShort(schemaTypeImpl.getBaseDepth());
            writeType(schemaType.getBaseType());
            writeShort(schemaType.getDerivationType());
            writeAnnotation(schemaType.getAnnotation());
            if (schemaType.getContainerField() == null) {
                writeShort(0);
            } else if (schemaType.getOuterType().isAttributeType() || schemaType.getOuterType().isDocumentType()) {
                writeShort(1);
                writeHandle(schemaType.getContainerField());
            } else if (schemaType.getContainerField().isAttribute()) {
                writeShort(2);
                writeShort(((SchemaTypeImpl) schemaType.getOuterType()).getIndexForLocalAttribute((SchemaLocalAttribute) schemaType.getContainerField()));
            } else {
                writeShort(3);
                writeShort(((SchemaTypeImpl) schemaType.getOuterType()).getIndexForLocalElement((SchemaLocalElement) schemaType.getContainerField()));
            }
            writeString(schemaType.getFullJavaName());
            writeString(schemaType.getFullJavaImplName());
            writeTypeArray(schemaType.getAnonymousTypes());
            writeShort(schemaType.getAnonymousUnionMemberOrdinal());
            boolean zIsSimpleType = schemaType.isSimpleType();
            ?? r1 = zIsSimpleType;
            if (schemaType.isDocumentType()) {
                r1 = (zIsSimpleType ? 1 : 0) | 2;
            }
            ?? r2 = r1;
            if (schemaType.isAttributeType()) {
                r2 = (r1 == true ? 1 : 0) | SchemaTypeSystemImpl.FLAG_ATTRIBUTE_TYPE;
            }
            ?? r3 = r2;
            if (schemaType.ordered() != 0) {
                r3 = (r2 == true ? 1 : 0) | 4;
            }
            ?? r4 = r3;
            if (schemaType.ordered() == 2) {
                r4 = (r3 == true ? 1 : 0) | 1024;
            }
            ?? r5 = r4;
            if (schemaType.isBounded()) {
                r5 = (r4 == true ? 1 : 0) | 8;
            }
            ?? r6 = r5;
            if (schemaType.isFinite()) {
                r6 = (r5 == true ? 1 : 0) | 16;
            }
            ?? r7 = r6;
            if (schemaType.isNumeric()) {
                r7 = (r6 == true ? 1 : 0) | 32;
            }
            ?? r8 = r7;
            if (schemaType.hasStringEnumValues()) {
                r8 = (r7 == true ? 1 : 0) | 64;
            }
            ?? r9 = r8;
            if (schemaTypeImpl.isUnionOfLists()) {
                r9 = (r8 == true ? 1 : 0) | 128;
            }
            ?? r10 = r9;
            if (schemaType.hasPatternFacet()) {
                r10 = (r9 == true ? 1 : 0) | 256;
            }
            ?? r11 = r10;
            if (schemaType.isOrderSensitive()) {
                r11 = (r10 == true ? 1 : 0) | 512;
            }
            ?? r12 = r11;
            if (schemaType.blockExtension()) {
                r12 = (r11 == true ? 1 : 0) | 4096;
            }
            ?? r13 = r12;
            if (schemaType.blockRestriction()) {
                r13 = (r12 == true ? 1 : 0) | 8192;
            }
            ?? r14 = r13;
            if (schemaType.finalExtension()) {
                r14 = (r13 == true ? 1 : 0) | SchemaTypeSystemImpl.FLAG_FINAL_EXT;
            }
            ?? r15 = r14;
            if (schemaType.finalRestriction()) {
                r15 = (r14 == true ? 1 : 0) | SchemaTypeSystemImpl.FLAG_FINAL_EXT;
            }
            ?? r16 = r15;
            if (schemaType.finalList()) {
                r16 = (r15 == true ? 1 : 0) | SchemaTypeSystemImpl.FLAG_FINAL_LIST;
            }
            ?? r17 = r16;
            if (schemaType.finalUnion()) {
                r17 = (r16 == true ? 1 : 0) | SchemaTypeSystemImpl.FLAG_FINAL_UNION;
            }
            int i = r17;
            if (schemaType.isAbstract()) {
                i = (r17 == true ? 1 : 0) | SchemaTypeSystemImpl.FLAG_ABSTRACT;
            }
            writeInt(i);
            if (!schemaType.isSimpleType()) {
                writeShort(schemaType.getContentType());
                writeType(schemaType.getContentBasedOnType());
                SchemaAttributeModel attributeModel = schemaType.getAttributeModel();
                SchemaLocalAttribute[] attributes = attributeModel.getAttributes();
                writeShort(attributes.length);
                for (SchemaLocalAttribute schemaLocalAttribute : attributes) {
                    writeAttributeData(schemaLocalAttribute);
                }
                writeQNameSet(attributeModel.getWildcardSet());
                writeShort(attributeModel.getWildcardProcess());
                SchemaProperty[] attributeProperties = schemaType.getAttributeProperties();
                writeShort(attributeProperties.length);
                for (SchemaProperty schemaProperty : attributeProperties) {
                    writePropertyData(schemaProperty);
                }
                if (schemaType.getContentType() == 3 || schemaType.getContentType() == 4) {
                    writeShort(schemaType.hasAllContent() ? 1 : 0);
                    writeParticleArray(schemaType.getContentModel() != null ? new SchemaParticle[]{schemaType.getContentModel()} : new SchemaParticle[0]);
                    SchemaProperty[] elementProperties = schemaType.getElementProperties();
                    writeShort(elementProperties.length);
                    for (SchemaProperty schemaProperty2 : elementProperties) {
                        writePropertyData(schemaProperty2);
                    }
                }
            }
            if (schemaType.isSimpleType() || schemaType.getContentType() == 2) {
                writeShort(schemaType.getSimpleVariety());
                int i2 = 0;
                for (int i3 = 0; i3 <= 11; i3++) {
                    if (schemaType.getFacet(i3) != null) {
                        i2++;
                    }
                }
                writeShort(i2);
                for (int i4 = 0; i4 <= 11; i4++) {
                    XmlAnySimpleType facet = schemaType.getFacet(i4);
                    if (facet != null) {
                        writeShort(i4);
                        writeXmlValueObject(facet);
                        writeShort(schemaType.isFacetFixed(i4) ? 1 : 0);
                    }
                }
                writeShort(schemaType.getWhiteSpaceRule());
                RegularExpression[] patternExpressions = schemaTypeImpl.getPatternExpressions();
                writeShort(patternExpressions.length);
                for (RegularExpression regularExpression : patternExpressions) {
                    writeString(regularExpression.getPattern());
                }
                XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
                if (enumerationValues == null) {
                    writeShort(0);
                } else {
                    writeShort(enumerationValues.length);
                    for (XmlAnySimpleType xmlAnySimpleType : enumerationValues) {
                        writeXmlValueObject(xmlAnySimpleType);
                    }
                }
                writeType(schemaType.getBaseEnumType());
                if (schemaType.hasStringEnumValues()) {
                    SchemaStringEnumEntry[] stringEnumEntries = schemaType.getStringEnumEntries();
                    writeShort(stringEnumEntries.length);
                    for (int i5 = 0; i5 < stringEnumEntries.length; i5++) {
                        writeString(stringEnumEntries[i5].getString());
                        writeShort(stringEnumEntries[i5].getIntValue());
                        writeString(stringEnumEntries[i5].getEnumName());
                    }
                }
                int simpleVariety = schemaType.getSimpleVariety();
                if (simpleVariety == 1) {
                    writeType(schemaType.getPrimitiveType());
                    writeInt(schemaType.getDecimalSize());
                } else if (simpleVariety == 2) {
                    writeTypeArray(schemaType.getUnionMemberTypes());
                } else if (simpleVariety == 3) {
                    writeType(schemaType.getListItemType());
                }
            }
            writeString(schemaType.getSourceName());
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void readExtensionsList() throws SchemaTypeLoaderException {
            int i = readShort();
            for (int i2 = 0; i2 < i; i2++) {
                readString();
                readString();
                readString();
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        SchemaLocalAttribute readAttributeData() throws SchemaTypeLoaderException {
            SchemaLocalAttributeImpl schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
            loadAttribute(schemaLocalAttributeImpl, readQName(), null);
            return schemaLocalAttributeImpl;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void loadAttribute(SchemaLocalAttributeImpl schemaLocalAttributeImpl, QName qName, SchemaContainer schemaContainer) throws SchemaTypeLoaderException {
            schemaLocalAttributeImpl.init(qName, readTypeRef(), readShort(), readString(), null, atLeast(2, 16, 0) ? readXmlValueObject() : null, readShort() == 1, readSOAPArrayType(), readAnnotation(schemaContainer), null);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeAttributeData(SchemaLocalAttribute schemaLocalAttribute) throws SchemaTypeLoaderException {
            writeQName(schemaLocalAttribute.getName());
            writeType(schemaLocalAttribute.getType());
            writeShort(schemaLocalAttribute.getUse());
            writeString(schemaLocalAttribute.getDefaultText());
            writeXmlValueObject(schemaLocalAttribute.getDefaultValue());
            writeShort(schemaLocalAttribute.isFixed() ? 1 : 0);
            writeSOAPArrayType(((SchemaWSDLArrayType) schemaLocalAttribute).getWSDLArrayType());
            writeAnnotation(schemaLocalAttribute.getAnnotation());
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeIdConstraintData(SchemaIdentityConstraint schemaIdentityConstraint) throws SchemaTypeLoaderException {
            writeQName(schemaIdentityConstraint.getName());
            writeShort(schemaIdentityConstraint.getConstraintCategory());
            writeString(schemaIdentityConstraint.getSelector());
            writeAnnotation(schemaIdentityConstraint.getAnnotation());
            String[] fields = schemaIdentityConstraint.getFields();
            writeShort(fields.length);
            for (String str : fields) {
                writeString(str);
            }
            if (schemaIdentityConstraint.getConstraintCategory() == 2) {
                writeHandle(schemaIdentityConstraint.getReferencedKey());
            }
            Set<Map.Entry> setEntrySet = schemaIdentityConstraint.getNSMap().entrySet();
            writeShort(setEntrySet.size());
            for (Map.Entry entry : setEntrySet) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                writeString(str2);
                writeString(str3);
            }
            writeString(schemaIdentityConstraint.getSourceName());
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        SchemaParticle[] readParticleArray() throws SchemaTypeLoaderException {
            int i = readShort();
            SchemaParticle[] schemaParticleArr = new SchemaParticle[i];
            for (int i2 = 0; i2 < i; i2++) {
                schemaParticleArr[i2] = readParticleData();
            }
            return schemaParticleArr;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeParticleArray(SchemaParticle[] schemaParticleArr) throws SchemaTypeLoaderException {
            writeShort(schemaParticleArr.length);
            for (SchemaParticle schemaParticle : schemaParticleArr) {
                writeParticleData(schemaParticle);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        SchemaParticle readParticleData() throws SchemaTypeLoaderException {
            SchemaParticleImpl schemaLocalElementImpl;
            int i = readShort();
            if (i != 4) {
                schemaLocalElementImpl = new SchemaParticleImpl();
            } else {
                schemaLocalElementImpl = new SchemaLocalElementImpl();
            }
            loadParticle(schemaLocalElementImpl, i);
            return schemaLocalElementImpl;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void loadParticle(SchemaParticleImpl schemaParticleImpl, int i) throws SchemaTypeLoaderException {
            int i2 = readShort();
            schemaParticleImpl.setParticleType(i);
            schemaParticleImpl.setMinOccurs(readBigInteger());
            schemaParticleImpl.setMaxOccurs(readBigInteger());
            schemaParticleImpl.setTransitionRules(readQNameSet(), (i2 & 1) != 0);
            if (i == 1 || i == 2 || i == 3) {
                schemaParticleImpl.setParticleChildren(readParticleArray());
                return;
            }
            if (i != 4) {
                if (i == 5) {
                    schemaParticleImpl.setWildcardSet(readQNameSet());
                    schemaParticleImpl.setWildcardProcess(readShort());
                    return;
                }
                throw new SchemaTypeLoaderException("Unrecognized particle type ", SchemaTypeSystemImpl.this._name, this._handle, 11);
            }
            SchemaLocalElementImpl schemaLocalElementImpl = (SchemaLocalElementImpl) schemaParticleImpl;
            schemaLocalElementImpl.setNameAndTypeRef(readQName(), readTypeRef());
            schemaLocalElementImpl.setDefault(readString(), (i2 & 4) != 0, null);
            if (atLeast(2, 16, 0)) {
                schemaLocalElementImpl.setDefaultValue(readXmlValueObject());
            }
            schemaLocalElementImpl.setNillable((i2 & 8) != 0);
            schemaLocalElementImpl.setBlock((i2 & 16) != 0, (i2 & 32) != 0, (i2 & 64) != 0);
            schemaLocalElementImpl.setWsdlArrayType(readSOAPArrayType());
            schemaLocalElementImpl.setAbstract((i2 & 128) != 0);
            schemaLocalElementImpl.setAnnotation(readAnnotation(null));
            int i3 = readShort();
            SchemaIdentityConstraint.Ref[] refArr = new SchemaIdentityConstraint.Ref[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                refArr[i4] = (SchemaIdentityConstraint.Ref) readHandle();
            }
            schemaLocalElementImpl.setIdentityConstraints(refArr);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeParticleData(SchemaParticle schemaParticle) throws SchemaTypeLoaderException {
            writeShort(schemaParticle.getParticleType());
            short s = schemaParticle.isSkippable() ? (short) 1 : (short) 0;
            if (schemaParticle.getParticleType() == 4) {
                SchemaGlobalElement schemaGlobalElement = (SchemaLocalElement) schemaParticle;
                if (schemaGlobalElement.isFixed()) {
                    s = (short) (s | 4);
                }
                if (schemaGlobalElement.isNillable()) {
                    s = (short) (s | 8);
                }
                if (schemaGlobalElement.blockExtension()) {
                    s = (short) (s | 16);
                }
                if (schemaGlobalElement.blockRestriction()) {
                    s = (short) (s | 32);
                }
                if (schemaGlobalElement.blockSubstitution()) {
                    s = (short) (s | 64);
                }
                if (schemaGlobalElement.isAbstract()) {
                    s = (short) (s | 128);
                }
                if (schemaGlobalElement instanceof SchemaGlobalElement) {
                    SchemaGlobalElement schemaGlobalElement2 = schemaGlobalElement;
                    if (schemaGlobalElement2.finalExtension()) {
                        s = (short) (s | 256);
                    }
                    if (schemaGlobalElement2.finalRestriction()) {
                        s = (short) (s | 512);
                    }
                }
            }
            writeShort(s);
            writeBigInteger(schemaParticle.getMinOccurs());
            writeBigInteger(schemaParticle.getMaxOccurs());
            writeQNameSet(schemaParticle.acceptedStartNames());
            int particleType = schemaParticle.getParticleType();
            if (particleType == 1 || particleType == 2 || particleType == 3) {
                writeParticleArray(schemaParticle.getParticleChildren());
                return;
            }
            if (particleType != 4) {
                if (particleType == 5) {
                    writeQNameSet(schemaParticle.getWildcardSet());
                    writeShort(schemaParticle.getWildcardProcess());
                    return;
                }
                throw new SchemaTypeLoaderException("Unrecognized particle type ", SchemaTypeSystemImpl.this._name, this._handle, 11);
            }
            SchemaGlobalElement schemaGlobalElement3 = (SchemaLocalElement) schemaParticle;
            writeQName(schemaGlobalElement3.getName());
            writeType(schemaGlobalElement3.getType());
            writeString(schemaGlobalElement3.getDefaultText());
            writeXmlValueObject(schemaGlobalElement3.getDefaultValue());
            writeSOAPArrayType(((SchemaWSDLArrayType) schemaGlobalElement3).getWSDLArrayType());
            writeAnnotation(schemaGlobalElement3.getAnnotation());
            if (schemaGlobalElement3 instanceof SchemaGlobalElement) {
                SchemaGlobalElement schemaGlobalElement4 = schemaGlobalElement3;
                writeHandle(schemaGlobalElement4.substitutionGroup());
                QName[] qNameArrSubstitutionGroupMembers = schemaGlobalElement4.substitutionGroupMembers();
                writeShort(qNameArrSubstitutionGroupMembers.length);
                for (QName qName : qNameArrSubstitutionGroupMembers) {
                    writeQName(qName);
                }
            }
            SchemaComponent[] identityConstraints = schemaGlobalElement3.getIdentityConstraints();
            writeShort(identityConstraints.length);
            for (SchemaComponent schemaComponent : identityConstraints) {
                writeHandle(schemaComponent);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        SchemaProperty readPropertyData() throws SchemaTypeLoaderException {
            SchemaPropertyImpl schemaPropertyImpl = new SchemaPropertyImpl();
            schemaPropertyImpl.setName(readQName());
            schemaPropertyImpl.setTypeRef(readTypeRef());
            int i = readShort();
            schemaPropertyImpl.setAttribute((i & 1) != 0);
            schemaPropertyImpl.setContainerTypeRef(readTypeRef());
            schemaPropertyImpl.setMinOccurs(readBigInteger());
            schemaPropertyImpl.setMaxOccurs(readBigInteger());
            schemaPropertyImpl.setNillable(readShort());
            schemaPropertyImpl.setDefault(readShort());
            schemaPropertyImpl.setFixed(readShort());
            schemaPropertyImpl.setDefaultText(readString());
            schemaPropertyImpl.setJavaPropertyName(readString());
            schemaPropertyImpl.setJavaTypeCode(readShort());
            schemaPropertyImpl.setExtendsJava(readTypeRef(), (i & 2) != 0, (i & 4) != 0, (i & 8) != 0);
            if (atMost(2, 19, 0)) {
                schemaPropertyImpl.setJavaSetterDelimiter(readQNameSet());
            }
            if (atLeast(2, 16, 0)) {
                schemaPropertyImpl.setDefaultValue(readXmlValueObject());
            }
            if (!schemaPropertyImpl.isAttribute() && atLeast(2, 17, 0)) {
                int i2 = readShort();
                LinkedHashSet linkedHashSet = new LinkedHashSet(i2);
                for (int i3 = 0; i3 < i2; i3++) {
                    linkedHashSet.add(readQName());
                }
                schemaPropertyImpl.setAcceptedNames(linkedHashSet);
            }
            schemaPropertyImpl.setImmutable();
            return schemaPropertyImpl;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writePropertyData(SchemaProperty schemaProperty) throws SchemaTypeLoaderException {
            writeQName(schemaProperty.getName());
            writeType(schemaProperty.getType());
            writeShort((schemaProperty.isAttribute() ? 1 : 0) | (schemaProperty.extendsJavaSingleton() ? 2 : 0) | (schemaProperty.extendsJavaOption() ? 4 : 0) | (schemaProperty.extendsJavaArray() ? 8 : 0));
            writeType(schemaProperty.getContainerType());
            writeBigInteger(schemaProperty.getMinOccurs());
            writeBigInteger(schemaProperty.getMaxOccurs());
            writeShort(schemaProperty.hasNillable());
            writeShort(schemaProperty.hasDefault());
            writeShort(schemaProperty.hasFixed());
            writeString(schemaProperty.getDefaultText());
            writeString(schemaProperty.getJavaPropertyName());
            writeShort(schemaProperty.getJavaTypeCode());
            writeType(schemaProperty.javaBasedOnType());
            writeXmlValueObject(schemaProperty.getDefaultValue());
            if (schemaProperty.isAttribute()) {
                return;
            }
            QName[] qNameArrAcceptedNames = schemaProperty.acceptedNames();
            writeShort(qNameArrAcceptedNames.length);
            for (QName qName : qNameArrAcceptedNames) {
                writeQName(qName);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeModelGroupData(SchemaModelGroup schemaModelGroup) throws SchemaTypeLoaderException {
            SchemaModelGroupImpl schemaModelGroupImpl = (SchemaModelGroupImpl) schemaModelGroup;
            writeQName(schemaModelGroupImpl.getName());
            writeString(schemaModelGroupImpl.getTargetNamespace());
            writeShort(schemaModelGroupImpl.getChameleonNamespace() != null ? 1 : 0);
            writeString(schemaModelGroupImpl.getElemFormDefault());
            writeString(schemaModelGroupImpl.getAttFormDefault());
            writeShort(schemaModelGroupImpl.isRedefinition() ? 1 : 0);
            writeString(schemaModelGroupImpl.getParseObject().xmlText(new XmlOptions().setSaveOuter()));
            writeAnnotation(schemaModelGroupImpl.getAnnotation());
            writeString(schemaModelGroupImpl.getSourceName());
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeAttributeGroupData(SchemaAttributeGroup schemaAttributeGroup) throws SchemaTypeLoaderException {
            SchemaAttributeGroupImpl schemaAttributeGroupImpl = (SchemaAttributeGroupImpl) schemaAttributeGroup;
            writeQName(schemaAttributeGroupImpl.getName());
            writeString(schemaAttributeGroupImpl.getTargetNamespace());
            writeShort(schemaAttributeGroupImpl.getChameleonNamespace() != null ? 1 : 0);
            writeString(schemaAttributeGroupImpl.getFormDefault());
            writeShort(schemaAttributeGroupImpl.isRedefinition() ? 1 : 0);
            writeString(schemaAttributeGroupImpl.getParseObject().xmlText(new XmlOptions().setSaveOuter()));
            writeAnnotation(schemaAttributeGroupImpl.getAnnotation());
            writeString(schemaAttributeGroupImpl.getSourceName());
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        XmlValueRef readXmlValueObject() throws SchemaTypeLoaderException {
            SchemaType.Ref typeRef = readTypeRef();
            if (typeRef == null) {
                return null;
            }
            int i = readShort();
            if (i != 0) {
                if (i == SchemaTypeSystemImpl.MAX_UNSIGNED_SHORT) {
                    int i2 = readShort();
                    ArrayList arrayList = new ArrayList();
                    writeShort(arrayList.size());
                    for (int i3 = 0; i3 < i2; i3++) {
                        arrayList.add(readXmlValueObject());
                    }
                    return new XmlValueRef(typeRef, arrayList);
                }
                switch (i) {
                    case 2:
                    case 3:
                    case 6:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        return new XmlValueRef(typeRef, readString());
                    case 4:
                    case 5:
                        return new XmlValueRef(typeRef, readByteArray());
                    case 7:
                    case 8:
                        return new XmlValueRef(typeRef, readQName());
                    case 9:
                    case 10:
                        return new XmlValueRef(typeRef, new Double(readDouble()));
                }
            }
            return new XmlValueRef(typeRef, null);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeXmlValueObject(XmlAnySimpleType xmlAnySimpleType) throws SchemaTypeLoaderException {
            SchemaType schemaType = xmlAnySimpleType == null ? null : xmlAnySimpleType.schemaType();
            writeType(schemaType);
            if (schemaType == null) {
            }
            SimpleValue simpleValue = (SimpleValue) xmlAnySimpleType;
            SchemaType schemaTypeInstanceType = simpleValue.instanceType();
            if (schemaTypeInstanceType == null) {
                writeShort(0);
                return;
            }
            if (schemaTypeInstanceType.getSimpleVariety() == 3) {
                writeShort(-1);
                List listXgetListValue = ((XmlObjectBase) xmlAnySimpleType).xgetListValue();
                writeShort(listXgetListValue.size());
                Iterator it = listXgetListValue.iterator();
                while (it.hasNext()) {
                    writeXmlValueObject((XmlAnySimpleType) it.next());
                }
                return;
            }
            int builtinTypeCode = schemaTypeInstanceType.getPrimitiveType().getBuiltinTypeCode();
            writeShort(builtinTypeCode);
            switch (builtinTypeCode) {
                case 2:
                case 3:
                case 6:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    writeString(xmlAnySimpleType.getStringValue());
                    break;
                case 4:
                case 5:
                    writeByteArray(simpleValue.getByteArrayValue());
                    break;
                case 7:
                case 8:
                    writeQName(simpleValue.getQNameValue());
                    break;
                case 9:
                    writeDouble(simpleValue.getFloatValue());
                    break;
                case 10:
                    writeDouble(simpleValue.getDoubleValue());
                    break;
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        double readDouble() throws SchemaTypeLoaderException {
            try {
                return this._input.readDouble();
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeDouble(double d) throws SchemaTypeLoaderException {
            DataOutputStream dataOutputStream = this._output;
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.writeDouble(d);
                } catch (IOException e) {
                    throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
                }
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        QNameSet readQNameSet() throws SchemaTypeLoaderException {
            int i = readShort();
            HashSet hashSet = new HashSet();
            int i2 = readShort();
            for (int i3 = 0; i3 < i2; i3++) {
                hashSet.add(readString());
            }
            HashSet hashSet2 = new HashSet();
            int i4 = readShort();
            for (int i5 = 0; i5 < i4; i5++) {
                hashSet2.add(readQName());
            }
            HashSet hashSet3 = new HashSet();
            int i6 = readShort();
            for (int i7 = 0; i7 < i6; i7++) {
                hashSet3.add(readQName());
            }
            if (i == 1) {
                return QNameSet.forSets(hashSet, (Set) null, hashSet2, hashSet3);
            }
            return QNameSet.forSets((Set) null, hashSet, hashSet3, hashSet2);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeQNameSet(QNameSet qNameSet) throws SchemaTypeLoaderException {
            int i = qNameSet.excludedURIs() != null ? 1 : 0;
            writeShort(i);
            Set setExcludedURIs = i != 0 ? qNameSet.excludedURIs() : qNameSet.includedURIs();
            writeShort(setExcludedURIs.size());
            Iterator it = setExcludedURIs.iterator();
            while (it.hasNext()) {
                writeString((String) it.next());
            }
            Set setExcludedQNamesInIncludedURIs = i != 0 ? qNameSet.excludedQNamesInIncludedURIs() : qNameSet.includedQNamesInExcludedURIs();
            writeShort(setExcludedQNamesInIncludedURIs.size());
            Iterator it2 = setExcludedQNamesInIncludedURIs.iterator();
            while (it2.hasNext()) {
                writeQName((QName) it2.next());
            }
            Set setIncludedQNamesInExcludedURIs = i != 0 ? qNameSet.includedQNamesInExcludedURIs() : qNameSet.excludedQNamesInIncludedURIs();
            writeShort(setIncludedQNamesInExcludedURIs.size());
            Iterator it3 = setIncludedQNamesInExcludedURIs.iterator();
            while (it3.hasNext()) {
                writeQName((QName) it3.next());
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        byte[] readByteArray() throws SchemaTypeLoaderException {
            try {
                byte[] bArr = new byte[this._input.readShort()];
                this._input.readFully(bArr);
                return bArr;
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeByteArray(byte[] bArr) throws SchemaTypeLoaderException {
            try {
                writeShort(bArr.length);
                DataOutputStream dataOutputStream = this._output;
                if (dataOutputStream != null) {
                    dataOutputStream.write(bArr);
                }
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        BigInteger readBigInteger() throws SchemaTypeLoaderException {
            byte[] byteArray = readByteArray();
            if (byteArray.length == 0) {
                return null;
            }
            if (byteArray.length == 1 && byteArray[0] == 0) {
                return BigInteger.ZERO;
            }
            if (byteArray.length == 1 && byteArray[0] == 1) {
                return BigInteger.ONE;
            }
            return new BigInteger(byteArray);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.SchemaTypeLoaderException */
        void writeBigInteger(BigInteger bigInteger) throws SchemaTypeLoaderException {
            if (bigInteger == null) {
                writeShort(0);
            } else if (bigInteger.signum() == 0) {
                writeByteArray(SchemaTypeSystemImpl.SINGLE_ZERO_BYTE);
            } else {
                writeByteArray(bigInteger.toByteArray());
            }
        }
    }

    public SchemaType typeForHandle(String str) {
        SchemaType schemaType;
        synchronized (this._resolvedHandles) {
            schemaType = (SchemaType) this._resolvedHandles.get(str);
        }
        return schemaType;
    }

    public SchemaType typeForClassname(String str) {
        SchemaType.Ref ref = (SchemaType.Ref) this._typeRefsByClassname.get(str);
        if (ref != null) {
            return ref.get();
        }
        return null;
    }

    public SchemaComponent resolveHandle(String str) {
        SchemaIdentityConstraint schemaIdentityConstraint;
        SchemaIdentityConstraint schemaIdentityConstraintFinishLoadingType;
        synchronized (this._resolvedHandles) {
            schemaIdentityConstraint = (SchemaComponent) this._resolvedHandles.get(str);
        }
        if (schemaIdentityConstraint == null) {
            XsbReader xsbReader = new XsbReader(str, MAX_UNSIGNED_SHORT);
            int actualFiletype = xsbReader.getActualFiletype();
            if (actualFiletype == 2) {
                XBeanDebug.trace(1, "Resolving type for handle " + str, 0);
                schemaIdentityConstraintFinishLoadingType = xsbReader.finishLoadingType();
            } else if (actualFiletype == 3) {
                XBeanDebug.trace(1, "Resolving element for handle " + str, 0);
                schemaIdentityConstraintFinishLoadingType = xsbReader.finishLoadingElement();
            } else if (actualFiletype == 4) {
                XBeanDebug.trace(1, "Resolving attribute for handle " + str, 0);
                schemaIdentityConstraintFinishLoadingType = xsbReader.finishLoadingAttribute();
            } else if (actualFiletype == 6) {
                XBeanDebug.trace(1, "Resolving model group for handle " + str, 0);
                schemaIdentityConstraintFinishLoadingType = xsbReader.finishLoadingModelGroup();
            } else if (actualFiletype == 7) {
                XBeanDebug.trace(1, "Resolving attribute group for handle " + str, 0);
                schemaIdentityConstraintFinishLoadingType = xsbReader.finishLoadingAttributeGroup();
            } else if (actualFiletype == 8) {
                XBeanDebug.trace(1, "Resolving id constraint for handle " + str, 0);
                schemaIdentityConstraintFinishLoadingType = xsbReader.finishLoadingIdentityConstraint();
            } else {
                throw new IllegalStateException("Illegal handle type");
            }
            synchronized (this._resolvedHandles) {
                if (!this._resolvedHandles.containsKey(str)) {
                    this._resolvedHandles.put(str, schemaIdentityConstraintFinishLoadingType);
                    schemaIdentityConstraint = schemaIdentityConstraintFinishLoadingType;
                } else {
                    schemaIdentityConstraint = (SchemaComponent) this._resolvedHandles.get(str);
                }
            }
        }
        return schemaIdentityConstraint;
    }

    public void resolve() {
        XBeanDebug.trace(1, "Resolve called type system " + this._name, 0);
        if (this._allNonGroupHandlesResolved) {
            return;
        }
        XBeanDebug.trace(1, "Resolving all handles for type system " + this._name, 1);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this._globalElements.values());
        arrayList.addAll(this._globalAttributes.values());
        arrayList.addAll(this._globalTypes.values());
        arrayList.addAll(this._documentTypes.values());
        arrayList.addAll(this._attributeTypes.values());
        arrayList.addAll(this._identityConstraints.values());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((SchemaComponent.Ref) it.next()).getComponent();
        }
        XBeanDebug.trace(1, "Finished resolving type system " + this._name, -1);
        this._allNonGroupHandlesResolved = true;
    }

    public boolean isNamespaceDefined(String str) {
        return this._namespaces.contains(str);
    }

    public SchemaType.Ref findTypeRef(QName qName) {
        return (SchemaType.Ref) this._globalTypes.get(qName);
    }

    public SchemaType.Ref findDocumentTypeRef(QName qName) {
        return (SchemaType.Ref) this._documentTypes.get(qName);
    }

    public SchemaType.Ref findAttributeTypeRef(QName qName) {
        return (SchemaType.Ref) this._attributeTypes.get(qName);
    }

    public SchemaGlobalElement.Ref findElementRef(QName qName) {
        return (SchemaGlobalElement.Ref) this._globalElements.get(qName);
    }

    public SchemaGlobalAttribute.Ref findAttributeRef(QName qName) {
        return (SchemaGlobalAttribute.Ref) this._globalAttributes.get(qName);
    }

    public SchemaModelGroup.Ref findModelGroupRef(QName qName) {
        return (SchemaModelGroup.Ref) this._modelGroups.get(qName);
    }

    public SchemaAttributeGroup.Ref findAttributeGroupRef(QName qName) {
        return (SchemaAttributeGroup.Ref) this._attributeGroups.get(qName);
    }

    public SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName qName) {
        return (SchemaIdentityConstraint.Ref) this._identityConstraints.get(qName);
    }

    public SchemaType[] globalTypes() {
        if (this._globalTypes.isEmpty()) {
            return EMPTY_ST_ARRAY;
        }
        SchemaType[] schemaTypeArr = new SchemaType[this._globalTypes.size()];
        Iterator it = this._globalTypes.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaTypeArr[i] = ((SchemaType.Ref) it.next()).get();
            i++;
        }
        return schemaTypeArr;
    }

    public SchemaType[] redefinedGlobalTypes() {
        List list = this._redefinedGlobalTypes;
        if (list == null || list.isEmpty()) {
            return EMPTY_ST_ARRAY;
        }
        SchemaType[] schemaTypeArr = new SchemaType[this._redefinedGlobalTypes.size()];
        Iterator it = this._redefinedGlobalTypes.iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaTypeArr[i] = ((SchemaType.Ref) it.next()).get();
            i++;
        }
        return schemaTypeArr;
    }

    public InputStream getSourceAsStream(String str) {
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        return this._resourceLoader.getResourceAsStream(getMetadataPath() + "/src" + str);
    }

    SchemaContainer[] containers() {
        SchemaContainer[] schemaContainerArr = new SchemaContainer[this._containers.size()];
        Iterator it = this._containers.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaContainerArr[i] = (SchemaContainer) it.next();
            i++;
        }
        return schemaContainerArr;
    }

    public SchemaType[] documentTypes() {
        if (this._documentTypes.isEmpty()) {
            return EMPTY_ST_ARRAY;
        }
        SchemaType[] schemaTypeArr = new SchemaType[this._documentTypes.size()];
        Iterator it = this._documentTypes.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaTypeArr[i] = ((SchemaType.Ref) it.next()).get();
            i++;
        }
        return schemaTypeArr;
    }

    public SchemaType[] attributeTypes() {
        if (this._attributeTypes.isEmpty()) {
            return EMPTY_ST_ARRAY;
        }
        SchemaType[] schemaTypeArr = new SchemaType[this._attributeTypes.size()];
        Iterator it = this._attributeTypes.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaTypeArr[i] = ((SchemaType.Ref) it.next()).get();
            i++;
        }
        return schemaTypeArr;
    }

    public SchemaGlobalElement[] globalElements() {
        if (this._globalElements.isEmpty()) {
            return EMPTY_GE_ARRAY;
        }
        SchemaGlobalElement[] schemaGlobalElementArr = new SchemaGlobalElement[this._globalElements.size()];
        Iterator it = this._globalElements.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaGlobalElementArr[i] = ((SchemaGlobalElement.Ref) it.next()).get();
            i++;
        }
        return schemaGlobalElementArr;
    }

    public SchemaGlobalAttribute[] globalAttributes() {
        if (this._globalAttributes.isEmpty()) {
            return EMPTY_GA_ARRAY;
        }
        SchemaGlobalAttribute[] schemaGlobalAttributeArr = new SchemaGlobalAttribute[this._globalAttributes.size()];
        Iterator it = this._globalAttributes.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaGlobalAttributeArr[i] = ((SchemaGlobalAttribute.Ref) it.next()).get();
            i++;
        }
        return schemaGlobalAttributeArr;
    }

    public SchemaModelGroup[] modelGroups() {
        if (this._modelGroups.isEmpty()) {
            return EMPTY_MG_ARRAY;
        }
        SchemaModelGroup[] schemaModelGroupArr = new SchemaModelGroup[this._modelGroups.size()];
        Iterator it = this._modelGroups.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaModelGroupArr[i] = ((SchemaModelGroup.Ref) it.next()).get();
            i++;
        }
        return schemaModelGroupArr;
    }

    public SchemaModelGroup[] redefinedModelGroups() {
        List list = this._redefinedModelGroups;
        if (list == null || list.isEmpty()) {
            return EMPTY_MG_ARRAY;
        }
        SchemaModelGroup[] schemaModelGroupArr = new SchemaModelGroup[this._redefinedModelGroups.size()];
        Iterator it = this._redefinedModelGroups.iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaModelGroupArr[i] = ((SchemaModelGroup.Ref) it.next()).get();
            i++;
        }
        return schemaModelGroupArr;
    }

    public SchemaAttributeGroup[] attributeGroups() {
        if (this._attributeGroups.isEmpty()) {
            return EMPTY_AG_ARRAY;
        }
        SchemaAttributeGroup[] schemaAttributeGroupArr = new SchemaAttributeGroup[this._attributeGroups.size()];
        Iterator it = this._attributeGroups.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaAttributeGroupArr[i] = ((SchemaAttributeGroup.Ref) it.next()).get();
            i++;
        }
        return schemaAttributeGroupArr;
    }

    public SchemaAttributeGroup[] redefinedAttributeGroups() {
        List list = this._redefinedAttributeGroups;
        if (list == null || list.isEmpty()) {
            return EMPTY_AG_ARRAY;
        }
        SchemaAttributeGroup[] schemaAttributeGroupArr = new SchemaAttributeGroup[this._redefinedAttributeGroups.size()];
        Iterator it = this._redefinedAttributeGroups.iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaAttributeGroupArr[i] = ((SchemaAttributeGroup.Ref) it.next()).get();
            i++;
        }
        return schemaAttributeGroupArr;
    }

    public SchemaAnnotation[] annotations() {
        List list = this._annotations;
        if (list == null || list.isEmpty()) {
            return EMPTY_ANN_ARRAY;
        }
        return (SchemaAnnotation[]) this._annotations.toArray(new SchemaAnnotation[this._annotations.size()]);
    }

    public SchemaIdentityConstraint[] identityConstraints() {
        if (this._identityConstraints.isEmpty()) {
            return EMPTY_IC_ARRAY;
        }
        SchemaIdentityConstraint[] schemaIdentityConstraintArr = new SchemaIdentityConstraint[this._identityConstraints.size()];
        Iterator it = this._identityConstraints.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaIdentityConstraintArr[i] = ((SchemaIdentityConstraint.Ref) it.next()).get();
            i++;
        }
        return schemaIdentityConstraintArr;
    }

    public ClassLoader getClassLoader() {
        return this._classloader;
    }

    public String handleForType(SchemaType schemaType) {
        return this._localHandles.handleForType(schemaType);
    }

    public String getName() {
        return this._name;
    }

    public SchemaTypeSystem typeSystemForName(String str) {
        String str2 = this._name;
        if (str2 == null || !str.equals(str2)) {
            return null;
        }
        return this;
    }

    protected String getMetadataPath() {
        return "schema" + METADATA_PACKAGE_GEN;
    }
}
