package com.syu.carinfo.xbs.tule;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;

@SuppressWarnings({"deprecation", "unchecked"})
public class XBSTuleDZSJIndexAct extends TabActivity {
    private RadioGroup mGroup;
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xbs_tule_index_dzsj);
        init();
    }

    private void init() {
        this.mGroup = (RadioGroup) findViewById(R.id.camry_main_group);
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTireInfo").setIndicator("tabTireInfo").setContent(new Intent(this, (Class<?>) XBSTuleTireActDZSJ.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabHistory").setIndicator("tabHistory").setContent(new Intent(this, (Class<?>) XBSTuleHistoryActDZSJ.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabBaseInfo").setIndicator("tabBaseInfo").setContent(new Intent(this, (Class<?>) XBSTuleSettingDZSJ.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripInfo").setIndicator("tabTripInfo").setContent(new Intent(this, (Class<?>) XBSTuleCarInfoDZSJ.class)));
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.camry_btn_trip_info /* 2131428108 */:
                        XBSTuleDZSJIndexAct.this.mTabHost.setCurrentTabByTag("tabTripInfo");
                        break;
                    case R.id.camry_btn_history_info /* 2131428109 */:
                        XBSTuleDZSJIndexAct.this.mTabHost.setCurrentTabByTag("tabHistory");
                        break;
                    case R.id.camry_btn_base_info /* 2131430649 */:
                        XBSTuleDZSJIndexAct.this.mTabHost.setCurrentTabByTag("tabBaseInfo");
                        break;
                    case R.id.camry_btn_trie_info /* 2131430651 */:
                        XBSTuleDZSJIndexAct.this.mTabHost.setCurrentTabByTag("tabTireInfo");
                        break;
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
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
