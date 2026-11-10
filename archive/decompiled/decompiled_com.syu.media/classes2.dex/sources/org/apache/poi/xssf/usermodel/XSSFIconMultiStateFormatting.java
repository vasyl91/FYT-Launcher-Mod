package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
import org.apache.poi.ss.usermodel.IconMultiStateFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfvo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STIconSetType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFIconMultiStateFormatting implements IconMultiStateFormatting {
    CTIconSet _iconset;

    XSSFIconMultiStateFormatting(CTIconSet cTIconSet) {
        this._iconset = cTIconSet;
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public IconMultiStateFormatting.IconSet getIconSet() {
        return IconMultiStateFormatting.IconSet.byName(this._iconset.getIconSet().toString());
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public void setIconSet(IconMultiStateFormatting.IconSet iconSet) {
        this._iconset.setIconSet(STIconSetType.Enum.forString(iconSet.name));
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public boolean isIconOnly() {
        if (this._iconset.isSetShowValue()) {
            return !this._iconset.getShowValue();
        }
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public void setIconOnly(boolean z) {
        this._iconset.setShowValue(!z);
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public boolean isReversed() {
        if (this._iconset.isSetReverse()) {
            return this._iconset.getReverse();
        }
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public void setReversed(boolean z) {
        this._iconset.setReverse(z);
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public XSSFConditionalFormattingThreshold[] getThresholds() {
        CTCfvo[] cfvoArray = this._iconset.getCfvoArray();
        XSSFConditionalFormattingThreshold[] xSSFConditionalFormattingThresholdArr = new XSSFConditionalFormattingThreshold[cfvoArray.length];
        for (int i = 0; i < cfvoArray.length; i++) {
            xSSFConditionalFormattingThresholdArr[i] = new XSSFConditionalFormattingThreshold(cfvoArray[i]);
        }
        return xSSFConditionalFormattingThresholdArr;
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public void setThresholds(ConditionalFormattingThreshold[] conditionalFormattingThresholdArr) {
        CTCfvo[] cTCfvoArr = new CTCfvo[conditionalFormattingThresholdArr.length];
        for (int i = 0; i < conditionalFormattingThresholdArr.length; i++) {
            cTCfvoArr[i] = ((XSSFConditionalFormattingThreshold) conditionalFormattingThresholdArr[i]).getCTCfvo();
        }
        this._iconset.setCfvoArray(cTCfvoArr);
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public XSSFConditionalFormattingThreshold createThreshold() {
        return new XSSFConditionalFormattingThreshold(this._iconset.addNewCfvo());
    }
}
