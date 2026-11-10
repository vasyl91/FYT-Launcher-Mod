package org.apache.poi.poifs.crypt;

import java.nio.charset.Charset;
import java.security.DigestException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import kotlin.jvm.internal.ByteCompanionObject;
import module.canbus.FinalCanbus;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.formula.ptg.IntersectionPtg;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class CryptoFunctions {
    private static final int[] INITIAL_CODE_ARRAY = {57840, 7439, 52380, 33984, 4364, 3600, 61902, 12606, 6258, 57657, 54287, 34041, 10252, 43370, 20163};
    private static final byte[] PAD_ARRAY = {-69, -1, -1, -70, -1, -1, -71, ByteCompanionObject.MIN_VALUE, 0, -66, IntersectionPtg.sid, 0, -65, IntersectionPtg.sid, 0};
    private static final int[][] ENCRYPTION_MATRIX = {new int[]{44796, 19929, 39858, 10053, 20106, 40212, 10761}, new int[]{31585, 63170, 64933, 60267, 50935, 40399, 11199}, new int[]{17763, 35526, 1453, 2906, 5812, 11624, 23248}, new int[]{885, 1770, 3540, 7080, 14160, 28320, 56640}, new int[]{55369, 41139, 20807, 41614, 21821, 43642, 17621}, new int[]{28485, 56970, 44341, 19019, 38038, 14605, 29210}, new int[]{60195, 50791, 40175, 10751, 21502, 43004, 24537}, new int[]{18387, 36774, 3949, 7898, 15796, 31592, 63184}, new int[]{47201, 24803, 49606, 37805, 14203, 28406, 56812}, new int[]{17824, 35648, 1697, 3394, 6788, 13576, 27152}, new int[]{43601, 17539, 35078, FinalCanbus.U_DOOR_RR_ADD, 1114, 2228, 4456}, new int[]{30388, 60776, 51953, 34243, 7079, 14158, 28316}, new int[]{14128, 28256, 56512, 43425, 17251, 34502, 7597}, new int[]{13105, 26210, 52420, 35241, 883, 1766, 3532}, new int[]{4129, 8258, 16516, 33032, 4657, 9314, 18628}};

    private static byte rotateLeft(byte b, int i) {
        int i2 = b & 255;
        return (byte) ((i2 >>> (8 - i)) | (i2 << i));
    }

    private static short rotateLeftBase15Bit(short s) {
        return (short) (((short) ((s << 1) & 32767)) | ((short) ((s & 16384) == 0 ? 0 : 1)));
    }

    public static byte[] hashPassword(String str, HashAlgorithm hashAlgorithm, byte[] bArr, int i) {
        return hashPassword(str, hashAlgorithm, bArr, i, true);
    }

    public static byte[] hashPassword(String str, HashAlgorithm hashAlgorithm, byte[] bArr, int i, boolean z) {
        if (str == null) {
            str = Decryptor.DEFAULT_PASSWORD;
        }
        MessageDigest messageDigest = getMessageDigest(hashAlgorithm);
        messageDigest.update(bArr);
        byte[] bArrDigest = messageDigest.digest(StringUtil.getToUnicodeLE(str));
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = z ? bArr2 : bArrDigest;
        byte[] bArr4 = z ? bArrDigest : bArr2;
        for (int i2 = 0; i2 < i; i2++) {
            try {
                LittleEndian.putInt(bArr2, 0, i2);
                messageDigest.reset();
                messageDigest.update(bArr3);
                messageDigest.update(bArr4);
                messageDigest.digest(bArrDigest, 0, bArrDigest.length);
            } catch (DigestException unused) {
                throw new EncryptedDocumentException("error in password hashing");
            }
        }
        return bArrDigest;
    }

    public static byte[] generateIv(HashAlgorithm hashAlgorithm, byte[] bArr, byte[] bArr2, int i) {
        if (bArr2 != null) {
            MessageDigest messageDigest = getMessageDigest(hashAlgorithm);
            messageDigest.update(bArr);
            bArr = messageDigest.digest(bArr2);
        }
        return getBlock36(bArr, i);
    }

    public static byte[] generateKey(byte[] bArr, HashAlgorithm hashAlgorithm, byte[] bArr2, int i) {
        MessageDigest messageDigest = getMessageDigest(hashAlgorithm);
        messageDigest.update(bArr);
        return getBlock36(messageDigest.digest(bArr2), i);
    }

    public static Cipher getCipher(SecretKey secretKey, CipherAlgorithm cipherAlgorithm, ChainingMode chainingMode, byte[] bArr, int i) {
        return getCipher(secretKey, cipherAlgorithm, chainingMode, bArr, i, null);
    }

    public static Cipher getCipher(Key key, CipherAlgorithm cipherAlgorithm, ChainingMode chainingMode, byte[] bArr, int i, String str) {
        Cipher cipher;
        AlgorithmParameterSpec ivParameterSpec;
        int length = key.getEncoded().length;
        if (str == null) {
            str = "NoPadding";
        }
        try {
            if (Cipher.getMaxAllowedKeyLength(cipherAlgorithm.jceId) < length * 8) {
                throw new EncryptedDocumentException("Export Restrictions in place - please install JCE Unlimited Strength Jurisdiction Policy files");
            }
            if (cipherAlgorithm == CipherAlgorithm.rc4) {
                cipher = Cipher.getInstance(cipherAlgorithm.jceId);
            } else if (cipherAlgorithm.needsBouncyCastle) {
                registerBouncyCastle();
                cipher = Cipher.getInstance(cipherAlgorithm.jceId + "/" + chainingMode.jceId + "/" + str, "BC");
            } else {
                cipher = Cipher.getInstance(cipherAlgorithm.jceId + "/" + chainingMode.jceId + "/" + str);
            }
            if (bArr == null) {
                cipher.init(i, key);
            } else {
                if (cipherAlgorithm == CipherAlgorithm.rc2) {
                    ivParameterSpec = new RC2ParameterSpec(key.getEncoded().length * 8, bArr);
                } else {
                    ivParameterSpec = new IvParameterSpec(bArr);
                }
                cipher.init(i, key, ivParameterSpec);
            }
            return cipher;
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException(e);
        }
    }

    private static byte[] getBlock36(byte[] bArr, int i) {
        return getBlockX(bArr, i, (byte) 54);
    }

    public static byte[] getBlock0(byte[] bArr, int i) {
        return getBlockX(bArr, i, (byte) 0);
    }

    private static byte[] getBlockX(byte[] bArr, int i, byte b) {
        if (bArr.length == i) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        Arrays.fill(bArr2, b);
        System.arraycopy(bArr, 0, bArr2, 0, Math.min(i, bArr.length));
        return bArr2;
    }

    public static MessageDigest getMessageDigest(HashAlgorithm hashAlgorithm) {
        try {
            if (hashAlgorithm.needsBouncyCastle) {
                registerBouncyCastle();
                return MessageDigest.getInstance(hashAlgorithm.jceId, "BC");
            }
            return MessageDigest.getInstance(hashAlgorithm.jceId);
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException("hash algo not supported", e);
        }
    }

    public static Mac getMac(HashAlgorithm hashAlgorithm) {
        try {
            if (hashAlgorithm.needsBouncyCastle) {
                registerBouncyCastle();
                return Mac.getInstance(hashAlgorithm.jceHmacId, "BC");
            }
            return Mac.getInstance(hashAlgorithm.jceHmacId);
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException("hmac algo not supported", e);
        }
    }

    public static void registerBouncyCastle() {
        if (Security.getProvider("BC") != null) {
            return;
        }
        try {
            Security.addProvider((Provider) Thread.currentThread().getContextClassLoader().loadClass("org.bouncycastle.jce.provider.BouncyCastleProvider").newInstance());
        } catch (Exception e) {
            throw new EncryptedDocumentException("Only the BouncyCastle provider supports your encryption settings - please add it to the classpath.", e);
        }
    }

    public static int createXorVerifier1(String str) {
        byte[] ansiPassword = toAnsiPassword(str);
        short sRotateLeftBase15Bit = 0;
        if (!"".equals(str)) {
            for (int length = ansiPassword.length - 1; length >= 0; length--) {
                sRotateLeftBase15Bit = (short) (rotateLeftBase15Bit(sRotateLeftBase15Bit) ^ ansiPassword[length]);
            }
            sRotateLeftBase15Bit = (short) (((short) (rotateLeftBase15Bit(sRotateLeftBase15Bit) ^ ansiPassword.length)) ^ 52811);
        }
        return 65535 & sRotateLeftBase15Bit;
    }

    public static int createXorVerifier2(String str) {
        byte[] bArr = new byte[4];
        if (!"".equals(str)) {
            String strSubstring = str.substring(0, Math.min(str.length(), 15));
            byte[] ansiPassword = toAnsiPassword(strSubstring);
            int i = INITIAL_CODE_ARRAY[ansiPassword.length - 1];
            for (int i2 = 0; i2 < ansiPassword.length; i2++) {
                int length = (15 - ansiPassword.length) + i2;
                for (int i3 = 0; i3 < 7; i3++) {
                    if ((ansiPassword[i2] & (1 << i3)) != 0) {
                        i ^= ENCRYPTION_MATRIX[length][i3];
                    }
                }
            }
            LittleEndian.putShort(bArr, 0, (short) createXorVerifier1(strSubstring));
            LittleEndian.putShort(bArr, 2, (short) i);
        }
        return LittleEndian.getInt(bArr);
    }

    public static String xorHashPassword(String str) {
        return String.format(Locale.ROOT, "%1$08X", Integer.valueOf(createXorVerifier2(str)));
    }

    public static String xorHashPasswordReversed(String str) {
        int iCreateXorVerifier2 = createXorVerifier2(str);
        return String.format(Locale.ROOT, "%1$02X%2$02X%3$02X%4$02X", Integer.valueOf((iCreateXorVerifier2 >>> 0) & 255), Integer.valueOf((iCreateXorVerifier2 >>> 8) & 255), Integer.valueOf((iCreateXorVerifier2 >>> 16) & 255), Integer.valueOf((iCreateXorVerifier2 >>> 24) & 255));
    }

    public static int createXorKey1(String str) {
        return createXorVerifier2(str) >>> 16;
    }

    public static byte[] createXorArray1(String str) {
        if (str.length() > 15) {
            str = str.substring(0, 15);
        }
        byte[] bytes = str.getBytes(Charset.forName("ASCII"));
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        byte[] bArr2 = PAD_ARRAY;
        System.arraycopy(bArr2, 0, bArr, bytes.length, (bArr2.length - bytes.length) + 1);
        int iCreateXorKey1 = createXorKey1(str);
        byte[] bArr3 = {(byte) (iCreateXorKey1 & 255), (byte) ((iCreateXorKey1 >>> 8) & 255)};
        for (int i = 0; i < 16; i++) {
            byte b = (byte) (bArr[i] ^ bArr3[i & 1]);
            bArr[i] = b;
            bArr[i] = rotateLeft(b, 2);
        }
        return bArr;
    }

    private static byte[] toAnsiPassword(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            byte b = (byte) (cCharAt & 255);
            byte b2 = (byte) ((cCharAt >>> '\b') & 255);
            if (b == 0) {
                b = b2;
            }
            bArr[i] = b;
        }
        return bArr;
    }
}
