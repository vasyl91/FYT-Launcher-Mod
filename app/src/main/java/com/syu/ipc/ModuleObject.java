package com.syu.ipc;

public class ModuleObject {
    public float[] flts;
    public int[] ints;
    public String[] strs;

    public ModuleObject() {
    }

    public ModuleObject(int value) {
        this.ints = new int[]{value};
    }

    public ModuleObject(int value, String strValue) {
        this.ints = new int[]{value};
        this.strs = new String[]{strValue};
    }

    public ModuleObject(int[] ints) {
        this.ints = ints;
    }

    public ModuleObject(String value) {
        this.strs = new String[]{value};
    }

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
