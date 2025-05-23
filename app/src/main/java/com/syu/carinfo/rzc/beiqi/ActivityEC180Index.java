package com.syu.carinfo.rzc.beiqi;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;

import com.syu.canbus.R;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityEC180Index extends TabActivity {
    private RadioGroup mGroup;
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_ec180_index);
        init();
    }

    private void init() {
        this.mGroup = (RadioGroup) findViewById(R.id.ec180_main_group);
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabEnvironmentsProtect").setIndicator("tabEnvironmentsProtect").setContent(new Intent(this, (Class<?>) ActivityEnvironmentProtect.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabEnergyLevel").setIndicator("tabEnergyLevel").setContent(new Intent(this, (Class<?>) ActivityEnergyLevel.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabEnergyStatistics").setIndicator("tabEnergyStatistics").setContent(new Intent(this, (Class<?>) ActivityEnergyStatistics.class)));
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.ec180_btn_trip_info /* 2131430931 */:
                        ActivityEC180Index.this.mTabHost.setCurrentTabByTag("tabEnvironmentsProtect");
                        break;
                    case R.id.ec180_btn_history_info /* 2131430932 */:
                        ActivityEC180Index.this.mTabHost.setCurrentTabByTag("tabEnergyLevel");
                        break;
                    case R.id.ec180_btn_settings /* 2131430933 */:
                        ActivityEC180Index.this.mTabHost.setCurrentTabByTag("tabEnergyStatistics");
                        break;
                }
            }
        });
    }
}
