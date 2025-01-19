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

public class rzc_6606_112_Toyota_AirControlAct extends Activity implements View.OnTouchListener {
    public static rzc_6606_112_Toyota_AirControlAct mInstance;
    public static boolean mIsFront = false;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirPower();
                    break;
                case 11:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirAC();
                    break;
                case 12:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdateAirCycle();
                    break;
                case 13:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdateAirAuto();
                    break;
                case 14:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdateAirdual();
                    break;
                case 16:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdateAirRearDefrost();
                    break;
                case 17:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirCleanIce();
                    break;
                case 21:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 27:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 28:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirTempRight();
                    break;
                case 29:
                    rzc_6606_112_Toyota_AirControlAct.this.updateSeatHotLeft(value);
                    break;
                case 30:
                    rzc_6606_112_Toyota_AirControlAct.this.updateSeatHotRight(value);
                    break;
                case 31:
                    rzc_6606_112_Toyota_AirControlAct.this.updateSeatBlowLeft(value);
                    break;
                case 32:
                    rzc_6606_112_Toyota_AirControlAct.this.updateSeatBlowRight(value);
                    break;
                case 35:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirCleanSwing();
                    break;
                case 40:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirTempRearLeft();
                    break;
                case 41:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirTempRightRear();
                    break;
                case 42:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirPowerRear();
                    break;
                case 43:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirAutoRear();
                    break;
                case 44:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirWindLevelRear();
                    break;
                case 46:
                case 47:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdateAirBlowRear();
                    break;
                case 65:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdateAirFrontDefrost();
                    break;
                case 67:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirRearCtrl();
                    break;
                case 76:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdaterAirClean();
                    break;
                case 77:
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdateAirBlow();
                    rzc_6606_112_Toyota_AirControlAct.this.mUpdateAirBlowRight();
                    break;
                case 88:
                    rzc_6606_112_Toyota_AirControlAct.this.updateSeatHotLeftRear(value);
                    break;
                case 89:
                    rzc_6606_112_Toyota_AirControlAct.this.updateSeatHotRightRear(value);
                    break;
                case 90:
                    rzc_6606_112_Toyota_AirControlAct.this.updateSeatBlowLeftRear(value);
                    break;
                case 91:
                    rzc_6606_112_Toyota_AirControlAct.this.updateSeatBlowRightRear(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_6606_0112_rzc_toyota_all_carairset);
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

