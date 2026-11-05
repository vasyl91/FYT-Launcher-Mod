package org.apache.poi.hssf.record.crypto;

import java.io.InputStream;
import java.io.PushbackInputStream;
import kotlin.UByte;
import org.apache.poi.hssf.record.BiffHeaderInput;
import org.apache.poi.poifs.crypt.ChunkedCipherInputStream;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Biff8DecryptingStream implements BiffHeaderInput, LittleEndianInput {
    public static final int RC4_REKEYING_INTERVAL = 1024;
    private ChunkedCipherInputStream ccis;
    private final EncryptionInfo info;
    private final byte[] buffer = new byte[8];
    private boolean shouldSkipEncryptionOnCurrentRecord = false;

    public static boolean isNeverEncryptedRecord(int i) {
        return i == 47 || i == 225 || i == 2057;
    }

    public Biff8DecryptingStream(InputStream inputStream, int i, EncryptionInfo encryptionInfo) throws RecordFormatException {
        try {
            byte[] bArr = new byte[i];
            if (i != 0) {
                PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, i);
                pushbackInputStream.unread(bArr);
                inputStream = pushbackInputStream;
            }
            this.info = encryptionInfo;
            Decryptor decryptor = encryptionInfo.getDecryptor();
            decryptor.setChunkSize(1024);
            ChunkedCipherInputStream chunkedCipherInputStream = (ChunkedCipherInputStream) decryptor.getDataStream(inputStream, Integer.MAX_VALUE, 0);
            this.ccis = chunkedCipherInputStream;
            if (i > 0) {
                chunkedCipherInputStream.readFully(bArr);
            }
        } catch (Exception e) {
            throw new RecordFormatException(e);
        }
    }

    @Override // org.apache.poi.hssf.record.BiffHeaderInput
    public int available() {
        return this.ccis.available();
    }

    @Override // org.apache.poi.hssf.record.BiffHeaderInput
    public int readRecordSID() {
        readPlain(this.buffer, 0, 2);
        int uShort = LittleEndian.getUShort(this.buffer, 0);
        this.shouldSkipEncryptionOnCurrentRecord = isNeverEncryptedRecord(uShort);
        return uShort;
    }

    @Override // org.apache.poi.hssf.record.BiffHeaderInput
    public int readDataSize() {
        readPlain(this.buffer, 0, 2);
        int uShort = LittleEndian.getUShort(this.buffer, 0);
        this.ccis.setNextRecordSize(uShort);
        return uShort;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        double dLongBitsToDouble = Double.longBitsToDouble(readLong());
        if (Double.isNaN(dLongBitsToDouble)) {
            throw new RuntimeException("Did not expect to read NaN");
        }
        return dLongBitsToDouble;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr) {
        readFully(bArr, 0, bArr.length);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr, int i, int i2) {
        if (this.shouldSkipEncryptionOnCurrentRecord) {
            readPlain(bArr, i, bArr.length);
        } else {
            this.ccis.readFully(bArr, i, i2);
        }
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        return readByte() & UByte.MAX_VALUE;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        if (this.shouldSkipEncryptionOnCurrentRecord) {
            readPlain(this.buffer, 0, 1);
            return this.buffer[0];
        }
        return this.ccis.readByte();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        return readShort() & 65535;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        if (this.shouldSkipEncryptionOnCurrentRecord) {
            readPlain(this.buffer, 0, 2);
            return LittleEndian.getShort(this.buffer);
        }
        return this.ccis.readShort();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        if (this.shouldSkipEncryptionOnCurrentRecord) {
            readPlain(this.buffer, 0, 4);
            return LittleEndian.getInt(this.buffer);
        }
        return this.ccis.readInt();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        if (this.shouldSkipEncryptionOnCurrentRecord) {
            readPlain(this.buffer, 0, 8);
            return LittleEndian.getLong(this.buffer);
        }
        return this.ccis.readLong();
    }

    public long getPosition() {
        return this.ccis.getPos();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readPlain(byte[] bArr, int i, int i2) {
        this.ccis.readPlain(bArr, i, i2);
    }
}
