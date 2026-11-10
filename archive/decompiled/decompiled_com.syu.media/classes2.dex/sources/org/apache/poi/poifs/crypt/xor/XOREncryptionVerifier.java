package org.apache.poi.poifs.crypt.xor;

import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.standard.EncryptionRecord;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XOREncryptionVerifier extends EncryptionVerifier implements EncryptionRecord, Cloneable {
    protected XOREncryptionVerifier() {
        setEncryptedKey(new byte[2]);
        setEncryptedVerifier(new byte[2]);
    }

    protected XOREncryptionVerifier(LittleEndianInput littleEndianInput) {
        byte[] bArr = new byte[2];
        littleEndianInput.readFully(bArr);
        setEncryptedKey(bArr);
        byte[] bArr2 = new byte[2];
        littleEndianInput.readFully(bArr2);
        setEncryptedVerifier(bArr2);
    }

    @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
    public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
        littleEndianByteArrayOutputStream.write(getEncryptedKey());
        littleEndianByteArrayOutputStream.write(getEncryptedVerifier());
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    public XOREncryptionVerifier clone() throws CloneNotSupportedException {
        return (XOREncryptionVerifier) super.clone();
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    protected final void setEncryptedVerifier(byte[] bArr) {
        super.setEncryptedVerifier(bArr);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    protected final void setEncryptedKey(byte[] bArr) {
        super.setEncryptedKey(bArr);
    }
}
