package com.syu.carinfo.sbd_electric;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;
import com.syu.util.HandlerUI;

public class Sbd_24vW3AirControlAct extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    Sbd_24vW3AirControlAct.this.mUpdaterAirPower();
                    break;
                case 11:
                    Sbd_24vW3AirControlAct.this.mUpdaterAirAC();
                    break;
                case 12:
                    Sbd_24vW3AirControlAct.this.mUpdateAirCycle();
                    break;
                case 13:
                    Sbd_24vW3AirControlAct.this.mUpdaterAirAuto();
                    break;
                case 21:
                    Sbd_24vW3AirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 22:
                case 23:
                case 24:
                    Sbd_24vW3AirControlAct.this.mUpdateAirBlowwind();
                    break;
                case 27:
                    Sbd_24vW3AirControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 65:
                    Sbd_24vW3AirControlAct.this.mUpdateAirFrontDefrost();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_313_carairset);
        init();
    }

    private void init() {
        findViewById(R.id.air_cycle_inter).setOnClickListener(this);
        findViewById(R.id.air_cycle_outer).setOnClickListener(this);
        findViewById(R.id.air_xts_power).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(this);
        findViewById(R.id.air_xts_front).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnClickListener(this);
        findViewById(R.id.air_xts_front).setOnClickListener(this);
        findViewById(R.id.sbd_313_mode).setOnClickListener(this);
        findViewById(R.id.air_xts_ac).setOnClickListener(this);
        findViewById(R.id.air_xts_auto).setVisibility(0);
        findViewById(R.id.air_xts_auto).setOnClickListener(this);
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

    private void sendCmd(final int cmd) {
        DataCanbus.PROXY.cmd(0, new int[]{cmd, 1}, null, null);
        HandlerUI.getInstance().postDelayed(new Runnable() { 
            @Override
            public void run() {
                DataCanbus.PROXY.cmd(0, new int[]{cmd}, null, null);
            }
        }, 100L);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                sendCmd(9);
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                sendCmd(10);
                break;
            case R.id.air_xts_power /* 2131427428 */:
                sendCmd(16);
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                sendCmd(7);
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                sendCmd(6);
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                sendCmd(8);
                break;
            case R.id.air_xts_front /* 2131427438 */:
                sendCmd(5);
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                sendCmd(1);
                break;
            case R.id.air_cycle_outer /* 2131428106 */:
                sendCmd(4);
                break;
            case R.id.air_cycle_inter /* 2131428107 */:
                sendCmd(3);
                break;
            case R.id.sbd_313_mode /* 2131429243 */:
                sendCmd(11);
                break;
        }
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAirAuto() {
        int value = DataCanbus.DATA[13];
        ImageView view = (ImageView) findViewById(R.id.air_xts_auto);
        view.setImageResource(value == 0 ? R.drawable.ic_sbd_313_auto : R.drawable.ic_sbd_313_auto_p);
    }

    
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp) {
                case 170:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                case 270:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "°C");
                    break;
            }
        }
    }

    
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[21];
        if (level >= 0 && level <= 7 && ((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
        }
    }

    
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[12];
        findViewById(R.id.air_cycle_inter).setBackgroundResource(value == 0 ? R.drawable.ic_313_cycle_in_p : R.drawable.ic_313_cycle_in);
        findViewById(R.id.air_cycle_outer).setBackgroundResource(value == 1 ? R.drawable.ic_313_cycle_out_p : R.drawable.ic_313_cycle_out);
    }

    
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(value == 0 ? R.drawable.ic_313_ac : R.drawable.ic_313_ac_p);
    }

    
    public void mUpdateAirFrontDefrost() {
        int value = DataCanbus.DATA[65];
        findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_313_frontfog : R.drawable.ic_313_frontfog_p);
    }

    
    public void mUpdateAirBlowwind() {
        int value1 = DataCanbus.DATA[22];
        int value2 = DataCanbus.DATA[23];
        int value3 = DataCanbus.DATA[24];
        if (value1 == 1 && value3 == 1) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_sbd_313_upfoot);
            return;
        }
        if (value2 == 1 && value3 == 1) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_sbd_bodyfoot);
            return;
        }
        if (value1 == 1) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_sbd_313_up);
        } else if (value2 == 1) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_sbd_body);
        } else if (value3 == 1) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_sbd_foot);
        }
    }

    
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(value == 0 ? R.drawable.ic_313_power : R.drawable.ic_313_power_p);
    }
}
