package com.syu.carinfo.od.mazdall;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WCSuzukiCarInfo extends TabActivity {
    private RadioGroup mGroup;
    private TabHost mTabHost;
    public TextView mTvTpis;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_suzuki_carinfo_index);
        init();
    }

    private void init() {
        this.mGroup = (RadioGroup) findViewById(R.id.camry_main_group);
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabCurrent").setIndicator("tabCurrent").setContent(new Intent(this, (Class<?>) WCSuzukiCurrentCarInfo.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabHisTripInfo").setIndicator("tabHisTripInfo").setContent(new Intent(this, (Class<?>) WCSuzukiHisTripCarInfo.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabHisRefuelInfo").setIndicator("tabHisRefuelInfo").setContent(new Intent(this, (Class<?>) WCSuzukiHisRefuelCarInfo.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabElectricInfo").setIndicator("tabElectricInfo").setContent(new Intent(this, (Class<?>) WCSuzukielcCarInfo.class)));
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiCarInfo.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_plus1 /* 2131427482 */:
                        WCSuzukiCarInfo.this.mTabHost.setCurrentTabByTag("tabCurrent");
                        break;
                    case R.id.btn_plus2 /* 2131427486 */:
                        WCSuzukiCarInfo.this.mTabHost.setCurrentTabByTag("tabHisTripInfo");
                        break;
                    case R.id.btn_plus3 /* 2131427490 */:
                        WCSuzukiCarInfo.this.mTabHost.setCurrentTabByTag("tabHisRefuelInfo");
                        break;
                    case R.id.btn_plus4 /* 2131427494 */:
                        WCSuzukiCarInfo.this.mTabHost.setCurrentTabByTag("tabElectricInfo");
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
