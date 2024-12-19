package com.syu.canbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class CarBtActi extends Activity {
    public static CarBtActi mInstance;
    public static boolean mIsFront = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_crv_bt);
        mInstance = this;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        FuncMain.setChannel(12);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        FuncMain.setChannel(0);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            FuncMain.setChannel(0);
            return true;
        }
        return true;
    }
}
