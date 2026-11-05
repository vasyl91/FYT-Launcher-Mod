package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.ConditionFilterData;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFConditionFilterData implements ConditionFilterData {
    private final CTCfRule _cfRule;

    XSSFConditionFilterData(CTCfRule cTCfRule) {
        this._cfRule = cTCfRule;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionFilterData
    public boolean getAboveAverage() {
        return this._cfRule.getAboveAverage();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionFilterData
    public boolean getBottom() {
        return this._cfRule.getBottom();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionFilterData
    public boolean getEqualAverage() {
        return this._cfRule.getEqualAverage();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionFilterData
    public boolean getPercent() {
        return this._cfRule.getPercent();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionFilterData
    public long getRank() {
        return this._cfRule.getRank();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionFilterData
    public int getStdDev() {
        return this._cfRule.getStdDev();
    }
}
