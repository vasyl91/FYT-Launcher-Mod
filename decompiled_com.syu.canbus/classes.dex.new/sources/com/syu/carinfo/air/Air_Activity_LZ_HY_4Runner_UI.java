package com.syu.carinfo.air;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_Activity_LZ_HY_4Runner_UI extends Activity implements View.OnTouchListener {
    public static Air_Activity_LZ_HY_4Runner_UI mInstance;
    public static boolean mIsFront = false;
    int pagenum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.air.Air_Activity_LZ_HY_4Runner_UI.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 11) {
                Air_Activity_LZ_HY_4Runner_UI.this.mUpdateAcOn();
            }
            if (updateCode == 12) {
                Air_Activity_LZ_HY_4Runner_UI.this.mUpdateCycle();
            }
            if (updateCode == 13) {
                Air_Activity_LZ_HY_4Runner_UI.this.mUpdateAuto();
            }
            if (updateCode == 14) {
                Air_Activity_LZ_HY_4Runner_UI.this.mUpdateDual();
            }
            if (updateCode == 16) {
                Air_Activity_LZ_HY_4Runner_UI.this.mUpdateRearDefrost();
            }
            if (updateCode == 15) {
                Air_Activity_LZ_HY_4Runner_UI.this.mUpdateFrontDefrost();
            }
            if (updateCode == 10) {
                Air_Activity_LZ_HY_4Runner_UI.this.mUpdatePower();
            }
            if (updateCode == 21) {
                Air_Activity_LZ_HY_4Runner_UI.this.mUpdaterAirWindLevelLeft();
            }
            if (updateCode == 27) {
                Air_Activity_LZ_HY_4Runner_UI.this.mUpdateAirTempLeft();
            }
            if (updateCode == 28) {
                Air_Activity_LZ_HY_4Runner_UI.this.mUpdateTempRight();
            }
            if (updateCode == 29) {
                Air_Activity_LZ_HY_4Runner_UI.this.mUpdateHeatLeft();
            }
            if (updateCode == 30) {
                Air_Activity_LZ_HY_4Runner_UI.this.mUpdateHeatRight();
            }
            if (updateCode == 31) {
                Air_Activity_LZ_HY_4Runner_UI.this.mUpdateBlowLeft();
            }
            if (updateCode == 32) {
                Air_Activity_LZ_HY_4Runner_UI.this.mUpdateBlowRight();
            }
            if (updateCode == 37) {
                Air_Activity_LZ_HY_4Runner_UI.this.mUpdateAirTempLeft();
                Air_Activity_LZ_HY_4Runner_UI.this.mUpdateTempRight();
            }
            if (updateCode != 18 && updateCode != 19 && updateCode != 20) {
                return;
            }
            Air_Activity_LZ_HY_4Runner_UI.this.updateBlowModeLeft();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_air_lz_hy_4runner_ui);
        init();
        mInstance = this;
    }

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(22, new int[]{data0, data1}, null, null);
    }

    private void init() {
        findViewById(R.id.air_sp_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_mode_plus).setOnTouchListener(this);
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
                data0 = 3;
                break;
            case R.id.air_sp_temp_left_munits /* 2131427517 */:
                data0 = 2;
                break;
            case R.id.air_sp_blow_mode_plus /* 2131427519 */:
                data0 = 36;
                break;
            case R.id.air_sp_wind_minuts /* 2131427520 */:
                data0 = 9;
                break;
            case R.id.air_sp_wind_plus /* 2131427522 */:
                data0 = 10;
                break;
            case R.id.air_sp_temp_right_plus /* 2131427523 */:
                data0 = 5;
                break;
            case R.id.air_sp_temp_right_munits /* 2131427524 */:
                data0 = 4;
                break;
            case R.id.air_sp_power /* 2131427528 */:
                data0 = 1;
                break;
            case R.id.air_sp_dual /* 2131427532 */:
                data0 = 16;
                break;
            case R.id.air_sp_front /* 2131427533 */:
                data0 = 18;
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
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
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
                default:
                    if (unit == 1) {
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
                default:
                    if (unit == 1) {
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
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_3);
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
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_3);
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
    public void mUpdateDual() {
        int vel = DataCanbus.DATA[14];
        findViewById(R.id.air_sp_dual).setBackgroundResource(vel == 0 ? R.drawable.ic_lzyl_gmscreen_dual_n : R.drawable.ic_lzyl_gmscreen_dual_p);
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
        int rear = DataCanbus.DATA[15];
        findViewById(R.id.air_sp_front).setBackgroundResource(rear == 0 ? R.drawable.ic_lzyl_gmscreen_front_n : R.drawable.ic_lzyl_gmscreen_front_p);
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
        findViewById(R.id.air_sp_mode_up).setVisibility(win == 1 ? 0 : 8);
        findViewById(R.id.air_sp_mode_body).setVisibility(body == 1 ? 0 : 8);
        findViewById(R.id.air_sp_mode_foot).setVisibility(foot != 1 ? 8 : 0);
    }
}
