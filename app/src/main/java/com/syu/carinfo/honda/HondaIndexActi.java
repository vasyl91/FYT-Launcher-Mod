package com.syu.carinfo.honda;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class HondaIndexActi extends TabActivity {
    private RadioGroup mGroup;
    private TabHost mTabHost;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jiede_index);
        init();
        DataCanbus.PROXY.cmd(100, 0);
    }

    private void init() {
        this.mGroup = (RadioGroup) findViewById(R.id.jiede_main_group);
        this.mTabHost = getTabHost();
        findViewById(R.id.jiede_btn_settings).setVisibility(8);
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripInfo").setIndicator("tabTripInfo").setContent(new Intent(this, (Class<?>) HondaTripActi.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabHistory").setIndicator("tabHistory").setContent(new Intent(this, (Class<?>) HondaHistoryActi.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripBInfo").setIndicator("tabTripBInfo").setContent(new Intent(this, (Class<?>) HondaHistoryBActi.class)));
        if (showRZCSettings()) {
            findViewById(R.id.jiede_btn_historyb_info).setVisibility(0);
        } else {
            findViewById(R.id.jiede_btn_historyb_info).setVisibility(8);
        }
        if (showWCCarInfo()) {
            findViewById(R.id.jiede_btn_settings).setVisibility(0);
            this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSettings").setIndicator("tabSettings").setContent(new Intent(this, (Class<?>) Wc_16Civic_FunctionalActi.class)));
        } else if (isBNRSiYuOrGuanDao()) {
            findViewById(R.id.jiede_btn_settings).setVisibility(0);
            this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSettings").setIndicator("tabSettings").setContent(new Intent(this, (Class<?>) AcrivitySiYuSettings.class)));
        } else if (showRZCSettings()) {
            findViewById(R.id.jiede_btn_settings).setVisibility(0);
            this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSettings").setIndicator("tabSettings").setContent(new Intent(this, (Class<?>) RZCCommpassActi.class)));
        } else {
            findViewById(R.id.jiede_btn_settings).setVisibility(0);
            this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSettings").setIndicator("tabSettings").setContent(new Intent(this, (Class<?>) CommpassActi.class)));
        }
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.carinfo.honda.HondaIndexActi.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.jiede_btn_trip_info /* 2131431795 */:
                        HondaIndexActi.this.mTabHost.setCurrentTabByTag("tabTripInfo");
                        break;
                    case R.id.jiede_btn_history_info /* 2131431796 */:
                        HondaIndexActi.this.mTabHost.setCurrentTabByTag("tabHistory");
                        break;
                    case R.id.jiede_btn_historyb_info /* 2131431797 */:
                        HondaIndexActi.this.mTabHost.setCurrentTabByTag("tabTripBInfo");
                        break;
                    case R.id.jiede_btn_settings /* 2131431798 */:
                        HondaIndexActi.this.mTabHost.setCurrentTabByTag("tabSettings");
                        break;
                }
            }
        });
    }

    private boolean showRZCSettings() {
        boolean state = false;
        int canbusId = DataCanbus.DATA[1000];
        if ((65535 & canbusId) == 298) {
            state = true;
        }
        switch (canbusId) {
            case FinalCanbus.CAR_XP1_2015SIYU_CRV_M /* 65834 */:
            case FinalCanbus.CAR_XP1_2015SIYU_CRV_H /* 131370 */:
            case FinalCanbus.CAR_XP1_2016SIYU /* 196906 */:
            case FinalCanbus.CAR_XP1_2016SIYU_H /* 262442 */:
            case FinalCanbus.CAR_BNR_XP1_AoDeSai /* 327978 */:
            case FinalCanbus.CAR_BNR_HONDA_16Civic_Vsceen_L /* 393514 */:
            case FinalCanbus.CAR_BNR_HONDA_16Civic_Vsceen_H /* 459050 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_NoAmp /* 524586 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_Amp_View /* 590122 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_Vsceen_NoAmp /* 655658 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_Vsceen_Amp_View /* 721194 */:
            case FinalCanbus.CAR_XP1_17CRV /* 852266 */:
            case FinalCanbus.CAR_BNR_17CRV /* 983338 */:
            case FinalCanbus.CAR_XP_2015SiYu_CRV /* 2294058 */:
            case FinalCanbus.CAR_BNR_HONDA_16Civic_NoAir /* 2621738 */:
                return false;
            default:
                return state;
        }
    }

    private boolean showWCCarInfo() {
        int canbusId = DataCanbus.DATA[1000];
        if ((65535 & canbusId) != 321) {
            return false;
        }
        return true;
    }

    private boolean isBNRSiYuOrGuanDao() {
        int canbusId = DataCanbus.DATA[1000];
        switch (canbusId) {
            case FinalCanbus.CAR_BNR_HONDA_16Civic_Vsceen_L /* 393514 */:
            case FinalCanbus.CAR_BNR_HONDA_16Civic_Vsceen_H /* 459050 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_NoAmp /* 524586 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_Amp_View /* 590122 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_Vsceen_NoAmp /* 655658 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_Vsceen_Amp_View /* 721194 */:
            case FinalCanbus.CAR_BNR_17CRV /* 983338 */:
            case FinalCanbus.CAR_BNR_HONDA_16Civic_NoAir /* 2621738 */:
                return true;
            default:
                return false;
        }
    }
}
