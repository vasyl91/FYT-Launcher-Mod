package com.syu.carinfo.rzc.havalh6;

import android.app.Activity;
import android.content.Intent;
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

public class Rzc_Oudi_0439_AirRearCtrl_HP extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    boolean bNeedSend = false;
    int cmdId = -1;
    int touchState = -1;
    Runnable airControl = new Runnable() { 
        @Override
        public void run() {
            Rzc_Oudi_0439_AirRearCtrl_HP.this.setAirControl(Rzc_Oudi_0439_AirRearCtrl_HP.this.cmdId, 0);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            if (DataCanbus.DATA[1000] == 16384439) {
                switch (updateCode) {
                    case 40:
                        Rzc_Oudi_0439_AirRearCtrl_HP.this.mUpdaterAirTempRear(value);
                        break;
                    case 42:
                        Rzc_Oudi_0439_AirRearCtrl_HP.this.mUpdaterAirPower(value);
                        break;
                    case 43:
                        Rzc_Oudi_0439_AirRearCtrl_HP.this.mUpdateAirAuto(value);
                        break;
                    case 44:
                        Rzc_Oudi_0439_AirRearCtrl_HP.this.mUpdaterAirWindLevel(value);
                        break;
                    case 46:
                    case 47:
                        Rzc_Oudi_0439_AirRearCtrl_HP.this.mUpdaterAirBLowMode();
                        break;
                }
            }
            switch (updateCode) {
                case 40:
                    Rzc_Oudi_0439_AirRearCtrl_HP.this.mUpdaterAirTempRear(value);
                    break;
                case 42:
                    Rzc_Oudi_0439_AirRearCtrl_HP.this.mUpdaterAirPower(value);
                    break;
                case 43:
                    Rzc_Oudi_0439_AirRearCtrl_HP.this.mUpdateAirAuto(value);
                    break;
                case 44:
                    Rzc_Oudi_0439_AirRearCtrl_HP.this.mUpdaterAirWindLevel(value);
                    break;
                case 46:
                case 47:
                    Rzc_Oudi_0439_AirRearCtrl_HP.this.mUpdaterAirBLowMode();
                    break;
                case 88:
                    switch (value) {
                        case 0:
                            Rzc_Oudi_0439_AirRearCtrl_HP.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                            break;
                        case 1:
                            Rzc_Oudi_0439_AirRearCtrl_HP.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                            break;
                        case 2:
                            Rzc_Oudi_0439_AirRearCtrl_HP.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
                            break;
                        case 3:
                            Rzc_Oudi_0439_AirRearCtrl_HP.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_439_haval_airrear_h9_control_hp);
        init();
    }

    private void init() {
        ((Button) findViewById(R.id.air_xts_frontpage)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rzc_Oudi_0439_AirRearCtrl_HP.this, Rzc_Oudi_0439_AirFrontCtrl_HP.class);
                    Rzc_Oudi_0439_AirRearCtrl_HP.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.air_xts_power)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_auto)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_body)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_footbody)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_foot)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_seathot_left)).setOnTouchListener(this);
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
        if (DataCanbus.DATA[1000] == 16384439) {
            DataCanbus.PROXY.cmd(2, cmdId, touchState);
        } else {
            DataCanbus.PROXY.cmd(3, cmdId, touchState);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343 || DataCanbus.DATA[1000] == 11796934 || DataCanbus.DATA[1000] == 11862470) {
                    this.cmdId = 133;
                    break;
                } else if (DataCanbus.DATA[1000] == 16384439) {
                    this.cmdId = 34;
                    break;
                } else {
                    this.cmdId = 30;
                    break;
                }
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343 || DataCanbus.DATA[1000] == 11796934 || DataCanbus.DATA[1000] == 11862470) {
                    this.cmdId = 134;
                    break;
                } else if (DataCanbus.DATA[1000] == 16384439) {
                    this.cmdId = 33;
                    break;
                } else {
                    this.cmdId = 31;
                    break;
                }
            case R.id.air_xts_power /* 2131427428 */:
                if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343 || DataCanbus.DATA[1000] == 11796934 || DataCanbus.DATA[1000] == 11862470) {
                    this.cmdId = 129;
                    break;
                } else if (DataCanbus.DATA[1000] == 16384439) {
                    this.cmdId = 32;
                    break;
                } else {
                    this.cmdId = 16;
                    break;
                }
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343 || DataCanbus.DATA[1000] == 11796934 || DataCanbus.DATA[1000] == 11862470) {
                    this.cmdId = 132;
                    break;
                } else if (DataCanbus.DATA[1000] == 16384439) {
                    this.cmdId = 35;
                    break;
                } else {
                    this.cmdId = 29;
                    break;
                }
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343 || DataCanbus.DATA[1000] == 11796934 || DataCanbus.DATA[1000] == 11862470) {
                    this.cmdId = 131;
                    break;
                } else if (DataCanbus.DATA[1000] == 16384439) {
                    this.cmdId = 36;
                    break;
                } else {
                    this.cmdId = 28;
                    break;
                }
            case R.id.air_xts_seathot_left /* 2131427433 */:
                if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343 || DataCanbus.DATA[1000] == 11796934 || DataCanbus.DATA[1000] == 11862470) {
                    this.cmdId = 138;
                    break;
                } else {
                    this.cmdId = 32;
                    break;
                }
            case R.id.air_xts_auto /* 2131427436 */:
                if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343 || DataCanbus.DATA[1000] == 11796934 || DataCanbus.DATA[1000] == 11862470) {
                    this.cmdId = 130;
                    break;
                } else if (DataCanbus.DATA[1000] == 16384439) {
                    this.cmdId = 37;
                    break;
                } else {
                    this.cmdId = 18;
                    break;
                }
            case R.id.air_xts_mode_foot /* 2131427443 */:
                if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343 || DataCanbus.DATA[1000] == 11796934 || DataCanbus.DATA[1000] == 11862470) {
                    this.cmdId = 137;
                    break;
                } else if (DataCanbus.DATA[1000] == 16384439) {
                    this.cmdId = 39;
                    break;
                } else {
                    this.cmdId = 26;
                    break;
                }
            case R.id.air_xts_mode_body /* 2131427444 */:
                if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343 || DataCanbus.DATA[1000] == 11796934 || DataCanbus.DATA[1000] == 11862470) {
                    this.cmdId = 135;
                    break;
                } else if (DataCanbus.DATA[1000] == 16384439) {
                    this.cmdId = 38;
                    break;
                } else {
                    this.cmdId = 24;
                    break;
                }
            case R.id.air_xts_mode_footbody /* 2131427502 */:
                if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343 || DataCanbus.DATA[1000] == 11796934 || DataCanbus.DATA[1000] == 11862470) {
                    this.cmdId = 136;
                    break;
                } else if (DataCanbus.DATA[1000] == 16384439) {
                    this.cmdId = 40;
                    break;
                } else {
                    this.cmdId = 25;
                    break;
                }
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
            return false;
        }
        return false;
    }

    private void addUpdater() {
        if (DataCanbus.DATA[1000] == 16384439) {
            DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        if (DataCanbus.DATA[1000] == 16384439) {
            DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAirBLowMode() {
        int body = DataCanbus.DATA[46];
        int foot = DataCanbus.DATA[47];
        if (DataCanbus.DATA[1000] == 16384439) {
            body = DataCanbus.DATA[46];
            foot = DataCanbus.DATA[47];
        }
        if (foot == 1 && body == 0) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_foot)).setSelected(true);
        } else if (foot == 1 && body == 1) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setSelected(true);
            ((Button) findViewById(R.id.air_xts_mode_foot)).setSelected(false);
        } else if (foot == 0 && body == 1) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setSelected(true);
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setSelected(false);
            ((Button) findViewById(R.id.air_xts_mode_foot)).setSelected(false);
        }
    }

    
    public void mUpdaterAirPower(int value) {
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_power)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_power)).setSelected(true);
            }
        }
    }

    
    public void mUpdateAirAuto(int value) {
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_auto)).setSelected(false);
            } else if (value == 1) {
                ((Button) findViewById(R.id.air_xts_auto)).setSelected(true);
            }
        }
    }

    
    public void mUpdaterAirTempRear(int temp) {
        int temp2;
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                default:
                    if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 2556343 || DataCanbus.DATA[1000] == 11796934 || DataCanbus.DATA[1000] == 11862470) {
                        temp2 = ((temp - 116) * 5) + 180;
                    } else if (DataCanbus.DATA[1000] == 16384439) {
                        temp2 = (temp * 5) + 160;
                    } else {
                        temp2 = ((temp - 116) * 5) + 160;
                    }
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp2 / 10.0f) + "℃");
                    break;
            }
        }
    }

    
    public void mUpdaterAirWindLevel(int level) {
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
    }
}
