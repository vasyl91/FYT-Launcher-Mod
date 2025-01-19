package com.syu.carinfo.toyota.tangdu;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ToyotaTangduIndexAct extends TabActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 100:
                    ToyotaTangduIndexAct.this.mUpdaterPEEnable();
                    break;
            }
        }
    };
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_toyota_tangdu_index);
        init();
    }

    private void init() {
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripInfo").setIndicator("tabTripInfo").setContent(new Intent(this, (Class<?>) ToyotaTangduTripAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabHistory").setIndicator("tabHistory").setContent(new Intent(this, (Class<?>) ToyotaTangduHistoryAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTireInfo").setIndicator("tabTireInfo").setContent(new Intent(this, (Class<?>) ToyotaTangduTireAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSettings").setIndicator("tabSettings").setContent(new Intent(this, (Class<?>) ToyotaTangduSettingsAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPE").setIndicator("tabPE").setContent(new Intent(this, (Class<?>) ToyotaTangduIcPetrolElectricActi.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabEQ").setIndicator("tabEQ").setContent(new Intent(this, (Class<?>) ToyotaTangduEQActi.class)));
        ((RadioGroup) findViewById(R.id.camry_main_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.ctv_checkedtext1 /* 2131427525 */:
                        ToyotaTangduIndexAct.this.mTabHost.setCurrentTabByTag("tabEQ");
                        break;
                    case R.id.camry_btn_trip_info /* 2131428108 */:
                        ToyotaTangduIndexAct.this.mTabHost.setCurrentTabByTag("tabTripInfo");
                        break;
                    case R.id.camry_btn_history_info /* 2131428109 */:
                        ToyotaTangduIndexAct.this.mTabHost.setCurrentTabByTag("tabHistory");
                        break;
                    case R.id.camry_btn_settings /* 2131428110 */:
                        ToyotaTangduIndexAct.this.mTabHost.setCurrentTabByTag("tabSettings");
                        break;
                    case R.id.camry_btn_trie_info /* 2131430651 */:
                        ToyotaTangduIndexAct.this.mTabHost.setCurrentTabByTag("tabTireInfo");
                        break;
                    case R.id.camry_btn_pe /* 2131430652 */:
                        ToyotaTangduIndexAct.this.mTabHost.setCurrentTabByTag("tabPE");
                        break;
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterPEEnable() {
        int value = DataCanbus.DATA[100];
        if (((RadioButton) findViewById(R.id.camry_btn_pe)) != null) {
            ((RadioButton) findViewById(R.id.camry_btn_pe)).setVisibility(value == 0 ? 8 : 0);
        }
    }
}
