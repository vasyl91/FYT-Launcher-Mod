package com.syu.carinfo.camry2012.xp;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;

import com.syu.canbus.R;
import com.syu.carinfo.bnr.Acti_Crow_Amp_Bnr;
import com.syu.carinfo.xp.ziyouguang.Activity_0452_PA_Ford_PitchAndRoll;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class CamryIndexAct extends TabActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    CamryIndexAct.this.mUpdaterPEEnable();
                    break;
            }
        }
    };
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_camry_index);
        init();
    }

    private void init() {
        this.mTabHost = getTabHost();
        if (DataCanbus.DATA[1000] == 196628 || DataCanbus.DATA[1000] == 5177741 || DataCanbus.DATA[1000] == 5243277 || DataCanbus.DATA[1000] == 6422925 || DataCanbus.DATA[1000] == 6488461 || DataCanbus.DATA[1000] == 6553997 || DataCanbus.DATA[1000] == 6619533 || DataCanbus.DATA[1000] == 6685069 || DataCanbus.DATA[1000] == 6750605 || DataCanbus.DATA[1000] == 6816141 || DataCanbus.DATA[1000] == 6029709 || DataCanbus.DATA[1000] == 6095245 || DataCanbus.DATA[1000] == 6160781 || DataCanbus.DATA[1000] == 6226317 || DataCanbus.DATA[1000] == 6291853 || DataCanbus.DATA[1000] == 6357389 || DataCanbus.DATA[1000] == 5308813 || DataCanbus.DATA[1000] == 5374349 || DataCanbus.DATA[1000] == 5439885 || DataCanbus.DATA[1000] == 5505421 || DataCanbus.DATA[1000] == 5570957 || DataCanbus.DATA[1000] == 5636493 || DataCanbus.DATA[1000] == 5833101 || DataCanbus.DATA[1000] == 5898637 || DataCanbus.DATA[1000] == 5964173) {
            if (((RadioButton) findViewById(R.id.camry_btn_base_info)) != null) {
                ((RadioButton) findViewById(R.id.camry_btn_base_info)).setVisibility(8);
            }
        } else if (((RadioButton) findViewById(R.id.camry_btn_base_info)) != null) {
            ((RadioButton) findViewById(R.id.camry_btn_base_info)).setVisibility(0);
        }
        if (((RadioButton) findViewById(R.id.camry_btn_amp_settings)) != null) {
            ((RadioButton) findViewById(R.id.camry_btn_amp_settings)).setVisibility(0);
        }
        if (DataCanbus.DATA[1000] == 5308813 || DataCanbus.DATA[1000] == 5374349 || DataCanbus.DATA[1000] == 5177741 || DataCanbus.DATA[1000] == 5243277 || DataCanbus.DATA[1000] == 6422925 || DataCanbus.DATA[1000] == 6488461 || DataCanbus.DATA[1000] == 6553997 || DataCanbus.DATA[1000] == 6619533 || DataCanbus.DATA[1000] == 6685069 || DataCanbus.DATA[1000] == 6750605 || DataCanbus.DATA[1000] == 6816141 || DataCanbus.DATA[1000] == 6029709 || DataCanbus.DATA[1000] == 6095245 || DataCanbus.DATA[1000] == 6160781 || DataCanbus.DATA[1000] == 6226317 || DataCanbus.DATA[1000] == 6291853 || DataCanbus.DATA[1000] == 6357389 || DataCanbus.DATA[1000] == 5439885 || DataCanbus.DATA[1000] == 5505421 || DataCanbus.DATA[1000] == 5570957 || DataCanbus.DATA[1000] == 5636493 || DataCanbus.DATA[1000] == 5833101 || DataCanbus.DATA[1000] == 5898637 || DataCanbus.DATA[1000] == 5964173) {
            if (((RadioButton) findViewById(R.id.camry_btn_pitch)) != null) {
                ((RadioButton) findViewById(R.id.camry_btn_pitch)).setVisibility(0);
            }
        } else if (((RadioButton) findViewById(R.id.camry_btn_pitch)) != null) {
            ((RadioButton) findViewById(R.id.camry_btn_pitch)).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 1048688) {
            if (((RadioButton) findViewById(R.id.camry_btn_settings)) != null) {
                ((RadioButton) findViewById(R.id.camry_btn_settings)).setVisibility(8);
            }
        } else if (((RadioButton) findViewById(R.id.camry_btn_settings)) != null) {
            ((RadioButton) findViewById(R.id.camry_btn_settings)).setVisibility(0);
        }
        if (DataCanbus.DATA[1000] == 983152 || DataCanbus.DATA[1000] == 1114224) {
            if (((RadioButton) findViewById(R.id.camry_btn_settings)) != null) {
                ((RadioButton) findViewById(R.id.camry_btn_settings)).setVisibility(8);
            }
            if (((RadioButton) findViewById(R.id.camry_btn_base_info)) != null) {
                ((RadioButton) findViewById(R.id.camry_btn_base_info)).setVisibility(8);
            }
            if (((RadioButton) findViewById(R.id.camry_btn_trie_info)) != null) {
                ((RadioButton) findViewById(R.id.camry_btn_trie_info)).setVisibility(8);
            }
        }
        if (DataCanbus.DATA[1000] == 2621460 && ((RadioButton) findViewById(R.id.camry_btn_base_info)) != null) {
            ((RadioButton) findViewById(R.id.camry_btn_base_info)).setVisibility(8);
        }
        if (((RadioButton) findViewById(R.id.camry_btn_ev)) != null) {
            ((RadioButton) findViewById(R.id.camry_btn_ev)).setVisibility(8);
        }
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripInfo").setIndicator("tabTripInfo").setContent(new Intent(this, (Class<?>) CamryTripAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabHistory").setIndicator("tabHistory").setContent(new Intent(this, (Class<?>) CamryHistoryAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabBaseInfo").setIndicator("tabBaseInfo").setContent(new Intent(this, (Class<?>) CamryMeterActi.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTireInfo").setIndicator("tabTireInfo").setContent(new Intent(this, (Class<?>) CamryTireAct.class)));
        if ((DataCanbus.DATA[1000] & 65535) == 20) {
            this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSettings").setIndicator("tabSettings").setContent(new Intent(this, (Class<?>) CamrySettingsAct_XP.class)));
        } else if ((DataCanbus.DATA[1000] & 65535) == 112) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_ZX_6606_XP1_Carmy /* 3211376 */:
                case FinalCanbus.CAR_ZX_6606_XP1_Carmy_M /* 3276912 */:
                case FinalCanbus.CAR_ZX_6606_XP1_Carmy_H /* 3342448 */:
                case FinalCanbus.CAR_ZX_6606_XP1_Carmy_21 /* 3670128 */:
                case FinalCanbus.CAR_ZX_6606_XP1_Sienna /* 3801200 */:
                case FinalCanbus.CAR_ZX_6606_XP1_Bz4x /* 4915312 */:
                case FinalCanbus.CAR_ZX_6606_XP1_24Camry /* 7274608 */:
                    this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSettings").setIndicator("tabSettings").setContent(new Intent(this, (Class<?>) CamrySettingsAct_RZC6606.class)));
                    break;
                default:
                    this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSettings").setIndicator("tabSettings").setContent(new Intent(this, (Class<?>) CamrySettingsAct_RZC.class)));
                    break;
            }
        } else if ((DataCanbus.DATA[1000] & 65535) == 214) {
            this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSettings").setIndicator("tabSettings").setContent(new Intent(this, (Class<?>) CamrySettingsAct_RZC.class)));
        } else {
            this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSettings").setIndicator("tabSettings").setContent(new Intent(this, (Class<?>) CamrySettingsAct.class)));
        }
        if ((DataCanbus.DATA[1000] & 65535) == 112 || (DataCanbus.DATA[1000] & 65535) == 214) {
            this.mTabHost.addTab(this.mTabHost.newTabSpec("tabAmpSettings").setIndicator("tabAmpSettings").setContent(new Intent(this, (Class<?>) ToyotaLexusEQActi.class)));
        } else {
            this.mTabHost.addTab(this.mTabHost.newTabSpec("tabAmpSettings").setIndicator("tabAmpSettings").setContent(new Intent(this, (Class<?>) Acti_Crow_Amp_Bnr.class)));
        }
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPE").setIndicator("tabPE").setContent(new Intent(this, (Class<?>) CamryicPetrolElectricActi.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabEV").setIndicator("tabEV").setContent(new Intent(this, (Class<?>) CamryEVinfoActi.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPitch").setIndicator("tabPitch").setContent(new Intent(this, (Class<?>) Activity_0452_PA_Ford_PitchAndRoll.class)));
        ((RadioGroup) findViewById(R.id.camry_main_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.camry_btn_trip_info /* 2131428108 */:
                        CamryIndexAct.this.mTabHost.setCurrentTabByTag("tabTripInfo");
                        break;
                    case R.id.camry_btn_history_info /* 2131428109 */:
                        CamryIndexAct.this.mTabHost.setCurrentTabByTag("tabHistory");
                        break;
                    case R.id.camry_btn_settings /* 2131428110 */:
                        CamryIndexAct.this.mTabHost.setCurrentTabByTag("tabSettings");
                        break;
                    case R.id.camry_btn_base_info /* 2131430649 */:
                        CamryIndexAct.this.mTabHost.setCurrentTabByTag("tabBaseInfo");
                        break;
                    case R.id.camry_btn_amp_settings /* 2131430650 */:
                        CamryIndexAct.this.mTabHost.setCurrentTabByTag("tabAmpSettings");
                        break;
                    case R.id.camry_btn_trie_info /* 2131430651 */:
                        CamryIndexAct.this.mTabHost.setCurrentTabByTag("tabTireInfo");
                        break;
                    case R.id.camry_btn_pe /* 2131430652 */:
                        CamryIndexAct.this.mTabHost.setCurrentTabByTag("tabPE");
                        break;
                    case R.id.camry_btn_ev /* 2131430653 */:
                        CamryIndexAct.this.mTabHost.setCurrentTabByTag("tabEV");
                        break;
                    case R.id.camry_btn_pitch /* 2131430654 */:
                        CamryIndexAct.this.mTabHost.setCurrentTabByTag("tabPitch");
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterPEEnable() {
        int value = DataCanbus.DATA[98];
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
