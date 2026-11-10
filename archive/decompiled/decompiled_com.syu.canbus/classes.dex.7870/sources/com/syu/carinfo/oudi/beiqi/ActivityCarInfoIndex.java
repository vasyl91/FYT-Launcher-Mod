package com.syu.carinfo.oudi.beiqi;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class ActivityCarInfoIndex extends TabActivity {
    private RadioGroup mGroup;
    private TabHost mTabHost;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ec180_index);
        init();
    }

    private void init() {
        this.mGroup = (RadioGroup) findViewById(R.id.ec180_main_group);
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabEnvironmentsProtect").setIndicator("tabEnvironmentsProtect").setContent(new Intent(this, (Class<?>) ActivityEnvironmentProtect.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabEnergyLevel").setIndicator("tabEnergyLevel").setContent(new Intent(this, (Class<?>) ActivityEnergyLevel.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabEnergyStatistics").setIndicator("tabEnergyStatistics").setContent(new Intent(this, (Class<?>) ActivityEnergyStatistics.class)));
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_OD_Beijing_X3_18 /* 4063686 */:
            case FinalCanbus.CAR_454_OD_Beijing_X5_18 /* 4129222 */:
            case FinalCanbus.CAR_454_OD_Beiqi_EU5_18 /* 4194758 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_D50_19 /* 4260294 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X35_19 /* 4325830 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X55_18 /* 4391366 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Zhixing_18 /* 4456902 */:
            case FinalCanbus.CAR_456_OD_Beiqi_Shenbao_D50_19_H /* 6685128 */:
            case FinalCanbus.CAR_456_OD_Beiqi_Shenbao_X55_18_H /* 6750664 */:
                ((RadioButton) findViewById(R.id.ec180_btn_settings)).setVisibility(8);
                break;
            default:
                ((RadioButton) findViewById(R.id.ec180_btn_settings)).setVisibility(0);
                break;
        }
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.carinfo.oudi.beiqi.ActivityCarInfoIndex.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.ec180_btn_trip_info /* 2131429897 */:
                        ActivityCarInfoIndex.this.mTabHost.setCurrentTabByTag("tabEnvironmentsProtect");
                        break;
                    case R.id.ec180_btn_history_info /* 2131429898 */:
                        ActivityCarInfoIndex.this.mTabHost.setCurrentTabByTag("tabEnergyLevel");
                        break;
                    case R.id.ec180_btn_settings /* 2131429899 */:
                        ActivityCarInfoIndex.this.mTabHost.setCurrentTabByTag("tabEnergyStatistics");
                        break;
                }
            }
        });
    }
}
