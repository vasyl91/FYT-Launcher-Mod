package com.syu.carinfo.rzc.biaozhi408;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_BZ408EVMileIndexActi extends TabActivity {
    private RadioGroup mGroup;
    private TabHost mTabHost;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_biaozhi408_ev_index);
        init();
    }

    private void init() {
        this.mGroup = (RadioGroup) findViewById(R.id.rzc_bz408_oil_main_group);
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage1").setIndicator("tabPage1").setContent(new Intent(this, (Class<?>) RZC_BZ408EVMilePage1Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage2").setIndicator("tabPage2").setContent(new Intent(this, (Class<?>) RZC_BZ408EVMilePage2Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage3").setIndicator("tabPage3").setContent(new Intent(this, (Class<?>) RZC_BZ408EVMilePage3Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage4").setIndicator("tabPage3").setContent(new Intent(this, (Class<?>) RZC_BZ408EVMilePage4Acti.class)));
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408EVMileIndexActi.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rzc_bz408_oil_btn_page1 /* 2131431622 */:
                        RZC_BZ408EVMileIndexActi.this.mTabHost.setCurrentTabByTag("tabPage1");
                        break;
                    case R.id.rzc_bz408_oil_btn_page2 /* 2131431623 */:
                        RZC_BZ408EVMileIndexActi.this.mTabHost.setCurrentTabByTag("tabPage2");
                        break;
                    case R.id.rzc_bz408_oil_btn_page3 /* 2131431624 */:
                        RZC_BZ408EVMileIndexActi.this.mTabHost.setCurrentTabByTag("tabPage3");
                        break;
                    case R.id.rzc_bz408_oil_btn_page4 /* 2131431625 */:
                        RZC_BZ408EVMileIndexActi.this.mTabHost.setCurrentTabByTag("tabPage4");
                        break;
                }
            }
        });
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onPause() {
        super.onPause();
    }
}
