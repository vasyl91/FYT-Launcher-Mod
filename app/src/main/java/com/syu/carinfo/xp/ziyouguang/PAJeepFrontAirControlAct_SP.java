package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class PAJeepFrontAirControlAct_SP extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    PAJeepFrontAirControlAct_SP.this.mUpdatePowerOn();
                    break;
                case 11:
                    PAJeepFrontAirControlAct_SP.this.mUpdateAcOn();
                    break;
                case 12:
                    PAJeepFrontAirControlAct_SP.this.mUpdateCycle();
                    break;
                case 13:
                    PAJeepFrontAirControlAct_SP.this.mUpdateAutoOn();
                    break;
                case 16:
                    PAJeepFrontAirControlAct_SP.this.mUpdateRearDefrost();
                    break;
                case 18:
                case 19:
                case 20:
                    PAJeepFrontAirControlAct_SP.this.updateBtnSource();
                    break;
                case 21:
                    PAJeepFrontAirControlAct_SP.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    PAJeepFrontAirControlAct_SP.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    PAJeepFrontAirControlAct_SP.this.mUpdateAirTempRight();
                    break;
                case 29:
                    PAJeepFrontAirControlAct_SP.this.mUpdaterSeatHeatLeft();
                    break;
                case 30:
                    PAJeepFrontAirControlAct_SP.this.mUpdaterSeatHeatRight();
                    break;
                case 31:
                    PAJeepFrontAirControlAct_SP.this.mUpdaterSeatBlowLeft();
                    break;
                case 32:
                    PAJeepFrontAirControlAct_SP.this.mUpdaterSeatBlowRight();
                    break;
                case 37:
                    PAJeepFrontAirControlAct_SP.this.mUpdateAirTempLeft();
                    PAJeepFrontAirControlAct_SP.this.mUpdateAirTempRight();
                    break;
                case 53:
                    PAJeepFrontAirControlAct_SP.this.mUpdateMaxAcOn();
                    break;
                case 62:
                    PAJeepFrontAirControlAct_SP.this.mUpdateSyncOn();
                    break;
                case 65:
                    PAJeepFrontAirControlAct_SP.this.mUpdateFrontDefrost();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(6, new int[]{data0, data1}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String platform = SystemProperties.get("ro.fyt.platform", "");
        if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform) || "6318".equals(platform)) {
            //setContentView(R.layout.layout_0374_pa_wrangler_air_control_9853);
        } else {
            //setContentView(R.layout.layout_0374_pa_wrangler_air_control_9853);
        }
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_maxac).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearpage).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_sync).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_right).setOnTouchListener(this);
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
        boolean flag = false;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 4;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 5;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 16;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 7;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 6;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data0 = 17;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                data0 = 18;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 2;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 3;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 12;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 1;
                break;
            case R.id.air_xts_maxac /* 2131427440 */:
                data0 = 15;
                break;
            case R.id.air_xts_sync /* 2131427441 */:
                data0 = 13;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data0 = 10;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 8;
                break;
            case R.id.air_xts_rearpage /* 2131427448 */:
                flag = true;
                try {
                    startActivity(new Intent(this, (Class<?>) PAJeepRearAirControlAct_SP.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 20;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 21;
                break;
            case R.id.air_xts_seatwin_left /* 2131427452 */:
                data0 = 22;
                break;
            case R.id.air_xts_seatwin_right /* 2131427454 */:
                data0 = 23;
                break;
            case R.id.air_xts_mode_footbody /* 2131427502 */:
                data0 = 9;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                data0 = 14;
                break;
            case R.id.air_xts_mode_footwin /* 2131427632 */:
                data0 = 11;
                break;
        }
        if (!flag && event.getAction() == 0) {
            sendCmd(1, data0);
            return false;
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterSeatBlowRight() {
        int value = DataCanbus.DATA[32];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level1);
                break;
            case 2:
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level2);
                break;
            case 3:
                findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level3);
                break;
        }
    }

    
    public void mUpdaterSeatBlowLeft() {
        int value = DataCanbus.DATA[31];
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level1);
                break;
            case 2:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level2);
                break;
            case 3:
                findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level3);
                break;
        }
    }

    
    public void mUpdaterSeatHeatRight() {
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

    
    public void mUpdaterSeatHeatLeft() {
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

    
    public void mUpdateMaxAcOn() {
        int power = DataCanbus.DATA[53];
        findViewById(R.id.air_xts_maxac).setBackgroundResource(power == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
    }

    
    public void mUpdateAirTempLeft() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("High");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("---");
                return;
            }
            if (unit == 0) {
                if (temp >= 30 && temp <= 128) {
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 0.5f) + "℃");
                    return;
                } else {
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("---");
                    return;
                }
            }
            if (temp >= 30 && temp <= 128) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(temp + "℉");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("---");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("High");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("---");
                return;
            }
            if (unit == 0) {
                if (temp >= 30 && temp <= 128) {
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 0.5f) + "℃");
                    return;
                } else {
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("---");
                    return;
                }
            }
            if (temp >= 30 && temp <= 128) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(temp + "℉");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("---");
            }
        }
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateSyncOn() {
        int acOn = DataCanbus.DATA[62];
        findViewById(R.id.air_xts_sync).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        }
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[65];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        if (leave < 0) {
            leave = 0;
        }
        if (leave > 8) {
            leave = 8;
        }
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
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
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        switch (mode) {
            case 1:
                findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
                break;
            case 2:
                findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
                break;
            case 3:
                findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
                break;
            case 5:
                findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
                break;
        }
    }
}
