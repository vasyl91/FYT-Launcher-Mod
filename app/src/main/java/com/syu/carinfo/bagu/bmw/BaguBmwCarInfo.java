package com.syu.carinfo.bagu.bmw;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BaguBmwCarInfo extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bagu.bmw.BaguBmwCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    BaguBmwCarInfo.this.mUpdateTx1();
                    break;
                case 2:
                    BaguBmwCarInfo.this.mUpdateTx2();
                    break;
                case 3:
                case 6:
                    BaguBmwCarInfo.this.mUpdateTx3();
                    break;
                case 4:
                    BaguBmwCarInfo.this.mUpdateTx1();
                    BaguBmwCarInfo.this.mUpdateTx2();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0386_bagu_bmw_carinfo);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTx1() {
        int value = DataCanbus.DATA[1];
        int unit = DataCanbus.DATA[4];
        if (value > 4000) {
            ((TextView) findViewById(R.id.tv_text1)).setText("----");
        } else if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " mls");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTx2() {
        int value = DataCanbus.DATA[2];
        int unit = DataCanbus.DATA[6];
        if (value > 4000) {
            ((TextView) findViewById(R.id.tv_text2)).setText("--.--");
        } else if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mls/h");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTx3() {
        int value = DataCanbus.DATA[3];
        int unit = DataCanbus.DATA[4];
        if (value > 4000) {
            ((TextView) findViewById(R.id.tv_text3)).setText("--.--");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " l/100km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg(us)");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg(uk)");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/l");
                break;
        }
    }
}
