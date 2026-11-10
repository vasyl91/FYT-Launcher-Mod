package com.syu.radio;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface Interface_RadioPage {
    void Func_Search();

    void ResponseClick(int i);

    boolean ResponseClick_Menu(int i);

    void ResponseLongClick(int i);

    boolean ResponseLongClick_Menu(int i);

    void checkTuneFromSpeech();

    void disLoading();

    void hideScan();

    void initPara();

    void jump1stChannel();

    void jump1stChannel_AtSoon();

    void onNotify(int i, int[] iArr, float[] fArr, String[] strArr);

    void refreshStationUI();

    void setBtnBk();

    void setPara(int i);

    void showHideScan();

    void showLoading();

    void switchBand(boolean z, boolean z2, boolean z3);

    void updateBandFocus(boolean z);

    void updateChannelTxt();

    void updateCurrentFreq(int i, boolean z);

    void updateHalfScreenVisble();

    void updateListRadio();

    void updateStFocus();
}
