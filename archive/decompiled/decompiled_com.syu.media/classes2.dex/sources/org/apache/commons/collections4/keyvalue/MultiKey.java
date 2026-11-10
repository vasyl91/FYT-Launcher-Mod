package org.apache.commons.collections4.keyvalue;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class MultiKey<K> implements Serializable {
    private static final long serialVersionUID = 4465448607415788805L;
    private transient int hashCode;
    private final K[] keys;

    public MultiKey(K k, K k2) {
        this(new Object[]{k, k2}, false);
    }

    public MultiKey(K k, K k2, K k3) {
        this(new Object[]{k, k2, k3}, false);
    }

    public MultiKey(K k, K k2, K k3, K k4) {
        this(new Object[]{k, k2, k3, k4}, false);
    }

    public MultiKey(K k, K k2, K k3, K k4, K k5) {
        this(new Object[]{k, k2, k3, k4, k5}, false);
    }

    public MultiKey(K[] kArr) {
        this((Object[]) kArr, true);
    }

    public MultiKey(K[] kArr, boolean z) {
        if (kArr == null) {
            throw new IllegalArgumentException("The array of keys must not be null");
        }
        if (z) {
            this.keys = (K[]) ((Object[]) kArr.clone());
        } else {
            this.keys = kArr;
        }
        calculateHashCode(kArr);
    }

    public K[] getKeys() {
        return (K[]) ((Object[]) this.keys.clone());
    }

    public K getKey(int i) {
        return this.keys[i];
    }

    public int size() {
        return this.keys.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MultiKey) {
            return Arrays.equals(this.keys, ((MultiKey) obj).keys);
        }
        return false;
    }

    public int hashCode() {
        return this.hashCode;
    }

    public String toString() {
        return "MultiKey" + Arrays.toString(this.keys);
    }

    private void calculateHashCode(Object[] objArr) {
        int iHashCode = 0;
        for (Object obj : objArr) {
            if (obj != null) {
                iHashCode ^= obj.hashCode();
            }
        }
        this.hashCode = iHashCode;
    }

    protected Object readResolve() {
        calculateHashCode(this.keys);
        return this;
    }
}
