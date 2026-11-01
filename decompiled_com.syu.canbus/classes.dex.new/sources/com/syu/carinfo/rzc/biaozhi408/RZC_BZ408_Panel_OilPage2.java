package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_BZ408_Panel_OilPage2 extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408_Panel_OilPage2.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    RZC_BZ408_Panel_OilPage2.this.mUpdaterValue1();
                    break;
                case 100:
                    RZC_BZ408_Panel_OilPage2.this.mUpdaterValue2();
                    break;
                case 104:
                    RZC_BZ408_Panel_OilPage2.this.mUpdaterValue3();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_c4l_oil_page2);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(29, new int[]{1}, null, null);
        DataCanbus.PROXY.cmd(71, new int[1], null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[99];
        if (((TextView) findViewById(R.id.rzc_c4l_tv_oil_page2_tv1)) != null) {
            if (value > -1 && value < 301) {
                ((TextView) findViewById(R.id.rzc_c4l_tv_oil_page2_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " L/100");
            } else {
                ((TextView) findViewById(R.id.rzc_c4l_tv_oil_page2_tv1)).setText("--.--");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[100];
        if (((TextView) findViewById(R.id.rzc_c4l_tv_oil_page2_tv2)) != null) {
            if (value > -1 && value < 251) {
                ((TextView) findViewById(R.id.rzc_c4l_tv_oil_page2_tv2)).setText(String.valueOf(value) + " KM/H");
            } else {
                ((TextView) findViewById(R.id.rzc_c4l_tv_oil_page2_tv2)).setText("--.--");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[104];
        if (((TextView) findViewById(R.id.rzc_c4l_tv_oil_page2_tv3)) != null) {
            if (value > -1 && value < 10000) {
                ((TextView) findViewById(R.id.rzc_c4l_tv_oil_page2_tv3)).setText(String.valueOf(value) + " KM");
            } else {
                ((TextView) findViewById(R.id.rzc_c4l_tv_oil_page2_tv3)).setText("--.--");
            }
        }
    }
}
