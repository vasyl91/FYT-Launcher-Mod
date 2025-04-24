package com.syu.carinfo.accord;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityAccord7AirControl extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    int tempunit = 0;
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 11:
                    ActivityAccord7AirControl.this.updateAirAuto(value);
                    break;
                case 12:
                    ActivityAccord7AirControl.this.updateAirCycle(value);
                    break;
                case 13:
                    ActivityAccord7AirControl.this.updateAirFront(value);
                    break;
                case 14:
                    ActivityAccord7AirControl.this.updateAirRear(value);
                    break;
                case 15:
                    ActivityAccord7AirControl.this.updateAirAC(value);
                    break;
                case 20:
                    ActivityAccord7AirControl.this.updateAirBlowMode(value);
                    break;
                case 21:
                    ActivityAccord7AirControl.this.updateAirWind(value);
                    break;
                case 22:
                    ActivityAccord7AirControl.this.updateAirTempLeft(value);
                    break;
                case 23:
                    ActivityAccord7AirControl.this.updateAirTempRight(value);
                    break;
                case 25:
                    ActivityAccord7AirControl.this.updateAirDual(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ////setContentView(R.layout.layout_274_accord7_air_control);
        setListener();
    }

    private void setListener() {
        ((Button) findViewById(R.id.btn_air_temp_left_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_front)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_rear)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_cycle_outer)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_cycle_inter)).setOnTouchListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_power)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_dual)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_ac)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_auto)).setOnTouchListener(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int cmdId = -1;
        switch (v.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                cmdId = 12;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                cmdId = 13;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                cmdId = 9;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                cmdId = 7;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                cmdId = 6;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
                cmdId = 11;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                cmdId = 1;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                cmdId = 35;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                cmdId = 8;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                cmdId = 14;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                cmdId = 15;
                break;
            case R.id.air_xts_dual /* 2131427460 */:
                cmdId = 2;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                cmdId = 5;
                break;
            case R.id.air_cycle_outer /* 2131427557 */:
                if (DataCanbus.DATA[12] == 1) {
                    cmdId = 3;
                    break;
                }
            case R.id.air_cycle_inter /* 2131427558 */:
                if (DataCanbus.DATA[12] == 0) {
                    cmdId = 3;
                    break;
                }
        }
        if (cmdId != -1) {
            switch (event.getAction()) {
                case 0:
                    setAirControl(cmdId, 1);
                    break;
                case 1:
                    setAirControl(cmdId, 0);
                    break;
            }
        }
        return false;
    }

    private void setAirControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(0, cmdId, touchState);
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

    private void addNotify() {
        this.tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mCanbusNotify);
    }

    protected void updateAirRear(int value) {
        if (((Button) findViewById(R.id.air_xts_rear)) != null) {
            ((Button) findViewById(R.id.air_xts_rear)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    protected void updateAirDual(int value) {
        if (((Button) findViewById(R.id.air_xts_dual)) != null) {
            ((Button) findViewById(R.id.air_xts_dual)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
        }
    }

    protected void updateAirFront(int value) {
        if (((Button) findViewById(R.id.air_xts_front)) != null) {
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    protected void updateAirBlowMode(int value) {
        if (((Button) findViewById(R.id.air_xts_mode)) != null) {
            switch (value) {
                case 1:
                    ((Button) findViewById(R.id.air_xts_mode)).setBackgroundResource(R.drawable.ic_xts_mode_body);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_mode)).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
                    break;
                case 3:
                    ((Button) findViewById(R.id.air_xts_mode)).setBackgroundResource(R.drawable.ic_xts_mode_foot);
                    break;
                case 4:
                    ((Button) findViewById(R.id.air_xts_mode)).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
                    break;
                case 5:
                    ((Button) findViewById(R.id.air_xts_mode)).setBackgroundResource(R.drawable.ic_xts_mode_win);
                    break;
                default:
                    ((Button) findViewById(R.id.air_xts_mode)).setBackgroundResource(R.drawable.ic_xts_mode_null);
                    break;
            }
        }
    }

    protected void updateAirWind(int value) {
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(value).toString());
        }
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    protected void updateAirTempRight(int value) {
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (value == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (value == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else if (this.tempunit == 1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(((value * 9) / 5) + 32) + "℉");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(value) + "℃");
            }
        }
    }

    protected void updateAirTempLeft(int value) {
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (value == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (value == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else if (this.tempunit == 1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(((value * 9) / 5) + 32) + "℉");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(value) + "℃");
            }
        }
    }

    protected void updateAirCycle(int value) {
        if (((Button) findViewById(R.id.air_cycle_outer)) != null) {
            ((Button) findViewById(R.id.air_cycle_outer)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_out_p : R.drawable.ic_xts_cycle_n);
        }
        if (((Button) findViewById(R.id.air_cycle_inter)) != null) {
            ((Button) findViewById(R.id.air_cycle_inter)).setBackgroundResource(value == 1 ? R.drawable.ic_cycle_all_p : R.drawable.ic_cycle_all_n);
        }
    }

    protected void updateAirAC(int value) {
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            switch (value) {
                case 2:
                case 3:
                    ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(R.drawable.ic_xts_ac_p);
                    break;
                default:
                    ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(R.drawable.ic_xts_ac_n);
                    break;
            }
        }
    }

    protected void updateAirAuto(int value) {
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }
}
