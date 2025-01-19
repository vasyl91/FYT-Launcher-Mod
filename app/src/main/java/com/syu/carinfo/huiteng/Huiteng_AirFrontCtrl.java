package com.syu.carinfo.huiteng;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class Huiteng_AirFrontCtrl extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    Huiteng_AirFrontCtrl.this.mUpdatePowerOn();
                    break;
                case 11:
                    Huiteng_AirFrontCtrl.this.mUpdateAcOn();
                    break;
                case 12:
                    Huiteng_AirFrontCtrl.this.mUpdateCycle();
                    break;
                case 13:
                    Huiteng_AirFrontCtrl.this.mUpdateAutoOn();
                    break;
                case 14:
                    Huiteng_AirFrontCtrl.this.mUpdaterDual();
                    break;
                case 15:
                    Huiteng_AirFrontCtrl.this.mUpdateFrontDefrost();
                    break;
                case 18:
                    Huiteng_AirFrontCtrl.this.mUpdateModeUpOn();
                    break;
                case 19:
                    Huiteng_AirFrontCtrl.this.mUpdateModeBodyOn();
                    break;
                case 20:
                    Huiteng_AirFrontCtrl.this.mUpdateModeFootOn();
                    break;
                case 21:
                    Huiteng_AirFrontCtrl.this.mUpdaterAirWindLevelLeft();
                    break;
                case 22:
                    Huiteng_AirFrontCtrl.this.mUpdateModeUpRightOn();
                    break;
                case 23:
                    Huiteng_AirFrontCtrl.this.mUpdateModeBodyRightOn();
                    break;
                case 24:
                    Huiteng_AirFrontCtrl.this.mUpdateModeFootRightOn();
                    break;
                case 26:
                    Huiteng_AirFrontCtrl.this.mUpdateAutoRightOn();
                    break;
                case 27:
                    Huiteng_AirFrontCtrl.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    Huiteng_AirFrontCtrl.this.mUpdateAirTempRight();
                    break;
                case 38:
                    Huiteng_AirFrontCtrl.this.mUpdateRearDefrost();
                    break;
                case 54:
                    Huiteng_AirFrontCtrl.this.mUpdateAQSOn();
                    break;
                case 55:
                    Huiteng_AirFrontCtrl.this.mUpdateRestOn();
                    break;
                case 67:
                    Huiteng_AirFrontCtrl.this.mUpdateRearLockOn();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(3, new int[]{data0, data1}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_439_huiteng_frontair_dj_control);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_win).setOnTouchListener(this);
        findViewById(R.id.air_xts_sync).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_win_right).setOnTouchListener(this);
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
        findViewById(R.id.air_xts_rest).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearlock).setOnTouchListener(this);
        findViewById(R.id.air_xts_aqs).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto_right).setOnTouchListener(this);
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
                data0 = 12;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 13;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 10;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 7;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 6;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 1;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 3;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 4;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 8;
                break;
            case R.id.air_xts_sync /* 2131427441 */:
                data0 = 2;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data0 = 35;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 34;
                break;
            case R.id.air_xts_mode_win /* 2131427445 */:
                data0 = 33;
                break;
            case R.id.air_xts_rearlock /* 2131427446 */:
                data0 = 38;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 14;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 15;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                data0 = 5;
                break;
            case R.id.air_xts_aqs /* 2131427592 */:
                data0 = 52;
                break;
            case R.id.air_xts_mode_win_right /* 2131428576 */:
                data0 = 48;
                break;
            case R.id.air_xts_mode_body_right /* 2131428577 */:
                data0 = 49;
                break;
            case R.id.air_xts_mode_foot_right /* 2131428578 */:
                data0 = 50;
                break;
            case R.id.air_xts_auto_right /* 2131428584 */:
                data0 = 51;
                break;
            case R.id.air_xts_rest /* 2131430062 */:
                data0 = 53;
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
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterDual() {
        int power = DataCanbus.DATA[14];
        findViewById(R.id.air_xts_sync).setBackgroundResource(power == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 5 * 0.1f) + "°C");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 5 * 0.1f) + "°C");
            }
        }
    }

    
    public void mUpdateAQSOn() {
        int acOn = DataCanbus.DATA[54];
        findViewById(R.id.air_xts_aqs).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_aqs_n : R.drawable.ic_xts_aqs_p);
    }

    
    public void mUpdateRearLockOn() {
        int acOn = DataCanbus.DATA[67];
        findViewById(R.id.air_xts_rearlock).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_rearlock_n : R.drawable.ic_xts_rearlock_p);
    }

    
    public void mUpdateRestOn() {
        int acOn = DataCanbus.DATA[55];
        findViewById(R.id.air_xts_rest).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_rest_n : R.drawable.ic_xts_rest_p);
    }

    
    public void mUpdateAutoRightOn() {
        int acOn = DataCanbus.DATA[26];
        findViewById(R.id.air_xts_auto_right).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
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

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        }
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[15];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[38];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        if (leave < 0) {
            leave = 0;
        }
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }

    
    public void mUpdateModeUpOn() {
        int rear = DataCanbus.DATA[18];
        findViewById(R.id.air_xts_mode_win).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
    }

    
    public void mUpdateModeBodyOn() {
        int rear = DataCanbus.DATA[19];
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
    }

    
    public void mUpdateModeFootOn() {
        int rear = DataCanbus.DATA[20];
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
    }

    
    public void mUpdateModeUpRightOn() {
        int rear = DataCanbus.DATA[22];
        findViewById(R.id.air_xts_mode_win_right).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
    }

    
    public void mUpdateModeBodyRightOn() {
        int rear = DataCanbus.DATA[23];
        findViewById(R.id.air_xts_mode_body_right).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
    }

    
    public void mUpdateModeFootRightOn() {
        int rear = DataCanbus.DATA[24];
        findViewById(R.id.air_xts_mode_foot_right).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
    }
}
