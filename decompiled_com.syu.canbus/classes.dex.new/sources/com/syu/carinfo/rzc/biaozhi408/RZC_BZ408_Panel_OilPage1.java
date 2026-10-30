package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_BZ408_Panel_OilPage1 extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408_Panel_OilPage1.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 101:
                    RZC_BZ408_Panel_OilPage1.this.mUpdaterOilExpend();
                    break;
                case 102:
                    RZC_BZ408_Panel_OilPage1.this.mUpdaterDrivingMileage();
                    break;
                case 103:
                    RZC_BZ408_Panel_OilPage1.this.mUpdaterSpecialMileage();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_c4l_oil_page1);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(29, new int[1], null, null);
        DataCanbus.PROXY.cmd(70, new int[1], null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[101];
        if (((TextView) findViewById(R.id.rzc_c4l_tv_oil_page1_tv1)) != null) {
            if (value > -1 && value < 3001) {
                ((TextView) findViewById(R.id.rzc_c4l_tv_oil_page1_tv1)).setText(String.valueOf(value / 10.0f) + " L/100KM");
            } else {
                ((TextView) findViewById(R.id.rzc_c4l_tv_oil_page1_tv1)).setText("--.--");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.rzc_c4l_tv_oil_page1_tv2)) != null) {
            if (value > -1 && value < 2001) {
                ((TextView) findViewById(R.id.rzc_c4l_tv_oil_page1_tv2)).setText(String.valueOf(value) + " KM");
            } else {
                ((TextView) findViewById(R.id.rzc_c4l_tv_oil_page1_tv2)).setText("--.--");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSpecialMileage() {
        int value = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.rzc_c4l_tv_oil_page1_tv3)) != null) {
            if (value > -1 && value < 6001) {
                ((TextView) findViewById(R.id.rzc_c4l_tv_oil_page1_tv3)).setText(String.valueOf(value) + " KM");
            } else {
                ((TextView) findViewById(R.id.rzc_c4l_tv_oil_page1_tv3)).setText("--.--");
            }
        }
    }
}
