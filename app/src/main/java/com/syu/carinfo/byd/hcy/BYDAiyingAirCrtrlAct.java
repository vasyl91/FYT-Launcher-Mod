package com.syu.carinfo.byd.hcy;

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

public class BYDAiyingAirCrtrlAct extends Activity implements View.OnTouchListener {
    public static BYDAiyingAirCrtrlAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    BYDAiyingAirCrtrlAct.this.mUpdatePowerOn();
                    break;
                case 11:
                    BYDAiyingAirCrtrlAct.this.mUpdateAcOn();
                    break;
                case 12:
                    BYDAiyingAirCrtrlAct.this.mUpdateCycle();
                    break;
                case 13:
                    BYDAiyingAirCrtrlAct.this.mUpdateAutoOn();
                    break;
                case 14:
                    BYDAiyingAirCrtrlAct.this.mUpdaterDualOn();
                    break;
                case 16:
                    BYDAiyingAirCrtrlAct.this.mUpdateRearDefrost();
                    break;
                case 18:
                    BYDAiyingAirCrtrlAct.this.mUpdateFrontDefrost();
                    BYDAiyingAirCrtrlAct.this.updateBtnSource();
                    break;
                case 19:
                case 20:
                    BYDAiyingAirCrtrlAct.this.updateBtnSource();
                    break;
                case 21:
                    BYDAiyingAirCrtrlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    BYDAiyingAirCrtrlAct.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    BYDAiyingAirCrtrlAct.this.mUpdateAirTempRight();
                    break;
                case 53:
                    BYDAiyingAirCrtrlAct.this.mUpdaterAcMaxOn();
                    break;
                case 65:
                    BYDAiyingAirCrtrlAct.this.mUpdateFrontDefrost();
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
        //setContentView(R.layout.layout_0455_aiying_byd_air_control);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_mode_munits).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_acmax).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
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
                data0 = 3;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 2;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 9;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 10;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data0 = 11;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                data0 = 13;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 21;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 25;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 19;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 23;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 5;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 4;
                break;
            case R.id.air_xts_mode_munits /* 2131427497 */:
                data0 = 7;
                break;
            case R.id.air_xts_mode_plus /* 2131427498 */:
                data0 = 8;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                data0 = 20;
                break;
            case R.id.air_xts_dual /* 2131427566 */:
                data0 = 16;
                break;
            case R.id.air_xts_acmax /* 2131428685 */:
                data0 = 22;
                break;
        }
        if (event.getAction() == 0) {
            sendCmd(data0, 1);
        } else if (event.getAction() == 1) {
            sendCmd(data0, 0);
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
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LO");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NO");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 0.1f) + "°C");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LO");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NO");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 0.1f) + "°C");
            }
        }
    }

    
    public void mUpdaterAcMaxOn() {
        int acOn = DataCanbus.DATA[53];
        findViewById(R.id.air_xts_acmax).setBackgroundResource(acOn == 0 ? R.drawable.ic_ay_byd_acmax_n : R.drawable.ic_ay_byd_acmax_p);
    }

    
    public void mUpdaterDualOn() {
        int acOn = DataCanbus.DATA[14];
        findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 0 ? R.drawable.ic_ay_byd_dual_n : R.drawable.ic_ay_byd_dual_p);
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_ay_byd_auto_n : R.drawable.ic_ay_byd_auto_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_ay_byd_ac_n : R.drawable.ic_ay_byd_ac_p);
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_ay_byd_power_n : R.drawable.ic_ay_byd_power_p);
    }

    private void uSeatHeatR(int val) {
        if (((Button) findViewById(R.id.air_xts_seathot_right)) != null) {
            int i = R.drawable.ic_xts_seathot_right_level0;
            if (val == 1) {
                i = R.drawable.ic_xts_seathot_right_level1;
            } else if (val == 2) {
                i = R.drawable.ic_xts_seathot_right_level2;
            } else if (val == 3) {
                i = R.drawable.ic_xts_seathot_right_level3;
            }
            ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(i);
        }
    }

    private void uSeatHeatL(int val) {
        if (((Button) findViewById(R.id.air_xts_seathot_left)) != null) {
            int i = R.drawable.ic_xts_seathot_left_level0;
            if (val == 1) {
                i = R.drawable.ic_xts_seathot_left_level1;
            } else if (val == 2) {
                i = R.drawable.ic_xts_seathot_left_level2;
            } else if (val == 3) {
                i = R.drawable.ic_xts_seathot_left_level3;
            }
            ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(i);
        }
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_ay_byd_cycle_n);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_ay_byd_cycle_p);
        }
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[18];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_ay_byd_front_n : R.drawable.ic_ay_byd_front_p);
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_ay_byd_rear_n : R.drawable.ic_ay_byd_rear_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        switch (leave) {
            case 0:
                findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_ay_byd_winlev_0);
                break;
            case 1:
                findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_ay_byd_winlev_1);
                break;
            case 2:
                findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_ay_byd_winlev_2);
                break;
            case 3:
                findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_ay_byd_winlev_3);
                break;
            case 4:
                findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_ay_byd_winlev_4);
                break;
            case 5:
                findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_ay_byd_winlev_5);
                break;
            case 6:
                findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_ay_byd_winlev_6);
                break;
            case 7:
                findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_ay_byd_winlev_7);
                break;
        }
    }

    
    public void updateBtnSource() {
        int up = DataCanbus.DATA[18];
        int foot = DataCanbus.DATA[20];
        int body = DataCanbus.DATA[19];
        findViewById(R.id.air_sp_mode_up).setVisibility(up == 1 ? 0 : 8);
        findViewById(R.id.air_sp_mode_body).setVisibility(body == 1 ? 0 : 8);
        findViewById(R.id.air_sp_mode_foot).setVisibility(foot != 1 ? 8 : 0);
    }
}
