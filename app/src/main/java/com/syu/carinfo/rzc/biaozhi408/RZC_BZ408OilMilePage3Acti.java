package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZC_BZ408OilMilePage3Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408OilMilePage3Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 95:
                    RZC_BZ408OilMilePage3Acti.this.mUpdaterValue1();
                    break;
                case 97:
                    RZC_BZ408OilMilePage3Acti.this.mUpdaterValue3();
                    break;
                case 98:
                    RZC_BZ408OilMilePage3Acti.this.mUpdaterValue2();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_biaozhi408_oil_page3);
        init();
        DataCanbus.PROXY.cmd(72, new int[]{53}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.rzc_bz408_btn_oil_page3_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408OilMilePage3Acti.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(28, new int[]{3}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(29, new int[]{2}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[95];
        if (((TextView) findViewById(R.id.rzc_bz408_tv_oil_page3_tv1)) != null) {
            if (value > -1 && value < 301) {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page3_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " L/100");
            } else {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page3_tv1)).setText("--.--");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[98];
        if (((TextView) findViewById(R.id.rzc_bz408_tv_oil_page3_tv2)) != null) {
            if (value > -1 && value < 251) {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page3_tv2)).setText(String.valueOf(value) + " KM/H");
            } else {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page3_tv2)).setText("--.--");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[97];
        if (((TextView) findViewById(R.id.rzc_bz408_tv_oil_page3_tv3)) != null) {
            if (value > -1 && value < 10000) {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page3_tv3)).setText(String.valueOf(value) + " KM");
            } else {
                ((TextView) findViewById(R.id.rzc_bz408_tv_oil_page3_tv3)).setText("--.--");
            }
        }
    }
}