package com.syu.carinfo.od.mazdall;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.carinfo.wc.axela.ActivityMzdAllMaintainanceCarSet;

public class MazdAllCarInfo extends TabActivity {
    private RadioGroup mGroup;
    private TabHost mTabHost;
    public TextView mTvTpis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_od_mazdall_index);
        init();
    }

    private void init() {
        this.mGroup = findViewById(R.id.camry_main_group);
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripInfo").setIndicator("tabTripInfo").setContent(new Intent(this, MazdAllTripAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabHistory").setIndicator("tabHistory").setContent(new Intent(this, MazdAllHistoryAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabMaintenance").setIndicator("tabMaintenance").setContent(new Intent(this, ActivityMzdAllMaintainanceCarSet.class)));
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.camry_btn_trip_info /* 2131428108 */:
                        MazdAllCarInfo.this.mTabHost.setCurrentTabByTag("tabTripInfo");
                        break;
                    case R.id.camry_btn_history_info /* 2131428109 */:
                        MazdAllCarInfo.this.mTabHost.setCurrentTabByTag("tabHistory");
                        break;
                    case R.id.camry_btn_maintenance_info /* 2131432067 */:
                        MazdAllCarInfo.this.mTabHost.setCurrentTabByTag("tabMaintenance");
                        break;
                }
            }
        });
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
