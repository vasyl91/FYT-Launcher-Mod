package com.syu.carinfo.dj.huangguan;

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

public class dj_429_crown_AirControlAct extends Activity implements View.OnTouchListener {
    public static dj_429_crown_AirControlAct mInstance;
    public static boolean mIsFront = false;
    int cmdId = -1;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 11:
                    dj_429_crown_AirControlAct.this.mUpdaterAirPower();
                    break;
                case 12:
                    dj_429_crown_AirControlAct.this.mUpdaterAirAC();
                    break;
                case 13:
                    dj_429_crown_AirControlAct.this.mUpdateAirCycle();
                    break;
                case 14:
                    dj_429_crown_AirControlAct.this.mUpdateAirAuto();
                    break;
                case 15:
                    dj_429_crown_AirControlAct.this.mUpdateAirdual();
                    break;
                case 21:
                    dj_429_crown_AirControlAct.this.mUpdateAirBlow();
                    break;
                case 22:
                    dj_429_crown_AirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 23:
                    dj_429_crown_AirControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 24:
                    dj_429_crown_AirControlAct.this.mUpdaterAirTempRight();
                    break;
                case 25:
                    dj_429_crown_AirControlAct.this.mUpdateAirFrontDefrost();
                    break;
                case 26:
                    dj_429_crown_AirControlAct.this.mUpdateAirRearDefrost();
                    break;
                case 66:
                    dj_429_crown_AirControlAct.this.mUpdaterAirClean();
                    break;
                case 67:
                    dj_429_crown_AirControlAct.this.mUpdaterAirCleanFlower();
                    break;
                case 68:
                    dj_429_crown_AirControlAct.this.mUpdaterAirCleanIce();
                    break;
                case 69:
                    dj_429_crown_AirControlAct.this.mUpdaterAirCleanSwing();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0429_dj_toyota_crown_carairset);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_cycle_outer).setOnTouchListener(this);
        findViewById(R.id.air_cycle_inter).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_clear).setOnTouchListener(this);
        findViewById(R.id.air_xts_ion).setOnTouchListener(this);
        findViewById(R.id.air_xts_front_hot).setOnTouchListener(this);
        findViewById(R.id.air_xts_front_blow_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode).setOnTouchListener(this);
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                this.cmdId = 12;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                this.cmdId = 13;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                this.cmdId = 10;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                this.cmdId = 7;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                this.cmdId = 6;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
                this.cmdId = 9;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                this.cmdId = 1;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                this.cmdId = 4;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                this.cmdId = 8;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                this.cmdId = 14;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                this.cmdId = 15;
                break;
            case R.id.air_xts_dual /* 2131427460 */:
                this.cmdId = 2;
                break;
            case R.id.air_xts_clear /* 2131427465 */:
                this.cmdId = 38;
                break;
            case R.id.air_xts_front_hot /* 2131427466 */:
                this.cmdId = 41;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                this.cmdId = 5;
                break;
            case R.id.air_cycle_outer /* 2131427557 */:
                if (DataCanbus.DATA[13] == 1) {
                    this.cmdId = 3;
                    break;
                }
            case R.id.air_cycle_inter /* 2131427558 */:
                if (DataCanbus.DATA[13] == 0) {
                    this.cmdId = 3;
                    break;
                }
            case R.id.air_xts_ion /* 2131427559 */:
                this.cmdId = 39;
                break;
            case R.id.air_xts_front_blow_auto /* 2131427560 */:
                this.cmdId = 40;
                break;
        }
        if (this.cmdId != -1) {
            switch (event.getAction()) {
                case 0:
                    DataCanbus.PROXY.cmd(3, new int[]{this.cmdId, 1}, null, null);
                    break;
                case 1:
                    DataCanbus.PROXY.cmd(3, new int[]{this.cmdId}, null, null);
                    break;
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAirClean() {
        int value = DataCanbus.DATA[66];
        findViewById(R.id.air_xts_clear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_clear_air_n : R.drawable.ic_xts_clear_air_p);
    }

    
    public void mUpdaterAirCleanFlower() {
        int value = DataCanbus.DATA[67];
        findViewById(R.id.air_xts_ion).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ion_n : R.drawable.ic_xts_ion_p);
    }

    
    public void mUpdaterAirCleanIce() {
        int value = DataCanbus.DATA[68];
        findViewById(R.id.air_xts_front_hot).setBackgroundResource(value == 0 ? R.drawable.ic_xts_fronthot_n : R.drawable.ic_xts_fronthot_p);
    }

    
    public void mUpdaterAirCleanSwing() {
        int value = DataCanbus.DATA[69];
        findViewById(R.id.air_xts_front_blow_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_blow_auto_n : R.drawable.ic_xts_blow_auto_p);
    }

    
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[23];
        if (findViewById(R.id.tv_air_temp_left) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("--");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 2.0f) + "℃");
                    break;
            }
        }
    }

    
    public void mUpdaterAirTempRight() {
        int temp = DataCanbus.DATA[24];
        if (findViewById(R.id.tv_air_temp_right) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("--");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 2.0f) + "℃");
                    break;
            }
        }
    }

    
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[22];
        if (level >= 0 && level <= 7) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(String.valueOf(level));
        }
    }

    
    public void mUpdateAirAuto() {
        int value = DataCanbus.DATA[14];
        findViewById(R.id.air_xts_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateAirdual() {
        int value = DataCanbus.DATA[15];
        findViewById(R.id.air_xts_dual).setBackgroundResource(value == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
    }

    
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[13];
        if (findViewById(R.id.air_cycle_outer) != null) {
            findViewById(R.id.air_cycle_outer).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_out_p : R.drawable.ic_xts_cycle_n);
        }
        if (findViewById(R.id.air_cycle_inter) != null) {
            findViewById(R.id.air_cycle_inter).setBackgroundResource(value == 1 ? R.drawable.ic_cycle_all_p : R.drawable.ic_cycle_all_n);
        }
    }

    
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[12];
        findViewById(R.id.air_xts_ac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_power).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdateAirFrontDefrost() {
        int value = DataCanbus.DATA[25];
        findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[26];
        findViewById(R.id.air_xts_rear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    
    public void mUpdateAirBlow() {
        int value = DataCanbus.DATA[21];
        if (value == 3) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
            return;
        }
        if (value == 5) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
            return;
        }
        if (value == 2) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body);
            return;
        }
        if (value == 1) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot);
        } else if (value == 4) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_win);
        } else {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
        }
    }
}
