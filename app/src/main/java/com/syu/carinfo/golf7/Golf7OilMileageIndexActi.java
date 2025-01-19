package com.syu.carinfo.golf7;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class Golf7OilMileageIndexActi extends TabActivity {
    private RadioGroup mGroup;
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_oil_index);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(98, new int[]{2}, null, null);
    }

    private void init() {
        this.mGroup = (RadioGroup) findViewById(R.id.golf_oil_main_group);
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSinceStart").setIndicator("tabSinceStart").setContent(new Intent(this, (Class<?>) Golf7OilMileagePage1Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabLongTerm").setIndicator("tabLongTerm").setContent(new Intent(this, (Class<?>) Golf7OilMileagePage2Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSinceRefuelling").setIndicator("tabSinceRefuelling").setContent(new Intent(this, (Class<?>) Golf7OilMileagePage3Acti.class)));
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.golf_oil_btn_page1 /* 2131431575 */:
                        Golf7OilMileageIndexActi.this.mTabHost.setCurrentTabByTag("tabSinceStart");
                        break;
                    case R.id.golf_oil_btn_page3 /* 2131431576 */:
                        Golf7OilMileageIndexActi.this.mTabHost.setCurrentTabByTag("tabSinceRefuelling");
                        break;
                    case R.id.golf_oil_btn_page2 /* 2131431577 */:
                        Golf7OilMileageIndexActi.this.mTabHost.setCurrentTabByTag("tabLongTerm");
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
