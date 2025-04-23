package com.syu.carinfo.wc.ruijie15;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0334_RZC_XP1_Focus2015;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;
import com.syu.util.HandlerUI;

public class FordMustangAirControlAct_Rzc extends Activity implements View.OnTouchListener {
    public static FordMustangAirControlAct_Rzc mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 15:
                    FordMustangAirControlAct_Rzc.this.mUpdatePowerOn();
                    break;
                case 16:
                    FordMustangAirControlAct_Rzc.this.mUpdateAcOn();
                    break;
                case 17:
                case 56:
                    FordMustangAirControlAct_Rzc.this.mUpdateFrontDefrost();
                    break;
                case 18:
                    FordMustangAirControlAct_Rzc.this.mUpdateCycle();
                    break;
                case 20:
                    FordMustangAirControlAct_Rzc.this.updateBtnSource();
                    if (DataCanbus.DATA[1000] != 3080526 && FordMustangAirControlAct_Rzc.this.findViewById(R.id.air_xts_mode_win) != null) {
                        FordMustangAirControlAct_Rzc.this.findViewById(R.id.air_xts_mode_win).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
                        break;
                    }
                case 21:
                    FordMustangAirControlAct_Rzc.this.updateBtnSource();
                    if (DataCanbus.DATA[1000] != 3080526 && FordMustangAirControlAct_Rzc.this.findViewById(R.id.air_xts_mode_body) != null) {
                        FordMustangAirControlAct_Rzc.this.findViewById(R.id.air_xts_mode_body).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
                        break;
                    }
                case 22:
                    FordMustangAirControlAct_Rzc.this.updateBtnSource();
                    if (DataCanbus.DATA[1000] != 3080526 && FordMustangAirControlAct_Rzc.this.findViewById(R.id.air_xts_mode_foot) != null) {
                        FordMustangAirControlAct_Rzc.this.findViewById(R.id.air_xts_mode_foot).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
                        break;
                    }
                case 23:
                    FordMustangAirControlAct_Rzc.this.mUpdaterAirWindLevelLeft();
                    break;
                case 24:
                    FordMustangAirControlAct_Rzc.this.mUpdateAirTempLeft();
                    break;
                case 25:
                    FordMustangAirControlAct_Rzc.this.mUpdateAirTempRight();
                    break;
                case 26:
                    FordMustangAirControlAct_Rzc.this.mUpdateDualOn();
                    break;
                case 27:
                    FordMustangAirControlAct_Rzc.this.mUpdateMaxAcOn();
                    break;
                case 28:
                    FordMustangAirControlAct_Rzc.this.mUpdateAirTempLeft();
                    FordMustangAirControlAct_Rzc.this.mUpdateAirTempRight();
                    break;
                case 48:
                    FordMustangAirControlAct_Rzc.this.mUpdateRearDefrost();
                    break;
                case 54:
                    FordMustangAirControlAct_Rzc.this.mUpdaterSeatHeatLeft();
                    break;
                case 55:
                    FordMustangAirControlAct_Rzc.this.mUpdaterSeatHeatRight();
                    break;
            }
        }
    };

    private void sendCmd(int cmd) {
        Callback_0334_RZC_XP1_Focus2015.jump = false;
        DataCanbus.PROXY.cmd(1, new int[]{172, cmd}, null, null);
        HandlerUI.getInstance().postDelayed(new Runnable() { 
            @Override
            public void run() {
                DataCanbus.PROXY.cmd(1, new int[]{172}, null, null);
            }
        }, 100L);
        mInstance = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 3080526) {
            //setContentView(R.layout.layout_0334_rzc_12f150_cd_air_control);
        } else if (DataCanbus.DATA[1000] == 2359630 || DataCanbus.DATA[1000] == 1048910) {
            //setContentView(R.layout.layout_0334_rzc_09mustang_air_control);
        } else {
            //setContentView(R.layout.layout_0334_rzc_mustang_cd_air_control);
        }
        init();
    }

    private void init() {
        if (findViewById(R.id.air_xts_mode_foot) != null) {
            findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_footbody) != null) {
            findViewById(R.id.air_xts_mode_footbody).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_footwin) != null) {
            findViewById(R.id.air_xts_mode_footwin).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_body) != null) {
            findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_win) != null) {
            findViewById(R.id.air_xts_mode_win).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode) != null) {
            findViewById(R.id.air_xts_mode).setOnTouchListener(this);
        }
        if (findViewById(R.id.btn_air_temp_left_plus) != null) {
            findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        }
        if (findViewById(R.id.btn_air_temp_left_minus) != null) {
            findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setOnTouchListener(this);
        }
        if (findViewById(R.id.dj_xts_air_win_minuts_btn) != null) {
            findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        }
        if (findViewById(R.id.dj_xts_air_win_plus_btn) != null) {
            findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        }
        if (findViewById(R.id.btn_air_temp_right_plus) != null) {
            findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        }
        if (findViewById(R.id.btn_air_temp_right_minus) != null) {
            findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_cycle) != null) {
            findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_maxac) != null) {
            findViewById(R.id.air_xts_maxac).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_dual) != null) {
            findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_seathot_left) != null) {
            findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_seathot_right) != null) {
            findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addUpdater();
        RJFunc.C_REQUEST_CAR_INFO(33, 0);
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
                data0 = 26;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 27;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 31;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 30;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data0 = 7;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
                data0 = 48;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                data0 = 9;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 3;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                if (DataCanbus.DATA[1000] == 2359630 || DataCanbus.DATA[1000] == 1048910) {
                    data0 = 5;
                    break;
                } else {
                    data0 = 25;
                    break;
                }
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 2;
                break;
            case R.id.air_xts_maxac /* 2131427440 */:
                data0 = 4;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                if (DataCanbus.DATA[1000] == 3080526) {
                    data0 = 36;
                    break;
                } else {
                    data0 = 34;
                    break;
                }
            case R.id.air_xts_mode_body /* 2131427444 */:
                if (DataCanbus.DATA[1000] == 3080526) {
                    data0 = 38;
                    break;
                } else {
                    data0 = 33;
                    break;
                }
            case R.id.air_xts_mode_win /* 2131427445 */:
                data0 = 32;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 28;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 29;
                break;
            case R.id.air_xts_dual /* 2131427460 */:
                data0 = 24;
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                data0 = 37;
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                data0 = 35;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data0 = 6;
                break;
        }
        if (0 == 0 && event.getAction() == 0) {
            sendCmd(data0);
            return false;
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterSeatHeatLeft() {
        int value = DataCanbus.DATA[54];
        if (findViewById(R.id.air_xts_seathot_left) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                    break;
                case 4:
                    ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                    break;
                case 5:
                    ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
                    break;
                case 6:
                    ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                    break;
            }
        }
    }

    
    public void mUpdaterSeatHeatRight() {
        int value = DataCanbus.DATA[55];
        if (findViewById(R.id.air_xts_seathot_right) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                    break;
                case 4:
                    ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
                    break;
                case 5:
                    ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
                    break;
                case 6:
                    ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                    break;
            }
        }
    }

    
    public void updateBtnSource() {
        int window = DataCanbus.DATA[20];
        int foot = DataCanbus.DATA[22];
        int body = DataCanbus.DATA[21];
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
        if (window == 1) {
            mode |= 4;
        } else if (window == 0) {
            mode &= 251;
        }
        if (findViewById(R.id.air_xts_mode) != null) {
            switch (mode) {
                case 0:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                    break;
                case 1:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot);
                    break;
                case 2:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body);
                    break;
                case 3:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
                    break;
                case 4:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_win);
                    break;
                case 5:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
                    break;
                case 6:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body_win);
                    break;
                case 7:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body_win);
                    break;
                default:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                    break;
            }
        }
        if (findViewById(R.id.air_xts_mode_footbody) != null && findViewById(R.id.air_xts_mode_foot) != null && findViewById(R.id.air_xts_mode_body) != null && findViewById(R.id.air_xts_mode_footwin) != null) {
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
            findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
            if (window == 0 && body == 1 && foot == 1) {
                findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
                return;
            }
            if (window == 1 && body == 0 && foot == 1) {
                findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
                return;
            }
            if (window == 0 && body == 1 && foot == 0) {
                findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
            } else if (window == 0 && body == 0 && foot == 1) {
                findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
            }
        }
    }

    
    public void mUpdateMaxAcOn() {
        int power = DataCanbus.DATA[27];
        if (findViewById(R.id.air_xts_maxac) != null) {
            findViewById(R.id.air_xts_maxac).setBackgroundResource(power == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
        }
    }

    
    public void mUpdateAirTempLeft() {
        int value = DataCanbus.DATA[24];
        if (value == 1048576) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
            return;
        }
        if (value == 1048577) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            return;
        }
        if (value == 1048578) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText("None");
        } else if (DataCanbus.DATA[28] == 0) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(value * 0.1f) + "℃");
        } else if (DataCanbus.DATA[28] == 1) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(value / 10) + "℉");
        }
    }

    
    public void mUpdateAirTempRight() {
        int value = DataCanbus.DATA[25];
        if (value == 1048576) {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            return;
        }
        if (value == 1048577) {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            return;
        }
        if (value == 1048578) {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText("None");
        } else if (DataCanbus.DATA[28] == 0) {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(value * 0.1f) + "℃");
        } else if (DataCanbus.DATA[28] == 1) {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(value / 10) + "℉");
        }
    }

    
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[26];
        if (findViewById(R.id.air_xts_dual) != null) {
            findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
        }
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[16];
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[15];
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[18];
        if (findViewById(R.id.air_xts_cycle) != null) {
            if (cycle == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
            } else if (cycle == 1) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
            }
        }
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[17];
        if (DataCanbus.DATA[1000] == 2359630 || DataCanbus.DATA[1000] == 1048910) {
            int front2 = DataCanbus.DATA[56];
            if (findViewById(R.id.air_xts_front) != null) {
                findViewById(R.id.air_xts_front).setBackgroundResource(front2 == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
                return;
            }
            return;
        }
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_maxfront_n : R.drawable.ic_xts_maxfront_p);
        }
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[48];
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[23];
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
