package org.apache.poi.poifs.crypt.cryptoapi;

import java.io.ByteArrayInputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class CryptoAPIDocumentInputStream extends ByteArrayInputStream {
    private Cipher cipher;
    private final CryptoAPIDecryptor decryptor;
    private byte[] oneByte;

    public void seek(int i) {
        if (i > this.count) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        this.pos = i;
        this.mark = i;
    }

    public void setBlock(int i) throws GeneralSecurityException {
        this.cipher = this.decryptor.initCipherForBlock(this.cipher, i);
    }

    @Override // java.io.ByteArrayInputStream, java.io.InputStream
    public synchronized int read() {
        int i = super.read();
        if (i == -1) {
            return -1;
        }
        byte[] bArr = this.oneByte;
        bArr[0] = (byte) i;
        try {
            this.cipher.update(bArr, 0, 1, bArr);
            return this.oneByte[0];
        } catch (ShortBufferException e) {
            throw new EncryptedDocumentException(e);
        }
    }

    @Override // java.io.ByteArrayInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        int i3 = super.read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        try {
            this.cipher.update(bArr, i, i3, bArr, i);
            return i3;
        } catch (ShortBufferException e) {
            throw new EncryptedDocumentException(e);
        }
    }

    public CryptoAPIDocumentInputStream(CryptoAPIDecryptor cryptoAPIDecryptor, byte[] bArr) throws GeneralSecurityException {
        super(bArr);
        this.oneByte = new byte[]{0};
        this.decryptor = cryptoAPIDecryptor;
        this.cipher = cryptoAPIDecryptor.initCipherForBlock(null, 0);
    }
}
