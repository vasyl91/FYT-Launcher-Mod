package com.syu.carinfo.camry2012.xp;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class CamryIndexAct_XP extends TabActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.camry2012.xp.CamryIndexAct_XP.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    CamryIndexAct_XP.this.mUpdaterPEEnable();
                    break;
            }
        }
    };
    private TabHost mTabHost;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_camry_index_xp);
        init();
    }

    private void init() {
        this.mTabHost = getTabHost();
        if (DataCanbus.DATA[1000] == 2621460 && ((RadioButton) findViewById(R.id.camry_btn_base_info)) != null) {
            ((RadioButton) findViewById(R.id.camry_btn_base_info)).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 3473428) {
            if (((RadioButton) findViewById(R.id.camry_btn_amp_settings)) != null) {
                ((RadioButton) findViewById(R.id.camry_btn_amp_settings)).setVisibility(8);
            }
            if (((RadioButton) findViewById(R.id.camry_btn_settings)) != null) {
                ((RadioButton) findViewById(R.id.camry_btn_settings)).setVisibility(8);
            }
        }
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripInfo").setIndicator("tabTripInfo").setContent(new Intent(this, (Class<?>) CamryTripAct_XP.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabHistory").setIndicator("tabHistory").setContent(new Intent(this, (Class<?>) CamryHistoryAct_XP.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabBaseInfo").setIndicator("tabBaseInfo").setContent(new Intent(this, (Class<?>) CamryMeterActi_XP.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTireInfo").setIndicator("tabTireInfo").setContent(new Intent(this, (Class<?>) CamryTireAct_XP.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSettings").setIndicator("tabSettings").setContent(new Intent(this, (Class<?>) CamrySettingsAct_XP.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabAmpSettings").setIndicator("tabAmpSettings").setContent(new Intent(this, (Class<?>) CamryEQActi_XP.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPE").setIndicator("tabPE").setContent(new Intent(this, (Class<?>) CamryicPetrolElectricActi_XP.class)));
        ((RadioGroup) findViewById(R.id.camry_main_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.carinfo.camry2012.xp.CamryIndexAct_XP.2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.camry_btn_trip_info /* 2131428277 */:
                        CamryIndexAct_XP.this.mTabHost.setCurrentTabByTag("tabTripInfo");
                        break;
                    case R.id.camry_btn_history_info /* 2131428278 */:
                        CamryIndexAct_XP.this.mTabHost.setCurrentTabByTag("tabHistory");
                        break;
                    case R.id.camry_btn_settings /* 2131428279 */:
                        CamryIndexAct_XP.this.mTabHost.setCurrentTabByTag("tabSettings");
                        break;
                    case R.id.camry_btn_base_info /* 2131430000 */:
                        CamryIndexAct_XP.this.mTabHost.setCurrentTabByTag("tabBaseInfo");
                        break;
                    case R.id.camry_btn_amp_settings /* 2131430001 */:
                        CamryIndexAct_XP.this.mTabHost.setCurrentTabByTag("tabAmpSettings");
                        break;
                    case R.id.camry_btn_trie_info /* 2131430002 */:
                        CamryIndexAct_XP.this.mTabHost.setCurrentTabByTag("tabTireInfo");
                        break;
                    case R.id.camry_btn_pe /* 2131430003 */:
                        CamryIndexAct_XP.this.mTabHost.setCurrentTabByTag("tabPE");
                        break;
                }
            }
        });
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(20, new int[]{31}, null, null);
        addNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterPEEnable() {
        int value = DataCanbus.DATA[99];
        if (((RadioButton) findViewById(R.id.camry_btn_pe)) != null) {
            ((RadioButton) findViewById(R.id.camry_btn_pe)).setVisibility(value == 0 ? 8 : 0);
        }
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
