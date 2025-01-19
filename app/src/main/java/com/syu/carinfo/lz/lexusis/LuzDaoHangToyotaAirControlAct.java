package com.syu.carinfo.lz.lexusis;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class LuzDaoHangToyotaAirControlAct extends Activity implements View.OnTouchListener {
    public static LuzDaoHangToyotaAirControlAct mInstance;
    public static boolean mIsFront = false;
    int Pagenum = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    if (LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_power) != null) {
                        LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_power).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_power_n : R.drawable.ic_daohang_toyota_power_p);
                        break;
                    }
                case 11:
                    if (LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_ac) != null) {
                        LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_ac).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_ac_n : R.drawable.ic_daohang_toyota_ac_p);
                        break;
                    }
                case 12:
                    if (LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_cycle) != null) {
                        LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_cycle).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_cycle_n : R.drawable.ic_daohang_toyota_cycle_p);
                        break;
                    }
                case 13:
                    if (LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_auto) != null) {
                        LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_auto).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_auto_n : R.drawable.ic_daohang_toyota_auto_p);
                        break;
                    }
                case 14:
                    if (LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_sync) != null) {
                        LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_sync).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_4zone_n : R.drawable.ic_daohang_toyota_4zone_p);
                        break;
                    }
                case 15:
                    if (LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_front) != null) {
                        LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_front_n : R.drawable.ic_daohang_toyota_front_p);
                        break;
                    }
                case 16:
                    if (LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_rear) != null) {
                        LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_rear).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_rear_n : R.drawable.ic_daohang_toyota_rear_p);
                        break;
                    }
                case 17:
                    if (LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_fronthot) != null) {
                        LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_fronthot).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_fronthot_n : R.drawable.ic_daohang_toyota_fronthot_p);
                        break;
                    }
                case 18:
                case 19:
                case 20:
                    LuzDaoHangToyotaAirControlAct.this.updateBtnSource();
                    break;
                case 21:
                    LuzDaoHangToyotaAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 22:
                case 23:
                case 24:
                    LuzDaoHangToyotaAirControlAct.this.updateBtnSourceRight();
                    break;
                case 27:
                    LuzDaoHangToyotaAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    LuzDaoHangToyotaAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 29:
                    LuzDaoHangToyotaAirControlAct.this.mUpdateAirSeatLeft();
                    break;
                case 30:
                    LuzDaoHangToyotaAirControlAct.this.mUpdateAirSeatRight();
                    break;
                case 33:
                    if (LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_flowauto) != null) {
                        LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_flowauto).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_flowauto_n : R.drawable.ic_daohang_toyota_flowauto_p);
                        break;
                    }
                case 35:
                    if (LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_swing) != null) {
                        LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_swing).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_swing_n : R.drawable.ic_daohang_toyota_swing_p);
                        break;
                    }
                case 37:
                    LuzDaoHangToyotaAirControlAct.this.mUpdateAirTempLeft();
                    LuzDaoHangToyotaAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 38:
                    if (LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_rearlock) != null) {
                        LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_rearlock).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_rearlight_n : R.drawable.ic_daohang_toyota_rearlight_p);
                        break;
                    }
                case 40:
                    LuzDaoHangToyotaAirControlAct.this.mUpdateAirTempRearLeft();
                    break;
                case 41:
                    LuzDaoHangToyotaAirControlAct.this.mUpdateAirTempRearRight();
                    break;
                case 43:
                    if (LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_auto_rear) != null) {
                        LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_auto_rear).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_auto_rear_n : R.drawable.ic_daohang_toyota_auto_rear_p);
                        break;
                    }
                case 44:
                    LuzDaoHangToyotaAirControlAct.this.mUpdaterAirWindLevelRear();
                    break;
                case 76:
                    if (LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_clear) != null) {
                        LuzDaoHangToyotaAirControlAct.this.findViewById(R.id.air_xts_clear).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_toyota_clean_n : R.drawable.ic_daohang_toyota_clean_p);
                        break;
                    }
                case 86:
                    LuzDaoHangToyotaAirControlAct.this.mUpdateManual();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        //setContentView(R.layout.layout_0454_lz_daohang_15kuluze_air_control);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.btn_plus2).setOnTouchListener(this);
        findViewById(R.id.btn_plus3).setOnTouchListener(this);
        findViewById(R.id.btn_plus7).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_plus).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_munits).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_plus_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_munits_right).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_sync).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearlock).setOnTouchListener(this);
        findViewById(R.id.air_xts_flowauto).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_fronthot).setOnTouchListener(this);
        findViewById(R.id.air_xts_clear).setOnTouchListener(this);
        findViewById(R.id.air_xts_swing).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus_rear).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus_rear).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn_rear).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn_rear).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus_rear).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_power_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_manual).setOnTouchListener(this);
    }

    private void updatepage(int num) {
        this.Pagenum = num;
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_daohang_front_n);
        findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_daohang_frontseat_n);
        findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_daohang_rear_n);
        switch (this.Pagenum) {
            case 0:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_daohang_front_p);
                break;
            case 1:
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_daohang_frontseat_p);
                break;
            case 2:
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_daohang_rear_p);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        updatepage(this.Pagenum);
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
        boolean flag = false;
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
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data0 = 11;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                data0 = 13;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 21;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 25;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 18;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 23;
                break;
            case R.id.air_xts_sync /* 2131427441 */:
                data0 = 16;
                break;
            case R.id.air_xts_rearlock /* 2131427446 */:
                data0 = 57;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 5;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 4;
                break;
            case R.id.air_xts_seatwin_left /* 2131427452 */:
                data0 = 12;
                break;
            case R.id.air_xts_seatwin_right /* 2131427454 */:
                data0 = 14;
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                flag = true;
                updatepage(0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                flag = true;
                updatepage(1);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                flag = true;
                updatepage(2);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                flag = true;
                if (event.getAction() == 1) {
                    finish();
                    break;
                }
            case R.id.air_xts_mode_munits /* 2131427497 */:
            case R.id.air_xts_mode_plus /* 2131427498 */:
                data0 = 36;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                data0 = 20;
                break;
            case R.id.air_xts_manual /* 2131427568 */:
                data0 = 59;
                break;
            case R.id.air_xts_clear /* 2131427569 */:
                data0 = 39;
                break;
            case R.id.air_xts_fronthot /* 2131427591 */:
                data0 = 38;
                break;
            case R.id.air_xts_mode_plus_right /* 2131428648 */:
            case R.id.air_xts_mode_munits_right /* 2131428649 */:
                data0 = 37;
                break;
            case R.id.air_xts_flowauto /* 2131428650 */:
                data0 = 40;
                break;
            case R.id.air_xts_swing /* 2131428653 */:
                data0 = 60;
                break;
            case R.id.btn_air_temp_left_plus_rear /* 2131428654 */:
                data0 = 42;
                break;
            case R.id.btn_air_temp_left_minus_rear /* 2131428656 */:
                data0 = 41;
                break;
            case R.id.dj_xts_air_win_plus_btn_rear /* 2131428657 */:
                data0 = 49;
                break;
            case R.id.dj_xts_air_win_minuts_btn_rear /* 2131428660 */:
                data0 = 48;
                break;
            case R.id.btn_air_temp_right_plus_rear /* 2131428661 */:
                data0 = 51;
                break;
            case R.id.btn_air_temp_right_minus_rear /* 2131428663 */:
                data0 = 50;
                break;
            case R.id.air_xts_power_rear /* 2131428664 */:
                data0 = 61;
                break;
            case R.id.air_xts_auto_rear /* 2131428665 */:
                data0 = 52;
                break;
        }
        if (!flag) {
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
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateManual() {
        int value = DataCanbus.DATA[86];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.air_xts_manual0);
                break;
            case 1:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.air_xts_manual1);
                break;
            case 2:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.air_xts_manual2);
                break;
            case 3:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.air_xts_manual3);
                break;
            case 4:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.air_xts_manual4);
                break;
            case 5:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.air_xts_manual5);
                break;
            case 6:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.air_xts_manual6);
                break;
            case 7:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.air_xts_manual7);
                break;
        }
    }

    
    public void mUpdateAirTempLeft() {
        int unit = DataCanbus.DATA[37];
        int sysunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        int temp = DataCanbus.DATA[27];
        if (findViewById(R.id.tv_air_temp_left) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LO");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                return;
            }
            if (unit == 0 && sysunit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(((temp * 5) + 175) * 0.1f));
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(((temp * 9) + 635) / 10));
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int unit = DataCanbus.DATA[37];
        int sysunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        int temp = DataCanbus.DATA[28];
        if (findViewById(R.id.tv_air_temp_right) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LO");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                return;
            }
            if (unit == 0 && sysunit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(((temp * 5) + 175) * 0.1f));
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(((temp * 9) + 635) / 10));
            }
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        switch (leave) {
            case 0:
                findViewById(R.id.air_xts_winlevel).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev0);
                break;
            case 1:
                findViewById(R.id.air_xts_winlevel).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev1);
                break;
            case 2:
                findViewById(R.id.air_xts_winlevel).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev2);
                break;
            case 3:
                findViewById(R.id.air_xts_winlevel).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev3);
                break;
            case 4:
                findViewById(R.id.air_xts_winlevel).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev4);
                break;
            case 5:
                findViewById(R.id.air_xts_winlevel).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev5);
                break;
            case 6:
                findViewById(R.id.air_xts_winlevel).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev6);
                break;
            case 7:
                findViewById(R.id.air_xts_winlevel).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev7);
                break;
        }
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(String.valueOf(leave));
    }

    
    public void mUpdateAirSeatLeft() {
        int value = DataCanbus.DATA[29];
        if ((value & 8) != 0) {
            findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_daohang_toyota_seathot_0);
            switch (16 - value) {
                case 1:
                    findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_daohang_toyota_seatwin_1);
                    findViewById(R.id.air_xts_seat_left).setBackgroundResource(R.drawable.ic_daohang_toyota_seatstate_winleft1);
                    break;
                case 2:
                    findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_daohang_toyota_seatwin_2);
                    findViewById(R.id.air_xts_seat_left).setBackgroundResource(R.drawable.ic_daohang_toyota_seatstate_winleft2);
                    break;
                case 3:
                    findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_daohang_toyota_seatwin_3);
                    findViewById(R.id.air_xts_seat_left).setBackgroundResource(R.drawable.ic_daohang_toyota_seatstate_winleft3);
                    break;
            }
        }
        findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_daohang_toyota_seatwin_0);
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_daohang_toyota_seathot_0);
                findViewById(R.id.air_xts_seat_left).setBackgroundResource(R.drawable.ic_daohang_toyota_seatstate_left0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_daohang_toyota_seathot_1);
                findViewById(R.id.air_xts_seat_left).setBackgroundResource(R.drawable.ic_daohang_toyota_seatstate_hotleft1);
                break;
            case 2:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_daohang_toyota_seathot_2);
                findViewById(R.id.air_xts_seat_left).setBackgroundResource(R.drawable.ic_daohang_toyota_seatstate_hotleft2);
                break;
            case 3:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_daohang_toyota_seathot_3);
                findViewById(R.id.air_xts_seat_left).setBackgroundResource(R.drawable.ic_daohang_toyota_seatstate_hotleft3);
                break;
        }
    }

    
    public void mUpdateAirSeatRight() {
        int value = DataCanbus.DATA[30];
        if ((value & 8) != 0) {
            findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_daohang_toyota_seathot_0);
            switch (16 - value) {
                case 1:
                    findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_daohang_toyota_seatwin_1);
                    findViewById(R.id.air_xts_seat_right).setBackgroundResource(R.drawable.ic_daohang_toyota_seatstate_winright1);
                    break;
                case 2:
                    findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_daohang_toyota_seatwin_2);
                    findViewById(R.id.air_xts_seat_right).setBackgroundResource(R.drawable.ic_daohang_toyota_seatstate_winright2);
                    break;
                case 3:
                    findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_daohang_toyota_seatwin_3);
                    findViewById(R.id.air_xts_seat_right).setBackgroundResource(R.drawable.ic_daohang_toyota_seatstate_winright3);
                    break;
            }
        }
        findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_daohang_toyota_seatwin_0);
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_daohang_toyota_seathot_0);
                findViewById(R.id.air_xts_seat_right).setBackgroundResource(R.drawable.ic_daohang_toyota_seatstate_right0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_daohang_toyota_seathot_1);
                findViewById(R.id.air_xts_seat_right).setBackgroundResource(R.drawable.ic_daohang_toyota_seatstate_hotright1);
                break;
            case 2:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_daohang_toyota_seathot_2);
                findViewById(R.id.air_xts_seat_right).setBackgroundResource(R.drawable.ic_daohang_toyota_seatstate_hotright2);
                break;
            case 3:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_daohang_toyota_seathot_3);
                findViewById(R.id.air_xts_seat_right).setBackgroundResource(R.drawable.ic_daohang_toyota_seatstate_hotright3);
                break;
        }
    }

    
    public void mUpdateAirTempRearLeft() {
        int unit = DataCanbus.DATA[37];
        int sysunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        int temp = DataCanbus.DATA[40];
        if (findViewById(R.id.tv_air_temp_left_rear) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left_rear)).setText("LO");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left_rear)).setText("HI");
                return;
            }
            if (unit == 0 && sysunit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left_rear)).setText(String.valueOf(((temp * 5) + 175) * 0.1f));
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left_rear)).setText(String.valueOf(((temp * 9) + 635) / 10));
            }
        }
    }

    
    public void mUpdateAirTempRearRight() {
        int unit = DataCanbus.DATA[37];
        int sysunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        int temp = DataCanbus.DATA[41];
        if (findViewById(R.id.tv_air_temp_right_rear) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right_rear)).setText("LO");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right_rear)).setText("HI");
                return;
            }
            if (unit == 0 && sysunit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right_rear)).setText(String.valueOf(((temp * 5) + 175) * 0.1f));
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right_rear)).setText(String.valueOf(((temp * 9) + 635) / 10));
            }
        }
    }

    
    public void mUpdaterAirWindLevelRear() {
        int leave = DataCanbus.DATA[44];
        switch (leave) {
            case 0:
                findViewById(R.id.air_xts_winlevel_rear).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev0);
                break;
            case 1:
                findViewById(R.id.air_xts_winlevel_rear).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev1);
                break;
            case 2:
                findViewById(R.id.air_xts_winlevel_rear).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev2);
                break;
            case 3:
                findViewById(R.id.air_xts_winlevel_rear).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev3);
                break;
            case 4:
                findViewById(R.id.air_xts_winlevel_rear).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev4);
                break;
            case 5:
                findViewById(R.id.air_xts_winlevel_rear).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev5);
                break;
            case 6:
                findViewById(R.id.air_xts_winlevel_rear).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev6);
                break;
            case 7:
                findViewById(R.id.air_xts_winlevel_rear).setBackgroundResource(R.drawable.ic_daohang_toyotawinlev7);
                break;
        }
        ((TextView) findViewById(R.id.dj_xts_air_winlevel_rear)).setText(String.valueOf(leave));
        findViewById(R.id.air_xts_power_rear).setBackgroundResource(leave == 0 ? R.drawable.ic_daohang_toyota_power_rear_n : R.drawable.ic_daohang_toyota_power_rear_p);
    }

    
    public void updateBtnSource() {
        int window = DataCanbus.DATA[18];
        int foot = DataCanbus.DATA[20];
        int body = DataCanbus.DATA[19];
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
        if (window == 1) {
            mode |= 4;
        } else if (window == 0) {
            mode &= 251;
        }
        switch (mode) {
            case 0:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_daohang_toyotamode0);
                break;
            case 1:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_daohang_toyotamode1);
                break;
            case 2:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_daohang_toyotamode2);
                break;
            case 3:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_daohang_toyotamode3);
                break;
            case 4:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_daohang_toyotamode4);
                break;
            case 5:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_daohang_toyotamode5);
                break;
            case 6:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_daohang_toyotamode6);
                break;
            case 7:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_daohang_toyotamode7);
                break;
            default:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_daohang_toyotamode0);
                break;
        }
    }

    
    public void updateBtnSourceRight() {
        int body_right = DataCanbus.DATA[23];
        int foot_right = DataCanbus.DATA[24];
        int window_right = DataCanbus.DATA[22];
        int mode_right = 0;
        if (foot_right == 1) {
            mode_right = 0 | 1;
        } else if (foot_right == 0) {
            mode_right = 0 & 254;
        }
        if (body_right == 1) {
            mode_right |= 2;
        } else if (body_right == 0) {
            mode_right &= 253;
        }
        if (window_right == 1) {
            mode_right |= 4;
        } else if (window_right == 0) {
            mode_right &= 251;
        }
        if (findViewById(R.id.air_xts_mode_right) != null) {
            switch (mode_right) {
                case 0:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_daohang_toyota_rightmode0);
                    break;
                case 1:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_daohang_toyota_rightmode1);
                    break;
                case 2:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_daohang_toyota_rightmode2);
                    break;
                case 3:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_daohang_toyota_rightmode3);
                    break;
                case 4:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_daohang_toyota_rightmode4);
                    break;
                case 5:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_daohang_toyota_rightmode5);
                    break;
                case 6:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_daohang_toyota_rightmode6);
                    break;
                case 7:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_daohang_toyota_rightmode7);
                    break;
                default:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_daohang_toyota_rightmode0);
                    break;
            }
        }
    }
}
