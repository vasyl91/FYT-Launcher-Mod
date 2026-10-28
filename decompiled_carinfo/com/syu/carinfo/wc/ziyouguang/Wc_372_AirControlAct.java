package com.syu.carinfo.wc.ziyouguang;

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
public class Wc_372_AirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 34:
                    Wc_372_AirControlAct.this.mUpdaterAirTempLeft();
                    Wc_372_AirControlAct.this.mUpdaterAirTempRight();
                    break;
                case 38:
                    Wc_372_AirControlAct.this.mUpdateAirBlowBodyFoot();
                    break;
                case 39:
                    Wc_372_AirControlAct.this.mUpdateAirBlowFootFront();
                    break;
                case 40:
                    Wc_372_AirControlAct.this.mUpdateAirBlowFoot();
                    break;
                case 41:
                    Wc_372_AirControlAct.this.mUpdateAirBlowBody();
                    break;
                case 58:
                    Wc_372_AirControlAct.this.mUpdateAirAuto();
                    break;
                case 59:
                    Wc_372_AirControlAct.this.mUpdateAirCycle();
                    break;
                case 60:
                    Wc_372_AirControlAct.this.mUpdateAirFrontDefrost();
                    break;
                case 61:
                    Wc_372_AirControlAct.this.mUpdateAirRearDefrost();
                    break;
                case 62:
                    Wc_372_AirControlAct.this.mUpdaterAirAC();
                    break;
                case 63:
                    Wc_372_AirControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 67:
                    Wc_372_AirControlAct.this.mUpdateAirGoFog();
                    break;
                case 68:
                    Wc_372_AirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 69:
                    Wc_372_AirControlAct.this.mUpdaterAirSeatHeatLeft();
                    break;
                case 70:
                    Wc_372_AirControlAct.this.mUpdaterAirSeatHeatRight();
                    break;
                case 71:
                    Wc_372_AirControlAct.this.mUpdaterAirTempRight();
                    break;
                case 72:
                    Wc_372_AirControlAct.this.mUpdaterAirPower();
                    break;
                case 76:
                    Wc_372_AirControlAct.this.mUpdateAirSYNC();
                    break;
                case 77:
                    Wc_372_AirControlAct.this.mUpdaterAirDimRear();
                    break;
                case 87:
                    Wc_372_AirControlAct.this.mUpdateAirBlowmode();
                    break;
                case 131:
                    Wc_372_AirControlAct.this.mUpdateAirSteerHot();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_372_jeep_carairset);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_sync).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearlock).setOnTouchListener(this);
        findViewById(R.id.air_xts_steer_hot).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_win).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_maxac).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
        removeUpdater();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 13;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 14;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 12;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 11;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data0 = 17;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                data0 = 18;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 4;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 7;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 5;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 2;
                break;
            case R.id.air_xts_maxac /* 2131427440 */:
                data0 = 21;
                break;
            case R.id.air_xts_sync /* 2131427441 */:
                data0 = 3;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data0 = 10;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 9;
                break;
            case R.id.air_xts_mode_win /* 2131427445 */:
                data0 = 8;
                break;
            case R.id.air_xts_rearlock /* 2131427446 */:
                data0 = 22;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 15;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 16;
                break;
            case R.id.air_xts_steer_hot /* 2131427453 */:
                data0 = 45;
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                data0 = 24;
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                data0 = 23;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data0 = 6;
                break;
        }
        if (event.getAction() == 0) {
            DataCanbus.PROXY.cmd(0, new int[]{data0, 1}, null, null);
        } else if (event.getAction() == 1) {
            DataCanbus.PROXY.cmd(0, new int[]{data0}, null, null);
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[63];
        int unit = DataCanbus.DATA[34] & 255;
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                case -1:
                default:
                    if (unit == 2) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "℉");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "℃");
                        break;
                    }
                case 0:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NO");
                    break;
            }
        }
    }

    
    public void mUpdaterAirTempRight() {
        int temp = DataCanbus.DATA[71];
        int unit = DataCanbus.DATA[34] & 255;
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                    break;
                case -1:
                default:
                    if (unit == 2) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "℉");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "℃");
                        break;
                    }
                case 0:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NO");
                    break;
            }
        }
    }

    
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[68];
        if (level >= 8) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText("A");
        } else {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
        }
    }

    
    public void mUpdateAirBlowmode() {
        int value = DataCanbus.DATA[87];
        findViewById(R.id.air_xts_mode_win).setBackgroundResource(value == 11 ? R.drawable.ic_xts_mode_win_p : R.drawable.ic_xts_mode_win_n);
    }

    
    public void mUpdateAirSteerHot() {
        int value = DataCanbus.DATA[131];
        findViewById(R.id.air_xts_steer_hot).setBackgroundResource(value == 0 ? R.drawable.ic_xts_steer_hot_n : R.drawable.ic_xts_steer_hot_p);
    }

    
    public void mUpdateAirGoFog() {
        int value = DataCanbus.DATA[67];
        findViewById(R.id.air_xts_maxac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
    }

    
    public void mUpdateAirAuto() {
        int value = DataCanbus.DATA[58];
        findViewById(R.id.air_xts_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateAirSYNC() {
        int value = DataCanbus.DATA[76];
        findViewById(R.id.air_xts_sync).setBackgroundResource(value == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
    }

    
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[59];
        findViewById(R.id.air_xts_cycle).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_n : R.drawable.ic_xts_cycle_p);
    }

    
    public void mUpdaterAirDimRear() {
        int value = DataCanbus.DATA[77];
        findViewById(R.id.air_xts_rearlock).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rearlock_n : R.drawable.ic_xts_rearlock_p);
    }

    
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[62];
        findViewById(R.id.air_xts_ac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdateAirFrontDefrost() {
        int value = DataCanbus.DATA[60];
        findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[61];
        findViewById(R.id.air_xts_rear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    
    public void mUpdateAirBlowBody() {
        int value = DataCanbus.DATA[41];
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
    }

    
    public void mUpdateAirBlowBodyFoot() {
        int value = DataCanbus.DATA[38];
        findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_footbody_n : R.drawable.ic_xts_mode_footbody_p);
    }

    
    public void mUpdateAirBlowFoot() {
        int value = DataCanbus.DATA[40];
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
    }

    
    public void mUpdateAirBlowFootFront() {
        int value = DataCanbus.DATA[39];
        findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_footwin_n : R.drawable.ic_xts_mode_footwin_p);
    }

    
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[72];
        findViewById(R.id.air_xts_power).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdaterAirSeatHeatLeft() {
        int value = DataCanbus.DATA[69];
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

    
    public void mUpdaterAirSeatHeatRight() {
        int value = DataCanbus.DATA[70];
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
}
