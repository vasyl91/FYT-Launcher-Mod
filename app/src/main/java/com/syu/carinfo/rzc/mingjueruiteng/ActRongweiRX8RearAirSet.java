package com.syu.carinfo.rzc.mingjueruiteng;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class ActRongweiRX8RearAirSet extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 91:
                    ActRongweiRX8RearAirSet.this.mUpdaterAirWindLevelLeft();
                    break;
                case 132:
                    ActRongweiRX8RearAirSet.this.mUpdateAirTempLeft();
                    break;
                case 133:
                case 134:
                    ActRongweiRX8RearAirSet.this.updateBtnSource();
                    break;
                case 136:
                    ActRongweiRX8RearAirSet.this.mUpdatePowerOn();
                    break;
                case 137:
                    ActRongweiRX8RearAirSet.this.mUpdateAutoOn();
                    break;
                case 138:
                    ActRongweiRX8RearAirSet.this.mUpdateSyncOn();
                    break;
                case 139:
                    ActRongweiRX8RearAirSet.this.mUpdateReaclockOn();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(5, new int[]{data0, data1}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0273_rzc_rx8_air_rear_control);
        init();
    }

    private void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_sync).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearlock).setOnTouchListener(this);
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
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 24;
                data1 = 1;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 24;
                data1 = 2;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 26;
                data1 = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 20;
                data1 = 2;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 20;
                data1 = 1;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 27;
                data1 = 1;
                break;
            case R.id.air_xts_sync /* 2131427441 */:
                data0 = 23;
                data1 = 1;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data0 = 25;
                data1 = 3;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 25;
                data1 = 1;
                break;
            case R.id.air_xts_rearlock /* 2131427446 */:
                data0 = 22;
                data1 = 1;
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                data0 = 25;
                data1 = 2;
                break;
        }
        if (data0 != 0) {
            if (event.getAction() == 0) {
                sendCmd(data0, data1);
            } else if (event.getAction() == 1) {
                sendCmd(data0, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateReaclockOn() {
        int acOn = DataCanbus.DATA[139];
        findViewById(R.id.air_xts_rearlock).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_rearlock_n : R.drawable.ic_xts_rearlock_p);
    }

    
    public void mUpdateSyncOn() {
        int acOn = DataCanbus.DATA[138];
        findViewById(R.id.air_xts_sync).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[137];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[132];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == 255) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else if (temp >= 1 && temp <= 15) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(((temp + 15) * 1.0f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("None");
            }
        }
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[136];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[91];
        if (leave < 0) {
            leave = 0;
        }
        if (leave > 8) {
            leave = 8;
        }
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }

    
    public void updateBtnSource() {
        int foot = DataCanbus.DATA[134];
        int body = DataCanbus.DATA[133];
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
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
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
        }
    }
}
