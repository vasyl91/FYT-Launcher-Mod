package com.syu.carinfo.klc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class KlcGl8AirControl_Rear extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 40:
                    KlcGl8AirControl_Rear.this.mUpdateAirTempLeft();
                    break;
                case 44:
                    KlcGl8AirControl_Rear.this.mUpdaterAirWindLevelLeft();
                    break;
                case 86:
                    KlcGl8AirControl_Rear.this.updateBlowMode();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0036_wc_gl8_air_rear_control);
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
        findViewById(R.id.air_xts_mode_footbody).setOnClickListener(this);
        findViewById(R.id.air_xts_auto).setOnClickListener(this);
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
        int id = v.getId();
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                KlcFunc.C_AIR_CONTROL_CMD(22, 1);
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                KlcFunc.C_AIR_CONTROL_CMD(22, 2);
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                KlcFunc.C_AIR_CONTROL_CMD(21, 2);
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                KlcFunc.C_AIR_CONTROL_CMD(21, 1);
                break;
            case R.id.air_xts_frontpage /* 2131427432 */:
                try {
                    startActivity(new Intent(this, (Class<?>) KlcGl8AirControlAct.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.air_xts_auto /* 2131427436 */:
                KlcFunc.C_AIR_CONTROL_CMD(17, 255);
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                KlcFunc.C_AIR_CONTROL_CMD(18, 255);
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                KlcFunc.C_AIR_CONTROL_CMD(20, 255);
                break;
            case R.id.air_xts_mode_footbody /* 2131427502 */:
                KlcFunc.C_AIR_CONTROL_CMD(19, 255);
                break;
        }
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateBlowMode() {
        int mode = DataCanbus.DATA[86];
        if (mode == 1) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(R.drawable.ic_xts_auto_p);
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
            return;
        }
        if (mode == 2) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(R.drawable.ic_xts_auto_n);
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
            return;
        }
        if (mode == 3) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(R.drawable.ic_xts_auto_n);
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
            return;
        }
        if (mode == 4) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(R.drawable.ic_xts_auto_n);
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        }
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[40];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == 254) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
            } else if (temp == 255) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(((temp * 5) / 10.0f) + "°C");
            }
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        String str;
        int leave = DataCanbus.DATA[44];
        if (leave > 12) {
            str = " A ";
        } else {
            str = " " + leave + " ";
        }
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
        findViewById(R.id.air_xts_power).setBackgroundResource(leave == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }
}
