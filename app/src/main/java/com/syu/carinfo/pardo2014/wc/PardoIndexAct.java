package com.syu.carinfo.pardo2014.wc;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.ui.door.DoorHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class PardoIndexAct extends TabActivity {
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_pardo_index);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (LauncherApplication.getScreenWidth() != 800) {
            DoorHelper.disableDoorWindowLocal(true);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        DoorHelper.disableDoorWindowLocal(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DoorHelper.disableDoorWindowLocal(false);
    }

    private void init() {
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripInfo").setIndicator("tabTripInfo").setContent(new Intent(this, (Class<?>) PardoBaseAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabHistory").setIndicator("tabHistory").setContent(new Intent(this, (Class<?>) PardoTripAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSettings").setIndicator("tabSettings").setContent(new Intent(this, (Class<?>) PardoSettingsAct.class)));
        ((RadioGroup) findViewById(R.id.pardo_main_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.pardo_btn_trip_info /* 2131432124 */:
                        PardoIndexAct.this.mTabHost.setCurrentTabByTag("tabTripInfo");
                        break;
                    case R.id.pardo_btn_history_info /* 2131432125 */:
                        PardoIndexAct.this.mTabHost.setCurrentTabByTag("tabHistory");
                        break;
                    case R.id.pardo_btn_settings /* 2131432126 */:
                        PardoIndexAct.this.mTabHost.setCurrentTabByTag("tabSettings");
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
