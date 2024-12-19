package com.syu.carinfo.rzc.havalh6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Rzc_Oudi_0439_AirFrontCtrl extends Activity implements View.OnTouchListener {
    public static Rzc_Oudi_0439_AirFrontCtrl mInstance;
    public static boolean mIsFront = false;
    boolean bNeedSend = false;
    int cmdId = -1;
    int touchState = -1;
    Runnable airControl = new Runnable() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_Oudi_0439_AirFrontCtrl.1
        @Override // java.lang.Runnable
        public void run() {
            Rzc_Oudi_0439_AirFrontCtrl.this.setAirControl(Rzc_Oudi_0439_AirFrontCtrl.this.cmdId, 0);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_Oudi_0439_AirFrontCtrl.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    Rzc_Oudi_0439_AirFrontCtrl.this.mUpdaterAirPower();
                    break;
                case 11:
                    Rzc_Oudi_0439_AirFrontCtrl.this.mUpdaterAirAC();
                    break;
                case 12:
                    Rzc_Oudi_0439_AirFrontCtrl.this.mUpdateAirCycle();
                    break;
                case 13:
                case 15:
                    Rzc_Oudi_0439_AirFrontCtrl.this.mUpdateAirZone();
                    break;
                case 14:
                    Rzc_Oudi_0439_AirFrontCtrl.this.mUpdateAirAuto();
                    break;
                case 18:
                case 19:
                case 20:
                    Rzc_Oudi_0439_AirFrontCtrl.this.mUpdaterAirBLowMode();
                    break;
                case 21:
                    Rzc_Oudi_0439_AirFrontCtrl.this.mUpdaterAirWindLevel();
                    break;
                case 22:
                    Rzc_Oudi_0439_AirFrontCtrl.this.mUpdaterAirTempLeft();
                    break;
                case 23:
                    Rzc_Oudi_0439_AirFrontCtrl.this.mUpdaterAirTempRight();
                    break;
                case 30:
                    switch (value) {
                        case 0:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                            break;
                        case 1:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                            break;
                        case 2:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
                            break;
                        case 3:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                            break;
                    }
                case 31:
                    switch (value) {
                        case 0:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                            break;
                        case 1:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
                            break;
                        case 2:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
                            break;
                        case 3:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                            break;
                    }
                case 62:
                    switch (value) {
                        case 0:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level0);
                            break;
                        case 1:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level1);
                            break;
                        case 2:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level2);
                            break;
                        case 3:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level3);
                            break;
                    }
                case 63:
                    switch (value) {
                        case 0:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level0);
                            break;
                        case 1:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level1);
                            break;
                        case 2:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level2);
                            break;
                        case 3:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level3);
                            break;
                    }
                case 64:
                    switch (value) {
                        case 0:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatmassage_left).setBackgroundResource(R.drawable.ic_xts_seatmassage_left_level0);
                            break;
                        case 1:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatmassage_left).setBackgroundResource(R.drawable.ic_xts_seatmassage_left_level1);
                            break;
                        case 2:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatmassage_left).setBackgroundResource(R.drawable.ic_xts_seatmassage_left_level2);
                            break;
                        case 3:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatmassage_left).setBackgroundResource(R.drawable.ic_xts_seatmassage_left_level3);
                            break;
                    }
                case 65:
                    switch (value) {
                        case 0:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatmassage_right).setBackgroundResource(R.drawable.ic_xts_seatmassage_right_level0);
                            break;
                        case 1:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatmassage_right).setBackgroundResource(R.drawable.ic_xts_seatmassage_right_level1);
                            break;
                        case 2:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatmassage_right).setBackgroundResource(R.drawable.ic_xts_seatmassage_right_level2);
                            break;
                        case 3:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatmassage_right).setBackgroundResource(R.drawable.ic_xts_seatmassage_right_level3);
                            break;
                    }
                case 66:
                    switch (value) {
                        case 0:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwaist_left).setBackgroundResource(R.drawable.ic_xts_seatwaist_left_level0);
                            break;
                        case 1:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwaist_left).setBackgroundResource(R.drawable.ic_xts_seatwaist_left_level1);
                            break;
                        case 2:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwaist_left).setBackgroundResource(R.drawable.ic_xts_seatwaist_left_level2);
                            break;
                        case 3:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwaist_left).setBackgroundResource(R.drawable.ic_xts_seatwaist_left_level3);
                            break;
                    }
                case 67:
                    switch (value) {
                        case 0:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwaist_right).setBackgroundResource(R.drawable.ic_xts_seatwaist_right_level0);
                            break;
                        case 1:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwaist_right).setBackgroundResource(R.drawable.ic_xts_seatwaist_right_level1);
                            break;
                        case 2:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwaist_right).setBackgroundResource(R.drawable.ic_xts_seatwaist_right_level2);
                            break;
                        case 3:
                            Rzc_Oudi_0439_AirFrontCtrl.this.findViewById(R.id.air_xts_seatwaist_right).setBackgroundResource(R.drawable.ic_xts_seatwaist_right_level3);
                            break;
                    }
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_439_haval_airfront_h9_control);
        init();
        mInstance = this;
    }

    private void init() {
        ((Button) findViewById(R.id.air_xts_rearpage)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_Oudi_0439_AirFrontCtrl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rzc_Oudi_0439_AirFrontCtrl.this, Rzc_Oudi_0439_AirRearCtrl.class);
                    Rzc_Oudi_0439_AirFrontCtrl.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
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
        ((Button) findViewById(R.id.air_xts_mode_body)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_footbody)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_footwin)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_foot)).setOnTouchListener(this);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setAirControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(0, cmdId, touchState);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        if (DataCanbus.DATA[1000] == 16384439) {
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
                case R.id.air_xts_seathot_right /* 2131427435 */:
                    this.cmdId = 13;
                    break;
                case R.id.air_xts_auto /* 2131427436 */:
                    this.cmdId = 21;
                    break;
                case R.id.air_xts_cycle /* 2131427437 */:
                    this.cmdId = 25;
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
                    setAirControl(this.cmdId, 1);
                    break;
                case 1:
                    setAirControl(this.cmdId, 0);
                    break;
            }
        } else {
            switch (id) {
                case R.id.btn_air_temp_left_plus /* 2131427425 */:
                    this.cmdId = 30;
                    break;
                case R.id.btn_air_temp_left_minus /* 2131427427 */:
                    this.cmdId = 31;
                    break;
                case R.id.air_xts_power /* 2131427428 */:
                    this.cmdId = 16;
                    break;
                case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                    this.cmdId = 29;
                    break;
                case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                    this.cmdId = 28;
                    break;
                case R.id.air_xts_seathot_left /* 2131427433 */:
                    if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343) {
                        this.cmdId = 36;
                        break;
                    } else {
                        this.cmdId = 34;
                        break;
                    }
                case R.id.air_xts_seathot_right /* 2131427435 */:
                    if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343) {
                        this.cmdId = 37;
                        break;
                    } else {
                        this.cmdId = 35;
                        break;
                    }
                case R.id.air_xts_auto /* 2131427436 */:
                    if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343) {
                        this.cmdId = 34;
                        break;
                    } else {
                        this.cmdId = 18;
                        break;
                    }
                case R.id.air_xts_cycle /* 2131427437 */:
                    this.cmdId = 19;
                    break;
                case R.id.air_xts_ac /* 2131427439 */:
                    this.cmdId = 17;
                    break;
                case R.id.air_xts_mode_foot /* 2131427443 */:
                    this.cmdId = 26;
                    break;
                case R.id.air_xts_mode_body /* 2131427444 */:
                    this.cmdId = 24;
                    break;
                case R.id.btn_air_temp_right_plus /* 2131427449 */:
                    this.cmdId = 32;
                    break;
                case R.id.btn_air_temp_right_minus /* 2131427451 */:
                    this.cmdId = 33;
                    break;
                case R.id.air_xts_seatwin_left /* 2131427452 */:
                    if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343) {
                        this.cmdId = 38;
                        break;
                    } else {
                        this.cmdId = 36;
                        break;
                    }
                case R.id.air_xts_seatwin_right /* 2131427454 */:
                    if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343) {
                        this.cmdId = 39;
                        break;
                    } else {
                        this.cmdId = 37;
                        break;
                    }
                case R.id.air_xts_mode_footbody /* 2131427461 */:
                    this.cmdId = 25;
                    break;
                case R.id.air_xts_mode_footwin /* 2131427462 */:
                    this.cmdId = 27;
                    break;
                case R.id.air_xts_zone /* 2131428027 */:
                    if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343) {
                        this.cmdId = 35;
                        break;
                    } else {
                        this.cmdId = 20;
                        break;
                    }
                case R.id.air_xts_seatmassage_left /* 2131428196 */:
                    if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343) {
                        this.cmdId = 40;
                        break;
                    } else {
                        this.cmdId = 38;
                        break;
                    }
                case R.id.air_xts_seatwaist_left /* 2131428197 */:
                    if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343) {
                        this.cmdId = 42;
                        break;
                    } else {
                        this.cmdId = 40;
                        break;
                    }
                case R.id.air_xts_seatwaist_right /* 2131428198 */:
                    if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343) {
                        this.cmdId = 43;
                        break;
                    } else {
                        this.cmdId = 41;
                        break;
                    }
                case R.id.air_xts_seatmassage_right /* 2131428199 */:
                    if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343) {
                        this.cmdId = 41;
                        break;
                    } else {
                        this.cmdId = 39;
                        break;
                    }
            }
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
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
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
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirBLowMode() {
        int win = DataCanbus.DATA[18];
        int body = DataCanbus.DATA[19];
        int foot = DataCanbus.DATA[20];
        if (win == 1 && foot == 1 && body == 0) {
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setSelected(true);
            ((Button) findViewById(R.id.air_xts_mode_body)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_foot)).setSelected(false);
            return;
        }
        if (win == 0 && foot == 1 && body == 0) {
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_body)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_foot)).setSelected(true);
            return;
        }
        if (win == 0 && foot == 1 && body == 1) {
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_body)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setSelected(true);
            ((Button) findViewById(R.id.air_xts_mode_foot)).setSelected(false);
            return;
        }
        if (win == 0 && foot == 0 && body == 1) {
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_body)).setSelected(true);
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_foot)).setSelected(false);
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
        int value;
        int i = DataCanbus.DATA[13];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_439_OuDi_Haval_H9 /* 1376695 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5 /* 16122308 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6 /* 16187844 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7 /* 16253380 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                value = DataCanbus.DATA[13];
                break;
            default:
                value = DataCanbus.DATA[15];
                break;
        }
        if (((Button) findViewById(R.id.air_xts_zone)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_zone)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_zone)).setSelected(true);
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
        int temp;
        int temp2 = DataCanbus.DATA[22];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp2) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                default:
                    if (temp2 == 0) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText("None");
                        break;
                    } else {
                        if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343) {
                            temp = ((temp2 - 112) * 5) + 160;
                        } else {
                            temp = ((temp2 - 116) * 5) + 160;
                        }
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 0.1f) + "℃");
                        break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempRight() {
        int temp;
        int temp2 = DataCanbus.DATA[23];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (temp2) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                    break;
                default:
                    if (temp2 == 0) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText("None");
                        break;
                    } else {
                        if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343) {
                            temp = ((temp2 - 112) * 5) + 160;
                        } else {
                            temp = ((temp2 - 116) * 5) + 160;
                        }
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 0.1f) + "℃");
                        break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[21];
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
    }
}
