package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class PAToyota10TundraAirControlAct_SP extends Activity implements View.OnTouchListener {
    public static PAToyota10TundraAirControlAct_SP mInstance;
    public static boolean mIsFront = false;
    int pagenum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                case 42:
                    PAToyota10TundraAirControlAct_SP.this.mUpdatePowerOn();
                    break;
                case 11:
                    PAToyota10TundraAirControlAct_SP.this.mUpdateAcOn();
                    break;
                case 12:
                    PAToyota10TundraAirControlAct_SP.this.mUpdateCycle();
                    break;
                case 13:
                    PAToyota10TundraAirControlAct_SP.this.mUpdateAutoOn();
                    break;
                case 14:
                    PAToyota10TundraAirControlAct_SP.this.mUpdateSyncOn();
                    break;
                case 15:
                    PAToyota10TundraAirControlAct_SP.this.mUpdateFrontDefrost();
                    break;
                case 16:
                    PAToyota10TundraAirControlAct_SP.this.mUpdateRearDefrost();
                    break;
                case 18:
                case 19:
                case 20:
                    PAToyota10TundraAirControlAct_SP.this.updateBtnSource();
                    break;
                case 21:
                    PAToyota10TundraAirControlAct_SP.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    PAToyota10TundraAirControlAct_SP.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    PAToyota10TundraAirControlAct_SP.this.mUpdateAirTempRight();
                    break;
                case 29:
                    PAToyota10TundraAirControlAct_SP.this.mUpdaterSeatHeatLeft();
                    break;
                case 30:
                    PAToyota10TundraAirControlAct_SP.this.mUpdaterSeatHeatRight();
                    break;
                case 31:
                    PAToyota10TundraAirControlAct_SP.this.mUpdaterSeatBlowLeft();
                    break;
                case 32:
                    PAToyota10TundraAirControlAct_SP.this.mUpdaterSeatBlowRight();
                    break;
                case 37:
                    PAToyota10TundraAirControlAct_SP.this.mUpdateAirTempLeft();
                    PAToyota10TundraAirControlAct_SP.this.mUpdateAirTempRight();
                    PAToyota10TundraAirControlAct_SP.this.mUpdateAirTempRear();
                    PAToyota10TundraAirControlAct_SP.this.mUpdateAirTempRearRight();
                    break;
                case 40:
                    PAToyota10TundraAirControlAct_SP.this.mUpdateAirTempRear();
                    break;
                case 41:
                    PAToyota10TundraAirControlAct_SP.this.mUpdateAirTempRearRight();
                    break;
                case 43:
                    PAToyota10TundraAirControlAct_SP.this.mUpdateRearAutoOn();
                    break;
                case 44:
                    PAToyota10TundraAirControlAct_SP.this.mUpdaterAirWindLevelRear();
                    break;
                case 46:
                case 47:
                    PAToyota10TundraAirControlAct_SP.this.updateBtnSourceRear();
                    break;
                case 53:
                    PAToyota10TundraAirControlAct_SP.this.mUpdateMaxAcOn();
                    break;
                case 67:
                    PAToyota10TundraAirControlAct_SP.this.mUpdateRearLockOn();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(22, new int[]{data0, data1}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_toyota_10tundra_air_sp);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.tv_sp_front).setOnTouchListener(this);
        findViewById(R.id.tv_sp_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_steer_hot).setOnTouchListener(this);
        findViewById(R.id.air_xts_maxac).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_right).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_plus).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_munits).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearlock).setOnTouchListener(this);
        findViewById(R.id.air_pa_jeep_auto_rear).setOnTouchListener(this);
        findViewById(R.id.air_pa_jeep_temp_left_plus_rear).setOnTouchListener(this);
        findViewById(R.id.air_pa_jeep_temp_left_munits_rear).setOnTouchListener(this);
        findViewById(R.id.air_pa_jeep_temp_right_plus_rear).setOnTouchListener(this);
        findViewById(R.id.air_pa_jeep_temp_right_munits_rear).setOnTouchListener(this);
        findViewById(R.id.air_pa_jeep_mode_rear_plus).setOnTouchListener(this);
        findViewById(R.id.air_pa_jeep_wind_minuts_rear).setOnTouchListener(this);
        findViewById(R.id.air_pa_jeep_wind_plus_rear).setOnTouchListener(this);
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
                if (this.pagenum == 1) {
                    data0 = 44;
                    break;
                } else {
                    data0 = 1;
                    break;
                }
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
            case R.id.air_xts_rearlock /* 2131427446 */:
                data0 = 42;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 5;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 4;
                break;
            case R.id.air_xts_seatwin_left /* 2131427452 */:
                data0 = 12;
                break;
            case R.id.air_xts_seatwin_right /* 2131427454 */:
                data0 = 14;
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
            case R.id.tv_sp_front /* 2131427932 */:
                this.pagenum = 0;
                findViewById(R.id.veiw_air_front).setVisibility(0);
                findViewById(R.id.veiw_air_rear).setVisibility(8);
                ((TextView) findViewById(R.id.tv_sp_front)).setTextColor(Color.parseColor("#ffffff"));
                ((TextView) findViewById(R.id.tv_sp_rear)).setTextColor(Color.parseColor("#666666"));
                mUpdatePowerOn();
                break;
            case R.id.tv_sp_rear /* 2131427933 */:
                this.pagenum = 1;
                findViewById(R.id.veiw_air_front).setVisibility(8);
                findViewById(R.id.veiw_air_rear).setVisibility(0);
                ((TextView) findViewById(R.id.tv_sp_front)).setTextColor(Color.parseColor("#666666"));
                ((TextView) findViewById(R.id.tv_sp_rear)).setTextColor(Color.parseColor("#ffffff"));
                mUpdatePowerOn();
                break;
            case R.id.air_pa_jeep_auto_rear /* 2131427940 */:
                data0 = 45;
                break;
            case R.id.air_pa_jeep_temp_left_plus_rear /* 2131427941 */:
                data0 = 39;
                break;
            case R.id.air_pa_jeep_temp_left_munits_rear /* 2131427943 */:
                data0 = 38;
                break;
            case R.id.air_pa_jeep_temp_right_plus_rear /* 2131427945 */:
                data0 = 66;
                break;
            case R.id.air_pa_jeep_temp_right_munits_rear /* 2131427947 */:
                data0 = 65;
                break;
            case R.id.air_pa_jeep_wind_minuts_rear /* 2131427951 */:
                data0 = 40;
                break;
            case R.id.air_pa_jeep_wind_plus_rear /* 2131427953 */:
                data0 = 41;
                break;
            case R.id.air_pa_jeep_mode_rear_plus /* 2131428019 */:
                data0 = 43;
                break;
        }
        if (data0 != 0) {
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
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[15];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_air_pa_jeep_front_n : R.drawable.ic_air_pa_jeep_front_p);
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_air_pa_jeep_rear_n : R.drawable.ic_air_pa_jeep_rear_p);
    }

    
    public void mUpdaterSeatBlowRight() {
        int value = DataCanbus.DATA[32];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_seatwin_right0);
                break;
            case 1:
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_seatwin_right1);
                break;
            case 2:
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_seatwin_right2);
                break;
            case 3:
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_seatwin_right3);
                break;
        }
    }

    
    public void mUpdaterSeatHeatRight() {
        int value = DataCanbus.DATA[30];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_seathot_right0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_seathot_right1);
                break;
            case 2:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_seathot_right2);
                break;
            case 3:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_air_pa_jeep_seathot_right3);
                break;
        }
    }

    
    public void mUpdaterSeatHeatLeft() {
        int value = DataCanbus.DATA[29];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_air_pa_jeep_seathot_left0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_air_pa_jeep_seathot_left1);
                break;
            case 2:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_air_pa_jeep_seathot_left2);
                break;
            case 3:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_air_pa_jeep_seathot_left3);
                break;
        }
    }

    
    public void mUpdaterSeatBlowLeft() {
        int value = DataCanbus.DATA[31];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_air_pa_jeep_seatwin_left0);
                break;
            case 1:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_air_pa_jeep_seatwin_left1);
                break;
            case 2:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_air_pa_jeep_seatwin_left2);
                break;
            case 3:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_air_pa_jeep_seatwin_left3);
                break;
        }
    }

    
    public void mUpdateMaxAcOn() {
        int power = DataCanbus.DATA[53];
        findViewById(R.id.air_xts_maxac).setBackgroundResource(power == 0 ? R.drawable.ic_air_pa_jeep_maxac_n : R.drawable.ic_air_pa_jeep_maxac_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_air_pa_jeep_cyclein_n);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_air_pa_jeep_cyclein_p);
        }
    }

    
    public void mUpdateSyncOn() {
        int acOn = DataCanbus.DATA[14];
        findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_pa_jeep_dual_n : R.drawable.ic_air_pa_jeep_dual_p);
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_pa_jeep_auto_n : R.drawable.ic_air_pa_jeep_auto_p);
    }

    
    public void mUpdateRearLockOn() {
        int acOn = DataCanbus.DATA[67];
        findViewById(R.id.air_xts_rearlock).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_pa_jeep_rearlock_n : R.drawable.ic_air_pa_jeep_rearlock_p);
    }

    
    public void mUpdateRearAutoOn() {
        int acOn = DataCanbus.DATA[43];
        findViewById(R.id.air_pa_jeep_auto_rear).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_pa_jeep_rearauto_n : R.drawable.ic_air_pa_jeep_rearauto_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_pa_jeep_ac_n : R.drawable.ic_air_pa_jeep_ac_p);
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[10];
        if (this.pagenum == 1) {
            power = DataCanbus.DATA[42];
        }
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_air_pa_jeep_power_n : R.drawable.ic_air_pa_jeep_power_p);
    }

    
    public void mUpdateAirTempRear() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[40];
        if (((TextView) findViewById(R.id.air_pa_jeep_temp_left_rear)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_left_rear)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_left_rear)).setText("HIGH");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_left_rear)).setText("---");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_left_rear)).setText((temp * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_left_rear)).setText(temp + "℉");
            }
        }
    }

    
    public void mUpdateAirTempRearRight() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[41];
        if (((TextView) findViewById(R.id.air_pa_jeep_temp_right_rear)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_right_rear)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_right_rear)).setText("HIGH");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_right_rear)).setText("---");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_right_rear)).setText((temp * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.air_pa_jeep_temp_right_rear)).setText(temp + "℉");
            }
        }
    }

    
    public void mUpdateAirTempLeft() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HIGH");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("---");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(temp + "℉");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HIGH");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("---");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(temp + "℉");
            }
        }
    }

    
    public void mUpdaterAirWindLevelRear() {
        int leave = DataCanbus.DATA[44];
        switch (leave) {
            case 0:
                findViewById(R.id.air_pa_jeep_wind_lev_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind0);
                break;
            case 1:
                findViewById(R.id.air_pa_jeep_wind_lev_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind1);
                break;
            case 2:
                findViewById(R.id.air_pa_jeep_wind_lev_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind2);
                break;
            case 3:
                findViewById(R.id.air_pa_jeep_wind_lev_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind3);
                break;
            case 4:
                findViewById(R.id.air_pa_jeep_wind_lev_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind4);
                break;
            case 5:
                findViewById(R.id.air_pa_jeep_wind_lev_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind5);
                break;
            case 6:
                findViewById(R.id.air_pa_jeep_wind_lev_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind6);
                break;
            case 7:
                findViewById(R.id.air_pa_jeep_wind_lev_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind7);
                break;
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        switch (leave) {
            case 0:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind0);
                break;
            case 1:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind1);
                break;
            case 2:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind2);
                break;
            case 3:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind3);
                break;
            case 4:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind4);
                break;
            case 5:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind5);
                break;
            case 6:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind6);
                break;
            case 7:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind7);
                break;
            default:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind0);
                break;
        }
    }

    
    public void updateBtnSource() {
        int body = DataCanbus.DATA[19];
        int window = DataCanbus.DATA[18];
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
        findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode0);
        switch (mode) {
            case 1:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode1);
                break;
            case 2:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode2);
                break;
            case 3:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode3);
                break;
            case 4:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode4);
                break;
            case 5:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode5);
                break;
            case 6:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode6);
                break;
            case 7:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode7);
                break;
        }
    }

    
    public void updateBtnSourceRear() {
        int foot_rear = DataCanbus.DATA[47];
        int body_rear = DataCanbus.DATA[46];
        int mode_rear = 0;
        if (foot_rear == 1) {
            mode_rear = 0 | 1;
        } else if (foot_rear == 0) {
            mode_rear = 0 & 254;
        }
        if (body_rear == 1) {
            mode_rear |= 2;
        } else if (body_rear == 0) {
            mode_rear &= 253;
        }
        findViewById(R.id.air_pa_jeep_mode_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_rear_mode0);
        switch (mode_rear) {
            case 1:
                findViewById(R.id.air_pa_jeep_mode_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_rear_mode1);
                break;
            case 2:
                findViewById(R.id.air_pa_jeep_mode_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_rear_mode2);
                break;
            case 3:
                findViewById(R.id.air_pa_jeep_mode_rear).setBackgroundResource(R.drawable.ic_air_pa_jeep_rear_mode3);
                break;
        }
    }
}
