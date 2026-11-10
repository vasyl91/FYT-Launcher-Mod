package org.apache.poi.sl.image;

import java.awt.Dimension;
import java.awt.Rectangle;
import kotlin.UByte;
import org.apache.poi.ss.formula.ptg.RangePtg;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class ImageHeaderPICT {
    public static final double DEFAULT_RESOLUTION = 72.0d;
    public static final int PICT_HEADER_OFFSET = 512;
    private static final byte[] V2_HEADER = {0, RangePtg.sid, 2, -1, 12, 0, -1, -2, 0, 0};
    private final Rectangle bounds;
    private final double hRes;
    private final double vRes;

    public ImageHeaderPICT(byte[] bArr, int i) {
        int i2 = i + 2;
        int unsignedShort = readUnsignedShort(bArr, i2);
        int i3 = i2 + 2;
        int unsignedShort2 = readUnsignedShort(bArr, i3);
        int i4 = i3 + 2;
        int unsignedShort3 = readUnsignedShort(bArr, i4);
        int i5 = i4 + 2;
        int unsignedShort4 = readUnsignedShort(bArr, i5);
        int i6 = i5 + 2;
        byte[] bArr2 = V2_HEADER;
        int length = bArr2.length;
        boolean z = false;
        int i7 = 0;
        while (true) {
            if (i7 >= length) {
                z = true;
                break;
            }
            int i8 = i6 + 1;
            if (bArr2[i7] != bArr[i6]) {
                i6 = i8;
                break;
            } else {
                i7++;
                i6 = i8;
            }
        }
        if (z) {
            this.hRes = readFixedPoint(bArr, i6);
            this.vRes = readFixedPoint(bArr, i6 + 4);
        } else {
            this.hRes = 72.0d;
            this.vRes = 72.0d;
        }
        this.bounds = new Rectangle(unsignedShort2, unsignedShort, unsignedShort4 - unsignedShort2, unsignedShort3 - unsignedShort);
    }

    public Dimension getSize() {
        return new Dimension((int) Math.round((((double) this.bounds.width) * 72.0d) / this.hRes), (int) Math.round((((double) this.bounds.height) * 72.0d) / this.vRes));
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    private static int readUnsignedShort(byte[] bArr, int i) {
        return (bArr[i + 1] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 8);
    }

    private static double readFixedPoint(byte[] bArr, int i) {
        return ((double) ((bArr[i + 3] & UByte.MAX_VALUE) | ((((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i + 1] & UByte.MAX_VALUE) << 16)) | ((bArr[i + 2] & UByte.MAX_VALUE) << 8)))) / 65536.0d;
    }
}
