package com.syu.carinfo.air;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_Activity_XP_HY_Jeep_UI extends Activity implements View.OnTouchListener {
    public static Air_Activity_XP_HY_Jeep_UI mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.air.Air_Activity_XP_HY_Jeep_UI.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 11) {
                Air_Activity_XP_HY_Jeep_UI.this.mUpdateAcOn();
            }
            if (updateCode == 53) {
                Air_Activity_XP_HY_Jeep_UI.this.mUpdateAcMaxOn();
            }
            if (updateCode == 12) {
                Air_Activity_XP_HY_Jeep_UI.this.mUpdateCycle();
            }
            if (updateCode == 13) {
                Air_Activity_XP_HY_Jeep_UI.this.mUpdateAuto();
            }
            if (updateCode == 62) {
                Air_Activity_XP_HY_Jeep_UI.this.mUpdateSync();
            }
            if (updateCode == 66) {
                Air_Activity_XP_HY_Jeep_UI.this.mUpdateSteer();
            }
            if (updateCode == 16) {
                Air_Activity_XP_HY_Jeep_UI.this.mUpdateRearDefrost();
            }
            if (updateCode == 65) {
                Air_Activity_XP_HY_Jeep_UI.this.mUpdateFrontDefrost();
            }
            if (updateCode == 10) {
                Air_Activity_XP_HY_Jeep_UI.this.mUpdatePower();
            }
            if (updateCode == 21) {
                Air_Activity_XP_HY_Jeep_UI.this.mUpdaterAirWindLevelLeft();
            }
            if (updateCode == 27) {
                Air_Activity_XP_HY_Jeep_UI.this.mUpdateAirTempLeft();
            }
            if (updateCode == 28) {
                Air_Activity_XP_HY_Jeep_UI.this.mUpdateTempRight();
            }
            if (updateCode == 37) {
                Air_Activity_XP_HY_Jeep_UI.this.mUpdateAirTempLeft();
                Air_Activity_XP_HY_Jeep_UI.this.mUpdateTempRight();
            }
            if (updateCode == 29) {
                Air_Activity_XP_HY_Jeep_UI.this.mUpdateHeatLeft();
            }
            if (updateCode == 30) {
                Air_Activity_XP_HY_Jeep_UI.this.mUpdateHeatRight();
            }
            if (updateCode == 31) {
                Air_Activity_XP_HY_Jeep_UI.this.mUpdateBlowLeft();
            }
            if (updateCode == 32) {
                Air_Activity_XP_HY_Jeep_UI.this.mUpdateBlowRight();
            }
            if (updateCode != 18 && updateCode != 19 && updateCode != 20) {
                return;
            }
            Air_Activity_XP_HY_Jeep_UI.this.updateBlowModeLeft();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_air_xp_hy_jeep_ui);
        init();
        mInstance = this;
    }

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(6, new int[]{data0, data1}, null, null);
    }

    private void init() {
        findViewById(R.id.air_sp_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_body_foot).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_foot).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_body).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_foot_win).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_minuts).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatwind_left).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatheat_left).setOnTouchListener(this);
        findViewById(R.id.air_sp_power).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatheat_right).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatwind_right).setOnTouchListener(this);
        findViewById(R.id.air_sp_sync).setOnTouchListener(this);
        findViewById(R.id.air_sp_front).setOnTouchListener(this);
        findViewById(R.id.air_sp_auto).setOnTouchListener(this);
        findViewById(R.id.air_sp_ac).setOnTouchListener(this);
        findViewById(R.id.air_sp_rear).setOnTouchListener(this);
        findViewById(R.id.air_sp_cycle).setOnTouchListener(this);
        findViewById(R.id.air_sp_acmax).setOnTouchListener(this);
        findViewById(R.id.air_sp_steer).setOnTouchListener(this);
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
        ConstAllAirDara.JumpNewAir = false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 255;
        switch (id) {
            case R.id.air_sp_temp_left_plus /* 2131427516 */:
                data0 = 4;
                break;
            case R.id.air_sp_temp_left_munits /* 2131427517 */:
                data0 = 5;
                break;
            case R.id.air_sp_wind_minuts /* 2131427520 */:
                data0 = 7;
                break;
            case R.id.air_sp_wind_plus /* 2131427522 */:
                data0 = 6;
                break;
            case R.id.air_sp_temp_right_plus /* 2131427523 */:
                data0 = 20;
                break;
            case R.id.air_sp_temp_right_munits /* 2131427524 */:
                data0 = 21;
                break;
            case R.id.air_sp_seatheat_left /* 2131427525 */:
                data0 = 17;
                break;
            case R.id.air_sp_seatwind_left /* 2131427526 */:
                data0 = 22;
                break;
            case R.id.air_sp_power /* 2131427528 */:
                data0 = 16;
                break;
            case R.id.air_sp_seatwind_right /* 2131427530 */:
                data0 = 23;
                break;
            case R.id.air_sp_seatheat_right /* 2131427531 */:
                data0 = 18;
                break;
            case R.id.air_sp_front /* 2131427533 */:
                data0 = 12;
                break;
            case R.id.air_sp_auto /* 2131427534 */:
                data0 = 2;
                break;
            case R.id.air_sp_ac /* 2131427535 */:
                data0 = 1;
                break;
            case R.id.air_sp_rear /* 2131427536 */:
                data0 = 14;
                break;
            case R.id.air_sp_cycle /* 2131427537 */:
                data0 = 3;
                break;
            case R.id.air_sp_blow_body_foot /* 2131428082 */:
                data0 = 9;
                break;
            case R.id.air_sp_blow_foot /* 2131428083 */:
                data0 = 10;
                break;
            case R.id.air_sp_blow_body /* 2131428084 */:
                data0 = 8;
                break;
            case R.id.air_sp_blow_foot_win /* 2131428085 */:
                data0 = 11;
                break;
            case R.id.air_sp_acmax /* 2131428086 */:
                data0 = 15;
                break;
            case R.id.air_sp_steer /* 2131428087 */:
                data0 = 24;
                break;
            case R.id.air_sp_sync /* 2131428088 */:
                data0 = 13;
                break;
        }
        if (data0 != 255 && event.getAction() == 0) {
            sendCmd(1, data0);
            return false;
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int temp;
        int temp2 = DataCanbus.DATA[27];
        int unit = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp2) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case -2:
                case 0:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LO");
                    break;
                case -1:
                default:
                    if (unit == 0) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            temp = (temp2 * 9) + 320;
                        } else {
                            temp = temp2 * 5;
                        }
                    } else {
                        temp = temp2 * 10;
                    }
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1 || unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(new StringBuilder(String.valueOf(temp / 10)).toString());
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTempRight() {
        int temp;
        int temp2 = DataCanbus.DATA[28];
        int unit = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (temp2) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                case -2:
                case 0:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LO");
                    break;
                case -1:
                default:
                    if (unit == 0) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            temp = (temp2 * 9) + 320;
                        } else {
                            temp = temp2 * 5;
                        }
                    } else {
                        temp = temp2 * 10;
                    }
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1 || unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(new StringBuilder(String.valueOf(temp / 10)).toString());
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int value = DataCanbus.DATA[21];
        switch (value) {
            case 0:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_7wind_0);
                break;
            case 1:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_7wind_1);
                break;
            case 2:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_7wind_2);
                break;
            case 3:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_7wind_3);
                break;
            case 4:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_7wind_4);
                break;
            case 5:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_7wind_5);
                break;
            case 6:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_7wind_6);
                break;
            case 7:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_7wind_7);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateHeatLeft() {
        int vel = DataCanbus.DATA[29];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_3);
                break;
            case 3:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBlowLeft() {
        int vel = DataCanbus.DATA[31];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_3);
                break;
            case 3:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateHeatRight() {
        int vel = DataCanbus.DATA[30];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_right0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_right1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_right3);
                break;
            case 3:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_right2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBlowRight() {
        int vel = DataCanbus.DATA[32];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_right0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_right1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_right3);
                break;
            case 3:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_right2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSync() {
        int vel = DataCanbus.DATA[62];
        findViewById(R.id.air_sp_sync).setBackgroundResource(vel == 0 ? R.drawable.ic_lzyl_gmscreen_sync_n : R.drawable.ic_lzyl_gmscreen_sync_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSteer() {
        int vel = DataCanbus.DATA[66];
        findViewById(R.id.air_sp_steer).setBackgroundResource(vel == 0 ? R.drawable.ic_lzyl_gmscreen_steer_n : R.drawable.ic_lzyl_gmscreen_steer_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAuto() {
        int vel = DataCanbus.DATA[13];
        findViewById(R.id.air_sp_auto).setBackgroundResource(vel == 0 ? R.drawable.ic_lzyl_gmscreen_auto_n : R.drawable.ic_lzyl_gmscreen_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_sp_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_lzyl_gmscreen_ac_n : R.drawable.ic_lzyl_gmscreen_ac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcMaxOn() {
        int acOn = DataCanbus.DATA[53];
        findViewById(R.id.air_sp_acmax).setBackgroundResource(acOn == 0 ? R.drawable.ic_lzyl_gmscreen_acmax_n : R.drawable.ic_lzyl_gmscreen_acmax_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (cycle == 0) {
            findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_cycle_n);
        } else {
            findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_cycle_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        findViewById(R.id.air_sp_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_lzyl_gmscreen_rear_n : R.drawable.ic_lzyl_gmscreen_rear_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontDefrost() {
        int rear = DataCanbus.DATA[65];
        findViewById(R.id.air_sp_front).setBackgroundResource(rear == 0 ? R.drawable.ic_lzyl_gmscreen_front_n : R.drawable.ic_lzyl_gmscreen_front_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePower() {
        int value = DataCanbus.DATA[10];
        findViewById(R.id.air_sp_power).setBackgroundResource(value == 0 ? R.drawable.ic_lzyl_gmscreen_power_n : R.drawable.ic_lzyl_gmscreen_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowModeLeft() {
        int mode;
        int mode2;
        int mode3;
        int win = DataCanbus.DATA[18];
        int body = DataCanbus.DATA[19];
        int foot = DataCanbus.DATA[20];
        if (win == 1) {
            mode = 0 | 4;
        } else {
            mode = 0 & 251;
        }
        if (body == 1) {
            mode2 = mode | 2;
        } else {
            mode2 = mode & 253;
        }
        if (foot == 1) {
            mode3 = mode2 | 1;
        } else {
            mode3 = mode2 & 254;
        }
        findViewById(R.id.air_sp_blow_body_foot).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_bodyfoot_n);
        findViewById(R.id.air_sp_blow_foot).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_foot_n);
        findViewById(R.id.air_sp_blow_body).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_body_n);
        findViewById(R.id.air_sp_blow_foot_win).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_footwin_n);
        findViewById(R.id.air_sp_mode_up).setVisibility(win == 1 ? 0 : 8);
        findViewById(R.id.air_sp_mode_body).setVisibility(body == 1 ? 0 : 8);
        findViewById(R.id.air_sp_mode_foot).setVisibility(foot != 1 ? 8 : 0);
        switch (mode3) {
            case 1:
                findViewById(R.id.air_sp_blow_foot).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_foot_p);
                break;
            case 2:
                findViewById(R.id.air_sp_blow_body).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_body_p);
                break;
            case 3:
                findViewById(R.id.air_sp_blow_body_foot).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_bodyfoot_p);
                break;
            case 5:
                findViewById(R.id.air_sp_blow_foot_win).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_footwin_p);
                break;
        }
    }
}
