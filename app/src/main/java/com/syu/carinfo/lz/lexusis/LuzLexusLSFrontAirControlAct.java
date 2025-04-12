package com.syu.carinfo.lz.lexusis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;

public class LuzLexusLSFrontAirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    LuzLexusLSFrontAirControlAct.this.mUpdatePowerOn();
                    break;
                case 11:
                    LuzLexusLSFrontAirControlAct.this.mUpdateAcOn();
                    break;
                case 12:
                case 54:
                    LuzLexusLSFrontAirControlAct.this.mUpdateCycle();
                    break;
                case 13:
                    LuzLexusLSFrontAirControlAct.this.mUpdateAutoOn();
                    break;
                case 14:
                    LuzLexusLSFrontAirControlAct.this.mUpdateDualOn();
                    break;
                case 15:
                    LuzLexusLSFrontAirControlAct.this.mUpdateFrontDefrost();
                    break;
                case 16:
                    LuzLexusLSFrontAirControlAct.this.mUpdateRearDefrost();
                    break;
                case 17:
                    LuzLexusLSFrontAirControlAct.this.mUpdateFrontHotOn();
                    break;
                case 18:
                case 19:
                case 20:
                    LuzLexusLSFrontAirControlAct.this.updateBtnSource();
                    break;
                case 21:
                    LuzLexusLSFrontAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 22:
                case 23:
                case 24:
                    LuzLexusLSFrontAirControlAct.this.updateBtnSourceRight();
                    break;
                case 27:
                    LuzLexusLSFrontAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    LuzLexusLSFrontAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 33:
                case 76:
                    LuzLexusLSFrontAirControlAct.this.mUpdateClearOn();
                    break;
                case 35:
                    LuzLexusLSFrontAirControlAct.this.mUpdaterBlowFrontAutoOn();
                    break;
                case 37:
                    LuzLexusLSFrontAirControlAct.this.mUpdateAirTempLeft();
                    LuzLexusLSFrontAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 38:
                    LuzLexusLSFrontAirControlAct.this.mUpdateRearLockOn();
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
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09 /* 1114565 */:
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09_H /* 1180101 */:
                //setContentView(R.layout.layout_0452_lz_toyota_reiz_air_control);
                break;
            case FinalCanbus.CAR_453_LZ_Toyota_markII_L /* 9634245 */:
            case FinalCanbus.CAR_453_LZ_Toyota_markII_H /* 9699781 */:
                //setContentView(R.layout.layout_0453_lz_toyota_mark2_air_control);
                break;
            default:
                //setContentView(R.layout.layout_0452_lz_lexus_ls_air_control);
                break;
        }
        init();
    }

    private void init() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09 /* 1114565 */:
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09_H /* 1180101 */:
                findViewById(R.id.air_cycle_outer).setOnTouchListener(this);
                findViewById(R.id.air_cycle_inter).setOnTouchListener(this);
                findViewById(R.id.air_xts_dual).setOnTouchListener(this);
                break;
            case FinalCanbus.CAR_453_LZ_Toyota_markII_L /* 9634245 */:
            case FinalCanbus.CAR_453_LZ_Toyota_markII_H /* 9699781 */:
                findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
                findViewById(R.id.air_xts_front_blow_auto).setOnTouchListener(this);
                findViewById(R.id.air_xts_outside).setOnTouchListener(this);
                break;
            default:
                findViewById(R.id.air_xts_dual).setOnTouchListener(this);
                findViewById(R.id.air_xts_front_hot).setOnTouchListener(this);
                findViewById(R.id.air_xts_clear).setOnTouchListener(this);
                findViewById(R.id.air_xts_front_blow_auto).setOnTouchListener(this);
                findViewById(R.id.air_xts_rearlock).setOnTouchListener(this);
                findViewById(R.id.air_xts_mode_right).setOnTouchListener(this);
                findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
                if (LauncherApplication.getConfiguration() != 1) {
                    findViewById(R.id.air_xts_rearpage).setOnTouchListener(this);
                    break;
                }
        }
        if (LauncherApplication.getConfiguration() == 1) {
            findViewById(R.id.air_xts_mode_left).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_xts_mode).setOnTouchListener(this);
        }
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
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
                data0 = 3;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 2;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 9;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 10;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
            case R.id.air_xts_mode_left /* 2131428283 */:
                data0 = 36;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 21;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 25;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 18;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 23;
                break;
            case R.id.air_xts_rearlock /* 2131427446 */:
                data0 = 57;
                break;
            case R.id.air_xts_rearpage /* 2131427448 */:
                flag = true;
                try {
                    startActivity(new Intent(this, LuzLexusLSRearAirControlAct.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 5;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 4;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                data0 = 20;
                break;
            case R.id.air_xts_dual /* 2131427566 */:
                data0 = 16;
                break;
            case R.id.air_xts_clear /* 2131427569 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460 /* 5308868 */:
                    case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460_H /* 5374404 */:
                        data0 = 39;
                        break;
                    default:
                        data0 = 40;
                        break;
                }
            case R.id.air_xts_front_hot /* 2131427571 */:
                data0 = 38;
                break;
            case R.id.air_xts_front_blow_auto /* 2131427572 */:
                data0 = 60;
                break;
            case R.id.air_xts_mode_right /* 2131428024 */:
                data0 = 37;
                break;
            case R.id.air_cycle_outer /* 2131428106 */:
                if (DataCanbus.DATA[12] == 1) {
                    data0 = 25;
                    break;
                }
            case R.id.air_cycle_inter /* 2131428107 */:
                if (DataCanbus.DATA[12] == 0) {
                    data0 = 25;
                    break;
                }
            case R.id.air_xts_outside /* 2131428634 */:
                data0 = 15;
                break;
        }
        if (!flag) {
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
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateAirTempLeft() {
        int unit = SystemProperties.getInt("persist.fyt.temperature", 0);
        int temp = DataCanbus.DATA[27];
        if (findViewById(R.id.tv_air_temp_left) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp * 5) + 175) * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp * 9) + 635) / 10) + "℉");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int unit = SystemProperties.getInt("persist.fyt.temperature", 0);
        int temp = DataCanbus.DATA[28];
        if (findViewById(R.id.tv_air_temp_right) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((temp * 5) + 175) * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((temp * 9) + 635) / 10) + "℉");
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

    
    public void mUpdateClearOn() {
        if (findViewById(R.id.air_xts_clear) != null) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460 /* 5308868 */:
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460_H /* 5374404 */:
                    int power = DataCanbus.DATA[76];
                    findViewById(R.id.air_xts_clear).setBackgroundResource(power == 0 ? R.drawable.ic_xts_clearair_n : R.drawable.ic_xts_clearair_p);
                    break;
                default:
                    int power2 = DataCanbus.DATA[33];
                    findViewById(R.id.air_xts_clear).setBackgroundResource(power2 == 0 ? R.drawable.ic_xts_clear_air_n : R.drawable.ic_xts_clear_air_p);
                    break;
            }
        }
    }

    
    public void mUpdateFrontHotOn() {
        int power = DataCanbus.DATA[17];
        if (findViewById(R.id.air_xts_front_hot) != null) {
            findViewById(R.id.air_xts_front_hot).setBackgroundResource(power == 0 ? R.drawable.ic_xts_fronthot_n : R.drawable.ic_xts_fronthot_p);
        }
    }

    
    public void mUpdateRearLockOn() {
        int power = DataCanbus.DATA[38];
        if (findViewById(R.id.air_xts_rearlock) != null) {
            findViewById(R.id.air_xts_rearlock).setBackgroundResource(power == 0 ? R.drawable.ic_xts_rearlock_n : R.drawable.ic_xts_rearlock_p);
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
        int auto = DataCanbus.DATA[54];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09 /* 1114565 */:
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09_H /* 1180101 */:
                findViewById(R.id.air_cycle_outer).setOnTouchListener(this);
                findViewById(R.id.air_cycle_inter).setOnTouchListener(this);
                if (cycle == 0) {
                    findViewById(R.id.air_cycle_outer).setBackgroundResource(R.drawable.ic_xts_cycle_out_p);
                    findViewById(R.id.air_cycle_inter).setBackgroundResource(R.drawable.ic_cycle_all_n);
                    break;
                } else if (cycle == 1) {
                    findViewById(R.id.air_cycle_outer).setBackgroundResource(R.drawable.ic_xts_cycle_n);
                    findViewById(R.id.air_cycle_inter).setBackgroundResource(R.drawable.ic_cycle_all_p);
                    break;
                }
            default:
                if (auto == 1) {
                    if (cycle == 0) {
                        findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycleauto_3);
                        break;
                    } else {
                        findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycleauto_2);
                        break;
                    }
                } else if (cycle == 0) {
                    findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycleauto_0);
                    break;
                } else if (cycle == 1) {
                    findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycleauto_1);
                    break;
                }
        }
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[15];
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

    
    public void mUpdaterBlowFrontAutoOn() {
        int rear = DataCanbus.DATA[35];
        if (findViewById(R.id.air_xts_front_blow_auto) != null) {
            findViewById(R.id.air_xts_front_blow_auto).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_blow_auto_n : R.drawable.ic_xts_blow_auto_p);
        }
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
        if (LauncherApplication.getConfiguration() == 1) {
            switch (mode) {
                case 0:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_null);
                    break;
                case 1:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot);
                    break;
                case 2:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_body);
                    break;
                case 3:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot_body);
                    break;
                case 4:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_win);
                    break;
                case 5:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot_win);
                    break;
                case 6:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_body_win);
                    break;
                case 7:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_all);
                    break;
                default:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_null);
                    break;
            }
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

    
    public void updateBtnSourceRight() {
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
        } else if (window_right == 0) {
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
}
