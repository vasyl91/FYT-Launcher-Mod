package com.syu.carinfo.wc2.weichai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WC2WeiChaiAct extends BaseActivity {
    private CheckedTextView mBtnSettings;
    private CheckedTextView mBtnShowLight;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (this.mBtnShowLight != null) {
            this.mBtnShowLight.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc2.weichai.WC2WeiChaiAct.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        WC2WeiChaiAct.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if (this.mBtnSettings != null) {
            this.mBtnSettings.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc2.weichai.WC2WeiChaiAct.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(WC2WeiChaiAct.this, WC2WeiChaiAirControlAct.class);
                        WC2WeiChaiAct.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
