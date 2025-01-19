package com.syu.carinfo.rzc.zhongtai;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;
import com.syu.util.HandlerUI;

public class RzcChanganAirControlAct extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    RzcChanganAirControlAct.this.mUpdateBlowPowerOn();
                    break;
                case 11:
                    RzcChanganAirControlAct.this.mUpdateAcOn();
                    break;
                case 12:
                    RzcChanganAirControlAct.this.mUpdateCycle();
                    break;
                case 13:
                    RzcChanganAirControlAct.this.mUpdateAutoOn();
                    break;
                case 14:
                    RzcChanganAirControlAct.this.mUpdateDualOn();
                    break;
                case 16:
                    RzcChanganAirControlAct.this.mUpdateRearDefrost();
                    break;
                case 18:
                case 19:
                case 20:
                    RzcChanganAirControlAct.this.updateBtnSource();
                    break;
                case 21:
                    RzcChanganAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    RzcChanganAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    RzcChanganAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 29:
                    RzcChanganAirControlAct.this.mUpdateSeatHotLeftLev();
                    break;
                case 30:
                    RzcChanganAirControlAct.this.mUpdateSeatHotRightLev();
                    break;
                case 53:
                    RzcChanganAirControlAct.this.mUpdateAcMaxOn();
                    break;
                case 58:
                    RzcChanganAirControlAct.this.mUpdateIonOn();
                    break;
                case 65:
                    RzcChanganAirControlAct.this.mUpdateFrontDefrost();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1, int data2, int data3, int data4, int data5) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1, data2, data3, data4, data5}, null, null);
        HandlerUI.getInstance().postDelayed(new Runnable() { 
            @Override
            public void run() {
                DataCanbus.PROXY.cmd(0, new int[6], null, null);
            }
        }, 100L);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_rzc_zhongtai_air_control);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_front).setOnClickListener(this);
        findViewById(R.id.air_xts_rear).setOnClickListener(this);
        findViewById(R.id.air_xts_dual).setOnClickListener(this);
        findViewById(R.id.air_xts_auto).setOnClickListener(this);
        findViewById(R.id.air_xts_maxac).setOnClickListener(this);
        findViewById(R.id.air_xts_seathot_left).setOnClickListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnClickListener(this);
        findViewById(R.id.air_xts_ion).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(this);
        findViewById(R.id.air_xts_ac).setOnClickListener(this);
        findViewById(R.id.air_xts_power).setOnClickListener(this);
        findViewById(R.id.air_xts_cycle).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_body).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_win).setOnClickListener(this);
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
        int data0 = 0;
        int data1 = 0;
        int data2 = 0;
        int data3 = 0;
        int data4 = 0;
        int data5 = 0;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data3 = 2;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data3 = 1;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 128;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data1 = 1;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data1 = 2;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data5 = 1;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                data5 = 2;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 32;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                if (DataCanbus.sCanbusId == 8520119) {
                    data2 = 1;
                    break;
                } else if (DataCanbus.DATA[12] == 1) {
                    data0 = 8;
                    break;
                } else {
                    data0 = 4;
                    break;
                }
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 16;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 2;
                break;
            case R.id.air_xts_maxac /* 2131427440 */:
                data0 = 1;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data2 = 96;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data2 = 32;
                break;
            case R.id.air_xts_mode_win /* 2131427445 */:
                data2 = 160;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data4 = 2;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data4 = 1;
                break;
            case R.id.air_xts_mode_footbody /* 2131427502 */:
                data2 = 64;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                data1 = 4;
                break;
            case R.id.air_xts_dual /* 2131427566 */:
                data1 = 8;
                break;
            case R.id.air_xts_ion /* 2131427570 */:
                data5 = 32;
                break;
            case R.id.air_xts_mode_footwin /* 2131427632 */:
                data2 = 128;
                break;
        }
        sendCmd(data0, data1, data2, data3, data4, data5);
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else {
                int value1 = (temp * 5) + 175;
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((value1 / 10.0f) + "℃");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else {
                int value1 = (temp * 5) + 175;
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((value1 / 10.0f) + "℃");
            }
        }
    }

    
    public void mUpdateSeatHotRightLev() {
        int lev = DataCanbus.DATA[30];
        switch (lev) {
            case 0:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
                break;
            case 2:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
                break;
            case 3:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                break;
        }
    }

    
    public void mUpdateSeatHotLeftLev() {
        int lev = DataCanbus.DATA[29];
        switch (lev) {
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

    
    public void mUpdateIonOn() {
        int acmaxOn = DataCanbus.DATA[58];
        findViewById(R.id.air_xts_ion).setBackgroundResource(acmaxOn == 0 ? R.drawable.ic_xts_ion_n : R.drawable.ic_xts_ion_p);
    }

    
    public void mUpdateAutoOn() {
        int acmaxOn = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acmaxOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateAcMaxOn() {
        int acmaxOn = DataCanbus.DATA[53];
        findViewById(R.id.air_xts_maxac).setBackgroundResource(acmaxOn == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
    }

    
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[14];
        findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdateBlowPowerOn() {
        int power = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        }
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[65];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(leave).toString());
    }

    
    public void updateBtnSource() {
        int up = DataCanbus.DATA[19];
        int win = DataCanbus.DATA[18];
        int down = DataCanbus.DATA[20];
        if (((Button) findViewById(R.id.air_xts_mode_body)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        }
        if (((Button) findViewById(R.id.air_xts_mode_footbody)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        }
        if (((Button) findViewById(R.id.air_xts_mode_foot)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        }
        if (((Button) findViewById(R.id.air_xts_mode_footwin)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        }
        if (((Button) findViewById(R.id.air_xts_mode_win)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_win)).setBackgroundResource(R.drawable.ic_xts_mode_win_n);
        }
        if (((Button) findViewById(R.id.air_xts_mode_foot)) != null && ((Button) findViewById(R.id.air_xts_mode_footbody)) != null && ((Button) findViewById(R.id.air_xts_mode_footwin)) != null) {
            if (up == 1 && down == 0 && win == 0) {
                ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
                return;
            }
            if (up == 1 && down == 1 && win == 0) {
                ((Button) findViewById(R.id.air_xts_mode_footbody)).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
                return;
            }
            if (up == 0 && down == 1 && win == 0) {
                ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
                return;
            }
            if (up == 0 && down == 1 && win == 1) {
                ((Button) findViewById(R.id.air_xts_mode_footwin)).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
            } else if (up == 0 && down == 0 && win == 1) {
                ((Button) findViewById(R.id.air_xts_mode_win)).setBackgroundResource(R.drawable.ic_xts_mode_win_p);
            }
        }
    }
}
