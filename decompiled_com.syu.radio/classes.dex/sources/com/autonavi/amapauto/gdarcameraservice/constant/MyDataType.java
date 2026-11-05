package com.autonavi.amapauto.gdarcameraservice.constant;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class MyDataType {
    public static final int H264 = 1;
    public static final int YUV = 0;
    private int type;

    private MyDataType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }
}
