package org.apache.poi.hssf.record;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import kotlin.UByte;
import org.apache.poi.hssf.record.crypto.Biff8DecryptingStream;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianInputStream;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class RecordInputStream implements LittleEndianInput {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DATA_LEN_NEEDS_TO_BE_READ = -1;
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final int INVALID_SID_VALUE = -1;
    public static final short MAX_RECORD_DATA_SIZE = 8224;
    private final BiffHeaderInput _bhi;
    private int _currentDataLength;
    private int _currentDataOffset;
    private int _currentSid;
    private final LittleEndianInput _dataInput;
    private int _markedDataOffset;
    private int _nextSid;

    public static final class LeftoverDataException extends RuntimeException {
        public LeftoverDataException(int i, int i2) {
            super("Initialisation of record 0x" + Integer.toHexString(i).toUpperCase(Locale.ROOT) + "(" + getRecordName(i) + ") left " + i2 + " bytes remaining still to be read.");
        }

        private static String getRecordName(int i) {
            Class<? extends Record> recordClass = RecordFactory.getRecordClass(i);
            if (recordClass == null) {
                return null;
            }
            return recordClass.getSimpleName();
        }
    }

    private static final class SimpleHeaderInput implements BiffHeaderInput {
        private final LittleEndianInput _lei;

        public SimpleHeaderInput(InputStream inputStream) {
            this._lei = RecordInputStream.getLEI(inputStream);
        }

        @Override // org.apache.poi.hssf.record.BiffHeaderInput
        public int available() {
            return this._lei.available();
        }

        @Override // org.apache.poi.hssf.record.BiffHeaderInput
        public int readDataSize() {
            return this._lei.readUShort();
        }

        @Override // org.apache.poi.hssf.record.BiffHeaderInput
        public int readRecordSID() {
            return this._lei.readUShort();
        }
    }

    public RecordInputStream(InputStream inputStream) throws RecordFormatException {
        this(inputStream, null, 0);
    }

    public RecordInputStream(InputStream inputStream, EncryptionInfo encryptionInfo, int i) throws RecordFormatException {
        if (encryptionInfo == null) {
            this._dataInput = getLEI(inputStream);
            this._bhi = new SimpleHeaderInput(inputStream);
        } else {
            Biff8DecryptingStream biff8DecryptingStream = new Biff8DecryptingStream(inputStream, i, encryptionInfo);
            this._dataInput = biff8DecryptingStream;
            this._bhi = biff8DecryptingStream;
        }
        this._nextSid = readNextSid();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static LittleEndianInput getLEI(InputStream inputStream) {
        if (inputStream instanceof LittleEndianInput) {
            return (LittleEndianInput) inputStream;
        }
        return new LittleEndianInputStream(inputStream);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int available() {
        return remaining();
    }

    public int read(byte[] bArr, int i, int i2) {
        int iMin = Math.min(i2, remaining());
        if (iMin == 0) {
            return 0;
        }
        readFully(bArr, i, iMin);
        return iMin;
    }

    public short getSid() {
        return (short) this._currentSid;
    }

    public boolean hasNextRecord() throws LeftoverDataException {
        int i = this._currentDataLength;
        if (i != -1 && i != this._currentDataOffset) {
            throw new LeftoverDataException(this._currentSid, remaining());
        }
        if (i != -1) {
            this._nextSid = readNextSid();
        }
        return this._nextSid != -1;
    }

    private int readNextSid() {
        if (this._bhi.available() < 4) {
            return -1;
        }
        int recordSID = this._bhi.readRecordSID();
        if (recordSID == -1) {
            throw new RecordFormatException("Found invalid sid (" + recordSID + ")");
        }
        this._currentDataLength = -1;
        return recordSID;
    }

    public void nextRecord() throws RecordFormatException {
        int i = this._nextSid;
        if (i == -1) {
            throw new IllegalStateException("EOF - next record not available");
        }
        if (this._currentDataLength != -1) {
            throw new IllegalStateException("Cannot call nextRecord() without checking hasNextRecord() first");
        }
        this._currentSid = i;
        this._currentDataOffset = 0;
        int dataSize = this._bhi.readDataSize();
        this._currentDataLength = dataSize;
        if (dataSize > 8224) {
            throw new RecordFormatException("The content of an excel record cannot exceed 8224 bytes");
        }
    }

    private void checkRecordPosition(int i) {
        int iRemaining = remaining();
        if (iRemaining >= i) {
            return;
        }
        if (iRemaining == 0 && isContinueNext()) {
            nextRecord();
            return;
        }
        throw new RecordFormatException("Not enough data (" + iRemaining + ") to read requested (" + i + ") bytes");
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        checkRecordPosition(1);
        this._currentDataOffset++;
        return this._dataInput.readByte();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        checkRecordPosition(2);
        this._currentDataOffset += 2;
        return this._dataInput.readShort();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        checkRecordPosition(4);
        this._currentDataOffset += 4;
        return this._dataInput.readInt();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        checkRecordPosition(8);
        this._currentDataOffset += 8;
        return this._dataInput.readLong();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        return readByte() & UByte.MAX_VALUE;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        checkRecordPosition(2);
        this._currentDataOffset += 2;
        return this._dataInput.readUShort();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        double dLongBitsToDouble = Double.longBitsToDouble(readLong());
        Double.isNaN(dLongBitsToDouble);
        return dLongBitsToDouble;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readPlain(byte[] bArr, int i, int i2) {
        readFully(bArr, 0, bArr.length, true);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr) {
        readFully(bArr, 0, bArr.length, false);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr, int i, int i2) {
        readFully(bArr, i, i2, false);
    }

    protected void readFully(byte[] bArr, int i, int i2, boolean z) {
        bArr.getClass();
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2;
        while (i3 > 0) {
            int iMin = Math.min(available(), i3);
            if (iMin == 0) {
                if (!hasNextRecord()) {
                    throw new RecordFormatException("Can't read the remaining " + i3 + " bytes of the requested " + i2 + " bytes. No further record exists.");
                }
                nextRecord();
                iMin = Math.min(available(), i3);
            }
            checkRecordPosition(iMin);
            if (z) {
                this._dataInput.readPlain(bArr, i, iMin);
            } else {
                this._dataInput.readFully(bArr, i, iMin);
            }
            this._currentDataOffset += iMin;
            i += iMin;
            i3 -= iMin;
        }
    }

    public String readString() {
        return readStringCommon(readUShort(), readByte() == 0);
    }

    public String readUnicodeLEString(int i) {
        return readStringCommon(i, false);
    }

    public String readCompressedUnicode(int i) {
        return readStringCommon(i, true);
    }

    private String readStringCommon(int i, boolean z) {
        int uByte;
        int uByte2;
        if (i < 0 || i > 1048576) {
            throw new IllegalArgumentException("Bad requested string length (" + i + ")");
        }
        char[] cArr = new char[i];
        int i2 = 0;
        while (true) {
            int iRemaining = remaining();
            if (!z) {
                iRemaining /= 2;
            }
            if (i - i2 <= iRemaining) {
                while (i2 < i) {
                    if (z) {
                        uByte = readUByte();
                    } else {
                        uByte = readShort();
                    }
                    cArr[i2] = (char) uByte;
                    i2++;
                }
                return new String(cArr);
            }
            while (iRemaining > 0) {
                if (z) {
                    uByte2 = readUByte();
                } else {
                    uByte2 = readShort();
                }
                cArr[i2] = (char) uByte2;
                i2++;
                iRemaining--;
            }
            if (!isContinueNext()) {
                throw new RecordFormatException("Expected to find a ContinueRecord in order to read remaining " + (i - i2) + " of " + i + " chars");
            }
            if (remaining() != 0) {
                throw new RecordFormatException("Odd number of bytes(" + remaining() + ") left behind");
            }
            nextRecord();
            z = readByte() == 0;
        }
    }

    public byte[] readRemainder() {
        int iRemaining = remaining();
        if (iRemaining == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[iRemaining];
        readFully(bArr);
        return bArr;
    }

    @Deprecated
    public byte[] readAllContinuedRemainder() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16448);
        while (true) {
            byte[] remainder = readRemainder();
            byteArrayOutputStream.write(remainder, 0, remainder.length);
            if (isContinueNext()) {
                nextRecord();
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public int remaining() {
        int i = this._currentDataLength;
        if (i == -1) {
            return 0;
        }
        return i - this._currentDataOffset;
    }

    private boolean isContinueNext() {
        int i = this._currentDataLength;
        if (i == -1 || this._currentDataOffset == i) {
            return hasNextRecord() && this._nextSid == 60;
        }
        throw new IllegalStateException("Should never be called before end of current record");
    }

    public int getNextSid() {
        return this._nextSid;
    }

    @Internal
    public void mark(int i) {
        ((InputStream) this._dataInput).mark(i);
        this._markedDataOffset = this._currentDataOffset;
    }

    @Internal
    public void reset() throws IOException {
        ((InputStream) this._dataInput).reset();
        this._currentDataOffset = this._markedDataOffset;
    }
}
