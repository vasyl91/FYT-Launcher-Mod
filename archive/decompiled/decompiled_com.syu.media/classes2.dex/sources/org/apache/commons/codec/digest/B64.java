package org.apache.commons.codec.digest;

import java.util.Random;
import kotlin.UByte;
import org.apache.poi.hpsf.Variant;
import org.apache.poi.ss.formula.ptg.UnionPtg;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
class B64 {
    static final String B64T = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    B64() {
    }

    static void b64from24bit(byte b, byte b2, byte b3, int i, StringBuilder sb) {
        int i2 = ((b << UnionPtg.sid) & 16777215) | ((b2 << 8) & Variant.VT_ILLEGAL) | (b3 & UByte.MAX_VALUE);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                return;
            }
            sb.append(B64T.charAt(i2 & 63));
            i2 >>= 6;
            i = i3;
        }
    }

    static String getRandomSalt(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 1; i2 <= i; i2++) {
            sb.append(B64T.charAt(new Random().nextInt(64)));
        }
        return sb.toString();
    }
}
