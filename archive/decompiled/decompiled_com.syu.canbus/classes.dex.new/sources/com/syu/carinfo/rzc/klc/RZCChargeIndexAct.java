package com.syu.carinfo.rzc.klc;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZCChargeIndexAct extends TabActivity {
    private TabHost mTabHost;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0061_rzc_gm_charge_index);
        init();
    }

    private void init() {
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabChargeSet1").setIndicator("tabChargeSet1").setContent(new Intent(this, (Class<?>) RZC_GMChargeSet1InfoAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabChargeSet2").setIndicator("tabChargeSet2").setContent(new Intent(this, (Class<?>) RZC_GMChargeSet2InfoAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabChargeSet3").setIndicator("tabChargeSet3").setContent(new Intent(this, (Class<?>) RZC_GMChargeSet3InfoAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabChargeSet4").setIndicator("tabChargeSet4").setContent(new Intent(this, (Class<?>) RZC_GMChargeSet4InfoAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabChargeSet5").setIndicator("tabChargeSet5").setContent(new Intent(this, (Class<?>) RZC_GMChargeSet5InfoAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabChargeSet6").setIndicator("tabChargeSet6").setContent(new Intent(this, (Class<?>) RZC_GMChargeSet6InfoAct.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabChargeSet7").setIndicator("tabChargeSet7").setContent(new Intent(this, (Class<?>) RZC_GMChargeSet7InfoAct.class)));
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_ALL_GM_22VELITE6_PHEV /* 7340093 */:
                findViewById(R.id.ctv_checkedtext3).setVisibility(8);
                findViewById(R.id.ctv_checkedtext4).setVisibility(0);
                findViewById(R.id.ctv_checkedtext5).setVisibility(0);
                findViewById(R.id.ctv_checkedtext6).setVisibility(0);
                findViewById(R.id.ctv_checkedtext7).setVisibility(0);
                break;
            default:
                findViewById(R.id.ctv_checkedtext3).setVisibility(0);
                findViewById(R.id.ctv_checkedtext4).setVisibility(8);
                findViewById(R.id.ctv_checkedtext5).setVisibility(8);
                findViewById(R.id.ctv_checkedtext6).setVisibility(8);
                findViewById(R.id.ctv_checkedtext7).setVisibility(8);
                break;
        }
        ((RadioGroup) findViewById(R.id.camry_main_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.carinfo.rzc.klc.RZCChargeIndexAct.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.ctv_checkedtext1 /* 2131427554 */:
                        RZCChargeIndexAct.this.mTabHost.setCurrentTabByTag("tabChargeSet1");
                        break;
                    case R.id.ctv_checkedtext4 /* 2131427561 */:
                        RZCChargeIndexAct.this.mTabHost.setCurrentTabByTag("tabChargeSet4");
                        break;
                    case R.id.ctv_checkedtext5 /* 2131427562 */:
                        RZCChargeIndexAct.this.mTabHost.setCurrentTabByTag("tabChargeSet5");
                        break;
                    case R.id.ctv_checkedtext2 /* 2131427576 */:
                        RZCChargeIndexAct.this.mTabHost.setCurrentTabByTag("tabChargeSet2");
                        break;
                    case R.id.ctv_checkedtext3 /* 2131427577 */:
                        RZCChargeIndexAct.this.mTabHost.setCurrentTabByTag("tabChargeSet3");
                        break;
                    case R.id.ctv_checkedtext6 /* 2131427581 */:
                        RZCChargeIndexAct.this.mTabHost.setCurrentTabByTag("tabChargeSet6");
                        break;
                    case R.id.ctv_checkedtext7 /* 2131427582 */:
                        RZCChargeIndexAct.this.mTabHost.setCurrentTabByTag("tabChargeSet7");
                        break;
                }
            }
        });
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
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
