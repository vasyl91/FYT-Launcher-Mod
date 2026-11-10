package com.fasterxml.aalto.in;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class PName1 extends ByteBasedPName {
    final int mQuad;

    @Override // com.fasterxml.aalto.in.ByteBasedPName, com.fasterxml.aalto.in.PName
    public int sizeInQuads() {
        return 1;
    }

    public PName1(String str, String str2, String str3, int i, int i2) {
        super(str, str2, str3, i);
        this.mQuad = i2;
    }

    @Override // com.fasterxml.aalto.in.PName
    public PName createBoundName(NsBinding nsBinding) {
        PName1 pName1 = new PName1(this._prefixedName, this._prefix, this._localName, this.mHash, this.mQuad);
        pName1._namespaceBinding = nsBinding;
        return pName1;
    }

    @Override // com.fasterxml.aalto.in.ByteBasedPName
    public boolean equals(int i, int i2) {
        return i == this.mQuad && i2 == 0;
    }

    @Override // com.fasterxml.aalto.in.ByteBasedPName
    public boolean equals(int[] iArr, int i) {
        return i == 1 && iArr[0] == this.mQuad;
    }

    @Override // com.fasterxml.aalto.in.ByteBasedPName
    public boolean hashEquals(int i, int i2, int i3) {
        return i == this.mHash && i2 == this.mQuad && i3 == 0;
    }

    @Override // com.fasterxml.aalto.in.ByteBasedPName
    public boolean hashEquals(int i, int[] iArr, int i2) {
        return i == this.mHash && i2 == 1 && iArr[0] == this.mQuad;
    }

    @Override // com.fasterxml.aalto.in.ByteBasedPName, com.fasterxml.aalto.in.PName
    public int getFirstQuad() {
        return this.mQuad;
    }

    @Override // com.fasterxml.aalto.in.PName
    public final int getLastQuad() {
        return this.mQuad;
    }

    @Override // com.fasterxml.aalto.in.ByteBasedPName, com.fasterxml.aalto.in.PName
    public int getQuad(int i) {
        if (i == 0) {
            return this.mQuad;
        }
        return 0;
    }
}
