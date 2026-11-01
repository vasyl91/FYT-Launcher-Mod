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
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_Activity_XP_CYT_YL_F150_UI extends Activity implements View.OnTouchListener {
    public static Air_Activity_XP_CYT_YL_F150_UI mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.air.Air_Activity_XP_CYT_YL_F150_UI.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 11) {
                Air_Activity_XP_CYT_YL_F150_UI.this.mUpdateAcOn();
            }
            if (updateCode == 12) {
                Air_Activity_XP_CYT_YL_F150_UI.this.mUpdateCycle();
            }
            if (updateCode == 16) {
                Air_Activity_XP_CYT_YL_F150_UI.this.mUpdateRearDefrost();
            }
            if (updateCode == 15) {
                Air_Activity_XP_CYT_YL_F150_UI.this.mUpdateFrontDefrost();
            }
            if (updateCode == 10) {
                Air_Activity_XP_CYT_YL_F150_UI.this.mUpdatePower();
            }
            if (updateCode == 27 || updateCode == 28) {
                Air_Activity_XP_CYT_YL_F150_UI.this.mUpdateAirTempLeft();
                Air_Activity_XP_CYT_YL_F150_UI.this.mUpdateTempRight();
            }
            if (updateCode == 21) {
                Air_Activity_XP_CYT_YL_F150_UI.this.mUpdaterAirWindLevelLeft();
            }
            if (updateCode == 13) {
                Air_Activity_XP_CYT_YL_F150_UI.this.mUpdateAuto();
            }
            if (updateCode == 62) {
                Air_Activity_XP_CYT_YL_F150_UI.this.mUpdateSync();
            }
            if (updateCode == 53) {
                Air_Activity_XP_CYT_YL_F150_UI.this.mUpdateACMAX();
            }
            if (updateCode == 66) {
                Air_Activity_XP_CYT_YL_F150_UI.this.mUpdateSteerHot();
            }
            if (updateCode == 29) {
                Air_Activity_XP_CYT_YL_F150_UI.this.mUpdateHeatLeft();
            }
            if (updateCode == 30) {
                Air_Activity_XP_CYT_YL_F150_UI.this.mUpdateHeatRight();
            }
            if (updateCode == 31) {
                Air_Activity_XP_CYT_YL_F150_UI.this.mUpdateWindLeft();
            }
            if (updateCode == 32) {
                Air_Activity_XP_CYT_YL_F150_UI.this.mUpdateWindRight();
            }
            if (updateCode != 18 && updateCode != 19 && updateCode != 20) {
                return;
            }
            Air_Activity_XP_CYT_YL_F150_UI.this.updateBlowModeLeft();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_448_6606_Ford_21F150_CYTAIr /* 1704384 */:
            case FinalCanbus.CAR_455_6606_XP_Ford_15F150_CYTAir /* 7864775 */:
            case FinalCanbus.CAR_455_6606_XP_Ford_15F150_CYTAir_R /* 7995847 */:
                setContentView(R.layout.layout_0455_air_xp_cyt_yl_f150_ui_low);
                break;
            case FinalCanbus.CAR_448_6606_Ford_21F150_CYTAIr_H /* 1769920 */:
            case FinalCanbus.CAR_455_6606_XP_Ford_15F150_CYTAir_H /* 7930311 */:
            case FinalCanbus.CAR_455_6606_XP_Ford_15F150_CYTAir_RH /* 8061383 */:
                setContentView(R.layout.layout_0455_air_xp_cyt_yl_f150_ui);
                break;
        }
        init();
        mInstance = this;
    }

    private void sendCmd(int data0) {
        DataCanbus.PROXY.cmd(24, new int[]{data0}, null, null);
    }

    private void init() {
        findViewById(R.id.air_sp_wind_minuts).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_munits).setOnTouchListener(this);
        if (findViewById(R.id.air_sp_auto) != null) {
            findViewById(R.id.air_sp_auto).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_sync) != null) {
            findViewById(R.id.air_sp_sync).setOnTouchListener(this);
        }
        findViewById(R.id.air_sp_acmax).setOnTouchListener(this);
        if (findViewById(R.id.air_sp_steer) != null) {
            findViewById(R.id.air_sp_steer).setOnTouchListener(this);
        }
        findViewById(R.id.air_sp_blow_up).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_body).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_foot).setOnTouchListener(this);
        findViewById(R.id.air_sp_power).setOnTouchListener(this);
        findViewById(R.id.air_sp_ac).setOnTouchListener(this);
        findViewById(R.id.air_sp_front).setOnTouchListener(this);
        findViewById(R.id.air_sp_rear).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatwind_left).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatheat_left).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatheat_right).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatwind_right).setOnTouchListener(this);
        findViewById(R.id.air_sp_cycle).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        if (DataCanbus.DATA[1003] == 1) {
            findViewById(R.id.air_sp_mode_change).setBackgroundResource(R.drawable.ic_air_wcylf150_mode_rightnull);
        } else {
            findViewById(R.id.air_sp_mode_change).setBackgroundResource(R.drawable.ic_air_wcylf150_mode_null);
        }
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
                data0 = 9;
                break;
            case R.id.air_sp_temp_left_munits /* 2131427517 */:
                data0 = 10;
                break;
            case R.id.air_sp_wind_minuts /* 2131427520 */:
                data0 = 21;
                break;
            case R.id.air_sp_wind_plus /* 2131427522 */:
                data0 = 20;
                break;
            case R.id.air_sp_temp_right_plus /* 2131427523 */:
                data0 = 11;
                break;
            case R.id.air_sp_temp_right_munits /* 2131427524 */:
                data0 = 12;
                break;
            case R.id.air_sp_seatheat_left /* 2131427525 */:
                data0 = 13;
                break;
            case R.id.air_sp_seatwind_left /* 2131427526 */:
                data0 = 45;
                break;
            case R.id.air_sp_power /* 2131427528 */:
                data0 = 1;
                break;
            case R.id.air_sp_seatwind_right /* 2131427530 */:
                data0 = 46;
                break;
            case R.id.air_sp_seatheat_right /* 2131427531 */:
                data0 = 14;
                break;
            case R.id.air_sp_front /* 2131427533 */:
                data0 = 38;
                break;
            case R.id.air_sp_auto /* 2131427534 */:
                data0 = 2;
                break;
            case R.id.air_sp_ac /* 2131427535 */:
                data0 = 16;
                break;
            case R.id.air_sp_rear /* 2131427536 */:
                data0 = 4;
                break;
            case R.id.air_sp_cycle /* 2131427537 */:
                data0 = 35;
                break;
            case R.id.air_sp_blow_foot /* 2131428083 */:
                data0 = 31;
                break;
            case R.id.air_sp_blow_body /* 2131428084 */:
                data0 = 29;
                break;
            case R.id.air_sp_acmax /* 2131428086 */:
                data0 = 39;
                break;
            case R.id.air_sp_steer /* 2131428087 */:
                data0 = 47;
                break;
            case R.id.air_sp_sync /* 2131428088 */:
                data0 = 8;
                break;
            case R.id.air_sp_blow_up /* 2131428861 */:
                data0 = 3;
                break;
        }
        if (data0 != 255 && event.getAction() == 0) {
            sendCmd(data0);
            return false;
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int TempUnit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[27];
        int Unit = SystemProperties.getInt("persist.fyt.temperature", 0);
        findViewById(R.id.air_sp_tempvalue_left).setVisibility(8);
        findViewById(R.id.air_sp_tempstate_left).setVisibility(0);
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.air_sp_tempstate_left)).setText("HI");
                    break;
                case -2:
                case 0:
                    ((TextView) findViewById(R.id.air_sp_tempstate_left)).setText("LO");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.air_sp_tempstate_left)).setText("--");
                    break;
                default:
                    findViewById(R.id.air_sp_tempvalue_left).setVisibility(0);
                    findViewById(R.id.air_sp_tempstate_left).setVisibility(8);
                    if (Unit == 1 || TempUnit == 1) {
                        ((TextView) findViewById(R.id.air_sp_tempunit_left)).setText("℉");
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(new StringBuilder(String.valueOf(temp / 10)).toString());
                    } else {
                        ((TextView) findViewById(R.id.air_sp_tempunit_left)).setText("℃");
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTempRight() {
        int TempUnit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[28];
        int Unit = SystemProperties.getInt("persist.fyt.temperature", 0);
        findViewById(R.id.air_sp_tempvalue_right).setVisibility(8);
        findViewById(R.id.air_sp_tempstate_right).setVisibility(0);
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.air_sp_tempstate_right)).setText("HI");
                    break;
                case -2:
                case 0:
                    ((TextView) findViewById(R.id.air_sp_tempstate_right)).setText("LO");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.air_sp_tempstate_right)).setText("--");
                    break;
                default:
                    findViewById(R.id.air_sp_tempvalue_right).setVisibility(0);
                    findViewById(R.id.air_sp_tempstate_right).setVisibility(8);
                    if (Unit == 1 || TempUnit == 1) {
                        ((TextView) findViewById(R.id.air_sp_tempunit_right)).setText("℉");
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(new StringBuilder(String.valueOf(temp / 10)).toString());
                    } else {
                        ((TextView) findViewById(R.id.air_sp_tempunit_right)).setText("℃");
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
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_wcyl_toyota_wind_0);
                break;
            case 1:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_wcyl_toyota_wind_1);
                break;
            case 2:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_wcyl_toyota_wind_2);
                break;
            case 3:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_wcyl_toyota_wind_3);
                break;
            case 4:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_wcyl_toyota_wind_4);
                break;
            case 5:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_wcyl_toyota_wind_5);
                break;
            case 6:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_wcyl_toyota_wind_6);
                break;
            case 7:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_wcyl_toyota_wind_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateHeatLeft() {
        int vel = DataCanbus.DATA[29];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_wcyl_toyota_seathot_left_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_wcyl_toyota_seathot_left_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_wcyl_toyota_seathot_left_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_wcyl_toyota_seathot_left_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateHeatRight() {
        int vel = DataCanbus.DATA[30];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_wcyl_toyota_seathot_right_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_wcyl_toyota_seathot_right_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_wcyl_toyota_seathot_right_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_wcyl_toyota_seathot_right_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateWindLeft() {
        int vel = DataCanbus.DATA[31];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_wcyl_toyota_seatblow_left_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_wcyl_toyota_seatblow_left_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_wcyl_toyota_seatblow_left_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_wcyl_toyota_seatblow_left_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateWindRight() {
        int vel = DataCanbus.DATA[32];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_wcyl_toyota_seatblow_right_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_wcyl_toyota_seatblow_right_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_wcyl_toyota_seatblow_right_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_wcyl_toyota_seatblow_right_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSteerHot() {
        int vel = DataCanbus.DATA[66];
        if (findViewById(R.id.air_sp_steer) != null) {
            findViewById(R.id.air_sp_steer).setBackgroundResource(vel == 0 ? R.drawable.ic_wcyl_toyota_steer_n : R.drawable.ic_wcyl_toyota_steer_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateACMAX() {
        int vel = DataCanbus.DATA[53];
        if (findViewById(R.id.air_sp_acmax) != null) {
            findViewById(R.id.air_sp_acmax).setBackgroundResource(vel == 0 ? R.drawable.ic_wcyl_toyota_acmax_n : R.drawable.ic_wcyl_toyota_acmax_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSync() {
        int vel = DataCanbus.DATA[62];
        if (findViewById(R.id.air_sp_sync) != null) {
            findViewById(R.id.air_sp_sync).setBackgroundResource(vel == 0 ? R.drawable.ic_wcyl_toyota_sync_n : R.drawable.ic_wcyl_toyota_sync_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAuto() {
        int vel = DataCanbus.DATA[13];
        if (findViewById(R.id.air_sp_auto) != null) {
            findViewById(R.id.air_sp_auto).setBackgroundResource(vel == 0 ? R.drawable.ic_wcyl_toyota_pauto_n : R.drawable.ic_wcyl_toyota_pauto_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_sp_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_wcyl_toyota_pac_n : R.drawable.ic_wcyl_toyota_pac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (cycle == 1) {
            findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_wcyl_toyota_cycle_1);
        } else if (cycle == 3) {
            findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_wcyl_toyota_cycle_2);
        } else {
            findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_wcyl_toyota_cycle_0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        findViewById(R.id.air_sp_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_wcyl_toyota_rearwin_n : R.drawable.ic_wcyl_toyota_rearwin_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontDefrost() {
        int rear = DataCanbus.DATA[15];
        findViewById(R.id.air_sp_front).setBackgroundResource(rear == 0 ? R.drawable.ic_wcyl_toyota_frontwin_n : R.drawable.ic_wcyl_toyota_frontwin_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePower() {
        int value = DataCanbus.DATA[10];
        findViewById(R.id.air_sp_power).setBackgroundResource(value == 0 ? R.drawable.ic_wcyl_toyota_power_n : R.drawable.ic_wcyl_toyota_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowModeLeft() {
        int mode;
        int mode2;
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
            int i = mode2 | 1;
        } else {
            int i2 = mode2 & 254;
        }
        findViewById(R.id.air_sp_mode_up).setVisibility(win == 0 ? 8 : 0);
        findViewById(R.id.air_sp_blow_up).setBackgroundResource(win == 0 ? R.drawable.ic_wcyl_toyota_mode4_n : R.drawable.ic_wcyl_toyota_mode4_p);
        findViewById(R.id.air_sp_mode_body).setVisibility(body == 0 ? 8 : 0);
        findViewById(R.id.air_sp_blow_body).setBackgroundResource(body == 0 ? R.drawable.ic_wcyl_toyota_mode2_n : R.drawable.ic_wcyl_toyota_mode2_p);
        findViewById(R.id.air_sp_mode_foot).setVisibility(foot != 0 ? 0 : 8);
        findViewById(R.id.air_sp_blow_foot).setBackgroundResource(body == 0 ? R.drawable.ic_wcyl_toyota_mode1_n : R.drawable.ic_wcyl_toyota_mode1_p);
    }
}
