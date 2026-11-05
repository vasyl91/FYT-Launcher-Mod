package org.apache.poi.hssf.record;

import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class WSBoolRecord extends StandardRecord {
    public static final short sid = 129;
    private byte field_1_wsbool;
    private byte field_2_wsbool;
    private static final BitField autobreaks = BitFieldFactory.getInstance(1);
    private static final BitField dialog = BitFieldFactory.getInstance(16);
    private static final BitField applystyles = BitFieldFactory.getInstance(32);
    private static final BitField rowsumsbelow = BitFieldFactory.getInstance(64);
    private static final BitField rowsumsright = BitFieldFactory.getInstance(128);
    private static final BitField fittopage = BitFieldFactory.getInstance(1);
    private static final BitField displayguts = BitFieldFactory.getInstance(6);
    private static final BitField alternateexpression = BitFieldFactory.getInstance(64);
    private static final BitField alternateformula = BitFieldFactory.getInstance(128);

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 129;
    }

    public WSBoolRecord() {
    }

    public WSBoolRecord(RecordInputStream recordInputStream) {
        byte[] remainder = recordInputStream.readRemainder();
        this.field_1_wsbool = remainder[1];
        this.field_2_wsbool = remainder[0];
    }

    public void setWSBool1(byte b) {
        this.field_1_wsbool = b;
    }

    public void setAutobreaks(boolean z) {
        this.field_1_wsbool = autobreaks.setByteBoolean(this.field_1_wsbool, z);
    }

    public void setDialog(boolean z) {
        this.field_1_wsbool = dialog.setByteBoolean(this.field_1_wsbool, z);
    }

    public void setRowSumsBelow(boolean z) {
        this.field_1_wsbool = rowsumsbelow.setByteBoolean(this.field_1_wsbool, z);
    }

    public void setRowSumsRight(boolean z) {
        this.field_1_wsbool = rowsumsright.setByteBoolean(this.field_1_wsbool, z);
    }

    public void setWSBool2(byte b) {
        this.field_2_wsbool = b;
    }

    public void setFitToPage(boolean z) {
        this.field_2_wsbool = fittopage.setByteBoolean(this.field_2_wsbool, z);
    }

    public void setDisplayGuts(boolean z) {
        this.field_2_wsbool = displayguts.setByteBoolean(this.field_2_wsbool, z);
    }

    public void setAlternateExpression(boolean z) {
        this.field_2_wsbool = alternateexpression.setByteBoolean(this.field_2_wsbool, z);
    }

    public void setAlternateFormula(boolean z) {
        this.field_2_wsbool = alternateformula.setByteBoolean(this.field_2_wsbool, z);
    }

    public byte getWSBool1() {
        return this.field_1_wsbool;
    }

    public boolean getAutobreaks() {
        return autobreaks.isSet(this.field_1_wsbool);
    }

    public boolean getDialog() {
        return dialog.isSet(this.field_1_wsbool);
    }

    public boolean getRowSumsBelow() {
        return rowsumsbelow.isSet(this.field_1_wsbool);
    }

    public boolean getRowSumsRight() {
        return rowsumsright.isSet(this.field_1_wsbool);
    }

    public byte getWSBool2() {
        return this.field_2_wsbool;
    }

    public boolean getFitToPage() {
        return fittopage.isSet(this.field_2_wsbool);
    }

    public boolean getDisplayGuts() {
        return displayguts.isSet(this.field_2_wsbool);
    }

    public boolean getAlternateExpression() {
        return alternateexpression.isSet(this.field_2_wsbool);
    }

    public boolean getAlternateFormula() {
        return alternateformula.isSet(this.field_2_wsbool);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        return "[WSBOOL]\n    .wsbool1        = " + Integer.toHexString(getWSBool1()) + "\n        .autobreaks = " + getAutobreaks() + "\n        .dialog     = " + getDialog() + "\n        .rowsumsbelw= " + getRowSumsBelow() + "\n        .rowsumsrigt= " + getRowSumsRight() + "\n    .wsbool2        = " + Integer.toHexString(getWSBool2()) + "\n        .fittopage  = " + getFitToPage() + "\n        .displayguts= " + getDisplayGuts() + "\n        .alternateex= " + getAlternateExpression() + "\n        .alternatefo= " + getAlternateFormula() + "\n[/WSBOOL]\n";
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getWSBool2());
        littleEndianOutput.writeByte(getWSBool1());
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        WSBoolRecord wSBoolRecord = new WSBoolRecord();
        wSBoolRecord.field_1_wsbool = this.field_1_wsbool;
        wSBoolRecord.field_2_wsbool = this.field_2_wsbool;
        return wSBoolRecord;
    }
}
