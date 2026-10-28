package com.syu.carinfo.cxw.k50;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class CxwK50AirControlAct extends Activity implements View.OnTouchListener {
    public static CxwK50AirControlAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    CxwK50AirControlAct.this.mUpdatePowerOn();
                    break;
                case 11:
                    CxwK50AirControlAct.this.mUpdateAcOn();
                    break;
                case 12:
                    CxwK50AirControlAct.this.mUpdateCycle();
                    break;
                case 21:
                    CxwK50AirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    CxwK50AirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 38:
                    CxwK50AirControlAct.this.mUpdateRearDefrost();
                    break;
                case 77:
                    CxwK50AirControlAct.this.updateBtnSource();
                    break;
            }
        }
    };

    private void sendCmd(int data0) {
        DataCanbus.PROXY.cmd(0, new int[]{data0}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_cxw_k50_air_control);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_blow_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_blow_body_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_blow_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_blow_foot_win).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle_in).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle_out).setOnTouchListener(this);
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
                data0 = 14;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 4;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 3;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 11;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 12;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                data0 = 13;
                break;
            case R.id.air_xts_blow_body /* 2131428142 */:
                data0 = 7;
                break;
            case R.id.air_xts_blow_body_foot /* 2131428143 */:
                data0 = 8;
                break;
            case R.id.air_xts_blow_foot /* 2131428144 */:
                data0 = 9;
                break;
            case R.id.air_xts_blow_foot_win /* 2131428145 */:
                data0 = 10;
                break;
            case R.id.air_xts_cycle_in /* 2131428146 */:
                data0 = 5;
                break;
            case R.id.air_xts_cycle_out /* 2131428147 */:
                data0 = 6;
                break;
        }
        if (event.getAction() == 0) {
            sendCmd(data0);
            return false;
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
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
            } else {
                if (temp == -1) {
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("--");
                    return;
                }
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp + 14) + "°C");
            }
        }
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_cxw_k50_ac_n : R.drawable.ic_cxw_k50_ac_p);
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_air_cxw_k50_power_n : R.drawable.ic_air_cxw_k50_power_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle_in).setBackgroundResource(R.drawable.ic_air_cxw_k50_cyclein_n);
            findViewById(R.id.air_xts_cycle_out).setBackgroundResource(R.drawable.ic_air_cxw_k50_cycleout_p);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle_in).setBackgroundResource(R.drawable.ic_air_cxw_k50_cyclein_p);
            findViewById(R.id.air_xts_cycle_out).setBackgroundResource(R.drawable.ic_air_cxw_k50_cycleout_n);
        }
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[38];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_cxw_k50_rear_n : R.drawable.ic_cxw_k50_rear_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        switch (leave) {
            case 0:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev0);
                break;
            case 1:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev1);
                break;
            case 2:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev2);
                break;
            case 3:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev3);
                break;
            case 4:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev4);
                break;
            case 5:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev5);
                break;
            case 6:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev6);
                break;
            case 7:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev7);
                break;
        }
    }

    
    public void updateBtnSource() {
        int mode = DataCanbus.DATA[77];
        switch (mode) {
            case 0:
                findViewById(R.id.air_xts_blow_body).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_n);
                findViewById(R.id.air_xts_blow_body_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_foot_n);
                findViewById(R.id.air_xts_blow_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_foot_n);
                findViewById(R.id.air_xts_blow_foot_win).setBackgroundResource(R.drawable.ic_air_cxw_k50_win_foot_n);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_cxw_k50_mode_null);
                findViewById(R.id.air_xts_front).setBackgroundResource(R.drawable.ic_cxw_k50_front_n);
                break;
            case 1:
                findViewById(R.id.air_xts_blow_body).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_p);
                findViewById(R.id.air_xts_blow_body_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_foot_n);
                findViewById(R.id.air_xts_blow_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_foot_n);
                findViewById(R.id.air_xts_blow_foot_win).setBackgroundResource(R.drawable.ic_air_cxw_k50_win_foot_n);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_cxw_k50_mode_1);
                findViewById(R.id.air_xts_front).setBackgroundResource(R.drawable.ic_cxw_k50_front_n);
                break;
            case 2:
                findViewById(R.id.air_xts_blow_body).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_n);
                findViewById(R.id.air_xts_blow_body_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_foot_p);
                findViewById(R.id.air_xts_blow_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_foot_n);
                findViewById(R.id.air_xts_blow_foot_win).setBackgroundResource(R.drawable.ic_air_cxw_k50_win_foot_n);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_cxw_k50_mode_2);
                findViewById(R.id.air_xts_front).setBackgroundResource(R.drawable.ic_cxw_k50_front_n);
                break;
            case 3:
                findViewById(R.id.air_xts_blow_body).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_n);
                findViewById(R.id.air_xts_blow_body_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_foot_n);
                findViewById(R.id.air_xts_blow_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_foot_p);
                findViewById(R.id.air_xts_blow_foot_win).setBackgroundResource(R.drawable.ic_air_cxw_k50_win_foot_n);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_cxw_k50_mode_3);
                findViewById(R.id.air_xts_front).setBackgroundResource(R.drawable.ic_cxw_k50_front_n);
                break;
            case 4:
                findViewById(R.id.air_xts_blow_body).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_n);
                findViewById(R.id.air_xts_blow_body_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_foot_n);
                findViewById(R.id.air_xts_blow_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_foot_n);
                findViewById(R.id.air_xts_blow_foot_win).setBackgroundResource(R.drawable.ic_air_cxw_k50_win_foot_p);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_cxw_k50_mode_4);
                findViewById(R.id.air_xts_front).setBackgroundResource(R.drawable.ic_cxw_k50_front_n);
                break;
            case 5:
                findViewById(R.id.air_xts_blow_body).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_n);
                findViewById(R.id.air_xts_blow_body_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_foot_n);
                findViewById(R.id.air_xts_blow_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_foot_n);
                findViewById(R.id.air_xts_blow_foot_win).setBackgroundResource(R.drawable.ic_air_cxw_k50_win_foot_n);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_cxw_k50_mode_null);
                findViewById(R.id.air_xts_front).setBackgroundResource(R.drawable.ic_cxw_k50_front_p);
                break;
        }
    }
}
