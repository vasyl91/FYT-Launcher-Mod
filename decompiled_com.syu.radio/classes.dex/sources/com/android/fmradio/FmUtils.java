package com.android.fmradio;

import com.lsec.core.util.data.AutoKeyEvent;
import com.lsec.core.util.data.FinalChip;
import com.syu.radio.App_Radio;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FmUtils {
    public static final int AM_BAND1 = 4;
    public static final int AM_BAND2 = 5;
    public static final int FM_BAND1 = 1;
    public static final int FM_BAND2 = 2;
    public static final int FM_BAND3 = 3;
    public static int mCurStation;
    public static int mDispStation;
    public static int mFmSens_Default = 10;
    public static int mFmSens_Min = 0;
    public static int mFmSens_Max = 100;
    public static int mAmSens_Default = 47;
    public static int mAmSens_Min = 0;
    public static int mAmSens_Max = 100;
    public static int HIGHEST_STATION_FM = 10800;
    public static int LOWEST_STATION_FM = 8750;
    public static int STEP_FM = 10;
    public static int HIGHEST_STATION_AM = 1620;
    public static int LOWEST_STATION_AM = AutoKeyEvent.KEYCODE_GUIDE;
    public static int STEP_AM = 9;
    public static int HIGHEST_STATION_OIRT = 0;
    public static int LOWEST_STATION_OIRT = 0;
    public static int STEP_OIRT = 0;
    public static boolean mSearch = false;
    public static boolean mScan = false;
    public static boolean mStopScan = false;
    public static int mBand = 1;
    public static String mStrFreqRange = FinalChip.BSP_PLATFORM_Null;
    public static int[] mFreqDefault = new int[30];
    public static int[] mIndexRadio = new int[5];

    static {
        mFreqDefault[0] = 8750;
        mFreqDefault[1] = 9010;
        mFreqDefault[2] = 9810;
        mFreqDefault[3] = 10610;
        mFreqDefault[4] = 10800;
        for (int i = 5; i < 18; i++) {
            mFreqDefault[i] = 8750;
        }
        mFreqDefault[18] = 522;
        mFreqDefault[19] = 603;
        mFreqDefault[20] = 999;
        mFreqDefault[21] = 1404;
        mFreqDefault[22] = 1620;
        for (int i2 = 23; i2 < 30; i2++) {
            mFreqDefault[i2] = 522;
        }
    }

    public static int getDefaultStation() {
        if (mBand <= 3) {
            if (App_Radio.iRadioType_Arm == 2) {
                boolean bIsOirtFMBand1 = FmService.isAreaOirtFMBand1(mBand);
                if (bIsOirtFMBand1) {
                    return LOWEST_STATION_OIRT;
                }
            }
            return LOWEST_STATION_FM;
        }
        return LOWEST_STATION_AM;
    }

    public static boolean isValidStation(int station) {
        return isValidStation(station, mBand);
    }

    public static boolean isValidStation(int station, int band) {
        if (band > 3) {
            return station >= LOWEST_STATION_AM && station <= HIGHEST_STATION_AM;
        }
        boolean bIsOirtFMBand1 = FmService.isAreaOirtFMBand1(band);
        if (bIsOirtFMBand1) {
            return station >= LOWEST_STATION_OIRT && station <= HIGHEST_STATION_OIRT;
        }
        return station >= LOWEST_STATION_FM && station <= HIGHEST_STATION_FM;
    }

    public static int computeIncreaseStation() {
        int result = mCurStation;
        if (mBand <= 3) {
            boolean bIsOirtFMBand1 = FmService.isAreaOirtFMBand1(mBand);
            if (bIsOirtFMBand1) {
                int result2 = result + STEP_OIRT;
                if (result2 > HIGHEST_STATION_OIRT) {
                    return LOWEST_STATION_OIRT;
                }
                return result2;
            }
            int result3 = result + STEP_FM;
            if (result3 > HIGHEST_STATION_FM) {
                return LOWEST_STATION_FM;
            }
            return result3;
        }
        int result4 = result + STEP_AM;
        if (result4 > HIGHEST_STATION_AM) {
            return LOWEST_STATION_AM;
        }
        return result4;
    }

    public static int computeDecreaseStation() {
        int result = mCurStation;
        if (mBand <= 3) {
            boolean bIsOirtFMBand1 = FmService.isAreaOirtFMBand1(mBand);
            if (bIsOirtFMBand1) {
                int result2 = result - STEP_OIRT;
                if (result2 < LOWEST_STATION_OIRT) {
                    return HIGHEST_STATION_OIRT;
                }
                return result2;
            }
            int result3 = result - STEP_FM;
            if (result3 < LOWEST_STATION_FM) {
                return HIGHEST_STATION_FM;
            }
            return result3;
        }
        int result4 = result - STEP_AM;
        if (result4 < LOWEST_STATION_AM) {
            return HIGHEST_STATION_AM;
        }
        return result4;
    }

    public static int trans2KB(float freq) {
        return freq < 200.0f ? (int) (100.0f * freq) : (int) freq;
    }

    public static float trans2Freq(int station) {
        return station > 5000 ? ((station * 10) + 2) / 1000.0f : station;
    }

    public static int getDefaultFmSens() {
        return mFmSens_Default;
    }

    public static int getDefaultAmSens() {
        return mAmSens_Default;
    }

    public static int getFmSensitivity(boolean bLoc) {
        int sens = FmService.mFmSenstivity;
        if (FmService.mAutoSensitivity) {
            sens = getDefaultFmSens();
        }
        if (bLoc) {
            return sens + App_Radio.mSens_Step;
        }
        return sens;
    }

    public static int getAmSensitivity() {
        int sens = FmService.mAmSenstivity;
        if (FmService.mAutoSensitivity) {
            int sens2 = getDefaultAmSens();
            return sens2;
        }
        return sens;
    }
}
