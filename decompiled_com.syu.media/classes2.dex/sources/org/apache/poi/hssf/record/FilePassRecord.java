package org.apache.poi.hssf.record;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.binaryrc4.BinaryRC4EncryptionHeader;
import org.apache.poi.poifs.crypt.binaryrc4.BinaryRC4EncryptionVerifier;
import org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIEncryptionHeader;
import org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIEncryptionVerifier;
import org.apache.poi.poifs.crypt.xor.XOREncryptionHeader;
import org.apache.poi.poifs.crypt.xor.XOREncryptionVerifier;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.LittleEndianOutputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FilePassRecord extends StandardRecord implements Cloneable {
    private static final int ENCRYPTION_OTHER = 1;
    private static final int ENCRYPTION_XOR = 0;
    public static final short sid = 47;
    private EncryptionInfo encryptionInfo;
    private final int encryptionType;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 47;
    }

    private FilePassRecord(FilePassRecord filePassRecord) {
        this.encryptionType = filePassRecord.encryptionType;
        try {
            this.encryptionInfo = filePassRecord.encryptionInfo.clone();
        } catch (CloneNotSupportedException e) {
            throw new EncryptedDocumentException(e);
        }
    }

    public FilePassRecord(EncryptionMode encryptionMode) {
        this.encryptionType = encryptionMode == EncryptionMode.xor ? 0 : 1;
        this.encryptionInfo = new EncryptionInfo(encryptionMode);
    }

    public FilePassRecord(RecordInputStream recordInputStream) {
        EncryptionMode encryptionMode;
        int uShort = recordInputStream.readUShort();
        this.encryptionType = uShort;
        if (uShort == 0) {
            encryptionMode = EncryptionMode.xor;
        } else if (uShort == 1) {
            encryptionMode = EncryptionMode.cryptoAPI;
        } else {
            throw new EncryptedDocumentException("invalid encryption type");
        }
        try {
            this.encryptionInfo = new EncryptionInfo(recordInputStream, encryptionMode);
        } catch (IOException e) {
            throw new EncryptedDocumentException(e);
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.encryptionType);
        byte[] bArr = new byte[1024];
        LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(bArr, 0);
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$poifs$crypt$EncryptionMode[this.encryptionInfo.getEncryptionMode().ordinal()];
        if (i == 1) {
            ((XOREncryptionHeader) this.encryptionInfo.getHeader()).write(littleEndianByteArrayOutputStream);
            ((XOREncryptionVerifier) this.encryptionInfo.getVerifier()).write(littleEndianByteArrayOutputStream);
        } else if (i == 2) {
            littleEndianOutput.writeShort(this.encryptionInfo.getVersionMajor());
            littleEndianOutput.writeShort(this.encryptionInfo.getVersionMinor());
            ((BinaryRC4EncryptionHeader) this.encryptionInfo.getHeader()).write(littleEndianByteArrayOutputStream);
            ((BinaryRC4EncryptionVerifier) this.encryptionInfo.getVerifier()).write(littleEndianByteArrayOutputStream);
        } else if (i == 3) {
            littleEndianOutput.writeShort(this.encryptionInfo.getVersionMajor());
            littleEndianOutput.writeShort(this.encryptionInfo.getVersionMinor());
            littleEndianOutput.writeInt(this.encryptionInfo.getEncryptionFlags());
            ((CryptoAPIEncryptionHeader) this.encryptionInfo.getHeader()).write(littleEndianByteArrayOutputStream);
            ((CryptoAPIEncryptionVerifier) this.encryptionInfo.getVerifier()).write(littleEndianByteArrayOutputStream);
        } else {
            throw new EncryptedDocumentException("not supported");
        }
        littleEndianOutput.write(bArr, 0, littleEndianByteArrayOutputStream.getWriteIndex());
    }

    /* JADX INFO: renamed from: org.apache.poi.hssf.record.FilePassRecord$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$crypt$EncryptionMode;

        static {
            int[] iArr = new int[EncryptionMode.values().length];
            $SwitchMap$org$apache$poi$poifs$crypt$EncryptionMode = iArr;
            try {
                iArr[EncryptionMode.xor.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$EncryptionMode[EncryptionMode.binaryRC4.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$EncryptionMode[EncryptionMode.cryptoAPI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        serialize(new LittleEndianOutputStream(byteArrayOutputStream));
        return byteArrayOutputStream.size();
    }

    public EncryptionInfo getEncryptionInfo() {
        return this.encryptionInfo;
    }

    @Override // org.apache.poi.hssf.record.Record
    public FilePassRecord clone() {
        return new FilePassRecord(this);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuilder sb = new StringBuilder("[FILEPASS]\n    .type = ");
        sb.append(HexDump.shortToHex(this.encryptionType)).append('\n');
        String str = "     ." + this.encryptionInfo.getEncryptionMode();
        sb.append(str + ".info = ").append(HexDump.shortToHex(this.encryptionInfo.getVersionMajor())).append('\n');
        sb.append(str + ".ver  = ").append(HexDump.shortToHex(this.encryptionInfo.getVersionMinor())).append('\n');
        sb.append(str + ".salt = ").append(HexDump.toHex(this.encryptionInfo.getVerifier().getSalt())).append('\n');
        sb.append(str + ".verifier = ").append(HexDump.toHex(this.encryptionInfo.getVerifier().getEncryptedVerifier())).append('\n');
        sb.append(str + ".verifierHash = ").append(HexDump.toHex(this.encryptionInfo.getVerifier().getEncryptedVerifierHash())).append("\n[/FILEPASS]\n");
        return sb.toString();
    }
}
