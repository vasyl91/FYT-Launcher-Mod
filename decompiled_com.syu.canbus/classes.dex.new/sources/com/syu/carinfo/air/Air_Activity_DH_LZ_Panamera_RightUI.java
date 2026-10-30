package com.syu.carinfo.air;

import android.app.Activity;
import android.content.Intent;
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
public class Air_Activity_DH_LZ_Panamera_RightUI extends Activity implements View.OnTouchListener {
    public static Air_Activity_DH_LZ_Panamera_RightUI mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.air.Air_Activity_DH_LZ_Panamera_RightUI.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 53) {
                Air_Activity_DH_LZ_Panamera_RightUI.this.mUpdateAcMaxOn();
            }
            if (updateCode == 62) {
                Air_Activity_DH_LZ_Panamera_RightUI.this.mUpdateSYNC();
            }
            if (updateCode == 10) {
                Air_Activity_DH_LZ_Panamera_RightUI.this.mUpdatePower();
            }
            if (updateCode == 27) {
                Air_Activity_DH_LZ_Panamera_RightUI.this.mUpdateAirTempLeft();
            }
            if (updateCode == 28) {
                Air_Activity_DH_LZ_Panamera_RightUI.this.mUpdateAirTempRight();
            }
            if (updateCode == 25) {
                Air_Activity_DH_LZ_Panamera_RightUI.this.mUpdaterAirWindLevelLeft();
            }
            if (updateCode == 50) {
                Air_Activity_DH_LZ_Panamera_RightUI.this.mUpdateAuto();
            }
            if (updateCode == 29) {
                Air_Activity_DH_LZ_Panamera_RightUI.this.mUpdateHeatLeft();
            }
            if (updateCode == 30) {
                Air_Activity_DH_LZ_Panamera_RightUI.this.mUpdateHeatRight();
            }
            if (updateCode == 31) {
                Air_Activity_DH_LZ_Panamera_RightUI.this.mUpdateWindLeft();
            }
            if (updateCode == 32) {
                Air_Activity_DH_LZ_Panamera_RightUI.this.mUpdateWindRight();
            }
            if (updateCode != 23 && updateCode != 24) {
                return;
            }
            Air_Activity_DH_LZ_Panamera_RightUI.this.updateBlowModeLeft();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.layout_0455_air_dh_lz_panamera_rightui);
        init();
        mInstance = this;
    }

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
    }

    private void init() {
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_minuts).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_bodyfoot).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_body).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_foot).setOnTouchListener(this);
        findViewById(R.id.air_sp_acmax).setOnTouchListener(this);
        findViewById(R.id.air_sp_sync).setOnTouchListener(this);
        findViewById(R.id.air_sp_power).setOnTouchListener(this);
        findViewById(R.id.air_sp_auto).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatwind_left).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatheat_left).setOnTouchListener(this);
        findViewById(R.id.tv_text1).setOnTouchListener(this);
        findViewById(R.id.air_sp_park).setOnTouchListener(this);
        findViewById(R.id.tv_text2).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatheat_right).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatwind_right).setOnTouchListener(this);
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
            case R.id.tv_text1 /* 2131427457 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) Air_Activity_DH_LZ_Panamera_UI.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                finish();
                break;
            case R.id.air_sp_wind_minuts /* 2131427520 */:
                data0 = 29;
                break;
            case R.id.air_sp_wind_plus /* 2131427522 */:
                data0 = 28;
                break;
            case R.id.air_sp_temp_right_plus /* 2131427523 */:
                data0 = 30;
                break;
            case R.id.air_sp_temp_right_munits /* 2131427524 */:
                data0 = 31;
                break;
            case R.id.air_sp_seatheat_left /* 2131427525 */:
                data0 = 24;
                break;
            case R.id.air_sp_seatwind_left /* 2131427526 */:
                data0 = 25;
                break;
            case R.id.air_sp_seatwind_right /* 2131427530 */:
                data0 = 27;
                break;
            case R.id.air_sp_seatheat_right /* 2131427531 */:
                data0 = 26;
                break;
            case R.id.air_sp_auto /* 2131427534 */:
                data0 = 19;
                break;
            case R.id.air_sp_blow_foot /* 2131428083 */:
                data0 = 21;
                break;
            case R.id.air_sp_blow_body /* 2131428084 */:
                data0 = 20;
                break;
            case R.id.air_sp_acmax /* 2131428086 */:
                data0 = 8;
                break;
            case R.id.air_sp_sync /* 2131428088 */:
                data0 = 9;
                break;
            case R.id.air_sp_blow_bodyfoot /* 2131428842 */:
                data0 = 22;
                break;
            case R.id.air_sp_park /* 2131428843 */:
                data0 = 2;
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
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_text1)).setText("HI");
                    break;
                case -2:
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText("LO");
                    break;
                case -1:
                default:
                    if (TempUnit == 1) {
                        temp = ((temp * 9) / 5) + 320;
                    }
                    ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(temp * 0.1f).toString());
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempRight() {
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_text2)).setText("HI");
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                case -2:
                case 0:
                    ((TextView) findViewById(R.id.tv_text2)).setText("LO");
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LO");
                    break;
                case -1:
                default:
                    if (TempUnit == 1) {
                        temp = ((temp * 9) / 5) + 320;
                    }
                    ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(temp * 0.1f).toString());
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText(new StringBuilder().append(temp * 0.1f).toString());
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int value = DataCanbus.DATA[25];
        switch (value) {
            case 0:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_dh_panamera_wind_0);
                break;
            case 1:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_dh_panamera_wind_1);
                break;
            case 2:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_dh_panamera_wind_2);
                break;
            case 3:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_dh_panamera_wind_3);
                break;
            case 4:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_dh_panamera_wind_4);
                break;
            case 5:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_dh_panamera_wind_5);
                break;
            case 6:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_dh_panamera_wind_6);
                break;
            case 7:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_dh_panamera_wind_7);
                break;
            case 8:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_dh_panamera_wind_8);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateHeatLeft() {
        int vel = DataCanbus.DATA[29];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_air_dh_panamera_seatheat_left_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_air_dh_panamera_seatheat_left_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_air_dh_panamera_seatheat_left_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_air_dh_panamera_seatheat_left_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateHeatRight() {
        int vel = DataCanbus.DATA[30];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_air_dh_panamera_seatheat_right_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_air_dh_panamera_seatheat_right_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_air_dh_panamera_seatheat_right_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_air_dh_panamera_seatheat_right_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateWindLeft() {
        int vel = DataCanbus.DATA[31];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_air_dh_panamera_seatblow_left_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_air_dh_panamera_seatblow_left_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_air_dh_panamera_seatblow_left_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_air_dh_panamera_seatblow_left_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateWindRight() {
        int vel = DataCanbus.DATA[32];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_air_dh_panamera_seatblow_right_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_air_dh_panamera_seatblow_right_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_air_dh_panamera_seatblow_right_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_air_dh_panamera_seatblow_right_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSYNC() {
        int vel = DataCanbus.DATA[62];
        findViewById(R.id.air_sp_sync).setBackgroundResource(vel == 0 ? R.drawable.ic_air_dh_panamera_sync_n : R.drawable.ic_air_dh_panamera_sync_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAuto() {
        int vel = DataCanbus.DATA[50];
        findViewById(R.id.air_sp_auto).setBackgroundResource(vel == 0 ? R.drawable.ic_air_dh_panamera_auto_n : R.drawable.ic_air_dh_panamera_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcMaxOn() {
        int acOn = DataCanbus.DATA[53];
        findViewById(R.id.air_sp_acmax).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_dh_panamera_acmax_n : R.drawable.ic_air_dh_panamera_acmax_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePower() {
        int value = DataCanbus.DATA[10];
        findViewById(R.id.air_sp_power).setBackgroundResource(value == 0 ? R.drawable.ic_air_dh_panamera_power_n : R.drawable.ic_air_dh_panamera_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowModeLeft() {
        int mode;
        int body = DataCanbus.DATA[23];
        int foot = DataCanbus.DATA[24];
        if (body == 1) {
            mode = 0 | 2;
        } else {
            mode = 0 & 253;
        }
        if (foot == 1) {
            int i = mode | 1;
        } else {
            int i2 = mode & 254;
        }
        findViewById(R.id.air_sp_mode_body).setVisibility(body == 0 ? 8 : 0);
        findViewById(R.id.air_sp_mode_foot).setVisibility(foot != 0 ? 0 : 8);
        findViewById(R.id.air_sp_blow_body).setBackgroundResource(R.drawable.ic_air_dh_panamera_modebody_right_n);
        findViewById(R.id.air_sp_blow_foot).setBackgroundResource(R.drawable.ic_air_dh_panamera_modefoot_right_n);
        findViewById(R.id.air_sp_blow_bodyfoot).setBackgroundResource(R.drawable.ic_air_dh_panamera_modebodyfoot_right_n);
        if (body == 0 && foot == 1) {
            findViewById(R.id.air_sp_blow_foot).setBackgroundResource(R.drawable.ic_air_dh_panamera_modefoot_right_p);
            return;
        }
        if (body == 1 && foot == 0) {
            findViewById(R.id.air_sp_blow_body).setBackgroundResource(R.drawable.ic_air_dh_panamera_modebody_right_p);
        } else if (body == 1 && foot == 1) {
            findViewById(R.id.air_sp_blow_bodyfoot).setBackgroundResource(R.drawable.ic_air_dh_panamera_modebodyfoot_right_p);
        }
    }
}
