package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KlcGl8_263_AirControlAct extends Activity implements View.OnClickListener {
    public static KlcGl8_263_AirControlAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.KlcGl8_263_AirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 87:
                    KlcGl8_263_AirControlAct.this.mUpdatesyncOn();
                    break;
                case 89:
                    KlcGl8_263_AirControlAct.this.mUpdateCycle();
                    break;
                case 93:
                    KlcGl8_263_AirControlAct.this.mUpdateAcOn();
                    break;
                case 97:
                    KlcGl8_263_AirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 98:
                    KlcGl8_263_AirControlAct.this.mUpdateAirTempRight();
                    break;
                case 102:
                case 296:
                    KlcGl8_263_AirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 107:
                    KlcGl8_263_AirControlAct.this.mUpdatePowerOn();
                    break;
                case 110:
                    KlcGl8_263_AirControlAct.this.mUpdateAirAutoOn();
                    break;
                case 293:
                    KlcGl8_263_AirControlAct.this.mUpdatefrontblow();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_036_wc_gm_gl8_front_airset);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_ac).setOnClickListener(this);
        findViewById(R.id.air_xts_auto).setOnClickListener(this);
        findViewById(R.id.air_xts_front).setOnClickListener(this);
        findViewById(R.id.air_xts_sync).setOnClickListener(this);
        findViewById(R.id.air_xts_cycle).setOnClickListener(this);
        findViewById(R.id.air_xts_power).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_body).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnClickListener(this);
        findViewById(R.id.air_xts_rearpage).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    @Override // android.view.View.OnClickListener
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
            case R.id.air_xts_power /* 2131427428 */:
                YLFunc.CAR_AIR_CONTROL(7, 26);
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
            case R.id.air_xts_rearpage /* 2131427448 */:
                try {
                    startActivity(new Intent(this, (Class<?>) KlcGl8_263_AirControl_Rear.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                YLFunc.CAR_AIR_CONTROL(7, 20);
                YLFunc.CAR_AIR_CONTROL(7, 0);
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                YLFunc.CAR_AIR_CONTROL(7, 21);
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
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[296].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[293].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[293].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[296].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        String str;
        int temp = DataCanbus.DATA[97];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == 0) {
                str = "LOW";
            } else if (temp == 30) {
                str = "HI";
            } else {
                str = String.valueOf(temp * 0.1f) + "℃";
            }
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempRight() {
        String str;
        int temp = DataCanbus.DATA[98];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == 0) {
                str = "LOW";
            } else if (temp == 30) {
                str = "HI";
            } else {
                str = String.valueOf(temp * 0.1f) + "℃";
            }
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePowerOn() {
        int acOn = DataCanbus.DATA[107];
        findViewById(R.id.air_xts_power).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[93];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatesyncOn() {
        int sync = DataCanbus.DATA[87];
        findViewById(R.id.air_xts_sync).setBackgroundResource(sync == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirAutoOn() {
        int auto = DataCanbus.DATA[110];
        findViewById(R.id.air_xts_auto).setBackgroundResource(auto == 1 ? R.drawable.ic_xts_auto_p : R.drawable.ic_xts_auto_n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[89];
        if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        String str;
        int leave = DataCanbus.DATA[102];
        int leaveAuto = DataCanbus.DATA[296];
        if (leaveAuto != 0) {
            str = "A";
        } else {
            str = new StringBuilder().append(leave).toString();
        }
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatefrontblow() {
        int mode = DataCanbus.DATA[293];
        boolean auto = false;
        boolean window = false;
        boolean foot = false;
        boolean up = false;
        boolean upfoot = false;
        boolean windowup = false;
        if (mode == 1) {
            auto = true;
        } else if (mode == 2) {
            window = true;
        } else if (mode == 3) {
            foot = true;
        } else if (mode == 4) {
            upfoot = true;
        } else if (mode == 5) {
            up = true;
        } else if (mode == 8) {
            windowup = true;
        }
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(up ? R.drawable.ic_xts_mode_body_p : R.drawable.ic_xts_mode_body_n);
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(foot ? R.drawable.ic_xts_mode_foot_p : R.drawable.ic_xts_mode_foot_n);
        findViewById(R.id.air_xts_front).setBackgroundResource(window ? R.drawable.ic_xts_front_p : R.drawable.ic_xts_front_n);
        findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(windowup ? R.drawable.ic_xts_mode_footwin_p : R.drawable.ic_xts_mode_footwin_n);
        findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(upfoot ? R.drawable.ic_xts_mode_footbody_p : R.drawable.ic_xts_mode_footbody_n);
        findViewById(R.id.air_xts_auto).setBackgroundResource(auto ? R.drawable.ic_xts_auto_p : R.drawable.ic_xts_auto_n);
    }
}