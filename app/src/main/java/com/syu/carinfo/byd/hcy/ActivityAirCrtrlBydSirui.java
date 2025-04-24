package com.syu.carinfo.byd.hcy;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityAirCrtrlBydSirui extends Activity implements View.OnTouchListener {
    public static ActivityAirCrtrlBydSirui mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    ActivityAirCrtrlBydSirui.this.mUpdatePowerOn();
                    break;
                case 11:
                    ActivityAirCrtrlBydSirui.this.mUpdateAcOn();
                    break;
                case 12:
                    ActivityAirCrtrlBydSirui.this.mUpdateCycle();
                    break;
                case 13:
                    ActivityAirCrtrlBydSirui.this.mUpdateAutoOn();
                    break;
                case 14:
                    ActivityAirCrtrlBydSirui.this.mUpdaterDualOn();
                    break;
                case 16:
                    ActivityAirCrtrlBydSirui.this.mUpdateRearDefrost();
                    break;
                case 18:
                    ActivityAirCrtrlBydSirui.this.mUpdateFrontDefrost();
                    ActivityAirCrtrlBydSirui.this.updateBtnSource();
                    break;
                case 19:
                case 20:
                    ActivityAirCrtrlBydSirui.this.updateBtnSource();
                    break;
                case 21:
                    ActivityAirCrtrlBydSirui.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    ActivityAirCrtrlBydSirui.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    ActivityAirCrtrlBydSirui.this.mUpdateAirTempRight();
                    break;
                case 29:
                    ActivityAirCrtrlBydSirui.this.uSeatHeatL(value);
                    break;
                case 30:
                    ActivityAirCrtrlBydSirui.this.uSeatHeatR(value);
                    break;
                case 53:
                    ActivityAirCrtrlBydSirui.this.mUpdaterAcMaxOn();
                    break;
                case 65:
                    ActivityAirCrtrlBydSirui.this.mUpdateFrontDefrost();
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
        String platform = SystemProperties.get("ro.fyt.platform", "");
        if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform) || "6318".equals(platform)) {
            if (LauncherApplication.getConfiguration() == 1) {
                //setContentView(R.layout.layout_0439_oudi_byd_sirui_air_control_9853);
            } else {
                //setContentView(R.layout.layout_0439_oudi_byd_sirui_air_control);
            }
        } else {
            //setContentView(R.layout.layout_0439_oudi_byd_sirui_air_control);
        }
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_mode_munits).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        if (findViewById(R.id.air_xts_seathot_left) != null) {
            findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_seathot_right) != null) {
            findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        }
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_sync).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_ac_max).setOnTouchListener(this);
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
        if (DataCanbus.sCanbusId == 9699767 || DataCanbus.sCanbusId == 9765303 || DataCanbus.sCanbusId == 9830839 || DataCanbus.sCanbusId == 9896375 || DataCanbus.sCanbusId == 9961911 || DataCanbus.sCanbusId == 10027447 || DataCanbus.sCanbusId == 10092983) {
            switch (id) {
                case R.id.btn_air_temp_left_plus /* 2131427425 */:
                    data0 = 4;
                    break;
                case R.id.btn_air_temp_left_minus /* 2131427427 */:
                    data0 = 5;
                    break;
                case R.id.air_xts_power /* 2131427428 */:
                    data0 = 1;
                    break;
                case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                    data0 = 3;
                    break;
                case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                    data0 = 2;
                    break;
                case R.id.air_xts_auto /* 2131427436 */:
                    data0 = 8;
                    break;
                case R.id.air_xts_cycle /* 2131427437 */:
                    data0 = 10;
                    break;
                case R.id.air_xts_front /* 2131427438 */:
                    data0 = 11;
                    break;
                case R.id.air_xts_ac /* 2131427439 */:
                    data0 = 13;
                    break;
                case R.id.btn_air_temp_right_plus /* 2131427449 */:
                    data0 = 6;
                    break;
                case R.id.btn_air_temp_right_minus /* 2131427451 */:
                    data0 = 7;
                    break;
                case R.id.air_xts_mode_munits /* 2131427497 */:
                    data0 = 14;
                    break;
                case R.id.air_xts_mode_plus /* 2131427498 */:
                    data0 = 14;
                    break;
                case R.id.air_xts_rear /* 2131427560 */:
                    data0 = 12;
                    break;
                case R.id.air_ac_max /* 2131427823 */:
                    data0 = 15;
                    break;
                case R.id.air_sync /* 2131428338 */:
                    data0 = 9;
                    break;
            }
        } else {
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
                    data0 = 19;
                    break;
                case R.id.air_xts_ac /* 2131427439 */:
                    data0 = 23;
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
                    data0 = 20;
                    break;
                case R.id.air_ac_max /* 2131427823 */:
                    data0 = 22;
                    break;
                case R.id.air_sync /* 2131428338 */:
                    data0 = 16;
                    break;
            }
        }
        if (event.getAction() == 0) {
            sendCmd(data0, 1);
        } else if (event.getAction() == 1) {
            sendCmd(data0, 0);
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NONE");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 0.1f) + "°C");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NONE");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 0.1f) + "°C");
            }
        }
    }

    
    public void mUpdaterAcMaxOn() {
        int acOn = DataCanbus.DATA[53];
        findViewById(R.id.air_ac_max).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
    }

    
    public void mUpdaterDualOn() {
        int acOn = DataCanbus.DATA[14];
        findViewById(R.id.air_sync).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void uSeatHeatR(int val) {
        if (((Button) findViewById(R.id.air_xts_seathot_right)) != null) {
            int i = R.drawable.ic_xts_seathot_right_level0;
            if (val == 1) {
                i = R.drawable.ic_xts_seathot_right_level1;
            } else if (val == 2) {
                i = R.drawable.ic_xts_seathot_right_level2;
            } else if (val == 3) {
                i = R.drawable.ic_xts_seathot_right_level3;
            }
            ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(i);
        }
    }

    
    public void uSeatHeatL(int val) {
        if (((Button) findViewById(R.id.air_xts_seathot_left)) != null) {
            int i = R.drawable.ic_xts_seathot_left_level0;
            if (val == 1) {
                i = R.drawable.ic_xts_seathot_left_level1;
            } else if (val == 2) {
                i = R.drawable.ic_xts_seathot_left_level2;
            } else if (val == 3) {
                i = R.drawable.ic_xts_seathot_left_level3;
            }
            ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(i);
        }
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
        int front = DataCanbus.DATA[18];
        if (DataCanbus.sCanbusId == 9699767 || DataCanbus.sCanbusId == 9765303 || DataCanbus.sCanbusId == 9830839 || DataCanbus.sCanbusId == 9896375 || DataCanbus.sCanbusId == 9961911 || DataCanbus.sCanbusId == 10027447 || DataCanbus.sCanbusId == 10092983) {
            front = DataCanbus.DATA[65];
        }
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
        if (DataCanbus.sCanbusId == 9699767 || DataCanbus.sCanbusId == 9765303 || DataCanbus.sCanbusId == 9830839 || DataCanbus.sCanbusId == 9896375 || DataCanbus.sCanbusId == 9961911 || DataCanbus.sCanbusId == 10027447 || DataCanbus.sCanbusId == 10092983) {
            if (leave >= 7) {
                findViewById(R.id.air_ac_max).setBackgroundResource(R.drawable.ic_xts_maxac_p);
            } else {
                findViewById(R.id.air_ac_max).setBackgroundResource(R.drawable.ic_xts_maxac_n);
            }
        }
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
        if (LauncherApplication.getConfiguration() == 1) {
            switch (mode) {
                case 0:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_null);
                    break;
                case 1:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot);
                    break;
                case 2:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_body);
                    break;
                case 3:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot_body);
                    break;
                case 4:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_win);
                    break;
                case 5:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot_win);
                    break;
                case 6:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_body_win);
                    break;
                case 7:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_all);
                    break;
                default:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_null);
                    break;
            }
        }
        switch (mode) {
            case 0:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                break;
            case 1:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot);
                break;
            case 2:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body);
                break;
            case 3:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
                break;
            case 4:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_win);
                break;
            case 5:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
                break;
            case 6:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body_win);
                break;
            case 7:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body_win);
                break;
            default:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                break;
        }
    }
}
