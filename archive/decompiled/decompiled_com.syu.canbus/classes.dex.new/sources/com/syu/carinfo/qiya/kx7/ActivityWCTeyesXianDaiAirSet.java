package com.syu.carinfo.qiya.kx7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityWCTeyesXianDaiAirSet extends BaseActivity implements View.OnClickListener {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0444_wc_teyes_xiandai_air_settings);
        findViewById(R.id.btn_plus1).setOnClickListener(this);
        findViewById(R.id.btn_plus2).setOnClickListener(this);
        findViewById(R.id.btn_plus3).setOnClickListener(this);
        findViewById(R.id.btn_plus4).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427458 */:
                finish();
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, ActivityWCTeyesXianDaiAirSet2.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, ActivityWCTeyesXianDaiAirSet3.class);
                    startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                try {
                    Intent intent3 = new Intent();
                    intent3.setClass(this, ActivityWCTeyesXianDaiAirSet4.class);
                    startActivity(intent3);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
        }
    }
}
