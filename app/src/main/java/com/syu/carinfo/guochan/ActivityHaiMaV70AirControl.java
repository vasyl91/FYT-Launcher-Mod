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
public class ActivityHaiMaV70AirControl extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.guochan.ActivityHaiMaV70AirControl.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 23:
                    if (value == 0) {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_power)).setBackgroundResource(R.drawable.ic_xts_power_n);
                        break;
                    } else {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_power)).setBackgroundResource(R.drawable.ic_xts_power_p);
                        break;
                    }
                case 27:
                    if (value == 0) {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_ac)).setBackgroundResource(R.drawable.ic_xts_ac_n);
                        break;
                    } else {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_ac)).setBackgroundResource(R.drawable.ic_xts_ac_p);
                        break;
                    }
                case 28:
                    if (value == 0) {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_cycle)).setBackgroundResource(R.drawable.ic_xts_cycle_p);
                        break;
                    } else {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_cycle)).setBackgroundResource(R.drawable.ic_xts_cycle_n);
                        break;
                    }
                case 29:
                    if (value == 0) {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_rear)).setBackgroundResource(R.drawable.ic_xts_rear_n);
                        break;
                    } else {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_rear)).setBackgroundResource(R.drawable.ic_xts_rear_p);
                        break;
                    }
                case 30:
                    if (value == 0) {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_front)).setBackgroundResource(R.drawable.ic_xts_front_n);
                        break;
                    } else {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_front)).setBackgroundResource(R.drawable.ic_xts_front_p);
                        break;
                    }
                case 35:
                case 36:
                case 37:
                    ActivityHaiMaV70AirControl.this.UpdateBlowMode();
                    break;
                case 39:
                    ActivityHaiMaV70AirControl.this.mUpdaterAirWindLevelLeft();
                    break;
                case 40:
                    if (value == -2) {
                        ((TextView) ActivityHaiMaV70AirControl.this.findViewById(R.id.tv_air_temp_left)).setText("LOW");
                        ((TextView) ActivityHaiMaV70AirControl.this.findViewById(R.id.tv_air_temp_right)).setText("LOW");
                        break;
                    } else if (value == -3) {
                        ((TextView) ActivityHaiMaV70AirControl.this.findViewById(R.id.tv_air_temp_left)).setText("HIGHT");
                        ((TextView) ActivityHaiMaV70AirControl.this.findViewById(R.id.tv_air_temp_right)).setText("HIGHT");
                        break;
                    } else if (value == -1) {
                        ((TextView) ActivityHaiMaV70AirControl.this.findViewById(R.id.tv_air_temp_left)).setText("NONE");
                        ((TextView) ActivityHaiMaV70AirControl.this.findViewById(R.id.tv_air_temp_right)).setText("NONE");
                        break;
                    } else {
                        ((TextView) ActivityHaiMaV70AirControl.this.findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(value / 10.0f) + "℃");
                        ((TextView) ActivityHaiMaV70AirControl.this.findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(value / 10.0f) + "℃");
                        break;
                    }
                case 41:
                    if (value == 0) {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_real)).setBackgroundResource(R.drawable.ic_xts_real_n);
                        break;
                    } else {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_real)).setBackgroundResource(R.drawable.ic_xts_real_p);
                        break;
                    }
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_395_air_control);
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
        ((Button) findViewById(R.id.air_xts_mode_foot)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_body)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_footbody)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_real)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_footwin)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_info)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_front)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_rear)).setOnTouchListener(this);
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int touchState = -1;
        if (event.getAction() == 0) {
            touchState = 1;
        } else if (event.getAction() == 1) {
            touchState = 0;
        }
        int cmd = 0;
        switch (v.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_left_plus)).setBackgroundResource(R.drawable.ic_xts_temp_plus_p);
                } else if (event.getAction() == 1) {
                    ((Button) findViewById(R.id.btn_air_temp_left_plus)).setBackgroundResource(R.drawable.ic_xts_temp_plus_n);
                }
                cmd = 13;
                setAirControl(cmd, touchState);
                return true;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_left_minus)).setBackgroundResource(R.drawable.ic_xts_temp_munits_p);
                } else if (event.getAction() == 1) {
                    ((Button) findViewById(R.id.btn_air_temp_left_minus)).setBackgroundResource(R.drawable.ic_xts_temp_munits_n);
                }
                cmd = 14;
                setAirControl(cmd, touchState);
                return true;
            case R.id.air_xts_power /* 2131427428 */:
                cmd = 1;
                setAirControl(cmd, touchState);
                return true;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setBackgroundResource(R.drawable.ic_xts_win_munits_p);
                } else if (event.getAction() == 1) {
                    ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setBackgroundResource(R.drawable.ic_xts_win_munits_n);
                }
                cmd = 12;
                setAirControl(cmd, touchState);
                return true;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setBackgroundResource(R.drawable.ic_xts_win_plus_p);
                } else if (event.getAction() == 1) {
                    ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setBackgroundResource(R.drawable.ic_xts_win_plus_n);
                }
                cmd = 11;
                setAirControl(cmd, touchState);
                return true;
            case R.id.air_xts_cycle /* 2131427437 */:
                cmd = 7;
                setAirControl(cmd, touchState);
                return true;
            case R.id.air_xts_front /* 2131427438 */:
                cmd = 5;
                setAirControl(cmd, touchState);
                return true;
            case R.id.air_xts_ac /* 2131427439 */:
                cmd = 2;
                setAirControl(cmd, touchState);
                return true;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                cmd = 28;
                setAirControl(cmd, touchState);
                return true;
            case R.id.air_xts_mode_body /* 2131427444 */:
                cmd = 25;
                setAirControl(cmd, touchState);
                return true;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_right_plus)).setBackgroundResource(R.drawable.ic_xts_temp_plus_p);
                } else if (event.getAction() == 1) {
                    ((Button) findViewById(R.id.btn_air_temp_right_plus)).setBackgroundResource(R.drawable.ic_xts_temp_plus_n);
                }
                cmd = 13;
                setAirControl(cmd, touchState);
                return true;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_right_minus)).setBackgroundResource(R.drawable.ic_xts_temp_munits_p);
                } else if (event.getAction() == 1) {
                    ((Button) findViewById(R.id.btn_air_temp_right_minus)).setBackgroundResource(R.drawable.ic_xts_temp_munits_n);
                }
                cmd = 14;
                setAirControl(cmd, touchState);
                return true;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                cmd = 26;
                setAirControl(cmd, touchState);
                return true;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                cmd = 27;
                setAirControl(cmd, touchState);
                return true;
            case R.id.air_xts_rear /* 2131427534 */:
                cmd = 6;
                setAirControl(cmd, touchState);
                return true;
            case R.id.air_xts_info /* 2131428028 */:
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.air_xts_info)).setBackgroundResource(R.drawable.ic_xts_info_p);
                } else if (event.getAction() == 1) {
                    ((Button) findViewById(R.id.air_xts_info)).setBackgroundResource(R.drawable.ic_xts_info_n);
                }
                DataCanbus.PROXY.cmd(1, 1, touchState);
                return true;
            case R.id.air_xts_real /* 2131428967 */:
                cmd = 23;
                setAirControl(cmd, touchState);
                return true;
            default:
                setAirControl(cmd, touchState);
                return true;
        }
    }

    private void setAirControl(int cmd, int value) {
        DataCanbus.PROXY.cmd(0, cmd, value);
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mCanbusNotify);
    }

    void mUpdaterAirWindLevelLeft() {
        int level = DataCanbus.DATA[39];
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null && level > -1 && level < 9) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder(String.valueOf(level)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UpdateBlowMode() {
        int body = DataCanbus.DATA[36];
        int win = DataCanbus.DATA[37];
        int foot = DataCanbus.DATA[35];
        ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        ((Button) findViewById(R.id.air_xts_mode_footbody)).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        ((Button) findViewById(R.id.air_xts_mode_footwin)).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        if (foot == 1 && body == 1 && win == 0) {
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
            return;
        }
        if (foot == 0 && body == 1 && win == 0) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
            return;
        }
        if (foot == 1 && body == 0 && win == 0) {
            ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
        } else if (foot == 1 && body == 0 && win == 1) {
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
        }
    }
}
