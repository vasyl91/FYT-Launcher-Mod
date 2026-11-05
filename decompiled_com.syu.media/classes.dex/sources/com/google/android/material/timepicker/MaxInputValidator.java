package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;
import chip.FinalChip;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class MaxInputValidator implements InputFilter {
    private int max;

    public MaxInputValidator(int i) {
        this.max = i;
    }

    public void setMax(int i) {
        this.max = i;
    }

    public int getMax() {
        return this.max;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i3, i4, charSequence.subSequence(i, i2).toString());
            if (Integer.parseInt(sb.toString()) <= this.max) {
                return null;
            }
            return FinalChip.BSP_PLATFORM_Null;
        } catch (NumberFormatException unused) {
            return FinalChip.BSP_PLATFORM_Null;
        }
    }
}
