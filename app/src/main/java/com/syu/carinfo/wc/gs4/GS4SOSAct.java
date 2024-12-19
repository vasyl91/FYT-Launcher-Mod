package com.syu.carinfo.wc.gs4;

import android.app.Activity;
import android.os.Bundle;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GS4SOSAct extends Activity {
    public static GS4SOSAct mInstance;
    public static boolean mIsFront = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_289_wc_gs4_car_sos);
        mInstance = this;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        FuncMain.setChannel(13);
        mIsFront = true;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
    }
}
