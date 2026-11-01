package com.syu.carinfo.dj.b70;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class DjB70AirControlAct extends Activity implements View.OnClickListener {
    public static DjB70AirControlAct mInstance;
    public static boolean mIsFront = false;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    DjB70AirControlAct.this.mUpdateCycle();
                    break;
                case 1:
                    DjB70AirControlAct.this.mUpdateAirRearDefrost();
                    break;
                case 2:
                case 3:
                case 4:
                    DjB70AirControlAct.this.updateBtnSource();
                    break;
                case 5:
                    DjB70AirControlAct.this.mUpdateAirAutoOn();
                    break;
                case 6:
                    DjB70AirControlAct.this.mUpdateAcOn();
                    break;
                case 7:
                    DjB70AirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 8:
                    DjB70AirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 9:
                    DjB70AirControlAct.this.mUpdateAirTempRight();
                    break;
                case 10:
                    DjB70AirControlAct.this.mUpdateAirPower();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ////setContentView(R.layout.layout_djb70_control_set);
        mInstance = this;
        init();
    }

    private void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnClickListener(this);
        findViewById(R.id.air_xts_power).setOnClickListener(this);
        findViewById(R.id.air_xts_rear).setOnClickListener(this);
        findViewById(R.id.air_xts_cycle).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnClickListener(this);
        findViewById(R.id.air_xts_ac).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_body).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_win).setOnClickListener(this);
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

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                DataCanbus.PROXY.cmd(0, new int[]{18, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{18}, null, null);
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                DataCanbus.PROXY.cmd(0, new int[]{19, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{19}, null, null);
                break;
            case R.id.air_xts_power /* 2131427428 */:
                DataCanbus.PROXY.cmd(0, new int[]{20, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{20}, null, null);
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                DataCanbus.PROXY.cmd(0, new int[]{17, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{17}, null, null);
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                DataCanbus.PROXY.cmd(0, new int[]{16, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{16}, null, null);
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                DataCanbus.PROXY.cmd(0, new int[]{2, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{2}, null, null);
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                int cycle = DataCanbus.DATA[0];
                if (cycle == 1) {
                    DataCanbus.PROXY.cmd(0, new int[]{3, 1}, null, null);
                    DataCanbus.PROXY.cmd(0, new int[]{3}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(0, new int[]{4, 1}, null, null);
                    DataCanbus.PROXY.cmd(0, new int[]{4}, null, null);
                    break;
                }
            case R.id.air_xts_ac /* 2131427439 */:
                DataCanbus.PROXY.cmd(0, new int[]{1, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                DataCanbus.PROXY.cmd(0, new int[]{8, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{8}, null, null);
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                DataCanbus.PROXY.cmd(0, new int[]{10, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{10}, null, null);
                break;
            case R.id.air_xts_mode_win /* 2131427445 */:
                DataCanbus.PROXY.cmd(0, new int[]{5, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{5}, null, null);
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                DataCanbus.PROXY.cmd(0, new int[]{21, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{21}, null, null);
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                DataCanbus.PROXY.cmd(0, new int[]{22, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{22}, null, null);
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                DataCanbus.PROXY.cmd(0, new int[]{11, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{11}, null, null);
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                DataCanbus.PROXY.cmd(0, new int[]{9, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{9}, null, null);
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                DataCanbus.PROXY.cmd(0, new int[]{23, 1}, null, null);
                DataCanbus.PROXY.cmd(0, new int[]{23}, null, null);
                break;
        }
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateAirRearDefrost() {
        int acOn = DataCanbus.DATA[1];
        findViewById(R.id.air_xts_rear).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    
    public void mUpdateAirPower() {
        int acOn = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[8];
        if (findViewById(R.id.tv_air_temp_left) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NONE");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 2.0f) + "℃");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[9];
        if (findViewById(R.id.tv_air_temp_right) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NONE");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 2.0f) + "℃");
            }
        }
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[6];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    
    public void mUpdateAirAutoOn() {
        int auto = DataCanbus.DATA[5];
        findViewById(R.id.air_xts_auto).setBackgroundResource(auto == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[0];
        if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        } else if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int level = DataCanbus.DATA[7];
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(String.valueOf(level));
    }

    
    public void updateBtnSource() {
        int window = DataCanbus.DATA[2];
        int foot = DataCanbus.DATA[3];
        int body = DataCanbus.DATA[4];
        if (window == 0 && body == 1 && foot == 1) {
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
        } else {
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        }
        if (window == 0 && body == 0 && foot == 1) {
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
        } else {
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        }
        if (window == 0 && body == 1 && foot == 0) {
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
        } else {
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        }
        if (window == 1 && body == 0 && foot == 1) {
            findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
        } else {
            findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        }
        if (window == 1 && body == 0 && foot == 0) {
            findViewById(R.id.air_xts_mode_win).setBackgroundResource(R.drawable.ic_xts_mode_win_p);
        } else {
            findViewById(R.id.air_xts_mode_win).setBackgroundResource(R.drawable.ic_xts_mode_win_n);
        }
    }
}
