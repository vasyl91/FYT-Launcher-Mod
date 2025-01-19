package com.syu.carinfo.hc.tianlai;

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
import com.syu.util.HandlerUI;

public class ActivityTianLaiFrontAirSetting extends Activity implements View.OnTouchListener {
    public static ActivityTianLaiFrontAirSetting mInstance;
    public static boolean mIsFront = false;
    boolean bNeedSend = false;
    int cmdId = -1;
    int touchState = -1;
    Runnable airControl = new Runnable() { 
        @Override
        public void run() {
            ActivityTianLaiFrontAirSetting.this.setAirControl(ActivityTianLaiFrontAirSetting.this.cmdId, 0);
        }
    };
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 11:
                    ActivityTianLaiFrontAirSetting.this.mUpdaterAirAC();
                    break;
                case 12:
                    ActivityTianLaiFrontAirSetting.this.mUpdateAirCycle();
                    break;
                case 13:
                    ActivityTianLaiFrontAirSetting.this.mUpdaterAuto();
                    break;
                case 14:
                    ActivityTianLaiFrontAirSetting.this.mUpdaterSync();
                    break;
                case 16:
                    ActivityTianLaiFrontAirSetting.this.mUpdateAirRearDefrost();
                    break;
                case 21:
                    ActivityTianLaiFrontAirSetting.this.mUpdaterAirWindLevel();
                    ActivityTianLaiFrontAirSetting.this.mUpdaterAirPower();
                    break;
                case 27:
                    ActivityTianLaiFrontAirSetting.this.UTempLeft(value);
                    break;
                case 28:
                    ActivityTianLaiFrontAirSetting.this.UTempRight(value);
                    break;
                case 65:
                    ActivityTianLaiFrontAirSetting.this.mUpdateAirFrontDefrost(value);
                    break;
                case 77:
                    ActivityTianLaiFrontAirSetting.this.UBlowMode_new(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_439_tianlai_airfront_control_hp);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.air_cycle_outer).setOnTouchListener(this);
        findViewById(R.id.air_cycle_inter).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
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

    
    public void setAirControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(0, cmdId, touchState);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                this.cmdId = 12;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                this.cmdId = 11;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                this.cmdId = 0;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                this.cmdId = 9;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                this.cmdId = 10;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
                this.cmdId = 8;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                this.cmdId = 4;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                this.cmdId = 5;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                this.cmdId = 1;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                this.cmdId = 14;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                this.cmdId = 13;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                this.cmdId = 6;
                break;
            case R.id.air_xts_dual /* 2131427566 */:
                this.cmdId = 7;
                break;
            case R.id.air_cycle_outer /* 2131428106 */:
                this.cmdId = 3;
                break;
            case R.id.air_cycle_inter /* 2131428107 */:
                this.cmdId = 2;
                break;
        }
        switch (event.getAction()) {
            case 0:
                this.touchState = 1;
                this.bNeedSend = true;
                setAirControl(this.cmdId, this.touchState);
                break;
            case 1:
                this.bNeedSend = false;
                this.touchState = 0;
                HandlerUI.getInstance().postDelayed(this.airControl, 100L);
                break;
        }
        if (this.cmdId == -1 || this.touchState == -1) {
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
    }

    
    public void UTempLeft(int data) {
        String str;
        if (findViewById(R.id.tv_air_temp_left) != null) {
            if (data == -2) {
                str = "LOW";
            } else if (data == -3) {
                str = "HI";
            } else {
                int data2 = (data * 5) + 175;
                str = data2 / 10 + "." + (data2 % 10) + "℃";
            }
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(str);
        }
    }

    
    public void UTempRight(int data) {
        String str;
        if (findViewById(R.id.tv_air_temp_right) != null) {
            if (data == -2) {
                str = "LOW";
            } else if (data == -3) {
                str = "HI";
            } else {
                int data2 = (data * 5) + 170;
                str = data2 / 10 + "." + (data2 % 10) + "℃";
            }
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(str);
        }
    }

    
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[21];
        if (findViewById(R.id.dj_xts_air_winlevel) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(String.valueOf(level));
        }
    }

    
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[12];
        if (findViewById(R.id.air_cycle_outer) != null) {
            findViewById(R.id.air_cycle_outer).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_out_p : R.drawable.ic_xts_cycle_n);
        }
        if (findViewById(R.id.air_cycle_inter) != null) {
            findViewById(R.id.air_cycle_inter).setBackgroundResource(value == 1 ? R.drawable.ic_cycle_all_p : R.drawable.ic_cycle_all_n);
        }
    }

    
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[11];
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    
    public void mUpdateAirFrontDefrost(int data) {
        int value = DataCanbus.DATA[65];
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[16];
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    
    public void mUpdaterSync() {
        int value = DataCanbus.DATA[14];
        if (findViewById(R.id.air_xts_dual) != null) {
            findViewById(R.id.air_xts_dual).setBackgroundResource(value == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
        }
    }

    
    public void mUpdaterAuto() {
        int value = DataCanbus.DATA[13];
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }

    
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[21];
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setBackgroundResource(value > 0 ? R.drawable.ic_xts_power_p : R.drawable.ic_xts_power_n);
        }
    }

    
    public void UBlowMode_new(int i_mode) {
        int idDrawable = R.drawable.ic_xts_mode_null;
        switch (i_mode) {
            case 1:
                idDrawable = R.drawable.ic_xts_mode_body;
                break;
            case 2:
                idDrawable = R.drawable.ic_xts_mode_foot_body;
                break;
            case 3:
                idDrawable = R.drawable.ic_xts_mode_foot;
                break;
            case 4:
                idDrawable = R.drawable.ic_xts_mode_foot_win;
                break;
            case 5:
                idDrawable = R.drawable.ic_xts_mode_win;
                break;
        }
        if (findViewById(R.id.air_xts_mode) != null && idDrawable != -1) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(idDrawable);
        }
    }
}
