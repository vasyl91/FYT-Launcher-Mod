package com.autonavi.amapauto.gdarcameraservice.constant;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public enum MemoryFileFlag {
    CAN_READ((byte) 0),
    CAN_WRITE((byte) 1);

    private byte flag;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static MemoryFileFlag[] valuesCustom() {
        MemoryFileFlag[] memoryFileFlagArrValuesCustom = values();
        int length = memoryFileFlagArrValuesCustom.length;
        MemoryFileFlag[] memoryFileFlagArr = new MemoryFileFlag[length];
        System.arraycopy(memoryFileFlagArrValuesCustom, 0, memoryFileFlagArr, 0, length);
        return memoryFileFlagArr;
    }

    MemoryFileFlag(byte flag) {
        this.flag = flag;
    }

    public byte getFlag() {
        return this.flag;
    }
}
