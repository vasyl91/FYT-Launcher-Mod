package org.apache.poi.ss.format;

import java.awt.Color;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CellFormatResult {
    public final boolean applies;
    public final String text;
    public final Color textColor;

    public CellFormatResult(boolean z, String str, Color color) throws IllegalArgumentException {
        this.applies = z;
        if (str == null) {
            throw new IllegalArgumentException("CellFormatResult text may not be null");
        }
        this.text = str;
        this.textColor = z ? color : null;
    }
}
