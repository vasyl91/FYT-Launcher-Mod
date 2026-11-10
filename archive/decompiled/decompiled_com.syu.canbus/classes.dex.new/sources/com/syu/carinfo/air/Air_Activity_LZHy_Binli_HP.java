package com.syu.carinfo.air;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_Activity_LZHy_Binli_HP extends Activity implements View.OnTouchListener {
    public static Air_Activity_LZHy_Binli_HP mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.air.Air_Activity_LZHy_Binli_HP.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 11) {
                Air_Activity_LZHy_Binli_HP.this.mUpdateAcOn();
            }
            if (updateCode == 12) {
                Air_Activity_LZHy_Binli_HP.this.mUpdateCycle();
            }
            if (updateCode == 16) {
                Air_Activity_LZHy_Binli_HP.this.mUpdateRearDefrost();
            }
            if (updateCode == 65) {
                Air_Activity_LZHy_Binli_HP.this.mUpdateFrontDefrost();
            }
            if (updateCode == 10) {
                Air_Activity_LZHy_Binli_HP.this.mUpdatePower();
            }
            if (updateCode == 27) {
                Air_Activity_LZHy_Binli_HP.this.mUpdateAirTempLeft();
            }
            if (updateCode == 21) {
                Air_Activity_LZHy_Binli_HP.this.mUpdaterAirWindLevelLeft();
            }
            if (updateCode == 13) {
                Air_Activity_LZHy_Binli_HP.this.mUpdateAuto();
            }
            if (updateCode == 26) {
                Air_Activity_LZHy_Binli_HP.this.mUpdateAutoRight();
            }
            if (updateCode == 62) {
                Air_Activity_LZHy_Binli_HP.this.mUpdateSYNC();
            }
            if (updateCode == 28) {
                Air_Activity_LZHy_Binli_HP.this.mUpdateTempRight();
            }
            if (updateCode == 37) {
                Air_Activity_LZHy_Binli_HP.this.mUpdateTempUNIT();
            }
            if (updateCode == 67) {
                Air_Activity_LZHy_Binli_HP.this.mUpdateRearLock();
            }
            if (updateCode == 18 || updateCode == 19 || updateCode == 20) {
                Air_Activity_LZHy_Binli_HP.this.updateBlowModeLeft();
            }
            if (updateCode != 22 && updateCode != 23 && updateCode != 24) {
                return;
            }
            Air_Activity_LZHy_Binli_HP.this.updateBlowModeRight();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_air_hp_all_hy_lu_binli);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_sp_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_win).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_body).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_foot).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_win_right).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_body_right).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_foot_right).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_minuts).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_ac).setOnTouchListener(this);
        findViewById(R.id.air_sp_sync).setOnTouchListener(this);
        findViewById(R.id.air_sp_front).setOnTouchListener(this);
        findViewById(R.id.air_sp_rear).setOnTouchListener(this);
        findViewById(R.id.air_sp_auto).setOnTouchListener(this);
        findViewById(R.id.air_sp_cycle).setOnTouchListener(this);
        findViewById(R.id.air_sp_auto_right).setOnTouchListener(this);
        findViewById(R.id.air_sp_rest).setOnTouchListener(this);
        findViewById(R.id.air_sp_aqs).setOnTouchListener(this);
        findViewById(R.id.air_sp_car_rear).setOnTouchListener(this);
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
        int data0 = 255;
        switch (id) {
            case R.id.air_sp_temp_left_plus /* 2131427516 */:
                data0 = 1;
                break;
            case R.id.air_sp_temp_left_munits /* 2131427517 */:
                data0 = 2;
                break;
            case R.id.air_sp_wind_minuts /* 2131427520 */:
                data0 = 6;
                break;
            case R.id.air_sp_wind_plus /* 2131427522 */:
                data0 = 5;
                break;
            case R.id.air_sp_temp_right_plus /* 2131427523 */:
                data0 = 3;
                break;
            case R.id.air_sp_temp_right_munits /* 2131427524 */:
                data0 = 4;
                break;
            case R.id.air_sp_front /* 2131427533 */:
                data0 = 12;
                break;
            case R.id.air_sp_auto /* 2131427534 */:
                data0 = 10;
                break;
            case R.id.air_sp_ac /* 2131427535 */:
                data0 = 8;
                break;
            case R.id.air_sp_rear /* 2131427536 */:
                data0 = 13;
                break;
            case R.id.air_sp_cycle /* 2131427537 */:
                data0 = 9;
                break;
            case R.id.air_sp_blow_foot /* 2131428083 */:
                data0 = 15;
                break;
            case R.id.air_sp_blow_body /* 2131428084 */:
                data0 = 14;
                break;
            case R.id.air_sp_sync /* 2131428088 */:
                data0 = 7;
                break;
            case R.id.air_sp_blow_win /* 2131428717 */:
                data0 = 16;
                break;
            case R.id.air_sp_auto_right /* 2131429692 */:
                data0 = 11;
                break;
            case R.id.air_sp_blow_win_right /* 2131429713 */:
                data0 = 19;
                break;
            case R.id.air_sp_blow_body_right /* 2131429714 */:
                data0 = 17;
                break;
            case R.id.air_sp_blow_foot_right /* 2131429715 */:
                data0 = 18;
                break;
            case R.id.air_sp_car_rear /* 2131429716 */:
                data0 = 22;
                break;
            case R.id.air_sp_aqs /* 2131429717 */:
                data0 = 20;
                break;
            case R.id.air_sp_rest /* 2131429718 */:
                data0 = 21;
                break;
        }
        if (event.getAction() == 0) {
            DataCanbus.PROXY.cmd(0, new int[]{data0}, null, null);
        } else if (event.getAction() == 1) {
            DataCanbus.PROXY.cmd(0, new int[1], null, null);
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    private void mUpdateTempValue(int id, int value, boolean isdian) {
        if (isdian) {
            switch (value) {
                case 0:
                    findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp_dian0);
                    break;
                case 5:
                    findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp_dian5);
                    break;
            }
        }
        switch (value) {
            case 0:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp0);
                break;
            case 1:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp1);
                break;
            case 2:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp2);
                break;
            case 3:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp3);
                break;
            case 4:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp4);
                break;
            case 5:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp5);
                break;
            case 6:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp6);
                break;
            case 7:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp7);
                break;
            case 8:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp8);
                break;
            case 9:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp9);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int temp;
        int temp2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
        if (findViewById(R.id.air_sp_temp_left1) != null) {
            if (temp2 == ConstAllAirDara.TEMPERATURE_LOW) {
                findViewById(R.id.air_sp_tempvalue_left).setVisibility(8);
                findViewById(R.id.air_sp_tempunit_left).setVisibility(8);
                findViewById(R.id.air_sp_tempstate_left).setVisibility(0);
                findViewById(R.id.air_sp_tempstate_left).setBackgroundResource(R.drawable.ic_hp_air_tempstate_l);
                return;
            }
            if (temp2 == ConstAllAirDara.TEMPERATURE_HIGHT) {
                findViewById(R.id.air_sp_tempvalue_left).setVisibility(8);
                findViewById(R.id.air_sp_tempunit_left).setVisibility(8);
                findViewById(R.id.air_sp_tempstate_left).setVisibility(0);
                findViewById(R.id.air_sp_tempstate_left).setBackgroundResource(R.drawable.ic_hp_air_tempstate_h);
                return;
            }
            if (temp2 == ConstAllAirDara.TEMPERATURE_NONE) {
                findViewById(R.id.air_sp_tempvalue_left).setVisibility(8);
                findViewById(R.id.air_sp_tempunit_left).setVisibility(8);
                findViewById(R.id.air_sp_tempstate_left).setVisibility(0);
                findViewById(R.id.air_sp_tempstate_left).setBackgroundResource(R.drawable.ic_hp_air_tempstate_n);
                return;
            }
            findViewById(R.id.air_sp_tempvalue_left).setVisibility(0);
            findViewById(R.id.air_sp_tempunit_left).setVisibility(0);
            findViewById(R.id.air_sp_tempstate_left).setVisibility(8);
            if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                temp = (temp2 * 9) + 320;
            } else {
                temp = temp2 * 5;
            }
            mUpdateTempValue(R.id.air_sp_temp_left1, temp / 100, false);
            mUpdateTempValue(R.id.air_sp_temp_left2, (temp % 100) / 10, false);
            mUpdateTempValue(R.id.air_sp_temp_left3, temp % 10, true);
            mUpdateTempUNIT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTempRight() {
        int temp;
        int temp2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_RIGHT];
        if (findViewById(R.id.air_sp_temp_right1) != null) {
            if (temp2 == ConstAllAirDara.TEMPERATURE_LOW) {
                findViewById(R.id.air_sp_tempvalue_right).setVisibility(8);
                findViewById(R.id.air_sp_tempunit_right).setVisibility(8);
                findViewById(R.id.air_sp_tempstate_right).setVisibility(0);
                findViewById(R.id.air_sp_tempstate_right).setBackgroundResource(R.drawable.ic_hp_air_tempstate_l);
                return;
            }
            if (temp2 == ConstAllAirDara.TEMPERATURE_HIGHT) {
                findViewById(R.id.air_sp_tempvalue_right).setVisibility(8);
                findViewById(R.id.air_sp_tempunit_right).setVisibility(8);
                findViewById(R.id.air_sp_tempstate_right).setVisibility(0);
                findViewById(R.id.air_sp_tempstate_right).setBackgroundResource(R.drawable.ic_hp_air_tempstate_h);
                return;
            }
            if (temp2 == ConstAllAirDara.TEMPERATURE_NONE) {
                findViewById(R.id.air_sp_tempvalue_right).setVisibility(8);
                findViewById(R.id.air_sp_tempunit_right).setVisibility(8);
                findViewById(R.id.air_sp_tempstate_right).setVisibility(0);
                findViewById(R.id.air_sp_tempstate_right).setBackgroundResource(R.drawable.ic_hp_air_tempstate_n);
                return;
            }
            findViewById(R.id.air_sp_tempvalue_right).setVisibility(0);
            findViewById(R.id.air_sp_tempunit_right).setVisibility(0);
            findViewById(R.id.air_sp_tempstate_right).setVisibility(8);
            if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                temp = (temp2 * 9) + 320;
            } else {
                temp = temp2 * 5;
            }
            mUpdateTempValue(R.id.air_sp_temp_right1, temp / 100, false);
            mUpdateTempValue(R.id.air_sp_temp_right2, (temp % 100) / 10, false);
            mUpdateTempValue(R.id.air_sp_temp_right3, temp % 10, true);
            mUpdateTempUNIT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTempUNIT() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT];
        if (vel == 1) {
            findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
            findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
        } else {
            findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
            findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearLock() {
        int vel = DataCanbus.DATA[67];
        findViewById(R.id.air_sp_car_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hy_binli_rearlock_n : R.drawable.ic_hy_binli_rearlock_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int value = DataCanbus.DATA[21];
        ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
        ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setProgress(value);
        ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).invalidate();
        findViewById(R.id.air_sp_power).setBackgroundResource(value == 0 ? R.drawable.ic_hp_power_n : R.drawable.ic_hp_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSYNC() {
        int vel = DataCanbus.DATA[62];
        findViewById(R.id.air_sp_sync).setBackgroundResource(vel == 0 ? R.drawable.ic_hy_binli_sync_n : R.drawable.ic_hy_binli_sync_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAutoRight() {
        int vel = DataCanbus.DATA[26];
        findViewById(R.id.air_sp_auto_right).setBackgroundResource(vel == 0 ? R.drawable.ic_hy_binli_auto_n : R.drawable.ic_hy_binli_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAuto() {
        int vel = DataCanbus.DATA[13];
        findViewById(R.id.air_sp_auto).setBackgroundResource(vel == 0 ? R.drawable.ic_hy_binli_auto_n : R.drawable.ic_hy_binli_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_sp_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_hy_binli_ac_n : R.drawable.ic_hy_binli_ac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        findViewById(R.id.air_sp_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_hy_binli_rear_n : R.drawable.ic_hy_binli_rear_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontDefrost() {
        int rear = DataCanbus.DATA[65];
        findViewById(R.id.air_sp_front).setBackgroundResource(rear == 0 ? R.drawable.ic_hy_binli_front_n : R.drawable.ic_hy_binli_front_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        findViewById(R.id.air_sp_cycle).setBackgroundResource(cycle == 0 ? R.drawable.ic_hy_binli_cycleout_n : R.drawable.ic_hy_binli_cyclein_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePower() {
        int value = DataCanbus.DATA[10];
        findViewById(R.id.air_sp_power).setBackgroundResource(value == 0 ? R.drawable.ic_hp_power_n : R.drawable.ic_hp_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowModeLeft() {
        int win = DataCanbus.DATA[18];
        int body = DataCanbus.DATA[19];
        int foot = DataCanbus.DATA[20];
        findViewById(R.id.air_sp_blow_win).setBackgroundResource(win == 0 ? R.drawable.ic_hy_binli_mode_win_n : R.drawable.ic_hy_binli_mode_win_p);
        findViewById(R.id.air_sp_blow_body).setBackgroundResource(body == 0 ? R.drawable.ic_hy_binli_mode_body_n : R.drawable.ic_hy_binli_mode_body_p);
        findViewById(R.id.air_sp_blow_foot).setBackgroundResource(foot == 0 ? R.drawable.ic_hy_binli_mode_foot_n : R.drawable.ic_hy_binli_mode_foot_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowModeRight() {
        int win = DataCanbus.DATA[22];
        int body = DataCanbus.DATA[23];
        int foot = DataCanbus.DATA[24];
        findViewById(R.id.air_sp_blow_win_right).setBackgroundResource(win == 0 ? R.drawable.ic_hy_binli_mode_rightwin_n : R.drawable.ic_hy_binli_mode_rightwin_p);
        findViewById(R.id.air_sp_blow_body_right).setBackgroundResource(body == 0 ? R.drawable.ic_hy_binli_mode_rightbody_n : R.drawable.ic_hy_binli_mode_rightbody_p);
        findViewById(R.id.air_sp_blow_foot_right).setBackgroundResource(foot == 0 ? R.drawable.ic_hy_binli_mode_rightfoot_n : R.drawable.ic_hy_binli_mode_rightfoot_p);
    }
}
