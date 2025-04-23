package com.syu.carinfo.luz.binli;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class BinliCarAirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_xts_mode_win_n;
            int i2 = R.drawable.ic_xts_mode_foot_n;
            int i3 = R.drawable.ic_xts_mode_body_n;
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 8:
                    BinliCarAirControlAct.this.mUpdatePowerOn();
                    break;
                case 9:
                    BinliCarAirControlAct.this.mUpdateAcOn();
                    break;
                case 10:
                    BinliCarAirControlAct.this.mUpdateCycle();
                    break;
                case 11:
                    BinliCarAirControlAct.this.mUpdateAutoOn();
                    break;
                case 12:
                    BinliCarAirControlAct.this.findViewById(R.id.air_xts_auto_right).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
                    break;
                case 13:
                    BinliCarAirControlAct.this.mUpdaterDual();
                    break;
                case 14:
                    BinliCarAirControlAct.this.mUpdateFrontDefrost();
                    break;
                case 15:
                    BinliCarAirControlAct.this.mUpdateRearDefrost();
                    break;
                case 16:
                    BinliCarAirControlAct.this.findViewById(R.id.air_xts_mode_win).setBackgroundResource(value == 0 ? 2130841741 : R.drawable.ic_xts_mode_win_p);
                    break;
                case 17:
                    BinliCarAirControlAct.this.findViewById(R.id.air_xts_mode_body).setBackgroundResource(value == 0 ? 2130841714 : 2130841715);
                    break;
                case 18:
                    View findViewById = BinliCarAirControlAct.this.findViewById(R.id.air_xts_mode_foot);
                    if (value != 0) {
                        i2 = 2130841723;
                    }
                    findViewById.setBackgroundResource(i2);
                    break;
                case 20:
                    BinliCarAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 21:
                    BinliCarAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 22:
                    BinliCarAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 23:
                    View findViewById2 = BinliCarAirControlAct.this.findViewById(R.id.air_xts_mode_win_right);
                    if (value != 0) {
                        i = R.drawable.ic_xts_mode_win_p;
                    }
                    findViewById2.setBackgroundResource(i);
                    break;
                case 24:
                    View findViewById3 = BinliCarAirControlAct.this.findViewById(R.id.air_xts_mode_body_right);
                    if (value != 0) {
                        i3 = 2130841715;
                    }
                    findViewById3.setBackgroundResource(i3);
                    break;
                case 25:
                    View findViewById4 = BinliCarAirControlAct.this.findViewById(R.id.air_xts_mode_foot_right);
                    if (value != 0) {
                        i2 = 2130841723;
                    }
                    findViewById4.setBackgroundResource(i2);
                    break;
                case 27:
                    BinliCarAirControlAct.this.findViewById(R.id.air_xts_rear_light).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_light_n : R.drawable.ic_xts_rear_light_p);
                    break;
                case 28:
                    BinliCarAirControlAct.this.findViewById(R.id.air_xts_aqs).setBackgroundResource(value == 0 ? R.drawable.ic_xts_aqs_n : R.drawable.ic_xts_aqs_p);
                    break;
                case 29:
                    BinliCarAirControlAct.this.findViewById(R.id.air_xts_rest).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rest_n : R.drawable.ic_xts_rest_p);
                    break;
                case 30:
                    BinliCarAirControlAct.this.mUpdateAirTempLeft();
                    BinliCarAirControlAct.this.mUpdateAirTempRight();
                    break;
            }
        }
    };

    private void sendCmd(int data0) {
        DataCanbus.PROXY.cmd(0, new int[]{data0}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ////setContentView(R.layout.layout_0439_lz_binli_air_control);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_win).setOnTouchListener(this);
        findViewById(R.id.air_xts_aqs).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_win_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot_right).setOnTouchListener(this);
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
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear_light).setOnTouchListener(this);
        findViewById(R.id.air_xts_sync).setOnTouchListener(this);
        findViewById(R.id.air_xts_rest).setOnTouchListener(this);
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
                data0 = 1;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 2;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 6;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 5;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 10;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 9;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 12;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 8;
                break;
            case R.id.air_xts_sync /* 2131427441 */:
                data0 = 7;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data0 = 15;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 14;
                break;
            case R.id.air_xts_mode_win /* 2131427445 */:
                data0 = 16;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 3;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 4;
                break;
            case R.id.air_xts_aqs /* 2131427467 */:
                data0 = 20;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data0 = 13;
                break;
            case R.id.air_xts_rear_light /* 2131427563 */:
                data0 = 22;
                break;
            case R.id.air_xts_mode_win_right /* 2131428290 */:
                data0 = 19;
                break;
            case R.id.air_xts_mode_body_right /* 2131428291 */:
                data0 = 17;
                break;
            case R.id.air_xts_mode_foot_right /* 2131428292 */:
                data0 = 18;
                break;
            case R.id.air_xts_rest /* 2131428293 */:
                data0 = 21;
                break;
            case R.id.air_xts_auto_right /* 2131428294 */:
                data0 = 11;
                break;
        }
        if (event.getAction() == 0) {
            sendCmd(data0);
        } else if (event.getAction() == 1) {
            sendCmd(0);
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[21];
        int unit = DataCanbus.DATA[30];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp * 9) + 320) * 0.1f) + "℉");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 5 * 0.1f) + "℃");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[22];
        int unit = DataCanbus.DATA[30];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(((temp * 9) + 320) + "℉");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 5 * 0.1f) + "℃");
            }
        }
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[9];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[8];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdaterDual() {
        int power = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_sync).setBackgroundResource(power == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[10];
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        }
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[14];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[15];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[20];
        if (leave < 0) {
            leave = 0;
        }
        if (leave > 8) {
            leave = 8;
        }
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }
}
