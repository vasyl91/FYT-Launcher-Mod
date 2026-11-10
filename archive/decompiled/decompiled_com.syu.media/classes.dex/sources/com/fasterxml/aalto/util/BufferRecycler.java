package com.fasterxml.aalto.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class BufferRecycler {
    private volatile char[] mSmallCBuffer = null;
    private volatile char[] mMediumCBuffer = null;
    private volatile char[] mFullCBuffer = null;
    private volatile byte[] mFullBBuffer = null;

    public synchronized char[] getSmallCBuffer(int i) {
        char[] cArr = this.mSmallCBuffer;
        if (cArr == null || cArr.length < i) {
            return null;
        }
        this.mSmallCBuffer = null;
        return cArr;
    }

    public synchronized void returnSmallCBuffer(char[] cArr) {
        this.mSmallCBuffer = cArr;
    }

    public synchronized char[] getMediumCBuffer(int i) {
        char[] cArr = this.mMediumCBuffer;
        if (cArr == null || cArr.length < i) {
            return null;
        }
        this.mMediumCBuffer = null;
        return cArr;
    }

    public synchronized void returnMediumCBuffer(char[] cArr) {
        this.mMediumCBuffer = cArr;
    }

    public synchronized char[] getFullCBuffer(int i) {
        char[] cArr = this.mFullCBuffer;
        if (cArr == null || cArr.length < i) {
            return null;
        }
        this.mFullCBuffer = null;
        return cArr;
    }

    public synchronized void returnFullCBuffer(char[] cArr) {
        this.mFullCBuffer = cArr;
    }

    public synchronized byte[] getFullBBuffer(int i) {
        byte[] bArr = this.mFullBBuffer;
        if (bArr == null || bArr.length < i) {
            return null;
        }
        this.mFullBBuffer = null;
        return bArr;
    }

    public synchronized void returnFullBBuffer(byte[] bArr) {
        this.mFullBBuffer = bArr;
    }
}
