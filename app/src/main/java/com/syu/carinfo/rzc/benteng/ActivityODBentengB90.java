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

public class ActivityODBentengB90 extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 11:
                    ActivityODBentengB90.this.updateAirAC(value);
                    break;
                case 12:
                    ActivityODBentengB90.this.updateAirCycle(value);
                    break;
                case 13:
                    ActivityODBentengB90.this.updateAirAuto(value);
                    break;
                case 14:
                    ActivityODBentengB90.this.updateAirRear(value);
                    break;
                case 15:
                    ActivityODBentengB90.this.updateAirFront(value);
                    break;
                case 18:
                    ActivityODBentengB90.this.updateAirWind(value);
                    ActivityODBentengB90.this.updateAirPower(value);
                    break;
                case 19:
                    ActivityODBentengB90.this.updateAirTempLeft(value);
                    break;
                case 20:
                    ActivityODBentengB90.this.updateAirTempRight(value);
                    break;
                case 22:
                    ActivityODBentengB90.this.updateAirBlowMode(value);
                    break;
                case 23:
                    ActivityODBentengB90.this.updateAirDual(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_413_air_od_b90_auto);
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
        ((Button) findViewById(R.id.air_xts_auto)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_munits)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_dual)).setOnTouchListener(this);
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
        switch (v.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                cmd = 3;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                cmd = 2;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                cmd = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                cmd = 9;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                cmd = 10;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                cmd = 21;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                cmd = 25;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                cmd = 19;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                cmd = 23;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                cmd = 5;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                cmd = 4;
                break;
            case R.id.air_xts_mode_munits /* 2131427455 */:
                cmd = 7;
                break;
            case R.id.air_xts_mode_plus /* 2131427456 */:
                cmd = 8;
                break;
            case R.id.air_xts_dual /* 2131427460 */:
                cmd = 16;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                cmd = 20;
                break;
        }
        if (event.getAction() == 0) {
            DataCanbus.PROXY.cmd(1, new int[]{cmd, 1}, null, null);
        } else if (event.getAction() == 1) {
            DataCanbus.PROXY.cmd(1, new int[]{cmd}, null, null);
        }
        return true;
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
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mCanbusNotify, 1);
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
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mCanbusNotify);
    }

    
    public void updateAirDual(int value) {
        if (((Button) findViewById(R.id.air_xts_dual)) != null) {
            ((Button) findViewById(R.id.air_xts_dual)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
        }
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
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(value == 1 ? R.drawable.ic_xts_front_p : R.drawable.ic_xts_front_n);
        }
    }

    
    public void updateAirRear(int value) {
        if (((Button) findViewById(R.id.air_xts_rear)) != null) {
            ((Button) findViewById(R.id.air_xts_rear)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    
    public void updateAirBlowMode(int value) {
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
                return;
            }
            if (value == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HIGH");
            } else if (value == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NONE");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(value / 2.0f) + "℃");
            }
        }
    }

    
    public void updateAirTempRight(int value) {
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (value == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (value == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HIGH");
            } else if (value == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NONE");
            } else {
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
