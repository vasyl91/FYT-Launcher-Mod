package com.syu.carinfo.saiou3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.carinfo.xfl.chuangku.XflCkFunc;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class SO3AirControlAct extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 11:
                    SO3AirControlAct.this.mUpdateAcOn();
                    break;
                case 12:
                    SO3AirControlAct.this.mUpdateCycle();
                    break;
                case 13:
                    SO3AirControlAct.this.mUpdateBlowAutoOn();
                    break;
                case 18:
                case 19:
                case 20:
                    SO3AirControlAct.this.updateBtnSource();
                    break;
                case 21:
                    SO3AirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    SO3AirControlAct.this.mUpdateAirTempLeft();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_saio3_air_control_set);
        init();
    }

    private void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnClickListener(this);
        findViewById(R.id.air_xts_ac).setOnClickListener(this);
        findViewById(R.id.air_xts_auto).setOnClickListener(this);
        findViewById(R.id.air_xts_cycle).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_body).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnClickListener(this);
        findViewById(R.id.air_xts_front).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                XflCkFunc.CAR_NAVI_AIR_CONTROL(2, 1);
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                XflCkFunc.CAR_NAVI_AIR_CONTROL(2, 0);
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                XflCkFunc.CAR_NAVI_AIR_CONTROL(5, 0);
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                XflCkFunc.CAR_NAVI_AIR_CONTROL(5, 1);
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                XflCkFunc.CAR_NAVI_AIR_CONTROL(4, 1);
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                XflCkFunc.CAR_NAVI_AIR_CONTROL(1, 1);
                break;
            case R.id.air_xts_front /* 2131427438 */:
                XflCkFunc.CAR_NAVI_AIR_CONTROL(6, 4);
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                XflCkFunc.CAR_NAVI_AIR_CONTROL(3, 1);
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                XflCkFunc.CAR_NAVI_AIR_CONTROL(6, 1);
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                XflCkFunc.CAR_NAVI_AIR_CONTROL(6, 0);
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                XflCkFunc.CAR_NAVI_AIR_CONTROL(2, 1);
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                XflCkFunc.CAR_NAVI_AIR_CONTROL(2, 0);
                break;
            case R.id.air_xts_mode_footbody /* 2131427502 */:
                XflCkFunc.CAR_NAVI_AIR_CONTROL(6, 2);
                break;
            case R.id.air_xts_mode_footwin /* 2131427632 */:
                XflCkFunc.CAR_NAVI_AIR_CONTROL(6, 3);
                break;
        }
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            } else if (temp == 63) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "℃");
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "℃");
            }
        }
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdateBlowAutoOn() {
        int auto = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(auto == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        } else if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        String str;
        int leave = DataCanbus.DATA[21];
        if (leave > 8 || leave == -1) {
            str = "A";
        } else {
            str = new StringBuilder().append(leave).toString();
        }
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }

    
    public void updateBtnSource() {
        int window = DataCanbus.DATA[18];
        int foot = DataCanbus.DATA[20];
        int body = DataCanbus.DATA[19];
        if (body == 1 && foot != 1) {
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
        } else {
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        }
        if (body == 1 && foot == 1) {
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
        } else {
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        }
        if (foot == 1 && body != 1 && window != 1) {
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
        } else {
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        }
        if (window == 1 && foot == 1) {
            findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
        } else {
            findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        }
        if (window == 1 && foot != 1) {
            findViewById(R.id.air_xts_front).setBackgroundResource(R.drawable.ic_xts_front_p);
        } else {
            findViewById(R.id.air_xts_front).setBackgroundResource(R.drawable.ic_xts_front_n);
        }
    }
}
