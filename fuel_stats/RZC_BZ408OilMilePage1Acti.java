package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZC_BZ408OilMilePage1Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408OilMilePage1Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 87:
                    RZC_BZ408OilMilePage1Acti.this.mUpdaterStartStopTime();
                    break;
                case 91:
                    RZC_BZ408OilMilePage1Acti.this.mUpdaterOilExpend();
                    break;
                case 92:
                    RZC_BZ408OilMilePage1Acti.this.mUpdaterDrivingMileage();
                    break;
                case 93:
                    RZC_BZ408OilMilePage1Acti.this.mUpdaterSpecialMileage();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_biaozhi408_oil_page1);
        init();
        DataCanbus.PROXY.cmd(70, new int[]{51}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(29, new int[1], null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[91];
        if (((TextView) findViewById(R.id.rzc_bz408_tv_oil_page1_tv1)) != null) {
            if (value > -1 && value < 3001) {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page1_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " L/100KM");
            } else {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page1_tv1)).setText("--.--");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[92];
        if (((TextView) findViewById(R.id.rzc_bz408_tv_oil_page1_tv2)) != null) {
            if (value > -1 && value < 2001) {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page1_tv2)).setText(String.valueOf(value) + " KM");
            } else {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page1_tv2)).setText("--.--");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSpecialMileage() {
        int value = DataCanbus.DATA[93];
        if (((TextView) findViewById(R.id.rzc_bz408_tv_oil_page1_tv3)) != null) {
            if (value > -1 && value < 6001) {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page1_tv3)).setText(String.valueOf(value) + " KM");
            } else {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page1_tv3)).setText("--.--");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterStartStopTime() {
        int value = DataCanbus.DATA[87];
        int hour = (16711680 & value) >> 16;
        int min = (65280 & value) >> 8;
        int second = value & 255;
        if (((TextView) findViewById(R.id.rzc_bz408_tv_oil_page1_tv4)) != null) {
            if (hour == 255 || min == 255 || second == 255) {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page1_tv4)).setText("--:--:--");
            } else {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page1_tv4)).setText(String.format("%02d:%02d:%02d", Integer.valueOf(hour), Integer.valueOf(min), Integer.valueOf(second)));
            }
        }
    }
}
