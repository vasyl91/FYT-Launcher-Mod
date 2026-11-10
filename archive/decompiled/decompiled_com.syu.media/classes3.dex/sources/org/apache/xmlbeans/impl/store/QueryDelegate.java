package org.apache.xmlbeans.impl.store;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class QueryDelegate {
    private static final Map<String, Constructor<? extends QueryInterface>> _constructors = new HashMap();

    public interface QueryInterface {
        List execQuery(Object obj, Map map);
    }

    private QueryDelegate() {
    }

    private static synchronized void init(String str) {
        boolean z;
        if (str == null) {
            str = "org.apache.xmlbeans.impl.xquery.saxon.XBeansXQuery";
        }
        Class<?> cls = null;
        try {
            cls = Class.forName(str);
            z = true;
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            z = false;
        }
        if (z) {
            try {
                _constructors.put(str, (Constructor<? extends QueryInterface>) cls.getConstructor(String.class, String.class, Integer.class, XmlOptions.class));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static synchronized QueryInterface createInstance(String str, String str2, String str3, int i, XmlOptions xmlOptions) {
        Map<String, Constructor<? extends QueryInterface>> map = _constructors;
        if (map.get(str) == null) {
            init(str);
        }
        if (map.get(str) == null) {
            return null;
        }
        try {
            return map.get(str).newInstance(str2, str3, Integer.valueOf(i), xmlOptions);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
