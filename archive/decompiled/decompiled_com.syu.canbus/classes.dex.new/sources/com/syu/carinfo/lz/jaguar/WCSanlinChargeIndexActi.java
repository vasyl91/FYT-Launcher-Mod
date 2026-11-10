package com.syu.carinfo.lz.jaguar;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WCSanlinChargeIndexActi extends TabActivity {
    public static WCSanlinChargeIndexActi mInstance;
    public static boolean mIsFront = false;
    private RadioGroup mGroup;
    private TabHost mTabHost;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_sanlin_charge_index);
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
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage1").setIndicator("tabPage1").setContent(new Intent(this, (Class<?>) WCSanlinChargePage1Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage2").setIndicator("tabPage2").setContent(new Intent(this, (Class<?>) WCSanlinChargePage2Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage3").setIndicator("tabPage3").setContent(new Intent(this, (Class<?>) WCSanlinChargePage3Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage4").setIndicator("tabPage4").setContent(new Intent(this, (Class<?>) WCSanlinChargePage4Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage5").setIndicator("tabPage5").setContent(new Intent(this, (Class<?>) WCSanlinChargePage5Acti.class)));
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.carinfo.lz.jaguar.WCSanlinChargeIndexActi.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_plus1 /* 2131427458 */:
                        WCSanlinChargeIndexActi.this.mTabHost.setCurrentTabByTag("tabPage1");
                        break;
                    case R.id.btn_plus2 /* 2131427461 */:
                        WCSanlinChargeIndexActi.this.mTabHost.setCurrentTabByTag("tabPage2");
                        break;
                    case R.id.btn_plus3 /* 2131427464 */:
                        WCSanlinChargeIndexActi.this.mTabHost.setCurrentTabByTag("tabPage3");
                        break;
                    case R.id.btn_plus4 /* 2131427467 */:
                        WCSanlinChargeIndexActi.this.mTabHost.setCurrentTabByTag("tabPage4");
                        break;
                    case R.id.btn_plus5 /* 2131427470 */:
                        WCSanlinChargeIndexActi.this.mTabHost.setCurrentTabByTag("tabPage5");
                        break;
                }
            }
        });
    }
}
