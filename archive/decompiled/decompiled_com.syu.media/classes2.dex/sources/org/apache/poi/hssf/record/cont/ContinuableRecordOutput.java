package org.apache.poi.hssf.record.cont;

import org.apache.poi.util.DelayableLittleEndianOutput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ContinuableRecordOutput implements LittleEndianOutput {
    private static final LittleEndianOutput NOPOutput = new DelayableLittleEndianOutput() { // from class: org.apache.poi.hssf.record.cont.ContinuableRecordOutput.1
        @Override // org.apache.poi.util.DelayableLittleEndianOutput
        public LittleEndianOutput createDelayedOutput(int i) {
            return this;
        }

        @Override // org.apache.poi.util.LittleEndianOutput
        public void write(byte[] bArr) {
        }

        @Override // org.apache.poi.util.LittleEndianOutput
        public void write(byte[] bArr, int i, int i2) {
        }

        @Override // org.apache.poi.util.LittleEndianOutput
        public void writeByte(int i) {
        }

        @Override // org.apache.poi.util.LittleEndianOutput
        public void writeDouble(double d) {
        }

        @Override // org.apache.poi.util.LittleEndianOutput
        public void writeInt(int i) {
        }

        @Override // org.apache.poi.util.LittleEndianOutput
        public void writeLong(long j) {
        }

        @Override // org.apache.poi.util.LittleEndianOutput
        public void writeShort(int i) {
        }
    };
    private final LittleEndianOutput _out;
    private int _totalPreviousRecordsSize = 0;
    private UnknownLengthRecordOutput _ulrOutput;

    public ContinuableRecordOutput(LittleEndianOutput littleEndianOutput, int i) {
        this._ulrOutput = new UnknownLengthRecordOutput(littleEndianOutput, i);
        this._out = littleEndianOutput;
    }

    public static ContinuableRecordOutput createForCountingOnly() {
        return new ContinuableRecordOutput(NOPOutput, -777);
    }

    public int getTotalSize() {
        return this._totalPreviousRecordsSize + this._ulrOutput.getTotalSize();
    }

    void terminate() {
        this._ulrOutput.terminate();
    }

    public int getAvailableSpace() {
        return this._ulrOutput.getAvailableSpace();
    }

    public void writeContinue() {
        this._ulrOutput.terminate();
        this._totalPreviousRecordsSize += this._ulrOutput.getTotalSize();
        this._ulrOutput = new UnknownLengthRecordOutput(this._out, 60);
    }

    public void writeContinueIfRequired(int i) {
        if (this._ulrOutput.getAvailableSpace() < i) {
            writeContinue();
        }
    }

    public void writeStringData(String str) {
        int i;
        int i2;
        boolean zHasMultibyte = StringUtil.hasMultibyte(str);
        if (zHasMultibyte) {
            i2 = 1;
            i = 3;
        } else {
            i = 2;
            i2 = 0;
        }
        writeContinueIfRequired(i);
        writeByte(i2);
        writeCharacterData(str, zHasMultibyte);
    }

    public void writeString(String str, int i, int i2) {
        int i3;
        int i4;
        boolean zHasMultibyte = StringUtil.hasMultibyte(str);
        if (zHasMultibyte) {
            i4 = 1;
            i3 = 5;
        } else {
            i3 = 4;
            i4 = 0;
        }
        if (i > 0) {
            i4 |= 8;
            i3 += 2;
        }
        if (i2 > 0) {
            i4 |= 4;
            i3 += 4;
        }
        writeContinueIfRequired(i3);
        writeShort(str.length());
        writeByte(i4);
        if (i > 0) {
            writeShort(i);
        }
        if (i2 > 0) {
            writeInt(i2);
        }
        writeCharacterData(str, zHasMultibyte);
    }

    private void writeCharacterData(String str, boolean z) {
        int length = str.length();
        int i = 0;
        if (z) {
            while (true) {
                int iMin = Math.min(length - i, this._ulrOutput.getAvailableSpace() / 2);
                while (iMin > 0) {
                    this._ulrOutput.writeShort(str.charAt(i));
                    iMin--;
                    i++;
                }
                if (i >= length) {
                    return;
                }
                writeContinue();
                writeByte(1);
            }
        } else {
            int i2 = 0;
            while (true) {
                int iMin2 = Math.min(length - i2, this._ulrOutput.getAvailableSpace() / 1);
                while (iMin2 > 0) {
                    this._ulrOutput.writeByte(str.charAt(i2));
                    iMin2--;
                    i2++;
                }
                if (i2 >= length) {
                    return;
                }
                writeContinue();
                writeByte(0);
            }
        }
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void write(byte[] bArr) {
        writeContinueIfRequired(bArr.length);
        this._ulrOutput.write(bArr);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void write(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (true) {
            int iMin = Math.min(i2 - i3, this._ulrOutput.getAvailableSpace() / 1);
            while (iMin > 0) {
                this._ulrOutput.writeByte(bArr[i3 + i]);
                iMin--;
                i3++;
            }
            if (i3 >= i2) {
                return;
            } else {
                writeContinue();
            }
        }
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeByte(int i) {
        writeContinueIfRequired(1);
        this._ulrOutput.writeByte(i);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeDouble(double d) {
        writeContinueIfRequired(8);
        this._ulrOutput.writeDouble(d);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeInt(int i) {
        writeContinueIfRequired(4);
        this._ulrOutput.writeInt(i);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeLong(long j) {
        writeContinueIfRequired(8);
        this._ulrOutput.writeLong(j);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeShort(int i) {
        writeContinueIfRequired(2);
        this._ulrOutput.writeShort(i);
    }
}
