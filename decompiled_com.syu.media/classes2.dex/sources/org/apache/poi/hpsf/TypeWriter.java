package org.apache.poi.hpsf;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Removal(version = "3.18")
@Deprecated
public class TypeWriter {
    public static int writeToStream(OutputStream outputStream, short s) throws IOException {
        LittleEndian.putShort(outputStream, s);
        return 2;
    }

    public static int writeToStream(OutputStream outputStream, int i) throws IOException {
        LittleEndian.putInt(i, outputStream);
        return 4;
    }

    public static int writeToStream(OutputStream outputStream, long j) throws IOException {
        LittleEndian.putLong(j, outputStream);
        return 8;
    }

    public static void writeUShortToStream(OutputStream outputStream, int i) throws IOException {
        if (((-65536) & i) != 0) {
            throw new IllegalPropertySetDataException("Value " + i + " cannot be represented by 2 bytes.");
        }
        LittleEndian.putUShort(i, outputStream);
    }

    public static int writeUIntToStream(OutputStream outputStream, long j) throws IOException {
        long j2 = j & (-4294967296L);
        if (j2 != 0 && j2 != -4294967296L) {
            throw new IllegalPropertySetDataException("Value " + j + " cannot be represented by 4 bytes.");
        }
        LittleEndian.putUInt(j, outputStream);
        return 4;
    }

    public static int writeToStream(OutputStream outputStream, ClassID classID) throws IOException {
        byte[] bArr = new byte[16];
        classID.write(bArr, 0);
        outputStream.write(bArr, 0, 16);
        return 16;
    }

    public static void writeToStream(OutputStream outputStream, Property[] propertyArr, int i) throws IOException, UnsupportedVariantTypeException {
        if (propertyArr == null) {
            return;
        }
        for (Property property : propertyArr) {
            writeUIntToStream(outputStream, property.getID());
            writeUIntToStream(outputStream, property.getSize(i));
        }
        for (Property property2 : propertyArr) {
            long type = property2.getType();
            writeUIntToStream(outputStream, type);
            VariantSupport.write(outputStream, (int) type, property2.getValue(), i);
        }
    }

    public static int writeToStream(OutputStream outputStream, double d) throws IOException {
        LittleEndian.putDouble(d, outputStream);
        return 8;
    }
}
