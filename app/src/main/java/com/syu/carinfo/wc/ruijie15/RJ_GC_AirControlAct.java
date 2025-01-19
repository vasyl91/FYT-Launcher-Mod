package com.syu.carinfo.wc.ruijie15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;
import com.syu.util.HandlerUI;

public class RJ_GC_AirControlAct extends Activity implements View.OnTouchListener {
    public static RJ_GC_AirControlAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    RJ_GC_AirControlAct.this.mUpdatePowerOn();
                    break;
                case 11:
                    RJ_GC_AirControlAct.this.mUpdateAcOn();
                    break;
                case 12:
                    RJ_GC_AirControlAct.this.mUpdateCycle();
                    break;
                case 13:
                    RJ_GC_AirControlAct.this.mUpdateAutoOn();
                    break;
                case 14:
                    RJ_GC_AirControlAct.this.mUpdateDualOn();
                    break;
                case 15:
                    RJ_GC_AirControlAct.this.mUpdateFrontDefrost();
                    break;
                case 16:
                    RJ_GC_AirControlAct.this.mUpdateRearDefrost();
                    break;
                case 18:
                    RJ_GC_AirControlAct.this.mUpdaterBlowWindow();
                    break;
                case 19:
                    RJ_GC_AirControlAct.this.mUpdaterBlowBodyLeftOn();
                    break;
                case 20:
                    RJ_GC_AirControlAct.this.mUpdaterBlowFootLeftOn();
                    break;
                case 21:
                    RJ_GC_AirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    RJ_GC_AirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    RJ_GC_AirControlAct.this.mUpdateAirTempRight();
                    break;
                case 29:
                    RJ_GC_AirControlAct.this.mUpdaterSeatHeatLeft();
                    break;
                case 30:
                    RJ_GC_AirControlAct.this.mUpdaterSeatHeatRight();
                    break;
                case 31:
                    RJ_GC_AirControlAct.this.mUpdaterSeatColdLeft();
                    break;
                case 32:
                    RJ_GC_AirControlAct.this.mUpdaterSeatColdRight();
                    break;
                case 37:
                    RJ_GC_AirControlAct.this.mUpdateAirTempLeft();
                    RJ_GC_AirControlAct.this.mUpdateAirTempRight();
                    break;
            }
        }
    };

    private void sendCmd(int cmd) {
        DataCanbus.PROXY.cmd(1, new int[]{172, cmd}, null, null);
        HandlerUI.getInstance().postDelayed(new Runnable() { 
            @Override
            public void run() {
                DataCanbus.PROXY.cmd(1, new int[]{172}, null, null);
            }
        }, 100L);
        mInstance = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_18ruijie_air_control);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_win).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearpage).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
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
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_right).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addUpdater();
        RJFunc.C_REQUEST_CAR_INFO(41, 0);
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
        boolean flag = false;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 36;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 35;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 39;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 40;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data0 = 43;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                data0 = 45;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 23;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 3;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 5;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 2;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data0 = 34;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 33;
                break;
            case R.id.air_xts_mode_win /* 2131427445 */:
                data0 = 32;
                break;
            case R.id.air_xts_rearpage /* 2131427448 */:
                flag = true;
                try {
                    startActivity(new Intent(this, (Class<?>) RuiJieRearAirControlAct_XP.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 38;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 37;
                break;
            case R.id.air_xts_seatwin_left /* 2131427452 */:
                data0 = 44;
                break;
            case R.id.air_xts_seatwin_right /* 2131427454 */:
                data0 = 46;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                data0 = 6;
                break;
            case R.id.air_xts_dual /* 2131427566 */:
                data0 = 24;
                break;
        }
        if (!flag && event.getAction() == 0) {
            sendCmd(data0);
            return false;
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterSeatColdRight() {
        int value = DataCanbus.DATA[32];
        switch (value) {
            case 0:
                ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level0);
                break;
            case 1:
                ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level1);
                break;
            case 2:
                ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level2);
                break;
            case 3:
                ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level3);
                break;
        }
    }

    
    public void mUpdaterSeatHeatRight() {
        int value = DataCanbus.DATA[30];
        switch (value) {
            case 0:
                ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                break;
            case 1:
                ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
                break;
            case 2:
                ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
                break;
            case 3:
                ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                break;
        }
    }

    
    public void mUpdaterSeatColdLeft() {
        int value = DataCanbus.DATA[31];
        switch (value) {
            case 0:
                ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level0);
                break;
            case 1:
                ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level1);
                break;
            case 2:
                ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level2);
                break;
            case 3:
                ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level3);
                break;
        }
    }

    
    public void mUpdaterSeatHeatLeft() {
        int value = DataCanbus.DATA[29];
        switch (value) {
            case 0:
                ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                break;
            case 1:
                ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                break;
            case 2:
                ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
                break;
            case 3:
                ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                break;
        }
    }

    
    public void mUpdateAirTempLeft() {
        int value = DataCanbus.DATA[27];
        if (value == 1048576) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
            return;
        }
        if (value == 1048577) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            return;
        }
        if (value == 1048578) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText("None");
        } else if (DataCanbus.DATA[37] == 0) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(value * 0.1f) + "℃");
        } else if (DataCanbus.DATA[37] == 1) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(value / 10) + "℉");
        }
    }

    
    public void mUpdateAirTempRight() {
        int value = DataCanbus.DATA[28];
        if (value == 1048576) {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            return;
        }
        if (value == 1048577) {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            return;
        }
        if (value == 1048578) {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText("None");
        } else if (DataCanbus.DATA[37] == 0) {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(value * 0.1f) + "℃");
        } else if (DataCanbus.DATA[37] == 1) {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(value / 10) + "℉");
        }
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[14];
        findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
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
        int front = DataCanbus.DATA[15];
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

    
    public void mUpdaterBlowBodyLeftOn() {
        int acOn = DataCanbus.DATA[19];
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
    }

    
    public void mUpdaterBlowFootLeftOn() {
        int acOn = DataCanbus.DATA[20];
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
    }

    
    public void mUpdaterBlowWindow() {
        int acOn = DataCanbus.DATA[18];
        findViewById(R.id.air_xts_mode_win).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
    }
}
