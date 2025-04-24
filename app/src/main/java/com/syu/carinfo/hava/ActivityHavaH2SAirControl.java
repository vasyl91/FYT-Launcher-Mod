package com.syu.carinfo.hava;

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
public class ActivityHavaH2SAirControl extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    ActivityHavaH2SAirControl.this.mUpdateAutoOn();
                    break;
                case 2:
                    ActivityHavaH2SAirControl.this.mUpdateCycle();
                    break;
                case 3:
                    ActivityHavaH2SAirControl.this.mUpdateAirFront();
                    break;
                case 5:
                    ActivityHavaH2SAirControl.this.mUpdateAcOn();
                    break;
                case 6:
                    ActivityHavaH2SAirControl.this.mUpdateAirTempLeft();
                    break;
                case 7:
                    ActivityHavaH2SAirControl.this.updateBtnSource();
                    break;
                case 8:
                    ActivityHavaH2SAirControl.this.updateBtnSource();
                    break;
                case 9:
                    ActivityHavaH2SAirControl.this.updateBtnSource();
                    break;
                case 10:
                    ActivityHavaH2SAirControl.this.mUpdaterAirWindLevelLeft();
                    break;
                case 13:
                    ActivityHavaH2SAirControl.this.mUpdateAirPower();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_132_havah2s_air_control);
        init();
    }

    public void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
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
        int cmd = 0;
        switch (v.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                if (event.getAction() == 0) {
                    findViewById(R.id.btn_air_temp_left_plus).setBackgroundResource(R.drawable.ic_ats_temp_plus_p);
                } else if (event.getAction() == 1) {
                    findViewById(R.id.btn_air_temp_left_plus).setBackgroundResource(R.drawable.ic_ats_temp_plus_n);
                }
                cmd = 13;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                if (event.getAction() == 0) {
                    findViewById(R.id.btn_air_temp_left_minus).setBackgroundResource(R.drawable.ic_ats_temp_munits_p);
                } else if (event.getAction() == 1) {
                    findViewById(R.id.btn_air_temp_left_minus).setBackgroundResource(R.drawable.ic_ats_temp_munits_n);
                }
                cmd = 14;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                cmd = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                if (event.getAction() == 0) {
                    findViewById(R.id.dj_xts_air_win_minuts_btn).setBackgroundResource(R.drawable.ic_xts_win_munits_p);
                } else if (event.getAction() == 1) {
                    findViewById(R.id.dj_xts_air_win_minuts_btn).setBackgroundResource(R.drawable.ic_xts_win_munits_n);
                }
                cmd = 12;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                if (event.getAction() == 0) {
                    findViewById(R.id.dj_xts_air_win_plus_btn).setBackgroundResource(R.drawable.ic_xts_win_plus_p);
                } else if (event.getAction() == 1) {
                    findViewById(R.id.dj_xts_air_win_plus_btn).setBackgroundResource(R.drawable.ic_xts_win_plus_n);
                }
                cmd = 11;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                cmd = 4;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                cmd = 7;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                cmd = 5;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                cmd = 2;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                cmd = 29;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                cmd = 26;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                if (event.getAction() == 0) {
                    findViewById(R.id.btn_air_temp_right_plus).setBackgroundResource(R.drawable.ic_ats_temp_plus_p);
                } else if (event.getAction() == 1) {
                    findViewById(R.id.btn_air_temp_right_plus).setBackgroundResource(R.drawable.ic_ats_temp_plus_n);
                }
                cmd = 13;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                if (event.getAction() == 0) {
                    findViewById(R.id.btn_air_temp_right_minus).setBackgroundResource(R.drawable.ic_ats_temp_munits_p);
                } else if (event.getAction() == 1) {
                    findViewById(R.id.btn_air_temp_right_minus).setBackgroundResource(R.drawable.ic_ats_temp_munits_n);
                }
                cmd = 14;
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                cmd = 27;
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                cmd = 28;
                break;
        }
        if (cmd != 0) {
            if (event.getAction() == 0) {
                setAirControl(cmd, 1);
            } else if (event.getAction() == 1) {
                setAirControl(cmd, 0);
            }
        }
        return true;
    }

    private void setAirControl(int cmd, int value) {
        DataCanbus.PROXY.cmd(0, cmd, value);
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
    }

    void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[6];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(new StringBuilder(String.valueOf(temp)).toString());
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(new StringBuilder(String.valueOf(temp)).toString());
            }
        }
    }

    void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[1];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[5];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    void mUpdateAirPower() {
        int auto = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_power).setBackgroundResource(auto == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    void mUpdateAirFront() {
        int value = DataCanbus.DATA[3];
        if (value == 1) {
            findViewById(R.id.air_xts_front).setBackgroundResource(R.drawable.ic_xts_front_p);
        } else {
            findViewById(R.id.air_xts_front).setBackgroundResource(R.drawable.ic_xts_front_n);
        }
    }

    void mUpdateCycle() {
        int cycle = DataCanbus.DATA[2];
        if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        } else if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        }
    }

    void mUpdaterAirWindLevelLeft() {
        int level = DataCanbus.DATA[10];
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null && level > -1 && level < 9) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder(String.valueOf(level)).toString());
        }
    }

    
    public void updateBtnSource() {
        int window = DataCanbus.DATA[9];
        int foot = DataCanbus.DATA[8];
        int body = DataCanbus.DATA[7];
        findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        if (body == 1 && foot != 1 && window != 1) {
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
        }
        if (body == 1 && foot == 1 && window != 1) {
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
        }
        if (foot == 1 && body != 1 && window != 1) {
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
        }
        if (window == 1 && body != 1 && foot == 1) {
            findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
        }
    }
}
