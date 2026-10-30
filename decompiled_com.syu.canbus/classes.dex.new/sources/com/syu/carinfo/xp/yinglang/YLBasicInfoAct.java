package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.KeyEvent;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class YLBasicInfoAct extends Activity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.YLBasicInfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 130:
                    YLBasicInfoAct.this.mUpdaterCurrentSpeech();
                    break;
                case 132:
                    YLBasicInfoAct.this.mUpdaterBatteryVol();
                    break;
                case 133:
                    YLBasicInfoAct.this.updaterOutTemp();
                    break;
                case 134:
                    YLBasicInfoAct.this.mUpdaterDrivingMileage();
                    break;
                case 135:
                    YLBasicInfoAct.this.mUpdaterEngineSpeed();
                    break;
                case 136:
                    YLBasicInfoAct.this.mUpdaterTrip();
                    break;
                case 137:
                    YLBasicInfoAct.this.mUpdaterTrunk();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_basic_info);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
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
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEngineSpeed() {
        int value = DataCanbus.DATA[135];
        if (value > 0) {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " RPM");
        } else {
            ((TextView) findViewById(R.id.tv_text4)).setText("--.-- RPM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurrentSpeech() {
        int value = DataCanbus.DATA[130];
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            if (value > 0) {
                ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf((value * 10) / 16) + " mph");
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText("--.-- mph");
                return;
            }
        }
        if (value > 0) {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " Km/h");
        } else {
            ((TextView) findViewById(R.id.tv_text5)).setText("--.-- Km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[134];
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            if (value > 0) {
                ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf((value * 10) / 16) + " MILES");
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText("--.-- MILES");
                return;
            }
        }
        if (value > 0) {
            ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " KM");
        } else {
            ((TextView) findViewById(R.id.tv_text6)).setText("--.-- KM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBatteryVol() {
        int value = DataCanbus.DATA[132];
        if (value > 0) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " V");
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText("--.-- V");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrip() {
        int value = DataCanbus.DATA[136];
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            if (value > 0) {
                int value2 = 235 / value;
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " MPG");
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text7)).setText("--.-- MPG");
                return;
            }
        }
        if (value > 0) {
            ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "L/100KM");
        } else {
            ((TextView) findViewById(R.id.tv_text7)).setText("--.--L/100KM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOutTemp() {
        int value = DataCanbus.DATA[133];
        int flag = 0;
        if ((value & 128) != 0) {
            value = 256 - value;
            flag = 1;
        }
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            if (flag == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(((value * 9) / 5) + 32) + "℉");
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf((320 - (value * 18)) / 10) + "℉");
                return;
            }
        }
        if (flag == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "℃");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText("-" + value + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrunk() {
        int value = DataCanbus.DATA[137];
        ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "%");
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
