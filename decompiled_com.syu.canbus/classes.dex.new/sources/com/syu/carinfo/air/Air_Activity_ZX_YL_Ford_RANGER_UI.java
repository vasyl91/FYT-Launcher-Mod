package com.syu.carinfo.air;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_Activity_ZX_YL_Ford_RANGER_UI extends Activity implements View.OnTouchListener {
    public static Air_Activity_ZX_YL_Ford_RANGER_UI mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.air.Air_Activity_ZX_YL_Ford_RANGER_UI.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 11) {
                Air_Activity_ZX_YL_Ford_RANGER_UI.this.mUpdateAcOn();
            }
            if (updateCode == 53) {
                Air_Activity_ZX_YL_Ford_RANGER_UI.this.mUpdateAcMaxOn();
            }
            if (updateCode == 12) {
                Air_Activity_ZX_YL_Ford_RANGER_UI.this.mUpdateCycle();
            }
            if (updateCode == 49) {
                Air_Activity_ZX_YL_Ford_RANGER_UI.this.mUpdateAuto();
            }
            if (updateCode == 14) {
                Air_Activity_ZX_YL_Ford_RANGER_UI.this.mUpdateSync();
            }
            if (updateCode == 16) {
                Air_Activity_ZX_YL_Ford_RANGER_UI.this.mUpdateRearDefrost();
            }
            if (updateCode == 65) {
                Air_Activity_ZX_YL_Ford_RANGER_UI.this.mUpdateFrontDefrost();
            }
            if (updateCode == 10) {
                Air_Activity_ZX_YL_Ford_RANGER_UI.this.mUpdatePower();
            }
            if (updateCode == 21) {
                Air_Activity_ZX_YL_Ford_RANGER_UI.this.mUpdaterAirWindLevelLeft();
            }
            if (updateCode == 27) {
                Air_Activity_ZX_YL_Ford_RANGER_UI.this.mUpdateAirTempLeft();
            }
            if (updateCode == 28) {
                Air_Activity_ZX_YL_Ford_RANGER_UI.this.mUpdateTempRight();
            }
            if (updateCode == 37) {
                Air_Activity_ZX_YL_Ford_RANGER_UI.this.mUpdateAirTempLeft();
                Air_Activity_ZX_YL_Ford_RANGER_UI.this.mUpdateTempRight();
            }
            if (updateCode == 29) {
                Air_Activity_ZX_YL_Ford_RANGER_UI.this.mUpdateHeatLeft();
            }
            if (updateCode == 30) {
                Air_Activity_ZX_YL_Ford_RANGER_UI.this.mUpdateHeatRight();
            }
            if (updateCode == 31) {
                Air_Activity_ZX_YL_Ford_RANGER_UI.this.mUpdateBlowLeft();
            }
            if (updateCode == 32) {
                Air_Activity_ZX_YL_Ford_RANGER_UI.this.mUpdateBlowRight();
            }
            if (updateCode != 18 && updateCode != 19 && updateCode != 20) {
                return;
            }
            Air_Activity_ZX_YL_Ford_RANGER_UI.this.updateBlowModeLeft();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0448_air_zx_yl_ford_ranger_ui);
        init();
        mInstance = this;
    }

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(38, new int[]{data0, data1}, null, null);
    }

    private void sendCmd2(int data0, int data1) {
        DataCanbus.PROXY.cmd(36, new int[]{data0, data1}, null, null);
    }

    private void init() {
        findViewById(R.id.air_sp_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_foot).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_body).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_win).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_minuts).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatwind_left).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatheat_left).setOnTouchListener(this);
        findViewById(R.id.air_sp_power).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatheat_right).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatwind_right).setOnTouchListener(this);
        findViewById(R.id.air_sp_dual).setOnTouchListener(this);
        findViewById(R.id.air_sp_front).setOnTouchListener(this);
        findViewById(R.id.air_sp_auto).setOnTouchListener(this);
        findViewById(R.id.air_sp_ac).setOnTouchListener(this);
        findViewById(R.id.air_sp_rear).setOnTouchListener(this);
        findViewById(R.id.air_sp_cycle).setOnTouchListener(this);
        findViewById(R.id.air_sp_acmax).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
        if (TheApp.getConfiguration() != 1) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_448_6606_Ford_24F150 /* 1835456 */:
                case FinalCanbus.CAR_448_6606_Ford_24F250 /* 1900992 */:
                case FinalCanbus.CAR_448_6606_Ford_24F550 /* 1966528 */:
                    if (DataCanbus.DATA[1003] == 1) {
                        findViewById(R.id.air_sp_mode_change).setBackgroundResource(R.drawable.ic_air_wcylf150_mode_rightnull);
                    } else {
                        findViewById(R.id.air_sp_mode_change).setBackgroundResource(R.drawable.ic_air_wcylf150_mode_null);
                    }
                    break;
                case FinalCanbus.CAR_448_6606_Ford_22Explorer /* 2032064 */:
                    if (DataCanbus.DATA[1003] == 1) {
                        findViewById(R.id.air_sp_mode_change).setBackgroundResource(R.drawable.ic_air_ylexploer_mode_rightnull);
                    } else {
                        findViewById(R.id.air_sp_mode_change).setBackgroundResource(R.drawable.ic_air_ylexploer_mode_null);
                    }
                    break;
                case FinalCanbus.CAR_448_6606_Ford_24Maverick /* 2097600 */:
                    if (DataCanbus.DATA[1003] == 1) {
                        findViewById(R.id.air_sp_mode_change).setBackgroundResource(R.drawable.ic_air_yl_duxingxia_mode_rightnull);
                    } else {
                        findViewById(R.id.air_sp_mode_change).setBackgroundResource(R.drawable.ic_air_yl_duxingxia_mode_null);
                    }
                    break;
            }
            return;
        }
        if (DataCanbus.DATA[1003] == 1) {
            findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.bk_air_zxyl_ford_ranger_right);
        } else {
            findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.bk_air_zxyl_ford_ranger);
        }
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
        int flag = 0;
        switch (id) {
            case R.id.air_sp_temp_left_plus /* 2131427516 */:
                data0 = 1;
                break;
            case R.id.air_sp_temp_left_munits /* 2131427517 */:
                data0 = 2;
                break;
            case R.id.air_sp_wind_minuts /* 2131427520 */:
                data0 = 3;
                break;
            case R.id.air_sp_wind_plus /* 2131427522 */:
                data0 = 4;
                break;
            case R.id.air_sp_temp_right_plus /* 2131427523 */:
                data0 = 8;
                break;
            case R.id.air_sp_temp_right_munits /* 2131427524 */:
                data0 = 9;
                break;
            case R.id.air_sp_seatheat_left /* 2131427525 */:
                data0 = 50;
                break;
            case R.id.air_sp_seatwind_left /* 2131427526 */:
                data0 = 48;
                break;
            case R.id.air_sp_power /* 2131427528 */:
                data0 = 0;
                break;
            case R.id.air_sp_seatwind_right /* 2131427530 */:
                data0 = 49;
                break;
            case R.id.air_sp_seatheat_right /* 2131427531 */:
                data0 = 51;
                break;
            case R.id.air_sp_dual /* 2131427532 */:
                data0 = 13;
                break;
            case R.id.air_sp_front /* 2131427533 */:
                flag = 1;
                data0 = 1;
                break;
            case R.id.air_sp_auto /* 2131427534 */:
                data0 = 16;
                break;
            case R.id.air_sp_ac /* 2131427535 */:
                data0 = 14;
                break;
            case R.id.air_sp_rear /* 2131427536 */:
                flag = 1;
                data0 = 2;
                break;
            case R.id.air_sp_cycle /* 2131427537 */:
                data0 = 15;
                break;
            case R.id.air_sp_blow_foot /* 2131428083 */:
                data0 = 7;
                break;
            case R.id.air_sp_blow_body /* 2131428084 */:
                data0 = 6;
                break;
            case R.id.air_sp_acmax /* 2131428086 */:
                data0 = 23;
                break;
            case R.id.air_sp_blow_win /* 2131428717 */:
                data0 = 5;
                break;
        }
        if (data0 != 255) {
            if (flag == 1) {
                if (event.getAction() == 0) {
                    sendCmd2(data0, 1);
                } else if (event.getAction() == 1) {
                    sendCmd2(data0, 0);
                }
            } else if (event.getAction() == 0) {
                sendCmd(data0, 1);
            } else if (event.getAction() == 1) {
                sendCmd(data0, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
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
        int temp = DataCanbus.DATA[27];
        int unit = DataCanbus.DATA[37];
        if (TheApp.getConfiguration() != 1) {
            findViewById(R.id.air_sp_tempvalue_left).setVisibility(8);
            findViewById(R.id.air_sp_tempstate_left).setVisibility(0);
        }
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case -2:
                case 0:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LO");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NO");
                    break;
                default:
                    if (TheApp.getConfiguration() != 1) {
                        findViewById(R.id.air_sp_tempvalue_left).setVisibility(0);
                        findViewById(R.id.air_sp_tempstate_left).setVisibility(8);
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
        int temp = DataCanbus.DATA[28];
        int unit = DataCanbus.DATA[37];
        if (TheApp.getConfiguration() != 1) {
            findViewById(R.id.air_sp_tempvalue_right).setVisibility(8);
            findViewById(R.id.air_sp_tempstate_right).setVisibility(0);
        }
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                case -2:
                case 0:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LO");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NO");
                    break;
                default:
                    if (TheApp.getConfiguration() != 1) {
                        findViewById(R.id.air_sp_tempvalue_right).setVisibility(0);
                        findViewById(R.id.air_sp_tempstate_right).setVisibility(8);
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
        if (TheApp.getConfiguration() != 1) {
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
        if (TheApp.getConfiguration() != 1) {
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
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBlowLeft() {
        int vel = DataCanbus.DATA[31];
        if (TheApp.getConfiguration() != 1) {
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
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateHeatRight() {
        int vel = DataCanbus.DATA[30];
        if (TheApp.getConfiguration() != 1) {
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
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_right0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_right1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_right2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_right3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBlowRight() {
        int vel = DataCanbus.DATA[32];
        if (TheApp.getConfiguration() != 1) {
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
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_right0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_right1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_right2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_right3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSync() {
        int vel = DataCanbus.DATA[14];
        if (TheApp.getConfiguration() != 1) {
            findViewById(R.id.air_sp_dual).setBackgroundResource(vel == 0 ? R.drawable.ic_wcyl_toyota_dual_n : R.drawable.ic_wcyl_toyota_dual_p);
        } else {
            findViewById(R.id.air_sp_dual).setBackgroundResource(vel == 0 ? R.drawable.ic_lzyl_gmscreen_dual_n : R.drawable.ic_lzyl_gmscreen_dual_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAuto() {
        int vel = DataCanbus.DATA[49];
        if (TheApp.getConfiguration() != 1) {
            findViewById(R.id.air_sp_auto).setBackgroundResource(vel == 0 ? R.drawable.ic_wcyl_toyota_pauto_n : R.drawable.ic_wcyl_toyota_pauto_p);
        } else {
            findViewById(R.id.air_sp_auto).setBackgroundResource(vel == 0 ? R.drawable.ic_lzyl_gmscreen_auto_n : R.drawable.ic_lzyl_gmscreen_auto_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        if (TheApp.getConfiguration() != 1) {
            findViewById(R.id.air_sp_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_wcyl_toyota_pac_n : R.drawable.ic_wcyl_toyota_pac_p);
        } else {
            findViewById(R.id.air_sp_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_lzyl_gmscreen_ac_n : R.drawable.ic_lzyl_gmscreen_ac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcMaxOn() {
        int acOn = DataCanbus.DATA[53];
        if (TheApp.getConfiguration() != 1) {
            findViewById(R.id.air_sp_acmax).setBackgroundResource(acOn == 0 ? R.drawable.ic_wcyl_toyota_acmax_n : R.drawable.ic_wcyl_toyota_acmax_p);
        } else {
            findViewById(R.id.air_sp_acmax).setBackgroundResource(acOn == 0 ? R.drawable.ic_lzyl_gmscreen_acmax_n : R.drawable.ic_lzyl_gmscreen_acmax_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (TheApp.getConfiguration() != 1) {
            if (cycle == 1) {
                findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_wcyl_toyota_cycle_1);
                return;
            } else if (cycle == 3) {
                findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_wcyl_toyota_cycle_2);
                return;
            } else {
                findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_wcyl_toyota_cycle_0);
                return;
            }
        }
        if (cycle == 1) {
            findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_cycle_p);
        } else {
            findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_cycle_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        if (TheApp.getConfiguration() != 1) {
            findViewById(R.id.air_sp_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_wcyl_toyota_rearwin_n : R.drawable.ic_wcyl_toyota_rearwin_p);
        } else {
            findViewById(R.id.air_sp_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_lzyl_gmscreen_rear_n : R.drawable.ic_lzyl_gmscreen_rear_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontDefrost() {
        int rear = DataCanbus.DATA[65];
        if (TheApp.getConfiguration() != 1) {
            findViewById(R.id.air_sp_front).setBackgroundResource(rear == 0 ? R.drawable.ic_wcyl_toyota_frontwin_n : R.drawable.ic_wcyl_toyota_frontwin_p);
        } else {
            findViewById(R.id.air_sp_front).setBackgroundResource(rear == 0 ? R.drawable.ic_lzyl_gmscreen_front_n : R.drawable.ic_lzyl_gmscreen_front_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePower() {
        int value = DataCanbus.DATA[10];
        if (TheApp.getConfiguration() != 1) {
            findViewById(R.id.air_sp_power).setBackgroundResource(value == 0 ? R.drawable.ic_wcyl_toyota_power_n : R.drawable.ic_wcyl_toyota_power_p);
        } else {
            findViewById(R.id.air_sp_power).setBackgroundResource(value == 0 ? R.drawable.ic_lzyl_gmscreen_power_n : R.drawable.ic_lzyl_gmscreen_power_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowModeLeft() {
        int win = DataCanbus.DATA[18];
        int body = DataCanbus.DATA[19];
        int foot = DataCanbus.DATA[20];
        if (TheApp.getConfiguration() != 1) {
            findViewById(R.id.air_sp_mode_up).setVisibility(win == 0 ? 8 : 0);
            findViewById(R.id.air_sp_blow_win).setBackgroundResource(win == 0 ? R.drawable.ic_wcyl_toyota_mode4_n : R.drawable.ic_wcyl_toyota_mode4_p);
            findViewById(R.id.air_sp_mode_body).setVisibility(body == 0 ? 8 : 0);
            findViewById(R.id.air_sp_blow_body).setBackgroundResource(body == 0 ? R.drawable.ic_wcyl_toyota_mode2_n : R.drawable.ic_wcyl_toyota_mode2_p);
            findViewById(R.id.air_sp_mode_foot).setVisibility(foot != 0 ? 0 : 8);
            findViewById(R.id.air_sp_blow_foot).setBackgroundResource(foot == 0 ? R.drawable.ic_wcyl_toyota_mode1_n : R.drawable.ic_wcyl_toyota_mode1_p);
            return;
        }
        if (win == 1) {
            findViewById(R.id.air_sp_blow_win).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_win_p);
        } else {
            findViewById(R.id.air_sp_blow_win).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_win_n);
        }
        if (body == 1) {
            findViewById(R.id.air_sp_blow_body).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_body_p);
        } else {
            findViewById(R.id.air_sp_blow_body).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_body_n);
        }
        if (foot == 1) {
            findViewById(R.id.air_sp_blow_foot).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_foot_p);
        } else {
            findViewById(R.id.air_sp_blow_foot).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_foot_n);
        }
    }
}
