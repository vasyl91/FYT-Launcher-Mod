package org.apache.poi.poifs.crypt.xor;

import org.apache.poi.poifs.crypt.EncryptionHeader;
import org.apache.poi.poifs.crypt.standard.EncryptionRecord;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XOREncryptionHeader extends EncryptionHeader implements EncryptionRecord, Cloneable {
    @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
    public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
    }

    protected XOREncryptionHeader() {
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionHeader
    public XOREncryptionHeader clone() throws CloneNotSupportedException {
        return (XOREncryptionHeader) super.clone();
    }
}
