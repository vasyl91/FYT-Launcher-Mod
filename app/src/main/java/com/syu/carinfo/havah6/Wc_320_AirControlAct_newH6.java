package com.syu.carinfo.havah6;

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

@SuppressWarnings({"deprecation", "unchecked"})
public class Wc_320_AirControlAct_newH6 extends Activity implements View.OnTouchListener {
    public static Wc_320_AirControlAct_newH6 mInstance;
    public static boolean mIsFront = false;
    int down;
    int up;
    int win;
    boolean bNeedSend = false;
    int cmdId = -1;
    int touchState = -1;
    Runnable airControl = new Runnable() { 
        @Override
        public void run() {
            Wc_320_AirControlAct_newH6.this.setAirControl(Wc_320_AirControlAct_newH6.this.cmdId, 0);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 4:
                    Wc_320_AirControlAct_newH6.this.mUpdateAirAuto();
                    break;
                case 5:
                    Wc_320_AirControlAct_newH6.this.mUpdateAirCycle();
                    break;
                case 6:
                    Wc_320_AirControlAct_newH6.this.mUpdateAirFrontDefrost();
                    break;
                case 7:
                    Wc_320_AirControlAct_newH6.this.mUpdateAirRearDefrost();
                    break;
                case 8:
                    Wc_320_AirControlAct_newH6.this.mUpdaterAirAC();
                    break;
                case 9:
                case 10:
                case 14:
                    Wc_320_AirControlAct_newH6.this.mUpdaterAirBLowMode();
                    break;
                case 11:
                    Wc_320_AirControlAct_newH6.this.mUpdaterAirWindLevel();
                    break;
                case 12:
                    Wc_320_AirControlAct_newH6.this.mUpdateAirDual();
                    break;
                case 13:
                    Wc_320_AirControlAct_newH6.this.mUpdaterAirPower();
                    break;
                case 27:
                    Wc_320_AirControlAct_newH6.this.mUpdaterAirTempLeft();
                    break;
                case 28:
                    Wc_320_AirControlAct_newH6.this.mUpdaterAirTempRight();
                    break;
                case 65:
                    Wc_320_AirControlAct_newH6.this.mUpdateAirSeatHotLeft();
                    break;
                case 66:
                    Wc_320_AirControlAct_newH6.this.mUpdateAirSeatHotRight();
                    break;
                case 67:
                    Wc_320_AirControlAct_newH6.this.mUpdaterSeatBlowLeft();
                    break;
                case 68:
                    Wc_320_AirControlAct_newH6.this.mUpdaterSeatBlowRight();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_320_haval_air_h6_control);
        init();
        mInstance = this;
    }

    private void init() {
        ((Button) findViewById(R.id.air_xts_power)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_ac)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_auto)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_dual)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_cycle)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_front)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_rear)).setOnTouchListener(this);
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
        DataCanbus.PROXY.cmd(4, cmdId, touchState);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                this.cmdId = 13;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                this.cmdId = 14;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                this.cmdId = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                this.cmdId = 12;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                this.cmdId = 11;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                this.cmdId = 17;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                this.cmdId = 18;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                this.cmdId = 4;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                this.cmdId = 7;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                this.cmdId = 5;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                this.cmdId = 2;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                this.cmdId = 29;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                this.cmdId = 26;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                this.cmdId = 15;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                this.cmdId = 16;
                break;
            case R.id.air_xts_seatwin_left /* 2131427452 */:
                this.cmdId = 23;
                break;
            case R.id.air_xts_seatwin_right /* 2131427454 */:
                this.cmdId = 24;
                break;
            case R.id.air_xts_dual /* 2131427460 */:
                this.cmdId = 41;
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                this.cmdId = 27;
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                this.cmdId = 28;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                this.cmdId = 6;
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
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAirBLowMode() {
        int up = DataCanbus.DATA[10];
        int win = DataCanbus.DATA[14];
        int down = DataCanbus.DATA[9];
        if (((Button) findViewById(R.id.air_xts_mode_body)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        }
        if (((Button) findViewById(R.id.air_xts_mode_footbody)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        }
        if (((Button) findViewById(R.id.air_xts_mode_foot)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        }
        if (((Button) findViewById(R.id.air_xts_mode_footwin)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        }
        if (((Button) findViewById(R.id.air_xts_mode_foot)) != null && ((Button) findViewById(R.id.air_xts_mode_footbody)) != null && ((Button) findViewById(R.id.air_xts_mode_footwin)) != null) {
            if (up == 1 && down == 0 && win == 0) {
                ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
                return;
            }
            if (up == 1 && down == 1 && win == 0) {
                ((Button) findViewById(R.id.air_xts_mode_footbody)).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
                return;
            }
            if (up == 0 && down == 1 && win == 0) {
                ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
            } else if (up == 0 && down == 1 && win == 1) {
                ((Button) findViewById(R.id.air_xts_mode_footwin)).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
            }
        }
    }

    
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[13];
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_power)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_power)).setSelected(true);
            }
        }
    }

    
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[8];
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_ac)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_ac)).setSelected(true);
            }
        }
    }

    
    public void mUpdateAirAuto() {
        int value = DataCanbus.DATA[4];
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_auto)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_auto)).setSelected(true);
            }
        }
    }

    
    public void mUpdateAirDual() {
        int value = DataCanbus.DATA[12];
        if (((Button) findViewById(R.id.air_xts_dual)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_dual)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_dual)).setSelected(true);
            }
        }
    }

    
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[5];
        if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_cycle)).setSelected(true);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_cycle)).setSelected(false);
            }
        }
    }

    
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                case -1:
                default:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "℃");
                    break;
                case 0:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NO");
                    break;
            }
        }
    }

    
    public void mUpdaterAirTempRight() {
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                    break;
                case -1:
                default:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "℃");
                    break;
                case 0:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NO");
                    break;
            }
        }
    }

    
    public void mUpdateAirFrontDefrost() {
        int value = DataCanbus.DATA[6];
        if (((Button) findViewById(R.id.air_xts_front)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_front)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_front)).setSelected(true);
            }
        }
    }

    
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[7];
        if (((Button) findViewById(R.id.air_xts_rear)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_rear)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_rear)).setSelected(true);
            }
        }
    }

    
    public void mUpdaterSeatBlowRight() {
        int value = DataCanbus.DATA[68];
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
        int value = DataCanbus.DATA[67];
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

    
    public void mUpdateAirSeatHotLeft() {
        int value = DataCanbus.DATA[65];
        if (((Button) findViewById(R.id.air_xts_seathot_left)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                return;
            }
            if (value == 1) {
                ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
            } else if (value == 2) {
                ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
            } else if (value == 3) {
                ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
            }
        }
    }

    
    public void mUpdateAirSeatHotRight() {
        int value = DataCanbus.DATA[66];
        if (((Button) findViewById(R.id.air_xts_seathot_right)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                return;
            }
            if (value == 1) {
                ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
            } else if (value == 2) {
                ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
            } else if (value == 3) {
                ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
            }
        }
    }

    
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[11];
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
    }
}
