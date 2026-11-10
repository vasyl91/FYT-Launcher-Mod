package org.apache.xmlbeans.impl.config;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class NameSet {
    public static NameSet EMPTY = new NameSet(true, Collections.EMPTY_SET);
    public static NameSet EVERYTHING = new NameSet(false, Collections.EMPTY_SET);
    private Set _finiteSet;
    private boolean _isFinite;

    private NameSet(boolean z, Set set) {
        this._isFinite = z;
        this._finiteSet = set;
    }

    static NameSet newInstance(boolean z, Set set) {
        if (set.size() == 0) {
            if (z) {
                return EMPTY;
            }
            return EVERYTHING;
        }
        HashSet hashSet = new HashSet();
        hashSet.addAll(set);
        return new NameSet(z, hashSet);
    }

    private static Set intersectFiniteSets(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        while (set.iterator().hasNext()) {
            String str = (String) set.iterator().next();
            if (set2.contains(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public NameSet union(NameSet nameSet) {
        if (this._isFinite) {
            if (nameSet._isFinite) {
                HashSet hashSet = new HashSet();
                hashSet.addAll(this._finiteSet);
                hashSet.addAll(nameSet._finiteSet);
                return newInstance(true, hashSet);
            }
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(nameSet._finiteSet);
            hashSet2.removeAll(this._finiteSet);
            return newInstance(false, hashSet2);
        }
        if (nameSet._isFinite) {
            HashSet hashSet3 = new HashSet();
            hashSet3.addAll(this._finiteSet);
            hashSet3.removeAll(nameSet._finiteSet);
            return newInstance(false, hashSet3);
        }
        return newInstance(false, intersectFiniteSets(this._finiteSet, nameSet._finiteSet));
    }

    public NameSet intersect(NameSet nameSet) {
        if (this._isFinite) {
            if (nameSet._isFinite) {
                return newInstance(true, intersectFiniteSets(this._finiteSet, nameSet._finiteSet));
            }
            HashSet hashSet = new HashSet();
            hashSet.addAll(this._finiteSet);
            hashSet.removeAll(nameSet._finiteSet);
            return newInstance(false, hashSet);
        }
        if (nameSet._isFinite) {
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(nameSet._finiteSet);
            hashSet2.removeAll(this._finiteSet);
            return newInstance(true, hashSet2);
        }
        HashSet hashSet3 = new HashSet();
        hashSet3.addAll(this._finiteSet);
        hashSet3.addAll(nameSet._finiteSet);
        return newInstance(false, hashSet3);
    }

    public NameSet substractFrom(NameSet nameSet) {
        return nameSet.substract(this);
    }

    public NameSet substract(NameSet nameSet) {
        if (this._isFinite) {
            if (nameSet._isFinite) {
                HashSet hashSet = new HashSet();
                hashSet.addAll(this._finiteSet);
                hashSet.removeAll(nameSet._finiteSet);
                return newInstance(true, hashSet);
            }
            return newInstance(true, intersectFiniteSets(this._finiteSet, nameSet._finiteSet));
        }
        if (nameSet._isFinite) {
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(this._finiteSet);
            hashSet2.addAll(nameSet._finiteSet);
            return newInstance(false, hashSet2);
        }
        HashSet hashSet3 = new HashSet();
        hashSet3.addAll(nameSet._finiteSet);
        hashSet3.removeAll(this._finiteSet);
        return newInstance(true, hashSet3);
    }

    public NameSet invert() {
        return newInstance(!this._isFinite, this._finiteSet);
    }

    public boolean contains(String str) {
        if (this._isFinite) {
            return this._finiteSet.contains(str);
        }
        return !this._finiteSet.contains(str);
    }
}
