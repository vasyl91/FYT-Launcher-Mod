package com.fasterxml.aalto.in;

import com.fasterxml.aalto.impl.ErrorConsts;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class PNameC extends PName {
    protected final int mHash;

    public PNameC(String str, String str2, String str3, int i) {
        super(str, str2, str3);
        this.mHash = i;
    }

    @Override // com.fasterxml.aalto.in.PName
    public PName createBoundName(NsBinding nsBinding) {
        PNameC pNameC = new PNameC(this._prefixedName, this._prefix, this._localName, this.mHash);
        pNameC._namespaceBinding = nsBinding;
        return pNameC;
    }

    public static PNameC construct(String str) {
        return construct(str, calcHash(str));
    }

    public static PNameC construct(String str, int i) {
        int iIndexOf = str.indexOf(58);
        if (iIndexOf < 0) {
            return new PNameC(str, null, str, i);
        }
        return new PNameC(str, str.substring(0, iIndexOf).intern(), str.substring(iIndexOf + 1).intern(), i);
    }

    public boolean equalsPName(char[] cArr, int i, int i2, int i3) {
        if (i3 != this.mHash) {
            return false;
        }
        String str = this._prefixedName;
        if (i2 != str.length()) {
            return false;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            if (cArr[i + i4] != str.charAt(i4)) {
                return false;
            }
        }
        return true;
    }

    public int getCustomHash() {
        return this.mHash;
    }

    public static int calcHash(char[] cArr, int i, int i2) {
        int i3 = 1;
        int i4 = cArr[0];
        while (i3 < i2) {
            int i5 = (i4 * 31) + cArr[i3];
            i3++;
            i4 = i5;
        }
        return i4;
    }

    public static int calcHash(String str) {
        int iCharAt = str.charAt(0);
        int length = str.length();
        for (int i = 1; i < length; i++) {
            iCharAt = (iCharAt * 31) + str.charAt(i);
        }
        return iCharAt;
    }

    @Override // com.fasterxml.aalto.in.PName
    public int sizeInQuads() {
        ErrorConsts.throwInternalError();
        return 0;
    }

    @Override // com.fasterxml.aalto.in.PName
    public int getFirstQuad() {
        ErrorConsts.throwInternalError();
        return 0;
    }

    @Override // com.fasterxml.aalto.in.PName
    public final int getLastQuad() {
        ErrorConsts.throwInternalError();
        return 0;
    }

    @Override // com.fasterxml.aalto.in.PName
    public int getQuad(int i) {
        ErrorConsts.throwInternalError();
        return 0;
    }

    @Override // com.fasterxml.aalto.in.PName
    public int hashCode() {
        return this.mHash;
    }
}
