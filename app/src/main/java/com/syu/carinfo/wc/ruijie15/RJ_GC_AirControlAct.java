package com.syu.carinfo.wc.ruijie15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RJ_GC_AirControlAct extends Activity implements View.OnTouchListener {
    public static RJ_GC_AirControlAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruijie15.RJ_GC_AirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 15:
                    RJ_GC_AirControlAct.this.mUpdatePowerOn();
                    break;
                case 16:
                    RJ_GC_AirControlAct.this.mUpdateAcOn();
                    break;
                case 18:
                    RJ_GC_AirControlAct.this.mUpdateCycle();
                    break;
                case 19:
                    RJ_GC_AirControlAct.this.mUpdateAutoOn();
                    break;
                case 20:
                    RJ_GC_AirControlAct.this.mUpdaterBlowWindow();
                    break;
                case 21:
                    RJ_GC_AirControlAct.this.mUpdaterBlowBodyLeftOn();
                    break;
                case 22:
                    RJ_GC_AirControlAct.this.mUpdaterBlowFootLeftOn();
                    break;
                case 23:
                    RJ_GC_AirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 24:
                    RJ_GC_AirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 25:
                    RJ_GC_AirControlAct.this.mUpdateAirTempRight();
                    break;
                case 26:
                    RJ_GC_AirControlAct.this.mUpdateDualOn();
                    break;
                case 28:
                    RJ_GC_AirControlAct.this.mUpdateAirTempLeft();
                    RJ_GC_AirControlAct.this.mUpdateAirTempRight();
                    break;
                case 49:
                    RJ_GC_AirControlAct.this.mUpdateRearDefrost();
                    break;
                case 50:
                    RJ_GC_AirControlAct.this.mUpdateFrontDefrost();
                    break;
                case 57:
                    RJ_GC_AirControlAct.this.mUpdaterSeatHeatLeft();
                    break;
                case 58:
                    RJ_GC_AirControlAct.this.mUpdaterSeatHeatRight();
                    break;
                case 59:
                    RJ_GC_AirControlAct.this.mUpdaterSeatColdLeft();
                    break;
                case 60:
                    RJ_GC_AirControlAct.this.mUpdaterSeatColdRight();
                    break;
            }
        }
    };

    private void sendCmd(int cmd) {
        DataCanbus.PROXY.cmd(1, new int[]{172, cmd}, null, null);
        HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.wc.ruijie15.RJ_GC_AirControlAct.2
            @Override // java.lang.Runnable
            public void run() {
                DataCanbus.PROXY.cmd(1, new int[]{172}, null, null);
            }
        }, 100L);
        mInstance = this;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_18ruijie_air_control);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_win).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearpage).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_right).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addUpdater();
        RJFunc.C_REQUEST_CAR_INFO(41, 0);
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
        boolean flag = false;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 36;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 35;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 39;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 40;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data0 = 43;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                data0 = 45;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 23;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 3;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 5;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 2;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data0 = 34;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 33;
                break;
            case R.id.air_xts_mode_win /* 2131427445 */:
                data0 = 32;
                break;
            case R.id.air_xts_rearpage /* 2131427448 */:
                flag = true;
                try {
                    startActivity(new Intent(this, (Class<?>) RuiJieRearAirControlAct_XP.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 38;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 37;
                break;
            case R.id.air_xts_seatwin_left /* 2131427452 */:
                data0 = 44;
                break;
            case R.id.air_xts_seatwin_right /* 2131427454 */:
                data0 = 46;
                break;
            case R.id.air_xts_dual /* 2131427460 */:
                data0 = 24;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data0 = 6;
                break;
        }
        if (!flag && event.getAction() == 0) {
            sendCmd(data0);
            return false;
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatColdRight() {
        int value = DataCanbus.DATA[60];
        switch (value) {
            case 0:
                ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level0);
                break;
            case 1:
                ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level1);
                break;
            case 2:
                ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level2);
                break;
            case 3:
                ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatHeatRight() {
        int value = DataCanbus.DATA[58];
        switch (value) {
            case 0:
                ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                break;
            case 1:
                ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
                break;
            case 2:
                ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
                break;
            case 3:
                ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatColdLeft() {
        int value = DataCanbus.DATA[59];
        switch (value) {
            case 0:
                ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level0);
                break;
            case 1:
                ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level1);
                break;
            case 2:
                ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level2);
                break;
            case 3:
                ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatHeatLeft() {
        int value = DataCanbus.DATA[57];
        switch (value) {
            case 0:
                ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                break;
            case 1:
                ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                break;
            case 2:
                ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
                break;
            case 3:
                ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int value = DataCanbus.DATA[24];
        if (value == 1048576) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
            return;
        }
        if (value == 1048577) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            return;
        }
        if (value == 1048578) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText("None");
        } else if (DataCanbus.DATA[28] == 0) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(value * 0.1f) + "℃");
        } else if (DataCanbus.DATA[28] == 1) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(value / 10) + "℉");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempRight() {
        int value = DataCanbus.DATA[25];
        if (value == 1048576) {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            return;
        }
        if (value == 1048577) {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            return;
        }
        if (value == 1048578) {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText("None");
        } else if (DataCanbus.DATA[28] == 0) {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(value * 0.1f) + "℃");
        } else if (DataCanbus.DATA[28] == 1) {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(value / 10) + "℉");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[19];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[26];
        findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[15];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[18];
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[50];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[49];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[23];
        if (leave < 0) {
            leave = 0;
        }
        if (leave > 8) {
            leave = 8;
        }
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowBodyLeftOn() {
        int acOn = DataCanbus.DATA[21];
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowFootLeftOn() {
        int acOn = DataCanbus.DATA[22];
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowWindow() {
        int acOn = DataCanbus.DATA[20];
        findViewById(R.id.air_xts_mode_win).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
    }
}