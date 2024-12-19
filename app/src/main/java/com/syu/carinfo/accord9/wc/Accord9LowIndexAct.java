package com.syu.carinfo.accord9.wc;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;
import com.syu.carinfo.honda.HondaHistoryActi;
import com.syu.carinfo.honda.HondaTripActi;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Accord9LowIndexAct extends TabActivity {
    private TabHost mTabHost;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_accord9_low_index);
        init();
    }

    private void init() {
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripInfo").setIndicator("tabTripInfo").setContent(new Intent(this, (Class<?>) HondaTripActi.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabHistory").setIndicator("tabHistory").setContent(new Intent(this, (Class<?>) HondaHistoryActi.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabOrigCarSettings").setIndicator("tabOrigCarSettings").setContent(new Intent(this, (Class<?>) Accord9LowBackCarSet.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSettings").setIndicator("tabSettings").setContent(new Intent(this, (Class<?>) Accord9LowSettingsAct.class)));
        ((RadioGroup) findViewById(R.id.accord9_low_main_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.carinfo.accord9.wc.Accord9LowIndexAct.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.accord9_low_btn_oil_info /* 2131430188 */:
                        Accord9LowIndexAct.this.mTabHost.setCurrentTabByTag("tabTripInfo");
                        break;
                    case R.id.accord9_low_btn_trip_info /* 2131430189 */:
                        Accord9LowIndexAct.this.mTabHost.setCurrentTabByTag("tabHistory");
                        break;
                    case R.id.accord9_low_btn_originalcar_settings /* 2131430190 */:
                        Accord9LowIndexAct.this.mTabHost.setCurrentTabByTag("tabOrigCarSettings");
                        break;
                    case R.id.accord9_low_btn_settings /* 2131430191 */:
                        Accord9LowIndexAct.this.mTabHost.setCurrentTabByTag("tabSettings");
                        break;
                }
            }
        });
    }
}
