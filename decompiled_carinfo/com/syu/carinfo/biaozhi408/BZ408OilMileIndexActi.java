package com.syu.carinfo.biaozhi408;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.syu.canbus.R;

@SuppressWarnings({"deprecation", "unchecked"})
public class BZ408OilMileIndexActi extends TabActivity {
    public static BZ408OilMileIndexActi mInstance;
    public static boolean mIsFront = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_biaozhi408_oil_index);
        init();
        mInstance = this;
    }

    private void init() {
        getTabHost().addTab(getTabHost().newTabSpec("tabPage1").setIndicator("tabPage1").setContent(new Intent(this, (Class<?>) BZ408OilMilePage1Acti.class)));
        getTabHost().addTab(getTabHost().newTabSpec("tabPage2").setIndicator("tabPage2").setContent(new Intent(this, (Class<?>) BZ408OilMilePage2Acti.class)));
        getTabHost().addTab(getTabHost().newTabSpec("tabPage3").setIndicator("tabPage3").setContent(new Intent(this, (Class<?>) BZ408OilMilePage3Acti.class)));
        ((RadioGroup) findViewById(R.id.bz408_oil_main_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bz408_oil_btn_page1 /* 2131430529 */:
                        BZ408OilMileIndexActi.this.getTabHost().setCurrentTabByTag("tabPage1");
                        break;
                    case R.id.bz408_oil_btn_page2 /* 2131430530 */:
                        BZ408OilMileIndexActi.this.getTabHost().setCurrentTabByTag("tabPage2");
                        break;
                    case R.id.bz408_oil_btn_page3 /* 2131430531 */:
                        BZ408OilMileIndexActi.this.getTabHost().setCurrentTabByTag("tabPage3");
                        break;
                }
            }
        });
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
}
