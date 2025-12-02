package com.syu.carinfo.rzc.keleijia;

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
public class RzcLeinuoAirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 50:
                    RzcLeinuoAirControlAct.this.mUpdateData0Onoff();
                    break;
                case 51:
                    RzcLeinuoAirControlAct.this.mUpdateData1Onoff();
                    break;
                case 52:
                    RzcLeinuoAirControlAct.this.mUpdateData2Onoff();
                    break;
                case 53:
                    RzcLeinuoAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 54:
                    RzcLeinuoAirControlAct.this.mUpdateAirTempRight();
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
        //setContentView(R.layout.layout_0402_rzc_leinuo_air_control);
        init();
    }

    private void init() {
        //findViewById(R.id.air_xts_soft).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_win).setOnTouchListener(this);
        //(R.id.air_xts_normal).setOnTouchListener(this);
        //findViewById(R.id.air_xts_fast).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_aqs).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
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
                data0 = 13;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 14;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 0;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 12;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 11;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 2;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 21;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 6;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 1;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data0 = 9;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 7;
                break;
            case R.id.air_xts_mode_win /* 2131427445 */:
                data0 = 24;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 15;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 16;
                break;
            case R.id.air_xts_dual /* 2131427460 */:
                data0 = 3;
                break;
            case R.id.air_xts_aqs /* 2131427467 */:
                data0 = 22;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data0 = 23;
                break;
        }
        if (event.getAction() == 0) {
            sendCmd(data0, 1);
        } else if (event.getAction() == 1) {
            sendCmd(data0, 0);
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateData2Onoff() {
        int winlev = DataCanbus.DATA[52] & 255;
        findViewById(R.id.air_xts_power).setBackgroundResource(winlev == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        if (winlev < 0) {
            winlev = 0;
        }
        if (winlev > 8) {
            winlev = 8;
        }
        String str = " " + winlev + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }

    
    public void mUpdateData1Onoff() {
        int softOn = (DataCanbus.DATA[51] >> 6) & 1;
        //findViewById(R.id.air_xts_soft).setBackgroundResource(softOn == 0 ? R.drawable.ic_xts_soft_n : R.drawable.ic_xts_soft_p);
        int fastOn = (DataCanbus.DATA[51] >> 5) & 1;
        //findViewById(R.id.air_xts_fast).setBackgroundResource(fastOn == 0 ? R.drawable.ic_xts_fast_n : R.drawable.ic_xts_fast_p);
        int normalOn = (DataCanbus.DATA[51] >> 4) & 1;
        //findViewById(R.id.air_xts_normal).setBackgroundResource(normalOn == 0 ? R.drawable.ic_xts_mormal_n : R.drawable.ic_xts_mormal_p);
        int foot = (DataCanbus.DATA[51] >> 2) & 1;
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(foot == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
        int body = (DataCanbus.DATA[51] >> 1) & 1;
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(body == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
        int win = (DataCanbus.DATA[51] >> 0) & 1;
        findViewById(R.id.air_xts_mode_win).setBackgroundResource(win == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
    }

    
    public void mUpdateData0Onoff() {
        int acOn = (DataCanbus.DATA[50] >> 6) & 1;
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        int aqsOn = (DataCanbus.DATA[50] >> 7) & 1;
        findViewById(R.id.air_xts_aqs).setBackgroundResource(aqsOn == 0 ? R.drawable.ic_xts_aqs_n : R.drawable.ic_xts_aqs_p);
        int cycleOn = (DataCanbus.DATA[50] >> 4) & 3;
        if (cycleOn == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else if (cycleOn == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        }
        int autoOn = (DataCanbus.DATA[50] >> 3) & 1;
        findViewById(R.id.air_xts_auto).setBackgroundResource(autoOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        int dualOn = (DataCanbus.DATA[50] >> 2) & 1;
        findViewById(R.id.air_xts_dual).setBackgroundResource(dualOn == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
        int rear = (DataCanbus.DATA[50] >> 1) & 1;
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        int front = (DataCanbus.DATA[50] >> 0) & 1;
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[53];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == 254) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == 255) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else if (temp == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("None");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 0.5f) + "℃");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[54] & 255;
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == 254) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == 255) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else if (temp == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("None");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 0.5f) + "℃");
            }
        }
    }
}
