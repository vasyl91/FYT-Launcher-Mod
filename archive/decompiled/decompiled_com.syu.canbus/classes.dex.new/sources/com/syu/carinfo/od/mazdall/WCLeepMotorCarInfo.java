package com.syu.carinfo.od.mazdall;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WCLeepMotorCarInfo extends TabActivity {
    private RadioGroup mGroup;
    private TabHost mTabHost;
    public TextView mTvTpis;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_leepmotor_carinfo_index);
        init();
    }

    private void init() {
        this.mGroup = (RadioGroup) findViewById(R.id.camry_main_group);
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabCurrent").setIndicator("tabCurrent").setContent(new Intent(this, (Class<?>) WCLeepMotorCurrentCarInfo.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabHisTripA").setIndicator("tabHisTripA").setContent(new Intent(this, (Class<?>) WCLeepMotorTripACarInfo.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabLastCharging").setIndicator("tabLastCharging").setContent(new Intent(this, (Class<?>) WCLeepMotorLastChargingCarInfo.class)));
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_OD_LEAPMOTOR_T03_19 /* 13042119 */:
            case FinalCanbus.CAR_455_CZH_OD_LEAPMOTOR_T03_19 /* 13107655 */:
                this.mTabHost.addTab(this.mTabHost.newTabSpec("tabElectricInfo").setIndicator("tabElectricInfo").setContent(new Intent(this, (Class<?>) ODLeepMotorElecCarInfo.class)));
                break;
            default:
                this.mTabHost.addTab(this.mTabHost.newTabSpec("tabElectricInfo").setIndicator("tabElectricInfo").setContent(new Intent(this, (Class<?>) WCLeepMotorElecCarInfo.class)));
                break;
        }
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.carinfo.od.mazdall.WCLeepMotorCarInfo.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_plus1 /* 2131427458 */:
                        WCLeepMotorCarInfo.this.mTabHost.setCurrentTabByTag("tabCurrent");
                        break;
                    case R.id.btn_plus2 /* 2131427461 */:
                        WCLeepMotorCarInfo.this.mTabHost.setCurrentTabByTag("tabHisTripA");
                        break;
                    case R.id.btn_plus3 /* 2131427464 */:
                        WCLeepMotorCarInfo.this.mTabHost.setCurrentTabByTag("tabLastCharging");
                        break;
                    case R.id.btn_plus4 /* 2131427467 */:
                        WCLeepMotorCarInfo.this.mTabHost.setCurrentTabByTag("tabElectricInfo");
                        break;
                }
            }
        });
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
