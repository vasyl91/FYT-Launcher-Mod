package com.syu.carinfo.golf7_xp;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class XP_MQB_AllAirControl extends Activity implements View.OnTouchListener {
    public static XP_MQB_AllAirControl mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 66:
                    XP_MQB_AllAirControl.this.mUpdateAirTempLeft();
                    XP_MQB_AllAirControl.this.mUpdateAirTempRight();
                    break;
                case 87:
                    XP_MQB_AllAirControl.this.mUpdatePowerOn();
                    break;
                case 88:
                    XP_MQB_AllAirControl.this.mUpdateAcOn();
                    break;
                case 89:
                    XP_MQB_AllAirControl.this.mUpdateCycle();
                    break;
                case 92:
                    XP_MQB_AllAirControl.this.mUpdateDualOn();
                    break;
                case 93:
                    XP_MQB_AllAirControl.this.mUpdateFrontDefrost();
                    break;
                case 94:
                    XP_MQB_AllAirControl.this.mUpdateRearLockOn();
                    break;
                case 95:
                    XP_MQB_AllAirControl.this.mUpdaterBlowWindow();
                    break;
                case 96:
                    XP_MQB_AllAirControl.this.mUpdaterBlowBodyLeftOn();
                    break;
                case 97:
                    XP_MQB_AllAirControl.this.mUpdaterBlowFootLeftOn();
                    break;
                case 98:
                    XP_MQB_AllAirControl.this.mUpdaterAirWindLevelLeft();
                    break;
                case 99:
                    XP_MQB_AllAirControl.this.mUpdateAirTempLeft();
                    break;
                case 100:
                    XP_MQB_AllAirControl.this.mUpdateAirTempRight();
                    break;
                case 102:
                    XP_MQB_AllAirControl.this.mUpdaterAQSOn();
                    break;
                case 104:
                    XP_MQB_AllAirControl.this.mUpdaterClearOn();
                    break;
                case 106:
                    XP_MQB_AllAirControl.this.mUpdaterSteerHeatOn();
                    break;
                case 107:
                    XP_MQB_AllAirControl.this.mUpdaterSeatHeatLeft();
                    break;
                case 108:
                    XP_MQB_AllAirControl.this.mUpdaterFGlassHeatOn();
                    break;
                case 109:
                    XP_MQB_AllAirControl.this.mUpdaterSeatHeatRight();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(107, new int[]{data0, data1}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0040_xp_mqb_air_control);
        mInstance = this;
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_win).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearlock).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_clear).setOnTouchListener(this);
        findViewById(R.id.air_xts_front_hot).setOnTouchListener(this);
        findViewById(R.id.air_xts_steer_hot).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_sync).setOnTouchListener(this);
        findViewById(R.id.air_xts_aqs).setOnTouchListener(this);
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        if (event.getAction() == 0) {
            switch (id) {
                case R.id.btn_air_temp_left_plus /* 2131427425 */:
                    sendCmd(184, 1);
                    break;
                case R.id.btn_air_temp_left_minus /* 2131427427 */:
                    sendCmd(184, 0);
                    break;
                case R.id.air_xts_power /* 2131427428 */:
                    int value = DataCanbus.DATA[87];
                    if (value == 1) {
                        value = 0;
                    } else if (value == 0) {
                        value = 1;
                    }
                    sendCmd(178, value);
                    break;
                case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                    int value2 = DataCanbus.DATA[98];
                    if (value2 > 0) {
                        value2--;
                    }
                    sendCmd(183, value2);
                    break;
                case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                    int value3 = DataCanbus.DATA[98];
                    if (value3 < 7) {
                        value3++;
                    }
                    sendCmd(183, value3);
                    break;
                case R.id.air_xts_seathot_left /* 2131427433 */:
                    int value4 = DataCanbus.DATA[107] + 1;
                    if (value4 > 3) {
                        value4 = 0;
                    }
                    sendCmd(173, value4);
                    break;
                case R.id.air_xts_seathot_right /* 2131427435 */:
                    int value5 = DataCanbus.DATA[109] + 1;
                    if (value5 > 3) {
                        value5 = 0;
                    }
                    sendCmd(174, value5);
                    break;
                case R.id.air_xts_cycle /* 2131427437 */:
                    int value6 = DataCanbus.DATA[89];
                    if (value6 == 1) {
                        value6 = 0;
                    } else if (value6 == 0) {
                        value6 = 1;
                    }
                    sendCmd(191, value6);
                    break;
                case R.id.air_xts_ac /* 2131427439 */:
                    int value7 = DataCanbus.DATA[88];
                    if (value7 == 1) {
                        value7 = 0;
                    } else if (value7 == 0) {
                        value7 = 1;
                    }
                    sendCmd(190, value7);
                    break;
                case R.id.air_xts_sync /* 2131427441 */:
                    int value8 = DataCanbus.DATA[92];
                    if (value8 == 1) {
                        value8 = 0;
                    } else if (value8 == 0) {
                        value8 = 1;
                    }
                    sendCmd(179, value8);
                    break;
                case R.id.air_xts_mode_foot /* 2131427443 */:
                    int value9 = DataCanbus.DATA[97];
                    if (value9 == 1) {
                        value9 = 0;
                    } else if (value9 == 0) {
                        value9 = 1;
                    }
                    sendCmd(181, value9);
                    break;
                case R.id.air_xts_mode_body /* 2131427444 */:
                    int value10 = DataCanbus.DATA[96];
                    if (value10 == 1) {
                        value10 = 0;
                    } else if (value10 == 0) {
                        value10 = 1;
                    }
                    sendCmd(180, value10);
                    break;
                case R.id.air_xts_mode_win /* 2131427445 */:
                    int value11 = DataCanbus.DATA[95];
                    if (value11 == 1) {
                        value11 = 0;
                    } else if (value11 == 0) {
                        value11 = 1;
                    }
                    sendCmd(182, value11);
                    break;
                case R.id.air_xts_rearlock /* 2131427446 */:
                    int value12 = DataCanbus.DATA[94];
                    if (value12 == 1) {
                        value12 = 0;
                    } else if (value12 == 0) {
                        value12 = 1;
                    }
                    sendCmd(188, value12);
                    break;
                case R.id.btn_air_temp_right_plus /* 2131427449 */:
                    sendCmd(185, 1);
                    break;
                case R.id.btn_air_temp_right_minus /* 2131427451 */:
                    sendCmd(185, 0);
                    break;
                case R.id.air_xts_steer_hot /* 2131427453 */:
                    int value13 = DataCanbus.DATA[106];
                    if (value13 == 1) {
                        value13 = 0;
                    } else if (value13 == 0) {
                        value13 = 1;
                    }
                    sendCmd(172, value13);
                    break;
                case R.id.air_xts_clear /* 2131427465 */:
                    int value14 = DataCanbus.DATA[104];
                    if (value14 == 1) {
                        value14 = 0;
                    } else if (value14 == 0) {
                        value14 = 1;
                    }
                    sendCmd(175, value14);
                    break;
                case R.id.air_xts_front_hot /* 2131427466 */:
                    int value15 = DataCanbus.DATA[108];
                    if (value15 == 1) {
                        value15 = 0;
                    } else if (value15 == 0) {
                        value15 = 1;
                    }
                    sendCmd(170, value15);
                    break;
                case R.id.air_xts_aqs /* 2131427467 */:
                    int value16 = DataCanbus.DATA[102];
                    if (value16 == 1) {
                        value16 = 0;
                    } else if (value16 == 0) {
                        value16 = 1;
                    }
                    sendCmd(176, value16);
                    break;
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterSeatHeatRight() {
        int value = DataCanbus.DATA[109];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
                break;
            case 2:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
                break;
            case 3:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                break;
        }
    }

    
    public void mUpdaterSeatHeatLeft() {
        int value = DataCanbus.DATA[107];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                break;
            case 2:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
                break;
            case 3:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                break;
        }
    }

    
    public void mUpdateAirTempLeft() {
        int unit = DataCanbus.DATA[66];
        int temp = DataCanbus.DATA[99];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == 31) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp * 5) + 155) * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(((temp + 59) * 1.0f) + "℉");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int unit = DataCanbus.DATA[66];
        int temp = DataCanbus.DATA[100];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == 31) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((temp * 5) + 155) * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(((temp + 59) * 1.0f) + "℉");
            }
        }
    }

    private void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[90];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[92];
        findViewById(R.id.air_xts_sync).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
    }

    
    public void mUpdateRearLockOn() {
        int acOn = DataCanbus.DATA[94];
        findViewById(R.id.air_xts_rearlock).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_rearlock_n : R.drawable.ic_xts_rearlock_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[88];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[87];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[89];
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        }
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[93];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[98];
        if (leave < 0) {
            leave = 0;
        }
        if (leave > 7) {
            leave = 7;
        }
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }

    
    public void mUpdaterClearOn() {
        int acOn = DataCanbus.DATA[104];
        findViewById(R.id.air_xts_clear).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_clear_air_n : R.drawable.ic_xts_clear_air_p);
    }

    
    public void mUpdaterSteerHeatOn() {
        int acOn = DataCanbus.DATA[106];
        findViewById(R.id.air_xts_steer_hot).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_steer_hot_n : R.drawable.ic_xts_steer_hot_p);
    }

    
    public void mUpdaterFGlassHeatOn() {
        int acOn = DataCanbus.DATA[108];
        findViewById(R.id.air_xts_front_hot).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_fronthot_n : R.drawable.ic_xts_fronthot_p);
    }

    
    public void mUpdaterAQSOn() {
        int acOn = DataCanbus.DATA[102];
        findViewById(R.id.air_xts_aqs).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_aqs_n : R.drawable.ic_xts_aqs_p);
    }

    
    public void mUpdaterBlowBodyLeftOn() {
        int acOn = DataCanbus.DATA[96];
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
    }

    
    public void mUpdaterBlowFootLeftOn() {
        int acOn = DataCanbus.DATA[97];
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
    }

    
    public void mUpdaterBlowWindow() {
        int acOn = DataCanbus.DATA[95];
        findViewById(R.id.air_xts_mode_win).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
    }
}
