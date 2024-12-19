package com.syu.carinfo.lz.jaguar;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class TDLandRoverEcoDataIndexActi2 extends TabActivity {
    public static TDLandRoverEcoDataIndexActi2 mInstance;
    public static boolean mIsFront = false;
    private RadioGroup mGroup;
    private TabHost mTabHost;
    public TextView mTvTpis;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_td_landrover_mileage_index);
        init();
        mInstance = this;
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
    }

    private void init() {
        this.mGroup = (RadioGroup) findViewById(R.id.psa_all_oil_main_group);
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage1").setIndicator("tabPage1").setContent(new Intent(this, (Class<?>) TDLandRoverMilePage1Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage2").setIndicator("tabPage2").setContent(new Intent(this, (Class<?>) TDLandRoverMilePage2Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage3").setIndicator("tabPage3").setContent(new Intent(this, (Class<?>) TDLandRoverMilePage3Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage4").setIndicator("tabPage4").setContent(new Intent(this, (Class<?>) TDLandRoverMilePage4Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage5").setIndicator("tabPage5").setContent(new Intent(this, (Class<?>) TDLandRoverMilePage5Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage6").setIndicator("tabPage6").setContent(new Intent(this, (Class<?>) TDLandRoverMilePage6Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage7").setIndicator("tabPage7").setContent(new Intent(this, (Class<?>) TDLandRoverMilePage7Acti.class)));
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverEcoDataIndexActi2.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_plus1 /* 2131427482 */:
                        TDLandRoverEcoDataIndexActi2.this.mTabHost.setCurrentTabByTag("tabPage1");
                        break;
                    case R.id.btn_plus2 /* 2131427486 */:
                        TDLandRoverEcoDataIndexActi2.this.mTabHost.setCurrentTabByTag("tabPage2");
                        break;
                    case R.id.btn_plus3 /* 2131427490 */:
                        TDLandRoverEcoDataIndexActi2.this.mTabHost.setCurrentTabByTag("tabPage3");
                        break;
                    case R.id.btn_plus4 /* 2131427494 */:
                        TDLandRoverEcoDataIndexActi2.this.mTabHost.setCurrentTabByTag("tabPage4");
                        break;
                    case R.id.btn_plus5 /* 2131427498 */:
                        TDLandRoverEcoDataIndexActi2.this.mTabHost.setCurrentTabByTag("tabPage5");
                        break;
                    case R.id.btn_plus6 /* 2131427503 */:
                        TDLandRoverEcoDataIndexActi2.this.mTabHost.setCurrentTabByTag("tabPage6");
                        break;
                    case R.id.btn_plus7 /* 2131427507 */:
                        TDLandRoverEcoDataIndexActi2.this.mTabHost.setCurrentTabByTag("tabPage7");
                        break;
                }
            }
        });
    }
}
