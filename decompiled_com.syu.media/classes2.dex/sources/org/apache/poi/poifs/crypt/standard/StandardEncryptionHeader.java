package org.apache.poi.poifs.crypt.standard;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.CipherProvider;
import org.apache.poi.poifs.crypt.EncryptionHeader;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class StandardEncryptionHeader extends EncryptionHeader implements EncryptionRecord, Cloneable {
    /* JADX WARN: Multi-variable type inference failed */
    protected StandardEncryptionHeader(LittleEndianInput littleEndianInput) throws IOException {
        setFlags(littleEndianInput.readInt());
        setSizeExtra(littleEndianInput.readInt());
        setCipherAlgorithm(CipherAlgorithm.fromEcmaId(littleEndianInput.readInt()));
        setHashAlgorithm(HashAlgorithm.fromEcmaId(littleEndianInput.readInt()));
        int i = littleEndianInput.readInt();
        setKeySize(i == 0 ? 40 : i);
        setBlockSize(getKeySize());
        setCipherProvider(CipherProvider.fromEcmaId(littleEndianInput.readInt()));
        littleEndianInput.readLong();
        boolean z = littleEndianInput instanceof RecordInputStream;
        if (z) {
            ((RecordInputStream) littleEndianInput).mark(5);
        } else {
            ((InputStream) littleEndianInput).mark(5);
        }
        int i2 = littleEndianInput.readInt();
        if (z) {
            ((RecordInputStream) littleEndianInput).reset();
        } else {
            ((InputStream) littleEndianInput).reset();
        }
        if (i2 == 16) {
            setCspName("");
        } else {
            StringBuilder sb = new StringBuilder();
            while (true) {
                char c = (char) littleEndianInput.readShort();
                if (c == 0) {
                    break;
                } else {
                    sb.append(c);
                }
            }
            setCspName(sb.toString());
        }
        setChainingMode(ChainingMode.ecb);
        setKeySalt(null);
    }

    protected StandardEncryptionHeader(CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        setCipherAlgorithm(cipherAlgorithm);
        setHashAlgorithm(hashAlgorithm);
        setKeySize(i);
        setBlockSize(i2);
        setCipherProvider(cipherAlgorithm.provider);
        setFlags(EncryptionInfo.flagAES.setBoolean(0, cipherAlgorithm.provider == CipherProvider.aes) | EncryptionInfo.flagCryptoAPI.setBoolean(0, true));
    }

    @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
    public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
        int writeIndex = littleEndianByteArrayOutputStream.getWriteIndex();
        LittleEndianOutput littleEndianOutputCreateDelayedOutput = littleEndianByteArrayOutputStream.createDelayedOutput(4);
        littleEndianByteArrayOutputStream.writeInt(getFlags());
        littleEndianByteArrayOutputStream.writeInt(0);
        littleEndianByteArrayOutputStream.writeInt(getCipherAlgorithm().ecmaId);
        littleEndianByteArrayOutputStream.writeInt(getHashAlgorithm().ecmaId);
        littleEndianByteArrayOutputStream.writeInt(getKeySize());
        littleEndianByteArrayOutputStream.writeInt(getCipherProvider().ecmaId);
        littleEndianByteArrayOutputStream.writeInt(0);
        littleEndianByteArrayOutputStream.writeInt(0);
        String cspName = getCspName();
        if (cspName == null) {
            cspName = getCipherProvider().cipherProviderName;
        }
        littleEndianByteArrayOutputStream.write(StringUtil.getToUnicodeLE(cspName));
        littleEndianByteArrayOutputStream.writeShort(0);
        littleEndianOutputCreateDelayedOutput.writeInt((littleEndianByteArrayOutputStream.getWriteIndex() - writeIndex) - 4);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionHeader
    public StandardEncryptionHeader clone() throws CloneNotSupportedException {
        return (StandardEncryptionHeader) super.clone();
    }
}
