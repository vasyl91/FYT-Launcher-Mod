package com.syu.carinfo.lz.jaguar;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class JaguarAirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    JaguarAirControlAct.this.mUpdatePowerOn();
                    break;
                case 11:
                    JaguarAirControlAct.this.mUpdateAcOn();
                    break;
                case 12:
                    JaguarAirControlAct.this.mUpdateCycle();
                    break;
                case 13:
                    JaguarAirControlAct.this.mUpdateAutoOn();
                    break;
                case 16:
                    JaguarAirControlAct.this.mUpdateRearDefrost();
                    break;
                case 18:
                    JaguarAirControlAct.this.mUpdateFrontDefrost();
                    JaguarAirControlAct.this.updateBtnSource();
                    break;
                case 19:
                case 20:
                    JaguarAirControlAct.this.updateBtnSource();
                    break;
                case 21:
                    JaguarAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    JaguarAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    JaguarAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 29:
                    JaguarAirControlAct.this.mUpdaterSeatHeatOrWinLeft();
                    break;
                case 30:
                    JaguarAirControlAct.this.mUpdaterSeatHeatOrWinRight();
                    break;
                case 52:
                    JaguarAirControlAct.this.mUpdateEconOn();
                    break;
                case 65:
                    JaguarAirControlAct.this.mUpdateFrontDefrost();
                    break;
                case 66:
                    JaguarAirControlAct.this.mUpdateSteerHotOn();
                    break;
                case 73:
                    JaguarAirControlAct.this.mUpdateAutoLev();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_lz_jaguar_air_control);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_bodywin).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footbodywin).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnTouchListener(this);
        findViewById(R.id.air_xts_econ).setOnTouchListener(this);
        findViewById(R.id.air_xts_autolev).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_steer_hot).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_right).setOnTouchListener(this);
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
                data0 = 1;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 2;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 11;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 6;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 5;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data0 = 19;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                data0 = 20;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 10;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 9;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 12;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 8;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 14;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 3;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 4;
                break;
            case R.id.air_xts_seatwin_left /* 2131427452 */:
                data0 = 30;
                break;
            case R.id.air_xts_steer_hot /* 2131427453 */:
                data0 = 21;
                break;
            case R.id.air_xts_seatwin_right /* 2131427454 */:
                data0 = 31;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                data0 = 13;
                break;
            case R.id.air_xts_econ /* 2131427567 */:
                data0 = 22;
                break;
            case R.id.air_xts_mode_footwin /* 2131427632 */:
                data0 = 17;
                break;
            case R.id.air_xts_autolev /* 2131428573 */:
                data0 = 23;
                break;
            case R.id.air_xts_mode_bodywin /* 2131428574 */:
                data0 = 15;
                break;
            case R.id.air_xts_mode_footbodywin /* 2131428575 */:
                data0 = 16;
                break;
        }
        if (event.getAction() == 0) {
            sendCmd(8, data0);
        } else if (event.getAction() == 1) {
            sendCmd(8, 0);
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterSeatHeatOrWinRight() {
        int value = DataCanbus.DATA[30];
        int flag = 0;
        if (((value >> 3) & 1) == 1) {
            flag = 1;
            value = 16 - value;
        }
        if (flag == 1) {
            switch (value) {
                case 1:
                    findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level1);
                    findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                    break;
                case 2:
                    findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level2);
                    findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                    break;
                case 3:
                    findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level3);
                    findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                    break;
            }
        }
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level0);
                break;
            case 2:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level0);
                break;
            case 3:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level0);
                break;
        }
    }

    
    public void mUpdaterSeatHeatOrWinLeft() {
        int value = DataCanbus.DATA[29];
        int flag = 0;
        if (((value >> 3) & 1) == 1) {
            flag = 1;
            value = 16 - value;
        }
        if (flag == 1) {
            switch (value) {
                case 1:
                    findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level1);
                    findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                    break;
                case 2:
                    findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level2);
                    findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                    break;
                case 3:
                    findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level3);
                    findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                    break;
            }
        }
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level0);
                break;
            case 2:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level0);
                break;
            case 3:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level0);
                break;
        }
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        if (findViewById(R.id.tv_air_temp_left) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 0.5f) + "°C");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[28];
        if (findViewById(R.id.tv_air_temp_right) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 0.5f) + "°C");
            }
        }
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdateEconOn() {
        int power = DataCanbus.DATA[52];
        findViewById(R.id.air_xts_econ).setBackgroundResource(power == 0 ? R.drawable.ic_xts_econ_n : R.drawable.ic_xts_econ_p);
    }

    
    public void mUpdateAutoLev() {
        int lev = DataCanbus.DATA[73];
        switch (lev) {
            case 0:
                findViewById(R.id.air_xts_autolev).setBackgroundResource(R.drawable.ic_xts_auto_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_autolev).setBackgroundResource(R.drawable.ic_xts_auto_level1);
                break;
            case 2:
                findViewById(R.id.air_xts_autolev).setBackgroundResource(R.drawable.ic_xts_auto_level2);
                break;
            case 3:
                findViewById(R.id.air_xts_autolev).setBackgroundResource(R.drawable.ic_xts_auto_level3);
                break;
            case 4:
                findViewById(R.id.air_xts_autolev).setBackgroundResource(R.drawable.ic_xts_auto_level4);
                break;
            case 5:
                findViewById(R.id.air_xts_autolev).setBackgroundResource(R.drawable.ic_xts_auto_level5);
                break;
        }
    }

    
    public void mUpdateSteerHotOn() {
        int power = DataCanbus.DATA[66];
        findViewById(R.id.air_xts_steer_hot).setBackgroundResource(power == 0 ? R.drawable.ic_xts_steer_hot_n : R.drawable.ic_xts_steer_hot_p);
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        }
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[65];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
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
        if (leave > 8) {
            leave = 8;
        }
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }

    
    public void updateBtnSource() {
        int window = DataCanbus.DATA[18];
        int foot = DataCanbus.DATA[20];
        int body = DataCanbus.DATA[19];
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
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        findViewById(R.id.air_xts_mode_bodywin).setBackgroundResource(R.drawable.ic_xts_mode_bodywin_n);
        findViewById(R.id.air_xts_mode_footbodywin).setBackgroundResource(R.drawable.ic_xts_mode_footbodywin_n);
        findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        switch (mode) {
            case 2:
                findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
                break;
            case 5:
                findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
                break;
            case 6:
                findViewById(R.id.air_xts_mode_bodywin).setBackgroundResource(R.drawable.ic_xts_mode_bodywin_p);
                break;
            case 7:
                findViewById(R.id.air_xts_mode_footbodywin).setBackgroundResource(R.drawable.ic_xts_mode_footbodywin_p);
                break;
        }
    }
}
