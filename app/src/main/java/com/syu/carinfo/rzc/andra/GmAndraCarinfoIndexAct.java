package com.syu.carinfo.rzc.andra;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GmAndraCarinfoIndexAct extends TabActivity {
    private TabHost mTabHost;
    int page_num = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.andra.GmAndraCarinfoIndexAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 137:
                    if (value == 1) {
                        GmAndraCarinfoIndexAct.this.page_num++;
                        if (GmAndraCarinfoIndexAct.this.page_num > 3) {
                            GmAndraCarinfoIndexAct.this.page_num = 0;
                        }
                        GmAndraCarinfoIndexAct.this.mUpdatermTabHost();
                        break;
                    }
                case 138:
                    if (value == 1) {
                        GmAndraCarinfoIndexAct gmAndraCarinfoIndexAct = GmAndraCarinfoIndexAct.this;
                        gmAndraCarinfoIndexAct.page_num--;
                        if (GmAndraCarinfoIndexAct.this.page_num < 0) {
                            GmAndraCarinfoIndexAct.this.page_num = 3;
                        }
                        GmAndraCarinfoIndexAct.this.mUpdatermTabHost();
                        break;
                    }
            }
        }
    };

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0061_gm_andra_carinfo_index);
        init();
    }

    private void init() {
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripInfo").setIndicator("tabTripInfo").setContent(new Intent(this, (Class<?>) GmAndraCarInfo.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripAInfo").setIndicator("tabTripAInfo").setContent(new Intent(this, (Class<?>) GmAndraCarInfoTripA.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripBInfo").setIndicator("tabTripBInfo").setContent(new Intent(this, (Class<?>) GmAndraCarInfoTripB.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTireInfo").setIndicator("tabTireInfo").setContent(new Intent(this, (Class<?>) GmAndraTireAct.class)));
        ((RadioGroup) findViewById(R.id.camry_main_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.syu.carinfo.rzc.andra.GmAndraCarinfoIndexAct.2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.ctv_checkedtext1 /* 2131427478 */:
                        GmAndraCarinfoIndexAct.this.mTabHost.setCurrentTabByTag("tabTripInfo");
                        break;
                    case R.id.ctv_checkedtext2 /* 2131427531 */:
                        GmAndraCarinfoIndexAct.this.mTabHost.setCurrentTabByTag("tabTripAInfo");
                        break;
                    case R.id.ctv_checkedtext3 /* 2131427532 */:
                        GmAndraCarinfoIndexAct.this.mTabHost.setCurrentTabByTag("tabTripBInfo");
                        break;
                    case R.id.ctv_checkedtext4 /* 2131427533 */:
                        GmAndraCarinfoIndexAct.this.mTabHost.setCurrentTabByTag("tabTireInfo");
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

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatermTabHost() {
        switch (this.page_num) {
            case 0:
                this.mTabHost.setCurrentTabByTag("tabTripInfo");
                ClearGroup();
                ((RadioButton) findViewById(R.id.ctv_checkedtext1)).setTextColor(Color.parseColor("#00ff00"));
                break;
            case 1:
                this.mTabHost.setCurrentTabByTag("tabTripAInfo");
                ClearGroup();
                ((RadioButton) findViewById(R.id.ctv_checkedtext2)).setTextColor(Color.parseColor("#00ff00"));
                break;
            case 2:
                this.mTabHost.setCurrentTabByTag("tabTripBInfo");
                ClearGroup();
                ((RadioButton) findViewById(R.id.ctv_checkedtext3)).setTextColor(Color.parseColor("#00ff00"));
                break;
            case 3:
                this.mTabHost.setCurrentTabByTag("tabTireInfo");
                ClearGroup();
                ((RadioButton) findViewById(R.id.ctv_checkedtext4)).setTextColor(Color.parseColor("#00ff00"));
                break;
        }
    }

    void ClearGroup() {
        ((RadioButton) findViewById(R.id.ctv_checkedtext1)).setTextColor(Color.parseColor("#FFFFFF"));
        ((RadioButton) findViewById(R.id.ctv_checkedtext2)).setTextColor(Color.parseColor("#FFFFFF"));
        ((RadioButton) findViewById(R.id.ctv_checkedtext3)).setTextColor(Color.parseColor("#FFFFFF"));
        ((RadioButton) findViewById(R.id.ctv_checkedtext4)).setTextColor(Color.parseColor("#FFFFFF"));
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
