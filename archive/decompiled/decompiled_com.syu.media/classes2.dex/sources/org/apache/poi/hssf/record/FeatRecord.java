package org.apache.poi.hssf.record;

import org.apache.poi.hssf.record.common.FeatFormulaErr2;
import org.apache.poi.hssf.record.common.FeatProtection;
import org.apache.poi.hssf.record.common.FeatSmartTag;
import org.apache.poi.hssf.record.common.FtrHeader;
import org.apache.poi.hssf.record.common.SharedFeature;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FeatRecord extends StandardRecord implements Cloneable {
    private static POILogger logger = POILogFactory.getLogger((Class<?>) FeatRecord.class);
    public static final short sid = 2152;
    public static final short v11_sid = 2162;
    public static final short v12_sid = 2168;
    private long cbFeatData;
    private CellRangeAddress[] cellRefs;
    private FtrHeader futureHeader;
    private int isf_sharedFeatureType;
    private byte reserved1;
    private long reserved2;
    private int reserved3;
    private SharedFeature sharedFeature;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        return "[SHARED FEATURE]\n[/SHARED FEATURE]\n";
    }

    public FeatRecord() {
        FtrHeader ftrHeader = new FtrHeader();
        this.futureHeader = ftrHeader;
        ftrHeader.setRecordType(sid);
    }

    public FeatRecord(RecordInputStream recordInputStream) {
        this.futureHeader = new FtrHeader(recordInputStream);
        this.isf_sharedFeatureType = recordInputStream.readShort();
        this.reserved1 = recordInputStream.readByte();
        this.reserved2 = recordInputStream.readInt();
        int uShort = recordInputStream.readUShort();
        this.cbFeatData = recordInputStream.readInt();
        this.reserved3 = recordInputStream.readShort();
        this.cellRefs = new CellRangeAddress[uShort];
        int i = 0;
        while (true) {
            CellRangeAddress[] cellRangeAddressArr = this.cellRefs;
            if (i >= cellRangeAddressArr.length) {
                break;
            }
            cellRangeAddressArr[i] = new CellRangeAddress(recordInputStream);
            i++;
        }
        int i2 = this.isf_sharedFeatureType;
        if (i2 == 2) {
            this.sharedFeature = new FeatProtection(recordInputStream);
            return;
        }
        if (i2 == 3) {
            this.sharedFeature = new FeatFormulaErr2(recordInputStream);
        } else if (i2 == 4) {
            this.sharedFeature = new FeatSmartTag(recordInputStream);
        } else {
            logger.log(7, "Unknown Shared Feature " + this.isf_sharedFeatureType + " found!");
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        this.futureHeader.serialize(littleEndianOutput);
        littleEndianOutput.writeShort(this.isf_sharedFeatureType);
        littleEndianOutput.writeByte(this.reserved1);
        littleEndianOutput.writeInt((int) this.reserved2);
        littleEndianOutput.writeShort(this.cellRefs.length);
        littleEndianOutput.writeInt((int) this.cbFeatData);
        littleEndianOutput.writeShort(this.reserved3);
        int i = 0;
        while (true) {
            CellRangeAddress[] cellRangeAddressArr = this.cellRefs;
            if (i < cellRangeAddressArr.length) {
                cellRangeAddressArr[i].serialize(littleEndianOutput);
                i++;
            } else {
                this.sharedFeature.serialize(littleEndianOutput);
                return;
            }
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (this.cellRefs.length * 8) + 27 + this.sharedFeature.getDataSize();
    }

    public int getIsf_sharedFeatureType() {
        return this.isf_sharedFeatureType;
    }

    public long getCbFeatData() {
        return this.cbFeatData;
    }

    public void setCbFeatData(long j) {
        this.cbFeatData = j;
    }

    public CellRangeAddress[] getCellRefs() {
        return this.cellRefs;
    }

    public void setCellRefs(CellRangeAddress[] cellRangeAddressArr) {
        this.cellRefs = cellRangeAddressArr;
    }

    public SharedFeature getSharedFeature() {
        return this.sharedFeature;
    }

    public void setSharedFeature(SharedFeature sharedFeature) {
        this.sharedFeature = sharedFeature;
        if (sharedFeature instanceof FeatProtection) {
            this.isf_sharedFeatureType = 2;
        }
        if (sharedFeature instanceof FeatFormulaErr2) {
            this.isf_sharedFeatureType = 3;
        }
        if (sharedFeature instanceof FeatSmartTag) {
            this.isf_sharedFeatureType = 4;
        }
        if (this.isf_sharedFeatureType == 3) {
            this.cbFeatData = sharedFeature.getDataSize();
        } else {
            this.cbFeatData = 0L;
        }
    }

    @Override // org.apache.poi.hssf.record.Record
    public FeatRecord clone() {
        return (FeatRecord) cloneViaReserialise();
    }
}
