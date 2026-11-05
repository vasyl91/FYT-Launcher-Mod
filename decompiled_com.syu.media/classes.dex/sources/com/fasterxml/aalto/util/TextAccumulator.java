package com.fasterxml.aalto.util;

import chip.FinalChip;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class TextAccumulator {
    private String mText = null;
    private StringBuilder mBuilder = null;

    public boolean hasText() {
        return (this.mBuilder == null && this.mText == null) ? false : true;
    }

    public void addText(String str) {
        int length = str.length();
        if (length > 0) {
            if (this.mText != null) {
                StringBuilder sb = new StringBuilder(this.mText.length() + length);
                this.mBuilder = sb;
                sb.append(this.mText);
                this.mText = null;
            }
            StringBuilder sb2 = this.mBuilder;
            if (sb2 != null) {
                sb2.append(str);
            } else {
                this.mText = str;
            }
        }
    }

    public void addText(char[] cArr, int i, int i2) {
        int i3 = i2 - i;
        if (i3 > 0) {
            if (this.mText != null) {
                StringBuilder sb = new StringBuilder(this.mText.length() + i3);
                this.mBuilder = sb;
                sb.append(this.mText);
                this.mText = null;
            } else if (this.mBuilder == null) {
                this.mBuilder = new StringBuilder(i3);
            }
            this.mBuilder.append(cArr, i, i3);
        }
    }

    public String getAndClear() {
        String str = this.mText;
        if (str != null) {
            this.mText = null;
            return str;
        }
        StringBuilder sb = this.mBuilder;
        if (sb == null) {
            return FinalChip.BSP_PLATFORM_Null;
        }
        String string = sb.toString();
        this.mBuilder = null;
        return string;
    }
}
