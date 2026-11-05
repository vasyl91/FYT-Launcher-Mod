package org.apache.xmlbeans.impl.store;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.impl.common.XPath;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class PathDelegate {
    private static HashMap _constructors = new HashMap();

    public interface SelectPathInterface {
        List selectPath(Object obj);
    }

    private PathDelegate() {
    }

    private static synchronized void init(String str) {
        boolean z;
        if (str == null) {
            str = "org.apache.xmlbeans.impl.xpath.saxon.XBeansXPath";
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
                _constructors.put(str, cls.getConstructor(String.class, String.class, Map.class, String.class));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static synchronized SelectPathInterface createInstance(String str, String str2, String str3, Map map) {
        if (_constructors.get(str) == null) {
            init(str);
        }
        if (_constructors.get(str) == null) {
            return null;
        }
        Constructor constructor = (Constructor) _constructors.get(str);
        try {
            Object obj = map.get(XPath._DEFAULT_ELT_NS);
            if (obj != null) {
                map.remove(XPath._DEFAULT_ELT_NS);
            }
            return (SelectPathInterface) constructor.newInstance(str2, str3, map, (String) obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
