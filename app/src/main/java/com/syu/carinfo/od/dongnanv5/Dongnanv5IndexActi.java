package com.syu.carinfo.od.dongnanv5;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Dongnanv5IndexActi extends TabActivity {
    private RadioGroup mGroup;
    private TabHost mTabHost;
    public View mViewHigh;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_oudi_17dongnanv5_index);
        init();
    }

    private void init() {
        this.mGroup = (RadioGroup) findViewById(R.id.jiede_main_group);
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripInfo").setIndicator("tabTripInfo").setContent(new Intent(this, (Class<?>) Dongnanv5CarinfoActi.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPressureInfo").setIndicator("tabPressureInfo").setContent(new Intent(this, (Class<?>) Dongnanv5PresActi.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSettings").setIndicator("tabSettings").setContent(new Intent(this, (Class<?>) Dongnanv5SettingActi.class)));
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.carinfo.od.dongnanv5.Dongnanv5IndexActi.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.jiede_btn_trip_info /* 2131431795 */:
                        Dongnanv5IndexActi.this.mTabHost.setCurrentTabByTag("tabTripInfo");
                        break;
                    case R.id.jiede_btn_history_info /* 2131431796 */:
                        Dongnanv5IndexActi.this.mTabHost.setCurrentTabByTag("tabPressureInfo");
                        break;
                    case R.id.jiede_btn_settings /* 2131431798 */:
                        Dongnanv5IndexActi.this.mTabHost.setCurrentTabByTag("tabSettings");
                        break;
                }
            }
        });
    }
}
