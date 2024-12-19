package com.syu.carinfo.dj.havalh8;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Dj_0439_AirFrontCtrl extends Activity implements View.OnTouchListener {
    public static Dj_0439_AirFrontCtrl mInstance;
    public static boolean mIsFront = false;
    boolean bNeedSend = false;
    int cmdId = -1;
    int touchState = -1;
    Runnable airControl = new Runnable() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_AirFrontCtrl.1
        @Override // java.lang.Runnable
        public void run() {
            Dj_0439_AirFrontCtrl.this.setAirControl(Dj_0439_AirFrontCtrl.this.cmdId, 0);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_AirFrontCtrl.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    Dj_0439_AirFrontCtrl.this.mUpdaterAirPower();
                    break;
                case 11:
                    Dj_0439_AirFrontCtrl.this.mUpdaterAirAC();
                    break;
                case 12:
                    Dj_0439_AirFrontCtrl.this.mUpdateAirCycle();
                    break;
                case 14:
                    Dj_0439_AirFrontCtrl.this.mUpdateAirAuto();
                    break;
                case 15:
                    Dj_0439_AirFrontCtrl.this.mUpdateAirZone();
                    break;
                case 16:
                    Dj_0439_AirFrontCtrl.this.mUpdaterAirFront();
                    break;
                case 17:
                    Dj_0439_AirFrontCtrl.this.mUpdaterAirRear();
                    break;
                case 18:
                case 19:
                case 20:
                    Dj_0439_AirFrontCtrl.this.mUpdaterAirBLowMode();
                    break;
                case 21:
                    Dj_0439_AirFrontCtrl.this.mUpdaterAirWindLevel();
                    break;
                case 22:
                    Dj_0439_AirFrontCtrl.this.mUpdaterAirTempLeft();
                    break;
                case 23:
                    Dj_0439_AirFrontCtrl.this.mUpdaterAirTempRight();
                    break;
                case 30:
                    switch (value) {
                        case 0:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                            break;
                        case 1:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                            break;
                        case 2:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
                            break;
                        case 3:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                            break;
                    }
                case 31:
                    switch (value) {
                        case 0:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                            break;
                        case 1:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
                            break;
                        case 2:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
                            break;
                        case 3:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                            break;
                    }
                case 62:
                    switch (value) {
                        case 0:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level0);
                            break;
                        case 1:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level1);
                            break;
                        case 2:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level2);
                            break;
                        case 3:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level3);
                            break;
                    }
                case 63:
                    switch (value) {
                        case 0:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level0);
                            break;
                        case 1:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level1);
                            break;
                        case 2:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level2);
                            break;
                        case 3:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level3);
                            break;
                    }
                case 64:
                    switch (value) {
                        case 0:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatmassage_left).setBackgroundResource(R.drawable.ic_xts_seatmassage_left_level0);
                            break;
                        case 1:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatmassage_left).setBackgroundResource(R.drawable.ic_xts_seatmassage_left_level1);
                            break;
                        case 2:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatmassage_left).setBackgroundResource(R.drawable.ic_xts_seatmassage_left_level2);
                            break;
                        case 3:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatmassage_left).setBackgroundResource(R.drawable.ic_xts_seatmassage_left_level3);
                            break;
                    }
                case 65:
                    switch (value) {
                        case 0:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatmassage_right).setBackgroundResource(R.drawable.ic_xts_seatmassage_right_level0);
                            break;
                        case 1:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatmassage_right).setBackgroundResource(R.drawable.ic_xts_seatmassage_right_level1);
                            break;
                        case 2:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatmassage_right).setBackgroundResource(R.drawable.ic_xts_seatmassage_right_level2);
                            break;
                        case 3:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatmassage_right).setBackgroundResource(R.drawable.ic_xts_seatmassage_right_level3);
                            break;
                    }
                case 66:
                    switch (value) {
                        case 0:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwaist_left).setBackgroundResource(R.drawable.ic_xts_seatwaist_left_level0);
                            break;
                        case 1:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwaist_left).setBackgroundResource(R.drawable.ic_xts_seatwaist_left_level1);
                            break;
                        case 2:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwaist_left).setBackgroundResource(R.drawable.ic_xts_seatwaist_left_level2);
                            break;
                        case 3:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwaist_left).setBackgroundResource(R.drawable.ic_xts_seatwaist_left_level3);
                            break;
                    }
                case 67:
                    switch (value) {
                        case 0:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwaist_right).setBackgroundResource(R.drawable.ic_xts_seatwaist_right_level0);
                            break;
                        case 1:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwaist_right).setBackgroundResource(R.drawable.ic_xts_seatwaist_right_level1);
                            break;
                        case 2:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwaist_right).setBackgroundResource(R.drawable.ic_xts_seatwaist_right_level2);
                            break;
                        case 3:
                            Dj_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwaist_right).setBackgroundResource(R.drawable.ic_xts_seatwaist_right_level3);
                            break;
                    }
                case 86:
                    Dj_0439_AirFrontCtrl.this.mUpdaterAirAqs();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_dj_haval_airfront_vv6_control);
        init();
        mInstance = this;
    }

    private void init() {
        ((Button) findViewById(R.id.air_xts_power)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_ac)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_auto)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_zone)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_cycle)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_rear)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_front)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_aqs)).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode).setOnTouchListener(this);
        if (findViewById(R.id.air_xts_mode_plus) != null) {
            ((Button) findViewById(R.id.air_xts_mode_plus)).setOnTouchListener(this);
        }
        ((Button) findViewById(R.id.air_xts_seathot_left)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_seathot_right)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_seatwin_left)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_seatwin_right)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_seatmassage_left)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_seatmassage_right)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_seatwaist_left)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_seatwaist_right)).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeUpdater();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAirControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(0, cmdId, touchState);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                this.cmdId = 3;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                this.cmdId = 2;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                this.cmdId = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                this.cmdId = 9;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                this.cmdId = 10;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                this.cmdId = 11;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
            case R.id.air_xts_mode_plus /* 2131427456 */:
                this.cmdId = 50;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                this.cmdId = 13;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                this.cmdId = 21;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                this.cmdId = 25;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                this.cmdId = 48;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                this.cmdId = 23;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                this.cmdId = 8;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                this.cmdId = 7;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                this.cmdId = 5;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                this.cmdId = 4;
                break;
            case R.id.air_xts_seatwin_left /* 2131427452 */:
                this.cmdId = 12;
                break;
            case R.id.air_xts_seatwin_right /* 2131427454 */:
                this.cmdId = 14;
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                this.cmdId = 6;
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                this.cmdId = 26;
                break;
            case R.id.air_xts_aqs /* 2131427467 */:
                this.cmdId = 24;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                this.cmdId = 49;
                break;
            case R.id.air_xts_zone /* 2131428027 */:
                this.cmdId = 16;
                break;
            case R.id.air_xts_seatmassage_left /* 2131428196 */:
                this.cmdId = 17;
                break;
            case R.id.air_xts_seatwaist_left /* 2131428197 */:
                this.cmdId = 18;
                break;
            case R.id.air_xts_seatwaist_right /* 2131428198 */:
                this.cmdId = 20;
                break;
            case R.id.air_xts_seatmassage_right /* 2131428199 */:
                this.cmdId = 19;
                break;
        }
        switch (event.getAction()) {
            case 0:
                this.touchState = 1;
                this.bNeedSend = true;
                setAirControl(this.cmdId, this.touchState);
                break;
            case 1:
                this.bNeedSend = false;
                this.touchState = 0;
                HandlerUI.getInstance().postDelayed(this.airControl, 100L);
                break;
        }
        if (this.cmdId == -1 || this.touchState == -1) {
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirBLowMode() {
        int win = DataCanbus.DATA[18];
        int body = DataCanbus.DATA[19];
        int foot = DataCanbus.DATA[20];
        int mode = 0;
        if (foot == 1) {
            mode = 0 | 1;
        } else if (foot == 0) {
            mode = 0 & 254;
        }
        if (body == 1) {
            mode |= 2;
        } else if (body == 0) {
            mode &= 253;
        }
        if (win == 1) {
            mode |= 4;
        } else if (win == 0) {
            mode &= 251;
        }
        if (LauncherApplication.getConfiguration() == 1) {
            switch (mode) {
                case 0:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_null);
                    break;
                case 1:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot);
                    break;
                case 2:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_body);
                    break;
                case 3:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot_body);
                    break;
                case 4:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_win);
                    break;
                case 5:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot_win);
                    break;
                case 6:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_body_win);
                    break;
                case 7:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_all);
                    break;
                default:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_null);
                    break;
            }
        }
        switch (mode) {
            case 0:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                break;
            case 1:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot);
                break;
            case 2:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body);
                break;
            case 3:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
                break;
            case 4:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_win);
                break;
            case 5:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
                break;
            case 6:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body_win);
                break;
            case 7:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body_win);
                break;
            default:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirAqs() {
        int value = DataCanbus.DATA[86];
        if (((Button) findViewById(R.id.air_xts_aqs)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_aqs)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_aqs)).setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirRear() {
        int value = DataCanbus.DATA[17];
        if (((Button) findViewById(R.id.air_xts_rear)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_rear)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_rear)).setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirFront() {
        int value = DataCanbus.DATA[16];
        if (((Button) findViewById(R.id.air_xts_front)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_front)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_front)).setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[10];
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_power)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_power)).setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[11];
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_ac)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_ac)).setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirAuto() {
        int value = DataCanbus.DATA[14];
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_auto)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_auto)).setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirZone() {
        int value = DataCanbus.DATA[15];
        if (((Button) findViewById(R.id.air_xts_zone)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_zone)).setSelected(true);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_zone)).setSelected(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[12];
        if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_cycle)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_cycle)).setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[22];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp * 5) + 160) * 0.1f) + "°C");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempRight() {
        int temp = DataCanbus.DATA[23];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((temp * 5) + 160) * 0.1f) + "°C");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[21];
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
    }
}
