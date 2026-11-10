package com.syu.remote;

import java.util.Arrays;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Message {
    public int code;
    public float[] flts;
    public int[] ints;

    /* JADX INFO: renamed from: module, reason: collision with root package name */
    public int f4module;
    public String[] strs;

    public Message(int i, int i2, int[] iArr, float[] fArr, String[] strArr) {
        this.f4module = i;
        this.code = i2;
        this.ints = iArr;
        this.flts = fArr;
        this.strs = strArr;
    }

    public String toString() {
        return "Message{module=" + this.f4module + ", code=" + this.code + ", ints=" + Arrays.toString(this.ints) + ", flts=" + Arrays.toString(this.flts) + ", strs=" + Arrays.toString(this.strs) + '}';
    }
}
