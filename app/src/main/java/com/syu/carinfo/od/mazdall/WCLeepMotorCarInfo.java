package com.syu.carinfo.od.mazdall;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.syu.canbus.R;

public class WCLeepMotorCarInfo extends TabActivity {
    private RadioGroup mGroup;
    private TabHost mTabHost;
    public TextView mTvTpis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_leepmotor_carinfo_index);
        init();
    }

    private void init() {
        this.mGroup = findViewById(R.id.camry_main_group);
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabCurrent").setIndicator("tabCurrent").setContent(new Intent(this, WCLeepMotorCurrentCarInfo.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabHisTripA").setIndicator("tabHisTripA").setContent(new Intent(this, WCLeepMotorTripACarInfo.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabLastCharging").setIndicator("tabLastCharging").setContent(new Intent(this, WCLeepMotorLastChargingCarInfo.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabElectricInfo").setIndicator("tabElectricInfo").setContent(new Intent(this, WCLeepMotorElecCarInfo.class)));
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_plus1 /* 2131427457 */:
                        WCLeepMotorCarInfo.this.mTabHost.setCurrentTabByTag("tabCurrent");
                        break;
                    case R.id.btn_plus2 /* 2131427460 */:
                        WCLeepMotorCarInfo.this.mTabHost.setCurrentTabByTag("tabHisTripA");
                        break;
                    case R.id.btn_plus3 /* 2131427463 */:
                        WCLeepMotorCarInfo.this.mTabHost.setCurrentTabByTag("tabLastCharging");
                        break;
                    case R.id.btn_plus4 /* 2131427466 */:
                        WCLeepMotorCarInfo.this.mTabHost.setCurrentTabByTag("tabElectricInfo");
                        break;
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
