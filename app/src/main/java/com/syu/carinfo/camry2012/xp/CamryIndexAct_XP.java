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

public class CamryIndexAct_XP extends TabActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    CamryIndexAct_XP.this.mUpdaterPEEnable();
                    break;
            }
        }
    };
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_camry_index_xp);
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
        ((RadioGroup) findViewById(R.id.camry_main_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.camry_btn_trip_info /* 2131428108 */:
                        CamryIndexAct_XP.this.mTabHost.setCurrentTabByTag("tabTripInfo");
                        break;
                    case R.id.camry_btn_history_info /* 2131428109 */:
                        CamryIndexAct_XP.this.mTabHost.setCurrentTabByTag("tabHistory");
                        break;
                    case R.id.camry_btn_settings /* 2131428110 */:
                        CamryIndexAct_XP.this.mTabHost.setCurrentTabByTag("tabSettings");
                        break;
                    case R.id.camry_btn_base_info /* 2131430649 */:
                        CamryIndexAct_XP.this.mTabHost.setCurrentTabByTag("tabBaseInfo");
                        break;
                    case R.id.camry_btn_amp_settings /* 2131430650 */:
                        CamryIndexAct_XP.this.mTabHost.setCurrentTabByTag("tabAmpSettings");
                        break;
                    case R.id.camry_btn_trie_info /* 2131430651 */:
                        CamryIndexAct_XP.this.mTabHost.setCurrentTabByTag("tabTireInfo");
                        break;
                    case R.id.camry_btn_pe /* 2131430652 */:
                        CamryIndexAct_XP.this.mTabHost.setCurrentTabByTag("tabPE");
                        break;
                }
            }
        });
    }

    @Override
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

    
    public void mUpdaterPEEnable() {
        int value = DataCanbus.DATA[99];
        if (((RadioButton) findViewById(R.id.camry_btn_pe)) != null) {
            ((RadioButton) findViewById(R.id.camry_btn_pe)).setVisibility(value == 0 ? 8 : 0);
        }
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
