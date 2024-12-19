package com.syu.carinfo.guochan;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class AirQiChenT90 extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    int touchState = -1;
    int cmd = 0;
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.guochan.AirQiChenT90.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 23:
                    if (value == 0) {
                        ((Button) AirQiChenT90.this.findViewById(R.id.air_xts_power)).setBackgroundResource(R.drawable.ic_xts_power_n);
                        break;
                    } else {
                        ((Button) AirQiChenT90.this.findViewById(R.id.air_xts_power)).setBackgroundResource(R.drawable.ic_xts_power_p);
                        break;
                    }
                case 27:
                    if (value == 0) {
                        ((Button) AirQiChenT90.this.findViewById(R.id.air_xts_ac)).setBackgroundResource(R.drawable.ic_xts_ac_n);
                        break;
                    } else {
                        ((Button) AirQiChenT90.this.findViewById(R.id.air_xts_ac)).setBackgroundResource(R.drawable.ic_xts_ac_p);
                        break;
                    }
                case 28:
                    if (value == 0) {
                        ((Button) AirQiChenT90.this.findViewById(R.id.air_xts_cycle)).setBackgroundResource(R.drawable.ic_xts_cycle_n);
                        break;
                    } else {
                        ((Button) AirQiChenT90.this.findViewById(R.id.air_xts_cycle)).setBackgroundResource(R.drawable.ic_xts_cycle_p);
                        break;
                    }
                case 35:
                case 36:
                case 37:
                    int foot = DataCanbus.DATA[35];
                    int body = DataCanbus.DATA[36];
                    int window = DataCanbus.DATA[37];
                    int mode = 0;
                    if (foot == 1) {
                        mode = 0 | 1;
                    } else if (foot == 0) {
                        mode = 0 & 254;
                    }
                    if (body == 1) {
                        mode |= 2;
                    } else if (body == 0) {
                        mode &= 253;
                    }
                    if (window == 1) {
                        mode |= 4;
                    } else if (window == 0) {
                        mode &= 251;
                    }
                    switch (mode) {
                        case 0:
                            AirQiChenT90.this.findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                            break;
                        case 1:
                            AirQiChenT90.this.findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot);
                            break;
                        case 2:
                            AirQiChenT90.this.findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body);
                            break;
                        case 3:
                            AirQiChenT90.this.findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
                            break;
                        case 4:
                            AirQiChenT90.this.findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_win);
                            break;
                        case 5:
                            AirQiChenT90.this.findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
                            break;
                        case 6:
                            AirQiChenT90.this.findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body_win);
                            break;
                        case 7:
                            AirQiChenT90.this.findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body_win);
                            break;
                        default:
                            AirQiChenT90.this.findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                            break;
                    }
                case 39:
                    AirQiChenT90.this.mUpdaterAirWindLevelLeft();
                    break;
                case 40:
                    if (1507723 == DataCanbus.DATA[1000]) {
                        if (value == -2) {
                            ((TextView) AirQiChenT90.this.findViewById(R.id.tv_air_temp_right)).setText("LOW");
                        } else if (value == -3) {
                            ((TextView) AirQiChenT90.this.findViewById(R.id.tv_air_temp_right)).setText("HIGHT");
                        } else if (value == -1) {
                            ((TextView) AirQiChenT90.this.findViewById(R.id.tv_air_temp_right)).setText("NONE");
                        } else {
                            ((TextView) AirQiChenT90.this.findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(value / 10.0f) + "℃");
                        }
                    }
                    if (value == -2) {
                        ((TextView) AirQiChenT90.this.findViewById(R.id.tv_air_temp_left)).setText("LOW");
                        break;
                    } else if (value == -3) {
                        ((TextView) AirQiChenT90.this.findViewById(R.id.tv_air_temp_left)).setText("HIGHT");
                        break;
                    } else if (value == -1) {
                        ((TextView) AirQiChenT90.this.findViewById(R.id.tv_air_temp_left)).setText("NONE");
                        break;
                    } else {
                        ((TextView) AirQiChenT90.this.findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(value / 10.0f) + "℃");
                        break;
                    }
                case 68:
                    if (1507723 != DataCanbus.DATA[1000]) {
                        if (value == -2) {
                            ((TextView) AirQiChenT90.this.findViewById(R.id.tv_air_temp_right)).setText("LOW");
                            break;
                        } else if (value == -3) {
                            ((TextView) AirQiChenT90.this.findViewById(R.id.tv_air_temp_right)).setText("HIGHT");
                            break;
                        } else if (value == -1) {
                            ((TextView) AirQiChenT90.this.findViewById(R.id.tv_air_temp_right)).setText("NONE");
                            break;
                        } else {
                            ((TextView) AirQiChenT90.this.findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(value / 10.0f) + "℃");
                            break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_395_qichen_t90);
        initListener();
    }

    private void initListener() {
        ((Button) findViewById(R.id.btn_air_temp_left_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_power)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_ac)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_cycle)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode)).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
        mIsFront = false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        this.touchState = -1;
        if (event.getAction() == 0) {
            this.touchState = 1;
        } else if (event.getAction() == 1) {
            this.touchState = 0;
        }
        switch (v.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                this.cmd = 13;
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_right_plus)).setBackgroundResource(R.drawable.ic_ats_temp_plus_p);
                    break;
                } else {
                    ((Button) findViewById(R.id.btn_air_temp_right_plus)).setBackgroundResource(R.drawable.ic_ats_temp_plus_n);
                    break;
                }
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                this.cmd = 14;
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_right_minus)).setBackgroundResource(R.drawable.ic_ats_temp_munits_p);
                    break;
                } else {
                    ((Button) findViewById(R.id.btn_air_temp_right_minus)).setBackgroundResource(R.drawable.ic_ats_temp_munits_n);
                    break;
                }
            case R.id.air_xts_power /* 2131427428 */:
                this.cmd = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                this.cmd = 12;
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setBackgroundResource(R.drawable.ic_xts_win_munits_p);
                    break;
                } else {
                    ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setBackgroundResource(R.drawable.ic_xts_win_munits_n);
                    break;
                }
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                this.cmd = 11;
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setBackgroundResource(R.drawable.ic_xts_win_plus_p);
                    break;
                } else {
                    ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setBackgroundResource(R.drawable.ic_xts_win_plus_n);
                    break;
                }
            case R.id.air_xts_mode /* 2131427434 */:
                this.cmd = 21;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                this.cmd = 7;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                this.cmd = 2;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                if (1507723 == DataCanbus.DATA[1000]) {
                    this.cmd = 13;
                } else {
                    this.cmd = 15;
                }
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_right_plus)).setBackgroundResource(R.drawable.ic_ats_temp_plus_p);
                    break;
                } else {
                    ((Button) findViewById(R.id.btn_air_temp_right_plus)).setBackgroundResource(R.drawable.ic_ats_temp_plus_n);
                    break;
                }
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                if (1507723 == DataCanbus.DATA[1000]) {
                    this.cmd = 14;
                } else {
                    this.cmd = 16;
                }
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_right_minus)).setBackgroundResource(R.drawable.ic_ats_temp_munits_p);
                    break;
                } else {
                    ((Button) findViewById(R.id.btn_air_temp_right_minus)).setBackgroundResource(R.drawable.ic_ats_temp_munits_n);
                    break;
                }
        }
        setAirControl(this.cmd, this.touchState);
        return true;
    }

    private void setAirControl(int cmd, int value) {
        DataCanbus.PROXY.cmd(0, cmd, value);
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mCanbusNotify);
    }

    void mUpdaterAirWindLevelLeft() {
        int level = DataCanbus.DATA[39];
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null && level > -1 && level < 9) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder(String.valueOf(level)).toString());
        }
    }
}
