package org.apache.poi.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface LittleEndianOutput {
    void write(byte[] bArr);

    void write(byte[] bArr, int i, int i2);

    void writeByte(int i);

    void writeDouble(double d);

    void writeInt(int i);

    void writeLong(long j);

    void writeShort(int i);
}
