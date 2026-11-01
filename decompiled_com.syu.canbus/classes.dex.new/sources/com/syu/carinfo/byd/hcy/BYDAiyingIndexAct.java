package com.syu.carinfo.byd.hcy;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class BYDAiyingIndexAct extends TabActivity {
    public static boolean mIsFront = false;
    private TabHost mTabHost;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_aiying_byd_index);
        init();
    }

    private void init() {
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabBydAir").setIndicator("tabBydAir").setContent(new Intent(this, (Class<?>) BYDAiyingAirCrtrlAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabBydPM25").setIndicator("tabBydPM25").setContent(new Intent(this, (Class<?>) BYDAiyingPM25Act.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabBydDoorlock").setIndicator("tabBydDoorlock").setContent(new Intent(this, (Class<?>) BYDAiyingDoorLockAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabBydDriving").setIndicator("tabBydDriving").setContent(new Intent(this, (Class<?>) BYDAiyingDrivingSetAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabBydOther").setIndicator("tabBydOther").setContent(new Intent(this, (Class<?>) BYDAiyingOtherSetAct.class)));
        ((RadioGroup) findViewById(R.id.camry_main_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.carinfo.byd.hcy.BYDAiyingIndexAct.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_plus1 /* 2131427458 */:
                        BYDAiyingIndexAct.this.mTabHost.setCurrentTabByTag("tabBydAir");
                        break;
                    case R.id.btn_plus2 /* 2131427461 */:
                        BYDAiyingIndexAct.this.mTabHost.setCurrentTabByTag("tabBydPM25");
                        break;
                    case R.id.btn_plus3 /* 2131427464 */:
                        BYDAiyingIndexAct.this.mTabHost.setCurrentTabByTag("tabBydDoorlock");
                        break;
                    case R.id.btn_plus4 /* 2131427467 */:
                        BYDAiyingIndexAct.this.mTabHost.setCurrentTabByTag("tabBydDriving");
                        break;
                    case R.id.btn_plus5 /* 2131427470 */:
                        BYDAiyingIndexAct.this.mTabHost.setCurrentTabByTag("tabBydOther");
                        break;
                }
            }
        });
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        this.mTabHost.setCurrentTabByTag("tabBydAir");
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
