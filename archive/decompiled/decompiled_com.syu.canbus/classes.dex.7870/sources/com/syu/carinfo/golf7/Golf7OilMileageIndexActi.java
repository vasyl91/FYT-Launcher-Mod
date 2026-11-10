package com.syu.carinfo.golf7;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Golf7OilMileageIndexActi extends TabActivity {
    private TabHost mTabHost;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_oil_index);
        init();
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(98, new int[]{2}, null, null);
    }

    private void init() {
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSinceStart").setIndicator("tabSinceStart").setContent(new Intent(this, (Class<?>) Golf7OilMileagePage1Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabLongTerm").setIndicator("tabLongTerm").setContent(new Intent(this, (Class<?>) Golf7OilMileagePage2Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabSinceRefuelling").setIndicator("tabSinceRefuelling").setContent(new Intent(this, (Class<?>) Golf7OilMileagePage3Acti.class)));
        ((RadioGroup) findViewById(R.id.layout_view1)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.carinfo.golf7.Golf7OilMileageIndexActi.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_plus1 /* 2131427419 */:
                        Golf7OilMileageIndexActi.this.mTabHost.setCurrentTabByTag("tabSinceStart");
                        break;
                    case R.id.btn_plus2 /* 2131427423 */:
                        Golf7OilMileageIndexActi.this.mTabHost.setCurrentTabByTag("tabSinceRefuelling");
                        break;
                    case R.id.btn_plus3 /* 2131427427 */:
                        Golf7OilMileageIndexActi.this.mTabHost.setCurrentTabByTag("tabLongTerm");
                        break;
                }
            }
        });
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
