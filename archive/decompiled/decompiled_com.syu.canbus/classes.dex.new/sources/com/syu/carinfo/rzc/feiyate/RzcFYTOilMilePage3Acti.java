package com.syu.carinfo.rzc.feiyate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RzcFYTOilMilePage3Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.feiyate.RzcFYTOilMilePage3Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 100:
                case 122:
                    RzcFYTOilMilePage3Acti.this.mUpdaterValue1();
                    break;
                case 101:
                    RzcFYTOilMilePage3Acti.this.mUpdaterValue3();
                    RzcFYTOilMilePage3Acti.this.mUpdaterValue4();
                    break;
                case 123:
                    RzcFYTOilMilePage3Acti.this.mUpdaterValue4();
                    break;
                case 124:
                    RzcFYTOilMilePage3Acti.this.mUpdaterValue3();
                    break;
                case 125:
                    RzcFYTOilMilePage3Acti.this.mUpdaterValue2();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fyt_all_oil_page3);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.psa_all_btn_oil_page3_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.feiyate.RzcFYTOilMilePage3Acti.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{242, 1}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{80, 2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[122];
        int value1 = DataCanbus.DATA[100] & 255;
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv1)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv1)).setText("--.--");
            }
            switch (value1) {
                case 0:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "km/l");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "L/100KM");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "mpg(uk)");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "mpg(us)");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[125];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv2)) != null) {
            if (value == 16777215) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv2)).setText("----");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv2)).setText(String.valueOf((value >> 8) & 65535) + "H " + (value & 255) + "M");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[124];
        int unit = DataCanbus.DATA[101] & 255;
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv3)) != null) {
            if (value == 16777215) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv3)).setText("----");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " KM");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " Mil");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[123];
        int unit = DataCanbus.DATA[101] & 255;
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv4)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv4)).setText("----");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv4)).setText(String.valueOf(value) + " KM/H");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv4)).setText(String.valueOf(value) + " Mil/H");
            }
        }
    }
}
