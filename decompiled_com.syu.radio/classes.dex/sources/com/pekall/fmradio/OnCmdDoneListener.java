package com.pekall.fmradio;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface OnCmdDoneListener {
    public static final int FM_CMD_CLOSE = 3;
    public static final int FM_CMD_GET_AUDIO_MODE = 6;
    public static final int FM_CMD_GET_BAND = 4;
    public static final int FM_CMD_GET_FREQ = 10;
    public static final int FM_CMD_GET_VOLUME = 14;
    public static final int FM_CMD_IS_MUTE = 8;
    public static final int FM_CMD_NONE = -1;
    public static final int FM_CMD_NOTIFY_RDS = 23;
    public static final int FM_CMD_OPEN = 2;
    public static final int FM_CMD_POWEROFF = 1;
    public static final int FM_CMD_POWERON = 0;
    public static final int FM_CMD_SEEK = 12;
    public static final int FM_CMD_SEND_RDS_RAW_DATA = 22;
    public static final int FM_CMD_SEND_RDS_STRING = 20;
    public static final int FM_CMD_SET_AUDIO_MODE = 7;
    public static final int FM_CMD_SET_BAND = 5;
    public static final int FM_CMD_SET_FREQ = 11;
    public static final int FM_CMD_SET_MUTE = 9;
    public static final int FM_CMD_SET_OUTPUT_MODE = 21;
    public static final int FM_CMD_SET_VOLUME = 15;
    public static final int FM_CMD_STOP_SEEK = 13;
    public static final int FM_CMD_TX_ON = 19;
    public static final int FM_CURRENT_RSSI = 16;
    public static final int FM_SET_DEEMPHASIS_FILTER = 18;
    public static final int FM_SET_RSSI_THRESHOLD = 17;
    public static final int FM_STATUS_FAILED = 1;
    public static final int FM_STATUS_SUCCESS = 0;

    void onCmdDone(int i, int i2, Object obj);
}
