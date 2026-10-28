package com.syu.carinfo.wc.crown;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class wc_420_lexus_RearAirControlAct extends Activity implements View.OnClickListener {
    public static wc_420_lexus_RearAirControlAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 40:
                    wc_420_lexus_RearAirControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 41:
                    wc_420_lexus_RearAirControlAct.this.mUpdaterAirTempRight();
                    break;
                case 44:
                    wc_420_lexus_RearAirControlAct.this.mUpdaterAirWindLevel();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0420_wc_lexus_ls460_rear_carairset);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_power).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                DataCanbus.PROXY.cmd(0, 19);
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                DataCanbus.PROXY.cmd(0, 20);
                break;
            case R.id.air_xts_power /* 2131427428 */:
                DataCanbus.PROXY.cmd(0, 25);
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                DataCanbus.PROXY.cmd(0, 24);
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                DataCanbus.PROXY.cmd(0, 23);
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                DataCanbus.PROXY.cmd(0, 21);
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                DataCanbus.PROXY.cmd(0, 22);
                break;
        }
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[40];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("--");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 2.0f) + "℃");
                    break;
            }
        }
    }

    
    public void mUpdaterAirTempRight() {
        int temp = DataCanbus.DATA[41];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("--");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 2.0f) + "℃");
                    break;
            }
        }
    }

    
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[44];
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
        findViewById(R.id.air_xts_power).setBackgroundResource(level == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }
}
