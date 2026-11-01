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

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityHaiMaV70AirControl extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    if (value == 0) {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_power)).setBackgroundResource(R.drawable.ic_xts_power_n);
                        break;
                    } else {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_power)).setBackgroundResource(R.drawable.ic_xts_power_p);
                        break;
                    }
                case 11:
                    if (value == 0) {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_ac)).setBackgroundResource(R.drawable.ic_xts_ac_n);
                        break;
                    } else {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_ac)).setBackgroundResource(R.drawable.ic_xts_ac_p);
                        break;
                    }
                case 12:
                    if (value == 0) {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_cycle)).setBackgroundResource(R.drawable.ic_xts_cycle_p);
                        break;
                    } else {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_cycle)).setBackgroundResource(R.drawable.ic_xts_cycle_n);
                        break;
                    }
                case 16:
                    if (value == 0) {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_rear)).setBackgroundResource(R.drawable.ic_xts_rear_n);
                        break;
                    } else {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_rear)).setBackgroundResource(R.drawable.ic_xts_rear_p);
                        break;
                    }
                case 18:
                case 19:
                case 20:
                    ActivityHaiMaV70AirControl.this.UpdateBlowMode();
                    break;
                case 21:
                    ActivityHaiMaV70AirControl.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
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
                case 38:
                    if (value == 0) {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_real)).setBackgroundResource(R.drawable.ic_xts_real_n);
                        break;
                    } else {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_real)).setBackgroundResource(R.drawable.ic_xts_real_p);
                        break;
                    }
                case 65:
                    if (value == 0) {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_front)).setBackgroundResource(R.drawable.ic_xts_front_n);
                        break;
                    } else {
                        ((Button) ActivityHaiMaV70AirControl.this.findViewById(R.id.air_xts_front)).setBackgroundResource(R.drawable.ic_xts_front_p);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_395_air_control);
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

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
        mIsFront = false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
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
            case R.id.air_xts_mode_footbody /* 2131427502 */:
                cmd = 26;
                setAirControl(cmd, touchState);
                return true;
            case R.id.air_xts_rear /* 2131427560 */:
                cmd = 6;
                setAirControl(cmd, touchState);
                return true;
            case R.id.air_xts_mode_footwin /* 2131427632 */:
                cmd = 27;
                setAirControl(cmd, touchState);
                return true;
            case R.id.air_xts_info /* 2131428032 */:
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.air_xts_info)).setBackgroundResource(R.drawable.ic_xts_info_p);
                } else if (event.getAction() == 1) {
                    ((Button) findViewById(R.id.air_xts_info)).setBackgroundResource(R.drawable.ic_xts_info_n);
                }
                DataCanbus.PROXY.cmd(1, 1, touchState);
                return true;
            case R.id.air_xts_real /* 2131429656 */:
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
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mCanbusNotify);
    }

    void mUpdaterAirWindLevelLeft() {
        int level = DataCanbus.DATA[21];
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null && level > -1 && level < 9) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder(String.valueOf(level)).toString());
        }
    }

    
    public void UpdateBlowMode() {
        int body = DataCanbus.DATA[19];
        int win = DataCanbus.DATA[18];
        int foot = DataCanbus.DATA[20];
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
