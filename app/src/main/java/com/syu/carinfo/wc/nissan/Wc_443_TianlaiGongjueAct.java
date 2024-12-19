package com.syu.carinfo.wc.nissan;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Wc_443_TianlaiGongjueAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Log.d("canbus", String.format("IUiNotify->updateCode:%d", Integer.valueOf(updateCode)));
            switch (updateCode) {
                case 23:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterCarVol();
                    break;
                case 24:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterCarEQBal();
                    break;
                case 25:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterCarEQFad();
                    break;
                case 26:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterCarEQTreble();
                    break;
                case 27:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterCarEQBass();
                    break;
                case 28:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterBoseCenterpoint();
                    break;
                case 29:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterSpeedVol();
                    break;
                case 30:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterCarSurroundVol();
                    break;
                case 33:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterUnlockLighton();
                    break;
                case 34:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterHeadlightSensitivity();
                    break;
                case 35:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterHeadlightsDelaytime();
                    break;
                case 36:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterSpeedSensingWiper();
                    break;
                case 37:
                    Wc_443_TianlaiGongjueAct.this.mUpdaterAutoUnlock();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_tianlaigongjue_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.tianlaigongjue_btn_carvol_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{1, 255}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_carvol_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{1, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_bass_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{4, 255}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_bass_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{4, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_treble_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{6, 255}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_treble_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{6, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_balance_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{2, 255}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_balance_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{2, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_fade_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{3, 255}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_fade_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{3, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_surroundvol_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{8, 255}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_surroundvol_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{8, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_speedvol_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{7, 255}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_speedvol_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{7, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_headlamps_on_sensitivity_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[34];
                DataCanbus.PROXY.cmd(1, new int[]{5, value <= 1 ? 1 : value - 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_headlamps_on_sensitivity_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[34];
                DataCanbus.PROXY.cmd(1, new int[]{5, value >= 4 ? 4 : value + 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_headlight_delay_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[35];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(1, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.tianlaigongjue_btn_headlight_delay_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[35];
                if (value < 7) {
                    value++;
                }
                DataCanbus.PROXY.cmd(1, new int[]{6, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.tianlaigongjue_btn_bose_centerpoint_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[28];
                int value2 = value != 0 ? 0 : 1;
                DataCanbus.PROXY.cmd(2, new int[]{9, value2}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.tianlaigongjue_interior_illumination_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[33];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.tianlaigongjue_wiper_speed_sensitivity_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[36];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{7, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.tianlaigongjue_intelligent_key_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[37];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{8, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadlightsDelaytime() {
        int value = DataCanbus.DATA[35];
        if (((TextView) findViewById(R.id.tianlaigongjue_tv_headlight_delay)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_headlight_delay)).setText("0s");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_headlight_delay)).setText("30s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_headlight_delay)).setText("45s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_headlight_delay)).setText("60s");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_headlight_delay)).setText("90s");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_headlight_delay)).setText("120s");
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_headlight_delay)).setText("150s");
                    break;
                case 7:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_headlight_delay)).setText("180s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoUnlock() {
        int value = DataCanbus.DATA[37];
        if (((CheckedTextView) findViewById(R.id.tianlaigongjue_intelligent_key_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.tianlaigongjue_intelligent_key_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSpeedSensingWiper() {
        int value = DataCanbus.DATA[36];
        if (((CheckedTextView) findViewById(R.id.tianlaigongjue_wiper_speed_sensitivity_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.tianlaigongjue_wiper_speed_sensitivity_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadlightSensitivity() {
        int value = DataCanbus.DATA[34];
        if (((TextView) findViewById(R.id.tianlaigongjue_tv_headlamps_on_sensitivity)) != null) {
            ((TextView) findViewById(R.id.tianlaigongjue_tv_headlamps_on_sensitivity)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterUnlockLighton() {
        int value = DataCanbus.DATA[33];
        if (((CheckedTextView) findViewById(R.id.tianlaigongjue_interior_illumination_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.tianlaigongjue_interior_illumination_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSpeedVol() {
        int value = DataCanbus.DATA[29];
        if (((TextView) findViewById(R.id.tianlaigongjue_tv_speedvol)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_speedvol)).setText(R.string.off);
                    break;
                default:
                    ((TextView) findViewById(R.id.tianlaigongjue_tv_speedvol)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBoseCenterpoint() {
        int value = DataCanbus.DATA[28];
        if (((CheckedTextView) findViewById(R.id.tianlaigongjue_btn_bose_centerpoint_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.tianlaigongjue_btn_bose_centerpoint_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarSurroundVol() {
        int value = DataCanbus.DATA[30];
        if (((TextView) findViewById(R.id.tianlaigongjue_tv_surroundvol)) != null) {
            if ((value & 128) == 128) {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_surroundvol)).setText("-" + (256 - value));
                return;
            }
            ((TextView) findViewById(R.id.tianlaigongjue_tv_surroundvol)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarEQFad() {
        int value = DataCanbus.DATA[25];
        if (((TextView) findViewById(R.id.tianlaigongjue_tv_fade)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_fade)).setText("F" + (0 - value));
            } else if (value > 0) {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_fade)).setText("B" + value);
            } else {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_fade)).setText(" 0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarEQBal() {
        int value = DataCanbus.DATA[24];
        if (((TextView) findViewById(R.id.tianlaigongjue_tv_balance)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_balance)).setText("L" + (0 - value));
            } else if (value > 0) {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_balance)).setText("R" + value);
            } else {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_balance)).setText(" 0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarEQTreble() {
        int value = DataCanbus.DATA[26];
        if (((TextView) findViewById(R.id.tianlaigongjue_tv_treble)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_treble)).setText("-" + (0 - value));
            } else if (value > 0) {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_treble)).setText("+" + value);
            } else {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_treble)).setText(" 0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarEQBass() {
        int value = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tianlaigongjue_tv_bass)) != null) {
            if (value < 0) {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_bass)).setText("-" + (0 - value));
            } else if (value > 0) {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_bass)).setText("+" + value);
            } else {
                ((TextView) findViewById(R.id.tianlaigongjue_tv_bass)).setText(" 0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarVol() {
        int value = DataCanbus.DATA[23];
        if (((TextView) findViewById(R.id.tianlaigongjue_tv_carvol)) != null) {
            ((TextView) findViewById(R.id.tianlaigongjue_tv_carvol)).setText(new StringBuilder().append(value).toString());
        }
    }
}
