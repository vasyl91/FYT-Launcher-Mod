package com.syu.carinfo.od.mazdall;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.syu.canbus.R;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCSuzukiCarInfo extends TabActivity {
    private RadioGroup mGroup;
    private TabHost mTabHost;
    public TextView mTvTpis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_suzuki_carinfo_index);
        init();
    }

    private void init() {
        this.mGroup = findViewById(R.id.camry_main_group);
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabCurrent").setIndicator("tabCurrent").setContent(new Intent(this, WCSuzukiCurrentCarInfo.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabHisTripInfo").setIndicator("tabHisTripInfo").setContent(new Intent(this, WCSuzukiHisTripCarInfo.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabHisRefuelInfo").setIndicator("tabHisRefuelInfo").setContent(new Intent(this, WCSuzukiHisRefuelCarInfo.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabElectricInfo").setIndicator("tabElectricInfo").setContent(new Intent(this, WCSuzukielcCarInfo.class)));
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_plus1 /* 2131427457 */:
                        WCSuzukiCarInfo.this.mTabHost.setCurrentTabByTag("tabCurrent");
                        break;
                    case R.id.btn_plus2 /* 2131427460 */:
                        WCSuzukiCarInfo.this.mTabHost.setCurrentTabByTag("tabHisTripInfo");
                        break;
                    case R.id.btn_plus3 /* 2131427463 */:
                        WCSuzukiCarInfo.this.mTabHost.setCurrentTabByTag("tabHisRefuelInfo");
                        break;
                    case R.id.btn_plus4 /* 2131427466 */:
                        WCSuzukiCarInfo.this.mTabHost.setCurrentTabByTag("tabElectricInfo");
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
