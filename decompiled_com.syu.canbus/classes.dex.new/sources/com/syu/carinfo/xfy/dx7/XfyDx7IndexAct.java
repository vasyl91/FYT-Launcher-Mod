package com.syu.carinfo.xfy.dx7;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class XfyDx7IndexAct extends TabActivity {
    private RadioGroup mGroup;
    private TabHost mTabHost;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xfy_dx7_index);
        init();
    }

    private void init() {
        this.mGroup = (RadioGroup) findViewById(R.id.xfy_dx7_main_group);
        this.mTabHost = getTabHost();
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_OD_DongNanDX7_15_17 /* 328009 */:
            case FinalCanbus.CAR_RZC_OD_DongNanDX5_18_20 /* 393545 */:
            case FinalCanbus.CAR_RZC_OD_DongNanDX7_18_20_H /* 655689 */:
            case FinalCanbus.CAR_CZH_OD_DongNanDX7_18_20_H /* 721225 */:
                ((RadioButton) findViewById(R.id.btn_plus1)).setVisibility(8);
                this.mTabHost.addTab(this.mTabHost.newTabSpec("tabHistory").setIndicator("tabHistory").setContent(new Intent(this, (Class<?>) ODDx7HistroyAct.class)));
                this.mTabHost.addTab(this.mTabHost.newTabSpec("TabSettingsInfo").setIndicator("TabSettingsInfo").setContent(new Intent(this, (Class<?>) ODDx7Settings.class)));
                break;
            default:
                ((RadioButton) findViewById(R.id.btn_plus1)).setVisibility(0);
                this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripInfo").setIndicator("tabTripInfo").setContent(new Intent(this, (Class<?>) XfyDx7PressureTireAct.class)));
                this.mTabHost.addTab(this.mTabHost.newTabSpec("tabHistory").setIndicator("tabHistory").setContent(new Intent(this, (Class<?>) XfyDx7HistroyAct.class)));
                this.mTabHost.addTab(this.mTabHost.newTabSpec("TabSettingsInfo").setIndicator("TabSettingsInfo").setContent(new Intent(this, (Class<?>) RzcDx7Settings.class)));
                break;
        }
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.carinfo.xfy.dx7.XfyDx7IndexAct.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_plus1 /* 2131427458 */:
                        XfyDx7IndexAct.this.mTabHost.setCurrentTabByTag("tabTripInfo");
                        break;
                    case R.id.btn_plus2 /* 2131427461 */:
                        XfyDx7IndexAct.this.mTabHost.setCurrentTabByTag("tabHistory");
                        break;
                    case R.id.btn_plus3 /* 2131427464 */:
                        XfyDx7IndexAct.this.mTabHost.setCurrentTabByTag("TabSettingsInfo");
                        break;
                }
            }
        });
    }
}
