package org.apache.xmlbeans.impl.config;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class NameSetBuilder {
    private boolean _isFinite = true;
    private Set _finiteSet = new HashSet();

    public void invert() {
        this._isFinite = !this._isFinite;
    }

    public void add(String str) {
        if (this._isFinite) {
            this._finiteSet.add(str);
        } else {
            this._finiteSet.remove(str);
        }
    }

    public NameSet toNameSet() {
        if (this._finiteSet.size() == 0) {
            if (this._isFinite) {
                return NameSet.EMPTY;
            }
            return NameSet.EVERYTHING;
        }
        return NameSet.newInstance(this._isFinite, this._finiteSet);
    }
}
