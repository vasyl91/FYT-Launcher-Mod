package com.syu.carinfo.psa;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;

import com.syu.canbus.R;

@SuppressWarnings({"deprecation", "unchecked"})
public class Psa308OilMileIndexActi extends TabActivity {
    public static Psa308OilMileIndexActi mInstance;
    public static boolean mIsFront = false;
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa308_oil_index);
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
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage1").setIndicator("tabPage1").setContent(new Intent(this, (Class<?>) Psa308OilMilePage1Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage2").setIndicator("tabPage2").setContent(new Intent(this, (Class<?>) Psa308OilMilePage2Acti.class)));
        ((RadioGroup) findViewById(R.id.psa308_oil_main_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.psa308_oil_btn_page1 /* 2131432283 */:
                        Psa308OilMileIndexActi.this.mTabHost.setCurrentTabByTag("tabPage1");
                        break;
                    case R.id.psa308_oil_btn_page2 /* 2131432284 */:
                        Psa308OilMileIndexActi.this.mTabHost.setCurrentTabByTag("tabPage2");
                        break;
                }
            }
        });
    }
}
