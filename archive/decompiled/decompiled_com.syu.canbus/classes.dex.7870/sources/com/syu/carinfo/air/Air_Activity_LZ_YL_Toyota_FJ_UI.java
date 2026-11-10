package com.syu.carinfo.air;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemProperties;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;
import com.syu.util.HandlerUI;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Air_Activity_LZ_YL_Toyota_FJ_UI extends Activity implements View.OnTouchListener {
    public static Air_Activity_LZ_YL_Toyota_FJ_UI mInstance;
    public static boolean mIsFront = false;
    Runnable mShowWindowcnt = new Runnable() { // from class: com.syu.carinfo.air.Air_Activity_LZ_YL_Toyota_FJ_UI.1
        @Override // java.lang.Runnable
        public void run() {
            Log.v("zed", "ConstAllAirDara.JumpNewAircnt = " + ConstAllAirDara.JumpNewAircnt);
            ConstAllAirDara.JumpNewAircnt--;
            if (ConstAllAirDara.JumpNewAircnt == 0) {
                Air_Activity_LZ_YL_Toyota_FJ_UI.this.finish();
                HandlerUI.getInstance().removeCallbacks(Air_Activity_LZ_YL_Toyota_FJ_UI.this.mShowWindowcnt);
            } else {
                HandlerUI.getInstance().removeCallbacks(Air_Activity_LZ_YL_Toyota_FJ_UI.this.mShowWindowcnt);
                HandlerUI.getInstance().postDelayed(Air_Activity_LZ_YL_Toyota_FJ_UI.this.mShowWindowcnt, 1000L);
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.air.Air_Activity_LZ_YL_Toyota_FJ_UI.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (ConstAllAirDara.JumpNewAir) {
                ConstAllAirDara.JumpNewAircnt = 8;
            }
            if (updateCode == 11) {
                Air_Activity_LZ_YL_Toyota_FJ_UI.this.mUpdateAcOn();
            }
            if (updateCode == 12) {
                Air_Activity_LZ_YL_Toyota_FJ_UI.this.mUpdateCycle();
            }
            if (updateCode == 16) {
                Air_Activity_LZ_YL_Toyota_FJ_UI.this.mUpdateRearDefrost();
            }
            if (updateCode == 15) {
                Air_Activity_LZ_YL_Toyota_FJ_UI.this.mUpdateFrontDefrost();
            }
            if (updateCode == 10) {
                Air_Activity_LZ_YL_Toyota_FJ_UI.this.mUpdatePower();
            }
            if (updateCode == 27 || updateCode == 28) {
                Air_Activity_LZ_YL_Toyota_FJ_UI.this.mUpdateAirTempLeft();
                Air_Activity_LZ_YL_Toyota_FJ_UI.this.mUpdateTempRight();
            }
            if (updateCode == 21) {
                Air_Activity_LZ_YL_Toyota_FJ_UI.this.mUpdaterAirWindLevelLeft();
            }
            if (updateCode != 18 && updateCode != 19 && updateCode != 20 && updateCode != 15) {
                return;
            }
            Air_Activity_LZ_YL_Toyota_FJ_UI.this.updateBlowModeLeft();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0456_air_lz_yl_toyota_fj_ui);
        init();
        mInstance = this;
    }

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
    }

    private void init() {
        findViewById(R.id.air_sp_wind_minuts).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_cycle).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_changer).setOnTouchListener(this);
        findViewById(R.id.air_sp_power).setOnTouchListener(this);
        findViewById(R.id.air_sp_ac).setOnTouchListener(this);
        findViewById(R.id.air_sp_front).setOnTouchListener(this);
        findViewById(R.id.air_sp_rear).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(30, new int[]{1}, null, null);
        mIsFront = true;
        if (DataCanbus.DATA[1003] == 1) {
            findViewById(R.id.air_sp_mode_change).setBackgroundResource(R.drawable.ic_air_lzyl_fjmode_rightnull);
        } else {
            findViewById(R.id.air_sp_mode_change).setBackgroundResource(R.drawable.ic_air_lzyl_fjmode_null);
        }
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
        if (ConstAllAirDara.JumpNewAir) {
            mUpdaterWindowShow(true);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        DataCanbus.PROXY.cmd(30, new int[1], null, null);
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
        ConstAllAirDara.JumpNewAir = false;
    }

    private void mUpdaterWindowShow(boolean flag) {
        if (flag) {
            HandlerUI.getInstance().removeCallbacks(this.mShowWindowcnt);
            HandlerUI.getInstance().postDelayed(this.mShowWindowcnt, 1000L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowWindowcnt);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 255;
        switch (id) {
            case R.id.air_sp_temp_left_plus /* 2131427510 */:
                data0 = 3;
                break;
            case R.id.air_sp_temp_left_munits /* 2131427511 */:
                data0 = 2;
                break;
            case R.id.air_sp_wind_minuts /* 2131427514 */:
                data0 = 9;
                break;
            case R.id.air_sp_wind_plus /* 2131427516 */:
                data0 = 10;
                break;
            case R.id.air_sp_temp_right_plus /* 2131427517 */:
                data0 = 5;
                break;
            case R.id.air_sp_temp_right_munits /* 2131427518 */:
                data0 = 4;
                break;
            case R.id.air_sp_power /* 2131427522 */:
                data0 = 1;
                break;
            case R.id.air_sp_front /* 2131427527 */:
                data0 = 18;
                break;
            case R.id.air_sp_ac /* 2131427529 */:
                data0 = 23;
                break;
            case R.id.air_sp_rear /* 2131427530 */:
                data0 = 20;
                break;
            case R.id.air_sp_cycle /* 2131427531 */:
                data0 = 25;
                break;
            case R.id.air_sp_blow_changer /* 2131428693 */:
                data0 = 36;
                break;
        }
        if (event.getAction() == 0) {
            if (ConstAllAirDara.JumpNewAir) {
                ConstAllAirDara.JumpNewAircnt = 8;
            }
            sendCmd(data0, 1);
        } else if (event.getAction() == 1) {
            if (ConstAllAirDara.JumpNewAir) {
                ConstAllAirDara.JumpNewAircnt = 8;
            }
            sendCmd(data0, 0);
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
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
                default:
                    if (TempUnit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(new StringBuilder().append(temp / 10).toString());
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(new StringBuilder().append(temp * 0.1f).toString());
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTempRight() {
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
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
                default:
                    if (TempUnit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(new StringBuilder().append(temp / 10).toString());
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(new StringBuilder().append(temp * 0.1f).toString());
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
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_wcyl_toyota_wind4_0);
                break;
            case 1:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_wcyl_toyota_wind4_1);
                break;
            case 2:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_wcyl_toyota_wind4_2);
                break;
            case 3:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_wcyl_toyota_wind4_3);
                break;
            case 4:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_wcyl_toyota_wind4_4);
                break;
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
        findViewById(R.id.air_sp_cycle).setBackgroundResource(cycle == 0 ? R.drawable.ic_wcyl_toyota_cycle_n : R.drawable.ic_wcyl_toyota_cycle_p);
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
        int mode3;
        int win = DataCanbus.DATA[18];
        int body = DataCanbus.DATA[19];
        int foot = DataCanbus.DATA[20];
        int maxfront = DataCanbus.DATA[15];
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
        if (maxfront == 1 || win == 1) {
            findViewById(R.id.air_sp_mode_up).setVisibility(0);
        }
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
