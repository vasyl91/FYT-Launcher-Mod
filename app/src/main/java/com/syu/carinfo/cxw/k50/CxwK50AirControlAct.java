package com.syu.carinfo.cxw.k50;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class CxwK50AirControlAct extends Activity implements View.OnTouchListener {
    public static CxwK50AirControlAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.cxw.k50.CxwK50AirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    CxwK50AirControlAct.this.mUpdateRearDefrost();
                    break;
                case 1:
                    CxwK50AirControlAct.this.mUpdateCycle();
                    break;
                case 2:
                    CxwK50AirControlAct.this.mUpdateAcOn();
                    break;
                case 3:
                    CxwK50AirControlAct.this.mUpdatePowerOn();
                    break;
                case 4:
                    CxwK50AirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 5:
                    CxwK50AirControlAct.this.updateBtnSource();
                    break;
                case 9:
                    CxwK50AirControlAct.this.mUpdateAirTempLeft();
                    break;
            }
        }
    };

    private void sendCmd(int data0) {
        DataCanbus.PROXY.cmd(0, new int[]{data0}, null, null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_cxw_k50_air_control);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_blow_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_blow_body_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_blow_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_blow_foot_win).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle_in).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle_out).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 1;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 2;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 14;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 4;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 3;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 11;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 12;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data0 = 13;
                break;
            case R.id.air_xts_blow_body /* 2131428150 */:
                data0 = 7;
                break;
            case R.id.air_xts_blow_body_foot /* 2131428151 */:
                data0 = 8;
                break;
            case R.id.air_xts_blow_foot /* 2131428152 */:
                data0 = 9;
                break;
            case R.id.air_xts_blow_foot_win /* 2131428153 */:
                data0 = 10;
                break;
            case R.id.air_xts_cycle_in /* 2131428154 */:
                data0 = 5;
                break;
            case R.id.air_xts_cycle_out /* 2131428155 */:
                data0 = 6;
                break;
        }
        if (event.getAction() == 0) {
            sendCmd(data0);
            return false;
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[9];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LO");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else {
                if (temp == -1) {
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("--");
                    return;
                }
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp + 14) + "°C");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[2];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_cxw_k50_ac_n : R.drawable.ic_cxw_k50_ac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[3];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_air_cxw_k50_power_n : R.drawable.ic_air_cxw_k50_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[1];
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle_in).setBackgroundResource(R.drawable.ic_air_cxw_k50_cyclein_n);
            findViewById(R.id.air_xts_cycle_out).setBackgroundResource(R.drawable.ic_air_cxw_k50_cycleout_p);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle_in).setBackgroundResource(R.drawable.ic_air_cxw_k50_cyclein_p);
            findViewById(R.id.air_xts_cycle_out).setBackgroundResource(R.drawable.ic_air_cxw_k50_cycleout_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[0];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_cxw_k50_rear_n : R.drawable.ic_cxw_k50_rear_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[4];
        switch (leave) {
            case 0:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev0);
                break;
            case 1:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev1);
                break;
            case 2:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev2);
                break;
            case 3:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev3);
                break;
            case 4:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev4);
                break;
            case 5:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev5);
                break;
            case 6:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev6);
                break;
            case 7:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev7);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtnSource() {
        int mode = DataCanbus.DATA[5];
        switch (mode) {
            case 0:
                findViewById(R.id.air_xts_blow_body).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_n);
                findViewById(R.id.air_xts_blow_body_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_foot_n);
                findViewById(R.id.air_xts_blow_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_foot_n);
                findViewById(R.id.air_xts_blow_foot_win).setBackgroundResource(R.drawable.ic_air_cxw_k50_win_foot_n);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_cxw_k50_mode_null);
                findViewById(R.id.air_xts_front).setBackgroundResource(R.drawable.ic_cxw_k50_front_n);
                break;
            case 1:
                findViewById(R.id.air_xts_blow_body).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_p);
                findViewById(R.id.air_xts_blow_body_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_foot_n);
                findViewById(R.id.air_xts_blow_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_foot_n);
                findViewById(R.id.air_xts_blow_foot_win).setBackgroundResource(R.drawable.ic_air_cxw_k50_win_foot_n);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_cxw_k50_mode_1);
                findViewById(R.id.air_xts_front).setBackgroundResource(R.drawable.ic_cxw_k50_front_n);
                break;
            case 2:
                findViewById(R.id.air_xts_blow_body).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_n);
                findViewById(R.id.air_xts_blow_body_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_foot_p);
                findViewById(R.id.air_xts_blow_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_foot_n);
                findViewById(R.id.air_xts_blow_foot_win).setBackgroundResource(R.drawable.ic_air_cxw_k50_win_foot_n);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_cxw_k50_mode_2);
                findViewById(R.id.air_xts_front).setBackgroundResource(R.drawable.ic_cxw_k50_front_n);
                break;
            case 3:
                findViewById(R.id.air_xts_blow_body).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_n);
                findViewById(R.id.air_xts_blow_body_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_foot_n);
                findViewById(R.id.air_xts_blow_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_foot_p);
                findViewById(R.id.air_xts_blow_foot_win).setBackgroundResource(R.drawable.ic_air_cxw_k50_win_foot_n);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_cxw_k50_mode_3);
                findViewById(R.id.air_xts_front).setBackgroundResource(R.drawable.ic_cxw_k50_front_n);
                break;
            case 4:
                findViewById(R.id.air_xts_blow_body).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_n);
                findViewById(R.id.air_xts_blow_body_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_foot_n);
                findViewById(R.id.air_xts_blow_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_foot_n);
                findViewById(R.id.air_xts_blow_foot_win).setBackgroundResource(R.drawable.ic_air_cxw_k50_win_foot_p);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_cxw_k50_mode_4);
                findViewById(R.id.air_xts_front).setBackgroundResource(R.drawable.ic_cxw_k50_front_n);
                break;
            case 5:
                findViewById(R.id.air_xts_blow_body).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_n);
                findViewById(R.id.air_xts_blow_body_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_body_foot_n);
                findViewById(R.id.air_xts_blow_foot).setBackgroundResource(R.drawable.ic_air_cxw_k50_foot_n);
                findViewById(R.id.air_xts_blow_foot_win).setBackgroundResource(R.drawable.ic_air_cxw_k50_win_foot_n);
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_cxw_k50_mode_null);
                findViewById(R.id.air_xts_front).setBackgroundResource(R.drawable.ic_cxw_k50_front_p);
                break;
        }
    }
}
