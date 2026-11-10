package com.syu.ipc;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ModuleObject {
    public float[] flts;
    public int[] ints;
    public String[] strs;

    public ModuleObject() {
    }

    public ModuleObject(int i) {
        this.ints = new int[]{i};
    }

    public static boolean checkInts(ModuleObject moduleObject, int i) {
        int[] iArr;
        return (moduleObject == null || (iArr = moduleObject.ints) == null || iArr.length < i) ? false : true;
    }

    public static int get(ModuleObject moduleObject, int i) {
        int[] iArr;
        return (moduleObject == null || (iArr = moduleObject.ints) == null || iArr.length < 1) ? i : iArr[0];
    }

    public ModuleObject(int i, String str) {
        this.ints = new int[]{i};
        this.strs = new String[]{str};
    }

    public static int get(RemoteModuleProxy remoteModuleProxy, int i, int i2) {
        int[] iArr;
        ModuleObject moduleObject = remoteModuleProxy.get(i, null, null, null);
        return (moduleObject == null || (iArr = moduleObject.ints) == null || iArr.length < 1) ? i2 : iArr[0];
    }

    public ModuleObject(String str) {
        this.strs = new String[]{str};
    }

    public static String get(ModuleObject moduleObject, String str) {
        String[] strArr;
        return (moduleObject == null || (strArr = moduleObject.strs) == null || strArr.length < 1) ? str : strArr[0];
    }

    public ModuleObject(int[] iArr) {
        this.ints = iArr;
    }
}
