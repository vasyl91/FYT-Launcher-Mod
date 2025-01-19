package com.syu.carinfo.aiying.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class JeepCarAirSet extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    JeepCarAirSet.this.mUpdaterAirPower();
                    break;
                case 11:
                    JeepCarAirSet.this.mUpdaterAirAC();
                    break;
                case 12:
                    JeepCarAirSet.this.mUpdateAirCycle();
                    break;
                case 13:
                    JeepCarAirSet.this.mUpdateAirAuto();
                    break;
                case 15:
                    JeepCarAirSet.this.mUpdateAirGoFog();
                    break;
                case 16:
                    JeepCarAirSet.this.mUpdateAirRearDefrost();
                    break;
                case 18:
                case 19:
                case 20:
                    JeepCarAirSet.this.updateBtnSource();
                    break;
                case 21:
                    JeepCarAirSet.this.mUpdaterAirWindLevel();
                    break;
                case 27:
                    JeepCarAirSet.this.mUpdaterAirTempLeft();
                    break;
                case 28:
                    JeepCarAirSet.this.mUpdaterAirTempRight();
                    break;
                case 29:
                    JeepCarAirSet.this.mUpdaterAirSeatHeatLeft();
                    break;
                case 30:
                    JeepCarAirSet.this.mUpdaterAirSeatHeatRight();
                    break;
                case 62:
                    JeepCarAirSet.this.mUpdateAirSYNC();
                    break;
                case 65:
                    JeepCarAirSet.this.mUpdateAirFrontDefrost();
                    break;
                case 67:
                    JeepCarAirSet.this.mUpdaterAirDimRear();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0365_aiying_jeep_carairset);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_seathot_left).setOnClickListener(this);
        findViewById(R.id.air_xts_auto).setOnClickListener(this);
        findViewById(R.id.air_xts_sync).setOnClickListener(this);
        findViewById(R.id.air_xts_cycle).setOnClickListener(this);
        findViewById(R.id.air_xts_power).setOnClickListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnClickListener(this);
        findViewById(R.id.air_xts_rearlock).setOnClickListener(this);
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
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                DataCanbus.PROXY.cmd(2, new int[]{7}, null, null);
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                DataCanbus.PROXY.cmd(2, new int[]{8}, null, null);
                break;
            case R.id.air_xts_power /* 2131427428 */:
                DataCanbus.PROXY.cmd(2, new int[]{16}, null, null);
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                DataCanbus.PROXY.cmd(2, new int[]{6}, null, null);
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                DataCanbus.PROXY.cmd(2, new int[]{5}, null, null);
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                DataCanbus.PROXY.cmd(2, new int[]{19}, null, null);
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                DataCanbus.PROXY.cmd(2, new int[]{20}, null, null);
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                DataCanbus.PROXY.cmd(2, new int[]{13}, null, null);
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                DataCanbus.PROXY.cmd(2, new int[]{12}, null, null);
                break;
            case R.id.air_xts_front /* 2131427438 */:
                DataCanbus.PROXY.cmd(2, new int[]{14}, null, null);
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                DataCanbus.PROXY.cmd(2, new int[]{11}, null, null);
                break;
            case R.id.air_xts_maxac /* 2131427440 */:
                DataCanbus.PROXY.cmd(2, new int[]{18}, null, null);
                break;
            case R.id.air_xts_sync /* 2131427441 */:
                DataCanbus.PROXY.cmd(2, new int[]{17}, null, null);
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                DataCanbus.PROXY.cmd(2, new int[]{3}, null, null);
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
                break;
            case R.id.air_xts_rearlock /* 2131427446 */:
                DataCanbus.PROXY.cmd(2, new int[]{21}, null, null);
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                DataCanbus.PROXY.cmd(2, new int[]{9}, null, null);
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                DataCanbus.PROXY.cmd(2, new int[]{10}, null, null);
                break;
            case R.id.air_xts_mode_footbody /* 2131427502 */:
                DataCanbus.PROXY.cmd(2, new int[]{2}, null, null);
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                DataCanbus.PROXY.cmd(2, new int[]{15}, null, null);
                break;
            case R.id.air_xts_mode_footwin /* 2131427632 */:
                DataCanbus.PROXY.cmd(2, new int[]{4}, null, null);
                break;
        }
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp) {
                case 1:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LO");
                    break;
                case 255:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                default:
                    if (temp >= 14 && temp <= 30) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(temp + "℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NO");
                        break;
                    }
            }
        }
    }

    
    public void mUpdaterAirTempRight() {
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (temp) {
                case 1:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LO");
                    break;
                case 255:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                default:
                    if (temp >= 14 && temp <= 30) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(temp + "℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NO");
                        break;
                    }
            }
        }
    }

    
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[21];
        if (level == 8) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText("A");
        } else if (level < 8) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
        }
    }

    
    public void mUpdateAirGoFog() {
        int value = DataCanbus.DATA[15];
        findViewById(R.id.air_xts_maxac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
    }

    
    public void mUpdateAirAuto() {
        int value = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateAirSYNC() {
        int value = DataCanbus.DATA[62];
        findViewById(R.id.air_xts_sync).setBackgroundResource(value == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
    }

    
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[12];
        findViewById(R.id.air_xts_cycle).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_n : R.drawable.ic_xts_cycle_p);
    }

    
    public void mUpdaterAirDimRear() {
        int value = DataCanbus.DATA[67];
        findViewById(R.id.air_xts_rearlock).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rearlock_n : R.drawable.ic_xts_rearlock_p);
    }

    
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdateAirFrontDefrost() {
        int value = DataCanbus.DATA[65];
        findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    
    public void updateBtnSource() {
        int window = DataCanbus.DATA[18];
        int foot = DataCanbus.DATA[20];
        int body = DataCanbus.DATA[19];
        if (window == 0 && body == 1 && foot == 1) {
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
        } else {
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        }
        if (window == 0 && body == 0 && foot == 1) {
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
        } else {
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        }
        if (window == 0 && body == 1 && foot == 0) {
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
        } else {
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        }
        if (window == 1 && body == 0 && foot == 1) {
            findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
        } else {
            findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        }
        if (window == 1 && body == 0 && foot == 0) {
            findViewById(R.id.air_xts_mode_win).setBackgroundResource(R.drawable.ic_xts_mode_win_p);
        } else {
            findViewById(R.id.air_xts_mode_win).setBackgroundResource(R.drawable.ic_xts_mode_win_n);
        }
    }

    
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
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
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
                break;
            case 3:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                break;
        }
    }

    
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
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
                break;
            case 3:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                break;
        }
    }
}
