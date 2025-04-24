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

@SuppressWarnings({"deprecation", "unchecked"})
public class RZC_BZ408_Panel_Oil_Index extends TabActivity {
    public static RZC_BZ408_Panel_Oil_Index mInstance;
    public static boolean mIsFront = false;
    public RadioButton btnPage1;
    public RadioButton btnPage2;
    public RadioButton btnPage3;
    private RadioGroup mGroup;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 18:
                    RZC_BZ408_Panel_Oil_Index.this.mUpdaterValue1();
                    break;
            }
        }
    };
    private TabHost mTabHost;
    public TextView mTvTpis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_c4l_oil_index);
        init();
        mInstance = this;
    }

    private void init() {
        this.mGroup = (RadioGroup) findViewById(R.id.rzc_c4l_oil_main_group);
        this.btnPage1 = (RadioButton) findViewById(R.id.rzc_c4l_oil_btn_page1);
        this.btnPage2 = (RadioButton) findViewById(R.id.rzc_c4l_oil_btn_page2);
        this.btnPage3 = (RadioButton) findViewById(R.id.rzc_c4l_oil_btn_page3);
        this.mTabHost = getTabHost();
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage1").setIndicator("tabPage1").setContent(new Intent(this, (Class<?>) RZC_BZ408_Panel_OilPage1.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage2").setIndicator("tabPage2").setContent(new Intent(this, (Class<?>) RZC_BZ408_Panel_OilPage2.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage3").setIndicator("tabPage3").setContent(new Intent(this, (Class<?>) RZC_BZ408_Panel_OilPage3.class)));
        this.mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rzc_c4l_oil_btn_page1 /* 2131432571 */:
                        RZC_BZ408_Panel_Oil_Index.this.mTabHost.setCurrentTabByTag("tabPage1");
                        break;
                    case R.id.rzc_c4l_oil_btn_page2 /* 2131432572 */:
                        RZC_BZ408_Panel_Oil_Index.this.mTabHost.setCurrentTabByTag("tabPage2");
                        break;
                    case R.id.rzc_c4l_oil_btn_page3 /* 2131432573 */:
                        RZC_BZ408_Panel_Oil_Index.this.mTabHost.setCurrentTabByTag("tabPage3");
                        break;
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[18];
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
