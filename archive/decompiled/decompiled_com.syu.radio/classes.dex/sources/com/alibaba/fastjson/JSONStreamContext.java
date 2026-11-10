package com.alibaba.fastjson;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class JSONStreamContext {
    static final int ArrayValue = 1005;
    static final int PropertyKey = 1002;
    static final int PropertyValue = 1003;
    static final int StartArray = 1004;
    static final int StartObject = 1001;
    private final JSONStreamContext parent;
    private int state;

    public JSONStreamContext(JSONStreamContext parent, int state) {
        this.parent = parent;
        this.state = state;
    }

    public JSONStreamContext getParent() {
        return this.parent;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
