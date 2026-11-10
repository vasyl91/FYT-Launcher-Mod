package org.apache.poi.poifs.crypt.temp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.TempFile;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EncryptedTempData {
    private static POILogger LOG = POILogFactory.getLogger((Class<?>) EncryptedTempData.class);
    private static final CipherAlgorithm cipherAlgorithm = CipherAlgorithm.aes128;
    private final byte[] ivBytes;
    private final SecretKeySpec skeySpec;
    private final File tempFile;

    public EncryptedTempData() throws IOException {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[16];
        this.ivBytes = bArr;
        byte[] bArr2 = new byte[16];
        secureRandom.nextBytes(bArr);
        secureRandom.nextBytes(bArr2);
        this.skeySpec = new SecretKeySpec(bArr2, cipherAlgorithm.jceId);
        this.tempFile = TempFile.createTempFile("poi-temp-data", ".tmp");
    }

    public OutputStream getOutputStream() throws IOException {
        return new CipherOutputStream(new FileOutputStream(this.tempFile), CryptoFunctions.getCipher(this.skeySpec, cipherAlgorithm, ChainingMode.cbc, this.ivBytes, 1, null));
    }

    public InputStream getInputStream() throws IOException {
        return new CipherInputStream(new FileInputStream(this.tempFile), CryptoFunctions.getCipher(this.skeySpec, cipherAlgorithm, ChainingMode.cbc, this.ivBytes, 2, null));
    }

    public void dispose() {
        if (this.tempFile.delete()) {
            return;
        }
        LOG.log(5, this.tempFile.getAbsolutePath() + " can't be removed (or was already removed.");
    }
}
