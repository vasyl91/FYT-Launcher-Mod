package com.syu.radio.runnable;

import android.util.SparseArray;
import com.syu.radio.Act_Radio;
import com.syu.radio.App_Radio;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class RunnableUpdate implements Runnable {
    private Act_Radio actRadio;
    private SparseArray<String> map;

    public RunnableUpdate(SparseArray<String> map, Act_Radio actRadio) {
        this.map = map;
        this.actRadio = actRadio;
    }

    @Override // java.lang.Runnable
    public void run() {
        App_Radio.getInstance().update(this.map, this.actRadio);
    }
}
