package com.syu.carinfo.od.mazdall;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.syu.canbus.R;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCTataCarInfoIndexAct extends TabActivity {
    private RadioGroup mGroup;
    private TabHost mTabHost;
    public TextView mTvTpis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_tata_carinfo_index);
        init();
    }

    private void init() {
        this.mGroup = findViewById(R.id.camry_main_group);
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabCurrentInfo").setIndicator("tabCurrentInfo").setContent(new Intent(this, WCTataCurrentCarInfo.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabBestInfo").setIndicator("tabBestInfo").setContent(new Intent(this, WCTataBestCarInfo.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripAInfo").setIndicator("tabTripAInfo").setContent(new Intent(this, WCTataTripACarInfo.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripBInfo").setIndicator("tabTripBInfo").setContent(new Intent(this, WCTataTripBCarInfo.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabAllInfo").setIndicator("tabAllInfo").setContent(new Intent(this, WCTataAllCarInfo.class)));
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_plus1 /* 2131427457 */:
                        WCTataCarInfoIndexAct.this.mTabHost.setCurrentTabByTag("tabCurrentInfo");
                        break;
                    case R.id.btn_plus2 /* 2131427460 */:
                        WCTataCarInfoIndexAct.this.mTabHost.setCurrentTabByTag("tabBestInfo");
                        break;
                    case R.id.btn_plus3 /* 2131427463 */:
                        WCTataCarInfoIndexAct.this.mTabHost.setCurrentTabByTag("tabTripAInfo");
                        break;
                    case R.id.btn_plus4 /* 2131427466 */:
                        WCTataCarInfoIndexAct.this.mTabHost.setCurrentTabByTag("tabTripBInfo");
                        break;
                    case R.id.btn_plus5 /* 2131427469 */:
                        WCTataCarInfoIndexAct.this.mTabHost.setCurrentTabByTag("tabAllInfo");
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
