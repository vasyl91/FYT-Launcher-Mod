package com.syu.carinfo.rzc.biaozhi408;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZC_BZ408OilMileIndexActi extends TabActivity {
    public RadioButton btnPage1;
    public RadioButton btnPage2;
    public RadioButton btnPage3;
    private RadioGroup mGroup;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408OilMileIndexActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 153:
                    RZC_BZ408OilMileIndexActi.this.mUpdaterValue1();
                    break;
            }
        }
    };
    private TabHost mTabHost;
    public TextView mTvTpis;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_biaozhi408_oil_index);
        init();
    }

    private void init() {
        this.mGroup = (RadioGroup) findViewById(R.id.rzc_bz408_oil_main_group);
        this.btnPage1 = (RadioButton) findViewById(R.id.rzc_bz408_oil_btn_page1);
        this.btnPage2 = (RadioButton) findViewById(R.id.rzc_bz408_oil_btn_page2);
        this.btnPage3 = (RadioButton) findViewById(R.id.rzc_bz408_oil_btn_page3);
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage1").setIndicator("tabPage1").setContent(new Intent(this, (Class<?>) RZC_BZ408OilMilePage1Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage2").setIndicator("tabPage2").setContent(new Intent(this, (Class<?>) RZC_BZ408OilMilePage2Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage3").setIndicator("tabPage3").setContent(new Intent(this, (Class<?>) RZC_BZ408OilMilePage3Acti.class)));
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408OilMileIndexActi.2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rzc_bz408_oil_btn_page1 /* 2131432616 */:
                        RZC_BZ408OilMileIndexActi.this.mTabHost.setCurrentTabByTag("tabPage1");
                        break;
                    case R.id.rzc_bz408_oil_btn_page2 /* 2131432617 */:
                        RZC_BZ408OilMileIndexActi.this.mTabHost.setCurrentTabByTag("tabPage2");
                        break;
                    case R.id.rzc_bz408_oil_btn_page3 /* 2131432618 */:
                        RZC_BZ408OilMileIndexActi.this.mTabHost.setCurrentTabByTag("tabPage3");
                        break;
                }
            }
        });
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    protected void finalize() throws Throwable {
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[153];
        if (this.mTabHost != null) {
            this.mTabHost.setCurrentTab(value);
        }
        if (this.btnPage1 != null) {
            if (value == 0) {
                this.btnPage1.setChecked(true);
                this.btnPage2.setChecked(false);
                this.btnPage3.setChecked(false);
            } else if (value == 1) {
                this.btnPage1.setChecked(false);
                this.btnPage2.setChecked(true);
                this.btnPage3.setChecked(false);
            } else if (value == 2) {
                this.btnPage1.setChecked(false);
                this.btnPage2.setChecked(false);
                this.btnPage3.setChecked(true);
            }
        }
    }
}
