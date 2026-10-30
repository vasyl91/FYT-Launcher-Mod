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
public class Air_Activity_Tangdu_YL_Toyota_UI extends Activity implements View.OnTouchListener {
    public static Air_Activity_Tangdu_YL_Toyota_UI mInstance;
    public static boolean mIsFront = false;
    int pagenum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.air.Air_Activity_Tangdu_YL_Toyota_UI.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 11) {
                Air_Activity_Tangdu_YL_Toyota_UI.this.mUpdateAcOn();
            }
            if (updateCode == 12 || updateCode == 54) {
                Air_Activity_Tangdu_YL_Toyota_UI.this.mUpdateCycle();
            }
            if (updateCode == 16) {
                Air_Activity_Tangdu_YL_Toyota_UI.this.mUpdateRearDefrost();
            }
            if (updateCode == 17) {
                Air_Activity_Tangdu_YL_Toyota_UI.this.mUpdateFrontHot();
            }
            if (updateCode == 33) {
                Air_Activity_Tangdu_YL_Toyota_UI.this.mUpdateFlowerBlow();
            }
            if (updateCode == 15) {
                Air_Activity_Tangdu_YL_Toyota_UI.this.mUpdateFrontDefrost();
            }
            if (updateCode == 10) {
                Air_Activity_Tangdu_YL_Toyota_UI.this.mUpdatePower();
            }
            if (updateCode == 42) {
                Air_Activity_Tangdu_YL_Toyota_UI.this.mUpdateRearPower();
            }
            if (updateCode == 27 || updateCode == 40 || updateCode == 28 || updateCode == 41) {
                Air_Activity_Tangdu_YL_Toyota_UI.this.mUpdateAirTempLeft();
                Air_Activity_Tangdu_YL_Toyota_UI.this.mUpdateTempRight();
            }
            if (updateCode == 21 || updateCode == 44) {
                Air_Activity_Tangdu_YL_Toyota_UI.this.mUpdaterAirWindLevelLeft();
            }
            if (updateCode == 13) {
                Air_Activity_Tangdu_YL_Toyota_UI.this.mUpdateAuto();
            }
            if (updateCode == 14) {
                Air_Activity_Tangdu_YL_Toyota_UI.this.mUpdateDual();
            }
            if (updateCode == 43) {
                Air_Activity_Tangdu_YL_Toyota_UI.this.mUpdateBackAuto();
            }
            if (updateCode == 67) {
                Air_Activity_Tangdu_YL_Toyota_UI.this.mUpdateBackRearLock();
            }
            if (updateCode == 18 || updateCode == 19 || updateCode == 20) {
                Air_Activity_Tangdu_YL_Toyota_UI.this.updateBlowModeLeft();
            }
            if (updateCode != 46 && updateCode != 47) {
                return;
            }
            Air_Activity_Tangdu_YL_Toyota_UI.this.updateBlowBackMode();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_air_tangdu_yl_toyota_ui);
        init();
        mInstance = this;
    }

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
    }

    private void init() {
        findViewById(R.id.tv_sp_rear).setOnTouchListener(this);
        findViewById(R.id.tv_sp_front).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_minuts).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_fronthot).setOnTouchListener(this);
        findViewById(R.id.air_sp_flowerblow).setOnTouchListener(this);
        findViewById(R.id.air_sp_dual).setOnTouchListener(this);
        findViewById(R.id.air_sp_cycle).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_changer).setOnTouchListener(this);
        findViewById(R.id.air_sp_power).setOnTouchListener(this);
        findViewById(R.id.air_sp_auto).setOnTouchListener(this);
        findViewById(R.id.air_sp_ac).setOnTouchListener(this);
        findViewById(R.id.air_sp_front).setOnTouchListener(this);
        findViewById(R.id.air_sp_rear).setOnTouchListener(this);
        findViewById(R.id.air_sp_power_rear).setOnTouchListener(this);
        findViewById(R.id.air_sp_auto_rear).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(35, new int[]{1}, null, null);
        mIsFront = true;
        if (DataCanbus.DATA[1003] == 1) {
            findViewById(R.id.air_sp_mode_change).setBackgroundResource(R.drawable.ic_air_wcyl_mode_rightnull);
            findViewById(R.id.air_sp_rear_mode_change).setBackgroundResource(R.drawable.ic_air_wcyl_rear_mode_rightnull);
        } else {
            findViewById(R.id.air_sp_mode_change).setBackgroundResource(R.drawable.ic_air_wcyl_mode_null);
            findViewById(R.id.air_sp_rear_mode_change).setBackgroundResource(R.drawable.ic_air_wcyl_rear_mode_null);
        }
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
        if (this.pagenum == 1) {
            DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
            findViewById(R.id.veiw_air_front).setVisibility(8);
            findViewById(R.id.veiw_air_frontmode).setVisibility(8);
            findViewById(R.id.veiw_air_rearmode).setVisibility(0);
            findViewById(R.id.veiw_air_rear).setVisibility(0);
            mUpdaterAirWindLevelLeft();
            mUpdateTempRight();
            mUpdateAirTempLeft();
            return;
        }
        DataCanbus.PROXY.cmd(6, new int[1], null, null);
        findViewById(R.id.veiw_air_front).setVisibility(0);
        findViewById(R.id.veiw_air_frontmode).setVisibility(0);
        findViewById(R.id.veiw_air_rearmode).setVisibility(8);
        findViewById(R.id.veiw_air_rear).setVisibility(8);
        mUpdaterAirWindLevelLeft();
        mUpdateTempRight();
        mUpdateAirTempLeft();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        DataCanbus.PROXY.cmd(35, new int[1], null, null);
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
        DataCanbus.PROXY.cmd(6, new int[1], null, null);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 255;
        switch (id) {
            case R.id.tv_sp_front /* 2131427513 */:
                this.pagenum = 0;
                findViewById(R.id.veiw_air_front).setVisibility(0);
                findViewById(R.id.veiw_air_frontmode).setVisibility(0);
                findViewById(R.id.veiw_air_rearmode).setVisibility(8);
                findViewById(R.id.veiw_air_rear).setVisibility(8);
                mUpdaterAirWindLevelLeft();
                mUpdateTempRight();
                mUpdateAirTempLeft();
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(6, new int[1], null, null);
                }
                break;
            case R.id.tv_sp_rear /* 2131427514 */:
                this.pagenum = 1;
                findViewById(R.id.veiw_air_front).setVisibility(8);
                findViewById(R.id.veiw_air_frontmode).setVisibility(8);
                findViewById(R.id.veiw_air_rearmode).setVisibility(0);
                findViewById(R.id.veiw_air_rear).setVisibility(0);
                mUpdaterAirWindLevelLeft();
                mUpdateTempRight();
                mUpdateAirTempLeft();
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                }
                break;
            case R.id.air_sp_temp_left_plus /* 2131427516 */:
                data0 = this.pagenum == 1 ? 39 : 3;
                break;
            case R.id.air_sp_temp_left_munits /* 2131427517 */:
                data0 = this.pagenum == 1 ? 38 : 2;
                break;
            case R.id.air_sp_wind_minuts /* 2131427520 */:
                data0 = this.pagenum == 1 ? 40 : 9;
                break;
            case R.id.air_sp_wind_plus /* 2131427522 */:
                data0 = this.pagenum == 1 ? 41 : 10;
                break;
            case R.id.air_sp_temp_right_plus /* 2131427523 */:
                data0 = this.pagenum == 1 ? 66 : 5;
                break;
            case R.id.air_sp_temp_right_munits /* 2131427524 */:
                data0 = this.pagenum == 1 ? 65 : 4;
                break;
            case R.id.air_sp_seatheat_left /* 2131427525 */:
                data0 = 11;
                break;
            case R.id.air_sp_seatwind_left /* 2131427526 */:
                data0 = 12;
                break;
            case R.id.air_sp_flowerblow /* 2131427527 */:
                data0 = 32;
                break;
            case R.id.air_sp_power /* 2131427528 */:
                data0 = 1;
                break;
            case R.id.air_sp_seatwind_right /* 2131427530 */:
                data0 = 14;
                break;
            case R.id.air_sp_seatheat_right /* 2131427531 */:
                data0 = 13;
                break;
            case R.id.air_sp_dual /* 2131427532 */:
                data0 = 16;
                break;
            case R.id.air_sp_front /* 2131427533 */:
                data0 = 19;
                break;
            case R.id.air_sp_auto /* 2131427534 */:
                data0 = 21;
                break;
            case R.id.air_sp_ac /* 2131427535 */:
                data0 = 23;
                break;
            case R.id.air_sp_rear /* 2131427536 */:
                data0 = 20;
                break;
            case R.id.air_sp_cycle /* 2131427537 */:
                data0 = 25;
                break;
            case R.id.air_sp_rear_blow_changer /* 2131427542 */:
                data0 = 43;
                break;
            case R.id.air_sp_rearlock_rear /* 2131427549 */:
                data0 = 42;
                break;
            case R.id.air_sp_power_rear /* 2131427550 */:
                data0 = 44;
                break;
            case R.id.air_sp_auto_rear /* 2131427551 */:
                data0 = 45;
                break;
            case R.id.air_sp_blow_changer /* 2131428846 */:
                data0 = 8;
                break;
            case R.id.air_sp_fronthot /* 2131428859 */:
                data0 = 72;
                break;
        }
        if (data0 != 255) {
            if (event.getAction() == 0) {
                sendCmd(data0, 1);
            } else if (event.getAction() == 1) {
                sendCmd(data0, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int TempUnit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[27];
        if (this.pagenum == 1) {
            temp = DataCanbus.DATA[40];
        }
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
                        if (temp >= 1 && temp <= 29) {
                            temp = (temp * 10) + 640;
                        } else if (temp >= 33 && temp <= 38) {
                            temp = ((temp - 33) * 10) + 590;
                        }
                        ((TextView) findViewById(R.id.air_sp_tempunit_left)).setText("℉");
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                    } else {
                        if (temp >= 1 && temp <= 29) {
                            temp = (temp * 5) + 175;
                        } else if (temp >= 33 && temp <= 38) {
                            temp = ((temp - 33) * 5) + 150;
                        }
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
        if (this.pagenum == 1) {
            temp = DataCanbus.DATA[40];
        }
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
                        if (temp >= 1 && temp <= 29) {
                            temp = (temp * 10) + 640;
                        } else if (temp >= 33 && temp <= 38) {
                            temp = ((temp - 33) * 10) + 590;
                        }
                        ((TextView) findViewById(R.id.air_sp_tempunit_right)).setText("℉");
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                    } else {
                        if (temp >= 1 && temp <= 29) {
                            temp = (temp * 5) + 175;
                        } else if (temp >= 33 && temp <= 38) {
                            temp = ((temp - 33) * 5) + 150;
                        }
                        ((TextView) findViewById(R.id.air_sp_tempunit_right)).setText("℃");
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackRearLock() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int value = DataCanbus.DATA[21];
        if (this.pagenum == 1) {
            value = DataCanbus.DATA[44];
        }
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

    private void mUpdateHeatLeft() {
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

    private void mUpdateHeatRight() {
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

    private void mUpdateHeatLeftRear() {
        int vel = DataCanbus.DATA[88];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatheat_left_rear).setBackgroundResource(R.drawable.ic_wcyl_toyota_seathot_left_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatheat_left_rear).setBackgroundResource(R.drawable.ic_wcyl_toyota_seathot_left_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatheat_left_rear).setBackgroundResource(R.drawable.ic_wcyl_toyota_seathot_left_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatheat_left_rear).setBackgroundResource(R.drawable.ic_wcyl_toyota_seathot_left_3);
                break;
        }
    }

    private void mUpdateHeatRightRear() {
        int vel = DataCanbus.DATA[89];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatheat_right_rear).setBackgroundResource(R.drawable.ic_wcyl_toyota_seathot_right_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatheat_right_rear).setBackgroundResource(R.drawable.ic_wcyl_toyota_seathot_right_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatheat_right_rear).setBackgroundResource(R.drawable.ic_wcyl_toyota_seathot_right_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatheat_right_rear).setBackgroundResource(R.drawable.ic_wcyl_toyota_seathot_right_3);
                break;
        }
    }

    private void mUpdateWindLeft() {
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

    private void mUpdateWindRight() {
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

    private void mUpdateWindLeftRear() {
        int vel = DataCanbus.DATA[90];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatwind_left_rear).setBackgroundResource(R.drawable.ic_wcyl_toyota_seatblow_left_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatwind_left_rear).setBackgroundResource(R.drawable.ic_wcyl_toyota_seatblow_left_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatwind_left_rear).setBackgroundResource(R.drawable.ic_wcyl_toyota_seatblow_left_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatwind_left_rear).setBackgroundResource(R.drawable.ic_wcyl_toyota_seatblow_left_3);
                break;
        }
    }

    private void mUpdateWindRightRear() {
        int vel = DataCanbus.DATA[91];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatwind_right_rear).setBackgroundResource(R.drawable.ic_wcyl_toyota_seatblow_right_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatwind_right_rear).setBackgroundResource(R.drawable.ic_wcyl_toyota_seatblow_right_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatwind_right_rear).setBackgroundResource(R.drawable.ic_wcyl_toyota_seatblow_right_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatwind_right_rear).setBackgroundResource(R.drawable.ic_wcyl_toyota_seatblow_right_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateDual() {
        int vel = DataCanbus.DATA[14];
        findViewById(R.id.air_sp_dual).setBackgroundResource(vel == 0 ? R.drawable.ic_wcyl_toyota_dual_n : R.drawable.ic_wcyl_toyota_dual_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackAuto() {
        int vel = DataCanbus.DATA[43];
        findViewById(R.id.air_sp_auto_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_wcyl_toyota_pauto_n : R.drawable.ic_wcyl_toyota_pauto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAuto() {
        int vel = DataCanbus.DATA[13];
        findViewById(R.id.air_sp_auto).setBackgroundResource(vel == 0 ? R.drawable.ic_wcyl_toyota_pauto_n : R.drawable.ic_wcyl_toyota_pauto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_sp_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_wcyl_toyota_pac_n : R.drawable.ic_wcyl_toyota_pac_p);
    }

    private void mUpdateFrontOnly() {
        int acOn = DataCanbus.DATA[92];
        findViewById(R.id.air_sp_onlyfront_front).setBackgroundResource(acOn == 0 ? R.drawable.ic_wcyl_toyota_frontonly_n : R.drawable.ic_wcyl_toyota_frontonly_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        int auto = DataCanbus.DATA[54];
        if (auto == 0) {
            if (cycle == 0) {
                findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_wcyl_toyota_cycle_0);
                return;
            } else {
                findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_wcyl_toyota_cycle_1);
                return;
            }
        }
        if (auto == 1) {
            if (cycle == 0) {
                findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_wcyl_toyota_cycle_2);
            } else {
                findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_wcyl_toyota_cycle_3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontHot() {
        int rear = DataCanbus.DATA[17];
        findViewById(R.id.air_sp_fronthot).setBackgroundResource(rear == 0 ? R.drawable.ic_wcyl_toyota_fronthot_n : R.drawable.ic_wcyl_toyota_fronthot_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFlowerBlow() {
        int rear = DataCanbus.DATA[33];
        findViewById(R.id.air_sp_flowerblow).setBackgroundResource(rear == 0 ? R.drawable.ic_wcyl_page_flowerblow_n : R.drawable.ic_wcyl_page_flowerblow_p);
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
    public void mUpdateRearPower() {
        int value = DataCanbus.DATA[42];
        findViewById(R.id.air_sp_power_rear).setBackgroundResource(value == 0 ? R.drawable.ic_wcyl_toyota_power_n : R.drawable.ic_wcyl_toyota_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePower() {
        int value = DataCanbus.DATA[10];
        findViewById(R.id.air_sp_power).setBackgroundResource(value == 0 ? R.drawable.ic_wcyl_toyota_power_n : R.drawable.ic_wcyl_toyota_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowBackMode() {
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
        findViewById(R.id.air_sp_mode_up).setVisibility(win == 0 ? 8 : 0);
        findViewById(R.id.air_sp_mode_body).setVisibility(body == 0 ? 8 : 0);
        findViewById(R.id.air_sp_mode_foot).setVisibility(foot != 0 ? 0 : 8);
        switch (mode3) {
            case 1:
                findViewById(R.id.air_sp_blow_changer).setBackgroundResource(R.drawable.ic_wcyl_toyota_mode1_p);
                break;
            case 2:
                findViewById(R.id.air_sp_blow_changer).setBackgroundResource(R.drawable.ic_wcyl_toyota_mode2_p);
                break;
            case 3:
                findViewById(R.id.air_sp_blow_changer).setBackgroundResource(R.drawable.ic_wcyl_toyota_mode3_p);
                break;
            case 4:
            default:
                findViewById(R.id.air_sp_blow_changer).setBackgroundResource(R.drawable.ic_wcyl_toyota_mode0_n);
                break;
            case 5:
                findViewById(R.id.air_sp_blow_changer).setBackgroundResource(R.drawable.ic_wcyl_toyota_mode5_p);
                break;
        }
    }
}