    @Override
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
        removeUpdater();
    }

    @Override
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
            case R.id.air_xts_rear /* 2131427560 */:
                data1 = 4;
                break;
            case R.id.air_xts_dual /* 2131427566 */:
                data1 = 8;
                break;
            case R.id.air_xts_clear /* 2131427569 */:
                data1 = 32;
                break;
            case R.id.air_xts_front_hot /* 2131427571 */:
                data1 = 16;
                break;
            case R.id.air_xts_front_blow_auto /* 2131427572 */:
                data1 = 64;
                break;
            case R.id.air_xts_mode_right /* 2131428024 */:
                data0 = 64;
                break;
            case R.id.btn_air_temp_left_plus_rear /* 2131428654 */:
                data5 = 2;
                break;
            case R.id.btn_air_temp_left_minus_rear /* 2131428656 */:
                data5 = 1;
                break;
            case R.id.dj_xts_air_win_plus_btn_rear /* 2131428657 */:
                data5 = 32;
                break;
            case R.id.dj_xts_air_win_minuts_btn_rear /* 2131428660 */:
                data5 = 16;
                break;
            case R.id.btn_air_temp_right_plus_rear /* 2131428661 */:
                data4 = 32;
                break;
            case R.id.btn_air_temp_right_minus_rear /* 2131428663 */:
                data4 = 16;
                break;
            case R.id.air_xts_seatwin_left_rear /* 2131428677 */:
                flag = true;
                data0 = 4;
                break;
            case R.id.air_xts_seathot_left_rear /* 2131428678 */:
                flag = true;
                data0 = 1;
                break;
            case R.id.air_xts_seathot_right_rear /* 2131428679 */:
                flag = true;
                data0 = 2;
                break;
            case R.id.air_xts_seatwin_right_rear /* 2131428680 */:
                flag = true;
                data0 = 8;
                break;
            case R.id.air_xts_rearpower /* 2131430086 */:
                data5 = 64;
                break;
            case R.id.air_xts_rearauto /* 2131430087 */:
                data5 = 4;
                break;
            case R.id.air_xts_rearmode /* 2131430088 */:
                data5 = 8;
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
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateSeatBlowLeftRear(int value) {
        if (findViewById(R.id.air_xts_seatwin_left_rear) != null) {
            switch (value) {
                case 0:
                    findViewById(R.id.air_xts_seatwin_left_rear).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_0);
                    break;
                case 1:
                    findViewById(R.id.air_xts_seatwin_left_rear).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_1);
                    break;
                case 2:
                    findViewById(R.id.air_xts_seatwin_left_rear).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_2);
                    break;
                case 3:
                    findViewById(R.id.air_xts_seatwin_left_rear).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_3);
                    break;
            }
        }
    }

    
    public void updateSeatBlowRightRear(int value) {
        if (findViewById(R.id.air_xts_seatwin_right_rear) != null) {
            switch (value) {
                case 0:
                    findViewById(R.id.air_xts_seatwin_right_rear).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_0);
                    break;
                case 1:
                    findViewById(R.id.air_xts_seatwin_right_rear).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_1);
                    break;
                case 2:
                    findViewById(R.id.air_xts_seatwin_right_rear).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_2);
                    break;
                case 3:
                    findViewById(R.id.air_xts_seatwin_right_rear).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_3);
                    break;
            }
        }
    }

    
    public void updateSeatHotRightRear(int value) {
        if (findViewById(R.id.air_xts_seathot_right_rear) != null) {
            switch (value) {
                case 0:
                    findViewById(R.id.air_xts_seathot_right_rear).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_0);
                    break;
                case 1:
                    findViewById(R.id.air_xts_seathot_right_rear).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_1);
                    break;
                case 2:
                    findViewById(R.id.air_xts_seathot_right_rear).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_2);
                    break;
                case 3:
                    findViewById(R.id.air_xts_seathot_right_rear).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_3);
                    break;
            }
        }
    }

    
    public void updateSeatHotLeftRear(int value) {
        if (findViewById(R.id.air_xts_seathot_left_rear) != null) {
            switch (value) {
                case 0:
                    findViewById(R.id.air_xts_seathot_left_rear).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_0);
                    break;
                case 1:
                    findViewById(R.id.air_xts_seathot_left_rear).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_1);
                    break;
                case 2:
                    findViewById(R.id.air_xts_seathot_left_rear).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_2);
                    break;
                case 3:
                    findViewById(R.id.air_xts_seathot_left_rear).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_3);
                    break;
            }
        }
    }

    
    public void updateSeatBlowLeft(int value) {
        if (findViewById(R.id.air_xts_seatwin_left) != null) {
            switch (value) {
                case 0:
                    findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_0);
                    break;
                case 1:
                    findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_1);
                    break;
                case 2:
                    findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_2);
                    break;
                case 3:
                    findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_3);
                    break;
            }
        }
    }

    
    public void updateSeatBlowRight(int value) {
        if (findViewById(R.id.air_xts_seatwin_right) != null) {
            switch (value) {
                case 0:
                    findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_0);
                    break;
                case 1:
                    findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_1);
                    break;
                case 2:
                    findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_2);
                    break;
                case 3:
                    findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_6606_toyota_seatwin_3);
                    break;
            }
        }
    }

    
    public void updateSeatHotRight(int value) {
        if (findViewById(R.id.air_xts_seathot_right) != null) {
            switch (value) {
                case 0:
                    findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_0);
                    break;
                case 1:
                    findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_1);
                    break;
                case 2:
                    findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_2);
                    break;
                case 3:
                    findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_3);
                    break;
            }
        }
    }

    
    public void updateSeatHotLeft(int value) {
        if (findViewById(R.id.air_xts_seathot_left) != null) {
            switch (value) {
                case 0:
                    findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_0);
                    break;
                case 1:
                    findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_1);
                    break;
                case 2:
                    findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_2);
                    break;
                case 3:
                    findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_6606_toyota_seathot_3);
                    break;
            }
        }
    }

    
    public void mUpdateAirBlowRear() {
        int mode;
        int mode2;
        int body = DataCanbus.DATA[46];
        int foot = DataCanbus.DATA[47];
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

    
    public void mUpdaterAirRearCtrl() {
        int value = DataCanbus.DATA[67];
        if (findViewById(R.id.air_xts_rearlock) != null) {
            findViewById(R.id.air_xts_rearlock).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_rearlock_n : R.drawable.ic_6606_toyota_rearlock_p);
        }
    }

    
    public void mUpdaterAirAutoRear() {
        int value = DataCanbus.DATA[43];
        if (findViewById(R.id.air_xts_rearauto) != null) {
            findViewById(R.id.air_xts_rearauto).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_rearauto_n : R.drawable.ic_6606_toyota_rearauto_p);
        }
    }

    
    public void mUpdaterAirPowerRear() {
        int value = DataCanbus.DATA[42];
        if (findViewById(R.id.air_xts_rearpower) != null) {
            findViewById(R.id.air_xts_rearpower).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_rearpower_n : R.drawable.ic_6606_toyota_rearpower_p);
        }
    }

    
    public void mUpdaterAirClean() {
        int value = DataCanbus.DATA[76];
        if (findViewById(R.id.air_xts_clear) != null) {
            findViewById(R.id.air_xts_clear).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_clearair_n : R.drawable.ic_6606_toyota_clearair_p);
        }
    }

    
    public void mUpdaterAirCleanIce() {
        int value = DataCanbus.DATA[17];
        if (findViewById(R.id.air_xts_front_hot) != null) {
            findViewById(R.id.air_xts_front_hot).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_fronthot_n : R.drawable.ic_6606_toyota_fronthot_p);
        }
    }

    
    public void mUpdaterAirCleanSwing() {
        int value = DataCanbus.DATA[35];
        if (findViewById(R.id.air_xts_front_blow_auto) != null) {
            findViewById(R.id.air_xts_front_blow_auto).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_autowing_n : R.drawable.ic_6606_toyota_autowing_p);
        }
    }

    
    public void mUpdaterAirTempRearLeft() {
        int temp = DataCanbus.DATA[40];
        int unit = DataCanbus.DATA[37];
        if (findViewById(R.id.tv_air_temp_left_rear) != null) {
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
                        ((TextView) findViewById(R.id.tv_air_temp_left_rear)).setText(String.valueOf(temp / 10.0f));
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left_rear)).setText(String.valueOf(temp / 10.0f));
                        break;
                    }
            }
        }
    }

    
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        int unit = DataCanbus.DATA[37];
        if (findViewById(R.id.tv_air_temp_left) != null) {
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
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(temp / 10.0f));
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(temp / 10.0f));
                        break;
                    }
            }
        }
    }

    
    public void mUpdaterAirTempRightRear() {
        int temp = DataCanbus.DATA[41];
        int unit = DataCanbus.DATA[37];
        if (findViewById(R.id.tv_air_temp_right_rear) != null) {
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
                        ((TextView) findViewById(R.id.tv_air_temp_right_rear)).setText(String.valueOf(temp / 10.0f));
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right_rear)).setText(String.valueOf(temp / 10.0f));
                        break;
                    }
            }
        }
    }

    
    public void mUpdaterAirTempRight() {
        int temp = DataCanbus.DATA[28];
        int unit = DataCanbus.DATA[37];
        if (findViewById(R.id.tv_air_temp_right) != null) {
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
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(temp / 10.0f));
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(temp / 10.0f));
                        break;
                    }
            }
        }
    }

    
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[21];
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(String.valueOf(level));
    }

    
    public void mUpdaterAirWindLevelRear() {
        int level = DataCanbus.DATA[44];
        ((TextView) findViewById(R.id.dj_xts_air_winlevel_rear)).setText(String.valueOf(level));
    }

    
    public void mUpdateAirAuto() {
        int value = DataCanbus.DATA[13];
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_auto_n : R.drawable.ic_6606_toyota_auto_p);
        }
    }

    
    public void mUpdateAirdual() {
        int value = DataCanbus.DATA[14];
        if (findViewById(R.id.air_xts_dual) != null) {
            findViewById(R.id.air_xts_dual).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_dual_n : R.drawable.ic_6606_toyota_dual_p);
        }
    }

    
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[12];
        if (findViewById(R.id.air_xts_cycle) != null) {
            if (value == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_6606_toyota_cycle_n);
            } else if (value == 1) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_6606_toyota_cycle_p);
            }
        }
    }

    
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[11];
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_ac_n : R.drawable.ic_6606_toyota_ac_p);
        }
    }

    
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[10];
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_power_n : R.drawable.ic_6606_toyota_power_p);
        }
    }

    
    public void mUpdateAirFrontDefrost() {
        int value = DataCanbus.DATA[65];
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_frontfrost_n : R.drawable.ic_6606_toyota_frontfrost_p);
        }
    }

    
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[16];
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setBackgroundResource(value == 0 ? R.drawable.ic_6606_toyota_rearfrost_n : R.drawable.ic_6606_toyota_rearfrost_p);
        }
    }

    
    public void mUpdateAirBlow() {
        int value = DataCanbus.DATA[77];
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

    
    public void mUpdateAirBlowRight() {
        int value = DataCanbus.DATA[77];
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
