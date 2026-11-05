package org.apache.xmlbeans.impl.schema;

import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.ResourceLoader;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.apache.xmlbeans.impl.common.SystemCache;
import org.apache.xmlbeans.impl.common.XBeanDebug;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SchemaTypeLoaderImpl extends SchemaTypeLoaderBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Map _attributeCache;
    private Map _attributeGroupCache;
    private Map _attributeTypeCache;
    private ClassLoader _classLoader;
    private Map _classLoaderTypeSystems;
    private Map _classnameCache;
    private Map _classpathTypeSystems;
    private Map _documentCache;
    private Map _elementCache;
    private Map _idConstraintCache;
    private final String _metadataPath;
    private Map _modelGroupCache;
    private ResourceLoader _resourceLoader;
    private SchemaTypeLoader[] _searchPath;
    private Map _typeCache;
    public static String METADATA_PACKAGE_LOAD = SchemaTypeSystemImpl.METADATA_PACKAGE_GEN;
    private static final Object CACHED_NOT_FOUND = new Object();
    private static final SchemaTypeLoader[] EMPTY_SCHEMATYPELOADER_ARRAY = new SchemaTypeLoader[0];

    static {
        if (SystemCache.get() instanceof SystemCache) {
            SystemCache.set(new SchemaTypeLoaderCache());
        }
    }

    private static class SchemaTypeLoaderCache extends SystemCache {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private ThreadLocal _cachedTypeSystems;

        private SchemaTypeLoaderCache() {
            this._cachedTypeSystems = new ThreadLocal() { // from class: org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl.SchemaTypeLoaderCache.1
                @Override // java.lang.ThreadLocal
                protected Object initialValue() {
                    return new ArrayList();
                }
            };
        }

        @Override // org.apache.xmlbeans.impl.common.SystemCache
        public void clearThreadLocals() {
            this._cachedTypeSystems.remove();
            super.clearThreadLocals();
        }

        @Override // org.apache.xmlbeans.impl.common.SystemCache
        public SchemaTypeLoader getFromTypeLoaderCache(ClassLoader classLoader) {
            SchemaTypeLoaderImpl schemaTypeLoaderImpl;
            ArrayList arrayList = (ArrayList) this._cachedTypeSystems.get();
            int i = 0;
            while (true) {
                if (i >= arrayList.size()) {
                    i = -1;
                    schemaTypeLoaderImpl = null;
                    break;
                }
                schemaTypeLoaderImpl = (SchemaTypeLoaderImpl) ((SoftReference) arrayList.get(i)).get();
                if (schemaTypeLoaderImpl != null) {
                    if (schemaTypeLoaderImpl._classLoader == classLoader) {
                        break;
                    }
                } else {
                    arrayList.remove(i);
                    i--;
                }
                i++;
            }
            if (i > 0) {
                Object obj = arrayList.get(0);
                arrayList.set(0, arrayList.get(i));
                arrayList.set(i, obj);
            }
            return schemaTypeLoaderImpl;
        }

        @Override // org.apache.xmlbeans.impl.common.SystemCache
        public void addToTypeLoaderCache(SchemaTypeLoader schemaTypeLoader, ClassLoader classLoader) {
            ArrayList arrayList = (ArrayList) this._cachedTypeSystems.get();
            if (arrayList.size() > 0) {
                Object obj = arrayList.get(0);
                arrayList.set(0, new SoftReference(schemaTypeLoader));
                arrayList.add(obj);
                return;
            }
            arrayList.add(new SoftReference(schemaTypeLoader));
        }
    }

    public static SchemaTypeLoaderImpl getContextTypeLoader() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        SchemaTypeLoaderImpl schemaTypeLoaderImpl = (SchemaTypeLoaderImpl) SystemCache.get().getFromTypeLoaderCache(contextClassLoader);
        if (schemaTypeLoaderImpl != null) {
            return schemaTypeLoaderImpl;
        }
        SchemaTypeLoaderImpl schemaTypeLoaderImpl2 = new SchemaTypeLoaderImpl(new SchemaTypeLoader[]{BuiltinSchemaTypeSystem.get()}, null, contextClassLoader, null);
        SystemCache.get().addToTypeLoaderCache(schemaTypeLoaderImpl2, contextClassLoader);
        return schemaTypeLoaderImpl2;
    }

    public static SchemaTypeLoader build(SchemaTypeLoader[] schemaTypeLoaderArr, ResourceLoader resourceLoader, ClassLoader classLoader) {
        return build(schemaTypeLoaderArr, resourceLoader, classLoader, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SchemaTypeLoader build(SchemaTypeLoader[] schemaTypeLoaderArr, ResourceLoader resourceLoader, ClassLoader classLoader, String str) {
        SchemaTypeLoader[] array = null;
        Object[] objArr = 0;
        if (schemaTypeLoaderArr == null) {
            if ((str == null || new StringBuilder("schema").append(SchemaTypeSystemImpl.METADATA_PACKAGE_GEN).toString().equals(str)) == false) {
                String[] strArr = {"schemaorg_apache_xmlbeans.system.sXMLCONFIG.TypeSystemHolder", "schemaorg_apache_xmlbeans.system.sXMLLANG.TypeSystemHolder", "schemaorg_apache_xmlbeans.system.sXMLSCHEMA.TypeSystemHolder", "schemaorg_apache_xmlbeans.system.sXMLTOOLS.TypeSystemHolder"};
                SchemaTypeLoader[] schemaTypeLoaderArr2 = new SchemaTypeLoader[4];
                for (int i = 0; i < 4; i++) {
                    try {
                        schemaTypeLoaderArr2[i] = (SchemaTypeLoader) Class.forName(strArr[i]).getDeclaredField("typeSystem").get(null);
                    } catch (Exception e) {
                        System.out.println("throw runtime: " + e.toString());
                        throw new RuntimeException(e);
                    }
                }
                array = schemaTypeLoaderArr2;
            }
        } else {
            SubLoaderList subLoaderList = new SubLoaderList();
            subLoaderList.add(schemaTypeLoaderArr);
            array = subLoaderList.toArray();
        }
        if (array != null && array.length == 1 && resourceLoader == null && classLoader == null) {
            return array[0];
        }
        return new SchemaTypeLoaderImpl(array, resourceLoader, classLoader, str);
    }

    private static class SubLoaderList {
        private final Map<SchemaTypeLoader, Object> seen;
        private final List<SchemaTypeLoader> theList;

        private SubLoaderList() {
            this.theList = new ArrayList();
            this.seen = new IdentityHashMap();
        }

        void add(SchemaTypeLoader[] schemaTypeLoaderArr) {
            if (schemaTypeLoaderArr == null) {
                return;
            }
            for (SchemaTypeLoader schemaTypeLoader : schemaTypeLoaderArr) {
                if (schemaTypeLoader instanceof SchemaTypeLoaderImpl) {
                    SchemaTypeLoaderImpl schemaTypeLoaderImpl = (SchemaTypeLoaderImpl) schemaTypeLoader;
                    if (schemaTypeLoaderImpl._classLoader == null && schemaTypeLoaderImpl._resourceLoader == null) {
                        add(schemaTypeLoaderImpl._searchPath);
                    } else {
                        add(schemaTypeLoaderImpl);
                    }
                } else {
                    add(schemaTypeLoader);
                }
            }
        }

        void add(SchemaTypeLoader schemaTypeLoader) {
            if (schemaTypeLoader == null || this.seen.containsKey(schemaTypeLoader)) {
                return;
            }
            this.theList.add(schemaTypeLoader);
            this.seen.put(schemaTypeLoader, null);
        }

        SchemaTypeLoader[] toArray() {
            return (SchemaTypeLoader[]) this.theList.toArray(SchemaTypeLoaderImpl.EMPTY_SCHEMATYPELOADER_ARRAY);
        }
    }

    private SchemaTypeLoaderImpl(SchemaTypeLoader[] schemaTypeLoaderArr, ResourceLoader resourceLoader, ClassLoader classLoader, String str) {
        if (schemaTypeLoaderArr == null) {
            this._searchPath = EMPTY_SCHEMATYPELOADER_ARRAY;
        } else {
            this._searchPath = schemaTypeLoaderArr;
        }
        this._resourceLoader = resourceLoader;
        this._classLoader = classLoader;
        this._metadataPath = str == null ? "schema" + METADATA_PACKAGE_LOAD : str;
        initCaches();
    }

    private final void initCaches() {
        this._classpathTypeSystems = Collections.synchronizedMap(new HashMap());
        this._classLoaderTypeSystems = Collections.synchronizedMap(new HashMap());
        this._elementCache = Collections.synchronizedMap(new HashMap());
        this._attributeCache = Collections.synchronizedMap(new HashMap());
        this._modelGroupCache = Collections.synchronizedMap(new HashMap());
        this._attributeGroupCache = Collections.synchronizedMap(new HashMap());
        this._idConstraintCache = Collections.synchronizedMap(new HashMap());
        this._typeCache = Collections.synchronizedMap(new HashMap());
        this._documentCache = Collections.synchronizedMap(new HashMap());
        this._attributeTypeCache = Collections.synchronizedMap(new HashMap());
        this._classnameCache = Collections.synchronizedMap(new HashMap());
    }

    SchemaTypeSystemImpl typeSystemForComponent(String str, QName qName) {
        String str2 = str + QNameHelper.hexsafedir(qName) + ".xsb";
        ResourceLoader resourceLoader = this._resourceLoader;
        String strCrackEntry = resourceLoader != null ? crackEntry(resourceLoader, str2) : null;
        ClassLoader classLoader = this._classLoader;
        if (classLoader != null) {
            strCrackEntry = crackEntry(classLoader, str2);
        }
        if (strCrackEntry != null) {
            return (SchemaTypeSystemImpl) typeSystemForName(strCrackEntry);
        }
        return null;
    }

    public SchemaTypeSystem typeSystemForName(String str) {
        SchemaTypeSystemImpl typeSystemOnClassloader;
        SchemaTypeSystemImpl typeSystemOnClasspath;
        if (this._resourceLoader != null && (typeSystemOnClasspath = getTypeSystemOnClasspath(str)) != null) {
            return typeSystemOnClasspath;
        }
        if (this._classLoader == null || (typeSystemOnClassloader = getTypeSystemOnClassloader(str)) == null) {
            return null;
        }
        return typeSystemOnClassloader;
    }

    SchemaTypeSystemImpl typeSystemForClassname(String str, String str2) {
        String strCrackEntry;
        String strCrackEntry2;
        String str3 = str + str2.replace(NameUtil.PERIOD, '/') + ".xsb";
        ResourceLoader resourceLoader = this._resourceLoader;
        if (resourceLoader != null && (strCrackEntry2 = crackEntry(resourceLoader, str3)) != null) {
            return getTypeSystemOnClasspath(strCrackEntry2);
        }
        ClassLoader classLoader = this._classLoader;
        if (classLoader == null || (strCrackEntry = crackEntry(classLoader, str3)) == null) {
            return null;
        }
        return getTypeSystemOnClassloader(strCrackEntry);
    }

    SchemaTypeSystemImpl getTypeSystemOnClasspath(String str) {
        SchemaTypeSystemImpl schemaTypeSystemImpl = (SchemaTypeSystemImpl) this._classpathTypeSystems.get(str);
        if (schemaTypeSystemImpl != null) {
            return schemaTypeSystemImpl;
        }
        SchemaTypeSystemImpl schemaTypeSystemImpl2 = new SchemaTypeSystemImpl(this._resourceLoader, str, this);
        this._classpathTypeSystems.put(str, schemaTypeSystemImpl2);
        return schemaTypeSystemImpl2;
    }

    SchemaTypeSystemImpl getTypeSystemOnClassloader(String str) {
        XBeanDebug.trace(1, "Finding type system " + str + " on classloader", 0);
        SchemaTypeSystemImpl schemaTypeSystemImpl = (SchemaTypeSystemImpl) this._classLoaderTypeSystems.get(str);
        if (schemaTypeSystemImpl != null) {
            return schemaTypeSystemImpl;
        }
        XBeanDebug.trace(1, "Type system " + str + " not cached - consulting field", 0);
        SchemaTypeSystemImpl schemaTypeSystemImplForName = SchemaTypeSystemImpl.forName(str, this._classLoader);
        this._classLoaderTypeSystems.put(str, schemaTypeSystemImplForName);
        return schemaTypeSystemImplForName;
    }

    static String crackEntry(ResourceLoader resourceLoader, String str) {
        InputStream resourceAsStream = resourceLoader.getResourceAsStream(str);
        if (resourceAsStream == null) {
            return null;
        }
        return crackPointer(resourceAsStream);
    }

    static String crackEntry(ClassLoader classLoader, String str) {
        InputStream resourceAsStream = classLoader.getResourceAsStream(str);
        if (resourceAsStream == null) {
            return null;
        }
        return crackPointer(resourceAsStream);
    }

    static String crackPointer(InputStream inputStream) {
        return SchemaTypeSystemImpl.crackPointer(inputStream);
    }

    public boolean isNamespaceDefined(String str) {
        int i = 0;
        while (true) {
            SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
            if (i >= schemaTypeLoaderArr.length) {
                return typeSystemForComponent(new StringBuilder().append(this._metadataPath).append("/namespace/").toString(), new QName(str, Sax2Dom.XMLNS_PREFIX)) != null;
            }
            if (schemaTypeLoaderArr[i].isNamespaceDefined(str)) {
                return true;
            }
            i++;
        }
    }

    public SchemaType.Ref findTypeRef(QName qName) {
        SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent;
        Object obj = this._typeCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaType.Ref refFindTypeRef = (SchemaType.Ref) obj;
        if (refFindTypeRef == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (refFindTypeRef = schemaTypeLoaderArr[i].findTypeRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (refFindTypeRef == null && (schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(this._metadataPath + "/type/", qName)) != null) {
                refFindTypeRef = schemaTypeSystemImplTypeSystemForComponent.findTypeRef(qName);
            }
            this._typeCache.put(qName, refFindTypeRef == null ? CACHED_NOT_FOUND : refFindTypeRef);
        }
        return refFindTypeRef;
    }

    public SchemaType typeForClassname(String str) {
        SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForClassname;
        String strReplace = str.replace('$', NameUtil.PERIOD);
        Object obj = this._classnameCache.get(strReplace);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaType schemaTypeTypeForClassname = (SchemaType) obj;
        if (schemaTypeTypeForClassname == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (schemaTypeTypeForClassname = schemaTypeLoaderArr[i].typeForClassname(strReplace)) != null) {
                    break;
                }
                i++;
            }
            if (schemaTypeTypeForClassname == null && (schemaTypeSystemImplTypeSystemForClassname = typeSystemForClassname(this._metadataPath + "/javaname/", strReplace)) != null) {
                schemaTypeTypeForClassname = schemaTypeSystemImplTypeSystemForClassname.typeForClassname(strReplace);
            }
            this._classnameCache.put(strReplace, schemaTypeTypeForClassname == null ? CACHED_NOT_FOUND : schemaTypeTypeForClassname);
        }
        return schemaTypeTypeForClassname;
    }

    public SchemaType.Ref findDocumentTypeRef(QName qName) {
        SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent;
        Object obj = this._documentCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaType.Ref refFindDocumentTypeRef = (SchemaType.Ref) obj;
        if (refFindDocumentTypeRef == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (refFindDocumentTypeRef = schemaTypeLoaderArr[i].findDocumentTypeRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (refFindDocumentTypeRef == null && (schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(this._metadataPath + "/element/", qName)) != null) {
                refFindDocumentTypeRef = schemaTypeSystemImplTypeSystemForComponent.findDocumentTypeRef(qName);
            }
            this._documentCache.put(qName, refFindDocumentTypeRef == null ? CACHED_NOT_FOUND : refFindDocumentTypeRef);
        }
        return refFindDocumentTypeRef;
    }

    public SchemaType.Ref findAttributeTypeRef(QName qName) {
        SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent;
        Object obj = this._attributeTypeCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaType.Ref refFindAttributeTypeRef = (SchemaType.Ref) obj;
        if (refFindAttributeTypeRef == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (refFindAttributeTypeRef = schemaTypeLoaderArr[i].findAttributeTypeRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (refFindAttributeTypeRef == null && (schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(this._metadataPath + "/attribute/", qName)) != null) {
                refFindAttributeTypeRef = schemaTypeSystemImplTypeSystemForComponent.findAttributeTypeRef(qName);
            }
            this._attributeTypeCache.put(qName, refFindAttributeTypeRef == null ? CACHED_NOT_FOUND : refFindAttributeTypeRef);
        }
        return refFindAttributeTypeRef;
    }

    public SchemaGlobalElement.Ref findElementRef(QName qName) {
        SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent;
        Object obj = this._elementCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaGlobalElement.Ref refFindElementRef = (SchemaGlobalElement.Ref) obj;
        if (refFindElementRef == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (refFindElementRef = schemaTypeLoaderArr[i].findElementRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (refFindElementRef == null && (schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(this._metadataPath + "/element/", qName)) != null) {
                refFindElementRef = schemaTypeSystemImplTypeSystemForComponent.findElementRef(qName);
            }
            this._elementCache.put(qName, refFindElementRef == null ? CACHED_NOT_FOUND : refFindElementRef);
        }
        return refFindElementRef;
    }

    public SchemaGlobalAttribute.Ref findAttributeRef(QName qName) {
        SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent;
        Object obj = this._attributeCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaGlobalAttribute.Ref refFindAttributeRef = (SchemaGlobalAttribute.Ref) obj;
        if (refFindAttributeRef == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (refFindAttributeRef = schemaTypeLoaderArr[i].findAttributeRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (refFindAttributeRef == null && (schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(this._metadataPath + "/attribute/", qName)) != null) {
                refFindAttributeRef = schemaTypeSystemImplTypeSystemForComponent.findAttributeRef(qName);
            }
            this._attributeCache.put(qName, refFindAttributeRef == null ? CACHED_NOT_FOUND : refFindAttributeRef);
        }
        return refFindAttributeRef;
    }

    public SchemaModelGroup.Ref findModelGroupRef(QName qName) {
        SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent;
        Object obj = this._modelGroupCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaModelGroup.Ref refFindModelGroupRef = (SchemaModelGroup.Ref) obj;
        if (refFindModelGroupRef == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (refFindModelGroupRef = schemaTypeLoaderArr[i].findModelGroupRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (refFindModelGroupRef == null && (schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(this._metadataPath + "/modelgroup/", qName)) != null) {
                refFindModelGroupRef = schemaTypeSystemImplTypeSystemForComponent.findModelGroupRef(qName);
            }
            this._modelGroupCache.put(qName, refFindModelGroupRef == null ? CACHED_NOT_FOUND : refFindModelGroupRef);
        }
        return refFindModelGroupRef;
    }

    public SchemaAttributeGroup.Ref findAttributeGroupRef(QName qName) {
        SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent;
        Object obj = this._attributeGroupCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaAttributeGroup.Ref refFindAttributeGroupRef = (SchemaAttributeGroup.Ref) obj;
        if (refFindAttributeGroupRef == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (refFindAttributeGroupRef = schemaTypeLoaderArr[i].findAttributeGroupRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (refFindAttributeGroupRef == null && (schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(this._metadataPath + "/attributegroup/", qName)) != null) {
                refFindAttributeGroupRef = schemaTypeSystemImplTypeSystemForComponent.findAttributeGroupRef(qName);
            }
            this._attributeGroupCache.put(qName, refFindAttributeGroupRef == null ? CACHED_NOT_FOUND : refFindAttributeGroupRef);
        }
        return refFindAttributeGroupRef;
    }

    public SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName qName) {
        SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent;
        Object obj = this._idConstraintCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaIdentityConstraint.Ref refFindIdentityConstraintRef = (SchemaIdentityConstraint.Ref) obj;
        if (refFindIdentityConstraintRef == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (refFindIdentityConstraintRef = schemaTypeLoaderArr[i].findIdentityConstraintRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (refFindIdentityConstraintRef == null && (schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(this._metadataPath + "/identityconstraint/", qName)) != null) {
                refFindIdentityConstraintRef = schemaTypeSystemImplTypeSystemForComponent.findIdentityConstraintRef(qName);
            }
            this._idConstraintCache.put(qName, refFindIdentityConstraintRef == null ? CACHED_NOT_FOUND : refFindIdentityConstraintRef);
        }
        return refFindIdentityConstraintRef;
    }

    public InputStream getSourceAsStream(String str) {
        ClassLoader classLoader;
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        ResourceLoader resourceLoader = this._resourceLoader;
        InputStream resourceAsStream = resourceLoader != null ? resourceLoader.getResourceAsStream(this._metadataPath + "/src" + str) : null;
        return (resourceAsStream != null || (classLoader = this._classLoader) == null) ? resourceAsStream : classLoader.getResourceAsStream(this._metadataPath + "/src" + str);
    }
}
