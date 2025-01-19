package com.syu.carinfo.dj.dodge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class RZCDodgeFrontAirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 42:
                    RZCDodgeFrontAirControlAct.this.mUpdateAutoOn();
                    break;
                case 43:
                    RZCDodgeFrontAirControlAct.this.mUpdateCycle();
                    break;
                case 44:
                    RZCDodgeFrontAirControlAct.this.mUpdateAirFrontDefrost();
                    break;
                case 45:
                    RZCDodgeFrontAirControlAct.this.mUpdateRearDefrost();
                    break;
                case 46:
                    RZCDodgeFrontAirControlAct.this.mUpdateAcOn();
                    break;
                case 47:
                    RZCDodgeFrontAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 48:
                case 49:
                case 50:
                    RZCDodgeFrontAirControlAct.this.updateBtnSource();
                    break;
                case 51:
                    RZCDodgeFrontAirControlAct.this.mUpdateMaxAcOn();
                    break;
                case 52:
                    RZCDodgeFrontAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 53:
                    RZCDodgeFrontAirControlAct.this.mUpdaterSeatHeatLeft();
                    break;
                case 54:
                    RZCDodgeFrontAirControlAct.this.mUpdaterSeatHeatRight();
                    break;
                case 55:
                    RZCDodgeFrontAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 56:
                    RZCDodgeFrontAirControlAct.this.mUpdatePowerOn();
                    break;
                case 59:
                    RZCDodgeFrontAirControlAct.this.mUpdateDualOn();
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
        //setContentView(R.layout.layout_0373_rzc_dodge_jcuv_air_control);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnTouchListener(this);
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
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_sync).setOnTouchListener(this);
        findViewById(R.id.air_xts_maxac).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearpage).setOnTouchListener(this);
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
        boolean flag = false;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 31;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 30;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                if (DataCanbus.DATA[56] == 1) {
                    data0 = 10;
                    break;
                } else {
                    data0 = 9;
                    break;
                }
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 28;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 29;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data0 = 48;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                data0 = 50;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 20;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 19;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 21;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 17;
                break;
            case R.id.air_xts_maxac /* 2131427440 */:
                data0 = 18;
                break;
            case R.id.air_xts_sync /* 2131427441 */:
                data0 = 23;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data0 = 26;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 24;
                break;
            case R.id.air_xts_rearpage /* 2131427448 */:
                flag = true;
                try {
                    startActivity(new Intent(this, RZCDodgeRearAirControlAct.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 33;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 32;
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                data0 = 25;
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                data0 = 27;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data0 = 22;
                break;
        }
        if (!flag) {
            if (event.getAction() == 0) {
                sendCmd(data0, 1);
            } else if (event.getAction() == 1) {
                sendCmd(data0, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterSeatHeatRight() {
        int value = DataCanbus.DATA[54];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
                break;
            case 2:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
                break;
            case 3:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                break;
        }
    }

    
    public void mUpdaterSeatHeatLeft() {
        int value = DataCanbus.DATA[53];
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

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[47];
        int unit = DataCanbus.DATA[57];
        if (findViewById(R.id.tv_air_temp_left) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NONE");
                    break;
                default:
                    if (unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(temp + "℉");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(temp + "℃");
                        break;
                    }
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[55];
        int unit = DataCanbus.DATA[57];
        if (findViewById(R.id.tv_air_temp_right) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NONE");
                    break;
                default:
                    if (unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(temp + "℉");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(temp + "℃");
                        break;
                    }
            }
        }
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[42];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[59];
        findViewById(R.id.air_xts_sync).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
    }

    
    public void mUpdateMaxAcOn() {
        int acOn = DataCanbus.DATA[51];
        findViewById(R.id.air_xts_maxac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[46];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[56];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[43];
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        }
    }

    
    public void mUpdateAirFrontDefrost() {
        int value = DataCanbus.DATA[44];
        findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[45];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[52];
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
        int window = DataCanbus.DATA[50];
        int foot = DataCanbus.DATA[49];
        int body = DataCanbus.DATA[48];
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
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        switch (mode) {
            case 1:
                findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
                break;
            case 2:
                findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
                break;
            case 3:
                findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
                break;
            case 5:
                findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
                break;
        }
    }
}
