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
public class WcGMKopachBasicInfoAct extends Activity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.WcGMKopachBasicInfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 194:
                    WcGMKopachBasicInfoAct.this.mUpdaterTrunk();
                    break;
                case 197:
                    WcGMKopachBasicInfoAct.this.updaterOutTemp();
                    break;
                case 202:
                    if (value > 0) {
                        ((TextView) WcGMKopachBasicInfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " KM");
                    } else {
                        ((TextView) WcGMKopachBasicInfoAct.this.findViewById(R.id.tv_text1)).setText("--.-- KM");
                    }
                    break;
                case 203:
                    if (value > 0) {
                        ((TextView) WcGMKopachBasicInfoAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " l/100km");
                    } else {
                        ((TextView) WcGMKopachBasicInfoAct.this.findViewById(R.id.tv_text6)).setText("--.- l/100km");
                    }
                    break;
                case 204:
                    if (value > 0) {
                        ((TextView) WcGMKopachBasicInfoAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/h");
                    } else {
                        ((TextView) WcGMKopachBasicInfoAct.this.findViewById(R.id.tv_text4)).setText("--.- km/h");
                    }
                    break;
                case 205:
                    int hour = ((value >> 8) & 65535) / 10;
                    int min = value & 255;
                    if (value > 0) {
                        ((TextView) WcGMKopachBasicInfoAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(hour) + ":" + min);
                    } else {
                        ((TextView) WcGMKopachBasicInfoAct.this.findViewById(R.id.tv_text5)).setText("--:--");
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0036_wc_gm_kopach_basic_info);
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
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOutTemp() {
        int value = DataCanbus.DATA[197];
        if (value >= 0 && value <= 80) {
            int value2 = 400 - (value * 5);
            ((TextView) findViewById(R.id.tv_text3)).setText("-" + (value2 / 10) + "." + (value2 % 10) + "℃");
        } else {
            int value3 = (value * 5) - 400;
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrunk() {
        int value = DataCanbus.DATA[194];
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setTextColor(-65536);
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setTextColor(-1);
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_right_camera_close);
        }
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
