package com.syu.carinfo.lz.lexusis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class LuzLexusLSRearAirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 35:
                    LuzLexusLSRearAirControlAct.this.mUpdateBlowOn();
                    break;
                case 40:
                    LuzLexusLSRearAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 41:
                    LuzLexusLSRearAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 43:
                    LuzLexusLSRearAirControlAct.this.mUpdateAutoOn();
                    break;
                case 44:
                    LuzLexusLSRearAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 86:
                    LuzLexusLSRearAirControlAct.this.mUpdateManual();
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
        //setContentView(R.layout.layout_0452_lz_lexus_ls_rear_aircontrol);
        init();
    }

    private void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_frontpage).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_manual).setOnTouchListener(this);
        findViewById(R.id.air_xts_blow).setOnTouchListener(this);
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
                data0 = 42;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 41;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 61;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 48;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 49;
                break;
            case R.id.air_xts_frontpage /* 2131427432 */:
                flag = true;
                try {
                    startActivity(new Intent(this, LuzLexusLSFrontAirControlAct.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 52;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 51;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 50;
                break;
            case R.id.air_xts_manual /* 2131427568 */:
                data0 = 59;
                break;
            case R.id.air_xts_blow /* 2131428582 */:
                data0 = 60;
                break;
        }
        if (!flag) {
            if (event.getAction() == 0) {
                sendCmd(data0, 1);
            } else if (event.getAction() == 1) {
                sendCmd(data0, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateBlowOn() {
        int acOn = DataCanbus.DATA[35];
        findViewById(R.id.air_xts_blow).setBackgroundResource(acOn == 0 ? R.drawable.ic_lexus_ls_blow_n : R.drawable.ic_lexus_ls_blow_p);
    }

    
    public void mUpdateManual() {
        int acOn = DataCanbus.DATA[86];
        switch (acOn) {
            case 0:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_0);
                break;
            case 1:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_1);
                break;
            case 2:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_2);
                break;
            case 3:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_3);
                break;
            case 4:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_4);
                break;
            case 5:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_5);
                break;
            case 6:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_6);
                break;
            case 7:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_7);
                break;
        }
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[43];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateAirTempLeft() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[40];
        if (findViewById(R.id.tv_air_temp_left) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(((temp * 5) + 175) * 0.1f + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(((((temp * 5) + 175) * 9) / 50) + 32 + "℉");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[41];
        if (findViewById(R.id.tv_air_temp_right) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(((temp * 5) + 175) * 0.1f + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(((((temp * 5) + 175) * 9) / 50) + 32 + "℉");
            }
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[44];
        if (leave < 0) {
            leave = 0;
        }
        if (leave > 8) {
            leave = 8;
        }
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
        findViewById(R.id.air_xts_power).setBackgroundResource(leave == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }
}
