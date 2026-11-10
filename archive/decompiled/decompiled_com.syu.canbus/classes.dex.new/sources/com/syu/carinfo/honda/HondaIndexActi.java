package com.syu.carinfo.honda;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
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
        if (showHondaEVSettings()) {
            findViewById(R.id.jiede_btn_history_e_info).setVisibility(0);
        } else {
            findViewById(R.id.jiede_btn_history_e_info).setVisibility(8);
        }
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabEVSettings").setIndicator("tabEVSettings").setContent(new Intent(this, (Class<?>) RZC_Honda_ElectricActi.class)));
        if (showRZCSettings()) {
            findViewById(R.id.jiede_btn_historyb_info).setVisibility(0);
        } else {
            findViewById(R.id.jiede_btn_historyb_info).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 131149 || DataCanbus.DATA[1000] == 327757 || DataCanbus.DATA[1000] == 65577 || DataCanbus.DATA[1000] == 131113 || DataCanbus.DATA[1000] == 196649 || DataCanbus.DATA[1000] == 262185) {
            findViewById(R.id.jiede_btn_settings).setVisibility(8);
        } else if (showWCCarInfo()) {
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
                    case R.id.jiede_btn_trip_info /* 2131431004 */:
                        HondaIndexActi.this.mTabHost.setCurrentTabByTag("tabTripInfo");
                        break;
                    case R.id.jiede_btn_history_info /* 2131431005 */:
                        HondaIndexActi.this.mTabHost.setCurrentTabByTag("tabHistory");
                        break;
                    case R.id.jiede_btn_historyb_info /* 2131431006 */:
                        HondaIndexActi.this.mTabHost.setCurrentTabByTag("tabTripBInfo");
                        break;
                    case R.id.jiede_btn_history_e_info /* 2131431007 */:
                        HondaIndexActi.this.mTabHost.setCurrentTabByTag("tabEVSettings");
                        break;
                    case R.id.jiede_btn_settings /* 2131431008 */:
                        HondaIndexActi.this.mTabHost.setCurrentTabByTag("tabSettings");
                        break;
                }
            }
        });
    }

    private boolean showHondaEVSettings() {
        int canbusId = DataCanbus.DATA[1000];
        switch (canbusId) {
            case FinalCanbus.CAR_CZH_RZC_HONDA_Civic /* 5636394 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_10Yage /* 5701930 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Haoying /* 5767466 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_CRV /* 5833002 */:
            case FinalCanbus.CAR_RZC_HONDA_22CRV_EV /* 5898538 */:
            case FinalCanbus.CAR_RZC_HONDA_22CRV_EV_H /* 5964074 */:
            case FinalCanbus.CAR_RZC_HONDA_22Haoying_EV /* 6029610 */:
            case FinalCanbus.CAR_RZC_HONDA_22Haoying_EV_H /* 6095146 */:
            case FinalCanbus.CAR_RZC_HONDA_22CRV_CEV /* 6750506 */:
            case FinalCanbus.CAR_RZC_HONDA_22CRV_CEV_H /* 6816042 */:
            case FinalCanbus.CAR_RZC_HONDA_22Haoying_CEV /* 6881578 */:
            case FinalCanbus.CAR_RZC_HONDA_22Haoying_CEV_H /* 6947114 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_XRV /* 7143722 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Vezel /* 7209258 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Lingpai /* 7274794 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_CRV_H /* 7340330 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Fit /* 7405866 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_CRV_21_Hybrid /* 7471402 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Haoying_21_Hybrid /* 7536938 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_CRV_21_EV /* 7602474 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Haoying_21_EV /* 7668010 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Siyu_22 /* 7733546 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Fit_21 /* 7799082 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Aodesai_22 /* 7864618 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_ZRV_22 /* 7930154 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_ELYSION_22 /* 7995690 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_CRV_22 /* 8061226 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Aodesai_15 /* 8126762 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_CRV_21_Hybrid_H /* 8192298 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Haoying_21_Hybrid_H /* 8257834 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_CRV_21_EV_H /* 8323370 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Haoying_21_EV_H /* 8388906 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Siyu_22_H /* 8454442 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Fit_21_H /* 8519978 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Aodesai_22_H /* 8585514 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_ZRV_22_H /* 8651050 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_ELYSION_22_H /* 8716586 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_CRV_22_H /* 8782122 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_XRV_H /* 8847658 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Vezel_H /* 8913194 */:
            case FinalCanbus.CAR_RZC_HONDA_24Haoying_PHEV /* 9044266 */:
            case FinalCanbus.CAR_RZC_HONDA_24Haoying_PHEV_H /* 9109802 */:
                return true;
            default:
                return false;
        }
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
            case FinalCanbus.CAR_BNR_ACCORD9_H /* 131149 */:
            case FinalCanbus.CAR_HAITES_BNR_ACCORD9_16Hi /* 327757 */:
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
