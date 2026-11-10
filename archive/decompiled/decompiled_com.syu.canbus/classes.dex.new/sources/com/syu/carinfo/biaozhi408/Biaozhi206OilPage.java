package com.syu.carinfo.biaozhi408;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Biaozhi206OilPage extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.biaozhi408.Biaozhi206OilPage.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    Biaozhi206OilPage.this.uAverageSpeed(DataCanbus.DATA[updateCode] & 255);
                    break;
                case 100:
                    Biaozhi206OilPage.this.uDrivingMiles(DataCanbus.DATA[updateCode] & 65535);
                    break;
                case 101:
                    Biaozhi206OilPage.this.uTripMiles(DataCanbus.DATA[updateCode] & 65535);
                    break;
                case 102:
                    Biaozhi206OilPage.this.uCurOilCost(DataCanbus.DATA[updateCode] & 65535);
                    break;
                case 103:
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
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
