package com.syu.carinfo.huiteng;

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

public class Huiteng_AirRearCtrl extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    boolean bNeedSend = false;
    int cmdId = -1;
    int touchState = -1;
    Runnable airControl = new Runnable() { 
        @Override
        public void run() {
            Huiteng_AirRearCtrl.this.setAirControl(Huiteng_AirRearCtrl.this.cmdId, 0);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 40:
                    Huiteng_AirRearCtrl.this.mUpdaterAirTempLeft();
                    break;
                case 41:
                    Huiteng_AirRearCtrl.this.mUpdaterAirTempRight();
                    break;
                case 42:
                    Huiteng_AirRearCtrl.this.mUpdaterAirPower();
                    break;
                case 43:
                    Huiteng_AirRearCtrl.this.mUpdaterAirAutoLeft();
                    break;
                case 46:
                    Huiteng_AirRearCtrl.this.mUpdaterAirBlowBodyLeft();
                    break;
                case 47:
                    Huiteng_AirRearCtrl.this.mUpdaterAirBlowFootLeft();
                    break;
                case 48:
                    Huiteng_AirRearCtrl.this.mUpdaterAirBlowUpLeft();
                    break;
                case 81:
                    Huiteng_AirRearCtrl.this.mUpdaterAirAutoRight();
                    break;
                case 82:
                    Huiteng_AirRearCtrl.this.mUpdaterAirBlowBodyRight();
                    break;
                case 83:
                    Huiteng_AirRearCtrl.this.mUpdaterAirBlowFootRight();
                    break;
                case 84:
                    Huiteng_AirRearCtrl.this.mUpdaterAirBlowUpRight();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_439_huiteng_rearair_dj_control);
        init();
    }

    private void init() {
        ((Button) findViewById(R.id.huiteng_rearair_power)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_autoleft)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_autoright)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_templeft_plus_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_templeft_munits_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_tempright_plus_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_tempright_munits_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_foot_left)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_foot_right)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_body_left)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_body_right)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_win_left)).setOnTouchListener(this);
        ((Button) findViewById(R.id.huiteng_rearair_win_right)).setOnTouchListener(this);
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
            case R.id.huiteng_rearair_power /* 2131430063 */:
                this.cmdId = 13;
                break;
            case R.id.huiteng_rearair_templeft_plus_btn /* 2131430064 */:
                this.cmdId = 3;
                break;
            case R.id.huiteng_rearair_templeft_munits_btn /* 2131430066 */:
                this.cmdId = 4;
                break;
            case R.id.huiteng_rearair_win_left /* 2131430067 */:
                this.cmdId = 7;
                break;
            case R.id.huiteng_rearair_win_right /* 2131430068 */:
                this.cmdId = 10;
                break;
            case R.id.huiteng_rearair_body_left /* 2131430069 */:
                this.cmdId = 8;
                break;
            case R.id.huiteng_rearair_body_right /* 2131430070 */:
                this.cmdId = 11;
                break;
            case R.id.huiteng_rearair_foot_left /* 2131430071 */:
                this.cmdId = 9;
                break;
            case R.id.huiteng_rearair_foot_right /* 2131430072 */:
                this.cmdId = 12;
                break;
            case R.id.huiteng_rearair_tempright_plus_btn /* 2131430073 */:
                this.cmdId = 5;
                break;
            case R.id.huiteng_rearair_tempright_munits_btn /* 2131430075 */:
                this.cmdId = 6;
                break;
            case R.id.huiteng_rearair_autoleft /* 2131430076 */:
                this.cmdId = 1;
                break;
            case R.id.huiteng_rearair_autoright /* 2131430077 */:
                this.cmdId = 2;
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
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAirTempLeft() {
        int value = DataCanbus.DATA[40];
        if (((TextView) findViewById(R.id.huiteng_rearair_templeft_tv)) != null) {
            switch (value) {
                case -3:
                    ((TextView) findViewById(R.id.huiteng_rearair_templeft_tv)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.huiteng_rearair_templeft_tv)).setText("LOW");
                    break;
                default:
                    ((TextView) findViewById(R.id.huiteng_rearair_templeft_tv)).setText((value * 0.5f) + "°C");
                    break;
            }
        }
    }

    
    public void mUpdaterAirTempRight() {
        int value = DataCanbus.DATA[41];
        if (((TextView) findViewById(R.id.huiteng_rearair_tempright_tv)) != null) {
            switch (value) {
                case -3:
                    ((TextView) findViewById(R.id.huiteng_rearair_tempright_tv)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.huiteng_rearair_tempright_tv)).setText("LOW");
                    break;
                default:
                    ((TextView) findViewById(R.id.huiteng_rearair_tempright_tv)).setText((value * 0.5f) + "°C");
                    break;
            }
        }
    }

    
    public void mUpdaterAirBlowFootLeft() {
        int value = DataCanbus.DATA[47];
        if (((Button) findViewById(R.id.huiteng_rearair_foot_left)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.huiteng_rearair_foot_left)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.huiteng_rearair_foot_left)).setSelected(true);
            }
        }
    }

    
    public void mUpdaterAirBlowBodyLeft() {
        int value = DataCanbus.DATA[46];
        if (((Button) findViewById(R.id.huiteng_rearair_body_left)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.huiteng_rearair_body_left)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.huiteng_rearair_body_left)).setSelected(true);
            }
        }
    }

    
    public void mUpdaterAirBlowUpLeft() {
        int value = DataCanbus.DATA[48];
        if (((Button) findViewById(R.id.huiteng_rearair_win_left)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.huiteng_rearair_win_left)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.huiteng_rearair_win_left)).setSelected(true);
            }
        }
    }

    
    public void mUpdaterAirBlowFootRight() {
        int value = DataCanbus.DATA[83];
        if (((Button) findViewById(R.id.huiteng_rearair_foot_right)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.huiteng_rearair_foot_right)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.huiteng_rearair_foot_right)).setSelected(true);
            }
        }
    }

    
    public void mUpdaterAirBlowBodyRight() {
        int value = DataCanbus.DATA[82];
        if (((Button) findViewById(R.id.huiteng_rearair_body_right)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.huiteng_rearair_body_right)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.huiteng_rearair_body_right)).setSelected(true);
            }
        }
    }

    
    public void mUpdaterAirBlowUpRight() {
        int value = DataCanbus.DATA[84];
        if (((Button) findViewById(R.id.huiteng_rearair_win_right)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.huiteng_rearair_win_right)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.huiteng_rearair_win_right)).setSelected(true);
            }
        }
    }

    
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[42];
        if (((Button) findViewById(R.id.huiteng_rearair_power)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.huiteng_rearair_power)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.huiteng_rearair_power)).setSelected(true);
            }
        }
    }

    
    public void mUpdaterAirAutoRight() {
        int value = DataCanbus.DATA[81];
        if (((Button) findViewById(R.id.huiteng_rearair_autoright)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.huiteng_rearair_autoright)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.huiteng_rearair_autoright)).setSelected(true);
            }
        }
    }

    
    public void mUpdaterAirAutoLeft() {
        int value = DataCanbus.DATA[43];
        if (((Button) findViewById(R.id.huiteng_rearair_autoleft)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.huiteng_rearair_autoleft)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.huiteng_rearair_autoleft)).setSelected(true);
            }
        }
    }
}
