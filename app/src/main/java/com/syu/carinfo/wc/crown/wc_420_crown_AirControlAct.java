package com.syu.carinfo.wc.crown;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;

public class wc_420_crown_AirControlAct extends Activity implements View.OnClickListener {
    public static wc_420_crown_AirControlAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    wc_420_crown_AirControlAct.this.mUpdaterAirPower();
                    break;
                case 11:
                    wc_420_crown_AirControlAct.this.mUpdaterAirAC();
                    break;
                case 12:
                    wc_420_crown_AirControlAct.this.mUpdateAirCycle();
                    break;
                case 13:
                    wc_420_crown_AirControlAct.this.mUpdateAirAuto();
                    break;
                case 14:
                    wc_420_crown_AirControlAct.this.mUpdateAirdual();
                    break;
                case 16:
                    wc_420_crown_AirControlAct.this.mUpdateAirRearDefrost();
                    break;
                case 17:
                    wc_420_crown_AirControlAct.this.mUpdaterAirCleanIce();
                    break;
                case 21:
                    wc_420_crown_AirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 22:
                case 23:
                case 24:
                    wc_420_crown_AirControlAct.this.updateBtnSource();
                    break;
                case 27:
                    wc_420_crown_AirControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 28:
                    wc_420_crown_AirControlAct.this.mUpdaterAirTempRight();
                    break;
                case 33:
                    wc_420_crown_AirControlAct.this.mUpdaterAirClean();
                    break;
                case 35:
                    wc_420_crown_AirControlAct.this.mUpdaterAirCleanSwing();
                    break;
                case 54:
                    if (((Button) wc_420_crown_AirControlAct.this.findViewById(R.id.air_xts_aqs)) != null) {
                        ((Button) wc_420_crown_AirControlAct.this.findViewById(R.id.air_xts_aqs)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_aqs_n : R.drawable.ic_xts_aqs_p);
                        break;
                    }
                case 65:
                    wc_420_crown_AirControlAct.this.mUpdateAirFrontDefrost();
                    break;
                case 76:
                    wc_420_crown_AirControlAct.this.mUpdaterAirCleanFlower();
                    break;
                case 77:
                    wc_420_crown_AirControlAct.this.mUpdateAirBlow();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_ToYoTa_Lexus_06LS460 /* 786852 */:
                //setContentView(R.layout.layout_0420_wc_lexus_ls460_carairset);
                break;
            default:
                //setContentView(R.layout.layout_0420_wc_toyota_crown_carairset);
                break;
        }
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_auto).setOnClickListener(this);
        findViewById(R.id.air_xts_ac).setOnClickListener(this);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_ToYoTa_Lexus_06LS460 /* 786852 */:
                findViewById(R.id.air_xts_cycle).setOnClickListener(this);
                findViewById(R.id.air_xts_mode_right).setOnClickListener(this);
                findViewById(R.id.air_xts_rearpage).setOnClickListener(this);
                findViewById(R.id.air_xts_aqs).setOnClickListener(this);
                break;
            default:
                findViewById(R.id.air_cycle_outer).setOnClickListener(this);
                findViewById(R.id.air_cycle_inter).setOnClickListener(this);
                break;
        }
        findViewById(R.id.air_xts_power).setOnClickListener(this);
        findViewById(R.id.air_xts_dual).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnClickListener(this);
        findViewById(R.id.air_xts_front).setOnClickListener(this);
        findViewById(R.id.air_xts_rear).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnClickListener(this);
        findViewById(R.id.air_xts_clear).setOnClickListener(this);
        findViewById(R.id.air_xts_ion).setOnClickListener(this);
        findViewById(R.id.air_xts_front_hot).setOnClickListener(this);
        findViewById(R.id.air_xts_front_blow_auto).setOnClickListener(this);
        findViewById(R.id.air_xts_mode).setOnClickListener(this);
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
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                DataCanbus.PROXY.cmd(0, 1);
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                DataCanbus.PROXY.cmd(0, 2);
                break;
            case R.id.air_xts_power /* 2131427428 */:
                DataCanbus.PROXY.cmd(0, 5);
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                DataCanbus.PROXY.cmd(0, 14);
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                DataCanbus.PROXY.cmd(0, 13);
                break;
            case R.id.air_xts_mode /* 2131427434 */:
                DataCanbus.PROXY.cmd(0, 11);
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                DataCanbus.PROXY.cmd(0, 6);
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                DataCanbus.PROXY.cmd(0, 7);
                break;
            case R.id.air_xts_front /* 2131427438 */:
                DataCanbus.PROXY.cmd(0, 8);
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                DataCanbus.PROXY.cmd(0, 17);
                break;
            case R.id.air_xts_rearpage /* 2131427448 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, wc_420_lexus_RearAirControlAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                DataCanbus.PROXY.cmd(0, 3);
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                DataCanbus.PROXY.cmd(0, 4);
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                DataCanbus.PROXY.cmd(0, 9);
                break;
            case R.id.air_xts_dual /* 2131427566 */:
                DataCanbus.PROXY.cmd(0, 12);
                break;
            case R.id.air_xts_clear /* 2131427569 */:
                DataCanbus.PROXY.cmd(0, 16);
                break;
            case R.id.air_xts_ion /* 2131427570 */:
                DataCanbus.PROXY.cmd(0, 10);
                break;
            case R.id.air_xts_front_hot /* 2131427571 */:
                DataCanbus.PROXY.cmd(0, 18);
                break;
            case R.id.air_xts_front_blow_auto /* 2131427572 */:
                DataCanbus.PROXY.cmd(0, 15);
                break;
            case R.id.air_xts_mode_right /* 2131428024 */:
                DataCanbus.PROXY.cmd(0, 26);
                break;
            case R.id.air_cycle_outer /* 2131428106 */:
                if (DataCanbus.DATA[12] == 1) {
                    DataCanbus.PROXY.cmd(0, 7);
                    break;
                }
            case R.id.air_cycle_inter /* 2131428107 */:
                if (DataCanbus.DATA[12] == 0) {
                    DataCanbus.PROXY.cmd(0, 7);
                    break;
                }
        }
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAirClean() {
        int value = DataCanbus.DATA[33];
        findViewById(R.id.air_xts_clear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_clear_air_n : R.drawable.ic_xts_clear_air_p);
    }

    
    public void mUpdaterAirCleanFlower() {
        int value = DataCanbus.DATA[76];
        findViewById(R.id.air_xts_ion).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ion_n : R.drawable.ic_xts_ion_p);
    }

    
    public void mUpdaterAirCleanIce() {
        int value = DataCanbus.DATA[17];
        findViewById(R.id.air_xts_front_hot).setBackgroundResource(value == 0 ? R.drawable.ic_xts_fronthot_n : R.drawable.ic_xts_fronthot_p);
    }

    
    public void mUpdaterAirCleanSwing() {
        int value = DataCanbus.DATA[35];
        findViewById(R.id.air_xts_front_blow_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_blow_auto_n : R.drawable.ic_xts_blow_auto_p);
    }

    
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
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
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 2.0f) + "℃");
                    break;
            }
        }
    }

    
    public void mUpdaterAirTempRight() {
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
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
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 2.0f) + "℃");
                    break;
            }
        }
    }

    
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[21];
        if (level >= 0 && level <= 7) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
        }
    }

    
    public void mUpdateAirAuto() {
        int value = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateAirdual() {
        int value = DataCanbus.DATA[14];
        findViewById(R.id.air_xts_dual).setBackgroundResource(value == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
    }

    
    public void mUpdateAirCycle() {
        int i = R.drawable.ic_xts_cycle_n;
        int value = DataCanbus.DATA[12];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_ToYoTa_Lexus_06LS460 /* 786852 */:
                if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
                    Button button = (Button) findViewById(R.id.air_xts_cycle);
                    if (value == 1) {
                        i = R.drawable.ic_xts_cycle_p;
                    }
                    button.setBackgroundResource(i);
                    break;
                }
            default:
                if (((Button) findViewById(R.id.air_cycle_outer)) != null) {
                    Button button2 = (Button) findViewById(R.id.air_cycle_outer);
                    if (value == 0) {
                        i = R.drawable.ic_xts_cycle_out_p;
                    }
                    button2.setBackgroundResource(i);
                }
                if (((Button) findViewById(R.id.air_cycle_inter)) != null) {
                    ((Button) findViewById(R.id.air_cycle_inter)).setBackgroundResource(value == 1 ? R.drawable.ic_cycle_all_p : R.drawable.ic_cycle_all_n);
                    break;
                }
        }
    }

    
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdateAirFrontDefrost() {
        int value = DataCanbus.DATA[65];
        findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    
    public void mUpdateAirBlow() {
        int value = DataCanbus.DATA[77];
        if (value == 3) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
            return;
        }
        if (value == 4) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
            return;
        }
        if (value == 1) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body);
        } else if (value == 2) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot);
        } else {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
        }
    }

    
    public void updateBtnSource() {
        int window = DataCanbus.DATA[22];
        int body = DataCanbus.DATA[23];
        int foot = DataCanbus.DATA[24];
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
        if (findViewById(R.id.air_xts_mode_right) != null) {
            switch (mode) {
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
