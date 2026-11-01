package com.syu.carinfo.golf7;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
@SuppressLint({"CutPasteId"})
public class TuAn_YueYe_Set_Acti extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.golf7.TuAn_YueYe_Set_Acti.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            int cmd = -1;
            int val = -1;
            switch (v.getId()) {
                case R.id.wc_golf_4engine_m /* 2131430477 */:
                case R.id.wc_golf_4engine_p /* 2131430479 */:
                    cmd = 229;
                    int val2 = DataCanbus.DATA[257] & 255;
                    val = val2 != 1 ? 1 : 0;
                    break;
                case R.id.wc_golf_air_downhill_m /* 2131430484 */:
                case R.id.wc_golf_air_downhill_p /* 2131430486 */:
                    cmd = 231;
                    int val3 = DataCanbus.DATA[259] & 255;
                    val = val3 != 1 ? 1 : 0;
                    break;
                case R.id.wc_golf_air_ramp_m /* 2131430488 */:
                case R.id.wc_golf_air_ramp_p /* 2131430490 */:
                    cmd = 232;
                    int val4 = DataCanbus.DATA[260] & 255;
                    val = val4 != 1 ? 1 : 0;
                    break;
                case R.id.wc_golf_air_parkassit_m /* 2131430492 */:
                case R.id.wc_golf_air_parkassit_p /* 2131430494 */:
                    cmd = 233;
                    int val5 = DataCanbus.DATA[261] & 255;
                    val = val5 != 1 ? 1 : 0;
                    break;
            }
            if (cmd != -1) {
                TuAn_YueYe_Set_Acti.this.sendCMD(cmd, val);
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.TuAn_YueYe_Set_Acti.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 255:
                    TuAn_YueYe_Set_Acti.this.uEngine(val);
                    break;
                case 256:
                    TuAn_YueYe_Set_Acti.this.uSteer(val);
                    break;
                case 257:
                    TuAn_YueYe_Set_Acti.this.u4Engine(val);
                    break;
                case 258:
                    TuAn_YueYe_Set_Acti.this.uAir(val);
                    break;
                case 259:
                    TuAn_YueYe_Set_Acti.this.uDownHill(val);
                    break;
                case 260:
                    TuAn_YueYe_Set_Acti.this.uRamp(val);
                    break;
                case 261:
                    TuAn_YueYe_Set_Acti.this.uParkAssit(val);
                    break;
                case 262:
                    TuAn_YueYe_Set_Acti.this.uBend(val);
                    break;
                case 263:
                    TuAn_YueYe_Set_Acti.this.uAcc(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_offroad_driving_info3_wc);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setVisible(findViewById(R.id.wc_golf_bend_view), false);
        setVisible(findViewById(R.id.wc_golf_acc_view), false);
        setClick((Button) findViewById(R.id.wc_golf_air_parkassit_m));
        setClick((Button) findViewById(R.id.wc_golf_air_parkassit_p));
        setClick((Button) findViewById(R.id.wc_golf_air_ramp_m));
        setClick((Button) findViewById(R.id.wc_golf_air_ramp_p));
        setClick((Button) findViewById(R.id.wc_golf_air_downhill_m));
        setClick((Button) findViewById(R.id.wc_golf_air_downhill_p));
        setClick((Button) findViewById(R.id.wc_golf_4engine_m));
        setClick((Button) findViewById(R.id.wc_golf_4engine_p));
        ((Button) findViewById(R.id.wc_golf_bend_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.TuAn_YueYe_Set_Acti.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[262] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 2;
                }
                TuAn_YueYe_Set_Acti.this.sendCMD(5, value);
            }
        });
        ((Button) findViewById(R.id.wc_golf_bend_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.TuAn_YueYe_Set_Acti.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[262] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                TuAn_YueYe_Set_Acti.this.sendCMD(5, value);
            }
        });
        ((Button) findViewById(R.id.wc_golf_engine_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.TuAn_YueYe_Set_Acti.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[255] & 255;
                TuAn_YueYe_Set_Acti.this.sendCMD(228, value == 1 ? 0 : 1);
            }
        });
        ((Button) findViewById(R.id.wc_golf_engine_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.TuAn_YueYe_Set_Acti.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[255] & 255;
                TuAn_YueYe_Set_Acti.this.sendCMD(228, value == 1 ? 0 : 1);
            }
        });
        ((Button) findViewById(R.id.wc_golf_acc_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.TuAn_YueYe_Set_Acti.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[263] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 2;
                }
                TuAn_YueYe_Set_Acti.this.sendCMD(4, value);
            }
        });
        ((Button) findViewById(R.id.wc_golf_acc_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.TuAn_YueYe_Set_Acti.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[263] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                TuAn_YueYe_Set_Acti.this.sendCMD(4, value);
            }
        });
        ((Button) findViewById(R.id.wc_golf_air_condition_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.TuAn_YueYe_Set_Acti.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[258] & 255;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                TuAn_YueYe_Set_Acti.this.sendCMD(230, value);
            }
        });
        ((Button) findViewById(R.id.wc_golf_air_condition_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.TuAn_YueYe_Set_Acti.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[258] & 255;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                TuAn_YueYe_Set_Acti.this.sendCMD(230, value);
            }
        });
        ((Button) findViewById(R.id.wc_golf_steering_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.TuAn_YueYe_Set_Acti.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[256] & 255;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                TuAn_YueYe_Set_Acti.this.sendCMD(227, value);
            }
        });
        ((Button) findViewById(R.id.wc_golf_steering_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.TuAn_YueYe_Set_Acti.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[256] & 255;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                TuAn_YueYe_Set_Acti.this.sendCMD(227, value);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_golf_driving_reset)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.TuAn_YueYe_Set_Acti.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                TuAn_YueYe_Set_Acti.this.dialog(R.string.driving_mode_reset);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(113, new int[]{9, cmd, val}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void setClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
    }

    private void setVisible(View v, boolean on) {
        if (v != null) {
            v.setVisibility(on ? 0 : 8);
        }
    }

    protected void dialog(int stringId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.golf7.TuAn_YueYe_Set_Acti.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.golf7.TuAn_YueYe_Set_Acti.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TuAn_YueYe_Set_Acti.this.sendCMD(234, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.golf7.TuAn_YueYe_Set_Acti.15
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
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
        DataCanbus.NOTIFY_EVENTS[262].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[255].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[263].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[258].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[256].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[257].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[259].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[260].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[261].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[262].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[255].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[263].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[258].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[256].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[257].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[259].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[260].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[261].removeNotify(this.mNotifyCanbus);
    }

    protected void uParkAssit(int val) {
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.wc_golf_air_parkassit_txt)) != null) {
            int id = R.string.str_right_camera_close;
            if (val2 == 1) {
                id = R.string.str_right_camera_open;
            }
            ((TextView) findViewById(R.id.wc_golf_air_parkassit_txt)).setText(id);
        }
    }

    protected void uRamp(int val) {
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.wc_golf_air_ramp_txt)) != null) {
            int id = R.string.str_right_camera_close;
            if (val2 == 1) {
                id = R.string.str_right_camera_open;
            }
            ((TextView) findViewById(R.id.wc_golf_air_ramp_txt)).setText(id);
        }
    }

    protected void uDownHill(int val) {
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.wc_golf_air_downhill_txt)) != null) {
            int id = R.string.str_right_camera_close;
            if (val2 == 1) {
                id = R.string.str_right_camera_open;
            }
            ((TextView) findViewById(R.id.wc_golf_air_downhill_txt)).setText(id);
        }
    }

    protected void u4Engine(int val) {
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.wc_golf_4engine_txt)) != null) {
            int id = R.string.driver_system_standard;
            if (val2 == 1) {
                id = R.string.str_17_off_road;
            }
            ((TextView) findViewById(R.id.wc_golf_4engine_txt)).setText(id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uBend(int val) {
        int value = val & 255;
        if (((TextView) findViewById(R.id.wc_golf_bend_set_show)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.wc_golf_bend_set_show)).setText(R.string.driver_system_standard);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_golf_bend_set_show)).setText(R.string.str_driving_sport);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.wc_golf_bend_set_show)).setText(R.string.str_driving_eco);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uEngine(int val) {
        int value = val & 255;
        if (((TextView) findViewById(R.id.wc_golf_engine_set_show)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.wc_golf_engine_set_show)).setText(R.string.driver_system_standard);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_golf_engine_set_show)).setText(R.string.str_17_off_road);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uAcc(int val) {
        int value = val & 255;
        if (((TextView) findViewById(R.id.wc_golf_acc_set_show)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.wc_golf_acc_set_show)).setText(R.string.driver_system_standard);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_golf_acc_set_show)).setText(R.string.str_driving_sport);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.wc_golf_acc_set_show)).setText(R.string.str_driving_eco);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uAir(int val) {
        int value = val & 255;
        if (((TextView) findViewById(R.id.wc_golf_air_condition_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_golf_air_condition_set_show)).setText(R.string.driver_system_standard);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.wc_golf_air_condition_set_show)).setText(R.string.str_driving_eco);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSteer(int val) {
        int value = val & 255;
        if (((TextView) findViewById(R.id.wc_golf_steering_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_golf_steering_set_show)).setText(R.string.driver_system_standard);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.wc_golf_steering_set_show)).setText(R.string.str_driving_sport);
            }
        }
    }
}
