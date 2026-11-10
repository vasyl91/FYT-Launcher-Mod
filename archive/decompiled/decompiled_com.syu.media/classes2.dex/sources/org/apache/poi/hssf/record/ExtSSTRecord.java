package org.apache.poi.hssf.record;

import java.util.ArrayList;
import org.apache.poi.hssf.record.cont.ContinuableRecord;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ExtSSTRecord extends ContinuableRecord {
    public static final int DEFAULT_BUCKET_SIZE = 8;
    public static final int MAX_BUCKETS = 128;
    public static final short sid = 255;
    private InfoSubRecord[] _sstInfos;
    private short _stringsPerBucket;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 255;
    }

    public static final class InfoSubRecord {
        public static final int ENCODED_SIZE = 8;
        private int field_1_stream_pos;
        private int field_2_bucket_sst_offset;
        private short field_3_zero;

        public InfoSubRecord(int i, int i2) {
            this.field_1_stream_pos = i;
            this.field_2_bucket_sst_offset = i2;
        }

        public InfoSubRecord(RecordInputStream recordInputStream) {
            this.field_1_stream_pos = recordInputStream.readInt();
            this.field_2_bucket_sst_offset = recordInputStream.readShort();
            this.field_3_zero = recordInputStream.readShort();
        }

        public int getStreamPos() {
            return this.field_1_stream_pos;
        }

        public int getBucketSSTOffset() {
            return this.field_2_bucket_sst_offset;
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeInt(this.field_1_stream_pos);
            littleEndianOutput.writeShort(this.field_2_bucket_sst_offset);
            littleEndianOutput.writeShort(this.field_3_zero);
        }
    }

    public ExtSSTRecord() {
        this._stringsPerBucket = (short) 8;
        this._sstInfos = new InfoSubRecord[0];
    }

    public ExtSSTRecord(RecordInputStream recordInputStream) {
        this._stringsPerBucket = recordInputStream.readShort();
        ArrayList arrayList = new ArrayList(recordInputStream.remaining() / 8);
        while (recordInputStream.available() > 0) {
            arrayList.add(new InfoSubRecord(recordInputStream));
            if (recordInputStream.available() == 0 && recordInputStream.hasNextRecord() && recordInputStream.getNextSid() == 60) {
                recordInputStream.nextRecord();
            }
        }
        this._sstInfos = (InfoSubRecord[]) arrayList.toArray(new InfoSubRecord[arrayList.size()]);
    }

    public void setNumStringsPerBucket(short s) {
        this._stringsPerBucket = s;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[EXTSST]\n    .dsst           = ");
        stringBuffer.append(Integer.toHexString(this._stringsPerBucket)).append("\n    .numInfoRecords = ");
        stringBuffer.append(this._sstInfos.length).append("\n");
        for (int i = 0; i < this._sstInfos.length; i++) {
            stringBuffer.append("    .inforecord     = ").append(i).append("\n    .streampos      = ");
            stringBuffer.append(Integer.toHexString(this._sstInfos[i].getStreamPos())).append("\n    .sstoffset      = ");
            stringBuffer.append(Integer.toHexString(this._sstInfos[i].getBucketSSTOffset())).append("\n");
        }
        stringBuffer.append("[/EXTSST]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.cont.ContinuableRecord
    public void serialize(ContinuableRecordOutput continuableRecordOutput) {
        continuableRecordOutput.writeShort(this._stringsPerBucket);
        int i = 0;
        while (true) {
            InfoSubRecord[] infoSubRecordArr = this._sstInfos;
            if (i >= infoSubRecordArr.length) {
                return;
            }
            infoSubRecordArr[i].serialize(continuableRecordOutput);
            i++;
        }
    }

    protected int getDataSize() {
        return (this._sstInfos.length * 8) + 2;
    }

    protected InfoSubRecord[] getInfoSubRecords() {
        return this._sstInfos;
    }

    public static final int getNumberOfInfoRecsForStrings(int i) {
        int i2 = i / 8;
        if (i % 8 != 0) {
            i2++;
        }
        if (i2 > 128) {
            return 128;
        }
        return i2;
    }

    public static final int getRecordSizeForStrings(int i) {
        return (getNumberOfInfoRecsForStrings(i) * 8) + 6;
    }

    public void setBucketOffsets(int[] iArr, int[] iArr2) {
        this._sstInfos = new InfoSubRecord[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            this._sstInfos[i] = new InfoSubRecord(iArr[i], iArr2[i]);
        }
    }
}
