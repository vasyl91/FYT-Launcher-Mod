package com.syu.carinfo.wc2.ford;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class WC2FordLincoinRearAirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 4:
                    WC2FordLincoinRearAirControlAct.this.mUpdateMaxAcOn();
                    break;
                case 6:
                    WC2FordLincoinRearAirControlAct.this.mUpdatePowerOn();
                    break;
                case 8:
                    WC2FordLincoinRearAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 10:
                    WC2FordLincoinRearAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 26:
                    WC2FordLincoinRearAirControlAct.this.mUpdateFrontHotOn();
                    break;
                case 27:
                    WC2FordLincoinRearAirControlAct.this.mUpdateSteerHotOn();
                    break;
                case 28:
                    WC2FordLincoinRearAirControlAct.this.mUpdateRearLockOn();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String platform = SystemProperties.get("ro.fyt.platform", "");
        if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform)) {
            if (LauncherApplication.getConfiguration() == 1) {
                //setContentView(R.layout.layout_0443_wc_18ruijie_air_rear_control_9853);
            } else {
                //setContentView(R.layout.layout_0443_wc_18ruijie_air_rear_control);
            }
        } else {
            //setContentView(R.layout.layout_0443_wc_18ruijie_air_rear_control);
        }
        init();
    }

    private void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_frontpage).setOnTouchListener(this);
        findViewById(R.id.air_xts_maxac).setOnTouchListener(this);
        findViewById(R.id.air_xts_front_hot).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearlock).setOnTouchListener(this);
        findViewById(R.id.air_xts_steer_hot).setOnTouchListener(this);
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
                data0 = 32;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 33;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 46;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 43;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 42;
                break;
            case R.id.air_xts_frontpage /* 2131427432 */:
                flag = true;
                try {
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
                        case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
                            startActivity(new Intent(this, (Class<?>) WC2FordEdgeAirControlAct.class));
                            break;
                        default:
                            startActivity(new Intent(this, (Class<?>) WC2FordLincoinAirControlAct.class));
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.air_xts_maxac /* 2131427440 */:
                data0 = 26;
                break;
            case R.id.air_xts_rearlock /* 2131427446 */:
                data0 = 34;
                break;
            case R.id.air_xts_steer_hot /* 2131427453 */:
                data0 = 45;
                break;
            case R.id.air_xts_front_hot /* 2131427466 */:
                data0 = 44;
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

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(1, new int[]{data0, data1}, null, null);
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateRearLockOn() {
        int power = DataCanbus.DATA[28];
        findViewById(R.id.air_xts_rearlock).setBackgroundResource(power == 0 ? R.drawable.ic_xts_rearlock_n : R.drawable.ic_xts_rearlock_p);
    }

    
    public void mUpdateSteerHotOn() {
        int power = DataCanbus.DATA[27];
        findViewById(R.id.air_xts_steer_hot).setBackgroundResource(power == 0 ? R.drawable.ic_xts_steer_hot_n : R.drawable.ic_xts_steer_hot_p);
    }

    
    public void mUpdateFrontHotOn() {
        int power = DataCanbus.DATA[26];
        findViewById(R.id.air_xts_front_hot).setBackgroundResource(power == 0 ? R.drawable.ic_xts_fronthot_n : R.drawable.ic_xts_fronthot_p);
    }

    
    public void mUpdateMaxAcOn() {
        int power = DataCanbus.DATA[4];
        findViewById(R.id.air_xts_maxac).setBackgroundResource(power == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[8];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(new StringBuilder().append(temp).toString());
        }
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[6];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[10];
        if (leave < 0) {
            leave = 0;
        }
        if (leave > 8) {
            leave = 8;
        }
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }
}
