package com.syu.carinfo.rzc.havalh6;

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
import com.syu.util.HandlerUI;

public class Rzc_H6_0439_AirFrontCtrl_HP extends Activity implements View.OnTouchListener {
    public static Rzc_H6_0439_AirFrontCtrl_HP mInstance;
    public static boolean mIsFront = false;
    boolean bNeedSend = false;
    int cmdId = -1;
    int touchState = -1;
    Runnable airControl = new Runnable() { 
        @Override
        public void run() {
            Rzc_H6_0439_AirFrontCtrl_HP.this.setAirControl(Rzc_H6_0439_AirFrontCtrl_HP.this.cmdId, 0);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    Rzc_H6_0439_AirFrontCtrl_HP.this.mUpdaterAirPower();
                    break;
                case 11:
                    Rzc_H6_0439_AirFrontCtrl_HP.this.mUpdaterAirAC();
                    break;
                case 12:
                    Rzc_H6_0439_AirFrontCtrl_HP.this.mUpdateAirCycle();
                    break;
                case 14:
                    Rzc_H6_0439_AirFrontCtrl_HP.this.mUpdateAirAuto();
                    break;
                case 15:
                    Rzc_H6_0439_AirFrontCtrl_HP.this.mUpdateAirZone();
                    break;
                case 18:
                case 19:
                case 20:
                    Rzc_H6_0439_AirFrontCtrl_HP.this.mUpdaterAirBLowMode();
                    break;
                case 21:
                    Rzc_H6_0439_AirFrontCtrl_HP.this.mUpdaterAirWindLevel();
                    break;
                case 22:
                    Rzc_H6_0439_AirFrontCtrl_HP.this.mUpdaterAirTempLeft();
                    break;
                case 23:
                    Rzc_H6_0439_AirFrontCtrl_HP.this.mUpdaterAirTempRight();
                    break;
                case 30:
                    Rzc_H6_0439_AirFrontCtrl_HP.this.mUpdaterSeatHeatLeft(value);
                    break;
                case 31:
                    Rzc_H6_0439_AirFrontCtrl_HP.this.mUpdaterSeatHeatRight(value);
                    break;
                case 62:
                    Rzc_H6_0439_AirFrontCtrl_HP.this.mUpdaterSeatBlowLeft(value);
                    break;
                case 63:
                    Rzc_H6_0439_AirFrontCtrl_HP.this.mUpdaterSeatBlowRight(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_439_haval_airfront_h6_control_hp);
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
        ((Button) findViewById(R.id.air_xts_mode_body)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_footbody)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_footwin)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_foot)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_win)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_seathot_left)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_seathot_right)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_seatwin_left)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_seatwin_right)).setOnTouchListener(this);
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

    
    public void setAirControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(0, cmdId, touchState);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int flag = 0;
        int id = v.getId();
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
                if (event.getAction() == 0) {
                    int value = DataCanbus.DATA[30] + 1;
                    if (value > 3) {
                        value = 0;
                    }
                    this.cmdId = 44;
                    setAirControl(this.cmdId, value);
                }
                flag = 1;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                if (event.getAction() == 0) {
                    int value2 = DataCanbus.DATA[31] + 1;
                    if (value2 > 3) {
                        value2 = 0;
                    }
                    this.cmdId = 45;
                    setAirControl(this.cmdId, value2);
                }
                flag = 1;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                this.cmdId = 34;
                break;
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
            case R.id.air_xts_mode_win /* 2131427445 */:
                this.cmdId = 21;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                this.cmdId = 32;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                this.cmdId = 33;
                break;
            case R.id.air_xts_seatwin_left /* 2131427452 */:
                if (event.getAction() == 0) {
                    int value3 = DataCanbus.DATA[62] + 1;
                    if (value3 > 3) {
                        value3 = 0;
                    }
                    this.cmdId = 46;
                    setAirControl(this.cmdId, value3);
                }
                flag = 1;
                break;
            case R.id.air_xts_seatwin_right /* 2131427454 */:
                if (event.getAction() == 0) {
                    int value4 = DataCanbus.DATA[63] + 1;
                    if (value4 > 3) {
                        value4 = 0;
                    }
                    this.cmdId = 47;
                    setAirControl(this.cmdId, value4);
                }
                flag = 1;
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                this.cmdId = 25;
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                this.cmdId = 27;
                break;
            case R.id.air_xts_zone /* 2131428027 */:
                this.cmdId = 35;
                break;
        }
        if (flag == 0) {
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
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterSeatHeatRight(int value) {
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

    
    public void mUpdaterSeatBlowRight(int value) {
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

    
    public void mUpdaterSeatHeatLeft(int value) {
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

    
    public void mUpdaterSeatBlowLeft(int value) {
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

    
    public void mUpdaterAirBLowMode() {
        int win = DataCanbus.DATA[18];
        int body = DataCanbus.DATA[19];
        int foot = DataCanbus.DATA[20];
        if (win == 1 && foot == 1 && body == 0) {
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setSelected(true);
            ((Button) findViewById(R.id.air_xts_mode_body)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_foot)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_win)).setSelected(false);
            return;
        }
        if (win == 0 && foot == 1 && body == 0) {
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_body)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_foot)).setSelected(true);
            ((Button) findViewById(R.id.air_xts_mode_win)).setSelected(false);
            return;
        }
        if (win == 0 && foot == 1 && body == 1) {
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_body)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setSelected(true);
            ((Button) findViewById(R.id.air_xts_mode_foot)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_win)).setSelected(false);
            return;
        }
        if (win == 0 && foot == 0 && body == 1) {
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_body)).setSelected(true);
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_foot)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_win)).setSelected(false);
            return;
        }
        if (win == 1 && foot == 0 && body == 0) {
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_body)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_foot)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_win)).setSelected(true);
        }
    }

    
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

    
    public void mUpdateAirZone() {
        int value = DataCanbus.DATA[15];
        if (((Button) findViewById(R.id.air_xts_zone)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_zone)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_zone)).setSelected(true);
            }
        }
    }

    
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
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText(((((temp - 116) * 5) + 180) / 10.0f) + "℃");
                    break;
            }
        }
    }

    
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
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText(((((temp - 116) * 5) + 180) / 10.0f) + "℃");
                    break;
            }
        }
    }

    
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[21];
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
    }
}
