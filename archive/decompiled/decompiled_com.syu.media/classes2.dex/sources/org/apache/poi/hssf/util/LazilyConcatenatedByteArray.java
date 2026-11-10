package org.apache.poi.hssf.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class LazilyConcatenatedByteArray {
    private final List<byte[]> arrays = new ArrayList(1);

    public void clear() {
        this.arrays.clear();
    }

    public void concatenate(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("array cannot be null");
        }
        this.arrays.add(bArr);
    }

    public byte[] toArray() {
        if (this.arrays.isEmpty()) {
            return null;
        }
        if (this.arrays.size() > 1) {
            Iterator<byte[]> it = this.arrays.iterator();
            int length = 0;
            while (it.hasNext()) {
                length += it.next().length;
            }
            byte[] bArr = new byte[length];
            int length2 = 0;
            for (byte[] bArr2 : this.arrays) {
                System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
                length2 += bArr2.length;
            }
            this.arrays.clear();
            this.arrays.add(bArr);
        }
        return this.arrays.get(0);
    }
}
