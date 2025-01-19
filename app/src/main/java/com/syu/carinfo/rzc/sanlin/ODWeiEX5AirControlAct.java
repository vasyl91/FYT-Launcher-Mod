package com.syu.carinfo.rzc.sanlin;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class ODWeiEX5AirControlAct extends Activity implements View.OnTouchListener {
    public static ODWeiEX5AirControlAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    ODWeiEX5AirControlAct.this.mUpdatePowerOn();
                    break;
                case 12:
                    ODWeiEX5AirControlAct.this.mUpdateCycle();
                    break;
                case 13:
                    ODWeiEX5AirControlAct.this.mUpdateAutoOn();
                    break;
                case 16:
                    ODWeiEX5AirControlAct.this.mUpdateRearDefrost();
                    break;
                case 18:
                case 19:
                case 20:
                    ODWeiEX5AirControlAct.this.updateBtnSource();
                    break;
                case 21:
                    ODWeiEX5AirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    ODWeiEX5AirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    ODWeiEX5AirControlAct.this.mUpdateAirTempRight();
                    break;
                case 62:
                    ODWeiEX5AirControlAct.this.mUpdateDualOn();
                    break;
                case 65:
                    ODWeiEX5AirControlAct.this.mUpdateFrontDefrost();
                    break;
                case 68:
                    ODWeiEX5AirControlAct.this.mUpdatePTC();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(2, new int[]{data0, data1}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_od_weima_ex5_air_control);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.air_xts_comfort).setOnTouchListener(this);
        findViewById(R.id.air_xts_economy).setOnTouchListener(this);
        findViewById(R.id.air_xts_ventilation).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 2;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 3;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 5;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 4;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 11;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 8;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 9;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data0 = 15;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 13;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 6;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 7;
                break;
            case R.id.air_xts_mode_footbody /* 2131427502 */:
                data0 = 14;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                data0 = 10;
                break;
            case R.id.air_xts_dual /* 2131427566 */:
                data0 = 12;
                break;
            case R.id.air_xts_mode_footwin /* 2131427632 */:
                data0 = 16;
                break;
            case R.id.air_xts_comfort /* 2131428635 */:
                data0 = 17;
                break;
            case R.id.air_xts_economy /* 2131428636 */:
                data0 = 18;
                break;
            case R.id.air_xts_ventilation /* 2131428637 */:
                data0 = 19;
                break;
        }
        if (0 == 0) {
            if (event.getAction() == 0) {
                sendCmd(data0, 1);
            } else if (event.getAction() == 1) {
                sendCmd(data0, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HIGH");
            } else if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NO");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp * 5) + 165) * 0.1f) + "℃");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HIGH");
            } else if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NO");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((temp * 5) + 165) * 0.1f) + "℃");
            }
        }
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[62];
        findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 1 ? R.drawable.ic_xts_dual_p : R.drawable.ic_xts_dual_n);
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(power != 0 ? R.drawable.ic_xts_power_p : R.drawable.ic_xts_power_n);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        } else {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        }
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[65];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdatePTC() {
        int value = DataCanbus.DATA[68];
        findViewById(R.id.air_xts_comfort).setBackgroundResource(R.drawable.ic_xts_comfort_n);
        findViewById(R.id.air_xts_economy).setBackgroundResource(R.drawable.ic_xts_economy_n);
        findViewById(R.id.air_xts_ventilation).setBackgroundResource(R.drawable.ic_xts_ventilation_n);
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_comfort).setBackgroundResource(R.drawable.ic_xts_comfort_p);
                break;
            case 1:
                findViewById(R.id.air_xts_economy).setBackgroundResource(R.drawable.ic_xts_economy_p);
                break;
            case 2:
                findViewById(R.id.air_xts_ventilation).setBackgroundResource(R.drawable.ic_xts_ventilation_p);
                break;
        }
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        if (leave < 0) {
            leave = 0;
        }
        if (leave > 7) {
            leave = 7;
        }
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }

    
    public void updateBtnSource() {
        int window = DataCanbus.DATA[18];
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
        if (window == 1) {
            mode |= 4;
        } else if (window == 0) {
            mode &= 251;
        }
        findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        switch (mode) {
            case 0:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_null);
                break;
            case 1:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot);
                findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
                break;
            case 2:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_body);
                findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
                break;
            case 3:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot_body);
                findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
                break;
            case 4:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_win);
                break;
            case 5:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot_win);
                findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
                break;
            case 6:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_body_win);
                break;
            case 7:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_all);
                break;
            default:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_null);
                break;
        }
    }
}
