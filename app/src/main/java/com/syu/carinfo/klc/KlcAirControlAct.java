package com.syu.carinfo.klc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class KlcAirControlAct extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 72:
                    KlcAirControlAct.this.mUpdateAcOn();
                    break;
                case 75:
                    KlcAirControlAct.this.mUpdateCycle();
                    break;
                case 76:
                    KlcAirControlAct.this.mUpdateAirAutoOn();
                    break;
                case 78:
                case 79:
                case 80:
                    KlcAirControlAct.this.updateBtnSource();
                    break;
                case 82:
                    KlcAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 83:
                    KlcAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 84:
                    KlcAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 110:
                    KlcAirControlAct.this.mUpdateSyncOn();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ////setContentView(R.layout.layout_0036_wc_gm_all_control);
        init();
    }

    private void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(this);
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
        findViewById(R.id.btn_air_temp_right_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnClickListener(this);
        findViewById(R.id.air_xts_dual).setOnClickListener(this);
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

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                KlcFunc.C_AIR_CONTROL_CMD(12, 1);
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                KlcFunc.C_AIR_CONTROL_CMD(12, 2);
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                KlcFunc.C_AIR_CONTROL_CMD(11, 2);
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                KlcFunc.C_AIR_CONTROL_CMD(11, 1);
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                int auto = DataCanbus.DATA[76];
                KlcFunc.C_AIR_CONTROL_CMD(4, auto != 0 ? 0 : 1);
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                int cycle = DataCanbus.DATA[75];
                if (cycle == 1) {
                    KlcFunc.C_AIR_CONTROL_CMD(7, 1);
                    break;
                } else if (cycle == 0) {
                    KlcFunc.C_AIR_CONTROL_CMD(7, 0);
                    break;
                }
            case R.id.air_xts_front /* 2131427438 */:
                KlcFunc.C_AIR_CONTROL_CMD(5, 255);
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                int acOn = DataCanbus.DATA[72];
                KlcFunc.C_AIR_CONTROL_CMD(2, acOn != 0 ? 0 : 1);
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                KlcFunc.C_AIR_CONTROL_CMD(10, 255);
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                KlcFunc.C_AIR_CONTROL_CMD(9, 255);
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                KlcFunc.C_AIR_CONTROL_CMD(13, 1);
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                KlcFunc.C_AIR_CONTROL_CMD(13, 2);
                break;
            case R.id.air_xts_dual /* 2131427460 */:
                int syncOn = DataCanbus.DATA[110];
                KlcFunc.C_AIR_CONTROL_CMD(15, syncOn != 0 ? 0 : 1);
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                KlcFunc.C_AIR_CONTROL_CMD(33, 255);
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                KlcFunc.C_AIR_CONTROL_CMD(34, 255);
                break;
        }
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[84];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == 254) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            } else if (temp == 255) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(((temp * 5) / 10.0f) + "℃");
            }
        }
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[83];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == 254) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
            } else if (temp == 255) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(((temp * 5) / 10.0f) + "℃");
            }
        }
    }

    
    public void mUpdateSyncOn() {
        int acOn = DataCanbus.DATA[110];
        findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[72];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdateAirAutoOn() {
        int auto = DataCanbus.DATA[76];
        if (auto == 1) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(R.drawable.ic_xts_auto_p);
        } else {
            findViewById(R.id.air_xts_auto).setBackgroundResource(R.drawable.ic_xts_auto_n);
        }
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[75];
        if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        } else if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        String str;
        int leave = DataCanbus.DATA[82];
        if (leave > 18) {
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
        int window = DataCanbus.DATA[78];
        int foot = DataCanbus.DATA[80];
        int body = DataCanbus.DATA[79];
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
