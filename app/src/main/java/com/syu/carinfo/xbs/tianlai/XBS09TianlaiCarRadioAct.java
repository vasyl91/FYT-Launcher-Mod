package com.syu.carinfo.xbs.tianlai;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0439_XBS_09Tianlai;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XBS09TianlaiCarRadioAct extends BaseActivity {
    public static XBS09TianlaiCarRadioAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.tianlai.XBS09TianlaiCarRadioAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (DataCanbus.DATA[1000] == 458942) {
                switch (updateCode) {
                    case 27:
                        XBS09TianlaiCarRadioAct.this.updaterRadioRdsOnOff();
                        break;
                    case 28:
                        XBS09TianlaiCarRadioAct.this.updaterRadioSCANOnOff();
                        break;
                    case 29:
                        XBS09TianlaiCarRadioAct.this.updaterRadioSTOnOff();
                        break;
                    case 30:
                        XBS09TianlaiCarRadioAct.this.updaterRadioAUTOOnOff();
                        break;
                    case 31:
                        XBS09TianlaiCarRadioAct.this.updaterRadioText();
                        break;
                    case 32:
                        XBS09TianlaiCarRadioAct.this.updaterRadioBand();
                        break;
                    case 34:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq();
                        break;
                    case 35:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq1();
                        break;
                    case 36:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq2();
                        break;
                    case 37:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq3();
                        break;
                    case 38:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq4();
                        break;
                    case 39:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq5();
                        break;
                    case 40:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq6();
                        break;
                }
            }
            switch (updateCode) {
                case 17:
                    XBS09TianlaiCarRadioAct.this.updaterRadioRdsOnOff();
                    break;
                case 18:
                    XBS09TianlaiCarRadioAct.this.updaterRadioSCANOnOff();
                    break;
                case 19:
                    XBS09TianlaiCarRadioAct.this.updaterRadioSTOnOff();
                    break;
                case 20:
                    XBS09TianlaiCarRadioAct.this.updaterRadioAUTOOnOff();
                    break;
                case 21:
                    XBS09TianlaiCarRadioAct.this.updaterRadioText();
                    break;
                case 22:
                    XBS09TianlaiCarRadioAct.this.updaterRadioBand();
                    break;
                case 24:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq();
                    break;
                case 25:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq1();
                    break;
                case 26:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq2();
                    break;
                case 27:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq3();
                    break;
                case 28:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq4();
                    break;
                case 29:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq5();
                    break;
                case 30:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq6();
                    break;
            }
        }
    };
    int radioband = 1;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (LauncherApplication.getConfiguration() == 1) {
            String platform = SystemProperties.get("ro.fyt.platform", "");
            if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform)) {
                setContentView(R.layout.layout_xbs_09tianlai_carradio_9853);
            } else {
                setContentView(R.layout.layout_xbs_09tianlai_carradio);
            }
        } else {
            setContentView(R.layout.layout_xbs_09tianlai_carradio);
        }
        mInstance = this;
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        if (DataCanbus.DATA[1000] == 458942) {
            DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        if (DataCanbus.DATA[1000] == 458942) {
            DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioText() {
        int value = DataCanbus.DATA[21];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[31];
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.radio_text)).setText(Callback_0439_XBS_09Tianlai.CarRadioText);
        } else {
            ((TextView) findViewById(R.id.radio_text)).setText("--------");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq6() {
        int value;
        int value2 = DataCanbus.DATA[30];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[40];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100) + " mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq5() {
        int value;
        int value2 = DataCanbus.DATA[29];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[39];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100) + " mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq4() {
        int value;
        int value2 = DataCanbus.DATA[28];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[38];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100) + " mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq3() {
        int value;
        int value2 = DataCanbus.DATA[27];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[37];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100) + " mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq2() {
        int value;
        int value2 = DataCanbus.DATA[26];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[36];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100) + " mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq1() {
        int value;
        int value2 = DataCanbus.DATA[25];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[35];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100) + " mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq() {
        int value;
        int value2 = DataCanbus.DATA[24];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[34];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder(String.valueOf(value)).toString());
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100));
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioBand() {
        this.radioband = DataCanbus.DATA[22];
        if (DataCanbus.DATA[1000] == 458942) {
            this.radioband = DataCanbus.DATA[32];
        }
        switch (this.radioband) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Am1");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Am2");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Fm1");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Fm2");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Fm3");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioAUTOOnOff() {
        int value = DataCanbus.DATA[20];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[30];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.radio_auto)).setText("AUTO:On");
                break;
            default:
                ((TextView) findViewById(R.id.radio_auto)).setText("AUTO:Off");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioSTOnOff() {
        int value = DataCanbus.DATA[19];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[29];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.radio_st)).setText("ST:On");
                break;
            default:
                ((TextView) findViewById(R.id.radio_st)).setText("ST:Off");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioSCANOnOff() {
        int value = DataCanbus.DATA[18];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[28];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.radio_scan)).setText("SCAN:On");
                break;
            default:
                ((TextView) findViewById(R.id.radio_scan)).setText("SCAN:Off");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioRdsOnOff() {
        int value = DataCanbus.DATA[17];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[27];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.radio_rds)).setText("RDS:On");
                break;
            default:
                ((TextView) findViewById(R.id.radio_rds)).setText("RDS:Off");
                break;
        }
    }
}
