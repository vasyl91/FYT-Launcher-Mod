package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.os.Bundle;
import android.SystemProperties;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class YLAirControlAct extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 87:
                    YLAirControlAct.this.mUpdateDualOn();
                    break;
                case 89:
                    YLAirControlAct.this.mUpdateCycle();
                    break;
                case 93:
                    YLAirControlAct.this.mUpdateAcOn();
                    break;
                case 97:
                    YLAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 98:
                    YLAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 99:
                case 100:
                case 101:
                    YLAirControlAct.this.updateBtnSource();
                    break;
                case 102:
                    YLAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 110:
                    YLAirControlAct.this.mUpdateBlowAutoOn();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0025_xp_gm_all_air_control);
        init();
    }

    private void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnClickListener(this);
        findViewById(R.id.air_xts_ac).setOnClickListener(this);
        findViewById(R.id.air_xts_auto).setOnClickListener(this);
        findViewById(R.id.air_xts_dual).setOnClickListener(this);
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

    protected void finalize() throws Throwable {
        removeUpdater();
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
            case R.id.air_xts_dual /* 2131427460 */:
                YLFunc.CAR_AIR_CONTROL(7, 13);
                YLFunc.CAR_AIR_CONTROL(7, 0);
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                YLFunc.CAR_AIR_CONTROL(7, 9);
                YLFunc.CAR_AIR_CONTROL(7, 0);
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                YLFunc.CAR_AIR_CONTROL(7, 10);
                YLFunc.CAR_AIR_CONTROL(7, 0);
                break;
        }
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[98];
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == 30) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                return;
            }
            if (temp == 255) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NO");
            } else if (TempUnit == 1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(((temp * 9) / 50) + 32) + "℉");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "℃");
            }
        }
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[97];
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == 30) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                return;
            }
            if (temp == 255) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NO");
            } else if (TempUnit == 1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(((temp * 9) / 50) + 32) + "℉");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "℃");
            }
        }
    }

    
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[87];
        findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[93];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdateBlowAutoOn() {
        int auto = DataCanbus.DATA[110];
        findViewById(R.id.air_xts_auto).setBackgroundResource(auto == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[89];
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        String str;
        int leave = DataCanbus.DATA[102];
        if (leave > 8) {
            str = "A";
        } else {
            str = new StringBuilder().append(leave).toString();
        }
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
        if (leave == 0) {
            findViewById(R.id.air_xts_power).setBackgroundResource(R.drawable.ic_xts_power_n);
        } else {
            findViewById(R.id.air_xts_power).setBackgroundResource(R.drawable.ic_xts_power_p);
        }
    }

    
    public void updateBtnSource() {
        int window = DataCanbus.DATA[99];
        int foot = DataCanbus.DATA[101];
        int body = DataCanbus.DATA[100];
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
