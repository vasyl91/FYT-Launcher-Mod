package org.apache.poi.hssf.record;

import java.util.ArrayList;
import java.util.List;
import module.canbus.FinalCanbus;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class PaletteRecord extends StandardRecord {
    public static final short FIRST_COLOR_INDEX = 8;
    public static final byte STANDARD_PALETTE_SIZE = 56;
    public static final short sid = 146;
    private final List<PColor> _colors;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 146;
    }

    public PaletteRecord() {
        PColor[] pColorArrCreateDefaultPalette = createDefaultPalette();
        this._colors = new ArrayList(pColorArrCreateDefaultPalette.length);
        for (PColor pColor : pColorArrCreateDefaultPalette) {
            this._colors.add(pColor);
        }
    }

    public PaletteRecord(RecordInputStream recordInputStream) {
        short s = recordInputStream.readShort();
        this._colors = new ArrayList(s);
        for (int i = 0; i < s; i++) {
            this._colors.add(new PColor(recordInputStream));
        }
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[PALETTE]\n  numcolors     = ");
        stringBuffer.append(this._colors.size()).append('\n');
        for (int i = 0; i < this._colors.size(); i++) {
            PColor pColor = this._colors.get(i);
            stringBuffer.append("* colornum      = ").append(i).append('\n');
            stringBuffer.append(pColor);
            stringBuffer.append("/*colornum      = ").append(i).append('\n');
        }
        stringBuffer.append("[/PALETTE]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._colors.size());
        for (int i = 0; i < this._colors.size(); i++) {
            this._colors.get(i).serialize(littleEndianOutput);
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (this._colors.size() * 4) + 2;
    }

    public byte[] getColor(int i) {
        int i2 = i - 8;
        if (i2 < 0 || i2 >= this._colors.size()) {
            return null;
        }
        return this._colors.get(i2).getTriplet();
    }

    public void setColor(short s, byte b, byte b2, byte b3) {
        int i = s - 8;
        if (i < 0 || i >= 56) {
            return;
        }
        while (this._colors.size() <= i) {
            this._colors.add(new PColor(0, 0, 0));
        }
        this._colors.set(i, new PColor(b, b2, b3));
    }

    private static PColor[] createDefaultPalette() {
        return new PColor[]{pc(0, 0, 0), pc(255, 255, 255), pc(255, 0, 0), pc(0, 255, 0), pc(0, 0, 255), pc(255, 255, 0), pc(255, 0, 255), pc(0, 255, 255), pc(128, 0, 0), pc(0, 128, 0), pc(0, 0, 128), pc(128, 128, 0), pc(128, 0, 128), pc(0, 128, 128), pc(192, 192, 192), pc(128, 128, 128), pc(153, 153, 255), pc(153, 51, 102), pc(255, 255, FinalCanbus.CAR_MSN_RZC_PSA301), pc(FinalCanbus.CAR_MSN_RZC_PSA301, 255, 255), pc(102, 0, 102), pc(255, 128, 128), pc(0, 102, FinalCanbus.CAR_MSN_RZC_PSA301), pc(FinalCanbus.CAR_MSN_RZC_PSA301, FinalCanbus.CAR_MSN_RZC_PSA301, 255), pc(0, 0, 128), pc(255, 0, 255), pc(255, 255, 0), pc(0, 255, 255), pc(128, 0, 128), pc(128, 0, 0), pc(0, 128, 128), pc(0, 0, 255), pc(0, FinalCanbus.CAR_MSN_RZC_PSA301, 255), pc(FinalCanbus.CAR_MSN_RZC_PSA301, 255, 255), pc(FinalCanbus.CAR_MSN_RZC_PSA301, 255, FinalCanbus.CAR_MSN_RZC_PSA301), pc(255, 255, 153), pc(153, FinalCanbus.CAR_MSN_RZC_PSA301, 255), pc(255, 153, FinalCanbus.CAR_MSN_RZC_PSA301), pc(FinalCanbus.CAR_MSN_RZC_PSA301, 153, 255), pc(255, FinalCanbus.CAR_MSN_RZC_PSA301, 153), pc(51, 102, 255), pc(51, FinalCanbus.CAR_MSN_RZC_PSA301, FinalCanbus.CAR_MSN_RZC_PSA301), pc(153, FinalCanbus.CAR_MSN_RZC_PSA301, 0), pc(255, FinalCanbus.CAR_MSN_RZC_PSA301, 0), pc(255, 153, 0), pc(255, 102, 0), pc(102, 102, 153), pc(150, 150, 150), pc(0, 51, 102), pc(51, 153, 102), pc(0, 51, 0), pc(51, 51, 0), pc(153, 51, 0), pc(153, 51, 102), pc(51, 51, 153), pc(51, 51, 51)};
    }

    private static PColor pc(int i, int i2, int i3) {
        return new PColor(i, i2, i3);
    }

    private static final class PColor {
        public static final short ENCODED_SIZE = 4;
        private final int _blue;
        private final int _green;
        private final int _red;

        public PColor(int i, int i2, int i3) {
            this._red = i;
            this._green = i2;
            this._blue = i3;
        }

        public byte[] getTriplet() {
            return new byte[]{(byte) this._red, (byte) this._green, (byte) this._blue};
        }

        public PColor(RecordInputStream recordInputStream) {
            this._red = recordInputStream.readByte();
            this._green = recordInputStream.readByte();
            this._blue = recordInputStream.readByte();
            recordInputStream.readByte();
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeByte(this._red);
            littleEndianOutput.writeByte(this._green);
            littleEndianOutput.writeByte(this._blue);
            littleEndianOutput.writeByte(0);
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("  red   = ");
            stringBuffer.append(this._red & 255).append("\n  green = ");
            stringBuffer.append(this._green & 255).append("\n  blue  = ");
            stringBuffer.append(this._blue & 255).append('\n');
            return stringBuffer.toString();
        }
    }
}
