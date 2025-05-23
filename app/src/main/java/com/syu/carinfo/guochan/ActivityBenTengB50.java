package com.syu.carinfo.guochan;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityBenTengB50 extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    int touchState = -1;
    int cmd = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 11:
                    ActivityBenTengB50.this.mUpdateAcOn();
                    break;
                case 12:
                    ActivityBenTengB50.this.mUpdateCycle();
                    break;
                case 16:
                    ActivityBenTengB50.this.mUpdateAirRear();
                    break;
                case 18:
                    ActivityBenTengB50.this.updateBtnSource();
                    break;
                case 19:
                    ActivityBenTengB50.this.updateBtnSource();
                    break;
                case 20:
                    ActivityBenTengB50.this.updateBtnSource();
                    break;
                case 21:
                    ActivityBenTengB50.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    ActivityBenTengB50.this.mUpdateAirTempLeft();
                    break;
                case 65:
                    ActivityBenTengB50.this.mUpdateAirFront();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_395_benteng_b50);
        init();
    }

    public void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
        mIsFront = false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        this.touchState = -1;
        if (event.getAction() == 0) {
            this.touchState = 1;
        } else if (event.getAction() == 1) {
            this.touchState = 0;
        }
        switch (v.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_right_plus)).setBackgroundResource(R.drawable.ic_ats_temp_plus_p);
                } else {
                    ((Button) findViewById(R.id.btn_air_temp_right_plus)).setBackgroundResource(R.drawable.ic_ats_temp_plus_n);
                }
                this.cmd = 13;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_right_minus)).setBackgroundResource(R.drawable.ic_ats_temp_munits_p);
                } else {
                    ((Button) findViewById(R.id.btn_air_temp_right_minus)).setBackgroundResource(R.drawable.ic_ats_temp_munits_n);
                }
                this.cmd = 14;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                this.cmd = 12;
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setBackgroundResource(R.drawable.ic_xts_win_munits_p);
                    break;
                } else {
                    ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setBackgroundResource(R.drawable.ic_xts_win_munits_n);
                    break;
                }
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                this.cmd = 11;
                if (event.getAction() == 0) {
                    ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setBackgroundResource(R.drawable.ic_xts_win_plus_p);
                    break;
                } else {
                    ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setBackgroundResource(R.drawable.ic_xts_win_plus_n);
                    break;
                }
            case R.id.air_xts_cycle /* 2131427437 */:
                this.cmd = 7;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                this.cmd = 5;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                this.cmd = 2;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                this.cmd = 28;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                this.cmd = 25;
                break;
            case R.id.air_xts_mode_footbody /* 2131427502 */:
                this.cmd = 26;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                this.cmd = 6;
                break;
            case R.id.air_xts_mode_footwin /* 2131427632 */:
                this.cmd = 27;
                break;
        }
        setAirControl(this.cmd, this.touchState);
        return true;
    }

    private void setAirControl(int cmd, int value) {
        DataCanbus.PROXY.cmd(0, cmd, value);
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
    }

    void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "℃");
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "℃");
            }
        }
    }

    void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    void mUpdateAirRear() {
        int auto = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear).setBackgroundResource(auto == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    void mUpdateAirFront() {
        int value = DataCanbus.DATA[65];
        if (value == 1) {
            findViewById(R.id.air_xts_front).setBackgroundResource(R.drawable.ic_xts_front_p);
        } else {
            findViewById(R.id.air_xts_front).setBackgroundResource(R.drawable.ic_xts_front_n);
        }
    }

    void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        } else if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        }
    }

    void mUpdaterAirWindLevelLeft() {
        int level = DataCanbus.DATA[21];
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null && level > -1 && level < 9) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
        }
        if (level > 0) {
            findViewById(R.id.air_xts_power).setBackgroundResource(R.drawable.ic_xts_power_p);
        } else {
            findViewById(R.id.air_xts_power).setBackgroundResource(R.drawable.ic_xts_power_n);
        }
    }

    
    public void updateBtnSource() {
        int window = DataCanbus.DATA[18];
        int foot = DataCanbus.DATA[20];
        int body = DataCanbus.DATA[19];
        findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        if (window == 0 && body == 1 && foot == 1) {
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
            return;
        }
        if (window == 1 && body == 0 && foot == 1) {
            findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
            return;
        }
        if (window == 0 && body == 1 && foot == 0) {
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
        } else if (window == 0 && body == 0 && foot == 1) {
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
        }
    }
}
