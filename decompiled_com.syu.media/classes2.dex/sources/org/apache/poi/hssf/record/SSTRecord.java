package org.apache.poi.hssf.record;

import java.util.Iterator;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.hssf.record.cont.ContinuableRecord;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.util.IntMapper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class SSTRecord extends ContinuableRecord {
    private static final UnicodeString EMPTY_STRING = new UnicodeString("");
    static final int MAX_DATA_SPACE = 8216;
    static final int SST_RECORD_OVERHEAD = 12;
    static final int STD_RECORD_OVERHEAD = 4;
    public static final short sid = 252;
    int[] bucketAbsoluteOffsets;
    int[] bucketRelativeOffsets;
    private SSTDeserializer deserializer;
    private int field_1_num_strings;
    private int field_2_num_unique_strings;
    private IntMapper<UnicodeString> field_3_strings;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 252;
    }

    public SSTRecord() {
        this.field_1_num_strings = 0;
        this.field_2_num_unique_strings = 0;
        this.field_3_strings = new IntMapper<>();
        this.deserializer = new SSTDeserializer(this.field_3_strings);
    }

    public int addString(UnicodeString unicodeString) {
        this.field_1_num_strings++;
        if (unicodeString == null) {
            unicodeString = EMPTY_STRING;
        }
        int index = this.field_3_strings.getIndex(unicodeString);
        if (index != -1) {
            return index;
        }
        int size = this.field_3_strings.size();
        this.field_2_num_unique_strings++;
        SSTDeserializer.addToStringTable(this.field_3_strings, unicodeString);
        return size;
    }

    public int getNumStrings() {
        return this.field_1_num_strings;
    }

    public int getNumUniqueStrings() {
        return this.field_2_num_unique_strings;
    }

    public UnicodeString getString(int i) {
        return this.field_3_strings.get(i);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[SST]\n    .numstrings     = ");
        stringBuffer.append(Integer.toHexString(getNumStrings())).append("\n    .uniquestrings  = ");
        stringBuffer.append(Integer.toHexString(getNumUniqueStrings())).append("\n");
        for (int i = 0; i < this.field_3_strings.size(); i++) {
            stringBuffer.append("    .string_" + i + "      = ").append(this.field_3_strings.get(i).getDebugInfo()).append("\n");
        }
        stringBuffer.append("[/SST]\n");
        return stringBuffer.toString();
    }

    public SSTRecord(RecordInputStream recordInputStream) {
        this.field_1_num_strings = recordInputStream.readInt();
        this.field_2_num_unique_strings = recordInputStream.readInt();
        this.field_3_strings = new IntMapper<>();
        SSTDeserializer sSTDeserializer = new SSTDeserializer(this.field_3_strings);
        this.deserializer = sSTDeserializer;
        if (this.field_1_num_strings == 0) {
            this.field_2_num_unique_strings = 0;
        } else {
            sSTDeserializer.manufactureStrings(this.field_2_num_unique_strings, recordInputStream);
        }
    }

    Iterator<UnicodeString> getStrings() {
        return this.field_3_strings.iterator();
    }

    int countStrings() {
        return this.field_3_strings.size();
    }

    @Override // org.apache.poi.hssf.record.cont.ContinuableRecord
    protected void serialize(ContinuableRecordOutput continuableRecordOutput) {
        SSTSerializer sSTSerializer = new SSTSerializer(this.field_3_strings, getNumStrings(), getNumUniqueStrings());
        sSTSerializer.serialize(continuableRecordOutput);
        this.bucketAbsoluteOffsets = sSTSerializer.getBucketAbsoluteOffsets();
        this.bucketRelativeOffsets = sSTSerializer.getBucketRelativeOffsets();
    }

    SSTDeserializer getDeserializer() {
        return this.deserializer;
    }

    public ExtSSTRecord createExtSSTRecord(int i) {
        if (this.bucketAbsoluteOffsets == null || this.bucketRelativeOffsets == null) {
            throw new IllegalStateException("SST record has not yet been serialized.");
        }
        ExtSSTRecord extSSTRecord = new ExtSSTRecord();
        extSSTRecord.setNumStringsPerBucket((short) 8);
        int[] iArr = (int[]) this.bucketAbsoluteOffsets.clone();
        int[] iArr2 = (int[]) this.bucketRelativeOffsets.clone();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = iArr[i2] + i;
        }
        extSSTRecord.setBucketOffsets(iArr, iArr2);
        return extSSTRecord;
    }

    public int calcExtSSTRecordSize() {
        return ExtSSTRecord.getRecordSizeForStrings(this.field_3_strings.size());
    }
}
