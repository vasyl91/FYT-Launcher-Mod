package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ObjectLinkRecord extends StandardRecord implements Cloneable {
    public static final short ANCHOR_ID_CHART_TITLE = 1;
    public static final short ANCHOR_ID_SERIES_OR_POINT = 4;
    public static final short ANCHOR_ID_X_AXIS = 3;
    public static final short ANCHOR_ID_Y_AXIS = 2;
    public static final short ANCHOR_ID_Z_AXIS = 7;
    public static final short sid = 4135;
    private short field_1_anchorId;
    private short field_2_link1;
    private short field_3_link2;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 6;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public ObjectLinkRecord() {
    }

    public ObjectLinkRecord(RecordInputStream recordInputStream) {
        this.field_1_anchorId = recordInputStream.readShort();
        this.field_2_link1 = recordInputStream.readShort();
        this.field_3_link2 = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[OBJECTLINK]\n    .anchorId             = 0x");
        stringBuffer.append(HexDump.toHex(getAnchorId())).append(" (").append((int) getAnchorId()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .link1                = 0x").append(HexDump.toHex(getLink1())).append(" (").append((int) getLink1()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .link2                = 0x").append(HexDump.toHex(getLink2())).append(" (").append((int) getLink2()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/OBJECTLINK]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_anchorId);
        littleEndianOutput.writeShort(this.field_2_link1);
        littleEndianOutput.writeShort(this.field_3_link2);
    }

    @Override // org.apache.poi.hssf.record.Record
    public ObjectLinkRecord clone() {
        ObjectLinkRecord objectLinkRecord = new ObjectLinkRecord();
        objectLinkRecord.field_1_anchorId = this.field_1_anchorId;
        objectLinkRecord.field_2_link1 = this.field_2_link1;
        objectLinkRecord.field_3_link2 = this.field_3_link2;
        return objectLinkRecord;
    }

    public short getAnchorId() {
        return this.field_1_anchorId;
    }

    public void setAnchorId(short s) {
        this.field_1_anchorId = s;
    }

    public short getLink1() {
        return this.field_2_link1;
    }

    public void setLink1(short s) {
        this.field_2_link1 = s;
    }

    public short getLink2() {
        return this.field_3_link2;
    }

    public void setLink2(short s) {
        this.field_3_link2 = s;
    }
}
