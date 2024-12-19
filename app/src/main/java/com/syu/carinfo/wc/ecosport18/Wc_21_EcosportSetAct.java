package com.syu.carinfo.wc.ecosport18;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Wc_21_EcosportSetAct extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.wc.ecosport18.Wc_21_EcosportSetAct.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            int iLanguage;
            int iTempUnitValue;
            int iDisUnitValue;
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427480 */:
                case R.id.btn_plus1 /* 2131427482 */:
                    int iDisUnitValue2 = DataCanbus.DATA[29];
                    if (iDisUnitValue2 == 1) {
                        iDisUnitValue = 0;
                    } else {
                        iDisUnitValue = 1;
                    }
                    Wc_21_EcosportSetAct.this.sendCMD(1, iDisUnitValue);
                    break;
                case R.id.btn_minus2 /* 2131427484 */:
                case R.id.btn_plus2 /* 2131427486 */:
                    int iTempUnitValue2 = DataCanbus.DATA[30];
                    if (iTempUnitValue2 == 1) {
                        iTempUnitValue = 0;
                    } else {
                        iTempUnitValue = 1;
                    }
                    Wc_21_EcosportSetAct.this.sendCMD(4, iTempUnitValue);
                    break;
                case R.id.btn_minus3 /* 2131427488 */:
                case R.id.btn_plus3 /* 2131427490 */:
                    int iLanguage2 = DataCanbus.DATA[31];
                    if (iLanguage2 == 1) {
                        iLanguage = 0;
                    } else {
                        iLanguage = 1;
                    }
                    Wc_21_EcosportSetAct.this.sendCMD(5, iLanguage);
                    break;
                case R.id.btn_minus4 /* 2131427492 */:
                    int value = DataCanbus.DATA[44] - 1;
                    if (value < 0) {
                        value = 7;
                    }
                    DataCanbus.PROXY.cmd(17, new int[]{3, value}, null, null);
                    break;
                case R.id.btn_plus4 /* 2131427494 */:
                    int value2 = DataCanbus.DATA[44] + 1;
                    if (value2 > 7) {
                        value2 = 0;
                    }
                    DataCanbus.PROXY.cmd(17, new int[]{3, value2}, null, null);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ecosport18.Wc_21_EcosportSetAct.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 24:
                case 34:
                    Wc_21_EcosportSetAct.this.updateCurSpeed();
                    break;
                case 25:
                case 33:
                    Wc_21_EcosportSetAct.this.updateEngineSpeed();
                    break;
                case 29:
                    Wc_21_EcosportSetAct.this.updateDisUnit();
                    break;
                case 30:
                    Wc_21_EcosportSetAct.this.updateTempUnit();
                    break;
                case 31:
                    Wc_21_EcosportSetAct.this.updateLanguage();
                    break;
                case 38:
                    if (((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 39:
                    if (((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value * 0.1f) + " km");
                        break;
                    }
                case 44:
                    if (((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.color_ice_blue);
                                break;
                            case 2:
                                ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.color_orange_str);
                                break;
                            case 3:
                                ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_2);
                                break;
                            case 4:
                                ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_3);
                                break;
                            case 5:
                                ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_4);
                                break;
                            case 6:
                                ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_5);
                                break;
                            case 7:
                                ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_6);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_021_wc_ecosport18);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] == 524309) {
            findViewById(R.id.layout_view7).setVisibility(0);
            findViewById(R.id.layout_view8).setVisibility(0);
        } else {
            findViewById(R.id.layout_view7).setVisibility(8);
            findViewById(R.id.layout_view8).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 524309 || DataCanbus.DATA[1000] == 458773) {
            findViewById(R.id.layout_view6).setVisibility(0);
        } else {
            findViewById(R.id.layout_view6).setVisibility(8);
        }
        setonClick((Button) findViewById(R.id.btn_minus1));
        setonClick((Button) findViewById(R.id.btn_plus1));
        setonClick((Button) findViewById(R.id.btn_minus2));
        setonClick((Button) findViewById(R.id.btn_plus2));
        setonClick((Button) findViewById(R.id.btn_minus3));
        setonClick((Button) findViewById(R.id.btn_plus3));
        setonClick((Button) findViewById(R.id.btn_minus4));
        setonClick((Button) findViewById(R.id.btn_plus4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(16, new int[]{cmd, val}, null, null);
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
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
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurSpeed() {
        int curspeedenable = DataCanbus.DATA[34];
        int curspeed = DataCanbus.DATA[24];
        if (findViewById(R.id.layout_view5) != null) {
            if (curspeedenable == 0) {
                findViewById(R.id.layout_view5).setVisibility(8);
                return;
            }
            findViewById(R.id.layout_view5).setVisibility(0);
            if (((TextView) findViewById(R.id.tv_text5)) != null) {
                if (curspeed == 65535) {
                    ((TextView) findViewById(R.id.tv_text5)).setText("---");
                } else {
                    ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(String.format("%d", Integer.valueOf(curspeed))) + " Km/h");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEngineSpeed() {
        int enginespeed = DataCanbus.DATA[25];
        int enginespeedenable = DataCanbus.DATA[33];
        if (findViewById(R.id.layout_view4) != null) {
            if (enginespeedenable == 0) {
                findViewById(R.id.layout_view4).setVisibility(8);
                return;
            }
            findViewById(R.id.layout_view4).setVisibility(0);
            if (((TextView) findViewById(R.id.tv_text4)) != null) {
                if (enginespeed == 65535) {
                    ((TextView) findViewById(R.id.tv_text4)).setText("---");
                } else {
                    ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(String.format("%d", Integer.valueOf(enginespeed))) + " R/min");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisUnit() {
        int disunit = DataCanbus.DATA[29];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (disunit == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_jianianhua_show__metric_unit_1);
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_jianianhua_show__metric_unit_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempUnit() {
        int tempunit = DataCanbus.DATA[30];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (tempunit == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_15ruijie_temp_unit_f_set);
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_15ruijie_temp_unit_c_set);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLanguage() {
        int language = DataCanbus.DATA[31];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (language == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_language_set0);
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_language_set1);
            }
        }
    }
}
