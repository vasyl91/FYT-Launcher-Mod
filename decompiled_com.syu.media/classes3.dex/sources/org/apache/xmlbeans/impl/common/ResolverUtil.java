package org.apache.xmlbeans.impl.common;

import org.apache.xmlbeans.SystemProperties;
import org.xml.sax.EntityResolver;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ResolverUtil {
    private static EntityResolver _entityResolver;

    static {
        try {
            String property = SystemProperties.getProperty("xmlbean.entityResolver");
            if (property != null) {
                _entityResolver = (EntityResolver) Class.forName(property).newInstance();
            }
        } catch (Exception unused) {
            _entityResolver = null;
        }
    }

    public static EntityResolver getGlobalEntityResolver() {
        return _entityResolver;
    }

    public static EntityResolver resolverForCatalog(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("org.apache.xml.resolver.CatalogManager");
            Object objNewInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            cls.getMethod("setCatalogFiles", String.class).invoke(objNewInstance, str);
            return (EntityResolver) Class.forName("org.apache.xml.resolver.tools.CatalogResolver").getConstructor(cls).newInstance(objNewInstance);
        } catch (Exception unused) {
            return null;
        }
    }
}
