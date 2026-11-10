package com.syu.ipc;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ModuleObject {
    public float[] flts;
    public int[] ints;
    public String[] strs;

    public static boolean checkInts(ModuleObject obj, int min) {
        return (obj == null || obj.ints == null || obj.ints.length < min) ? false : true;
    }

    public static int get(ModuleObject obj, int valueIfNotOk) {
        if (obj != null && obj.ints != null && obj.ints.length >= 1) {
            return obj.ints[0];
        }
        return valueIfNotOk;
    }

    public static String get(ModuleObject obj, String valueIfNotOk) {
        if (obj != null && obj.strs != null && obj.strs.length >= 1) {
            return obj.strs[0];
        }
        return valueIfNotOk;
    }

    public static int get(RemoteModuleProxy proxy, int getCode, int valueIfNotOk) {
        ModuleObject obj = proxy.get(getCode, null, null, null);
        if (obj != null && obj.ints != null && obj.ints.length >= 1) {
            return obj.ints[0];
        }
        return valueIfNotOk;
    }
}
