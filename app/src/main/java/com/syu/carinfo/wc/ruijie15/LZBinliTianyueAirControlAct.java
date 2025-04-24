package com.syu.carinfo.wc.ruijie15;

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
public class LZBinliTianyueAirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_xts_mode_foot_n;
            int i2 = R.drawable.ic_xts_mode_body_n;
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    LZBinliTianyueAirControlAct.this.mUpdatePowerOn();
                    break;
                case 11:
                    LZBinliTianyueAirControlAct.this.mUpdateAcOn();
                    break;
                case 12:
                    LZBinliTianyueAirControlAct.this.mUpdateCycle();
                    break;
                case 13:
                    LZBinliTianyueAirControlAct.this.mUpdateAutoOn();
                    break;
                case 16:
                    LZBinliTianyueAirControlAct.this.mUpdateRearDefrost();
                    break;
                case 18:
                    if (LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_win) != null) {
                        LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_win).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
                        break;
                    }
                case 19:
                    if (LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_body) != null) {
                        LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_body).setBackgroundResource(value == 0 ? 2130842750 : 2130842751);
                        break;
                    }
                case 20:
                    if (LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_foot) != null) {
                        View findViewById = LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_foot);
                        if (value != 0) {
                            i = R.drawable.ic_xts_mode_foot_p;
                        }
                        findViewById.setBackgroundResource(i);
                        break;
                    }
                case 21:
                    LZBinliTianyueAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 22:
                    if (LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_win_right) != null) {
                        LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_win_right).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
                        break;
                    }
                case 23:
                    if (LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_body_right) != null) {
                        View findViewById2 = LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_body_right);
                        if (value != 0) {
                            i2 = 2130842751;
                        }
                        findViewById2.setBackgroundResource(i2);
                        break;
                    }
                case 24:
                    if (LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_foot_right) != null) {
                        View findViewById3 = LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_mode_foot_right);
                        if (value != 0) {
                            i = R.drawable.ic_xts_mode_foot_p;
                        }
                        findViewById3.setBackgroundResource(i);
                        break;
                    }
                case 25:
                    LZBinliTianyueAirControlAct.this.mUpdaterAirWindLevelRight();
                    break;
                case 26:
                    if (LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_auto_right) != null) {
                        LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_auto_right).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
                        break;
                    }
                case 27:
                    LZBinliTianyueAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    LZBinliTianyueAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 29:
                    switch (value) {
                        case 0:
                            LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                            break;
                        case 1:
                            LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                            break;
                        case 2:
                            LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
                            break;
                        case 3:
                            LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                            break;
                    }
                case 30:
                    switch (value) {
                        case 0:
                            LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                            break;
                        case 1:
                            LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
                            break;
                        case 2:
                            LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
                            break;
                        case 3:
                            LZBinliTianyueAirControlAct.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                            break;
                    }
                case 37:
                    LZBinliTianyueAirControlAct.this.mUpdateAirTempLeft();
                    LZBinliTianyueAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 53:
                    LZBinliTianyueAirControlAct.this.mUpdateMaxAcOn();
                    break;
                case 62:
                    LZBinliTianyueAirControlAct.this.mUpdateDualOn();
                    break;
                case 65:
                    LZBinliTianyueAirControlAct.this.mUpdateFrontDefrost();
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
        //setContentView(R.layout.layout_0453_lz_binli_tianyue_air_control);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_sync).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_maxac).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto_right).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn_right).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_win).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_win_right).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        DataCanbus.PROXY.cmd(1, new int[]{3}, null, null);
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
        boolean flag = false;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 1;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 2;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 15;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 14;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
            case R.id.air_xts_seathot_right /* 2131427435 */:
                flag = true;
                try {
                    startActivity(new Intent(this, (Class<?>) LZBinliTianyueSeatControlAct.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 11;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 7;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 9;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 5;
                break;
            case R.id.air_xts_maxac /* 2131427440 */:
                data0 = 6;
                break;
            case R.id.air_xts_sync /* 2131427441 */:
                data0 = 8;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data0 = 19;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 18;
                break;
            case R.id.air_xts_mode_win /* 2131427445 */:
                data0 = 17;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 3;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 4;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                data0 = 10;
                break;
            case R.id.air_xts_mode_win_right /* 2131428576 */:
                data0 = 24;
                break;
            case R.id.air_xts_mode_body_right /* 2131428577 */:
                data0 = 25;
                break;
            case R.id.air_xts_mode_foot_right /* 2131428578 */:
                data0 = 26;
                break;
            case R.id.air_xts_auto_right /* 2131428584 */:
                data0 = 12;
                break;
            case R.id.dj_xts_air_win_plus_btn_right /* 2131428617 */:
                data0 = 21;
                break;
            case R.id.dj_xts_air_win_minuts_btn_right /* 2131428619 */:
                data0 = 22;
                break;
        }
        if (event.getAction() == 0 && !flag) {
            sendCmd(20, data0);
            return false;
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateMaxAcOn() {
        int power = DataCanbus.DATA[53];
        findViewById(R.id.air_xts_maxac).setBackgroundResource(power == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
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
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("High");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("None");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 0.5f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp * 9) / 10) + 32) + "℉");
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
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("High");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("None");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 0.5f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((temp * 9) / 10) + 32) + "℉");
            }
        }
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[13];
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }

    
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[62];
        if (findViewById(R.id.air_xts_sync) != null) {
            findViewById(R.id.air_xts_sync).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
        }
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[10];
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (findViewById(R.id.air_xts_cycle) != null) {
            if (cycle == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
            } else if (cycle == 1) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
            }
        }
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[65];
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        switch (leave) {
            case 0:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_0);
                break;
            case 1:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_1);
                break;
            case 2:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_2);
                break;
            case 3:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_3);
                break;
            case 4:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_4);
                break;
            case 5:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_5);
                break;
            case 6:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_6);
                break;
            case 7:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_7);
                break;
            case 8:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_8);
                break;
            case 9:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_9);
                break;
            case 10:
                findViewById(R.id.air_xts_fan).setBackgroundResource(R.drawable.ic_xts_fan_10);
                break;
        }
    }

    
    public void mUpdaterAirWindLevelRight() {
        int leave = DataCanbus.DATA[25];
        switch (leave) {
            case 0:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_0);
                break;
            case 1:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_1);
                break;
            case 2:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_2);
                break;
            case 3:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_3);
                break;
            case 4:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_4);
                break;
            case 5:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_5);
                break;
            case 6:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_6);
                break;
            case 7:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_7);
                break;
            case 8:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_8);
                break;
            case 9:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_9);
                break;
            case 10:
                findViewById(R.id.air_xts_fan_right).setBackgroundResource(R.drawable.ic_xts_fan_10);
                break;
        }
    }
}
