package com.syu.radio;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface Interface_Radio {
    void checkTuneFromSpeech();

    void disLoading();

    void goPage(int i);

    void initPara();

    void initlist(boolean z, boolean z2, boolean z3);

    boolean isTop();

    void jump1stChannel();

    void onKeyDown();

    void onKeyLeft();

    void onKeyRight();

    void onKeyUp();

    void onNotify(int i, int[] iArr, float[] fArr, String[] strArr);

    void refreshStationUI();

    void resetIndexFMAM();

    void scrollOk();

    void scrollToNext();

    void scrollToPrev();

    void setBtnBk();

    void setDayOrNight(int i);

    void setPara(int i);

    void showAfOn();

    void showLoading();

    void showPs();

    void showPty();

    void showRds();

    void showTa();

    void showTaOn();

    void showTp();

    void startCheckSt();

    void stopScan();

    void updateCurrentFreq(int i, boolean z);

    void updateListRadio();

    void updateSearchFreq(int i);
}
