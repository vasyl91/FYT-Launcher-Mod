package com.syu.carinfo.wc.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class Wc_372_AirControlAct_17ZhiNanZhe extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 38:
                    Wc_372_AirControlAct_17ZhiNanZhe.this.mUpdateAirBlowBodyFoot();
                    break;
                case 39:
                    Wc_372_AirControlAct_17ZhiNanZhe.this.mUpdateAirBlowFootFront();
                    break;
                case 40:
                    Wc_372_AirControlAct_17ZhiNanZhe.this.mUpdateAirBlowFoot();
                    break;
                case 41:
                    Wc_372_AirControlAct_17ZhiNanZhe.this.mUpdateAirBlowBody();
                    break;
                case 58:
                    Wc_372_AirControlAct_17ZhiNanZhe.this.mUpdateAirAuto();
                    break;
                case 59:
                    Wc_372_AirControlAct_17ZhiNanZhe.this.mUpdateAirCycle();
                    break;
                case 60:
                    Wc_372_AirControlAct_17ZhiNanZhe.this.mUpdateAirFrontDefrost();
                    break;
                case 61:
                    Wc_372_AirControlAct_17ZhiNanZhe.this.mUpdateAirRearDefrost();
                    break;
                case 62:
                    Wc_372_AirControlAct_17ZhiNanZhe.this.mUpdaterAirAC();
                    break;
                case 63:
                    Wc_372_AirControlAct_17ZhiNanZhe.this.mUpdaterAirTempLeft();
                    break;
                case 67:
                    Wc_372_AirControlAct_17ZhiNanZhe.this.mUpdateAirGoFog();
                    break;
                case 68:
                    Wc_372_AirControlAct_17ZhiNanZhe.this.mUpdaterAirWindLevel();
                    break;
                case 71:
                    Wc_372_AirControlAct_17ZhiNanZhe.this.mUpdaterAirTempRight();
                    break;
                case 72:
                    Wc_372_AirControlAct_17ZhiNanZhe.this.mUpdaterAirPower();
                    break;
                case 76:
                    Wc_372_AirControlAct_17ZhiNanZhe.this.mUpdateAirSYNC();
                    break;
                case 92:
                    Wc_372_AirControlAct_17ZhiNanZhe.this.mUpdaterAirTempLeft();
                    Wc_372_AirControlAct_17ZhiNanZhe.this.mUpdaterAirTempRight();
                    break;
            }
        }
    };
    int cycle = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_372_jeep_air_17zhinanzhe);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_auto).setOnClickListener(this);
        findViewById(R.id.air_xts_sync).setOnClickListener(this);
        findViewById(R.id.air_cycle_inter).setOnClickListener(this);
        findViewById(R.id.air_cycle_outer).setOnClickListener(this);
        findViewById(R.id.air_xts_power).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnClickListener(this);
        findViewById(R.id.air_xts_front).setOnClickListener(this);
        findViewById(R.id.air_xts_rear).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_body).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnClickListener(this);
        findViewById(R.id.air_xts_ac).setOnClickListener(this);
        findViewById(R.id.air_xts_maxac).setOnClickListener(this);
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
                DataCanbus.PROXY.cmd(0, new int[]{13, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{13}, null, null);
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                DataCanbus.PROXY.cmd(0, new int[]{14, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{14}, null, null);
                break;
            case R.id.air_xts_power /* 2131427428 */:
                DataCanbus.PROXY.cmd(0, new int[]{1, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                DataCanbus.PROXY.cmd(0, new int[]{12, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{12}, null, null);
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                DataCanbus.PROXY.cmd(0, new int[]{11, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{11}, null, null);
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                DataCanbus.PROXY.cmd(0, new int[]{4, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{4}, null, null);
                break;
            case R.id.air_xts_front /* 2131427438 */:
                DataCanbus.PROXY.cmd(0, new int[]{5, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{5}, null, null);
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                DataCanbus.PROXY.cmd(0, new int[]{2, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{2}, null, null);
                break;
            case R.id.air_xts_maxac /* 2131427440 */:
                DataCanbus.PROXY.cmd(0, new int[]{30, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{30}, null, null);
                break;
            case R.id.air_xts_sync /* 2131427441 */:
                DataCanbus.PROXY.cmd(0, new int[]{3, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{3}, null, null);
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                DataCanbus.PROXY.cmd(0, new int[]{29, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{29}, null, null);
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                DataCanbus.PROXY.cmd(0, new int[]{26, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{26}, null, null);
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                DataCanbus.PROXY.cmd(0, new int[]{15, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{15}, null, null);
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                DataCanbus.PROXY.cmd(0, new int[]{16, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{16}, null, null);
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                DataCanbus.PROXY.cmd(0, new int[]{27, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{27}, null, null);
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                DataCanbus.PROXY.cmd(0, new int[]{28, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{28}, null, null);
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                DataCanbus.PROXY.cmd(0, new int[]{6, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{6}, null, null);
                break;
            case R.id.air_cycle_outer /* 2131427557 */:
                if (this.cycle == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{7, 1}, null, null);
                    DataCanbus.PROXY.cmd(0, new int[]{7}, null, null);
                    break;
                }
            case R.id.air_cycle_inter /* 2131427558 */:
                if (this.cycle == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{7, 1}, null, null);
                    DataCanbus.PROXY.cmd(0, new int[]{7}, null, null);
                    break;
                }
        }
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[63];
        int unit = DataCanbus.DATA[92] & 255;
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                case -1:
                default:
                    if (temp / 10 >= 16 && temp / 10 <= 28) {
                        if (unit == 2) {
                            ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp * 9) / 50.0f) + 32.0f) + "℉");
                            break;
                        } else {
                            ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "℃");
                            break;
                        }
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NONE");
                        break;
                    }
                case 0:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NONE");
                    break;
            }
        }
    }

    
    public void mUpdaterAirTempRight() {
        int temp = DataCanbus.DATA[71];
        int unit = DataCanbus.DATA[92] & 255;
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                    break;
                case -1:
                default:
                    if (temp / 10 >= 16 && temp / 10 <= 28) {
                        if (unit == 2) {
                            ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((temp * 9) / 50.0f) + 32.0f) + "℉");
                            break;
                        } else {
                            ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "℃");
                            break;
                        }
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NONE");
                        break;
                    }
                case 0:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NONE");
                    break;
            }
        }
    }

    
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[68];
        if (level >= 8) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText("A");
        } else {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
        }
    }

    
    public void mUpdateAirGoFog() {
        int value = DataCanbus.DATA[67];
        findViewById(R.id.air_xts_maxac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
    }

    
    public void mUpdateAirAuto() {
        int value = DataCanbus.DATA[58];
        findViewById(R.id.air_xts_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateAirSYNC() {
        int value = DataCanbus.DATA[76];
        findViewById(R.id.air_xts_sync).setBackgroundResource(value == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
    }

    
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[59];
        this.cycle = value;
        if (((Button) findViewById(R.id.air_cycle_outer)) != null) {
            ((Button) findViewById(R.id.air_cycle_outer)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_out_p : R.drawable.ic_xts_cycle_n);
        }
        if (((Button) findViewById(R.id.air_cycle_inter)) != null) {
            ((Button) findViewById(R.id.air_cycle_inter)).setBackgroundResource(value == 1 ? R.drawable.ic_cycle_all_p : R.drawable.ic_cycle_all_n);
        }
    }

    
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[62];
        findViewById(R.id.air_xts_ac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdateAirFrontDefrost() {
        int value = DataCanbus.DATA[60];
        findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[61];
        findViewById(R.id.air_xts_rear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    
    public void mUpdateAirBlowBody() {
        int value = DataCanbus.DATA[41];
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
    }

    
    public void mUpdateAirBlowBodyFoot() {
        int value = DataCanbus.DATA[38];
        findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_footbody_n : R.drawable.ic_xts_mode_footbody_p);
    }

    
    public void mUpdateAirBlowFoot() {
        int value = DataCanbus.DATA[40];
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
    }

    
    public void mUpdateAirBlowFootFront() {
        int value = DataCanbus.DATA[39];
        findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_footwin_n : R.drawable.ic_xts_mode_footwin_p);
    }

    
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[72];
        findViewById(R.id.air_xts_power).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }
}
