package org.apache.poi.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class LZWDecompresser {
    private final int codeLengthIncrease;
    private final boolean maskMeansCompressed;
    private final boolean positionIsBigEndian;

    public static int fromByte(byte b) {
        return b >= 0 ? b : b + 256;
    }

    public static byte fromInt(int i) {
        return i < 128 ? (byte) i : (byte) (i - 256);
    }

    protected abstract int adjustDictionaryOffset(int i);

    protected abstract int populateDictionary(byte[] bArr);

    protected LZWDecompresser(boolean z, int i, boolean z2) {
        this.maskMeansCompressed = z;
        this.codeLengthIncrease = i;
        this.positionIsBigEndian = z2;
    }

    public byte[] decompress(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        decompress(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public void decompress(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i;
        byte[] bArr = new byte[4096];
        int iPopulateDictionary = populateDictionary(bArr);
        byte[] bArr2 = new byte[this.codeLengthIncrease + 16];
        while (true) {
            int i2 = inputStream.read();
            if (i2 == -1) {
                return;
            }
            for (int i3 = 1; i3 < 256; i3 <<= 1) {
                if (((i2 & i3) > 0) ^ this.maskMeansCompressed) {
                    int i4 = inputStream.read();
                    if (i4 != -1) {
                        bArr[iPopulateDictionary & 4095] = fromInt(i4);
                        iPopulateDictionary++;
                        outputStream.write(new byte[]{fromInt(i4)});
                    }
                } else {
                    int i5 = inputStream.read();
                    int i6 = inputStream.read();
                    if (i5 == -1 || i6 == -1) {
                        break;
                    }
                    int i7 = (i6 & 15) + this.codeLengthIncrease;
                    if (this.positionIsBigEndian) {
                        i5 <<= 4;
                        i = i6 >> 4;
                    } else {
                        i = (i6 & 240) << 4;
                    }
                    int iAdjustDictionaryOffset = adjustDictionaryOffset(i5 + i);
                    for (int i8 = 0; i8 < i7; i8++) {
                        byte b = bArr[(iAdjustDictionaryOffset + i8) & 4095];
                        bArr2[i8] = b;
                        bArr[(iPopulateDictionary + i8) & 4095] = b;
                    }
                    outputStream.write(bArr2, 0, i7);
                    iPopulateDictionary += i7;
                }
            }
        }
    }
}
