package org.apache.xmlbeans.impl.common;

import java.lang.ref.SoftReference;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SystemProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SystemCache {
    private static SystemCache INSTANCE;
    private ThreadLocal tl_saxLoaders = new ThreadLocal();

    public void addToTypeLoaderCache(SchemaTypeLoader schemaTypeLoader, ClassLoader classLoader) {
    }

    public SchemaTypeLoader getFromTypeLoaderCache(ClassLoader classLoader) {
        return null;
    }

    static {
        Object objNewInstance;
        INSTANCE = new SystemCache();
        String property = SystemProperties.getProperty("xmlbean.systemcacheimpl");
        if (property != null) {
            try {
                objNewInstance = Class.forName(property).newInstance();
                if (!(objNewInstance instanceof SystemCache)) {
                    throw new ClassCastException("Value for system property \"xmlbean.systemcacheimpl\" points to a class (" + property + ") which does not derive from SystemCache");
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Cache class " + property + " specified by \"xmlbean.systemcacheimpl\" was not found.", e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Could not instantiate class " + property + " as specified by \"xmlbean.systemcacheimpl\". A public empty constructor may be missing.", e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Could not instantiate class " + property + " as specified by \"xmlbean.systemcacheimpl\". An empty constructor may be missing.", e3);
            }
        } else {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            INSTANCE = (SystemCache) objNewInstance;
        }
    }

    public static final synchronized void set(SystemCache systemCache) {
        INSTANCE = systemCache;
    }

    public static final SystemCache get() {
        return INSTANCE;
    }

    public void clearThreadLocals() {
        this.tl_saxLoaders.remove();
    }

    public Object getSaxLoader() {
        SoftReference softReference = (SoftReference) this.tl_saxLoaders.get();
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public void setSaxLoader(Object obj) {
        this.tl_saxLoaders.set(new SoftReference(obj));
    }
}
