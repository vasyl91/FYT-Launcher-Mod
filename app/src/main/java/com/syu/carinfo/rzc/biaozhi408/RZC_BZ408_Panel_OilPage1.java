package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZC_BZ408_Panel_OilPage1 extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408_Panel_OilPage1.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 11:
                    RZC_BZ408_Panel_OilPage1.this.mUpdaterOilExpend();
                    break;
                case 12:
                    RZC_BZ408_Panel_OilPage1.this.mUpdaterDrivingMileage();
                    break;
                case 13:
                    RZC_BZ408_Panel_OilPage1.this.mUpdaterSpecialMileage();
                    break;
            }
        }
    };
    private TextView mTv1;
    private TextView mTv2;
    private TextView mTv3;
    private TextView mTv4;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_c4l_oil_page1);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mTv1 = (TextView) findViewById(R.id.rzc_c4l_tv_oil_page1_tv1);
        this.mTv2 = (TextView) findViewById(R.id.rzc_c4l_tv_oil_page1_tv2);
        this.mTv3 = (TextView) findViewById(R.id.rzc_c4l_tv_oil_page1_tv3);
        this.mTv4 = (TextView) findViewById(R.id.rzc_c4l_tv_oil_page1_tv4_text);
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
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[11];
        if (this.mTv1 != null) {
            if (value > -1 && value < 3001) {
                this.mTv1.setText(String.valueOf(value / 10.0f) + " L/100KM");
            } else {
                this.mTv1.setText("--.--");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[12];
        if (this.mTv2 != null) {
            if (value > -1 && value < 2001) {
                this.mTv2.setText(String.valueOf(value) + " KM");
            } else {
                this.mTv2.setText("--.--");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSpecialMileage() {
        int value = DataCanbus.DATA[13];
        if (this.mTv3 != null) {
            if (value > -1 && value < 6001) {
                this.mTv3.setText(String.valueOf(value) + " KM");
            } else {
                this.mTv3.setText("--.--");
            }
        }
    }
}
