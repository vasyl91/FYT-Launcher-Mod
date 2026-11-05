package org.apache.poi.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface LittleEndianInput {
    int available();

    byte readByte();

    double readDouble();

    void readFully(byte[] bArr);

    void readFully(byte[] bArr, int i, int i2);

    int readInt();

    long readLong();

    void readPlain(byte[] bArr, int i, int i2);

    short readShort();

    int readUByte();

    int readUShort();
}
