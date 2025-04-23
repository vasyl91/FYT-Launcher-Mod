package com.syu.carinfo.rzc.siwei;

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

public class RZCSiWeiAirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 8:
                    RZCSiWeiAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 9:
                    RZCSiWeiAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 13:
                    RZCSiWeiAirControlAct.this.updateModeSource();
                    break;
                case 14:
                    RZCSiWeiAirControlAct.this.mUpdatePowerOn();
                    break;
                case 15:
                    RZCSiWeiAirControlAct.this.mUpdateAcOn();
                    break;
                case 16:
                    RZCSiWeiAirControlAct.this.mUpdateCycle();
                    break;
                case 17:
                    RZCSiWeiAirControlAct.this.mUpdateAutoOn();
                    break;
                case 18:
                    RZCSiWeiAirControlAct.this.mUpdateRearDefrost();
                    break;
                case 19:
                    RZCSiWeiAirControlAct.this.mUpdateFrontDefrost();
                    break;
                case 20:
                    RZCSiWeiAirControlAct.this.mUpdaterSeatHeatLeft();
                    break;
                case 21:
                    RZCSiWeiAirControlAct.this.mUpdaterSeatBlowLeft();
                    break;
                case 22:
                    RZCSiWeiAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1, int data2, int data3, int data4, int data5) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1, data2, data3, data4, data5}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_rzc_18siwei_air_control);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_cycle_outer).setOnTouchListener(this);
        findViewById(R.id.air_cycle_inter).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
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
        int data1 = 0;
        int data2 = 0;
        int data3 = 0;
        int data4 = 0;
        int data5 = 0;
        boolean flag = false;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data3 = 2;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data3 = 1;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 128;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data1 = 1;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data1 = 2;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data5 = 1;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 32;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 16;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 2;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data2 = 8;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data2 = 2;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data4 = 2;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data4 = 1;
                break;
            case R.id.air_xts_seatwin_left /* 2131427452 */:
                data5 = 4;
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                data2 = 4;
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                data2 = 16;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data1 = 4;
                break;
            case R.id.air_cycle_outer /* 2131427557 */:
                if (DataCanbus.DATA[16] == 1) {
                    data2 = 1;
                    break;
                } else {
                    flag = true;
                    break;
                }
            case R.id.air_cycle_inter /* 2131427558 */:
                if (DataCanbus.DATA[16] == 0) {
                    data2 = 1;
                    break;
                } else {
                    flag = true;
                    break;
                }
        }
        if (!flag) {
            if (event.getAction() == 0) {
                sendCmd(data0, data1, data2, data3, data4, data5);
                return false;
            }
            if (event.getAction() == 1) {
                sendCmd(0, 0, 0, 0, 0, 0);
                return false;
            }
            return false;
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterSeatHeatLeft() {
        int value = DataCanbus.DATA[20];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                break;
            case 2:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
                break;
            case 3:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                break;
        }
    }

    
    public void mUpdaterSeatBlowLeft() {
        int value = DataCanbus.DATA[21];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level1);
                break;
            case 2:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level2);
                break;
            case 3:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level3);
                break;
        }
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[8];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                return;
            }
            if (DataCanbus.DATA[1000] == 11338180) {
                if (temp >= 36 && temp <= 50) {
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp - 36) + 18) * 1.0f) + "℃");
                    return;
                } else {
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("No");
                    return;
                }
            }
            if (temp >= 30 && temp <= 70) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 0.5f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("No");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[9];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                return;
            }
            if (DataCanbus.DATA[1000] == 11338180) {
                if (temp >= 36 && temp <= 50) {
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((temp - 36) + 18) * 1.0f) + "℃");
                    return;
                } else {
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("No");
                    return;
                }
            }
            if (temp >= 30 && temp <= 70) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 0.5f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("No");
            }
        }
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[17];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[15];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[14];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[16];
        if (((Button) findViewById(R.id.air_cycle_outer)) != null) {
            ((Button) findViewById(R.id.air_cycle_outer)).setBackgroundResource(cycle == 0 ? R.drawable.ic_xts_cycle_out_p : R.drawable.ic_xts_cycle_n);
        }
        if (((Button) findViewById(R.id.air_cycle_inter)) != null) {
            ((Button) findViewById(R.id.air_cycle_inter)).setBackgroundResource(cycle == 1 ? R.drawable.ic_cycle_all_p : R.drawable.ic_cycle_all_n);
        }
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[19];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[18];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[22];
        if (leave < 0) {
            leave = 0;
        }
        if (leave > 8) {
            leave = 8;
        }
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }

    
    public void updateModeSource() {
        int mode = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        switch (mode) {
            case 1:
                findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
                break;
            case 2:
                findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
                break;
            case 3:
                findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
                break;
            case 4:
                findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
                break;
        }
    }
}
