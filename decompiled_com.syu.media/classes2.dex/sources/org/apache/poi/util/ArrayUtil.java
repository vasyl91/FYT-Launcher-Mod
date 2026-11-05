package org.apache.poi.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ArrayUtil {
    public static void arraycopy(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (i < 0) {
            throw new IllegalArgumentException("src_position was less than 0.  Actual value " + i);
        }
        if (i >= bArr.length) {
            throw new IllegalArgumentException("src_position was greater than src array size.  Tried to write starting at position " + i + " but the array length is " + bArr.length);
        }
        int i4 = i + i3;
        if (i4 > bArr.length) {
            throw new IllegalArgumentException("src_position + length would overrun the src array.  Expected end at " + i4 + " actual end at " + bArr.length);
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("dst_position was less than 0.  Actual value " + i2);
        }
        if (i2 >= bArr2.length) {
            throw new IllegalArgumentException("dst_position was greater than dst array size.  Tried to write starting at position " + i2 + " but the array length is " + bArr2.length);
        }
        int i5 = i2 + i3;
        if (i5 > bArr2.length) {
            throw new IllegalArgumentException("dst_position + length would overrun the dst array.  Expected end at " + i5 + " actual end at " + bArr2.length);
        }
        System.arraycopy(bArr, i, bArr2, i2, i3);
    }

    public static void arrayMoveWithin(Object[] objArr, int i, int i2, int i3) {
        Object[] objArr2;
        if (i3 > 0 && i != i2) {
            if (i < 0 || i >= objArr.length) {
                throw new IllegalArgumentException("The moveFrom must be a valid array index");
            }
            if (i2 < 0 || i2 >= objArr.length) {
                throw new IllegalArgumentException("The moveTo must be a valid array index");
            }
            int i4 = i + i3;
            if (i4 > objArr.length) {
                throw new IllegalArgumentException("Asked to move more entries than the array has");
            }
            int i5 = i2 + i3;
            if (i5 > objArr.length) {
                throw new IllegalArgumentException("Asked to move to a position that doesn't have enough space");
            }
            Object[] objArr3 = new Object[i3];
            System.arraycopy(objArr, i, objArr3, 0, i3);
            if (i > i2) {
                int i6 = i - i2;
                objArr2 = new Object[i6];
                System.arraycopy(objArr, i2, objArr2, 0, i6);
                i = i5;
            } else {
                int i7 = i2 - i;
                Object[] objArr4 = new Object[i7];
                System.arraycopy(objArr, i4, objArr4, 0, i7);
                objArr2 = objArr4;
            }
            System.arraycopy(objArr3, 0, objArr, i2, i3);
            System.arraycopy(objArr2, 0, objArr, i, objArr2.length);
        }
    }
}
