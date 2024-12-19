package com.syu.util;

import android.util.Log;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Print {
    public static void screenMsg(String msg) {
        ObjApp.getMsgView().msg(msg);
    }

    public static void jumpPage(String msg) {
    }

    public static void screenMsg2(String msg) {
    }

    public static void screenVolMsg(String msg) {
    }

    public static void videoPortMsg(String msg) {
    }

    public static void dvd8288(String msg) {
    }

    public static void bd3702(String msg) {
    }

    public static void ipod(String msg) {
    }

    public static void ipodMsg(String msg) {
    }

    public static String hex(byte[] data, int start, int length) {
        StringBuilder sb = new StringBuilder(length);
        int end = start + length;
        for (int i = start; i < end; i++) {
            sb.append(String.format("%02X ", Byte.valueOf(data[i])));
        }
        return sb.toString();
    }

    public static String hex(int[] data, int start, int length) {
        StringBuilder sb = new StringBuilder(length);
        int end = start + length;
        for (int i = start; i < end; i++) {
            sb.append(String.format("%02X ", Integer.valueOf(data[i])));
        }
        return sb.toString();
    }

    public static String ascii(byte[] data, int start, int length) {
        StringBuilder sb = new StringBuilder(length);
        int end = start + length;
        for (int i = start; i < end; i++) {
            sb.append(String.valueOf((char) data[i]) + " ");
        }
        return sb.toString();
    }

    public static void logHex(String TAG, byte[] data, int start, int length) {
    }

    public static void log(String TAG, String msg) {
        Log.d(TAG, msg);
    }

    public static void logAscii(String TAG, byte[] data, int start, int length) {
    }

    public static void screenHex(byte[] data, int start, int length) {
    }

    public static void screenModuleCmd(String TAG, int cmdCode, int[] ints, float[] flts, String[] strs) {
    }

    public static void LogModuleCmd(String TAG, int cmdCode, int[] ints, float[] flts, String[] strs) {
    }

    public static String formatModuleCmd(int cmdCode, int[] ints, float[] flts, String[] strs) {
        StringBuilder sb = new StringBuilder(100);
        sb.append("[code\t" + cmdCode + "] ");
        if (ints != null && ints.length > 0) {
            sb.append("[ints");
            for (int i : ints) {
                sb.append(" " + i);
            }
            sb.append("] ");
        }
        if (flts != null && flts.length > 0) {
            sb.append("[flts");
            for (float f : flts) {
                sb.append(" " + f);
            }
            sb.append("] ");
        }
        if (strs != null && strs.length > 0) {
            sb.append("[strs");
            for (String s : strs) {
                sb.append(" " + s);
            }
            sb.append("]");
        }
        return sb.toString();
    }

    public static String appId2Str(int appId) {
        switch (appId) {
            case 0:
                return "APP_ID_NULL";
            case 1:
                return "APP_ID_RADIO";
            case 2:
                return "APP_ID_BTPHONE";
            case 3:
                return "APP_ID_BTAV";
            case 4:
                return "APP_ID_DVD";
            case 5:
                return "APP_ID_AUX";
            case 6:
                return "APP_ID_TV";
            case 7:
                return "APP_ID_IPOD";
            case 8:
                return "APP_ID_AUDIO_PLAYER";
            case 9:
                return "APP_ID_VIDEO_PLAYER";
            case 10:
                return "APP_ID_THIRD_PLAYER";
            case 11:
                return "APP_ID_CAR_RADIO";
            case 12:
                return "APP_ID_CAR_BTPHONE";
            case 13:
                return "APP_ID_CAR_USB";
            default:
                String result = new StringBuilder().append(appId).toString();
                return result;
        }
    }
}
