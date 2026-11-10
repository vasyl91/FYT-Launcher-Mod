package com.syu.carinfo.rzc.benteng;

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
public class ActivityRzcBenteng19B50 extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 11:
                    ActivityRzcBenteng19B50.this.updateAirAC(value);
                    break;
                case 12:
                    ActivityRzcBenteng19B50.this.updateAirCycle(value);
                    break;
                case 13:
                    ActivityRzcBenteng19B50.this.updateAirAuto(value);
                    break;
                case 14:
                    ActivityRzcBenteng19B50.this.updateAirRear(value);
                    break;
                case 18:
                    ActivityRzcBenteng19B50.this.updateAirWind(value);
                    ActivityRzcBenteng19B50.this.updateAirPower(value);
                    break;
                case 19:
                    ActivityRzcBenteng19B50.this.updateAirTempLeft(value);
                    break;
                case 22:
                    ActivityRzcBenteng19B50.this.updateAirBlowMode(value);
                    ActivityRzcBenteng19B50.this.updateAirFront(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 655773) {
            //setContentView(R.layout.layout_413_air_19b50_hand);
        } else {
            //setContentView(R.layout.layout_413_air_19b50_auto);
        }
        setListener();
    }

    private void setListener() {
        ((Button) findViewById(R.id.air_xts_power)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_cycle)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_front)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_rear)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_ac)).setOnTouchListener(this);
        if (DataCanbus.DATA[1000] != 655773) {
            ((Button) findViewById(R.id.air_xts_auto)).setOnTouchListener(this);
            ((Button) findViewById(R.id.air_xts_mode)).setOnTouchListener(this);
        } else {
            ((Button) findViewById(R.id.air_xts_mode_body)).setOnTouchListener(this);
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setOnTouchListener(this);
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setOnTouchListener(this);
            ((Button) findViewById(R.id.air_xts_mode_foot)).setOnTouchListener(this);
        }
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
        removeNotify();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int cmd = 0;
        int touchState = -1;
        if (event.getAction() == 0) {
            touchState = 1;
        } else if (event.getAction() == 1) {
            touchState = 0;
        }
        switch (v.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                if (touchState == 1) {
                    ((Button) findViewById(R.id.btn_air_temp_left_plus)).setBackgroundResource(R.drawable.ic_ats_temp_plus_p);
                } else if (touchState == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_left_plus)).setBackgroundResource(R.drawable.ic_ats_temp_plus_n);
                }
                cmd = 13;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                if (touchState == 1) {
                    ((Button) findViewById(R.id.btn_air_temp_left_minus)).setBackgroundResource(R.drawable.ic_ats_temp_munits_p);
                } else if (touchState == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_left_minus)).setBackgroundResource(R.drawable.ic_ats_temp_munits_n);
                }
                cmd = 14;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                cmd = 0;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                if (touchState == 1) {
                    ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setBackgroundResource(R.drawable.ic_xts_win_munits_p);
                } else if (touchState == 0) {
                    ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setBackgroundResource(R.drawable.ic_xts_win_munits_n);
                }
                cmd = 12;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                if (touchState == 1) {
                    ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setBackgroundResource(R.drawable.ic_xts_win_plus_p);
                } else if (touchState == 0) {
                    ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setBackgroundResource(R.drawable.ic_xts_win_plus_n);
                }
                cmd = 11;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
                cmd = 17;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                cmd = 2;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                cmd = 21;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                cmd = 6;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                cmd = 1;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                cmd = 9;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                cmd = 7;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                if (touchState == 1) {
                    ((Button) findViewById(R.id.btn_air_temp_right_plus)).setBackgroundResource(R.drawable.ic_ats_temp_plus_p);
                } else if (touchState == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_right_plus)).setBackgroundResource(R.drawable.ic_ats_temp_plus_n);
                }
                cmd = 13;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                if (touchState == 1) {
                    ((Button) findViewById(R.id.btn_air_temp_right_minus)).setBackgroundResource(R.drawable.ic_ats_temp_munits_p);
                } else if (touchState == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_right_minus)).setBackgroundResource(R.drawable.ic_ats_temp_munits_n);
                }
                cmd = 14;
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                cmd = 8;
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                cmd = 10;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                cmd = 23;
                break;
        }
        setAirControl(cmd, touchState);
        return true;
    }

    private void setAirControl(int cmd, int value) {
        DataCanbus.PROXY.cmd(0, cmd, value);
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mCanbusNotify);
    }

    
    public void updateAirPower(int value) {
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    
    public void updateAirAC(int value) {
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    
    public void updateAirAuto(int value) {
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }

    
    public void updateAirFront(int value) {
        if (((Button) findViewById(R.id.air_xts_front)) != null) {
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(value == 5 ? R.drawable.ic_xts_front_p : R.drawable.ic_xts_front_n);
        }
    }

    
    public void updateAirRear(int value) {
        if (((Button) findViewById(R.id.air_xts_rear)) != null) {
            ((Button) findViewById(R.id.air_xts_rear)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    
    public void updateAirBlowMode(int value) {
        if (DataCanbus.DATA[1000] == 655773) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
            ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
            switch (value) {
                case 1:
                    ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_mode_footbody)).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
                    break;
                case 3:
                    ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
                    break;
                case 4:
                    ((Button) findViewById(R.id.air_xts_mode_footwin)).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
                    break;
            }
            return;
        }
        if (value == 3) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot);
            return;
        }
        if (value == 4) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
            return;
        }
        if (value == 1) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body);
            return;
        }
        if (value == 2) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
        } else if (value == 5) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_win);
        } else {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
        }
    }

    
    public void updateAirTempLeft(int value) {
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (value == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            } else if (value == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HIGH");
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HIGH");
            } else if (value == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NONE");
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NONE");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(value / 2.0f) + "℃");
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(value / 2.0f) + "℃");
            }
        }
    }

    
    public void updateAirWind(int value) {
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void updateAirCycle(int value) {
        if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_cycle)).setBackgroundResource(R.drawable.ic_xts_cycle_n);
            } else {
                ((Button) findViewById(R.id.air_xts_cycle)).setBackgroundResource(R.drawable.ic_xts_cycle_p);
            }
        }
    }
}
