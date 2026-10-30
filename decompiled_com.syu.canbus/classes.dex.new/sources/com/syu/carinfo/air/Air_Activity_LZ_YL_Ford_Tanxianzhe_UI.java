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
public class Air_Activity_LZ_YL_Ford_Tanxianzhe_UI extends Activity implements View.OnTouchListener {
    public static Air_Activity_LZ_YL_Ford_Tanxianzhe_UI mInstance;
    public static boolean mIsFront = false;
    int pagenum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.air.Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 155) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdateABSOn();
            }
            if (updateCode == 11) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdateAcOn();
            }
            if (updateCode == 53) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdateAcMaxOn();
            }
            if (updateCode == 12) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdateCycle();
            }
            if (updateCode == 13) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdateAuto();
            }
            if (updateCode == 14) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdateSync();
            }
            if (updateCode == 16) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdateRearDefrost();
            }
            if (updateCode == 65) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdateFrontDefrost();
            }
            if (updateCode == 15) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdateMaxFront();
            }
            if (updateCode == 66) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdateHotSteer();
            }
            if (updateCode == 10) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdatePower();
            }
            if (updateCode == 21) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdaterAirWindLevelLeft();
            }
            if (updateCode == 27) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdateAirTempLeft();
            }
            if (updateCode == 28) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdateTempRight();
            }
            if (updateCode == 42) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdateRearPower();
            }
            if (updateCode == 40) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdateRearTemp();
            }
            if (updateCode == 44) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdaterAirWindLevelRear();
            }
            if (updateCode == 29) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdateHeatLeft();
            }
            if (updateCode == 31) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdateBlowLeft();
            }
            if (updateCode == 30) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdateHeatRight();
            }
            if (updateCode == 32) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdateBlowRight();
            }
            if (updateCode == 67) {
                Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.mUpdateRearLock();
            }
            if (updateCode != 18 && updateCode != 19 && updateCode != 20) {
                return;
            }
            Air_Activity_LZ_YL_Ford_Tanxianzhe_UI.this.updateBlowModeLeft();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0454_air_lz_yl_frod_ui);
        init();
        mInstance = this;
    }

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(1, new int[]{data0, data1}, null, null);
    }

    private void init() {
        findViewById(R.id.tv_sp_rear).setOnTouchListener(this);
        findViewById(R.id.tv_sp_front).setOnTouchListener(this);
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
        findViewById(R.id.air_sp_acmax).setOnTouchListener(this);
        findViewById(R.id.air_sp_steer).setOnTouchListener(this);
        findViewById(R.id.air_sp_dual).setOnTouchListener(this);
        findViewById(R.id.air_sp_front).setOnTouchListener(this);
        findViewById(R.id.air_sp_auto).setOnTouchListener(this);
        findViewById(R.id.air_sp_ac).setOnTouchListener(this);
        findViewById(R.id.air_sp_rear).setOnTouchListener(this);
        findViewById(R.id.air_sp_cycle).setOnTouchListener(this);
        findViewById(R.id.air_sp_frontmax).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_rearleft_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_tempunit_rearleft).setOnTouchListener(this);
        findViewById(R.id.air_sp_rear_wind_minuts).setOnTouchListener(this);
        findViewById(R.id.air_sp_rear_wind_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_rearright_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_rearright_minus).setOnTouchListener(this);
        findViewById(R.id.air_sp_rearlock_rear).setOnTouchListener(this);
        findViewById(R.id.air_sp_power_rear).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
        if (this.pagenum == 1) {
            findViewById(R.id.veiw_air_front).setVisibility(8);
            findViewById(R.id.veiw_air_rear).setVisibility(0);
            findViewById(R.id.tv_sp_front).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_n);
            findViewById(R.id.tv_sp_rear).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_p);
            return;
        }
        findViewById(R.id.veiw_air_front).setVisibility(0);
        findViewById(R.id.veiw_air_rear).setVisibility(8);
        findViewById(R.id.tv_sp_front).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_p);
        findViewById(R.id.tv_sp_rear).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_n);
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
            case R.id.tv_sp_front /* 2131427513 */:
                this.pagenum = 0;
                findViewById(R.id.veiw_air_front).setVisibility(0);
                findViewById(R.id.veiw_air_rear).setVisibility(8);
                findViewById(R.id.tv_sp_front).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_p);
                findViewById(R.id.tv_sp_rear).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_n);
                break;
            case R.id.tv_sp_rear /* 2131427514 */:
                this.pagenum = 1;
                findViewById(R.id.veiw_air_front).setVisibility(8);
                findViewById(R.id.veiw_air_rear).setVisibility(0);
                findViewById(R.id.tv_sp_front).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_n);
                findViewById(R.id.tv_sp_rear).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_p);
                break;
            case R.id.air_sp_temp_left_plus /* 2131427516 */:
                data0 = 26;
                break;
            case R.id.air_sp_temp_left_munits /* 2131427517 */:
                data0 = 27;
                break;
            case R.id.air_sp_wind_minuts /* 2131427520 */:
                data0 = 31;
                break;
            case R.id.air_sp_wind_plus /* 2131427522 */:
                data0 = 30;
                break;
            case R.id.air_sp_temp_right_plus /* 2131427523 */:
                data0 = 28;
                break;
            case R.id.air_sp_temp_right_munits /* 2131427524 */:
                data0 = 29;
                break;
            case R.id.air_sp_seatheat_left /* 2131427525 */:
                data0 = 35;
                break;
            case R.id.air_sp_seatwind_left /* 2131427526 */:
                data0 = 37;
                break;
            case R.id.air_sp_power /* 2131427528 */:
                data0 = 1;
                break;
            case R.id.air_sp_seatwind_right /* 2131427530 */:
                data0 = 38;
                break;
            case R.id.air_sp_seatheat_right /* 2131427531 */:
                data0 = 36;
                break;
            case R.id.air_sp_dual /* 2131427532 */:
                data0 = 24;
                break;
            case R.id.air_sp_front /* 2131427533 */:
                data0 = 42;
                break;
            case R.id.air_sp_auto /* 2131427534 */:
                data0 = 23;
                break;
            case R.id.air_sp_ac /* 2131427535 */:
                data0 = 2;
                break;
            case R.id.air_sp_rear /* 2131427536 */:
                data0 = 40;
                break;
            case R.id.air_sp_cycle /* 2131427537 */:
                data0 = 3;
                break;
            case R.id.air_sp_temp_rearleft_plus /* 2131427539 */:
                data0 = 20;
                break;
            case R.id.air_sp_tempunit_rearleft /* 2131427541 */:
                data0 = 19;
                break;
            case R.id.air_sp_rear_wind_minuts /* 2131427543 */:
                data0 = 21;
                break;
            case R.id.air_sp_rear_wind_plus /* 2131427545 */:
                data0 = 22;
                break;
            case R.id.air_sp_temp_rearright_plus /* 2131427546 */:
                data0 = 20;
                break;
            case R.id.air_sp_temp_rearright_minus /* 2131427548 */:
                data0 = 19;
                break;
            case R.id.air_sp_rearlock_rear /* 2131427549 */:
                data0 = 18;
                break;
            case R.id.air_sp_power_rear /* 2131427550 */:
                data0 = 17;
                break;
            case R.id.air_sp_blow_foot /* 2131428083 */:
                data0 = 34;
                break;
            case R.id.air_sp_blow_body /* 2131428084 */:
                data0 = 33;
                break;
            case R.id.air_sp_acmax /* 2131428086 */:
                data0 = 4;
                break;
            case R.id.air_sp_steer /* 2131428087 */:
                data0 = 41;
                break;
            case R.id.air_sp_blow_win /* 2131428717 */:
                data0 = 32;
                break;
            case R.id.air_sp_frontmax /* 2131428803 */:
                data0 = 25;
                break;
        }
        if (data0 != 255) {
            if (event.getAction() == 0) {
                sendCmd(172, data0);
            } else if (event.getAction() == 1) {
                sendCmd(172, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[27];
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
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(new StringBuilder(String.valueOf(((temp * 9) + 320) / 10)).toString());
                    } else {
                        int temp2 = temp * 5;
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10));
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTempRight() {
        int temp = DataCanbus.DATA[28];
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
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(new StringBuilder(String.valueOf(((temp * 9) + 320) / 10)).toString());
                    } else {
                        int temp2 = temp * 5;
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10));
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearTemp() {
        int temp = DataCanbus.DATA[40];
        if (((TextView) findViewById(R.id.air_sp_tempvalue_rearleft)) != null) {
            ((TextView) findViewById(R.id.air_sp_tempvalue_rearleft)).setText(new StringBuilder(String.valueOf(temp)).toString());
            ((TextView) findViewById(R.id.air_sp_tempvalue_rearright)).setText(new StringBuilder(String.valueOf(temp)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int value = DataCanbus.DATA[21];
        switch (value) {
            case 0:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_0);
                break;
            case 1:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_1);
                break;
            case 2:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_2);
                break;
            case 3:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_3);
                break;
            case 4:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_4);
                break;
            case 5:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_5);
                break;
            case 6:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_6);
                break;
            case 7:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_7);
                break;
            case 8:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_8);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelRear() {
        int value = DataCanbus.DATA[44];
        switch (value) {
            case 0:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_0);
                break;
            case 1:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_1);
                break;
            case 2:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_2);
                break;
            case 3:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_3);
                break;
            case 4:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_4);
                break;
            case 5:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_5);
                break;
            case 6:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_6);
                break;
            case 7:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_7);
                break;
            case 8:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_8);
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
        switch (vel) {
            case 1:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_3);
                break;
            default:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_0);
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
        findViewById(R.id.air_sp_dual).setBackgroundResource(vel == 0 ? R.drawable.ic_lzyl_gmscreen_dual_n : R.drawable.ic_lzyl_gmscreen_dual_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAuto() {
        int vel = DataCanbus.DATA[13];
        findViewById(R.id.air_sp_auto).setBackgroundResource(vel == 0 ? R.drawable.ic_lzyl_gmscreen_auto_n : R.drawable.ic_lzyl_gmscreen_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearLock() {
        int acOn = DataCanbus.DATA[67];
        findViewById(R.id.air_sp_rearlock_rear).setBackgroundResource(acOn == 0 ? R.drawable.ic_lzyl_gmscreen_lock_n : R.drawable.ic_lzyl_gmscreen_lock_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_sp_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_lzyl_gmscreen_ac_n : R.drawable.ic_lzyl_gmscreen_ac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateABSOn() {
        int acOn = DataCanbus.DATA[155];
        if (findViewById(R.id.btn_plus1) != null) {
            findViewById(R.id.btn_plus1).setBackgroundResource(acOn == 0 ? R.drawable.ic_ford_abs_off : R.drawable.ic_ford_abs_on);
        }
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
    public void mUpdateMaxFront() {
        int rear = DataCanbus.DATA[15];
        findViewById(R.id.air_sp_frontmax).setBackgroundResource(rear == 0 ? R.drawable.ic_lzyl_gmscreen_maxfront_n : R.drawable.ic_lzyl_gmscreen_maxfront_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateHotSteer() {
        int rear = DataCanbus.DATA[66];
        findViewById(R.id.air_sp_steer).setBackgroundResource(rear == 0 ? R.drawable.ic_lzyl_gmscreen_steer_n : R.drawable.ic_lzyl_gmscreen_steer_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearPower() {
        int value = DataCanbus.DATA[42];
        findViewById(R.id.air_sp_power_rear).setBackgroundResource(value == 0 ? R.drawable.ic_lzyl_gmscreen_power_n : R.drawable.ic_lzyl_gmscreen_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePower() {
        int value = DataCanbus.DATA[10];
        findViewById(R.id.air_sp_power).setBackgroundResource(value == 0 ? R.drawable.ic_lzyl_gmscreen_power_n : R.drawable.ic_lzyl_gmscreen_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowModeLeft() {
        int win = DataCanbus.DATA[18];
        int body = DataCanbus.DATA[19];
        int foot = DataCanbus.DATA[20];
        if (findViewById(R.id.air_sp_mode_up) != null) {
            findViewById(R.id.air_sp_mode_up).setVisibility(win == 1 ? 0 : 8);
        }
        if (findViewById(R.id.air_sp_mode_body) != null) {
            findViewById(R.id.air_sp_mode_body).setVisibility(body == 1 ? 0 : 8);
        }
        if (findViewById(R.id.air_sp_mode_foot) != null) {
            findViewById(R.id.air_sp_mode_foot).setVisibility(foot != 1 ? 8 : 0);
        }
        findViewById(R.id.air_sp_blow_foot).setBackgroundResource(foot == 0 ? R.drawable.ic_lzyl_gmscreen_mode_foot_n : R.drawable.ic_lzyl_gmscreen_mode_foot_p);
        findViewById(R.id.air_sp_blow_body).setBackgroundResource(body == 0 ? R.drawable.ic_lzyl_gmscreen_mode_body_n : R.drawable.ic_lzyl_gmscreen_mode_body_p);
        findViewById(R.id.air_sp_blow_win).setBackgroundResource(win == 0 ? R.drawable.ic_lzyl_gmscreen_mode_win_n : R.drawable.ic_lzyl_gmscreen_mode_win_p);
    }
}
