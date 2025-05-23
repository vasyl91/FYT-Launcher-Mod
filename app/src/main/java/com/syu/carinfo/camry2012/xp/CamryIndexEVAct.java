package com.syu.carinfo.camry2012.xp;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class CamryIndexEVAct extends TabActivity {
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_camry_index_ev);
        init();
    }

    private void init() {
        this.mTabHost = getTabHost();
        if (DataCanbus.DATA[1000] == 1310832) {
            if (((RadioButton) findViewById(R.id.camry_btn_trip_info)) != null) {
                ((RadioButton) findViewById(R.id.camry_btn_trip_info)).setVisibility(8);
            }
            if (((RadioButton) findViewById(R.id.camry_btn_history_info)) != null) {
                ((RadioButton) findViewById(R.id.camry_btn_history_info)).setVisibility(8);
            }
            if (((RadioButton) findViewById(R.id.camry_btn_settings)) != null) {
                ((RadioButton) findViewById(R.id.camry_btn_settings)).setVisibility(8);
            }
            if (((RadioButton) findViewById(R.id.camry_btn_base_info)) != null) {
                ((RadioButton) findViewById(R.id.camry_btn_base_info)).setVisibility(8);
            }
            if (((RadioButton) findViewById(R.id.camry_btn_trie_info)) != null) {
                ((RadioButton) findViewById(R.id.camry_btn_trie_info)).setVisibility(8);
            }
        } else if (((RadioButton) findViewById(R.id.camry_btn_ev)) != null) {
            ((RadioButton) findViewById(R.id.camry_btn_ev)).setVisibility(8);
        }
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabEV").setIndicator("tabEV").setContent(new Intent(this, (Class<?>) CamryEVinfoActi.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripInfo").setIndicator("tabTripInfo").setContent(new Intent(this, (Class<?>) CamryTripAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabHistory").setIndicator("tabHistory").setContent(new Intent(this, (Class<?>) CamryHistoryAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabBaseInfo").setIndicator("tabBaseInfo").setContent(new Intent(this, (Class<?>) CamryMeterActi.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTireInfo").setIndicator("tabTireInfo").setContent(new Intent(this, (Class<?>) CamryTireAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSettings").setIndicator("tabSettings").setContent(new Intent(this, (Class<?>) CamrySettingsAct_RZC.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPE").setIndicator("tabPE").setContent(new Intent(this, (Class<?>) CamryicPetrolElectricActi.class)));
        ((RadioGroup) findViewById(R.id.camry_main_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.camry_btn_trip_info /* 2131428108 */:
                        CamryIndexEVAct.this.mTabHost.setCurrentTabByTag("tabTripInfo");
                        break;
                    case R.id.camry_btn_history_info /* 2131428109 */:
                        CamryIndexEVAct.this.mTabHost.setCurrentTabByTag("tabHistory");
                        break;
                    case R.id.camry_btn_settings /* 2131428110 */:
                        CamryIndexEVAct.this.mTabHost.setCurrentTabByTag("tabSettings");
                        break;
                    case R.id.camry_btn_base_info /* 2131430649 */:
                        CamryIndexEVAct.this.mTabHost.setCurrentTabByTag("tabBaseInfo");
                        break;
                    case R.id.camry_btn_trie_info /* 2131430651 */:
                        CamryIndexEVAct.this.mTabHost.setCurrentTabByTag("tabTireInfo");
                        break;
                    case R.id.camry_btn_pe /* 2131430652 */:
                        CamryIndexEVAct.this.mTabHost.setCurrentTabByTag("tabPE");
                        break;
                    case R.id.camry_btn_ev /* 2131430653 */:
                        CamryIndexEVAct.this.mTabHost.setCurrentTabByTag("tabEV");
                        break;
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(20, new int[]{31}, null, null);
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
