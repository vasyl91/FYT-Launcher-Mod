package com.syu.carinfo.biaozhi408;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Biaozhi206OilPage extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.biaozhi408.Biaozhi206OilPage.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 25:
                    Biaozhi206OilPage.this.uAverageSpeed(DataCanbus.DATA[updateCode] & 255);
                    break;
                case 27:
                    Biaozhi206OilPage.this.uDrivingMiles(DataCanbus.DATA[updateCode] & 65535);
                    break;
                case 28:
                    Biaozhi206OilPage.this.uTripMiles(DataCanbus.DATA[updateCode] & 65535);
                    break;
                case 29:
                    Biaozhi206OilPage.this.uCurOilCost(DataCanbus.DATA[updateCode] & 65535);
                    break;
                case 30:
                    Biaozhi206OilPage.this.uAverageOilCost(DataCanbus.DATA[updateCode] & 65535);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_biaozhi206_oil_page);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    protected void finalize() throws Throwable {
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }

    protected void uAverageOilCost(int i) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (i == 65535) {
                ((TextView) findViewById(R.id.tv_text1)).setText("----");
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(i * 0.1f) + "L/100Km");
            }
        }
    }

    protected void uDrivingMiles(int i) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (i == 65535) {
                ((TextView) findViewById(R.id.tv_text3)).setText("----");
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(i) + "Km");
            }
        }
    }

    protected void uTripMiles(int i) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (i == 65535) {
                ((TextView) findViewById(R.id.tv_text5)).setText("----");
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(i) + "Km");
            }
        }
    }

    protected void uCurOilCost(int i) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (i == 65535) {
                ((TextView) findViewById(R.id.tv_text2)).setText("----");
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(i * 0.1f) + "L/100Km");
            }
        }
    }

    protected void uAverageSpeed(int i) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(i) + "Km/h");
        }
    }
}
