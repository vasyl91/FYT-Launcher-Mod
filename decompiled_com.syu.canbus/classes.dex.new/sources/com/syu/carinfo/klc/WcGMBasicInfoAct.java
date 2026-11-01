package com.syu.carinfo.klc;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WcGMBasicInfoAct extends Activity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.WcGMBasicInfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 110:
                    WcGMBasicInfoAct.this.mUpdaterCurrentSpeech();
                    break;
                case 169:
                    WcGMBasicInfoAct.this.mUpdaterEngineSpeed();
                    break;
                case 194:
                    WcGMBasicInfoAct.this.mUpdaterTrunk();
                    break;
                case 195:
                    WcGMBasicInfoAct.this.mUpdaterBatteryVol();
                    break;
                case 197:
                    if (value >= 0 && value <= 80) {
                        int value2 = 400 - (value * 5);
                        ((TextView) WcGMBasicInfoAct.this.findViewById(R.id.tv_text1)).setText("-" + (value2 / 10) + "." + (value2 % 10) + "℃");
                    } else {
                        int value3 = (value * 5) - 400;
                        ((TextView) WcGMBasicInfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "℃");
                    }
                    break;
                case 225:
                    ((TextView) WcGMBasicInfoAct.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + "%");
                    break;
                case 226:
                    ((TextView) WcGMBasicInfoAct.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + "L");
                    break;
                case 227:
                    if (value == 0) {
                        ((TextView) WcGMBasicInfoAct.this.findViewById(R.id.tv_text11)).setText("--- ℃");
                    } else {
                        ((TextView) WcGMBasicInfoAct.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value - 40) + " ℃");
                    }
                    break;
                case 228:
                    if (value == 65535) {
                        ((TextView) WcGMBasicInfoAct.this.findViewById(R.id.tv_text12)).setText("--- kPa");
                    } else {
                        ((TextView) WcGMBasicInfoAct.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value) + " kPa");
                    }
                    break;
                case 229:
                    WcGMBasicInfoAct.this.updaterOutTemp();
                    break;
                case 230:
                    ((TextView) WcGMBasicInfoAct.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value) + "%");
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0036_wc_gm_basic_info);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[225].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[228].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[229].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[230].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[228].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[229].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[230].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEngineSpeed() {
        int value = DataCanbus.DATA[169];
        if (value > 0) {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " RPM");
        } else {
            ((TextView) findViewById(R.id.tv_text5)).setText("--.-- RPM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurrentSpeech() {
        int value = DataCanbus.DATA[110];
        if (value != 65535) {
            ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " Km/h");
        } else {
            ((TextView) findViewById(R.id.tv_text6)).setText("--.-- Km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBatteryVol() {
        int value = DataCanbus.DATA[195];
        if (value > 0) {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " V");
        } else {
            ((TextView) findViewById(R.id.tv_text4)).setText("--.-- V");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOutTemp() {
        int value = DataCanbus.DATA[229];
        ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "Pa");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrunk() {
        int value = DataCanbus.DATA[194];
        ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " ");
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
