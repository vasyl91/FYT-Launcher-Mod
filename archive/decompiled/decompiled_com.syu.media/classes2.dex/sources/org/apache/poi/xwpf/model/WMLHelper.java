package org.apache.poi.xwpf.model;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class WMLHelper {
    public static boolean convertSTOnOffToBoolean(STOnOff.Enum r1) {
        return r1 == STOnOff.TRUE || r1 == STOnOff.ON || r1 == STOnOff.X_1;
    }

    public static STOnOff.Enum convertBooleanToSTOnOff(boolean z) {
        return z ? STOnOff.TRUE : STOnOff.FALSE;
    }
}
