package com.autonavi.amapauto.gdarcameraservice.utils;

import com.autonavi.amapauto.gdarcameraservice.constant.MemoryFileFlag;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class SharedMemUtils {
    public static final int HEADER_SIZE = 20;
    public static final byte VERSION_CODE = 1;

    public static void initHeader(byte[] header) {
        if (header != null && header.length >= 20) {
            header[0] = MemoryFileFlag.CAN_WRITE.getFlag();
            header[1] = 1;
        }
    }

    public static boolean canRead(byte[] header) {
        return header != null && header.length >= 20 && header[0] == MemoryFileFlag.CAN_READ.getFlag();
    }

    public static boolean setCanRead(byte[] header) {
        if (header == null || header.length < 20) {
            return false;
        }
        header[0] = MemoryFileFlag.CAN_READ.getFlag();
        return true;
    }

    public static boolean canWrite(byte[] header) {
        return header != null && header.length >= 20 && header[0] == MemoryFileFlag.CAN_WRITE.getFlag();
    }

    public static boolean setWritable(byte[] header) {
        if (header == null || header.length < 20) {
            return false;
        }
        header[0] = MemoryFileFlag.CAN_WRITE.getFlag();
        return true;
    }

    public static boolean setOffset(byte[] header, int start) {
        if (header == null || header.length < 20) {
            return false;
        }
        header[2] = (byte) (start >> 24);
        header[3] = (byte) ((16711680 & start) >> 16);
        header[4] = (byte) ((65280 & start) >> 8);
        header[5] = (byte) (start & 255);
        return true;
    }

    public static int getOffset(byte[] header) {
        if (header == null || header.length < 20) {
            return -1;
        }
        int result = header[2] & 255;
        return (((((result << 8) | (header[3] & 255)) << 8) | (header[4] & 255)) << 8) | (header[5] & 255);
    }

    public static boolean setLength(byte[] header, int length) {
        if (header == null || header.length < 20) {
            return false;
        }
        header[6] = (byte) (length >> 24);
        header[7] = (byte) ((16711680 & length) >> 16);
        header[8] = (byte) ((65280 & length) >> 8);
        header[9] = (byte) (length & 255);
        return true;
    }

    public static int getLength(byte[] header) {
        if (header == null || header.length < 20) {
            return -1;
        }
        int result = header[6] & 255;
        return (((((result << 8) | (header[7] & 255)) << 8) | (header[8] & 255)) << 8) | (header[9] & 255);
    }

    public static boolean setContentSize(byte[] header, int contentSize) {
        if (header == null || header.length < 20) {
            return false;
        }
        header[10] = (byte) (contentSize >>> 24);
        header[11] = (byte) (contentSize >>> 16);
        header[12] = (byte) (contentSize >>> 8);
        header[13] = (byte) contentSize;
        return true;
    }

    public static int getContentSize(byte[] header) {
        if (header == null || header.length < 20) {
            return -1;
        }
        int result = header[10] & 255;
        return (((((result << 8) | (header[11] & 255)) << 8) | (header[12] & 255)) << 8) | (header[13] & 255);
    }
}
