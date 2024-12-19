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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Bg_ZiYouGuangAirControlAct extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private View.OnTouchListener touchSeat = new View.OnTouchListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouGuangAirControlAct.1
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:
        
            return false;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(View v, MotionEvent event) {
            switch (v.getId()) {
                case R.id.air_xts_seathot_left /* 2131427433 */:
                    if (event.getAction() == 0) {
                        DataCanbus.PROXY.cmd(0, new int[]{48, 1}, null, null);
                        break;
                    } else if (event.getAction() == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{48, 0}, null, null);
                        break;
                    }
                    break;
                case R.id.air_xts_seathot_right /* 2131427435 */:
                    if (event.getAction() == 0) {
                        DataCanbus.PROXY.cmd(0, new int[]{50, 1}, null, null);
                        break;
                    } else if (event.getAction() == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{50, 0}, null, null);
                        break;
                    }
                    break;
            }
            return false;
        }
    };

    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouGuangAirControlAct.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 39:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirAuto();
                    break;
                case 40:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirCycle();
                    break;
                case 41:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirFrontDefrost();
                    break;
                case 42:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirRearDefrost();
                    break;
                case 43:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirAC();
                    break;
                case 44:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 45:
                case 46:
                case 47:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirBlowMode();
                    break;
                case 48:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirGoFog();
                    break;
                case 49:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 50:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirSeatHeatLeft();
                    break;
                case 51:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirSeatHeatRight();
                    break;
                case 52:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirTempRight();
                    break;
                case 53:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirPower();
                    break;
                case 54:
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirTempRight();
                    Bg_ZiYouGuangAirControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 56:
                    Bg_ZiYouGuangAirControlAct.this.mUpdateAirSYNC();
                    break;
                case 97:
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
                int temp = DataCanbus.DATA[44];
                int unit = DataCanbus.DATA[54];
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
                int temp2 = DataCanbus.DATA[44];
                int unit2 = DataCanbus.DATA[54];
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
                DataCanbus.PROXY.cmd(0, new int[]{16}, null, null);
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                DataCanbus.PROXY.cmd(0, new int[]{28, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{28}, null, null);
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                DataCanbus.PROXY.cmd(0, new int[]{29, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{29}, null, null);
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                DataCanbus.PROXY.cmd(0, new int[]{20, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{20}, null, null);
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                DataCanbus.PROXY.cmd(0, new int[]{19, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{19}, null, null);
                break;
            case R.id.air_xts_front /* 2131427438 */:
                DataCanbus.PROXY.cmd(0, new int[]{21, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{21}, null, null);
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                DataCanbus.PROXY.cmd(0, new int[]{17, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{17}, null, null);
                break;
            case R.id.air_xts_maxac /* 2131427440 */:
                DataCanbus.PROXY.cmd(0, new int[]{18, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{18}, null, null);
                break;
            case R.id.air_xts_sync /* 2131427441 */:
                DataCanbus.PROXY.cmd(0, new int[]{23, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{23}, null, null);
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                DataCanbus.PROXY.cmd(0, new int[]{26, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{26}, null, null);
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                DataCanbus.PROXY.cmd(0, new int[]{24, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{24}, null, null);
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                int temp3 = DataCanbus.DATA[52];
                int unit3 = DataCanbus.DATA[54];
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
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                int temp4 = DataCanbus.DATA[52];
                int unit4 = DataCanbus.DATA[54];
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
            case R.id.air_xts_steer_hot /* 2131427453 */:
                DataCanbus.PROXY.cmd(0, new int[]{52, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{52}, null, null);
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                DataCanbus.PROXY.cmd(0, new int[]{25, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{25}, null, null);
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                DataCanbus.PROXY.cmd(0, new int[]{27, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{27}, null, null);
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                DataCanbus.PROXY.cmd(0, new int[]{22, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{22}, null, null);
                break;
        }
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[44];
        int unit = DataCanbus.DATA[54];
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
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(temp + "℃");
                        break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempRight() {
        int temp = DataCanbus.DATA[52];
        int unit = DataCanbus.DATA[54];
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
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(temp + "℃");
                        break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[49];
        if (level >= 0 && level <= 7) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirGoFog() {
        int value = DataCanbus.DATA[48];
        findViewById(R.id.air_xts_maxac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirAuto() {
        int value = DataCanbus.DATA[39];
        findViewById(R.id.air_xts_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirSteerHot() {
        int value = DataCanbus.DATA[97];
        findViewById(R.id.air_xts_steer_hot).setBackgroundResource(value == 0 ? R.drawable.ic_xts_steer_hot_n : R.drawable.ic_xts_steer_hot_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirSYNC() {
        int value = DataCanbus.DATA[56];
        findViewById(R.id.air_xts_sync).setBackgroundResource(value == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[40];
        findViewById(R.id.air_xts_cycle).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_n : R.drawable.ic_xts_cycle_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[43];
        findViewById(R.id.air_xts_ac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirFrontDefrost() {
        int value = DataCanbus.DATA[41];
        findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[42];
        findViewById(R.id.air_xts_rear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirBlowMode() {
        int up = DataCanbus.DATA[47];
        int body = DataCanbus.DATA[45];
        int foot = DataCanbus.DATA[46];
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
        int value = DataCanbus.DATA[53];
        findViewById(R.id.air_xts_power).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirSeatHeatLeft() {
        int value = DataCanbus.DATA[50];
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
        int value = DataCanbus.DATA[51];
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
