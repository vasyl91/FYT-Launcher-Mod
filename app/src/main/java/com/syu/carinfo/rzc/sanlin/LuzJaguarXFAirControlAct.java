package com.syu.carinfo.rzc.sanlin;

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
public class LuzJaguarXFAirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    LuzJaguarXFAirControlAct.this.mUpdatePowerOn();
                    break;
                case 11:
                    LuzJaguarXFAirControlAct.this.mUpdateAcOn();
                    break;
                case 12:
                    LuzJaguarXFAirControlAct.this.mUpdateCycle();
                    break;
                case 13:
                    LuzJaguarXFAirControlAct.this.mUpdateAutoOn();
                    break;
                case 14:
                    LuzJaguarXFAirControlAct.this.mUpdaterDual();
                    break;
                case 16:
                    LuzJaguarXFAirControlAct.this.mUpdateRearDefrost();
                    break;
                case 18:
                    LuzJaguarXFAirControlAct.this.mUpdaterBlowWindow();
                    break;
                case 19:
                    LuzJaguarXFAirControlAct.this.mUpdaterBlowBodyLeftOn();
                    break;
                case 20:
                    LuzJaguarXFAirControlAct.this.mUpdaterBlowFootLeftOn();
                    break;
                case 21:
                    LuzJaguarXFAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    LuzJaguarXFAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    LuzJaguarXFAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 37:
                    LuzJaguarXFAirControlAct.this.mUpdateAirTempLeft();
                    LuzJaguarXFAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 65:
                    LuzJaguarXFAirControlAct.this.mUpdateFrontDefrost();
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
        //setContentView(R.layout.layout_0452_luz_jaguar_xf_air_control);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_win).setOnTouchListener(this);
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
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
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
                data0 = 16;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 17;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 22;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 21;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 20;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 25;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 26;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 23;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 1;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data0 = 4;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 3;
                break;
            case R.id.air_xts_mode_win /* 2131427445 */:
                data0 = 2;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 18;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 19;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                data0 = 24;
                break;
            case R.id.air_xts_dual /* 2131427566 */:
                data0 = 5;
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
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        int unit = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else if (unit != 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(((temp + 58) * 1.0f) + "°C");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp * 5) + 155) * 0.1f) + "°C");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[28];
        int unit = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else if (unit != 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(((temp + 58) * 1.0f) + "°C");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((temp * 5) + 155) * 0.1f) + "°C");
            }
        }
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdaterDual() {
        int power = DataCanbus.DATA[14];
        findViewById(R.id.air_xts_dual).setBackgroundResource(power == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        }
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[65];
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
        int body = DataCanbus.DATA[19];
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(body == 1 ? R.drawable.ic_xts_mode_body_p : R.drawable.ic_xts_mode_body_n);
    }

    
    public void mUpdaterBlowFootLeftOn() {
        int foot = DataCanbus.DATA[20];
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(foot == 1 ? R.drawable.ic_xts_mode_foot_p : R.drawable.ic_xts_mode_foot_n);
    }

    
    public void mUpdaterBlowWindow() {
        int window = DataCanbus.DATA[18];
        findViewById(R.id.air_xts_mode_win).setBackgroundResource(window == 1 ? R.drawable.ic_xts_mode_win_p : R.drawable.ic_xts_mode_win_n);
    }
}
