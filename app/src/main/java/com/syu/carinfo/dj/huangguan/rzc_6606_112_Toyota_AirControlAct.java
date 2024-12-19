package com.syu.carinfo.dj.huangguan;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class rzc_6606_112_Toyota_AirControlAct extends Activity implements View.OnTouchListener {
    public static rzc_6606_112_Toyota_AirControlAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.huangguan.rzc_6606_112_Toyota_AirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 60:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirPower();
                    break;
                case 61:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirAC();
                    break;
                case 62:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdateAirCycle();
                    break;
                case 63:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdateAirAuto();
                    break;
                case 65:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdateAirdual();
                    break;
                case 70:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 71:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 72:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirTempRight();
                    break;
                case 152:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdateAirRearDefrost();
                    break;
                case 163:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirClean();
                    break;
                case 165:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirCleanIce();
                    break;
                case 166:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirCleanSwing();
                    break;
                case 167:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdateAirBlow();
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdateAirBlowRight();
                    break;
                case 169:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdateAirFrontDefrost();
                    break;
                case 200:
                    rzc_6606_112_Toyota_AirControlAct.this.updateSeatHotLeft(value);
                    break;
                case 201:
                    rzc_6606_112_Toyota_AirControlAct.this.updateSeatHotRight(value);
                    break;
                case 202:
                    rzc_6606_112_Toyota_AirControlAct.this.updateSeatBlowLeft(value);
                    break;
                case 203:
                    rzc_6606_112_Toyota_AirControlAct.this.updateSeatBlowRight(value);
                    break;
                case 215:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirRearCtrl();
                    break;
                case 216:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirTempRearLeft();
                    break;
                case 217:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirPowerRear();
                    break;
                case 218:
                case 219:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdateAirBlowRear();
                    break;
                case 220:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirAutoRear();
                    break;
                case 221:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirWindLevelRear();
                    break;
                case 246:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirTempRightRear();
                    break;
                case 248:
                    rzc_6606_112_Toyota_AirControlAct.this.updateSeatHotLeftRear(value);
                    break;
                case 249:
                    rzc_6606_112_Toyota_AirControlAct.this.updateSeatHotRightRear(value);
                    break;
                case 250:
                    rzc_6606_112_Toyota_AirControlAct.this.updateSeatBlowLeftRear(value);
                    break;
                case 251:
                    rzc_6606_112_Toyota_AirControlAct.this.updateSeatBlowRightRear(value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_6606_0112_rzc_toyota_all_carairset);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_front_hot).setOnTouchListener(this);
        findViewById(R.id.air_xts_front_blow_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_clear).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearpower).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearauto).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearmode).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus_rear).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus_rear).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn_rear).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn_rear).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus_rear).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearlock).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_left_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_left_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_right_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right_rear).setOnTouchListener(this);
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

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        int data1 = 0;
        int data2 = 0;
        int data3 = 0;
        int data4 = 0;
        int data5 = 0;
        boolean flag = false;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data3 = 2;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data3 = 1;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 128;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data1 = 1;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data1 = 2;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data2 = 16;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
                data0 = 64;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                data2 = 4;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 32;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data2 = 1;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 16;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 2;
                break;
            case R.id.air_xts_rearlock /* 2131427446 */:
                data5 = 128;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data4 = 2;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data4 = 1;
                break;
            case R.id.air_xts_seatwin_left /* 2131427452 */:
                data2 = 64;
                break;
            case R.id.air_xts_seatwin_right /* 2131427454 */:
                data2 = 32;
                break;
            case R.id.air_xts_dual /* 2131427460 */:
                data1 = 8;
                break;
            case R.id.air_xts_clear /* 2131427465 */:
                data1 = 32;
                break;
            case R.id.air_xts_front_hot /* 2131427466 */:
                data1 = 16;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data1 = 4;
                break;
            case R.id.air_xts_front_blow_auto /* 2131427560 */:
                data1 = 64;
                break;
            case R.id.air_xts_mode_right /* 2131427724 */:
                data0 = 64;
                break;
            case R.id.air_xts_rearpower /* 2131430131 */:
                data5 = 64;
                break;
            case R.id.air_xts_rearauto /* 2131430132 */:
                data5 = 4;
                break;
            case R.id.air_xts_rearmode /* 2131430133 */:
                data5 = 8;
                break;
            case R.id.btn_air_temp_left_plus_rear /* 2131430134 */:
                data5 = 2;
                break;
            case R.id.btn_air_temp_left_minus_rear /* 2131430136 */:
                data5 = 1;
                break;
            case R.id.dj_xts_air_win_plus_btn_rear /* 2131430137 */:
                data5 = 32;
                break;
            case R.id.dj_xts_air_win_minuts_btn_rear /* 2131430139 */:
                data5 = 16;
                break;
            case R.id.btn_air_temp_right_plus_rear /* 2131430140 */:
                data4 = 32;
                break;
            case R.id.btn_air_temp_right_minus_rear /* 2131430142 */:
                data4 = 16;
                break;
            case R.id.air_xts_seatwin_left_rear /* 2131430143 */:
                flag = true;
                data0 = 4;
                break;
            case R.id.air_xts_seathot_left_rear /* 2131430144 */:
                flag = true;
                data0 = 1;
                break;
            case R.id.air_xts_seatwin_right_rear /* 2131430145 */:
                flag = true;
                data0 = 8;
                break;
            case R.id.air_xts_seathot_right_rear /* 2131430146 */:
                flag = true;
                data0 = 2;
                break;
        }
        if (!flag) {
            switch (event.getAction()) {
                case 0:
                    DataCanbus.PROXY.cmd(41, new int[]{data0, data1, data2, data3, data4, data5}, null, null);
                    break;
                case 1:
                    DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    break;
            }
            return false;
        }
        switch (event.getAction()) {
            case 0:
                DataCanbus.PROXY.cmd(151, new int[]{16, data0}, null, null);
                break;
            case 1:
                DataCanbus.PROXY.cmd(151, new int[]{16}, null, null);
                break;
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[247].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[246].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[248].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[249].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[250].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[251].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[247].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[246].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[248].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[249].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[250].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[251].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSeatBlowLeftRear(int value) {
        if (((Button) findViewById(R.id.air_xts_seatwin_left_rear)) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_seatwin_left_rear)).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_0);
                    break;
                case 1:
                    ((Button) findViewById(R.id.air_xts_seatwin_left_rear)).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_1);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_seatwin_left_rear)).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_2);
                    break;
                case 3:
                    ((Button) findViewById(R.id.air_xts_seatwin_left_rear)).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_3);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSeatBlowRightRear(int value) {
        if (((Button) findViewById(R.id.air_xts_seatwin_right_rear)) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_seatwin_right_rear)).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_0);
                    break;
                case 1:
                    ((Button) findViewById(R.id.air_xts_seatwin_right_rear)).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_1);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_seatwin_right_rear)).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_2);
                    break;
                case 3:
                    ((Button) findViewById(R.id.air_xts_seatwin_right_rear)).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_3);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSeatHotRightRear(int value) {
        if (((Button) findViewById(R.id.air_xts_seathot_right_rear)) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_seathot_right_rear)).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_0);
                    break;
                case 1:
                    ((Button) findViewById(R.id.air_xts_seathot_right_rear)).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_1);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_seathot_right_rear)).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_2);
                    break;
                case 3:
                    ((Button) findViewById(R.id.air_xts_seathot_right_rear)).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_3);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSeatHotLeftRear(int value) {
        if (((Button) findViewById(R.id.air_xts_seathot_left_rear)) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_seathot_left_rear)).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_0);
                    break;
                case 1:
                    ((Button) findViewById(R.id.air_xts_seathot_left_rear)).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_1);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_seathot_left_rear)).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_2);
                    break;
                case 3:
                    ((Button) findViewById(R.id.air_xts_seathot_left_rear)).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_3);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSeatBlowLeft(int value) {
        if (((Button) findViewById(R.id.air_xts_seatwin_left)) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_0);
                    break;
                case 1:
                    ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_1);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_2);
                    break;
                case 3:
                    ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_3);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSeatBlowRight(int value) {
        if (((Button) findViewById(R.id.air_xts_seatwin_right)) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_0);
                    break;
                case 1:
                    ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_1);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_2);
                    break;
                case 3:
                    ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_3);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSeatHotRight(int value) {
        if (((Button) findViewById(R.id.air_xts_seathot_right)) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_0);
                    break;
                case 1:
                    ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_1);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_2);
                    break;
                case 3:
                    ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_3);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSeatHotLeft(int value) {
        if (((Button) findViewById(R.id.air_xts_seathot_left)) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_0);
                    break;
                case 1:
                    ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_1);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_2);
                    break;
                case 3:
                    ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_3);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirBlowRear() {
        int mode;
        int mode2;
        int body = DataCanbus.DATA[218];
        int foot = DataCanbus.DATA[219];
        if (body == 1) {
            mode = 0 | 2;
        } else {
            mode = 0 & 253;
        }
        if (foot == 1) {
            mode2 = mode | 1;
        } else {
            mode2 = mode & 254;
        }
        switch (mode2) {
            case 1:
                findViewById(R.id.air_xts_rearmode).setBackgroundResource(R.drawable.ic_6606_toyota_rearmode_1);
                break;
            case 2:
                findViewById(R.id.air_xts_rearmode).setBackgroundResource(R.drawable.ic_6606_toyota_rearmode_2);
                break;
            case 3:
                findViewById(R.id.air_xts_rearmode).setBackgroundResource(R.drawable.ic_6606_toyota_rearmode_3);
                break;
            default:
                findViewById(R.id.air_xts_rearmode).setBackgroundResource(R.drawable.ic_6606_toyota_rearmode_0);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirRearCtrl() {
        int value = DataCanbus.DATA[215];
        if (findViewById(R.id.air_xts_rearlock) != null) {
            findViewById(R.id.air_xts_rearlock).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_rearlock_n : R.drawable.ic_6606_toyota_rearlock_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirAutoRear() {
        int value = DataCanbus.DATA[220];
        if (findViewById(R.id.air_xts_rearauto) != null) {
            findViewById(R.id.air_xts_rearauto).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_rearauto_n : R.drawable.ic_6606_toyota_rearauto_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirPowerRear() {
        int value = DataCanbus.DATA[217];
        if (findViewById(R.id.air_xts_rearpower) != null) {
            findViewById(R.id.air_xts_rearpower).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_rearpower_n : R.drawable.ic_6606_toyota_rearpower_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirClean() {
        int value = DataCanbus.DATA[163];
        if (findViewById(R.id.air_xts_clear) != null) {
            findViewById(R.id.air_xts_clear).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_clearair_n : R.drawable.ic_6606_toyota_clearair_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirCleanIce() {
        int value = DataCanbus.DATA[165];
        if (findViewById(R.id.air_xts_front_hot) != null) {
            findViewById(R.id.air_xts_front_hot).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_fronthot_n : R.drawable.ic_6606_toyota_fronthot_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirCleanSwing() {
        int value = DataCanbus.DATA[166];
        if (findViewById(R.id.air_xts_front_blow_auto) != null) {
            findViewById(R.id.air_xts_front_blow_auto).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_autowing_n : R.drawable.ic_6606_toyota_autowing_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempRearLeft() {
        int temp = DataCanbus.DATA[216];
        int unit = DataCanbus.DATA[181];
        if (((TextView) findViewById(R.id.tv_air_temp_left_rear)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left_rear)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_left_rear)).setText("LO");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_left_rear)).setText("NO");
                    break;
                default:
                    if (unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_left_rear)).setText(new StringBuilder().append(temp / 10.0f).toString());
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left_rear)).setText(new StringBuilder().append(temp / 10.0f).toString());
                        break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[71];
        int unit = DataCanbus.DATA[181];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LO");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NO");
                    break;
                default:
                    if (unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(new StringBuilder().append(temp / 10.0f).toString());
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(new StringBuilder().append(temp / 10.0f).toString());
                        break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempRightRear() {
        int temp = DataCanbus.DATA[246];
        int unit = DataCanbus.DATA[181];
        if (((TextView) findViewById(R.id.tv_air_temp_right_rear)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_right_rear)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_right_rear)).setText("LO");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_right_rear)).setText("NO");
                    break;
                default:
                    if (unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_right_rear)).setText(new StringBuilder().append(temp / 10.0f).toString());
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right_rear)).setText(new StringBuilder().append(temp / 10.0f).toString());
                        break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempRight() {
        int temp = DataCanbus.DATA[72];
        int unit = DataCanbus.DATA[181];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LO");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NO");
                    break;
                default:
                    if (unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(new StringBuilder().append(temp / 10.0f).toString());
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(new StringBuilder().append(temp / 10.0f).toString());
                        break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[70];
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelRear() {
        int level = DataCanbus.DATA[221];
        ((TextView) findViewById(R.id.dj_xts_air_winlevel_rear)).setText(new StringBuilder().append(level).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirAuto() {
        int value = DataCanbus.DATA[63];
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_auto_n : R.drawable.ic_6606_toyota_auto_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirdual() {
        int value = DataCanbus.DATA[65];
        if (findViewById(R.id.air_xts_dual) != null) {
            findViewById(R.id.air_xts_dual).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_dual_n : R.drawable.ic_6606_toyota_dual_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[62];
        if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
            if (value == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_6606_toyota_cycle_n);
            } else if (value == 1) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_6606_toyota_cycle_p);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[61];
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_ac_n : R.drawable.ic_6606_toyota_ac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[60];
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_power_n : R.drawable.ic_6606_toyota_power_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirFrontDefrost() {
        int value = DataCanbus.DATA[169];
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_frontfrost_n : R.drawable.ic_6606_toyota_frontfrost_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[152];
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_rearfrost_n : R.drawable.ic_6606_toyota_rearfrost_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirBlow() {
        int value = DataCanbus.DATA[167];
        switch (value) {
            case 1:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_6606_toyota_mode_1);
                break;
            case 2:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_6606_toyota_mode_2);
                break;
            case 3:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_6606_toyota_mode_3);
                break;
            case 4:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_6606_toyota_mode_4);
                break;
            case 5:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_6606_toyota_mode_5);
                break;
            case 6:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_6606_toyota_mode_6);
                break;
            case 7:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_6606_toyota_mode_7);
                break;
            default:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_6606_toyota_mode_0);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirBlowRight() {
        int value = DataCanbus.DATA[167];
        switch (value) {
            case 1:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_6606_toyota_mode_1);
                break;
            case 2:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_6606_toyota_mode_2);
                break;
            case 3:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_6606_toyota_mode_3);
                break;
            case 4:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_6606_toyota_mode_4);
                break;
            case 5:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_6606_toyota_mode_5);
                break;
            case 6:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_6606_toyota_mode_6);
                break;
            case 7:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_6606_toyota_mode_7);
                break;
            default:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_6606_toyota_mode_0);
                break;
        }
    }
}
