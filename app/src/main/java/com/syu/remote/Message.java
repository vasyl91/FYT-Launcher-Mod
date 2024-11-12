package com.syu.remote;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class Message {
    public int code;
    public float[] flts;
    public int[] ints;
    public int module;
    public String[] strs;

    public Message(int module, int code, int[] ints, float[] flts, String[] strs) {
        this.module = module;
        this.code = code;
        this.ints = ints;
        this.flts = flts;
        this.strs = strs;
    }
}
