package com.syu.carinfo.rzc.klc;

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

@SuppressWarnings({"deprecation", "unchecked"})
public class RzcChevroletBlazerRearAirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 64:
                    RzcChevroletBlazerRearAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 65:
                    RzcChevroletBlazerRearAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 66:
                    RzcChevroletBlazerRearAirControlAct.this.mUpdaterBlowBodyLeftOn();
                    break;
                case 67:
                    RzcChevroletBlazerRearAirControlAct.this.mUpdaterBlowFootLeftOn();
                    break;
                case 68:
                    RzcChevroletBlazerRearAirControlAct.this.mUpdateAutokOn();
                    break;
                case 69:
                    RzcChevroletBlazerRearAirControlAct.this.mUpdateRearLockOn();
                    break;
                case 70:
                    RzcChevroletBlazerRearAirControlAct.this.mUpdateSyncOn();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(1, new int[]{data0, data1}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0061_rzc_chevroletblazer_air_control_r);
        init();
    }

    private void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_frontpage).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearlock).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_sync).setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        boolean flag = false;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 97;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 98;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 107;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 100;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 99;
                break;
            case R.id.air_xts_frontpage /* 2131427432 */:
                flag = true;
                try {
                    startActivity(new Intent(this, (Class<?>) RzcChevroletBlazerFrontAirControlAct.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 104;
                break;
            case R.id.air_xts_sync /* 2131427441 */:
                data0 = 106;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data0 = 103;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 101;
                break;
            case R.id.air_xts_rearlock /* 2131427446 */:
                data0 = 105;
                break;
        }
        if (!flag && event.getAction() == 0) {
            sendCmd(7, data0);
            return false;
        }
        return false;
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

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateAutokOn() {
        int power = DataCanbus.DATA[68];
        findViewById(R.id.air_xts_auto).setBackgroundResource(power == 1 ? R.drawable.ic_xts_auto_p : R.drawable.ic_xts_auto_n);
    }

    
    public void mUpdateRearLockOn() {
        int power = DataCanbus.DATA[69];
        findViewById(R.id.air_xts_rearlock).setBackgroundResource(power == 0 ? R.drawable.ic_xts_rearlock_n : R.drawable.ic_xts_rearlock_p);
    }

    
    public void mUpdateSyncOn() {
        int acOn = DataCanbus.DATA[70];
        findViewById(R.id.air_xts_sync).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
    }

    
    public void mUpdaterBlowFootLeftOn() {
        int acOn = DataCanbus.DATA[67];
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
    }

    
    public void mUpdaterBlowBodyLeftOn() {
        int acOn = DataCanbus.DATA[66];
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[64];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                case 129:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case 255:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("----");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 2.0f) + "°C");
                    break;
            }
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        String str;
        int leave = DataCanbus.DATA[65];
        if (leave < 0) {
            leave = 0;
        }
        if (leave == 15) {
            str = "A";
        } else {
            str = " " + leave + " ";
        }
        findViewById(R.id.air_xts_power).setBackgroundResource(leave == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }
}
