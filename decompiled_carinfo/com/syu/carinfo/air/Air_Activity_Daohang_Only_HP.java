package com.syu.carinfo.air;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_Activity_Daohang_Only_HP extends Activity implements View.OnTouchListener {
    public static Air_Activity_Daohang_Only_HP mInstance;
    public static boolean mIsFront = false;
    int pagenum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 11) {
                Air_Activity_Daohang_Only_HP.this.mUpdateAcOn();
            }
            if (updateCode == 12) {
                Air_Activity_Daohang_Only_HP.this.mUpdateCycle();
            }
            if (updateCode == 16) {
                Air_Activity_Daohang_Only_HP.this.mUpdateRearDefrost();
            }
            if (updateCode == 65) {
                Air_Activity_Daohang_Only_HP.this.mUpdateFrontDefrost();
            }
            if (updateCode == 10) {
                Air_Activity_Daohang_Only_HP.this.mUpdatePower();
            }
            if (updateCode == 42) {
                Air_Activity_Daohang_Only_HP.this.mUpdateRearPower();
            }
            if (updateCode == 27) {
                Air_Activity_Daohang_Only_HP.this.mUpdateAirTempLeft();
            }
            if (updateCode == 21) {
                Air_Activity_Daohang_Only_HP.this.mUpdaterAirWindLevelLeft();
            }
            if (updateCode == 13) {
                Air_Activity_Daohang_Only_HP.this.mUpdateAuto();
            }
            if (updateCode == 26) {
                Air_Activity_Daohang_Only_HP.this.mUpdateAutoRight();
            }
            if (updateCode == 62) {
                Air_Activity_Daohang_Only_HP.this.mUpdateSYNC();
            }
            if (updateCode == 29) {
                Air_Activity_Daohang_Only_HP.this.mUpdateHeatLeft();
            }
            if (updateCode == 30) {
                Air_Activity_Daohang_Only_HP.this.mUpdateHeatRight();
            }
            if (updateCode == 31) {
                Air_Activity_Daohang_Only_HP.this.mUpdateWindLeft();
            }
            if (updateCode == 32) {
                Air_Activity_Daohang_Only_HP.this.mUpdateWindRight();
            }
            if (updateCode == 28) {
                Air_Activity_Daohang_Only_HP.this.mUpdateTempRight();
            }
            if (updateCode == 37) {
                Air_Activity_Daohang_Only_HP.this.mUpdateTempUNIT();
            }
            if (updateCode == 40) {
                Air_Activity_Daohang_Only_HP.this.mUpdateBackTemp();
            }
            if (updateCode == 41) {
                Air_Activity_Daohang_Only_HP.this.mUpdateBackTempRight();
            }
            if (updateCode == 43) {
                Air_Activity_Daohang_Only_HP.this.mUpdateBackAuto();
            }
            if (updateCode == 67) {
                Air_Activity_Daohang_Only_HP.this.mUpdateBackRearLock();
            }
            if (updateCode == 39) {
                Air_Activity_Daohang_Only_HP.this.mUpdateBackRearSync();
            }
            if (updateCode == 78) {
                Air_Activity_Daohang_Only_HP.this.mUpdateBackRearAC();
            }
            if (updateCode == 53) {
                Air_Activity_Daohang_Only_HP.this.mUpdateAcMax();
            }
            if (updateCode == 66) {
                Air_Activity_Daohang_Only_HP.this.mUpdateSteerHot();
            }
            if (updateCode == 44) {
                Air_Activity_Daohang_Only_HP.this.mUpdateBackWind();
            }
            if (updateCode == 18 || updateCode == 19 || updateCode == 20) {
                Air_Activity_Daohang_Only_HP.this.updateBlowModeLeft();
            }
            if (updateCode == 22 || updateCode == 23 || updateCode == 24) {
                Air_Activity_Daohang_Only_HP.this.updateBlowModeRight();
            }
            if (updateCode != 46 && updateCode != 47) {
                return;
            }
            Air_Activity_Daohang_Only_HP.this.updateBlowBackMode();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_air_hp_all_daohang_only);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.tv_sp_front).setOnTouchListener(this);
        findViewById(R.id.tv_sp_seat).setOnTouchListener(this);
        findViewById(R.id.tv_sp_rear).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_mode_up).setOnTouchListener(this);
        findViewById(R.id.air_sp_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_sp_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_sp_mode_up_right).setOnTouchListener(this);
        findViewById(R.id.air_sp_mode_body_right).setOnTouchListener(this);
        findViewById(R.id.air_sp_mode_foot_right).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_acmax).setOnTouchListener(this);
        findViewById(R.id.air_sp_ac).setOnTouchListener(this);
        findViewById(R.id.air_sp_sync).setOnTouchListener(this);
        findViewById(R.id.air_sp_front).setOnTouchListener(this);
        findViewById(R.id.air_sp_rear).setOnTouchListener(this);
        findViewById(R.id.air_sp_auto).setOnTouchListener(this);
        findViewById(R.id.air_sp_power).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_minuts).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_cycle).setOnTouchListener(this);
        findViewById(R.id.air_sp_auto_right).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatheat_left).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatwind_left).setOnTouchListener(this);
        findViewById(R.id.air_sp_steer).setOnTouchListener(this);
        findViewById(R.id.air_sp_sunshade).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatheat_right).setOnTouchListener(this);
        findViewById(R.id.air_sp_seatwind_right).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_rearleft_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_rearleft_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_rear_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_sp_rear_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_sp_rear_mode_bodyfoot).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_rearright_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_rearright_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_rearlock_rear).setOnTouchListener(this);
        findViewById(R.id.air_sp_ac_rear).setOnTouchListener(this);
        findViewById(R.id.air_sp_sync_rear).setOnTouchListener(this);
        findViewById(R.id.air_sp_power_rear).setOnTouchListener(this);
        findViewById(R.id.air_sp_rear_wind_minuts).setOnTouchListener(this);
        findViewById(R.id.air_sp_rear_wind_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_auto_rear).setOnTouchListener(this);
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
        int data0 = 255;
        switch (id) {
            case R.id.tv_sp_front /* 2131427932 */:
                this.pagenum = 0;
                findViewById(R.id.veiw_air_front).setVisibility(0);
                findViewById(R.id.veiw_air_seat).setVisibility(8);
                findViewById(R.id.veiw_air_rear).setVisibility(8);
                ((TextView) findViewById(R.id.tv_sp_front)).setTextColor(Color.parseColor("#d5a45e"));
                ((TextView) findViewById(R.id.tv_sp_seat)).setTextColor(Color.parseColor("#ffffff"));
                ((TextView) findViewById(R.id.tv_sp_rear)).setTextColor(Color.parseColor("#ffffff"));
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.bk_daohang_select1);
                break;
            case R.id.tv_sp_rear /* 2131427933 */:
                this.pagenum = 2;
                findViewById(R.id.veiw_air_front).setVisibility(8);
                findViewById(R.id.veiw_air_seat).setVisibility(8);
                findViewById(R.id.veiw_air_rear).setVisibility(0);
                ((TextView) findViewById(R.id.tv_sp_front)).setTextColor(Color.parseColor("#ffffff"));
                ((TextView) findViewById(R.id.tv_sp_seat)).setTextColor(Color.parseColor("#ffffff"));
                ((TextView) findViewById(R.id.tv_sp_rear)).setTextColor(Color.parseColor("#d5a45e"));
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.bk_daohang_select3);
                break;
            case R.id.air_sp_mode_body /* 2131428558 */:
                data0 = 15;
                break;
            case R.id.air_sp_mode_foot /* 2131428560 */:
                data0 = 17;
                break;
            case R.id.air_sp_mode_body_right /* 2131428568 */:
                data0 = 40;
                break;
            case R.id.air_sp_mode_foot_right /* 2131428570 */:
                data0 = 41;
                break;
            case R.id.air_sp_mode_up /* 2131428686 */:
                data0 = 39;
                break;
            case R.id.tv_sp_seat /* 2131430260 */:
                this.pagenum = 1;
                findViewById(R.id.veiw_air_front).setVisibility(8);
                findViewById(R.id.veiw_air_seat).setVisibility(0);
                findViewById(R.id.veiw_air_rear).setVisibility(8);
                ((TextView) findViewById(R.id.tv_sp_front)).setTextColor(Color.parseColor("#ffffff"));
                ((TextView) findViewById(R.id.tv_sp_seat)).setTextColor(Color.parseColor("#d5a45e"));
                ((TextView) findViewById(R.id.tv_sp_rear)).setTextColor(Color.parseColor("#ffffff"));
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.bk_daohang_select2);
                break;
            case R.id.air_sp_temp_left_plus /* 2131430261 */:
                data0 = 1;
                break;
            case R.id.air_sp_temp_left_munits /* 2131430265 */:
                data0 = 2;
                break;
            case R.id.air_sp_mode_up_right /* 2131430268 */:
                data0 = 42;
                break;
            case R.id.air_sp_temp_right_plus /* 2131430269 */:
                data0 = 3;
                break;
            case R.id.air_sp_temp_right_munits /* 2131430273 */:
                data0 = 4;
                break;
            case R.id.air_sp_acmax /* 2131430274 */:
                data0 = 9;
                break;
            case R.id.air_sp_ac /* 2131430275 */:
                data0 = 10;
                break;
            case R.id.air_sp_sync /* 2131430276 */:
                data0 = 8;
                break;
            case R.id.air_sp_front /* 2131430277 */:
                data0 = 13;
                break;
            case R.id.air_sp_rear /* 2131430278 */:
                data0 = 14;
                break;
            case R.id.air_sp_auto /* 2131430279 */:
                data0 = 12;
                break;
            case R.id.air_sp_power /* 2131430280 */:
                data0 = 7;
                break;
            case R.id.air_sp_wind_minuts /* 2131430281 */:
                data0 = 6;
                break;
            case R.id.air_sp_wind_plus /* 2131430283 */:
                data0 = 5;
                break;
            case R.id.air_sp_cycle /* 2131430284 */:
                data0 = 11;
                break;
            case R.id.air_sp_auto_right /* 2131430285 */:
                data0 = 43;
                break;
            case R.id.air_sp_seatheat_left /* 2131430287 */:
                data0 = 22;
                break;
            case R.id.air_sp_seatwind_left /* 2131430288 */:
                data0 = 23;
                break;
            case R.id.air_sp_steer /* 2131430289 */:
                data0 = 24;
                break;
            case R.id.air_sp_sunshade /* 2131430290 */:
                data0 = 19;
                break;
            case R.id.air_sp_seatheat_right /* 2131430291 */:
                data0 = 20;
                break;
            case R.id.air_sp_seatwind_right /* 2131430292 */:
                data0 = 21;
                break;
            case R.id.air_sp_temp_rearleft_plus /* 2131430293 */:
                data0 = 25;
                break;
            case R.id.air_sp_temp_rearleft_munits /* 2131430297 */:
                data0 = 26;
                break;
            case R.id.air_sp_rear_mode_body /* 2131430299 */:
                data0 = 35;
                break;
            case R.id.air_sp_rear_mode_foot /* 2131430300 */:
                data0 = 37;
                break;
            case R.id.air_sp_rear_mode_bodyfoot /* 2131430301 */:
                data0 = 36;
                break;
            case R.id.air_sp_temp_rearright_plus /* 2131430302 */:
                data0 = 27;
                break;
            case R.id.air_sp_temp_rearright_munits /* 2131430306 */:
                data0 = 28;
                break;
            case R.id.air_sp_rearlock_rear /* 2131430307 */:
                data0 = 38;
                break;
            case R.id.air_sp_ac_rear /* 2131430308 */:
                data0 = 33;
                break;
            case R.id.air_sp_sync_rear /* 2131430309 */:
                data0 = 32;
                break;
            case R.id.air_sp_power_rear /* 2131430310 */:
                data0 = 31;
                break;
            case R.id.air_sp_rear_wind_minuts /* 2131430311 */:
                data0 = 30;
                break;
            case R.id.air_sp_rear_wind_plus /* 2131430313 */:
                data0 = 29;
                break;
            case R.id.air_sp_auto_rear /* 2131430314 */:
                data0 = 34;
                break;
        }
        if (event.getAction() == 0) {
            DataCanbus.PROXY.cmd(0, new int[]{24, data0}, null, null);
        } else if (event.getAction() == 1) {
            DataCanbus.PROXY.cmd(0, new int[]{24}, null, null);
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateSteerHot() {
        int vel = DataCanbus.DATA[66];
        findViewById(R.id.air_sp_steer).setBackgroundResource(vel == 0 ? R.drawable.ic_daohang_steerhot_p : R.drawable.ic_daohang_steerhot_n);
    }

    
    public void mUpdateAcMax() {
        int vel = DataCanbus.DATA[53];
        findViewById(R.id.air_sp_acmax).setBackgroundResource(vel == 0 ? R.drawable.ic_daohang_acmax_n : R.drawable.ic_daohang_acmax_p);
    }

    
    public void mUpdateBackTemp() {
        int temp = DataCanbus.DATA[40];
        if (findViewById(R.id.air_sp_temp_rearleft) != null) {
            if (temp == -2) {
                findViewById(R.id.air_sp_temp_rearleft).setVisibility(8);
                findViewById(R.id.air_sp_temp_unit_rearleft).setVisibility(8);
                findViewById(R.id.air_sp_temp_state_rearleft).setVisibility(0);
                ((TextView) findViewById(R.id.air_sp_temp_state_rearleft)).setText("LO");
                return;
            }
            if (temp == -3) {
                findViewById(R.id.air_sp_temp_rearleft).setVisibility(8);
                findViewById(R.id.air_sp_temp_unit_rearleft).setVisibility(8);
                findViewById(R.id.air_sp_temp_state_rearleft).setVisibility(0);
                ((TextView) findViewById(R.id.air_sp_temp_state_rearleft)).setText("HI");
                return;
            }
            if (temp == -1) {
                findViewById(R.id.air_sp_temp_rearleft).setVisibility(8);
                findViewById(R.id.air_sp_temp_unit_rearleft).setVisibility(8);
                findViewById(R.id.air_sp_temp_state_rearleft).setVisibility(0);
                ((TextView) findViewById(R.id.air_sp_temp_state_rearleft)).setText("NO");
                return;
            }
            findViewById(R.id.air_sp_temp_rearleft).setVisibility(0);
            findViewById(R.id.air_sp_temp_unit_rearleft).setVisibility(0);
            findViewById(R.id.air_sp_temp_state_rearleft).setVisibility(8);
            int temp2 = temp * 5;
            ((TextView) findViewById(R.id.air_sp_temp_rearleft)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10));
            mUpdateTempUNIT();
        }
    }

    
    public void mUpdateBackTempRight() {
        int temp = DataCanbus.DATA[41];
        if (findViewById(R.id.air_sp_temp_rearright) != null) {
            if (temp == -2) {
                findViewById(R.id.air_sp_temp_rearright).setVisibility(8);
                findViewById(R.id.air_sp_temp_unit_rearright).setVisibility(8);
                findViewById(R.id.air_sp_temp_state_rearright).setVisibility(0);
                ((TextView) findViewById(R.id.air_sp_temp_state_rearright)).setText("LO");
                return;
            }
            if (temp == -3) {
                findViewById(R.id.air_sp_temp_rearright).setVisibility(8);
                findViewById(R.id.air_sp_temp_unit_rearright).setVisibility(8);
                findViewById(R.id.air_sp_temp_state_rearright).setVisibility(0);
                ((TextView) findViewById(R.id.air_sp_temp_state_rearright)).setText("HI");
                return;
            }
            if (temp == -1) {
                findViewById(R.id.air_sp_temp_rearright).setVisibility(8);
                findViewById(R.id.air_sp_temp_unit_rearright).setVisibility(8);
                findViewById(R.id.air_sp_temp_state_rearright).setVisibility(0);
                ((TextView) findViewById(R.id.air_sp_temp_state_rearright)).setText("NO");
                return;
            }
            findViewById(R.id.air_sp_temp_rearright).setVisibility(0);
            findViewById(R.id.air_sp_temp_unit_rearright).setVisibility(0);
            findViewById(R.id.air_sp_temp_state_rearright).setVisibility(8);
            int temp2 = temp * 5;
            ((TextView) findViewById(R.id.air_sp_temp_rearright)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10));
            mUpdateTempUNIT();
        }
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        if (findViewById(R.id.air_sp_temp_left) != null) {
            if (temp == -2) {
                findViewById(R.id.air_sp_temp_unit_left).setVisibility(8);
                findViewById(R.id.air_sp_temp_left).setVisibility(8);
                findViewById(R.id.air_sp_temp_state_left).setVisibility(0);
                ((TextView) findViewById(R.id.air_sp_temp_state_left)).setText("LO");
                return;
            }
            if (temp == -3) {
                findViewById(R.id.air_sp_temp_unit_left).setVisibility(8);
                findViewById(R.id.air_sp_temp_left).setVisibility(8);
                findViewById(R.id.air_sp_temp_state_left).setVisibility(0);
                ((TextView) findViewById(R.id.air_sp_temp_state_left)).setText("HI");
                return;
            }
            if (temp == -1) {
                findViewById(R.id.air_sp_temp_unit_left).setVisibility(8);
                findViewById(R.id.air_sp_temp_left).setVisibility(8);
                findViewById(R.id.air_sp_temp_state_left).setVisibility(0);
                ((TextView) findViewById(R.id.air_sp_temp_state_left)).setText("NO");
                return;
            }
            findViewById(R.id.air_sp_temp_unit_left).setVisibility(0);
            findViewById(R.id.air_sp_temp_left).setVisibility(0);
            findViewById(R.id.air_sp_temp_state_left).setVisibility(8);
            int temp2 = temp * 5;
            ((TextView) findViewById(R.id.air_sp_temp_left)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10));
            mUpdateTempUNIT();
        }
    }

    
    public void mUpdateTempRight() {
        int temp = DataCanbus.DATA[28];
        if (findViewById(R.id.air_sp_temp_right) != null) {
            if (temp == -2) {
                findViewById(R.id.air_sp_temp_right).setVisibility(8);
                findViewById(R.id.air_sp_temp_unit_right).setVisibility(8);
                findViewById(R.id.air_sp_temp_state_right).setVisibility(0);
                ((TextView) findViewById(R.id.air_sp_temp_state_right)).setText("LO");
                return;
            }
            if (temp == -3) {
                findViewById(R.id.air_sp_temp_right).setVisibility(8);
                findViewById(R.id.air_sp_temp_unit_right).setVisibility(8);
                findViewById(R.id.air_sp_temp_state_right).setVisibility(0);
                ((TextView) findViewById(R.id.air_sp_temp_state_right)).setText("HI");
                return;
            }
            if (temp == -1) {
                findViewById(R.id.air_sp_temp_right).setVisibility(8);
                findViewById(R.id.air_sp_temp_unit_right).setVisibility(8);
                findViewById(R.id.air_sp_temp_state_right).setVisibility(0);
                ((TextView) findViewById(R.id.air_sp_temp_state_right)).setText("NO");
                return;
            }
            findViewById(R.id.air_sp_temp_right).setVisibility(0);
            findViewById(R.id.air_sp_temp_unit_right).setVisibility(0);
            findViewById(R.id.air_sp_temp_state_right).setVisibility(8);
            int temp2 = temp * 5;
            ((TextView) findViewById(R.id.air_sp_temp_right)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10));
            mUpdateTempUNIT();
        }
    }

    
    public void mUpdateTempUNIT() {
        int vel = DataCanbus.DATA[37];
        if (vel == 1) {
            ((TextView) findViewById(R.id.air_sp_temp_unit_rearright)).setText("℉");
            ((TextView) findViewById(R.id.air_sp_temp_unit_rearleft)).setText("℉");
            ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℉");
            ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℉");
            return;
        }
        ((TextView) findViewById(R.id.air_sp_temp_unit_rearright)).setText("℃");
        ((TextView) findViewById(R.id.air_sp_temp_unit_rearleft)).setText("℃");
        ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
    }

    
    public void mUpdateBackAuto() {
        int vel = DataCanbus.DATA[43];
        findViewById(R.id.air_sp_auto_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_daohang_rear_auto_p : R.drawable.ic_daohang_rear_auto_n);
    }

    
    public void mUpdateBackRearLock() {
        int vel = DataCanbus.DATA[67];
        findViewById(R.id.air_sp_rearlock_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_daohang_rearlock_n : R.drawable.ic_daohang_rearlock_p);
    }

    
    public void mUpdateBackRearSync() {
        int vel = DataCanbus.DATA[39];
        findViewById(R.id.air_sp_sync_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_daohang_rear_sync_p : R.drawable.ic_daohang_rear_sync_n);
    }

    
    public void mUpdateBackRearAC() {
        int vel = DataCanbus.DATA[78];
        findViewById(R.id.air_sp_ac_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_daohang_rear_ac_n : R.drawable.ic_daohang_rear_ac_p);
    }

    
    public void mUpdateBackWind() {
        int leave = DataCanbus.DATA[44];
        switch (leave) {
            case 0:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_daohang_win_lev0);
                break;
            case 1:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_daohang_win_lev1);
                break;
            case 2:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_daohang_win_lev2);
                break;
            case 3:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_daohang_win_lev3);
                break;
            case 4:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_daohang_win_lev4);
                break;
            case 5:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_daohang_win_lev5);
                break;
            case 6:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_daohang_win_lev6);
                break;
            case 7:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_daohang_win_lev7);
                break;
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int value = DataCanbus.DATA[21];
        switch (value) {
            case 0:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_daohang_win_lev0);
                break;
            case 1:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_daohang_win_lev1);
                break;
            case 2:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_daohang_win_lev2);
                break;
            case 3:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_daohang_win_lev3);
                break;
            case 4:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_daohang_win_lev4);
                break;
            case 5:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_daohang_win_lev5);
                break;
            case 6:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_daohang_win_lev6);
                break;
            case 7:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_daohang_win_lev7);
                break;
        }
    }

    
    public void mUpdateHeatLeft() {
        int vel = DataCanbus.DATA[29];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_daohang_seathot_left_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_daohang_seathot_left_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_daohang_seathot_left_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_daohang_seathot_left_3);
                break;
        }
    }

    
    public void mUpdateHeatRight() {
        int vel = DataCanbus.DATA[30];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_daohang_seathot_right_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_daohang_seathot_right_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_daohang_seathot_right_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_daohang_seathot_right_3);
                break;
        }
    }

    
    public void mUpdateWindLeft() {
        int vel = DataCanbus.DATA[31];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_daohang_seatblow_left_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_daohang_seatblow_left_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_daohang_seatblow_left_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_daohang_seatblow_left_3);
                break;
        }
    }

    
    public void mUpdateWindRight() {
        int vel = DataCanbus.DATA[32];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_daohang_seatblow_right_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_daohang_seatblow_right_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_daohang_seatblow_right_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_daohang_seatblow_right_3);
                break;
        }
    }

    
    public void mUpdateSYNC() {
        int vel = DataCanbus.DATA[62];
        findViewById(R.id.air_sp_sync).setBackgroundResource(vel == 0 ? R.drawable.ic_daohang_sync_n : R.drawable.ic_daohang_sync_p);
    }

    
    public void mUpdateAutoRight() {
        int vel = DataCanbus.DATA[26];
        findViewById(R.id.air_sp_auto_right).setBackgroundResource(vel == 0 ? R.drawable.ic_daohang_auto_p : R.drawable.ic_daohang_auto_n);
    }

    
    public void mUpdateAuto() {
        int vel = DataCanbus.DATA[13];
        findViewById(R.id.air_sp_auto).setBackgroundResource(vel == 0 ? R.drawable.ic_daohang_auto_p : R.drawable.ic_daohang_auto_n);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_sp_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_daohang_ac_p : R.drawable.ic_daohang_ac_n);
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        findViewById(R.id.air_sp_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_daohang_rear_n : R.drawable.ic_daohang_rear_p);
    }

    
    public void mUpdateFrontDefrost() {
        int rear = DataCanbus.DATA[65];
        findViewById(R.id.air_sp_front).setBackgroundResource(rear == 0 ? R.drawable.ic_daohang_maxfront_n : R.drawable.ic_daohang_maxfront_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        findViewById(R.id.air_sp_cycle).setBackgroundResource(cycle == 1 ? R.drawable.ic_daohang_cycle_n : R.drawable.ic_daohang_cycle_p);
    }

    
    public void mUpdatePower() {
        int value = DataCanbus.DATA[10];
        findViewById(R.id.air_sp_power).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_power_n : R.drawable.ic_daohang_power_p);
    }

    
    public void mUpdateRearPower() {
        int value = DataCanbus.DATA[42];
        findViewById(R.id.air_sp_power_rear).setBackgroundResource(value == 0 ? R.drawable.ic_daohang_power_n : R.drawable.ic_daohang_power_p);
    }

    
    public void updateBlowBackMode() {
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
        findViewById(R.id.air_sp_rear_mode_foot).setBackgroundResource(R.drawable.ic_air_daohang_mode_rear_foot_p);
        findViewById(R.id.air_sp_rear_mode_body).setBackgroundResource(R.drawable.ic_air_daohang_mode_rear_body_p);
        findViewById(R.id.air_sp_rear_mode_bodyfoot).setBackgroundResource(R.drawable.ic_air_daohang_mode_rear_bodyfoot_p);
        switch (mode2 & 3) {
            case 1:
                findViewById(R.id.air_sp_rear_mode_foot).setBackgroundResource(R.drawable.ic_air_daohang_mode_rear_foot_n);
                break;
            case 2:
                findViewById(R.id.air_sp_rear_mode_body).setBackgroundResource(R.drawable.ic_air_daohang_mode_rear_body_n);
                break;
            case 3:
                findViewById(R.id.air_sp_rear_mode_bodyfoot).setBackgroundResource(R.drawable.ic_air_daohang_mode_rear_bodyfoot_n);
                break;
        }
    }

    
    public void updateBlowModeLeft() {
        int win = DataCanbus.DATA[18];
        int body = DataCanbus.DATA[19];
        int foot = DataCanbus.DATA[20];
        findViewById(R.id.air_sp_mode_up).setBackgroundResource(win == 0 ? R.drawable.ic_air_daohang_mode_left_up_n : R.drawable.ic_air_daohang_mode_left_up_p);
        findViewById(R.id.air_sp_mode_body).setBackgroundResource(body == 0 ? R.drawable.ic_air_daohang_mode_left_body_n : R.drawable.ic_air_daohang_mode_left_body_p);
        findViewById(R.id.air_sp_mode_foot).setBackgroundResource(foot == 0 ? R.drawable.ic_air_daohang_mode_left_foot_n : R.drawable.ic_air_daohang_mode_left_foot_p);
    }

    
    public void updateBlowModeRight() {
        int win = DataCanbus.DATA[22];
        int body = DataCanbus.DATA[23];
        int foot = DataCanbus.DATA[24];
        findViewById(R.id.air_sp_mode_up_right).setBackgroundResource(win == 0 ? R.drawable.ic_air_daohang_mode_right_up_n : R.drawable.ic_air_daohang_mode_right_up_p);
        findViewById(R.id.air_sp_mode_body_right).setBackgroundResource(body == 0 ? R.drawable.ic_air_daohang_mode_right_body_n : R.drawable.ic_air_daohang_mode_right_body_p);
        findViewById(R.id.air_sp_mode_foot_right).setBackgroundResource(foot == 0 ? R.drawable.ic_air_daohang_mode_right_foot_n : R.drawable.ic_air_daohang_mode_right_foot_p);
    }
}
