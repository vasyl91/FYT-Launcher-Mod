package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class JaguarOilMilePage3Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.JaguarOilMilePage3Acti.1
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 46:
                    JaguarOilMilePage3Acti.this.mUpdaterValue1();
                    JaguarOilMilePage3Acti.this.mUpdaterValue2();
                    JaguarOilMilePage3Acti.this.mUpdaterValue3();
                    JaguarOilMilePage3Acti.this.mUpdaterValue1();
                    JaguarOilMilePage3Acti.this.mUpdaterValue2();
                    JaguarOilMilePage3Acti.this.mUpdaterValue3();
                    break;
                case 47:
                    JaguarOilMilePage3Acti.this.mUpdaterValue2();
                    JaguarOilMilePage3Acti.this.mUpdaterValue3();
                    JaguarOilMilePage3Acti.this.mUpdaterValue1();
                    JaguarOilMilePage3Acti.this.mUpdaterValue2();
                    JaguarOilMilePage3Acti.this.mUpdaterValue3();
                    break;
                case 48:
                    JaguarOilMilePage3Acti.this.mUpdaterValue3();
                    JaguarOilMilePage3Acti.this.mUpdaterValue1();
                    JaguarOilMilePage3Acti.this.mUpdaterValue2();
                    JaguarOilMilePage3Acti.this.mUpdaterValue3();
                    break;
                case 50:
                    JaguarOilMilePage3Acti.this.mUpdaterValue1();
                    JaguarOilMilePage3Acti.this.mUpdaterValue2();
                    JaguarOilMilePage3Acti.this.mUpdaterValue3();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_lz_jaguar_page3);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(0, new int[]{13, 2}, null, null);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[46];
        int value1 = DataCanbus.DATA[50] & 255;
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.tv_text1)).setText("--.--");
            }
            switch (value1) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "L/100KM");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "mpg");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[47];
        int unit = DataCanbus.DATA[50] & 255;
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.tv_text2)).setText("----");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(String.format("%d", Integer.valueOf(value))) + " km");
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(String.format("%d", Integer.valueOf(value))) + " miles");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[42];
        int unit = DataCanbus.DATA[50];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.tv_text3)).setText("----");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/h");
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mph");
            }
        }
    }
}
