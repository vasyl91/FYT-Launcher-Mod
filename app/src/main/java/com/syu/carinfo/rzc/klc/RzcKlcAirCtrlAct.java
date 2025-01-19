package com.syu.carinfo.rzc.klc;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;
import com.syu.util.HandlerUI;

public class RzcKlcAirCtrlAct extends Activity implements View.OnTouchListener {
    public static RzcKlcAirCtrlAct mInstance;
    public static boolean mIsFront = false;
    boolean bNeedSend = false;
    int cmdId = -1;
    int touchState = -1;
    Runnable airControl = new Runnable() { 
        @Override
        public void run() {
            RzcKlcAirCtrlAct.this.setAirControl(7, 0);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 32:
                    RzcKlcAirCtrlAct.this.mUpdateAirCycle();
                    break;
                case 33:
                    RzcKlcAirCtrlAct.this.mUpdaterAirRear();
                    break;
                case 34:
                    RzcKlcAirCtrlAct.this.mUpdaterAirAC();
                    break;
                case 37:
                    RzcKlcAirCtrlAct.this.mUpdaterAirTempLeft();
                    break;
                case 38:
                    RzcKlcAirCtrlAct.this.mUpdaterAirTempRight();
                    break;
                case 39:
                case 40:
                case 41:
                    RzcKlcAirCtrlAct.this.mUpdaterAirBLowMode();
                    break;
                case 42:
                    RzcKlcAirCtrlAct.this.mUpdaterAirWindLevel();
                    break;
                case 43:
                    RzcKlcAirCtrlAct.this.mUpdaterAirPower();
                    break;
                case 46:
                    RzcKlcAirCtrlAct.this.mUpdaterAirFront();
                    break;
                case 57:
                    RzcKlcAirCtrlAct.this.mUpdateAirZone();
                    break;
                case 58:
                    RzcKlcAirCtrlAct.this.mUpdateAirAuto();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 196669 || DataCanbus.DATA[1000] == 5111869 || DataCanbus.DATA[1000] == 4784189 || DataCanbus.DATA[1000] == 2555965 || DataCanbus.DATA[1000] == 4849725 || DataCanbus.DATA[1000] == 2687037 || DataCanbus.DATA[1000] == 4063293) {
            //setContentView(R.layout.layout_0061_rzc_gm_junyue_air_control);
        } else {
            //setContentView(R.layout.layout_0061_rzc_gm_all_air_control);
        }
        init();
        mInstance = this;
    }

    private void init() {
        if (DataCanbus.DATA[1000] == 196669 || DataCanbus.DATA[1000] == 5111869 || DataCanbus.DATA[1000] == 4784189 || DataCanbus.DATA[1000] == 2555965 || DataCanbus.DATA[1000] == 4849725 || DataCanbus.DATA[1000] == 2687037 || DataCanbus.DATA[1000] == 4063293) {
            ((Button) findViewById(R.id.air_xts_mode_win)).setOnTouchListener(this);
        } else {
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setOnTouchListener(this);
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setOnTouchListener(this);
        }
        ((Button) findViewById(R.id.air_xts_mode_body)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_foot)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_power)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_ac)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_auto)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_sync)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_cycle)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_front)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_rear)).setOnTouchListener(this);
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
        RzcKlcFunc.CAR_AIR_CONTROL(cmdId, touchState);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                this.cmdId = 4;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                this.cmdId = 5;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                this.cmdId = 26;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                this.cmdId = 7;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                this.cmdId = 6;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                this.cmdId = 2;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                this.cmdId = 3;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                this.cmdId = 12;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                this.cmdId = 1;
                break;
            case R.id.air_xts_sync /* 2131427441 */:
                this.cmdId = 13;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                this.cmdId = 11;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                this.cmdId = 8;
                break;
            case R.id.air_xts_mode_win /* 2131427445 */:
                this.cmdId = 28;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                this.cmdId = 20;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                this.cmdId = 21;
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                this.cmdId = 9;
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                this.cmdId = 10;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                this.cmdId = 27;
                break;
        }
        switch (event.getAction()) {
            case 0:
                this.touchState = 1;
                this.bNeedSend = true;
                setAirControl(7, this.cmdId);
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
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAirBLowMode() {
        int win = DataCanbus.DATA[39];
        int body = DataCanbus.DATA[40];
        int foot = DataCanbus.DATA[41];
        if (DataCanbus.DATA[1000] == 196669 || DataCanbus.DATA[1000] == 5111869 || DataCanbus.DATA[1000] == 4784189 || DataCanbus.DATA[1000] == 2555965 || DataCanbus.DATA[1000] == 4849725 || DataCanbus.DATA[1000] == 2687037 || DataCanbus.DATA[1000] == 4063293) {
            ((Button) findViewById(R.id.air_xts_mode_win)).setSelected(win == 1);
            ((Button) findViewById(R.id.air_xts_mode_body)).setSelected(body == 1);
            ((Button) findViewById(R.id.air_xts_mode_foot)).setSelected(foot == 1);
            return;
        }
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

    
    public void mUpdaterAirFront() {
        int value = DataCanbus.DATA[46];
        if (((Button) findViewById(R.id.air_xts_front)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_front)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_front)).setSelected(true);
            }
        }
    }

    
    public void mUpdaterAirRear() {
        int value = DataCanbus.DATA[33];
        if (((Button) findViewById(R.id.air_xts_rear)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_rear)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_rear)).setSelected(true);
            }
        }
    }

    
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[43];
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_power)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_power)).setSelected(true);
            }
        }
    }

    
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[34];
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_ac)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_ac)).setSelected(true);
            }
        }
    }

    
    public void mUpdateAirAuto() {
        int value = DataCanbus.DATA[58];
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_auto)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_auto)).setSelected(true);
            }
        }
    }

    
    public void mUpdateAirZone() {
        int value = DataCanbus.DATA[57];
        if (((Button) findViewById(R.id.air_xts_sync)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_sync)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_sync)).setSelected(true);
            }
        }
    }

    
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[32];
        if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_cycle)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_cycle)).setSelected(true);
            }
        }
    }

    
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[37];
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp) {
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("None");
                    break;
                case 0:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                case 30:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                default:
                    if (TempUnit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(((temp * 9) / 50) + 32) + "℉");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "℃");
                        break;
                    }
            }
        }
    }

    
    public void mUpdaterAirTempRight() {
        int temp = DataCanbus.DATA[38];
        int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (temp) {
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("None");
                    break;
                case 0:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                    break;
                case 30:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                default:
                    if (TempUnit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(((temp * 9) / 50) + 32) + "℉");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "℃");
                        break;
                    }
            }
        }
    }

    
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[42];
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
    }
}
