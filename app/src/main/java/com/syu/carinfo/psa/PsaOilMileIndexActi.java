package com.syu.carinfo.psa;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;

public class PsaOilMileIndexActi extends TabActivity {
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa_oil_index);
        init();
    }

    private void init() {
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage1").setIndicator("tabPage1").setContent(new Intent(this, (Class<?>) PsaOilMilePage1Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage2").setIndicator("tabPage2").setContent(new Intent(this, (Class<?>) PsaOilMilePage2Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage3").setIndicator("tabPage3").setContent(new Intent(this, (Class<?>) PsaOilMilePage3Acti.class)));
        ((RadioGroup) findViewById(R.id.psa_oil_main_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.psa_oil_btn_page1 /* 2131432329 */:
                        PsaOilMileIndexActi.this.mTabHost.setCurrentTabByTag("tabPage1");
                        break;
                    case R.id.psa_oil_btn_page2 /* 2131432330 */:
                        PsaOilMileIndexActi.this.mTabHost.setCurrentTabByTag("tabPage2");
                        break;
                    case R.id.psa_oil_btn_page3 /* 2131432331 */:
                        PsaOilMileIndexActi.this.mTabHost.setCurrentTabByTag("tabPage3");
                        break;
                }
            }
        });
    }
}
