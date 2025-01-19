package com.syu.carinfo.golf7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class AirControlMQB_RZC_Rear extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 38:
                    AirControlMQB_RZC_Rear.this.mUpdatePowerOn();
                    break;
                case 40:
                    AirControlMQB_RZC_Rear.this.mUpdateAirTempLeft();
                    break;
                case 43:
                    AirControlMQB_RZC_Rear.this.mUpdateAutoOn();
                    break;
                case 44:
                    AirControlMQB_RZC_Rear.this.mUpdaterAirWindLevelLeft();
                    break;
                case 46:
                    AirControlMQB_RZC_Rear.this.updateBlowBody();
                    break;
                case 47:
                    AirControlMQB_RZC_Rear.this.updateBlowFoot();
                    break;
                case 67:
                    AirControlMQB_RZC_Rear.this.updateRearLock();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0160_rzc_mqb_air_rear_control);
        init();
    }

    private void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(this);
        findViewById(R.id.air_xts_power).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnClickListener(this);
        findViewById(R.id.air_xts_frontpage).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_body).setOnClickListener(this);
        findViewById(R.id.air_xts_auto).setOnClickListener(this);
        findViewById(R.id.air_xts_rearlock).setOnClickListener(this);
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
    public void onClick(View v) {
        int value = 0;
        int cmdId = 0;
        switch (v.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                cmdId = 186;
                value = 1;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                cmdId = 186;
                value = 0;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                cmdId = 36;
                if (DataCanbus.DATA[38] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                cmdId = 40;
                value = DataCanbus.DATA[44] - 1;
                if (value <= 0) {
                    value = 0;
                    break;
                }
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                cmdId = 40;
                value = DataCanbus.DATA[44] + 1;
                if (value >= 7) {
                    value = 7;
                    break;
                }
            case R.id.air_xts_frontpage /* 2131427432 */:
                try {
                    startActivity(new Intent(this, (Class<?>) AirControlMQB_RZC_Front.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.air_xts_auto /* 2131427436 */:
                cmdId = 37;
                if (DataCanbus.DATA[43] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_mode_foot /* 2131427443 */:
                cmdId = 39;
                if (DataCanbus.DATA[47] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_mode_body /* 2131427444 */:
                cmdId = 38;
                if (DataCanbus.DATA[46] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_rearlock /* 2131427446 */:
                cmdId = 188;
                if (DataCanbus.DATA[67] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
        }
        if (value >= 0 && cmdId > 0) {
            setAirCmd(cmdId, value);
        }
    }

    private void setAirCmd(int cmdCode, int value) {
        DataCanbus.PROXY.cmd(107, new int[]{cmdCode, value}, null, null);
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateRearLock() {
        int value = DataCanbus.DATA[67];
        if (((Button) findViewById(R.id.air_xts_rearlock)) != null) {
            ((Button) findViewById(R.id.air_xts_rearlock)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rearlock_n : R.drawable.ic_xts_rearlock_p);
        }
    }

    
    public void updateBlowBody() {
        int value = DataCanbus.DATA[46];
        if (((Button) findViewById(R.id.air_xts_mode_body)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
        }
    }

    
    public void updateBlowFoot() {
        int value = DataCanbus.DATA[47];
        if (((Button) findViewById(R.id.air_xts_mode_foot)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
        }
    }

    
    public void mUpdateAutoOn() {
        int power = DataCanbus.DATA[43];
        findViewById(R.id.air_xts_auto).setBackgroundResource(power == 0 ? R.drawable.ic_xts_auto_p : R.drawable.ic_xts_auto_n);
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[40];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                case 31:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HIGHT");
                    break;
                default:
                    if (DataCanbus.DATA[37] == 0) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp * 5) + 155) / 10.0f) + "℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp + 59) + "℉");
                        break;
                    }
            }
        }
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[38];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[44];
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }
}
