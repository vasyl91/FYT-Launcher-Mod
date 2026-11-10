package org.apache.poi.hssf.record.cf;

import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class PatternFormatting implements Cloneable {
    public static final short ALT_BARS = 3;
    public static final short BIG_SPOTS = 9;
    public static final short BRICKS = 10;
    public static final short DIAMONDS = 16;
    public static final short FINE_DOTS = 2;
    public static final short LEAST_DOTS = 18;
    public static final short LESS_DOTS = 17;
    public static final short NO_FILL = 0;
    public static final short SOLID_FOREGROUND = 1;
    public static final short SPARSE_DOTS = 4;
    public static final short SQUARES = 15;
    public static final short THICK_BACKWARD_DIAG = 7;
    public static final short THICK_FORWARD_DIAG = 8;
    public static final short THICK_HORZ_BANDS = 5;
    public static final short THICK_VERT_BANDS = 6;
    public static final short THIN_BACKWARD_DIAG = 13;
    public static final short THIN_FORWARD_DIAG = 14;
    public static final short THIN_HORZ_BANDS = 11;
    public static final short THIN_VERT_BANDS = 12;
    private int field_15_pattern_style;
    private int field_16_pattern_color_indexes;
    private static final BitField fillPatternStyle = BitFieldFactory.getInstance(64512);
    private static final BitField patternColorIndex = BitFieldFactory.getInstance(127);
    private static final BitField patternBackgroundColorIndex = BitFieldFactory.getInstance(16256);

    public int getDataLength() {
        return 4;
    }

    public PatternFormatting() {
        this.field_15_pattern_style = 0;
        this.field_16_pattern_color_indexes = 0;
    }

    public PatternFormatting(LittleEndianInput littleEndianInput) {
        this.field_15_pattern_style = littleEndianInput.readUShort();
        this.field_16_pattern_color_indexes = littleEndianInput.readUShort();
    }

    public void setFillPattern(int i) {
        this.field_15_pattern_style = fillPatternStyle.setValue(this.field_15_pattern_style, i);
    }

    public int getFillPattern() {
        return fillPatternStyle.getValue(this.field_15_pattern_style);
    }

    public void setFillBackgroundColor(int i) {
        this.field_16_pattern_color_indexes = patternBackgroundColorIndex.setValue(this.field_16_pattern_color_indexes, i);
    }

    public int getFillBackgroundColor() {
        return patternBackgroundColorIndex.getValue(this.field_16_pattern_color_indexes);
    }

    public void setFillForegroundColor(int i) {
        this.field_16_pattern_color_indexes = patternColorIndex.setValue(this.field_16_pattern_color_indexes, i);
    }

    public int getFillForegroundColor() {
        return patternColorIndex.getValue(this.field_16_pattern_color_indexes);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("    [Pattern Formatting]\n          .fillpattern= ");
        stringBuffer.append(Integer.toHexString(getFillPattern())).append("\n          .fgcoloridx= ");
        stringBuffer.append(Integer.toHexString(getFillForegroundColor())).append("\n          .bgcoloridx= ");
        stringBuffer.append(Integer.toHexString(getFillBackgroundColor())).append("\n    [/Pattern Formatting]\n");
        return stringBuffer.toString();
    }

    public Object clone() {
        PatternFormatting patternFormatting = new PatternFormatting();
        patternFormatting.field_15_pattern_style = this.field_15_pattern_style;
        patternFormatting.field_16_pattern_color_indexes = this.field_16_pattern_color_indexes;
        return patternFormatting;
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_15_pattern_style);
        littleEndianOutput.writeShort(this.field_16_pattern_color_indexes);
    }
}
