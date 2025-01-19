package com.syu.carinfo.wc.leinuo;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;

public class DusterOilMileIndexActi extends TabActivity {
    public static DusterOilMileIndexActi mInstance;
    public static boolean mIsFront = false;
    private RadioGroup mGroup;
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_duster_all_oil_index);
        init();
        mInstance = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
    }

    private void init() {
        this.mGroup = (RadioGroup) findViewById(R.id.psa_all_oil_main_group);
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage1").setIndicator("tabPage1").setContent(new Intent(this, (Class<?>) DusterOilMilePage1Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage2").setIndicator("tabPage2").setContent(new Intent(this, (Class<?>) DusterOilMilePage2Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage3").setIndicator("tabPage3").setContent(new Intent(this, (Class<?>) DusterOilMilePage3Acti.class)));
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.psa_all_oil_btn_page1 /* 2131430917 */:
                        DusterOilMileIndexActi.this.mTabHost.setCurrentTabByTag("tabPage1");
                        break;
                    case R.id.psa_all_oil_btn_page2 /* 2131430918 */:
                        DusterOilMileIndexActi.this.mTabHost.setCurrentTabByTag("tabPage2");
                        break;
                    case R.id.psa_all_oil_btn_page3 /* 2131430919 */:
                        DusterOilMileIndexActi.this.mTabHost.setCurrentTabByTag("tabPage3");
                        break;
                }
            }
        });
    }
}
