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

@SuppressWarnings({"deprecation", "unchecked"})
public class GmAndraCarinfoIndexAct extends TabActivity {
    private TabHost mTabHost;
    int page_num = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 198:
                    if (value == 1) {
                        GmAndraCarinfoIndexAct.this.page_num++;
                        if (GmAndraCarinfoIndexAct.this.page_num > 3) {
                            GmAndraCarinfoIndexAct.this.page_num = 0;
                        }
                        GmAndraCarinfoIndexAct.this.mUpdatermTabHost();
                        break;
                    }
                case 199:
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0061_gm_andra_carinfo_index);
        init();
    }

    private void init() {
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripInfo").setIndicator("tabTripInfo").setContent(new Intent(this, (Class<?>) GmAndraCarInfo.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripAInfo").setIndicator("tabTripAInfo").setContent(new Intent(this, (Class<?>) GmAndraCarInfoTripA.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTripBInfo").setIndicator("tabTripBInfo").setContent(new Intent(this, (Class<?>) GmAndraCarInfoTripB.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabTireInfo").setIndicator("tabTireInfo").setContent(new Intent(this, (Class<?>) GmAndraTireAct.class)));
        ((RadioGroup) findViewById(R.id.camry_main_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.ctv_checkedtext1 /* 2131427525 */:
                        GmAndraCarinfoIndexAct.this.mTabHost.setCurrentTabByTag("tabTripInfo");
                        break;
                    case R.id.ctv_checkedtext2 /* 2131427541 */:
                        GmAndraCarinfoIndexAct.this.mTabHost.setCurrentTabByTag("tabTripAInfo");
                        break;
                    case R.id.ctv_checkedtext3 /* 2131427542 */:
                        GmAndraCarinfoIndexAct.this.mTabHost.setCurrentTabByTag("tabTripBInfo");
                        break;
                    case R.id.ctv_checkedtext4 /* 2131427544 */:
                        GmAndraCarinfoIndexAct.this.mTabHost.setCurrentTabByTag("tabTireInfo");
                        break;
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
    }

    
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
