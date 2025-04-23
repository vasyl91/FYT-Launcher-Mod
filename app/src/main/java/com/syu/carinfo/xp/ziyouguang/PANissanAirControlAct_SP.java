package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class PANissanAirControlAct_SP extends Activity implements View.OnTouchListener {
    public static PANissanAirControlAct_SP mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    PANissanAirControlAct_SP.this.mUpdatePowerOn();
                    PANissanAirControlAct_SP.this.mUpdateAirTempLeft();
                    PANissanAirControlAct_SP.this.mUpdateAirTempRight();
                    break;
                case 11:
                    PANissanAirControlAct_SP.this.mUpdateAcOn();
                    break;
                case 12:
                    PANissanAirControlAct_SP.this.mUpdateCycle();
                    break;
                case 13:
                    PANissanAirControlAct_SP.this.mUpdateAutoOn();
                    break;
                case 14:
                    PANissanAirControlAct_SP.this.mUpdateSyncOn();
                    break;
                case 16:
                    PANissanAirControlAct_SP.this.mUpdateRearDefrost();
                    break;
                case 18:
                case 19:
                case 20:
                    PANissanAirControlAct_SP.this.updateBtnSource();
                    break;
                case 21:
                    PANissanAirControlAct_SP.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    PANissanAirControlAct_SP.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    PANissanAirControlAct_SP.this.mUpdateAirTempRight();
                    break;
                case 37:
                    PANissanAirControlAct_SP.this.mUpdateAirTempLeft();
                    PANissanAirControlAct_SP.this.mUpdateAirTempRight();
                    break;
                case 53:
                    PANissanAirControlAct_SP.this.mUpdateMaxAcOn();
                    break;
                case 65:
                    PANissanAirControlAct_SP.this.mUpdateFrontDefrost();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1, int data2, int data3, int data4) {
        DataCanbus.PROXY.cmd(4, new int[]{data0, data1, data2, data3, data4}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_toyota_air_sp);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_steer_hot).setOnTouchListener(this);
        findViewById(R.id.air_xts_maxac).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_right).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_munits).setVisibility(8);
        findViewById(R.id.air_xts_mode_plus).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        int num = 0;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 2;
                num = 3;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 1;
                num = 3;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 128;
                num = 0;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 1;
                num = 1;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 2;
                num = 1;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 32;
                num = 0;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                if (DataCanbus.DATA[12] == 1) {
                    data0 = 8;
                } else {
                    data0 = 4;
                }
                num = 0;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 16;
                num = 0;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 2;
                num = 0;
                break;
            case R.id.air_xts_maxac /* 2131427440 */:
                data0 = 1;
                num = 0;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 2;
                num = 4;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 1;
                num = 4;
                break;
            case R.id.air_xts_mode_munits /* 2131427497 */:
                data0 = 64;
                num = 0;
                break;
            case R.id.air_xts_mode_plus /* 2131427498 */:
                data0 = 64;
                num = 0;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                data0 = 4;
                num = 1;
                break;
            case R.id.air_xts_dual /* 2131427566 */:
                data0 = 8;
                num = 1;
                break;
        }
        if (data0 != 0) {
            if (event.getAction() == 0) {
                switch (num) {
                    case 0:
                        sendCmd(data0, 0, 0, 0, 0);
                        break;
                    case 1:
                        sendCmd(0, data0, 0, 0, 0);
                        break;
                    case 2:
                        sendCmd(0, 0, data0, 0, 0);
                        break;
                    case 3:
                        sendCmd(0, 0, 0, data0, 0);
                        break;
                    case 4:
                        sendCmd(0, 0, 0, 0, data0);
                        break;
                }
            } else if (event.getAction() == 1) {
                sendCmd(0, 0, 0, 0, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[65];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_air_pa_jeep_front_n : R.drawable.ic_air_pa_jeep_front_p);
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_air_pa_jeep_rear_n : R.drawable.ic_air_pa_jeep_rear_p);
    }

    
    public void mUpdateMaxAcOn() {
        int power = DataCanbus.DATA[53];
        findViewById(R.id.air_xts_maxac).setBackgroundResource(power == 0 ? R.drawable.ic_air_pa_jeep_maxac_n : R.drawable.ic_air_pa_jeep_maxac_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_air_pa_jeep_cyclein_n);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_air_pa_jeep_cyclein_p);
        }
    }

    
    public void mUpdateSyncOn() {
        int acOn = DataCanbus.DATA[14];
        findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_pa_jeep_dual_n : R.drawable.ic_air_pa_jeep_dual_p);
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_pa_jeep_auto_n : R.drawable.ic_air_pa_jeep_auto_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_pa_jeep_ac_n : R.drawable.ic_air_pa_jeep_ac_p);
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_air_pa_jeep_power_n : R.drawable.ic_air_pa_jeep_power_p);
    }

    
    public void mUpdateAirTempLeft() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[27];
        int power = DataCanbus.DATA[10];
        if (power == 0) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText("---");
            return;
        }
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HIGH");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("---");
                return;
            }
            if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp * 5) + 80) * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp + 42) + "℉");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[28];
        int power = DataCanbus.DATA[10];
        if (power == 0) {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText("---");
            return;
        }
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HIGH");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("---");
                return;
            }
            if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((temp * 5) + 80) * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp + 42) + "℉");
            }
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        switch (leave) {
            case 0:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind0);
                break;
            case 1:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind1);
                break;
            case 2:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind2);
                break;
            case 3:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind3);
                break;
            case 4:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind4);
                break;
            case 5:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind5);
                break;
            case 6:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind6);
                break;
            case 7:
                findViewById(R.id.air_pa_jeep_wind_lev).setBackgroundResource(R.drawable.ic_air_pa_jeep_wind7);
                break;
        }
    }

    
    public void updateBtnSource() {
        int body = DataCanbus.DATA[19];
        int window = DataCanbus.DATA[18];
        int foot = DataCanbus.DATA[20];
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
        findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode0);
        switch (mode) {
            case 1:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode1);
                break;
            case 2:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode2);
                break;
            case 3:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode3);
                break;
            case 4:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode4);
                break;
            case 5:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode5);
                break;
            case 6:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode6);
                break;
            case 7:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_air_pa_jeep_mode7);
                break;
        }
    }
}
