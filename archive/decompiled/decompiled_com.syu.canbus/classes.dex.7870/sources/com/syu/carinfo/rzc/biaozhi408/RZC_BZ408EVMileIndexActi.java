package com.syu.carinfo.rzc.biaozhi408;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class RZC_BZ408EVMileIndexActi extends TabActivity {
    private TabHost mTabHost;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_biaozhi408_ev_index);
        init();
    }

    private void init() {
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage1").setIndicator("tabPage1").setContent(new Intent(this, (Class<?>) RZC_BZ408EVMilePage1Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage2").setIndicator("tabPage2").setContent(new Intent(this, (Class<?>) RZC_BZ408EVMilePage2Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage3").setIndicator("tabPage3").setContent(new Intent(this, (Class<?>) RZC_BZ408EVMilePage3Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage4").setIndicator("tabPage3").setContent(new Intent(this, (Class<?>) RZC_BZ408EVMilePage4Acti.class)));
        ((RadioGroup) findViewById(R.id.layout_view1)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408EVMileIndexActi.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_plus1 /* 2131427419 */:
                        RZC_BZ408EVMileIndexActi.this.mTabHost.setCurrentTabByTag("tabPage1");
                        break;
                    case R.id.btn_plus2 /* 2131427423 */:
                        RZC_BZ408EVMileIndexActi.this.mTabHost.setCurrentTabByTag("tabPage2");
                        break;
                    case R.id.btn_plus3 /* 2131427427 */:
                        RZC_BZ408EVMileIndexActi.this.mTabHost.setCurrentTabByTag("tabPage3");
                        break;
                    case R.id.btn_plus4 /* 2131427428 */:
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
