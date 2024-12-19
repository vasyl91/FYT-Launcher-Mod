package com.syu.carinfo.lz.nissan.gtr;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LuzNissanGTRCarInfo extends BaseActivity {
    int tempunit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.nissan.gtr.LuzNissanGTRCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 25:
                    ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "%");
                    break;
                case 26:
                    ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "%");
                    break;
                case 27:
                    LuzNissanGTRCarInfo.this.mUpdateEgnOilTemp();
                    break;
                case 28:
                    LuzNissanGTRCarInfo.this.mUpdateTransOilTemp();
                    break;
                case 29:
                    if (LuzNissanGTRCarInfo.this.tempunit == 1) {
                        int value2 = (value * 145) / 100;
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + " psi");
                        break;
                    } else {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + " Kpa");
                        break;
                    }
                case 30:
                    ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value) + "%");
                    break;
                case 31:
                    if (LuzNissanGTRCarInfo.this.tempunit == 1) {
                        if ((value & 32768) != 0) {
                            int value3 = ((65536 - value) * 145) / 100;
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text12)).setText("-" + (value3 / 10) + "." + (value3 % 10) + " psi");
                            break;
                        } else {
                            int value4 = (value * 145) / 100;
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value4 / 10) + "." + (value4 % 10) + " psi");
                            break;
                        }
                    } else if ((value & 32768) != 0) {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text12)).setText("-" + (65536 - value) + " Kpa");
                        break;
                    } else {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value) + " Kpa");
                        break;
                    }
                case 32:
                    switch (value) {
                        case 0:
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text13)).setText("P");
                            break;
                        case 1:
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text13)).setText("R");
                            break;
                        case 2:
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text13)).setText("N");
                            break;
                        case 3:
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text13)).setText("1");
                            break;
                        case 4:
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text13)).setText("2");
                            break;
                        case 5:
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text13)).setText("3");
                            break;
                        case 6:
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text13)).setText("4");
                            break;
                        case 7:
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text13)).setText("5");
                            break;
                        case 8:
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text13)).setText("6");
                            break;
                    }
                case 34:
                    LuzNissanGTRCarInfo.this.mUpdateWaterTemp();
                    break;
                case 35:
                    LuzNissanGTRCarInfo.this.mUpdateSpeed();
                    break;
                case 36:
                    LuzNissanGTRCarInfo.this.mUpdateMile();
                    break;
                case 37:
                    ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " Rpm");
                    break;
                case 39:
                    LuzNissanGTRCarInfo.this.mUpdateTotalMile();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_luz_nissan_gtr_carinfo);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        this.tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTransOilTemp() {
        int value = DataCanbus.DATA[28];
        if (value >= 40) {
            int value2 = value - 40;
            if (this.tempunit == 1) {
                ((TextView) findViewById(R.id.tv_text9)).setText(String.valueOf(((value2 * 9) / 5) + 32) + " ℉");
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text9)).setText(String.valueOf(value2) + " ℃");
                return;
            }
        }
        int value3 = 40 - value;
        if (this.tempunit == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("-" + (((value3 * 9) / 5) + 32) + " ℉");
        } else {
            ((TextView) findViewById(R.id.tv_text9)).setText("-" + value3 + " ℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateEgnOilTemp() {
        int value = DataCanbus.DATA[27];
        if (value >= 40) {
            int value2 = value - 40;
            if (this.tempunit == 1) {
                ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(((value2 * 9) / 5) + 32) + " ℉");
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(value2) + " ℃");
                return;
            }
        }
        int value3 = 40 - value;
        if (this.tempunit == 1) {
            ((TextView) findViewById(R.id.tv_text8)).setText("-" + (((value3 * 9) / 5) + 32) + " ℉");
        } else {
            ((TextView) findViewById(R.id.tv_text8)).setText("-" + value3 + " ℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateWaterTemp() {
        int value = DataCanbus.DATA[34];
        if (value >= 40) {
            int value2 = value - 40;
            if (this.tempunit == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(((value2 * 9) / 5) + 32) + " ℉");
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value2) + " ℃");
                return;
            }
        }
        int value3 = 40 - value;
        if (this.tempunit == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText("-" + (((value3 * 9) / 5) + 32) + " ℉");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText("-" + value3 + " ℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSpeed() {
        int value = DataCanbus.DATA[35];
        if (this.tempunit == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf((value * 10) / 16) + " mph");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateMile() {
        int value = DataCanbus.DATA[36];
        if (this.tempunit == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf((value * 10) / 16) + " Mil");
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " Km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTotalMile() {
        int value = DataCanbus.DATA[39];
        if (this.tempunit == 1) {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf((value * 10) / 16) + " Mil");
        } else {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " Km");
        }
    }
}
