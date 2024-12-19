package com.syu.carinfo.psa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PsaOilMilePage3Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.psa.PsaOilMilePage3Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 4:
                    PsaOilMilePage3Acti.this.mUpdaterValue1();
                    break;
                case 8:
                    PsaOilMilePage3Acti.this.mUpdaterValue2();
                    break;
                case 9:
                    PsaOilMilePage3Acti.this.mUpdaterValue3();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_psa_oil_page3);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.psa_btn_oil_page3_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.PsaOilMilePage3Acti.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(24, new int[]{3}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[4];
        if (DataCanbus.DATA[1000] == 12) {
            if (((TextView) findViewById(R.id.psa_tv_oil_page3_tv1)) != null) {
                if (value == 65535) {
                    ((TextView) findViewById(R.id.psa_tv_oil_page3_tv1)).setText("--.--");
                    return;
                } else {
                    ((TextView) findViewById(R.id.psa_tv_oil_page3_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf((value >> 8) & 255), Integer.valueOf(value & 255))) + " L/100KM");
                    return;
                }
            }
            return;
        }
        if (((TextView) findViewById(R.id.psa_tv_oil_page3_tv1)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_tv_oil_page3_tv1)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.psa_tv_oil_page3_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " L/100KM");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[8];
        if (((TextView) findViewById(R.id.psa_tv_oil_page3_tv2)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.psa_tv_oil_page3_tv2)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.psa_tv_oil_page3_tv2)).setText(String.valueOf(value) + " Km/h");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[9];
        if (((TextView) findViewById(R.id.psa_tv_oil_page3_tv3)) != null) {
            if (value > 9999) {
                value = 9999;
            }
            ((TextView) findViewById(R.id.psa_tv_oil_page3_tv3)).setText(String.valueOf(value) + " KM");
        }
    }
}
