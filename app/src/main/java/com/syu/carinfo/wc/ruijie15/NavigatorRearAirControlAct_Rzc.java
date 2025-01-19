package com.syu.carinfo.wc.ruijie15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0334_RZC_XP1_Focus2015;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;
import com.syu.util.HandlerUI;

public class NavigatorRearAirControlAct_Rzc extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 40:
                    NavigatorRearAirControlAct_Rzc.this.mUpdateAirTempLeft();
                    break;
                case 42:
                    NavigatorRearAirControlAct_Rzc.this.mUpdatePowerOn();
                    break;
                case 44:
                    NavigatorRearAirControlAct_Rzc.this.mUpdaterAirWindLevelLeft();
                    break;
                case 67:
                    NavigatorRearAirControlAct_Rzc.this.mUpdateRearLockOn();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0334_rzc_navigator_air_rear_control);
        init();
    }

    private void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_frontpage).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearlock).setOnTouchListener(this);
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
                data0 = 20;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 19;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 17;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 21;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 22;
                break;
            case R.id.air_xts_frontpage /* 2131427432 */:
                flag = true;
                try {
                    startActivity(new Intent(this, (Class<?>) NavigatorAirControlAct_Rzc.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.air_xts_rearlock /* 2131427446 */:
                data0 = 18;
                break;
        }
        if (!flag && event.getAction() == 0) {
            sendCmd(data0);
            return false;
        }
        return false;
    }

    private void sendCmd(int cmd) {
        Callback_0334_RZC_XP1_Focus2015.jump = false;
        DataCanbus.PROXY.cmd(1, new int[]{172, cmd}, null, null);
        HandlerUI.getInstance().postDelayed(new Runnable() { 
            @Override
            public void run() {
                DataCanbus.PROXY.cmd(1, new int[]{172}, null, null);
            }
        }, 100L);
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateRearLockOn() {
        int power = DataCanbus.DATA[67];
        findViewById(R.id.air_xts_rearlock).setBackgroundResource(power == 0 ? R.drawable.ic_xts_rearlock_n : R.drawable.ic_xts_rearlock_p);
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[40];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(new StringBuilder().append(temp).toString());
        }
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[42];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
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
    }
}
