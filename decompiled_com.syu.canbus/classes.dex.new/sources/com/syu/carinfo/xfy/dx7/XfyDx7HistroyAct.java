package com.syu.carinfo.xfy.dx7;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class XfyDx7HistroyAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xfy.dx7.XfyDx7HistroyAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                    XfyDx7HistroyAct.this.mUpdateCurOilExpend();
                    break;
                case 103:
                    XfyDx7HistroyAct.this.mUpdaterDrivingMileage();
                    break;
                case 104:
                    XfyDx7HistroyAct.this.mUpdateCurOptimalOilExpend();
                    break;
                case 105:
                    XfyDx7HistroyAct.this.mUpdaterLastOil();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xfydx7_oil_trip_info);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCurOilExpend() {
        int value = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.tv_text1)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " " + CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCurOptimalOilExpend() {
        int value = DataCanbus.DATA[104];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.tv_text3)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " Km");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLastOil() {
        int value = DataCanbus.DATA[105];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText("--.--");
            } else if (value < 5) {
                ((TextView) findViewById(R.id.tv_text2)).setText("0%");
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "%");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.tv_text4)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " km");
            }
        }
    }
}
