package org.apache.xmlbeans.impl.common;

import java.lang.ref.SoftReference;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SoftCache {
    private HashMap map = new HashMap();

    public Object get(Object obj) {
        SoftReference softReference = (SoftReference) this.map.get(obj);
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public Object put(Object obj, Object obj2) {
        SoftReference softReference = (SoftReference) this.map.put(obj, new SoftReference(obj2));
        if (softReference == null) {
            return null;
        }
        Object obj3 = softReference.get();
        softReference.clear();
        return obj3;
    }

    public Object remove(Object obj) {
        SoftReference softReference = (SoftReference) this.map.remove(obj);
        if (softReference == null) {
            return null;
        }
        Object obj2 = softReference.get();
        softReference.clear();
        return obj2;
    }
}
