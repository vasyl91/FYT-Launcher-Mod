package com.syu.carinfo.bg.ziyouguang;

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
public class Bg_ZiYouGuangAirControlAct extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private View.OnTouchListener touchSeat = new View.OnTouchListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouGuangAirControlAct.1
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            switch (v.getId()) {
                case R.id.air_xts_seathot_left /* 2131427433 */:
                    if (event.getAction() == 0) {
                        DataCanbus.PROXY.cmd(0, new int[]{48, 1}, null, null);
                    } else if (event.getAction() == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{48, 0}, null, null);
                    }
                    return false;
                case R.id.air_xts_mode /* 2131427434 */:
                default:
                    return false;
                case R.id.air_xts_seathot_right /* 2131427435 */:
                    if (event.getAction() == 0) {
                        DataCanbus.PROXY.cmd(0, new int[]{50, 1}, null, null);
                    } else if (event.getAction() == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{50, 0}, null, null);
                    }
                    return false;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouGuangAirControlAct.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirPower();
                    break;
                case 11:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirAC();
                    break;
                case 12:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirCycle();
                    break;
                case 13:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirAuto();
                    break;
                case 16:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirRearDefrost();
                    break;
                case 18:
                case 19:
                case 20:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirBlowMode();
                    break;
                case 21:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 27:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 28:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirTempRight();
                    break;
                case 29:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirSeatHeatLeft();
                    break;
                case 30:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirSeatHeatRight();
                    break;
                case 37:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirTempRight();
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 53:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirGoFog();
                    break;
                case 62:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirSYNC();
                    break;
                case 65:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirFrontDefrost();
                    break;
                case 66:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirSteerHot();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_371_jeep_carairset);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this.touchSeat);
        findViewById(R.id.air_xts_auto).setOnClickListener(this);
        findViewById(R.id.air_xts_steer_hot).setOnClickListener(this);
        findViewById(R.id.air_xts_sync).setOnClickListener(this);
        findViewById(R.id.air_xts_cycle).setOnClickListener(this);
        findViewById(R.id.air_xts_power).setOnClickListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this.touchSeat);
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnClickListener(this);
        findViewById(R.id.air_xts_front).setOnClickListener(this);
        findViewById(R.id.air_xts_rear).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_body).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnClickListener(this);
        findViewById(R.id.air_xts_ac).setOnClickListener(this);
        findViewById(R.id.air_xts_maxac).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
        removeUpdater();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                int temp = DataCanbus.DATA[27];
                int unit = DataCanbus.DATA[37];
                if ((temp >= 13 && temp < 30) || (temp >= 60 && temp < 84)) {
                    temp++;
                } else if (temp == 30 || temp == 84) {
                    temp = 127;
                } else if (temp == -2 && unit == 1) {
                    temp = 14;
                } else if (temp == -2 && unit == 0) {
                    temp = 60;
                }
                DataCanbus.PROXY.cmd(0, new int[]{34, temp}, null, null);
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                int temp2 = DataCanbus.DATA[27];
                int unit2 = DataCanbus.DATA[37];
                if ((temp2 > 13 && temp2 <= 30) || (temp2 > 60 && temp2 <= 84)) {
                    temp2--;
                } else if (temp2 == 13 || temp2 == 60) {
                    temp2 = 0;
                } else if (temp2 == -3 && unit2 == 1) {
                    temp2 = 30;
                } else if (temp2 == -3 && unit2 == 0) {
                    temp2 = 84;
                }
                DataCanbus.PROXY.cmd(0, new int[]{34, temp2}, null, null);
                break;
            case R.id.air_xts_power /* 2131427428 */:
                DataCanbus.PROXY.cmd(0, new int[]{16, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{16, 0}, null, null);
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                DataCanbus.PROXY.cmd(0, new int[]{28, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{28, 0}, null, null);
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                DataCanbus.PROXY.cmd(0, new int[]{29, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{29, 0}, null, null);
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                DataCanbus.PROXY.cmd(0, new int[]{20, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{20, 0}, null, null);
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                DataCanbus.PROXY.cmd(0, new int[]{19, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{19, 0}, null, null);
                break;
            case R.id.air_xts_front /* 2131427438 */:
                DataCanbus.PROXY.cmd(0, new int[]{21, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{21, 0}, null, null);
                break;
            case R.id.air_xts_ac /* 2131427440 */:
                DataCanbus.PROXY.cmd(0, new int[]{17, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{17, 0}, null, null);
                break;
            case R.id.air_xts_maxac /* 2131427441 */:
                DataCanbus.PROXY.cmd(0, new int[]{18, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{18, 0}, null, null);
                break;
            case R.id.air_xts_sync /* 2131427442 */:
                DataCanbus.PROXY.cmd(0, new int[]{23, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{23, 0}, null, null);
                break;
            case R.id.air_xts_mode_foot /* 2131427444 */:
                DataCanbus.PROXY.cmd(0, new int[]{26, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{26, 0}, null, null);
                break;
            case R.id.air_xts_mode_body /* 2131427445 */:
                DataCanbus.PROXY.cmd(0, new int[]{24, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{24, 0}, null, null);
                break;
            case R.id.btn_air_temp_right_plus /* 2131427450 */:
                int temp3 = DataCanbus.DATA[28];
                int unit3 = DataCanbus.DATA[37];
                if ((temp3 >= 13 && temp3 < 30) || (temp3 >= 60 && temp3 < 84)) {
                    temp3++;
                } else if (temp3 == 30 || temp3 == 84) {
                    temp3 = 127;
                } else if (temp3 == -2 && unit3 == 1) {
                    temp3 = 14;
                } else if (temp3 == -2 && unit3 == 0) {
                    temp3 = 60;
                }
                DataCanbus.PROXY.cmd(0, new int[]{35, temp3}, null, null);
                break;
            case R.id.btn_air_temp_right_minus /* 2131427452 */:
                int temp4 = DataCanbus.DATA[28];
                int unit4 = DataCanbus.DATA[37];
                if ((temp4 > 13 && temp4 <= 30) || (temp4 > 60 && temp4 <= 84)) {
                    temp4--;
                } else if (temp4 == 13 || temp4 == 60) {
                    temp4 = 0;
                } else if (temp4 == -3 && unit4 == 1) {
                    temp4 = 30;
                } else if (temp4 == -3 && unit4 == 0) {
                    temp4 = 84;
                }
                DataCanbus.PROXY.cmd(0, new int[]{35, temp4}, null, null);
                break;
            case R.id.air_xts_steer_hot /* 2131427454 */:
                DataCanbus.PROXY.cmd(0, new int[]{52, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{52, 0}, null, null);
                break;
            case R.id.air_xts_mode_footbody /* 2131427555 */:
                DataCanbus.PROXY.cmd(0, new int[]{25, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{25, 0}, null, null);
                break;
            case R.id.air_xts_rear /* 2131427643 */:
                DataCanbus.PROXY.cmd(0, new int[]{22, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{22, 0}, null, null);
                break;
            case R.id.air_xts_mode_footwin /* 2131427735 */:
                DataCanbus.PROXY.cmd(0, new int[]{27, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{27, 0}, null, null);
                break;
        }
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        int unit = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                default:
                    if (unit == 0) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(temp + "℉");
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(temp + "℃");
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempRight() {
        int temp = DataCanbus.DATA[28];
        int unit = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                    break;
                default:
                    if (unit == 0) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(temp + "℉");
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(temp + "℃");
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[21];
        if (level >= 0 && level <= 7) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirGoFog() {
        int value = DataCanbus.DATA[53];
        findViewById(R.id.air_xts_maxac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirAuto() {
        int value = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirSteerHot() {
        int value = DataCanbus.DATA[66];
        findViewById(R.id.air_xts_steer_hot).setBackgroundResource(value == 0 ? R.drawable.ic_xts_steer_hot_n : R.drawable.ic_xts_steer_hot_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirSYNC() {
        int value = DataCanbus.DATA[62];
        findViewById(R.id.air_xts_sync).setBackgroundResource(value == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[12];
        findViewById(R.id.air_xts_cycle).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_n : R.drawable.ic_xts_cycle_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirFrontDefrost() {
        int value = DataCanbus.DATA[65];
        findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirBlowMode() {
        int up = DataCanbus.DATA[18];
        int body = DataCanbus.DATA[19];
        int foot = DataCanbus.DATA[20];
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        if (up == 1 && body == 0 && foot == 1) {
            findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
            return;
        }
        if (up == 0 && body == 0 && foot == 1) {
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
            return;
        }
        if (up == 0 && body == 1 && foot == 1) {
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
        } else if (up == 0 && body == 1 && foot == 0) {
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirSeatHeatLeft() {
        int value = DataCanbus.DATA[29];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                break;
            case 2:
            case 3:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirSeatHeatRight() {
        int value = DataCanbus.DATA[30];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
                break;
            case 2:
            case 3:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                break;
        }
    }
}
