package org.apache.poi.hssf.record;

import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class WindowOneRecord extends StandardRecord {
    public static final short sid = 61;
    private short field_1_h_hold;
    private short field_2_v_hold;
    private short field_3_width;
    private short field_4_height;
    private short field_5_options;
    private int field_6_active_sheet;
    private int field_7_first_visible_tab;
    private short field_8_num_selected_tabs;
    private short field_9_tab_width_ratio;
    private static final BitField hidden = BitFieldFactory.getInstance(1);
    private static final BitField iconic = BitFieldFactory.getInstance(2);
    private static final BitField reserved = BitFieldFactory.getInstance(4);
    private static final BitField hscroll = BitFieldFactory.getInstance(8);
    private static final BitField vscroll = BitFieldFactory.getInstance(16);
    private static final BitField tabs = BitFieldFactory.getInstance(32);

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 18;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 61;
    }

    public WindowOneRecord() {
    }

    public WindowOneRecord(RecordInputStream recordInputStream) {
        this.field_1_h_hold = recordInputStream.readShort();
        this.field_2_v_hold = recordInputStream.readShort();
        this.field_3_width = recordInputStream.readShort();
        this.field_4_height = recordInputStream.readShort();
        this.field_5_options = recordInputStream.readShort();
        this.field_6_active_sheet = recordInputStream.readShort();
        this.field_7_first_visible_tab = recordInputStream.readShort();
        this.field_8_num_selected_tabs = recordInputStream.readShort();
        this.field_9_tab_width_ratio = recordInputStream.readShort();
    }

    public void setHorizontalHold(short s) {
        this.field_1_h_hold = s;
    }

    public void setVerticalHold(short s) {
        this.field_2_v_hold = s;
    }

    public void setWidth(short s) {
        this.field_3_width = s;
    }

    public void setHeight(short s) {
        this.field_4_height = s;
    }

    public void setOptions(short s) {
        this.field_5_options = s;
    }

    public void setHidden(boolean z) {
        this.field_5_options = hidden.setShortBoolean(this.field_5_options, z);
    }

    public void setIconic(boolean z) {
        this.field_5_options = iconic.setShortBoolean(this.field_5_options, z);
    }

    public void setDisplayHorizonalScrollbar(boolean z) {
        this.field_5_options = hscroll.setShortBoolean(this.field_5_options, z);
    }

    public void setDisplayVerticalScrollbar(boolean z) {
        this.field_5_options = vscroll.setShortBoolean(this.field_5_options, z);
    }

    public void setDisplayTabs(boolean z) {
        this.field_5_options = tabs.setShortBoolean(this.field_5_options, z);
    }

    public void setActiveSheetIndex(int i) {
        this.field_6_active_sheet = i;
    }

    public void setFirstVisibleTab(int i) {
        this.field_7_first_visible_tab = i;
    }

    public void setNumSelectedTabs(short s) {
        this.field_8_num_selected_tabs = s;
    }

    public void setTabWidthRatio(short s) {
        this.field_9_tab_width_ratio = s;
    }

    public short getHorizontalHold() {
        return this.field_1_h_hold;
    }

    public short getVerticalHold() {
        return this.field_2_v_hold;
    }

    public short getWidth() {
        return this.field_3_width;
    }

    public short getHeight() {
        return this.field_4_height;
    }

    public short getOptions() {
        return this.field_5_options;
    }

    public boolean getHidden() {
        return hidden.isSet(this.field_5_options);
    }

    public boolean getIconic() {
        return iconic.isSet(this.field_5_options);
    }

    public boolean getDisplayHorizontalScrollbar() {
        return hscroll.isSet(this.field_5_options);
    }

    public boolean getDisplayVerticalScrollbar() {
        return vscroll.isSet(this.field_5_options);
    }

    public boolean getDisplayTabs() {
        return tabs.isSet(this.field_5_options);
    }

    public int getActiveSheetIndex() {
        return this.field_6_active_sheet;
    }

    public int getFirstVisibleTab() {
        return this.field_7_first_visible_tab;
    }

    public short getNumSelectedTabs() {
        return this.field_8_num_selected_tabs;
    }

    public short getTabWidthRatio() {
        return this.field_9_tab_width_ratio;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        return "[WINDOW1]\n    .h_hold          = " + Integer.toHexString(getHorizontalHold()) + "\n    .v_hold          = " + Integer.toHexString(getVerticalHold()) + "\n    .width           = " + Integer.toHexString(getWidth()) + "\n    .height          = " + Integer.toHexString(getHeight()) + "\n    .options         = " + Integer.toHexString(getOptions()) + "\n        .hidden      = " + getHidden() + "\n        .iconic      = " + getIconic() + "\n        .hscroll     = " + getDisplayHorizontalScrollbar() + "\n        .vscroll     = " + getDisplayVerticalScrollbar() + "\n        .tabs        = " + getDisplayTabs() + "\n    .activeSheet     = " + Integer.toHexString(getActiveSheetIndex()) + "\n    .firstVisibleTab    = " + Integer.toHexString(getFirstVisibleTab()) + "\n    .numselectedtabs = " + Integer.toHexString(getNumSelectedTabs()) + "\n    .tabwidthratio   = " + Integer.toHexString(getTabWidthRatio()) + "\n[/WINDOW1]\n";
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getHorizontalHold());
        littleEndianOutput.writeShort(getVerticalHold());
        littleEndianOutput.writeShort(getWidth());
        littleEndianOutput.writeShort(getHeight());
        littleEndianOutput.writeShort(getOptions());
        littleEndianOutput.writeShort(getActiveSheetIndex());
        littleEndianOutput.writeShort(getFirstVisibleTab());
        littleEndianOutput.writeShort(getNumSelectedTabs());
        littleEndianOutput.writeShort(getTabWidthRatio());
    }
}
