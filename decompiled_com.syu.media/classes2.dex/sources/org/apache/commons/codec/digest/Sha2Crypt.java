package org.apache.commons.codec.digest;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.UByte;
import org.apache.commons.codec.Charsets;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Sha2Crypt {
    private static final int ROUNDS_DEFAULT = 5000;
    private static final int ROUNDS_MAX = 999999999;
    private static final int ROUNDS_MIN = 1000;
    private static final String ROUNDS_PREFIX = "rounds=";
    private static final Pattern SALT_PATTERN = Pattern.compile("^\\$([56])\\$(rounds=(\\d+)\\$)?([\\.\\/a-zA-Z0-9]{1,16}).*");
    private static final int SHA256_BLOCKSIZE = 32;
    static final String SHA256_PREFIX = "$5$";
    private static final int SHA512_BLOCKSIZE = 64;
    static final String SHA512_PREFIX = "$6$";

    public static String sha256Crypt(byte[] bArr) {
        return sha256Crypt(bArr, null);
    }

    public static String sha256Crypt(byte[] bArr, String str) {
        if (str == null) {
            str = SHA256_PREFIX + B64.getRandomSalt(8);
        }
        return sha2Crypt(bArr, str, SHA256_PREFIX, 32, MessageDigestAlgorithms.SHA_256);
    }

    private static String sha2Crypt(byte[] bArr, String str, String str2, int i, String str3) {
        int iMax;
        boolean z;
        byte b;
        int i2;
        int length = bArr.length;
        if (str == null) {
            throw new IllegalArgumentException("Salt must not be null");
        }
        Matcher matcher = SALT_PATTERN.matcher(str);
        if (matcher == null || !matcher.find()) {
            throw new IllegalArgumentException("Invalid salt value: " + str);
        }
        if (matcher.group(3) != null) {
            iMax = Math.max(1000, Math.min(ROUNDS_MAX, Integer.parseInt(matcher.group(3))));
            z = true;
        } else {
            iMax = ROUNDS_DEFAULT;
            z = false;
        }
        String strGroup = matcher.group(4);
        byte[] bytes = strGroup.getBytes(Charsets.UTF_8);
        int length2 = bytes.length;
        MessageDigest digest = DigestUtils.getDigest(str3);
        digest.update(bArr);
        digest.update(bytes);
        MessageDigest digest2 = DigestUtils.getDigest(str3);
        digest2.update(bArr);
        digest2.update(bytes);
        digest2.update(bArr);
        byte[] bArrDigest = digest2.digest();
        int length3 = bArr.length;
        while (length3 > i) {
            digest.update(bArrDigest, 0, i);
            length3 -= i;
        }
        digest.update(bArrDigest, 0, length3);
        for (int length4 = bArr.length; length4 > 0; length4 >>= 1) {
            if ((length4 & 1) != 0) {
                digest.update(bArrDigest, 0, i);
            } else {
                digest.update(bArr);
            }
        }
        byte[] bArrDigest2 = digest.digest();
        MessageDigest digest3 = DigestUtils.getDigest(str3);
        for (int i3 = 1; i3 <= length; i3++) {
            digest3.update(bArr);
        }
        byte[] bArrDigest3 = digest3.digest();
        byte[] bArr2 = new byte[length];
        int i4 = 0;
        while (i4 < length - i) {
            System.arraycopy(bArrDigest3, 0, bArr2, i4, i);
            i4 += i;
        }
        System.arraycopy(bArrDigest3, 0, bArr2, i4, length - i4);
        MessageDigest digest4 = DigestUtils.getDigest(str3);
        for (int i5 = 1; i5 <= (bArrDigest2[0] & UByte.MAX_VALUE) + 16; i5++) {
            digest4.update(bytes);
        }
        byte[] bArrDigest4 = digest4.digest();
        byte[] bArr3 = new byte[length2];
        int i6 = 0;
        while (i6 < length2 - i) {
            System.arraycopy(bArrDigest4, 0, bArr3, i6, i);
            i6 += i;
        }
        System.arraycopy(bArrDigest4, 0, bArr3, i6, length2 - i6);
        int i7 = 0;
        MessageDigest digest5 = digest;
        while (i7 <= iMax - 1) {
            digest5 = DigestUtils.getDigest(str3);
            int i8 = i7 & 1;
            if (i8 != 0) {
                i2 = 0;
                digest5.update(bArr2, 0, length);
            } else {
                i2 = 0;
                digest5.update(bArrDigest2, 0, i);
            }
            if (i7 % 3 != 0) {
                digest5.update(bArr3, i2, length2);
            }
            if (i7 % 7 != 0) {
                digest5.update(bArr2, i2, length);
            }
            if (i8 != 0) {
                digest5.update(bArrDigest2, i2, i);
            } else {
                digest5.update(bArr2, i2, length);
            }
            bArrDigest2 = digest5.digest();
            i7++;
            bytes = bytes;
        }
        byte[] bArr4 = bytes;
        StringBuilder sb = new StringBuilder(str2);
        if (z) {
            sb.append(ROUNDS_PREFIX);
            sb.append(iMax);
            sb.append("$");
        }
        sb.append(strGroup);
        sb.append("$");
        if (i == 32) {
            B64.b64from24bit(bArrDigest2[0], bArrDigest2[10], bArrDigest2[20], 4, sb);
            B64.b64from24bit(bArrDigest2[21], bArrDigest2[1], bArrDigest2[11], 4, sb);
            B64.b64from24bit(bArrDigest2[12], bArrDigest2[22], bArrDigest2[2], 4, sb);
            B64.b64from24bit(bArrDigest2[3], bArrDigest2[13], bArrDigest2[23], 4, sb);
            B64.b64from24bit(bArrDigest2[24], bArrDigest2[4], bArrDigest2[14], 4, sb);
            B64.b64from24bit(bArrDigest2[15], bArrDigest2[25], bArrDigest2[5], 4, sb);
            B64.b64from24bit(bArrDigest2[6], bArrDigest2[16], bArrDigest2[26], 4, sb);
            B64.b64from24bit(bArrDigest2[27], bArrDigest2[7], bArrDigest2[17], 4, sb);
            B64.b64from24bit(bArrDigest2[18], bArrDigest2[28], bArrDigest2[8], 4, sb);
            B64.b64from24bit(bArrDigest2[9], bArrDigest2[19], bArrDigest2[29], 4, sb);
            B64.b64from24bit((byte) 0, bArrDigest2[31], bArrDigest2[30], 3, sb);
            b = 0;
        } else {
            B64.b64from24bit(bArrDigest2[0], bArrDigest2[21], bArrDigest2[42], 4, sb);
            B64.b64from24bit(bArrDigest2[22], bArrDigest2[43], bArrDigest2[1], 4, sb);
            B64.b64from24bit(bArrDigest2[44], bArrDigest2[2], bArrDigest2[23], 4, sb);
            B64.b64from24bit(bArrDigest2[3], bArrDigest2[24], bArrDigest2[45], 4, sb);
            B64.b64from24bit(bArrDigest2[25], bArrDigest2[46], bArrDigest2[4], 4, sb);
            B64.b64from24bit(bArrDigest2[47], bArrDigest2[5], bArrDigest2[26], 4, sb);
            B64.b64from24bit(bArrDigest2[6], bArrDigest2[27], bArrDigest2[48], 4, sb);
            B64.b64from24bit(bArrDigest2[28], bArrDigest2[49], bArrDigest2[7], 4, sb);
            B64.b64from24bit(bArrDigest2[50], bArrDigest2[8], bArrDigest2[29], 4, sb);
            B64.b64from24bit(bArrDigest2[9], bArrDigest2[30], bArrDigest2[51], 4, sb);
            B64.b64from24bit(bArrDigest2[31], bArrDigest2[52], bArrDigest2[10], 4, sb);
            B64.b64from24bit(bArrDigest2[53], bArrDigest2[11], bArrDigest2[32], 4, sb);
            B64.b64from24bit(bArrDigest2[12], bArrDigest2[33], bArrDigest2[54], 4, sb);
            B64.b64from24bit(bArrDigest2[34], bArrDigest2[55], bArrDigest2[13], 4, sb);
            B64.b64from24bit(bArrDigest2[56], bArrDigest2[14], bArrDigest2[35], 4, sb);
            B64.b64from24bit(bArrDigest2[15], bArrDigest2[36], bArrDigest2[57], 4, sb);
            B64.b64from24bit(bArrDigest2[37], bArrDigest2[58], bArrDigest2[16], 4, sb);
            B64.b64from24bit(bArrDigest2[59], bArrDigest2[17], bArrDigest2[38], 4, sb);
            B64.b64from24bit(bArrDigest2[18], bArrDigest2[39], bArrDigest2[60], 4, sb);
            B64.b64from24bit(bArrDigest2[40], bArrDigest2[61], bArrDigest2[19], 4, sb);
            B64.b64from24bit(bArrDigest2[62], bArrDigest2[20], bArrDigest2[41], 4, sb);
            b = 0;
            B64.b64from24bit((byte) 0, (byte) 0, bArrDigest2[63], 2, sb);
        }
        Arrays.fill(bArrDigest4, b);
        Arrays.fill(bArr2, b);
        Arrays.fill(bArr3, b);
        digest5.reset();
        digest4.reset();
        Arrays.fill(bArr, b);
        Arrays.fill(bArr4, b);
        return sb.toString();
    }

    public static String sha512Crypt(byte[] bArr) {
        return sha512Crypt(bArr, null);
    }

    public static String sha512Crypt(byte[] bArr, String str) {
        if (str == null) {
            str = SHA512_PREFIX + B64.getRandomSalt(8);
        }
        return sha2Crypt(bArr, str, SHA512_PREFIX, 64, MessageDigestAlgorithms.SHA_512);
    }
}
