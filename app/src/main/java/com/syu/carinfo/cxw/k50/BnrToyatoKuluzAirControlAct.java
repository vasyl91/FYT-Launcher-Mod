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
public class BnrToyatoKuluzAirControlAct extends Activity implements View.OnTouchListener {
    public static BnrToyatoKuluzAirControlAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.cxw.k50.BnrToyatoKuluzAirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 60:
                    BnrToyatoKuluzAirControlAct.this.mUpdatePowerOn();
                    break;
                case 61:
                    BnrToyatoKuluzAirControlAct.this.mUpdateAcOn();
                    break;
                case 62:
                    BnrToyatoKuluzAirControlAct.this.mUpdateCycle();
                    break;
                case 64:
                    BnrToyatoKuluzAirControlAct.this.mUpdateAutoOn();
                    break;
                case 65:
                    BnrToyatoKuluzAirControlAct.this.mUpdateDualOn();
                    break;
                case 66:
                    BnrToyatoKuluzAirControlAct.this.mUpdateFrontDefrost();
                    break;
                case 67:
                case 68:
                case 69:
                    BnrToyatoKuluzAirControlAct.this.mUpdateModeOnlyLeft();
                    break;
                case 70:
                    BnrToyatoKuluzAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 71:
                    BnrToyatoKuluzAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 72:
                    BnrToyatoKuluzAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 73:
                    BnrToyatoKuluzAirControlAct.this.mUpdateRearDefrost();
                    break;
                case 74:
                    BnrToyatoKuluzAirControlAct.this.mUpdateAirTempLeft();
                    BnrToyatoKuluzAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 108:
                    BnrToyatoKuluzAirControlAct.this.mUpdateClearAir();
                    break;
                case 117:
                    BnrToyatoKuluzAirControlAct.this.mUpdateRearCtrlOn();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int state) {
        DataCanbus.PROXY.cmd(22, new int[]{data0, state}, null, null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0397_bnr_toyato_klz_air_control);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_munits).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_plus).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear_defrog).setOnTouchListener(this);
        findViewById(R.id.air_xts_front_defrost).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_clearair).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
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
                data0 = 3;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 2;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 9;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 10;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
                data0 = 67;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 21;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 25;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 23;
                break;
            case R.id.air_xts_clearair /* 2131427447 */:
                data0 = 32;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 5;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 4;
                break;
            case R.id.air_xts_mode_munits /* 2131427455 */:
                data0 = 7;
                break;
            case R.id.air_xts_mode_plus /* 2131427456 */:
                data0 = 8;
                break;
            case R.id.air_xts_dual /* 2131427460 */:
                data0 = 16;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data0 = 42;
                break;
            case R.id.air_xts_rear_defrog /* 2131428024 */:
                data0 = 20;
                break;
            case R.id.air_xts_front_defrost /* 2131428025 */:
                data0 = 19;
                break;
        }
        if (event.getAction() == 0) {
            sendCmd(data0, 1);
        } else if (event.getAction() == 1) {
            sendCmd(data0, 0);
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
    }

    private void mUpdateModeright() {
        int win = DataCanbus.DATA[156];
        int body = DataCanbus.DATA[157];
        int foot = DataCanbus.DATA[158];
        int mode = ((win << 2) & 4) | ((body << 1) & 2) | ((foot << 0) & 1);
        switch (mode) {
            case 1:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list1);
                break;
            case 2:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list2);
                break;
            case 3:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list3);
                break;
            case 4:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list4);
                break;
            case 5:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list5);
                break;
            case 6:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list6);
                break;
            case 7:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list7);
                break;
            default:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_null);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateModeOnlyLeft() {
        int win = DataCanbus.DATA[67];
        int body = DataCanbus.DATA[68];
        int foot = DataCanbus.DATA[69];
        int mode = ((win << 2) & 4) | ((body << 1) & 2) | ((foot << 0) & 1);
        switch (mode) {
            case 1:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list1);
                break;
            case 2:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list2);
                break;
            case 3:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list3);
                break;
            case 4:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list4);
                break;
            case 5:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list5);
                break;
            case 6:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list6);
                break;
            case 7:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list7);
                break;
            default:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_null);
                break;
        }
    }

    private void mUpdateModeLeft() {
        int win = DataCanbus.DATA[153];
        int body = DataCanbus.DATA[154];
        int foot = DataCanbus.DATA[155];
        int mode = ((win << 2) & 4) | ((body << 1) & 2) | ((foot << 0) & 1);
        switch (mode) {
            case 1:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list1);
                break;
            case 2:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list2);
                break;
            case 3:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list3);
                break;
            case 4:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list4);
                break;
            case 5:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list5);
                break;
            case 6:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list6);
                break;
            case 7:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list7);
                break;
            default:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_null);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[72];
        int unit = DataCanbus.DATA[74];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LO");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("--");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(temp + 64) + "℉");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(temp / 10) + "." + (temp % 10) + "℃");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[71];
        int unit = DataCanbus.DATA[74];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LO");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("--");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(temp + 64) + "℉");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(temp / 10) + "." + (temp % 10) + "℃");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearCtrlOn() {
        int acOn = DataCanbus.DATA[117];
        findViewById(R.id.air_xts_rear).setBackgroundResource(acOn == 0 ? R.drawable.ic_wc_toyota_klz_rear_n : R.drawable.ic_wc_toyota_klz_rear_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[65];
        findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 0 ? R.drawable.ic_wc_toyota_klz_zone_n : R.drawable.ic_wc_toyota_klz_zone_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[64];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_wc_toyota_klz_auto_n : R.drawable.ic_wc_toyota_klz_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[61];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_wc_toyota_klz_ac_n : R.drawable.ic_wc_toyota_klz_ac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[60];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_air_cxw_k50_power_n : R.drawable.ic_air_cxw_k50_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateClearAir() {
        int on = DataCanbus.DATA[108];
        findViewById(R.id.air_xts_clearair).setBackgroundResource(on == 0 ? R.drawable.ic_wc_toyota_klz_clearair_n : R.drawable.ic_wc_toyota_klz_clearair_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[62];
        findViewById(R.id.air_xts_cycle).setBackgroundResource(cycle == 0 ? R.drawable.ic_wc_toyota_klz_cycle_outer_p : R.drawable.ic_wc_toyota_klz_cycle_inter_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[66];
        findViewById(R.id.air_xts_front_defrost).setBackgroundResource(front == 0 ? R.drawable.ic_wc_toyota_klz_front_defrost_n : R.drawable.ic_wc_toyota_klz_front_defrost_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[73];
        findViewById(R.id.air_xts_rear_defrog).setBackgroundResource(rear == 0 ? R.drawable.ic_wc_toyota_klz_rear_defrost_n : R.drawable.ic_wc_toyota_klz_rear_defrost_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[70];
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
}
