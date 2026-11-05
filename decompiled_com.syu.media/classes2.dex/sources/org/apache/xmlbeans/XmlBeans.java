package org.apache.xmlbeans;

import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XmlBeans {
    private static final String HOLDER_CLASS_NAME = "TypeSystemHolder";
    public static SchemaType NO_TYPE = null;
    private static final String TYPE_SYSTEM_FIELD = "typeSystem";
    private static String XMLBEANS_TITLE = "org.apache.xmlbeans";
    private static String XMLBEANS_VENDOR = "Apache Software Foundation";
    private static String XMLBEANS_VERSION = "3.1.0";
    private static final Method _compilationMethod;
    private static final Method _getBuiltinSchemaTypeSystemMethod;
    private static final Method _getContextTypeLoaderMethod;
    private static final Method _getNoTypeMethod;
    private static final Method _nodeToCursorMethod;
    private static final Method _nodeToXmlObjectMethod;
    private static final Method _nodeToXmlStreamMethod;
    private static final Constructor _pathResourceLoaderConstructor;
    private static final Method _streamToNodeMethod;
    private static final ThreadLocal _threadLocalLoaderQNameCache;
    private static final Method _typeLoaderBuilderMethod;

    static {
        Package r0 = XmlBeans.class.getPackage();
        if (r0 != null && r0.getImplementationVersion() != null) {
            XMLBEANS_TITLE = r0.getImplementationTitle();
            XMLBEANS_VERSION = r0.getImplementationVersion();
            XMLBEANS_VENDOR = r0.getImplementationVendor();
        }
        _threadLocalLoaderQNameCache = new ThreadLocal() { // from class: org.apache.xmlbeans.XmlBeans.1
            @Override // java.lang.ThreadLocal
            protected Object initialValue() {
                return new SoftReference(new QNameCache(32));
            }
        };
        _getContextTypeLoaderMethod = buildGetContextTypeLoaderMethod();
        _getBuiltinSchemaTypeSystemMethod = buildGetBuiltinSchemaTypeSystemMethod();
        _getNoTypeMethod = buildGetNoTypeMethod();
        _typeLoaderBuilderMethod = buildTypeLoaderBuilderMethod();
        _compilationMethod = buildCompilationMethod();
        _nodeToCursorMethod = buildNodeToCursorMethod();
        _nodeToXmlObjectMethod = buildNodeToXmlObjectMethod();
        _nodeToXmlStreamMethod = buildNodeToXmlStreamMethod();
        _streamToNodeMethod = buildStreamToNodeMethod();
        _pathResourceLoaderConstructor = buildPathResourceLoaderConstructor();
        NO_TYPE = getNoType();
    }

    public static final String getTitle() {
        return XMLBEANS_TITLE;
    }

    public static final String getVendor() {
        return XMLBEANS_VENDOR;
    }

    public static final String getVersion() {
        return XMLBEANS_VERSION;
    }

    public static void clearThreadLocals() {
        _threadLocalLoaderQNameCache.remove();
    }

    public static QNameCache getQNameCache() {
        ThreadLocal threadLocal = _threadLocalLoaderQNameCache;
        QNameCache qNameCache = (QNameCache) ((SoftReference) threadLocal.get()).get();
        if (qNameCache != null) {
            return qNameCache;
        }
        QNameCache qNameCache2 = new QNameCache(32);
        threadLocal.set(new SoftReference(qNameCache2));
        return qNameCache2;
    }

    public static QName getQName(String str) {
        return getQNameCache().getName("", str);
    }

    public static QName getQName(String str, String str2) {
        return getQNameCache().getName(str, str2);
    }

    private static RuntimeException causedException(RuntimeException runtimeException, Throwable th) {
        runtimeException.initCause(th);
        return runtimeException;
    }

    private static XmlException wrappedException(Throwable th) {
        if (th instanceof XmlException) {
            return (XmlException) th;
        }
        return new XmlException(th.getMessage(), th);
    }

    private static final Constructor buildConstructor(String str, Class[] clsArr) {
        try {
            return Class.forName(str, false, XmlBeans.class.getClassLoader()).getConstructor(clsArr);
        } catch (Exception e) {
            throw causedException(new IllegalStateException("Cannot load constructor for " + str + ": verify that xbean.jar is on the classpath"), e);
        }
    }

    private static final Method buildMethod(String str, String str2, Class[] clsArr) {
        try {
            return Class.forName(str, false, XmlBeans.class.getClassLoader()).getMethod(str2, clsArr);
        } catch (Exception e) {
            throw causedException(new IllegalStateException("Cannot load " + str2 + ": verify that xbean.jar is on the classpath"), e);
        }
    }

    private static final Method buildNoArgMethod(String str, String str2) {
        return buildMethod(str, str2, new Class[0]);
    }

    private static final Method buildNodeMethod(String str, String str2) {
        return buildMethod(str, str2, new Class[]{Node.class});
    }

    private static Method buildGetContextTypeLoaderMethod() {
        return buildNoArgMethod("org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl", "getContextTypeLoader");
    }

    private static final Method buildGetBuiltinSchemaTypeSystemMethod() {
        return buildNoArgMethod("org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem", "get");
    }

    private static final Method buildGetNoTypeMethod() {
        return buildNoArgMethod("org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem", "getNoType");
    }

    private static final Method buildTypeLoaderBuilderMethod() {
        return buildMethod("org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl", "build", new Class[]{SchemaTypeLoader[].class, ResourceLoader.class, ClassLoader.class});
    }

    private static final Method buildCompilationMethod() {
        return buildMethod("org.apache.xmlbeans.impl.schema.SchemaTypeSystemCompiler", "compile", new Class[]{String.class, SchemaTypeSystem.class, XmlObject[].class, BindingConfig.class, SchemaTypeLoader.class, Filer.class, XmlOptions.class});
    }

    private static final Method buildNodeToCursorMethod() {
        return buildNodeMethod("org.apache.xmlbeans.impl.store.Locale", "nodeToCursor");
    }

    private static final Method buildNodeToXmlObjectMethod() {
        return buildNodeMethod("org.apache.xmlbeans.impl.store.Locale", "nodeToXmlObject");
    }

    private static final Method buildNodeToXmlStreamMethod() {
        return buildNodeMethod("org.apache.xmlbeans.impl.store.Locale", "nodeToXmlStream");
    }

    private static final Method buildStreamToNodeMethod() {
        return buildMethod("org.apache.xmlbeans.impl.store.Locale", "streamToNode", new Class[]{XMLStreamReader.class});
    }

    private static final Constructor buildPathResourceLoaderConstructor() {
        return buildConstructor("org.apache.xmlbeans.impl.schema.PathResourceLoader", new Class[]{File[].class});
    }

    public static String compilePath(String str) throws XmlException {
        return compilePath(str, null);
    }

    public static String compilePath(String str, XmlOptions xmlOptions) throws XmlException {
        return getContextTypeLoader().compilePath(str, xmlOptions);
    }

    public static String compileQuery(String str) throws XmlException {
        return compileQuery(str, null);
    }

    public static String compileQuery(String str, XmlOptions xmlOptions) throws XmlException {
        return getContextTypeLoader().compileQuery(str, xmlOptions);
    }

    public static SchemaTypeLoader getContextTypeLoader() {
        try {
            return (SchemaTypeLoader) _getContextTypeLoaderMethod.invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl.getContextTypeLoader(): verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static SchemaTypeSystem getBuiltinTypeSystem() {
        try {
            return (SchemaTypeSystem) _getBuiltinSchemaTypeSystemMethod.invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to BuiltinSchemaTypeSystem.get(): verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static XmlCursor nodeToCursor(Node node) {
        try {
            return (XmlCursor) _nodeToCursorMethod.invoke(null, node);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to nodeToCursor verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static XmlObject nodeToXmlObject(Node node) {
        try {
            return (XmlObject) _nodeToXmlObjectMethod.invoke(null, node);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to nodeToXmlObject verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static XMLStreamReader nodeToXmlStreamReader(Node node) {
        try {
            return (XMLStreamReader) _nodeToXmlStreamMethod.invoke(null, node);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to nodeToXmlStreamReader verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static Node streamToNode(XMLStreamReader xMLStreamReader) {
        try {
            return (Node) _streamToNodeMethod.invoke(null, xMLStreamReader);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to streamToNode verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static SchemaTypeLoader loadXsd(XmlObject[] xmlObjectArr) throws XmlException {
        return loadXsd(xmlObjectArr, null);
    }

    public static SchemaTypeLoader loadXsd(XmlObject[] xmlObjectArr, XmlOptions xmlOptions) throws XmlException {
        try {
            SchemaTypeSystem schemaTypeSystem = (SchemaTypeSystem) _compilationMethod.invoke(null, null, null, xmlObjectArr, null, getContextTypeLoader(), null, xmlOptions);
            if (schemaTypeSystem == null) {
                return null;
            }
            return typeLoaderUnion(new SchemaTypeLoader[]{schemaTypeSystem, getContextTypeLoader()});
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl.forSchemaXml(): verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            throw wrappedException(e2.getCause());
        }
    }

    public static SchemaTypeSystem compileXsd(XmlObject[] xmlObjectArr, SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) throws XmlException {
        return compileXmlBeans(null, null, xmlObjectArr, null, schemaTypeLoader, null, xmlOptions);
    }

    public static SchemaTypeSystem compileXsd(SchemaTypeSystem schemaTypeSystem, XmlObject[] xmlObjectArr, SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) throws XmlException {
        return compileXmlBeans(null, schemaTypeSystem, xmlObjectArr, null, schemaTypeLoader, null, xmlOptions);
    }

    public static SchemaTypeSystem compileXmlBeans(String str, SchemaTypeSystem schemaTypeSystem, XmlObject[] xmlObjectArr, BindingConfig bindingConfig, SchemaTypeLoader schemaTypeLoader, Filer filer, XmlOptions xmlOptions) throws XmlException {
        try {
            Method method = _compilationMethod;
            Object[] objArr = new Object[7];
            objArr[0] = str;
            objArr[1] = schemaTypeSystem;
            objArr[2] = xmlObjectArr;
            objArr[3] = bindingConfig;
            if (schemaTypeLoader == null) {
                schemaTypeLoader = getContextTypeLoader();
            }
            objArr[4] = schemaTypeLoader;
            objArr[5] = filer;
            objArr[6] = xmlOptions;
            return (SchemaTypeSystem) method.invoke(null, objArr);
        } catch (IllegalAccessException unused) {
            throw new IllegalStateException("No access to SchemaTypeLoaderImpl.forSchemaXml(): verify that version of xbean.jar is correct");
        } catch (InvocationTargetException e) {
            throw wrappedException(e.getCause());
        }
    }

    public static SchemaTypeLoader typeLoaderUnion(SchemaTypeLoader[] schemaTypeLoaderArr) {
        try {
            return schemaTypeLoaderArr.length == 1 ? schemaTypeLoaderArr[0] : (SchemaTypeLoader) _typeLoaderBuilderMethod.invoke(null, schemaTypeLoaderArr, null, null);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl: verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static SchemaTypeLoader typeLoaderForClassLoader(ClassLoader classLoader) {
        try {
            return (SchemaTypeLoader) _typeLoaderBuilderMethod.invoke(null, null, null, classLoader);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl: verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static SchemaTypeLoader typeLoaderForResource(ResourceLoader resourceLoader) {
        try {
            return (SchemaTypeLoader) _typeLoaderBuilderMethod.invoke(null, null, resourceLoader, null);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl: verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static SchemaTypeSystem typeSystemForClassLoader(ClassLoader classLoader, String str) {
        if (classLoader == null) {
            try {
                classLoader = Thread.currentThread().getContextClassLoader();
            } catch (ClassNotFoundException e) {
                throw causedException(new RuntimeException("Cannot load SchemaTypeSystem. Unable to load class with name " + str + ".TypeSystemHolder. Make sure the generated binary files are on the classpath."), e);
            } catch (IllegalAccessException e2) {
                throw causedException(new RuntimeException("Field typeSystem on class " + str + ".TypeSystemHolderis not accessible. Please verify the version of xbean.jar is correct."), e2);
            } catch (NoSuchFieldException e3) {
                throw causedException(new RuntimeException("Cannot find field typeSystem on class " + str + ".TypeSystemHolder. Please verify the version of xbean.jar is correct."), e3);
            }
        }
        SchemaTypeSystem schemaTypeSystem = (SchemaTypeSystem) classLoader.loadClass(str + ".TypeSystemHolder").getDeclaredField(TYPE_SYSTEM_FIELD).get(null);
        if (schemaTypeSystem != null) {
            return schemaTypeSystem;
        }
        throw new RuntimeException("SchemaTypeSystem is null for field typeSystem on class with name " + str + ".TypeSystemHolder. Please verify the version of xbean.jar is correct.");
    }

    public static ResourceLoader resourceLoaderForPath(File[] fileArr) {
        try {
            return (ResourceLoader) _pathResourceLoaderConstructor.newInstance(fileArr);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl: verify that version of xbean.jar is correct"), e);
        } catch (InstantiationException e2) {
            throw causedException(new IllegalStateException(e2.getMessage()), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static SchemaType typeForClass(Class cls) {
        if (cls != null && XmlObject.class.isAssignableFrom(cls)) {
            try {
                Field field = cls.getField("type");
                if (field == null) {
                    return null;
                }
                return (SchemaType) field.get(null);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static SchemaType getNoType() {
        try {
            return (SchemaType) _getNoTypeMethod.invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl.getContextTypeLoader(): verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    private XmlBeans() {
    }
}
