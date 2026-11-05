package com.fasterxml.aalto.in;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class PName2 extends ByteBasedPName {
    final int mQuad1;
    final int mQuad2;

    @Override // com.fasterxml.aalto.in.ByteBasedPName, com.fasterxml.aalto.in.PName
    public int sizeInQuads() {
        return 2;
    }

    public PName2(String str, String str2, String str3, int i, int i2, int i3) {
        super(str, str2, str3, i);
        this.mQuad1 = i2;
        this.mQuad2 = i3;
    }

    @Override // com.fasterxml.aalto.in.PName
    public PName createBoundName(NsBinding nsBinding) {
        PName2 pName2 = new PName2(this._prefixedName, this._prefix, this._localName, this.mHash, this.mQuad1, this.mQuad2);
        pName2._namespaceBinding = nsBinding;
        return pName2;
    }

    @Override // com.fasterxml.aalto.in.ByteBasedPName
    public boolean equals(int i, int i2) {
        return i == this.mQuad1 && i2 == this.mQuad2;
    }

    @Override // com.fasterxml.aalto.in.ByteBasedPName
    public boolean equals(int[] iArr, int i) {
        return i == 2 && iArr[0] == this.mQuad1 && iArr[1] == this.mQuad2;
    }

    @Override // com.fasterxml.aalto.in.ByteBasedPName
    public boolean hashEquals(int i, int i2, int i3) {
        return i == this.mHash && i2 == this.mQuad1 && i3 == this.mQuad2;
    }

    @Override // com.fasterxml.aalto.in.ByteBasedPName
    public boolean hashEquals(int i, int[] iArr, int i2) {
        return i == this.mHash && i2 == 2 && iArr[0] == this.mQuad1 && iArr[1] == this.mQuad2;
    }

    @Override // com.fasterxml.aalto.in.ByteBasedPName, com.fasterxml.aalto.in.PName
    public int getFirstQuad() {
        return this.mQuad1;
    }

    @Override // com.fasterxml.aalto.in.PName
    public int getLastQuad() {
        return this.mQuad2;
    }

    @Override // com.fasterxml.aalto.in.ByteBasedPName, com.fasterxml.aalto.in.PName
    public int getQuad(int i) {
        return i == 0 ? this.mQuad1 : this.mQuad2;
    }
}
