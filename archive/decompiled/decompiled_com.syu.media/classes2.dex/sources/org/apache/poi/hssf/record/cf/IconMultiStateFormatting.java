package org.apache.poi.hssf.record.cf;

import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class IconMultiStateFormatting implements Cloneable {
    private org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet iconSet;
    private byte options;
    private Threshold[] thresholds;
    private static POILogger log = POILogFactory.getLogger((Class<?>) IconMultiStateFormatting.class);
    private static BitField iconOnly = BitFieldFactory.getInstance(1);
    private static BitField reversed = BitFieldFactory.getInstance(4);

    public IconMultiStateFormatting() {
        org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet iconSet = org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet.GYR_3_TRAFFIC_LIGHTS;
        this.iconSet = iconSet;
        this.options = (byte) 0;
        this.thresholds = new Threshold[iconSet.num];
    }

    public IconMultiStateFormatting(LittleEndianInput littleEndianInput) {
        littleEndianInput.readShort();
        littleEndianInput.readByte();
        byte b = littleEndianInput.readByte();
        org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet iconSetById = org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet.byId(littleEndianInput.readByte());
        this.iconSet = iconSetById;
        int i = 0;
        if (iconSetById.num != b) {
            log.log(5, "Inconsistent Icon Set defintion, found " + this.iconSet + " but defined as " + ((int) b) + " entries");
        }
        this.options = littleEndianInput.readByte();
        this.thresholds = new Threshold[this.iconSet.num];
        while (true) {
            Threshold[] thresholdArr = this.thresholds;
            if (i >= thresholdArr.length) {
                return;
            }
            thresholdArr[i] = new IconMultiStateThreshold(littleEndianInput);
            i++;
        }
    }

    public org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet getIconSet() {
        return this.iconSet;
    }

    public void setIconSet(org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet iconSet) {
        this.iconSet = iconSet;
    }

    public Threshold[] getThresholds() {
        return this.thresholds;
    }

    public void setThresholds(Threshold[] thresholdArr) {
        this.thresholds = thresholdArr == null ? null : (Threshold[]) thresholdArr.clone();
    }

    public boolean isIconOnly() {
        return getOptionFlag(iconOnly);
    }

    public void setIconOnly(boolean z) {
        setOptionFlag(z, iconOnly);
    }

    public boolean isReversed() {
        return getOptionFlag(reversed);
    }

    public void setReversed(boolean z) {
        setOptionFlag(z, reversed);
    }

    private boolean getOptionFlag(BitField bitField) {
        return bitField.getValue(this.options) != 0;
    }

    private void setOptionFlag(boolean z, BitField bitField) {
        this.options = bitField.setByteBoolean(this.options, z);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("    [Icon Formatting]\n          .icon_set = ");
        stringBuffer.append(this.iconSet).append("\n          .icon_only= ");
        stringBuffer.append(isIconOnly()).append("\n          .reversed = ");
        stringBuffer.append(isReversed()).append("\n");
        for (Threshold threshold : this.thresholds) {
            stringBuffer.append(threshold);
        }
        stringBuffer.append("    [/Icon Formatting]\n");
        return stringBuffer.toString();
    }

    public Object clone() {
        IconMultiStateFormatting iconMultiStateFormatting = new IconMultiStateFormatting();
        iconMultiStateFormatting.iconSet = this.iconSet;
        iconMultiStateFormatting.options = this.options;
        Threshold[] thresholdArr = new Threshold[this.thresholds.length];
        iconMultiStateFormatting.thresholds = thresholdArr;
        Threshold[] thresholdArr2 = this.thresholds;
        System.arraycopy(thresholdArr2, 0, thresholdArr, 0, thresholdArr2.length);
        return iconMultiStateFormatting;
    }

    public int getDataLength() {
        int dataLength = 6;
        for (Threshold threshold : this.thresholds) {
            dataLength += threshold.getDataLength();
        }
        return dataLength;
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(0);
        littleEndianOutput.writeByte(0);
        littleEndianOutput.writeByte(this.iconSet.num);
        littleEndianOutput.writeByte(this.iconSet.id);
        littleEndianOutput.writeByte(this.options);
        for (Threshold threshold : this.thresholds) {
            threshold.serialize(littleEndianOutput);
        }
    }
}
