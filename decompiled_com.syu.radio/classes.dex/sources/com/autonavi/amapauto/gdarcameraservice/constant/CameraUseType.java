package com.autonavi.amapauto.gdarcameraservice.constant;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class CameraUseType {
    public static final int AR_NAVI_CAMERA = 0;
    public static final int COMMON_CAMERA = 1;
    private int type;

    private CameraUseType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }
}
