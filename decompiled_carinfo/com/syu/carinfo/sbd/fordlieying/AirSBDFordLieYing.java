package com.syu.carinfo.sbd.fordlieying;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0398_SBD_FORD_LIEYING;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class AirSBDFordLieYing extends BaseActivity implements View.OnTouchListener {
    public static AirSBDFordLieYing mInstance;
    public static boolean mIsFront = false;
    int touchState = -1;
    int cmd = 0;
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    if (((Button) AirSBDFordLieYing.this.findViewById(R.id.air_xts_power)) != null) {
                        ((Button) AirSBDFordLieYing.this.findViewById(R.id.air_xts_power)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
                        break;
                    }
                case 11:
                    if (((Button) AirSBDFordLieYing.this.findViewById(R.id.air_xts_ac)) != null) {
                        ((Button) AirSBDFordLieYing.this.findViewById(R.id.air_xts_ac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
                        break;
                    }
                case 12:
                    if (((Button) AirSBDFordLieYing.this.findViewById(R.id.air_xts_cycle)) != null) {
                        if (value == 0) {
                            ((Button) AirSBDFordLieYing.this.findViewById(R.id.air_xts_cycle)).setBackgroundResource(R.drawable.ic_xts_cycle_n);
                            break;
                        } else if (value == 1) {
                            ((Button) AirSBDFordLieYing.this.findViewById(R.id.air_xts_cycle)).setBackgroundResource(R.drawable.ic_xts_cycle_p);
                            break;
                        }
                    }
                    break;
                case 14:
                    if (((Button) AirSBDFordLieYing.this.findViewById(R.id.air_xts_zone)) != null) {
                        ((Button) AirSBDFordLieYing.this.findViewById(R.id.air_xts_zone)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_zone_n : R.drawable.ic_xts_zone_p);
                        break;
                    }
                case 16:
                    if (value == 0) {
                        ((Button) AirSBDFordLieYing.this.findViewById(R.id.air_xts_rear)).setBackgroundResource(R.drawable.ic_xts_rear_n);
                        break;
                    } else {
                        ((Button) AirSBDFordLieYing.this.findViewById(R.id.air_xts_rear)).setBackgroundResource(R.drawable.ic_xts_rear_p);
                        break;
                    }
                case 18:
                case 19:
                case 20:
                    AirSBDFordLieYing.this.mUpdaterAirBlowMode();
                    break;
                case 21:
                    AirSBDFordLieYing.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    if (value == 95) {
                        ((TextView) AirSBDFordLieYing.this.findViewById(R.id.tv_air_temp_left)).setText("LOW");
                        break;
                    } else if (value == 410) {
                        ((TextView) AirSBDFordLieYing.this.findViewById(R.id.tv_air_temp_left)).setText("HI");
                        break;
                    } else {
                        float temp = value * 0.1f;
                        ((TextView) AirSBDFordLieYing.this.findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(temp) + "℃");
                        break;
                    }
                case 28:
                    if (value == 95) {
                        ((TextView) AirSBDFordLieYing.this.findViewById(R.id.tv_air_temp_right)).setText("LOW");
                        break;
                    } else if (value == 410) {
                        ((TextView) AirSBDFordLieYing.this.findViewById(R.id.tv_air_temp_right)).setText("HI");
                        break;
                    } else {
                        float temp_r = value * 0.1f;
                        ((TextView) AirSBDFordLieYing.this.findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(temp_r) + "℃");
                        break;
                    }
                case 49:
                    if (value == 0) {
                        ((Button) AirSBDFordLieYing.this.findViewById(R.id.air_xts_auto)).setBackgroundResource(R.drawable.ic_xts_auto_n);
                        break;
                    } else {
                        ((Button) AirSBDFordLieYing.this.findViewById(R.id.air_xts_auto)).setBackgroundResource(R.drawable.ic_xts_auto_p);
                        break;
                    }
                case 65:
                    if (value == 0) {
                        ((Button) AirSBDFordLieYing.this.findViewById(R.id.air_xts_front)).setBackgroundResource(R.drawable.ic_xts_front_n);
                        break;
                    } else {
                        ((Button) AirSBDFordLieYing.this.findViewById(R.id.air_xts_front)).setBackgroundResource(R.drawable.ic_xts_front_p);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0398_lsdt_fordlieying_air);
        initListener();
        mInstance = this;
    }

    private void initListener() {
        setSelfTouch((Button) findViewById(R.id.btn_air_temp_left_minus), this);
        setSelfTouch((Button) findViewById(R.id.btn_air_temp_left_plus), this);
        setSelfTouch((Button) findViewById(R.id.btn_air_temp_right_minus), this);
        setSelfTouch((Button) findViewById(R.id.btn_air_temp_right_plus), this);
        setSelfTouch((Button) findViewById(R.id.dj_xts_air_win_minuts_btn), this);
        setSelfTouch((Button) findViewById(R.id.dj_xts_air_win_plus_btn), this);
        setSelfTouch((Button) findViewById(R.id.air_xts_power), this);
        setSelfTouch((Button) findViewById(R.id.air_xts_ac), this);
        setSelfTouch((Button) findViewById(R.id.air_xts_cycle), this);
        setSelfTouch((Button) findViewById(R.id.air_xts_front), this);
        setSelfTouch((Button) findViewById(R.id.air_xts_rear), this);
        setSelfTouch((Button) findViewById(R.id.air_xts_auto), this);
        setSelfTouch((Button) findViewById(R.id.air_xts_info), this);
        setSelfTouch((Button) findViewById(R.id.air_xts_mode), this);
        setSelfTouch((Button) findViewById(R.id.air_xts_zone), this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        Callback_0398_SBD_FORD_LIEYING.delay = false;
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

    @Override
    public boolean onTouch(View arg0, MotionEvent arg1) {
        this.cmd = 0;
        if (arg1.getAction() == 0) {
            switch (arg0.getId()) {
                case R.id.btn_air_temp_left_plus /* 2131427425 */:
                    this.cmd = 1;
                    break;
                case R.id.btn_air_temp_left_minus /* 2131427427 */:
                    this.cmd = 2;
                    break;
                case R.id.air_xts_power /* 2131427428 */:
                    this.cmd = 11;
                    break;
                case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                    this.cmd = 8;
                    break;
                case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                    this.cmd = 7;
                    break;
                case R.id.air_xts_mode /* 2131427434 */:
                    this.cmd = 5;
                    break;
                case R.id.air_xts_auto /* 2131427436 */:
                    this.cmd = 12;
                    break;
                case R.id.air_xts_cycle /* 2131427437 */:
                    this.cmd = 9;
                    break;
                case R.id.air_xts_front /* 2131427438 */:
                    this.cmd = 6;
                    break;
                case R.id.air_xts_ac /* 2131427439 */:
                    this.cmd = 4;
                    break;
                case R.id.btn_air_temp_right_plus /* 2131427449 */:
                    this.cmd = 13;
                    break;
                case R.id.btn_air_temp_right_minus /* 2131427451 */:
                    this.cmd = 14;
                    break;
                case R.id.air_xts_rear /* 2131427560 */:
                    this.cmd = 3;
                    break;
                case R.id.air_xts_zone /* 2131428031 */:
                    this.cmd = 10;
                    break;
                case R.id.air_xts_info /* 2131428032 */:
                    try {
                        Callback_0398_SBD_FORD_LIEYING.jump = false;
                        Intent intent = new Intent();
                        intent.setClass(this, InfoSBDFordLieYing.class);
                        startActivity(intent);
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
            }
        }
        setAirControl(this.cmd);
        return false;
    }

    private void setAirControl(int cmd) {
        DataCanbus.PROXY.cmd(1, cmd);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mCanbusNotify, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mCanbusNotify);
    }

    void mUpdaterAirBlowMode() {
        int win = DataCanbus.DATA[18];
        int body = DataCanbus.DATA[19];
        int foot = DataCanbus.DATA[20];
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
        if (win == 1) {
            mode |= 4;
        } else if (win == 0) {
            mode &= 251;
        }
        switch (mode) {
            case 0:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                break;
            case 1:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot);
                break;
            case 2:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body);
                break;
            case 3:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
                break;
            case 4:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_win);
                break;
            case 5:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
                break;
            case 6:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body_win);
                break;
            case 7:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body_win);
                break;
            default:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                break;
        }
    }

    void mUpdaterAirWindLevelLeft() {
        int level = DataCanbus.DATA[21];
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null && level > -1 && level < 9) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.addCategory("android.intent.category.HOME");
            startActivity(intent);
        }
        return true;
    }
}
