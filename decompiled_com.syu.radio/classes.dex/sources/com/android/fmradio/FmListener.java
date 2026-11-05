package com.android.fmradio;

import android.os.Bundle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface FmListener {
    public static final String CALLBACK_FLAG = "callback_flag";
    public static final String KEY_AUDIOFOCUS_CHANGED = "key_audiofocus_changed";
    public static final String KEY_IS_RECORDING_MODE = "key_is_recording_mode";
    public static final String KEY_IS_SCAN = "key_is_scan";
    public static final String KEY_IS_SEEK = "key_is_seek";
    public static final String KEY_IS_SPEAKER_MODE = "key_is_speaker_mode";
    public static final String KEY_IS_SWITCH_ANTENNA = "key_is_switch_antenna";
    public static final String KEY_IS_TUNE = "key_is_tune";
    public static final String KEY_PS_INFO = "key_ps_info";
    public static final String KEY_RDS_STATION = "key_rds_station";
    public static final String KEY_RECORDING_ERROR_TYPE = "key_recording_error_type";
    public static final String KEY_RECORDING_STATE = "key_is_recording_state";
    public static final String KEY_RT_INFO = "key_rt_info";
    public static final String KEY_SCAN_FREQ = "fm_scan_freq";
    public static final String KEY_SEEK_TO_STATION = "key_seek_to_station";
    public static final String KEY_STATION_NUM = "key_station_num";
    public static final String KEY_TUNE_TO_STATION = "key_tune_to_station";
    public static final int LISTEN_PS_CHANGED = 1048593;
    public static final int LISTEN_RDSSTATION_CHANGED = 1048592;
    public static final int LISTEN_RECORDERROR = 1048848;
    public static final int LISTEN_RECORDMODE_CHANGED = 1048849;
    public static final int LISTEN_RECORDSTATE_CHANGED = 1048833;
    public static final int LISTEN_RT_CHANGED = 1048832;
    public static final int LISTEN_SPEAKER_MODE_CHANGED = 1052672;
    public static final int MSGID_ACTIVE_AF_FINISHED = 18;
    public static final int MSGID_ANTENNA_UNAVAILABE = 3;
    public static final int MSGID_AUDIOFOCUS_FAILED = 14;
    public static final int MSGID_FM_EXIT = 11;
    public static final int MSGID_FM_HEADSET_NEXT = 41;
    public static final int MSGID_POWERDOWN_FINISHED = 10;
    public static final int MSGID_POWERUP_FINISHED = 9;
    public static final int MSGID_RECORD_ERROR = 20;
    public static final int MSGID_RECORD_MODE_CHANED = 21;
    public static final int MSGID_RECORD_STATE_CHANGED = 19;
    public static final int MSGID_REFRESH = 101;
    public static final int MSGID_REFRESH_SCANFREQ = 55;
    public static final int MSGID_SAVERECORDING_FINISHED = 26;
    public static final int MSGID_SCAN_CANCELED = 12;
    public static final int MSGID_SCAN_FINISHED = 13;
    public static final int MSGID_SEEK_FINISHED = 16;
    public static final int MSGID_SEEK_FINISHED_PTY = 28;
    public static final int MSGID_SEEK_FINISHED_TA = 27;
    public static final int MSGID_SET_CHANNEL_FINISHED = 6;
    public static final int MSGID_SET_MUTE_FINISHED = 7;
    public static final int MSGID_SET_RDS_FINISHED = 5;
    public static final int MSGID_STARTPLAYBACK_FINISHED = 24;
    public static final int MSGID_STARTRECORDING_FINISHED = 22;
    public static final int MSGID_STOPPLAYBACK_FINISHED = 25;
    public static final int MSGID_STOPRECORDING_FINISHED = 23;
    public static final int MSGID_SWITCH_ANTENNA = 4;
    public static final int MSGID_TUNE_FINISHED = 15;
    public static final int MSGID_UPDATE_CURRENT_STATION = 2;
    public static final int MSGID_UPDATE_RDS = 1;
    public static final int NOT_AUDIO_FOCUS = 33;
    public static final String SWITCH_ANTENNA_VALUE = "switch_antenna_value";

    void onCallBack(Bundle bundle);
}
