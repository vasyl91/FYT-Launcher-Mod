package com.syu.carinfo.hc.tianlai;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;
import com.syu.util.HandlerUI;

public class ActivityToread_AirRearCtrl extends Activity implements View.OnTouchListener {
    public static ActivityToread_AirRearCtrl mInstance;
    public static boolean mIsFront = false;
    boolean bNeedSend = false;
    int cmdId = -1;
    int touchState = -1;
    Runnable airControl = new Runnable() { 
        @Override
        public void run() {
            ActivityToread_AirRearCtrl.this.setAirControl(ActivityToread_AirRearCtrl.this.cmdId, 0);
        }
    };
    Runnable airControl2 = new Runnable() { 
        @Override
        public void run() {
            ActivityToread_AirRearCtrl.this.setAirControl(128, 0);
        }
    };
    Runnable airControl3 = new Runnable() { 
        @Override
        public void run() {
            ActivityToread_AirRearCtrl.this.setAirControl(129, 0);
        }
    };
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 40:
                    ActivityToread_AirRearCtrl.this.mUpdaterAirTempRear();
                    break;
                case 42:
                    ActivityToread_AirRearCtrl.this.mUpdaterAirPower();
                    break;
                case 43:
                    ActivityToread_AirRearCtrl.this.mUpdateAirAuto();
                    break;
                case 44:
                    ActivityToread_AirRearCtrl.this.mUpdaterAirWindLevel();
                    break;
                case 46:
                case 47:
                    ActivityToread_AirRearCtrl.this.mUpdaterAirBLowMode();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 7799223 || DataCanbus.DATA[1000] == 65988 || DataCanbus.DATA[1000] == 1442245) {
            //setContentView(R.layout.layout_439_toread_airrear_control_hp);
        } else {
            //setContentView(R.layout.layout_439_toread_airrear_control);
        }
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
        addUpdater();
        setAirControl(128, 1);
        HandlerUI.getInstance().postDelayed(this.airControl2, 50L);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
        removeUpdater();
        setAirControl(129, 1);
        HandlerUI.getInstance().postDelayed(this.airControl3, 50L);
    }

    
    public void setAirControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(6, cmdId, touchState);
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
            case R.id.air_xts_auto /* 2131427436 */:
                this.cmdId = 4;
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
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAirBLowMode() {
        int body = DataCanbus.DATA[46];
        int foot = DataCanbus.DATA[47];
        if (foot == 1 && body == 0) {
            findViewById(R.id.air_xts_mode_body).setSelected(false);
            findViewById(R.id.air_xts_mode_footbody).setSelected(false);
            findViewById(R.id.air_xts_mode_foot).setSelected(true);
        } else if (foot == 1 && body == 1) {
            findViewById(R.id.air_xts_mode_body).setSelected(false);
            findViewById(R.id.air_xts_mode_footbody).setSelected(true);
            findViewById(R.id.air_xts_mode_foot).setSelected(false);
        } else if (foot == 0 && body == 1) {
            findViewById(R.id.air_xts_mode_body).setSelected(true);
            findViewById(R.id.air_xts_mode_footbody).setSelected(false);
            findViewById(R.id.air_xts_mode_foot).setSelected(false);
        }
    }

    
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[42];
        if (findViewById(R.id.air_xts_power) != null) {
            if (value == 0) {
                findViewById(R.id.air_xts_power).setSelected(false);
            } else if (value == 1) {
                findViewById(R.id.air_xts_power).setSelected(true);
            }
        }
    }

    
    public void mUpdateAirAuto() {
        int value = DataCanbus.DATA[43];
        if (findViewById(R.id.air_xts_auto) != null) {
            if (value == 0) {
                findViewById(R.id.air_xts_auto).setSelected(false);
            } else if (value == 1) {
                findViewById(R.id.air_xts_auto).setSelected(true);
            }
        }
    }

    
    public void mUpdaterAirTempRear() {
        int temp = DataCanbus.DATA[40];
        if (findViewById(R.id.tv_air_temp_left) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                case -1:
                case 0:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NONE");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp * 5) + 175) * 0.1f) + "℃");
                    break;
            }
        }
    }

    
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[44];
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(String.valueOf(level));
    }
}
