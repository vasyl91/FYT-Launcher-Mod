package com.syu.carinfo.wc.infeinidi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;

public class WcInfeinidiFrontAirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    WcInfeinidiFrontAirControlAct.this.mUpdatePowerOn();
                    break;
                case 11:
                    WcInfeinidiFrontAirControlAct.this.mUpdateAcOn();
                    break;
                case 12:
                    WcInfeinidiFrontAirControlAct.this.mUpdateCycle();
                    break;
                case 13:
                    WcInfeinidiFrontAirControlAct.this.mUpdateAutoOn();
                    break;
                case 14:
                    WcInfeinidiFrontAirControlAct.this.mUpdateDualOn();
                    break;
                case 16:
                    WcInfeinidiFrontAirControlAct.this.mUpdateRearDefrost();
                    break;
                case 18:
                case 19:
                case 20:
                    WcInfeinidiFrontAirControlAct.this.updateBtnSource();
                    break;
                case 21:
                    WcInfeinidiFrontAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 22:
                case 23:
                case 24:
                    WcInfeinidiFrontAirControlAct.this.updateBtnSource_right();
                    break;
                case 27:
                    WcInfeinidiFrontAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    WcInfeinidiFrontAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 29:
                    WcInfeinidiFrontAirControlAct.this.mUpdaterSeatHeatLeft();
                    break;
                case 30:
                    WcInfeinidiFrontAirControlAct.this.mUpdaterSeatHeatRight();
                    break;
                case 65:
                    WcInfeinidiFrontAirControlAct.this.mUpdateFrontDefrost();
                    break;
                case 67:
                    WcInfeinidiFrontAirControlAct.this.mUpdateRearLockOn();
                    break;
                case 72:
                    WcInfeinidiFrontAirControlAct.this.mUpdateUpWin();
                    break;
                case 79:
                    WcInfeinidiFrontAirControlAct.this.mUpdateForest();
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_443_WC_12Cedric_CD /* 7143867 */:
            case FinalCanbus.CAR_443_WC_12Cedric /* 7209403 */:
                //setContentView(R.layout.layout_439_tianlai_airfront_control_hp);
                break;
            default:
                String platform = SystemProperties.get("ro.fyt.platform", "");
                if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform) || "6318".equals(platform)) {
                    //setContentView(R.layout.layout_0443_wc_infeinidi_air_control);
                    break;
                } else {
                    //setContentView(R.layout.layout_0443_wc_infeinidi_air_control_7731);
                    break;
                }
        }
        init();
    }

    private void init() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_443_WC_12Cedric_CD /* 7143867 */:
            case FinalCanbus.CAR_443_WC_12Cedric /* 7209403 */:
                ((Button) findViewById(R.id.air_cycle_outer)).setOnTouchListener(this);
                ((Button) findViewById(R.id.air_cycle_inter)).setOnTouchListener(this);
                ((Button) findViewById(R.id.air_xts_mode)).setOnTouchListener(this);
                break;
            default:
                findViewById(R.id.air_xts_mode_left).setOnTouchListener(this);
                findViewById(R.id.air_xts_blowup).setOnTouchListener(this);
                findViewById(R.id.air_xts_forest).setOnTouchListener(this);
                findViewById(R.id.air_xts_mode_right).setOnTouchListener(this);
                findViewById(R.id.air_xts_rearpage).setOnTouchListener(this);
                findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
                break;
        }
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        if (findViewById(R.id.air_xts_seathot_left) != null) {
            findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_seathot_right) != null) {
            findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_rearlock) != null) {
            findViewById(R.id.air_xts_rearlock).setOnTouchListener(this);
        }
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
        boolean flag = false;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 13;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 14;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 12;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 11;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data0 = 17;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
            case R.id.air_xts_mode_left /* 2131428283 */:
                data0 = 21;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                data0 = 18;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 4;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 7;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 5;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 2;
                break;
            case R.id.air_xts_rearlock /* 2131427446 */:
                data0 = 34;
                break;
            case R.id.air_xts_rearpage /* 2131427448 */:
                flag = true;
                try {
                    if (event.getAction() == 0) {
                        sendCmd(34, 1);
                        sendCmd(34, 0);
                    }
                    startActivity(new Intent(this, (Class<?>) WcInfeinidiRearAirControlAct.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 15;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 16;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                data0 = 6;
                break;
            case R.id.air_xts_dual /* 2131427566 */:
                data0 = 41;
                break;
            case R.id.air_xts_mode_right /* 2131428024 */:
                data0 = 36;
                break;
            case R.id.air_cycle_outer /* 2131428106 */:
                if (((DataCanbus.DATA[12] >> 1) & 1) == 1) {
                    data0 = 7;
                    break;
                }
            case R.id.air_cycle_inter /* 2131428107 */:
                if (((DataCanbus.DATA[12] >> 1) & 1) == 0) {
                    data0 = 7;
                    break;
                }
            case R.id.air_xts_blowup /* 2131428543 */:
                data0 = 57;
                break;
            case R.id.air_xts_forest /* 2131428544 */:
                data0 = 56;
                break;
        }
        if (!flag && data0 != 0) {
            if (event.getAction() == 0) {
                sendCmd(data0, 1);
            } else if (event.getAction() == 1) {
                sendCmd(data0, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateRearLockOn() {
        int power = DataCanbus.DATA[67];
        if (findViewById(R.id.air_xts_rearlock) != null) {
            findViewById(R.id.air_xts_rearlock).setBackgroundResource(power == 0 ? R.drawable.ic_xts_rearlock_n : R.drawable.ic_xts_rearlock_p);
        }
    }

    
    public void mUpdaterSeatHeatLeft() {
        int value = DataCanbus.DATA[29];
        if (findViewById(R.id.air_xts_seathot_left) != null) {
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
    }

    
    public void mUpdaterSeatHeatRight() {
        int value = DataCanbus.DATA[30];
        if (findViewById(R.id.air_xts_seathot_right) != null) {
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
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                return;
            }
            int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
            if (TempUnit == 1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp * 9) / 10) + 32) + "℉");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 0.5f) + "℃");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                return;
            }
            int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
            if (TempUnit == 1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((temp * 9) / 10) + 32) + "℉");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 0.5f) + "℃");
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
        int acOn = DataCanbus.DATA[14];
        if (findViewById(R.id.air_xts_dual) != null) {
            findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
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

    
    public void mUpdateForest() {
        int power = DataCanbus.DATA[79];
        if (findViewById(R.id.air_xts_forest) != null) {
            findViewById(R.id.air_xts_forest).setBackgroundResource(power == 0 ? R.drawable.ic_xts_forest_n : R.drawable.ic_xts_forest_p);
        }
    }

    
    public void mUpdateUpWin() {
        int power = DataCanbus.DATA[72];
        if (findViewById(R.id.air_xts_blowup) != null) {
            findViewById(R.id.air_xts_blowup).setBackgroundResource(power == 0 ? R.drawable.ic_xts_blowup_n : R.drawable.ic_xts_blowup_p);
        }
    }

    
    public void mUpdateCycle() {
        int cycle = (DataCanbus.DATA[12] >> 1) & 1;
        int auto = (DataCanbus.DATA[12] >> 0) & 1;
        if (findViewById(R.id.air_xts_cycle) != null) {
            if (auto == 1) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycleauto_2);
                return;
            } else if (cycle == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycleauto_0);
                return;
            } else {
                if (cycle == 1) {
                    findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycleauto_1);
                    return;
                }
                return;
            }
        }
        if (cycle == 0) {
            findViewById(R.id.air_cycle_outer).setBackgroundResource(R.drawable.ic_xts_cycle_out_p);
            findViewById(R.id.air_cycle_inter).setBackgroundResource(R.drawable.ic_cycle_all_n);
        } else if (cycle == 1) {
            findViewById(R.id.air_cycle_outer).setBackgroundResource(R.drawable.ic_xts_cycle_n);
            findViewById(R.id.air_cycle_inter).setBackgroundResource(R.drawable.ic_cycle_all_p);
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
        if (leave < 0) {
            leave = 0;
        }
        if (leave > 7) {
            leave = 7;
        }
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }

    
    public void updateBtnSource_right() {
        int body_right = DataCanbus.DATA[23];
        int foot_right = DataCanbus.DATA[24];
        int window_right = DataCanbus.DATA[22];
        int mode_right = 0;
        if (foot_right == 1) {
            mode_right = 0 | 1;
        } else if (foot_right == 0) {
            mode_right = 0 & 254;
        }
        if (body_right == 1) {
            mode_right |= 2;
        } else if (body_right == 0) {
            mode_right &= 253;
        }
        if (window_right == 1) {
            mode_right |= 4;
        } else if (body_right == 0) {
            mode_right &= 251;
        }
        if (findViewById(R.id.air_xts_mode_right) != null) {
            switch (mode_right) {
                case 0:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_xts_mode_null);
                    break;
                case 1:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_xts_mode_foot);
                    break;
                case 2:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_xts_mode_body);
                    break;
                case 3:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
                    break;
                case 4:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_xts_mode_win);
                    break;
                case 5:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
                    break;
                case 6:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_xts_mode_body_win);
                    break;
                case 7:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_xts_mode_foot_body_win);
                    break;
                default:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_xts_mode_null);
                    break;
            }
        }
    }

    
    public void updateBtnSource() {
        int window = DataCanbus.DATA[18];
        int foot = DataCanbus.DATA[20];
        int body = DataCanbus.DATA[19];
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
        if (findViewById(R.id.air_xts_mode_left) != null) {
            switch (mode) {
                case 0:
                    findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_null);
                    break;
                case 1:
                    findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_foot);
                    break;
                case 2:
                    findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_body);
                    break;
                case 3:
                    findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
                    break;
                case 4:
                    findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_win);
                    break;
                case 5:
                    findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
                    break;
                case 6:
                    findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_body_win);
                    break;
                case 7:
                    findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_foot_body_win);
                    break;
                default:
                    findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_null);
                    break;
            }
        }
    }
}
