package com.syu.carinfo.camry.luz;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class CamryIndexAct_LuZ extends TabActivity {
    private TabHost mTabHost;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_camry_index_luz);
        init();
    }

    private void init() {
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripInfo").setIndicator("tabTripInfo").setContent(new Intent(this, (Class<?>) CamryTripAct_Luz.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabHistory").setIndicator("tabHistory").setContent(new Intent(this, (Class<?>) CamryHistoryAct_Luz.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSettings").setIndicator("tabSettings").setContent(new Intent(this, (Class<?>) CamrySettingsAct_Luz.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabAmpSettings").setIndicator("tabAmpSettings").setContent(new Intent(this, (Class<?>) ToyotaLexusEQActi_Luz.class)));
        ((RadioGroup) findViewById(R.id.camry_main_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.carinfo.camry.luz.CamryIndexAct_LuZ.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.camry_btn_trip_info /* 2131428277 */:
                        CamryIndexAct_LuZ.this.mTabHost.setCurrentTabByTag("tabTripInfo");
                        break;
                    case R.id.camry_btn_history_info /* 2131428278 */:
                        CamryIndexAct_LuZ.this.mTabHost.setCurrentTabByTag("tabHistory");
                        break;
                    case R.id.camry_btn_settings /* 2131428279 */:
                        CamryIndexAct_LuZ.this.mTabHost.setCurrentTabByTag("tabSettings");
                        break;
                    case R.id.camry_btn_amp_settings /* 2131430001 */:
                        CamryIndexAct_LuZ.this.mTabHost.setCurrentTabByTag("tabAmpSettings");
                        break;
                }
            }
        });
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
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
