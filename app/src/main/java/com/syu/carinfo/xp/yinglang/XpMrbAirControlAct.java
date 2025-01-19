package com.syu.carinfo.xp.yinglang;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class XpMrbAirControlAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 11:
                    XpMrbAirControlAct.this.mUpdateAcOn();
                    break;
                case 12:
                    XpMrbAirControlAct.this.mUpdateCycle();
                    break;
                case 18:
                    XpMrbAirControlAct.this.updateBtnSource();
                    break;
                case 19:
                    XpMrbAirControlAct.this.updateBtnSource();
                    break;
                case 20:
                    XpMrbAirControlAct.this.updateBtnSource();
                    break;
                case 21:
                    XpMrbAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    XpMrbAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    XpMrbAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 49:
                    XpMrbAirControlAct.this.mUpdaterAirAuto();
                    break;
                case 62:
                    XpMrbAirControlAct.this.mUpdateAirSync();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_359_xp_gm_mairuibao_air_control);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnClickListener(this);
        findViewById(R.id.air_xts_ac).setOnClickListener(this);
        findViewById(R.id.air_xts_sync).setOnClickListener(this);
        findViewById(R.id.air_xts_cycle).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_body).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnClickListener(this);
        findViewById(R.id.air_xts_front).setOnClickListener(this);
        findViewById(R.id.air_xts_auto).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
        removeNotify();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                YLFunc.CAR_AIR_CONTROL(7, 4);
                YLFunc.CAR_AIR_CONTROL(7, 0);
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                YLFunc.CAR_AIR_CONTROL(7, 5);
                YLFunc.CAR_AIR_CONTROL(7, 0);
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                YLFunc.CAR_AIR_CONTROL(7, 7);
                YLFunc.CAR_AIR_CONTROL(7, 0);
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                YLFunc.CAR_AIR_CONTROL(7, 6);
                YLFunc.CAR_AIR_CONTROL(7, 0);
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                YLFunc.CAR_AIR_CONTROL(7, 2);
                YLFunc.CAR_AIR_CONTROL(7, 0);
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                YLFunc.CAR_AIR_CONTROL(7, 3);
                YLFunc.CAR_AIR_CONTROL(7, 0);
                break;
            case R.id.air_xts_front /* 2131427438 */:
                YLFunc.CAR_AIR_CONTROL(7, 12);
                YLFunc.CAR_AIR_CONTROL(7, 0);
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                YLFunc.CAR_AIR_CONTROL(7, 1);
                YLFunc.CAR_AIR_CONTROL(7, 0);
                break;
            case R.id.air_xts_sync /* 2131427441 */:
                YLFunc.CAR_AIR_CONTROL(7, 13);
                YLFunc.CAR_AIR_CONTROL(7, 0);
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                YLFunc.CAR_AIR_CONTROL(7, 11);
                YLFunc.CAR_AIR_CONTROL(7, 0);
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                YLFunc.CAR_AIR_CONTROL(7, 8);
                YLFunc.CAR_AIR_CONTROL(7, 0);
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                YLFunc.CAR_AIR_CONTROL(7, 20);
                YLFunc.CAR_AIR_CONTROL(7, 0);
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                YLFunc.CAR_AIR_CONTROL(7, 21);
                YLFunc.CAR_AIR_CONTROL(7, 0);
                break;
            case R.id.air_xts_mode_footbody /* 2131427502 */:
                YLFunc.CAR_AIR_CONTROL(7, 9);
                YLFunc.CAR_AIR_CONTROL(7, 0);
                break;
            case R.id.air_xts_mode_footwin /* 2131427632 */:
                YLFunc.CAR_AIR_CONTROL(7, 10);
                YLFunc.CAR_AIR_CONTROL(7, 0);
                break;
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
    }

    void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
            } else if (temp == 30) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "℃");
            }
        }
    }

    void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            } else if (temp == 30) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "℃");
            }
        }
    }

    void mUpdaterAirAuto() {
        int auto = DataCanbus.DATA[49];
        findViewById(R.id.air_xts_auto).setBackgroundResource(auto == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    void mUpdateAirSync() {
        int auto = DataCanbus.DATA[62];
        findViewById(R.id.air_xts_sync).setBackgroundResource(auto == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
    }

    void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        } else if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        }
    }

    void mUpdaterAirWindLevelLeft() {
        int level = DataCanbus.DATA[21];
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null && level > -1 && level < 9) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
        }
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
