package com.syu.carinfo.od.dongnanv5;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TabHost;

import com.syu.canbus.R;

@SuppressWarnings({"deprecation", "unchecked"})
public class Dongnanv5IndexActi extends TabActivity {
    private RadioGroup mGroup;
    private TabHost mTabHost;
    public View mViewHigh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_oudi_17dongnanv5_index);
        init();
    }

    private void init() {
        this.mGroup = (RadioGroup) findViewById(R.id.jiede_main_group);
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripInfo").setIndicator("tabTripInfo").setContent(new Intent(this, (Class<?>) Dongnanv5CarinfoActi.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPressureInfo").setIndicator("tabPressureInfo").setContent(new Intent(this, (Class<?>) Dongnanv5PresActi.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSettings").setIndicator("tabSettings").setContent(new Intent(this, (Class<?>) Dongnanv5SettingActi.class)));
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.jiede_btn_trip_info /* 2131431772 */:
                        Dongnanv5IndexActi.this.mTabHost.setCurrentTabByTag("tabTripInfo");
                        break;
                    case R.id.jiede_btn_history_info /* 2131431773 */:
                        Dongnanv5IndexActi.this.mTabHost.setCurrentTabByTag("tabPressureInfo");
                        break;
                    case R.id.jiede_btn_settings /* 2131431776 */:
                        Dongnanv5IndexActi.this.mTabHost.setCurrentTabByTag("tabSettings");
                        break;
                }
            }
        });
    }
}
