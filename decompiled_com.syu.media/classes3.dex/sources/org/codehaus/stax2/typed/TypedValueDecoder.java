package org.codehaus.stax2.typed;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class TypedValueDecoder {
    public abstract void decode(String str) throws IllegalArgumentException;

    public abstract void decode(char[] cArr, int i, int i2) throws IllegalArgumentException;

    public abstract void handleEmptyValue() throws IllegalArgumentException;
}
