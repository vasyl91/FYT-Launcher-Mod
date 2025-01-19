package com.syu.carinfo.byd.hcy;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;

public class BYDAiyingIndexAct extends TabActivity {
    public static boolean mIsFront = false;
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0455_aiying_byd_index);
        init();
    }

    private void init() {
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabBydAir").setIndicator("tabBydAir").setContent(new Intent(this, (Class<?>) BYDAiyingAirCrtrlAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabBydPM25").setIndicator("tabBydPM25").setContent(new Intent(this, (Class<?>) BYDAiyingPM25Act.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabBydDoorlock").setIndicator("tabBydDoorlock").setContent(new Intent(this, (Class<?>) BYDAiyingDoorLockAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabBydDriving").setIndicator("tabBydDriving").setContent(new Intent(this, (Class<?>) BYDAiyingDrivingSetAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabBydOther").setIndicator("tabBydOther").setContent(new Intent(this, (Class<?>) BYDAiyingOtherSetAct.class)));
        ((RadioGroup) findViewById(R.id.camry_main_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_plus1 /* 2131427457 */:
                        BYDAiyingIndexAct.this.mTabHost.setCurrentTabByTag("tabBydAir");
                        break;
                    case R.id.btn_plus2 /* 2131427460 */:
                        BYDAiyingIndexAct.this.mTabHost.setCurrentTabByTag("tabBydPM25");
                        break;
                    case R.id.btn_plus3 /* 2131427463 */:
                        BYDAiyingIndexAct.this.mTabHost.setCurrentTabByTag("tabBydDoorlock");
                        break;
                    case R.id.btn_plus4 /* 2131427466 */:
                        BYDAiyingIndexAct.this.mTabHost.setCurrentTabByTag("tabBydDriving");
                        break;
                    case R.id.btn_plus5 /* 2131427469 */:
                        BYDAiyingIndexAct.this.mTabHost.setCurrentTabByTag("tabBydOther");
                        break;
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        this.mTabHost.setCurrentTabByTag("tabBydAir");
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
