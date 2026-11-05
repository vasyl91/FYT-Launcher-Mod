package com.syu.manger.module.radio;

import chip.FinalChip;
import kotlin.Metadata;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/syu/manger/module/radio/RadioConstants;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "BAND_STORED_STATION_NUM", "I", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "a", "[Ljava/lang/String;", "getPTY_DISPLAY", "()[Ljava/lang/String;", "PTY_DISPLAY", "b", "getFREQ_UNIT", "FREQ_UNIT", "c", "getBAND_NAME", "BAND_NAME", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final class RadioConstants {
    public static final int BAND_STORED_STATION_NUM = 6;
    public static final RadioConstants INSTANCE = new RadioConstants();

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public static final String[] PTY_DISPLAY = {" NO PTY ", "  News  ", "Affairs ", "  Info  ", " Sport  ", "Educate ", " Drama  ", "Culture ", "Science ", " Varied ", " Pop M  ", " Rock M ", " Easy M ", "Light M ", "Classics", "Other M ", "Weather ", "Finance ", "Children", " Social ", "Religion", "Phone In", " Travel ", "Leisure ", "  Jazz  ", "Country ", "Nation M", " Oldies ", " Folk M ", "Document", "  Test  ", " Alarm  ", "PTY Seek", "        ", " TA ON  ", " TA OFF ", " TA SEEK", " AF ON  ", " AF OFF ", " AF SEEK", "PTY SEEK"};

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final String[] FREQ_UNIT = {"KHz", "MHz"};

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final String[] BAND_NAME = {"AM-1", "AM-2", "AM-3", "FM-1", "FM-2", "FM-3"};

    public final String[] getBAND_NAME() {
        return BAND_NAME;
    }

    public final String[] getFREQ_UNIT() {
        return FREQ_UNIT;
    }

    public final String[] getPTY_DISPLAY() {
        return PTY_DISPLAY;
    }
}
