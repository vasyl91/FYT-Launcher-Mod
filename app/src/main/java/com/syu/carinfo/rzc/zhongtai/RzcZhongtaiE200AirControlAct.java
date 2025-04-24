package com.syu.carinfo.rzc.zhongtai;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class RzcZhongtaiE200AirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 7:
                    RzcZhongtaiE200AirControlAct.this.mUpdatePowerOn();
                    break;
                case 8:
                    RzcZhongtaiE200AirControlAct.this.mUpdateAcOn();
                    break;
                case 9:
                    RzcZhongtaiE200AirControlAct.this.mUpdateCycle();
                    break;
                case 14:
                    RzcZhongtaiE200AirControlAct.this.mUpdateRearDefrost();
                    break;
                case 15:
                case 16:
                case 17:
                    RzcZhongtaiE200AirControlAct.this.updateBtnSource();
                    break;
                case 18:
                    RzcZhongtaiE200AirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 20:
                    RzcZhongtaiE200AirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 21:
                    RzcZhongtaiE200AirControlAct.this.mUpdateAirTempRight();
                    break;
                case 22:
                    RzcZhongtaiE200AirControlAct.this.mUpdateFrontDefrost();
                    break;
                case 103:
                    RzcZhongtaiE200AirControlAct.this.mUpdateHeatOn();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1, int data2, int data3, int data4, int data5) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1, data2, data3, data4, data5}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_rzc_zhongtai_e200_air_control);
        init();
    }

    private void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_heat).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_plus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_cycle_outer).setOnTouchListener(this);
        findViewById(R.id.air_cycle_inter).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
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
        int data3 = 0;
        int data4 = 0;
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
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 16;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 2;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data4 = 2;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data4 = 1;
                break;
            case R.id.air_xts_mode_plus /* 2131427456 */:
                data0 = 64;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data1 = 4;
                break;
            case R.id.air_cycle_outer /* 2131427557 */:
                data0 = 8;
                break;
            case R.id.air_cycle_inter /* 2131427558 */:
                data0 = 4;
                break;
            case R.id.air_xts_heat /* 2131427614 */:
                data5 = 4;
                break;
        }
        if (event.getAction() == 0) {
            sendCmd(data0, data1, 0, data3, data4, data5);
            return false;
        }
        if (event.getAction() == 1) {
            sendCmd(0, 0, 0, 0, 0, 0);
            return false;
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[20];
        if (DataCanbus.DATA[1000] == 852420) {
            if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("None");
            }
        } else if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else {
                int value1 = (temp * 5) + 175;
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((value1 / 10.0f) + "°C");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[21];
        if (DataCanbus.DATA[1000] == 852420) {
            if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("None");
            }
        } else if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else {
                int value1 = (temp * 5) + 175;
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((value1 / 10.0f) + "°C");
            }
        }
    }

    
    public void mUpdateHeatOn() {
        int acOn = DataCanbus.DATA[103];
        findViewById(R.id.air_xts_heat).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_heat_n : R.drawable.ic_xts_heat_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[8];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[7];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[9];
        if (cycle == 0) {
            findViewById(R.id.air_cycle_outer).setBackgroundResource(R.drawable.ic_xts_cycle_out_p);
            findViewById(R.id.air_cycle_inter).setBackgroundResource(R.drawable.ic_cycle_all_n);
        } else if (cycle == 1) {
            findViewById(R.id.air_cycle_outer).setBackgroundResource(R.drawable.ic_xts_cycle_n);
            findViewById(R.id.air_cycle_inter).setBackgroundResource(R.drawable.ic_cycle_all_p);
        }
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[22];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[14];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[18];
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
        int window = DataCanbus.DATA[15];
        int foot = DataCanbus.DATA[17];
        int body = DataCanbus.DATA[16];
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
