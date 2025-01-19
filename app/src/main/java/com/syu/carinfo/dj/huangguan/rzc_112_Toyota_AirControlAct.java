package com.syu.carinfo.dj.huangguan;

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
import com.syu.ui.air.AirHelper;

public class rzc_112_Toyota_AirControlAct extends Activity implements View.OnTouchListener {
    public static rzc_112_Toyota_AirControlAct mInstance;
    public static boolean mIsFront = false;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 60:
                    rzc_112_Toyota_AirControlAct.this.mUpdaterAirPower();
                    break;
                case 61:
                    rzc_112_Toyota_AirControlAct.this.mUpdaterAirAC();
                    break;
                case 62:
                    rzc_112_Toyota_AirControlAct.this.mUpdateAirCycle();
                    break;
                case 63:
                    rzc_112_Toyota_AirControlAct.this.mUpdateAirAuto();
                    break;
                case 65:
                    rzc_112_Toyota_AirControlAct.this.mUpdateAirdual();
                    break;
                case 70:
                    rzc_112_Toyota_AirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 71:
                    rzc_112_Toyota_AirControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 72:
                    rzc_112_Toyota_AirControlAct.this.mUpdaterAirTempRight();
                    break;
                case 152:
                    rzc_112_Toyota_AirControlAct.this.mUpdateAirRearDefrost();
                    break;
                case 163:
                    rzc_112_Toyota_AirControlAct.this.mUpdaterAirClean();
                    break;
                case 164:
                    rzc_112_Toyota_AirControlAct.this.mUpdaterAirCleanFlower();
                    break;
                case 165:
                    rzc_112_Toyota_AirControlAct.this.mUpdaterAirCleanIce();
                    break;
                case 166:
                    rzc_112_Toyota_AirControlAct.this.mUpdaterAirCleanSwing();
                    break;
                case 167:
                    rzc_112_Toyota_AirControlAct.this.mUpdateAirBlow();
                    break;
                case 169:
                    rzc_112_Toyota_AirControlAct.this.mUpdateAirFrontDefrost();
                    break;
                case 179:
                    if (rzc_112_Toyota_AirControlAct.this.findViewById(R.id.air_xts_rear_light) != null) {
                        rzc_112_Toyota_AirControlAct.this.findViewById(R.id.air_xts_rear_light).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_light_n : R.drawable.ic_xts_rear_light_p);
                        break;
                    }
                case 180:
                    if (rzc_112_Toyota_AirControlAct.this.findViewById(R.id.air_xts_econ) != null) {
                        rzc_112_Toyota_AirControlAct.this.findViewById(R.id.air_xts_econ).setBackgroundResource(value == 0 ? R.drawable.ic_xts_econ_n : R.drawable.ic_xts_econ_p);
                        break;
                    }
                case 181:
                    rzc_112_Toyota_AirControlAct.this.mUpdaterAirTempLeft();
                    rzc_112_Toyota_AirControlAct.this.mUpdaterAirTempRight();
                    break;
                case 222:
                    if (rzc_112_Toyota_AirControlAct.this.findViewById(R.id.air_xts_manual) != null) {
                        switch (value) {
                            case 0:
                                rzc_112_Toyota_AirControlAct.this.findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_0);
                                break;
                            case 1:
                                rzc_112_Toyota_AirControlAct.this.findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_4);
                                break;
                            case 2:
                                rzc_112_Toyota_AirControlAct.this.findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_6);
                                break;
                            case 3:
                                rzc_112_Toyota_AirControlAct.this.findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_1);
                                break;
                            case 4:
                                rzc_112_Toyota_AirControlAct.this.findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_3);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0112_rzc_toyota_all_carairset);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_clear).setOnTouchListener(this);
        findViewById(R.id.air_xts_ion).setOnTouchListener(this);
        findViewById(R.id.air_xts_front_hot).setOnTouchListener(this);
        findViewById(R.id.air_xts_front_blow_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode).setOnTouchListener(this);
        findViewById(R.id.air_cycle_outer).setOnTouchListener(this);
        findViewById(R.id.air_cycle_inter).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
        removeUpdater();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        int data1 = 0;
        int data2 = 0;
        int data3 = 0;
        int data4 = 0;
        int data5 = 0;
        boolean flag = false;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                if (SystemProperties.getBoolean("persist.fyt.reversetemp", false)) {
                    data4 = 2;
                    break;
                } else {
                    data3 = 2;
                    break;
                }
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                if (SystemProperties.getBoolean("persist.fyt.reversetemp", false)) {
                    data4 = 1;
                    break;
                } else {
                    data3 = 1;
                    break;
                }
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 128;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data1 = 1;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data1 = 2;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
                data0 = 64;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 32;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data2 = 1;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 16;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 2;
                break;
            case R.id.air_xts_rearpage /* 2131427448 */:
                flag = true;
                try {
                    startActivity(new Intent(this, rzc_112_Toyota_AirRearControlAct.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                if (SystemProperties.getBoolean("persist.fyt.reversetemp", false)) {
                    data3 = 2;
                    break;
                } else {
                    data4 = 2;
                    break;
                }
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                if (SystemProperties.getBoolean("persist.fyt.reversetemp", false)) {
                    data3 = 1;
                    break;
                } else {
                    data4 = 1;
                    break;
                }
            case R.id.air_xts_dual /* 2131427460 */:
                data1 = 8;
                break;
            case R.id.air_xts_clear /* 2131427465 */:
                data1 = 32;
                break;
            case R.id.air_xts_front_hot /* 2131427466 */:
                data1 = 16;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data1 = 4;
                break;
            case R.id.air_cycle_outer /* 2131427557 */:
                if (DataCanbus.DATA[62] == 1) {
                    data2 = 1;
                    break;
                } else {
                    flag = true;
                    break;
                }
            case R.id.air_cycle_inter /* 2131427558 */:
                if (DataCanbus.DATA[62] == 0) {
                    data2 = 1;
                    break;
                } else {
                    flag = true;
                    break;
                }
            case R.id.air_xts_ion /* 2131427559 */:
                data1 = 128;
                break;
            case R.id.air_xts_front_blow_auto /* 2131427560 */:
                data1 = 64;
                break;
            case R.id.air_xts_econ /* 2131427561 */:
                data4 = 4;
                break;
            case R.id.air_xts_manual /* 2131427562 */:
                data5 = 128;
                break;
            case R.id.air_xts_rear_light /* 2131427563 */:
                data4 = 8;
                break;
        }
        if (!flag) {
            switch (event.getAction()) {
                case 0:
                    DataCanbus.PROXY.cmd(41, new int[]{data0, data1, data2, data3, data4, data5}, null, null);
                    break;
                case 1:
                    DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    break;
            }
            return false;
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[222].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[222].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAirClean() {
        int value = DataCanbus.DATA[163];
        if (findViewById(R.id.air_xts_clear) != null) {
            findViewById(R.id.air_xts_clear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_clear_air_n : R.drawable.ic_xts_clear_air_p);
        }
    }

    
    public void mUpdaterAirCleanFlower() {
        int value = DataCanbus.DATA[164];
        if (findViewById(R.id.air_xts_ion) != null) {
            findViewById(R.id.air_xts_ion).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ion_n : R.drawable.ic_xts_ion_p);
        }
    }

    
    public void mUpdaterAirCleanIce() {
        int value = DataCanbus.DATA[165];
        if (findViewById(R.id.air_xts_front_hot) != null) {
            findViewById(R.id.air_xts_front_hot).setBackgroundResource(value == 0 ? R.drawable.ic_xts_fronthot_n : R.drawable.ic_xts_fronthot_p);
        }
    }

    
    public void mUpdaterAirCleanSwing() {
        int value = DataCanbus.DATA[166];
        if (findViewById(R.id.air_xts_front_blow_auto) != null) {
            findViewById(R.id.air_xts_front_blow_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_blow_auto_n : R.drawable.ic_xts_blow_auto_p);
        }
    }

    
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[71];
        int unit = DataCanbus.DATA[181];
        if (findViewById(R.id.tv_air_temp_left) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("--");
                    break;
                default:
                    if (unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "℉");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "℃");
                        break;
                    }
            }
        }
    }

    
    public void mUpdaterAirTempRight() {
        int temp = DataCanbus.DATA[72];
        int unit = DataCanbus.DATA[181];
        if (findViewById(R.id.tv_air_temp_right) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("--");
                    break;
                default:
                    if (unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "℉");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "°C");
                        break;
                    }
            }
        }
    }

    
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[70];
        if (level >= 0 && level <= 7) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(String.valueOf(level));
        }
    }

    
    public void mUpdateAirAuto() {
        int value = DataCanbus.DATA[63];
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }

    
    public void mUpdateAirdual() {
        int value = DataCanbus.DATA[65];
        if (findViewById(R.id.air_xts_dual) != null) {
            findViewById(R.id.air_xts_dual).setBackgroundResource(value == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
        }
    }

    
    public void mUpdateAirCycle() {
        int i = R.drawable.ic_xts_cycle_n;
        int value = DataCanbus.DATA[62];
        if (findViewById(R.id.air_xts_cycle) != null) {
            if (value == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
            } else if (value == 1) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
            }
        }
        if (findViewById(R.id.air_cycle_outer) != null) {
            Button button = findViewById(R.id.air_cycle_outer);
            if (value == 0) {
                i = R.drawable.ic_xts_cycle_out_p;
            }
            button.setBackgroundResource(i);
        }
        if (findViewById(R.id.air_cycle_inter) != null) {
            findViewById(R.id.air_cycle_inter).setBackgroundResource(value == 1 ? R.drawable.ic_cycle_all_p : R.drawable.ic_cycle_all_n);
        }
    }

    
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[61];
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[60];
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    
    public void mUpdateAirFrontDefrost() {
        int value = DataCanbus.DATA[169];
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[152];
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    
    public void mUpdateAirBlow() {
        int value = DataCanbus.DATA[167];
        if (value == 3) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
            return;
        }
        if (value == 5) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
            return;
        }
        if (value == 2) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body);
            return;
        }
        if (value == 1) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot);
        } else if (value == 4) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_win);
        } else {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
        }
    }
}
