package com.syu.carinfo.lz.jaguar;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.syu.canbus.R;

public class TDLandRoverEcoDataIndexActi2 extends TabActivity {
    public static TDLandRoverEcoDataIndexActi2 mInstance;
    public static boolean mIsFront = false;
    private RadioGroup mGroup;
    private TabHost mTabHost;
    public TextView mTvTpis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_td_landrover_mileage_index);
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
        this.mGroup = findViewById(R.id.psa_all_oil_main_group);
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage1").setIndicator("tabPage1").setContent(new Intent(this, TDLandRoverMilePage1Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage2").setIndicator("tabPage2").setContent(new Intent(this, TDLandRoverMilePage2Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage3").setIndicator("tabPage3").setContent(new Intent(this, TDLandRoverMilePage3Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage4").setIndicator("tabPage4").setContent(new Intent(this, TDLandRoverMilePage4Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage5").setIndicator("tabPage5").setContent(new Intent(this, TDLandRoverMilePage5Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage6").setIndicator("tabPage6").setContent(new Intent(this, TDLandRoverMilePage6Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage7").setIndicator("tabPage7").setContent(new Intent(this, TDLandRoverMilePage7Acti.class)));
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_plus1 /* 2131427457 */:
                        TDLandRoverEcoDataIndexActi2.this.mTabHost.setCurrentTabByTag("tabPage1");
                        break;
                    case R.id.btn_plus2 /* 2131427460 */:
                        TDLandRoverEcoDataIndexActi2.this.mTabHost.setCurrentTabByTag("tabPage2");
                        break;
                    case R.id.btn_plus3 /* 2131427463 */:
                        TDLandRoverEcoDataIndexActi2.this.mTabHost.setCurrentTabByTag("tabPage3");
                        break;
                    case R.id.btn_plus4 /* 2131427466 */:
                        TDLandRoverEcoDataIndexActi2.this.mTabHost.setCurrentTabByTag("tabPage4");
                        break;
                    case R.id.btn_plus5 /* 2131427469 */:
                        TDLandRoverEcoDataIndexActi2.this.mTabHost.setCurrentTabByTag("tabPage5");
                        break;
                    case R.id.btn_plus6 /* 2131427472 */:
                        TDLandRoverEcoDataIndexActi2.this.mTabHost.setCurrentTabByTag("tabPage6");
                        break;
                    case R.id.btn_plus7 /* 2131427475 */:
                        TDLandRoverEcoDataIndexActi2.this.mTabHost.setCurrentTabByTag("tabPage7");
                        break;
                }
            }
        });
    }
}
