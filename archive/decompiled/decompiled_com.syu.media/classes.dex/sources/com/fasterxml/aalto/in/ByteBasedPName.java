package com.fasterxml.aalto.in;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class ByteBasedPName extends PName {
    protected final int mHash;

    public abstract boolean equals(int i, int i2);

    public abstract boolean equals(int[] iArr, int i);

    @Override // com.fasterxml.aalto.in.PName
    public abstract int getFirstQuad();

    @Override // com.fasterxml.aalto.in.PName
    public abstract int getQuad(int i);

    public abstract boolean hashEquals(int i, int i2, int i3);

    public abstract boolean hashEquals(int i, int[] iArr, int i2);

    @Override // com.fasterxml.aalto.in.PName
    public abstract int sizeInQuads();

    protected ByteBasedPName(String str, String str2, String str3, int i) {
        super(str, str2, str3);
        this.mHash = i;
    }

    @Override // com.fasterxml.aalto.in.PName
    public int hashCode() {
        return this.mHash;
    }
}
