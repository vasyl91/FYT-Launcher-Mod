package com.syu.radio;

import android.app.Activity;
import android.os.Bundle;
import com.lsec.core.frame.app.MyApplication;
import com.syu.radio.act.ActRadio;
import com.syu.radio.data.FinalRadioCtrl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Launch extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!App_Radio.includePage(App_Radio.getInstance().sPage)) {
            MyApplication.sPage_WillBe = FinalRadioCtrl.Page_Radio;
        } else {
            MyApplication.sPage_WillBe = App_Radio.getInstance().sPage;
        }
        MyApplication.myApp.startAct(ActRadio.class);
        finish();
    }
}
