package com.syu.carinfo.rzc.changan_cx70;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class RzcChanganCOSAirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 5:
                    RzcChanganCOSAirControlAct.this.mUpdateAutoOn();
                    break;
                case 6:
                    RzcChanganCOSAirControlAct.this.mUpdateCycle();
                    break;
                case 7:
                    RzcChanganCOSAirControlAct.this.mUpdateFrontDefrost();
                    break;
                case 8:
                    RzcChanganCOSAirControlAct.this.mUpdateRearDefrost();
                    break;
                case 9:
                    RzcChanganCOSAirControlAct.this.mUpdateAcOn();
                    break;
                case 10:
                    RzcChanganCOSAirControlAct.this.mUpdateAirTempLeft();
                    RzcChanganCOSAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 11:
                case 12:
                    RzcChanganCOSAirControlAct.this.updateBtnSource();
                    break;
                case 13:
                    RzcChanganCOSAirControlAct.this.mUpdateFrontDefrost();
                    RzcChanganCOSAirControlAct.this.updateBtnSource();
                    break;
                case 14:
                    RzcChanganCOSAirControlAct.this.mUpdaterAirWindLevelLeft();
                    RzcChanganCOSAirControlAct.this.mUpdatePowerOn();
                    break;
                case 16:
                    RzcChanganCOSAirControlAct.this.mUpdateRearOn();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1, int data2, int data3, int data4, int data5) {
        DataCanbus.PROXY.cmd(2, new int[]{data0, data1, data2, data3, data4, data5}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_rzc_changan_cos_control);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear_light).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
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
        int data1 = 0;
        int data2 = 0;
        int data3 = 0;
        int data5 = 0;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data3 = 2;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data3 = 1;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 128;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data1 = 1;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data1 = 2;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 32;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                if (DataCanbus.DATA[6] == 1) {
                    data0 = 8;
                    break;
                } else {
                    data0 = 4;
                    break;
                }
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 16;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 2;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data2 = 8;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data2 = 2;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data3 = 2;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data3 = 1;
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                data2 = 4;
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                data2 = 16;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data1 = 4;
                break;
            case R.id.air_xts_rear_light /* 2131427563 */:
                data5 = 4;
                break;
        }
        if (event.getAction() == 0) {
            sendCmd(data0, data1, data2, data3, 0, data5);
            return false;
        }
        if (event.getAction() == 1) {
            sendCmd(0, 0, 0, 0, 0, 0);
            return false;
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[10];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp * 5) + 175) * 0.1f) + "°C");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[10];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((temp * 5) + 175) * 0.1f) + "°C");
            }
        }
    }

    
    public void mUpdateRearOn() {
        int acOn = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear_light).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_rear_light_n : R.drawable.ic_xts_rear_light_p);
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[5];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[9];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[14];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[6];
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        }
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[7];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[8];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[14];
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
        int window = DataCanbus.DATA[13];
        int foot = DataCanbus.DATA[12];
        int body = DataCanbus.DATA[11];
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
        findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
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
