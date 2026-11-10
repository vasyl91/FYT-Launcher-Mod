package com.fasterxml.aalto.in;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class ElementScope {
    PName mName;
    ElementScope mParent;

    public ElementScope(PName pName, ElementScope elementScope) {
        this.mParent = elementScope;
        this.mName = pName;
    }

    public PName getName() {
        return this.mName;
    }

    public ElementScope getParent() {
        return this.mParent;
    }

    public String toString() {
        if (this.mParent == null) {
            return this.mName.toString();
        }
        return this.mParent.toString() + "/" + this.mName;
    }
}
