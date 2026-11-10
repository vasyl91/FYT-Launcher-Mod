package org.apache.poi.poifs.crypt.temp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.xssf.streaming.SheetDataWriter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SheetDataWriterWithDecorator extends SheetDataWriter {
    static final CipherAlgorithm cipherAlgorithm = CipherAlgorithm.aes128;
    byte[] ivBytes;
    SecretKeySpec skeySpec;

    void init() {
        if (this.skeySpec == null) {
            SecureRandom secureRandom = new SecureRandom();
            byte[] bArr = new byte[16];
            this.ivBytes = bArr;
            byte[] bArr2 = new byte[16];
            secureRandom.nextBytes(bArr);
            secureRandom.nextBytes(bArr2);
            this.skeySpec = new SecretKeySpec(bArr2, cipherAlgorithm.jceId);
        }
    }

    @Override // org.apache.poi.xssf.streaming.SheetDataWriter
    protected OutputStream decorateOutputStream(FileOutputStream fileOutputStream) {
        init();
        return new CipherOutputStream(fileOutputStream, CryptoFunctions.getCipher(this.skeySpec, cipherAlgorithm, ChainingMode.cbc, this.ivBytes, 1, "PKCS5Padding"));
    }

    @Override // org.apache.poi.xssf.streaming.SheetDataWriter
    protected InputStream decorateInputStream(FileInputStream fileInputStream) {
        return new CipherInputStream(fileInputStream, CryptoFunctions.getCipher(this.skeySpec, cipherAlgorithm, ChainingMode.cbc, this.ivBytes, 2, "PKCS5Padding"));
    }
}
