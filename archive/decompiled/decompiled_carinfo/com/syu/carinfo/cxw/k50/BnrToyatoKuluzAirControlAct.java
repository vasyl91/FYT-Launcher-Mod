package com.syu.carinfo.cxw.k50;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class BnrToyatoKuluzAirControlAct extends Activity implements View.OnTouchListener {
    public static BnrToyatoKuluzAirControlAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    BnrToyatoKuluzAirControlAct.this.mUpdatePowerOn();
                    break;
                case 11:
                    BnrToyatoKuluzAirControlAct.this.mUpdateAcOn();
                    break;
                case 12:
                    BnrToyatoKuluzAirControlAct.this.mUpdateCycle();
                    break;
                case 13:
                    BnrToyatoKuluzAirControlAct.this.mUpdateAutoOn();
                    break;
                case 14:
                    BnrToyatoKuluzAirControlAct.this.mUpdateDualOn();
                    break;
                case 15:
                    BnrToyatoKuluzAirControlAct.this.mUpdateFrontDefrost();
                    break;
                case 16:
                    BnrToyatoKuluzAirControlAct.this.mUpdateRearDefrost();
                    break;
                case 18:
                case 19:
                case 20:
                    BnrToyatoKuluzAirControlAct.this.mUpdateModeOnlyLeft();
                    break;
                case 21:
                    BnrToyatoKuluzAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    BnrToyatoKuluzAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    BnrToyatoKuluzAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 33:
                    BnrToyatoKuluzAirControlAct.this.mUpdateClearAir();
                    break;
                case 37:
                    BnrToyatoKuluzAirControlAct.this.mUpdateAirTempLeft();
                    BnrToyatoKuluzAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 67:
                    BnrToyatoKuluzAirControlAct.this.mUpdateRearCtrlOn();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int state) {
        DataCanbus.PROXY.cmd(22, new int[]{data0, state}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0397_bnr_toyato_klz_air_control);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_munits).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_plus).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear_defrog).setOnTouchListener(this);
        findViewById(R.id.air_xts_front_defrost).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_clearair).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 3;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 2;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 9;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 10;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
                data0 = 67;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 21;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 25;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 23;
                break;
            case R.id.air_xts_clearair /* 2131427447 */:
                data0 = 32;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 5;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 4;
                break;
            case R.id.air_xts_mode_munits /* 2131427497 */:
                data0 = 7;
                break;
            case R.id.air_xts_mode_plus /* 2131427498 */:
                data0 = 8;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                data0 = 42;
                break;
            case R.id.air_xts_dual /* 2131427566 */:
                data0 = 16;
                break;
            case R.id.air_xts_rear_defrog /* 2131428028 */:
                data0 = 20;
                break;
            case R.id.air_xts_front_defrost /* 2131428029 */:
                data0 = 19;
                break;
        }
        if (event.getAction() == 0) {
            sendCmd(data0, 1);
        } else if (event.getAction() == 1) {
            sendCmd(data0, 0);
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
    }

    private void mUpdateModeright() {
        int win = DataCanbus.DATA[22];
        int body = DataCanbus.DATA[23];
        int foot = DataCanbus.DATA[24];
        int mode = ((win << 2) & 4) | ((body << 1) & 2) | ((foot << 0) & 1);
        switch (mode) {
            case 1:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list1);
                break;
            case 2:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list2);
                break;
            case 3:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list3);
                break;
            case 4:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list4);
                break;
            case 5:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list5);
                break;
            case 6:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list6);
                break;
            case 7:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list7);
                break;
            default:
                findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_null);
                break;
        }
    }

    
    public void mUpdateModeOnlyLeft() {
        int win = DataCanbus.DATA[18];
        int body = DataCanbus.DATA[19];
        int foot = DataCanbus.DATA[20];
        int mode = ((win << 2) & 4) | ((body << 1) & 2) | ((foot << 0) & 1);
        switch (mode) {
            case 1:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list1);
                break;
            case 2:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list2);
                break;
            case 3:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list3);
                break;
            case 4:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list4);
                break;
            case 5:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list5);
                break;
            case 6:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list6);
                break;
            case 7:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list7);
                break;
            default:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_null);
                break;
        }
    }

    private void mUpdateModeLeft() {
        int win = DataCanbus.DATA[18];
        int body = DataCanbus.DATA[19];
        int foot = DataCanbus.DATA[20];
        int mode = ((win << 2) & 4) | ((body << 1) & 2) | ((foot << 0) & 1);
        switch (mode) {
            case 1:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list1);
                break;
            case 2:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list2);
                break;
            case 3:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list3);
                break;
            case 4:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list4);
                break;
            case 5:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list5);
                break;
            case 6:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list6);
                break;
            case 7:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_list7);
                break;
            default:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_wc_toyota_klz_mode_null);
                break;
        }
    }

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[28];
        int unit = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LO");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("--");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(temp + 64) + "℉");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(temp / 10) + "." + (temp % 10) + "℃");
            }
        }
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        int unit = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LO");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("--");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(temp + 64) + "℉");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(temp / 10) + "." + (temp % 10) + "℃");
            }
        }
    }

    
    public void mUpdateRearCtrlOn() {
        int acOn = DataCanbus.DATA[67];
        findViewById(R.id.air_xts_rear).setBackgroundResource(acOn == 0 ? R.drawable.ic_wc_toyota_klz_rear_n : R.drawable.ic_wc_toyota_klz_rear_p);
    }

    
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[14];
        findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 0 ? R.drawable.ic_wc_toyota_klz_zone_n : R.drawable.ic_wc_toyota_klz_zone_p);
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_wc_toyota_klz_auto_n : R.drawable.ic_wc_toyota_klz_auto_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_wc_toyota_klz_ac_n : R.drawable.ic_wc_toyota_klz_ac_p);
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_air_cxw_k50_power_n : R.drawable.ic_air_cxw_k50_power_p);
    }

    
    public void mUpdateClearAir() {
        int on = DataCanbus.DATA[33];
        findViewById(R.id.air_xts_clearair).setBackgroundResource(on == 0 ? R.drawable.ic_wc_toyota_klz_clearair_n : R.drawable.ic_wc_toyota_klz_clearair_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        findViewById(R.id.air_xts_cycle).setBackgroundResource(cycle == 0 ? R.drawable.ic_wc_toyota_klz_cycle_outer_p : R.drawable.ic_wc_toyota_klz_cycle_inter_p);
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[15];
        findViewById(R.id.air_xts_front_defrost).setBackgroundResource(front == 0 ? R.drawable.ic_wc_toyota_klz_front_defrost_n : R.drawable.ic_wc_toyota_klz_front_defrost_p);
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear_defrog).setBackgroundResource(rear == 0 ? R.drawable.ic_wc_toyota_klz_rear_defrost_n : R.drawable.ic_wc_toyota_klz_rear_defrost_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        switch (leave) {
            case 0:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev0);
                break;
            case 1:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev1);
                break;
            case 2:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev2);
                break;
            case 3:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev3);
                break;
            case 4:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev4);
                break;
            case 5:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev5);
                break;
            case 6:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev6);
                break;
            case 7:
                findViewById(R.id.air_xts_win_lev).setBackgroundResource(R.drawable.ic_xts_win_lev7);
                break;
        }
    }
}
