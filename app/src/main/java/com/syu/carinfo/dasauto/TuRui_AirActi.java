package com.syu.carinfo.dasauto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class TuRui_AirActi extends BaseActivity {
    public static TuRui_AirActi mInstance;
    public static boolean mIsFront = false;
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_AirActi.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            int val = 0;
            int val2 = 0;
            int val3 = 0;
            int val4 = 0;
            switch (v.getId()) {
                case R.id.btn_air_temp_left_plus /* 2131427425 */:
                    int val5 = DataCanbus.DATA[98] & 255;
                    if (val5 == 254) {
                        val3 = 34;
                    } else if (val5 != 255) {
                        val3 = val5 + 2;
                    }
                    if (val3 > 62) {
                        val3 = 255;
                    }
                    TuRui_AirActi.this.setCMD(8, val3);
                    break;
                case R.id.btn_air_temp_left_minus /* 2131427427 */:
                    int val6 = DataCanbus.DATA[98] & 255;
                    if (val6 == 255) {
                        val4 = 62;
                    } else if (val6 != 254) {
                        val4 = val6 - 2;
                    }
                    if (val4 < 34) {
                        val4 = 254;
                    }
                    TuRui_AirActi.this.setCMD(8, val4);
                    break;
                case R.id.air_xts_power /* 2131427428 */:
                    TuRui_AirActi.this.setCMD(6, DataCanbus.DATA[87] != 1 ? 1 : 0);
                    break;
                case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                    int val7 = DataCanbus.DATA[97] - 1;
                    if (val7 < 0) {
                        val7 = 0;
                    }
                    TuRui_AirActi.this.setCMD(7, val7);
                    break;
                case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                    int val8 = DataCanbus.DATA[97] + 1;
                    if (val8 > 7) {
                        val8 = 7;
                    }
                    TuRui_AirActi.this.setCMD(7, val8);
                    break;
                case R.id.air_xts_auto /* 2131427436 */:
                    int val9 = DataCanbus.DATA[89] + 1;
                    if (val9 > 2) {
                        val9 = 0;
                    }
                    TuRui_AirActi.this.setCMD(2, val9);
                    break;
                case R.id.air_xts_cycle /* 2131427437 */:
                    TuRui_AirActi.this.setCMD(1, DataCanbus.DATA[149] != 1 ? 1 : 0);
                    break;
                case R.id.air_xts_mode_foot /* 2131427443 */:
                    TuRui_AirActi.this.setCMD(5, DataCanbus.DATA[96] != 1 ? 1 : 0);
                    break;
                case R.id.air_xts_mode_body /* 2131427444 */:
                    TuRui_AirActi.this.setCMD(4, DataCanbus.DATA[95] != 1 ? 1 : 0);
                    break;
                case R.id.air_xts_mode_win /* 2131427445 */:
                    TuRui_AirActi.this.setCMD(3, DataCanbus.DATA[120] != 1 ? 1 : 0);
                    break;
                case R.id.btn_air_temp_right_plus /* 2131427449 */:
                    int val10 = DataCanbus.DATA[99] & 255;
                    if (val10 == 254) {
                        val = 34;
                    } else if (val10 != 255) {
                        val = val10 + 2;
                    }
                    if (val > 62) {
                        val = 255;
                    }
                    TuRui_AirActi.this.setCMD(9, val);
                    break;
                case R.id.btn_air_temp_right_minus /* 2131427451 */:
                    int val11 = DataCanbus.DATA[99] & 255;
                    if (val11 == 255) {
                        val2 = 62;
                    } else if (val11 != 254) {
                        val2 = val11 - 2;
                    }
                    if (val2 < 34) {
                        val2 = 254;
                    }
                    TuRui_AirActi.this.setCMD(9, val2);
                    break;
                case R.id.air_xts_steer_hot /* 2131427453 */:
                    TuRui_AirActi.this.setCMD(10, DataCanbus.DATA[234] != 1 ? 1 : 0);
                    break;
                case R.id.air_xts_front_hot /* 2131427466 */:
                    TuRui_AirActi.this.setCMD(11, DataCanbus.DATA[235] != 1 ? 1 : 0);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dasauto.TuRui_AirActi.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 87:
                    TuRui_AirActi.this.uPower(DataCanbus.DATA[updateCode]);
                    break;
                case 89:
                case 94:
                    TuRui_AirActi.this.uAuto();
                    break;
                case 95:
                    TuRui_AirActi.this.uBlowBody(DataCanbus.DATA[updateCode]);
                    break;
                case 96:
                    TuRui_AirActi.this.uBlowFoot(DataCanbus.DATA[updateCode]);
                    break;
                case 97:
                    TuRui_AirActi.this.uWindLevel(DataCanbus.DATA[updateCode]);
                    break;
                case 98:
                    TuRui_AirActi.this.uLTemp(DataCanbus.DATA[updateCode] & 255);
                    break;
                case 99:
                    TuRui_AirActi.this.uRTemp(DataCanbus.DATA[updateCode] & 255);
                    break;
                case 120:
                    TuRui_AirActi.this.uBlowWin(DataCanbus.DATA[updateCode]);
                    break;
                case 149:
                    TuRui_AirActi.this.uCycleAuto(DataCanbus.DATA[updateCode]);
                    break;
                case 234:
                    TuRui_AirActi.this.uSteerHot(DataCanbus.DATA[updateCode]);
                    break;
                case 235:
                    TuRui_AirActi.this.uFrontHot(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0270_wc_turui_air_control);
        init();
        AirHelper.disableAirWindowLocal(true);
        mInstance = this;
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setOnClick((Button) findViewById(R.id.btn_air_temp_left_plus));
        setOnClick((Button) findViewById(R.id.btn_air_temp_left_minus));
        setOnClick((Button) findViewById(R.id.btn_air_temp_right_minus));
        setOnClick((Button) findViewById(R.id.btn_air_temp_right_plus));
        setOnClick((Button) findViewById(R.id.dj_xts_air_win_minuts_btn));
        setOnClick((Button) findViewById(R.id.dj_xts_air_win_plus_btn));
        setOnClick((Button) findViewById(R.id.air_xts_cycle));
        setOnClick((Button) findViewById(R.id.air_xts_mode_win));
        setOnClick((Button) findViewById(R.id.air_xts_mode_body));
        setOnClick((Button) findViewById(R.id.air_xts_mode_foot));
        setOnClick((Button) findViewById(R.id.air_xts_power));
        setOnClick((Button) findViewById(R.id.air_xts_auto));
        setOnClick((Button) findViewById(R.id.air_xts_steer_hot));
        setOnClick((Button) findViewById(R.id.air_xts_front_hot));
    }

    private void setOnClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCMD(int cmd, int para) {
        DataCanbus.PROXY.cmd(22, cmd, para);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.mNotifyCanbus);
    }

    protected void uFrontHot(int i) {
        if (((Button) findViewById(R.id.air_xts_front_hot)) != null) {
            ((Button) findViewById(R.id.air_xts_front_hot)).setBackgroundResource(i == 1 ? R.drawable.ic_xts_fronthot_p : R.drawable.ic_xts_fronthot_n);
        }
    }

    protected void uSteerHot(int i) {
        if (((Button) findViewById(R.id.air_xts_steer_hot)) != null) {
            ((Button) findViewById(R.id.air_xts_steer_hot)).setBackgroundResource(i == 1 ? R.drawable.ic_xts_steer_hot_p : R.drawable.ic_xts_steer_hot_n);
        }
    }

    protected void uAuto() {
        int auto = DataCanbus.DATA[94];
        int autolev = DataCanbus.DATA[89];
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            int resid = R.drawable.ic_turui_auto;
            if (auto != 0) {
                if (autolev == 1) {
                    resid = R.drawable.ic_turui_auto_mid;
                } else if (autolev == 2) {
                    resid = R.drawable.ic_turui_auto_high;
                } else if (autolev == 0) {
                    resid = R.drawable.ic_turui_auto_low;
                }
            } else if (autolev == 1) {
                resid = R.drawable.ic_turui_auto_off_mid;
            } else if (autolev == 2) {
                resid = R.drawable.ic_turui_auto_off_high;
            } else if (autolev == 0) {
                resid = R.drawable.ic_turui_auto_off_low;
            }
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(resid);
        }
    }

    protected void uWindLevel(int i) {
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(i).toString());
        }
    }

    protected void uCycleAuto(int i) {
        if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
            if (i == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycleauto_0);
            } else if (i == 1) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycleauto_2);
            }
        }
    }

    protected void uBlowWin(int i) {
        if (((Button) findViewById(R.id.air_xts_mode_win)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_win)).setBackgroundResource(i == 1 ? R.drawable.ic_xts_mode_win_p : R.drawable.ic_xts_mode_win_n);
        }
    }

    protected void uBlowFoot(int i) {
        if (((Button) findViewById(R.id.air_xts_mode_foot)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(i == 1 ? R.drawable.ic_xts_mode_foot_p : R.drawable.ic_xts_mode_foot_n);
        }
    }

    protected void uLTemp(int i) {
        String str;
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (i == 254) {
                str = "LOW";
            } else if (i == 255) {
                str = "HI";
            } else if (DataCanbus.DATA[1000] == 196878) {
                if ((DataCanbus.DATA[179] & 255) == 1) {
                    str = String.valueOf(i * 0.5f) + "℃";
                } else {
                    str = String.valueOf(i - 60) + "℉";
                }
            } else {
                str = String.valueOf(i * 0.5f) + "℃";
            }
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(str);
        }
    }

    protected void uBlowBody(int i) {
        if (((Button) findViewById(R.id.air_xts_mode_body)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(i == 1 ? R.drawable.ic_xts_mode_body_p : R.drawable.ic_xts_mode_body_n);
        }
    }

    protected void uRTemp(int i) {
        String str;
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (i == 254) {
                str = "LOW";
            } else if (i == 255) {
                str = "HI";
            } else if (DataCanbus.DATA[1000] == 196878) {
                if ((DataCanbus.DATA[179] & 255) == 1) {
                    str = String.valueOf(i * 0.5f) + "℃";
                } else {
                    str = String.valueOf(i - 60) + "℉";
                }
            } else {
                str = String.valueOf(i * 0.5f) + "℃";
            }
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(str);
        }
    }

    protected void uPower(int i) {
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(i == 1 ? R.drawable.ic_xts_power_p : R.drawable.ic_xts_power_n);
        }
    }
}
