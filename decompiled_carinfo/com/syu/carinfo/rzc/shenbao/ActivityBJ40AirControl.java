package com.syu.carinfo.rzc.shenbao;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityBJ40AirControl extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 12:
                    ActivityBJ40AirControl.this.updateAC(value);
                    break;
                case 13:
                    ActivityBJ40AirControl.this.updateCycle(value);
                    break;
                case 15:
                case 16:
                case 17:
                    ActivityBJ40AirControl.this.mUpdataWindType();
                    break;
                case 18:
                    ActivityBJ40AirControl.this.updateFront(value);
                    break;
                case 19:
                    ActivityBJ40AirControl.this.updateRear(value);
                    break;
                case 20:
                    ActivityBJ40AirControl.this.updateWindLevel(value);
                    break;
                case 21:
                    ActivityBJ40AirControl.this.updateTempLeft(value);
                    break;
                case 22:
                    ActivityBJ40AirControl.this.updateAuto(value);
                    break;
                case 23:
                    ActivityBJ40AirControl.this.updateDual(value);
                    break;
                case 25:
                    ActivityBJ40AirControl.this.updateTempRight(value);
                    break;
            }
        }
    };
    public static boolean mIsFront = false;
    public static ActivityBJ40AirControl mInstance = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInstance = this;
        //setContentView(R.layout.layout_0396_bj40_air_control);
        initUi();
    }

    private void initUi() {
        ((Button) findViewById(R.id.btn_air_temp_left_minus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_plus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_minus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_plus)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_mode_footwin)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_mode_footbody)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_mode_body)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_mode_foot)).setOnClickListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_cycle)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_rear)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_front)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_ac)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_power)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_auto)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_dual)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                setCmd(13);
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                setCmd(14);
                break;
            case R.id.air_xts_power /* 2131427428 */:
                setCmd(0);
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                setCmd(12);
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                setCmd(11);
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                setCmd(2);
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                setCmd(4);
                break;
            case R.id.air_xts_front /* 2131427438 */:
                setCmd(6);
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                setCmd(1);
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                setCmd(9);
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                setCmd(7);
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                setCmd(15);
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                setCmd(16);
                break;
            case R.id.air_xts_dual /* 2131427460 */:
                setCmd(3);
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                setCmd(8);
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                setCmd(10);
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                setCmd(18);
                break;
        }
    }

    private void setCmd(int cmd) {
        DataCanbus.PROXY.cmd(0, cmd, 1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateDual(int value) {
        if (value == 0) {
            ((Button) findViewById(R.id.air_xts_dual)).setBackgroundResource(R.drawable.ic_xts_dual_n);
        } else {
            ((Button) findViewById(R.id.air_xts_dual)).setBackgroundResource(R.drawable.ic_xts_dual_p);
        }
    }

    
    public void updateAuto(int value) {
        if (value == 0) {
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(R.drawable.ic_xts_auto_n);
        } else {
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(R.drawable.ic_xts_auto_p);
        }
    }

    
    public void updateRear(int value) {
        if (value == 0) {
            ((Button) findViewById(R.id.air_xts_rear)).setBackgroundResource(R.drawable.ic_xts_rear_n);
        } else {
            ((Button) findViewById(R.id.air_xts_rear)).setBackgroundResource(R.drawable.ic_xts_rear_p);
        }
    }

    
    public void updateFront(int value) {
        if (value == 0) {
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(R.drawable.ic_xts_front_n);
        } else {
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(R.drawable.ic_xts_front_p);
        }
    }

    
    public void updateCycle(int value) {
        if (value == 0) {
            ((Button) findViewById(R.id.air_xts_cycle)).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else {
            ((Button) findViewById(R.id.air_xts_cycle)).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        }
    }

    
    public void updateWindLevel(int value) {
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(value).toString());
    }

    
    public void mUpdataWindType() {
        int wind = DataCanbus.DATA[15];
        int body = DataCanbus.DATA[16];
        int foot = DataCanbus.DATA[17];
        int mHeadFoot = 0;
        int mWindowFoot = 0;
        int mHead = 0;
        int mFoot = 0;
        if (wind == 0 && body != 0 && foot != 0) {
            mHeadFoot = 1;
        } else if (wind != 0 && body == 0 && foot != 0) {
            mWindowFoot = 1;
        } else if (wind == 0 && body != 0 && foot == 0) {
            mHead = 1;
        } else if (wind == 0 && body == 0 && foot != 0) {
            mFoot = 1;
        }
        if (((Button) findViewById(R.id.air_xts_mode_body)) != null && ((Button) findViewById(R.id.air_xts_mode_footwin)) != null && ((Button) findViewById(R.id.air_xts_mode_foot)) != null && ((Button) findViewById(R.id.air_xts_mode_footbody)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(mHead == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setBackgroundResource(mHeadFoot == 0 ? R.drawable.ic_xts_mode_footbody_n : R.drawable.ic_xts_mode_footbody_p);
            ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(mFoot == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setBackgroundResource(mWindowFoot == 0 ? R.drawable.ic_xts_mode_footwin_n : R.drawable.ic_xts_mode_footwin_p);
        }
    }

    
    public void updateAC(int value) {
        if (value == 0) {
            ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(R.drawable.ic_xts_ac_n);
        } else {
            ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(R.drawable.ic_xts_ac_p);
        }
    }

    
    public void updateTempLeft(int temp) {
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("None");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp * 5) + 155) * 0.1f) + "°C");
            }
        }
    }

    
    public void updateTempRight(int temp) {
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("None");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((temp * 5) + 155) * 0.1f) + "°C");
            }
        }
    }

    private void updatePower(int value) {
        if (value == 0) {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(R.drawable.ic_xts_power_n);
        } else {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(R.drawable.ic_xts_power_p);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mInstance = null;
    }
}
