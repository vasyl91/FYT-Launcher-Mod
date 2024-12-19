package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZC_BZ408_Panel_OilPage3 extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408_Panel_OilPage3.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 15:
                    RZC_BZ408_Panel_OilPage3.this.mUpdaterValue1();
                    break;
                case 16:
                    RZC_BZ408_Panel_OilPage3.this.mUpdaterValue3();
                    break;
                case 17:
                    RZC_BZ408_Panel_OilPage3.this.mUpdaterValue2();
                    break;
            }
        }
    };
    private TextView mTv1;
    private TextView mTv2;
    private TextView mTv3;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_c4l_oil_page3);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mTv1 = (TextView) findViewById(R.id.rzc_c4l_tv_oil_page3_tv1);
        this.mTv2 = (TextView) findViewById(R.id.rzc_c4l_tv_oil_page3_tv2);
        this.mTv3 = (TextView) findViewById(R.id.rzc_c4l_tv_oil_page3_tv3);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(29, new int[]{1}, null, null);
        DataCanbus.PROXY.cmd(72, new int[1], null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[15];
        if (this.mTv1 != null) {
            if (value > -1 && value < 301) {
                this.mTv1.setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " L/100");
            } else {
                this.mTv1.setText("--.--");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[17];
        if (this.mTv2 != null) {
            if (value > -1 && value < 251) {
                this.mTv2.setText(String.valueOf(value) + " KM/H");
            } else {
                this.mTv2.setText("--.--");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[16];
        if (this.mTv3 != null) {
            if (value > -1 && value < 10000) {
                this.mTv3.setText(String.valueOf(value) + " KM");
            } else {
                this.mTv3.setText("--.--");
            }
        }
    }
}
