package com.syu.carinfo.rzc.baojun;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;

public class RzcBaojunRs3AirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 29:
                    RzcBaojunRs3AirControlAct.this.mUpdateAcOn();
                    break;
                case 30:
                    RzcBaojunRs3AirControlAct.this.mUpdateCycle();
                    break;
                case 31:
                    RzcBaojunRs3AirControlAct.this.mUpdateAutoOn();
                    break;
                case 33:
                    RzcBaojunRs3AirControlAct.this.mUpdateRearDefrost();
                    break;
                case 34:
                case 35:
                case 36:
                    RzcBaojunRs3AirControlAct.this.updateBtnSource();
                    break;
                case 37:
                    RzcBaojunRs3AirControlAct.this.mUpdatePowerOn();
                    RzcBaojunRs3AirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 38:
                    RzcBaojunRs3AirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 39:
                    RzcBaojunRs3AirControlAct.this.mUpdateAirTempRight();
                    break;
                case 40:
                    RzcBaojunRs3AirControlAct.this.mUpdateAcMaxOn();
                    break;
                case 41:
                    RzcBaojunRs3AirControlAct.this.mUpdateIonOn();
                    break;
                case 42:
                    RzcBaojunRs3AirControlAct.this.mUpdaterAirSeatHeatLeft();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(1, new int[]{data0, data1}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0310_rzc_baojun_rs3_air_control);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_20BaoJunRS3 /* 459062 */:
            case FinalCanbus.CAR_OD_RZC_Wuling_Xingchen /* 655670 */:
            case FinalCanbus.CAR_RZC_Wuling_Xingchen /* 721206 */:
            case FinalCanbus.CAR_RZC_Wuling_Jiachen /* 852278 */:
            case FinalCanbus.CAR_RZC_Wuling_Xingchi /* 1179958 */:
                //setContentView(R.layout.layout_0310_od_wuling_xingchen_air_control);
                break;
            case FinalCanbus.CAR_RZC_Wuling_Kaijie /* 786742 */:
                //setContentView(R.layout.layout_0310_rzc_wuling_kaijie_air_control);
                break;
            case FinalCanbus.CAR_RZC_20BaoJunRS3_Auto /* 917814 */:
            case FinalCanbus.CAR_RZC_Wuling_Xingchen_Auto /* 983350 */:
            case FinalCanbus.CAR_RZC_Wuling_Jiachen_Auto /* 1114422 */:
            case FinalCanbus.CAR_RZC_Wuling_Xingchi_Auto /* 1245494 */:
                //setContentView(R.layout.layout_0310_rzc_wuling_xingchen_air_control);
                break;
            case FinalCanbus.CAR_RZC_Wuling_Kaijie_Auto /* 1048886 */:
                //setContentView(R.layout.layout_0310_rzc_wuling_kaijie_auto_air_control);
                break;
            default:
                //setContentView(R.layout.layout_0310_rzc_baojun_rs3_air_control);
                break;
        }
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_win).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnTouchListener(this);
        if (findViewById(R.id.air_xts_maxac) != null) {
            findViewById(R.id.air_xts_maxac).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_seathot_left) != null) {
            findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_ion) != null) {
            findViewById(R.id.air_xts_ion).setOnTouchListener(this);
        }
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
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 13;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 14;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 0;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 12;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 11;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data0 = 25;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 2;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 21;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 1;
                break;
            case R.id.air_xts_maxac /* 2131427440 */:
                data0 = 22;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data0 = 9;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 7;
                break;
            case R.id.air_xts_mode_win /* 2131427445 */:
                data0 = 6;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 15;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 16;
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                data0 = 8;
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                data0 = 10;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data0 = 23;
                break;
            case R.id.air_xts_ion /* 2131427559 */:
                data0 = 24;
                break;
        }
        if (data0 == 25) {
            if (event.getAction() == 0) {
                int value = DataCanbus.DATA[42] + 1;
                if (value > 3) {
                    value = 0;
                }
                sendCmd(data0, value);
            }
        } else if (event.getAction() == 0) {
            sendCmd(data0, 1);
        } else if (event.getAction() == 1) {
            sendCmd(data0, 0);
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAirSeatHeatLeft() {
        int value = DataCanbus.DATA[42];
        if (findViewById(R.id.air_xts_seathot_left) != null) {
            switch (value) {
                case 0:
                    findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                    break;
                case 1:
                    findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                    break;
                case 2:
                    findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
                    break;
                case 3:
                    findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                    break;
            }
        }
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[38];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NONE");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 0.5f) + "℃");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[39];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NONE");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 0.5f) + "℃");
            }
        }
    }

    
    public void mUpdateIonOn() {
        int acOn = DataCanbus.DATA[41];
        if (findViewById(R.id.air_xts_ion) != null) {
            findViewById(R.id.air_xts_ion).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ion_n : R.drawable.ic_xts_ion_p);
        }
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[31];
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }

    
    public void mUpdateAcMaxOn() {
        int acOn = DataCanbus.DATA[40];
        if (findViewById(R.id.air_xts_maxac) != null) {
            findViewById(R.id.air_xts_maxac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
        }
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[29];
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[37];
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[30];
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        }
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[33];
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[37];
        if (leave < 0) {
            leave = 0;
        }
        if (leave > 6) {
            leave = 6;
        }
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }

    
    public void updateBtnSource() {
        int window = DataCanbus.DATA[36];
        int foot = DataCanbus.DATA[35];
        int body = DataCanbus.DATA[34];
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
        findViewById(R.id.air_xts_mode_win).setBackgroundResource(R.drawable.ic_xts_mode_win_n);
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        switch (mode) {
            case 1:
                findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
                break;
            case 2:
                findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
                break;
            case 3:
                findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
                break;
            case 4:
                findViewById(R.id.air_xts_mode_win).setBackgroundResource(R.drawable.ic_xts_mode_win_p);
                break;
            case 5:
                findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
                break;
        }
    }
}
